package com.bytedance.msdk.api.u.xj.hf;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.qt;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.msdk.api.u.xj.hf.f.c;
import com.bytedance.msdk.api.u.xj.hf.f.f;
import com.bytedance.msdk.api.u.xj.hf.f.kd;
import com.bytedance.msdk.api.u.xj.hf.f.u;
import com.bytedance.msdk.api.u.xj.hf.f.y;
import com.bytedance.msdk.hf.w;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w {
    private f am;
    private com.bytedance.msdk.api.u.xj.hf.hf.xj d;
    private com.bytedance.msdk.api.u.xj.hf.f.hf e;
    private y g;
    private u p;

    /* renamed from: pl, reason: collision with root package name */
    private qt f10115pl;
    private com.bytedance.msdk.api.u.xj.hf.f.w qt;
    private com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj tf;
    private kd yo;
    private c zg;

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.hf am() {
        return this.w;
    }

    @Override // com.bytedance.msdk.hf.w
    public String c() {
        com.bytedance.msdk.api.u.xj.hf.f.hf hfVar = this.e;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        com.bytedance.msdk.api.u.xj.hf.hf.xj xjVar = this.d;
        if (xjVar != null && (xjVar instanceof com.bytedance.msdk.api.u.xj.hf.xj.xj)) {
            return ((com.bytedance.msdk.api.u.xj.hf.xj.xj) xjVar).xj();
        }
        y yVar = this.g;
        if (yVar != null) {
            return yVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public void e() {
        super.e();
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.c.kd f() {
        com.bytedance.msdk.api.u.xj.hf.f.hf hfVar = this.e;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.c.f g() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf() {
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean jk() {
        try {
            com.bytedance.msdk.api.u.xj.hf.f.w wVar = this.qt;
            if (wVar != null) {
                return wVar.xj();
            }
        } catch (Exception unused) {
        }
        return super.jk();
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean kd() {
        return false;
    }

    @Override // com.bytedance.msdk.hf.w
    public void p() {
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.c.hf pl() {
        return this.xj;
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.w.xj qt() {
        return this.y;
    }

    @Override // com.bytedance.msdk.hf.w
    public View tf() {
        com.bytedance.msdk.api.u.xj.hf.f.hf hfVar = this.e;
        return hfVar != null ? hfVar.w() : super.tf();
    }

    @Override // com.bytedance.msdk.hf.w
    public int u() {
        kd kdVar = this.yo;
        if (kdVar != null) {
            return kdVar.xj();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj v() {
        return this.tf;
    }

    @Override // com.bytedance.msdk.hf.w
    public void w() {
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj() {
    }

    @Override // com.bytedance.msdk.hf.w
    public final Integer y() {
        c cVar = this.zg;
        if (cVar != null) {
            return cVar.xj();
        }
        com.bytedance.msdk.api.u.xj.hf.hf.xj xjVar = this.d;
        return xjVar != null ? xjVar.w() : super.y();
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
    }

    @Override // com.bytedance.msdk.hf.w
    public void zg() {
        super.zg();
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        if (this.d != null) {
            da();
        }
        if (this.f10115pl != null) {
            da();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar, List<View> list4) {
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, Object obj, String str) {
        com.bytedance.msdk.api.u.xj.hf.hf.xj xjVar = this.d;
        if (xjVar == null || !(xjVar instanceof com.bytedance.msdk.api.u.xj.hf.hf.hf)) {
            return;
        }
        ((com.bytedance.msdk.api.u.xj.hf.hf.hf) xjVar).xj(activity);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(ViewGroup viewGroup) {
        com.bytedance.msdk.api.u.xj.hf.hf.xj xjVar = this.d;
        if (xjVar == null || !(xjVar instanceof com.bytedance.msdk.api.u.xj.hf.tf.xj)) {
            return;
        }
        ((com.bytedance.msdk.api.u.xj.hf.tf.xj) xjVar).xj(viewGroup);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.tf = xjVar;
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            if (obj instanceof Integer) {
                ((Integer) obj).getClass();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        u uVar = this.p;
        if (uVar != null) {
            return uVar.xj(activity);
        }
        return super.xj(activity);
    }
}
