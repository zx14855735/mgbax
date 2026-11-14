package OpB85q;

import AZkASS.BNL6CD;
import AZkASS.BpkvW3;
import DaOi9o.BJ7GGh;
import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AcNBzu implements BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AZkASS f6781AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f6782AlLFFp = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f6783AmA8tU;

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        AYUAbz aYUAbz;
        int i;
        DaOi9o.A2egSU a2egSU;
        if (this.f6782AlLFFp) {
            return;
        }
        if (z) {
            this.f6781AcNBzu.A2egSU();
            return;
        }
        AZkASS aZkASS = this.f6781AcNBzu;
        AYUAbz aYUAbz2 = aZkASS.f6769D07BeM;
        if (aYUAbz2 == null || aZkASS.f6738B3GDIM == null) {
            return;
        }
        aZkASS.f6768CtxOCS.f6782AlLFFp = true;
        aYUAbz2.A4TApA();
        aZkASS.f6768CtxOCS.f6782AlLFFp = false;
        if (aZkASS.f6738B3GDIM != null && (aYUAbz = aZkASS.f6769D07BeM) != null && aYUAbz.f6727A4TApA.size() == aZkASS.f6738B3GDIM.length) {
            while (i < aZkASS.f6738B3GDIM.length) {
                if (!(aZkASS.f6769D07BeM.A2egSU(i) instanceof A2egSU) || (aZkASS.f6738B3GDIM[i] instanceof A5SV6n)) {
                    i = ((aZkASS.f6769D07BeM.A2egSU(i) instanceof A2egSU) || !((aZkASS.f6769D07BeM.A2egSU(i).hasSubMenu() && !(aZkASS.f6738B3GDIM[i] instanceof AlLFFp)) || (!aZkASS.f6769D07BeM.A2egSU(i).hasSubMenu() && !(aZkASS.f6738B3GDIM[i] instanceof ARc23Z)))) ? i + 1 : 0;
                }
            }
            int i2 = aZkASS.f6739B4ZgIw;
            int size = aZkASS.f6769D07BeM.f6727A4TApA.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem A2egSU2 = aZkASS.f6769D07BeM.A2egSU(i3);
                if (A2egSU2.isChecked()) {
                    aZkASS.setCheckedItem(A2egSU2);
                    aZkASS.f6739B4ZgIw = A2egSU2.getItemId();
                    aZkASS.f6740B7CMnp = i3;
                }
            }
            if (i2 != aZkASS.f6739B4ZgIw && (a2egSU = aZkASS.f6732AcNBzu) != null) {
                BJ7GGh.A2egSU(aZkASS, a2egSU);
            }
            boolean ASJ6gh2 = AZkASS.ASJ6gh(aZkASS.f6736B25kr6, aZkASS.getCurrentVisibleContentItemCount());
            for (int i4 = 0; i4 < size; i4++) {
                aZkASS.f6768CtxOCS.f6782AlLFFp = true;
                aZkASS.f6738B3GDIM[i4].setExpanded(aZkASS.f6774D9tr6l);
                AZOQYO azoqyo = aZkASS.f6738B3GDIM[i4];
                if (azoqyo instanceof ARc23Z) {
                    ARc23Z aRc23Z = (ARc23Z) azoqyo;
                    aRc23Z.setLabelVisibilityMode(aZkASS.f6736B25kr6);
                    aRc23Z.setItemIconGravity(aZkASS.f6737B2KMhB);
                    aRc23Z.setItemGravity(aZkASS.f6764CmUvjW);
                    aRc23Z.setShifting(ASJ6gh2);
                }
                if (aZkASS.f6769D07BeM.A2egSU(i4) instanceof AZkASS.B25kr6) {
                    aZkASS.f6738B3GDIM[i4].A2egSU((AZkASS.B25kr6) aZkASS.f6769D07BeM.A2egSU(i4));
                }
                aZkASS.f6768CtxOCS.f6782AlLFFp = false;
            }
            return;
        }
        aZkASS.A2egSU();
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof AaHO0E) {
            AZkASS aZkASS = this.f6781AcNBzu;
            AaHO0E aaHO0E = (AaHO0E) parcelable;
            int i = aaHO0E.f6779AcNBzu;
            int size = aZkASS.f6769D07BeM.f6727A4TApA.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem A2egSU2 = aZkASS.f6769D07BeM.A2egSU(i2);
                if (i == A2egSU2.getItemId()) {
                    aZkASS.f6739B4ZgIw = i;
                    aZkASS.f6740B7CMnp = i2;
                    aZkASS.setCheckedItem(A2egSU2);
                    break;
                }
                i2++;
            }
            Context context = this.f6781AcNBzu.getContext();
            Oay4Bh.BJ7GGh bJ7GGh = aaHO0E.f6780AlLFFp;
            SparseArray sparseArray2 = new SparseArray(bJ7GGh.size());
            for (int i3 = 0; i3 < bJ7GGh.size(); i3++) {
                int keyAt = bJ7GGh.keyAt(i3);
                NpX2pY.A4TApA a4TApA = (NpX2pY.A4TApA) bJ7GGh.valueAt(i3);
                sparseArray2.put(keyAt, a4TApA != null ? new NpX2pY.A2egSU(context, a4TApA) : null);
            }
            AZkASS aZkASS2 = this.f6781AcNBzu;
            aZkASS2.getClass();
            int i4 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = aZkASS2.f6752C2rE4F;
                if (i4 >= size2) {
                    break;
                }
                int keyAt2 = sparseArray2.keyAt(i4);
                if (sparseArray.indexOfKey(keyAt2) < 0) {
                    sparseArray.append(keyAt2, (NpX2pY.A2egSU) sparseArray2.get(keyAt2));
                }
                i4++;
            }
            AZOQYO[] azoqyoArr = aZkASS2.f6738B3GDIM;
            if (azoqyoArr != null) {
                for (AZOQYO azoqyo : azoqyoArr) {
                    if (azoqyo instanceof ARc23Z) {
                        ARc23Z aRc23Z = (ARc23Z) azoqyo;
                        NpX2pY.A2egSU a2egSU = (NpX2pY.A2egSU) sparseArray.get(aRc23Z.getId());
                        if (a2egSU != null) {
                            aRc23Z.setBadge(a2egSU);
                        }
                    }
                }
            }
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(BpkvW3 bpkvW3) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ASJ6gh(AZkASS.B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        AaHO0E aaHO0E = new AaHO0E();
        aaHO0E.f6779AcNBzu = this.f6781AcNBzu.getSelectedItemId();
        SparseArray<NpX2pY.A2egSU> badgeDrawables = this.f6781AcNBzu.getBadgeDrawables();
        Oay4Bh.BJ7GGh bJ7GGh = new Oay4Bh.BJ7GGh();
        for (int i = 0; i < badgeDrawables.size(); i++) {
            int keyAt = badgeDrawables.keyAt(i);
            NpX2pY.A2egSU valueAt = badgeDrawables.valueAt(i);
            bJ7GGh.put(keyAt, valueAt != null ? valueAt.f6076B25kr6.f6115A2egSU : null);
        }
        aaHO0E.f6780AlLFFp = bJ7GGh;
        return aaHO0E;
    }

    @Override // AZkASS.BNL6CD
    public final boolean AZOQYO(AZkASS.B25kr6 b25kr6) {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AZkASS.AmA8tU amA8tU) {
        this.f6781AcNBzu.A5SV6n(amA8tU);
    }

    @Override // AZkASS.BNL6CD
    public final int getId() {
        return this.f6783AmA8tU;
    }
}
