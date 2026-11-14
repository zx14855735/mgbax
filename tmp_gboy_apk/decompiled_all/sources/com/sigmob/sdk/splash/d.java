package com.sigmob.sdk.splash;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.utils.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class d extends y {
    a c;
    private SplashAdBroadcastReceiver d;

    public d(p pVar) {
        super(pVar);
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        MaterialMeta material = baseAdUnit.getMaterial();
        if (TextUtils.isEmpty(baseAdUnit.getCrid())) {
            return false;
        }
        return (TextUtils.isEmpty(material.video_url) && TextUtils.isEmpty(material.image_src)) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(p pVar) {
        this.f13165a = pVar;
    }

    @Override // com.sigmob.sdk.base.common.y
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdBroadcastReceiver splashAdBroadcastReceiver = this.d;
        if (splashAdBroadcastReceiver == null) {
            return;
        }
        splashAdBroadcastReceiver.b(splashAdBroadcastReceiver);
        this.d = null;
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        if (baseAdUnit == null) {
            baseAdUnit = this.b;
        }
        if (q.b(baseAdUnit)) {
            this.c = (a) baseAdUnit.getAdConfig();
        }
        super.a(baseAdUnit, bundle);
        p pVar = this.f13165a;
        if (pVar instanceof e) {
            SplashAdBroadcastReceiver splashAdBroadcastReceiver = new SplashAdBroadcastReceiver((e) pVar, baseAdUnit.getUuid());
            this.d = splashAdBroadcastReceiver;
            splashAdBroadcastReceiver.a(splashAdBroadcastReceiver);
        }
    }

    @Override // com.sigmob.sdk.base.common.y
    public boolean a(BaseAdUnit baseAdUnit) {
        return c(baseAdUnit);
    }
}
