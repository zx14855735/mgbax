package AaHO0E;

import android.view.View;
import android.widget.AdapterView;
import androidx.preference.DropDownPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EsrwYR implements AdapterView.OnItemSelectedListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f809AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f810AlLFFp;

    public /* synthetic */ EsrwYR(int i, Object obj) {
        this.f809AcNBzu = i;
        this.f810AlLFFp = obj;
    }

    private final void A2egSU(AdapterView adapterView) {
    }

    private final void A4TApA(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        EdQ5bb edQ5bb;
        switch (this.f809AcNBzu) {
            case 0:
                if (i != -1 && (edQ5bb = ((FM663C) this.f810AlLFFp).f823AmA8tU) != null) {
                    edQ5bb.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                if (i >= 0) {
                    DropDownPreference dropDownPreference = (DropDownPreference) this.f810AlLFFp;
                    String charSequence = dropDownPreference.f9071DUi7mC[i].toString();
                    if (!charSequence.equals(dropDownPreference.f9072DV2E8K) && dropDownPreference.A2egSU(charSequence)) {
                        dropDownPreference.BpkvW3(charSequence);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.f809AcNBzu;
    }
}
