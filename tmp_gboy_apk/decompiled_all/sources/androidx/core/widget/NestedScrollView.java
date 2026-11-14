package androidx.core.widget;

import ADYaiT.AcNBzu;
import AZkASS.ARc23Z;
import COJEAR.B9tovu;
import COJEAR.BChYOn;
import COJEAR.BIYEnU;
import COJEAR.BJ7GGh;
import COJEAR.DG07BK;
import CikNvS.AMqCpz;
import CikNvS.AYUAbz;
import CikNvS.AZOQYO;
import CikNvS.AZkASS;
import CikNvS.AaHO0E;
import K1Z3yj.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.bumptech.glide.A5SV6n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NestedScrollView extends FrameLayout implements BIYEnU, B9tovu {

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static final float f8583CTkVKb = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static final AYUAbz f8584CcAIMM = new AYUAbz(0);

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final int[] f8585Cd8JRx = {R.attr.fillViewport};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final float f8586AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f8587AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Rect f8588AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final OverScroller f8589AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final EdgeEffect f8590B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final EdgeEffect f8591B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f8592B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8593B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f8594B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public View f8595B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f8596BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public VelocityTracker f8597BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f8598BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f8599BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final int f8600BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final int f8601BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f8602BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f8603BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final int[] f8604BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final int[] f8605BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f8606C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public AaHO0E f8607C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final BJ7GGh f8608CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final BChYOn f8609CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public float f8610COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public AZkASS f8611CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final COJEAR.AZkASS f8612CSDoyG;

    static {
        ausr();
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969672);
        this.f8588AmA8tU = new Rect();
        this.f8593B4ZgIw = true;
        this.f8594B7CMnp = false;
        this.f8595B9tovu = null;
        this.f8596BChYOn = false;
        this.f8599BJ7GGh = true;
        this.f8603BV3sI0 = -1;
        this.f8604BmvVmW = new int[2];
        this.f8605BniPrB = new int[2];
        this.f8612CSDoyG = new COJEAR.AZkASS(getContext(), new ARc23Z(7, this));
        int i = Build.VERSION.SDK_INT;
        this.f8590B25kr6 = i >= 31 ? AMqCpz.A2egSU(context, attributeSet) : new EdgeEffect(context);
        this.f8591B2KMhB = i >= 31 ? AMqCpz.A2egSU(context, attributeSet) : new EdgeEffect(context);
        this.f8586AcNBzu = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f8589AzWtSf = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f8600BNL6CD = viewConfiguration.getScaledTouchSlop();
        this.f8601BPw6Q8 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8602BTvldC = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8585Cd8JRx, 2130969672, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f8608CASmeH = new BJ7GGh();
        this.f8609CNPG0E = new BChYOn(this);
        setNestedScrollingEnabled(true);
        DG07BK.B4ZgIw(this, f8584CcAIMM);
    }

    public static boolean ASJ6gh(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && ASJ6gh((View) parent, nestedScrollView);
    }

    private static /* synthetic */ void ausr() {
        char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 255);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 255);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A2egSU(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !AYUAbz(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            AmA8tU(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f8588AmA8tU;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            AmA8tU(A4TApA(rect), 0, 1, true);
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && !AYUAbz(findFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final int A4TApA(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public final boolean A5SV6n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f8609CNPG0E.A5SV6n(i, i2, iArr, null, i3);
    }

    public final boolean ADYaiT(KeyEvent keyEvent) {
        this.f8588AmA8tU.setEmpty();
        int childCount = getChildCount();
        int i = MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
        if (childCount > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return keyEvent.isAltPressed() ? ARc23Z(33) : A2egSU(33);
                    }
                    if (keyCode == 20) {
                        return keyEvent.isAltPressed() ? ARc23Z(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE) : A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                    }
                    if (keyCode == 62) {
                        if (keyEvent.isShiftPressed()) {
                            i = 33;
                        }
                        AcNBzu(i);
                        return false;
                    }
                    if (keyCode == 92) {
                        return ARc23Z(33);
                    }
                    if (keyCode == 93) {
                        return ARc23Z(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                    }
                    if (keyCode == 122) {
                        AcNBzu(33);
                        return false;
                    }
                    if (keyCode == 123) {
                        AcNBzu(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                        return false;
                    }
                }
                return false;
            }
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
            if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE)) {
                return true;
            }
        }
        return false;
    }

    public final void AMqCpz(int i) {
        if (getChildCount() > 0) {
            this.f8589AzWtSf.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            B2KMhB(2, 1);
            this.f8606C2rE4F = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean ARc23Z(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f8588AmA8tU;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return AlLFFp(i, rect.top, rect.bottom);
    }

    public final boolean AYUAbz(View view, int i, int i2) {
        Rect rect = this.f8588AmA8tU;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2;
    }

    public final void AZOQYO(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f8609CNPG0E.ADYaiT(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public final void AZkASS(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8603BV3sI0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f8592B3GDIM = (int) motionEvent.getY(i);
            this.f8603BV3sI0 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f8597BI9f7h;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean AaHO0E(int i, int i2, int i3, int i4) {
        int i5;
        boolean z;
        int i6;
        boolean z2;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i7 = i3 + i;
        if (i2 <= 0 && i2 >= 0) {
            i5 = i2;
            z = false;
        } else {
            z = true;
            i5 = 0;
        }
        if (i7 > i4) {
            i6 = i4;
            z2 = true;
        } else if (i7 < 0) {
            z2 = true;
            i6 = 0;
        } else {
            i6 = i7;
            z2 = false;
        }
        if (z2 && !this.f8609CNPG0E.ARc23Z(1)) {
            this.f8589AzWtSf.springBack(i5, i6, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i6);
        return z || z2;
    }

    public final void AcNBzu(int i) {
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f8588AmA8tU;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        AlLFFp(i, i2, i3);
    }

    public final boolean AlLFFp(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else {
                        if (!z5) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            AmA8tU(z2 ? i2 - scrollY : i3 - i4, 0, 1, true);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    public final int AmA8tU(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        boolean z2;
        VelocityTracker velocityTracker;
        if (i3 == 1) {
            B2KMhB(2, i3);
        }
        boolean A5SV6n2 = this.f8609CNPG0E.A5SV6n(0, i, this.f8605BniPrB, this.f8604BmvVmW, i3);
        int[] iArr = this.f8605BniPrB;
        int[] iArr2 = this.f8604BmvVmW;
        if (A5SV6n2) {
            i4 = i - iArr[1];
            i5 = iArr2[1];
        } else {
            i4 = i;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z3 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z;
        boolean z4 = AaHO0E(i4, 0, scrollY, scrollRange) && !this.f8609CNPG0E.ARc23Z(i3);
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.f8609CNPG0E.ADYaiT(0, scrollY2, 0, i4 - scrollY2, this.f8604BmvVmW, i3, iArr);
        int i6 = i5 + iArr2[1];
        int i7 = i4 - iArr[1];
        int i8 = scrollY + i7;
        EdgeEffect edgeEffect = this.f8591B2KMhB;
        EdgeEffect edgeEffect2 = this.f8590B25kr6;
        if (i8 < 0) {
            if (z3) {
                A5SV6n.CqNSpT(edgeEffect2, (-i7) / getHeight(), i2 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i8 > scrollRange && z3) {
            A5SV6n.CqNSpT(edgeEffect, i7 / getHeight(), 1.0f - (i2 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z2 = z4;
        } else {
            postInvalidateOnAnimation();
            z2 = false;
        }
        if (z2 && i3 == 0 && (velocityTracker = this.f8597BI9f7h) != null) {
            velocityTracker.clear();
        }
        if (i3 == 1) {
            B4ZgIw(i3);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i6;
    }

    public final boolean AzWtSf(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float BChYOn2 = A5SV6n.BChYOn(edgeEffect) * getHeight();
        float abs = Math.abs(-i) * 0.35f;
        float f = this.f8586AcNBzu * 0.015f;
        double log = Math.log(abs / f);
        double d = f8583CTkVKb;
        return ((float) (Math.exp((d / (d - 1.0d)) * log) * ((double) f))) < BChYOn2;
    }

    public final void B25kr6(int i, int i2, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f8587AlLFFp > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f8589AzWtSf.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM);
            if (z) {
                B2KMhB(2, 1);
            } else {
                B4ZgIw(1);
            }
            this.f8606C2rE4F = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f8589AzWtSf.isFinished()) {
                this.f8589AzWtSf.abortAnimation();
                B4ZgIw(1);
            }
            scrollBy(i, i2);
        }
        this.f8587AlLFFp = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean B2KMhB(int i, int i2) {
        return this.f8609CNPG0E.AYUAbz(2, i2);
    }

    public final boolean B3GDIM(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.f8590B25kr6;
        if (A5SV6n.BChYOn(edgeEffect) != 0.0f) {
            A5SV6n.CqNSpT(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f8591B2KMhB;
        if (A5SV6n.BChYOn(edgeEffect2) == 0.0f) {
            return z;
        }
        A5SV6n.CqNSpT(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void B4ZgIw(int i) {
        this.f8609CNPG0E.AZOQYO(i);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? (scrollY - max) + bottom : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || ADYaiT(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f8609CNPG0E.A2egSU(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.f8609CNPG0E.A4TApA(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f8609CNPG0E.A5SV6n(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f8609CNPG0E.ADYaiT(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f8590B25kr6;
        int i2 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (AZOQYO.A2egSU(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i = getPaddingLeft();
            } else {
                i = 0;
            }
            if (AZOQYO.A2egSU(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f8591B2KMhB;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (AZOQYO.A2egSU(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            i2 = getPaddingLeft();
        }
        if (AZOQYO.A2egSU(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            max -= getPaddingBottom();
        }
        canvas.translate(i2 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        BJ7GGh bJ7GGh = this.f8608CASmeH;
        return bJ7GGh.f1649A4TApA | bJ7GGh.f1648A2egSU;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.f8610COJEAR == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f8610COJEAR = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f8610COJEAR;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f8609CNPG0E.ARc23Z(0);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f8609CNPG0E.f1647ADYaiT;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8594B7CMnp = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x012c, code lost:
    
        if (r2 >= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00d9, code lost:
    
        if (r2 >= 0) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ca  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r31) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.f8596BChYOn) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.f8603BV3sI0;
                    if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y - this.f8592B3GDIM) > this.f8600BNL6CD && (2 & getNestedScrollAxes()) == 0) {
                            this.f8596BChYOn = true;
                            this.f8592B3GDIM = y;
                            if (this.f8597BI9f7h == null) {
                                this.f8597BI9f7h = VelocityTracker.obtain();
                            }
                            this.f8597BI9f7h.addMovement(motionEvent);
                            this.BpkvW3 = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        AZkASS(motionEvent);
                    }
                }
            }
            this.f8596BChYOn = false;
            this.f8603BV3sI0 = -1;
            VelocityTracker velocityTracker = this.f8597BI9f7h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f8597BI9f7h = null;
            }
            if (this.f8589AzWtSf.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            B4ZgIw(0);
        } else {
            int y2 = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y2 >= childAt.getTop() - scrollY && y2 < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                    this.f8592B3GDIM = y2;
                    this.f8603BV3sI0 = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f8597BI9f7h;
                    if (velocityTracker2 == null) {
                        this.f8597BI9f7h = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f8597BI9f7h.addMovement(motionEvent);
                    this.f8589AzWtSf.computeScrollOffset();
                    if (!B3GDIM(motionEvent) && this.f8589AzWtSf.isFinished()) {
                        z = false;
                    }
                    this.f8596BChYOn = z;
                    B2KMhB(2, 0);
                }
            }
            if (!B3GDIM(motionEvent) && this.f8589AzWtSf.isFinished()) {
                z = false;
            }
            this.f8596BChYOn = z;
            VelocityTracker velocityTracker3 = this.f8597BI9f7h;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f8597BI9f7h = null;
            }
        }
        return this.f8596BChYOn;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = 0;
        this.f8593B4ZgIw = false;
        View view = this.f8595B9tovu;
        if (view != null && ASJ6gh(view, this)) {
            View view2 = this.f8595B9tovu;
            Rect rect = this.f8588AmA8tU;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int A4TApA2 = A4TApA(rect);
            if (A4TApA2 != 0) {
                scrollBy(0, A4TApA2);
            }
        }
        this.f8595B9tovu = null;
        if (!this.f8594B7CMnp) {
            if (this.f8607C4FrIb != null) {
                scrollTo(getScrollX(), this.f8607C4FrIb.f1810AcNBzu);
                this.f8607C4FrIb = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i5 = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i5 && scrollY >= 0) {
                i6 = paddingTop + scrollY > i5 ? i5 - paddingTop : scrollY;
            }
            if (i6 != scrollY) {
                scrollTo(getScrollX(), i6);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f8594B7CMnp = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8598BIYEnU && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        AMqCpz((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return this.f8609CNPG0E.A4TApA(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        A5SV6n(i, i2, iArr, null, 0);
    }

    @Override // COJEAR.BIYEnU
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        AZOQYO(i4, i5, iArr);
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        BJ7GGh bJ7GGh = this.f8608CASmeH;
        if (i2 == 1) {
            bJ7GGh.f1649A4TApA = i;
        } else {
            bJ7GGh.f1648A2egSU = i;
        }
        B2KMhB(2, i2);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && AYUAbz(findNextFocus, 0, getHeight())) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof AaHO0E)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        AaHO0E aaHO0E = (AaHO0E) parcelable;
        super.onRestoreInstanceState(aaHO0E.getSuperState());
        this.f8607C4FrIb = aaHO0E;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        AaHO0E aaHO0E = new AaHO0E(super.onSaveInstanceState());
        aaHO0E.f1810AcNBzu = getScrollY();
        return aaHO0E;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        AZkASS aZkASS = this.f8611CQhlFr;
        if (aZkASS != null) {
            A2egSU a2egSU = (A2egSU) aZkASS;
            AcNBzu.A4TApA(this, (View) a2egSU.f4174AlLFFp, (View) a2egSU.f4175AmA8tU);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !AYUAbz(findFocus, 0, i4)) {
            return;
        }
        Rect rect = this.f8588AmA8tU;
        findFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(findFocus, rect);
        int A4TApA2 = A4TApA(rect);
        if (A4TApA2 != 0) {
            if (this.f8599BJ7GGh) {
                B25kr6(0, A4TApA2, false);
            } else {
                scrollBy(0, A4TApA2);
            }
        }
    }

    @Override // COJEAR.BI9f7h
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // COJEAR.BI9f7h
    public final void onStopNestedScroll(View view, int i) {
        BJ7GGh bJ7GGh = this.f8608CASmeH;
        if (i == 1) {
            bJ7GGh.f1649A4TApA = 0;
        } else {
            bJ7GGh.f1648A2egSU = 0;
        }
        B4ZgIw(i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f8597BI9f7h == null) {
            this.f8597BI9f7h = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.BpkvW3 = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        float f = 0.0f;
        obtain.offsetLocation(0.0f, this.BpkvW3);
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.f8591B2KMhB;
            EdgeEffect edgeEffect2 = this.f8590B25kr6;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f8597BI9f7h;
                velocityTracker.computeCurrentVelocity(1000, this.f8602BTvldC);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f8603BV3sI0);
                if (Math.abs(yVelocity) >= this.f8601BPw6Q8) {
                    if (A5SV6n.BChYOn(edgeEffect2) != 0.0f) {
                        if (AzWtSf(edgeEffect2, yVelocity)) {
                            edgeEffect2.onAbsorb(yVelocity);
                        } else {
                            AMqCpz(-yVelocity);
                        }
                    } else if (A5SV6n.BChYOn(edgeEffect) != 0.0f) {
                        int i = -yVelocity;
                        if (AzWtSf(edgeEffect, i)) {
                            edgeEffect.onAbsorb(i);
                        } else {
                            AMqCpz(i);
                        }
                    } else {
                        int i2 = -yVelocity;
                        float f2 = i2;
                        if (!this.f8609CNPG0E.A4TApA(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            AMqCpz(i2);
                        }
                    }
                } else if (this.f8589AzWtSf.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f8603BV3sI0 = -1;
                this.f8596BChYOn = false;
                VelocityTracker velocityTracker2 = this.f8597BI9f7h;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f8597BI9f7h = null;
                }
                B4ZgIw(0);
                this.f8590B25kr6.onRelease();
                this.f8591B2KMhB.onRelease();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f8603BV3sI0);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i3 = this.f8592B3GDIM - y;
                    float x = motionEvent.getX(findPointerIndex) / getWidth();
                    float height = i3 / getHeight();
                    if (A5SV6n.BChYOn(edgeEffect2) != 0.0f) {
                        float f3 = -A5SV6n.CqNSpT(edgeEffect2, -height, x);
                        if (A5SV6n.BChYOn(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                        f = f3;
                    } else if (A5SV6n.BChYOn(edgeEffect) != 0.0f) {
                        float CqNSpT2 = A5SV6n.CqNSpT(edgeEffect, height, 1.0f - x);
                        if (A5SV6n.BChYOn(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                        f = CqNSpT2;
                    }
                    int round = Math.round(f * getHeight());
                    if (round != 0) {
                        invalidate();
                    }
                    int i4 = i3 - round;
                    if (!this.f8596BChYOn && Math.abs(i4) > this.f8600BNL6CD) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f8596BChYOn = true;
                        i4 = i4 > 0 ? i4 - this.f8600BNL6CD : i4 + this.f8600BNL6CD;
                    }
                    if (this.f8596BChYOn) {
                        int AmA8tU2 = AmA8tU(i4, (int) motionEvent.getX(findPointerIndex), 0, false);
                        this.f8592B3GDIM = y - AmA8tU2;
                        this.BpkvW3 += AmA8tU2;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f8596BChYOn && getChildCount() > 0 && this.f8589AzWtSf.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f8603BV3sI0 = -1;
                this.f8596BChYOn = false;
                VelocityTracker velocityTracker3 = this.f8597BI9f7h;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f8597BI9f7h = null;
                }
                B4ZgIw(0);
                this.f8590B25kr6.onRelease();
                this.f8591B2KMhB.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f8592B3GDIM = (int) motionEvent.getY(actionIndex);
                this.f8603BV3sI0 = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                AZkASS(motionEvent);
                this.f8592B3GDIM = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f8603BV3sI0));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f8596BChYOn && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f8589AzWtSf.isFinished()) {
                this.f8589AzWtSf.abortAnimation();
                B4ZgIw(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.f8592B3GDIM = y2;
            this.f8603BV3sI0 = pointerId;
            B2KMhB(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f8597BI9f7h;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f8593B4ZgIw) {
            this.f8595B9tovu = view2;
        } else {
            Rect rect = this.f8588AmA8tU;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int A4TApA2 = A4TApA(rect);
            if (A4TApA2 != 0) {
                scrollBy(0, A4TApA2);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int A4TApA2 = A4TApA(rect);
        boolean z2 = A4TApA2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, A4TApA2);
                return z2;
            }
            B25kr6(0, A4TApA2, false);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.f8597BI9f7h) != null) {
            velocityTracker.recycle();
            this.f8597BI9f7h = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f8593B4ZgIw = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i < 0) {
                i = 0;
            } else if (width + i > width2) {
                i = width2 - width;
            }
            if (height >= height2 || i2 < 0) {
                i2 = 0;
            } else if (height + i2 > height2) {
                i2 = height2 - height;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f8598BIYEnU) {
            this.f8598BIYEnU = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f8609CNPG0E.ASJ6gh(z);
    }

    public void setOnScrollChangeListener(AZkASS aZkASS) {
        this.f8611CQhlFr = aZkASS;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f8599BJ7GGh = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.f8609CNPG0E.AYUAbz(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        B4ZgIw(0);
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        A5SV6n(i, i2, iArr, null, i3);
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        AZOQYO(i4, i5, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        AZOQYO(i4, 0, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
