package com.bytedance.msdk.w.w.hf.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf extends com.bytedance.sdk.openadsdk.core.wo.u implements com.bytedance.msdk.w.xj.hf, com.bytedance.msdk.w.xj.xj {
    private boolean hf = false;
    private boolean w = false;
    protected com.bytedance.msdk.w.xj.hf xj;

    public hf(com.bytedance.msdk.w.xj.hf hfVar) {
        this.xj = hfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        this.hf = false;
        this.w = false;
        if (com.bytedance.msdk.core.xj.p().jk()) {
            hf(context, hfVar, hfVar2, map);
            xj(hfVar);
            return;
        }
        try {
            hf(context, hfVar, hfVar2, map);
            xj(hfVar);
        } catch (Throwable th) {
            xj(new com.bytedance.msdk.api.xj(com.bytedance.msdk.core.am.hf.xj(th)));
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public abstract void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map);

    public boolean hf() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.w.xj.xj
    public String xj(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2) {
        return null;
    }

    @Override // com.bytedance.msdk.w.xj.xj
    public final void xj(final Context context, final com.bytedance.msdk.w.y.hf.hf hfVar, final com.bytedance.msdk.api.xj.hf hfVar2, final Map<String, Object> map) {
        if (hfVar != null && (TextUtils.equals(MediationConstant.ADN_MINTEGRAL, hfVar.g()) || TextUtils.equals("baidu", hfVar.g()) || TextUtils.equals(MediationConstant.ADN_ADMOB, hfVar.g()))) {
            y.w(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.xj.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.w(context, hfVar, hfVar2, map);
                }
            });
        } else {
            w(context, hfVar, hfVar2, map);
        }
    }

    private void xj(com.bytedance.msdk.w.y.hf.hf hfVar) {
        if (hfVar != null) {
            com.bytedance.msdk.core.w.w.hf(hfVar.g(), hfVar.hf(), hfVar.pl());
        }
    }

    public void xj(com.bytedance.msdk.hf.w wVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(wVar);
        xj(arrayList);
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(List<com.bytedance.msdk.hf.w> list) {
        if (this.hf) {
            return;
        }
        this.hf = true;
        com.bytedance.msdk.w.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(list);
        }
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(com.bytedance.msdk.api.xj xjVar) {
        this.w = true;
        if (this.hf) {
            return;
        }
        this.hf = true;
        com.bytedance.msdk.w.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    public void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj xjVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(wVar);
        xj(arrayList, xjVar);
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.w.xj.hf hfVar;
        if (this.w || (hfVar = this.xj) == null) {
            return;
        }
        hfVar.xj(list, xjVar);
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(com.bytedance.msdk.hf.w wVar, String str) {
        com.bytedance.msdk.w.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(wVar, str);
        }
    }

    public boolean xj() {
        return this.w;
    }
}
