package PWr3nF;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB extends View.AccessibilityDelegate {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B3GDIM f7357A2egSU;

    public B2KMhB(B3GDIM b3gdim) {
        this.f7357A2egSU = b3gdim;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        EditText editText = this.f7357A2egSU.f7364AYUAbz.getEditText();
        if (editText != null) {
            accessibilityNodeInfo.setLabeledBy(editText);
        }
    }
}
