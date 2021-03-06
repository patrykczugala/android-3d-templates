package android.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.io.File;

/**
 * Created by stark on 12/02/2017.
 */

public class ResourceUtils {

    public static String getGlobalResourcePackageIdentifier(Context context) throws Exception {
        String packageName = context.getPackageName();
        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            String apk = ai.dataDir;
            Log.i("UTIL",apk.substring(apk.lastIndexOf(File.separator)+1));
            return apk.substring(apk.lastIndexOf(File.separator)+1);
        } catch (Throwable x) {
            throw new Exception("Failed when try to get global package identifier",x);
        }
    }

}
