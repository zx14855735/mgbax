package com.bytedance.embedapplog;

import java.lang.reflect.Method;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tj {
    private static final LinkedList<vl> xj = new LinkedList<>();
    private static final LinkedList<vl> hf = new LinkedList<>();

    static {
        SwZLFZY();
    }

    private static /* synthetic */ void SwZLFZY() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(vl vlVar) {
        LinkedList<vl> linkedList = xj;
        synchronized (linkedList) {
            try {
                if (linkedList.size() > 200) {
                    vl poll = linkedList.poll();
                    cu.hf("drop event in cache", null);
                    hf.add(poll);
                }
                linkedList.add(vlVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void xj() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<vl> linkedList3 = xj;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<vl> linkedList4 = hf;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            a.xj((vl) linkedList.poll());
        }
    }
}
