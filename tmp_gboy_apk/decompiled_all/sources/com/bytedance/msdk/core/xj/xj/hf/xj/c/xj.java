package com.bytedance.msdk.core.xj.xj.hf.xj.c;

import IzHBwY.AYUAbz;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.core.wo.u;
import com.czhj.sdk.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.c.xj$xj, reason: collision with other inner class name */
    public static class C0061xj extends u {
        private hf hf;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0061xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
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
            if (i != 60000) {
                if (i != 60001 || this.xj == null) {
                    return null;
                }
                com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
                if (hfVar.xj() != 4004 && hfVar.xj() != 4005) {
                    this.xj.xj(hfVar.xj(), hfVar.hf());
                    return null;
                }
                hf hfVar2 = this.hf;
                if (hfVar2 == null) {
                    return null;
                }
                hfVar2.xj(hfVar);
                return null;
            }
            Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
            long longValue = pluginValueSet.longValue(50012) - SystemClock.elapsedRealtime();
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar = this.xj;
            if (xjVar == null || longValue <= 1000) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        kd();
        w(context);
        u();
        y();
    }

    private void kd() {
        HashMap hashMap = new HashMap();
        d hf = com.bytedance.msdk.core.xj.p().ra().hf();
        if (hf != null) {
            hashMap.put("lng", String.valueOf(hf.hf()));
            hashMap.put("lat", String.valueOf(hf.xj()));
            hashMap.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (!this.xj.v()) {
            hashMap.put("shakable", Constants.FAIL);
        }
        if (hashMap.size() > 0) {
            AYUAbz.A4TApA().ARc23Z(50010, hashMap);
            Function<SparseArray<Object>, Object> function = this.w;
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40025).xj(Void.class).hf());
            }
        }
    }

    private void u() {
        if (this.xj.jk() || this.w == null) {
            return;
        }
        this.w.apply(A2egSU.ARc23Z(40026, Void.class));
    }

    private void w(Context context) {
        if (this.w != null) {
            int e = this.xj.e();
            if (e < 0) {
                e = 3000;
            } else if (e > 5000) {
                e = 5000;
            }
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40024).xj(50000, this.hf.yo()).xj(50011, Integer.valueOf(e)).xj(10000, context).xj(Void.class).hf());
        }
    }

    private void y() {
        tf tfVar;
        if (this.w == null || (tfVar = this.hf) == null) {
            return;
        }
        int tf = tfVar.tf();
        if (tf == 2) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40027).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0061xj(this)).xj(Void.class).hf());
        } else if (tf == 0 || tf == 1) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40028).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0061xj(this)).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.c.xj.1
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
