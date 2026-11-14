package K7mCWO;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.skydoves.colorpickerview.ColorPickerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static A4TApA f4180A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public SharedPreferences f4181A2egSU;

    public static A4TApA A2egSU(Context context) {
        if (f4180A4TApA == null) {
            A4TApA a4TApA = new A4TApA();
            a4TApA.f4181A2egSU = context.getSharedPreferences(context.getPackageName(), 0);
            f4180A4TApA = a4TApA;
        }
        return f4180A4TApA;
    }

    public void A4TApA(ColorPickerView colorPickerView) {
        if (colorPickerView == null || colorPickerView.getPreferenceName() == null) {
            return;
        }
        String preferenceName = colorPickerView.getPreferenceName();
        int color = colorPickerView.getColor();
        SharedPreferences sharedPreferences = this.f4181A2egSU;
        sharedPreferences.edit().putInt(preferenceName + "_COLOR", color).apply();
        Point selectedPoint = colorPickerView.getSelectedPoint();
        sharedPreferences.edit().putInt(CtFAbx.AcNBzu(preferenceName, "_SELECTOR_X"), selectedPoint.x).apply();
        sharedPreferences.edit().putInt(CtFAbx.AcNBzu(preferenceName, "_SELECTOR_Y"), selectedPoint.y).apply();
        if (colorPickerView.getAlphaSlideBar() != null) {
            int selectedX = colorPickerView.getAlphaSlideBar().getSelectedX();
            sharedPreferences.edit().putInt(preferenceName + "_SLIDER_ALPHA", selectedX).apply();
        }
        if (colorPickerView.getBrightnessSlider() != null) {
            int selectedX2 = colorPickerView.getBrightnessSlider().getSelectedX();
            sharedPreferences.edit().putInt(preferenceName + "_SLIDER_BRIGHTNESS", selectedX2).apply();
        }
    }

    public String A5SV6n() {
        String hf = ((JrXYwF.AMqCpz) JrXYwF.A5SV6n.f4151A5SV6n.f240AmA8tU).hf();
        return (TextUtils.isEmpty(hf) || Constants.FAIL.equals(hf)) ? this.f4181A2egSU.getString("device_id", Constants.FAIL) : hf;
    }
}
