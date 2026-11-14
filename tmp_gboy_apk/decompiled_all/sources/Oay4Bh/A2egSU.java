package Oay4Bh;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f6452A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashSet f6453A4TApA = new HashSet();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public NGepWW.A2egSU f6454A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f6455ADYaiT;
    public boolean AMqCpz;

    public final boolean A2egSU(AZkASS aZkASS) {
        int id = aZkASS.getId();
        HashSet hashSet = this.f6453A4TApA;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        AZkASS aZkASS2 = (AZkASS) this.f6452A2egSU.get(Integer.valueOf(A5SV6n()));
        if (aZkASS2 != null) {
            AMqCpz(aZkASS2, false);
        }
        boolean add = hashSet.add(Integer.valueOf(id));
        if (!aZkASS.isChecked()) {
            aZkASS.setChecked(true);
        }
        return add;
    }

    public final ArrayList A4TApA(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.f6453A4TApA);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof AZkASS) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int A5SV6n() {
        if (!this.f6455ADYaiT) {
            return -1;
        }
        HashSet hashSet = this.f6453A4TApA;
        if (hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public final void ADYaiT() {
        NGepWW.A2egSU a2egSU = this.f6454A5SV6n;
        if (a2egSU != null) {
            new HashSet(this.f6453A4TApA);
            ChipGroup chipGroup = (ChipGroup) a2egSU.f5658AlLFFp;
            OLvDpK.AZOQYO azoqyo = chipGroup.f11569B3GDIM;
            if (azoqyo != null) {
                chipGroup.f11570B4ZgIw.A4TApA(chipGroup);
                ChipGroup chipGroup2 = (ChipGroup) ((IQ76hF.AmA8tU) azoqyo).f3956AlLFFp;
                if (chipGroup2.f11570B4ZgIw.f6455ADYaiT) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public final boolean AMqCpz(AZkASS aZkASS, boolean z) {
        int id = aZkASS.getId();
        HashSet hashSet = this.f6453A4TApA;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            aZkASS.setChecked(true);
            return false;
        }
        boolean remove = hashSet.remove(Integer.valueOf(id));
        if (aZkASS.isChecked()) {
            aZkASS.setChecked(false);
        }
        return remove;
    }
}
