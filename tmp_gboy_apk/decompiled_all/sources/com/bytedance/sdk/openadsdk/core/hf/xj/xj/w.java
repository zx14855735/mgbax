package com.bytedance.sdk.openadsdk.core.hf.xj.xj;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private c c;
    private boolean f;
    private int y;

    private boolean d() {
        if (this.xj == null || tf() || !ws.hf(this.xj)) {
            return false;
        }
        if (this.y == 0) {
            this.y = wo.f(this.xj);
        }
        kd();
        c();
        y();
        if (this.y == 5 && p() && c() && !kd() && !y()) {
            return false;
        }
        int i = this.y;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean f() {
        return d() && hf(this.u) && !this.kd.hf();
    }

    private boolean hf(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387664 || view.getId() == 2114387957 || view.getId() == 2114387764 || view.getId() == 2114387686 || view.getId() == 2114387626) {
            return true;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                if (hf(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private boolean p() {
        ws wsVar = this.xj;
        return wsVar != null && wsVar.dq() == 1 && ws.hf(this.xj);
    }

    private boolean tf() {
        return this.f;
    }

    public boolean c() {
        ws wsVar = this.xj;
        if (wsVar == null) {
            return true;
        }
        int c = pz.hf().c(wo.d(wsVar));
        if (c == 1) {
            return am.u(this.hf);
        }
        if (c == 2) {
            return am.kd(this.hf) || am.u(this.hf) || am.y(this.hf);
        }
        if (c != 3) {
            return c != 5 || am.u(this.hf) || am.y(this.hf);
        }
        return false;
    }

    public boolean kd() {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        return cVar.xj();
    }

    public boolean y() {
        c cVar = this.c;
        if (cVar == null) {
            return false;
        }
        return cVar.hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj, com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hf.xj.w wVar) {
        boolean z;
        hf(this.xj.vw());
        w();
        final xj.InterfaceC0169xj xj = this.kd.xj();
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.xj.w.1
            @Override // java.lang.Runnable
            public void run() {
                xj.InterfaceC0169xj interfaceC0169xj = xj;
                if (interfaceC0169xj != null) {
                    interfaceC0169xj.xj(((com.bytedance.sdk.openadsdk.core.hf.xj.xj) w.this).u, w.this.kd.w());
                }
            }
        });
        Map<String, Object> f = this.kd.f();
        String pz = this.w.pz();
        if (TextUtils.isEmpty(pz)) {
            pz = "clickEvent";
        }
        String str = pz;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        f.put("click_from_uchain", 1);
        f.put("event_type", str);
        wo.x();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.xj);
        hashMap.put("click_chain", wVar);
        hashMap.put("dpa_tag", this.w.jk());
        hashMap.put("context", this.hf);
        hashMap.put("event_tag", this.kd.d());
        hashMap.put(n.l, Integer.valueOf(this.kd.c()));
        hashMap.put("view", this.u);
        View view = this.u;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.u instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        hashMap.put("is_click_button", Boolean.valueOf(z || this.w.xj()));
        hashMap.put("handle_chain_data", map);
        com.bytedance.sdk.openadsdk.core.pl.hf.w y = this.kd.y();
        if (y != null) {
            hashMap.put("download_adapter", y);
            hashMap.put("is_market_covert", Boolean.valueOf(y.w()));
            hashMap.putAll(y.kd());
        }
        Map<String, Object> xj2 = com.bytedance.sdk.component.p.kd.xj.xj().xj(this.xj.hashCode() + this.xj.zf());
        this.c = (c) ht.xj(this.xj.ko(), c.class);
        Object remove = xj2.remove("is_express_ad");
        if (remove instanceof Boolean) {
            this.f = ((Boolean) remove).booleanValue();
        }
        hashMap.put("is_video_lp", Boolean.valueOf(f()));
        hashMap.putAll(xj2);
        Boolean bool = Boolean.FALSE;
        hashMap.put("convert_from_downloader", bool);
        hashMap.put("convert_from_landing_page", Boolean.valueOf(this.kd.hf()));
        hashMap.put("pip_controller", this.kd.pl());
        com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj(this.xj, this.hf, this.kd.d(), this.kd.c());
        xjVar.xj(!f() && this.kd.u());
        xjVar.hf(this.kd.tf());
        hashMap.put("is_open_web_page", bool);
        xjVar.hf(hashMap);
        hashMap.put("activity_type", Integer.valueOf(wo.xj(xjVar.xj())));
        hashMap.put("is_feed_register_direct_download", Boolean.valueOf(this.w.xj()));
        com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(this.xj, f, str, hashMap, this.kd.d(), new HashMap());
        u();
        return 0;
    }
}
