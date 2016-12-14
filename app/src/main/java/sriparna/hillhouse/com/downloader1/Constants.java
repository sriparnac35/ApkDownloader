package sriparna.hillhouse.com.downloader1;

import android.os.Environment;

/**
 * Created by sriparna on 12/12/16.
 */

public class Constants {
    public static final String APK_DOWNLOAD_URL
            = "https://github.com/appium/sample-code/blob/master/sample-code/apps/ContactManager/ContactManager.apk?raw=true";

    public static final String APK_DOWNLOAD_DESTINATION = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS) + "/docs/" + "DummyProjForDownload1.apk";

}