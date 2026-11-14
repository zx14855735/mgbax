package ARc23Z;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.StateSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E extends Drawable.ConstantState {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AcNBzu f315A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Resources f316A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f317A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f318ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public SparseArray f319ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Drawable[] f320ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f321AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f322AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f323AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public Rect f324AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f325AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f326AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f327AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f328AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f329B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f330B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f331B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f332B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f333B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f334B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f335BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f336BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f337BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f338BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f339BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f340BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f341BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public ColorFilter f342BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f343BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public ColorStateList f344BniPrB;
    public PorterDuff.Mode BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f345C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f346C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int[][] f347CASmeH;

    public AaHO0E(AaHO0E aaHO0E, AcNBzu acNBzu, Resources resources) {
        this.f322AZOQYO = false;
        this.f325AcNBzu = false;
        this.f337BIYEnU = true;
        this.f339BNL6CD = 0;
        this.f340BPw6Q8 = 0;
        this.f315A2egSU = acNBzu;
        this.f316A4TApA = resources != null ? resources : aaHO0E != null ? aaHO0E.f316A4TApA : null;
        int i = aaHO0E != null ? aaHO0E.f317A5SV6n : 0;
        int i2 = AYUAbz.f290BIYEnU;
        i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
        i = i == 0 ? 160 : i;
        this.f317A5SV6n = i;
        if (aaHO0E != null) {
            this.f318ADYaiT = aaHO0E.f318ADYaiT;
            this.AMqCpz = aaHO0E.AMqCpz;
            this.f335BChYOn = true;
            this.f336BI9f7h = true;
            this.f322AZOQYO = aaHO0E.f322AZOQYO;
            this.f325AcNBzu = aaHO0E.f325AcNBzu;
            this.f337BIYEnU = aaHO0E.f337BIYEnU;
            this.f338BJ7GGh = aaHO0E.f338BJ7GGh;
            this.f339BNL6CD = aaHO0E.f339BNL6CD;
            this.f340BPw6Q8 = aaHO0E.f340BPw6Q8;
            this.f341BTvldC = aaHO0E.f341BTvldC;
            this.f342BV3sI0 = aaHO0E.f342BV3sI0;
            this.f343BmvVmW = aaHO0E.f343BmvVmW;
            this.f344BniPrB = aaHO0E.f344BniPrB;
            this.BpkvW3 = aaHO0E.BpkvW3;
            this.f345C2rE4F = aaHO0E.f345C2rE4F;
            this.f346C4FrIb = aaHO0E.f346C4FrIb;
            if (aaHO0E.f317A5SV6n == i) {
                if (aaHO0E.f323AZkASS) {
                    this.f324AaHO0E = aaHO0E.f324AaHO0E != null ? new Rect(aaHO0E.f324AaHO0E) : null;
                    this.f323AZkASS = true;
                }
                if (aaHO0E.f326AlLFFp) {
                    this.f327AmA8tU = aaHO0E.f327AmA8tU;
                    this.f328AzWtSf = aaHO0E.f328AzWtSf;
                    this.f329B25kr6 = aaHO0E.f329B25kr6;
                    this.f330B2KMhB = aaHO0E.f330B2KMhB;
                    this.f326AlLFFp = true;
                }
            }
            if (aaHO0E.f331B3GDIM) {
                this.f332B4ZgIw = aaHO0E.f332B4ZgIw;
                this.f331B3GDIM = true;
            }
            if (aaHO0E.f333B7CMnp) {
                this.f334B9tovu = aaHO0E.f334B9tovu;
                this.f333B7CMnp = true;
            }
            Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
            this.f320ASJ6gh = new Drawable[drawableArr.length];
            this.f321AYUAbz = aaHO0E.f321AYUAbz;
            SparseArray sparseArray = aaHO0E.f319ARc23Z;
            if (sparseArray != null) {
                this.f319ARc23Z = sparseArray.clone();
            } else {
                this.f319ARc23Z = new SparseArray(this.f321AYUAbz);
            }
            int i3 = this.f321AYUAbz;
            for (int i4 = 0; i4 < i3; i4++) {
                Drawable drawable = drawableArr[i4];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f319ARc23Z.put(i4, constantState);
                    } else {
                        this.f320ASJ6gh[i4] = drawableArr[i4];
                    }
                }
            }
        } else {
            this.f320ASJ6gh = new Drawable[10];
            this.f321AYUAbz = 0;
        }
        if (aaHO0E != null) {
            this.f347CASmeH = aaHO0E.f347CASmeH;
        } else {
            this.f347CASmeH = new int[this.f320ASJ6gh.length][];
        }
    }

    public final int A2egSU(Drawable drawable) {
        int i = this.f321AYUAbz;
        Drawable[] drawableArr = this.f320ASJ6gh;
        if (i >= drawableArr.length) {
            int i2 = i + 10;
            Drawable[] drawableArr2 = new Drawable[i2];
            System.arraycopy(drawableArr, 0, drawableArr2, 0, i);
            this.f320ASJ6gh = drawableArr2;
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f347CASmeH, 0, iArr, 0, i);
            this.f347CASmeH = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f315A2egSU);
        this.f320ASJ6gh[i] = drawable;
        this.f321AYUAbz++;
        this.AMqCpz = drawable.getChangingConfigurations() | this.AMqCpz;
        this.f331B3GDIM = false;
        this.f333B7CMnp = false;
        this.f324AaHO0E = null;
        this.f323AZkASS = false;
        this.f326AlLFFp = false;
        this.f335BChYOn = false;
        return i;
    }

    public final void A4TApA() {
        this.f326AlLFFp = true;
        A5SV6n();
        int i = this.f321AYUAbz;
        Drawable[] drawableArr = this.f320ASJ6gh;
        this.f328AzWtSf = -1;
        this.f327AmA8tU = -1;
        this.f330B2KMhB = 0;
        this.f329B25kr6 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f327AmA8tU) {
                this.f327AmA8tU = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f328AzWtSf) {
                this.f328AzWtSf = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f329B25kr6) {
                this.f329B25kr6 = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f330B2KMhB) {
                this.f330B2KMhB = minimumHeight;
            }
        }
    }

    public final void A5SV6n() {
        SparseArray sparseArray = this.f319ARc23Z;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.f319ARc23Z.keyAt(i);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f319ARc23Z.valueAt(i);
                Drawable[] drawableArr = this.f320ASJ6gh;
                Drawable newDrawable = constantState.newDrawable(this.f316A4TApA);
                if (Build.VERSION.SDK_INT >= 23) {
                    com.bumptech.glide.A5SV6n.D8cQ8b(newDrawable, this.f338BJ7GGh);
                }
                Drawable mutate = newDrawable.mutate();
                mutate.setCallback(this.f315A2egSU);
                drawableArr[keyAt] = mutate;
            }
            this.f319ARc23Z = null;
        }
    }

    public final Drawable ADYaiT(int i) {
        int indexOfKey;
        Drawable drawable = this.f320ASJ6gh[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f319ARc23Z;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable newDrawable = ((Drawable.ConstantState) this.f319ARc23Z.valueAt(indexOfKey)).newDrawable(this.f316A4TApA);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.A5SV6n.D8cQ8b(newDrawable, this.f338BJ7GGh);
        }
        Drawable mutate = newDrawable.mutate();
        mutate.setCallback(this.f315A2egSU);
        this.f320ASJ6gh[i] = mutate;
        this.f319ARc23Z.removeAt(indexOfKey);
        if (this.f319ARc23Z.size() == 0) {
            this.f319ARc23Z = null;
        }
        return mutate;
    }

    public final int AMqCpz(int[] iArr) {
        int[][] iArr2 = this.f347CASmeH;
        int i = this.f321AYUAbz;
        for (int i2 = 0; i2 < i; i2++) {
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                return i2;
            }
        }
        return -1;
    }

    public void ARc23Z() {
        int[][] iArr = this.f347CASmeH;
        int[][] iArr2 = new int[iArr.length][];
        for (int length = iArr.length - 1; length >= 0; length--) {
            int[] iArr3 = this.f347CASmeH[length];
            iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
        }
        this.f347CASmeH = iArr2;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i = this.f321AYUAbz;
        Drawable[] drawableArr = this.f320ASJ6gh;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f319ARc23Z.get(i2);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (BmvVmW.A2egSU.A4TApA(drawable)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f318ADYaiT | this.AMqCpz;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new AcNBzu(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new AcNBzu(this, resources);
    }
}
