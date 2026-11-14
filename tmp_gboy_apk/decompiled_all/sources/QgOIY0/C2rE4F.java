package QgOIY0;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class C2rE4F implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final QkAq4X.A4TApA f7660AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final TransitionSet f7661AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final C4FrIb f7662AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f7663AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final B2KMhB f7664B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final B2KMhB f7665B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f7666B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f7667B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Transition f7668B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Rect f7669B9tovu;

    public C2rE4F(QkAq4X.A4TApA a4TApA, TransitionSet transitionSet, C4FrIb c4FrIb, ArrayList arrayList, View view, B2KMhB b2KMhB, B2KMhB b2KMhB2, boolean z, ArrayList arrayList2, Transition transition, Rect rect) {
        this.f7660AcNBzu = a4TApA;
        this.f7661AlLFFp = transitionSet;
        this.f7662AmA8tU = c4FrIb;
        this.f7663AzWtSf = arrayList;
        this.f7664B25kr6 = b2KMhB;
        this.f7665B2KMhB = b2KMhB2;
        this.f7666B3GDIM = z;
        this.f7667B4ZgIw = arrayList2;
        this.f7668B7CMnp = transition;
        this.f7669B9tovu = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QkAq4X.A4TApA a4TApA = this.f7660AcNBzu;
        C4FrIb c4FrIb = this.f7662AmA8tU;
        TransitionSet transitionSet = this.f7661AlLFFp;
        AMqCpz.AzWtSf(a4TApA, transitionSet, c4FrIb);
        ArrayList arrayList = this.f7663AzWtSf;
        if (this.f7666B3GDIM) {
            this.f7665B2KMhB.getClass();
        } else {
            this.f7664B25kr6.getClass();
        }
        if (transitionSet != null) {
            ArrayList arrayList2 = this.f7667B4ZgIw;
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList);
            AMqCpz.AlLFFp(transitionSet, arrayList2, arrayList);
            AaHO0E aaHO0E = c4FrIb.f7672A5SV6n;
        }
    }
}
