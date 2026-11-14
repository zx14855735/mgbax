package com.kwad.components.core.innerEc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.innerEc.a.k;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener;
import com.kwad.components.offline.api.adInnerEc.login.InnerEcLoginResponse;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwai.auth.login.kwailogin.applogin.RouteHandlerActivity;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e {
    private static volatile e RA;
    private static final AtomicBoolean RC = new AtomicBoolean(false);
    private static final AtomicBoolean RD = new AtomicBoolean(false);
    private IAdInnerEcExternalModule RB;
    private final String TAG = "InnerEcLoginManager";
    private long expire;
    private String serviceToken;
    private String sid;
    private long userId;

    static {
        MmeeVko();
    }

    private static /* synthetic */ void MmeeVko() {
        char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 17);
        }
        String str = new String(charArray);
        char[] charArray2 = "r}x\u007fxe".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 17);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void b(String str, c cVar, String str2) {
        new d().a(str, cVar, str2);
    }

    private void init() {
        AtomicBoolean atomicBoolean = RC;
        if (atomicBoolean.get()) {
            return;
        }
        AtomicBoolean atomicBoolean2 = RD;
        if (!atomicBoolean2.get()) {
            com.kwad.sdk.service.c.putComponentProxy(RouteHandlerActivity.class, RouteHandlerActivityProxy.class);
            atomicBoolean2.set(true);
        }
        com.kwad.components.core.offline.a.a.a aVar = (com.kwad.components.core.offline.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.a.a.class);
        if (aVar == null || !aVar.rl()) {
            return;
        }
        Context context = ServiceProvider.getContext();
        com.kwad.sdk.core.d.c.w("InnerEcLoginManager", "getApp: " + context);
        context.getApplicationContext();
        IAdInnerEcExternalModule rm = aVar.rm();
        this.RB = rm;
        if (rm != null) {
            atomicBoolean.set(true);
            qJ();
        }
    }

    public static e qH() {
        if (RA == null) {
            synchronized (e.class) {
                try {
                    if (RA == null) {
                        RA = new e();
                    }
                } finally {
                }
            }
        }
        if (!RC.get()) {
            RA.init();
        }
        return RA;
    }

    private boolean qJ() {
        try {
            String d = ag.d(ServiceProvider.getContext(), true);
            if (!TextUtils.isEmpty(d)) {
                InnerEcUserLoginBindInfo innerEcUserLoginBindInfo = new InnerEcUserLoginBindInfo();
                innerEcUserLoginBindInfo.parseJson(new JSONObject(d));
                this.userId = innerEcUserLoginBindInfo.userId;
                this.serviceToken = innerEcUserLoginBindInfo.serviceToken;
                this.expire = innerEcUserLoginBindInfo.expire;
                this.sid = innerEcUserLoginBindInfo.sid;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return false;
        }
    }

    public final void a(Activity activity, IAdInnerEcLoginBindListener iAdInnerEcLoginBindListener) {
        com.kwad.sdk.core.d.c.i("InnerEcLoginManager", "click start");
        if (!RC.get()) {
            iAdInnerEcLoginBindListener.onFailed(-1, "adInnerEcExternalModule is null", 2);
            return;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModule = this.RB;
        if (iAdInnerEcExternalModule == null) {
            iAdInnerEcLoginBindListener.onFailed(-1, "adInnerEcExternalModule is null", 2);
        } else {
            iAdInnerEcExternalModule.startLoginAuth(activity, iAdInnerEcLoginBindListener);
        }
    }

    public final String getServiceToken() {
        return this.serviceToken;
    }

    public final String getSid() {
        return this.sid;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final boolean qI() {
        if (ag.Sg()) {
            return false;
        }
        return (!ag.Sf() || qJ()) && this.expire > 0 && !TextUtils.isEmpty(this.serviceToken) && !TextUtils.isEmpty(this.sid) && this.userId > 0 && System.currentTimeMillis() < this.expire;
    }

    public static void a(Context context, AdTemplate adTemplate, k kVar) {
        StringBuilder sb = new StringBuilder("startLoginWithH5 mIsReady: ");
        AtomicBoolean atomicBoolean = RC;
        sb.append(atomicBoolean.get());
        com.kwad.sdk.core.d.c.w("jky", sb.toString());
        if (atomicBoolean.get()) {
            String Ik = com.kwad.sdk.core.config.e.Ik();
            if (TextUtils.isEmpty(Ik)) {
                kVar.oB();
            } else {
                AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0304a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aJ(Ik).aG(adTemplate).aQ(3).b(kVar).rV());
            }
        }
    }

    public final void a(long j, String str, long j2, String str2, String str3) {
        this.userId = j;
        this.serviceToken = str;
        this.expire = j2;
        this.sid = str2;
        ag.c(ServiceProvider.getContext(), str3, false);
    }

    public final void a(InnerEcLoginResponse innerEcLoginResponse, Activity activity) {
        if (!RC.get()) {
            activity.finish();
            return;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModule = this.RB;
        if (iAdInnerEcExternalModule == null) {
            activity.finish();
        } else {
            iAdInnerEcExternalModule.handleLoginResponse(innerEcLoginResponse, activity);
        }
    }
}
