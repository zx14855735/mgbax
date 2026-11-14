package IJPJ4E;

import HSHyT0.AmA8tU;
import HSHyT0.B25kr6;
import HXc4pW.BTvldC;
import HZUvgL.AaHO0E;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.sigmob.sdk.downloader.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3922A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A2egSU f3923A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AaHO0E f3924A5SV6n;

    public AZkASS(ArrayList arrayList, A2egSU a2egSU, AaHO0E aaHO0E) {
        this.f3922A2egSU = arrayList;
        this.f3923A4TApA = a2egSU;
        this.f3924A5SV6n = aaHO0E;
    }

    @Override // HSHyT0.B25kr6
    public final BTvldC A2egSU(Object obj, int i, int i2, AmA8tU amA8tU) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(f.a.d);
        try {
            byte[] bArr2 = new byte[f.a.d];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f3923A4TApA.A2egSU(ByteBuffer.wrap(bArr), i, i2, amA8tU);
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, AmA8tU amA8tU) {
        return !((Boolean) amA8tU.A5SV6n(AZOQYO.f3921A4TApA)).booleanValue() && HSHyT0.AZOQYO.getType(this.f3922A2egSU, (InputStream) obj, this.f3924A5SV6n) == ImageHeaderParser$ImageType.GIF;
    }
}
