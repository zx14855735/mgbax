package PWr3nF;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends PCV8se.AaHO0E {

    /* renamed from: CqNSpT, reason: collision with root package name */
    public static final /* synthetic */ int f7305CqNSpT = 0;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public ARc23Z f7306CmUvjW;

    @Override // PCV8se.AaHO0E
    public final void ASJ6gh(Canvas canvas) {
        if (this.f7306CmUvjW.f7304B4ZgIw.isEmpty()) {
            super.ASJ6gh(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f7306CmUvjW.f7304B4ZgIw);
        } else {
            canvas.clipRect(this.f7306CmUvjW.f7304B4ZgIw, Region.Op.DIFFERENCE);
        }
        super.ASJ6gh(canvas);
        canvas.restore();
    }

    public final void BmvVmW(float f, float f2, float f3, float f4) {
        RectF rectF = this.f7306CmUvjW.f7304B4ZgIw;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f7306CmUvjW = new ARc23Z(this.f7306CmUvjW);
        return this;
    }
}
