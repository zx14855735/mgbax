package com.bytedance.sdk.openadsdk.live;

import ADYaiT.BpkvW3;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.w.u;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w implements Function<SparseArray<Object>, Object> {
    private static final w xj = new w();
    private volatile Function<SparseArray<Object>, Object> hf;
    private volatile hf u;
    private Map<String, String> w;

    public final class hf implements TTPluginListener {
        String hf;
        int xj;

        private hf() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            xj(i, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.xj = i;
            if (w.this.hf != null) {
                ARc23Z A4TApA2 = ARc23Z.A4TApA();
                A4TApA2.ADYaiT(0, i);
                SparseArray sparseArray = A4TApA2.f4113A2egSU;
                sparseArray.put(1, classLoader);
                sparseArray.put(2, resources);
                sparseArray.put(3, bundle);
                sparseArray.put(4, w.this.xj(z));
                A4TApA2.ADYaiT(-99999987, 3);
                w.this.hf.apply(A4TApA2.A2egSU().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(int i, String str, boolean z) {
            this.xj = i;
            this.hf = str;
            if (w.this.hf != null) {
                ARc23Z A4TApA2 = ARc23Z.A4TApA();
                A4TApA2.ADYaiT(0, i);
                if (str != null) {
                    A4TApA2.ARc23Z(1, str);
                }
                A4TApA2.f4113A2egSU.put(2, w.this.xj(z));
                A4TApA2.ADYaiT(-99999987, 2);
                w.this.hf.apply(A4TApA2.A2egSU().sparseArray());
            }
        }
    }

    public static final class xj implements Function<SparseArray<Object>, Object> {
        private ILiveAdCustomConfig xj;

        public xj(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.xj = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            int intValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (intValue == -99999986) {
                ARc23Z A4TApA2 = ARc23Z.A4TApA();
                A4TApA2.ADYaiT(10000, 1);
                return A4TApA2.A2egSU().sparseArray();
            }
            if (intValue == 0) {
                return Integer.valueOf(this.xj.openLR((String) sparseArray.get(0)));
            }
            if (intValue == 1) {
                return this.xj.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (intValue == 2) {
                return this.xj.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (intValue == 3) {
                return this.xj.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (intValue == 4) {
                this.xj.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (intValue != 5) {
                return null;
            }
            return this.xj;
        }
    }

    static {
        BJIGnO();
    }

    private w() {
    }

    private static /* synthetic */ void BJIGnO() {
        char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 169);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 169);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Object kd(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                Object[] objArr = (Object[]) map.get("expand_method_param");
                if (objArr == null) {
                    return liveRoomService.callExpandMethod(str, new Object[0]);
                }
                for (int i = 0; i < objArr.length; i++) {
                    if (BpkvW3.BmvVmW(objArr[i])) {
                        objArr[i] = new com.bytedance.sdk.openadsdk.live.xj(AaHO0E.AYUAbz(objArr[i]));
                    }
                }
                return liveRoomService.callExpandMethod(str, objArr);
            } catch (Throwable th) {
                th = th;
                xj("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                y.hf("TTLiveSDkBridge", th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private Function<SparseArray<Object>, Object> u(Map map) {
        return qt.xj(map.get("c_control"));
    }

    private void w(Map map) {
        ILiveHostContextParam.Builder addHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.w.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                Object apply;
                if (w.this.hf == null) {
                    return null;
                }
                ARc23Z A4TApA2 = ARc23Z.A4TApA();
                SparseArray sparseArray = A4TApA2.f4113A2egSU;
                sparseArray.put(0, str);
                sparseArray.put(1, map2);
                A4TApA2.ADYaiT(-99999987, 0);
                apply = w.this.hf.apply(A4TApA2.A2egSU().sparseArray());
                return apply;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.xj.xj(u(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.xj.hf(this.hf)).addHostInitExtra(hf(map));
        Map<String, String> map2 = this.w;
        if (map2 != null) {
            addHostInitExtra.addHostInitExtra(map2);
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.w.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                y.xj("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (w.this.u != null) {
                    w.this.u.xj(-3, str, false);
                }
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                y.hf("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.hf.xj();
                if (w.this.u != null) {
                    w.this.u.xj(2, null, false);
                }
                w.this.w = null;
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            addHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        Boolean valueOf = Boolean.valueOf(String.valueOf(map.get("sub_process")));
        y.xj("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.hf.xj(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), addHostInitExtra, iLiveInitCallback, valueOf.booleanValue())), " subProcess=", valueOf);
    }

    private Boolean y(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.hf.xj(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            xj("handleLiveScheme", th);
            y.hf("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
        int intValue = AMqCpz.intValue(-99999987, 0);
        if (intValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (intValue == 5) {
            w((Map) AMqCpz.objectValue(0, Map.class));
            return null;
        }
        if (intValue != 9) {
            return xj(intValue, (Map<String, Object>) AMqCpz.objectValue(0, Map.class));
        }
        this.hf = qt.xj(AMqCpz.objectValue(0, Object.class));
        if (this.u == null) {
            this.u = new hf();
            ARc23Z A5SV6n2 = ARc23Z.A5SV6n(2);
            A5SV6n2.ADYaiT(0, 4);
            A5SV6n2.ADYaiT(-99999987, 10);
            Function<SparseArray<Object>, Object> xj2 = qt.xj(u.xj().apply(A5SV6n2.A2egSU().sparseArray()));
            ARc23Z A5SV6n3 = ARc23Z.A5SV6n(2);
            A5SV6n3.ADYaiT(-99999987, 106);
            A5SV6n3.f4113A2egSU.put(0, this.u);
            ADYaiT A2egSU2 = A5SV6n3.A2egSU();
            if (xj2 != null) {
                xj2.apply(A2egSU2.sparseArray());
            }
        } else {
            if (this.u.xj == 2 || this.u.xj == -3) {
                this.u.xj(this.u.xj, this.u.hf, true);
                return null;
            }
            if (this.u.xj != 0) {
                this.u.xj(this.u.xj, null, null, null, true);
                return null;
            }
        }
        return null;
    }

    private Map<String, String> hf(Map map) {
        Object obj = map.get("live_tob_init_extra");
        return obj instanceof Map ? (Map) obj : new HashMap();
    }

    public static w xj() {
        return xj;
    }

    public static Function<SparseArray<Object>, Object> xj(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new xj(iLiveAdCustomConfig);
    }

    public void xj(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.w = map;
    }

    public <T> T xj(int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.bytedance.sdk.openadsdk.live.hf.xj(getContext(map.get("context")), xj(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) kd(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) y(map);
    }

    private Bundle xj(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    public static void xj(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put(br.c, Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString("event_name", "exception");
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            y.hf("TTLiveSDkBridge", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map xj(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("onlyUpdateState", Boolean.valueOf(z));
        return hashMap;
    }
}
