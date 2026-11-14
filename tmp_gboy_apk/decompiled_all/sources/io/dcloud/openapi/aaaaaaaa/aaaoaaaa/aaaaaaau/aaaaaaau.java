package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import com.sigmob.sdk.downloader.core.c;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaea;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaeaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaau {
    private static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao("\"\\");
    private static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao("\t ,=");

    static {
        fNwuB();
    }

    public static boolean aaaaaaa0(aaaaaaca aaaaaacaVar) {
        if (aaaaaacaVar.aaoaaaaa().aaaaaaau().equals(c.f13360a)) {
            return false;
        }
        int aaaaeaaa = aaaaaacaVar.aaaaeaaa();
        return (((aaaaeaaa >= 100 && aaaaeaaa < 200) || aaaaeaaa == 204 || aaaaeaaa == 304) && aaaaaaaa(aaaaaacaVar) == -1 && !"chunked".equalsIgnoreCase(aaaaaacaVar.aaaaaaa0(c.h))) ? false : true;
    }

    public static long aaaaaaaa(aaaaaaca aaaaaacaVar) {
        return aaaaaaaa(aaaaaacaVar.aaaaaaea());
    }

    private static /* synthetic */ void fNwuB() {
        char[] charArray = "nb`#jl`h#obt#~ehaa#GcdO\u007fdijh".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\r');
        }
        String str = new String(charArray);
        char[] charArray2 = "nadcdy".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static long aaaaaaaa(aaaoaaaa aaaoaaaaVar) {
        return aaaaaaaa(aaaoaaaaVar.aaaaaaa0(c.e));
    }

    private static long aaaaaaaa(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void aaaaaaaa(aaaaaaea aaaaaaeaVar, aaaaoaaa aaaaoaaaVar, aaaoaaaa aaaoaaaaVar) {
        if (aaaaaaeaVar == aaaaaaea.aaaaaaaa) {
            return;
        }
        List aaaaaaaa2 = aaaaaeaa.aaaaaaaa(aaaaoaaaVar, aaaoaaaaVar);
        if (aaaaaaaa2.isEmpty()) {
            return;
        }
        aaaaaaeaVar.aaaaaaaa(aaaaoaaaVar, aaaaaaaa2);
    }

    public static int aaaaaaa0(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int aaaaaaaa(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int aaaaaaaa(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
