package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum an {
    IGNORE_ABOUT_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.1
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
            SigmobLog.d("Link to about page ignored.");
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }
    },
    MINI_PROGRAM(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.2
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            WXProgramRes wXProgramRes;
            if (baseAdUnit == null || (wXProgramRes = baseAdUnit.getWXProgramRes()) == null) {
                return null;
            }
            return wXProgramRes.wx_app_id;
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
            int interactionType = baseAdUnit.getInteractionType();
            if (interactionType == 7) {
                WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
                if (wXProgramRes == null) {
                    return;
                }
                v.a(com.sigmob.sdk.b.e(), wXProgramRes.wx_app_id, wXProgramRes.wx_app_username, wXProgramRes.wx_app_path, wXProgramRes.wx_business_type.intValue(), wXProgramRes.wx_ext_msg);
                return;
            }
            String str = "performAction interaction_type is not right with " + interactionType;
            an.b(this, "performAction", baseAdUnit, str);
            throw new Exception(str);
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || i != 7) ? false : true;
        }
    },
    FOLLOW_DEEP_LINK(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.3
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getDeeplinkUrl();
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
            try {
                int interactionType = baseAdUnit.getInteractionType();
                h.d(baseAdUnit);
                baseAdUnit.setDeeplinkUri(uri);
                String host = uri.getHost();
                if (interactionType != 8 && (!com.sigmob.sdk.base.utils.o.b(host) || !host.equalsIgnoreCase("hapjs.org"))) {
                    v.a(context, uri, v.a(context, uri, baseAdUnit.getMarketPackageNameList()), baseAdUnit.enableSmallWindow(Integer.valueOf(interactionType)));
                    return;
                }
                v.a(context, uri, com.sigmob.sdk.b.a());
            } catch (Exception e) {
                h.d((BaseAdUnit) null);
                baseAdUnit.setDeeplinkUri(null);
                throw e;
            }
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return (i == 8 || (com.sigmob.sdk.base.utils.o.b(host) && host.equalsIgnoreCase("hapjs.org"))) ? "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || "HAP".equalsIgnoreCase(scheme) : ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    FOLLOW_PACKAGE_NAME(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.4
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return com.sigmob.sdk.base.utils.o.a((CharSequence) baseAdUnit.getApkPackageName()) ? baseAdUnit.getProductId() : baseAdUnit.getApkPackageName();
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
            String apkPackageName = baseAdUnit.getApkPackageName();
            if (baseAdUnit.getsubInteractionType() == 2 || com.sigmob.sdk.base.utils.o.b(apkPackageName)) {
                if (!com.sigmob.sdk.base.utils.o.b(apkPackageName)) {
                    apkPackageName = baseAdUnit.getProductId();
                }
                if (com.sigmob.sdk.base.utils.o.b(apkPackageName)) {
                    boolean a2 = com.sigmob.sdk.base.utils.q.a(baseAdUnit.enableSmallWindow());
                    try {
                        h.c(baseAdUnit);
                        v.a(context, (Uri) null, apkPackageName, a2);
                        return;
                    } catch (Throwable th) {
                        an.b(this, "performAction", baseAdUnit, th.getMessage());
                        h.c((BaseAdUnit) null);
                    }
                }
            }
            throw new Exception("can't launch application for packageName " + baseAdUnit.getProductId());
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            return i == 2;
        }
    },
    MARKET_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.5
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            AndroidMarket androidMarket;
            if (baseAdUnit == null || (androidMarket = baseAdUnit.getAndroidMarket()) == null) {
                return null;
            }
            return androidMarket.market_url;
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            String str = null;
            an.b(this, "performAction", baseAdUnit, null);
            AndroidMarket androidMarket = baseAdUnit.getAndroidMarket();
            if (androidMarket == null) {
                return;
            }
            int intValue = ((Integer) Wire.get(androidMarket.type, 0)).intValue();
            if (com.sigmob.sdk.base.utils.o.b(androidMarket.appstore_package_name)) {
                try {
                    if (AppPackageUtil.getPackageVersionCode(context, androidMarket.appstore_package_name) != -1) {
                        str = androidMarket.appstore_package_name;
                    }
                } catch (Throwable th) {
                    an.b(this, "performAction", baseAdUnit, th.getMessage());
                    com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("get store package error "));
                }
            }
            Uri parse = Uri.parse(androidMarket.market_url);
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
                str = v.a(context, parse, baseAdUnit.getMarketPackageNameList());
            }
            if (intValue == 1) {
                new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.b.e(), baseAdUnit);
            }
            v.a(context, parse, str);
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    DOWNLOAD_APK(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.6
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            int interactionType;
            an.b(this, "performAction", baseAdUnit, null);
            if (baseAdUnit == null || (interactionType = baseAdUnit.getInteractionType()) == 2 || interactionType == 3) {
                return;
            }
            String str = "Could not handle download Scheme url: " + uri;
            an.b(this, "performAction", baseAdUnit, str);
            throw new Exception(str);
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    },
    OPEN_WITH_BROWSER(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.7
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
            if (baseAdUnit.getInteractionType() != 8) {
                if (aoVar.b()) {
                    v.a(context, uri);
                    return;
                } else {
                    h.a(baseAdUnit);
                    BaseAdActivity.a(context, (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit.getUuid());
                    return;
                }
            }
            try {
                h.d(baseAdUnit);
                baseAdUnit.setDeeplinkUri(uri);
                v.a(context, uri, com.sigmob.sdk.b.a());
            } catch (Exception e) {
                an.b(this, "performAction", baseAdUnit, e.getMessage());
                h.d((BaseAdUnit) null);
                baseAdUnit.setDeeplinkUri(null);
                throw e;
            }
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            if (uri != null) {
                return "HTTP".equalsIgnoreCase(uri.getScheme()) || "HTTPS".equalsIgnoreCase(uri.getScheme());
            }
            return false;
        }
    },
    NOOP(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.an.8
        @Override // com.sigmob.sdk.base.common.an
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.an
        public void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit) {
            an.b(this, "performAction", baseAdUnit, null);
        }

        @Override // com.sigmob.sdk.base.common.an
        public boolean a(Uri uri, int i) {
            return false;
        }
    };

    private final boolean i;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        lcJwRVr();
    }

    an(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(an anVar, String str, BaseAdUnit baseAdUnit, String str2) {
        if (anVar == null || baseAdUnit == null) {
            return;
        }
        String name = anVar.name();
        String deeplinkUrl = baseAdUnit.getDeeplinkUrl();
        int interactionType = baseAdUnit.getInteractionType();
        if (com.sigmob.sdk.base.utils.o.b(str2)) {
            SigmobLogger.e(name, CtFAbx.AlLFFp(str, ": error = ", str2), new Object[0]);
            return;
        }
        SigmobLogger.d(name, str + ": deeplinkUrl = " + deeplinkUrl + ", interactionType = " + interactionType, new Object[0]);
    }

    private static /* synthetic */ void lcJwRVr() {
        char[] charArray = "DHJ\t@FJB\tEH^\tTOBKK\tmINeUNC@B".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\'');
        }
        String str = new String(charArray);
        char[] charArray2 = "DKNINS".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\'');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract String a(BaseAdUnit baseAdUnit);

    public abstract void a(Context context, Uri uri, ao aoVar, BaseAdUnit baseAdUnit);

    public abstract boolean a(Uri uri, int i);

    public void a(ao aoVar, Context context, Uri uri, boolean z, BaseAdUnit baseAdUnit) {
        SigmobLog.d("Ad event URL: " + uri);
        if (this.i && !z) {
            throw new Exception("Attempted to handle action without user interaction.");
        }
        a(context, uri, aoVar, baseAdUnit);
    }
}
