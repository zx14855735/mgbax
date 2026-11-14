package AaHO0E;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FM663C implements AZkASS.BmvVmW {

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final Method f818CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public static final Method f819CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static final Method f820CTkVKb;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f821AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ListAdapter f822AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public EdQ5bb f823AmA8tU;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f826B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f827B3GDIM;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f829B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f830B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f831BChYOn;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public F32kj0 f834BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public View f835BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AdapterView.OnItemClickListener f836BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f837BTvldC;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final Handler f841C2rE4F;

    /* renamed from: CASmeH, reason: collision with root package name */
    public Rect f843CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f844CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final BpkvW3 f845COJEAR;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f824AzWtSf = -2;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f825B25kr6 = -2;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f828B4ZgIw = 1002;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f832BI9f7h = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int f833BIYEnU = Integer.MAX_VALUE;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final F1loUV f838BV3sI0 = new F1loUV(this, 1);

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final FG7pZc f839BmvVmW = new FG7pZc(0, this);

    /* renamed from: BniPrB, reason: collision with root package name */
    public final F508T2 f840BniPrB = new F508T2(this);
    public final F1loUV BpkvW3 = new F1loUV(this, 0);

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final Rect f842C4FrIb = new Rect();

    static {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i <= 28) {
            try {
                f818CQhlFr = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
            }
            try {
                f820CTkVKb = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f819CSDoyG = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public FM663C(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        this.f821AcNBzu = context;
        this.f841C2rE4F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8028B25kr6, i, 0);
        this.f826B2KMhB = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f827B3GDIM = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f829B7CMnp = true;
        }
        obtainStyledAttributes.recycle();
        BpkvW3 bpkvW3 = new BpkvW3(context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f8032B7CMnp, i, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            com.bumptech.glide.AMqCpz.CcAIMM(bpkvW3, obtainStyledAttributes2.getBoolean(2, false));
        }
        bpkvW3.setBackgroundDrawable((!obtainStyledAttributes2.hasValue(0) || (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) == 0) ? obtainStyledAttributes2.getDrawable(0) : NOd7IU.AlLFFp.CQhlFr(context, resourceId));
        obtainStyledAttributes2.recycle();
        this.f845COJEAR = bpkvW3;
        bpkvW3.setInputMethodMode(1);
    }

    public final int A2egSU() {
        return this.f826B2KMhB;
    }

    public final void A4TApA(int i) {
        this.f826B2KMhB = i;
    }

    public final Drawable ADYaiT() {
        return this.f845COJEAR.getBackground();
    }

    @Override // AZkASS.BmvVmW
    public final EdQ5bb AMqCpz() {
        return this.f823AmA8tU;
    }

    public final void ASJ6gh(Drawable drawable) {
        this.f845COJEAR.setBackgroundDrawable(drawable);
    }

    public final void AYUAbz(int i) {
        this.f827B3GDIM = i;
        this.f829B7CMnp = true;
    }

    public final int AcNBzu() {
        if (this.f829B7CMnp) {
            return this.f827B3GDIM;
        }
        return 0;
    }

    public void AlLFFp(ListAdapter listAdapter) {
        F32kj0 f32kj0 = this.f834BJ7GGh;
        if (f32kj0 == null) {
            this.f834BJ7GGh = new F32kj0(0, this);
        } else {
            ListAdapter listAdapter2 = this.f822AlLFFp;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(f32kj0);
            }
        }
        this.f822AlLFFp = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f834BJ7GGh);
        }
        EdQ5bb edQ5bb = this.f823AmA8tU;
        if (edQ5bb != null) {
            edQ5bb.setAdapter(this.f822AlLFFp);
        }
    }

    public EdQ5bb AmA8tU(Context context, boolean z) {
        return new EdQ5bb(context, z);
    }

    public final void AzWtSf(int i) {
        Drawable background = this.f845COJEAR.getBackground();
        if (background == null) {
            this.f825B25kr6 = i;
            return;
        }
        Rect rect = this.f842C4FrIb;
        background.getPadding(rect);
        this.f825B25kr6 = rect.left + rect.right + i;
    }

    @Override // AZkASS.BmvVmW
    public final void dismiss() {
        BpkvW3 bpkvW3 = this.f845COJEAR;
        bpkvW3.dismiss();
        bpkvW3.setContentView(null);
        this.f823AmA8tU = null;
        this.f841C2rE4F.removeCallbacks(this.f838BV3sI0);
    }

    @Override // AZkASS.BmvVmW
    public final boolean isShowing() {
        return this.f845COJEAR.isShowing();
    }

    @Override // AZkASS.BmvVmW
    public final void show() {
        int i;
        int A2egSU2;
        int paddingBottom;
        EdQ5bb edQ5bb;
        EdQ5bb edQ5bb2 = this.f823AmA8tU;
        BpkvW3 bpkvW3 = this.f845COJEAR;
        Context context = this.f821AcNBzu;
        if (edQ5bb2 == null) {
            EdQ5bb AmA8tU2 = AmA8tU(context, !this.f844CNPG0E);
            this.f823AmA8tU = AmA8tU2;
            AmA8tU2.setAdapter(this.f822AlLFFp);
            this.f823AmA8tU.setOnItemClickListener(this.f836BPw6Q8);
            this.f823AmA8tU.setFocusable(true);
            this.f823AmA8tU.setFocusableInTouchMode(true);
            this.f823AmA8tU.setOnItemSelectedListener(new EsrwYR(r2, this));
            this.f823AmA8tU.setOnScrollListener(this.f840BniPrB);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f837BTvldC;
            if (onItemSelectedListener != null) {
                this.f823AmA8tU.setOnItemSelectedListener(onItemSelectedListener);
            }
            bpkvW3.setContentView(this.f823AmA8tU);
        }
        Drawable background = bpkvW3.getBackground();
        Rect rect = this.f842C4FrIb;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.f829B7CMnp) {
                this.f827B3GDIM = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        boolean z = bpkvW3.getInputMethodMode() == 2;
        View view = this.f835BNL6CD;
        int i3 = this.f827B3GDIM;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f819CSDoyG;
            if (method != null) {
                try {
                    A2egSU2 = ((Integer) method.invoke(bpkvW3, view, Integer.valueOf(i3), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                }
            }
            A2egSU2 = bpkvW3.getMaxAvailableHeight(view, i3);
        } else {
            A2egSU2 = EwN40Z.A2egSU(bpkvW3, view, i3, z);
        }
        int i4 = this.f824AzWtSf;
        if (i4 == -1) {
            paddingBottom = A2egSU2 + i;
        } else {
            int i5 = this.f825B25kr6;
            int A2egSU3 = this.f823AmA8tU.A2egSU(i5 != -2 ? i5 != -1 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), A2egSU2);
            paddingBottom = A2egSU3 + (A2egSU3 > 0 ? this.f823AmA8tU.getPaddingBottom() + this.f823AmA8tU.getPaddingTop() + i : 0);
        }
        boolean z2 = this.f845COJEAR.getInputMethodMode() == 2;
        com.bumptech.glide.AMqCpz.CikNvS(bpkvW3, this.f828B4ZgIw);
        if (bpkvW3.isShowing()) {
            if (this.f835BNL6CD.isAttachedToWindow()) {
                int i6 = this.f825B25kr6;
                if (i6 == -1) {
                    i6 = -1;
                } else if (i6 == -2) {
                    i6 = this.f835BNL6CD.getWidth();
                }
                if (i4 == -1) {
                    i4 = z2 ? paddingBottom : -1;
                    if (z2) {
                        bpkvW3.setWidth(this.f825B25kr6 == -1 ? -1 : 0);
                        bpkvW3.setHeight(0);
                    } else {
                        bpkvW3.setWidth(this.f825B25kr6 == -1 ? -1 : 0);
                        bpkvW3.setHeight(-1);
                    }
                } else if (i4 == -2) {
                    i4 = paddingBottom;
                }
                bpkvW3.setOutsideTouchable(true);
                int i7 = i6;
                View view2 = this.f835BNL6CD;
                int i8 = this.f826B2KMhB;
                int i9 = this.f827B3GDIM;
                if (i7 < 0) {
                    i7 = -1;
                }
                bpkvW3.update(view2, i8, i9, i7, i4 < 0 ? -1 : i4);
                return;
            }
            return;
        }
        int i10 = this.f825B25kr6;
        if (i10 == -1) {
            i10 = -1;
        } else if (i10 == -2) {
            i10 = this.f835BNL6CD.getWidth();
        }
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = paddingBottom;
        }
        bpkvW3.setWidth(i10);
        bpkvW3.setHeight(i4);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f818CQhlFr;
            if (method2 != null) {
                try {
                    method2.invoke(bpkvW3, Boolean.TRUE);
                } catch (Exception unused2) {
                }
            }
        } else {
            ExjC7D.A4TApA(bpkvW3, true);
        }
        bpkvW3.setOutsideTouchable(true);
        bpkvW3.setTouchInterceptor(this.f839BmvVmW);
        if (this.f831BChYOn) {
            com.bumptech.glide.AMqCpz.CcAIMM(bpkvW3, this.f830B9tovu);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = f820CTkVKb;
            if (method3 != null) {
                try {
                    method3.invoke(bpkvW3, this.f843CASmeH);
                } catch (Exception unused3) {
                }
            }
        } else {
            ExjC7D.A2egSU(bpkvW3, this.f843CASmeH);
        }
        bpkvW3.showAsDropDown(this.f835BNL6CD, this.f826B2KMhB, this.f827B3GDIM, this.f832BI9f7h);
        this.f823AmA8tU.setSelection(-1);
        if ((!this.f844CNPG0E || this.f823AmA8tU.isInTouchMode()) && (edQ5bb = this.f823AmA8tU) != null) {
            edQ5bb.setListSelectionHidden(true);
            edQ5bb.requestLayout();
        }
        if (this.f844CNPG0E) {
            return;
        }
        this.f841C2rE4F.post(this.BpkvW3);
    }
}
