package ADYaiT;

import android.app.Dialog;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CrfGsy extends androidx.fragment.app.B4ZgIw {
    @Override // androidx.fragment.app.B4ZgIw
    public Dialog onCreateDialog(Bundle bundle) {
        return new CqNSpT(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.B4ZgIw
    public final void setupDialog(Dialog dialog, int i) {
        if (!(dialog instanceof CqNSpT)) {
            super.setupDialog(dialog, i);
            return;
        }
        CqNSpT cqNSpT = (CqNSpT) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        cqNSpT.A5SV6n().ARc23Z(1);
    }
}
