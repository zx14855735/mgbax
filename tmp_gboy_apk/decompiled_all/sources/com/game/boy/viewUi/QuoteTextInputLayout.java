package com.game.boy.viewUi;

import ADYaiT.A5SV6n;
import ADYaiT.CtFAbx;
import DRlcZ9.BniPrB;
import Mm8v1u.BNL6CD;
import Mm8v1u.BPw6Q8;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class QuoteTextInputLayout extends TextInputLayout {

    /* renamed from: F508T2, reason: collision with root package name */
    public BPw6Q8 f11192F508T2;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public String f11193FG7pZc;

    /* renamed from: FM663C, reason: collision with root package name */
    public final String f11194FM663C;

    public QuoteTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11194FM663C = "输入消息...";
        setHint("输入消息...");
        setEndIconMode(-1);
        setEndIconDrawable(AlLFFp.CQhlFr(getContext(), 2131230983));
        setEndIconTintList(ColorStateList.valueOf(Color.parseColor("#8E8E8E")));
        setEndIconOnClickListener(new A5SV6n(13, this));
        setEndIconVisible(false);
    }

    public String getQuoteMark() {
        return this.f11193FG7pZc;
    }

    public String getSendContent() {
        TextInputEditText editText = getEditText();
        String trim = (editText == null || editText.getText() == null) ? "" : editText.getText().toString().trim();
        return !TextUtils.isEmpty(this.f11193FG7pZc) ? TextUtils.isEmpty(trim) ? this.f11193FG7pZc : CtFAbx.B25kr6(new StringBuilder(), this.f11193FG7pZc, trim) : trim;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        TextInputEditText editText = getEditText();
        if (editText == null) {
            return;
        }
        editText.setOnEditorActionListener(new BNL6CD(this));
        editText.setOnKeyListener(new BniPrB(1, this));
    }

    public void setOnSendListener(BPw6Q8 bPw6Q8) {
        this.f11192F508T2 = bPw6Q8;
    }

    public void setQuoteMessage(String str) {
        String AMqCpz;
        int indexOf;
        this.f11193FG7pZc = str;
        if (TextUtils.isEmpty(str)) {
            this.f11193FG7pZc = null;
            setHint(this.f11194FM663C);
            setEndIconVisible(false);
        } else {
            setHint((str.startsWith("【QUOTE||") && str.endsWith("】") && (indexOf = (AMqCpz = CtFAbx.AMqCpz(1, 8, str)).indexOf("||")) > 0) ? CtFAbx.AmA8tU("回复 @", AMqCpz.substring(0, indexOf), ": ", AMqCpz.substring(indexOf + 2)) : "回复");
            setEndIconVisible(true);
            TextInputEditText editText = getEditText();
            if (editText != null) {
                editText.requestFocus();
            }
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public TextInputEditText getEditText() {
        return (TextInputEditText) super.getEditText();
    }
}
