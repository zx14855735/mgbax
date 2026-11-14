package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.c.c;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    private static final Map<String, String> azd = new HashMap();
    private final AtomicBoolean RD;
    private final AtomicBoolean aze;
    private final AtomicBoolean azf;
    private final AtomicBoolean azg;
    private final List<String> azh;
    private final List<String> azi;
    private final d azj;
    private final BroadcastReceiver azk;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    public static class a {
        private static final b azn = new b(0);

        static {
            ZmhmQ();
        }

        private static /* synthetic */ void ZmhmQ() {
            char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ ' ');
            }
            String str = new String(charArray);
            char[] charArray2 = "CLINIT".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ ' ');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        mXKA();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Context context, String str) {
        A2egSU.B7CMnp("installApp packageName: ", str, "AppInstallManager");
        F(context, str);
        cK(str);
        D(context, str);
    }

    private void D(Context context, String str) {
        com.kwad.sdk.core.c.b.Ji();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            E(context, str);
            return;
        }
        this.azh.add(str);
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.azh.size() > 0) {
                    for (int i = 0; i < b.this.azh.size(); i++) {
                        b.E(b.this.mContext, (String) b.this.azh.get(i));
                    }
                    b.this.azh.clear();
                }
                com.kwad.sdk.core.c.b.Ji();
                com.kwad.sdk.core.c.b.b((c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Context context, String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.RL()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.e(context, str), 1);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private static void F(Context context, String str) {
        str.getClass();
        switch (str) {
            case "com.tencent.mm":
                azd.put("com.tencent.mm", m.Q(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                azd.put("com.kuaishou.nebula", m.Q(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                azd.put("com.smile.gifmaker", m.Q(context, "com.smile.gifmaker"));
                break;
        }
    }

    public static b Fi() {
        return a.azn;
    }

    private void Fj() {
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.Fn();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Fm();
                    b.this.Fo();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        });
    }

    private void Fk() {
        if (this.azg.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(this.azj);
        this.azg.set(true);
    }

    private void Fl() {
        if (this.azg.get()) {
            com.kwad.sdk.core.c.b.Ji();
            com.kwad.sdk.core.c.b.b((c) this.azj);
            this.azg.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        Context Re = ServiceProvider.Re();
        bp(Re);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).CZ().iterator();
        while (it.hasNext()) {
            AdInfo er = e.er(it.next());
            int bC = com.kwad.sdk.core.response.b.a.bC(er);
            String az = com.kwad.sdk.core.response.b.a.az(er);
            if (bC != 12) {
                if (as.at(Re, az)) {
                    C(Re, az);
                }
            } else if (!as.at(Re, az)) {
                cH(az);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn() {
        if (this.RD.get()) {
            ServiceProvider.Re().unregisterReceiver(this.azk);
            this.RD.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo() {
        if (this.RD.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.Re().registerReceiver(this.azk, intentFilter);
        this.RD.set(true);
    }

    private synchronized void bo(Context context) {
        if (this.aze.get()) {
            return;
        }
        F(context, "com.smile.gifmaker");
        F(context, "com.kuaishou.nebula");
        F(context, "com.tencent.mm");
        this.aze.set(true);
    }

    private void bp(Context context) {
        if (this.aze.get()) {
            for (String str : azd.keySet()) {
                String str2 = azd.get(str);
                String Q = m.Q(context, str);
                if (!TextUtils.isEmpty(Q) && !TextUtils.equals(str2, Q)) {
                    C(context, str);
                } else if (TextUtils.isEmpty(Q) && !TextUtils.isEmpty(str2)) {
                    cH(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(String str) {
        A2egSU.B7CMnp("unInstallApp packageName: ", str, "AppInstallManager");
        cM(str);
        cL(str);
        cI(str);
    }

    private void cI(String str) {
        com.kwad.sdk.core.c.b.Ji();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cJ(str);
            return;
        }
        this.azi.add(str);
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.azi.size() > 0) {
                    for (int i = 0; i < b.this.azi.size(); i++) {
                        b.cJ((String) b.this.azi.get(i));
                    }
                    b.this.azi.clear();
                }
                com.kwad.sdk.core.c.b.Ji();
                com.kwad.sdk.core.c.b.b((c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cJ(String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.RL()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.C(str), 2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void cK(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().U(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    private void cL(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().V(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    private static void cM(String str) {
        str.getClass();
        switch (str) {
            case "com.tencent.mm":
                azd.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                azd.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                azd.put("com.smile.gifmaker", "");
                break;
        }
    }

    private static /* synthetic */ void mXKA() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        bo(context);
        return azd.get(str);
    }

    public final synchronized void init() {
        try {
            if (this.azf.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).DD()) {
                Fl();
                if (((h) ServiceProvider.get(h.class)).DC()) {
                    com.kwad.sdk.core.c.b.Ji();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        Fo();
                    }
                    Fj();
                } else {
                    Fo();
                }
                this.azf.set(true);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private b() {
        this.aze = new AtomicBoolean();
        this.azf = new AtomicBoolean();
        this.RD = new AtomicBoolean();
        this.azg = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.azh = new CopyOnWriteArrayList();
        this.azi = new CopyOnWriteArrayList();
        this.azj = new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Fm();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.azk = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent azm;

            private boolean d(Intent intent) {
                boolean z = TextUtils.equals(this.azm.getAction(), intent.getAction()) && this.azm.getFlags() == intent.getFlags() && TextUtils.equals(this.azm.getDataString(), intent.getDataString());
                this.azm = intent;
                return z;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    if (this.azm == null) {
                        this.azm = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    com.kwad.sdk.core.d.c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action) && (data = intent.getData()) != null) {
                        String schemeSpecificPart = data.getSchemeSpecificPart();
                        if (TextUtils.isEmpty(schemeSpecificPart)) {
                            return;
                        }
                        b.this.mContext = context;
                        if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                            b.this.C(context, schemeSpecificPart);
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                            b.this.cH(schemeSpecificPart);
                        }
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Fk();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Fk();
        this.mListeners.add(aVar);
    }
}
