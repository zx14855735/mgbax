package com.bytedance.msdk.core.xj.xj.hf.xj.xj;

import P8ccfD.AaHO0E;
import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.d;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.xj.kd.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.msdk.core.xj.xj.hf.xj {

    /* renamed from: com.bytedance.msdk.core.xj.xj.hf.xj.xj.xj$xj, reason: collision with other inner class name */
    public static class C0066xj extends com.bytedance.sdk.openadsdk.core.wo.u {
        private volatile boolean hf = false;
        private u w;
        private com.bytedance.msdk.core.xj.xj.hf.xj xj;

        public C0066xj(com.bytedance.msdk.core.xj.xj.hf.xj xjVar) {
            this.xj = xjVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.u
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar;
            if (i == 60008) {
                if (this.hf) {
                    return null;
                }
                this.hf = true;
                Function AYUAbz2 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
                com.bytedance.msdk.core.xj.xj.hf.xj xjVar2 = this.xj;
                if (xjVar2 == null) {
                    return null;
                }
                if (AYUAbz2 == null) {
                    xjVar2.xj(-999, "adn return data is null");
                    return null;
                }
                hf hfVar = new hf(xjVar2, AYUAbz2);
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(hfVar);
                this.xj.xj(arrayList);
                return null;
            }
            if (i == 60001) {
                if (this.hf) {
                    return null;
                }
                this.hf = true;
                if (this.xj == null) {
                    return null;
                }
                com.bytedance.msdk.core.xj.xj.hf.xj.y.hf hfVar2 = new com.bytedance.msdk.core.xj.xj.hf.xj.y.hf(AaHO0E.AYUAbz(pluginValueSet.objectValue(50006, AaHO0E.ARc23Z())));
                this.xj.xj(hfVar2.xj(), hfVar2.hf());
                return null;
            }
            if (i != 60000) {
                if (i != 60017 || (xjVar = this.xj) == null) {
                    return null;
                }
                if (this.w == null) {
                    xjVar.xj(-999, "adn return data is null");
                    return null;
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(this.w);
                this.xj.xj(arrayList2);
                return null;
            }
            Function AYUAbz3 = AaHO0E.AYUAbz(pluginValueSet.objectValue(50005, AaHO0E.ARc23Z()));
            if (AYUAbz3 == null) {
                com.bytedance.msdk.core.xj.xj.hf.xj xjVar3 = this.xj;
                if (xjVar3 == null) {
                    return null;
                }
                xjVar3.xj(-999, "adn return data is null");
                return null;
            }
            if (this.xj.xj()) {
                u uVar = new u(this.xj, AYUAbz3);
                this.w = uVar;
                uVar.p();
                return null;
            }
            com.bytedance.msdk.core.xj.xj.hf.xj xjVar4 = this.xj;
            if (xjVar4 == null) {
                return null;
            }
            w wVar = new w(xjVar4, AYUAbz3);
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(wVar);
            this.xj.xj(arrayList3);
            return null;
        }
    }

    private void c() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40031).xj(50014, Integer.valueOf((int) this.xj.am())).xj(Void.class).hf());
        }
    }

    private void d() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40019).xj(50010, this.xj.r()).xj(Void.class).hf());
        }
    }

    private void f() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40018).xj(50010, this.xj.r()).xj(Void.class).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Context context) {
        u();
        tf tfVar = this.hf;
        if (tfVar != null) {
            if (tfVar.y() != 4) {
                c(context);
                return;
            }
            int tf = this.hf.tf();
            if (tf == 1) {
                kd(context);
            } else if (tf == 2) {
                w(context);
            } else {
                c(context);
            }
        }
    }

    private void kd() {
        if (this.w == null || this.xj == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40037).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0066xj(this)).xj(10013, 1).xj(Void.class).hf());
    }

    private void p() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40067).xj(50022, 0).xj(Void.class).hf());
        }
    }

    private void pl() {
        if (this.w == null || this.hf == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40002).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0066xj(this)).xj(Void.class).hf());
    }

    private void tf() {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40020).xj(50010, this.xj.r()).xj(Void.class).hf());
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
            u(context);
            d();
            tf();
            kd();
        }
    }

    private void y() {
        if (this.w == null || this.xj == null) {
            return;
        }
        this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40068).xj(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, new C0066xj(this)).xj(10013, 1).xj(Void.class).hf());
    }

    @Override // com.bytedance.msdk.core.xj.xj.hf.xj
    public void xj(final Context context) {
        if (w()) {
            y.u(new Runnable() { // from class: com.bytedance.msdk.core.xj.xj.hf.xj.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf(context);
                }
            });
        } else {
            hf(context);
        }
    }

    private void c(Context context) {
        f(context);
        p();
        pl();
    }

    private void f(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40066).xj(50000, this.hf.yo()).xj(10000, context).xj(Void.class).hf());
        }
    }

    private void kd(Context context) {
        if (this.hf != null) {
            c();
            y(context);
            d();
            tf();
            f();
            y();
        }
    }

    private void y(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40030).xj(50000, this.hf.yo()).xj(10000, context).xj(50002, hf()).xj(Void.class).hf());
        }
    }

    private void u(Context context) {
        if (this.w != null) {
            this.w.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(40036).xj(50000, this.hf.yo()).xj(10000, context).xj(50002, hf()).xj(Void.class).hf());
        }
    }
}
