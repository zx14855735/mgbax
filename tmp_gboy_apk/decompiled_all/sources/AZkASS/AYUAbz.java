package AZkASS;

import ADYaiT.CtFAbx;
import AaHO0E.EdQ5bb;
import AaHO0E.FSFw2u;
import AaHO0E.Ff5QvW;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends BChYOn implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f455AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f456AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f457AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final boolean f458B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Handler f459B2KMhB;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final A5SV6n f462B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ADYaiT f463B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ARc23Z f464BChYOn;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public View f467BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public View f468BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f469BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f470BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f471BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f472BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f473BniPrB;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f474C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public BJ7GGh f475C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public ViewTreeObserver f476CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public BI9f7h f477CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public boolean f478COJEAR;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f460B3GDIM = new ArrayList();

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f461B4ZgIw = new ArrayList();

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f465BI9f7h = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f466BIYEnU = 0;
    public boolean BpkvW3 = false;

    public AYUAbz(Context context, View view, int i, boolean z) {
        int i2 = 0;
        this.f462B7CMnp = new A5SV6n(i2, this);
        this.f463B9tovu = new ADYaiT(i2, this);
        this.f464BChYOn = new ARc23Z(i2, this);
        this.f455AlLFFp = context;
        this.f467BJ7GGh = view;
        this.f457AzWtSf = i;
        this.f458B25kr6 = z;
        this.f469BPw6Q8 = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f456AmA8tU = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131165207));
        this.f459B2KMhB = new Handler();
    }

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AmA8tU amA8tU, boolean z) {
        ArrayList arrayList = this.f461B4ZgIw;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (amA8tU == ((ASJ6gh) arrayList.get(i)).f453A4TApA) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((ASJ6gh) arrayList.get(i2)).f453A4TApA.A5SV6n(false);
        }
        ASJ6gh aSJ6gh = (ASJ6gh) arrayList.remove(i);
        aSJ6gh.f453A4TApA.B3GDIM(this);
        boolean z2 = this.f478COJEAR;
        Ff5QvW ff5QvW = aSJ6gh.f452A2egSU;
        if (z2) {
            if (Build.VERSION.SDK_INT >= 23) {
                FSFw2u.A4TApA(ff5QvW.f845COJEAR, null);
            }
            ff5QvW.f845COJEAR.setAnimationStyle(0);
        }
        ff5QvW.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f469BPw6Q8 = ((ASJ6gh) arrayList.get(size2 - 1)).f454A5SV6n;
        } else {
            this.f469BPw6Q8 = this.f467BJ7GGh.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((ASJ6gh) arrayList.get(0)).f453A4TApA.A5SV6n(false);
                return;
            }
            return;
        }
        dismiss();
        BJ7GGh bJ7GGh = this.f475C4FrIb;
        if (bJ7GGh != null) {
            bJ7GGh.A2egSU(amA8tU, true);
        }
        ViewTreeObserver viewTreeObserver = this.f476CASmeH;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f476CASmeH.removeGlobalOnLayoutListener(this.f462B7CMnp);
            }
            this.f476CASmeH = null;
        }
        this.f468BNL6CD.removeOnAttachStateChangeListener(this.f463B9tovu);
        this.f477CNPG0E.onDismiss();
    }

    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        Iterator it = this.f461B4ZgIw.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((ASJ6gh) it.next()).f452A2egSU.f823AmA8tU.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((AaHO0E) adapter).notifyDataSetChanged();
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
        ArrayList arrayList = this.f461B4ZgIw;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((ASJ6gh) CtFAbx.ADYaiT(arrayList, 1)).f452A2egSU.f823AmA8tU;
    }

    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(BpkvW3 bpkvW3) {
        Iterator it = this.f461B4ZgIw.iterator();
        while (it.hasNext()) {
            ASJ6gh aSJ6gh = (ASJ6gh) it.next();
            if (bpkvW3 == aSJ6gh.f453A4TApA) {
                aSJ6gh.f452A2egSU.f823AmA8tU.requestFocus();
                return true;
            }
        }
        if (!bpkvW3.hasVisibleItems()) {
            return false;
        }
        AcNBzu(bpkvW3);
        BJ7GGh bJ7GGh = this.f475C4FrIb;
        if (bJ7GGh != null) {
            bJ7GGh.AMqCpz(bpkvW3);
        }
        return true;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        return null;
    }

    @Override // AZkASS.BNL6CD
    public final void AaHO0E(BJ7GGh bJ7GGh) {
        this.f475C4FrIb = bJ7GGh;
    }

    @Override // AZkASS.BChYOn
    public final void AcNBzu(AmA8tU amA8tU) {
        amA8tU.A4TApA(this, this.f455AlLFFp);
        if (isShowing()) {
            BChYOn(amA8tU);
        } else {
            this.f460B3GDIM.add(amA8tU);
        }
    }

    @Override // AZkASS.BChYOn
    public final void AmA8tU(View view) {
        if (this.f467BJ7GGh != view) {
            this.f467BJ7GGh = view;
            this.f466BIYEnU = Gravity.getAbsoluteGravity(this.f465BI9f7h, view.getLayoutDirection());
        }
    }

    @Override // AZkASS.BChYOn
    public final void AzWtSf(boolean z) {
        this.BpkvW3 = z;
    }

    @Override // AZkASS.BChYOn
    public final void B25kr6(int i) {
        if (this.f465BI9f7h != i) {
            this.f465BI9f7h = i;
            this.f466BIYEnU = Gravity.getAbsoluteGravity(i, this.f467BJ7GGh.getLayoutDirection());
        }
    }

    @Override // AZkASS.BChYOn
    public final void B2KMhB(int i) {
        this.f470BTvldC = true;
        this.f472BmvVmW = i;
    }

    @Override // AZkASS.BChYOn
    public final void B3GDIM(PopupWindow.OnDismissListener onDismissListener) {
        this.f477CNPG0E = (BI9f7h) onDismissListener;
    }

    @Override // AZkASS.BChYOn
    public final void B4ZgIw(boolean z) {
        this.f474C2rE4F = z;
    }

    @Override // AZkASS.BChYOn
    public final void B7CMnp(int i) {
        this.f471BV3sI0 = true;
        this.f473BniPrB = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x013d, code lost:
    
        if (((r3.getWidth() + r10[0]) + r6) > r9.right) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x013f, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0142, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0149, code lost:
    
        if ((r10[0] - r6) < 0) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BChYOn(AZkASS.AmA8tU r20) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AZkASS.AYUAbz.BChYOn(AZkASS.AmA8tU):void");
    }

    @Override // AZkASS.BmvVmW
    public final void dismiss() {
        ArrayList arrayList = this.f461B4ZgIw;
        int size = arrayList.size();
        if (size > 0) {
            ASJ6gh[] aSJ6ghArr = (ASJ6gh[]) arrayList.toArray(new ASJ6gh[size]);
            for (int i = size - 1; i >= 0; i--) {
                ASJ6gh aSJ6gh = aSJ6ghArr[i];
                if (aSJ6gh.f452A2egSU.f845COJEAR.isShowing()) {
                    aSJ6gh.f452A2egSU.dismiss();
                }
            }
        }
    }

    @Override // AZkASS.BmvVmW
    public final boolean isShowing() {
        ArrayList arrayList = this.f461B4ZgIw;
        return arrayList.size() > 0 && ((ASJ6gh) arrayList.get(0)).f452A2egSU.f845COJEAR.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ASJ6gh aSJ6gh;
        ArrayList arrayList = this.f461B4ZgIw;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aSJ6gh = null;
                break;
            }
            aSJ6gh = (ASJ6gh) arrayList.get(i);
            if (!aSJ6gh.f452A2egSU.f845COJEAR.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (aSJ6gh != null) {
            aSJ6gh.f453A4TApA.A5SV6n(false);
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
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.f460B3GDIM;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BChYOn((AmA8tU) it.next());
        }
        arrayList.clear();
        View view = this.f467BJ7GGh;
        this.f468BNL6CD = view;
        if (view != null) {
            boolean z = this.f476CASmeH == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f476CASmeH = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f462B7CMnp);
            }
            this.f468BNL6CD.addOnAttachStateChangeListener(this.f463B9tovu);
        }
    }
}
