package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private final Set<Integer> alI = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> alJ = new ConcurrentHashMap<>();

    public static class a {
        private static final b alK = new b();

        static {
            jAxZTC();
        }

        private static /* synthetic */ void jAxZTC() {
            char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 244);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 244);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private void bG(int i) {
        Set<f> set;
        this.alI.remove(Integer.valueOf(i));
        if (this.alJ.isEmpty() || this.alJ.get(Integer.valueOf(i)) == null || (set = this.alJ.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().wY();
        }
        this.alJ.remove(Integer.valueOf(i));
    }

    public static b xn() {
        return a.alK;
    }

    public final void a(int i, f fVar) {
        Set<f> set = this.alJ.get(Integer.valueOf(i));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.alJ.put(Integer.valueOf(i), hashSet);
    }

    public final void b(int i, String str, String str2) {
        a(i, str, str2);
    }

    public final boolean bF(int i) {
        if (this.alI.contains(Integer.valueOf(i))) {
            return false;
        }
        this.alI.add(Integer.valueOf(i));
        return true;
    }

    public final void bH(int i) {
        bG(i);
    }

    private void a(int i, String str, String str2) {
        Set<f> set;
        this.alI.remove(Integer.valueOf(i));
        if (this.alJ.isEmpty() || this.alJ.get(Integer.valueOf(i)) == null || (set = this.alJ.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        this.alJ.remove(Integer.valueOf(i));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().wX();
        }
    }
}
