package NOd7IU;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA extends DialogFragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AlertDialog f5857AcNBzu = null;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public GoogleApiActivity f5858AlLFFp = null;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        GoogleApiActivity googleApiActivity = this.f5858AlLFFp;
        if (googleApiActivity != null) {
            googleApiActivity.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        if (this.f5857AcNBzu == null) {
            setShowsDialog(false);
        }
        return this.f5857AcNBzu;
    }
}
