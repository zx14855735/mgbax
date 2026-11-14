package QgOIY0;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BniPrB implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Transition f7648AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final View f7649AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final B2KMhB f7650AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f7651AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f7652B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f7653B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Transition f7654B3GDIM;

    public BniPrB(Transition transition, View view, B2KMhB b2KMhB, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Transition transition2) {
        this.f7648AcNBzu = transition;
        this.f7649AlLFFp = view;
        this.f7650AmA8tU = b2KMhB;
        this.f7651AzWtSf = arrayList;
        this.f7652B25kr6 = arrayList2;
        this.f7653B2KMhB = arrayList3;
        this.f7654B3GDIM = transition2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f7649AlLFFp;
        Transition transition = this.f7648AcNBzu;
        if (transition != null) {
            transition.removeTarget(view);
            this.f7652B25kr6.addAll(AMqCpz.AcNBzu(transition, this.f7650AmA8tU, this.f7651AzWtSf, view));
        }
        ArrayList arrayList = this.f7653B2KMhB;
        if (arrayList != null) {
            Transition transition2 = this.f7654B3GDIM;
            if (transition2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(view);
                AMqCpz.AlLFFp(transition2, arrayList, arrayList2);
            }
            arrayList.clear();
            arrayList.add(view);
        }
    }
}
