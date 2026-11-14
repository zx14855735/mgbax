package I3HV03;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends HwAeAU.A5SV6n {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HZUvgL.AMqCpz f3813A4TApA = new HZUvgL.AMqCpz();

    @Override // HwAeAU.A5SV6n
    public final ARc23Z ADYaiT(ImageDecoder.Source source, HwAeAU.A4TApA a4TApA) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, a4TApA);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            decodeBitmap.getWidth();
            decodeBitmap.getHeight();
        }
        return new ARc23Z(this.f3813A4TApA, decodeBitmap);
    }
}
