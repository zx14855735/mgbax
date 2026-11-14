package HSHyT0;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp {
    public static final AaHO0E AMqCpz = new AaHO0E();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f3466A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AcNBzu f3467A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f3468A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile byte[] f3469ADYaiT;

    static {
        dWtdd();
    }

    public AlLFFp(String str, Object obj, AcNBzu acNBzu) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f3468A5SV6n = str;
        this.f3466A2egSU = obj;
        this.f3467A4TApA = acNBzu;
    }

    public static AlLFFp A2egSU(Object obj, String str) {
        return new AlLFFp(str, obj, AMqCpz);
    }

    private static /* synthetic */ void dWtdd() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AlLFFp) {
            return this.f3468A5SV6n.equals(((AlLFFp) obj).f3468A5SV6n);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3468A5SV6n.hashCode();
    }

    public final String toString() {
        return CtFAbx.B25kr6(new StringBuilder("Option{key='"), this.f3468A5SV6n, "'}");
    }

    public void update(Object obj, MessageDigest messageDigest) {
        AcNBzu acNBzu = this.f3467A4TApA;
        if (this.f3469ADYaiT == null) {
            this.f3469ADYaiT = this.f3468A5SV6n.getBytes(AZkASS.f3465A2egSU);
        }
        acNBzu.update(this.f3469ADYaiT, obj, messageDigest);
    }
}
