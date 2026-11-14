package DRlcZ9;

import ADYaiT.D8MqeW;
import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ADYaiT extends B2KMhB {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public EditText f2073B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CharSequence f2074B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final D8MqeW f2075BChYOn = new D8MqeW(8, this);

    /* renamed from: BI9f7h, reason: collision with root package name */
    public long f2076BI9f7h = -1;

    @Override // DRlcZ9.B2KMhB
    public final void AlLFFp(View view) {
        super.AlLFFp(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f2073B7CMnp = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f2073B7CMnp.setText(this.f2074B9tovu);
        EditText editText2 = this.f2073B7CMnp;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) AcNBzu()).getClass();
    }

    @Override // DRlcZ9.B2KMhB
    public final void AmA8tU(boolean z) {
        if (z) {
            String obj = this.f2073B7CMnp.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) AcNBzu();
            if (editTextPreference.A2egSU(obj)) {
                editTextPreference.BmvVmW(obj);
            }
        }
    }

    public final void B25kr6() {
        long j = this.f2076BI9f7h;
        if (j == -1 || j + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.f2073B7CMnp;
        if (editText == null || !editText.isFocused()) {
            this.f2076BI9f7h = -1L;
            return;
        }
        if (((InputMethodManager) this.f2073B7CMnp.getContext().getSystemService("input_method")).showSoftInput(this.f2073B7CMnp, 0)) {
            this.f2076BI9f7h = -1L;
            return;
        }
        EditText editText2 = this.f2073B7CMnp;
        D8MqeW d8MqeW = this.f2075BChYOn;
        editText2.removeCallbacks(d8MqeW);
        this.f2073B7CMnp.postDelayed(d8MqeW, 50L);
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f2074B9tovu = ((EditTextPreference) AcNBzu()).f9069DRlcZ9;
        } else {
            this.f2074B9tovu = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f2074B9tovu);
    }
}
