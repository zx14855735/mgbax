package LQ734U;

import android.content.SharedPreferences;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import com.game.boy.activity.KeyMappingSettings;
import com.game.boy.activity.KeyProfilesActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends A2egSU implements View.OnKeyListener {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SurfaceView f4825AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final SparseIntArray f4826AzWtSf = new SparseIntArray(32);

    public A4TApA(SurfaceView surfaceView) {
        this.f4825AmA8tU = surfaceView;
        surfaceView.setOnKeyListener(this);
        KeyMappingSettings.f11040B4ZgIw = true;
    }

    @Override // LQ734U.A2egSU
    public final void A4TApA(SharedPreferences sharedPreferences) {
        if (KeyMappingSettings.f11040B4ZgIw) {
            int i = KeyProfilesActivity.f11051B4ZgIw;
            int[] AZkASS2 = KeyMappingSettings.AZkASS(KeyMappingSettings.AYUAbz(sharedPreferences.getString("keyProfile", "Default")));
            int[] iArr = KeyMappingSettings.f11041B7CMnp;
            SparseIntArray sparseIntArray = this.f4826AzWtSf;
            sparseIntArray.clear();
            for (int i2 = 0; i2 < 31; i2++) {
                int i3 = AZkASS2[i2];
                if (i3 != 0) {
                    sparseIntArray.put(AZkASS2[i2], sparseIntArray.get(i3) | iArr[i2]);
                }
            }
            KeyMappingSettings.f11040B4ZgIw = false;
        }
    }

    @Override // LQ734U.A2egSU
    public final void A5SV6n() {
        this.f4824AlLFFp = null;
        this.f4825AmA8tU.setOnKeyListener(null);
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        int i2 = this.f4826AzWtSf.get(i);
        if (i2 == 0) {
            return i == 82;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        int action = keyEvent.getAction();
        if (action == 0) {
            this.f4823AcNBzu = i2 | this.f4823AcNBzu;
            this.f4824AlLFFp.A2egSU();
            return true;
        }
        if (action != 1) {
            return true;
        }
        this.f4823AcNBzu = (~i2) & this.f4823AcNBzu;
        this.f4824AlLFFp.A2egSU();
        return true;
    }
}
