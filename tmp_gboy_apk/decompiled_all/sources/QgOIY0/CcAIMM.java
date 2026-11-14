package QgOIY0;

import com.sigmob.sdk.base.views.r;
import java.io.PrintWriter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class CcAIMM extends CSDoyG {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final QkAq4X.AZOQYO f7699A2egSU = new QkAq4X.AZOQYO();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final QkAq4X.AZOQYO f7700A4TApA = new QkAq4X.AZOQYO();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f7701A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f7702ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f7703ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public B3GDIM f7704ASJ6gh;

    public CcAIMM(String str, B3GDIM b3gdim, boolean z) {
        this.f7701A5SV6n = str;
        this.f7704ASJ6gh = b3gdim;
        this.f7702ADYaiT = z;
    }

    public final void A2egSU(String str, PrintWriter printWriter) {
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        if (azoqyo.A4TApA() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < azoqyo.A4TApA(); i++) {
                CTkVKb cTkVKb = (CTkVKb) azoqyo.ASJ6gh(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(azoqyo.AMqCpz(i));
                printWriter.print(": ");
                printWriter.println(cTkVKb.toString());
                cTkVKb.A4TApA(str2, printWriter);
            }
        }
        QkAq4X.AZOQYO azoqyo2 = this.f7700A4TApA;
        if (azoqyo2.A4TApA() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < azoqyo2.A4TApA(); i2++) {
                CTkVKb cTkVKb2 = (CTkVKb) azoqyo2.ASJ6gh(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(azoqyo2.AMqCpz(i2));
                printWriter.print(": ");
                printWriter.println(cTkVKb2.toString());
                cTkVKb2.A4TApA(str3, printWriter);
            }
        }
    }

    public final boolean A4TApA() {
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        int A4TApA2 = azoqyo.A4TApA();
        int i = 0;
        boolean z = false;
        while (i < A4TApA2) {
            CTkVKb cTkVKb = (CTkVKb) azoqyo.ASJ6gh(i);
            i++;
            z |= cTkVKb.f7692ARc23Z && !cTkVKb.f7691ADYaiT;
        }
        return z;
    }

    public final void A5SV6n() {
        if (this.f7702ADYaiT) {
            new RuntimeException("here").fillInStackTrace();
            toString();
            return;
        }
        this.f7702ADYaiT = true;
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
            ((CTkVKb) azoqyo.ASJ6gh(A4TApA2)).A2egSU();
        }
    }

    public final void ADYaiT() {
        if (!this.f7702ADYaiT) {
            new RuntimeException("here").fillInStackTrace();
            toString();
            return;
        }
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
            ((CTkVKb) azoqyo.ASJ6gh(A4TApA2)).ADYaiT();
        }
        this.f7702ADYaiT = false;
    }

    public final void AMqCpz() {
        if (!this.f7702ADYaiT) {
            new RuntimeException("here").fillInStackTrace();
            toString();
            return;
        }
        this.AMqCpz = true;
        this.f7702ADYaiT = false;
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
            CTkVKb cTkVKb = (CTkVKb) azoqyo.ASJ6gh(A4TApA2);
            cTkVKb.f7693ASJ6gh = true;
            cTkVKb.f7694AYUAbz = cTkVKb.f7692ARc23Z;
            cTkVKb.f7692ARc23Z = false;
            cTkVKb.f7688A2egSU = null;
        }
    }

    public final void ARc23Z() {
        QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
        for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
            CTkVKb cTkVKb = (CTkVKb) azoqyo.ASJ6gh(A4TApA2);
            if (cTkVKb.f7692ARc23Z && cTkVKb.f7695AZOQYO) {
                cTkVKb.f7695AZOQYO = false;
                if (cTkVKb.f7690A5SV6n && !cTkVKb.f7693ASJ6gh) {
                    cTkVKb.A5SV6n(cTkVKb.AMqCpz);
                }
            }
        }
    }

    public final void ASJ6gh() {
        if (!this.AMqCpz) {
            QkAq4X.AZOQYO azoqyo = this.f7699A2egSU;
            for (int A4TApA2 = azoqyo.A4TApA() - 1; A4TApA2 >= 0; A4TApA2--) {
                ((CTkVKb) azoqyo.ASJ6gh(A4TApA2)).AMqCpz();
            }
            int i = azoqyo.f7757AzWtSf;
            Object[] objArr = azoqyo.f7756AmA8tU;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            azoqyo.f7757AzWtSf = 0;
            azoqyo.f7754AcNBzu = false;
        }
        QkAq4X.AZOQYO azoqyo2 = this.f7700A4TApA;
        for (int A4TApA3 = azoqyo2.A4TApA() - 1; A4TApA3 >= 0; A4TApA3--) {
            ((CTkVKb) azoqyo2.ASJ6gh(A4TApA3)).AMqCpz();
        }
        int i3 = azoqyo2.f7757AzWtSf;
        Object[] objArr2 = azoqyo2.f7756AmA8tU;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr2[i4] = null;
        }
        azoqyo2.f7757AzWtSf = 0;
        azoqyo2.f7754AcNBzu = false;
        this.f7704ASJ6gh = null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        QkAq4X.ADYaiT.A4TApA(this.f7704ASJ6gh, sb);
        sb.append("}}");
        return sb.toString();
    }
}
