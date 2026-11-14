package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae;

import com.sigmob.sdk.base.views.r;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaea {
    private final int[] aaaaaaa0 = new int[10];
    private int aaaaaaaa;

    public int aaaaaaa0() {
        if ((this.aaaaaaaa & 2) != 0) {
            return this.aaaaaaa0[1];
        }
        return -1;
    }

    public void aaaaaaaa() {
        this.aaaaaaaa = 0;
        Arrays.fill(this.aaaaaaa0, 0);
    }

    public boolean aaaaaaac(int i) {
        return ((1 << i) & this.aaaaaaaa) != 0;
    }

    public int aaaaaaao(int i) {
        return (this.aaaaaaaa & 32) != 0 ? this.aaaaaaa0[5] : i;
    }

    public int aaaaaaa0(int i) {
        return (this.aaaaaaaa & 16) != 0 ? this.aaaaaaa0[4] : i;
    }

    public int aaaaaaac() {
        return Integer.bitCount(this.aaaaaaaa);
    }

    public int aaaaaaao() {
        if ((this.aaaaaaaa & r.b.d) != 0) {
            return this.aaaaaaa0[7];
        }
        return 65535;
    }

    public aaaaaaea aaaaaaaa(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.aaaaaaa0;
            if (i < iArr.length) {
                this.aaaaaaaa = (1 << i) | this.aaaaaaaa;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public int aaaaaaaa(int i) {
        return this.aaaaaaa0[i];
    }

    public void aaaaaaaa(aaaaaaea aaaaaaeaVar) {
        for (int i = 0; i < 10; i++) {
            if (aaaaaaeaVar.aaaaaaac(i)) {
                aaaaaaaa(i, aaaaaaeaVar.aaaaaaaa(i));
            }
        }
    }
}
