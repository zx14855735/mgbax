package CASmeH;

import ADYaiT.D9tr6l;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final D9tr6l f1593ADYaiT;
    public static final String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final String f1594ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final A5SV6n f1595ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final A5SV6n f1596AYUAbz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f1597A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1598A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final D9tr6l f1599A5SV6n;

    static {
        D9tr6l d9tr6l = AaHO0E.f1608A5SV6n;
        f1593ADYaiT = d9tr6l;
        AMqCpz = Character.toString((char) 8206);
        f1594ARc23Z = Character.toString((char) 8207);
        f1595ASJ6gh = new A5SV6n(false, 2, d9tr6l);
        f1596AYUAbz = new A5SV6n(true, 2, d9tr6l);
        clFwSa();
    }

    public A5SV6n(boolean z, int i, D9tr6l d9tr6l) {
        this.f1597A2egSU = z;
        this.f1598A4TApA = i;
        this.f1599A5SV6n = d9tr6l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        if (r1 != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0071, code lost:
    
        if (r2 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0073, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0076, code lost:
    
        if (r0.f1591A5SV6n <= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007c, code lost:
    
        switch(r0.A2egSU()) {
            case 14: goto L66;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L65;
            case 18: goto L64;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0080, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0083, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0086, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0089, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x008c, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A2egSU(java.lang.CharSequence r9) {
        /*
            CASmeH.A4TApA r0 = new CASmeH.A4TApA
            r0.<init>(r9)
            r9 = 0
            r0.f1591A5SV6n = r9
            r1 = 0
            r2 = 0
            r3 = 0
        Lb:
            int r4 = r0.f1591A5SV6n
            int r5 = r0.f1590A4TApA
            r6 = 1
            r7 = -1
            if (r4 >= r5) goto L6e
            if (r1 != 0) goto L6e
            java.lang.CharSequence r5 = r0.f1589A2egSU
            char r4 = r5.charAt(r4)
            r0.f1592ADYaiT = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L37
            int r4 = r0.f1591A5SV6n
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.f1591A5SV6n
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.f1591A5SV6n = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4b
        L37:
            int r4 = r0.f1591A5SV6n
            int r4 = r4 + r6
            r0.f1591A5SV6n = r4
            char r4 = r0.f1592ADYaiT
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L47
            byte[] r5 = CASmeH.A4TApA.AMqCpz
            r4 = r5[r4]
            goto L4b
        L47:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4b:
            if (r4 == 0) goto L69
            if (r4 == r6) goto L66
            r5 = 2
            if (r4 == r5) goto L66
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L62;
                case 15: goto L62;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5a;
                default: goto L59;
            }
        L59:
            goto L6c
        L5a:
            int r3 = r3 + (-1)
            r2 = 0
            goto Lb
        L5e:
            int r3 = r3 + 1
            r2 = 1
            goto Lb
        L62:
            int r3 = r3 + 1
            r2 = -1
            goto Lb
        L66:
            if (r3 != 0) goto L6c
            goto L85
        L69:
            if (r3 != 0) goto L6c
            goto L8b
        L6c:
            r1 = r3
            goto Lb
        L6e:
            if (r1 != 0) goto L71
            goto L8c
        L71:
            if (r2 == 0) goto L74
            return r2
        L74:
            int r2 = r0.f1591A5SV6n
            if (r2 <= 0) goto L8c
            byte r2 = r0.A2egSU()
            switch(r2) {
                case 14: goto L89;
                case 15: goto L89;
                case 16: goto L83;
                case 17: goto L83;
                case 18: goto L80;
                default: goto L7f;
            }
        L7f:
            goto L74
        L80:
            int r3 = r3 + 1
            goto L74
        L83:
            if (r1 != r3) goto L86
        L85:
            return r6
        L86:
            int r3 = r3 + (-1)
            goto L74
        L89:
            if (r1 != r3) goto L86
        L8b:
            return r7
        L8c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: CASmeH.A5SV6n.A2egSU(java.lang.CharSequence):int");
    }

    public static int A4TApA(CharSequence charSequence) {
        A4TApA a4TApA = new A4TApA(charSequence);
        a4TApA.f1591A5SV6n = a4TApA.f1590A4TApA;
        int i = 0;
        int i2 = 0;
        while (a4TApA.f1591A5SV6n > 0) {
            byte A2egSU2 = a4TApA.A2egSU();
            if (A2egSU2 != 0) {
                if (A2egSU2 == 1 || A2egSU2 == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (A2egSU2 != 9) {
                    switch (A2egSU2) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else {
                if (i == 0) {
                    return -1;
                }
                if (i2 == 0) {
                    i2 = i;
                }
            }
        }
        return 0;
    }

    public static A5SV6n A5SV6n() {
        A2egSU a2egSU = new A2egSU();
        int i = a2egSU.f1587A4TApA;
        return (i == 2 && a2egSU.f1588A5SV6n == f1593ADYaiT) ? a2egSU.f1586A2egSU ? f1596AYUAbz : f1595ASJ6gh : new A5SV6n(a2egSU.f1586A2egSU, i, a2egSU.f1588A5SV6n);
    }

    private static /* synthetic */ void clFwSa() {
        char[] charArray = "\u0001\r\u000fL\u0005\u0003\u000f\u0007L\u0000\r\u001bL\u0011\n\u0007\u000e\u000eL(\f\u000b \u0010\u000b\u0006\u0005\u0007".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'b');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0001\u000e\u000b\f\u000b\u0016".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final SpannableStringBuilder ADYaiT(CharSequence charSequence, D9tr6l d9tr6l) {
        if (charSequence == null) {
            return null;
        }
        boolean ADYaiT2 = d9tr6l.ADYaiT(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = this.f1598A4TApA & 2;
        String str = "";
        String str2 = f1594ARc23Z;
        String str3 = AMqCpz;
        boolean z = this.f1597A2egSU;
        if (i != 0) {
            boolean ADYaiT3 = (ADYaiT2 ? AaHO0E.f1607A4TApA : AaHO0E.f1606A2egSU).ADYaiT(charSequence, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((z || !(ADYaiT3 || A2egSU(charSequence) == 1)) ? (!z || (ADYaiT3 && A2egSU(charSequence) != -1)) ? "" : str2 : str3));
        }
        if (ADYaiT2 != z) {
            spannableStringBuilder.append(ADYaiT2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean ADYaiT4 = (ADYaiT2 ? AaHO0E.f1607A4TApA : AaHO0E.f1606A2egSU).ADYaiT(charSequence, charSequence.length());
        if (!z && (ADYaiT4 || A4TApA(charSequence) == 1)) {
            str = str3;
        } else if (z && (!ADYaiT4 || A4TApA(charSequence) == -1)) {
            str = str2;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }
}
