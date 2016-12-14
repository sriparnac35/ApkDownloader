package sriparna.hillhouse.com.downloader1;

import android.app.DownloadManager;
import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;

/**
 * Created by sriparna on 12/12/16.
 */

public class DownloadService extends Service {
    public static final String ACTION_DOWNLOAD = "com.hillhouse.sriparna.download_file";



    @Override
    public void onCreate(){
        super.onCreate();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int startID, int flags){
        onHandleIntent(intent);
        return START_STICKY;
    }

    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();

        switch (action){
            case ACTION_DOWNLOAD:

                break;

            default:

        }

    }
}
