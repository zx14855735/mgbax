package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D07BeM extends Observable {
    public final boolean A2egSU() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void A4TApA() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    public final void A5SV6n(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
        }
    }

    public final void ADYaiT(int i, int i2, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }

    public final void AMqCpz(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    public final void ARc23Z(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }

    public final void ASJ6gh() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.A4TApA) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
        }
    }
}
