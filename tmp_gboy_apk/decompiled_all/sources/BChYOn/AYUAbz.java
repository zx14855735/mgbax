package BChYOn;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1216A2egSU;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AMqCpz f1219ADYaiT;
    public AMqCpz AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AMqCpz f1220ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public AMqCpz f1221ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1222AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f1223AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f1224AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f1225AaHO0E;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f1231B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f1232B3GDIM;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ARc23Z f1217A4TApA = null;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1218A5SV6n = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1226AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f1227AlLFFp = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1228AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1229AzWtSf = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f1230B25kr6 = 0;

    public AYUAbz(AZOQYO azoqyo, int i, AMqCpz aMqCpz, AMqCpz aMqCpz2, AMqCpz aMqCpz3, AMqCpz aMqCpz4, int i2) {
        this.f1232B3GDIM = azoqyo;
        this.f1222AYUAbz = 0;
        this.f1223AZOQYO = 0;
        this.f1224AZkASS = 0;
        this.f1225AaHO0E = 0;
        this.f1231B2KMhB = 0;
        this.f1216A2egSU = i;
        this.f1219ADYaiT = aMqCpz;
        this.AMqCpz = aMqCpz2;
        this.f1220ARc23Z = aMqCpz3;
        this.f1221ASJ6gh = aMqCpz4;
        this.f1222AYUAbz = azoqyo.f1269EPdU4G;
        this.f1223AZOQYO = azoqyo.f1265DyaChj;
        this.f1224AZkASS = azoqyo.f1270EQurEW;
        this.f1225AaHO0E = azoqyo.f1266ECyGFg;
        this.f1231B2KMhB = i2;
    }

    public final void A2egSU(ARc23Z aRc23Z) {
        int i = this.f1216A2egSU;
        AZOQYO azoqyo = this.f1232B3GDIM;
        if (i == 0) {
            int CtxOCS2 = azoqyo.CtxOCS(aRc23Z, this.f1231B2KMhB);
            if (aRc23Z.f1195Dphsd2[0] == 3) {
                this.f1230B25kr6++;
                CtxOCS2 = 0;
            }
            this.f1226AcNBzu = CtxOCS2 + (aRc23Z.f1188DV2E8K != 8 ? azoqyo.f1245FSFw2u : 0) + this.f1226AcNBzu;
            int CtFAbx2 = azoqyo.CtFAbx(aRc23Z, this.f1231B2KMhB);
            if (this.f1217A4TApA == null || this.f1218A5SV6n < CtFAbx2) {
                this.f1217A4TApA = aRc23Z;
                this.f1218A5SV6n = CtFAbx2;
                this.f1227AlLFFp = CtFAbx2;
            }
        } else {
            int CtxOCS3 = azoqyo.CtxOCS(aRc23Z, this.f1231B2KMhB);
            int CtFAbx3 = azoqyo.CtFAbx(aRc23Z, this.f1231B2KMhB);
            if (aRc23Z.f1195Dphsd2[1] == 3) {
                this.f1230B25kr6++;
                CtFAbx3 = 0;
            }
            this.f1227AlLFFp = CtFAbx3 + (aRc23Z.f1188DV2E8K != 8 ? azoqyo.f1246FZu94u : 0) + this.f1227AlLFFp;
            if (this.f1217A4TApA == null || this.f1218A5SV6n < CtxOCS3) {
                this.f1217A4TApA = aRc23Z;
                this.f1218A5SV6n = CtxOCS3;
                this.f1226AcNBzu = CtxOCS3;
            }
        }
        this.f1229AzWtSf++;
    }

    public final void A4TApA(boolean z, int i, boolean z2) {
        AZOQYO azoqyo;
        int i2;
        int i3;
        ARc23Z aRc23Z;
        boolean z3;
        float f;
        float f2;
        int i4;
        float f3;
        float f4;
        int i5;
        int i6 = this.f1229AzWtSf;
        int i7 = 0;
        while (true) {
            azoqyo = this.f1232B3GDIM;
            if (i7 >= i6 || (i5 = this.f1228AmA8tU + i7) >= azoqyo.f1255GGG1xW) {
                break;
            }
            ARc23Z aRc23Z2 = azoqyo.f1254GEYgCP[i5];
            if (aRc23Z2 != null) {
                aRc23Z2.BmvVmW();
            }
            i7++;
        }
        if (i6 == 0 || this.f1217A4TApA == null) {
            return;
        }
        boolean z4 = z2 && i == 0;
        int i8 = -1;
        int i9 = -1;
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = this.f1228AmA8tU + (z ? (i6 - 1) - i10 : i10);
            if (i11 >= azoqyo.f1255GGG1xW) {
                break;
            }
            ARc23Z aRc23Z3 = azoqyo.f1254GEYgCP[i11];
            if (aRc23Z3 != null && aRc23Z3.f1188DV2E8K == 0) {
                if (i8 == -1) {
                    i8 = i10;
                }
                i9 = i10;
            }
        }
        if (this.f1216A2egSU != 0) {
            boolean z5 = z4;
            ARc23Z aRc23Z4 = this.f1217A4TApA;
            aRc23Z4.DXuj49 = azoqyo.f1233EicXu4;
            int i12 = this.f1222AYUAbz;
            if (i > 0) {
                i12 += azoqyo.f1245FSFw2u;
            }
            AMqCpz aMqCpz = aRc23Z4.f1164CNPG0E;
            AMqCpz aMqCpz2 = aRc23Z4.f1166CQhlFr;
            if (z) {
                aMqCpz2.A2egSU(this.f1220ARc23Z, i12);
                if (z2) {
                    aMqCpz.A2egSU(this.f1219ADYaiT, this.f1224AZkASS);
                }
                if (i > 0) {
                    this.f1220ARc23Z.f1126ADYaiT.f1164CNPG0E.A2egSU(aMqCpz2, 0);
                }
            } else {
                aMqCpz.A2egSU(this.f1219ADYaiT, i12);
                if (z2) {
                    aMqCpz2.A2egSU(this.f1220ARc23Z, this.f1224AZkASS);
                }
                if (i > 0) {
                    this.f1219ADYaiT.f1126ADYaiT.f1166CQhlFr.A2egSU(aMqCpz, 0);
                }
            }
            ARc23Z aRc23Z5 = null;
            for (int i13 = 0; i13 < i6; i13++) {
                int i14 = this.f1228AmA8tU + i13;
                if (i14 >= azoqyo.f1255GGG1xW) {
                    return;
                }
                ARc23Z aRc23Z6 = azoqyo.f1254GEYgCP[i14];
                if (aRc23Z6 != null) {
                    AMqCpz aMqCpz3 = aRc23Z6.f1165COJEAR;
                    if (i13 == 0) {
                        aRc23Z6.ARc23Z(aMqCpz3, this.AMqCpz, this.f1223AZOQYO);
                        int i15 = azoqyo.f1234EmJGcg;
                        float f5 = azoqyo.f1240F32kj0;
                        if (this.f1228AmA8tU == 0) {
                            i3 = azoqyo.f1236EsrwYR;
                            i2 = -1;
                            if (i3 != -1) {
                                f5 = azoqyo.f1242FG7pZc;
                                i15 = i3;
                                aRc23Z6.f1190DaOi9o = i15;
                                aRc23Z6.f1186DRlcZ9 = f5;
                            }
                        } else {
                            i2 = -1;
                        }
                        if (z2 && (i3 = azoqyo.f1238ExjC7D) != i2) {
                            f5 = azoqyo.f1244FOAO9d;
                            i15 = i3;
                        }
                        aRc23Z6.f1190DaOi9o = i15;
                        aRc23Z6.f1186DRlcZ9 = f5;
                    }
                    if (i13 == i6 - 1) {
                        aRc23Z6.ARc23Z(aRc23Z6.f1167CSDoyG, this.f1221ASJ6gh, this.f1225AaHO0E);
                    }
                    if (aRc23Z5 != null) {
                        int i16 = azoqyo.f1246FZu94u;
                        AMqCpz aMqCpz4 = aRc23Z5.f1167CSDoyG;
                        aMqCpz3.A2egSU(aMqCpz4, i16);
                        if (i13 == i8) {
                            int i17 = this.f1223AZOQYO;
                            if (aMqCpz3.AYUAbz()) {
                                aMqCpz3.f1129AYUAbz = i17;
                            }
                        }
                        aMqCpz4.A2egSU(aMqCpz3, 0);
                        if (i13 == i9 + 1) {
                            int i18 = this.f1225AaHO0E;
                            if (aMqCpz4.AYUAbz()) {
                                aMqCpz4.f1129AYUAbz = i18;
                            }
                        }
                    }
                    if (aRc23Z6 != aRc23Z4) {
                        AMqCpz aMqCpz5 = aRc23Z6.f1166CQhlFr;
                        AMqCpz aMqCpz6 = aRc23Z6.f1164CNPG0E;
                        if (z) {
                            int i19 = azoqyo.f1247FdMWEC;
                            if (i19 == 0) {
                                aMqCpz5.A2egSU(aMqCpz2, 0);
                            } else if (i19 == 1) {
                                aMqCpz6.A2egSU(aMqCpz, 0);
                            } else if (i19 == 2) {
                                aMqCpz6.A2egSU(aMqCpz, 0);
                                aMqCpz5.A2egSU(aMqCpz2, 0);
                            }
                        } else {
                            int i20 = azoqyo.f1247FdMWEC;
                            if (i20 == 0) {
                                aMqCpz6.A2egSU(aMqCpz, 0);
                            } else if (i20 == 1) {
                                aMqCpz5.A2egSU(aMqCpz2, 0);
                            } else if (i20 == 2) {
                                if (z5) {
                                    aMqCpz6.A2egSU(this.f1219ADYaiT, this.f1222AYUAbz);
                                    aMqCpz5.A2egSU(this.f1220ARc23Z, this.f1224AZkASS);
                                } else {
                                    aMqCpz6.A2egSU(aMqCpz, 0);
                                    aMqCpz5.A2egSU(aMqCpz2, 0);
                                }
                            }
                            aRc23Z5 = aRc23Z6;
                        }
                    }
                    aRc23Z5 = aRc23Z6;
                }
            }
            return;
        }
        ARc23Z aRc23Z7 = this.f1217A4TApA;
        aRc23Z7.f1190DaOi9o = azoqyo.f1234EmJGcg;
        int i21 = this.f1223AZOQYO;
        if (i > 0) {
            i21 += azoqyo.f1246FZu94u;
        }
        AMqCpz aMqCpz7 = this.AMqCpz;
        AMqCpz aMqCpz8 = aRc23Z7.f1165COJEAR;
        aMqCpz8.A2egSU(aMqCpz7, i21);
        AMqCpz aMqCpz9 = aRc23Z7.f1167CSDoyG;
        if (z2) {
            aMqCpz9.A2egSU(this.f1221ASJ6gh, this.f1225AaHO0E);
        }
        if (i > 0) {
            this.AMqCpz.f1126ADYaiT.f1167CSDoyG.A2egSU(aMqCpz8, 0);
        }
        if (azoqyo.f1248Ff5QvW == 3 && !aRc23Z7.BpkvW3) {
            for (int i22 = 0; i22 < i6; i22++) {
                int i23 = this.f1228AmA8tU + (z ? (i6 - 1) - i22 : i22);
                if (i23 >= azoqyo.f1255GGG1xW) {
                    break;
                }
                aRc23Z = azoqyo.f1254GEYgCP[i23];
                if (aRc23Z.BpkvW3) {
                    break;
                }
            }
        }
        aRc23Z = aRc23Z7;
        ARc23Z aRc23Z8 = null;
        int i24 = 0;
        while (i24 < i6) {
            int i25 = z ? (i6 - 1) - i24 : i24;
            int i26 = this.f1228AmA8tU + i25;
            if (i26 >= azoqyo.f1255GGG1xW) {
                return;
            }
            ARc23Z aRc23Z9 = azoqyo.f1254GEYgCP[i26];
            if (aRc23Z9 == null) {
                z3 = z4;
            } else {
                AMqCpz aMqCpz10 = aRc23Z9.f1164CNPG0E;
                if (i24 == 0) {
                    aRc23Z9.ARc23Z(aMqCpz10, this.f1219ADYaiT, this.f1222AYUAbz);
                }
                if (i25 == 0) {
                    int i27 = azoqyo.f1233EicXu4;
                    if (z) {
                        f = 1.0f;
                        f2 = 1.0f - azoqyo.f1239F1loUV;
                    } else {
                        f = 1.0f;
                        f2 = azoqyo.f1239F1loUV;
                    }
                    if (this.f1228AmA8tU == 0) {
                        i4 = azoqyo.f1235ErKPGd;
                        z3 = z4;
                        if (i4 != -1) {
                            if (z) {
                                f4 = azoqyo.f1241F508T2;
                                f2 = f - f4;
                                aRc23Z9.DXuj49 = i4;
                                aRc23Z9.f1185DG07BK = f2;
                            } else {
                                f3 = azoqyo.f1241F508T2;
                                f2 = f3;
                                aRc23Z9.DXuj49 = i4;
                                aRc23Z9.f1185DG07BK = f2;
                            }
                        }
                    } else {
                        z3 = z4;
                    }
                    if (!z2 || (i4 = azoqyo.f1237EwN40Z) == -1) {
                        i4 = i27;
                        aRc23Z9.DXuj49 = i4;
                        aRc23Z9.f1185DG07BK = f2;
                    } else if (z) {
                        f4 = azoqyo.f1243FM663C;
                        f2 = f - f4;
                        aRc23Z9.DXuj49 = i4;
                        aRc23Z9.f1185DG07BK = f2;
                    } else {
                        f3 = azoqyo.f1243FM663C;
                        f2 = f3;
                        aRc23Z9.DXuj49 = i4;
                        aRc23Z9.f1185DG07BK = f2;
                    }
                } else {
                    z3 = z4;
                }
                if (i24 == i6 - 1) {
                    aRc23Z9.ARc23Z(aRc23Z9.f1166CQhlFr, this.f1220ARc23Z, this.f1224AZkASS);
                }
                if (aRc23Z8 != null) {
                    int i28 = azoqyo.f1245FSFw2u;
                    AMqCpz aMqCpz11 = aRc23Z8.f1166CQhlFr;
                    aMqCpz10.A2egSU(aMqCpz11, i28);
                    if (i24 == i8) {
                        int i29 = this.f1222AYUAbz;
                        if (aMqCpz10.AYUAbz()) {
                            aMqCpz10.f1129AYUAbz = i29;
                        }
                    }
                    aMqCpz11.A2egSU(aMqCpz10, 0);
                    if (i24 == i9 + 1) {
                        int i30 = this.f1224AZkASS;
                        if (aMqCpz11.AYUAbz()) {
                            aMqCpz11.f1129AYUAbz = i30;
                        }
                    }
                }
                if (aRc23Z9 != aRc23Z7) {
                    int i31 = azoqyo.f1248Ff5QvW;
                    if (i31 == 3 && aRc23Z.BpkvW3 && aRc23Z9 != aRc23Z && aRc23Z9.BpkvW3) {
                        aRc23Z9.f1168CTkVKb.A2egSU(aRc23Z.f1168CTkVKb, 0);
                    } else {
                        AMqCpz aMqCpz12 = aRc23Z9.f1165COJEAR;
                        if (i31 != 0) {
                            AMqCpz aMqCpz13 = aRc23Z9.f1167CSDoyG;
                            if (i31 == 1) {
                                aMqCpz13.A2egSU(aMqCpz9, 0);
                            } else if (z3) {
                                aMqCpz12.A2egSU(this.AMqCpz, this.f1223AZOQYO);
                                aMqCpz13.A2egSU(this.f1221ASJ6gh, this.f1225AaHO0E);
                            } else {
                                aMqCpz12.A2egSU(aMqCpz8, 0);
                                aMqCpz13.A2egSU(aMqCpz9, 0);
                            }
                        } else {
                            aMqCpz12.A2egSU(aMqCpz8, 0);
                        }
                    }
                }
                aRc23Z8 = aRc23Z9;
            }
            i24++;
            z4 = z3;
        }
    }

    public final int A5SV6n() {
        return this.f1216A2egSU == 1 ? this.f1227AlLFFp - this.f1232B3GDIM.f1246FZu94u : this.f1227AlLFFp;
    }

    public final int ADYaiT() {
        return this.f1216A2egSU == 0 ? this.f1226AcNBzu - this.f1232B3GDIM.f1245FSFw2u : this.f1226AcNBzu;
    }

    public final void AMqCpz(int i) {
        AZOQYO azoqyo;
        int i2;
        int i3 = this.f1230B25kr6;
        if (i3 == 0) {
            return;
        }
        int i4 = this.f1229AzWtSf;
        int i5 = i / i3;
        int i6 = 0;
        while (true) {
            azoqyo = this.f1232B3GDIM;
            if (i6 >= i4 || (i2 = this.f1228AmA8tU + i6) >= azoqyo.f1255GGG1xW) {
                break;
            }
            ARc23Z aRc23Z = azoqyo.f1254GEYgCP[i2];
            if (this.f1216A2egSU == 0) {
                if (aRc23Z != null) {
                    int[] iArr = aRc23Z.f1195Dphsd2;
                    if (iArr[0] == 3 && aRc23Z.f1148B4ZgIw == 0) {
                        azoqyo.CrfGsy(aRc23Z, 1, i5, iArr[1], aRc23Z.AaHO0E());
                    }
                }
            } else if (aRc23Z != null) {
                int[] iArr2 = aRc23Z.f1195Dphsd2;
                if (iArr2[1] == 3 && aRc23Z.f1149B7CMnp == 0) {
                    int i7 = iArr2[0];
                    int i8 = i5;
                    azoqyo.CrfGsy(aRc23Z, i7, aRc23Z.B2KMhB(), 1, i8);
                    i5 = i8;
                }
            }
            i6++;
        }
        this.f1226AcNBzu = 0;
        this.f1227AlLFFp = 0;
        this.f1217A4TApA = null;
        this.f1218A5SV6n = 0;
        int i9 = this.f1229AzWtSf;
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = this.f1228AmA8tU + i10;
            if (i11 >= azoqyo.f1255GGG1xW) {
                return;
            }
            ARc23Z aRc23Z2 = azoqyo.f1254GEYgCP[i11];
            if (this.f1216A2egSU == 0) {
                int B2KMhB2 = aRc23Z2.B2KMhB();
                int i12 = azoqyo.f1245FSFw2u;
                if (aRc23Z2.f1188DV2E8K == 8) {
                    i12 = 0;
                }
                this.f1226AcNBzu = B2KMhB2 + i12 + this.f1226AcNBzu;
                int CtFAbx2 = azoqyo.CtFAbx(aRc23Z2, this.f1231B2KMhB);
                if (this.f1217A4TApA == null || this.f1218A5SV6n < CtFAbx2) {
                    this.f1217A4TApA = aRc23Z2;
                    this.f1218A5SV6n = CtFAbx2;
                    this.f1227AlLFFp = CtFAbx2;
                }
            } else {
                int CtxOCS2 = azoqyo.CtxOCS(aRc23Z2, this.f1231B2KMhB);
                int CtFAbx3 = azoqyo.CtFAbx(aRc23Z2, this.f1231B2KMhB);
                int i13 = azoqyo.f1246FZu94u;
                if (aRc23Z2.f1188DV2E8K == 8) {
                    i13 = 0;
                }
                this.f1227AlLFFp = CtFAbx3 + i13 + this.f1227AlLFFp;
                if (this.f1217A4TApA == null || this.f1218A5SV6n < CtxOCS2) {
                    this.f1217A4TApA = aRc23Z2;
                    this.f1218A5SV6n = CtxOCS2;
                    this.f1226AcNBzu = CtxOCS2;
                }
            }
        }
    }

    public final void ARc23Z(int i, AMqCpz aMqCpz, AMqCpz aMqCpz2, AMqCpz aMqCpz3, AMqCpz aMqCpz4, int i2, int i3, int i4, int i5, int i6) {
        this.f1216A2egSU = i;
        this.f1219ADYaiT = aMqCpz;
        this.AMqCpz = aMqCpz2;
        this.f1220ARc23Z = aMqCpz3;
        this.f1221ASJ6gh = aMqCpz4;
        this.f1222AYUAbz = i2;
        this.f1223AZOQYO = i3;
        this.f1224AZkASS = i4;
        this.f1225AaHO0E = i5;
        this.f1231B2KMhB = i6;
    }
}
