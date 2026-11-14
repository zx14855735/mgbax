package androidx.viewpager2.adapter;

import android.view.ViewParent;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AmA8tU;
import androidx.lifecycle.B4ZgIw;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public A5SV6n f9548A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ADYaiT f9549A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public B4ZgIw f9550A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ViewPager2 f9551ADYaiT;
    public long AMqCpz = -1;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f9552ARc23Z;

    public AMqCpz(AYUAbz aYUAbz) {
        this.f9552ARc23Z = aYUAbz;
    }

    public static ViewPager2 A2egSU(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    public final void A4TApA(boolean z) {
        int currentItem;
        Fragment fragment;
        AYUAbz aYUAbz = this.f9552ARc23Z;
        CtxOCS ctxOCS = aYUAbz.f9555AlLFFp;
        if (!ctxOCS.CQhlFr() && this.f9551ADYaiT.getScrollState() == 0) {
            B25kr6.AYUAbz aYUAbz2 = aYUAbz.f9556AmA8tU;
            if (aYUAbz2.AZkASS() != 0 && (currentItem = this.f9551ADYaiT.getCurrentItem()) < 2) {
                long j = currentItem;
                if ((j != this.AMqCpz || z) && (fragment = (Fragment) aYUAbz2.ADYaiT(j)) != null && fragment.isAdded()) {
                    this.AMqCpz = j;
                    ctxOCS.getClass();
                    androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(ctxOCS);
                    ArrayList arrayList = new ArrayList();
                    Fragment fragment2 = null;
                    for (int i = 0; i < aYUAbz2.AZkASS(); i++) {
                        long ASJ6gh2 = aYUAbz2.ASJ6gh(i);
                        Fragment fragment3 = (Fragment) aYUAbz2.AaHO0E(i);
                        if (fragment3.isAdded()) {
                            if (ASJ6gh2 != this.AMqCpz) {
                                a2egSU.B4ZgIw(fragment3, AmA8tU.f8980AzWtSf);
                                arrayList.add(aYUAbz.f9560B3GDIM.AmA8tU());
                            } else {
                                fragment2 = fragment3;
                            }
                            fragment3.setMenuVisibility(ASJ6gh2 == this.AMqCpz);
                        }
                    }
                    if (fragment2 != null) {
                        a2egSU.B4ZgIw(fragment2, AmA8tU.f8981B25kr6);
                        arrayList.add(aYUAbz.f9560B3GDIM.AmA8tU());
                    }
                    if (a2egSU.f8917A2egSU.isEmpty()) {
                        return;
                    }
                    a2egSU.AMqCpz();
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        List list = (List) it.next();
                        aYUAbz.f9560B3GDIM.getClass();
                        IQ76hF.AmA8tU.AzWtSf(list);
                    }
                }
            }
        }
    }
}
