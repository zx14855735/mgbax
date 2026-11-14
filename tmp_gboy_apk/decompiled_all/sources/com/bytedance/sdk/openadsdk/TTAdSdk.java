package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.kd;
import com.bytedance.sdk.openadsdk.api.plugin.tf;
import com.bytedance.sdk.openadsdk.api.xj;
import com.bytedance.sdk.openadsdk.api.y;
import com.bytedance.sdk.openadsdk.live.w;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class TTAdSdk {
    public static final String BRANCH = "";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "c2d0b757b5";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = true;
    public static final boolean IS_P = false;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final boolean PC_BOOST_ABI = false;
    public static final String PLUGIN_ADAPTER_PACKAGE_NAME = "com.byted.mixed";
    public static final int SDK_VERSION_CODE = 7132;
    public static final String SDK_VERSION_NAME = "7.1.3.2";
    public static final String S_C = "main";
    private static volatile TTAdConfig hf;
    private static final xj xj = new tf();

    public interface Callback extends InitCallback {
    }

    @Deprecated
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        iwxwY();
    }

    public static TTAdManager getAdManager() {
        xj xjVar = xj;
        if (xjVar != null) {
            return xjVar.hf();
        }
        return null;
    }

    public static View getEcMallBackUpView() {
        xj.w hf2 = xj.hf();
        if (hf2 == null) {
            return null;
        }
        return (View) hf2.getExtra(View.class, null);
    }

    public static IMediationManager getMediationManager() {
        if (xj != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        hf = tTAdConfig;
        xj(context, hf);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        xj xjVar = xj;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return false;
    }

    public static boolean isOpenMediationMap() {
        TTAdManager adManager = getAdManager();
        if (adManager == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_name", "use_mediation_map");
        Map map = (Map) adManager.getExtra(Map.class, bundle);
        if (map == null || !(map.get("use_mediation_map") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) map.get("use_mediation_map")).booleanValue();
    }

    public static boolean isSdkReady() {
        xj xjVar = xj;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return false;
    }

    private static /* synthetic */ void iwxwY() {
        char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'n');
        }
        String str = new String(charArray);
        char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void start(Callback callback) {
        xj(hf, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        xj xjVar = xj;
        if (xjVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            xjVar.xj(TTAppContextHolder.getContext(), hf, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        xj.w hf2;
        if (kd.xj() || tTAdConfig == null || (hf2 = xj.hf()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (!bundle.keySet().isEmpty()) {
            hf2.getExtra(SparseArray.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra == null || initExtra.isEmpty()) {
                return;
            }
            mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Map<String, Object> initExtra;
        if (kd.xj() || tTAdConfig == null || (initExtra = tTAdConfig.getInitExtra()) == null) {
            return;
        }
        Object obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE);
        if (obj instanceof Map) {
            w.xj().xj((Map<String, String>) obj);
        }
    }

    public static void updatePaid(boolean z) {
        xj.w hf2 = xj.hf();
        if (hf2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        hf2.getExtra(SparseArray.class, bundle);
    }

    private static void xj(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            y.xj();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            y.hf("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        xj(context, "Context is null, please check.");
        xj(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    private static void xj(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
