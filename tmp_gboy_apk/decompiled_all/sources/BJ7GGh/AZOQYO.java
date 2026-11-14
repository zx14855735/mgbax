package BJ7GGh;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f1421AcNBzu;

    public AZOQYO(Context context) {
        super(context);
        this.f1421AcNBzu = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.f1421AcNBzu = z;
    }

    public void setGuidelineBegin(int i) {
        ADYaiT aDYaiT = (ADYaiT) getLayoutParams();
        if (this.f1421AcNBzu && aDYaiT.f1343A2egSU == i) {
            return;
        }
        aDYaiT.f1343A2egSU = i;
        setLayoutParams(aDYaiT);
    }

    public void setGuidelineEnd(int i) {
        ADYaiT aDYaiT = (ADYaiT) getLayoutParams();
        if (this.f1421AcNBzu && aDYaiT.f1344A4TApA == i) {
            return;
        }
        aDYaiT.f1344A4TApA = i;
        setLayoutParams(aDYaiT);
    }

    public void setGuidelinePercent(float f) {
        ADYaiT aDYaiT = (ADYaiT) getLayoutParams();
        if (this.f1421AcNBzu && aDYaiT.f1345A5SV6n == f) {
            return;
        }
        aDYaiT.f1345A5SV6n = f;
        setLayoutParams(aDYaiT);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
