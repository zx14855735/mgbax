package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aeaaaaaa {
    int aaaaaaa0;
    final byte[] aaaaaaaa;
    boolean aaaaaaac;
    aeaaaaaa aaaaaaae;
    aeaaaaaa aaaaaaan;
    int aaaaaaao;
    boolean aaaaaaau;

    public aeaaaaaa() {
        this.aaaaaaaa = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        this.aaaaaaau = true;
        this.aaaaaaac = false;
    }

    public final aeaaaaaa aaaaaaa0() {
        aeaaaaaa aeaaaaaaVar = this.aaaaaaan;
        aeaaaaaa aeaaaaaaVar2 = aeaaaaaaVar != this ? aeaaaaaaVar : null;
        aeaaaaaa aeaaaaaaVar3 = this.aaaaaaae;
        aeaaaaaaVar3.aaaaaaan = aeaaaaaaVar;
        this.aaaaaaan.aaaaaaae = aeaaaaaaVar3;
        this.aaaaaaan = null;
        this.aaaaaaae = null;
        return aeaaaaaaVar2;
    }

    public final aeaaaaaa aaaaaaaa(aeaaaaaa aeaaaaaaVar) {
        aeaaaaaaVar.aaaaaaae = this;
        aeaaaaaaVar.aaaaaaan = this.aaaaaaan;
        this.aaaaaaan.aaaaaaae = aeaaaaaaVar;
        this.aaaaaaan = aeaaaaaaVar;
        return aeaaaaaaVar;
    }

    public final aeaaaaaa aaaaaaao() {
        this.aaaaaaac = true;
        return new aeaaaaaa(this.aaaaaaaa, this.aaaaaaa0, this.aaaaaaao, true, false);
    }

    public aeaaaaaa(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.aaaaaaaa = bArr;
        this.aaaaaaa0 = i;
        this.aaaaaaao = i2;
        this.aaaaaaac = z;
        this.aaaaaaau = z2;
    }

    public final aeaaaaaa aaaaaaaa(int i) {
        aeaaaaaa aaaaaaaa;
        if (i > 0 && i <= this.aaaaaaao - this.aaaaaaa0) {
            if (i >= 1024) {
                aaaaaaaa = aaaaaaao();
            } else {
                aaaaaaaa = aoaaaaaa.aaaaaaaa();
                System.arraycopy(this.aaaaaaaa, this.aaaaaaa0, aaaaaaaa.aaaaaaaa, 0, i);
            }
            aaaaaaaa.aaaaaaao = aaaaaaaa.aaaaaaa0 + i;
            this.aaaaaaa0 += i;
            this.aaaaaaae.aaaaaaaa(aaaaaaaa);
            return aaaaaaaa;
        }
        throw new IllegalArgumentException();
    }

    public final void aaaaaaaa() {
        aeaaaaaa aeaaaaaaVar = this.aaaaaaae;
        if (aeaaaaaaVar != this) {
            if (aeaaaaaaVar.aaaaaaau) {
                int i = this.aaaaaaao - this.aaaaaaa0;
                if (i > (8192 - aeaaaaaaVar.aaaaaaao) + (aeaaaaaaVar.aaaaaaac ? 0 : aeaaaaaaVar.aaaaaaa0)) {
                    return;
                }
                aaaaaaaa(aeaaaaaaVar, i);
                aaaaaaa0();
                aoaaaaaa.aaaaaaaa(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void aaaaaaaa(aeaaaaaa aeaaaaaaVar, int i) {
        if (aeaaaaaaVar.aaaaaaau) {
            int i2 = aeaaaaaaVar.aaaaaaao;
            int i3 = i2 + i;
            if (i3 > 8192) {
                if (!aeaaaaaaVar.aaaaaaac) {
                    int i4 = aeaaaaaaVar.aaaaaaa0;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = aeaaaaaaVar.aaaaaaaa;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        aeaaaaaaVar.aaaaaaao -= aeaaaaaaVar.aaaaaaa0;
                        aeaaaaaaVar.aaaaaaa0 = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.aaaaaaaa, this.aaaaaaa0, aeaaaaaaVar.aaaaaaaa, aeaaaaaaVar.aaaaaaao, i);
            aeaaaaaaVar.aaaaaaao += i;
            this.aaaaaaa0 += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
