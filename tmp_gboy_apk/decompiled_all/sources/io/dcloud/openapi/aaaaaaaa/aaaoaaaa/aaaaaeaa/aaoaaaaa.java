package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaoaaaaa extends aaaaaaan {
    final transient int[] aaaaaaae;
    final transient byte[][] aaaaaaan;

    public aaoaaaaa(aaaaaaao aaaaaaaoVar, int i) {
        super(null);
        aaaaaaoa.aaaaaaaa(aaaaaaaoVar.aaaaaaa0, 0L, i);
        aeaaaaaa aeaaaaaaVar = aaaaaaaoVar.aaaaaaaa;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = aeaaaaaaVar.aaaaaaao;
            int i6 = aeaaaaaaVar.aaaaaaa0;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
        }
        this.aaaaaaan = new byte[i4][];
        this.aaaaaaae = new int[i4 * 2];
        aeaaaaaa aeaaaaaaVar2 = aaaaaaaoVar.aaaaaaaa;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.aaaaaaan;
            bArr[i7] = aeaaaaaaVar2.aaaaaaaa;
            int i8 = aeaaaaaaVar2.aaaaaaao;
            int i9 = aeaaaaaaVar2.aaaaaaa0;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.aaaaaaae;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            aeaaaaaaVar2.aaaaaaac = true;
            i7++;
            aeaaaaaaVar2 = aeaaaaaaVar2.aaaaaaan;
        }
    }

    private aaaaaaan aaaaaaav() {
        return new aaaaaaan(aaaaaaan());
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public String aaaaaaa0() {
        return aaaaaaav().aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public String aaaaaaaa() {
        return aaaaaaav().aaaaaaaa();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public int aaaaaaac() {
        return this.aaaaaaae[this.aaaaaaan.length - 1];
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public String aaaaaaae() {
        return aaaaaaav().aaaaaaae();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public byte[] aaaaaaan() {
        int[] iArr = this.aaaaaaae;
        byte[][] bArr = this.aaaaaaan;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.aaaaaaae;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.aaaaaaan[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public aaaaaaan aaaaaaao() {
        return aaaaaaav().aaaaaaao();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public aaaaaaan aaaaaaau() {
        return aaaaaaav().aaaaaaau();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aaaaaaan) {
            aaaaaaan aaaaaaanVar = (aaaaaaan) obj;
            if (aaaaaaanVar.aaaaaaac() == aaaaaaac() && aaaaaaaa(0, aaaaaaanVar, 0, aaaaaaac())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public int hashCode() {
        int i = this.aaaaaaa0;
        if (i != 0) {
            return i;
        }
        int length = this.aaaaaaan.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.aaaaaaan[i2];
            int[] iArr = this.aaaaaaae;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.aaaaaaa0 = i4;
        return i4;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public String toString() {
        return aaaaaaav().toString();
    }

    private int aaaaaaa0(int i) {
        int binarySearch = Arrays.binarySearch(this.aaaaaaae, 0, this.aaaaaaan.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public aaaaaaan aaaaaaaa(int i, int i2) {
        return aaaaaaav().aaaaaaaa(i, i2);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public byte aaaaaaaa(int i) {
        aaaaaaoa.aaaaaaaa(this.aaaaaaae[this.aaaaaaan.length - 1], i, 1L);
        int aaaaaaa0 = aaaaaaa0(i);
        int i2 = aaaaaaa0 == 0 ? 0 : this.aaaaaaae[aaaaaaa0 - 1];
        int[] iArr = this.aaaaaaae;
        byte[][] bArr = this.aaaaaaan;
        return bArr[aaaaaaa0][(i - i2) + iArr[bArr.length + aaaaaaa0]];
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        int length = this.aaaaaaan.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.aaaaaaae;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            aeaaaaaa aeaaaaaaVar = new aeaaaaaa(this.aaaaaaan[i], i3, (i3 + i4) - i2, true, false);
            aeaaaaaa aeaaaaaaVar2 = aaaaaaaoVar.aaaaaaaa;
            if (aeaaaaaaVar2 == null) {
                aeaaaaaaVar.aaaaaaae = aeaaaaaaVar;
                aeaaaaaaVar.aaaaaaan = aeaaaaaaVar;
                aaaaaaaoVar.aaaaaaaa = aeaaaaaaVar;
            } else {
                aeaaaaaaVar2.aaaaaaae.aaaaaaaa(aeaaaaaaVar);
            }
            i++;
            i2 = i4;
        }
        aaaaaaaoVar.aaaaaaa0 += i2;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public boolean aaaaaaaa(int i, aaaaaaan aaaaaaanVar, int i2, int i3) {
        if (i < 0 || i > aaaaaaac() - i3) {
            return false;
        }
        int aaaaaaa0 = aaaaaaa0(i);
        while (i3 > 0) {
            int i4 = aaaaaaa0 == 0 ? 0 : this.aaaaaaae[aaaaaaa0 - 1];
            int min = Math.min(i3, ((this.aaaaaaae[aaaaaaa0] - i4) + i4) - i);
            int[] iArr = this.aaaaaaae;
            byte[][] bArr = this.aaaaaaan;
            if (!aaaaaaanVar.aaaaaaaa(i2, bArr[aaaaaaa0], (i - i4) + iArr[bArr.length + aaaaaaa0], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            aaaaaaa0++;
        }
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan
    public boolean aaaaaaaa(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > aaaaaaac() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int aaaaaaa0 = aaaaaaa0(i);
        while (i3 > 0) {
            int i4 = aaaaaaa0 == 0 ? 0 : this.aaaaaaae[aaaaaaa0 - 1];
            int min = Math.min(i3, ((this.aaaaaaae[aaaaaaa0] - i4) + i4) - i);
            int[] iArr = this.aaaaaaae;
            byte[][] bArr2 = this.aaaaaaan;
            if (!aaaaaaoa.aaaaaaaa(bArr2[aaaaaaa0], (i - i4) + iArr[bArr2.length + aaaaaaa0], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            aaaaaaa0++;
        }
        return true;
    }
}
