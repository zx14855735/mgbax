package AaHO0E;

import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EicXu4 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final float f785AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f786AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f787AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final View f788AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public EiK8oA f789B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public EiK8oA f790B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f791B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f792B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int[] f793B7CMnp = new int[2];

    public EicXu4(View view) {
        this.f788AzWtSf = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f785AcNBzu = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f786AlLFFp = tapTimeout;
        this.f787AmA8tU = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void A2egSU() {
        EiK8oA eiK8oA = this.f790B2KMhB;
        View view = this.f788AzWtSf;
        if (eiK8oA != null) {
            view.removeCallbacks(eiK8oA);
        }
        EiK8oA eiK8oA2 = this.f789B25kr6;
        if (eiK8oA2 != null) {
            view.removeCallbacks(eiK8oA2);
        }
    }

    public abstract AZkASS.BmvVmW A4TApA();

    public abstract boolean A5SV6n();

    public boolean ADYaiT() {
        AZkASS.BmvVmW A4TApA2 = A4TApA();
        if (A4TApA2 == null || !A4TApA2.isShowing()) {
            return true;
        }
        A4TApA2.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.EicXu4.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f791B3GDIM = false;
        this.f792B4ZgIw = -1;
        EiK8oA eiK8oA = this.f789B25kr6;
        if (eiK8oA != null) {
            this.f788AzWtSf.removeCallbacks(eiK8oA);
        }
    }
}
