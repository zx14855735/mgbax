package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class GifInfoHandle {

    /* renamed from: A2egSU, reason: collision with root package name */
    public volatile long f14096A2egSU;

    static {
        RujA7D.ADYaiT.A2egSU();
        dFUMdr();
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    public static native int createTempNativeFileDescriptor();

    private static /* synthetic */ void dFUMdr() {
        char[] charArray = "{wu6\u007fyu}6zwa6kp}tt6RvqZjq|\u007f}".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 24);
        }
        String str = new String(charArray);
        char[] charArray2 = "{tqvql".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 24);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z);

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    public static native long openByteArray(byte[] bArr);

    public static native long openDirectByteBuffer(ByteBuffer byteBuffer);

    public static native long openFile(String str);

    public static native long openNativeFileDescriptor(int i, long j);

    public static native long openStream(InputStream inputStream);

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    public final synchronized int A2egSU() {
        return getCurrentFrameIndex(this.f14096A2egSU);
    }

    public final synchronized int A4TApA() {
        return getCurrentLoop(this.f14096A2egSU);
    }

    public final synchronized int A5SV6n() {
        return getCurrentPosition(this.f14096A2egSU);
    }

    public final synchronized int ADYaiT() {
        return getDuration(this.f14096A2egSU);
    }

    public final synchronized int AMqCpz() {
        return getHeight(this.f14096A2egSU);
    }

    public final synchronized int ARc23Z() {
        return getLoopCount(this.f14096A2egSU);
    }

    public final synchronized int ASJ6gh() {
        return getNativeErrorCode(this.f14096A2egSU);
    }

    public final synchronized int AYUAbz() {
        return getNumberOfFrames(this.f14096A2egSU);
    }

    public final synchronized int AZOQYO() {
        return getWidth(this.f14096A2egSU);
    }

    public final synchronized boolean AZkASS() {
        return isOpaque(this.f14096A2egSU);
    }

    public final synchronized long AaHO0E(Bitmap bitmap) {
        return renderFrame(this.f14096A2egSU, bitmap);
    }

    public final synchronized boolean AcNBzu() {
        return reset(this.f14096A2egSU);
    }

    public final synchronized long AlLFFp() {
        return restoreRemainder(this.f14096A2egSU);
    }

    public final synchronized void AmA8tU() {
        saveRemainder(this.f14096A2egSU);
    }

    public final synchronized void AzWtSf(Bitmap bitmap, int i) {
        seekToTime(this.f14096A2egSU, i, bitmap);
    }

    public final void finalize() {
        try {
            synchronized (this) {
                free(this.f14096A2egSU);
                this.f14096A2egSU = 0L;
            }
        } finally {
            super.finalize();
        }
    }
}
