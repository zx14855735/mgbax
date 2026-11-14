package androidx.recyclerview.widget;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DjONCG implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f9366AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f9367AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public OverScroller f9368AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Interpolator f9369AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f9370B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f9371B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9372B3GDIM;

    public DjONCG(RecyclerView recyclerView) {
        this.f9372B3GDIM = recyclerView;
        Interpolator interpolator = RecyclerView.sQuinticInterpolator;
        this.f9369AzWtSf = interpolator;
        this.f9370B25kr6 = false;
        this.f9371B2KMhB = false;
        this.f9368AmA8tU = new OverScroller(recyclerView.getContext(), interpolator);
    }

    public final void A2egSU(int i, int i2) {
        RecyclerView recyclerView = this.f9372B3GDIM;
        recyclerView.setScrollState(2);
        this.f9367AlLFFp = 0;
        this.f9366AcNBzu = 0;
        Interpolator interpolator = this.f9369AzWtSf;
        Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
        if (interpolator != interpolator2) {
            this.f9369AzWtSf = interpolator2;
            this.f9368AmA8tU = new OverScroller(recyclerView.getContext(), interpolator2);
        }
        this.f9368AmA8tU.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        A4TApA();
    }

    public final void A4TApA() {
        if (this.f9370B25kr6) {
            this.f9371B2KMhB = true;
            return;
        }
        RecyclerView recyclerView = this.f9372B3GDIM;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        recyclerView.postOnAnimation(this);
    }

    public final void A5SV6n(int i, int i2, int i3, Interpolator interpolator) {
        RecyclerView recyclerView = this.f9372B3GDIM;
        if (i3 == Integer.MIN_VALUE) {
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                abs = abs2;
            }
            i3 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.sQuinticInterpolator;
        }
        if (this.f9369AzWtSf != interpolator) {
            this.f9369AzWtSf = interpolator;
            this.f9368AmA8tU = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f9367AlLFFp = 0;
        this.f9366AcNBzu = 0;
        recyclerView.setScrollState(2);
        this.f9368AmA8tU.startScroll(0, 0, i, i2, i4);
        if (Build.VERSION.SDK_INT < 23) {
            this.f9368AmA8tU.computeScrollOffset();
        }
        A4TApA();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean awakenScrollBars;
        RecyclerView recyclerView = this.f9372B3GDIM;
        if (recyclerView.mLayout == null) {
            recyclerView.removeCallbacks(this);
            this.f9368AmA8tU.abortAnimation();
            return;
        }
        this.f9371B2KMhB = false;
        this.f9370B25kr6 = true;
        recyclerView.consumePendingUpdateOperations();
        OverScroller overScroller = this.f9368AmA8tU;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i5 = currX - this.f9366AcNBzu;
            int i6 = currY - this.f9367AlLFFp;
            this.f9366AcNBzu = currX;
            this.f9367AlLFFp = currY;
            int consumeFlingInHorizontalStretch = recyclerView.consumeFlingInHorizontalStretch(i5);
            int consumeFlingInVerticalStretch = recyclerView.consumeFlingInVerticalStretch(i6);
            int[] iArr = recyclerView.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (recyclerView.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, null, 1)) {
                int[] iArr2 = recyclerView.mReusableIntPair;
                consumeFlingInHorizontalStretch -= iArr2[0];
                consumeFlingInVerticalStretch -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
            }
            if (recyclerView.mAdapter != null) {
                int[] iArr3 = recyclerView.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                int[] iArr4 = recyclerView.mReusableIntPair;
                int i7 = iArr4[0];
                int i8 = iArr4[1];
                int i9 = consumeFlingInHorizontalStretch - i7;
                int i10 = consumeFlingInVerticalStretch - i8;
                RecyclerView.AZkASS aZkASS = recyclerView.mLayout.mSmoothScroller;
                if (aZkASS != null && !aZkASS.isPendingInitialRun() && aZkASS.isRunning()) {
                    int A4TApA2 = recyclerView.mState.A4TApA();
                    if (A4TApA2 == 0) {
                        aZkASS.stop();
                    } else if (aZkASS.getTargetPosition() >= A4TApA2) {
                        aZkASS.setTargetPosition(A4TApA2 - 1);
                        aZkASS.onAnimation(i7, i8);
                    } else {
                        aZkASS.onAnimation(i7, i8);
                    }
                }
                i = i9;
                i3 = i7;
                i2 = i10;
                i4 = i8;
            } else {
                i = consumeFlingInHorizontalStretch;
                i2 = consumeFlingInVerticalStretch;
                i3 = 0;
                i4 = 0;
            }
            if (!recyclerView.mItemDecorations.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr5 = recyclerView.mReusableIntPair;
            iArr5[0] = 0;
            iArr5[1] = 0;
            recyclerView.dispatchNestedScroll(i3, i4, i, i2, null, 1, iArr5);
            int[] iArr6 = recyclerView.mReusableIntPair;
            int i11 = i - iArr6[0];
            int i12 = i2 - iArr6[1];
            if (i3 != 0 || i4 != 0) {
                recyclerView.dispatchOnScrolled(i3, i4);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
            RecyclerView.AZkASS aZkASS2 = recyclerView.mLayout.mSmoothScroller;
            if ((aZkASS2 == null || !aZkASS2.isPendingInitialRun()) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                    if (i12 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i12 <= 0) {
                        currVelocity = 0;
                    }
                    recyclerView.absorbGlows(i13, currVelocity);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    BNL6CD bnl6cd = recyclerView.mPrefetchRegistry;
                    int[] iArr7 = bnl6cd.f9279A5SV6n;
                    if (iArr7 != null) {
                        Arrays.fill(iArr7, -1);
                    }
                    bnl6cd.f9280ADYaiT = 0;
                }
            } else {
                A4TApA();
                BTvldC bTvldC = recyclerView.mGapWorker;
                if (bTvldC != null) {
                    bTvldC.A2egSU(recyclerView, i3, i4);
                }
            }
        }
        RecyclerView.AZkASS aZkASS3 = recyclerView.mLayout.mSmoothScroller;
        if (aZkASS3 != null && aZkASS3.isPendingInitialRun()) {
            aZkASS3.onAnimation(0, 0);
        }
        this.f9370B25kr6 = false;
        if (!this.f9371B2KMhB) {
            recyclerView.setScrollState(0);
            recyclerView.stopNestedScroll(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            recyclerView.postOnAnimation(this);
        }
    }
}
