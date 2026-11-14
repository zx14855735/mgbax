package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f9180AcNBzu;

    public ASJ6gh(RecyclerView.A2egSU... a2egSUArr) {
        ArrayList arrayList;
        int size;
        List asList = Arrays.asList(a2egSUArr);
        this.f9180AcNBzu = new AYUAbz(this);
        Iterator it = asList.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                super.setHasStableIds(this.f9180AcNBzu.f9186ASJ6gh != 1);
                return;
            }
            RecyclerView.A2egSU a2egSU = (RecyclerView.A2egSU) it.next();
            AYUAbz aYUAbz = this.f9180AcNBzu;
            arrayList = aYUAbz.AMqCpz;
            size = arrayList.size();
            if (size < 0 || size > arrayList.size()) {
                break;
            }
            if (aYUAbz.f9186ASJ6gh != 1) {
                JrXYwF.A4TApA.B2KMhB(a2egSU.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
            } else {
                a2egSU.hasStableIds();
            }
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    i = -1;
                    break;
                } else if (((CQhlFr) arrayList.get(i)).f9322A5SV6n == a2egSU) {
                    break;
                } else {
                    i++;
                }
            }
            if ((i == -1 ? null : (CQhlFr) arrayList.get(i)) == null) {
                CQhlFr cQhlFr = new CQhlFr(a2egSU, aYUAbz, aYUAbz.f9182A4TApA, aYUAbz.f9187AYUAbz.f9379A2egSU);
                arrayList.add(size, cQhlFr);
                Iterator it2 = aYUAbz.f9183A5SV6n.iterator();
                while (it2.hasNext()) {
                    RecyclerView recyclerView = (RecyclerView) ((WeakReference) it2.next()).get();
                    if (recyclerView != null) {
                        a2egSU.onAttachedToRecyclerView(recyclerView);
                    }
                }
                if (cQhlFr.AMqCpz > 0) {
                    aYUAbz.f9181A2egSU.notifyItemRangeInserted(aYUAbz.A4TApA(cQhlFr), cQhlFr.AMqCpz);
                }
                aYUAbz.A2egSU();
            }
        }
        throw new IndexOutOfBoundsException("Index must be between 0 and " + arrayList.size() + ". Given:" + size);
    }

    public final void A2egSU(CtxOCS ctxOCS) {
        super.setStateRestorationPolicy(ctxOCS);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int findRelativeAdapterPositionIn(RecyclerView.A2egSU a2egSU, Dphsd2 dphsd2, int i) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        CQhlFr cQhlFr = (CQhlFr) aYUAbz.f9184ADYaiT.get(dphsd2);
        if (cQhlFr == null) {
            return -1;
        }
        int A4TApA2 = i - aYUAbz.A4TApA(cQhlFr);
        RecyclerView.A2egSU a2egSU2 = cQhlFr.f9322A5SV6n;
        int itemCount = a2egSU2.getItemCount();
        if (A4TApA2 >= 0 && A4TApA2 < itemCount) {
            return a2egSU2.findRelativeAdapterPositionIn(a2egSU, dphsd2, A4TApA2);
        }
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(A4TApA2, itemCount, "Detected inconsistent adapter updates. The local position of the view holder maps to ", " which is out of bounds for the adapter with size ", ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        B7CMnp2.append(dphsd2);
        B7CMnp2.append("adapter:");
        B7CMnp2.append(a2egSU);
        throw new IllegalStateException(B7CMnp2.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        Iterator it = this.f9180AcNBzu.AMqCpz.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((CQhlFr) it.next()).AMqCpz;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        AaHO0E.A2egSU A5SV6n2 = aYUAbz.A5SV6n(i);
        CQhlFr cQhlFr = (CQhlFr) A5SV6n2.f595A5SV6n;
        cQhlFr.f9322A5SV6n.getItemId(A5SV6n2.f593A2egSU);
        cQhlFr.f9321A4TApA.getClass();
        A5SV6n2.f594A4TApA = false;
        A5SV6n2.f595A5SV6n = null;
        A5SV6n2.f593A2egSU = -1;
        aYUAbz.f9185ARc23Z = A5SV6n2;
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        AaHO0E.A2egSU A5SV6n2 = aYUAbz.A5SV6n(i);
        CQhlFr cQhlFr = (CQhlFr) A5SV6n2.f595A5SV6n;
        int A4TApA2 = cQhlFr.f9320A2egSU.A4TApA(cQhlFr.f9322A5SV6n.getItemViewType(A5SV6n2.f593A2egSU));
        A5SV6n2.f594A4TApA = false;
        A5SV6n2.f595A5SV6n = null;
        A5SV6n2.f593A2egSU = -1;
        aYUAbz.f9185ARc23Z = A5SV6n2;
        return A4TApA2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        ArrayList arrayList = aYUAbz.f9183A5SV6n;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == recyclerView) {
                return;
            }
        }
        arrayList.add(new WeakReference(recyclerView));
        Iterator it2 = aYUAbz.AMqCpz.iterator();
        while (it2.hasNext()) {
            ((CQhlFr) it2.next()).f9322A5SV6n.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        AaHO0E.A2egSU A5SV6n2 = aYUAbz.A5SV6n(i);
        aYUAbz.f9184ADYaiT.put(dphsd2, (CQhlFr) A5SV6n2.f595A5SV6n);
        CQhlFr cQhlFr = (CQhlFr) A5SV6n2.f595A5SV6n;
        cQhlFr.f9322A5SV6n.bindViewHolder(dphsd2, A5SV6n2.f593A2egSU);
        A5SV6n2.f594A4TApA = false;
        A5SV6n2.f595A5SV6n = null;
        A5SV6n2.f593A2egSU = -1;
        aYUAbz.f9185ARc23Z = A5SV6n2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        CQhlFr cQhlFr = (CQhlFr) this.f9180AcNBzu.f9182A4TApA.f9412A2egSU.get(i);
        if (cQhlFr == null) {
            throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "Cannot find the wrapper for global view type "));
        }
        return cQhlFr.f9322A5SV6n.onCreateViewHolder(viewGroup, cQhlFr.f9320A2egSU.A2egSU(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        ArrayList arrayList = aYUAbz.f9183A5SV6n;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) arrayList.get(size);
            if (weakReference.get() == null) {
                arrayList.remove(size);
            } else if (weakReference.get() == recyclerView) {
                arrayList.remove(size);
                break;
            }
            size--;
        }
        Iterator it = aYUAbz.AMqCpz.iterator();
        while (it.hasNext()) {
            ((CQhlFr) it.next()).f9322A5SV6n.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final boolean onFailedToRecycleView(Dphsd2 dphsd2) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        IdentityHashMap identityHashMap = aYUAbz.f9184ADYaiT;
        CQhlFr cQhlFr = (CQhlFr) identityHashMap.get(dphsd2);
        if (cQhlFr != null) {
            boolean onFailedToRecycleView = cQhlFr.f9322A5SV6n.onFailedToRecycleView(dphsd2);
            identityHashMap.remove(dphsd2);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + dphsd2 + ", seems like it is not bound by this adapter: " + aYUAbz);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewAttachedToWindow(Dphsd2 dphsd2) {
        this.f9180AcNBzu.ADYaiT(dphsd2).f9322A5SV6n.onViewAttachedToWindow(dphsd2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewDetachedFromWindow(Dphsd2 dphsd2) {
        this.f9180AcNBzu.ADYaiT(dphsd2).f9322A5SV6n.onViewDetachedFromWindow(dphsd2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        AYUAbz aYUAbz = this.f9180AcNBzu;
        IdentityHashMap identityHashMap = aYUAbz.f9184ADYaiT;
        CQhlFr cQhlFr = (CQhlFr) identityHashMap.get(dphsd2);
        if (cQhlFr != null) {
            cQhlFr.f9322A5SV6n.onViewRecycled(dphsd2);
            identityHashMap.remove(dphsd2);
        } else {
            throw new IllegalStateException("Cannot find wrapper for " + dphsd2 + ", seems like it is not bound by this adapter: " + aYUAbz);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void setStateRestorationPolicy(CtxOCS ctxOCS) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }
}
