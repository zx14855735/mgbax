package BI9f7h;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z implements ADYaiT {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final B25kr6 f1297ADYaiT;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f1298ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f1299ASJ6gh;

    /* renamed from: A2egSU, reason: collision with root package name */
    public B25kr6 f1294A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f1295A4TApA = false;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1296A5SV6n = false;
    public int AMqCpz = 1;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1300AYUAbz = 1;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public ASJ6gh f1301AZOQYO = null;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f1302AZkASS = false;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final ArrayList f1303AaHO0E = new ArrayList();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f1304AcNBzu = new ArrayList();

    public ARc23Z(B25kr6 b25kr6) {
        this.f1297ADYaiT = b25kr6;
    }

    public final void A2egSU(B25kr6 b25kr6) {
        this.f1303AaHO0E.add(b25kr6);
        if (this.f1302AZkASS) {
            b25kr6.update(b25kr6);
        }
    }

    public final void A4TApA() {
        this.f1304AcNBzu.clear();
        this.f1303AaHO0E.clear();
        this.f1302AZkASS = false;
        this.f1299ASJ6gh = 0;
        this.f1296A5SV6n = false;
        this.f1295A4TApA = false;
    }

    public void A5SV6n(int i) {
        if (this.f1302AZkASS) {
            return;
        }
        this.f1302AZkASS = true;
        this.f1299ASJ6gh = i;
        Iterator it = this.f1303AaHO0E.iterator();
        while (it.hasNext()) {
            ADYaiT aDYaiT = (ADYaiT) it.next();
            aDYaiT.update(aDYaiT);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1297ADYaiT.f1318A4TApA.f1189DXnQ0V);
        sb.append(":");
        switch (this.AMqCpz) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f1302AZkASS ? Integer.valueOf(this.f1299ASJ6gh) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f1304AcNBzu.size());
        sb.append(":d=");
        sb.append(this.f1303AaHO0E.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // BI9f7h.ADYaiT
    public void update(ADYaiT aDYaiT) {
        ArrayList arrayList = this.f1304AcNBzu;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((ARc23Z) it.next()).f1302AZkASS) {
                return;
            }
        }
        this.f1296A5SV6n = true;
        B25kr6 b25kr6 = this.f1294A2egSU;
        if (b25kr6 != null) {
            b25kr6.update(this);
        }
        if (this.f1295A4TApA) {
            this.f1297ADYaiT.update(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        ARc23Z aRc23Z = null;
        int i = 0;
        while (it2.hasNext()) {
            ARc23Z aRc23Z2 = (ARc23Z) it2.next();
            if (!(aRc23Z2 instanceof ASJ6gh)) {
                i++;
                aRc23Z = aRc23Z2;
            }
        }
        if (aRc23Z != null && i == 1 && aRc23Z.f1302AZkASS) {
            ASJ6gh aSJ6gh = this.f1301AZOQYO;
            if (aSJ6gh != null) {
                if (!aSJ6gh.f1302AZkASS) {
                    return;
                } else {
                    this.f1298ARc23Z = this.f1300AYUAbz * aSJ6gh.f1299ASJ6gh;
                }
            }
            A5SV6n(aRc23Z.f1299ASJ6gh + this.f1298ARc23Z);
        }
        B25kr6 b25kr62 = this.f1294A2egSU;
        if (b25kr62 != null) {
            b25kr62.update(this);
        }
    }
}
