package com.bytedance.msdk.w.w.hf.xj.xj;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends hf {
    private com.bytedance.msdk.w.xj.xj.w d;

    public y(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(str, hfVar);
    }

    public void am() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.4
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.kd.xj xjVar = (com.bytedance.msdk.api.u.xj.kd.xj) y.this.d.kr();
                    if (xjVar != null) {
                        xjVar.u();
                    }
                }
            });
        }
    }

    public void kd() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.3
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.kd.xj xjVar = (com.bytedance.msdk.api.u.xj.kd.xj) y.this.d.kr();
                    if (xjVar != null) {
                        xjVar.w();
                    }
                }
            });
        }
    }

    public void qt() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.5
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.kd.xj xjVar = (com.bytedance.msdk.api.u.xj.kd.xj) y.this.d.kr();
                    if (xjVar != null) {
                        xjVar.kd();
                    }
                }
            });
        }
    }

    public void u() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.2
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    y.this.w(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.2.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.kd.xj xjVar = (com.bytedance.msdk.api.u.xj.kd.xj) y.this.d.kr();
                            if (xjVar != null) {
                                xjVar.hf();
                            }
                        }
                    });
                }
            });
        }
    }

    public void w() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.1
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    y.this.hf(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.y.1.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.kd.xj xjVar = (com.bytedance.msdk.api.u.xj.kd.xj) y.this.d.kr();
                            if (xjVar != null) {
                                xjVar.xj();
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
        com.bytedance.msdk.w.xj.xj.c cVar = new com.bytedance.msdk.w.xj.xj.c(this, ((hf) this).w);
        this.d = cVar;
        xj(cVar, d, map);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.xj.hf
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double d;
        Map<String, Object> map;
        if (i == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            xj(intValue, stringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                d = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d = 0.0d;
                map = null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callLoadSucceed price:" + d + " mextraMsg:" + map);
            xj(d, map);
        } else if (i == 1008) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialShow");
            w();
        } else if (i == 1009) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdClick");
            u();
        } else if (i == 1014) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialClosed");
            kd();
        } else if (i == 1015) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdOpened");
            am();
        } else if (i == 1016) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            qt();
        }
        return null;
    }
}
