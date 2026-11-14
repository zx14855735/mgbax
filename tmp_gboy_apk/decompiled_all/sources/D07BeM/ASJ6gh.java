package D07BeM;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.B4ZgIw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements KeyListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final KeyListener f1931A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ARc23Z f1932A4TApA;

    public ASJ6gh(KeyListener keyListener) {
        ARc23Z aRc23Z = new ARc23Z();
        this.f1931A2egSU = keyListener;
        this.f1932A4TApA = aRc23Z;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.f1931A2egSU.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f1931A2egSU.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        this.f1932A4TApA.getClass();
        return B4ZgIw.A2egSU(editable, i, keyEvent) || this.f1931A2egSU.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f1931A2egSU.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f1931A2egSU.onKeyUp(view, editable, i, keyEvent);
    }
}
