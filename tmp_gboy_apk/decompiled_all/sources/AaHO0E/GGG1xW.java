package AaHO0E;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class GGG1xW extends androidx.emoji2.text.AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f870A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final WeakReference f871A4TApA;

    public GGG1xW(EditText editText) {
        this.f871A4TApA = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.AaHO0E
    public void A2egSU() {
        switch (this.f870A2egSU) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f871A4TApA.get();
                if (switchCompat != null) {
                    switchCompat.A5SV6n();
                    break;
                }
                break;
        }
    }

    @Override // androidx.emoji2.text.AaHO0E
    public final void A4TApA() {
        switch (this.f870A2egSU) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f871A4TApA.get();
                if (switchCompat != null) {
                    switchCompat.A5SV6n();
                    break;
                }
                break;
            default:
                D07BeM.AZkASS.A2egSU((EditText) this.f871A4TApA.get(), 1);
                break;
        }
    }

    public GGG1xW(SwitchCompat switchCompat) {
        this.f871A4TApA = new WeakReference(switchCompat);
    }
}
