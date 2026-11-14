package OvgpEe;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.checkbox.MaterialCheckBox;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends DcUJf1.A5SV6n {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f6823A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ View f6824A5SV6n;

    public /* synthetic */ A5SV6n(View view, int i) {
        this.f6823A4TApA = i;
        this.f6824A5SV6n = view;
    }

    @Override // DcUJf1.A5SV6n
    public final void A2egSU(Drawable drawable) {
        switch (this.f6823A4TApA) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f6824A5SV6n;
                aDYaiT.setIndeterminate(false);
                aDYaiT.A2egSU(aDYaiT.f6826AlLFFp);
                break;
            case 1:
                ADYaiT aDYaiT2 = (ADYaiT) this.f6824A5SV6n;
                if (!aDYaiT2.f6830B2KMhB) {
                    aDYaiT2.setVisibility(aDYaiT2.f6831B3GDIM);
                    break;
                }
                break;
            default:
                ColorStateList colorStateList = ((MaterialCheckBox) this.f6824A5SV6n).f11537BNL6CD;
                if (colorStateList != null) {
                    drawable.setTintList(colorStateList);
                    break;
                }
                break;
        }
    }

    @Override // DcUJf1.A5SV6n
    public void A4TApA(Drawable drawable) {
        switch (this.f6823A4TApA) {
            case 2:
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) this.f6824A5SV6n;
                ColorStateList colorStateList = materialCheckBox.f11537BNL6CD;
                if (colorStateList != null) {
                    drawable.setTint(colorStateList.getColorForState(materialCheckBox.f11541BmvVmW, colorStateList.getDefaultColor()));
                    break;
                }
                break;
        }
    }
}
