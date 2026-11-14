package HwAeAU;

import HSHyT0.AzWtSf;
import I3HV03.B2KMhB;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3795A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f3796A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ boolean f3797A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ HSHyT0.A2egSU f3798ADYaiT;
    public final /* synthetic */ B2KMhB AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f3799ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f3800ASJ6gh;

    public A4TApA(A5SV6n a5SV6n, int i, int i2, boolean z, HSHyT0.A2egSU a2egSU, B2KMhB b2KMhB, AzWtSf azWtSf) {
        this.f3800ASJ6gh = a5SV6n;
        this.f3795A2egSU = i;
        this.f3796A4TApA = i2;
        this.f3797A5SV6n = z;
        this.f3798ADYaiT = a2egSU;
        this.AMqCpz = b2KMhB;
        this.f3799ARc23Z = azWtSf;
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace colorSpace;
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        ColorSpace.Named unused;
        if (this.f3800ASJ6gh.f3801A2egSU.A4TApA(this.f3795A2egSU, this.f3796A4TApA, this.f3797A5SV6n, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f3798ADYaiT == HSHyT0.A2egSU.f3458AlLFFp) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new A2egSU());
        size = imageInfo.getSize();
        int i = this.f3795A2egSU;
        if (i == Integer.MIN_VALUE) {
            i = size.getWidth();
        }
        int i2 = this.f3796A4TApA;
        if (i2 == Integer.MIN_VALUE) {
            i2 = size.getHeight();
        }
        float A4TApA2 = this.AMqCpz.A4TApA(size.getWidth(), size.getHeight(), i, i2);
        int round = Math.round(size.getWidth() * A4TApA2);
        int round2 = Math.round(A4TApA2 * size.getHeight());
        if (Log.isLoggable("ImageDecoder", 2)) {
            size.getWidth();
            size.getHeight();
        }
        imageDecoder.setTargetSize(round, round2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            if (i3 >= 26) {
                unused = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                imageDecoder.setTargetColorSpace(colorSpace);
                return;
            }
            return;
        }
        if (this.f3799ARc23Z == AzWtSf.f3472AlLFFp) {
            colorSpace3 = imageInfo.getColorSpace();
            if (colorSpace3 != null) {
                colorSpace4 = imageInfo.getColorSpace();
                isWideGamut = colorSpace4.isWideGamut();
                if (isWideGamut) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    colorSpace2 = ColorSpace.get(named);
                    imageDecoder.setTargetColorSpace(colorSpace2);
                }
            }
        }
        named = ColorSpace.Named.SRGB;
        colorSpace2 = ColorSpace.get(named);
        imageDecoder.setTargetColorSpace(colorSpace2);
    }
}
