package D07BeM;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements InputFilter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextView f1929A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ADYaiT f1930A4TApA;

    public AMqCpz(TextView textView) {
        this.f1929A2egSU = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.f1929A2egSU;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int A4TApA2 = AmA8tU.A2egSU().A4TApA();
        if (A4TApA2 != 0) {
            if (A4TApA2 == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return AmA8tU.A2egSU().AMqCpz(charSequence, 0, charSequence.length());
            }
            if (A4TApA2 != 3) {
                return charSequence;
            }
        }
        AmA8tU A2egSU2 = AmA8tU.A2egSU();
        if (this.f1930A4TApA == null) {
            this.f1930A4TApA = new ADYaiT(textView, this);
        }
        A2egSU2.ARc23Z(this.f1930A4TApA);
        return charSequence;
    }
}
