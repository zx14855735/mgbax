package I3HV03;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements AmA8tU, com.bumptech.glide.load.data.ASJ6gh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ByteBuffer f3822AcNBzu;

    public AcNBzu(ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 1:
                this.f3822AcNBzu = byteBuffer;
                break;
            default:
                this.f3822AcNBzu = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public void AMqCpz() {
    }

    @Override // I3HV03.AmA8tU
    public int ASJ6gh() {
        return (AcNBzu() << 8) | AcNBzu();
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public Object AYUAbz() {
        ByteBuffer byteBuffer = this.f3822AcNBzu;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // I3HV03.AmA8tU
    public short AcNBzu() {
        ByteBuffer byteBuffer = this.f3822AcNBzu;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new AlLFFp();
    }

    @Override // I3HV03.AmA8tU
    public long skip(long j) {
        ByteBuffer byteBuffer = this.f3822AcNBzu;
        int min = (int) Math.min(byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }
}
