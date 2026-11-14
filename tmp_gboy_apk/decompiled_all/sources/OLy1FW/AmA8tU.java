package OLy1FW;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f6371A2egSU = {2130969047};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Map f6372A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Map f6373A5SV6n;

    static {
        AZkASS aZkASS = new AZkASS();
        AaHO0E aaHO0E = new AaHO0E();
        HashMap hashMap = new HashMap();
        hashMap.put("fcnt", aZkASS);
        hashMap.put("google", aZkASS);
        hashMap.put("hmd global", aZkASS);
        hashMap.put("infinix", aZkASS);
        hashMap.put("infinix mobility limited", aZkASS);
        hashMap.put("itel", aZkASS);
        hashMap.put("kyocera", aZkASS);
        hashMap.put("lenovo", aZkASS);
        hashMap.put("lge", aZkASS);
        hashMap.put("meizu", aZkASS);
        hashMap.put("motorola", aZkASS);
        hashMap.put("nothing", aZkASS);
        hashMap.put("oneplus", aZkASS);
        hashMap.put("oppo", aZkASS);
        hashMap.put("realme", aZkASS);
        hashMap.put("robolectric", aZkASS);
        hashMap.put("samsung", aaHO0E);
        hashMap.put("sharp", aZkASS);
        hashMap.put("shift", aZkASS);
        hashMap.put("sony", aZkASS);
        hashMap.put("tcl", aZkASS);
        hashMap.put("tecno", aZkASS);
        hashMap.put("tecno mobile limited", aZkASS);
        hashMap.put("vivo", aZkASS);
        hashMap.put("wingtech", aZkASS);
        hashMap.put(MediationConstant.ADN_XIAOMI, aZkASS);
        f6372A4TApA = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", aZkASS);
        hashMap2.put("jio", aZkASS);
        f6373A5SV6n = Collections.unmodifiableMap(hashMap2);
        aIGeiA();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
    
        if (r4.compareTo(r5) >= 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A2egSU(androidx.fragment.app.FragmentActivity r18, OLy1FW.B2KMhB r19) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OLy1FW.AmA8tU.A2egSU(androidx.fragment.app.FragmentActivity, OLy1FW.B2KMhB):void");
    }

    private static /* synthetic */ void aIGeiA() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
