package I3HV03;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h implements HSHyT0.ADYaiT {
    /* JADX WARN: Removed duplicated region for block: B:5:0x0018 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // HSHyT0.ADYaiT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A2egSU(java.io.InputStream r1, HZUvgL.AaHO0E r2) {
        /*
            r0 = this;
            D6DOie.ARc23Z r2 = new D6DOie.ARc23Z
            r2.<init>(r1)
            java.lang.String r1 = "Orientation"
            D6DOie.A5SV6n r1 = r2.AMqCpz(r1)
            if (r1 != 0) goto Le
            goto L15
        Le:
            java.nio.ByteOrder r2 = r2.f1990ARc23Z     // Catch: java.lang.NumberFormatException -> L15
            int r1 = r1.AMqCpz(r2)     // Catch: java.lang.NumberFormatException -> L15
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 != 0) goto L19
            r1 = -1
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: I3HV03.BI9f7h.A2egSU(java.io.InputStream, HZUvgL.AaHO0E):int");
    }

    @Override // HSHyT0.ADYaiT
    public ImageHeaderParser$ImageType getType(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // HSHyT0.ADYaiT
    public ImageHeaderParser$ImageType getType(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
