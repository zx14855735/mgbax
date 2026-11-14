package DRlcZ9;

import android.os.Bundle;
import androidx.preference.ListPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz extends B2KMhB {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f2081B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CharSequence[] f2082B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CharSequence[] f2083BChYOn;

    @Override // DRlcZ9.B2KMhB
    public final void AmA8tU(boolean z) {
        int i;
        if (!z || (i = this.f2081B7CMnp) < 0) {
            return;
        }
        String charSequence = this.f2083BChYOn[i].toString();
        ListPreference listPreference = (ListPreference) AcNBzu();
        if (listPreference.A2egSU(charSequence)) {
            listPreference.BpkvW3(charSequence);
        }
    }

    @Override // DRlcZ9.B2KMhB
    public final void AzWtSf(ADYaiT.AlLFFp alLFFp) {
        alLFFp.ADYaiT(this.f2082B9tovu, this.f2081B7CMnp, new ASJ6gh(0, this));
        alLFFp.A5SV6n(null, null);
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2081B7CMnp = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f2082B9tovu = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f2083BChYOn = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) AcNBzu();
        if (listPreference.f9070DRlcZ9 == null || (charSequenceArr = listPreference.f9071DUi7mC) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f2081B7CMnp = listPreference.BmvVmW(listPreference.f9072DV2E8K);
        this.f2082B9tovu = listPreference.f9070DRlcZ9;
        this.f2083BChYOn = charSequenceArr;
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f2081B7CMnp);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f2082B9tovu);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f2083BChYOn);
    }
}
