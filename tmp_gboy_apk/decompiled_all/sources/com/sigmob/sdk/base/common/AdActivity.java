package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdActivity extends BaseAdActivity implements k {
    private static final String k = "AdActivity";
    private j l;
    private String m;
    private BaseAdUnit n;
    private boolean o;
    private boolean p;

    private j a(BaseAdUnit baseAdUnit, Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("ad_view_class_name");
        Bundle extras = getIntent().getExtras();
        if (stringExtra == null) {
            return null;
        }
        this.n = baseAdUnit;
        switch (stringExtra) {
            case "LandNative":
                if (extras != null) {
                    break;
                }
                break;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BaseAdUnit baseAdUnit;
        if (isFinishing() || isDestroyed() || (baseAdUnit = this.n) == null || this.l == null || baseAdUnit.getAd_type() != 6) {
            return;
        }
        if (this.o || this.p) {
            if (com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(this.l instanceof com.sigmob.sdk.newInterstitial.i))) {
                com.sigmob.sdk.base.network.g.a(this.n, "ad_close");
                ae.a("ad_close", (String) null, this.n, new B25kr6(3));
                this.n.setSessionManager(null);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        SigmobLogger.d(k, "onCreate#onTimerFinished", new Object[0]);
        this.p = true;
        runOnUiThread(new A2egSU(0, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.o = true;
        BaseAdUnit baseAdUnit = this.n;
        if (baseAdUnit == null) {
            return;
        }
        int interactionType = baseAdUnit.getInteractionType();
        boolean enableSmallWindow = this.n.enableSmallWindow(Integer.valueOf(interactionType));
        if (interactionType == 2 || enableSmallWindow) {
            b();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        jVar.a(i, i2, intent);
    }

    @Override // android.app.Activity, com.sigmob.sdk.base.common.k
    public void onBackPressed() {
        j jVar = this.l;
        if (jVar == null || !jVar.j()) {
            return;
        }
        super.onBackPressed();
        this.l.i();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        jVar.a(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.sigmob.sdk.videoplayer.c.e((Activity) this);
        super.onCreate(bundle);
        SigmobLog.i("TaskId :" + getTaskId());
        this.m = a(getIntent());
        String stringExtra = getIntent().getStringExtra("adUnit_requestId_key");
        try {
            if (ClientMetadata.getInstance() != null && !TextUtils.isEmpty(stringExtra)) {
                BaseAdUnit c = h.c(stringExtra);
                if (!this.m.equals("dislike_broadcastIdentifier") && c == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("error", "playAdUnit is null");
                    a(hashMap);
                    finish();
                }
                j a2 = a(c, bundle);
                this.l = a2;
                if (a2 == null) {
                    return;
                }
                a2.e();
                if (com.sigmob.sdk.base.utils.q.a(c.allowClickToAutoClose())) {
                    this.l.a(new A4TApA(this));
                }
                Integer allowCountdownEndsClose = c.allowCountdownEndsClose();
                if (com.sigmob.sdk.base.utils.q.a((Number) allowCountdownEndsClose)) {
                    j jVar = this.l;
                    if (jVar instanceof com.sigmob.sdk.newInterstitial.i) {
                        ((com.sigmob.sdk.newInterstitial.i) jVar).a(allowCountdownEndsClose.intValue(), new A4TApA(this));
                        return;
                    }
                    return;
                }
                return;
            }
            SigmobLog.e("uuid is empty");
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("error", "uuid is empty");
            a(hashMap2);
            finish();
        } catch (Throwable th) {
            SigmobLog.e("AdActivity onCreate Throwable: " + th.getMessage(), th);
            HashMap<String, Object> hashMap3 = new HashMap<>();
            hashMap3.put("error", th.getMessage());
            a(hashMap3);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SigmobLog.d("RewardVideoAdPlayerActivity onDestroy() called");
        if (com.sigmob.sdk.base.utils.q.b(this.l)) {
            this.l.h();
        }
        this.l = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        try {
            jVar.f();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("error", th.getMessage());
            a(hashMap);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        try {
            jVar.g();
        } catch (Throwable th) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("error", th.getMessage());
            a(hashMap);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        jVar.a(bundle);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        j jVar = this.l;
        if (jVar == null) {
            return;
        }
        try {
            jVar.o();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            if (Build.VERSION.SDK_INT == 26 && com.sigmob.sdk.videoplayer.c.g((Activity) this)) {
                return;
            }
            super.setRequestedOrientation(i);
        } catch (Exception e) {
            SigmobLog.e("setRequestedOrientation: " + e.getMessage());
        }
    }

    private static String a(Intent intent) {
        return intent.getStringExtra(Constants.BROADCAST_IDENTIFIER_KEY);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(int i) {
        setRequestedOrientation(i);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls == null) {
            return;
        }
        try {
            startActivityForResult(v.a(this, cls, bundle), i);
        } catch (Throwable unused) {
            SigmobLog.d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        boolean z = obj instanceof PointEntitySigmob;
    }

    private void a(HashMap<String, Object> hashMap) {
        BaseBroadcastReceiver.a(this, this.m, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
    }
}
