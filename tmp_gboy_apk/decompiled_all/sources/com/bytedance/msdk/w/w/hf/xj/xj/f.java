package com.bytedance.msdk.w.w.hf.xj.xj;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.hf.xj;
import com.bytedance.msdk.w.xj.xj.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends hf {
    private com.bytedance.msdk.w.xj.xj.w d;

    public f(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(str, hfVar);
    }

    public void am() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.4
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.d.hf hfVar = (com.bytedance.msdk.api.u.xj.d.hf) f.this.d.kr();
                    if (hfVar != null) {
                        hfVar.hf(2);
                    }
                }
            });
        }
    }

    public void kd() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.3
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.d.hf hfVar = (com.bytedance.msdk.api.u.xj.d.hf) f.this.d.kr();
                    if (hfVar != null) {
                        hfVar.xj(1);
                    }
                }
            });
        }
    }

    public void u() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.2
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    f.this.hf(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.2.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.d.hf hfVar = (com.bytedance.msdk.api.u.xj.d.hf) f.this.d.kr();
                            if (hfVar != null) {
                                hfVar.kd();
                            }
                        }
                    });
                }
            });
        }
    }

    public void w() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.1
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    f.this.w(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.f.1.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.d.hf hfVar = (com.bytedance.msdk.api.u.xj.d.hf) f.this.d.kr();
                            if (hfVar != null) {
                                hfVar.u();
                            }
                        }
                    });
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
        tf tfVar = new tf(this, ((hf) this).w);
        this.d = tfVar;
        xj(tfVar, d, map);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.xj.hf
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double d;
        Map<String, Object> map;
        if (i == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            xj(intValue, stringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                d = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d = 0.0d;
                map = null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callLoadSucceed price:" + d + " mextraMsg:" + map);
            xj(d, map);
        } else if (i == 1009) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callSplashAdClicked");
            w();
        } else if (i == 1008) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callSplashAdShow");
            u();
        } else if (i == 1019) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callSplashAdSkip");
            kd();
        } else if (i == 1011) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom splash loader : callSplashAdDismiss");
            am();
        }
        return null;
    }
}
