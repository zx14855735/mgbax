package com.sigmob.windad;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.windad.consent.ConsentStatus;
import com.sigmob.windad.consent.WindAdConsentInformation;
import java.util.ArrayList;
import java.util.logging.Level;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindAds {
    public static final String ADN_ID = "ADN_ID";
    public static final String ADX_ID = "_adx_id";
    public static final String AD_SCENE_DESC = "scene_desc";
    public static final String AD_SCENE_ID = "scene_id";
    public static final String AUCTION_PRICE = "AUCTION_PRICE";
    public static final String CNY = "CNY";
    public static final String CURRENCY = "CURRENCY";
    public static final String HIGHEST_LOSS_PRICE = "HIGHEST_LOSS_PRICE";
    public static final String LOSS_REASON = "LOSS_REASON";
    public static final String REWARD_TYPE = "reward_type";
    public static final String SERVER_ARRIVED = "server_arrived";
    public static final String TAG = "WindAds";
    public static final String TRANS_ID = "trans_id";
    public static final String USD = "USD";

    /* renamed from: a, reason: collision with root package name */
    private static volatile WindAds f13784a;
    private boolean e;
    private OnInitializationListener g;
    private int i;
    private int k;
    private int l;
    private Context m;
    private volatile boolean b = false;
    private volatile boolean c = false;
    private boolean h = true;
    private boolean j = true;
    private boolean n = true;
    private WindAdOptions d = null;
    private Handler f = new Handler(Looper.getMainLooper());

    /* renamed from: com.sigmob.windad.WindAds$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13786a;

        static {
            int[] iArr = new int[ConsentStatus.values().length];
            f13786a = iArr;
            try {
                iArr[ConsentStatus.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13786a[ConsentStatus.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13786a[ConsentStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private WindAds() {
    }

    private void b() {
        OnInitializationListener onInitializationListener = this.g;
        if (onInitializationListener == null) {
            return;
        }
        onInitializationListener.onInitializationSuccess();
    }

    private void c() {
        if (this.i == 0) {
            try {
                this.i = i.a().g();
            } catch (Throwable unused) {
            }
            if (this.i == 0) {
                try {
                    int i = AnonymousClass2.f13786a[WindAdConsentInformation.getInstance(b.e()).getConsentStatus().ordinal()];
                    int i2 = 1;
                    if (i != 1) {
                        i2 = 2;
                        if (i != 2) {
                        }
                    }
                    this.i = i2;
                } catch (Throwable unused2) {
                }
            }
        }
        i.a().c(this.i, false);
    }

    private void d() {
        try {
            if (this.k == 0) {
                this.k = i.a().c();
            } else {
                i.a().b(this.k, false);
            }
            if (this.l == 0) {
                this.l = i.a().b();
            } else {
                i.a().a(this.l, false);
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        try {
            d();
            c();
            i.a().b(this.j, false);
            i.a().a(this.h, false);
        } catch (Throwable th) {
            A2egSU.BJ7GGh(th, new StringBuilder("loadPrivacyInfo: error = "));
        }
    }

    public static String getUserId() {
        return ClientMetadata.getUserId();
    }

    public static String getVersion() {
        return n.k;
    }

    public static void requestPermission(Activity activity) {
        if (activity == null || Build.VERSION.SDK_INT < 23 || ClientMetadata.isPermissionGranted(activity, g.c)) {
            return;
        }
        activity.requestPermissions(new String[]{g.c}, 0);
    }

    public static void setOAIDCertPem(String str) {
        try {
            ClientMetadata.setOAIDCertPem(str);
        } catch (Throwable unused) {
            com.sigmob.sdk.base.utils.i.f(TAG, "not support OAID module.", new Object[0]);
        }
    }

    public static void setUserId(String str) {
        ClientMetadata.setUserId(str);
    }

    public static WindAds sharedAds() {
        if (f13784a == null) {
            synchronized (WindAds.class) {
                try {
                    if (f13784a == null) {
                        WindAds windAds = new WindAds();
                        windAds.setDebugEnable(true);
                        f13784a = windAds;
                    }
                } finally {
                }
            }
        }
        return f13784a;
    }

    public int a() {
        return 159;
    }

    public void checkAndResGuard(Context context) {
        if (ResourceUtil.getLayoutId(context, "sig_new_interstitial_layout") != 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>() { // from class: com.sigmob.windad.WindAds.1
            {
                add("R.string.sig_*");
                add("R.integer.sig_*");
                add("R.layout.sig_*");
                add("R.drawable.sig_*");
                add("R.style.sig_*");
                add("R.dimen.sig_*");
                add("R.anim.sig_*");
                add("R.color.sig_*");
                add("R.id.sig_*");
                add("R.attr.sig_*");
            }
        };
        com.sigmob.sdk.base.utils.i.f(TAG, "The Wind SDK resources may have been obfuscated by AndResGuard. Please add the following " + arrayList + " to the whitelist.", new Object[0]);
    }

    public int getAgeRestrictedStatus() {
        return this.k;
    }

    public String getAppId() {
        WindAdOptions windAdOptions = this.d;
        if (windAdOptions == null) {
            return null;
        }
        return windAdOptions.getAppId();
    }

    public String getAppKey() {
        WindAdOptions windAdOptions = this.d;
        if (windAdOptions == null) {
            return null;
        }
        return windAdOptions.getAppKey();
    }

    public int getCommonVersion() {
        try {
            return Constants.getVersion();
        } catch (Throwable unused) {
            return 186;
        }
    }

    public Handler getHandler() {
        if (this.f == null) {
            this.f = new Handler(Looper.getMainLooper());
        }
        return this.f;
    }

    public WindAdOptions getOptions() {
        return this.d;
    }

    public String getSDKToken() {
        if (this.c) {
            com.sigmob.sdk.base.utils.i.c(TAG, "getSDKToken: SDK is ready, Retrieving token.", new Object[0]);
            return Sigmob.getInstance().getSDKToken();
        }
        com.sigmob.sdk.base.utils.i.f(TAG, "getSDKToken: SDK is not ready, Cannot retrieve token.", new Object[0]);
        return null;
    }

    public boolean getSensorStatus() {
        return this.n;
    }

    public int getUserAge() {
        return this.l;
    }

    public int getUserGDPRConsentStatus() {
        return this.i;
    }

    public String getWindUid() {
        try {
            return ClientMetadata.getUid();
        } catch (Exception e) {
            SigmobLog.e("getWindUid: error = " + e.getMessage());
            return null;
        }
    }

    public boolean init(Context context, WindAdOptions windAdOptions, OnInitializationListener onInitializationListener) {
        synchronized (this) {
            try {
                this.g = onInitializationListener;
                if (!this.b) {
                    if (context == null) {
                        a("context is null.");
                    } else if (windAdOptions == null) {
                        a("WindAdOptions is null.");
                    } else if (TextUtils.isEmpty(windAdOptions.getAppId())) {
                        a("appId is empty.");
                    } else if (getCommonVersion() < 186) {
                        a("Your COMMON Lib version must be equal or higher than 186, current Version :[ " + getCommonVersion() + " ]");
                    } else {
                        checkAndResGuard(context);
                        this.d = windAdOptions;
                        this.m = context.getApplicationContext();
                        this.b = true;
                    }
                    return false;
                }
                b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isAdult() {
        return this.h;
    }

    public boolean isDebugEnable() {
        return this.e;
    }

    public boolean isInit() {
        return this.b;
    }

    public boolean isPersonalizedAdvertisingOn() {
        return this.j;
    }

    public void setAdult(boolean z) {
        this.h = z;
        com.sigmob.sdk.base.utils.i.b(TAG, "setAdult: result = " + z, new Object[0]);
        if (this.c) {
            i.a().a(z, true);
        }
    }

    public void setDebugEnable(boolean z) {
        this.e = z;
        if (n.f.booleanValue()) {
            SigmobLog.setSdkHandlerLevel(z ? Level.FINE : Level.SEVERE);
        } else {
            SigmobLog.setSdkHandlerLevel(z ? Level.INFO : Level.SEVERE);
        }
    }

    public void setIsAgeRestrictedUser(int i) {
        this.k = i;
        if (this.c) {
            i.a().b(i, true);
        }
    }

    public void setOAIDCertFileName(String str) {
        ClientMetadata.setOaidCertFileName(str);
    }

    public void setPersonalizedAdvertisingOn(boolean z) {
        this.j = z;
        com.sigmob.sdk.base.utils.i.b(TAG, "setPersonalized: result = " + z, new Object[0]);
        if (this.c) {
            i.a().b(z, true);
        }
    }

    public void setSensorStatus(boolean z) {
        this.n = z;
        com.sigmob.sdk.base.utils.i.b(TAG, "setSensorStatus: status = " + z, new Object[0]);
    }

    public void setUserAge(int i) {
        this.l = i;
        if (this.c) {
            i.a().a(i, true);
        }
    }

    public void setUserGDPRConsentStatus(int i) {
        this.i = i;
        if (this.c) {
            i.a().c(i, true);
        }
    }

    public void start(OnStartListener onStartListener) {
        synchronized (this) {
            try {
                if (this.b) {
                    if (!this.c) {
                        b.a(this.m.getApplicationContext());
                        e();
                        Sigmob.getInstance().init();
                        this.c = true;
                        com.sigmob.sdk.base.utils.i.b(TAG, "start: appId = " + this.d.getAppId(), new Object[0]);
                    }
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else if (onStartListener != null) {
                    onStartListener.onStartFail("Wind SDK Start fail, need Init SDK first.");
                }
            } catch (Throwable th) {
                if (onStartListener != null) {
                    onStartListener.onStartFail("Wind SDK Start fail Exception " + th.getMessage());
                }
                com.sigmob.sdk.base.utils.i.f(TAG, "start: error = " + th.getMessage(), new Object[0]);
            } finally {
            }
        }
    }

    private void a(String str) {
        com.sigmob.sdk.base.utils.i.f(TAG, CtFAbx.BChYOn("notifyInitError: error = ", str), new Object[0]);
        OnInitializationListener onInitializationListener = this.g;
        if (onInitializationListener == null) {
            return;
        }
        onInitializationListener.onInitializationFail(str);
    }
}
