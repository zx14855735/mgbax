package GIl1rw;

import GJee0v.AZOQYO;
import android.util.Base64;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final byte[] f3028A2egSU = "#PART#".getBytes();

    static {
        NNiT();
    }

    public static String A2egSU() {
        byte[] bArr;
        try {
            bArr = Base64.encode(ADYaiT("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1,D3579468AA6A2371".getBytes("UTF-8"), A2egSU.ADYaiT("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP1Kih/K38O5JKETk5bTWQerfE3fxHffwIaz/GTECPC8SsywzwTZexB/BpJqGck9I35Jp4RsD2BlJldLiOEgRlA1bdmY/SOSyxTY9Hkh+vFqADQVo8vWtnLOwloNRkhp5kQiQxEyGEr6zJRd+DLVyFYuhgzlqOhyIS8XYkLnyZqwIDAQAB")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        return bArr == null ? "" : new String(bArr);
    }

    public static byte[] A4TApA(byte[] bArr, byte[] bArr2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePrivate);
            return cipher.doFinal(Base64.decode(bArr, 0));
        } catch (Exception unused) {
            int i = AZOQYO.f3039AcNBzu;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:3:0x0003, B:5:0x0006, B:8:0x000b, B:10:0x0018, B:12:0x001e, B:14:0x002d, B:16:0x0038, B:19:0x005f, B:21:0x006e, B:23:0x0079, B:25:0x007f, B:27:0x003e, B:30:0x0044, B:34:0x004c, B:36:0x0055, B:40:0x005a, B:47:0x0081, B:48:0x008b, B:50:0x0091), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] A5SV6n(byte[] r13, byte[] r14) {
        /*
            r0 = 1
            byte[] r1 = GIl1rw.A4TApA.f3028A2egSU
            int r2 = r1.length     // Catch: java.lang.Exception -> La2
            if (r2 > 0) goto Lb
            byte[] r13 = A4TApA(r13, r14)     // Catch: java.lang.Exception -> La2
            return r13
        Lb:
            int r3 = r13.length     // Catch: java.lang.Exception -> La2
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> La2
            r5 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5)     // Catch: java.lang.Exception -> La2
            r5 = 0
            r6 = 0
            r7 = 0
        L16:
            if (r6 >= r3) goto L81
            r8 = r13[r6]     // Catch: java.lang.Exception -> La2
            int r9 = r3 + (-1)
            if (r6 != r9) goto L3e
            int r8 = r3 - r7
            byte[] r9 = new byte[r8]     // Catch: java.lang.Exception -> La2
            java.lang.System.arraycopy(r13, r7, r9, r5, r8)     // Catch: java.lang.Exception -> La2
            byte[] r7 = A4TApA(r9, r14)     // Catch: java.lang.Exception -> La2
            int r8 = r7.length     // Catch: java.lang.Exception -> La2
            r9 = 0
        L2b:
            if (r9 >= r8) goto L38
            r10 = r7[r9]     // Catch: java.lang.Exception -> La2
            java.lang.Byte r10 = java.lang.Byte.valueOf(r10)     // Catch: java.lang.Exception -> La2
            r4.add(r10)     // Catch: java.lang.Exception -> La2
            int r9 = r9 + r0
            goto L2b
        L38:
            int r7 = r6 + r2
            int r6 = r7 + (-1)
        L3c:
            r9 = 0
            goto L5d
        L3e:
            r9 = r1[r5]     // Catch: java.lang.Exception -> La2
            if (r8 != r9) goto L3c
            if (r2 <= r0) goto L5c
            int r8 = r6 + r2
            if (r8 >= r3) goto L3c
            r8 = 1
            r9 = 0
        L4a:
            if (r8 >= r2) goto L5d
            r10 = r1[r8]     // Catch: java.lang.Exception -> La2
            int r11 = r6 + r8
            r11 = r13[r11]     // Catch: java.lang.Exception -> La2
            if (r10 == r11) goto L55
            goto L5d
        L55:
            int r10 = r2 + (-1)
            if (r8 != r10) goto L5a
            r9 = 1
        L5a:
            int r8 = r8 + r0
            goto L4a
        L5c:
            r9 = 1
        L5d:
            if (r9 == 0) goto L7f
            int r8 = r6 - r7
            byte[] r9 = new byte[r8]     // Catch: java.lang.Exception -> La2
            java.lang.System.arraycopy(r13, r7, r9, r5, r8)     // Catch: java.lang.Exception -> La2
            byte[] r7 = A4TApA(r9, r14)     // Catch: java.lang.Exception -> La2
            int r8 = r7.length     // Catch: java.lang.Exception -> La2
            r9 = 0
        L6c:
            if (r9 >= r8) goto L79
            r10 = r7[r9]     // Catch: java.lang.Exception -> La2
            java.lang.Byte r10 = java.lang.Byte.valueOf(r10)     // Catch: java.lang.Exception -> La2
            r4.add(r10)     // Catch: java.lang.Exception -> La2
            int r9 = r9 + r0
            goto L6c
        L79:
            int r6 = r6 + r2
            int r7 = r6 + (-1)
            r12 = r7
            r7 = r6
            r6 = r12
        L7f:
            int r6 = r6 + r0
            goto L16
        L81:
            int r13 = r4.size()     // Catch: java.lang.Exception -> La2
            byte[] r13 = new byte[r13]     // Catch: java.lang.Exception -> La2
            java.util.Iterator r14 = r4.iterator()     // Catch: java.lang.Exception -> La2
        L8b:
            boolean r1 = r14.hasNext()     // Catch: java.lang.Exception -> La2
            if (r1 == 0) goto La1
            java.lang.Object r1 = r14.next()     // Catch: java.lang.Exception -> La2
            java.lang.Byte r1 = (java.lang.Byte) r1     // Catch: java.lang.Exception -> La2
            int r2 = r5 + 1
            byte r1 = r1.byteValue()     // Catch: java.lang.Exception -> La2
            r13[r5] = r1     // Catch: java.lang.Exception -> La2
            r5 = r2
            goto L8b
        La1:
            return r13
        La2:
            int r13 = GJee0v.AZOQYO.f3039AcNBzu
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: GIl1rw.A4TApA.A5SV6n(byte[], byte[]):byte[]");
    }

    public static byte[] ADYaiT(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length <= 117) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        }
        ArrayList arrayList = new ArrayList(2048);
        byte[] bArr3 = new byte[117];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            bArr3[i3] = bArr[i2];
            i3++;
            if (i3 == 117 || i2 == length - 1) {
                i4++;
                if (i4 != 1) {
                    for (byte b : f3028A2egSU) {
                        arrayList.add(Byte.valueOf(b));
                    }
                }
                PublicKey generatePublic2 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher2.init(1, generatePublic2);
                byte[] doFinal = cipher2.doFinal(bArr3);
                for (byte b2 : doFinal) {
                    arrayList.add(Byte.valueOf(b2));
                }
                bArr3 = i2 == length + (-1) ? null : new byte[Math.min(117, (length - i2) - 1)];
                i3 = 0;
            }
            i2++;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bArr4[i] = ((Byte) it.next()).byteValue();
            i++;
        }
        return bArr4;
    }

    private static /* synthetic */ void NNiT() {
        char[] charArray = "\u008d\u0081\u0083À\u0089\u008f\u0083\u008bÀ\u008c\u0081\u0097À\u009d\u0086\u008b\u0082\u0082À¤\u0080\u0087¬\u009c\u0087\u008a\u0089\u008b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 238);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008d\u0082\u0087\u0080\u0087\u009a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 238);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
