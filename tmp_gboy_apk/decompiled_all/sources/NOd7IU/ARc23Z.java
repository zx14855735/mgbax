package NOd7IU;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z extends QgOIY0.AmA8tU {

    /* renamed from: DUi7mC, reason: collision with root package name */
    public AlertDialog f5866DUi7mC = null;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public GoogleApiActivity f5867DV2E8K = null;

    @Override // QgOIY0.AmA8tU
    public final Dialog B3GDIM() {
        AlertDialog alertDialog = this.f5866DUi7mC;
        if (alertDialog == null) {
            this.f7538D8MqeW = false;
        }
        return alertDialog;
    }

    @Override // QgOIY0.AmA8tU, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        GoogleApiActivity googleApiActivity = this.f5867DV2E8K;
        if (googleApiActivity != null) {
            googleApiActivity.onCancel(dialogInterface);
        }
    }
}
