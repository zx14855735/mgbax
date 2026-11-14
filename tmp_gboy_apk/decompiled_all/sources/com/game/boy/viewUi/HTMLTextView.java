package com.game.boy.viewUi;

import Mm8v1u.AaHO0E;
import Mm8v1u.AcNBzu;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HTMLTextView extends AppCompatTextView {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final Pattern f11183B4ZgIw = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", 32);

    static {
        TMRsCq();
    }

    public HTMLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private static /* synthetic */ void TMRsCq() {
        char[] charArray = "óÿý¾÷ñýõ¾òÿé¾ãøõüü¾ÚþùÒâùô÷õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 144);
        }
        String str = new String(charArray);
        char[] charArray2 = "óüùþùä".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 144);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getText() instanceof Spanned) {
            setText(getText());
        }
    }

    public void setHTMLText(String str) {
        if (str == null || !f11183B4ZgIw.matcher(str).find()) {
            setText(str);
        } else {
            setText(Html.fromHtml(str, new AaHO0E(this), new AcNBzu(this)));
        }
    }
}
