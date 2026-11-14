package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f9188AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9189AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f9190AmA8tU;

    public /* synthetic */ AZOQYO(AzWtSf azWtSf, ArrayList arrayList, int i) {
        this.f9188AcNBzu = i;
        this.f9190AmA8tU = azWtSf;
        this.f9189AlLFFp = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9188AcNBzu) {
            case 0:
                ArrayList arrayList = this.f9189AlLFFp;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    AzWtSf azWtSf = this.f9190AmA8tU;
                    if (!hasNext) {
                        arrayList.clear();
                        azWtSf.f9219AlLFFp.remove(arrayList);
                        break;
                    } else {
                        AmA8tU amA8tU = (AmA8tU) it.next();
                        Dphsd2 dphsd2 = amA8tU.f9209A2egSU;
                        azWtSf.getClass();
                        View view = dphsd2.itemView;
                        int i = amA8tU.f9212ADYaiT - amA8tU.f9210A4TApA;
                        int i2 = amA8tU.AMqCpz - amA8tU.f9211A5SV6n;
                        if (i != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i2 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        azWtSf.f9222B25kr6.add(dphsd2);
                        animate.setDuration(azWtSf.AMqCpz).setListener(new AaHO0E(azWtSf, dphsd2, i, view, i2, animate)).start();
                    }
                }
            case 1:
                ArrayList arrayList2 = this.f9189AlLFFp;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    boolean hasNext2 = it2.hasNext();
                    AzWtSf azWtSf2 = this.f9190AmA8tU;
                    if (!hasNext2) {
                        arrayList2.clear();
                        azWtSf2.f9220AmA8tU.remove(arrayList2);
                        break;
                    } else {
                        AlLFFp alLFFp = (AlLFFp) it2.next();
                        azWtSf2.getClass();
                        Dphsd2 dphsd22 = alLFFp.f9204A2egSU;
                        View view2 = dphsd22 == null ? null : dphsd22.itemView;
                        Dphsd2 dphsd23 = alLFFp.f9205A4TApA;
                        View view3 = dphsd23 != null ? dphsd23.itemView : null;
                        ArrayList arrayList3 = azWtSf2.f9224B3GDIM;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(azWtSf2.f9430ARc23Z);
                            arrayList3.add(alLFFp.f9204A2egSU);
                            duration.translationX(alLFFp.AMqCpz - alLFFp.f9206A5SV6n);
                            duration.translationY(alLFFp.f9208ARc23Z - alLFFp.f9207ADYaiT);
                            duration.alpha(0.0f).setListener(new AcNBzu(azWtSf2, alLFFp, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator animate2 = view3.animate();
                            arrayList3.add(alLFFp.f9205A4TApA);
                            animate2.translationX(0.0f).translationY(0.0f).setDuration(azWtSf2.f9430ARc23Z).alpha(1.0f).setListener(new AcNBzu(azWtSf2, alLFFp, animate2, view3, 1)).start();
                        }
                    }
                }
            default:
                ArrayList arrayList4 = this.f9189AlLFFp;
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    boolean hasNext3 = it3.hasNext();
                    AzWtSf azWtSf3 = this.f9190AmA8tU;
                    if (!hasNext3) {
                        arrayList4.clear();
                        azWtSf3.f9218AcNBzu.remove(arrayList4);
                        break;
                    } else {
                        Dphsd2 dphsd24 = (Dphsd2) it3.next();
                        azWtSf3.getClass();
                        View view4 = dphsd24.itemView;
                        ViewPropertyAnimator animate3 = view4.animate();
                        azWtSf3.f9221AzWtSf.add(dphsd24);
                        animate3.alpha(1.0f).setDuration(azWtSf3.f9428A5SV6n).setListener(new AZkASS(azWtSf3, dphsd24, view4, animate3)).start();
                    }
                }
        }
    }
}
