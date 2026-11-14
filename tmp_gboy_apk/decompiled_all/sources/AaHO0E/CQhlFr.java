package AaHO0E;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CQhlFr extends SeekBar {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CSDoyG f687AcNBzu;

    public CQhlFr(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969826);
        GIi2tl.A2egSU(getContext(), this);
        CSDoyG cSDoyG = new CSDoyG(this);
        this.f687AcNBzu = cSDoyG;
        cSDoyG.A4TApA(attributeSet, 2130969826);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        CSDoyG cSDoyG = this.f687AcNBzu;
        Drawable drawable = cSDoyG.f688ARc23Z;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        CQhlFr cQhlFr = cSDoyG.AMqCpz;
        if (drawable.setState(cQhlFr.getDrawableState())) {
            cQhlFr.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f687AcNBzu.f688ARc23Z;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f687AcNBzu.ASJ6gh(canvas);
    }
}
