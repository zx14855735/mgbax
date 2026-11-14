package D07BeM;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends InputConnectionWrapper {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final EditText f1925A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A4TApA f1926A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5SV6n(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        A4TApA a4TApA = new A4TApA();
        this.f1925A2egSU = editText;
        this.f1926A4TApA = a4TApA;
        if (AmA8tU.f8658AaHO0E != null) {
            AmA8tU A2egSU2 = AmA8tU.A2egSU();
            if (A2egSU2.A4TApA() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.AYUAbz aYUAbz = A2egSU2.AMqCpz;
            aYUAbz.getClass();
            Bundle bundle = editorInfo.extras;
            CtxOCS.A4TApA a4TApA2 = (CtxOCS.A4TApA) aYUAbz.f8653A5SV6n.f363AcNBzu;
            int A2egSU3 = a4TApA2.A2egSU(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", A2egSU3 != 0 ? a4TApA2.f1918A4TApA.getInt(A2egSU3 + a4TApA2.f1917A2egSU) : 0);
            Bundle bundle2 = editorInfo.extras;
            aYUAbz.f8651A2egSU.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.f1925A2egSU.getEditableText();
        this.f1926A4TApA.getClass();
        return A4TApA.A2egSU(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.f1925A2egSU.getEditableText();
        this.f1926A4TApA.getClass();
        return A4TApA.A2egSU(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
