package com.bytedance.msdk.w.w.hf.xj;

import ADYaiT.BpkvW3;
import ADYaiT.CtFAbx;
import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.core.xj.xj.kd;
import com.bytedance.msdk.w.xj.c;
import com.bytedance.msdk.w.xj.d;
import com.bytedance.msdk.w.xj.f;
import com.bytedance.msdk.w.xj.y;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private tf c;
    private int hf;
    private com.bytedance.msdk.w.y.hf.hf kd;
    private Function<SparseArray<Object>, Object> u;
    private int w;
    private w xj;
    private com.bytedance.msdk.api.xj.hf y;

    public xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, w wVar) {
        this.hf = hfVar.ht();
        this.y = hfVar;
        this.w = hfVar2.qt();
        this.kd = hfVar2;
        this.xj = wVar;
        this.c = hfVar2.f();
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        Object apply2;
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        Class cls = (Class) ADYaiT2.objectValue(-99999985, Class.class);
        if (intValue == 8108) {
            this.xj.xj(new com.bytedance.msdk.api.xj(ADYaiT2.intValue(8014, 0), ADYaiT2.stringValue(8015, null)));
        } else if (intValue == 8112) {
            Function AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(8303, AaHO0E.ARc23Z()));
            int intValue2 = ADYaiT2.intValue(8014, 0);
            String stringValue = ADYaiT2.stringValue(8015, null);
            ArrayList arrayList = new ArrayList(1);
            if (AYUAbz2 instanceof com.bytedance.msdk.hf.w) {
                arrayList.add((com.bytedance.msdk.hf.w) AYUAbz2);
            } else if (CtFAbx.B9tovu(AYUAbz2)) {
                apply2 = AYUAbz2.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(-99999977).hf());
                if (apply2 instanceof com.bytedance.msdk.hf.w) {
                    arrayList.add((com.bytedance.msdk.hf.w) apply2);
                }
            }
            this.xj.xj(arrayList, new com.bytedance.msdk.api.xj(intValue2, stringValue));
        } else if (intValue == 8107) {
            List list = (List) ADYaiT2.objectValue(8303, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.bytedance.msdk.hf.w) {
                        arrayList2.add((com.bytedance.msdk.hf.w) obj);
                    } else if (BpkvW3.BmvVmW(obj)) {
                        apply = AaHO0E.AYUAbz(obj).apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(-99999977).hf());
                        if (apply instanceof com.bytedance.msdk.hf.w) {
                            arrayList2.add((com.bytedance.msdk.hf.w) apply);
                        }
                    }
                }
            }
            this.xj.xj(arrayList2);
        } else {
            if (intValue == 8127) {
                return xj();
            }
            if (intValue == 8110) {
                return Boolean.valueOf(this.kd.xj());
            }
            if (intValue == 8136) {
                return Boolean.valueOf(this.kd.ra());
            }
            if (intValue == 8141) {
                return Boolean.valueOf(this.kd.dk());
            }
            if (intValue == 8137) {
                return this.kd.et();
            }
            if (intValue == 8226) {
                return Integer.valueOf(this.kd.v());
            }
            if (intValue == 8138) {
                this.u = AaHO0E.AYUAbz(ADYaiT2.objectValue(8043, AaHO0E.ARc23Z()));
            } else {
                if (intValue == 8210) {
                    return Boolean.valueOf(this.xj.xj());
                }
                if (intValue == 20000) {
                    Function<SparseArray<Object>, Object> AYUAbz3 = AaHO0E.AYUAbz(ADYaiT2.objectValue(10010, AaHO0E.ARc23Z()));
                    String str = (String) ADYaiT2.objectValue(10011, String.class);
                    Context context = (Context) ADYaiT2.objectValue(10000, Context.class);
                    if (AYUAbz3 == null || TextUtils.isEmpty(str) || this.y == null || this.c == null) {
                        kd.hf(this.y);
                    } else {
                        com.bytedance.msdk.core.xj.xj.xj.xj hf = kd.hf(str, this.hf, this.w);
                        if (hf != null) {
                            kd.xj(this.y);
                            hf.xj(context, AYUAbz3, this.y, this.c, new com.bytedance.msdk.core.xj.xj.xj.hf() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.1
                                @Override // com.bytedance.msdk.core.xj.xj.xj.hf
                                public void xj(List<com.bytedance.msdk.hf.w> list2) {
                                    if (xj.this.xj != null) {
                                        xj.this.xj.xj(list2);
                                    }
                                }

                                @Override // com.bytedance.msdk.core.xj.xj.xj.hf
                                public void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj xjVar) {
                                    if (xj.this.xj != null) {
                                        xj.this.xj.xj(wVar, xjVar);
                                    }
                                }

                                @Override // com.bytedance.msdk.core.xj.xj.xj.hf
                                public void xj(int i, String str2) {
                                    if (xj.this.xj != null) {
                                        xj.this.xj.xj(new com.bytedance.msdk.api.xj(i, str2));
                                    }
                                }
                            });
                        } else {
                            kd.hf(this.y);
                        }
                    }
                }
            }
        }
        return com.bytedance.msdk.core.zg.xj.xj(cls);
    }

    public String xj(Context context, String str, Object obj) {
        Object apply;
        if (this.u == null) {
            return null;
        }
        apply = this.u.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8139).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str).xj(8044, obj).xj(String.class).hf());
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    private com.bytedance.msdk.hf.w xj() {
        switch (this.hf) {
            case 1:
                return new com.bytedance.msdk.w.xj.w(this.kd);
            case 2:
                return new y(this.kd);
            case 3:
                return new d(this.kd);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i = this.w;
                if (i == 4) {
                    return new c(this.kd, this.xj);
                }
                if (i == 3) {
                    return new com.bytedance.msdk.w.xj.w(this.kd);
                }
                if (i == 5) {
                    return new c(this.kd, this.xj);
                }
                return new c(this.kd, this.xj);
            case 7:
                int i2 = this.w;
                if (i2 == 6) {
                    return new f(this.kd);
                }
                if (i2 == 7) {
                    return new com.bytedance.msdk.w.xj.kd(this.kd);
                }
                return new f(this.kd);
            case 8:
                return new com.bytedance.msdk.w.xj.kd(this.kd);
            case 9:
                return new c(this.kd, this.xj);
            case 10:
                int i3 = this.w;
                if (i3 == 1) {
                    return new y(this.kd);
                }
                if (i3 == 2) {
                    return new com.bytedance.msdk.w.xj.kd(this.kd);
                }
                return null;
        }
    }
}
