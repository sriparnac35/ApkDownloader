package sriparna.hillhouse.com.downloader1;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar = null;
    private Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "apk download complete", Toast.LENGTH_SHORT).show();
                Intent viewIntent = new Intent();
                viewIntent.setAction(Intent.ACTION_VIEW);
                viewIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                viewIntent.setDataAndType(uri, "application/vnd.android.package-archive");
                context.startActivity(viewIntent);
                progressBar.setVisibility(View.GONE);


            }
        }, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadApp();
            }
        });

        InputStream inputStream = getResources().openRawResource(R.raw.url);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String url = bufferedReader.readLine();
            Toast.makeText(this, "url is : "+ url , Toast.LENGTH_SHORT).show();
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadApp(){
        progressBar.setVisibility(View.VISIBLE);
        final DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        Uri downloadURI = Uri.parse(Constants.APK_DOWNLOAD_URL);
        DownloadManager.Request request = new DownloadManager.Request(downloadURI);
        request.setVisibleInDownloadsUi(false);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);


        File file = new File(Constants.APK_DOWNLOAD_DESTINATION);
        if (file.exists()){
            file.delete();
        }

        this.uri = Uri.parse("file://" + Constants.APK_DOWNLOAD_DESTINATION);

        request.setDestinationUri(uri);
        downloadManager.enqueue(request);
    }

}
