package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class b extends com.sigmob.sdk.base.common.j {
    public b(Activity activity, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
    }

    public void a(boolean z) {
        if (z) {
            this.d.a();
        }
    }

    public void b(Context context, int i, Bundle bundle) {
        try {
            a(context.getApplicationContext(), i, bundle);
            boolean z = bundle.getBoolean(n.v, false);
            boolean z2 = bundle.getBoolean(n.u, false);
            if (Build.VERSION.SDK_INT >= 27) {
                if (z) {
                    n().setTurnScreenOn(true);
                }
                if (z2) {
                    n().setShowWhenLocked(true);
                    n().setTurnScreenOn(true);
                }
            }
            if (z) {
                n().getWindow().addFlags(r.b.d);
            }
            if (z2) {
                n().getWindow().addFlags(2621440);
            }
        } catch (Throwable th) {
            SigmobLog.e("optionSetting error", th);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        this.d.onSetContentView(this.c);
    }
}
