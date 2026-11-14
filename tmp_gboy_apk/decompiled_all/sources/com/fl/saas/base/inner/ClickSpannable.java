package com.fl.saas.base.inner;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.fl.saas.common.util.feature.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ClickSpannable {
    private Supplier<Boolean> nextCondition;
    private final SpannableStringBuilder spannable = new SpannableStringBuilder();
    private String separator = " ";
    private int genericColor = -1;

    private void addSeparator() {
        if (this.spannable.length() <= 0 || this.spannable.toString().endsWith(this.separator)) {
            return;
        }
        this.spannable.append((CharSequence) this.separator);
    }

    public SpannableStringBuilder build() {
        return this.spannable;
    }

    public ClickSpannable nextCondition(Supplier<Boolean> supplier) {
        this.nextCondition = supplier;
        return this;
    }

    public ClickSpannable setGenericColor(int i) {
        this.genericColor = i;
        return this;
    }

    public ClickSpannable setSeparator(String str) {
        this.separator = str;
        return this;
    }

    public ClickSpannable setText(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                addSeparator();
                for (String str : strArr) {
                    this.spannable.append((CharSequence) str);
                }
            } else {
                if (TextUtils.isEmpty(strArr[i])) {
                    break;
                }
                i++;
            }
        }
        return this;
    }

    public ClickSpannable setTextClick(String str, Runnable runnable) {
        return setTextClick(str, false, runnable);
    }

    public ClickSpannable setTextClick(String str, final boolean z, final Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            Supplier<Boolean> supplier = this.nextCondition;
            this.nextCondition = null;
            if (supplier == null || supplier.get() == Boolean.TRUE) {
                addSeparator();
                int length = this.spannable.length();
                this.spannable.append((CharSequence) str);
                int length2 = this.spannable.length();
                if (runnable != null) {
                    this.spannable.setSpan(new ClickableSpan() { // from class: com.fl.saas.base.inner.ClickSpannable.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            runnable.run();
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            if (z) {
                                return;
                            }
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(ClickSpannable.this.genericColor);
                        }
                    }, length, length2, 33);
                }
            }
        }
        return this;
    }
}
