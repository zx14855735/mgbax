package com.fl.saas.s2s.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.bykv.vk.component.ttvideo.player.C;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommClickHelper;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ApkUtils {
    public static Intent getApkInStallIntent(Context context, File file) {
        Uri apkUri;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        if (Build.VERSION.SDK_INT > 23) {
            apkUri = FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", file);
            intent.addFlags(1);
        } else {
            apkUri = getApkUri(file);
        }
        intent.setDataAndType(apkUri, AdBaseConstants.MIME_APK);
        return intent;
    }

    private static Uri getApkUri(File file) {
        try {
            new ProcessBuilder("chmod", "777", file.toString()).start();
        } catch (IOException unused) {
        }
        return Uri.fromFile(file);
    }

    public static void installAPk(Context context, File file, AdInfoPoJo adInfoPoJo) {
        context.startActivity(getApkInStallIntent(context, file));
        if (adInfoPoJo != null) {
            CommClickHelper.getInstance().report(context, adInfoPoJo, 6);
        }
    }
}
