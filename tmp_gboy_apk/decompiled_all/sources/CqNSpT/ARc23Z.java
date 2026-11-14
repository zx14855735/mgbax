package CqNSpT;

import ADYaiT.D8MqeW;
import COJEAR.DG07BK;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final ADYaiT f1836BIYEnU = new ADYaiT(0);

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1837A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1838A4TApA;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float[] f1840ADYaiT;
    public float[] AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float[] f1841ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float[] f1842ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int[] f1843AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int[] f1844AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int[] f1845AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f1846AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public VelocityTracker f1847AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final float f1848AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f1849AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1850AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f1851B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f1852B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final OverScroller f1853B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final AMqCpz f1854B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public View f1855B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f1856B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ViewGroup f1857BChYOn;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1839A5SV6n = -1;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final D8MqeW f1858BI9f7h = new D8MqeW(6, this);

    static {
        UOeqym();
    }

    public ARc23Z(Context context, ViewGroup viewGroup, AMqCpz aMqCpz) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aMqCpz == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1857BChYOn = viewGroup;
        this.f1854B4ZgIw = aMqCpz;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1851B25kr6 = i;
        this.f1850AzWtSf = i;
        this.f1838A4TApA = viewConfiguration.getScaledTouchSlop();
        this.f1848AlLFFp = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1849AmA8tU = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1853B3GDIM = new OverScroller(context, f1836BIYEnU);
    }

    private static /* synthetic */ void UOeqym() {
        char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 2);
        }
        String str = new String(charArray);
        char[] charArray2 = "anklkv".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 2);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        this.f1839A5SV6n = -1;
        float[] fArr = this.f1840ADYaiT;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.AMqCpz, 0.0f);
            Arrays.fill(this.f1841ARc23Z, 0.0f);
            Arrays.fill(this.f1842ASJ6gh, 0.0f);
            Arrays.fill(this.f1843AYUAbz, 0);
            Arrays.fill(this.f1844AZOQYO, 0);
            Arrays.fill(this.f1845AZkASS, 0);
            this.f1846AaHO0E = 0;
        }
        VelocityTracker velocityTracker = this.f1847AcNBzu;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1847AcNBzu = null;
        }
    }

    public final void A4TApA(View view, int i) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f1857BChYOn;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f1855B7CMnp = view;
        this.f1839A5SV6n = i;
        this.f1854B4ZgIw.ASJ6gh(i, view);
        AzWtSf(1);
    }

    public final boolean A5SV6n(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1843AYUAbz[i] & i2) != i2 || (this.f1852B2KMhB & i2) == 0 || (this.f1845AZkASS[i] & i2) == i2 || (this.f1844AZOQYO[i] & i2) == i2) {
            return false;
        }
        float f3 = this.f1838A4TApA;
        if (abs <= f3 && abs2 <= f3) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.f1854B4ZgIw.getClass();
        }
        return (this.f1844AZOQYO[i] & i2) == 0 && abs > ((float) this.f1838A4TApA);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ADYaiT(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L48
        L4:
            CqNSpT.AMqCpz r1 = r3.f1854B4ZgIw
            int r4 = r1.A5SV6n(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = 1
            goto L10
        Lf:
            r4 = 0
        L10:
            int r1 = r1.ADYaiT()
            if (r1 <= 0) goto L18
            r1 = 1
            goto L19
        L18:
            r1 = 0
        L19:
            if (r4 == 0) goto L2c
            if (r1 == 0) goto L2c
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f1838A4TApA
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L48
            goto L47
        L2c:
            if (r4 == 0) goto L3a
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f1838A4TApA
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L48
            goto L47
        L3a:
            if (r1 == 0) goto L48
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f1838A4TApA
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L48
        L47:
            return r2
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: CqNSpT.ARc23Z.ADYaiT(android.view.View, float, float):boolean");
    }

    public final void AMqCpz(int i) {
        float[] fArr = this.f1840ADYaiT;
        if (fArr != null) {
            int i2 = this.f1846AaHO0E;
            int i3 = 1 << i;
            if ((i2 & i3) != 0) {
                fArr[i] = 0.0f;
                this.AMqCpz[i] = 0.0f;
                this.f1841ARc23Z[i] = 0.0f;
                this.f1842ASJ6gh[i] = 0.0f;
                this.f1843AYUAbz[i] = 0;
                this.f1844AZOQYO[i] = 0;
                this.f1845AZkASS[i] = 0;
                this.f1846AaHO0E = (~i3) & i2;
            }
        }
    }

    public final int ARc23Z(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        float width = this.f1857BChYOn.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final boolean ASJ6gh() {
        if (this.f1837A2egSU == 2) {
            OverScroller overScroller = this.f1853B3GDIM;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f1855B7CMnp.getLeft();
            int top = currY - this.f1855B7CMnp.getTop();
            if (left != 0) {
                DG07BK.AcNBzu(left, this.f1855B7CMnp);
            }
            if (top != 0) {
                DG07BK.AlLFFp(top, this.f1855B7CMnp);
            }
            if (left != 0 || top != 0) {
                this.f1854B4ZgIw.AZOQYO(this.f1855B7CMnp, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f1857BChYOn.post(this.f1858BI9f7h);
            }
        }
        return this.f1837A2egSU == 2;
    }

    public final View AYUAbz(int i, int i2) {
        ViewGroup viewGroup = this.f1857BChYOn;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f1854B4ZgIw.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean AZOQYO(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.f1855B7CMnp.getLeft();
        int top = this.f1855B7CMnp.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.f1853B3GDIM;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            AzWtSf(0);
            return false;
        }
        View view = this.f1855B7CMnp;
        int i7 = (int) this.f1849AmA8tU;
        int i8 = (int) this.f1848AlLFFp;
        int abs = Math.abs(i3);
        if (abs < i7) {
            i3 = 0;
        } else if (abs > i8) {
            i3 = i3 > 0 ? i8 : -i8;
        }
        int i9 = (int) this.f1849AmA8tU;
        int abs2 = Math.abs(i4);
        if (abs2 < i9) {
            i4 = 0;
        } else if (abs2 > i8) {
            i4 = i4 > 0 ? i8 : -i8;
        }
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int abs5 = Math.abs(i3);
        int abs6 = Math.abs(i4);
        int i10 = abs5 + abs6;
        int i11 = abs3 + abs4;
        if (i3 != 0) {
            f = abs5;
            f2 = i10;
        } else {
            f = abs3;
            f2 = i11;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = abs6;
            f4 = i10;
        } else {
            f3 = abs4;
            f4 = i11;
        }
        float f6 = f3 / f4;
        AMqCpz aMqCpz = this.f1854B4ZgIw;
        overScroller.startScroll(left, top, i5, i6, (int) ((ARc23Z(i6, i4, aMqCpz.ADYaiT()) * f6) + (ARc23Z(i5, i3, aMqCpz.A5SV6n(view)) * f5)));
        AzWtSf(2);
        return true;
    }

    public final void AZkASS(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            A2egSU();
        }
        if (this.f1847AcNBzu == null) {
            this.f1847AcNBzu = VelocityTracker.obtain();
        }
        this.f1847AcNBzu.addMovement(motionEvent);
        AMqCpz aMqCpz = this.f1854B4ZgIw;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View AYUAbz2 = AYUAbz((int) x, (int) y);
            AlLFFp(x, y, pointerId);
            B4ZgIw(pointerId, AYUAbz2);
            if ((this.f1843AYUAbz[pointerId] & this.f1852B2KMhB) != 0) {
                aMqCpz.ARc23Z();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1837A2egSU == 1) {
                AaHO0E();
            }
            A2egSU();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1837A2egSU != 1) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    int pointerId2 = motionEvent.getPointerId(i2);
                    if ((this.f1846AaHO0E & (1 << pointerId2)) != 0) {
                        float x2 = motionEvent.getX(i2);
                        float y2 = motionEvent.getY(i2);
                        float f = x2 - this.f1840ADYaiT[pointerId2];
                        float f2 = y2 - this.AMqCpz[pointerId2];
                        AcNBzu(f, f2, pointerId2);
                        if (this.f1837A2egSU == 1) {
                            break;
                        }
                        View AYUAbz3 = AYUAbz((int) x2, (int) y2);
                        if (ADYaiT(AYUAbz3, f, f2) && B4ZgIw(pointerId2, AYUAbz3)) {
                            break;
                        }
                    }
                }
                AmA8tU(motionEvent);
                return;
            }
            int i3 = this.f1839A5SV6n;
            if (((this.f1846AaHO0E & (1 << i3)) != 0 ? 1 : 0) == 0) {
                return;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i3);
            float x3 = motionEvent.getX(findPointerIndex);
            float y3 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f1841ARc23Z;
            int i4 = this.f1839A5SV6n;
            int i5 = (int) (x3 - fArr[i4]);
            int i6 = (int) (y3 - this.f1842ASJ6gh[i4]);
            int left = this.f1855B7CMnp.getLeft() + i5;
            int top = this.f1855B7CMnp.getTop() + i6;
            int left2 = this.f1855B7CMnp.getLeft();
            int top2 = this.f1855B7CMnp.getTop();
            if (i5 != 0) {
                left = aMqCpz.A2egSU(left, this.f1855B7CMnp);
                DG07BK.AcNBzu(left - left2, this.f1855B7CMnp);
            }
            if (i6 != 0) {
                top = aMqCpz.A4TApA(top, this.f1855B7CMnp);
                DG07BK.AlLFFp(top - top2, this.f1855B7CMnp);
            }
            if (i5 != 0 || i6 != 0) {
                aMqCpz.AZOQYO(this.f1855B7CMnp, left, top);
            }
            AmA8tU(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f1837A2egSU == 1) {
                this.f1856B9tovu = true;
                aMqCpz.AZkASS(this.f1855B7CMnp, 0.0f, 0.0f);
                this.f1856B9tovu = false;
                if (this.f1837A2egSU == 1) {
                    AzWtSf(0);
                }
            }
            A2egSU();
            return;
        }
        if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f1837A2egSU == 1 && pointerId3 == this.f1839A5SV6n) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (r3 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(r3);
                    if (pointerId4 != this.f1839A5SV6n) {
                        View AYUAbz4 = AYUAbz((int) motionEvent.getX(r3), (int) motionEvent.getY(r3));
                        View view = this.f1855B7CMnp;
                        if (AYUAbz4 == view && B4ZgIw(pointerId4, view)) {
                            i = this.f1839A5SV6n;
                            break;
                        }
                    }
                    r3++;
                }
                if (i == -1) {
                    AaHO0E();
                }
            }
            AMqCpz(pointerId3);
            return;
        }
        int pointerId5 = motionEvent.getPointerId(actionIndex);
        float x4 = motionEvent.getX(actionIndex);
        float y4 = motionEvent.getY(actionIndex);
        AlLFFp(x4, y4, pointerId5);
        if (this.f1837A2egSU == 0) {
            B4ZgIw(pointerId5, AYUAbz((int) x4, (int) y4));
            if ((this.f1843AYUAbz[pointerId5] & this.f1852B2KMhB) != 0) {
                aMqCpz.ARc23Z();
                return;
            }
            return;
        }
        int i7 = (int) x4;
        int i8 = (int) y4;
        View view2 = this.f1855B7CMnp;
        if (view2 != null && i7 >= view2.getLeft() && i7 < view2.getRight() && i8 >= view2.getTop() && i8 < view2.getBottom()) {
            r3 = 1;
        }
        if (r3 != 0) {
            B4ZgIw(pointerId5, this.f1855B7CMnp);
        }
    }

    public final void AaHO0E() {
        VelocityTracker velocityTracker = this.f1847AcNBzu;
        float f = this.f1848AlLFFp;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.f1847AcNBzu.getXVelocity(this.f1839A5SV6n);
        float f2 = this.f1849AmA8tU;
        float abs = Math.abs(xVelocity);
        if (abs < f2) {
            xVelocity = 0.0f;
        } else if (abs > f) {
            xVelocity = xVelocity > 0.0f ? f : -f;
        }
        float yVelocity = this.f1847AcNBzu.getYVelocity(this.f1839A5SV6n);
        float f3 = this.f1849AmA8tU;
        float abs2 = Math.abs(yVelocity);
        if (abs2 < f3) {
            f = 0.0f;
        } else if (abs2 <= f) {
            f = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f = -f;
        }
        this.f1856B9tovu = true;
        this.f1854B4ZgIw.AZkASS(this.f1855B7CMnp, xVelocity, f);
        this.f1856B9tovu = false;
        if (this.f1837A2egSU == 1) {
            AzWtSf(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [CqNSpT.AMqCpz] */
    public final void AcNBzu(float f, float f2, int i) {
        boolean A5SV6n2 = A5SV6n(f, f2, i, 1);
        boolean z = A5SV6n2;
        if (A5SV6n(f2, f, i, 4)) {
            z = (A5SV6n2 ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (A5SV6n(f, f2, i, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (A5SV6n(f2, f, i, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.f1844AZOQYO;
            iArr[i] = iArr[i] | r0;
            this.f1854B4ZgIw.AMqCpz(r0, i);
        }
    }

    public final void AlLFFp(float f, float f2, int i) {
        float[] fArr = this.f1840ADYaiT;
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
                float[] fArr6 = this.AMqCpz;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1841ARc23Z;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1842ASJ6gh;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1843AYUAbz;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1844AZOQYO;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1845AZkASS;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1840ADYaiT = fArr2;
            this.AMqCpz = fArr3;
            this.f1841ARc23Z = fArr4;
            this.f1842ASJ6gh = fArr5;
            this.f1843AYUAbz = iArr;
            this.f1844AZOQYO = iArr2;
            this.f1845AZkASS = iArr3;
        }
        float[] fArr9 = this.f1840ADYaiT;
        this.f1841ARc23Z[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.AMqCpz;
        this.f1842ASJ6gh[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.f1843AYUAbz;
        int i3 = (int) f;
        int i4 = (int) f2;
        ViewGroup viewGroup = this.f1857BChYOn;
        int i5 = i3 < viewGroup.getLeft() + this.f1850AzWtSf ? 1 : 0;
        if (i4 < viewGroup.getTop() + this.f1850AzWtSf) {
            i5 |= 4;
        }
        if (i3 > viewGroup.getRight() - this.f1850AzWtSf) {
            i5 |= 2;
        }
        if (i4 > viewGroup.getBottom() - this.f1850AzWtSf) {
            i5 |= 8;
        }
        iArr7[i] = i5;
        this.f1846AaHO0E |= 1 << i;
    }

    public final void AmA8tU(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if ((this.f1846AaHO0E & (1 << pointerId)) != 0) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1841ARc23Z[pointerId] = x;
                this.f1842ASJ6gh[pointerId] = y;
            }
        }
    }

    public final void AzWtSf(int i) {
        this.f1857BChYOn.removeCallbacks(this.f1858BI9f7h);
        if (this.f1837A2egSU != i) {
            this.f1837A2egSU = i;
            this.f1854B4ZgIw.AYUAbz(i);
            if (this.f1837A2egSU == 0) {
                this.f1855B7CMnp = null;
            }
        }
    }

    public final boolean B25kr6(int i, int i2) {
        if (this.f1856B9tovu) {
            return AZOQYO(i, i2, (int) this.f1847AcNBzu.getXVelocity(this.f1839A5SV6n), (int) this.f1847AcNBzu.getYVelocity(this.f1839A5SV6n));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d4, code lost:
    
        if (r13 != r12) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B2KMhB(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: CqNSpT.ARc23Z.B2KMhB(android.view.MotionEvent):boolean");
    }

    public final boolean B3GDIM(View view, int i, int i2) {
        this.f1855B7CMnp = view;
        this.f1839A5SV6n = -1;
        boolean AZOQYO2 = AZOQYO(i, i2, 0, 0);
        if (!AZOQYO2 && this.f1837A2egSU == 0 && this.f1855B7CMnp != null) {
            this.f1855B7CMnp = null;
        }
        return AZOQYO2;
    }

    public final boolean B4ZgIw(int i, View view) {
        if (view == this.f1855B7CMnp && this.f1839A5SV6n == i) {
            return true;
        }
        if (view == null || !this.f1854B4ZgIw.AaHO0E(view, i)) {
            return false;
        }
        this.f1839A5SV6n = i;
        A4TApA(view, i);
        return true;
    }
}
