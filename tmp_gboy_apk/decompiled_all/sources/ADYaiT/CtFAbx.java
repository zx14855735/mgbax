package ADYaiT;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class CtFAbx {
    public static /* synthetic */ boolean A2egSU(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static float A4TApA(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static ClassCastException A5SV6n(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static Object ADYaiT(ArrayList arrayList, int i) {
        return arrayList.get(arrayList.size() - i);
    }

    public static String AMqCpz(int i, int i2, String str) {
        return str.substring(i2, str.length() - i);
    }

    public static String ARc23Z(int i, String str) {
        return str + i;
    }

    public static String ASJ6gh(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String AYUAbz(File file, String str) {
        return str + file;
    }

    public static String AZOQYO(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static String AZkASS(String str, int i, StringBuilder sb) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String AaHO0E(String str, long j) {
        return str + j;
    }

    public static String AcNBzu(String str, String str2) {
        return str + str2;
    }

    public static String AlLFFp(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String AmA8tU(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String AzWtSf(StringBuilder sb, int i) {
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    public static String B25kr6(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder B2KMhB(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder B3GDIM(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void B4ZgIw(Exception exc, StringBuilder sb, EY4UKY.ADYaiT aDYaiT, String str, Exception exc2) {
        sb.append(exc.getMessage());
        aDYaiT.AmA8tU(str, sb.toString(), exc2);
    }

    public static void B7CMnp(String str, String str2, Exception exc) {
        new EY4UKY.ADYaiT().AmA8tU(str, str2, exc);
    }

    public static /* synthetic */ boolean B9tovu(Object obj) {
        return obj != null;
    }

    public static String BChYOn(String str, String str2) {
        return str + str2;
    }

    public static String BI9f7h(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ String BIYEnU(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }
}
