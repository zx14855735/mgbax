package LLcl8r;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;
import com.game.boy.activity.B7CMnp;
import com.game.boy.activity.EmulatorActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends OOnEhG.A4TApA implements DialogInterface.OnClickListener {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static Editable f4668B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static Editable f4669B4ZgIw;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f4670B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public EmulatorActivity f4671B2KMhB;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog = (Dialog) dialogInterface;
        f4668B3GDIM = ((EditText) dialog.findViewById(2131296742)).getText();
        f4669B4ZgIw = ((EditText) dialog.findViewById(2131297764)).getText();
        EmulatorActivity emulatorActivity = this.f4671B2KMhB;
        if (this.f4670B25kr6.equals(emulatorActivity.getString(2131887042))) {
            emulatorActivity.AZOQYO(emulatorActivity.getText(2131887042), emulatorActivity.getText(2131886185), new B7CMnp(emulatorActivity, f4668B3GDIM.toString(), 2)).show();
        }
    }
}
