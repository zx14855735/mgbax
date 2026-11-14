package L2suez;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.czhj.sdk.common.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZOQYO {
    public static void A2egSU(Context context, ImageView imageView) {
        PackageInfo packageInfo;
        RequestBuilder A2egSU2 = com.bumptech.glide.A4TApA.ARc23Z(context).A2egSU(Drawable.class);
        RequestBuilder BmvVmW2 = A2egSU2.BmvVmW(2131230987);
        ConcurrentHashMap concurrentHashMap = IssTRV.A4TApA.f4067A2egSU;
        Context context2 = A2egSU2.BpkvW3;
        String packageName = context2.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = IssTRV.A4TApA.f4067A2egSU;
        HSHyT0.AZkASS aZkASS = (HSHyT0.AZkASS) concurrentHashMap2.get(packageName);
        if (aZkASS == null) {
            try {
                packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                context2.getPackageName();
                packageInfo = null;
            }
            IssTRV.ADYaiT aDYaiT = new IssTRV.ADYaiT(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            HSHyT0.AZkASS aZkASS2 = (HSHyT0.AZkASS) concurrentHashMap2.putIfAbsent(packageName, aDYaiT);
            aZkASS = aZkASS2 == null ? aDYaiT : aZkASS2;
        }
        BmvVmW2.A2egSU((RequestOptions) new RequestOptions().AmA8tU(new IssTRV.A2egSU(context2.getResources().getConfiguration().uiMode & 48, aZkASS))).BTvldC(imageView);
    }

    public static void A4TApA(Context context, String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            A2egSU(context, imageView);
            return;
        }
        if (str != null && !str.isEmpty()) {
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c)) {
                }
            }
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(context).AaHO0E(CtFAbx.BChYOn("file:///android_asset/", CtFAbx.BI9f7h("image/", str, ".jpeg"))).ADYaiT(HXc4pW.AlLFFp.f3556A4TApA)).B25kr6(true)).AMqCpz(2131230987)).BTvldC(imageView);
            return;
        }
        if (!(TextUtils.isEmpty(str) ? false : Patterns.WEB_URL.matcher(str.toLowerCase(Locale.ROOT)).matches())) {
            A2egSU(context, imageView);
            return;
        }
        String str2 = "https://gboy.top/";
        if (!TextUtils.isEmpty(str)) {
            try {
                URI uri = new URI(str);
                String scheme = uri.getScheme();
                String host = uri.getHost();
                if (scheme == null) {
                    scheme = str.startsWith("//") ? "https" : Constants.HTTP;
                }
                if (host != null && !host.isEmpty()) {
                    str2 = scheme + "://" + host + "/";
                }
            } catch (URISyntaxException unused) {
                if (str.contains("://")) {
                    int indexOf = str.indexOf("/", str.indexOf("://") + 3);
                    str2 = indexOf > 0 ? str.substring(0, indexOf) + "/" : str.concat("/");
                } else {
                    str2 = CtFAbx.B25kr6(new StringBuilder("http://"), str.split("/")[0], "/");
                }
            }
        }
        Hjvs0g.AmA8tU amA8tU = new Hjvs0g.AmA8tU();
        amA8tU.A2egSU("Referer", str2);
        amA8tU.A2egSU("User-Agent", "Your-App-Name");
        amA8tU.f3727A2egSU = true;
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(context).A2egSU(Drawable.class).BmvVmW(new Hjvs0g.AcNBzu(str, new Hjvs0g.B25kr6(amA8tU.f3728A4TApA))).ADYaiT(HXc4pW.AlLFFp.f3558ADYaiT)).AZkASS(2131230987)).AMqCpz(2131230987)).BTvldC(imageView);
    }
}
