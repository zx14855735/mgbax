package ADYaiT;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMHView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMVView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMHView;
import com.fl.saas.base.inner.spread.coustomView.SpreadHorizontalView;
import com.fl.saas.base.inner.spread.coustomView.SpreadVerticalView;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.util.S2SVideoView;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.c;
import com.sigmob.sdk.mraid.h;
import com.sigmob.sdk.videoAd.j;
import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.WindAdError;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.f.aaaaaaaa;
import io.dcloud.openapi.poly.adapter.slot.WinXinMinProgramDispatcher;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class BChYOn implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f89AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f90AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f91AmA8tU;

    public /* synthetic */ BChYOn(Object obj, int i, Object obj2) {
        this.f89AcNBzu = i;
        this.f90AlLFFp = obj;
        this.f91AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        int i = 1;
        Object obj = this.f91AmA8tU;
        Object obj2 = this.f90AlLFFp;
        switch (this.f89AcNBzu) {
            case 0:
                Runnable runnable = (Runnable) obj;
                BI9f7h bI9f7h = (BI9f7h) obj2;
                bI9f7h.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    bI9f7h.A4TApA();
                }
            case 1:
                ((BTvldC.B2KMhB) obj2).A5SV6n((Typeface) obj);
                return;
            case 2:
                ((ProfileInstallerInitializer) obj2).getClass();
                (Build.VERSION.SDK_INT >= 28 ? DUi7mC.AYUAbz.A2egSU(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new B4ZgIw((Context) obj, i), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 3:
                ImageView imageView = (ImageView) obj;
                H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                AppInfoViewActivity appInfoViewActivity = (AppInfoViewActivity) obj2;
                appInfoViewActivity.getClass();
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                try {
                    GnQT2j.AcNBzu.A2egSU().A4TApA(appInfoViewActivity.f9607AcNBzu.getMaterial().getIconurl(), new K1Z3yj.A2egSU(appInfoViewActivity, imageView, 15, z));
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 4:
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) obj2;
                aZkASS.getClass();
                int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                String replace = UUID.randomUUID().toString().replace("-", "");
                GJee0v.AYUAbz.A2egSU().A4TApA((Context) obj, aZkASS.f2718GJee0v.getAdm(), CtFAbx.BChYOn("aaaccc", replace), new K1Z3yj.A2egSU(aZkASS, replace, 18, z));
                return;
            case 5:
                FSFw2u.AZkASS aZkASS2 = (FSFw2u.AZkASS) obj2;
                if (aZkASS2.f2731HHLj6Q == 1) {
                    aZkASS2.B2KMhB(aZkASS2.f2704FOAO9d, "1");
                    return;
                } else {
                    aZkASS2.B2KMhB((View) obj, null);
                    return;
                }
            case 6:
                FdMWEC.AZkASS aZkASS3 = (FdMWEC.AZkASS) obj2;
                aZkASS3.getClass();
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                if (aZkASS3.f2842H1wUHe == 1) {
                    aZkASS3.B2KMhB(aZkASS3.f2808EicXu4, "1");
                    return;
                } else {
                    aZkASS3.B2KMhB((View) obj, null);
                    return;
                }
            case 7:
                FdMWEC.AZkASS aZkASS4 = (FdMWEC.AZkASS) obj2;
                aZkASS4.getClass();
                int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                String str = UUID.randomUUID().toString().replace("-", "") + "aaaccc";
                GJee0v.AYUAbz.A2egSU().A4TApA((Context) obj, aZkASS4.f2824Fmmv0E.getAdm(), str, new K1Z3yj.A2egSU(aZkASS4, str, 21, z));
                return;
            case 8:
                try {
                    ((ContextWrapper) obj).getApplicationContext().sendBroadcast(new Intent((String) obj2));
                    return;
                } catch (Exception unused2) {
                    int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                    return;
                }
            case 9:
                ((H0qugq.AZOQYO) obj2).f3188AZOQYO.onError(100006, (String) obj);
                return;
            case 10:
                ((SpreadHorizontalView) obj2).lambda$setMediaView$0((Bitmap) obj);
                return;
            case 11:
                ((SpreadHorizontalView) obj2).lambda$setMediaView$1((Drawable) obj);
                return;
            case 12:
                ((SpreadHorizontalView) obj2).lambda$setMediaView$2((BitmapDrawable) obj);
                return;
            case 13:
                ((SpreadVerticalView) obj2).lambda$setMediaView$0((Bitmap) obj);
                return;
            case 14:
                ((WindSplashAD) obj2).b((WindAdError) obj);
                return;
            case 15:
                ((aaaaaaaa) obj2).aaaaaaa0((JSONObject) obj);
                return;
            case 16:
                ((WinXinMinProgramDispatcher.MessageListener) obj2).onReceiver(obj);
                return;
            case 17:
                ((InterstitialFullScreenView) obj2).lambda$setMediaView$1((Drawable) obj);
                return;
            case 18:
                ((InterstitialFullScreenView) obj2).lambda$setMediaView$2((BitmapDrawable) obj);
                return;
            case 19:
                ((InterstitialFullScreenView) obj2).lambda$setMediaView$0((Bitmap) obj);
                return;
            case 20:
                ((InterstitialHMHView) obj2).lambda$bindActionView$0((View) obj);
                return;
            case 21:
                ((InterstitialHMVView) obj2).lambda$bindActionView$2((View) obj);
                return;
            case 22:
                ((InterstitialHMVView) obj2).lambda$setMediaView$0((Drawable) obj);
                return;
            case 23:
                ((InterstitialVMHView) obj2).lambda$setMediaView$0((Bitmap) obj);
                return;
            case 24:
                ((BaseLoader) obj2).lambda$loadAdapter$0((AdapterAPI) obj);
                return;
            case 25:
                ((S2SVideoView) obj2).lambda$setVideo$2((AdInfoPoJo) obj);
                return;
            case 26:
                ((S2SVideoView) obj2).lambda$setVideo$1((Bitmap) obj);
                return;
            case 27:
                a.a((String) obj2, (c) obj);
                return;
            case 28:
                ((h) obj2).a((Context) obj);
                return;
            default:
                ((j) obj2).a((Bitmap) obj);
                return;
        }
    }
}
