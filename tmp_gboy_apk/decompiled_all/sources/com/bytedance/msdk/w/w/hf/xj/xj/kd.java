package com.bytedance.msdk.w.w.hf.xj.xj;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends hf {
    private volatile com.bytedance.msdk.w.xj.xj.w d;

    public kd(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(str, hfVar);
    }

    public void am() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.3
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                    if (xjVar != null) {
                        xjVar.w();
                    }
                }
            });
        }
    }

    public void e() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.6
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                    if (xjVar != null) {
                        xjVar.y();
                    }
                }
            });
        }
    }

    public void kd() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.2
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    kd.this.w(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.2.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                            if (xjVar != null) {
                                xjVar.h_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void qt() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.4
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                    if (xjVar != null) {
                        xjVar.u();
                    }
                }
            });
        }
    }

    public void u() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.1
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    kd.this.hf(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.1.1
                        @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                        public void xj() {
                            com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                            if (xjVar != null) {
                                xjVar.g_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void w() {
        if (this.d == null) {
            this.d = new com.bytedance.msdk.w.xj.xj.y(this, ((hf) this).w);
        }
        xj(this.d, (com.bytedance.msdk.api.xj) null);
    }

    public void zg() {
        if (this.d != null) {
            xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.5
                @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
                public void xj() {
                    com.bytedance.msdk.api.u.xj.u.xj xjVar = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                    if (xjVar != null) {
                        xjVar.kd();
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
        if (this.d == null) {
            this.d = new com.bytedance.msdk.w.xj.xj.y(this, ((hf) this).w);
        }
        xj(this.d, d, map);
    }

    public void xj(final com.bytedance.msdk.api.w.xj xjVar) {
        if (xjVar == null || this.d == null) {
            return;
        }
        xj(new xj.InterfaceC0050xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.7
            @Override // com.bytedance.msdk.api.u.xj.hf.hf.xj.InterfaceC0050xj
            public void xj() {
                com.bytedance.msdk.api.u.xj.u.xj xjVar2 = (com.bytedance.msdk.api.u.xj.u.xj) kd.this.d.kr();
                if (xjVar2 != null) {
                    xjVar2.xj(xjVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.xj.hf
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double d;
        Map<String, Object> map;
        if (i == 8123) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
            xj(intValue, stringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                d = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                d = 0.0d;
                map = null;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callLoadSucceed price:" + d + " mextraMsg:" + map);
            xj(d, map);
        } else if (i == 8112) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callAdVideoCache");
            w();
        } else if (i == 1008) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdShow");
            u();
        } else if (i == 1009) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdClick");
            kd();
        } else if (i == 1014) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdClosed");
            am();
        } else if (i == 1026) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoComplete");
            qt();
        } else if (i == 1021) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoError");
            zg();
        } else if (i == 1037) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoSkippedVideo");
            e();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean booleanValue = pluginValueSet.booleanValue(8017);
            final float floatValue = pluginValueSet.floatValue(8018);
            final String stringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom full loader : callFullVideoRewardVerify rewardVerify:" + booleanValue + " amount:" + floatValue + " name:" + stringValue2 + " map:" + map2);
            xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.w.hf.xj.xj.kd.8
                @Override // com.bytedance.msdk.api.w.xj
                public float hf() {
                    return floatValue;
                }

                @Override // com.bytedance.msdk.api.w.xj
                public Map<String, Object> u() {
                    return map2;
                }

                @Override // com.bytedance.msdk.api.w.xj
                public String w() {
                    return stringValue2;
                }

                @Override // com.bytedance.msdk.api.w.xj
                public boolean xj() {
                    return booleanValue;
                }
            });
            return null;
        }
        return null;
    }
}
