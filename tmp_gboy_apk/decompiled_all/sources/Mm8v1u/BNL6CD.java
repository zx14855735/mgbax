package Mm8v1u;

import android.view.KeyEvent;
import android.widget.TextView;
import com.game.boy.viewUi.QuoteTextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD implements TextView.OnEditorActionListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ QuoteTextInputLayout f5520A2egSU;

    public BNL6CD(QuoteTextInputLayout quoteTextInputLayout) {
        this.f5520A2egSU = quoteTextInputLayout;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        QuoteTextInputLayout quoteTextInputLayout = this.f5520A2egSU;
        if (i == 4) {
            BPw6Q8 bPw6Q8 = quoteTextInputLayout.f11192F508T2;
            if (bPw6Q8 != null) {
                LHpdLt.AZOQYO.A5SV6n((LHpdLt.AZOQYO) ((IQ76hF.AmA8tU) bPw6Q8).f3956AlLFFp);
                return true;
            }
        } else {
            if (i != 0 || keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
                return false;
            }
            BPw6Q8 bPw6Q82 = quoteTextInputLayout.f11192F508T2;
            if (bPw6Q82 != null) {
                LHpdLt.AZOQYO.A5SV6n((LHpdLt.AZOQYO) ((IQ76hF.AmA8tU) bPw6Q82).f3956AlLFFp);
            }
        }
        return true;
    }
}
