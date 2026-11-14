package QkAq4X;

import com.sigmob.sdk.base.views.r;
import java.io.Writer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz extends Writer {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7737AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final StringBuilder f7738AlLFFp;

    public AMqCpz(int i) {
        this.f7737AcNBzu = i;
        switch (i) {
            case 1:
                this.f7738AlLFFp = new StringBuilder(r.b.d);
                break;
            default:
                this.f7738AlLFFp = new StringBuilder(r.b.d);
                break;
        }
    }

    public void A2egSU() {
        StringBuilder sb = this.f7738AlLFFp;
        if (sb.length() > 0) {
            sb.toString();
            sb.delete(0, sb.length());
        }
    }

    public void A4TApA() {
        StringBuilder sb = this.f7738AlLFFp;
        if (sb.length() > 0) {
            sb.toString();
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f7737AcNBzu) {
            case 0:
                A2egSU();
                break;
            default:
                A4TApA();
                break;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.f7737AcNBzu) {
            case 0:
                A2egSU();
                break;
            default:
                A4TApA();
                break;
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        switch (this.f7737AcNBzu) {
            case 0:
                for (int i3 = 0; i3 < i2; i3++) {
                    char c = cArr[i + i3];
                    if (c == '\n') {
                        A2egSU();
                    } else {
                        this.f7738AlLFFp.append(c);
                    }
                }
                break;
            default:
                for (int i4 = 0; i4 < i2; i4++) {
                    char c2 = cArr[i + i4];
                    if (c2 == '\n') {
                        A4TApA();
                    } else {
                        this.f7738AlLFFp.append(c2);
                    }
                }
                break;
        }
    }
}
