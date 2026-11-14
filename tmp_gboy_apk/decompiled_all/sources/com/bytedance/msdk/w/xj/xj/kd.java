package com.bytedance.msdk.w.xj.xj;

import ADYaiT.BpkvW3;
import ADYaiT.CtFAbx;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends f {
    public kd(com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar, Function<SparseArray<Object>, Object> function) {
        super(hfVar, function);
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8127).xj(Void.class).xj(8034, this).hf());
            ct();
        }
    }

    private void ct() {
        PluginValueSet hf = com.bytedance.sdk.openadsdk.zg.w.hf(((w) this).tf);
        if (hf != null) {
            Map<String, Object> map = (Map) hf.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
            String stringValue = hf.stringValue(8045);
            String stringValue2 = hf.stringValue(8046);
            String stringValue3 = hf.stringValue(8048);
            String stringValue4 = hf.stringValue(8049);
            String stringValue5 = hf.stringValue(8050);
            int intValue = hf.intValue(8051);
            int intValue2 = hf.intValue(8052);
            List<String> list = (List) hf.objectValue(8053, List.class);
            String stringValue6 = hf.stringValue(8054);
            double doubleValue = hf.doubleValue(8016);
            boolean booleanValue = hf.booleanValue(8033);
            int intValue3 = hf.intValue(8060);
            String stringValue7 = hf.stringValue(8061);
            double doubleValue2 = hf.doubleValue(8082);
            int intValue4 = hf.intValue(8420);
            int intValue5 = hf.intValue(8421);
            int intValue6 = hf.intValue(8059);
            Function AYUAbz2 = AaHO0E.AYUAbz(hf.objectValue(8315, AaHO0E.ARc23Z()));
            if (doubleValue > 0.0d) {
                xj(doubleValue);
            }
            w(map);
            j(stringValue);
            en(stringValue2);
            x(stringValue3);
            ai(stringValue5);
            yo(intValue2);
            v(intValue);
            q(stringValue7);
            z(stringValue6);
            pz(intValue4);
            ht(intValue5);
            u(doubleValue2);
            xj(list);
            l(stringValue4);
            c(booleanValue);
            p(intValue3);
            pl(intValue6);
            if (AYUAbz2 != null) {
                com.bytedance.msdk.xj.u.xj.xj.xj xjVar = new com.bytedance.msdk.xj.u.xj.xj.xj(AYUAbz2);
                ht(xjVar.w());
                ra(xjVar.u());
                hf(xjVar.kd());
                dk(xjVar.y());
                et(xjVar.f());
                io(xjVar.d());
                kd(xjVar.c());
            }
        }
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8134) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeRenderFail code:" + intValue + " msg:" + stringValue + " view" + view);
            xj(view, stringValue, intValue);
        } else if (i == 8133) {
            float floatValue = pluginValueSet.floatValue(8040);
            float floatValue2 = pluginValueSet.floatValue(8041);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeRenderSuccess width:" + floatValue + " height:" + floatValue2);
            xj(floatValue, floatValue2);
        } else if (i == 8130) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeAdClick");
            mq();
        } else if (i == 8113) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeAdShow");
            zf();
        } else if (i == 8145) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeVideoStart");
            jq();
        } else if (i == 8146) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeVideoPause");
            jb();
        } else if (i == 8150) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeVideoResume");
            ka();
        } else if (i == 8118) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeVideoCompleted");
            rx();
        } else if (i == 8117) {
            int intValue2 = pluginValueSet.intValue(8014);
            String stringValue2 = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeVideoError code:" + intValue2 + " msg:" + stringValue2);
            xj(new com.bytedance.msdk.api.u.xj.hf.xj(intValue2, stringValue2));
        } else if (i == 8154) {
            long longValue = pluginValueSet.longValue(8072);
            long longValue2 = pluginValueSet.longValue(8073);
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("Adn custom feed ad : callNativeVideoError current:", longValue, " duration:");
            B2KMhB2.append(longValue2);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B2KMhB2.toString());
            xj(longValue, longValue2);
        } else if (i == 8152) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeOnIdle");
            o();
        } else if (i == 8187) {
            long longValue3 = pluginValueSet.longValue(8062);
            long longValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            StringBuilder B2KMhB3 = CtFAbx.B2KMhB("Adn custom feed ad : callNativeOnDownloadActive totalBytes:", longValue3, " curlBytes:");
            B2KMhB3.append(longValue4);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B2KMhB3.toString());
            xj(longValue3, longValue4, "", "");
        } else if (i == 8158) {
            long longValue5 = pluginValueSet.longValue(8062);
            long longValue6 = pluginValueSet.longValue(8063);
            String stringValue3 = pluginValueSet.stringValue(8066);
            String stringValue4 = pluginValueSet.stringValue(8056);
            StringBuilder B2KMhB4 = CtFAbx.B2KMhB("Adn custom feed ad : callNativeOnDownloadPaused totalBytes:", longValue5, " curlBytes:");
            B2KMhB4.append(longValue6);
            B2KMhB4.append(" fileName:");
            B2KMhB4.append(stringValue3);
            B2KMhB4.append(" appName:");
            B2KMhB4.append(stringValue4);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B2KMhB4.toString());
            hf(longValue5, longValue6, stringValue3, stringValue4);
        } else if (i == 8157) {
            long longValue7 = pluginValueSet.longValue(8062);
            long longValue8 = pluginValueSet.longValue(8063);
            String stringValue5 = pluginValueSet.stringValue(8066);
            String stringValue6 = pluginValueSet.stringValue(8056);
            StringBuilder B2KMhB5 = CtFAbx.B2KMhB("Adn custom feed ad : callNativeOnDownloadFailed totalBytes:", longValue7, " curlBytes:");
            B2KMhB5.append(longValue8);
            B2KMhB5.append(" fileName:");
            B2KMhB5.append(stringValue5);
            B2KMhB5.append(" appName:");
            B2KMhB5.append(stringValue6);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B2KMhB5.toString());
            w(longValue7, longValue8, stringValue5, stringValue6);
        } else if (i == 8155) {
            long longValue9 = pluginValueSet.longValue(8062);
            String stringValue7 = pluginValueSet.stringValue(8066);
            String stringValue8 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeOnDownloadFinished totalBytes:" + longValue9 + " fileName:" + stringValue7 + " appName:" + stringValue8);
            xj(longValue9, stringValue7, stringValue8);
        } else if (i == 8156) {
            String stringValue9 = pluginValueSet.stringValue(8066);
            String stringValue10 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeOnDownloadFinished  fileName:" + stringValue9 + " appName:" + stringValue10);
            xj(stringValue9, stringValue10);
        } else if (i == 8185) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeDislikeShow");
            hx();
        } else if (i == 8184) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeDislikeCancel");
            it();
        } else if (i != 6085) {
            if (i == 8110) {
                boolean lm = lm();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : isClientBiddingAd :".concat(String.valueOf(lm)));
                return (T) Boolean.valueOf(lm);
            }
            if (i == 8136) {
                boolean si = si();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : isServerBiddingAd :".concat(String.valueOf(si)));
                return (T) Boolean.valueOf(si);
            }
            if (i == 8160) {
                boolean a2 = a();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : isUseCustomVideo :".concat(String.valueOf(a2)));
                return (T) Boolean.valueOf(a2);
            }
            if (i == 8226) {
                int qi = qi();
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : getBiddingType :".concat(String.valueOf(qi)));
                return (T) Integer.valueOf(qi);
            }
            if (i == 8132) {
                int intValue3 = pluginValueSet.intValue(8038);
                String stringValue11 = pluginValueSet.stringValue(8039);
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom feed ad : callNativeDislikeSelected postion:" + intValue3 + " value:" + stringValue11);
                xj(intValue3, stringValue11);
            }
        }
        return (T) com.bytedance.msdk.core.zg.xj.xj(cls);
    }

    @Override // com.bytedance.msdk.hf.w
    public String c() {
        Object apply;
        if (((w) this).tf == null) {
            return super.c();
        }
        apply = ((w) this).tf.apply(A2egSU.ARc23Z(8228, String.class));
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        Object apply;
        if (((w) this).tf == null) {
            return super.d();
        }
        apply = ((w) this).tf.apply(A2egSU.ARc23Z(6081, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.w.xj.xj.w, com.bytedance.msdk.hf.w
    public void e() {
        if (((w) this).tf != null) {
            ((w) this).tf.apply(A2egSU.ARc23Z(8148, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.c.kd f() {
        Object apply;
        if (((w) this).tf != null) {
            apply = ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8320).xj(AaHO0E.ARc23Z()).hf());
            if (BpkvW3.BmvVmW(apply)) {
                return com.bytedance.msdk.core.xj.xj.xj(AaHO0E.AYUAbz(apply));
            }
        }
        return super.f();
    }

    public void hf(long j, long j2, String str, String str2) {
        if (am() != null) {
            am().xj(j, j2, str, str2);
        }
    }

    public void hx() {
        if (v() != null) {
            v().xj();
        }
    }

    public void it() {
        if (v() != null) {
            v().hf();
        }
    }

    public void jb() {
        if (g() != null) {
            g().w();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean jk() {
        Object apply;
        if (((w) this).tf == null) {
            return super.jk();
        }
        apply = ((w) this).tf.apply(A2egSU.ARc23Z(8135, Boolean.class));
        return (apply instanceof Boolean) && ((Boolean) apply).booleanValue();
    }

    public void jq() {
        if (g() != null) {
            g().hf();
        }
    }

    public void ka() {
        if (g() != null) {
            g().u();
        }
    }

    public void mq() {
        xj(new xj() { // from class: com.bytedance.msdk.w.xj.xj.kd.2
            @Override // com.bytedance.msdk.w.xj.xj.xj
            public void xj() {
                if (kd.this.pl() != null) {
                    kd.this.pl().xj(null);
                }
            }
        });
    }

    public void o() {
        if (am() != null) {
            am().xj();
        }
    }

    public void rx() {
        if (g() != null) {
            g().kd();
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public View tf() {
        Object apply;
        if (((w) this).tf == null) {
            return super.tf();
        }
        apply = ((w) this).tf.apply(A2egSU.ARc23Z(6164, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    public void w(long j, long j2, String str, String str2) {
        if (am() != null) {
            am().hf(j, j2, str, str2);
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        Object apply;
        if (((w) this).tf == null) {
            return null;
        }
        apply = ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6072).xj(AaHO0E.ARc23Z()).xj(20033, activity).hf());
        if (!BpkvW3.BmvVmW(apply)) {
            return null;
        }
        final com.bytedance.sdk.openadsdk.mediation.hf.hf.y yVar = new com.bytedance.sdk.openadsdk.mediation.hf.hf.y(AaHO0E.AYUAbz(apply));
        return new com.bytedance.sdk.openadsdk.zg.w.hf.c() { // from class: com.bytedance.msdk.w.xj.xj.kd.1
            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
            public boolean w() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
            public void xj(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
            public void xj() {
                yVar.xj();
            }

            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
            public void xj(com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
                yVar.xj(new com.bytedance.msdk.xj.u.xj.xj.hf(xjVar));
            }
        };
    }

    @Override // com.bytedance.msdk.w.xj.xj.w, com.bytedance.msdk.hf.w
    public Integer y() {
        Object apply;
        if (((w) this).tf != null) {
            apply = ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8121).xj(Object.class).xj(20068, 1).hf());
            Integer xj = com.bytedance.sdk.openadsdk.core.wo.xj.xj.xj(apply);
            if (xj != null) {
                return xj;
            }
        }
        return 1;
    }

    @Override // com.bytedance.msdk.w.xj.xj.w, com.bytedance.msdk.hf.w
    public void yo() {
        if (((w) this).tf != null) {
            ((w) this).tf.apply(A2egSU.ARc23Z(8109, Void.class));
        }
    }

    public void zf() {
        hf(new xj() { // from class: com.bytedance.msdk.w.xj.xj.kd.3
            @Override // com.bytedance.msdk.w.xj.xj.xj
            public void xj() {
                if (kd.this.pl() != null) {
                    kd.this.pl().xj();
                }
            }
        });
    }

    @Override // com.bytedance.msdk.w.xj.xj.w, com.bytedance.msdk.hf.w
    public void zg() {
        if (((w) this).tf != null) {
            ((w) this).tf.apply(A2egSU.ARc23Z(8149, Void.class));
        }
    }

    @Override // com.bytedance.msdk.w.xj.xj.w
    public void xj(boolean z, double d, int i, Map<String, Object> map) {
        super.xj(z, d, i, map);
        if (((w) this).tf != null) {
            ((w) this).tf.apply(A2egSU.AZOQYO(8225, Void.class).xj(8406, Boolean.valueOf(z)).xj(8407, Double.valueOf(d)).xj(8408, Integer.valueOf(i)).xj(8075, map).hf());
        }
    }

    @Override // com.bytedance.msdk.w.xj.xj.f
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar) {
        if (((w) this).tf != null) {
            ((w) this).tf.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8159).xj(Void.class).xj(20033, activity).xj(8067, viewGroup).xj(8068, list).xj(8069, list2).xj(8070, list3).xj(8071, com.bytedance.msdk.api.u.xj.c.tf.xj(tfVar)).hf());
        }
    }

    public void xj(View view, String str, int i) {
        if (pl() instanceof com.bytedance.msdk.api.u.xj.c.y) {
            try {
                ((com.bytedance.msdk.api.u.xj.c.y) pl()).xj(view, str, i);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public void xj(float f, float f2) {
        if (pl() instanceof com.bytedance.msdk.api.u.xj.c.y) {
            try {
                ((com.bytedance.msdk.api.u.xj.c.y) pl()).xj(f, f2);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.hf.xj xjVar) {
        if (g() != null) {
            g().xj(new com.bytedance.msdk.api.xj(49012, com.bytedance.msdk.api.xj.xj(49012), xjVar == null ? -1 : xjVar.xj(), xjVar == null ? "" : xjVar.hf()));
        }
    }

    public void xj(long j, long j2) {
        if (g() != null) {
            g().xj(j, j2);
        }
    }

    public void xj(long j, long j2, String str, String str2) {
        if (am() != null) {
            am().xj(j, j2, -1, 1, str, str2);
        }
    }

    public void xj(long j, String str, String str2) {
        if (am() != null) {
            am().xj(j, str, str2);
        }
    }

    public void xj(String str, String str2) {
        if (am() != null) {
            am().xj(str, str2);
        }
    }

    public void xj(int i, String str) {
        com.bytedance.msdk.w.w.hf.xj.xj.hf hfVar = ((w) this).d;
        if (hfVar != null) {
            hfVar.xj(this, str);
        }
        if (v() != null) {
            v().xj(i, str, false);
        }
    }
}
