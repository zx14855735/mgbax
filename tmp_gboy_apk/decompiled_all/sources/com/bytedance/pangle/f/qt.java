package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.util.ArraySet;
import com.bytedance.pangle.activity.A2egSU;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class qt {
    public static final qt xj = new qt(null, 0, null, null, null);
    public final Signature[] hf;
    public final Signature[] kd;
    public final ArraySet<PublicKey> u;
    public final int w;
    public final int[] y;

    static {
        KUsxu();
    }

    public qt(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.hf = signatureArr;
        this.w = i;
        this.u = arraySet;
        this.kd = signatureArr2;
        this.y = iArr;
    }

    private static /* synthetic */ void KUsxu() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static ArraySet<PublicKey> xj(Signature[] signatureArr) {
        Method method;
        A2egSU.AZkASS();
        ArraySet<PublicKey> ASJ6gh2 = A2egSU.ASJ6gh(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.bytedance.sdk.openadsdk.api.y.xj(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    ASJ6gh2.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.bytedance.sdk.openadsdk.api.y.xj(e2);
                } catch (InvocationTargetException e3) {
                    com.bytedance.sdk.openadsdk.api.y.xj(e3);
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.api.y.xj(e4);
                }
            }
        }
        return ASJ6gh2;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qt)) {
            return false;
        }
        qt qtVar = (qt) obj;
        if (this.w != qtVar.w || !xj(this.hf, qtVar.hf)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.u;
        if (arraySet != null) {
            equals = arraySet.equals(qtVar.u);
            if (!equals) {
                return false;
            }
        } else if (qtVar.u != null) {
            return false;
        }
        return Arrays.equals(this.kd, qtVar.kd) && Arrays.equals(this.y, qtVar.y);
    }

    public int hashCode() {
        int hashCode = ((Arrays.hashCode(this.hf) * 31) + this.w) * 31;
        ArraySet<PublicKey> arraySet = this.u;
        return Arrays.hashCode(this.y) + ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.kd)) * 31);
    }

    public qt(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, xj(signatureArr), signatureArr2, iArr);
    }

    public qt(Signature[] signatureArr, int i) {
        this(signatureArr, i, null, null);
    }

    public static boolean xj(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.u.xj((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.u.xj((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean xj(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
