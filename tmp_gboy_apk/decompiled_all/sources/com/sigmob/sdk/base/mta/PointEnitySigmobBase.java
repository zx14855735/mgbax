package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityBase;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.windad.WindAds;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class PointEnitySigmobBase extends PointEntityBase {

    /* renamed from: a, reason: collision with root package name */
    private String f13181a;
    private String b;
    private String c;

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return b.b();
    }

    public String getIs_custom_android_id() {
        return this.b;
    }

    public String getIs_custom_imei() {
        return this.f13181a;
    }

    public String getIs_custom_oaid() {
        return this.c;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String getSdkversion() {
        return n.k;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public boolean isAcTypeBlock() {
        if (!i.a().i()) {
            return true;
        }
        List<Integer> O = o.a().O();
        if (e.a(O)) {
            return false;
        }
        Iterator<Integer> it = O.iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void setIs_custom_android_id(String str) {
        this.b = str;
    }

    public void setIs_custom_imei(String str) {
        this.f13181a = str;
    }

    public void setIs_custom_oaid(String str) {
        this.c = str;
    }
}
