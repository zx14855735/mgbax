package ARc23Z;

import ADYaiT.D8MqeW;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz extends Drawable implements Drawable.Callback {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final /* synthetic */ int f290BIYEnU = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AaHO0E f291AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Rect f292AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Drawable f293AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Drawable f294AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f296B2KMhB;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f298B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public D8MqeW f299B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public long f300B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public long f301BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ASJ6gh f302BI9f7h;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f295B25kr6 = 255;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f297B3GDIM = -1;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f296B2KMhB = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f293AmA8tU
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f300B9tovu
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f295B25kr6
            r3.setAlpha(r9)
            r13.f300B9tovu = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            ARc23Z.AaHO0E r9 = r13.f291AcNBzu
            int r9 = r9.f339BNL6CD
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f295B25kr6
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f300B9tovu = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f294AzWtSf
            if (r9 == 0) goto L65
            long r10 = r13.f301BChYOn
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f294AzWtSf = r0
            r13.f301BChYOn = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            ARc23Z.AaHO0E r4 = r13.f291AcNBzu
            int r4 = r4.f340BPw6Q8
            int r3 = r3 / r4
            int r4 = r13.f295B25kr6
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f301BChYOn = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            ADYaiT.D8MqeW r14 = r13.f299B7CMnp
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ARc23Z.AYUAbz.A2egSU(boolean):void");
    }

    public AaHO0E A4TApA() {
        return this.f291AcNBzu;
    }

    public final void A5SV6n(Drawable drawable) {
        if (this.f302BI9f7h == null) {
            this.f302BI9f7h = new ASJ6gh();
        }
        ASJ6gh aSJ6gh = this.f302BI9f7h;
        aSJ6gh.f289AlLFFp = drawable.getCallback();
        drawable.setCallback(aSJ6gh);
        try {
            if (this.f291AcNBzu.f339BNL6CD <= 0 && this.f296B2KMhB) {
                drawable.setAlpha(this.f295B25kr6);
            }
            AaHO0E aaHO0E = this.f291AcNBzu;
            if (aaHO0E.f343BmvVmW) {
                drawable.setColorFilter(aaHO0E.f342BV3sI0);
            } else {
                if (aaHO0E.f345C2rE4F) {
                    BmvVmW.A2egSU.AYUAbz(drawable, aaHO0E.f344BniPrB);
                }
                AaHO0E aaHO0E2 = this.f291AcNBzu;
                if (aaHO0E2.f346C4FrIb) {
                    BmvVmW.A2egSU.AZOQYO(drawable, aaHO0E2.BpkvW3);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f291AcNBzu.f337BIYEnU);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                com.bumptech.glide.A5SV6n.D8cQ8b(drawable, com.bumptech.glide.A5SV6n.BPw6Q8(this));
            }
            drawable.setAutoMirrored(this.f291AcNBzu.f341BTvldC);
            Rect rect = this.f292AlLFFp;
            if (rect != null) {
                BmvVmW.A2egSU.ARc23Z(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            ASJ6gh aSJ6gh2 = this.f302BI9f7h;
            Drawable.Callback callback = (Drawable.Callback) aSJ6gh2.f289AlLFFp;
            aSJ6gh2.f289AlLFFp = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            ASJ6gh aSJ6gh3 = this.f302BI9f7h;
            Drawable.Callback callback2 = (Drawable.Callback) aSJ6gh3.f289AlLFFp;
            aSJ6gh3.f289AlLFFp = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ADYaiT(int r10) {
        /*
            r9 = this;
            int r0 = r9.f297B3GDIM
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            ARc23Z.AaHO0E r0 = r9.f291AcNBzu
            int r0 = r0.f340BPw6Q8
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f294AzWtSf
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f293AmA8tU
            if (r0 == 0) goto L29
            r9.f294AzWtSf = r0
            ARc23Z.AaHO0E r0 = r9.f291AcNBzu
            int r0 = r0.f340BPw6Q8
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f301BChYOn = r0
            goto L35
        L29:
            r9.f294AzWtSf = r4
            r9.f301BChYOn = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f293AmA8tU
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            ARc23Z.AaHO0E r0 = r9.f291AcNBzu
            int r1 = r0.f321AYUAbz
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.ADYaiT(r10)
            r9.f293AmA8tU = r0
            r9.f297B3GDIM = r10
            if (r0 == 0) goto L5a
            ARc23Z.AaHO0E r10 = r9.f291AcNBzu
            int r10 = r10.f339BNL6CD
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f300B9tovu = r2
        L51:
            r9.A5SV6n(r0)
            goto L5a
        L55:
            r9.f293AmA8tU = r4
            r10 = -1
            r9.f297B3GDIM = r10
        L5a:
            long r0 = r9.f300B9tovu
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f301BChYOn
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L7d
        L67:
            ADYaiT.D8MqeW r0 = r9.f299B7CMnp
            if (r0 != 0) goto L77
            ADYaiT.D8MqeW r0 = new ADYaiT.D8MqeW
            r1 = r9
            ARc23Z.AcNBzu r1 = (ARc23Z.AcNBzu) r1
            r2 = 1
            r0.<init>(r2, r1)
            r9.f299B7CMnp = r0
            goto L7a
        L77:
            r9.unscheduleSelf(r0)
        L7a:
            r9.A2egSU(r10)
        L7d:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ARc23Z.AYUAbz.ADYaiT(int):boolean");
    }

    public void AMqCpz(AaHO0E aaHO0E) {
        this.f291AcNBzu = aaHO0E;
        int i = this.f297B3GDIM;
        if (i >= 0) {
            Drawable ADYaiT2 = aaHO0E.ADYaiT(i);
            this.f293AmA8tU = ADYaiT2;
            if (ADYaiT2 != null) {
                A5SV6n(ADYaiT2);
            }
        }
        this.f294AzWtSf = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (theme == null) {
            aaHO0E.getClass();
            return;
        }
        aaHO0E.A5SV6n();
        int i = aaHO0E.f321AYUAbz;
        Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null && BmvVmW.A2egSU.A4TApA(drawable)) {
                BmvVmW.A2egSU.A2egSU(drawableArr[i2], theme);
                aaHO0E.AMqCpz |= drawableArr[i2].getChangingConfigurations();
            }
        }
        Resources resources = ARc23Z.getResources(theme);
        if (resources != null) {
            aaHO0E.f316A4TApA = resources;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            int i4 = aaHO0E.f317A5SV6n;
            aaHO0E.f317A5SV6n = i3;
            if (i4 != i3) {
                aaHO0E.f326AlLFFp = false;
                aaHO0E.f323AZkASS = false;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.f291AcNBzu.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f294AzWtSf;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f295B25kr6;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f291AcNBzu.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (!aaHO0E.f335BChYOn) {
            aaHO0E.A5SV6n();
            aaHO0E.f335BChYOn = true;
            int i = aaHO0E.f321AYUAbz;
            Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    aaHO0E.f336BI9f7h = true;
                    z = true;
                    break;
                }
                if (drawableArr[i2].getConstantState() == null) {
                    aaHO0E.f336BI9f7h = false;
                    z = false;
                    break;
                }
                i2++;
            }
        } else {
            z = aaHO0E.f336BI9f7h;
        }
        if (!z) {
            return null;
        }
        this.f291AcNBzu.f318ADYaiT = getChangingConfigurations();
        return this.f291AcNBzu;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f293AmA8tU;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f292AlLFFp;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f325AcNBzu) {
            if (!aaHO0E.f326AlLFFp) {
                aaHO0E.A4TApA();
            }
            return aaHO0E.f328AzWtSf;
        }
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f325AcNBzu) {
            if (!aaHO0E.f326AlLFFp) {
                aaHO0E.A4TApA();
            }
            return aaHO0E.f327AmA8tU;
        }
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f325AcNBzu) {
            if (!aaHO0E.f326AlLFFp) {
                aaHO0E.A4TApA();
            }
            return aaHO0E.f330B2KMhB;
        }
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f325AcNBzu) {
            if (!aaHO0E.f326AlLFFp) {
                aaHO0E.A4TApA();
            }
            return aaHO0E.f329B25kr6;
        }
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null && drawable.isVisible()) {
            AaHO0E aaHO0E = this.f291AcNBzu;
            if (aaHO0E.f331B3GDIM) {
                return aaHO0E.f332B4ZgIw;
            }
            aaHO0E.A5SV6n();
            int i = aaHO0E.f321AYUAbz;
            Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
            r1 = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                r1 = Drawable.resolveOpacity(r1, drawableArr[i2].getOpacity());
            }
            aaHO0E.f332B4ZgIw = r1;
            aaHO0E.f331B3GDIM = true;
        }
        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        boolean z = false;
        Rect rect2 = null;
        if (!aaHO0E.f322AZOQYO) {
            Rect rect3 = aaHO0E.f324AaHO0E;
            if (rect3 != null || aaHO0E.f323AZkASS) {
                rect2 = rect3;
            } else {
                aaHO0E.A5SV6n();
                Rect rect4 = new Rect();
                int i = aaHO0E.f321AYUAbz;
                Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                aaHO0E.f323AZkASS = true;
                aaHO0E.f324AaHO0E = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z = true;
            }
        } else {
            Drawable drawable = this.f293AmA8tU;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f291AcNBzu.f341BTvldC && com.bumptech.glide.A5SV6n.BPw6Q8(this) == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E != null) {
            aaHO0E.f331B3GDIM = false;
            aaHO0E.f333B7CMnp = false;
        }
        if (drawable != this.f293AmA8tU || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f291AcNBzu.f341BTvldC;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f333B7CMnp) {
            return aaHO0E.f334B9tovu;
        }
        aaHO0E.A5SV6n();
        int i = aaHO0E.f321AYUAbz;
        Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (drawableArr[i2].isStateful()) {
                z = true;
                break;
            }
            i2++;
        }
        aaHO0E.f334B9tovu = z;
        aaHO0E.f333B7CMnp = true;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f294AzWtSf;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f294AzWtSf = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f293AmA8tU;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f296B2KMhB) {
                this.f293AmA8tU.setAlpha(this.f295B25kr6);
            }
        }
        if (this.f301BChYOn != 0) {
            this.f301BChYOn = 0L;
            z = true;
        }
        if (this.f300B9tovu != 0) {
            this.f300B9tovu = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f298B4ZgIw && super.mutate() == this) {
            AaHO0E A4TApA2 = A4TApA();
            A4TApA2.ARc23Z();
            AMqCpz(A4TApA2);
            this.f298B4ZgIw = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f294AzWtSf;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f293AmA8tU;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        int i2 = this.f297B3GDIM;
        int i3 = aaHO0E.f321AYUAbz;
        Drawable[] drawableArr = aaHO0E.f320ASJ6gh;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean D8cQ8b2 = Build.VERSION.SDK_INT >= 23 ? com.bumptech.glide.A5SV6n.D8cQ8b(drawable, i) : false;
                if (i4 == i2) {
                    z = D8cQ8b2;
                }
            }
        }
        aaHO0E.f338BJ7GGh = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f294AzWtSf;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f293AmA8tU;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f294AzWtSf;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f293AmA8tU;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f293AmA8tU || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f296B2KMhB && this.f295B25kr6 == i) {
            return;
        }
        this.f296B2KMhB = true;
        this.f295B25kr6 = i;
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            if (this.f300B9tovu == 0) {
                drawable.setAlpha(i);
            } else {
                A2egSU(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f341BTvldC != z) {
            aaHO0E.f341BTvldC = z;
            Drawable drawable = this.f293AmA8tU;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        aaHO0E.f343BmvVmW = true;
        if (aaHO0E.f342BV3sI0 != colorFilter) {
            aaHO0E.f342BV3sI0 = colorFilter;
            Drawable drawable = this.f293AmA8tU;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        if (aaHO0E.f337BIYEnU != z) {
            aaHO0E.f337BIYEnU = z;
            Drawable drawable = this.f293AmA8tU;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            BmvVmW.A2egSU.AMqCpz(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f292AlLFFp;
        if (rect == null) {
            this.f292AlLFFp = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f293AmA8tU;
        if (drawable != null) {
            BmvVmW.A2egSU.ARc23Z(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        aaHO0E.f345C2rE4F = true;
        if (aaHO0E.f344BniPrB != colorStateList) {
            aaHO0E.f344BniPrB = colorStateList;
            com.bumptech.glide.A5SV6n.DAk1zC(this.f293AmA8tU, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        AaHO0E aaHO0E = this.f291AcNBzu;
        aaHO0E.f346C4FrIb = true;
        if (aaHO0E.BpkvW3 != mode) {
            aaHO0E.BpkvW3 = mode;
            com.bumptech.glide.A5SV6n.DG07BK(this.f293AmA8tU, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f294AzWtSf;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f293AmA8tU;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f293AmA8tU || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
