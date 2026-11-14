package com.bytedance.msdk.core.xj.xj.hf.xj.w;

import P8ccfD.AaHO0E;
import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.core.wo.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.w.xj$xj, reason: collision with other inner class name */
    public static class C0065xj extends u {
        private Context hf;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0065xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
            this.xj = xjVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.u
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i != 60000) {
                if (i != 60001 || this.xj == null) {
                    return null;
                }
                com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
                this.xj.xj(hfVar.xj(), hfVar.hf());
                return null;
            }
            List list = (List) pluginValueSet.objectValue(50015, List.class);
            if (this.xj == null) {
                return null;
            }
            if (list == null || list.size() <= 0) {
                this.xj.xj(-999, "adn return data is null");
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Function AYUAbz2 = AaHO0E.AYUAbz(it.next());
                if (this.xj.xj()) {
                    arrayList.add(new w(this.xj, AYUAbz2));
                } else {
                    arrayList.add(new hf(this.hf, this.xj, AYUAbz2));
                }
            }
            this.xj.xj(arrayList);
            return null;
        }

        public void xj(Context context) {
            this.hf = context;
        }
    }

    private void c(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40030).xj(50000, this.hf.yo()).xj(10000, context).xj(50002, hf()).xj(Void.class).hf());
        }
    }

    private void d() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40020, Void.class).xj(50010, this.xj.r()).hf());
        }
    }

    private void f() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40019, Void.class).xj(50010, this.xj.r()).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        u();
        if (xj()) {
            y(context);
        } else {
            w(context);
        }
    }

    private void kd(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40036).xj(50000, this.hf.yo()).xj(10000, context).xj(50002, hf()).xj(Void.class).hf());
        }
    }

    private void u() {
        HashMap hashMap = new HashMap();
        d hf = com.bytedance.msdk.core.xj.p().ra().hf();
        if (hf != null) {
            hashMap.put("lng", String.valueOf(hf.hf()));
            hashMap.put("lat", String.valueOf(hf.xj()));
            hashMap.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (hashMap.isEmpty() || this.w == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40025).xj(50010, hashMap).xj(Void.class).hf());
    }

    private void w(Context context) {
        if (this.hf != null) {
            kd(context);
            f();
            d();
            u(context);
        }
    }

    private void y(Context context) {
        if (this.hf != null) {
            y();
            c(context);
            f();
            d();
            c();
            kd();
        }
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.w.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf(context);
                }
            });
        } else {
            hf(context);
        }
    }

    private void y() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40031).xj(50014, Integer.valueOf((int) this.xj.am())).xj(Void.class).hf());
        }
    }

    private void c() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40018).xj(50010, this.xj.r()).xj(Void.class).hf());
        }
    }

    private void kd() {
        if (this.w == null || this.xj == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40002).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0065xj(this)).xj(10013, Integer.valueOf(this.xj.x())).xj(Void.class).hf());
    }

    private void u(Context context) {
        if (this.w == null || this.xj == null) {
            return;
        }
        C0065xj c0065xj = new C0065xj(this);
        c0065xj.xj(context);
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40037).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, c0065xj).xj(10013, Integer.valueOf(this.xj.x())).xj(Void.class).hf());
    }
}
