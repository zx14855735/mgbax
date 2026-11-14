package OLvDpK;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f6334AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f6335AlLFFp;

    public AZkASS(ChipGroup chipGroup) {
        this.f6335AlLFFp = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f6335AlLFFp;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                view2.setId(View.generateViewId());
            }
            Chip chip = (Chip) view2;
            Oay4Bh.A2egSU a2egSU = chipGroup.f11570B4ZgIw;
            a2egSU.f6452A2egSU.put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                a2egSU.A2egSU(chip);
            }
            chip.setInternalOnCheckedChangeListener(new NGepWW.A2egSU(6, a2egSU));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f6334AcNBzu;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f6335AlLFFp;
        if (view == chipGroup && (view2 instanceof Chip)) {
            Chip chip = (Chip) view2;
            Oay4Bh.A2egSU a2egSU = chipGroup.f11570B4ZgIw;
            a2egSU.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            a2egSU.f6452A2egSU.remove(Integer.valueOf(chip.getId()));
            a2egSU.f6453A4TApA.remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f6334AcNBzu;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
