package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB implements DialogInterface.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f8760AcNBzu;

    public B2KMhB(B4ZgIw b4ZgIw) {
        this.f8760AcNBzu = b4ZgIw;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        B4ZgIw b4ZgIw = this.f8760AcNBzu;
        dialog = b4ZgIw.mDialog;
        if (dialog != null) {
            dialog2 = b4ZgIw.mDialog;
            b4ZgIw.onDismiss(dialog2);
        }
    }
}
