package I3HV03;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CASmeH implements HSHyT0.AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ByteBuffer f3871A2egSU = ByteBuffer.allocate(4);

    @Override // HSHyT0.AcNBzu
    public void update(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f3871A2egSU) {
            this.f3871A2egSU.position(0);
            messageDigest.update(this.f3871A2egSU.putInt(num.intValue()).array());
        }
    }
}
