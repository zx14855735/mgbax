package com.kwad.framework.filedownloader.message;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e {
    private volatile g asS;
    private volatile b asT;

    public static final class a {
        private static final e asU = new e();

        static {
            bdQQKF();
        }

        private static /* synthetic */ void bdQQKF() {
            char[] charArray = "\u0085\u0089\u008bÈ\u0081\u0087\u008b\u0083È\u0084\u0089\u009fÈ\u0095\u008e\u0083\u008a\u008aÈ¬\u0088\u008f¤\u0094\u008f\u0082\u0081\u0083".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 230);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0085\u008a\u008f\u0088\u008f\u0092".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 230);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e Ax() {
        return a.asU;
    }

    public final void a(b bVar) {
        this.asT = bVar;
        if (bVar == null) {
            this.asS = null;
        } else {
            this.asS = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.asT != null) {
                this.asT.r(messageSnapshot);
            }
        } else if (this.asS != null) {
            this.asS.u(messageSnapshot);
        }
    }
}
