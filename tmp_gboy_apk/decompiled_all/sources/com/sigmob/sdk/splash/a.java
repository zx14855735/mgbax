package com.sigmob.sdk.splash;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.sigmob.sdk.base.common.i {
    private int l = 3;
    private boolean m;

    public static a d(BaseAdUnit baseAdUnit) {
        a aVar = new a();
        aVar.b(baseAdUnit);
        return aVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.b("close", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.b("skip", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "skip");
    }

    public int l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdSetting splashAdSetting = baseAdUnit.getSplashAdSetting();
        if (splashAdSetting == null) {
            return;
        }
        this.l = splashAdSetting.show_duration.intValue();
        this.m = splashAdSetting.enable_close_on_click.booleanValue();
    }
}
