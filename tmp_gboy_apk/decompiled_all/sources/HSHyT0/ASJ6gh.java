package HSHyT0;

import I3HV03.BPw6Q8;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.load.data.AzWtSf f3463A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ HZUvgL.A4TApA f3464A4TApA;

    public ASJ6gh(com.bumptech.glide.load.data.AzWtSf azWtSf, HZUvgL.A4TApA a4TApA) {
        this.f3463A2egSU = azWtSf;
        this.f3464A4TApA = a4TApA;
    }

    @Override // HSHyT0.AYUAbz
    public ImageHeaderParser$ImageType getType(ADYaiT aDYaiT) {
        com.bumptech.glide.load.data.AzWtSf azWtSf = this.f3463A2egSU;
        BPw6Q8 bPw6Q8 = null;
        try {
            BPw6Q8 bPw6Q82 = new BPw6Q8(new FileInputStream(azWtSf.A2egSU().getFileDescriptor()), this.f3464A4TApA);
            try {
                ImageHeaderParser$ImageType type = aDYaiT.getType(bPw6Q82);
                try {
                    bPw6Q82.close();
                } catch (IOException unused) {
                }
                azWtSf.A2egSU();
                return type;
            } catch (Throwable th) {
                th = th;
                bPw6Q8 = bPw6Q82;
                if (bPw6Q8 != null) {
                    try {
                        bPw6Q8.close();
                    } catch (IOException unused2) {
                    }
                }
                azWtSf.A2egSU();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
