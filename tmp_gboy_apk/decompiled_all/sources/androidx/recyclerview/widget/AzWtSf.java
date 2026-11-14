package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AzWtSf extends ECyGFg {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static TimeInterpolator f9213B4ZgIw;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ArrayList f9214AYUAbz = new ArrayList();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ArrayList f9215AZOQYO = new ArrayList();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final ArrayList f9216AZkASS = new ArrayList();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final ArrayList f9217AaHO0E = new ArrayList();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f9218AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f9219AlLFFp = new ArrayList();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f9220AmA8tU = new ArrayList();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f9221AzWtSf = new ArrayList();

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f9222B25kr6 = new ArrayList();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f9223B2KMhB = new ArrayList();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f9224B3GDIM = new ArrayList();

    public static void B2KMhB(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Dphsd2) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean ASJ6gh(Dphsd2 dphsd2, List list) {
        return !list.isEmpty() || ARc23Z(dphsd2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final void AZOQYO(Dphsd2 dphsd2) {
        View view = dphsd2.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f9216AZkASS;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((AmA8tU) arrayList.get(size)).f9209A2egSU == dphsd2) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                AYUAbz(dphsd2);
                arrayList.remove(size);
            }
        }
        B4ZgIw(this.f9217AaHO0E, dphsd2);
        if (this.f9214AYUAbz.remove(dphsd2)) {
            view.setAlpha(1.0f);
            AYUAbz(dphsd2);
        }
        if (this.f9215AZOQYO.remove(dphsd2)) {
            view.setAlpha(1.0f);
            AYUAbz(dphsd2);
        }
        ArrayList arrayList2 = this.f9220AmA8tU;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            B4ZgIw(arrayList3, dphsd2);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f9219AlLFFp;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((AmA8tU) arrayList5.get(size4)).f9209A2egSU == dphsd2) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    AYUAbz(dphsd2);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f9218AcNBzu;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(dphsd2)) {
                view.setAlpha(1.0f);
                AYUAbz(dphsd2);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f9223B2KMhB.remove(dphsd2);
        this.f9221AzWtSf.remove(dphsd2);
        this.f9224B3GDIM.remove(dphsd2);
        this.f9222B25kr6.remove(dphsd2);
        B3GDIM();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final void AZkASS() {
        ArrayList arrayList = this.f9216AZkASS;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            AmA8tU amA8tU = (AmA8tU) arrayList.get(size);
            View view = amA8tU.f9209A2egSU.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            AYUAbz(amA8tU.f9209A2egSU);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f9214AYUAbz;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            AYUAbz((Dphsd2) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f9215AZOQYO;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            Dphsd2 dphsd2 = (Dphsd2) arrayList3.get(size3);
            dphsd2.itemView.setAlpha(1.0f);
            AYUAbz(dphsd2);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f9217AaHO0E;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            AlLFFp alLFFp = (AlLFFp) arrayList4.get(size4);
            Dphsd2 dphsd22 = alLFFp.f9204A2egSU;
            if (dphsd22 != null) {
                B7CMnp(alLFFp, dphsd22);
            }
            Dphsd2 dphsd23 = alLFFp.f9205A4TApA;
            if (dphsd23 != null) {
                B7CMnp(alLFFp, dphsd23);
            }
        }
        arrayList4.clear();
        if (AaHO0E()) {
            ArrayList arrayList5 = this.f9219AlLFFp;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    AmA8tU amA8tU2 = (AmA8tU) arrayList6.get(size6);
                    View view2 = amA8tU2.f9209A2egSU.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    AYUAbz(amA8tU2.f9209A2egSU);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f9218AcNBzu;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    Dphsd2 dphsd24 = (Dphsd2) arrayList8.get(size8);
                    dphsd24.itemView.setAlpha(1.0f);
                    AYUAbz(dphsd24);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f9220AmA8tU;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    AlLFFp alLFFp2 = (AlLFFp) arrayList10.get(size10);
                    Dphsd2 dphsd25 = alLFFp2.f9204A2egSU;
                    if (dphsd25 != null) {
                        B7CMnp(alLFFp2, dphsd25);
                    }
                    Dphsd2 dphsd26 = alLFFp2.f9205A4TApA;
                    if (dphsd26 != null) {
                        B7CMnp(alLFFp2, dphsd26);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            B2KMhB(this.f9223B2KMhB);
            B2KMhB(this.f9222B25kr6);
            B2KMhB(this.f9221AzWtSf);
            B2KMhB(this.f9224B3GDIM);
            ArrayList arrayList11 = this.f9427A4TApA;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean AaHO0E() {
        return (this.f9215AZOQYO.isEmpty() && this.f9217AaHO0E.isEmpty() && this.f9216AZkASS.isEmpty() && this.f9214AYUAbz.isEmpty() && this.f9222B25kr6.isEmpty() && this.f9223B2KMhB.isEmpty() && this.f9221AzWtSf.isEmpty() && this.f9224B3GDIM.isEmpty() && this.f9219AlLFFp.isEmpty() && this.f9218AcNBzu.isEmpty() && this.f9220AmA8tU.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final void AcNBzu() {
        int i = 0;
        ArrayList arrayList = this.f9214AYUAbz;
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = this.f9216AZkASS;
        boolean isEmpty2 = arrayList2.isEmpty();
        ArrayList arrayList3 = this.f9217AaHO0E;
        boolean isEmpty3 = arrayList3.isEmpty();
        ArrayList arrayList4 = this.f9215AZOQYO;
        boolean isEmpty4 = arrayList4.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Dphsd2 dphsd2 = (Dphsd2) it.next();
            View view = dphsd2.itemView;
            ViewPropertyAnimator animate = view.animate();
            this.f9223B2KMhB.add(dphsd2);
            animate.setDuration(this.f9429ADYaiT).alpha(0.0f).setListener(new AZkASS(this, dphsd2, animate, view)).start();
        }
        arrayList.clear();
        if (!isEmpty2) {
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList2);
            this.f9219AlLFFp.add(arrayList5);
            arrayList2.clear();
            AZOQYO azoqyo = new AZOQYO(this, arrayList5, i);
            if (isEmpty) {
                azoqyo.run();
            } else {
                View view2 = ((AmA8tU) arrayList5.get(0)).f9209A2egSU.itemView;
                long j = this.f9429ADYaiT;
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                view2.postOnAnimationDelayed(azoqyo, j);
            }
        }
        if (!isEmpty3) {
            ArrayList arrayList6 = new ArrayList();
            arrayList6.addAll(arrayList3);
            this.f9220AmA8tU.add(arrayList6);
            arrayList3.clear();
            AZOQYO azoqyo2 = new AZOQYO(this, arrayList6, 1);
            if (isEmpty) {
                azoqyo2.run();
            } else {
                View view3 = ((AlLFFp) arrayList6.get(0)).f9204A2egSU.itemView;
                long j2 = this.f9429ADYaiT;
                WeakHashMap weakHashMap2 = COJEAR.DG07BK.f1680A2egSU;
                view3.postOnAnimationDelayed(azoqyo2, j2);
            }
        }
        if (isEmpty4) {
            return;
        }
        ArrayList arrayList7 = new ArrayList();
        arrayList7.addAll(arrayList4);
        this.f9218AcNBzu.add(arrayList7);
        arrayList4.clear();
        AZOQYO azoqyo3 = new AZOQYO(this, arrayList7, 2);
        if (isEmpty && isEmpty2 && isEmpty3) {
            azoqyo3.run();
            return;
        }
        long max = Math.max(!isEmpty2 ? this.AMqCpz : 0L, isEmpty3 ? 0L : this.f9430ARc23Z) + (!isEmpty ? this.f9429ADYaiT : 0L);
        View view4 = ((Dphsd2) arrayList7.get(0)).itemView;
        WeakHashMap weakHashMap3 = COJEAR.DG07BK.f1680A2egSU;
        view4.postOnAnimationDelayed(azoqyo3, max);
    }

    @Override // androidx.recyclerview.widget.ECyGFg
    public final void AlLFFp(Dphsd2 dphsd2) {
        B9tovu(dphsd2);
        dphsd2.itemView.setAlpha(0.0f);
        this.f9215AZOQYO.add(dphsd2);
    }

    @Override // androidx.recyclerview.widget.ECyGFg
    public final boolean AmA8tU(Dphsd2 dphsd2, Dphsd2 dphsd22, int i, int i2, int i3, int i4) {
        if (dphsd2 == dphsd22) {
            return AzWtSf(dphsd2, i, i2, i3, i4);
        }
        float translationX = dphsd2.itemView.getTranslationX();
        float translationY = dphsd2.itemView.getTranslationY();
        float alpha = dphsd2.itemView.getAlpha();
        B9tovu(dphsd2);
        dphsd2.itemView.setTranslationX(translationX);
        dphsd2.itemView.setTranslationY(translationY);
        dphsd2.itemView.setAlpha(alpha);
        B9tovu(dphsd22);
        dphsd22.itemView.setTranslationX(-((int) ((i3 - i) - translationX)));
        dphsd22.itemView.setTranslationY(-((int) ((i4 - i2) - translationY)));
        dphsd22.itemView.setAlpha(0.0f);
        ArrayList arrayList = this.f9217AaHO0E;
        AlLFFp alLFFp = new AlLFFp();
        alLFFp.f9204A2egSU = dphsd2;
        alLFFp.f9205A4TApA = dphsd22;
        alLFFp.f9206A5SV6n = i;
        alLFFp.f9207ADYaiT = i2;
        alLFFp.AMqCpz = i3;
        alLFFp.f9208ARc23Z = i4;
        arrayList.add(alLFFp);
        return true;
    }

    @Override // androidx.recyclerview.widget.ECyGFg
    public final boolean AzWtSf(Dphsd2 dphsd2, int i, int i2, int i3, int i4) {
        View view = dphsd2.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) dphsd2.itemView.getTranslationY());
        B9tovu(dphsd2);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            AYUAbz(dphsd2);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ArrayList arrayList = this.f9216AZkASS;
        AmA8tU amA8tU = new AmA8tU();
        amA8tU.f9209A2egSU = dphsd2;
        amA8tU.f9210A4TApA = translationX;
        amA8tU.f9211A5SV6n = translationY;
        amA8tU.f9212ADYaiT = i3;
        amA8tU.AMqCpz = i4;
        arrayList.add(amA8tU);
        return true;
    }

    @Override // androidx.recyclerview.widget.ECyGFg
    public final void B25kr6(Dphsd2 dphsd2) {
        B9tovu(dphsd2);
        this.f9214AYUAbz.add(dphsd2);
    }

    public final void B3GDIM() {
        if (AaHO0E()) {
            return;
        }
        ArrayList arrayList = this.f9427A4TApA;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void B4ZgIw(ArrayList arrayList, Dphsd2 dphsd2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AlLFFp alLFFp = (AlLFFp) arrayList.get(size);
            if (B7CMnp(alLFFp, dphsd2) && alLFFp.f9204A2egSU == null && alLFFp.f9205A4TApA == null) {
                arrayList.remove(alLFFp);
            }
        }
    }

    public final boolean B7CMnp(AlLFFp alLFFp, Dphsd2 dphsd2) {
        if (alLFFp.f9205A4TApA == dphsd2) {
            alLFFp.f9205A4TApA = null;
        } else {
            if (alLFFp.f9204A2egSU != dphsd2) {
                return false;
            }
            alLFFp.f9204A2egSU = null;
        }
        dphsd2.itemView.setAlpha(1.0f);
        dphsd2.itemView.setTranslationX(0.0f);
        dphsd2.itemView.setTranslationY(0.0f);
        AYUAbz(dphsd2);
        return true;
    }

    public final void B9tovu(Dphsd2 dphsd2) {
        if (f9213B4ZgIw == null) {
            f9213B4ZgIw = new ValueAnimator().getInterpolator();
        }
        dphsd2.itemView.animate().setInterpolator(f9213B4ZgIw);
        AZOQYO(dphsd2);
    }
}
