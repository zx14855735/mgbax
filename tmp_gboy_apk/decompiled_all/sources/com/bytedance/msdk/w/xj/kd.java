package com.bytedance.msdk.w.xj;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends u {
    public kd(com.bytedance.msdk.w.y.hf.xj xjVar) {
        super(xjVar);
    }

    private com.bytedance.msdk.api.u.xj.u.xj zf() {
        return (com.bytedance.msdk.api.u.xj.u.xj) this.c;
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean ew() {
        Object apply;
        if (((u) this).d == null) {
            return super.ew();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8211, Boolean.class));
        return apply instanceof Boolean ? ((Boolean) apply).booleanValue() : super.ew();
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        Object apply;
        if (((u) this).d == null) {
            return super.ir();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8147, String.class));
        if (apply instanceof String) {
            return (String) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, Object obj, String str) {
        super.xj(activity, obj, str);
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8113).xj(Void.class).xj(20033, activity).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        return com.bytedance.msdk.core.xj.xj.kd.xj(gh(), ((u) this).d);
    }

    @Override // com.bytedance.msdk.w.xj.u
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String str;
        if (i == 8143) {
            return (T) Double.valueOf(da());
        }
        if (i == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!mq() && !vi()) {
                return null;
            }
            xj(pluginValueSet.doubleValue(8016));
            return null;
        }
        int i2 = 0;
        if (i == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            c(pluginValueSet.booleanValue(8033, false));
            return null;
        }
        if (i == 1008) {
            if (zf() == null) {
                return null;
            }
            zf().g_();
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
        if (i == 1009) {
            if (zf() == null) {
                return null;
            }
            zf().h_();
            return null;
        }
        if (i == 1014) {
            if (zf() == null) {
                return null;
            }
            zf().w();
            return null;
        }
        if (i == 1026) {
            if (zf() == null) {
                return null;
            }
            zf().u();
            return null;
        }
        if (i == 1021) {
            if (zf() == null) {
                return null;
            }
            zf().kd();
            return null;
        }
        if (i == 1037) {
            if (zf() == null) {
                return null;
            }
            zf().y();
            return null;
        }
        if (i != 1018 || zf() == null) {
            return null;
        }
        final boolean booleanValue = pluginValueSet.booleanValue(8017);
        final float intValue = pluginValueSet.intValue(8018);
        final String stringValue = pluginValueSet.stringValue(8019);
        zf().xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.xj.kd.1
            @Override // com.bytedance.msdk.api.w.xj
            public float hf() {
                return intValue;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public Map<String, Object> u() {
                return null;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public String w() {
                return stringValue;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public boolean xj() {
                return booleanValue;
            }
        });
        return null;
    }
}
