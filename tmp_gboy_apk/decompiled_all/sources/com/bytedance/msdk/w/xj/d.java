package com.bytedance.msdk.w.xj;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends u {
    private com.bytedance.msdk.xj.hf.y p;

    public d(com.bytedance.msdk.w.y.hf.xj xjVar) {
        super(xjVar);
    }

    private com.bytedance.msdk.xj.hf.kd zf() {
        return (com.bytedance.msdk.xj.hf.kd) this.c;
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        Object apply;
        if (((u) this).d == null) {
            return super.ir();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8147, String.class));
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(ViewGroup viewGroup) {
        super.xj(viewGroup);
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6152).xj(Void.class).xj(20060, viewGroup).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        return com.bytedance.msdk.core.xj.xj.kd.xj(gh(), ((u) this).d);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(ViewGroup viewGroup, Activity activity) {
        super.xj(viewGroup, activity);
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6154).xj(Void.class).xj(20060, viewGroup).xj(20033, activity).hf());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.msdk.w.xj.u
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String str;
        if (i == 8143) {
            return (T) Double.valueOf(da());
        }
        int i2 = 0;
        if (i == 1009) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.xj.hf.y yVar = this.p;
                if (!(yVar instanceof com.bytedance.msdk.api.u.xj.d.hf)) {
                    return null;
                }
                ((com.bytedance.msdk.api.u.xj.d.hf) yVar).u();
                return null;
            }
            if (zf() == null) {
                return null;
            }
            zf().u();
            return null;
        }
        if (i == 1017) {
            if (zf() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                i2 = pluginValueSet.intValue(8014, 0);
                str = pluginValueSet.stringValue(8015);
            } else {
                str = "";
            }
            zf().xj(new com.bytedance.msdk.api.xj(i2, str));
            return null;
        }
        if (i == 1011) {
            boolean booleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (booleanValue) {
                com.bytedance.msdk.xj.hf.y yVar2 = this.p;
                if (!(yVar2 instanceof com.bytedance.msdk.api.u.xj.d.hf)) {
                    return null;
                }
                ((com.bytedance.msdk.api.u.xj.d.hf) yVar2).hf(2);
                return null;
            }
            if (zf() == null) {
                return null;
            }
            zf().hf(2);
            return null;
        }
        if (i == 1008) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.bytedance.msdk.xj.hf.y yVar3 = this.p;
                if (!(yVar3 instanceof com.bytedance.msdk.api.u.xj.d.hf)) {
                    return null;
                }
                ((com.bytedance.msdk.api.u.xj.d.hf) yVar3).kd();
                return null;
            }
            if (zf() == null) {
                return null;
            }
            zf().kd();
            return null;
        }
        if (i == 1019) {
            boolean booleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (booleanValue2) {
                com.bytedance.msdk.xj.hf.y yVar4 = this.p;
                if (!(yVar4 instanceof com.bytedance.msdk.api.u.xj.d.hf)) {
                    return null;
                }
                ((com.bytedance.msdk.api.u.xj.d.hf) yVar4).xj(1);
                return null;
            }
            if (zf() == null) {
                return null;
            }
            zf().xj(1);
            return null;
        }
        if (i == 1074) {
            if (zf() != null) {
                return (T) zf().getActivity();
            }
            return null;
        }
        if (i == 1051) {
            zf();
            return null;
        }
        if (i == 1052) {
            zf();
            return null;
        }
        if (i == 6156) {
            if (zf() == null) {
                return null;
            }
            zf().w();
            return null;
        }
        if (i != 8111) {
            return null;
        }
        xj(pluginValueSet.doubleValue(8016));
        return null;
    }
}
