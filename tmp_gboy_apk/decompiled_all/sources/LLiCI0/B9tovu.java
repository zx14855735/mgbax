package LLiCI0;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends InsetDrawable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4724AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B9tovu(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i, 0, i2, 0);
        this.f4724AcNBzu = i3;
    }

    @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        int intrinsicHeight = getIntrinsicHeight();
        int i = this.f4724AcNBzu;
        return intrinsicHeight + i + i;
    }
}
