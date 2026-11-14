package com.kwad.framework.filedownloader.f;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e {
    public final int atM;
    public final long atN;
    public final boolean atO;
    public final boolean atP;
    public final int atQ;
    public final boolean atR;
    public final boolean atS;

    public static class a {
        private static final e atT = new e(0);

        static {
            Dflj();
        }

        private static /* synthetic */ void Dflj() {
            char[] charArray = "\u0010\u001c\u001e]\u0014\u0012\u001e\u0016]\u0011\u001c\n]\u0000\u001b\u0016\u001f\u001f]9\u001d\u001a1\u0001\u001a\u0017\u0014\u0016".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 's');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0010\u001f\u001a\u001d\u001a\u0007".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 's');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e Bf() {
        return a.atT;
    }

    public static int cw(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i > 0) {
            return i;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x008f A[Catch: all -> 0x0053, TryCatch #4 {all -> 0x0053, blocks: (B:60:0x0035, B:62:0x003c, B:65:0x0040, B:68:0x0044, B:71:0x0048, B:73:0x004c, B:78:0x008b, B:80:0x008f, B:82:0x0093, B:84:0x009b), top: B:59:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #4 {all -> 0x0053, blocks: (B:60:0x0035, B:62:0x003c, B:65:0x0040, B:68:0x0044, B:71:0x0048, B:73:0x004c, B:78:0x008b, B:80:0x008f, B:82:0x0093, B:84:0x009b), top: B:59:0x0035 }] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private e() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.f.e.<init>():void");
    }
}
