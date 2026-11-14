package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityCrash;
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
public class PointEntitySigmobCrash extends PointEntityCrash {
    public static PointEntitySigmobCrash WindCrash(String str) {
        PointEntitySigmobCrash pointEntitySigmobCrash = new PointEntitySigmobCrash();
        pointEntitySigmobCrash.setAc_type(PointType.SIGMOB_CRASH);
        pointEntitySigmobCrash.setCategory("crash");
        pointEntitySigmobCrash.setCrashMessage(str);
        return pointEntitySigmobCrash;
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    @Override // com.czhj.sdk.common.mta.PointEntitySuper
    public DeviceContext getDeviceContext() {
        return b.b();
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
}
