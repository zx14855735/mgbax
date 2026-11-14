package com.bytedance.sdk.gromore.init;

import P8ccfD.AaHO0E;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.g;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends com.bytedance.sdk.openadsdk.mediation.hf.hf.u {
    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Activity activity, List<com.bytedance.sdk.openadsdk.mediation.hf.hf.kd> list, int i, int i2, Function<SparseArray<Object>, Object> function) {
        com.bytedance.msdk.api.xj.hf xj;
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i + " requestIntervalS = " + i2 + " classLoader = " + function);
        if (list == null || list.size() == 0) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "参数错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.mediation.hf.hf.kd kdVar : list) {
            if (kdVar != null && (xj = com.bytedance.msdk.api.u.xj.xj.xj(kdVar.xj(), kdVar.hf(), function)) != null) {
                arrayList.add(new g(xj, kdVar.w()));
            }
        }
        if (arrayList.size() > 0) {
            com.bytedance.msdk.api.u.tf.xj(activity, arrayList, i, i2);
        } else {
            com.bytedance.msdk.xj.kd.w.u("TMe", "参数错误");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(String str) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager setPulisherDid configUserInfoForSegment = ".concat(String.valueOf(str)));
        com.bytedance.msdk.api.u.tf.xj(str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Context context) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager requestPermissionIfNecessary context = ".concat(String.valueOf(context)));
        com.bytedance.msdk.api.u.tf.xj(context);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Context context, int[] iArr) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.bytedance.msdk.api.u.tf.xj(context, iArr);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(int i) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager setThemeStatus themeStatus = ".concat(String.valueOf(i)));
        com.bytedance.msdk.api.u.tf.xj(i);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public int xj(final com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.u uVar) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.bytedance.msdk.api.u.tf.xj(new com.bytedance.msdk.api.u.w() { // from class: com.bytedance.sdk.gromore.init.f.1
            @Override // com.bytedance.msdk.api.u.w
            public void xj(int i) {
                com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.xj(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar) {
        com.bytedance.msdk.api.u.tf.xj(hf.xj(wVar));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager updatePrivacyConfig customController = ".concat(String.valueOf(uVar)));
        com.bytedance.msdk.api.u.tf.xj(uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Map<String, Object> map) {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager updateLocalExtra map = ".concat(String.valueOf(map)) == null ? "null" : map.toString());
        com.bytedance.msdk.core.xj.p().hf(map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, final com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.w wVar, Function<SparseArray<Object>, Object> function) {
        if (context == null || xjVar == null) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "参数错误");
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + xjVar + " pluginIMediationNativeAdTokenCallback = " + wVar + " classLoader = " + function);
        com.bytedance.msdk.api.xj.hf xj = com.bytedance.msdk.api.u.xj.xj.xj(5, xjVar, function);
        if (xj != null) {
            final com.bytedance.msdk.w.u.d dVar = new com.bytedance.msdk.w.u.d(context);
            dVar.xj(xj, new com.bytedance.msdk.api.u.xj.w() { // from class: com.bytedance.sdk.gromore.init.f.2
                @Override // com.bytedance.msdk.api.u.xj.w
                public void xj(String str) {
                    com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(str, new com.bytedance.sdk.gromore.xj.xj.c.u.xj(dVar));
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w
                public void xj(com.bytedance.msdk.api.xj xjVar2) {
                    com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.w wVar2;
                    if (xjVar2 == null || (wVar2 = wVar) == null) {
                        return;
                    }
                    wVar2.xj(xjVar2.xj, xjVar2.hf);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public void xj(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, final com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj xjVar2, Function<SparseArray<Object>, Object> function) {
        if (context == null || xjVar == null) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "参数错误");
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + xjVar + " pluginIMediationDrawAdTokenCallback = " + xjVar2 + " classLoader = " + function);
        com.bytedance.msdk.api.xj.hf xj = com.bytedance.msdk.api.u.xj.xj.xj(9, xjVar, function);
        if (xj != null) {
            final com.bytedance.msdk.w.u.c cVar = new com.bytedance.msdk.w.u.c(context);
            cVar.xj(xj, new com.bytedance.msdk.api.u.xj.w() { // from class: com.bytedance.sdk.gromore.init.f.3
                @Override // com.bytedance.msdk.api.u.xj.w
                public void xj(String str) {
                    com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj xjVar3 = xjVar2;
                    if (xjVar3 != null) {
                        xjVar3.xj(str, new com.bytedance.sdk.gromore.xj.xj.c.hf.u(cVar));
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w
                public void xj(com.bytedance.msdk.api.xj xjVar3) {
                    com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj xjVar4;
                    if (xjVar3 == null || (xjVar4 = xjVar2) == null) {
                        return;
                    }
                    xjVar4.xj(xjVar3.xj, xjVar3.hf);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public Map<String, Object> xj() {
        com.bytedance.msdk.xj.kd.w.hf("TMe", "getMediationExtraInfo");
        return com.bytedance.msdk.api.u.tf.g();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.u
    public Object xj(int i, PluginValueSet pluginValueSet) {
        String str;
        String str2;
        if (i == 8259) {
            return xj();
        }
        if (i == 1001) {
            return Boolean.valueOf(com.bytedance.msdk.api.u.tf.xj());
        }
        if (i == 1002) {
            return Boolean.valueOf(com.bytedance.msdk.api.u.tf.xj(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1002)));
        }
        if (i == 1003) {
            return Boolean.valueOf(com.bytedance.msdk.api.u.tf.hf(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1003)));
        }
        if (i == 1004) {
            return com.bytedance.msdk.api.u.tf.kd();
        }
        if (i == 1005) {
            return com.bytedance.msdk.api.u.tf.p();
        }
        if (i == 1006) {
            return com.bytedance.msdk.api.u.tf.tf();
        }
        if (i == 1007) {
            return com.bytedance.msdk.api.u.tf.hf((Context) pluginValueSet.objectValue(PluginConstants.ERROR_PLUGIN_DOWNLOAD, Context.class));
        }
        if (i == 1008) {
            com.bytedance.msdk.api.u.tf.hf(2);
            return null;
        }
        if (i == 1009) {
            com.bytedance.msdk.api.u.tf.pl();
            return null;
        }
        if (i == 1010) {
            return Boolean.valueOf(com.bytedance.msdk.api.u.tf.u(pluginValueSet.stringValue(1001)));
        }
        if (i != 1011) {
            if (i == 2001) {
                if (pluginValueSet != null) {
                    com.bytedance.sdk.gromore.hf.xj.xj((Function<SparseArray<Object>, Object>) AaHO0E.AYUAbz(pluginValueSet.objectValue(2002, AaHO0E.ARc23Z())));
                    return com.bytedance.sdk.gromore.hf.xj.xj();
                }
            } else if (i == 1012) {
                return Boolean.valueOf(com.bytedance.msdk.core.xj.p().ra().w());
            }
            return null;
        }
        String stringValue = pluginValueSet.stringValue(1001);
        com.bytedance.msdk.api.u.xj.hf.y.xj kd = com.bytedance.msdk.api.u.tf.kd(stringValue);
        com.bytedance.msdk.xj.xj.u y = com.bytedance.msdk.api.u.tf.y(stringValue);
        if (kd != null) {
            str = kd.w();
            str2 = kd.u();
        } else if (y != null) {
            String hf = y.hf();
            str2 = y.xj();
            str = hf;
        } else {
            str = "";
            str2 = "";
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("networdSdkVersion", str);
        hashMap.put("adapterSdkVersion", str2);
        return hashMap;
    }
}
