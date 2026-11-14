package HtmBAy;

import HSHyT0.AlLFFp;
import HSHyT0.AmA8tU;
import Hjvs0g.AcNBzu;
import Hjvs0g.B4ZgIw;
import Hjvs0g.B7CMnp;
import Hjvs0g.B9tovu;
import Hjvs0g.BChYOn;
import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import Hjvs0g.BmvVmW;
import java.lang.reflect.Method;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU implements BI9f7h {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AlLFFp f3777A4TApA = AlLFFp.A2egSU(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B9tovu f3778A2egSU;

    /* renamed from: HtmBAy.A2egSU$A2egSU, reason: collision with other inner class name */
    public static class C0001A2egSU implements BIYEnU {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final B9tovu f3779AcNBzu = new B9tovu(500);

        @Override // Hjvs0g.BIYEnU
        public final BI9f7h AYUAbz(BmvVmW bmvVmW) {
            return new A2egSU(this.f3779AcNBzu);
        }
    }

    static {
        VNYL();
    }

    public A2egSU() {
        this(null);
    }

    private static /* synthetic */ void VNYL() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, AmA8tU amA8tU) {
        AcNBzu acNBzu = (AcNBzu) obj;
        B9tovu b9tovu = this.f3778A2egSU;
        if (b9tovu != null) {
            B7CMnp A2egSU2 = B7CMnp.A2egSU(acNBzu);
            B4ZgIw b4ZgIw = b9tovu.f3741A2egSU;
            Object A2egSU3 = b4ZgIw.A2egSU(A2egSU2);
            ArrayDeque arrayDeque = B7CMnp.f3739A4TApA;
            synchronized (arrayDeque) {
                arrayDeque.offer(A2egSU2);
            }
            AcNBzu acNBzu2 = (AcNBzu) A2egSU3;
            if (acNBzu2 == null) {
                b4ZgIw.ADYaiT(B7CMnp.A2egSU(acNBzu), acNBzu);
            } else {
                acNBzu = acNBzu2;
            }
        }
        return new BChYOn(acNBzu, new com.bumptech.glide.load.data.AcNBzu(acNBzu, ((Integer) amA8tU.A5SV6n(f3777A4TApA)).intValue()));
    }

    @Override // Hjvs0g.BI9f7h
    public final /* bridge */ /* synthetic */ boolean A4TApA(Object obj) {
        return true;
    }

    public A2egSU(B9tovu b9tovu) {
        this.f3778A2egSU = b9tovu;
    }
}
