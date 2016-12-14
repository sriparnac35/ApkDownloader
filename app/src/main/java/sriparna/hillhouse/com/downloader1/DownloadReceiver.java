package sriparna.hillhouse.com.downloader1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sriparna on 12/12/16.
 */

public class DownloadReceiver extends BroadcastReceiver {
    private Uri uri = null;

    public void setURL(String uri){
        this.uri = Uri.parse("file://" + uri);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "apk download complete", Toast.LENGTH_SHORT).show();
        Intent viewIntent = new Intent();
        viewIntent.setAction(Intent.ACTION_VIEW);
        viewIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        viewIntent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(viewIntent);
    }

}
