package I3HV03;

import ADYaiT.CtFAbx;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class COJEAR implements HSHyT0.B25kr6 {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final HSHyT0.AlLFFp f3873ADYaiT = new HSHyT0.AlLFFp("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new C4FrIb());
    public static final HSHyT0.AlLFFp AMqCpz = new HSHyT0.AlLFFp("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new CASmeH());

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Hdahpu.AZOQYO f3874ARc23Z = new Hdahpu.AZOQYO(10);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Hdahpu.AZOQYO f3875A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HZUvgL.ADYaiT f3876A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Hdahpu.AZOQYO f3877A5SV6n = f3874ARc23Z;

    static {
        pgjct();
    }

    public COJEAR(HZUvgL.ADYaiT aDYaiT, Hdahpu.AZOQYO azoqyo) {
        this.f3876A4TApA = aDYaiT;
        this.f3875A2egSU = azoqyo;
    }

    public static Bitmap A5SV6n(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, B2KMhB b2KMhB) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && b2KMhB != B2KMhB.f3829ADYaiT) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float A4TApA2 = b2KMhB.A4TApA(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * A4TApA2), Math.round(A4TApA2 * parseInt2));
            } catch (Throwable unused) {
                Log.isLoggable("VideoDecoder", 3);
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new DXnQ0V.A5SV6n("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
    }

    private static /* synthetic */ void pgjct() {
        char[] charArray = "\u0089\u0085\u0087Ä\u008d\u008b\u0087\u008fÄ\u0088\u0085\u0093Ä\u0099\u0082\u008f\u0086\u0086Ä \u0084\u0083¨\u0098\u0083\u008e\u008d\u008f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 234);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0089\u0086\u0083\u0084\u0083\u009e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 234);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // HSHyT0.B25kr6
    public final HXc4pW.BTvldC A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        long longValue = ((Long) amA8tU.A5SV6n(f3873ADYaiT)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
        }
        Integer num = (Integer) amA8tU.A5SV6n(AMqCpz);
        if (num == null) {
            num = 2;
        }
        B2KMhB b2KMhB = (B2KMhB) amA8tU.A5SV6n(B2KMhB.f3830ARc23Z);
        if (b2KMhB == null) {
            b2KMhB = B2KMhB.AMqCpz;
        }
        B2KMhB b2KMhB2 = b2KMhB;
        this.f3877A5SV6n.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            switch (this.f3875A2egSU.f3699AcNBzu) {
                case 8:
                    AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
                    try {
                        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                        mediaMetadataRetriever = mediaMetadataRetriever;
                        Bitmap A5SV6n2 = A5SV6n(mediaMetadataRetriever, longValue, num.intValue(), i, i2, b2KMhB2);
                        mediaMetadataRetriever.release();
                        return ARc23Z.A5SV6n(this.f3876A4TApA, A5SV6n2);
                    } catch (Throwable th) {
                        th = th;
                        mediaMetadataRetriever = mediaMetadataRetriever;
                        mediaMetadataRetriever.release();
                        throw th;
                    }
                case 9:
                    mediaMetadataRetriever.setDataSource(new CNPG0E((ByteBuffer) obj));
                    Bitmap A5SV6n22 = A5SV6n(mediaMetadataRetriever, longValue, num.intValue(), i, i2, b2KMhB2);
                    mediaMetadataRetriever.release();
                    return ARc23Z.A5SV6n(this.f3876A4TApA, A5SV6n22);
                default:
                    mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                    Bitmap A5SV6n222 = A5SV6n(mediaMetadataRetriever, longValue, num.intValue(), i, i2, b2KMhB2);
                    mediaMetadataRetriever.release();
                    return ARc23Z.A5SV6n(this.f3876A4TApA, A5SV6n222);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // HSHyT0.B25kr6
    public final boolean A4TApA(Object obj, HSHyT0.AmA8tU amA8tU) {
        return true;
    }
}
