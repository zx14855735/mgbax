package com.bytedance.adsdk.ugeno.viewpager;

import ADYaiT.CtFAbx;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.bytedance.sdk.component.utils.pl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private float f10080a;
    private boolean ai;
    private boolean am;
    private boolean aq;
    private VelocityTracker b;
    private List<Object> bl;
    private final ArrayList<hf> c;
    private final Rect d;
    private boolean dc;
    private boolean dk;
    private u dq;
    private Drawable e;
    private int en;
    private boolean et;
    private int eu;
    private final hf f;
    private float ff;
    private Scroller g;
    private int gh;
    private EdgeEffect hl;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10081io;
    private int j;
    private float jk;
    private float l;
    private kd lw;
    private int n;
    private final Runnable nb;
    private ArrayList<View> op;
    private Parcelable p;

    /* renamed from: pl, reason: collision with root package name */
    private ClassLoader f10082pl;
    private float pz;
    private boolean q;
    private u qd;
    private y qt;
    private int r;
    private int ra;
    private List<u> s;
    private int ss;
    private int tf;
    private int tj;
    private int tu;
    int u;
    private int v;
    private EdgeEffect vm;
    com.bytedance.adsdk.ugeno.viewpager.hf w;
    private int wa;
    private boolean wn;
    private float wo;
    private int ws;
    private int x;
    private int xj;
    private int yo;
    private boolean yy;
    private int z;
    private int zg;
    static final int[] hf = {R.attr.layout_gravity};
    private static final Comparator<hf> kd = new Comparator<hf>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(hf hfVar, hf hfVar2) {
            return hfVar.hf - hfVar2.hf;
        }
    };
    private static final Interpolator y = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final f gy = new f();

    public static class c extends com.bytedance.adsdk.ugeno.viewpager.xj {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.ClassLoaderCreator<c>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.c.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };
        int hf;
        ClassLoader u;
        Parcelable w;

        static {
            MxTusMS();
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private static /* synthetic */ void MxTusMS() {
            char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 20);
            }
            String str = new String(charArray);
            char[] charArray2 = "wx}z}`".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 20);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return CtFAbx.AZkASS("}", this.hf, sb);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.xj, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hf);
            parcel.writeParcelable(this.w, i);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.hf = parcel.readInt();
            this.w = parcel.readParcelable(classLoader);
            this.u = classLoader;
        }
    }

    public static class f implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            w wVar = (w) view.getLayoutParams();
            w wVar2 = (w) view2.getLayoutParams();
            boolean z = wVar.xj;
            return z != wVar2.xj ? z ? 1 : -1 : wVar.kd - wVar2.kd;
        }
    }

    public static class hf {
        int hf;
        float kd;
        float u;
        boolean w;
        Object xj;
    }

    public interface kd {
        void xj(View view, float f);
    }

    public interface u {
        void d(int i);

        void f(int i);

        void xj(int i, float f, int i2);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface xj {
    }

    public class y extends DataSetObserver {
        public y() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.hf();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.hf();
        }
    }

    static {
        CpHw();
    }

    public ViewPager(Context context) {
        super(context);
        this.c = new ArrayList<>();
        this.f = new hf();
        this.d = new Rect();
        this.tf = -1;
        this.p = null;
        this.f10082pl = null;
        this.jk = -3.4028235E38f;
        this.pz = Float.MAX_VALUE;
        this.x = 1;
        this.r = -1;
        this.dc = true;
        this.wn = false;
        this.nb = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.w();
            }
        };
        this.ss = 0;
        xj();
    }

    private static /* synthetic */ void CpHw() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void c() {
        if (this.gh != 0) {
            ArrayList<View> arrayList = this.op;
            if (arrayList == null) {
                this.op = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.op.add(getChildAt(i));
            }
            Collections.sort(this.op, gy);
        }
    }

    private hf d() {
        int i;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.zg / clientWidth : 0.0f;
        hf hfVar = null;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.c.size()) {
            hf hfVar2 = this.c.get(i3);
            if (!z && hfVar2.hf != (i = i2 + 1)) {
                hfVar2 = this.f;
                hfVar2.kd = f2 + f4 + f3;
                hfVar2.hf = i;
                hfVar2.u = this.w.xj(i);
                i3--;
            }
            hf hfVar3 = hfVar2;
            f2 = hfVar3.kd;
            float f5 = hfVar3.u + f2 + f3;
            if (!z && scrollX < f2) {
                break;
            }
            if (scrollX < f5 || i3 == this.c.size() - 1) {
                return hfVar3;
            }
            int i4 = hfVar3.hf;
            float f6 = hfVar3.u;
            i3++;
            i2 = i4;
            f4 = f6;
            hfVar = hfVar3;
            z = false;
        }
        return hfVar;
    }

    private boolean f() {
        this.r = -1;
        tf();
        this.hl.onRelease();
        this.vm.onRelease();
        return this.hl.isFinished() || this.vm.isFinished();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void kd(int i) {
        u uVar = this.dq;
        if (uVar != null) {
            uVar.f(i);
        }
        List<u> list = this.s;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                u uVar2 = this.s.get(i2);
                if (uVar2 != null) {
                    uVar2.f(i);
                }
            }
        }
        u uVar3 = this.qd;
        if (uVar3 != null) {
            uVar3.f(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.et != z) {
            this.et = z;
        }
    }

    private void tf() {
        this.ai = false;
        this.q = false;
        VelocityTracker velocityTracker = this.b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.b = null;
        }
    }

    private boolean u(int i) {
        if (this.c.size() == 0) {
            if (this.dc) {
                return false;
            }
            this.aq = false;
            xj(0, 0.0f, 0);
            if (this.aq) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        hf d = d();
        int clientWidth = getClientWidth();
        int i2 = this.zg;
        int i3 = clientWidth + i2;
        float f2 = clientWidth;
        int i4 = d.hf;
        float f3 = ((i / f2) - d.kd) / (d.u + (i2 / f2));
        this.aq = false;
        xj(i4, f3, (int) (i3 * f3));
        if (this.aq) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void y() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((w) getChildAt(i).getLayoutParams()).xj) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        hf xj2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (xj2 = xj(childAt)) != null && xj2.hf == this.u) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        hf xj2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (xj2 = xj(childAt)) != null && xj2.hf == this.u) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        w wVar = (w) layoutParams;
        boolean w2 = wVar.xj | w(view);
        wVar.xj = w2;
        if (!this.dk) {
            super.addView(view, i, layoutParams);
        } else {
            if (w2) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            wVar.u = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.w == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.jk)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.pz));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof w) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.am = true;
        if (this.g.isFinished() || !this.g.computeScrollOffset()) {
            xj(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.g.getCurrX();
        int currY = this.g.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!u(currX)) {
                this.g.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || xj(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        hf xj2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (xj2 = xj(childAt)) != null && xj2.hf == this.u && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (hfVar = this.w) != null && hfVar.xj() > 1)) {
            if (!this.hl.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.jk * width);
                this.hl.setSize(height, width);
                z = this.hl.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.vm.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.pz + 1.0f)) * width2);
                this.vm.setSize(height2, width2);
                z |= this.vm.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.hl.finish();
            this.vm.finish();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new w();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.viewpager.hf getAdapter() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.gh == 2) {
            i2 = (i - 1) - i2;
        }
        return ((w) this.op.get(i2).getLayoutParams()).y;
    }

    public int getCurrentItem() {
        return this.u;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.zg;
    }

    public void hf() {
        int xj2 = this.w.xj();
        this.xj = xj2;
        boolean z = this.c.size() < (this.x * 2) + 1 && this.c.size() < xj2;
        int i = this.u;
        int i2 = 0;
        while (i2 < this.c.size()) {
            hf hfVar = this.c.get(i2);
            int xj3 = this.w.xj(hfVar.xj);
            if (xj3 != -1) {
                if (xj3 == -2) {
                    this.c.remove(i2);
                    i2--;
                    this.w.xj((ViewGroup) this, hfVar.hf, hfVar.xj);
                    int i3 = this.u;
                    if (i3 == hfVar.hf) {
                        i = Math.max(0, Math.min(i3, xj2 - 1));
                    }
                } else {
                    int i4 = hfVar.hf;
                    if (i4 != xj3) {
                        if (i4 == this.u) {
                            i = xj3;
                        }
                        hfVar.hf = xj3;
                    }
                }
                z = true;
            }
            i2++;
        }
        Collections.sort(this.c, kd);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                w wVar = (w) getChildAt(i5).getLayoutParams();
                if (!wVar.xj) {
                    wVar.w = 0.0f;
                }
            }
            xj(i, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dc = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.nb);
        Scroller scroller = this.g;
        if (scroller != null && !scroller.isFinished()) {
            this.g.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f2;
        int i2;
        super.onDraw(canvas);
        if (this.zg <= 0 || this.e == null || this.c.size() <= 0 || this.w == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.zg / width;
        int i3 = 0;
        hf hfVar = this.c.get(0);
        float f4 = hfVar.kd;
        int size = this.c.size();
        int i4 = hfVar.hf;
        int i5 = this.c.get(size - 1).hf;
        while (i4 < i5) {
            while (true) {
                i = hfVar.hf;
                if (i4 <= i || i3 >= size) {
                    break;
                }
                i3++;
                hfVar = this.c.get(i3);
            }
            if (i4 == i) {
                float f5 = hfVar.kd;
                float f6 = hfVar.u;
                f2 = (f5 + f6) * width;
                f4 = f5 + f6 + f3;
            } else {
                float xj2 = this.w.xj(i4);
                f2 = (f4 + xj2) * width;
                f4 = xj2 + f3 + f4;
            }
            if (this.zg + f2 > scrollX) {
                i2 = scrollX;
                this.e.setBounds(Math.round(f2), this.yo, Math.round(this.zg + f2), this.v);
                this.e.draw(canvas);
            } else {
                i2 = scrollX;
            }
            if (f2 > i2 + r2) {
                return;
            }
            i4++;
            scrollX = i2;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            f();
            return false;
        }
        if (action != 0) {
            if (this.ai) {
                return true;
            }
            if (this.q) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f10080a = x;
            this.l = x;
            float y2 = motionEvent.getY();
            this.wo = y2;
            this.ff = y2;
            this.r = motionEvent.getPointerId(0);
            this.q = false;
            this.am = true;
            this.g.computeScrollOffset();
            if (this.ss != 2 || Math.abs(this.g.getFinalX() - this.g.getCurrX()) <= this.n) {
                xj(false);
                this.ai = false;
            } else {
                this.g.abortAnimation();
                this.f10081io = false;
                w();
                this.ai = true;
                w(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.r;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.l;
                float abs = Math.abs(f2);
                float y3 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.wo);
                if (f2 != 0.0f && !xj(this.l, f2) && xj(this, false, (int) f2, (int) x2, (int) y3)) {
                    this.l = x2;
                    this.ff = y3;
                    this.q = true;
                    return false;
                }
                int i2 = this.en;
                if (abs > i2 && abs * 0.5f > abs2) {
                    this.ai = true;
                    w(true);
                    setScrollState(1);
                    this.l = f2 > 0.0f ? this.f10080a + this.en : this.f10080a - this.en;
                    this.ff = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i2) {
                    this.q = true;
                }
                if (this.ai && hf(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            xj(motionEvent);
        }
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
        this.b.addMovement(motionEvent);
        return this.ai;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        hf xj2;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (xj2 = xj(childAt)) != null && xj2.hf == this.u && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.xj());
        if (this.w != null) {
            xj(cVar.hf, false, true);
            return;
        }
        this.tf = cVar.hf;
        this.p = cVar.w;
        this.f10082pl = cVar.u;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.hf = this.u;
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar = this.w;
        if (hfVar != null) {
            cVar.w = hfVar.hf();
        }
        return cVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.zg;
            xj(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar;
        int findPointerIndex;
        if (this.yy) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (hfVar = this.w) == null || hfVar.xj() == 0) {
            return false;
        }
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
        this.b.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.g.abortAnimation();
            this.f10081io = false;
            w();
            float x = motionEvent.getX();
            this.f10080a = x;
            this.l = x;
            float y2 = motionEvent.getY();
            this.wo = y2;
            this.ff = y2;
            this.r = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.ai) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
                    if (findPointerIndex2 == -1) {
                        z = f();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex2);
                        float abs = Math.abs(x2 - this.l);
                        float y3 = motionEvent.getY(findPointerIndex2);
                        float abs2 = Math.abs(y3 - this.ff);
                        if (abs > this.en && abs > abs2) {
                            this.ai = true;
                            w(true);
                            float f2 = this.f10080a;
                            this.l = x2 - f2 > 0.0f ? f2 + this.en : f2 - this.en;
                            this.ff = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.ai && (findPointerIndex = motionEvent.findPointerIndex(this.r)) != -1) {
                    z = hf(motionEvent.getX(findPointerIndex));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex != -1) {
                        this.l = motionEvent.getX(actionIndex);
                        this.r = motionEvent.getPointerId(actionIndex);
                    }
                } else if (action == 6) {
                    xj(motionEvent);
                    int findPointerIndex3 = motionEvent.findPointerIndex(this.r);
                    if (findPointerIndex3 != -1) {
                        this.l = motionEvent.getX(findPointerIndex3);
                    }
                }
            } else if (this.ai) {
                xj(this.u, true, 0, false);
                z = f();
            }
        } else if (this.ai) {
            VelocityTracker velocityTracker = this.b;
            velocityTracker.computeCurrentVelocity(1000, this.eu);
            int xVelocity = (int) velocityTracker.getXVelocity(this.r);
            this.f10081io = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            hf d = d();
            float f3 = clientWidth;
            int i = d.hf;
            float f4 = ((scrollX / f3) - d.kd) / (d.u + (this.zg / f3));
            int findPointerIndex4 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex4 != -1) {
                xj(xj(i, f4, xVelocity, (int) (motionEvent.getX(findPointerIndex4) - this.f10080a)), true, true, xVelocity);
                z = f();
            }
        }
        if (z) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.dk) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.hf hfVar) {
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar2 = this.w;
        if (hfVar2 != null) {
            hfVar2.xj((DataSetObserver) null);
            for (int i = 0; i < this.c.size(); i++) {
                hf hfVar3 = this.c.get(i);
                this.w.xj((ViewGroup) this, hfVar3.hf, hfVar3.xj);
            }
            this.c.clear();
            y();
            this.u = 0;
            scrollTo(0, 0);
        }
        this.w = hfVar;
        this.xj = 0;
        if (hfVar != null) {
            if (this.qt == null) {
                this.qt = new y();
            }
            this.w.xj((DataSetObserver) this.qt);
            this.f10081io = false;
            boolean z = this.dc;
            this.dc = true;
            this.xj = this.w.xj();
            int i2 = this.tf;
            if (i2 >= 0) {
                xj(i2, false, true);
                this.tf = -1;
                this.p = null;
                this.f10082pl = null;
            } else if (z) {
                requestLayout();
            } else {
                w();
            }
        }
        List<Object> list = this.bl;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.bl.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.bl.get(i3);
        }
    }

    public void setCurrentItem(int i) {
        this.f10081io = false;
        xj(i, !this.dc, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            pl.hf("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.x) {
            this.x = i;
            w();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(u uVar) {
        this.dq = uVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.zg;
        this.zg = i;
        int width = getWidth();
        xj(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.e = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.ss == i) {
            return;
        }
        this.ss = i;
        if (this.lw != null) {
            hf(i != 0);
        }
        y(i);
    }

    public void setScroller(Scroller scroller) {
        this.g = scroller;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.e;
    }

    public void w() {
        xj(this.u);
    }

    public void xj() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.g = new Scroller(context, y);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.en = viewConfiguration.getScaledPagingTouchSlop();
        this.ws = (int) (400.0f * f2);
        this.eu = viewConfiguration.getScaledMaximumFlingVelocity();
        this.hl = new EdgeEffect(context);
        this.vm = new EdgeEffect(context);
        this.tj = (int) (25.0f * f2);
        this.n = (int) (2.0f * f2);
        this.z = (int) (f2 * 16.0f);
    }

    public static class w extends ViewGroup.LayoutParams {
        public int hf;
        int kd;
        boolean u;
        float w;
        public boolean xj;
        int y;

        public w() {
            super(-1, -1);
            this.w = 0.0f;
        }

        public w(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.w = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.hf);
            this.hf = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean w(View view) {
        return view.getClass().getAnnotation(xj.class) != null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new w(getContext(), attributeSet);
    }

    private void w(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    private void y(int i) {
        u uVar = this.dq;
        if (uVar != null) {
            uVar.d(i);
        }
        List<u> list = this.s;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                u uVar2 = this.s.get(i2);
                if (uVar2 != null) {
                    uVar2.d(i);
                }
            }
        }
        u uVar3 = this.qd;
        if (uVar3 != null) {
            uVar3.d(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        if (r5 != 2) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L60
        L9:
            if (r0 == 0) goto L60
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L60
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            com.bytedance.sdk.component.utils.pl.u(r2, r0)
            goto L7
        L60:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lab
            if (r1 == r0) goto Lab
            if (r5 != r3) goto L90
            android.graphics.Rect r2 = r4.d
            android.graphics.Rect r2 = r4.xj(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.d
            android.graphics.Rect r3 = r4.xj(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8b
            if (r2 < r3) goto L8b
            boolean r0 = r4.u()
            goto Lc2
        L8b:
            boolean r0 = r1.requestFocus()
            goto Lc2
        L90:
            if (r5 != r2) goto Lb7
            android.graphics.Rect r2 = r4.d
            android.graphics.Rect r2 = r4.xj(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.d
            android.graphics.Rect r3 = r4.xj(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto La6
            if (r2 <= r3) goto Lb9
        La6:
            boolean r0 = r1.requestFocus()
            goto Lc2
        Lab:
            if (r5 == r3) goto Lbe
            r0 = 1
            if (r5 != r0) goto Lb1
            goto Lbe
        Lb1:
            if (r5 == r2) goto Lb9
            r0 = 2
            if (r5 != r0) goto Lb7
            goto Lb9
        Lb7:
            r0 = 0
            goto Lc2
        Lb9:
            boolean r0 = r4.kd()
            goto Lc2
        Lbe:
            boolean r0 = r4.u()
        Lc2:
            if (r0 == 0) goto Lcb
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Lcb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.w(int):boolean");
    }

    public boolean kd() {
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar = this.w;
        if (hfVar == null || this.u >= hfVar.xj() - 1) {
            return false;
        }
        xj(this.u + 1, true);
        return true;
    }

    public boolean u() {
        int i = this.u;
        if (i <= 0) {
            return false;
        }
        xj(i - 1, true);
        return true;
    }

    public void xj(int i, boolean z) {
        this.f10081io = false;
        xj(i, z, false);
    }

    public void xj(int i, boolean z, boolean z2) {
        xj(i, z, z2, 0);
    }

    public void xj(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.viewpager.hf hfVar = this.w;
        if (hfVar != null && hfVar.xj() > 0) {
            if (!z2 && this.u == i && this.c.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.w.xj()) {
                i = this.w.xj() - 1;
            }
            int i3 = this.x;
            int i4 = this.u;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.c.size(); i5++) {
                    this.c.get(i5).w = true;
                }
            }
            boolean z3 = this.u != i;
            if (this.dc) {
                this.u = i;
                if (z3) {
                    kd(i);
                }
                requestLayout();
                return;
            }
            xj(i);
            xj(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public hf hf(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return xj(view);
            }
        }
    }

    public hf hf(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            hf hfVar = this.c.get(i2);
            if (hfVar.hf == i) {
                return hfVar;
            }
        }
        return null;
    }

    private void hf(int i, float f2, int i2) {
        u uVar = this.dq;
        if (uVar != null) {
            uVar.xj(i, f2, i2);
        }
        List<u> list = this.s;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                u uVar2 = this.s.get(i3);
                if (uVar2 != null) {
                    uVar2.xj(i, f2, i2);
                }
            }
        }
        u uVar3 = this.qd;
        if (uVar3 != null) {
            uVar3.xj(i, f2, i2);
        }
    }

    private void xj(int i, boolean z, int i2, boolean z2) {
        int i3;
        hf hf2 = hf(i);
        if (hf2 != null) {
            i3 = (int) (Math.max(this.jk, Math.min(hf2.kd, this.pz)) * getClientWidth());
        } else {
            i3 = 0;
        }
        if (z) {
            xj(i3, 0, i2);
            if (z2) {
                kd(i);
                return;
            }
            return;
        }
        if (z2) {
            kd(i);
        }
        xj(false);
        scrollTo(i3, 0);
        u(i3);
    }

    private void hf(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.wa : 0, null);
        }
    }

    private boolean hf(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.l - f2;
        this.l = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.jk * clientWidth;
        float f5 = this.pz * clientWidth;
        boolean z3 = false;
        hf hfVar = this.c.get(0);
        hf hfVar2 = (hf) CtFAbx.ADYaiT(this.c, 1);
        if (hfVar.hf != 0) {
            f4 = hfVar.kd * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (hfVar2.hf != this.w.xj() - 1) {
            f5 = hfVar2.kd * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.hl.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.vm.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i = (int) scrollX;
        this.l = (scrollX - i) + this.l;
        scrollTo(i, getScrollY());
        u(i);
        return z3;
    }

    public void xj(u uVar) {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(uVar);
    }

    public void xj(boolean z, kd kdVar) {
        xj(z, kdVar, 2);
    }

    public void xj(boolean z, kd kdVar, int i) {
        boolean z2 = kdVar != null;
        boolean z3 = z2 != (this.lw != null);
        this.lw = kdVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.gh = z ? 2 : 1;
            this.wa = i;
        } else {
            this.gh = 0;
        }
        if (z3) {
            w();
        }
    }

    public float xj(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public void xj(int i, int i2, int i3) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.g;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.am ? this.g.getCurrX() : this.g.getStartX();
            this.g.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            xj(false);
            w();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i7;
        float xj2 = (xj(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3) + f3;
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(xj2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((this.w.xj(this.u) * f2) + this.zg)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.am = false;
        this.g.startScroll(i4, scrollY, i5, i6, min);
        postInvalidateOnAnimation();
    }

    public hf xj(int i, int i2) {
        hf hfVar = new hf();
        hfVar.hf = i;
        hfVar.xj = this.w.xj((ViewGroup) this, i);
        hfVar.u = this.w.xj(i);
        if (i2 >= 0 && i2 < this.c.size()) {
            this.c.add(i2, hfVar);
            return hfVar;
        }
        this.c.add(hfVar);
        return hfVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r9 == r10) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r18) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.xj(int):void");
    }

    private void xj(hf hfVar, int i, hf hfVar2) {
        int i2;
        int i3;
        hf hfVar3;
        hf hfVar4;
        int xj2 = this.w.xj();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.zg / clientWidth : 0.0f;
        if (hfVar2 != null) {
            int i4 = hfVar2.hf;
            int i5 = hfVar.hf;
            if (i4 < i5) {
                float f3 = hfVar2.kd + hfVar2.u + f2;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= hfVar.hf && i7 < this.c.size()) {
                    hf hfVar5 = this.c.get(i7);
                    while (true) {
                        hfVar4 = hfVar5;
                        if (i6 <= hfVar4.hf || i7 >= this.c.size() - 1) {
                            break;
                        }
                        i7++;
                        hfVar5 = this.c.get(i7);
                    }
                    while (i6 < hfVar4.hf) {
                        f3 += this.w.xj(i6) + f2;
                        i6++;
                    }
                    hfVar4.kd = f3;
                    f3 += hfVar4.u + f2;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.c.size() - 1;
                float f4 = hfVar2.kd;
                while (true) {
                    i4--;
                    if (i4 < hfVar.hf || size < 0) {
                        break;
                    }
                    hf hfVar6 = this.c.get(size);
                    while (true) {
                        hfVar3 = hfVar6;
                        if (i4 >= hfVar3.hf || size <= 0) {
                            break;
                        }
                        size--;
                        hfVar6 = this.c.get(size);
                    }
                    while (i4 > hfVar3.hf) {
                        f4 -= this.w.xj(i4) + f2;
                        i4--;
                    }
                    f4 -= hfVar3.u + f2;
                    hfVar3.kd = f4;
                }
            }
        }
        int size2 = this.c.size();
        float f5 = hfVar.kd;
        int i8 = hfVar.hf;
        int i9 = i8 - 1;
        this.jk = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = xj2 - 1;
        this.pz = i8 == i10 ? (hfVar.u + f5) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            hf hfVar7 = this.c.get(i11);
            while (true) {
                i3 = hfVar7.hf;
                if (i9 <= i3) {
                    break;
                }
                f5 -= this.w.xj(i9) + f2;
                i9--;
            }
            f5 -= hfVar7.u + f2;
            hfVar7.kd = f5;
            if (i3 == 0) {
                this.jk = f5;
            }
            i11--;
            i9--;
        }
        float f6 = hfVar.kd + hfVar.u + f2;
        int i12 = hfVar.hf + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            hf hfVar8 = this.c.get(i13);
            while (true) {
                i2 = hfVar8.hf;
                if (i12 >= i2) {
                    break;
                }
                f6 += this.w.xj(i12) + f2;
                i12++;
            }
            if (i2 == i10) {
                this.pz = (hfVar8.u + f6) - 1.0f;
            }
            hfVar8.kd = f6;
            f6 += hfVar8.u + f2;
            i13++;
            i12++;
        }
        this.wn = false;
    }

    public hf xj(View view) {
        for (int i = 0; i < this.c.size(); i++) {
            hf hfVar = this.c.get(i);
            if (this.w.xj(view, hfVar.xj)) {
                return hfVar;
            }
        }
        return null;
    }

    private void xj(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.c.isEmpty()) {
            if (!this.g.isFinished()) {
                this.g.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        hf hf2 = hf(this.u);
        int min = (int) ((hf2 != null ? Math.min(hf2.kd, this.pz) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            xj(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.tu
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$w r9 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.w) r9
            boolean r10 = r9.xj
            if (r10 == 0) goto L68
            int r9 = r9.hf
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5c
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L45:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5c
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L45
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.hf(r13, r14, r15)
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$kd r13 = r12.lw
            if (r13 == 0) goto L9e
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9e
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$w r0 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.w) r0
            boolean r0 = r0.xj
            if (r0 != 0) goto L9b
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$kd r3 = r12.lw
            r3.xj(r15, r0)
        L9b:
            int r1 = r1 + 1
            goto L7a
        L9e:
            r12.aq = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.xj(int, float, int):void");
    }

    private void xj(boolean z) {
        boolean z2 = this.ss == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.g.isFinished()) {
                this.g.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.g.getCurrX();
                int currY = this.g.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        u(currX);
                    }
                }
            }
        }
        this.f10081io = false;
        for (int i = 0; i < this.c.size(); i++) {
            hf hfVar = this.c.get(i);
            if (hfVar.w) {
                hfVar.w = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.nb);
            } else {
                this.nb.run();
            }
        }
    }

    private boolean xj(float f2, float f3) {
        if (f2 >= this.j || f3 <= 0.0f) {
            return f2 > ((float) (getWidth() - this.j)) && f3 < 0.0f;
        }
        return true;
    }

    private int xj(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.tj || Math.abs(i2) <= this.ws) {
            i += (int) (f2 + (i >= this.u ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.c.size() > 0) {
            return Math.max(this.c.get(0).hf, Math.min(i, ((hf) CtFAbx.ADYaiT(this.c, 1)).hf));
        }
        return i;
    }

    private void xj(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i = actionIndex == 0 ? 1 : 0;
            this.l = motionEvent.getX(i);
            this.r = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.b;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean xj(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && xj(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public boolean xj(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return u();
            }
            return w(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return kd();
            }
            return w(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return w(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return w(1);
        }
        return false;
    }

    private Rect xj(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
