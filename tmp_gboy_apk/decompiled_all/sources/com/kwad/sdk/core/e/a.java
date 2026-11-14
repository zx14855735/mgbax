package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.e;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.core.e.a.m;
import com.kwad.sdk.core.e.a.n;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    static {
        adgc();
    }

    public static /* synthetic */ void FF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String JY() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String h = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = h;
        return h;
    }

    private static /* synthetic */ void adgc() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eH(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ag.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    public static String getAppOAID(Context context) {
        if (bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid())) {
            return bc.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (!bc.useOaidDisable() && s.RJ()) {
            initAsync(context);
            return sOAID;
        }
        String JY = JY();
        sOAID = JY;
        return JY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getOAIDNormal(Context context) {
        char c;
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1706170181:
                    if (upperCase.equals(ADBidEvent.XIAOMI)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 2634924:
                    if (upperCase.equals(ADBidEvent.VIVO)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 68924490:
                    if (upperCase.equals("HONOR")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 2141820391:
                    if (upperCase.equals(ADBidEvent.HUAWEI)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    sOAID = new d(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new b(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new m(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new j(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new l(applicationContext).getOAID();
                    break;
                case 7:
                case '\b':
                    sOAID = new e(applicationContext).getOAID();
                    break;
                case '\t':
                    sOAID = new f(applicationContext).getOAID();
                    break;
                case '\n':
                    sOAID = new g(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new k(applicationContext).getOAID();
                    break;
                case '\f':
                    sOAID = new com.kwad.sdk.core.e.a.a(applicationContext).getOAID();
                    break;
                case '\r':
                case 14:
                case 15:
                    sOAID = new n(applicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
            eH(sOAID);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                String unused = a.sOAID = a.JY();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eH(str);
                                a.FF();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.eH(str);
                                a.FF();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }
}
