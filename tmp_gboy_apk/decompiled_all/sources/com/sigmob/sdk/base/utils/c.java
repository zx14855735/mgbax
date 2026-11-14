package com.sigmob.sdk.base.utils;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, a> f13214a = new HashMap<>();
    public static int b = 0;
    public static int c = 1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f13215a = 0;
        public Integer b = 0;

        public String toString() {
            return "CLickCallbackObj{clickLoseRate=" + this.f13215a + ", clickCbState=" + this.b + '}';
        }
    }

    static {
        igyj();
    }

    public static a a(String str, BaseAdUnit baseAdUnit) {
        SigmobLog.d(str + "#calResultWithAssign");
        a b2 = b(str, baseAdUnit);
        a(str, baseAdUnit, b2);
        return b2;
    }

    public static a b(String str, BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return null;
        }
        String requestId = baseAdUnit.getRequestId();
        int ad_type = baseAdUnit.getAd_type();
        HashMap<String, a> hashMap = f13214a;
        if (hashMap.get(requestId) == null) {
            a(baseAdUnit);
        }
        a aVar = hashMap.get(requestId);
        SigmobLog.d(str + "#getObj: requestId = " + requestId + ", adType = " + ad_type + ", obj = " + aVar);
        return aVar;
    }

    private static /* synthetic */ void igyj() {
        char[] charArray = "¢®¬ï¦ ¬¤ï£®¸ï²©¤\u00ad\u00adï\u008b¯¨\u0083³¨¥¦¤".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 193);
        }
        String str = new String(charArray);
        char[] charArray2 = "¢\u00ad¨¯¨µ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 193);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(BaseAdUnit baseAdUnit) {
        SlotAdSetting slotAdSetting;
        if (baseAdUnit == null || (slotAdSetting = baseAdUnit.getSlotAdSetting()) == null) {
            return;
        }
        String requestId = baseAdUnit.getRequestId();
        Integer num = slotAdSetting.click_lose_rate;
        if (num == null) {
            return;
        }
        a(requestId, num, Integer.valueOf(new Random().nextInt(100) + 1 > num.intValue() ? 0 : 1));
    }

    public static void a(String str, BaseAdUnit baseAdUnit, a aVar) {
        SigmobLog.d(str + "#assignValue: start");
        if (baseAdUnit == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(aVar == null ? 0 : aVar.f13215a.intValue());
        Integer valueOf2 = Integer.valueOf(aVar == null ? b : aVar.b.intValue());
        ClickCommon clickCommon = baseAdUnit.getClickCommon();
        clickCommon.click_lose_rate = valueOf;
        clickCommon.click_cb_state = valueOf2;
        baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._ISNC_, String.valueOf(valueOf2));
        SigmobLog.d(str + "#assignValue: end");
    }

    public static void a(String str, Integer num, Integer num2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, a> hashMap = f13214a;
        if (hashMap.get(str) == null) {
            a aVar = new a();
            aVar.f13215a = num;
            aVar.b = num2;
            hashMap.put(str, aVar);
        }
    }

    public static boolean a(a aVar) {
        Integer num;
        return aVar == null || (num = aVar.b) == null || num.intValue() == b;
    }
}
