package RlXTID;

import OLy1FW.AzWtSf;
import com.bumptech.glide.AMqCpz;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AzWtSf f7910A2egSU;

    static {
        AMqCpz.CkXcdM("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i = RkPTj2.A4TApA.f7908A2egSU;
        if (i < 2) {
            i = 2;
        }
        AMqCpz.CmUvjW(i, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        AMqCpz.CmUvjW(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        TimeUnit.SECONDS.toNanos(AMqCpz.CkXcdM("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        A2egSU a2egSU = A2egSU.f7909A2egSU;
        f7910A2egSU = new AzWtSf(0);
        new AzWtSf(1);
        ySGWIc();
    }

    private static /* synthetic */ void ySGWIc() {
        char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 143);
        }
        String str = new String(charArray);
        char[] charArray2 = "ìãæáæû".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 143);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
