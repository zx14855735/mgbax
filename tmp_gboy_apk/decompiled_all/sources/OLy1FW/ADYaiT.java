package OLy1FW;

import java.io.ByteArrayOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final short f6346A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final short f6347A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6348A5SV6n;

    public ADYaiT(short s, short s2, int i) {
        this.f6346A2egSU = s;
        this.f6347A4TApA = s2;
        this.f6348A5SV6n = i;
    }

    public final void A2egSU(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(AYUAbz.AcNBzu(this.f6346A2egSU));
        byteArrayOutputStream.write(AYUAbz.AcNBzu(this.f6347A4TApA));
        byteArrayOutputStream.write(AYUAbz.A2egSU(this.f6348A5SV6n));
    }
}
