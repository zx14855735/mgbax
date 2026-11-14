package com.game.boy.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.gson.JsonIOException;
import io.dcloud.ads.core.v2.splash.DCSplashAd;
import io.dcloud.ads.core.v2.splash.DCSplashAdLoadListener;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements OLy1FW.AlLFFp, LLiCI0.COJEAR, DCSplashAdLoadListener, com.google.gson.internal.AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Object f10885AcNBzu;

    public /* synthetic */ A2egSU(Object obj) {
        this.f10885AcNBzu = obj;
    }

    @Override // OLy1FW.AlLFFp
    public void A2egSU() {
        ((A5SV6n) this.f10885AcNBzu).ASJ6gh();
    }

    @Override // LLiCI0.COJEAR
    public void A4TApA(MTKlkd.ARc23Z aRc23Z) {
        MOpbMP.B2KMhB AzWtSf2 = MOpbMP.B2KMhB.AzWtSf(aRc23Z);
        AzWtSf2.show(((FavoriteActivity) this.f10885AcNBzu).getSupportFragmentManager(), AzWtSf2.getTag());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b0, code lost:
    
        if (r0 != 6) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca A[Catch: Exception -> 0x00d1, TryCatch #0 {Exception -> 0x00d1, blocks: (B:23:0x00c4, B:25:0x00ca, B:28:0x00ce), top: B:22:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d1, blocks: (B:23:0x00c4, B:25:0x00ca, B:28:0x00ce), top: B:22:0x00c4 }] */
    @Override // LLiCI0.COJEAR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A5SV6n(MTKlkd.ARc23Z r8) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.A2egSU.A5SV6n(MTKlkd.ARc23Z):void");
    }

    @Override // com.google.gson.internal.AlLFFp
    public Object AZkASS() {
        Type type = (Type) this.f10885AcNBzu;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdLoadListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
    public void onError(int i, String str, JSONArray jSONArray) {
        int i2 = SplashActivity.f11087BChYOn;
        ((SplashActivity) this.f10885AcNBzu).AZOQYO();
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdLoadListener
    public void onSplashAdLoad() {
        RelativeLayout relativeLayout;
        int i = SplashActivity.f11087BChYOn;
        SplashActivity splashActivity = (SplashActivity) this.f10885AcNBzu;
        splashActivity.getClass();
        try {
            DCSplashAd dCSplashAd = splashActivity.f11088B25kr6;
            if (dCSplashAd == null || (relativeLayout = splashActivity.f11089B2KMhB) == null) {
                splashActivity.AZOQYO();
            } else {
                dCSplashAd.showIn(relativeLayout);
            }
        } catch (Throwable unused) {
            splashActivity.AZOQYO();
        }
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdLoadListener
    public void redBag(View view, FrameLayout.LayoutParams layoutParams) {
    }
}
