package ADYaiT;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.MenuItem;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CcAIMM implements Hjvs0g.BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object f135AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f136AlLFFp;

    public CcAIMM(Context context) {
        this.f135AcNBzu = context;
    }

    public abstract void A5SV6n();

    public void ADYaiT() {
        CTkVKb cTkVKb = (CTkVKb) this.f135AcNBzu;
        if (cTkVKb != null) {
            try {
                ((CkXcdM) this.f136AlLFFp).f157BChYOn.unregisterReceiver(cTkVKb);
            } catch (IllegalArgumentException unused) {
            }
            this.f135AcNBzu = null;
        }
    }

    public abstract IntentFilter AMqCpz();

    public abstract int ARc23Z();

    public MenuItem ASJ6gh(MenuItem menuItem) {
        if (!(menuItem instanceof BniPrB.A2egSU)) {
            return menuItem;
        }
        BniPrB.A2egSU a2egSU = (BniPrB.A2egSU) menuItem;
        if (((B25kr6.AzWtSf) this.f136AlLFFp) == null) {
            this.f136AlLFFp = new B25kr6.AzWtSf();
        }
        MenuItem menuItem2 = (MenuItem) ((B25kr6.AzWtSf) this.f136AlLFFp).get(a2egSU);
        if (menuItem2 != null) {
            return menuItem2;
        }
        AZkASS.B9tovu b9tovu = new AZkASS.B9tovu((Context) this.f135AcNBzu, a2egSU);
        ((B25kr6.AzWtSf) this.f136AlLFFp).put(a2egSU, b9tovu);
        return b9tovu;
    }

    @Override // Hjvs0g.BIYEnU
    public Hjvs0g.BI9f7h AYUAbz(Hjvs0g.BmvVmW bmvVmW) {
        Class cls = (Class) this.f136AlLFFp;
        return new HtmBAy.ADYaiT((Context) this.f135AcNBzu, bmvVmW.A5SV6n(File.class, cls), bmvVmW.A5SV6n(Uri.class, cls), cls);
    }

    public abstract void AZOQYO();

    public abstract void AZkASS();

    public abstract void AaHO0E(OvgpEe.A5SV6n a5SV6n);

    public abstract void AcNBzu();

    public void AlLFFp() {
        ADYaiT();
        IntentFilter AMqCpz = AMqCpz();
        if (AMqCpz.countActions() == 0) {
            return;
        }
        if (((CTkVKb) this.f135AcNBzu) == null) {
            this.f135AcNBzu = new CTkVKb(0, this);
        }
        ((CkXcdM) this.f136AlLFFp).f157BChYOn.registerReceiver((CTkVKb) this.f135AcNBzu, AMqCpz);
    }

    public abstract void AmA8tU();

    public abstract void AzWtSf();

    public CcAIMM(int i) {
        this.f136AlLFFp = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            ((ArrayList) this.f136AlLFFp).add(new OvgpEe.AYUAbz());
        }
    }

    public CcAIMM(Context context, Class cls) {
        this.f135AcNBzu = context;
        this.f136AlLFFp = cls;
    }

    public CcAIMM(CkXcdM ckXcdM) {
        this.f136AlLFFp = ckXcdM;
    }
}
