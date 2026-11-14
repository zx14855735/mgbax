package ARc23Z;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu extends AYUAbz {

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public AaHO0E f348BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f349BNL6CD;

    public AcNBzu() {
        this(null, null);
    }

    @Override // ARc23Z.AYUAbz
    public void AMqCpz(AaHO0E aaHO0E) {
        super.AMqCpz(aaHO0E);
        this.f348BJ7GGh = aaHO0E;
    }

    @Override // ARc23Z.AYUAbz
    /* renamed from: ARc23Z, reason: merged with bridge method [inline-methods] */
    public AaHO0E A4TApA() {
        return new AaHO0E(this.f348BJ7GGh, this, null);
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f349BNL6CD) {
            super.mutate();
            this.f348BJ7GGh.ARc23Z();
            this.f349BNL6CD = true;
        }
        return this;
    }

    @Override // ARc23Z.AYUAbz, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int AMqCpz = this.f348BJ7GGh.AMqCpz(iArr);
        if (AMqCpz < 0) {
            AMqCpz = this.f348BJ7GGh.AMqCpz(StateSet.WILD_CARD);
        }
        return ADYaiT(AMqCpz) || onStateChange;
    }

    public AcNBzu(AaHO0E aaHO0E, Resources resources) {
        AMqCpz(new AaHO0E(aaHO0E, this, resources));
        onStateChange(getState());
    }
}
