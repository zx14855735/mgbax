package com.bytedance.msdk.w.xj;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends u {
    public w(com.bytedance.msdk.w.y.hf.xj xjVar) {
        super(xjVar);
    }

    private com.bytedance.msdk.api.u.xj.xj.xj zf() {
        return (com.bytedance.msdk.api.u.xj.xj.xj) this.c;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        Object apply;
        if (((u) this).d == null) {
            return super.d();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(6081, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
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
    public boolean jk() {
        Object apply;
        try {
            if (((u) this).d != null) {
                apply = ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8135).xj(Boolean.class).hf());
                if (apply instanceof Boolean) {
                    return ((Boolean) apply).booleanValue();
                }
                return false;
            }
        } catch (Exception unused) {
        }
        return super.jk();
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar, List<View> list4) {
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8159).xj(Void.class).xj(20033, activity).xj(8067, viewGroup).xj(8068, list).xj(8069, list2).xj(8070, list3).xj(8071, tf.xj(tfVar)).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        return com.bytedance.msdk.core.xj.xj.kd.xj(gh(), ((u) this).d);
    }

    @Override // com.bytedance.msdk.w.xj.u
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 1008) {
            if (!(this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj)) {
                return null;
            }
            zf().hf(null);
            return null;
        }
        if (i != 1009) {
            if (i != 1014) {
                if (i == 1016) {
                    boolean z = this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj;
                } else if (i == 8111) {
                    xj(pluginValueSet.doubleValue(8016));
                } else if (i == 8140) {
                    String stringValue = pluginValueSet.stringValue(8045);
                    String stringValue2 = pluginValueSet.stringValue(8046);
                    int intValue = pluginValueSet.intValue(8047);
                    String stringValue3 = pluginValueSet.stringValue(8048);
                    String stringValue4 = pluginValueSet.stringValue(8049);
                    String stringValue5 = pluginValueSet.stringValue(8050);
                    int intValue2 = pluginValueSet.intValue(8051);
                    int intValue3 = pluginValueSet.intValue(8052);
                    List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                    String stringValue6 = pluginValueSet.stringValue(8054);
                    boolean booleanValue = pluginValueSet.booleanValue(8055);
                    String stringValue7 = pluginValueSet.stringValue(8056);
                    String stringValue8 = pluginValueSet.stringValue(8057);
                    Object objectValue = pluginValueSet.objectValue(8036, Object.class);
                    String stringValue9 = pluginValueSet.stringValue(8058);
                    double doubleValue = pluginValueSet.doubleValue(8016);
                    boolean booleanValue2 = pluginValueSet.booleanValue(8033);
                    int intValue4 = pluginValueSet.intValue(8060);
                    String stringValue10 = pluginValueSet.stringValue(8061);
                    String stringValue11 = pluginValueSet.stringValue(8061);
                    long longValue = pluginValueSet.longValue(8078);
                    String stringValue12 = pluginValueSet.stringValue(8079);
                    Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                    String stringValue13 = pluginValueSet.stringValue(8080);
                    String stringValue14 = pluginValueSet.stringValue(8081);
                    double doubleValue2 = pluginValueSet.doubleValue(8082);
                    int intValue5 = pluginValueSet.intValue(8059);
                    String stringValue15 = pluginValueSet.stringValue(8551);
                    String stringValue16 = pluginValueSet.stringValue(8559);
                    j(stringValue);
                    en(stringValue2);
                    jk(intValue);
                    x(stringValue3);
                    l(stringValue4);
                    ai(stringValue5);
                    v(intValue2);
                    yo(intValue3);
                    xj(list);
                    z(stringValue6);
                    f(booleanValue);
                    ht(stringValue7);
                    ra(stringValue8);
                    if (TextUtils.equals(lw(), "baidu")) {
                        xj(MediationConstant.BAIDU_DISLIKE_INFO, objectValue);
                    }
                    am(stringValue9);
                    xj(doubleValue);
                    c(booleanValue2);
                    p(intValue4);
                    pl(intValue5);
                    q(stringValue10);
                    pz(stringValue11);
                    hf(longValue);
                    dk(stringValue12);
                    kd(map);
                    et(stringValue13);
                    io(stringValue14);
                    u(doubleValue2);
                    pl(stringValue15);
                    tf(stringValue16);
                } else if (i == 8207) {
                    am(pluginValueSet.stringValue(8058));
                }
            } else if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
                com.bytedance.msdk.w.y.hf.xj xjVar = ((u) this).tf;
                if (xjVar != null) {
                    com.bytedance.msdk.core.hf.xj.xj(xjVar.hf());
                }
                zf().f_();
            }
        } else if (this.c instanceof com.bytedance.msdk.api.u.xj.xj.xj) {
            zf().xj((View) null);
            return null;
        }
        return null;
    }
}
