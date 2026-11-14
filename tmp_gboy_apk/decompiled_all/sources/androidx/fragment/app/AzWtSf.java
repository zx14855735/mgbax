package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8757AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f8758AlLFFp;

    public /* synthetic */ AzWtSf(int i, Object obj) {
        this.f8757AcNBzu = i;
        this.f8758AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DialogInterface.OnDismissListener onDismissListener;
        Dialog dialog;
        switch (this.f8757AcNBzu) {
            case 0:
                B4ZgIw b4ZgIw = (B4ZgIw) this.f8758AlLFFp;
                onDismissListener = b4ZgIw.mOnDismissListener;
                dialog = b4ZgIw.mDialog;
                onDismissListener.onDismiss(dialog);
                break;
            case 1:
                ((AmA8tU) this.f8758AlLFFp).ADYaiT();
                break;
            default:
                ((CtxOCS) this.f8758AlLFFp).BIYEnU(true);
                break;
        }
    }
}
