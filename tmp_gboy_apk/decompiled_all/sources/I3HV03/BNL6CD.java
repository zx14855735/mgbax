package I3HV03;

import android.graphics.ImageDecoder;
import com.sigmob.sdk.downloader.f;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD implements HSHyT0.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AMqCpz f3857A2egSU = new AMqCpz();

    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        ImageDecoder.Source createSource;
        InputStream inputStream = (InputStream) obj;
        AtomicReference atomicReference = ItGa5w.A4TApA.f4072A2egSU;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(f.a.d);
        AtomicReference atomicReference2 = ItGa5w.A4TApA.f4072A2egSU;
        byte[] bArr = (byte[]) atomicReference2.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[f.a.d];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                atomicReference2.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                createSource = ImageDecoder.createSource((ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0));
                return this.f3857A2egSU.A5SV6n(createSource, i, i2, amA8tU);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @Override // HSHyT0.B25kr6
    public final /* bridge */ /* synthetic */ boolean A4TApA(Object obj, HSHyT0.AmA8tU amA8tU) {
        return true;
    }
}
