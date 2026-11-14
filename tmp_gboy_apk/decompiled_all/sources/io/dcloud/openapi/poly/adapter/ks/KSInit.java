package io.dcloud.openapi.poly.adapter.ks;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.AdUtil;
import io.dcloud.openapi.core.util.LoadAppUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class KSInit {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f13987a = false;
    public DCloudAOLManager.PrivacyConfig b = null;
    public final KsCustomController c = new KsCustomController() { // from class: io.dcloud.openapi.poly.adapter.ks.KSInit.1
        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canReadInstalledPackages() : privacyConfig.isCanGetInstallAppList();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canReadLocation() : privacyConfig.isCanUseLocation();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canUseMacAddress() : privacyConfig.isCanGetMacAddress();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canUseNetworkState() : privacyConfig.isCanUseWifiState();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canUseOaid() : privacyConfig.isCanGetOAID();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canUsePhoneState() : privacyConfig.isCanUsePhoneState();
        }

        public boolean canUseSensorManager() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            if (privacyConfig == null) {
                return true;
            }
            return privacyConfig.isCanUseSensor();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            DCloudAOLManager.PrivacyConfig privacyConfig = KSInit.this.b;
            return privacyConfig == null ? super.canUseStoragePermission() : privacyConfig.isCanUseStorage();
        }
    };

    public static final class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final KSInit f13989a = new KSInit();

        static {
            SDkNplb();
        }

        private static /* synthetic */ void SDkNplb() {
            char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'N');
            }
            String str = new String(charArray);
            char[] charArray2 = "-\"' ':".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'N');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static KSInit getInstance() {
        return InstanceHolder.f13989a;
    }

    public DCloudAOLManager.PrivacyConfig getPrivacyConfig() {
        return this.b;
    }

    public String init(Context context, String str) {
        if (!this.f13987a) {
            if (!TextUtils.isEmpty(str)) {
                this.f13987a = KsAdSDK.init(context, new SdkConfig.Builder().appId(str).appName(LoadAppUtils.getAppName(context)).showNotification(true).customController(this.c).build());
                KsAdSDK.start();
            }
            setPersonalAd(AdUtil.getPersonalAd(context));
        }
        return str;
    }

    public void setCustomPermission(DCloudAOLManager.PrivacyConfig privacyConfig) {
        if (privacyConfig == null) {
            return;
        }
        this.b = privacyConfig;
    }

    public void setPersonalAd(boolean z) {
        KsAdSDK.setPersonalRecommend(z);
    }
}
