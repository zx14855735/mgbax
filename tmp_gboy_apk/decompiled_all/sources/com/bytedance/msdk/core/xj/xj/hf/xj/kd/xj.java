package com.bytedance.msdk.core.xj.xj.hf.xj.kd;

import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.core.wo.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.kd.xj$xj, reason: collision with other inner class name */
    public static class C0063xj extends u {
        private hf hf;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0063xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
            this.xj = xjVar;
        }

        private void xj(Function<SparseArray<Object>, Object> function) {
            if (this.hf != null || function == null) {
                return;
            }
            this.hf = new hf(this.xj, function);
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.u
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i != 60008) {
                if (i != 60001 || this.xj == null) {
                    return null;
                }
                com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
                this.xj.xj(hfVar.xj(), hfVar.hf());
                return null;
            }
            Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.xj;
            if (xjVar == null) {
                return null;
            }
            if (AYUAbz2 == null) {
                xjVar.xj(-999, "adn return data is null");
                return null;
            }
            xj(AYUAbz2);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hf);
            this.xj.xj(arrayList);
            return null;
        }
    }

    private void c() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40018, Void.class).xj(50010, this.xj.r()).hf());
        }
    }

    private void f() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40002, Void.class).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0063xj(this)).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        u();
        w(context);
        c();
        kd();
        y();
        f();
    }

    private void kd() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40019, Void.class).xj(50010, this.xj.r()).hf());
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
        if (hashMap.size() <= 0 || this.w == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40025).xj(Void.class).xj(50010, hashMap).hf());
    }

    private void w(Context context) {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40017, Void.class).xj(50000, this.hf.yo()).xj(10000, context).hf());
        }
    }

    private void y() {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40020, Void.class).xj(50010, this.xj.r()).hf());
        }
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.kd.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf(context);
                }
            });
        } else {
            hf(context);
        }
    }
}
