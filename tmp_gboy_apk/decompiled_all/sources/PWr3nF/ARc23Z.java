package PWr3nF;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends PCV8se.AZOQYO {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final RectF f7304B4ZgIw;

    public ARc23Z(PCV8se.B2KMhB b2KMhB, RectF rectF) {
        super(b2KMhB);
        this.f7304B4ZgIw = rectF;
    }

    @Override // PCV8se.AZOQYO, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        ASJ6gh aSJ6gh = new ASJ6gh(this);
        aSJ6gh.f7306CmUvjW = this;
        aSJ6gh.invalidateSelf();
        return aSJ6gh;
    }

    public ARc23Z(ARc23Z aRc23Z) {
        super(aRc23Z);
        this.f7304B4ZgIw = aRc23Z.f7304B4ZgIw;
    }
}
