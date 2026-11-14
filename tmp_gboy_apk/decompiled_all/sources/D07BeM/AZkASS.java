package D07BeM;

import AaHO0E.GGG1xW;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements TextWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final EditText f1937AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public GGG1xW f1938AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f1939AmA8tU = true;

    public AZkASS(EditText editText) {
        this.f1937AcNBzu = editText;
    }

    public static void A2egSU(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            AmA8tU A2egSU2 = AmA8tU.A2egSU();
            if (editableText == null) {
                length = 0;
            } else {
                A2egSU2.getClass();
                length = editableText.length();
            }
            A2egSU2.AMqCpz(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.f1937AcNBzu;
        if (editText.isInEditMode() || !this.f1939AmA8tU || AmA8tU.f8658AaHO0E == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int A4TApA2 = AmA8tU.A2egSU().A4TApA();
        if (A4TApA2 != 0) {
            if (A4TApA2 == 1) {
                AmA8tU.A2egSU().AMqCpz((Spannable) charSequence, i, i3 + i);
                return;
            } else if (A4TApA2 != 3) {
                return;
            }
        }
        AmA8tU A2egSU2 = AmA8tU.A2egSU();
        if (this.f1938AlLFFp == null) {
            this.f1938AlLFFp = new GGG1xW(editText);
        }
        A2egSU2.ARc23Z(this.f1938AlLFFp);
    }
}
