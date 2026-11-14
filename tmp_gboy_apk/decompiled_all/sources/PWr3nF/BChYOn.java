package PWr3nF;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn implements TextWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7400AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EditText f7401AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f7402AmA8tU;

    public BChYOn(TextInputLayout textInputLayout, EditText editText) {
        this.f7402AmA8tU = textInputLayout;
        this.f7401AlLFFp = editText;
        this.f7400AcNBzu = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f7402AmA8tU;
        textInputLayout.BI9f7h(!textInputLayout.f11979ExjC7D, false);
        if (textInputLayout.f11918BI9f7h) {
            textInputLayout.B25kr6(editable);
        }
        if (textInputLayout.f11926BniPrB) {
            textInputLayout.BIYEnU(editable);
        }
        EditText editText = this.f7401AlLFFp;
        int lineCount = editText.getLineCount();
        int i = this.f7400AcNBzu;
        if (lineCount != i) {
            if (lineCount < i) {
                int minimumHeight = editText.getMinimumHeight();
                int i2 = textInputLayout.f11972EdhSi6;
                if (minimumHeight != i2) {
                    editText.setMinimumHeight(i2);
                }
            }
            this.f7400AcNBzu = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
