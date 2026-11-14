package OpB85q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends FrameLayout implements AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final TextView f6784AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f6785AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6786AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AZkASS.B25kr6 f6787AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ColorStateList f6788B25kr6;

    public AlLFFp(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2131493205, (ViewGroup) this, true);
        this.f6784AcNBzu = (TextView) findViewById(2131297699);
    }

    @Override // AZkASS.BPw6Q8
    public final void A2egSU(AZkASS.B25kr6 b25kr6) {
        this.f6787AzWtSf = b25kr6;
        b25kr6.setCheckable(false);
        this.f6784AcNBzu.setText(b25kr6.f524B25kr6);
        A4TApA();
    }

    public final void A4TApA() {
        AZkASS.B25kr6 b25kr6 = this.f6787AzWtSf;
        if (b25kr6 != null) {
            setVisibility((!b25kr6.isVisible() || (!this.f6785AlLFFp && this.f6786AmA8tU)) ? 8 : 0);
        }
    }

    @Override // AZkASS.BPw6Q8
    public AZkASS.B25kr6 getItemData() {
        return this.f6787AzWtSf;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
    }

    @Override // OpB85q.AZOQYO
    public void setExpanded(boolean z) {
        this.f6785AlLFFp = z;
        A4TApA();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // OpB85q.AZOQYO
    public void setOnlyShowWhenExpanded(boolean z) {
        this.f6786AmA8tU = z;
        A4TApA();
    }

    public void setTextAppearance(int i) {
        TextView textView = this.f6784AcNBzu;
        JrXYwF.A4TApA.DRlcZ9(textView, i);
        ColorStateList colorStateList = this.f6788B25kr6;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f6788B25kr6 = colorStateList;
        if (colorStateList != null) {
            this.f6784AcNBzu.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
    }
}
