package AaHO0E;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends AppCompatImageView implements B25kr6 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AzWtSf f608AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcNBzu(AzWtSf azWtSf, Context context) {
        super(context, null, 2130968610);
        this.f608AcNBzu = azWtSf;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        JrXYwF.A4TApA.DV2E8K(this, getContentDescription());
        setOnTouchListener(new AaHO0E(this, this));
    }

    @Override // AaHO0E.B25kr6
    public final boolean A4TApA() {
        return false;
    }

    @Override // AaHO0E.B25kr6
    public final boolean A5SV6n() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f608AcNBzu.AmA8tU();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            BmvVmW.A2egSU.ARc23Z(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
