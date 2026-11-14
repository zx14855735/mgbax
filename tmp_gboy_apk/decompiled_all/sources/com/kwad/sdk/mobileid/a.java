package com.kwad.sdk.mobileid;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.os.Build;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.mobileid.a.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.octopus.ad.ADBidEvent;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    private static String TAG = "MobileIdManager";
    public static com.kwad.sdk.mobileid.a.a.a aYf;
    private static Context mContext;

    private static d Pg() {
        Context context = mContext;
        int e = ao.e(context, bd.dF(context), bc.useNetworkStateDisable());
        try {
            if (!ao.isWifiConnected(mContext)) {
                d dVar = new d(true, "uaidTokenCanRequest");
                new com.kwad.sdk.mobileid.a.a().cr(mContext);
                com.kwad.sdk.core.d.c.w(TAG, "requestMobileIdByMobileData");
                return dVar;
            }
            boolean z = e == 1;
            boolean Ph = Ph();
            if (!z || Ph) {
                return z ? new d(false, "noRequestByBrand") : !Ph ? new d(false, "noRequestByNoCMCC") : new d(false, "noRequestByBrandAndCMCC");
            }
            d dVar2 = new d(true, "uaidTokenCanRequestByWifi");
            h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.cq(a.mContext);
                    com.kwad.sdk.core.d.c.w(a.TAG, "requestMobileIdChangeToyMobileData");
                    h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.Pi();
                            com.kwad.sdk.core.d.c.w(a.TAG, "schedule unbindNetwork");
                        }
                    }, 2L, TimeUnit.SECONDS);
                }
            }, e.Ia(), TimeUnit.SECONDS);
            return dVar2;
        } catch (Exception e2) {
            d dVar3 = new d(false, "noRequestByException");
            dVar3.gD(e2.getMessage());
            ServiceProvider.reportSdkCaughtException(e2);
            return dVar3;
        }
    }

    private static boolean Ph() {
        String str = Build.MANUFACTURER;
        com.kwad.sdk.core.d.c.w(TAG, "isHuaweiOrHonorDevice manufacturer: " + str);
        return ADBidEvent.HUAWEI.equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }

    public static void Pi() {
        synchronized (a.class) {
            try {
                if (aYf != null) {
                    com.kwad.sdk.core.d.c.w(TAG, "unbindNetwork");
                    aYf.Pi();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static d Pj() {
        boolean Sh = ag.Sh();
        return new d(Sh && !ag.St() && Pk(), !Sh ? "noRequestByUaidEnable" : ag.St() ? "noRequestByUaidExist" : !Pk() ? "noNetworkPermission" : "uaidTokenCanRequest");
    }

    private static boolean Pk() {
        String[] strArr = {g.b, g.d, "android.permission.CHANGE_NETWORK_STATE", g.f12282a};
        for (int i = 0; i < 4; i++) {
            if (ASJ6gh.A2egSU(ServiceProvider.getContext(), strArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cq(final Context context) {
        if (aYf == null) {
            aYf = new com.kwad.sdk.mobileid.a.a.a();
        }
        c.b(context, new d(true, "uaidTokenCanRequestByWifiPre"));
        aYf.a(context, new a.InterfaceC0383a() { // from class: com.kwad.sdk.mobileid.a.2
            @Override // com.kwad.sdk.mobileid.a.a.a.InterfaceC0383a
            public final void Pn() {
                new com.kwad.sdk.mobileid.a.a().b(context, true);
            }
        });
    }

    public static void init(Context context) {
        mContext = context;
        d Pj = Pj();
        if (Pj.isSuccess()) {
            Pj = Pg();
            com.kwad.sdk.core.d.c.d(TAG, "init success :" + Pj);
        } else {
            com.kwad.sdk.core.d.c.d(TAG, "init error: " + Pj.Po());
        }
        c.a(context, Pj);
    }
}
