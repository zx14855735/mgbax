package MS6BTZ;

import android.content.Intent;
import androidx.preference.Preference;
import com.skydoves.colorpickerview.ColorPickerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z implements DRlcZ9.AmA8tU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5166AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f5167AlLFFp;

    public /* synthetic */ ARc23Z(AZOQYO azoqyo, int i) {
        this.f5166AcNBzu = i;
        this.f5167AlLFFp = azoqyo;
    }

    @Override // DRlcZ9.AmA8tU
    public final boolean AaHO0E(Preference preference) {
        switch (this.f5166AcNBzu) {
            case 0:
                AZOQYO azoqyo = this.f5167AlLFFp;
                azoqyo.f5174BI9f7h = azoqyo.f5173BChYOn;
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
                azoqyo.f5171B7CMnp.A2egSU(intent);
                break;
            default:
                AZOQYO azoqyo2 = this.f5167AlLFFp;
                Mm8v1u.A4TApA a4TApA = new Mm8v1u.A4TApA(azoqyo2.requireActivity());
                a4TApA.f81AcNBzu.AMqCpz = "游戏背景色";
                ColorPickerView colorPickerView = a4TApA.f5459B2KMhB;
                if (colorPickerView != null) {
                    colorPickerView.setPreferenceName("game");
                }
                ColorPickerView colorPickerView2 = a4TApA.f5459B2KMhB;
                if (colorPickerView2 != null) {
                    colorPickerView2.setInitialColor(-15108398);
                }
                a4TApA.B7CMnp(azoqyo2.getString(2131886723), new AYUAbz(azoqyo2, 0));
                a4TApA.B3GDIM(azoqyo2.getString(2131886161), new ASJ6gh(0));
                a4TApA.B4ZgIw(new DRlcZ9.ASJ6gh(5, azoqyo2));
                a4TApA.f5460B3GDIM = true;
                a4TApA.f5461B4ZgIw = true;
                a4TApA.f5462B7CMnp = (int) ((12 * a4TApA.getContext().getResources().getDisplayMetrics().density) + 0.5f);
                a4TApA.AMqCpz();
                break;
        }
        return true;
    }
}
