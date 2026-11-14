package com.bytedance.msdk.core.xj.xj.hf.xj.hf;

import IzHBwY.AYUAbz;
import P8ccfD.AaHO0E;
import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.core.wo.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.hf.xj$xj, reason: collision with other inner class name */
    public static class C0062xj extends u {
        private Context hf;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0062xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
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
                arrayList.add(new hf(this.hf, this.xj, AaHO0E.AYUAbz(it.next())));
            }
            this.xj.xj(arrayList);
            return null;
        }

        public void xj(Context context) {
            this.hf = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        u();
        u(context);
        kd();
        y();
        w(context);
    }

    private void kd() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40019).xj(50010, this.xj.r()).xj(Void.class).hf());
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
        if (hashMap.size() > 0) {
            AYUAbz.A4TApA().ARc23Z(50010, hashMap);
            if (this.w != null) {
                this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40025).xj(50010, hashMap).xj(Void.class).hf());
            }
        }
    }

    private void w(Context context) {
        if (this.w == null || this.xj == null) {
            return;
        }
        C0062xj c0062xj = new C0062xj(this);
        c0062xj.xj(context);
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40037).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, c0062xj).xj(10013, Integer.valueOf(this.xj.x())).xj(Void.class).hf());
    }

    private void y() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40020).xj(50010, this.xj.r()).xj(Void.class).hf());
        }
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.hf.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf(context);
                }
            });
        } else {
            hf(context);
        }
    }

    private void u(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40036).xj(50000, this.hf.yo()).xj(10000, context).xj(Void.class).hf());
        }
    }
}
