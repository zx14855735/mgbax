package Oay4Bh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BI9f7h implements AZkASS.BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public NavigationMenuView f6546AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LinearLayout f6547AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AZkASS.AmA8tU f6548AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f6549AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AzWtSf f6550B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public LayoutInflater f6551B2KMhB;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ColorStateList f6553B4ZgIw;

    /* renamed from: BChYOn, reason: collision with root package name */
    public ColorStateList f6556BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f6557BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public Drawable f6558BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public RippleDrawable f6559BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f6560BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f6561BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f6562BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f6563BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f6564BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f6565BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f6566C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f6567C4FrIb;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public int f6569CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f6570COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public int f6571CQhlFr;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6552B3GDIM = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f6554B7CMnp = 0;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f6555B9tovu = true;

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f6568CASmeH = true;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f6572CSDoyG = -1;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final ADYaiT.A5SV6n f6573CTkVKb = new ADYaiT.A5SV6n(15, this);

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        AzWtSf azWtSf = this.f6550B25kr6;
        if (azWtSf != null) {
            azWtSf.update();
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
        AZkASS.B25kr6 b25kr6;
        View actionView;
        BJ7GGh bJ7GGh;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f6546AcNBzu.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                AzWtSf azWtSf = this.f6550B25kr6;
                azWtSf.getClass();
                int i = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = azWtSf.f6537AcNBzu;
                if (i != 0) {
                    azWtSf.f6539AmA8tU = true;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        B2KMhB b2KMhB = (B2KMhB) arrayList.get(i2);
                        if (b2KMhB instanceof B4ZgIw) {
                            AZkASS.B25kr6 b25kr62 = ((B4ZgIw) b2KMhB).f6543A2egSU;
                            if (b25kr62.f520AcNBzu == i) {
                                azWtSf.A4TApA(b25kr62);
                                break;
                            }
                        }
                        i2++;
                    }
                    azWtSf.f6539AmA8tU = false;
                    azWtSf.A2egSU();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        B2KMhB b2KMhB2 = (B2KMhB) arrayList.get(i3);
                        if ((b2KMhB2 instanceof B4ZgIw) && (actionView = (b25kr6 = ((B4ZgIw) b2KMhB2).f6543A2egSU).getActionView()) != null && (bJ7GGh = (BJ7GGh) sparseParcelableArray2.get(b25kr6.f520AcNBzu)) != null) {
                            actionView.restoreHierarchyState(bJ7GGh);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f6547AlLFFp.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    public final void AMqCpz() {
        AzWtSf azWtSf = this.f6550B25kr6;
        if (azWtSf == null) {
            return;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = azWtSf.f6537AcNBzu;
            if (i >= arrayList.size()) {
                return;
            }
            if (arrayList.get(i) instanceof B3GDIM) {
                azWtSf.notifyItemChanged(i);
            }
            i++;
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(AZkASS.BpkvW3 bpkvW3) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ASJ6gh(AZkASS.B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        Bundle bundle = new Bundle();
        if (this.f6546AcNBzu != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f6546AcNBzu.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        AzWtSf azWtSf = this.f6550B25kr6;
        if (azWtSf != null) {
            azWtSf.getClass();
            Bundle bundle2 = new Bundle();
            AZkASS.B25kr6 b25kr6 = azWtSf.f6538AlLFFp;
            if (b25kr6 != null) {
                bundle2.putInt("android:menu:checked", b25kr6.f520AcNBzu);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = azWtSf.f6537AcNBzu;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                B2KMhB b2KMhB = (B2KMhB) arrayList.get(i);
                if (b2KMhB instanceof B4ZgIw) {
                    AZkASS.B25kr6 b25kr62 = ((B4ZgIw) b2KMhB).f6543A2egSU;
                    View actionView = b25kr62 != null ? b25kr62.getActionView() : null;
                    if (actionView != null) {
                        BJ7GGh bJ7GGh = new BJ7GGh();
                        actionView.saveHierarchyState(bJ7GGh);
                        sparseArray2.put(b25kr62.f520AcNBzu, bJ7GGh);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f6547AlLFFp != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f6547AlLFFp.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // AZkASS.BNL6CD
    public final boolean AZOQYO(AZkASS.B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AZkASS.AmA8tU amA8tU) {
        this.f6551B2KMhB = LayoutInflater.from(context);
        this.f6548AmA8tU = amA8tU;
        this.f6571CQhlFr = context.getResources().getDimensionPixelOffset(2131165316);
    }

    public final void AcNBzu() {
        AzWtSf azWtSf = this.f6550B25kr6;
        if (azWtSf == null) {
            return;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = azWtSf.f6537AcNBzu;
            if (i >= arrayList.size()) {
                return;
            }
            if ((arrayList.get(i) instanceof B4ZgIw) && azWtSf.getItemViewType(i) == 1) {
                azWtSf.notifyItemChanged(i);
            }
            i++;
        }
    }

    public final void AlLFFp() {
        AzWtSf azWtSf = this.f6550B25kr6;
        if (azWtSf == null) {
            return;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = azWtSf.f6537AcNBzu;
            if (i >= arrayList.size()) {
                return;
            }
            if ((arrayList.get(i) instanceof B4ZgIw) && azWtSf.getItemViewType(i) == 0) {
                azWtSf.notifyItemChanged(i);
            }
            i++;
        }
    }

    @Override // AZkASS.BNL6CD
    public final int getId() {
        return this.f6549AzWtSf;
    }
}
