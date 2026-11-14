package GnQT2j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static int f3096A2egSU;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static G58fqA.A4TApA f3100ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static G58fqA.A2egSU f3101ASJ6gh;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ArrayList f3097A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final HashMap f3098A5SV6n = new HashMap();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final HashMap f3099ADYaiT = new HashMap();
    public static final HashMap AMqCpz = new HashMap();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static boolean f3102AYUAbz = false;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static boolean f3103AZOQYO = false;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static boolean f3104AZkASS = false;

    static {
        MGhhq();
    }

    public static void A2egSU(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            HashMap hashMap = f3098A5SV6n;
            String str2 = (String) hashMap.get(str);
            ArrayList arrayList = f3097A4TApA;
            if (arrayList.contains(str2)) {
                arrayList.remove(str2);
            }
            hashMap.remove(str);
            f3099ADYaiT.remove(str);
            AMqCpz.remove(str);
        } catch (Exception e) {
            e.getMessage();
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        }
    }

    public static void A4TApA(String str, boolean z) {
        AZOQYO azoqyo = (AZOQYO) f3099ADYaiT.get(str);
        AZkASS aZkASS = (AZkASS) AMqCpz.get(str);
        if (azoqyo == null || aZkASS == null) {
            return;
        }
        if (z) {
            azoqyo.A4TApA(aZkASS.f3125A4TApA);
        } else {
            azoqyo.A5SV6n(aZkASS.f3125A4TApA, AZOQYO.f3116AYUAbz);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Exception, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStream, java.lang.Object] */
    public static Bitmap A5SV6n(String str) {
        ?? r3;
        ?? r1 = null;
        try {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    HttpURLConnection ADYaiT2 = ADYaiT(str);
                    ADYaiT2.setConnectTimeout(3000);
                    r3 = ADYaiT2.getInputStream();
                    try {
                        Context context = EY4UKY.A2egSU.A5SV6n().f2499A2egSU;
                        if (context == null) {
                            context = null;
                        }
                        Bitmap.Config config = GJee0v.A4TApA.f3029A2egSU;
                        context.getClass();
                        r3.getClass();
                        Bitmap decodeStream = BitmapFactory.decodeStream(r3, null, GJee0v.A4TApA.A2egSU(context));
                        r3.close();
                        return decodeStream;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        str = r3;
                        if (r3 != 0) {
                            r3.close();
                            str = r3;
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    r3 = 0;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != null) {
                        try {
                            r1.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = str;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            str = e4;
        }
    }

    public static HttpURLConnection ADYaiT(String str) {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().toLowerCase().equals("https")) {
                return (HttpURLConnection) url.openConnection();
            }
            NOd7IU.AlLFFp.AZOQYO();
            return (HttpsURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static /* synthetic */ void MGhhq() {
        char[] charArray = "AMO\fECOG\f@M[\fQJGNN\fhLK`PKFEG".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\"');
        }
        String str = new String(charArray);
        char[] charArray2 = "ANKLKV".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\"');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
