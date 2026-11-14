package IOxIEW;

import HSHyT0.AmA8tU;
import HXc4pW.BTvldC;
import I3HV03.BniPrB;
import IJPJ4E.AYUAbz;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA implements A5SV6n {
    @Override // IOxIEW.A5SV6n
    public final BTvldC ARc23Z(BTvldC bTvldC, AmA8tU amA8tU) {
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = ((AYUAbz) ((IJPJ4E.A4TApA) bTvldC.get()).f3888AcNBzu.f2321A4TApA).f3905A2egSU.f3441ADYaiT.asReadOnlyBuffer();
        AtomicReference atomicReference = ItGa5w.A4TApA.f4072A2egSU;
        BJ7GGh.ARc23Z aRc23Z = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new BJ7GGh.ARc23Z(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        if (aRc23Z != null && aRc23Z.f1414A2egSU == 0) {
            if (aRc23Z.f1415A4TApA == ((byte[]) aRc23Z.f1416A5SV6n).length) {
                bArr = asReadOnlyBuffer.array();
                return new BniPrB(bArr);
            }
        }
        ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
        byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
        asReadOnlyBuffer2.position(0);
        asReadOnlyBuffer2.get(bArr2);
        bArr = bArr2;
        return new BniPrB(bArr);
    }
}
