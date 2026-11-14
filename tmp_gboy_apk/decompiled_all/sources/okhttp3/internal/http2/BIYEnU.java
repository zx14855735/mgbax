package okhttp3.internal.http2;

import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BIYEnU {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public final int A2egSU(int i) {
        return this.values[i];
    }

    public final int A4TApA() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int A5SV6n() {
        return (this.set & r.b.d) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int ADYaiT() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int AMqCpz(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    public final boolean ARc23Z(int i) {
        return ((1 << i) & this.set) != 0;
    }

    public final void ASJ6gh(BIYEnU bIYEnU) {
        for (int i = 0; i < 10; i++) {
            if (bIYEnU.ARc23Z(i)) {
                AYUAbz(i, bIYEnU.values[i]);
            }
        }
    }

    public final void AYUAbz(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i >= iArr.length) {
                return;
            }
            this.set = (1 << i) | this.set;
            iArr[i] = i2;
        }
    }

    public final int AZOQYO() {
        return Integer.bitCount(this.set);
    }
}
