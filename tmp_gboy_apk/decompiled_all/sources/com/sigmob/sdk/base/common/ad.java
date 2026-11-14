package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ad extends PointEntityCommon {

    /* renamed from: a, reason: collision with root package name */
    private String f13101a;
    private String b;
    private String c;

    public String a() {
        return this.f13101a;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return com.sigmob.sdk.b.b();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String getSdkversion() {
        return com.sigmob.sdk.base.n.k;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public boolean isAcTypeBlock() {
        if (!com.sigmob.sdk.base.i.a().i()) {
            return true;
        }
        Iterator<Integer> it = com.sigmob.sdk.base.o.a().O().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        this.f13101a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }
}
