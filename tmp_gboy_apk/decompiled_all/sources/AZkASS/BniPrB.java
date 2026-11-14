package AZkASS;

import AaHO0E.EdQ5bb;
import AaHO0E.Ff5QvW;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB extends BChYOn implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f572AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AmA8tU f573AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AaHO0E f574AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f575B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f576B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f577B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Ff5QvW f578B4ZgIw;

    /* renamed from: BChYOn, reason: collision with root package name */
    public BI9f7h f581BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public View f582BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public View f583BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public BJ7GGh f584BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ViewTreeObserver f585BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f586BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f587BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f588BV3sI0;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f590BniPrB;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final A5SV6n f579B7CMnp = new A5SV6n(1, this);

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ADYaiT f580B9tovu = new ADYaiT(1, this);

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f589BmvVmW = 0;

    public BniPrB(int i, AmA8tU amA8tU, Context context, View view, boolean z) {
        this.f572AlLFFp = context;
        this.f573AmA8tU = amA8tU;
        this.f575B25kr6 = z;
        this.f574AzWtSf = new AaHO0E(amA8tU, LayoutInflater.from(context), z, 2131492885);
        this.f577B3GDIM = i;
        Resources resources = context.getResources();
        this.f576B2KMhB = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131165207));
        this.f582BI9f7h = view;
        this.f578B4ZgIw = new Ff5QvW(context, null, i);
        amA8tU.A4TApA(this, context);
    }

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AmA8tU amA8tU, boolean z) {
        if (amA8tU != this.f573AmA8tU) {
            return;
        }
        dismiss();
        BJ7GGh bJ7GGh = this.f584BJ7GGh;
        if (bJ7GGh != null) {
            bJ7GGh.A2egSU(amA8tU, z);
        }
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        this.f587BTvldC = false;
        AaHO0E aaHO0E = this.f574AzWtSf;
        if (aaHO0E != null) {
            aaHO0E.notifyDataSetChanged();
        }
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
    }

    @Override // AZkASS.BmvVmW
    public final EdQ5bb AMqCpz() {
        return this.f578B4ZgIw.f823AmA8tU;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(BpkvW3 bpkvW3) {
        if (bpkvW3.hasVisibleItems()) {
            View view = this.f583BIYEnU;
            BIYEnU bIYEnU = new BIYEnU(this.f577B3GDIM, bpkvW3, this.f572AlLFFp, view, this.f575B25kr6);
            BJ7GGh bJ7GGh = this.f584BJ7GGh;
            bIYEnU.f567AYUAbz = bJ7GGh;
            BChYOn bChYOn = bIYEnU.f568AZOQYO;
            if (bChYOn != null) {
                bChYOn.AaHO0E(bJ7GGh);
            }
            boolean B9tovu2 = BChYOn.B9tovu(bpkvW3);
            bIYEnU.f566ASJ6gh = B9tovu2;
            BChYOn bChYOn2 = bIYEnU.f568AZOQYO;
            if (bChYOn2 != null) {
                bChYOn2.AzWtSf(B9tovu2);
            }
            bIYEnU.f569AZkASS = this.f581BChYOn;
            this.f581BChYOn = null;
            this.f573AmA8tU.A5SV6n(false);
            Ff5QvW ff5QvW = this.f578B4ZgIw;
            int i = ff5QvW.f826B2KMhB;
            int AcNBzu2 = ff5QvW.AcNBzu();
            if ((Gravity.getAbsoluteGravity(this.f589BmvVmW, this.f582BI9f7h.getLayoutDirection()) & 7) == 5) {
                i += this.f582BI9f7h.getWidth();
            }
            if (!bIYEnU.A4TApA()) {
                if (bIYEnU.AMqCpz != null) {
                    bIYEnU.ADYaiT(i, AcNBzu2, true, true);
                }
            }
            BJ7GGh bJ7GGh2 = this.f584BJ7GGh;
            if (bJ7GGh2 != null) {
                bJ7GGh2.AMqCpz(bpkvW3);
            }
            return true;
        }
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        return null;
    }

    @Override // AZkASS.BNL6CD
    public final void AaHO0E(BJ7GGh bJ7GGh) {
        this.f584BJ7GGh = bJ7GGh;
    }

    @Override // AZkASS.BChYOn
    public final void AcNBzu(AmA8tU amA8tU) {
    }

    @Override // AZkASS.BChYOn
    public final void AmA8tU(View view) {
        this.f582BI9f7h = view;
    }

    @Override // AZkASS.BChYOn
    public final void AzWtSf(boolean z) {
        this.f574AzWtSf.f489A5SV6n = z;
    }

    @Override // AZkASS.BChYOn
    public final void B25kr6(int i) {
        this.f589BmvVmW = i;
    }

    @Override // AZkASS.BChYOn
    public final void B2KMhB(int i) {
        this.f578B4ZgIw.f826B2KMhB = i;
    }

    @Override // AZkASS.BChYOn
    public final void B3GDIM(PopupWindow.OnDismissListener onDismissListener) {
        this.f581BChYOn = (BI9f7h) onDismissListener;
    }

    @Override // AZkASS.BChYOn
    public final void B4ZgIw(boolean z) {
        this.f590BniPrB = z;
    }

    @Override // AZkASS.BChYOn
    public final void B7CMnp(int i) {
        this.f578B4ZgIw.AYUAbz(i);
    }

    @Override // AZkASS.BmvVmW
    public final void dismiss() {
        if (isShowing()) {
            this.f578B4ZgIw.dismiss();
        }
    }

    @Override // AZkASS.BmvVmW
    public final boolean isShowing() {
        return !this.f586BPw6Q8 && this.f578B4ZgIw.f845COJEAR.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f586BPw6Q8 = true;
        this.f573AmA8tU.A5SV6n(true);
        ViewTreeObserver viewTreeObserver = this.f585BNL6CD;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f585BNL6CD = this.f583BIYEnU.getViewTreeObserver();
            }
            this.f585BNL6CD.removeGlobalOnLayoutListener(this.f579B7CMnp);
            this.f585BNL6CD = null;
        }
        this.f583BIYEnU.removeOnAttachStateChangeListener(this.f580B9tovu);
        BI9f7h bI9f7h = this.f581BChYOn;
        if (bI9f7h != null) {
            bI9f7h.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // AZkASS.BmvVmW
    public final void show() {
        View view;
        if (isShowing()) {
            return;
        }
        if (this.f586BPw6Q8 || (view = this.f582BI9f7h) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f583BIYEnU = view;
        Ff5QvW ff5QvW = this.f578B4ZgIw;
        ff5QvW.f845COJEAR.setOnDismissListener(this);
        ff5QvW.f836BPw6Q8 = this;
        ff5QvW.f844CNPG0E = true;
        ff5QvW.f845COJEAR.setFocusable(true);
        View view2 = this.f583BIYEnU;
        boolean z = this.f585BNL6CD == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f585BNL6CD = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f579B7CMnp);
        }
        view2.addOnAttachStateChangeListener(this.f580B9tovu);
        ff5QvW.f835BNL6CD = view2;
        ff5QvW.f832BI9f7h = this.f589BmvVmW;
        boolean z2 = this.f587BTvldC;
        Context context = this.f572AlLFFp;
        AaHO0E aaHO0E = this.f574AzWtSf;
        if (!z2) {
            this.f588BV3sI0 = BChYOn.AlLFFp(aaHO0E, context, this.f576B2KMhB);
            this.f587BTvldC = true;
        }
        ff5QvW.AzWtSf(this.f588BV3sI0);
        ff5QvW.f845COJEAR.setInputMethodMode(2);
        Rect rect = this.f558AcNBzu;
        ff5QvW.f843CASmeH = rect != null ? new Rect(rect) : null;
        ff5QvW.show();
        EdQ5bb edQ5bb = ff5QvW.f823AmA8tU;
        edQ5bb.setOnKeyListener(this);
        if (this.f590BniPrB) {
            AmA8tU amA8tU = this.f573AmA8tU;
            if (amA8tU.f505BIYEnU != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(2131492884, (ViewGroup) edQ5bb, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(amA8tU.f505BIYEnU);
                }
                frameLayout.setEnabled(false);
                edQ5bb.addHeaderView(frameLayout, null, false);
            }
        }
        ff5QvW.AlLFFp(aaHO0E);
        ff5QvW.show();
    }
}
