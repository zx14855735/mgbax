package BI9f7h;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO {
    public static AzWtSf A2egSU(BChYOn.ARc23Z aRc23Z, int i, ArrayList arrayList, AzWtSf azWtSf) {
        int i2;
        int i3 = i == 0 ? aRc23Z.f1193De4eam : aRc23Z.f1194DjONCG;
        if (i3 != -1 && (azWtSf == null || i3 != azWtSf.f1314A4TApA)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                AzWtSf azWtSf2 = (AzWtSf) arrayList.get(i4);
                if (azWtSf2.f1314A4TApA == i3) {
                    if (azWtSf != null) {
                        azWtSf.A5SV6n(i, azWtSf2);
                        arrayList.remove(azWtSf);
                    }
                    azWtSf = azWtSf2;
                } else {
                    i4++;
                }
            }
        } else if (i3 != -1) {
            return azWtSf;
        }
        if (azWtSf == null) {
            if (aRc23Z instanceof BChYOn.AaHO0E) {
                BChYOn.AaHO0E aaHO0E = (BChYOn.AaHO0E) aRc23Z;
                int i5 = 0;
                while (true) {
                    if (i5 >= aaHO0E.f1263DvK7DB) {
                        i2 = -1;
                        break;
                    }
                    BChYOn.ARc23Z aRc23Z2 = aaHO0E.f1262DuwtYk[i5];
                    if ((i == 0 && (i2 = aRc23Z2.f1193De4eam) != -1) || (i == 1 && (i2 = aRc23Z2.f1194DjONCG) != -1)) {
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            break;
                        }
                        AzWtSf azWtSf3 = (AzWtSf) arrayList.get(i6);
                        if (azWtSf3.f1314A4TApA == i2) {
                            azWtSf = azWtSf3;
                            break;
                        }
                        i6++;
                    }
                }
            }
            if (azWtSf == null) {
                azWtSf = new AzWtSf();
                azWtSf.f1313A2egSU = new ArrayList();
                azWtSf.f1316ADYaiT = null;
                azWtSf.AMqCpz = -1;
                int i7 = AzWtSf.f1312ARc23Z;
                AzWtSf.f1312ARc23Z = i7 + 1;
                azWtSf.f1314A4TApA = i7;
                azWtSf.f1315A5SV6n = i;
            }
            arrayList.add(azWtSf);
        }
        ArrayList arrayList2 = azWtSf.f1313A2egSU;
        if (arrayList2.contains(aRc23Z)) {
            return azWtSf;
        }
        arrayList2.add(aRc23Z);
        if (aRc23Z instanceof BChYOn.AZkASS) {
            BChYOn.AZkASS aZkASS = (BChYOn.AZkASS) aRc23Z;
            aZkASS.f1259ECyGFg.A5SV6n(aZkASS.f1260EGM26s == 0 ? 1 : 0, azWtSf, arrayList);
        }
        int i8 = azWtSf.f1314A4TApA;
        if (i == 0) {
            aRc23Z.f1193De4eam = i8;
            aRc23Z.f1164CNPG0E.A5SV6n(i, azWtSf, arrayList);
            aRc23Z.f1166CQhlFr.A5SV6n(i, azWtSf, arrayList);
        } else {
            aRc23Z.f1194DjONCG = i8;
            aRc23Z.f1165COJEAR.A5SV6n(i, azWtSf, arrayList);
            aRc23Z.f1168CTkVKb.A5SV6n(i, azWtSf, arrayList);
            aRc23Z.f1167CSDoyG.A5SV6n(i, azWtSf, arrayList);
        }
        aRc23Z.f1171CikNvS.A5SV6n(i, azWtSf, arrayList);
        return azWtSf;
    }

    public static boolean A4TApA(int i, int i2, int i3, int i4) {
        return (i3 == 1 || i3 == 2 || (i3 == 4 && i != 2)) || (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2));
    }
}
