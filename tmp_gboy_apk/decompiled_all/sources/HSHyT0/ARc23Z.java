package HSHyT0;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f3462A2egSU;

    public ARc23Z(ByteBuffer byteBuffer) {
        this.f3462A2egSU = byteBuffer;
    }

    @Override // HSHyT0.AYUAbz
    public ImageHeaderParser$ImageType getType(ADYaiT aDYaiT) {
        return aDYaiT.getType(this.f3462A2egSU);
    }
}
