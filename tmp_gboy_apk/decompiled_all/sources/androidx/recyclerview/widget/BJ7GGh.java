package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BJ7GGh extends RecyclerView.AMqCpz implements DUi7mC {

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static final int[] f9248BV3sI0 = {R.attr.state_pressed};

    /* renamed from: BmvVmW, reason: collision with root package name */
    public static final int[] f9249BmvVmW = new int[0];

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f9250A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f9251A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final StateListDrawable f9252A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Drawable f9253ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f9254ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final StateListDrawable f9255ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Drawable f9256AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final int f9257AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final int f9258AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f9259AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9260AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f9261AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f9262AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f9263AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f9264B25kr6;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final RecyclerView f9267B4ZgIw;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final ValueAnimator f9274BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f9275BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final CmUvjW f9276BTvldC;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f9265B2KMhB = 0;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f9266B3GDIM = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f9268B7CMnp = false;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f9269B9tovu = false;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f9270BChYOn = 0;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f9271BI9f7h = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int[] f9272BIYEnU = new int[2];

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final int[] f9273BJ7GGh = new int[2];

    static {
        AdMfrk();
    }

    public BJ7GGh(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f9274BNL6CD = ofFloat;
        this.f9275BPw6Q8 = 0;
        CmUvjW cmUvjW = new CmUvjW(1, this);
        this.f9276BTvldC = cmUvjW;
        BI9f7h bI9f7h = new BI9f7h(this);
        this.f9252A5SV6n = stateListDrawable;
        this.f9253ADYaiT = drawable;
        this.f9255ASJ6gh = stateListDrawable2;
        this.f9256AYUAbz = drawable2;
        this.AMqCpz = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f9254ARc23Z = Math.max(i, drawable.getIntrinsicWidth());
        this.f9257AZOQYO = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f9258AZkASS = Math.max(i, drawable2.getIntrinsicWidth());
        this.f9250A2egSU = i2;
        this.f9251A4TApA = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new P8ccfD.AmA8tU(this));
        ofFloat.addUpdateListener(new BIYEnU(this));
        RecyclerView recyclerView2 = this.f9267B4ZgIw;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f9267B4ZgIw.removeOnItemTouchListener(this);
            this.f9267B4ZgIw.removeOnScrollListener(bI9f7h);
            this.f9267B4ZgIw.removeCallbacks(cmUvjW);
        }
        this.f9267B4ZgIw = recyclerView;
        recyclerView.addItemDecoration(this);
        this.f9267B4ZgIw.addOnItemTouchListener(this);
        this.f9267B4ZgIw.addOnScrollListener(bI9f7h);
    }

    public static int A5SV6n(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 != 0) {
            int i5 = i - i3;
            int i6 = (int) (((f2 - f) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 < i5 && i7 >= 0) {
                return i6;
            }
        }
        return 0;
    }

    private static /* synthetic */ void AdMfrk() {
        char[] charArray = "£¯\u00adî§¡\u00ad¥î¢¯¹î³¨¥¬¬î\u008a®©\u0082²©¤§¥".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 192);
        }
        String str = new String(charArray);
        char[] charArray2 = "£¬©®©´".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 192);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A2egSU(float f, float f2) {
        if (f2 < this.f9266B3GDIM - this.f9257AZOQYO) {
            return false;
        }
        int i = this.f9263AzWtSf;
        int i2 = this.f9262AmA8tU;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) ((i2 / 2) + i));
    }

    public final boolean A4TApA(float f, float f2) {
        RecyclerView recyclerView = this.f9267B4ZgIw;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        boolean z = recyclerView.getLayoutDirection() == 1;
        int i = this.AMqCpz;
        if (!z ? f >= this.f9265B2KMhB - i : f <= i) {
            int i2 = this.f9260AcNBzu;
            int i3 = this.f9259AaHO0E / 2;
            if (f2 >= i2 - i3 && f2 <= i3 + i2) {
                return true;
            }
        }
        return false;
    }

    public final void ADYaiT(int i) {
        CmUvjW cmUvjW = this.f9276BTvldC;
        StateListDrawable stateListDrawable = this.f9252A5SV6n;
        if (i == 2 && this.f9270BChYOn != 2) {
            stateListDrawable.setState(f9248BV3sI0);
            this.f9267B4ZgIw.removeCallbacks(cmUvjW);
        }
        if (i == 0) {
            this.f9267B4ZgIw.invalidate();
        } else {
            AMqCpz();
        }
        if (this.f9270BChYOn == 2 && i != 2) {
            stateListDrawable.setState(f9249BmvVmW);
            this.f9267B4ZgIw.removeCallbacks(cmUvjW);
            this.f9267B4ZgIw.postDelayed(cmUvjW, 1200);
        } else if (i == 1) {
            this.f9267B4ZgIw.removeCallbacks(cmUvjW);
            this.f9267B4ZgIw.postDelayed(cmUvjW, TTAdConstant.STYLE_SIZE_RADIO_3_2);
        }
        this.f9270BChYOn = i;
    }

    public final void AMqCpz() {
        int i = this.f9275BPw6Q8;
        ValueAnimator valueAnimator = this.f9274BNL6CD;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f9275BPw6Q8 = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AMqCpz
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E) {
        int i = this.f9265B2KMhB;
        RecyclerView recyclerView2 = this.f9267B4ZgIw;
        if (i != recyclerView2.getWidth() || this.f9266B3GDIM != recyclerView2.getHeight()) {
            this.f9265B2KMhB = recyclerView2.getWidth();
            this.f9266B3GDIM = recyclerView2.getHeight();
            ADYaiT(0);
            return;
        }
        if (this.f9275BPw6Q8 != 0) {
            if (this.f9268B7CMnp) {
                int i2 = this.f9265B2KMhB;
                int i3 = this.AMqCpz;
                int i4 = i2 - i3;
                int i5 = this.f9260AcNBzu;
                int i6 = this.f9259AaHO0E;
                int i7 = i5 - (i6 / 2);
                StateListDrawable stateListDrawable = this.f9252A5SV6n;
                stateListDrawable.setBounds(0, 0, i3, i6);
                int i8 = this.f9266B3GDIM;
                int i9 = this.f9254ARc23Z;
                Drawable drawable = this.f9253ADYaiT;
                drawable.setBounds(0, 0, i9, i8);
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i3, i7);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i3, -i7);
                } else {
                    canvas.translate(i4, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i7);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i4, -i7);
                }
            }
            if (this.f9269B9tovu) {
                int i10 = this.f9266B3GDIM;
                int i11 = this.f9257AZOQYO;
                int i12 = i10 - i11;
                int i13 = this.f9263AzWtSf;
                int i14 = this.f9262AmA8tU;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.f9255ASJ6gh;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.f9265B2KMhB;
                int i17 = this.f9258AZkASS;
                Drawable drawable2 = this.f9256AYUAbz;
                drawable2.setBounds(0, 0, i16, i17);
                canvas.translate(0.0f, i12);
                drawable2.draw(canvas);
                canvas.translate(i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i15, -i12);
            }
        }
    }
}
