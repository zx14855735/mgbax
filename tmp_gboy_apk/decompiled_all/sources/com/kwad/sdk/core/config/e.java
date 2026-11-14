package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.config.item.s;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.h;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static volatile SdkConfigData aGT;
    private static final AtomicBoolean aGS = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    static {
        nDQMzM();
    }

    public static boolean Bb() {
        return c.aFy.getValue().booleanValue();
    }

    public static int CQ() {
        return c.aDh.getValue().intValue();
    }

    public static boolean CR() {
        return false;
    }

    public static boolean CS() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return c.aDm.getValue().intValue() == 1;
    }

    public static boolean DA() {
        return c.aFZ.It();
    }

    public static boolean DH() {
        return c.aGs.getValue().booleanValue();
    }

    public static int DI() {
        return c.aGt.getValue().intValue();
    }

    public static boolean DJ() {
        int intValue = c.aGu.getValue().intValue();
        return intValue == 2 || intValue == 3;
    }

    public static int DK() {
        return c.aGM.getValue().intValue();
    }

    public static boolean DQ() {
        return c.aGk.It();
    }

    public static boolean De() {
        return c.aEj.getValue().intValue() == 1;
    }

    public static boolean Dg() {
        return c.aEk.getValue().intValue() == 1;
    }

    public static boolean Dh() {
        return c.aEi.getValue().intValue() == 1;
    }

    public static String Di() {
        return c.aEw.getImei();
    }

    public static String Dj() {
        return c.aEw.getOaid();
    }

    public static List<String> Dk() {
        return c.aDP.getValue();
    }

    public static boolean Dl() {
        return c.aEI.getValue().intValue() == 1;
    }

    public static boolean Dm() {
        return c.aEJ.getValue().booleanValue();
    }

    public static boolean Dn() {
        return c.aEL.getValue().intValue() == 1;
    }

    public static boolean Dp() {
        return c.aFi.getValue().booleanValue();
    }

    public static boolean Dq() {
        return c.aFj.getValue().booleanValue();
    }

    public static int Dr() {
        if (aGT != null) {
            return aGT.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int Ds() {
        return c.aFl.getValue().intValue();
    }

    public static double Dt() {
        return c.aET.getValue().floatValue();
    }

    public static boolean Du() {
        return c.aFF.getValue().booleanValue();
    }

    public static boolean Dy() {
        return c.aFV.getValue().booleanValue();
    }

    @Deprecated
    public static int Dz() {
        return c.aDE.getValue().intValue();
    }

    public static boolean GD() {
        return c.aDr.getValue().intValue() == 1;
    }

    public static int GE() {
        return c.aDs.getValue().intValue();
    }

    public static int GF() {
        return c.aDt.getValue().intValue();
    }

    public static boolean GG() {
        return c.aDv.getValue().intValue() > 0;
    }

    public static boolean GH() {
        return c.aDt.getValue().intValue() == 2;
    }

    public static int GI() {
        return c.aDu.getValue().intValue();
    }

    public static boolean GJ() {
        return c.aDz.getValue().intValue() > 0;
    }

    public static boolean GK() {
        return c.aDA.getValue().intValue() == 1;
    }

    public static int GL() {
        return c.aDz.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void GM() {
        com.kwad.components.ad.e.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> GN() {
        return c.aDR.getValue();
    }

    public static List<String> GO() {
        return c.aDQ.getValue();
    }

    public static int GP() {
        return c.aFs.getValue().intValue();
    }

    public static int GQ() {
        return c.aFt.getValue().intValue();
    }

    public static String GR() {
        return c.aDL.getValue();
    }

    public static String GS() {
        return c.aDM.getValue();
    }

    public static boolean GT() {
        return c.aDn.getValue().intValue() == 1;
    }

    public static int GU() {
        return c.aDo.getValue().intValue();
    }

    public static boolean GV() {
        return c.aDp.getValue().intValue() == 1;
    }

    public static int GW() {
        return c.aDq.getValue().intValue();
    }

    public static int GX() {
        return c.aEa.getValue().intValue();
    }

    public static int GY() {
        return c.aEb.getValue().intValue();
    }

    public static int GZ() {
        return c.aEc.getValue().intValue();
    }

    public static boolean HA() {
        return c.aEY.getValue().booleanValue();
    }

    public static boolean HB() {
        return c.aEZ.getValue().intValue() > 0;
    }

    public static boolean HC() {
        return c.aFg.getValue().intValue() == 1;
    }

    public static long HD() {
        return c.aFe.getValue().longValue();
    }

    public static boolean HE() {
        return c.aFk.It();
    }

    public static com.kwad.sdk.core.network.idc.a.b HF() {
        return c.aFm.getValue();
    }

    public static int HG() {
        return c.aFn.getValue().intValue();
    }

    public static long HH() {
        return c.aFo.getValue().longValue();
    }

    public static int HI() {
        return c.aFp.getValue().intValue();
    }

    public static boolean HJ() {
        return c.aFq.getValue().floatValue() == 1.0f;
    }

    public static boolean HK() {
        return c.aFr.It();
    }

    public static boolean HL() {
        return c.aFu.It();
    }

    public static String HM() {
        return c.aFv.getValue();
    }

    public static String HN() {
        return c.aFw.getValue();
    }

    public static String HO() {
        return c.aFx.getValue();
    }

    public static boolean HP() {
        return c.aFz.getValue().booleanValue();
    }

    public static int HQ() {
        return c.aFA.getValue().intValue();
    }

    public static int HR() {
        return c.aFC.getValue().intValue();
    }

    public static boolean HS() {
        return c.aFH.getValue().booleanValue();
    }

    public static int HT() {
        return c.aFI.getValue().intValue();
    }

    public static boolean HU() {
        return c.aGh.It();
    }

    public static boolean HV() {
        return c.aGj.It();
    }

    public static boolean HW() {
        return c.aGo.getValue().booleanValue();
    }

    public static int HX() {
        return c.aGq.getValue().intValue();
    }

    public static int HY() {
        return c.aGp.getValue().intValue();
    }

    public static long HZ() {
        return c.aDx.getValue().longValue();
    }

    public static long Ha() {
        return c.aEd.getValue().intValue() * 60000;
    }

    public static boolean Hb() {
        return c.aEm.getValue().intValue() == 1;
    }

    public static boolean Hc() {
        return c.aEn.getValue().intValue() == 1;
    }

    public static int Hd() {
        return c.aEu.getValue().intValue();
    }

    public static boolean He() {
        return c.aEv.getValue().booleanValue();
    }

    public static boolean Hf() {
        return com.kwad.sdk.core.h.a.LG();
    }

    public static boolean Hg() {
        return a(c.aEB);
    }

    public static boolean Hh() {
        return !c.aEC.getValue().booleanValue();
    }

    public static boolean Hi() {
        return a(c.aEA);
    }

    public static boolean Hj() {
        return c.aEE.getValue().intValue() == 1;
    }

    public static int Hk() {
        return c.aEF.getValue().intValue();
    }

    public static SdkConfigData Hl() {
        if (aGT != null) {
            return aGT;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            aGT = Hm();
        } else {
            synchronized (mLock) {
                try {
                    if (aGT == null) {
                        return Hm();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aGT;
    }

    private static SdkConfigData Hm() {
        aGT = new SdkConfigData();
        String dk = ag.dk(ServiceProvider.Re());
        if (TextUtils.isEmpty(dk)) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "configCache is empty");
        } else {
            try {
                aGT.parseJson(new JSONObject(dk));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return aGT;
    }

    public static boolean Hn() {
        return c.aDB.getValue().intValue() == 1;
    }

    public static boolean Ho() {
        return c.aDC.getValue().intValue() == 1;
    }

    public static boolean Hp() {
        return c.aDF.getValue().booleanValue();
    }

    public static boolean Hq() {
        return c.aFh.getValue().intValue() == 1;
    }

    public static int Hr() {
        return c.aDD.getValue().intValue();
    }

    public static int Hs() {
        return c.aEN.getValue().intValue();
    }

    public static int Ht() {
        return c.aEM.getValue().intValue();
    }

    public static boolean Hu() {
        return c.aEO.getValue().intValue() == 1;
    }

    public static boolean Hv() {
        return c.aEP.getValue().booleanValue();
    }

    public static float Hw() {
        float floatValue = c.aEQ.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float Hx() {
        return c.aES.getValue().floatValue();
    }

    public static float Hy() {
        return c.aER.getValue().floatValue();
    }

    public static boolean Hz() {
        return c.aEU.getValue().booleanValue();
    }

    public static long Ia() {
        return c.aDy.getValue().longValue();
    }

    public static boolean Ib() {
        return c.aDf.getValue().booleanValue();
    }

    public static Long Ic() {
        return c.aDg.getValue();
    }

    public static boolean Id() {
        int intValue = c.aGu.getValue().intValue();
        return intValue == 1 || intValue == 3;
    }

    public static long Ie() {
        return c.aGv.getValue().longValue();
    }

    public static String If() {
        return c.aGy.getValue();
    }

    public static String Ig() {
        return c.aGI.getValue();
    }

    public static String Ih() {
        return c.aGJ.getValue();
    }

    public static boolean Ii() {
        return c.aGK.It();
    }

    public static String Ij() {
        return c.aGN.getValue();
    }

    public static String Ik() {
        return c.aGD.getValue();
    }

    public static String Il() {
        return c.aGE.getValue();
    }

    public static boolean Im() {
        return c.aGC.getValue().booleanValue();
    }

    public static String In() {
        return c.aGF.getValue();
    }

    public static String P(String str, String str2) {
        if (!bp.isNullString(str)) {
            JSONObject abConfig = Hl().getAbConfig();
            if (abConfig != null && abConfig.has(str)) {
                return abConfig.optString(str);
            }
            JSONObject appConfig = Hl().getAppConfig();
            if (appConfig != null && appConfig.has(str)) {
                return appConfig.optString(str);
            }
            JSONObject adxConfig = Hl().getAdxConfig();
            if (adxConfig != null && adxConfig.has(str)) {
                return adxConfig.optString(str);
            }
        }
        return str2;
    }

    public static JSONObject a(f fVar) {
        JSONObject jSONObject = (JSONObject) b(fVar);
        return jSONObject != null ? jSONObject : fVar.Io();
    }

    public static boolean ai(long j) {
        return (j & c.aDG.getValue().longValue()) != 0;
    }

    public static <T> T b(com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context Re = ServiceProvider.Re();
            b.a(Re, bVar);
            h.execute(new bg() { // from class: com.kwad.sdk.core.config.e.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    e.bB(Re);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.Io();
    }

    public static synchronized void bB(Context context) {
        synchronized (e.class) {
            AtomicBoolean atomicBoolean = aGS;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "loadCache");
            c.init();
            GM();
            b.bA(context);
            Hl();
            atomicBoolean.set(true);
        }
    }

    public static int ct(String str) {
        return c.aGn.dN(str);
    }

    public static int cu(String str) {
        Integer value = c.aDX.getValue(str);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    public static boolean f(String str, boolean z) {
        if (!bp.isNullString(str)) {
            JSONObject abConfig = Hl().getAbConfig();
            if (abConfig != null && abConfig.has(str)) {
                return abConfig.optBoolean(str);
            }
            JSONObject appConfig = Hl().getAppConfig();
            if (appConfig != null && appConfig.has(str)) {
                return appConfig.optBoolean(str);
            }
            JSONObject adxConfig = Hl().getAdxConfig();
            if (adxConfig != null && adxConfig.has(str)) {
                return adxConfig.optBoolean(str);
            }
        }
        return z;
    }

    public static String getLogObiwanData() {
        return c.aFd.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.aGi.getValue().intValue();
    }

    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.aGe.getValue();
    }

    public static String getUserAgent() {
        return c.aEK.getValue();
    }

    public static boolean hD() {
        return c.aEX.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return aGS.get();
    }

    private static /* synthetic */ void nDQMzM() {
        char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\\');
        }
        String str = new String(charArray);
        char[] charArray2 = "?0525(".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\\');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static JSONObject a(com.kwad.sdk.core.config.item.e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.Io();
    }

    public static int a(l lVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) lVar);
        if (num == null) {
            num = lVar.Io();
        }
        return num.intValue();
    }

    public static boolean b(l lVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) lVar);
        return num != null ? num.intValue() > 0 : lVar.Io().intValue() > 0;
    }

    public static long a(p pVar) {
        Long l = (Long) b(pVar);
        if (l == null) {
            l = pVar.Io();
        }
        return l.longValue();
    }

    public static double a(g gVar) {
        Double d = (Double) b(gVar);
        if (d == null) {
            d = gVar.Io();
        }
        return d.doubleValue();
    }

    public static void f(SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            aGT = sdkConfigData;
        }
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.Io();
        }
        return bool.booleanValue();
    }

    public static String a(s sVar) {
        String str = (String) b(sVar);
        return str != null ? str : sVar.Io();
    }
}
