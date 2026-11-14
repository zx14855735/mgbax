package LLcl8r;

import ADYaiT.AZOQYO;
import ADYaiT.AmA8tU;
import KpHwm4.B25kr6;
import android.content.Context;
import android.content.DialogInterface;
import com.game.boy.activity.EmulatorActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends OOnEhG.A4TApA implements DialogInterface.OnClickListener {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f4647B25kr6 = 0;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final EmulatorActivity f4648B2KMhB;

    public A2egSU(Context context) {
        super(context);
        EmulatorActivity emulatorActivity = (EmulatorActivity) context;
        this.f4648B2KMhB = emulatorActivity;
        B2KMhB(2131886706);
        AYUAbz();
        B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
        AZOQYO((b25kr6 == null || !b25kr6.f4354ARc23Z) ? 2131886215 : 2131886465);
        AmA8tU(2131886706, this);
        AaHO0E(2131886161, null);
    }

    private final void B3GDIM(DialogInterface dialogInterface, int i) {
    }

    @Override // ADYaiT.AlLFFp
    public AmA8tU AMqCpz() {
        switch (this.f4647B25kr6) {
            case 1:
                this.f4648B2KMhB.C2rE4F();
                break;
        }
        return super.AMqCpz();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f4647B25kr6) {
            case 0:
                this.f4648B2KMhB.BmvVmW();
                break;
        }
    }

    public A2egSU(EmulatorActivity emulatorActivity) {
        super(emulatorActivity);
        this.f4648B2KMhB = emulatorActivity;
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.AMqCpz = "温馨提示";
        azoqyo.f28ASJ6gh = emulatorActivity.getString(2131886472);
        AaHO0E(2131886161, this);
    }

    public A2egSU(EmulatorActivity emulatorActivity, String str) {
        super(emulatorActivity);
        this.f4648B2KMhB = emulatorActivity;
        AZOQYO azoqyo = this.f81AcNBzu;
        azoqyo.AMqCpz = "温馨提示";
        azoqyo.f28ASJ6gh = str;
        AaHO0E(2131886161, this);
    }
}
