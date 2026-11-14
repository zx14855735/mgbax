package D07BeM;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.AmA8tU;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends androidx.emoji2.text.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f1927A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final WeakReference f1928A4TApA;

    public ADYaiT(TextView textView, AMqCpz aMqCpz) {
        this.f1927A2egSU = new WeakReference(textView);
        this.f1928A4TApA = new WeakReference(aMqCpz);
    }

    @Override // androidx.emoji2.text.AaHO0E
    public final void A4TApA() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f1927A2egSU.get();
        InputFilter inputFilter = (InputFilter) this.f1928A4TApA.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    AmA8tU A2egSU2 = AmA8tU.A2egSU();
                    if (text == null) {
                        length = 0;
                    } else {
                        A2egSU2.getClass();
                        length = text.length();
                    }
                    CharSequence AMqCpz = A2egSU2.AMqCpz(text, 0, length);
                    if (text == AMqCpz) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(AMqCpz);
                    int selectionEnd = Selection.getSelectionEnd(AMqCpz);
                    textView.setText(AMqCpz);
                    if (AMqCpz instanceof Spannable) {
                        Spannable spannable = (Spannable) AMqCpz;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
