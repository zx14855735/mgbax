package ItGa5w;

import I3HV03.BPw6Q8;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends InputStream {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final ArrayDeque f4076AmA8tU;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public BPw6Q8 f4077AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public IOException f4078AlLFFp;

    static {
        char[] cArr = AlLFFp.f4092A2egSU;
        f4076AmA8tU = new ArrayDeque(0);
        JAmNfUq();
    }

    private static /* synthetic */ void JAmNfUq() {
        char[] charArray = "\u0080\u008c\u008eÍ\u0084\u0082\u008e\u0086Í\u0081\u008c\u009aÍ\u0090\u008b\u0086\u008f\u008fÍ©\u008d\u008a¡\u0091\u008a\u0087\u0084\u0086".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 227);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0080\u008f\u008a\u008d\u008a\u0097".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 227);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        this.f4078AlLFFp = null;
        this.f4077AcNBzu = null;
        ArrayDeque arrayDeque = f4076AmA8tU;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f4077AcNBzu.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4077AcNBzu.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f4077AcNBzu.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f4077AcNBzu.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f4077AcNBzu.read();
        } catch (IOException e) {
            this.f4078AlLFFp = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f4077AcNBzu.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        try {
            return this.f4077AcNBzu.skip(j);
        } catch (IOException e) {
            this.f4078AlLFFp = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f4077AcNBzu.read(bArr);
        } catch (IOException e) {
            this.f4078AlLFFp = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        try {
            return this.f4077AcNBzu.read(bArr, i, i2);
        } catch (IOException e) {
            this.f4078AlLFFp = e;
            throw e;
        }
    }
}
