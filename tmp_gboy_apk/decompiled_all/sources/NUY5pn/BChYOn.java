package NUY5pn;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BChYOn implements DialogInterface.OnClickListener {
    public abstract void A2egSU();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            A2egSU();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }
}
