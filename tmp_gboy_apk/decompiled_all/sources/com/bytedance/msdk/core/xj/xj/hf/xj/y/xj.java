package com.bytedance.msdk.core.xj.xj.hf.xj.y;

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
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.y.xj$xj, reason: collision with other inner class name */
    public static class C0067xj extends u {
        private w hf;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0067xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
            this.xj = xjVar;
        }

        private void xj(Function<SparseArray<Object>, Object> function) {
            if (this.hf != null || function == null) {
                return;
            }
            this.hf = new w(this.xj, function);
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.u
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60000) {
                Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
                com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.xj;
                if (xjVar != null) {
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
            } else if (i == 60001) {
                if (this.xj != null) {
                    hf hfVar = new hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
                    this.xj.xj(hfVar.xj(), hfVar.hf());
                    return null;
                }
            } else if (i == 60003) {
                Function<SparseArray<Object>, Object> AYUAbz3 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
                com.bytedance.msdk.core.xj.xj.hf.xj xjVar2 = this.xj;
                if (xjVar2 != null) {
                    if (AYUAbz3 != null) {
                        xj(AYUAbz3);
                        this.xj.xj(this.hf, (com.bytedance.msdk.api.xj) null);
                        return null;
                    }
                    xjVar2.xj(-999, "adn return data is null");
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        u();
        w(context);
        kd();
        y();
    }

    private void kd() {
        if (this.w != null) {
            com.bytedance.sdk.openadsdk.zg.u xj = com.bytedance.sdk.openadsdk.zg.u.xj().xj(40001).xj(50003, this.xj.en()).xj(Void.class);
            Map<String, Object> r = this.xj.r();
            if (r != null && r.get("gdt") != null) {
                xj.xj(50004, String.valueOf(r.get("gdt")));
            }
            this.w.apply(xj.hf());
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
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40025).xj(Void.class).xj(50010, hashMap).hf());
    }

    private void w(Context context) {
        if (this.w != null) {
            this.w.apply(A2egSU.AZOQYO(40000, Void.class).xj(50001, Boolean.valueOf(this.xj.ff())).xj(50002, hf()).xj(50000, this.hf.yo()).xj(10000, context).hf());
        }
    }

    private void y() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40002).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0067xj(this)).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.y.xj.1
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
