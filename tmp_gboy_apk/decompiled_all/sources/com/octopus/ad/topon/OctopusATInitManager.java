package com.octopus.ad.topon;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.octopus.ad.Octopus;
import com.octopus.ad.OctopusAdSdkController;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATInitManager extends ATInitMediation {
    public static final String TAG = "OctopusATInitManager";
    private static volatile OctopusATInitManager sInstance;
    private boolean mHasInit;
    private List<MediationInitCallback> mListeners;
    private final Object mLock = new Object();
    private int personAdStatus = 0;
    private final AtomicBoolean mIsIniting = new AtomicBoolean(false);

    static {
        ufJhQp();
    }

    private OctopusATInitManager() {
    }

    private void callbackResult(boolean z, String str, String str2) {
        synchronized (this.mLock) {
            try {
                int size = this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    MediationInitCallback mediationInitCallback = this.mListeners.get(i);
                    if (mediationInitCallback != null) {
                        if (z) {
                            mediationInitCallback.onSuccess();
                        } else {
                            mediationInitCallback.onFail(str + " | " + str2);
                        }
                    }
                }
                this.mListeners.clear();
                this.mIsIniting.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static OctopusATInitManager getInstance() {
        if (sInstance == null) {
            synchronized (OctopusATInitManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new OctopusATInitManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private static /* synthetic */ void ufJhQp() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String getNetworkName() {
        return "Octopus";
    }

    public String getNetworkVersion() {
        return Octopus.getSdkVersion();
    }

    public synchronized void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        try {
            this.personAdStatus = ATSDK.getPersionalizedAdStatus();
        } catch (Throwable unused) {
        }
        try {
            Octopus.setLimitPersonalAds(this.personAdStatus == 2);
            if (ATSDK.isNetworkLogDebug()) {
                Octopus.isLimitPersonalAds();
            }
            if (this.mHasInit) {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
                return;
            }
            synchronized (this.mLock) {
                try {
                    if (this.mIsIniting.get()) {
                        if (mediationInitCallback != null) {
                            this.mListeners.add(mediationInitCallback);
                        }
                        return;
                    }
                    if (this.mListeners == null) {
                        this.mListeners = new ArrayList();
                    }
                    this.mIsIniting.set(true);
                    String stringFromMap = getStringFromMap(map, PluginConstants.KEY_APP_ID);
                    if (mediationInitCallback != null) {
                        this.mListeners.add(mediationInitCallback);
                    }
                    if (TextUtils.isEmpty(stringFromMap)) {
                        callbackResult(false, "80000", "AppId is empty!");
                        return;
                    }
                    try {
                        Octopus.init(context, stringFromMap, new OctopusAdSdkController() { // from class: com.octopus.ad.topon.OctopusATInitManager.1
                            @Override // com.octopus.ad.OctopusAdSdkController
                            public String getImei() {
                                return super.getImei();
                            }

                            @Override // com.octopus.ad.OctopusAdSdkController
                            public String getOaid() {
                                return super.getOaid();
                            }

                            @Override // com.octopus.ad.OctopusAdSdkController
                            public boolean isCanUsePhoneState() {
                                return false;
                            }
                        });
                        Octopus.setIsDownloadDirect(false);
                        this.mHasInit = true;
                        callbackResult(true, null, null);
                    } catch (Throwable th) {
                        callbackResult(false, "80000", "init fail:" + th.getMessage());
                        th.getMessage();
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
