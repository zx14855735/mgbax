package com.kwad.sdk.pngencrypt;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    final k aZD;
    private int aZF;
    private int aZG;
    int aZH;
    int aZI;
    int aZJ;
    int aZK;
    int aZL;
    int aZM;
    private int aZE = 0;
    private int aZN = -1;
    private int aZO = -1;
    private int aZP = 0;
    private boolean aZR = false;
    int aZQ = 0;

    public e(k kVar) {
        this.aZD = kVar;
        ez(1);
        ey(0);
    }

    private int Qc() {
        return Qb();
    }

    private static byte[] eA(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException(CtFAbx.ARc23Z(i, "bad interlace pass"));
        }
    }

    private void ey(int i) {
        this.aZN = i;
        int i2 = (i * this.aZH) + this.aZJ;
        this.aZO = i2;
        if (i2 < 0 || i2 >= this.aZD.aZF) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void ez(int i) {
        if (this.aZE == i) {
            return;
        }
        this.aZE = i;
        byte[] eA = eA(i);
        byte b = eA[0];
        this.aZI = b;
        byte b2 = eA[1];
        this.aZH = b2;
        byte b3 = eA[2];
        this.aZK = b3;
        byte b4 = eA[3];
        this.aZJ = b4;
        k kVar = this.aZD;
        int i2 = kVar.aZF;
        this.aZF = i2 > b4 ? (((i2 + b2) - 1) - b4) / b2 : 0;
        int i3 = kVar.aZG;
        int i4 = i3 > b3 ? (((i3 + b) - 1) - b3) / b : 0;
        this.aZG = i4;
        if (i4 == 0) {
            this.aZF = 0;
        }
        int i5 = kVar.aZZ;
        this.aZM = b * i5;
        this.aZL = b3 * i5;
    }

    public final boolean PW() {
        int i;
        while (true) {
            this.aZP++;
            int i2 = this.aZF;
            if (i2 != 0 && (i = this.aZN) < i2 - 1) {
                ey(i + 1);
                break;
            }
            int i3 = this.aZE;
            if (i3 != 7) {
                ez(i3 + 1);
                if (this.aZF != 0) {
                    ey(0);
                    break;
                }
                this.aZP--;
            } else {
                this.aZR = true;
                return false;
            }
        }
        return true;
    }

    public final int PX() {
        return this.aZN;
    }

    public final int PY() {
        return this.aZO;
    }

    public final int PZ() {
        return this.aZE;
    }

    public final int Qa() {
        return this.aZF;
    }

    public final int Qb() {
        return this.aZG;
    }

    public final int Qd() {
        return ((this.aZD.bae * Qc()) + 7) / 8;
    }
}
