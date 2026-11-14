package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    static final float f13458a = 30.0f;
    static final float b = 50.0f;
    static final float c = 8.0f;
    private final int d;
    private InterfaceC0457b e;
    private final StateListDrawable f;
    private a g;
    private final int h;
    private final int i;
    private final int j;
    private boolean k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private boolean p;
    private c q;

    public enum a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);

        private final int h;

        static {
            nslxKu();
        }

        a(int i2) {
            this.h = i2;
        }

        private static /* synthetic */ void nslxKu() {
            char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
            int length = charArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                charArray[i2] = (char) (charArray[i2] ^ 145);
            }
            String str = new String(charArray);
            char[] charArray2 = "òýøÿøå".toCharArray();
            int length2 = charArray2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                charArray2[i3] = (char) (charArray2[i3] ^ 145);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public int a() {
            return this.h;
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.b$b, reason: collision with other inner class name */
    public interface InterfaceC0457b {
        void a();
    }

    public final class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.setClosePressed(false);
        }
    }

    public b(Context context) {
        this(context, null, 0);
    }

    private void a(a aVar, int i, Rect rect, Rect rect2) {
        Gravity.apply(aVar.a(), i, i, rect, rect2);
    }

    private void b(a aVar, Rect rect, Rect rect2) {
        a(aVar, this.i, rect, rect2);
    }

    private void c() {
        playSoundEffect(0);
        InterfaceC0457b interfaceC0457b = this.e;
        if (interfaceC0457b != null) {
            interfaceC0457b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == b()) {
            return;
        }
        this.f.setState(z ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.m);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k) {
            this.k = false;
            this.l.set(0, 0, getWidth(), getHeight());
            a(this.g, this.l, this.m);
            this.o.set(this.m);
            Rect rect = this.o;
            int i = this.j;
            rect.inset(i, i);
            b(this.g, this.o, this.n);
            this.f.setBounds(this.n);
        }
        if (this.f.isVisible()) {
            this.f.draw(canvas);
        }
    }

    public Rect getCloseBounds() {
        return this.m;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.d) || !a()) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (b()) {
            if (this.q == null) {
                this.q = new c();
            }
            postDelayed(this.q, ViewConfiguration.getPressedStateDuration());
            c();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean z) {
        this.p = z;
    }

    public void setCloseBoundChanged(boolean z) {
        this.k = z;
    }

    public void setCloseBounds(Rect rect) {
        this.m.set(rect);
    }

    public void setClosePosition(a aVar) {
        Preconditions.checkNotNull(aVar);
        this.g = aVar;
        this.k = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.f.setVisible(z, false)) {
            invalidate(this.m);
        }
    }

    public void setOnCloseListener(InterfaceC0457b interfaceC0457b) {
        this.e = interfaceC0457b;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(a aVar, Rect rect, Rect rect2) {
        a(aVar, this.h, rect, rect2);
    }

    public boolean b() {
        return this.f.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f = stateListDrawable;
        this.g = a.TOP_RIGHT;
        stateListDrawable.setState(FrameLayout.EMPTY_STATE_SET);
        stateListDrawable.setCallback(this);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h = Dips.asIntPixels(50.0f, context);
        this.i = Dips.asIntPixels(f13458a, context);
        this.j = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.p = true;
    }

    public boolean a() {
        return this.p || this.f.isVisible();
    }

    public boolean a(int i, int i2, int i3) {
        Rect rect = this.m;
        return i >= rect.left - i3 && i2 >= rect.top - i3 && i < rect.right + i3 && i2 < rect.bottom + i3;
    }
}
