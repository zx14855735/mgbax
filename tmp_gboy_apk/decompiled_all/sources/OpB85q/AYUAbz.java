package OpB85q;

import ADYaiT.CtFAbx;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS.AmA8tU f6726A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f6728A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6729ADYaiT = 0;
    public int AMqCpz = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f6727A4TApA = new ArrayList();

    public AYUAbz(AZkASS.AmA8tU amA8tU) {
        this.f6726A2egSU = amA8tU;
        A4TApA();
    }

    public final MenuItem A2egSU(int i) {
        return (MenuItem) this.f6727A4TApA.get(i);
    }

    public final void A4TApA() {
        ArrayList arrayList = this.f6727A4TApA;
        arrayList.clear();
        this.f6728A5SV6n = 0;
        this.f6729ADYaiT = 0;
        this.AMqCpz = 0;
        int i = 0;
        while (true) {
            AZkASS.AmA8tU amA8tU = this.f6726A2egSU;
            if (i >= amA8tU.f498B2KMhB.size()) {
                break;
            }
            MenuItem item = amA8tU.getItem(i);
            if (item.hasSubMenu()) {
                if (!arrayList.isEmpty() && !(CtFAbx.ADYaiT(arrayList, 1) instanceof A2egSU) && item.isVisible()) {
                    arrayList.add(new A2egSU());
                }
                arrayList.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i2 = 0; i2 < subMenu.size(); i2++) {
                    MenuItem item2 = subMenu.getItem(i2);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    arrayList.add(item2);
                    this.f6728A5SV6n++;
                    if (item2.isVisible()) {
                        this.f6729ADYaiT++;
                    }
                }
                arrayList.add(new A2egSU());
            } else {
                arrayList.add(item);
                this.f6728A5SV6n++;
                if (item.isVisible()) {
                    this.f6729ADYaiT++;
                    this.AMqCpz++;
                }
            }
            i++;
        }
        if (arrayList.isEmpty() || !(CtFAbx.ADYaiT(arrayList, 1) instanceof A2egSU)) {
            return;
        }
        arrayList.remove(arrayList.size() - 1);
    }
}
