package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaao {
    private final boolean aaaaaaa0;
    private final boolean aaaaaaaa;
    private final int aaaaaaac;
    private final boolean aaaaaaae;
    private final boolean aaaaaaan;
    private final int aaaaaaao;
    private final boolean aaaaaaau;
    private final int aaaaaaav;
    String aaaaaaea;
    private final int aaaaaaeo;
    private final boolean aaaaaeaa;
    private final boolean aaaaeaaa;
    private final boolean aaaeaaaa;
    public static final aaaaaaao eaaaaaaa = new aaaaaaaa().aaaaaaa0().aaaaaaaa();
    public static final aaaaaaao aeaaaaaa = new aaaaaaaa().aaaaaaao().aaaaaaaa(Integer.MAX_VALUE, TimeUnit.SECONDS).aaaaaaaa();

    static {
        ymIAZVM();
    }

    private aaaaaaao(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.aaaaaaaa = z;
        this.aaaaaaa0 = z2;
        this.aaaaaaao = i;
        this.aaaaaaac = i2;
        this.aaaaaaau = z3;
        this.aaaaaaan = z4;
        this.aaaaaaae = z5;
        this.aaaaaaav = i3;
        this.aaaaaaeo = i4;
        this.aaaeaaaa = z6;
        this.aaaaeaaa = z7;
        this.aaaaaeaa = z8;
        this.aaaaaaea = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa r23) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa):io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaao");
    }

    private static /* synthetic */ void ymIAZVM() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean aaaaaaa0() {
        return this.aaaaaaau;
    }

    public int aaaaaaac() {
        return this.aaaaaaao;
    }

    public boolean aaaaaaae() {
        return this.aaaaaaae;
    }

    public int aaaaaaan() {
        return this.aaaaaaeo;
    }

    public boolean aaaaaaao() {
        return this.aaaaaaan;
    }

    public int aaaaaaau() {
        return this.aaaaaaav;
    }

    public boolean aaaaaaav() {
        return this.aaaaaaaa;
    }

    public boolean aaaaaaeo() {
        return this.aaaaaaa0;
    }

    public boolean aaaeaaaa() {
        return this.aaaeaaaa;
    }

    public String toString() {
        String str = this.aaaaaaea;
        if (str != null) {
            return str;
        }
        String aaaaaaaa2 = aaaaaaaa();
        this.aaaaaaea = aaaaaaaa2;
        return aaaaaaaa2;
    }

    public static final class aaaaaaaa {
        boolean aaaaaaa0;
        boolean aaaaaaaa;
        boolean aaaaaaae;
        boolean aaaaaaan;
        boolean aaaaaaav;
        int aaaaaaao = -1;
        int aaaaaaac = -1;
        int aaaaaaau = -1;

        public aaaaaaaa aaaaaaa0() {
            this.aaaaaaaa = true;
            return this;
        }

        public aaaaaaaa aaaaaaaa(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "maxStale < 0: "));
            }
            long seconds = timeUnit.toSeconds(i);
            this.aaaaaaac = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public aaaaaaaa aaaaaaao() {
            this.aaaaaaan = true;
            return this;
        }

        public aaaaaaao aaaaaaaa() {
            return new aaaaaaao(this);
        }
    }

    public aaaaaaao(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaa0 = aaaaaaaaVar.aaaaaaa0;
        this.aaaaaaao = aaaaaaaaVar.aaaaaaao;
        this.aaaaaaac = -1;
        this.aaaaaaau = false;
        this.aaaaaaan = false;
        this.aaaaaaae = false;
        this.aaaaaaav = aaaaaaaaVar.aaaaaaac;
        this.aaaaaaeo = aaaaaaaaVar.aaaaaaau;
        this.aaaeaaaa = aaaaaaaaVar.aaaaaaan;
        this.aaaaeaaa = aaaaaaaaVar.aaaaaaae;
        this.aaaaaeaa = aaaaaaaaVar.aaaaaaav;
    }

    private String aaaaaaaa() {
        StringBuilder sb = new StringBuilder();
        if (this.aaaaaaaa) {
            sb.append("no-cache, ");
        }
        if (this.aaaaaaa0) {
            sb.append("no-store, ");
        }
        if (this.aaaaaaao != -1) {
            sb.append("max-age=");
            sb.append(this.aaaaaaao);
            sb.append(", ");
        }
        if (this.aaaaaaac != -1) {
            sb.append("s-maxage=");
            sb.append(this.aaaaaaac);
            sb.append(", ");
        }
        if (this.aaaaaaau) {
            sb.append("private, ");
        }
        if (this.aaaaaaan) {
            sb.append("public, ");
        }
        if (this.aaaaaaae) {
            sb.append("must-revalidate, ");
        }
        if (this.aaaaaaav != -1) {
            sb.append("max-stale=");
            sb.append(this.aaaaaaav);
            sb.append(", ");
        }
        if (this.aaaaaaeo != -1) {
            sb.append("min-fresh=");
            sb.append(this.aaaaaaeo);
            sb.append(", ");
        }
        if (this.aaaeaaaa) {
            sb.append("only-if-cached, ");
        }
        if (this.aaaaeaaa) {
            sb.append("no-transform, ");
        }
        if (this.aaaaaeaa) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
