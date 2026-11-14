package AaHO0E;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EdQ5bb extends ListView {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Rect f771AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f772AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f773AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f774AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f775B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f776B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public EUIRHA f777B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f778B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f779B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f780B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CikNvS.ASJ6gh f781BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ADYaiT.D8MqeW f782BI9f7h;

    public EdQ5bb(Context context, boolean z) {
        super(context, null, 2130969043);
        this.f771AcNBzu = new Rect();
        this.f772AlLFFp = 0;
        this.f773AmA8tU = 0;
        this.f774AzWtSf = 0;
        this.f775B25kr6 = 0;
        this.f779B7CMnp = z;
        setCacheColorHint(0);
    }

    public final int A2egSU(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i3 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = adapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = adapter.getView(i5, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i6 = layoutParams.height;
            view.measure(i, i6 > 0 ? View.MeasureSpec.makeMeasureSpec(i6, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i5 > 0) {
                i3 += dividerHeight;
            }
            i3 += view.getMeasuredHeight();
            if (i3 >= i2) {
                return i2;
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0148 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A4TApA(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.EdQ5bb.A4TApA(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f771AcNBzu;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f782BI9f7h != null) {
            return;
        }
        super.drawableStateChanged();
        EUIRHA euirha = this.f777B3GDIM;
        if (euirha != null) {
            euirha.f769AlLFFp = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f780B9tovu && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f779B7CMnp || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f779B7CMnp || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f779B7CMnp || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f779B7CMnp && this.f778B4ZgIw) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f782BI9f7h = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = 2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f782BI9f7h == null) {
            ADYaiT.D8MqeW d8MqeW = new ADYaiT.D8MqeW(i, this);
            this.f782BI9f7h = d8MqeW;
            post(d8MqeW);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i2 < 30 || !EPdU4G.f768ADYaiT) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        EPdU4G.f765A2egSU.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        EPdU4G.f766A4TApA.invoke(this, Integer.valueOf(pointToPosition));
                        EPdU4G.f767A5SV6n.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f780B9tovu && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f776B2KMhB = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ADYaiT.D8MqeW d8MqeW = this.f782BI9f7h;
        if (d8MqeW != null) {
            EdQ5bb edQ5bb = (EdQ5bb) d8MqeW.f220AlLFFp;
            edQ5bb.f782BI9f7h = null;
            edQ5bb.removeCallbacks(d8MqeW);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f778B4ZgIw = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        EUIRHA euirha;
        if (drawable != null) {
            euirha = new EUIRHA(drawable);
            euirha.f769AlLFFp = true;
        } else {
            euirha = null;
        }
        this.f777B3GDIM = euirha;
        super.setSelector(euirha);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f772AlLFFp = rect.left;
        this.f773AmA8tU = rect.top;
        this.f774AzWtSf = rect.right;
        this.f775B25kr6 = rect.bottom;
    }
}
