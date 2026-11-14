package com.kwad.library.solder.lib.ext;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    private final String avA;
    private final boolean avB;
    private final boolean avC;
    private final boolean avD;
    private ExecutorService avE;
    private String avF;
    private byte[] avG;
    private boolean avH;
    private int avI;
    private final int avg;
    private final String avu;
    private final String avv;
    private final String avw;
    private final String avx;
    private final String avy;
    private final String avz;

    public static class a {
        private static final String avJ;
        private String avA;
        private boolean avD;
        private ExecutorService avE;
        private String avF;
        private byte[] avG;
        private boolean avH;
        private int avK;
        private int avg = 3;
        private String avu = "sodler";
        private String avv = "code-cache";
        private String avw = "lib";
        private String avx = "temp";
        private String avz = avJ;
        private String avy = ".tmp";
        private boolean avC = false;
        private boolean avB = false;

        static {
            avJ = Cb() ? "base-1_apk" : "base-1.apk";
            oMqxqwC();
        }

        private static boolean Cb() {
            int i = Build.VERSION.SDK_INT;
            return i == 30 || i == 31 || i == 32;
        }

        private static /* synthetic */ void oMqxqwC() {
            char[] charArray = "ÂÎÌ\u008fÆÀÌÄ\u008fÃÎØ\u008fÒÉÄÍÍ\u008fëÏÈãÓÈÅÆÄ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 161);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÂÍÈÏÈÕ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 161);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final c Cc() {
            return new c(this.avB, this.avC, this.avA, this.avu, this.avv, this.avw, this.avx, this.avy, this.avz, this.avg, this.avF, this.avG, this.avH, this.avD, this.avE, this.avK, (byte) 0);
        }

        public final a a(ExecutorService executorService) {
            this.avE = executorService;
            return this;
        }

        public final a bo(boolean z) {
            this.avH = false;
            return this;
        }

        public final a bp(boolean z) {
            this.avD = z;
            return this;
        }

        public final a cB(int i) {
            if (i > 0) {
                this.avg = i;
            }
            return this;
        }

        public final a cC(int i) {
            this.avK = i;
            return this;
        }

        public final a cl(String str) {
            this.avu = str;
            return this;
        }
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService, i2);
    }

    public final int BR() {
        return this.avI;
    }

    public final String BS() {
        return this.avu;
    }

    public final String BT() {
        return this.avv;
    }

    public final String BU() {
        return this.avw;
    }

    public final String BV() {
        return this.avx;
    }

    public final String BW() {
        return this.avy;
    }

    public final String BX() {
        return this.avz;
    }

    public final boolean BY() {
        return this.avC;
    }

    public final boolean BZ() {
        return this.avD;
    }

    public final ExecutorService Ca() {
        return this.avE;
    }

    public final int getRetryCount() {
        return this.avg;
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2) {
        this.avg = i;
        this.avu = str2;
        this.avv = str3;
        this.avw = str4;
        this.avx = str5;
        this.avy = str6;
        this.avz = str7;
        this.avA = str;
        this.avB = z;
        this.avC = z2;
        this.avF = str8;
        this.avG = bArr;
        this.avH = z3;
        this.avD = z4;
        this.avE = executorService;
        this.avI = i2;
    }
}
