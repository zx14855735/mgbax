package com.kuaishou.weapon.p0;

import ADYaiT.CtFAbx;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    static cq f12247a;
    static cq b;
    static cq c;
    private long d;
    private a e;

    public enum a {
        DWORD(4),
        QWORD(8);

        int c;

        static {
            ubbiV();
        }

        a(int i) {
            this.c = i;
        }

        private static /* synthetic */ void ubbiV() {
            char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 158);
            }
            String str = new String(charArray);
            char[] charArray2 = "ýò÷ð÷ê".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 158);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        c();
        YeLf();
    }

    private static /* synthetic */ void YeLf() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void c() {
        f12247a = new cq();
        b = new cq();
        c = new cq();
        cq cqVar = b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f12247a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            c.a(aVar2);
            switch (i) {
                case 21:
                    f12247a.a(40L);
                    f12247a.a(aVar2);
                    c.a(32L);
                    c.a(aVar2);
                    b.a(56L);
                    return;
                case 22:
                    f12247a.a(52L);
                    c.a(44L);
                    b.a(20L);
                    return;
                case 23:
                    f12247a.a(48L);
                    c.a(40L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    f12247a.a(48L);
                    c.a(40L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    f12247a.a(40L);
                    c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f12247a.a(32L);
                    c.a(24L);
                    b.a(4L);
                    return;
                default:
                    throw new RuntimeException(CtFAbx.ASJ6gh(i, "API LEVEL: ", " is not supported now : ("));
            }
        }
        f12247a.a(aVar);
        c.a(aVar);
        switch (i) {
            case 21:
                f12247a.a(40L);
                cq cqVar3 = f12247a;
                a aVar3 = a.QWORD;
                cqVar3.a(aVar3);
                c.a(32L);
                c.a(aVar3);
                b.a(56L);
                return;
            case 22:
                f12247a.a(44L);
                c.a(40L);
                b.a(20L);
                return;
            case 23:
                f12247a.a(36L);
                c.a(32L);
                b.a(12L);
                return;
            case 24:
            case 25:
                f12247a.a(32L);
                c.a(28L);
                b.a(4L);
                return;
            case 26:
            case 27:
                f12247a.a(28L);
                c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f12247a.a(24L);
                c.a(20L);
                b.a(4L);
                return;
            default:
                throw new RuntimeException(CtFAbx.ASJ6gh(i, "API LEVEL: ", " is not supported now : ("));
        }
    }

    public long a() {
        return this.d;
    }

    public a b() {
        return this.e;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
