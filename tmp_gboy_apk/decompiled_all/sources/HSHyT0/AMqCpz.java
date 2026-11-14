package HSHyT0;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ InputStream f3461A2egSU;

    public AMqCpz(InputStream inputStream) {
        this.f3461A2egSU = inputStream;
    }

    @Override // HSHyT0.AYUAbz
    public ImageHeaderParser$ImageType getType(ADYaiT aDYaiT) {
        InputStream inputStream = this.f3461A2egSU;
        try {
            return aDYaiT.getType(inputStream);
        } finally {
            inputStream.reset();
        }
    }
}
