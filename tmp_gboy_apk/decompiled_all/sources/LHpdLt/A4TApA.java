package LHpdLt;

import com.game.boy.MyApp;
import com.game.boy.viewUi.QuoteTextInputLayout;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends LLYwnm.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ String f4453A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4454A4TApA;

    public A4TApA(AZOQYO azoqyo, String str) {
        this.f4454A4TApA = azoqyo;
        this.f4453A2egSU = str;
    }

    @Override // LLYwnm.B25kr6
    public final void A2egSU(String str) {
        MyApp.A2egSU(str);
    }

    @Override // LLYwnm.B25kr6
    public final void A4TApA(Map map) {
    }

    @Override // LLYwnm.B25kr6
    public final void A5SV6n(String str) {
        MyApp.A2egSU(str);
    }

    @Override // LLYwnm.B25kr6
    public final void ADYaiT() {
        AZOQYO azoqyo = this.f4454A4TApA;
        BV3sI0 bV3sI0 = new BV3sI0(azoqyo.f4505COJEAR.B25kr6("user_name"), this.f4453A2egSU, azoqyo.f4505COJEAR.B25kr6("user_avatar"), true);
        if (azoqyo.f4496BPw6Q8 == 0) {
            azoqyo.ARc23Z(azoqyo.f4494BJ7GGh, bV3sI0, null, false);
        } else {
            azoqyo.ARc23Z(azoqyo.f4495BNL6CD, bV3sI0, null, true);
        }
        QuoteTextInputLayout quoteTextInputLayout = azoqyo.f4485B25kr6;
        TextInputEditText editText = quoteTextInputLayout.getEditText();
        if (editText != null) {
            editText.setText("");
        }
        quoteTextInputLayout.f11193FG7pZc = null;
        quoteTextInputLayout.setHint(quoteTextInputLayout.f11194FM663C);
        quoteTextInputLayout.setEndIconVisible(false);
    }
}
