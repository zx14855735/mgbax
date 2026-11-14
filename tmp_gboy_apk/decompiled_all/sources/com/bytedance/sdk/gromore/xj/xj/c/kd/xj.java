package com.bytedance.sdk.gromore.xj.xj.c.kd;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.msdk.w.u.pl;
import com.bytedance.sdk.gromore.xj.xj.kd.u;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends qt {
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj hf;
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj w;
    private pl xj;

    public xj(pl plVar) {
        this.xj = plVar;
        y();
    }

    private void y() {
        pl plVar = this.xj;
        if (plVar == null) {
            return;
        }
        plVar.xj(new com.bytedance.msdk.api.u.xj.f.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.kd.xj.1
            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void i_() {
                if (xj.this.hf != null) {
                    xj.this.hf.xj();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void j_() {
                if (xj.this.hf != null) {
                    xj.this.hf.hf();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void kd() {
                if (xj.this.hf != null) {
                    xj.this.hf.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void u() {
                if (xj.this.hf != null) {
                    xj.this.hf.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void w() {
                if (xj.this.hf != null) {
                    xj.this.hf.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void y() {
                if (xj.this.hf != null) {
                    xj.this.hf.y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                xj xjVar2 = xj.this;
                xjVar2.xj(xjVar, xjVar2.hf, "CSJMRewardAd normal");
            }
        });
        this.xj.hf(new com.bytedance.msdk.api.u.xj.f.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.kd.xj.2
            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void i_() {
                if (xj.this.w != null) {
                    xj.this.w.xj();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void j_() {
                if (xj.this.w != null) {
                    xj.this.w.hf();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void kd() {
                if (xj.this.w != null) {
                    xj.this.w.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void u() {
                if (xj.this.w != null) {
                    xj.this.w.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void w() {
                if (xj.this.w != null) {
                    xj.this.w.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void y() {
                if (xj.this.w != null) {
                    xj.this.w.y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.f.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                xj xjVar2 = xj.this;
                xjVar2.xj(xjVar, xjVar2.w, "CSJMRewardAd play again");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public y kd() {
        return new com.bytedance.sdk.gromore.xj.xj.kd.xj(new hf(this.xj));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public long u() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void hf(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        this.w = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public Map<String, Object> hf() {
        pl plVar = this.xj;
        if (plVar != null) {
            return plVar.yo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.msdk.api.w.xj xjVar, com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar2, String str) {
        Bundle bundle;
        String str2;
        u.xj(xjVar, str);
        if (xjVar2 == null || xjVar == null) {
            return;
        }
        boolean xj = xjVar.xj();
        float hf = xjVar.hf();
        String w = xjVar.w();
        Map<String, Object> u = xjVar.u();
        if (u == null) {
            u = new HashMap<>();
        }
        Object obj = u.get(MediationConstant.KEY_REWARD_TYPE);
        int i = 0;
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = u.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, w);
        bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, hf);
        Object obj3 = u.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj3 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj3).booleanValue());
        }
        Object obj4 = u.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = u.get(MediationConstant.KEY_REASON);
        if (obj5 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj5).intValue());
        }
        Object obj6 = u.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = u.get(MediationConstant.KEY_ERROR_CODE);
        if (obj7 instanceof Integer) {
            Integer num = (Integer) obj7;
            i = num.intValue();
            bundle.putInt(MediationConstant.KEY_ERROR_CODE, num.intValue());
        }
        Object obj8 = u.get(MediationConstant.KEY_ERROR_MSG);
        if (obj8 instanceof String) {
            String str3 = (String) obj8;
            bundle.putString(MediationConstant.KEY_ERROR_MSG, str3);
            str2 = str3;
        } else {
            str2 = "";
        }
        Object obj9 = u.get(MediationConstant.KEY_ADN_NAME);
        if (obj9 instanceof String) {
            bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj9);
        }
        Object obj10 = u.get("ecpm");
        if (obj10 instanceof String) {
            bundle.putString("ecpm", (String) obj10);
        }
        xjVar2.xj(xj, intValue, bundle);
        if (com.bytedance.msdk.xj.w.hf.xj("6.4.0.0")) {
            xjVar2.xj(xj, (int) hf, w != null ? w : "", i, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar) {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj(hfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj(new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.kd.xj.3
                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf() {
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj() {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj();
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.w(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, int i, int i2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.hf(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(String str, String str2) {
                    com.bytedance.sdk.openadsdk.zg.w.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(Activity activity) {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(Activity activity, Object obj, String str) {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public int xj() {
        pl plVar = this.xj;
        if (plVar != null) {
            return plVar.e();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj(hfVar);
        }
    }
}
