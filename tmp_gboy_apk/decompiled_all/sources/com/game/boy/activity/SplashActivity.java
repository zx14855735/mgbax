package com.game.boy.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import io.dcloud.ads.core.v2.splash.DCSplashAd;

@SuppressLint({"CustomSplashScreen"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashActivity extends A5SV6n {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final /* synthetic */ int f11087BChYOn = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public DCSplashAd f11088B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public RelativeLayout f11089B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f11090B3GDIM = false;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Handler f11091B4ZgIw = new Handler(Looper.getMainLooper());

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CkXcdM f11092B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CkXcdM f11093B9tovu;

    public final void AYUAbz() {
        CkXcdM ckXcdM = this.f11092B7CMnp;
        if (ckXcdM != null) {
            this.f11091B4ZgIw.removeCallbacks(ckXcdM);
            this.f11092B7CMnp = null;
        }
    }

    public final void AZOQYO() {
        if (this.f11090B3GDIM) {
            return;
        }
        this.f11090B3GDIM = true;
        AYUAbz();
        try {
            A5SV6n.f10887AlLFFp = false;
            A5SV6n.f10888AmA8tU = 0L;
        } catch (Throwable unused) {
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        setContentView(2131492905);
        this.f11089B2KMhB = (RelativeLayout) findViewById(2131298004);
        AYUAbz();
        CkXcdM ckXcdM = new CkXcdM(this, 1);
        this.f11092B7CMnp = ckXcdM;
        Handler handler = this.f11091B4ZgIw;
        handler.postDelayed(ckXcdM, 3000L);
        CkXcdM ckXcdM2 = new CkXcdM(this, 0);
        this.f11093B9tovu = ckXcdM2;
        handler.postDelayed(ckXcdM2, 150L);
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        AYUAbz();
        CkXcdM ckXcdM = this.f11093B9tovu;
        Handler handler = this.f11091B4ZgIw;
        if (ckXcdM != null) {
            handler.removeCallbacks(ckXcdM);
            this.f11093B9tovu = null;
        }
        handler.removeCallbacksAndMessages(null);
        DCSplashAd dCSplashAd = this.f11088B25kr6;
        if (dCSplashAd != null) {
            try {
                dCSplashAd.setSplashAdListener(null);
            } catch (Throwable unused) {
            }
            this.f11088B25kr6 = null;
        }
    }

    @Override // ADYaiT.B2KMhB, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f11089B2KMhB.setSystemUiVisibility(5894);
        }
    }
}
