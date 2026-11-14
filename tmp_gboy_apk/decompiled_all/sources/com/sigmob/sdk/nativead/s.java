package com.sigmob.sdk.nativead;

import android.content.Context;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.natives.WindNativeAdData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s extends m {
    ac g;

    public s(Context context) {
        super(context);
    }

    public void a(ac acVar) {
        this.g = acVar;
    }

    @Override // com.sigmob.sdk.nativead.m
    public void c() {
        super.c();
        this.g = null;
    }

    public void e() {
    }

    public e getAdConfig() {
        ac acVar = this.g;
        if (acVar == null) {
            return null;
        }
        return acVar.x();
    }

    public BaseAdUnit getAdUnit() {
        ac acVar = this.g;
        if (acVar == null) {
            return null;
        }
        return acVar.k();
    }

    public n getAppInfoView() {
        ac acVar = this.g;
        if (acVar == null) {
            return null;
        }
        return acVar.m();
    }

    public WindNativeAdData getNativeAdUnit() {
        ac acVar = this.g;
        if (acVar == null) {
            return null;
        }
        return acVar.l();
    }

    public double getVideoDuration() {
        return 0.0d;
    }

    public double getVideoProgress() {
        return 0.0d;
    }

    public void i() {
    }

    public void j() {
    }

    public void setUIStyle(j jVar) {
        this.d = jVar;
    }
}
