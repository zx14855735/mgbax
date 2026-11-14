package I3HV03;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C4FrIb implements HSHyT0.AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ByteBuffer f3870A2egSU = ByteBuffer.allocate(8);

    @Override // HSHyT0.AcNBzu
    public void update(byte[] bArr, Long l, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.f3870A2egSU) {
            this.f3870A2egSU.position(0);
            messageDigest.update(this.f3870A2egSU.putLong(l.longValue()).array());
        }
    }
}
