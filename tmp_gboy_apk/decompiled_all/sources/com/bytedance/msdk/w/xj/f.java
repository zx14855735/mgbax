package com.bytedance.msdk.w.xj;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends u {
    public f(com.bytedance.msdk.w.y.hf.xj xjVar) {
        super(xjVar);
    }

    private com.bytedance.msdk.api.u.xj.f.xj jq() {
        return (com.bytedance.msdk.api.u.xj.f.xj) this.f;
    }

    private com.bytedance.msdk.api.u.xj.f.xj zf() {
        return (com.bytedance.msdk.api.u.xj.f.xj) this.c;
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
            return apply.toString();
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
        if (i == 8115) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().j_();
            }
        } else if (i == 8116) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().w();
            }
        } else if (i == 8117) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().kd();
            }
        } else if (i == 8118) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().u();
            }
        } else if (i == 8119) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().y();
            }
        } else if (i == 8230) {
            if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                zf().i_();
            }
        } else {
            if (i == 8231) {
                if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    final boolean booleanValue = pluginValueSet.booleanValue(8017);
                    final float intValue = pluginValueSet.intValue(8018);
                    final String stringValue = pluginValueSet.stringValue(8019);
                    Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                    final HashMap hashMap = new HashMap();
                    if (map != null) {
                        hashMap.putAll(map);
                    }
                    com.bytedance.msdk.api.w.xj xjVar = new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.xj.f.1
                        @Override // com.bytedance.msdk.api.w.xj
                        public float hf() {
                            return intValue;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public Map<String, Object> u() {
                            return hashMap;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public String w() {
                            return stringValue;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public boolean xj() {
                            return booleanValue;
                        }
                    };
                    com.bytedance.sdk.gromore.xj.xj.kd.u.xj(xjVar, "GMRewardAd reward verify");
                    zf().xj(xjVar);
                }
            } else if (i == 1017) {
                if (this.c instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    int i2 = 0;
                    if (pluginValueSet != null) {
                        i2 = pluginValueSet.intValue(8014, 0);
                        str = pluginValueSet.stringValue(8015);
                    } else {
                        str = "";
                    }
                    zf().xj(new com.bytedance.msdk.api.xj(i2, str));
                }
            } else if (i == 8232) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().j_();
                }
            } else if (i == 8233) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().w();
                }
            } else if (i == 8234) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().kd();
                }
            } else if (i == 8235) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().u();
                }
            } else if (i == 8236) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().y();
                }
            } else if (i == 8237) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    jq().i_();
                }
            } else if (i == 8238) {
                if (this.f instanceof com.bytedance.msdk.api.u.xj.f.xj) {
                    final boolean booleanValue2 = pluginValueSet.booleanValue(8017);
                    final float intValue2 = pluginValueSet.intValue(8018);
                    final String stringValue2 = pluginValueSet.stringValue(8019);
                    Map map2 = (Map) pluginValueSet.objectValue(8020, Map.class);
                    final HashMap hashMap2 = new HashMap();
                    if (map2 != null) {
                        hashMap2.putAll(map2);
                    }
                    com.bytedance.msdk.api.w.xj xjVar2 = new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.xj.f.2
                        @Override // com.bytedance.msdk.api.w.xj
                        public float hf() {
                            return intValue2;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public Map<String, Object> u() {
                            return hashMap2;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public String w() {
                            return stringValue2;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public boolean xj() {
                            return booleanValue2;
                        }
                    };
                    com.bytedance.sdk.gromore.xj.xj.kd.u.xj(xjVar2, "GMRewardAd play again reward verify");
                    jq().xj(xjVar2);
                }
            } else if (i == 8111) {
                xj(pluginValueSet.doubleValue(8016));
            }
            return (T) com.bytedance.msdk.core.zg.xj.xj(cls);
        }
        return (T) com.bytedance.msdk.core.zg.xj.xj(cls);
    }
}
