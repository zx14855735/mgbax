package com.kwad.sdk.utils;

import BPw6Q8.ASJ6gh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bh {
    private static Context bfp;
    private static Map<String, l> bfq = new HashMap();

    public static class a extends l<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b bfr;

        public a(boolean z) {
            super(z);
        }

        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) z.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.l
        /* renamed from: dW, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.l.a.b cM(Context context) {
            int i;
            int i2;
            if (bc.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
                return bfr;
            }
            com.kwad.sdk.l.a.b bVar = bfr;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || bc.readLocationDisable()) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23 && ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) == -1) {
                return null;
            }
            if (br.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    i2 = cdmaCellLocation.getBaseStationId();
                    i = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    i2 = gsmCellLocation.getCid();
                    i = gsmCellLocation.getLac();
                } else {
                    i = -1;
                    i2 = -1;
                }
                Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CellInfo next = it.next();
                    if (next != null && next.isRegistered()) {
                        cellInfo = next;
                        break;
                    }
                }
                bfr = new com.kwad.sdk.l.a.b(i2, i, cellInfo != null ? a(cellInfo) : -1);
            }
            return bfr;
        }
    }

    public static class b extends l<com.kwad.sdk.l.a.f> {
        public b(boolean z) {
            super(z);
        }

        private static com.kwad.sdk.l.a.f dX(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.bbP = bd.dJ(context);
            fVar.bbO = bd.dH(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.l
        public final /* synthetic */ com.kwad.sdk.l.a.f cM(Context context) {
            return dX(context);
        }
    }

    static {
        sIYIKaL();
    }

    public static com.kwad.sdk.l.a.b QD() {
        if (Tn()) {
            return (com.kwad.sdk.l.a.b) hC("baseStationEnable");
        }
        return null;
    }

    public static com.kwad.sdk.l.a.f QE() {
        if (Tn()) {
            return (com.kwad.sdk.l.a.f) hC("simCardInfoEnable");
        }
        return null;
    }

    private static boolean Tn() {
        return bfp != null;
    }

    private static <T> l<T> hB(String str) {
        try {
            return bfq.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static <T> T hC(String str) {
        l hB = hB(str);
        if (hB != null) {
            return (T) hB.cL(bfp);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (!Tn()) {
            bfp = context.getApplicationContext();
            bfq.put("baseStationEnable", new a(hVar.Dg()));
            bfq.put("simCardInfoEnable", new b(hVar.De()));
            return;
        }
        if (bfq.containsKey("baseStationEnable")) {
            boolean Dg = hVar.Dg();
            l hB = hB("baseStationEnable");
            if (hB != null) {
                hB.ce(Dg);
            }
        }
        if (bfq.containsKey("simCardInfoEnable")) {
            boolean De = hVar.De();
            l hB2 = hB("simCardInfoEnable");
            if (hB2 != null) {
                hB2.ce(De);
            }
        }
    }

    private static /* synthetic */ void sIYIKaL() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
