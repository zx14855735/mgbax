package com.bytedance.sdk.component.w.hf;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    private final boolean am;
    private final int c;
    private final boolean d;
    private final boolean f;
    private final boolean g;
    private final boolean kd;
    private final int p;

    /* renamed from: pl, reason: collision with root package name */
    private final int f10233pl;
    private final boolean qt;
    private final boolean tf;
    private final boolean u;
    String w;
    private final int y;
    public static final u xj = new xj().xj().w();
    public static final u hf = new xj().hf().xj(Integer.MAX_VALUE, TimeUnit.SECONDS).w();

    public static final class xj {
        boolean c;
        boolean f;
        boolean hf;
        boolean xj;
        boolean y;
        int w = -1;
        int u = -1;
        int kd = -1;

        public xj hf() {
            this.y = true;
            return this;
        }

        public u w() {
            return new u(this);
        }

        public xj xj() {
            this.xj = true;
            return this;
        }

        public xj xj(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.u = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }
    }

    static {
        mfeZIk();
    }

    private u(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.u = z;
        this.kd = z2;
        this.y = i;
        this.c = i2;
        this.f = z3;
        this.d = z4;
        this.tf = z5;
        this.p = i3;
        this.f10233pl = i4;
        this.g = z6;
        this.am = z7;
        this.qt = z8;
        this.w = str;
    }

    private static /* synthetic */ void mfeZIk() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String p() {
        StringBuilder sb = new StringBuilder();
        if (this.u) {
            sb.append("no-cache, ");
        }
        if (this.kd) {
            sb.append("no-store, ");
        }
        if (this.y != -1) {
            sb.append("max-age=");
            sb.append(this.y);
            sb.append(", ");
        }
        if (this.c != -1) {
            sb.append("s-maxage=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.f) {
            sb.append("private, ");
        }
        if (this.d) {
            sb.append("public, ");
        }
        if (this.tf) {
            sb.append("must-revalidate, ");
        }
        if (this.p != -1) {
            sb.append("max-stale=");
            sb.append(this.p);
            sb.append(", ");
        }
        if (this.f10233pl != -1) {
            sb.append("min-fresh=");
            sb.append(this.f10233pl);
            sb.append(", ");
        }
        if (this.g) {
            sb.append("only-if-cached, ");
        }
        if (this.am) {
            sb.append("no-transform, ");
        }
        if (this.qt) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public int c() {
        return this.p;
    }

    public boolean d() {
        return this.g;
    }

    public int f() {
        return this.f10233pl;
    }

    public boolean hf() {
        return this.kd;
    }

    public boolean kd() {
        return this.d;
    }

    public boolean tf() {
        return this.qt;
    }

    public String toString() {
        String str = this.w;
        if (str != null) {
            return str;
        }
        String p = p();
        this.w = p;
        return p;
    }

    public boolean u() {
        return this.f;
    }

    public int w() {
        return this.y;
    }

    public boolean xj() {
        return this.u;
    }

    public boolean y() {
        return this.tf;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.sdk.component.w.hf.u xj(com.bytedance.sdk.component.w.hf.yo r23) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.u.xj(com.bytedance.sdk.component.w.hf.yo):com.bytedance.sdk.component.w.hf.u");
    }

    public u(xj xjVar) {
        this.u = xjVar.xj;
        this.kd = xjVar.hf;
        this.y = xjVar.w;
        this.c = -1;
        this.f = false;
        this.d = false;
        this.tf = false;
        this.p = xjVar.u;
        this.f10233pl = xjVar.kd;
        this.g = xjVar.y;
        this.am = xjVar.c;
        this.qt = xjVar.f;
    }
}
