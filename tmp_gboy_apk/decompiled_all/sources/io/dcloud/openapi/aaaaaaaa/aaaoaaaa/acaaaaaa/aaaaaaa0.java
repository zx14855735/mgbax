package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.download.api.constant.BaseConstants;
import io.dcloud.openapi.activity.WebViewActivity;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaa0 {

    public class aaaaaaaa implements Runnable {
        final /* synthetic */ String aaaaaaa0;
        final /* synthetic */ Context aaaaaaaa;

        public aaaaaaaa(Context context, String str) {
            this.aaaaaaaa = context;
            this.aaaaaaa0 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.aaaaaaaa, this.aaaaaaa0, 0).show();
        }
    }

    public static void aaaaaaa0(Context context, String str) {
        MainHandlerUtil.getMainHandler().post(new aaaaaaaa(context, str));
    }

    public static boolean aaaaaaaa(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(context.getPackageName())) {
            return true;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean aaaaaaac(Context context, String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setComponent(null);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                return false;
            }
            parseUri.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(parseUri);
            return true;
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }

    public static PackageInfo aaaaaaan(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static void aaaaaaao(Context context, String str) {
        try {
            Intent intent = new Intent();
            if (!Build.BRAND.equalsIgnoreCase("vivo") && aaaaaaaa(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
                intent.setPackage(BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
            }
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void aaaaaaau(Context context, String str) {
        try {
            Intent intent = new Intent();
            int i = WebViewActivity.aeaaaaaa;
            intent.setClass(context, WebViewActivity.class);
            intent.putExtra("url", str);
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void aaaaaaaa(Context context) {
        aaaaaaa0(context, "已开始下载，完成后自动打开安装界面");
    }
}
