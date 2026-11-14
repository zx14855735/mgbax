package com.bytedance.sdk.openadsdk.core.g.xj;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.qt;
import com.bytedance.sdk.component.adexpress.hf.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.l;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.hf.u;
import com.bytedance.sdk.openadsdk.core.hf.w;
import com.bytedance.sdk.openadsdk.core.pl.w.w.y;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends u implements com.bytedance.sdk.component.adexpress.dynamic.kd.xj, w {
    private boolean hf;
    private volatile boolean kd;
    private qt p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10356pl;
    private View tf;
    private WeakReference<ViewGroup> u;
    private ws w;
    private p xj;

    public xj(ws wsVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.kd = false;
        this.f10356pl = Integer.MIN_VALUE;
        this.w = wsVar;
        this.u = weakReference;
    }

    private JSONObject u(View view) {
        return new JSONObject();
    }

    private void w(View view) {
        try {
            xj(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e) {
            pl.xj(e);
            e.getMessage();
        } catch (Exception e2) {
            pl.u("DynamicClickListener", e2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
    public void hf(View view) {
        this.c.xj(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
    public void xj(p pVar) {
        this.xj = pVar;
    }

    private void hf() {
        WeakReference<ViewGroup> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null || !l.xj(this.u.get())) {
            return;
        }
        this.f10356pl = 1;
        w(this.tf);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
    public void xj(boolean z, qt qtVar) {
        this.kd = true;
        this.hf = z;
        this.p = qtVar;
        WeakReference<ViewGroup> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        l.xj(this.u, this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f10356pl = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.kd.xj
    public void xj(View view) {
        this.c.hf(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(View view, tf tfVar) {
        this.tf = view;
        if (this.kd) {
            this.kd = false;
        } else {
            w(view);
        }
    }

    private void xj(View view, int i) {
        CharSequence text;
        if (this.xj != null) {
            if (this.hf && this.w != null) {
                y.u = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View y = this.c.y();
            if (y != null) {
                int[] xj = r.xj(y);
                if (xj != null) {
                    iArr = xj;
                }
                int[] w = r.w(y);
                if (w != null) {
                    iArr2 = w;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.f10356pl));
            } catch (Throwable unused) {
            }
            this.xj.xj(view, i, new ra.xj().u(this.c.am()).w(this.c.qt()).hf(this.c.zg()).xj(this.c.e()).hf(this.c.pl()).xj(this.c.g()).xj(iArr[0]).hf(iArr[1]).w(iArr2[0]).u(iArr2[1]).xj(u(view)).w(String.valueOf(i)).hf(String.valueOf(view.getTag(2097610714))).xj(String.valueOf(view.getTag(2097610715))).u(String.valueOf(view.getTag(2097610713))).xj(this.c.kd()).xj(jSONObject).xj(this.c.tf()).xj());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.w
    public void xj() {
        hf();
        this.kd = false;
        qt qtVar = this.p;
        if (qtVar != null) {
            qtVar.kd();
        }
    }
}
