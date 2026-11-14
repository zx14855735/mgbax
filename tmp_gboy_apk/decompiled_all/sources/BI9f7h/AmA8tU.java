package BI9f7h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU extends B25kr6 {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ARc23Z f1310AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A2egSU f1311AcNBzu;

    @Override // BI9f7h.B25kr6
    public final void A5SV6n() {
        BChYOn.ARc23Z aRc23Z;
        BChYOn.ARc23Z aRc23Z2;
        BChYOn.ARc23Z aRc23Z3;
        BChYOn.ARc23Z aRc23Z4;
        BChYOn.ARc23Z aRc23Z5 = this.f1318A4TApA;
        boolean z = aRc23Z5.f1131A2egSU;
        ASJ6gh aSJ6gh = this.AMqCpz;
        if (z) {
            aSJ6gh.A5SV6n(aRc23Z5.AaHO0E());
        }
        boolean z2 = aSJ6gh.f1302AZkASS;
        ARc23Z aRc23Z6 = this.f1324AZOQYO;
        ARc23Z aRc23Z7 = this.f1323AYUAbz;
        if (!z2) {
            BChYOn.ARc23Z aRc23Z8 = this.f1318A4TApA;
            this.f1320ADYaiT = aRc23Z8.f1195Dphsd2[1];
            if (aRc23Z8.BpkvW3) {
                this.f1311AcNBzu = new A2egSU(this);
            }
            int i = this.f1320ADYaiT;
            if (i != 3) {
                if (i == 4 && (aRc23Z4 = this.f1318A4TApA.f1175CrfGsy) != null && aRc23Z4.f1195Dphsd2[1] == 1) {
                    int AaHO0E2 = (aRc23Z4.AaHO0E() - this.f1318A4TApA.f1165COJEAR.AMqCpz()) - this.f1318A4TApA.f1167CSDoyG.AMqCpz();
                    B25kr6.A2egSU(aRc23Z7, aRc23Z4.AMqCpz.f1323AYUAbz, this.f1318A4TApA.f1165COJEAR.AMqCpz());
                    B25kr6.A2egSU(aRc23Z6, aRc23Z4.AMqCpz.f1324AZOQYO, -this.f1318A4TApA.f1167CSDoyG.AMqCpz());
                    aSJ6gh.A5SV6n(AaHO0E2);
                    return;
                }
                if (i == 1) {
                    aSJ6gh.A5SV6n(this.f1318A4TApA.AaHO0E());
                }
            }
        } else if (this.f1320ADYaiT == 4 && (aRc23Z2 = (aRc23Z = this.f1318A4TApA).f1175CrfGsy) != null && aRc23Z2.f1195Dphsd2[1] == 1) {
            B25kr6.A2egSU(aRc23Z7, aRc23Z2.AMqCpz.f1323AYUAbz, aRc23Z.f1165COJEAR.AMqCpz());
            B25kr6.A2egSU(aRc23Z6, aRc23Z2.AMqCpz.f1324AZOQYO, -this.f1318A4TApA.f1167CSDoyG.AMqCpz());
            return;
        }
        boolean z3 = aSJ6gh.f1302AZkASS;
        ARc23Z aRc23Z9 = this.f1310AaHO0E;
        if (z3) {
            BChYOn.ARc23Z aRc23Z10 = this.f1318A4TApA;
            if (aRc23Z10.f1131A2egSU) {
                BChYOn.AMqCpz[] aMqCpzArr = aRc23Z10.f1172CkXcdM;
                BChYOn.AMqCpz aMqCpz = aMqCpzArr[2];
                BChYOn.AMqCpz aMqCpz2 = aMqCpz.f1127ARc23Z;
                if (aMqCpz2 != null && aMqCpzArr[3].f1127ARc23Z != null) {
                    if (aRc23Z10.BJ7GGh()) {
                        aRc23Z7.f1298ARc23Z = this.f1318A4TApA.f1172CkXcdM[2].AMqCpz();
                        aRc23Z6.f1298ARc23Z = -this.f1318A4TApA.f1172CkXcdM[3].AMqCpz();
                    } else {
                        ARc23Z ASJ6gh2 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[2]);
                        if (ASJ6gh2 != null) {
                            B25kr6.A2egSU(aRc23Z7, ASJ6gh2, this.f1318A4TApA.f1172CkXcdM[2].AMqCpz());
                        }
                        ARc23Z ASJ6gh3 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[3]);
                        if (ASJ6gh3 != null) {
                            B25kr6.A2egSU(aRc23Z6, ASJ6gh3, -this.f1318A4TApA.f1172CkXcdM[3].AMqCpz());
                        }
                        aRc23Z7.f1295A4TApA = true;
                        aRc23Z6.f1295A4TApA = true;
                    }
                    BChYOn.ARc23Z aRc23Z11 = this.f1318A4TApA;
                    if (aRc23Z11.BpkvW3) {
                        B25kr6.A2egSU(aRc23Z9, aRc23Z7, aRc23Z11.f1182D8cQ8b);
                        return;
                    }
                    return;
                }
                if (aMqCpz2 != null) {
                    ARc23Z ASJ6gh4 = B25kr6.ASJ6gh(aMqCpz);
                    if (ASJ6gh4 != null) {
                        B25kr6.A2egSU(aRc23Z7, ASJ6gh4, this.f1318A4TApA.f1172CkXcdM[2].AMqCpz());
                        B25kr6.A2egSU(aRc23Z6, aRc23Z7, aSJ6gh.f1299ASJ6gh);
                        BChYOn.ARc23Z aRc23Z12 = this.f1318A4TApA;
                        if (aRc23Z12.BpkvW3) {
                            B25kr6.A2egSU(aRc23Z9, aRc23Z7, aRc23Z12.f1182D8cQ8b);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BChYOn.AMqCpz aMqCpz3 = aMqCpzArr[3];
                if (aMqCpz3.f1127ARc23Z != null) {
                    ARc23Z ASJ6gh5 = B25kr6.ASJ6gh(aMqCpz3);
                    if (ASJ6gh5 != null) {
                        B25kr6.A2egSU(aRc23Z6, ASJ6gh5, -this.f1318A4TApA.f1172CkXcdM[3].AMqCpz());
                        B25kr6.A2egSU(aRc23Z7, aRc23Z6, -aSJ6gh.f1299ASJ6gh);
                    }
                    BChYOn.ARc23Z aRc23Z13 = this.f1318A4TApA;
                    if (aRc23Z13.BpkvW3) {
                        B25kr6.A2egSU(aRc23Z9, aRc23Z7, aRc23Z13.f1182D8cQ8b);
                        return;
                    }
                    return;
                }
                BChYOn.AMqCpz aMqCpz4 = aMqCpzArr[4];
                if (aMqCpz4.f1127ARc23Z != null) {
                    ARc23Z ASJ6gh6 = B25kr6.ASJ6gh(aMqCpz4);
                    if (ASJ6gh6 != null) {
                        B25kr6.A2egSU(aRc23Z9, ASJ6gh6, 0);
                        B25kr6.A2egSU(aRc23Z7, aRc23Z9, -this.f1318A4TApA.f1182D8cQ8b);
                        B25kr6.A2egSU(aRc23Z6, aRc23Z7, aSJ6gh.f1299ASJ6gh);
                        return;
                    }
                    return;
                }
                if ((aRc23Z10 instanceof BChYOn.AaHO0E) || aRc23Z10.f1175CrfGsy == null || aRc23Z10.AZOQYO(BChYOn.ADYaiT.f1119B2KMhB).f1127ARc23Z != null) {
                    return;
                }
                BChYOn.ARc23Z aRc23Z14 = this.f1318A4TApA;
                B25kr6.A2egSU(aRc23Z7, aRc23Z14.f1175CrfGsy.AMqCpz.f1323AYUAbz, aRc23Z14.B4ZgIw());
                B25kr6.A2egSU(aRc23Z6, aRc23Z7, aSJ6gh.f1299ASJ6gh);
                BChYOn.ARc23Z aRc23Z15 = this.f1318A4TApA;
                if (aRc23Z15.BpkvW3) {
                    B25kr6.A2egSU(aRc23Z9, aRc23Z7, aRc23Z15.f1182D8cQ8b);
                    return;
                }
                return;
            }
        }
        if (z3 || this.f1320ADYaiT != 3) {
            aSJ6gh.A2egSU(this);
        } else {
            BChYOn.ARc23Z aRc23Z16 = this.f1318A4TApA;
            int i2 = aRc23Z16.f1149B7CMnp;
            if (i2 == 2) {
                BChYOn.ARc23Z aRc23Z17 = aRc23Z16.f1175CrfGsy;
                if (aRc23Z17 != null) {
                    ASJ6gh aSJ6gh2 = aRc23Z17.AMqCpz.AMqCpz;
                    aSJ6gh.f1304AcNBzu.add(aSJ6gh2);
                    aSJ6gh2.f1303AaHO0E.add(aSJ6gh);
                    aSJ6gh.f1295A4TApA = true;
                    aSJ6gh.f1303AaHO0E.add(aRc23Z7);
                    aSJ6gh.f1303AaHO0E.add(aRc23Z6);
                }
            } else if (i2 == 3 && !aRc23Z16.BJ7GGh()) {
                BChYOn.ARc23Z aRc23Z18 = this.f1318A4TApA;
                if (aRc23Z18.f1148B4ZgIw != 3) {
                    ASJ6gh aSJ6gh3 = aRc23Z18.f1134ADYaiT.AMqCpz;
                    aSJ6gh.f1304AcNBzu.add(aSJ6gh3);
                    aSJ6gh3.f1303AaHO0E.add(aSJ6gh);
                    aSJ6gh.f1295A4TApA = true;
                    aSJ6gh.f1303AaHO0E.add(aRc23Z7);
                    aSJ6gh.f1303AaHO0E.add(aRc23Z6);
                }
            }
        }
        BChYOn.ARc23Z aRc23Z19 = this.f1318A4TApA;
        BChYOn.AMqCpz[] aMqCpzArr2 = aRc23Z19.f1172CkXcdM;
        BChYOn.AMqCpz aMqCpz5 = aMqCpzArr2[2];
        BChYOn.AMqCpz aMqCpz6 = aMqCpz5.f1127ARc23Z;
        if (aMqCpz6 != null && aMqCpzArr2[3].f1127ARc23Z != null) {
            if (aRc23Z19.BJ7GGh()) {
                aRc23Z7.f1298ARc23Z = this.f1318A4TApA.f1172CkXcdM[2].AMqCpz();
                aRc23Z6.f1298ARc23Z = -this.f1318A4TApA.f1172CkXcdM[3].AMqCpz();
            } else {
                ARc23Z ASJ6gh7 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[2]);
                ARc23Z ASJ6gh8 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[3]);
                if (ASJ6gh7 != null) {
                    ASJ6gh7.A2egSU(this);
                }
                if (ASJ6gh8 != null) {
                    ASJ6gh8.A2egSU(this);
                }
                this.f1325AZkASS = 4;
            }
            if (this.f1318A4TApA.BpkvW3) {
                A4TApA(aRc23Z9, aRc23Z7, 1, this.f1311AcNBzu);
            }
        } else if (aMqCpz6 != null) {
            ARc23Z ASJ6gh9 = B25kr6.ASJ6gh(aMqCpz5);
            if (ASJ6gh9 != null) {
                B25kr6.A2egSU(aRc23Z7, ASJ6gh9, this.f1318A4TApA.f1172CkXcdM[2].AMqCpz());
                A4TApA(aRc23Z6, aRc23Z7, 1, aSJ6gh);
                if (this.f1318A4TApA.BpkvW3) {
                    A4TApA(aRc23Z9, aRc23Z7, 1, this.f1311AcNBzu);
                }
                if (this.f1320ADYaiT == 3) {
                    BChYOn.ARc23Z aRc23Z20 = this.f1318A4TApA;
                    if (aRc23Z20.f1178D07BeM > 0.0f) {
                        AcNBzu acNBzu = aRc23Z20.f1134ADYaiT;
                        if (acNBzu.f1320ADYaiT == 3) {
                            acNBzu.AMqCpz.f1303AaHO0E.add(aSJ6gh);
                            aSJ6gh.f1304AcNBzu.add(this.f1318A4TApA.f1134ADYaiT.AMqCpz);
                            aSJ6gh.f1294A2egSU = this;
                        }
                    }
                }
            }
        } else {
            BChYOn.AMqCpz aMqCpz7 = aMqCpzArr2[3];
            if (aMqCpz7.f1127ARc23Z != null) {
                ARc23Z ASJ6gh10 = B25kr6.ASJ6gh(aMqCpz7);
                if (ASJ6gh10 != null) {
                    B25kr6.A2egSU(aRc23Z6, ASJ6gh10, -this.f1318A4TApA.f1172CkXcdM[3].AMqCpz());
                    A4TApA(aRc23Z7, aRc23Z6, -1, aSJ6gh);
                    if (this.f1318A4TApA.BpkvW3) {
                        A4TApA(aRc23Z9, aRc23Z7, 1, this.f1311AcNBzu);
                    }
                }
            } else {
                BChYOn.AMqCpz aMqCpz8 = aMqCpzArr2[4];
                if (aMqCpz8.f1127ARc23Z != null) {
                    ARc23Z ASJ6gh11 = B25kr6.ASJ6gh(aMqCpz8);
                    if (ASJ6gh11 != null) {
                        B25kr6.A2egSU(aRc23Z9, ASJ6gh11, 0);
                        A4TApA(aRc23Z7, aRc23Z9, -1, this.f1311AcNBzu);
                        A4TApA(aRc23Z6, aRc23Z7, 1, aSJ6gh);
                    }
                } else if (!(aRc23Z19 instanceof BChYOn.AaHO0E) && (aRc23Z3 = aRc23Z19.f1175CrfGsy) != null) {
                    B25kr6.A2egSU(aRc23Z7, aRc23Z3.AMqCpz.f1323AYUAbz, aRc23Z19.B4ZgIw());
                    A4TApA(aRc23Z6, aRc23Z7, 1, aSJ6gh);
                    if (this.f1318A4TApA.BpkvW3) {
                        A4TApA(aRc23Z9, aRc23Z7, 1, this.f1311AcNBzu);
                    }
                    if (this.f1320ADYaiT == 3) {
                        BChYOn.ARc23Z aRc23Z21 = this.f1318A4TApA;
                        if (aRc23Z21.f1178D07BeM > 0.0f) {
                            AcNBzu acNBzu2 = aRc23Z21.f1134ADYaiT;
                            if (acNBzu2.f1320ADYaiT == 3) {
                                acNBzu2.AMqCpz.f1303AaHO0E.add(aSJ6gh);
                                aSJ6gh.f1304AcNBzu.add(this.f1318A4TApA.f1134ADYaiT.AMqCpz);
                                aSJ6gh.f1294A2egSU = this;
                            }
                        }
                    }
                }
            }
        }
        if (aSJ6gh.f1304AcNBzu.size() == 0) {
            aSJ6gh.f1296A5SV6n = true;
        }
    }

    @Override // BI9f7h.B25kr6
    public final void ADYaiT() {
        ARc23Z aRc23Z = this.f1323AYUAbz;
        if (aRc23Z.f1302AZkASS) {
            this.f1318A4TApA.f1181D8MqeW = aRc23Z.f1299ASJ6gh;
        }
    }

    @Override // BI9f7h.B25kr6
    public final void AMqCpz() {
        this.f1319A5SV6n = null;
        this.f1323AYUAbz.A4TApA();
        this.f1324AZOQYO.A4TApA();
        this.f1310AaHO0E.A4TApA();
        this.AMqCpz.A4TApA();
        this.f1322ASJ6gh = false;
    }

    @Override // BI9f7h.B25kr6
    public final boolean AZkASS() {
        return this.f1320ADYaiT != 3 || this.f1318A4TApA.f1149B7CMnp == 0;
    }

    public final void AcNBzu() {
        this.f1322ASJ6gh = false;
        ARc23Z aRc23Z = this.f1323AYUAbz;
        aRc23Z.A4TApA();
        aRc23Z.f1302AZkASS = false;
        ARc23Z aRc23Z2 = this.f1324AZOQYO;
        aRc23Z2.A4TApA();
        aRc23Z2.f1302AZkASS = false;
        ARc23Z aRc23Z3 = this.f1310AaHO0E;
        aRc23Z3.A4TApA();
        aRc23Z3.f1302AZkASS = false;
        this.AMqCpz.f1302AZkASS = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f1318A4TApA.f1189DXnQ0V;
    }

    @Override // BI9f7h.B25kr6, BI9f7h.ADYaiT
    public void update(ADYaiT aDYaiT) {
        float f;
        float f2;
        float f3;
        int i;
        if (B4ZgIw.AYUAbz.ADYaiT(this.f1325AZkASS) == 3) {
            BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
            AaHO0E(aRc23Z.f1165COJEAR, aRc23Z.f1167CSDoyG, 1);
            return;
        }
        ASJ6gh aSJ6gh = this.AMqCpz;
        if (aSJ6gh.f1296A5SV6n && !aSJ6gh.f1302AZkASS && this.f1320ADYaiT == 3) {
            BChYOn.ARc23Z aRc23Z2 = this.f1318A4TApA;
            int i2 = aRc23Z2.f1149B7CMnp;
            if (i2 == 2) {
                BChYOn.ARc23Z aRc23Z3 = aRc23Z2.f1175CrfGsy;
                if (aRc23Z3 != null) {
                    if (aRc23Z3.AMqCpz.AMqCpz.f1302AZkASS) {
                        aSJ6gh.A5SV6n((int) ((r5.f1299ASJ6gh * aRc23Z2.f1156BPw6Q8) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                ASJ6gh aSJ6gh2 = aRc23Z2.f1134ADYaiT.AMqCpz;
                if (aSJ6gh2.f1302AZkASS) {
                    int i3 = aRc23Z2.f1179D6DOie;
                    if (i3 == -1) {
                        f = aSJ6gh2.f1299ASJ6gh;
                        f2 = aRc23Z2.f1178D07BeM;
                    } else if (i3 == 0) {
                        f3 = aSJ6gh2.f1299ASJ6gh * aRc23Z2.f1178D07BeM;
                        i = (int) (f3 + 0.5f);
                        aSJ6gh.A5SV6n(i);
                    } else if (i3 != 1) {
                        i = 0;
                        aSJ6gh.A5SV6n(i);
                    } else {
                        f = aSJ6gh2.f1299ASJ6gh;
                        f2 = aRc23Z2.f1178D07BeM;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    aSJ6gh.A5SV6n(i);
                }
            }
        }
        ARc23Z aRc23Z4 = this.f1323AYUAbz;
        if (aRc23Z4.f1296A5SV6n) {
            ARc23Z aRc23Z5 = this.f1324AZOQYO;
            if (aRc23Z5.f1296A5SV6n) {
                if (aRc23Z4.f1302AZkASS && aRc23Z5.f1302AZkASS && aSJ6gh.f1302AZkASS) {
                    return;
                }
                if (!aSJ6gh.f1302AZkASS && this.f1320ADYaiT == 3) {
                    BChYOn.ARc23Z aRc23Z6 = this.f1318A4TApA;
                    if (aRc23Z6.f1148B4ZgIw == 0 && !aRc23Z6.BJ7GGh()) {
                        ARc23Z aRc23Z7 = (ARc23Z) aRc23Z4.f1304AcNBzu.get(0);
                        ARc23Z aRc23Z8 = (ARc23Z) aRc23Z5.f1304AcNBzu.get(0);
                        int i4 = aRc23Z7.f1299ASJ6gh + aRc23Z4.f1298ARc23Z;
                        int i5 = aRc23Z8.f1299ASJ6gh + aRc23Z5.f1298ARc23Z;
                        aRc23Z4.A5SV6n(i4);
                        aRc23Z5.A5SV6n(i5);
                        aSJ6gh.A5SV6n(i5 - i4);
                        return;
                    }
                }
                if (!aSJ6gh.f1302AZkASS && this.f1320ADYaiT == 3 && this.f1317A2egSU == 1 && aRc23Z4.f1304AcNBzu.size() > 0 && aRc23Z5.f1304AcNBzu.size() > 0) {
                    ARc23Z aRc23Z9 = (ARc23Z) aRc23Z4.f1304AcNBzu.get(0);
                    int i6 = (((ARc23Z) aRc23Z5.f1304AcNBzu.get(0)).f1299ASJ6gh + aRc23Z5.f1298ARc23Z) - (aRc23Z9.f1299ASJ6gh + aRc23Z4.f1298ARc23Z);
                    int i7 = aSJ6gh.f1305AlLFFp;
                    if (i6 < i7) {
                        aSJ6gh.A5SV6n(i6);
                    } else {
                        aSJ6gh.A5SV6n(i7);
                    }
                }
                if (aSJ6gh.f1302AZkASS && aRc23Z4.f1304AcNBzu.size() > 0 && aRc23Z5.f1304AcNBzu.size() > 0) {
                    ARc23Z aRc23Z10 = (ARc23Z) aRc23Z4.f1304AcNBzu.get(0);
                    ARc23Z aRc23Z11 = (ARc23Z) aRc23Z5.f1304AcNBzu.get(0);
                    int i8 = aRc23Z10.f1299ASJ6gh;
                    int i9 = aRc23Z4.f1298ARc23Z + i8;
                    int i10 = aRc23Z11.f1299ASJ6gh;
                    int i11 = aRc23Z5.f1298ARc23Z + i10;
                    float f4 = this.f1318A4TApA.f1186DRlcZ9;
                    if (aRc23Z10 == aRc23Z11) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    aRc23Z4.A5SV6n((int) ((((i10 - i8) - aSJ6gh.f1299ASJ6gh) * f4) + i8 + 0.5f));
                    aRc23Z5.A5SV6n(aRc23Z4.f1299ASJ6gh + aSJ6gh.f1299ASJ6gh);
                }
            }
        }
    }
}
