package OOnEhG;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Dialog f6434AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f6435AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f6436AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f6437AzWtSf;

    public A2egSU(Dialog dialog, Rect rect) {
        this.f6434AcNBzu = dialog;
        this.f6435AlLFFp = rect.left;
        this.f6436AmA8tU = rect.top;
        this.f6437AzWtSf = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = findViewById.getLeft() + this.f6435AlLFFp;
        int width = findViewById.getWidth() + left;
        if (new RectF(left, findViewById.getTop() + this.f6436AmA8tU, width, findViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.f6437AzWtSf;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.f6434AcNBzu.onTouchEvent(obtain);
    }
}
