package com.bytedance.msdk.w.w.hf.xj.xj;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf {
    private com.bytedance.msdk.w.xj.xj.w d;

    public xj(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(str, hfVar);
    }

    public void kd() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.xj.3
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.xj.xj xjVar = (com.bytedance.msdk.api.u.xj.xj.xj) xj.this.d.kr();
                    if (xjVar != null) {
                        xjVar.f_();
                    }
                }
            });
        }
    }

    public void u() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.xj.2
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    xj.this.w(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.xj.2.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.xj.xj xjVar = (com.bytedance.msdk.api.u.xj.xj.xj) xj.this.d.kr();
                            if (xjVar != null) {
                                xjVar.xj((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void w() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.xj.1
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.xj.xj xjVar = (com.bytedance.msdk.api.u.xj.xj.xj) xj.this.d.kr();
                    if (xjVar != null) {
                        xjVar.hf(null);
                    }
                }
            });
        }
    }

    public void xj(double d, Map<String, Object> map) {
        if (hf()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
        com.bytedance.msdk.w.xj.xj.hf hfVar = new com.bytedance.msdk.w.xj.xj.hf(this, ((hf) this).w);
        this.d = hfVar;
        hfVar.w(this.kd);
        this.d.am(this.u.io());
        if (d > 0.0d && d() == 1) {
            this.d.xj(d);
        }
        if (map != null) {
            this.kd.putAll(map);
        }
        this.d.u(this.kd);
        xj(this.d);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.xj.hf
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double d;
        Map<String, Object> map;
        if (i == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom banner loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            xj(intValue, stringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                d = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d = 0.0d;
                map = null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom banner loader : callLoadSucceed price:" + d + " mextraMsg:" + map);
            xj(d, map);
        } else if (i == 1008) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom banner loader : callBannerAdShow");
            w();
        } else if (i == 1009) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClick");
            u();
        } else if (i == 1014) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom banner loader : callBannerAdClosed");
            kd();
        }
        return null;
    }
}
