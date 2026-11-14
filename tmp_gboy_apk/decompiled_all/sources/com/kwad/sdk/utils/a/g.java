package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class g implements c.b<Set<String>> {
    static final g bhN = new g();

    static {
        FYYj();
    }

    private g() {
    }

    private static /* synthetic */ void FYYj() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int hU = b.hU(str);
                strArr[i2] = str;
                iArr[i2] = hU;
                i = b.fs(hU) + hU + i;
            }
            i2++;
        }
        b bVar = new b(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            bVar.fr(i4);
            if (i4 >= 0) {
                bVar.hT(strArr[i3]);
            }
        }
        return bVar.bgV;
    }

    private static Set<String> g(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = bVar.position;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Ui()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String UC() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> f(byte[] bArr, int i, int i2) {
        return g(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] q(Set<String> set) {
        return e(set);
    }
}
