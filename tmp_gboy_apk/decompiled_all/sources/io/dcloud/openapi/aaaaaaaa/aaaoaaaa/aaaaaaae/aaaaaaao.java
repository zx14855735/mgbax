package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import java.lang.reflect.Method;
import okhttp3.internal.http2.ADYaiT;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaao {
    public final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaa0;
    public final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaaa;
    final int aaaaaaao;
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaac = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(":");
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaau = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(ADYaiT.RESPONSE_STATUS_UTF8);
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(ADYaiT.TARGET_METHOD_UTF8);
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaae = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(ADYaiT.TARGET_PATH_UTF8);
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaav = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(ADYaiT.TARGET_SCHEME_UTF8);
    public static final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaeo = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(ADYaiT.TARGET_AUTHORITY_UTF8);

    public interface aaaaaaaa {
    }

    static {
        XidDik();
    }

    public aaaaaaao(String str, String str2) {
        this(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(str), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(str2));
    }

    private static /* synthetic */ void XidDik() {
        char[] charArray = "\u0080\u008c\u008eÍ\u0084\u0082\u008e\u0086Í\u0081\u008c\u009aÍ\u0090\u008b\u0086\u008f\u008fÍ©\u008d\u008a¡\u0091\u008a\u0087\u0084\u0086".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 227);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0080\u008f\u008a\u008d\u008a\u0097".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 227);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof aaaaaaao) {
            aaaaaaao aaaaaaaoVar = (aaaaaaao) obj;
            if (this.aaaaaaaa.equals(aaaaaaaoVar.aaaaaaaa) && this.aaaaaaa0.equals(aaaaaaaoVar.aaaaaaa0)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.aaaaaaa0.hashCode() + ((this.aaaaaaaa.hashCode() + 527) * 31);
    }

    public String toString() {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("%s: %s", this.aaaaaaaa.aaaaaaae(), this.aaaaaaa0.aaaaaaae());
    }

    public aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar, String str) {
        this(aaaaaaanVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaao(str));
    }

    public aaaaaaao(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaanVar2) {
        this.aaaaaaaa = aaaaaaanVar;
        this.aaaaaaa0 = aaaaaaanVar2;
        this.aaaaaaao = aaaaaaanVar2.aaaaaaac() + aaaaaaanVar.aaaaaaac() + 32;
    }
}
