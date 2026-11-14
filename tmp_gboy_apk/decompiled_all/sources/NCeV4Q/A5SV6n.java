package NCeV4Q;

import QgOIY0.CTkVKb;
import QgOIY0.CcAIMM;
import android.content.Context;
import android.os.SystemClock;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public CTkVKb f5634A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public CTkVKb f5635A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f5636A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f5637ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public volatile QigWB9.A2egSU f5638ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public volatile QigWB9.A2egSU f5639ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ThreadPoolExecutor f5640AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final Semaphore f5641AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Set f5642AZkASS;

    public A5SV6n(Context context, Set set) {
        ThreadPoolExecutor threadPoolExecutor = QigWB9.AMqCpz.f7711B2KMhB;
        this.f5636A5SV6n = false;
        this.f5637ADYaiT = true;
        this.AMqCpz = false;
        context.getApplicationContext();
        this.f5640AYUAbz = threadPoolExecutor;
        this.f5641AZOQYO = new Semaphore(0);
        this.f5642AZkASS = set;
    }

    public final void A2egSU(QigWB9.A2egSU a2egSU) {
        if (this.f5639ASJ6gh == a2egSU) {
            SystemClock.uptimeMillis();
            this.f5639ASJ6gh = null;
            CTkVKb cTkVKb = this.f5635A4TApA;
            if (cTkVKb != null && !cTkVKb.f7696AZkASS) {
                cTkVKb.f7698AcNBzu.f7699A2egSU.A2egSU(0);
            }
            A5SV6n();
        }
    }

    public final void A4TApA(QigWB9.A2egSU a2egSU, Object obj) {
        if (this.f5638ARc23Z != a2egSU) {
            A2egSU(a2egSU);
            return;
        }
        SystemClock.uptimeMillis();
        this.f5638ARc23Z = null;
        CTkVKb cTkVKb = this.f5634A2egSU;
        if (cTkVKb == null || cTkVKb.f7696AZkASS) {
            return;
        }
        CcAIMM ccAIMM = cTkVKb.f7698AcNBzu;
        if (ccAIMM.f7699A2egSU.A2egSU(0) != cTkVKb) {
            return;
        }
        if (cTkVKb.AMqCpz != obj || !cTkVKb.f7690A5SV6n) {
            cTkVKb.AMqCpz = obj;
            cTkVKb.f7690A5SV6n = true;
            if (cTkVKb.f7692ARc23Z) {
                cTkVKb.A5SV6n(obj);
            }
        }
        QkAq4X.AZOQYO azoqyo = ccAIMM.f7700A4TApA;
        CTkVKb cTkVKb2 = (CTkVKb) azoqyo.A2egSU(0);
        if (cTkVKb2 != null && cTkVKb2 != cTkVKb) {
            cTkVKb2.f7691ADYaiT = false;
            cTkVKb2.AMqCpz();
            azoqyo.ADYaiT(0);
        }
        if (ccAIMM.f7704ASJ6gh == null || ccAIMM.A4TApA()) {
            return;
        }
        ccAIMM.f7704ASJ6gh.f7589A5SV6n.BniPrB();
    }

    public final void A5SV6n() {
        if (this.f5639ASJ6gh != null || this.f5638ARc23Z == null) {
            return;
        }
        this.f5638ARc23Z.getClass();
        QigWB9.A2egSU a2egSU = this.f5638ARc23Z;
        ThreadPoolExecutor threadPoolExecutor = this.f5640AYUAbz;
        if (a2egSU.f7716AmA8tU != 1) {
            int i = QigWB9.A5SV6n.f7708A2egSU[B4ZgIw.AYUAbz.ADYaiT(a2egSU.f7716AmA8tU)];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        a2egSU.f7716AmA8tU = 2;
        a2egSU.f7714AcNBzu.getClass();
        threadPoolExecutor.execute(a2egSU.f7715AlLFFp);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        QkAq4X.ADYaiT.A4TApA(this, sb);
        sb.append(" id=");
        sb.append(0);
        sb.append("}");
        return sb.toString();
    }
}
