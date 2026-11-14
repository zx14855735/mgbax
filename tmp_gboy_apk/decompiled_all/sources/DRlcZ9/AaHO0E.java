package DRlcZ9;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E extends B2KMhB {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final HashSet f2087B7CMnp = new HashSet();

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f2088B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CharSequence[] f2089BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public CharSequence[] f2090BI9f7h;

    @Override // DRlcZ9.B2KMhB
    public final void AmA8tU(boolean z) {
        if (z && this.f2088B9tovu) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) AcNBzu();
            HashSet hashSet = this.f2087B7CMnp;
            if (multiSelectListPreference.A2egSU(hashSet)) {
                multiSelectListPreference.BmvVmW(hashSet);
            }
        }
        this.f2088B9tovu = false;
    }

    @Override // DRlcZ9.B2KMhB
    public final void AzWtSf(ADYaiT.AlLFFp alLFFp) {
        int length = this.f2090BI9f7h.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.f2087B7CMnp.contains(this.f2090BI9f7h[i].toString());
        }
        alLFFp.A4TApA(this.f2089BChYOn, zArr, new AZkASS(0, this));
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        HashSet hashSet = this.f2087B7CMnp;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f2088B9tovu = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f2089BChYOn = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f2090BI9f7h = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) AcNBzu();
        if (multiSelectListPreference.f9074DRlcZ9 == null || (charSequenceArr = multiSelectListPreference.f9075DUi7mC) == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.f9076DV2E8K);
        this.f2088B9tovu = false;
        this.f2089BChYOn = multiSelectListPreference.f9074DRlcZ9;
        this.f2090BI9f7h = charSequenceArr;
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f2087B7CMnp));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f2088B9tovu);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f2089BChYOn);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f2090BI9f7h);
    }
}
