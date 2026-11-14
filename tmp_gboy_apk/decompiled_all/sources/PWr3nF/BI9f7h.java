package PWr3nF;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final TextInputLayout f7403ADYaiT;

    public BI9f7h(TextInputLayout textInputLayout) {
        this.f7403ADYaiT = textInputLayout;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f7403ADYaiT;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean isEmpty = TextUtils.isEmpty(text);
        boolean isEmpty2 = TextUtils.isEmpty(hint);
        boolean z = textInputLayout.f11973EiK8oA;
        boolean isEmpty3 = TextUtils.isEmpty(error);
        boolean z2 = (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String charSequence = !isEmpty2 ? hint.toString() : "";
        B9tovu b9tovu = textInputLayout.f11908AlLFFp;
        AppCompatTextView appCompatTextView = b9tovu.f7391AlLFFp;
        if (appCompatTextView.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            }
        } else if (Build.VERSION.SDK_INT >= 22) {
            accessibilityNodeInfo.setTraversalAfter(b9tovu.f7393AzWtSf);
        }
        if (!isEmpty) {
            aYUAbz.AmA8tU(text);
        } else if (!TextUtils.isEmpty(charSequence)) {
            aYUAbz.AmA8tU(charSequence);
            if (!z && placeholderText != null) {
                aYUAbz.AmA8tU(charSequence + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            aYUAbz.AmA8tU(placeholderText);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                if (!isEmpty) {
                    charSequence = ((Object) text) + ", " + charSequence;
                }
                aYUAbz.AmA8tU(charSequence);
            } else if (i >= 26) {
                accessibilityNodeInfo.setHintText(charSequence);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
            }
            if (i >= 26) {
                accessibilityNodeInfo.setShowingHintText(isEmpty);
            } else {
                aYUAbz.AZOQYO(4, isEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z2) {
            if (isEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        AppCompatTextView appCompatTextView2 = textInputLayout.f11917BChYOn.f7381BJ7GGh;
        if (appCompatTextView2 != null) {
            accessibilityNodeInfo.setLabelFor(appCompatTextView2);
        }
        textInputLayout.f11909AmA8tU.A4TApA().AmA8tU(aYUAbz);
    }

    @Override // COJEAR.A4TApA
    public final void AMqCpz(View view, AccessibilityEvent accessibilityEvent) {
        super.AMqCpz(view, accessibilityEvent);
        this.f7403ADYaiT.f11909AmA8tU.A4TApA().AzWtSf(accessibilityEvent);
    }
}
