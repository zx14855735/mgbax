package HH6JFw;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends ViewOutlineProvider {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f3353A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f3354A4TApA;

    public AMqCpz(float f, int i) {
        this.f3353A2egSU = f;
        this.f3354A4TApA = i;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect(0, 0, rect.right - rect.left, rect.bottom - rect.top);
        float f = this.f3353A2egSU;
        int i = this.f3354A4TApA;
        if (i == 1) {
            outline.setRoundRect(rect2, f);
            return;
        }
        try {
            if (i == 2) {
                Path path = new Path();
                path.moveTo(rect2.left, rect2.top + f);
                float f2 = rect2.left;
                float f3 = rect2.top;
                path.quadTo(f2, f3, f2 + f, f3);
                path.lineTo(rect2.right - f, rect2.top);
                float f4 = rect2.right;
                float f5 = rect2.top;
                path.quadTo(f4, f5, f4, f + f5);
                path.lineTo(rect2.right, rect2.bottom);
                path.lineTo(rect2.left, rect2.bottom);
                path.close();
                outline.setConvexPath(path);
                return;
            }
            if (i != 3) {
                return;
            }
            Path path2 = new Path();
            path2.moveTo(rect2.left, rect2.top + f);
            float f6 = rect2.left;
            float f7 = rect2.top;
            path2.quadTo(f6, f7, f6 + f, f7);
            path2.lineTo(rect2.right, rect2.top);
            path2.lineTo(rect2.right, rect2.bottom);
            path2.lineTo(rect2.left + f, rect2.bottom);
            float f8 = rect2.left;
            float f9 = rect2.bottom;
            path2.quadTo(f8, f9, f8, f9 - f);
            path2.close();
            outline.setConvexPath(path2);
        } catch (Exception unused) {
        }
    }
}
