package com.bytedance.sdk.gromore.xj.xj.xj;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj {
    private com.bytedance.msdk.api.u.xj.xj.w xj;

    public u(com.bytedance.msdk.api.u.xj.xj.w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public List<String> c() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.y();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public int d() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String f() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public com.bytedance.sdk.openadsdk.zg.w.hf.u g() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.pl();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String hf() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String kd() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.u();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.u p() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar == null || wVar.tf() == null) {
            return null;
        }
        return new w(this.xj.tf());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public boolean pl() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.p();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public int tf() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.d();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String u() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.w();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String w() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.hf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public String xj() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public double y() {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.kd();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public c hf(Activity activity) {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.hf(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(activity, viewGroup, list, list2, list3, tf.xj(uVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public c hf(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            return wVar.hf(dialog, numArr);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.w xj(Activity activity) {
        com.bytedance.msdk.api.u.xj.xj.w wVar;
        if (activity == null || (wVar = this.xj) == null) {
            return null;
        }
        return new hf(activity, null, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.w xj(Activity activity, Map<String, Object> map) {
        com.bytedance.msdk.api.u.xj.xj.w wVar;
        if (activity == null || map == null || (wVar = this.xj) == null) {
            return null;
        }
        return new hf(activity, map, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(activity, xjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
    public void xj(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.api.u.xj.xj.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(dialog, numArr);
        }
    }
}
