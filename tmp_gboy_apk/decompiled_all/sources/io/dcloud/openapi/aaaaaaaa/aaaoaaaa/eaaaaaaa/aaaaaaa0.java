package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaa0 {
    private static boolean aaaaaaaa;

    public static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa aaaaaaaa(aaaaaaaa.aaaaaaao aaaaaaaoVar, Context context, String str, String str2, String str3, String str4) {
        aaaaaaaa(context);
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa(aaaaaaaoVar, context, str, str2, str3, str4);
    }

    private static void aaaaaaaa(Context context) {
        File[] listFiles;
        if (aaaaaaaa) {
            return;
        }
        aaaaaaaa = true;
        if (context != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - bn.d;
                File file = new File(context.getCacheDir().getAbsolutePath() + "/dcloud_ad/img/");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    if (file2.lastModified() < currentTimeMillis) {
                        file2.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
