package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements DialogInterface.OnCancelListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f8759AcNBzu;

    public B25kr6(B4ZgIw b4ZgIw) {
        this.f8759AcNBzu = b4ZgIw;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        B4ZgIw b4ZgIw = this.f8759AcNBzu;
        dialog = b4ZgIw.mDialog;
        if (dialog != null) {
            dialog2 = b4ZgIw.mDialog;
            b4ZgIw.onCancel(dialog2);
        }
    }
}
