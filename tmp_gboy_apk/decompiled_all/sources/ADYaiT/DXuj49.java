package ADYaiT;

import AaHO0E.DvK7DB;
import AaHO0E.GhvxjZ;
import AaHO0E.H6qKiO;
import COJEAR.Ddcejp;
import COJEAR.De4eam;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DXuj49 extends A2egSU implements AaHO0E.AMqCpz {

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final AccelerateInterpolator f249BJ7GGh = new AccelerateInterpolator();

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final DecelerateInterpolator f250BNL6CD = new DecelerateInterpolator();

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f251A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Context f252A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ActionBarOverlayLayout f253A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ActionBarContainer f254ADYaiT;
    public DvK7DB AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ActionBarContextView f255ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final View f256ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f257AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public DXnQ0V f258AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public DXnQ0V f259AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public K1Z3yj.A2egSU f260AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f261AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f262AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f263AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f264AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f265B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f266B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f267B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AZOQYO.AcNBzu f268B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f269B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f270B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final DV2E8K f271BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final DV2E8K f272BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final KCxDWD.A5SV6n f273BIYEnU;

    static {
        vkASS();
    }

    public DXuj49(Activity activity, boolean z) {
        new ArrayList();
        this.f262AlLFFp = new ArrayList();
        this.f263AmA8tU = 0;
        this.f264AzWtSf = true;
        this.f267B3GDIM = true;
        this.f271BChYOn = new DV2E8K(this, 0);
        this.f272BI9f7h = new DV2E8K(this, 1);
        this.f273BIYEnU = new KCxDWD.A5SV6n(2, this);
        View decorView = activity.getWindow().getDecorView();
        B7CMnp(decorView);
        if (z) {
            return;
        }
        this.f256ASJ6gh = decorView.findViewById(R.id.content);
    }

    private static /* synthetic */ void vkASS() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // ADYaiT.A2egSU
    public final boolean A4TApA() {
        GhvxjZ ghvxjZ;
        DvK7DB dvK7DB = this.AMqCpz;
        if (dvK7DB == null || (ghvxjZ = ((H6qKiO) dvK7DB).f898A2egSU.f8256D07BeM) == null || ghvxjZ.f889AlLFFp == null) {
            return false;
        }
        GhvxjZ ghvxjZ2 = ((H6qKiO) dvK7DB).f898A2egSU.f8256D07BeM;
        AZkASS.B25kr6 b25kr6 = ghvxjZ2 == null ? null : ghvxjZ2.f889AlLFFp;
        if (b25kr6 == null) {
            return true;
        }
        b25kr6.collapseActionView();
        return true;
    }

    @Override // ADYaiT.A2egSU
    public final void A5SV6n(boolean z) {
        if (z == this.f261AcNBzu) {
            return;
        }
        this.f261AcNBzu = z;
        ArrayList arrayList = this.f262AlLFFp;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // ADYaiT.A2egSU
    public final int ADYaiT() {
        return ((H6qKiO) this.AMqCpz).f899A4TApA;
    }

    @Override // ADYaiT.A2egSU
    public final Context AMqCpz() {
        if (this.f252A4TApA == null) {
            TypedValue typedValue = new TypedValue();
            this.f251A2egSU.getTheme().resolveAttribute(2130968588, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f252A4TApA = new ContextThemeWrapper(this.f251A2egSU, i);
            } else {
                this.f252A4TApA = this.f251A2egSU;
            }
        }
        return this.f252A4TApA;
    }

    @Override // ADYaiT.A2egSU
    public final void ASJ6gh() {
        B9tovu(this.f251A2egSU.getResources().getBoolean(2131034112));
    }

    @Override // ADYaiT.A2egSU
    public final boolean AZOQYO(int i, KeyEvent keyEvent) {
        AZkASS.AmA8tU amA8tU;
        DXnQ0V dXnQ0V = this.f258AZOQYO;
        if (dXnQ0V == null || (amA8tU = dXnQ0V.f245AzWtSf) == null) {
            return false;
        }
        amA8tU.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return amA8tU.performShortcut(i, keyEvent, 0);
    }

    @Override // ADYaiT.A2egSU
    public final void AcNBzu(boolean z) {
        if (this.f257AYUAbz) {
            return;
        }
        AlLFFp(z);
    }

    @Override // ADYaiT.A2egSU
    public final void AlLFFp(boolean z) {
        int i = z ? 4 : 0;
        H6qKiO h6qKiO = (H6qKiO) this.AMqCpz;
        int i2 = h6qKiO.f899A4TApA;
        this.f257AYUAbz = true;
        h6qKiO.A2egSU((i & 4) | (i2 & (-5)));
    }

    @Override // ADYaiT.A2egSU
    public final void AmA8tU() {
        H6qKiO h6qKiO = (H6qKiO) this.AMqCpz;
        h6qKiO.A2egSU((h6qKiO.f899A4TApA & (-3)) | 2);
    }

    @Override // ADYaiT.A2egSU
    public final void AzWtSf(boolean z) {
        AZOQYO.AcNBzu acNBzu;
        this.f269B7CMnp = z;
        if (z || (acNBzu = this.f268B4ZgIw) == null) {
            return;
        }
        acNBzu.A2egSU();
    }

    @Override // ADYaiT.A2egSU
    public final void B25kr6() {
        H6qKiO h6qKiO = (H6qKiO) this.AMqCpz;
        h6qKiO.f903ASJ6gh = true;
        h6qKiO.f904AYUAbz = "互传";
        if ((h6qKiO.f899A4TApA & 8) != 0) {
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.setTitle("互传");
            if (h6qKiO.f903ASJ6gh) {
                COJEAR.DG07BK.B7CMnp(toolbar.getRootView(), "互传");
            }
        }
    }

    @Override // ADYaiT.A2egSU
    public final void B2KMhB(CharSequence charSequence) {
        H6qKiO h6qKiO = (H6qKiO) this.AMqCpz;
        if (h6qKiO.f903ASJ6gh) {
            return;
        }
        h6qKiO.f904AYUAbz = charSequence;
        if ((h6qKiO.f899A4TApA & 8) != 0) {
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.setTitle(charSequence);
            if (h6qKiO.f903ASJ6gh) {
                COJEAR.DG07BK.B7CMnp(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // ADYaiT.A2egSU
    public final AZOQYO.A4TApA B3GDIM(K1Z3yj.A2egSU a2egSU) {
        DXnQ0V dXnQ0V = this.f258AZOQYO;
        if (dXnQ0V != null) {
            dXnQ0V.A2egSU();
        }
        this.f253A5SV6n.setHideOnContentScrollEnabled(false);
        this.f255ARc23Z.AMqCpz();
        DXnQ0V dXnQ0V2 = new DXnQ0V(this, this.f255ARc23Z.getContext(), a2egSU);
        AZkASS.AmA8tU amA8tU = dXnQ0V2.f245AzWtSf;
        amA8tU.BJ7GGh();
        try {
            if (!((AZOQYO.A2egSU) dXnQ0V2.f246B25kr6.f4174AlLFFp).AZOQYO(dXnQ0V2, amA8tU)) {
                return null;
            }
            this.f258AZOQYO = dXnQ0V2;
            dXnQ0V2.ASJ6gh();
            this.f255ARc23Z.A5SV6n(dXnQ0V2);
            B4ZgIw(true);
            return dXnQ0V2;
        } finally {
            amA8tU.BIYEnU();
        }
    }

    public final void B4ZgIw(boolean z) {
        De4eam AZOQYO2;
        De4eam de4eam;
        if (z) {
            if (!this.f266B2KMhB) {
                this.f266B2KMhB = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f253A5SV6n;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                BChYOn(false);
            }
        } else if (this.f266B2KMhB) {
            this.f266B2KMhB = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f253A5SV6n;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            BChYOn(false);
        }
        if (!this.f254ADYaiT.isLaidOut()) {
            if (z) {
                ((H6qKiO) this.AMqCpz).f898A2egSU.setVisibility(4);
                this.f255ARc23Z.setVisibility(0);
                return;
            } else {
                ((H6qKiO) this.AMqCpz).f898A2egSU.setVisibility(0);
                this.f255ARc23Z.setVisibility(8);
                return;
            }
        }
        if (z) {
            H6qKiO h6qKiO = (H6qKiO) this.AMqCpz;
            AZOQYO2 = COJEAR.DG07BK.A2egSU(h6qKiO.f898A2egSU);
            AZOQYO2.A2egSU(0.0f);
            AZOQYO2.A5SV6n(100L);
            AZOQYO2.ADYaiT(new AZOQYO.AaHO0E(h6qKiO, 4));
            de4eam = this.f255ARc23Z.AZOQYO(0, 200L);
        } else {
            H6qKiO h6qKiO2 = (H6qKiO) this.AMqCpz;
            De4eam A2egSU2 = COJEAR.DG07BK.A2egSU(h6qKiO2.f898A2egSU);
            A2egSU2.A2egSU(1.0f);
            A2egSU2.A5SV6n(200L);
            A2egSU2.ADYaiT(new AZOQYO.AaHO0E(h6qKiO2, 0));
            AZOQYO2 = this.f255ARc23Z.AZOQYO(8, 100L);
            de4eam = A2egSU2;
        }
        AZOQYO.AcNBzu acNBzu = new AZOQYO.AcNBzu();
        ArrayList arrayList = acNBzu.f411A2egSU;
        arrayList.add(AZOQYO2);
        View view = (View) AZOQYO2.f1696A2egSU.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) de4eam.f1696A2egSU.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(de4eam);
        acNBzu.A4TApA();
    }

    public final void B7CMnp(View view) {
        DvK7DB wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(2131296565);
        this.f253A5SV6n = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(2131296319);
        if (findViewById instanceof DvK7DB) {
            wrapper = (DvK7DB) findViewById;
        } else {
            if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.AMqCpz = wrapper;
        this.f255ARc23Z = (ActionBarContextView) view.findViewById(2131296330);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(2131296321);
        this.f254ADYaiT = actionBarContainer;
        DvK7DB dvK7DB = this.AMqCpz;
        if (dvK7DB == null || this.f255ARc23Z == null || actionBarContainer == null) {
            throw new IllegalStateException(DXuj49.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((H6qKiO) dvK7DB).getContext();
        this.f251A2egSU = context;
        if ((((H6qKiO) this.AMqCpz).f899A4TApA & 4) != 0) {
            this.f257AYUAbz = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.AMqCpz.getClass();
        B9tovu(context.getResources().getBoolean(2131034112));
        TypedArray obtainStyledAttributes = this.f251A2egSU.obtainStyledAttributes(null, R$styleable.f8014A2egSU, 2130968583, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f253A5SV6n;
            if (!actionBarOverlayLayout2.f8115B3GDIM) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f270B9tovu = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f254ADYaiT;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            COJEAR.CmUvjW.B4ZgIw(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void B9tovu(boolean z) {
        if (z) {
            this.f254ADYaiT.setTabContainer(null);
            ((H6qKiO) this.AMqCpz).getClass();
        } else {
            ((H6qKiO) this.AMqCpz).getClass();
            this.f254ADYaiT.setTabContainer(null);
        }
        this.AMqCpz.getClass();
        ((H6qKiO) this.AMqCpz).f898A2egSU.setCollapsible(false);
        this.f253A5SV6n.setHasNonEmbeddedTabs(false);
    }

    public final void BChYOn(boolean z) {
        boolean z2 = this.f266B2KMhB || !this.f265B25kr6;
        View view = this.f256ASJ6gh;
        KCxDWD.A5SV6n a5SV6n = this.f273BIYEnU;
        if (!z2) {
            if (this.f267B3GDIM) {
                this.f267B3GDIM = false;
                AZOQYO.AcNBzu acNBzu = this.f268B4ZgIw;
                if (acNBzu != null) {
                    acNBzu.A2egSU();
                }
                int i = this.f263AmA8tU;
                DV2E8K dv2e8k = this.f271BChYOn;
                if (i != 0 || (!this.f269B7CMnp && !z)) {
                    dv2e8k.A5SV6n();
                    return;
                }
                this.f254ADYaiT.setAlpha(1.0f);
                this.f254ADYaiT.setTransitioning(true);
                AZOQYO.AcNBzu acNBzu2 = new AZOQYO.AcNBzu();
                float f = -this.f254ADYaiT.getHeight();
                if (z) {
                    this.f254ADYaiT.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                De4eam A2egSU2 = COJEAR.DG07BK.A2egSU(this.f254ADYaiT);
                A2egSU2.AMqCpz(f);
                View view2 = (View) A2egSU2.f1696A2egSU.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(a5SV6n != null ? new Ddcejp(a5SV6n, view2) : null);
                }
                boolean z3 = acNBzu2.AMqCpz;
                ArrayList arrayList = acNBzu2.f411A2egSU;
                if (!z3) {
                    arrayList.add(A2egSU2);
                }
                if (this.f264AzWtSf && view != null) {
                    De4eam A2egSU3 = COJEAR.DG07BK.A2egSU(view);
                    A2egSU3.AMqCpz(f);
                    if (!acNBzu2.AMqCpz) {
                        arrayList.add(A2egSU3);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f249BJ7GGh;
                boolean z4 = acNBzu2.AMqCpz;
                if (!z4) {
                    acNBzu2.f413A5SV6n = accelerateInterpolator;
                }
                if (!z4) {
                    acNBzu2.f412A4TApA = 250L;
                }
                if (!z4) {
                    acNBzu2.f414ADYaiT = dv2e8k;
                }
                this.f268B4ZgIw = acNBzu2;
                acNBzu2.A4TApA();
                return;
            }
            return;
        }
        if (this.f267B3GDIM) {
            return;
        }
        this.f267B3GDIM = true;
        AZOQYO.AcNBzu acNBzu3 = this.f268B4ZgIw;
        if (acNBzu3 != null) {
            acNBzu3.A2egSU();
        }
        this.f254ADYaiT.setVisibility(0);
        int i2 = this.f263AmA8tU;
        DV2E8K dv2e8k2 = this.f272BI9f7h;
        if (i2 == 0 && (this.f269B7CMnp || z)) {
            this.f254ADYaiT.setTranslationY(0.0f);
            float f2 = -this.f254ADYaiT.getHeight();
            if (z) {
                this.f254ADYaiT.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.f254ADYaiT.setTranslationY(f2);
            AZOQYO.AcNBzu acNBzu4 = new AZOQYO.AcNBzu();
            De4eam A2egSU4 = COJEAR.DG07BK.A2egSU(this.f254ADYaiT);
            A2egSU4.AMqCpz(0.0f);
            View view3 = (View) A2egSU4.f1696A2egSU.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(a5SV6n != null ? new Ddcejp(a5SV6n, view3) : null);
            }
            boolean z5 = acNBzu4.AMqCpz;
            ArrayList arrayList2 = acNBzu4.f411A2egSU;
            if (!z5) {
                arrayList2.add(A2egSU4);
            }
            if (this.f264AzWtSf && view != null) {
                view.setTranslationY(f2);
                De4eam A2egSU5 = COJEAR.DG07BK.A2egSU(view);
                A2egSU5.AMqCpz(0.0f);
                if (!acNBzu4.AMqCpz) {
                    arrayList2.add(A2egSU5);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f250BNL6CD;
            boolean z6 = acNBzu4.AMqCpz;
            if (!z6) {
                acNBzu4.f413A5SV6n = decelerateInterpolator;
            }
            if (!z6) {
                acNBzu4.f412A4TApA = 250L;
            }
            if (!z6) {
                acNBzu4.f414ADYaiT = dv2e8k2;
            }
            this.f268B4ZgIw = acNBzu4;
            acNBzu4.A4TApA();
        } else {
            this.f254ADYaiT.setAlpha(1.0f);
            this.f254ADYaiT.setTranslationY(0.0f);
            if (this.f264AzWtSf && view != null) {
                view.setTranslationY(0.0f);
            }
            dv2e8k2.A5SV6n();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f253A5SV6n;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            COJEAR.CikNvS.A5SV6n(actionBarOverlayLayout);
        }
    }

    public DXuj49(Dialog dialog) {
        new ArrayList();
        this.f262AlLFFp = new ArrayList();
        this.f263AmA8tU = 0;
        this.f264AzWtSf = true;
        this.f267B3GDIM = true;
        this.f271BChYOn = new DV2E8K(this, 0);
        this.f272BI9f7h = new DV2E8K(this, 1);
        this.f273BIYEnU = new KCxDWD.A5SV6n(2, this);
        B7CMnp(dialog.getWindow().getDecorView());
    }
}
