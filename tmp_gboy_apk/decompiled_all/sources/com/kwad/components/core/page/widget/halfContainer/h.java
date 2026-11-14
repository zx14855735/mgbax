package com.kwad.components.core.page.widget.halfContainer;

import COJEAR.CQhlFr;
import COJEAR.DG07BK;
import CikNvS.AlLFFp;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h {
    private static final Interpolator Zh = new Interpolator() { // from class: com.kwad.components.core.page.widget.halfContainer.h.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private VelocityTracker WN;
    private boolean ZB;
    private final a Zi;
    private final ViewGroup Zj;
    private int Zk;
    private int Zl;
    private float[] Zm;
    private float[] Zn;
    private float[] Zo;
    private float[] Zp;
    private int[] Zq;
    private int[] Zr;
    private int[] Zs;
    private int Zt;
    private float Zu;
    private float Zv;
    private int Zw;
    private int Zx;
    private AlLFFp Zy;
    private View Zz;
    private int duration = 0;
    private int YD = -1;
    private final Runnable ZA = new Runnable() { // from class: com.kwad.components.core.page.widget.halfContainer.h.2
        @Override // java.lang.Runnable
        public final void run() {
            h.this.bh(0);
        }
    };

    public static abstract class a {
        public static int getOrderedChildIndex(int i) {
            return i;
        }

        public int D(View view) {
            return 0;
        }

        public void bb(int i) {
        }

        public int bc(int i) {
            return 0;
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public int th() {
            return 0;
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    static {
        hRibT();
    }

    private h(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.Zj = viewGroup;
        this.Zi = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.Zw = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.Zl = viewConfiguration.getScaledTouchSlop();
        this.Zu = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Zv = viewConfiguration.getScaledMinimumFlingVelocity();
        Interpolator interpolator = Zh;
        AlLFFp alLFFp = new AlLFFp();
        alLFFp.f1811A2egSU = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
        this.Zy = alLFFp;
    }

    public static h a(ViewGroup viewGroup, a aVar) {
        return new h(viewGroup.getContext(), viewGroup, aVar);
    }

    private int b(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int c = c(i3, (int) this.Zv, (int) this.Zu);
        int c2 = c(i4, (int) this.Zv, (int) this.Zu);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(c);
        int abs4 = Math.abs(c2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (c != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (c2 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((b(i2, c2, this.Zi.th()) * (f3 / f4)) + (b(i, c, 0) * f5));
    }

    private void bf(int i) {
        float[] fArr = this.Zm;
        if (fArr == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.Zn[i] = 0.0f;
        this.Zo[i] = 0.0f;
        this.Zp[i] = 0.0f;
        this.Zq[i] = 0;
        this.Zr[i] = 0;
        this.Zs[i] = 0;
        this.Zt = (~(1 << i)) & this.Zt;
    }

    private void bg(int i) {
        float[] fArr = this.Zm;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.Zn;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.Zo;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.Zp;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.Zq;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.Zr;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.Zs;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.Zm = fArr2;
            this.Zn = fArr3;
            this.Zo = fArr4;
            this.Zp = fArr5;
            this.Zq = iArr;
            this.Zr = iArr2;
            this.Zs = iArr3;
        }
    }

    private boolean bi(int i) {
        return isPointerDown(i);
    }

    private static int c(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void cancel() {
        this.YD = -1;
        tj();
        VelocityTracker velocityTracker = this.WN;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.WN = null;
        }
    }

    private void e(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.Zo[pointerId] = x;
            this.Zp[pointerId] = y;
        }
    }

    private View findTopChildUnder(int i, int i2) {
        for (int childCount = this.Zj.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Zj.getChildAt(a.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private static /* synthetic */ void hRibT() {
        char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 17);
        }
        String str = new String(charArray);
        char[] charArray2 = "r}x\u007fxe".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 17);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.Zz, i, i2);
    }

    private boolean isPointerDown(int i) {
        return ((1 << i) & this.Zt) != 0;
    }

    private static boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    private static float j(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    private boolean l(View view, int i) {
        if (view == this.Zz && this.YD == i) {
            return true;
        }
        if (view == null || !this.Zi.tryCaptureView(view, i)) {
            return false;
        }
        this.YD = i;
        captureChildView(view, i);
        return true;
    }

    private int o(int i, int i2) {
        int i3 = i < this.Zj.getLeft() + this.Zw ? 1 : 0;
        if (i2 < this.Zj.getTop() + this.Zw) {
            i3 |= 4;
        }
        if (i > this.Zj.getRight() - this.Zw) {
            i3 |= 2;
        }
        return i2 > this.Zj.getBottom() - this.Zw ? i3 | 8 : i3;
    }

    private void tj() {
        float[] fArr = this.Zm;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.Zn, 0.0f);
        Arrays.fill(this.Zo, 0.0f);
        Arrays.fill(this.Zp, 0.0f);
        Arrays.fill(this.Zq, 0);
        Arrays.fill(this.Zr, 0);
        Arrays.fill(this.Zs, 0);
        this.Zt = 0;
    }

    private void tk() {
        this.WN.computeCurrentVelocity(1000, this.Zu);
        VelocityTracker velocityTracker = this.WN;
        int i = this.YD;
        Map map = CQhlFr.f1662A2egSU;
        c(a(velocityTracker.getXVelocity(i), this.Zv, this.Zu), a(this.WN.getYVelocity(this.YD), this.Zv, this.Zu));
    }

    public final void bh(int i) {
        this.Zj.removeCallbacks(this.ZA);
        if (this.Zk != i) {
            this.Zk = i;
            this.Zi.onViewDragStateChanged(i);
            if (this.Zk == 0) {
                this.Zz = null;
            }
        }
    }

    public final void captureChildView(View view, int i) {
        if (view.getParent() == this.Zj) {
            this.Zz = view;
            this.YD = i;
            bh(1);
        } else {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Zj + ")");
        }
    }

    public final boolean continueSettling(boolean z) {
        if (this.Zk == 2) {
            boolean computeScrollOffset = this.Zy.f1811A2egSU.computeScrollOffset();
            int currX = this.Zy.f1811A2egSU.getCurrX();
            int currY = this.Zy.f1811A2egSU.getCurrY();
            int left = currX - this.Zz.getLeft();
            int top = currY - this.Zz.getTop();
            if (left != 0) {
                DG07BK.AcNBzu(left, this.Zz);
            }
            if (top != 0) {
                DG07BK.AlLFFp(top, this.Zz);
            }
            if (left != 0 || top != 0) {
                this.Zi.bb(currY);
            }
            if (computeScrollOffset && currX == this.Zy.f1811A2egSU.getFinalX() && currY == this.Zy.f1811A2egSU.getFinalY()) {
                this.Zy.f1811A2egSU.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.Zj.post(this.ZA);
            }
        }
        return this.Zk == 2;
    }

    public final int getTouchSlop() {
        return this.Zl;
    }

    public final void processTouchEvent(MotionEvent motionEvent) {
        float f;
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        this.WN.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            a(x, y, pointerId);
            l(findTopChildUnder, pointerId);
            int i3 = this.Zq[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.Zk == 1) {
                tk();
            }
            cancel();
            return;
        }
        float f2 = 0.0f;
        if (actionMasked == 2) {
            if (this.Zk == 1) {
                if (bi(this.YD)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.YD);
                    try {
                        f = motionEvent.getX(findPointerIndex);
                        try {
                            f2 = motionEvent.getY(findPointerIndex);
                        } catch (IllegalArgumentException unused) {
                        }
                    } catch (IllegalArgumentException unused2) {
                        f = 0.0f;
                    }
                    float[] fArr = this.Zo;
                    int i4 = this.YD;
                    int i5 = (int) (f - fArr[i4]);
                    int i6 = (int) (f2 - this.Zp[i4]);
                    b(this.Zz.getLeft() + i5, this.Zz.getTop() + i6, i5, i6);
                    e(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (bi(pointerId2)) {
                    float x2 = motionEvent.getX(i2);
                    float y2 = motionEvent.getY(i2);
                    float f3 = x2 - this.Zm[pointerId2];
                    float f4 = y2 - this.Zn[pointerId2];
                    b(f3, f4, pointerId2);
                    if (this.Zk == 1) {
                        break;
                    }
                    View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                    if (a(findTopChildUnder2, f3, f4) && l(findTopChildUnder2, pointerId2)) {
                        break;
                    }
                }
                i2++;
            }
            e(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.Zk == 1) {
                c(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x3 = motionEvent.getX(actionIndex);
            float y3 = motionEvent.getY(actionIndex);
            a(x3, y3, pointerId3);
            if (this.Zk == 0) {
                l(findTopChildUnder((int) x3, (int) y3), pointerId3);
                return;
            } else {
                if (isCapturedViewUnder((int) x3, (int) y3)) {
                    l(this.Zz, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.Zk == 1 && pointerId4 == this.YD) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.YD) {
                    View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.Zz;
                    if (findTopChildUnder3 == view && l(view, pointerId5)) {
                        i = this.YD;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                tk();
            }
        }
        bf(pointerId4);
    }

    public final boolean settleCapturedViewAt(int i, int i2) {
        if (!this.ZB) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        VelocityTracker velocityTracker = this.WN;
        int i3 = this.YD;
        Map map = CQhlFr.f1662A2egSU;
        return a(i, i2, (int) velocityTracker.getXVelocity(i3), (int) this.WN.getYVelocity(this.YD));
    }

    public final boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        this.WN.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            a(x, y, pointerId);
                            int i = this.Zk;
                            if (i != 0 && i == 2 && (findTopChildUnder = findTopChildUnder((int) x, (int) y)) == this.Zz) {
                                l(findTopChildUnder, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            bf(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (this.Zm != null && this.Zn != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (bi(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.Zm[pointerId2];
                            float f2 = y2 - this.Zn[pointerId2];
                            View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                            boolean z = findTopChildUnder2 != null && a(findTopChildUnder2, f, f2);
                            if (z) {
                                findTopChildUnder2.getLeft();
                                this.Zi.D(findTopChildUnder2);
                                int top = findTopChildUnder2.getTop();
                                int bc = this.Zi.bc(((int) f2) + top);
                                int th = this.Zi.th();
                                if (th == 0) {
                                    break;
                                }
                                if (th > 0 && bc == top) {
                                    break;
                                }
                            }
                            b(f, f2, pointerId2);
                            if (this.Zk == 1) {
                                break;
                            }
                            if (z && l(findTopChildUnder2, pointerId2)) {
                                break;
                            }
                        }
                    }
                    e(motionEvent);
                }
            }
            cancel();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = motionEvent.getPointerId(0);
            a(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.Zz && this.Zk == 2) {
                l(findTopChildUnder3, pointerId3);
            }
            int i3 = this.Zq[pointerId3];
        }
        return this.Zk == 1;
    }

    public final boolean smoothSlideViewTo(View view, int i, int i2) {
        this.Zz = view;
        this.YD = -1;
        boolean a2 = a(i, i2, 0, 0);
        if (!a2 && this.Zk == 0 && this.Zz != null) {
            this.Zz = null;
        }
        return a2;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        h hVar;
        int i5;
        int left = this.Zz.getLeft();
        int top = this.Zz.getTop();
        int i6 = i - left;
        int i7 = i2 - top;
        if (i6 == 0 && i7 == 0) {
            this.Zy.f1811A2egSU.abortAnimation();
            bh(0);
            return false;
        }
        int i8 = this.duration;
        if (i8 == 0) {
            i5 = i7;
            i8 = b(this.Zz, i6, i5, i3, i4);
            hVar = this;
            i6 = i6;
        } else {
            hVar = this;
            i5 = i7;
        }
        hVar.Zy.f1811A2egSU.startScroll(left, top, i6, i5, i8);
        bh(2);
        return true;
    }

    private void c(float f, float f2) {
        this.ZB = true;
        this.Zi.onViewReleased(this.Zz, f, f2);
        this.ZB = false;
        if (this.Zk == 1) {
            bh(0);
        }
    }

    private int b(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.Zj.getWidth();
        float f = width / 2;
        float j = (j(Math.min(1.0f, Math.abs(i) / width)) * f) + f;
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(j / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private static float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private void a(float f, float f2, int i) {
        bg(i);
        float[] fArr = this.Zm;
        this.Zo[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.Zn;
        this.Zp[i] = f2;
        fArr2[i] = f2;
        this.Zq[i] = o((int) f, (int) f2);
        this.Zt |= 1 << i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private void b(float f, float f2, int i) {
        boolean a2 = a(f, f2, i, 1);
        boolean z = a2;
        if (a(f2, f, i, 4)) {
            z = (a2 ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (a(f, f2, i, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (a(f2, f, i, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.Zr;
            iArr[i] = iArr[i] | r0;
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.Zq[i] & i2) == i2 && (this.Zx & i2) != 0 && (this.Zs[i] & i2) != i2) {
            int i3 = this.Zr[i];
            if ((i3 & i2) != i2) {
                int i4 = this.Zl;
                if ((abs > i4 || abs2 > i4) && (i3 & i2) == 0 && abs > i4) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(View view, float f, float f2) {
        return view != null && this.Zi.th() > 0 && Math.abs(f2) > ((float) this.Zl);
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.Zz.getLeft();
        int top = this.Zz.getTop();
        if (i3 != 0) {
            DG07BK.AcNBzu(this.Zi.D(this.Zz) - left, this.Zz);
        }
        if (i4 != 0) {
            i2 = this.Zi.bc(i2);
            DG07BK.AlLFFp(i2 - top, this.Zz);
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.Zi.bb(i2);
    }
}
