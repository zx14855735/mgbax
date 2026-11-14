package androidx.appcompat.widget;

import ADYaiT.D8MqeW;
import ADYaiT.D9tr6l;
import AZOQYO.AZkASS;
import AZkASS.ARc23Z;
import AZkASS.B25kr6;
import AaHO0E.AzWtSf;
import AaHO0E.BV3sI0;
import AaHO0E.DvK7DB;
import AaHO0E.G16Pvp;
import AaHO0E.GYpKKt;
import AaHO0E.GZqyMh;
import AaHO0E.GcSJYy;
import AaHO0E.GhvxjZ;
import AaHO0E.GnQT2j;
import AaHO0E.H0R8Px;
import AaHO0E.H1wUHe;
import AaHO0E.H6qKiO;
import AaHO0E.HSHyT0;
import COJEAR.AmA8tU;
import COJEAR.B3GDIM;
import COJEAR.B7CMnp;
import COJEAR.DG07BK;
import JrXYwF.A4TApA;
import KCxDWD.A5SV6n;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.fragment.app.CmUvjW;
import com.qq.e.comm.adevent.AdEventType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Toolbar extends ViewGroup implements AmA8tU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ActionMenuView f8219AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AppCompatTextView f8220AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AppCompatTextView f8221AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BV3sI0 f8222AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AppCompatImageView f8223B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Drawable f8224B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CharSequence f8225B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public BV3sI0 f8226B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public View f8227B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public Context f8228B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f8229BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f8230BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f8231BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final int f8232BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final int f8233BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f8234BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f8235BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f8236BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f8237BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public G16Pvp f8238BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f8239C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final int f8240C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public CharSequence f8241CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public CharSequence f8242CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public ColorStateList f8243COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public ColorStateList f8244CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public boolean f8245CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public boolean f8246CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final ArrayList f8247CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final ArrayList f8248Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final int[] f8249CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public final B3GDIM f8250CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public ArrayList f8251CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public H0R8Px f8252CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public final ARc23Z f8253CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public H6qKiO f8254CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public AzWtSf f8255CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public GhvxjZ f8256D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public D9tr6l f8257D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public A5SV6n f8258D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f8259D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public OnBackInvokedCallback f8260D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public OnBackInvokedDispatcher f8261D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f8262DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public final D8MqeW f8263DG07BK;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130970128);
    }

    public static GnQT2j AYUAbz() {
        GnQT2j gnQT2j = new GnQT2j(-2, -2);
        gnQT2j.f892A4TApA = 0;
        gnQT2j.f891A2egSU = 8388627;
        return gnQT2j;
    }

    public static GnQT2j AZOQYO(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof GnQT2j;
        if (z) {
            GnQT2j gnQT2j = (GnQT2j) layoutParams;
            GnQT2j gnQT2j2 = new GnQT2j(gnQT2j);
            gnQT2j2.f892A4TApA = 0;
            gnQT2j2.f892A4TApA = gnQT2j.f892A4TApA;
            return gnQT2j2;
        }
        if (z) {
            GnQT2j gnQT2j3 = new GnQT2j((GnQT2j) layoutParams);
            gnQT2j3.f892A4TApA = 0;
            return gnQT2j3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            GnQT2j gnQT2j4 = new GnQT2j(layoutParams);
            gnQT2j4.f892A4TApA = 0;
            return gnQT2j4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        GnQT2j gnQT2j5 = new GnQT2j(marginLayoutParams);
        gnQT2j5.f892A4TApA = 0;
        ((ViewGroup.MarginLayoutParams) gnQT2j5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) gnQT2j5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) gnQT2j5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) gnQT2j5).bottomMargin = marginLayoutParams.bottomMargin;
        return gnQT2j5;
    }

    public static int AaHO0E(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int AcNBzu(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new AZkASS(getContext());
    }

    public final void A2egSU(ArrayList arrayList, int i) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                GnQT2j gnQT2j = (GnQT2j) childAt.getLayoutParams();
                if (gnQT2j.f892A4TApA == 0 && B9tovu(childAt)) {
                    int i3 = gnQT2j.f891A2egSU;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            GnQT2j gnQT2j2 = (GnQT2j) childAt2.getLayoutParams();
            if (gnQT2j2.f892A4TApA == 0 && B9tovu(childAt2)) {
                int i5 = gnQT2j2.f891A2egSU;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void A4TApA(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        GnQT2j AYUAbz2 = layoutParams == null ? AYUAbz() : !checkLayoutParams(layoutParams) ? AZOQYO(layoutParams) : (GnQT2j) layoutParams;
        AYUAbz2.f892A4TApA = 1;
        if (!z || this.f8227B7CMnp == null) {
            addView(view, AYUAbz2);
        } else {
            view.setLayoutParams(AYUAbz2);
            this.f8248Cd8JRx.add(view);
        }
    }

    public final void A5SV6n() {
        if (this.f8226B4ZgIw == null) {
            BV3sI0 bV3sI0 = new BV3sI0(getContext(), null, 2130970127);
            this.f8226B4ZgIw = bV3sI0;
            bV3sI0.setImageDrawable(this.f8224B2KMhB);
            this.f8226B4ZgIw.setContentDescription(this.f8225B3GDIM);
            GnQT2j AYUAbz2 = AYUAbz();
            AYUAbz2.f891A2egSU = (this.f8232BJ7GGh & AdEventType.AD_TICK) | 8388611;
            AYUAbz2.f892A4TApA = 2;
            this.f8226B4ZgIw.setLayoutParams(AYUAbz2);
            this.f8226B4ZgIw.setOnClickListener(new ADYaiT.A5SV6n(2, this));
        }
    }

    public final void ADYaiT() {
        if (this.f8238BniPrB == null) {
            G16Pvp g16Pvp = new G16Pvp();
            g16Pvp.f862A2egSU = 0;
            g16Pvp.f863A4TApA = 0;
            g16Pvp.f864A5SV6n = Integer.MIN_VALUE;
            g16Pvp.f865ADYaiT = Integer.MIN_VALUE;
            g16Pvp.AMqCpz = 0;
            g16Pvp.f866ARc23Z = 0;
            g16Pvp.f867ASJ6gh = false;
            g16Pvp.f868AYUAbz = false;
            this.f8238BniPrB = g16Pvp;
        }
    }

    public final void AMqCpz() {
        ARc23Z();
        ActionMenuView actionMenuView = this.f8219AcNBzu;
        if (actionMenuView.f8136BPw6Q8 == null) {
            AZkASS.AmA8tU amA8tU = (AZkASS.AmA8tU) actionMenuView.getMenu();
            if (this.f8256D07BeM == null) {
                this.f8256D07BeM = new GhvxjZ(this);
            }
            this.f8219AcNBzu.setExpandedActionViewsExclusive(true);
            amA8tU.A4TApA(this.f8256D07BeM, this.f8228B9tovu);
            BI9f7h();
        }
    }

    public final void ARc23Z() {
        if (this.f8219AcNBzu == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f8219AcNBzu = actionMenuView;
            actionMenuView.setPopupTheme(this.f8229BChYOn);
            this.f8219AcNBzu.setOnMenuItemClickListener(this.f8253CrfGsy);
            ActionMenuView actionMenuView2 = this.f8219AcNBzu;
            D9tr6l d9tr6l = this.f8257D6DOie;
            A5SV6n a5SV6n = new A5SV6n(6, this);
            actionMenuView2.BpkvW3 = d9tr6l;
            actionMenuView2.f8141C2rE4F = a5SV6n;
            GnQT2j AYUAbz2 = AYUAbz();
            AYUAbz2.f891A2egSU = (this.f8232BJ7GGh & AdEventType.AD_TICK) | 8388613;
            this.f8219AcNBzu.setLayoutParams(AYUAbz2);
            A4TApA(this.f8219AcNBzu, false);
        }
    }

    public final void ASJ6gh() {
        if (this.f8222AzWtSf == null) {
            this.f8222AzWtSf = new BV3sI0(getContext(), null, 2130970127);
            GnQT2j AYUAbz2 = AYUAbz();
            AYUAbz2.f891A2egSU = (this.f8232BJ7GGh & AdEventType.AD_TICK) | 8388611;
            this.f8222AzWtSf.setLayoutParams(AYUAbz2);
        }
    }

    public final int AZkASS(int i, View view) {
        GnQT2j gnQT2j = (GnQT2j) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = gnQT2j.f891A2egSU & AdEventType.AD_TICK;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.f8240C4FrIb & AdEventType.AD_TICK;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gnQT2j).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) gnQT2j).topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) gnQT2j).bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    public void AlLFFp(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final void AmA8tU() {
        Iterator it = this.f8251CmUvjW.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = this.f8250CkXcdM.f1642A4TApA.iterator();
        while (it2.hasNext()) {
            ((CmUvjW) ((B7CMnp) it2.next())).f8826A2egSU.AZkASS(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f8251CmUvjW = currentMenuItems2;
    }

    public final boolean AzWtSf(View view) {
        return view.getParent() == this || this.f8248Cd8JRx.contains(view);
    }

    public final boolean B25kr6() {
        AzWtSf azWtSf;
        ActionMenuView actionMenuView = this.f8219AcNBzu;
        return (actionMenuView == null || (azWtSf = actionMenuView.f8140BniPrB) == null || !azWtSf.AlLFFp()) ? false : true;
    }

    public final int B2KMhB(View view, int i, int i2, int[] iArr) {
        GnQT2j gnQT2j = (GnQT2j) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gnQT2j).leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int AZkASS2 = AZkASS(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, AZkASS2, max + measuredWidth, view.getMeasuredHeight() + AZkASS2);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) gnQT2j).rightMargin + max;
    }

    public final int B3GDIM(View view, int i, int i2, int[] iArr) {
        GnQT2j gnQT2j = (GnQT2j) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gnQT2j).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int AZkASS2 = AZkASS(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, AZkASS2, max, view.getMeasuredHeight() + AZkASS2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) gnQT2j).leftMargin);
    }

    public final int B4ZgIw(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void B7CMnp(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean B9tovu(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean BChYOn() {
        AzWtSf azWtSf;
        ActionMenuView actionMenuView = this.f8219AcNBzu;
        return (actionMenuView == null || (azWtSf = actionMenuView.f8140BniPrB) == null || !azWtSf.AmA8tU()) ? false : true;
    }

    public final void BI9f7h() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher A2egSU2 = GcSJYy.A2egSU(this);
            GhvxjZ ghvxjZ = this.f8256D07BeM;
            boolean z = (ghvxjZ == null || ghvxjZ.f889AlLFFp == null || A2egSU2 == null || !isAttachedToWindow() || !this.f8262DAk1zC) ? false : true;
            if (z && this.f8261D9tr6l == null) {
                if (this.f8260D8cQ8b == null) {
                    this.f8260D8cQ8b = GcSJYy.A4TApA(new GZqyMh(this, 0));
                }
                GcSJYy.A5SV6n(A2egSU2, this.f8260D8cQ8b);
                this.f8261D9tr6l = A2egSU2;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.f8261D9tr6l) == null) {
                return;
            }
            GcSJYy.ADYaiT(onBackInvokedDispatcher, this.f8260D8cQ8b);
            this.f8261D9tr6l = null;
        }
    }

    @Override // COJEAR.AmA8tU
    public final void addMenuProvider(B7CMnp b7CMnp) {
        B3GDIM b3gdim = this.f8250CkXcdM;
        b3gdim.f1642A4TApA.add(b7CMnp);
        b3gdim.f1641A2egSU.run();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof GnQT2j);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return AYUAbz();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return AZOQYO(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        BV3sI0 bV3sI0 = this.f8226B4ZgIw;
        if (bV3sI0 != null) {
            return bV3sI0.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        BV3sI0 bV3sI0 = this.f8226B4ZgIw;
        if (bV3sI0 != null) {
            return bV3sI0.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        G16Pvp g16Pvp = this.f8238BniPrB;
        if (g16Pvp != null) {
            return g16Pvp.f867ASJ6gh ? g16Pvp.f862A2egSU : g16Pvp.f863A4TApA;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f8239C2rE4F;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        G16Pvp g16Pvp = this.f8238BniPrB;
        if (g16Pvp != null) {
            return g16Pvp.f862A2egSU;
        }
        return 0;
    }

    public int getContentInsetRight() {
        G16Pvp g16Pvp = this.f8238BniPrB;
        if (g16Pvp != null) {
            return g16Pvp.f863A4TApA;
        }
        return 0;
    }

    public int getContentInsetStart() {
        G16Pvp g16Pvp = this.f8238BniPrB;
        if (g16Pvp != null) {
            return g16Pvp.f867ASJ6gh ? g16Pvp.f863A4TApA : g16Pvp.f862A2egSU;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.BpkvW3;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        AZkASS.AmA8tU amA8tU;
        ActionMenuView actionMenuView = this.f8219AcNBzu;
        return (actionMenuView == null || (amA8tU = actionMenuView.f8136BPw6Q8) == null || !amA8tU.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f8239C2rE4F, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.BpkvW3, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f8223B25kr6;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f8223B25kr6;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        AMqCpz();
        return this.f8219AcNBzu.getMenu();
    }

    public View getNavButtonView() {
        return this.f8222AzWtSf;
    }

    public CharSequence getNavigationContentDescription() {
        BV3sI0 bV3sI0 = this.f8222AzWtSf;
        if (bV3sI0 != null) {
            return bV3sI0.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        BV3sI0 bV3sI0 = this.f8222AzWtSf;
        if (bV3sI0 != null) {
            return bV3sI0.getDrawable();
        }
        return null;
    }

    public AzWtSf getOuterActionMenuPresenter() {
        return this.f8255CtxOCS;
    }

    public Drawable getOverflowIcon() {
        AMqCpz();
        return this.f8219AcNBzu.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f8228B9tovu;
    }

    public int getPopupTheme() {
        return this.f8229BChYOn;
    }

    public CharSequence getSubtitle() {
        return this.f8242CNPG0E;
    }

    public final TextView getSubtitleTextView() {
        return this.f8221AmA8tU;
    }

    public CharSequence getTitle() {
        return this.f8241CASmeH;
    }

    public int getTitleMarginBottom() {
        return this.f8237BmvVmW;
    }

    public int getTitleMarginEnd() {
        return this.f8235BTvldC;
    }

    public int getTitleMarginStart() {
        return this.f8234BPw6Q8;
    }

    public int getTitleMarginTop() {
        return this.f8236BV3sI0;
    }

    public final TextView getTitleTextView() {
        return this.f8220AlLFFp;
    }

    public DvK7DB getWrapper() {
        if (this.f8254CtFAbx == null) {
            this.f8254CtFAbx = new H6qKiO(this, true);
        }
        return this.f8254CtFAbx;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BI9f7h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8263DG07BK);
        BI9f7h();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f8246CTkVKb = false;
        }
        if (!this.f8246CTkVKb) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f8246CTkVKb = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f8246CTkVKb = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028f A[LOOP:0: B:39:0x028d->B:40:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02a7 A[LOOP:1: B:43:0x02a5->B:44:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02c7 A[LOOP:2: B:47:0x02c5->B:48:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0317 A[LOOP:3: B:56:0x0315->B:57:0x0317, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2 = HSHyT0.f933A2egSU;
        int i10 = 0;
        if (getLayoutDirection() == 1) {
            z = true;
            c = 0;
        } else {
            z = false;
            c = 1;
        }
        if (B9tovu(this.f8222AzWtSf)) {
            B7CMnp(this.f8222AzWtSf, i, 0, i2, this.f8233BNL6CD);
            i3 = AaHO0E(this.f8222AzWtSf) + this.f8222AzWtSf.getMeasuredWidth();
            i4 = Math.max(0, AcNBzu(this.f8222AzWtSf) + this.f8222AzWtSf.getMeasuredHeight());
            i5 = View.combineMeasuredStates(0, this.f8222AzWtSf.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (B9tovu(this.f8226B4ZgIw)) {
            B7CMnp(this.f8226B4ZgIw, i, 0, i2, this.f8233BNL6CD);
            i3 = AaHO0E(this.f8226B4ZgIw) + this.f8226B4ZgIw.getMeasuredWidth();
            i4 = Math.max(i4, AcNBzu(this.f8226B4ZgIw) + this.f8226B4ZgIw.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f8226B4ZgIw.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i3);
        int max2 = Math.max(0, currentContentInsetStart - i3);
        boolean z3 = z;
        int[] iArr = this.f8249CikNvS;
        iArr[z3 ? 1 : 0] = max2;
        if (B9tovu(this.f8219AcNBzu)) {
            B7CMnp(this.f8219AcNBzu, i, max, i2, this.f8233BNL6CD);
            i6 = AaHO0E(this.f8219AcNBzu) + this.f8219AcNBzu.getMeasuredWidth();
            i4 = Math.max(i4, AcNBzu(this.f8219AcNBzu) + this.f8219AcNBzu.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f8219AcNBzu.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (B9tovu(this.f8227B7CMnp)) {
            max3 += B4ZgIw(this.f8227B7CMnp, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, AcNBzu(this.f8227B7CMnp) + this.f8227B7CMnp.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f8227B7CMnp.getMeasuredState());
        }
        if (B9tovu(this.f8223B25kr6)) {
            max3 += B4ZgIw(this.f8223B25kr6, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, AcNBzu(this.f8223B25kr6) + this.f8223B25kr6.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.f8223B25kr6.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((GnQT2j) childAt.getLayoutParams()).f892A4TApA == 0 && B9tovu(childAt)) {
                max3 += B4ZgIw(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i4, AcNBzu(childAt) + childAt.getMeasuredHeight());
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                i4 = max4;
            } else {
                max3 = max3;
            }
        }
        int i12 = max3;
        int i13 = this.f8236BV3sI0 + this.f8237BmvVmW;
        int i14 = this.f8234BPw6Q8 + this.f8235BTvldC;
        if (B9tovu(this.f8220AlLFFp)) {
            B4ZgIw(this.f8220AlLFFp, i, i12 + i14, i2, i13, iArr);
            int AaHO0E2 = AaHO0E(this.f8220AlLFFp) + this.f8220AlLFFp.getMeasuredWidth();
            i9 = AcNBzu(this.f8220AlLFFp) + this.f8220AlLFFp.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i5, this.f8220AlLFFp.getMeasuredState());
            i8 = AaHO0E2;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (B9tovu(this.f8221AmA8tU)) {
            i8 = Math.max(i8, B4ZgIw(this.f8221AmA8tU, i, i12 + i14, i2, i13 + i9, iArr));
            i9 += AcNBzu(this.f8221AmA8tU) + this.f8221AmA8tU.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, this.f8221AmA8tU.getMeasuredState());
        }
        int max5 = Math.max(i4, i9);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i12 + i8;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.f8259D8MqeW) {
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                if (!B9tovu(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i10);
        }
        i10 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof H1wUHe)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        H1wUHe h1wUHe = (H1wUHe) parcelable;
        super.onRestoreInstanceState(h1wUHe.getSuperState());
        ActionMenuView actionMenuView = this.f8219AcNBzu;
        AZkASS.AmA8tU amA8tU = actionMenuView != null ? actionMenuView.f8136BPw6Q8 : null;
        int i = h1wUHe.f894AcNBzu;
        if (i != 0 && this.f8256D07BeM != null && amA8tU != null && (findItem = amA8tU.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (h1wUHe.f895AlLFFp) {
            D8MqeW d8MqeW = this.f8263DG07BK;
            removeCallbacks(d8MqeW);
            post(d8MqeW);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        ADYaiT();
        G16Pvp g16Pvp = this.f8238BniPrB;
        boolean z = i == 1;
        if (z == g16Pvp.f867ASJ6gh) {
            return;
        }
        g16Pvp.f867ASJ6gh = z;
        if (!g16Pvp.f868AYUAbz) {
            g16Pvp.f862A2egSU = g16Pvp.AMqCpz;
            g16Pvp.f863A4TApA = g16Pvp.f866ARc23Z;
            return;
        }
        if (z) {
            int i2 = g16Pvp.f865ADYaiT;
            if (i2 == Integer.MIN_VALUE) {
                i2 = g16Pvp.AMqCpz;
            }
            g16Pvp.f862A2egSU = i2;
            int i3 = g16Pvp.f864A5SV6n;
            if (i3 == Integer.MIN_VALUE) {
                i3 = g16Pvp.f866ARc23Z;
            }
            g16Pvp.f863A4TApA = i3;
            return;
        }
        int i4 = g16Pvp.f864A5SV6n;
        if (i4 == Integer.MIN_VALUE) {
            i4 = g16Pvp.AMqCpz;
        }
        g16Pvp.f862A2egSU = i4;
        int i5 = g16Pvp.f865ADYaiT;
        if (i5 == Integer.MIN_VALUE) {
            i5 = g16Pvp.f866ARc23Z;
        }
        g16Pvp.f863A4TApA = i5;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        B25kr6 b25kr6;
        H1wUHe h1wUHe = new H1wUHe(super.onSaveInstanceState());
        GhvxjZ ghvxjZ = this.f8256D07BeM;
        if (ghvxjZ != null && (b25kr6 = ghvxjZ.f889AlLFFp) != null) {
            h1wUHe.f894AcNBzu = b25kr6.f520AcNBzu;
        }
        h1wUHe.f895AlLFFp = B25kr6();
        return h1wUHe;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8245CSDoyG = false;
        }
        if (!this.f8245CSDoyG) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f8245CSDoyG = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f8245CSDoyG = false;
        return true;
    }

    @Override // COJEAR.AmA8tU
    public final void removeMenuProvider(B7CMnp b7CMnp) {
        this.f8250CkXcdM.A4TApA(b7CMnp);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.f8262DAk1zC != z) {
            this.f8262DAk1zC = z;
            BI9f7h();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.f8259D8MqeW = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f8239C2rE4F) {
            this.f8239C2rE4F = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.BpkvW3) {
            this.BpkvW3 = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ASJ6gh();
        this.f8222AzWtSf.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(H0R8Px h0R8Px) {
        this.f8252CqNSpT = h0R8Px;
    }

    public void setOverflowIcon(Drawable drawable) {
        AMqCpz();
        this.f8219AcNBzu.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f8229BChYOn != i) {
            this.f8229BChYOn = i;
            if (i == 0) {
                this.f8228B9tovu = getContext();
            } else {
                this.f8228B9tovu = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.f8237BmvVmW = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f8235BTvldC = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f8234BPw6Q8 = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f8236BV3sI0 = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8240C4FrIb = 8388627;
        this.f8247CcAIMM = new ArrayList();
        this.f8248Cd8JRx = new ArrayList();
        this.f8249CikNvS = new int[2];
        this.f8250CkXcdM = new B3GDIM(new GZqyMh(this, 1));
        this.f8251CmUvjW = new ArrayList();
        this.f8253CrfGsy = new ARc23Z(3, this);
        this.f8263DG07BK = new D8MqeW(4, this);
        Context context2 = getContext();
        int[] iArr = R$styleable.f8037BJ7GGh;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context2, attributeSet, iArr, i);
        DG07BK.B3GDIM(this, context, iArr, attributeSet, ARc23Z2.f884A4TApA, i);
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        this.f8230BI9f7h = typedArray.getResourceId(28, 0);
        this.f8231BIYEnU = typedArray.getResourceId(19, 0);
        this.f8240C4FrIb = typedArray.getInteger(0, 8388627);
        this.f8232BJ7GGh = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f8237BmvVmW = dimensionPixelOffset;
        this.f8236BV3sI0 = dimensionPixelOffset;
        this.f8235BTvldC = dimensionPixelOffset;
        this.f8234BPw6Q8 = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f8234BPw6Q8 = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f8235BTvldC = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f8236BV3sI0 = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f8237BmvVmW = dimensionPixelOffset5;
        }
        this.f8233BNL6CD = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        ADYaiT();
        G16Pvp g16Pvp = this.f8238BniPrB;
        g16Pvp.f868AYUAbz = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            g16Pvp.AMqCpz = dimensionPixelSize;
            g16Pvp.f862A2egSU = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            g16Pvp.f866ARc23Z = dimensionPixelSize2;
            g16Pvp.f863A4TApA = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            g16Pvp.A2egSU(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.BpkvW3 = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f8239C2rE4F = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f8224B2KMhB = ARc23Z2.A4TApA(4);
        this.f8225B3GDIM = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f8228B9tovu = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable A4TApA2 = ARc23Z2.A4TApA(16);
        if (A4TApA2 != null) {
            setNavigationIcon(A4TApA2);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable A4TApA3 = ARc23Z2.A4TApA(11);
        if (A4TApA3 != null) {
            setLogo(A4TApA3);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(ARc23Z2.A2egSU(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(ARc23Z2.A2egSU(20));
        }
        if (typedArray.hasValue(14)) {
            AlLFFp(typedArray.getResourceId(14, 0));
        }
        ARc23Z2.ASJ6gh();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        GnQT2j gnQT2j = new GnQT2j(context, attributeSet);
        gnQT2j.f891A2egSU = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8015A4TApA);
        gnQT2j.f891A2egSU = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        gnQT2j.f892A4TApA = 0;
        return gnQT2j;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            A5SV6n();
        }
        BV3sI0 bV3sI0 = this.f8226B4ZgIw;
        if (bV3sI0 != null) {
            bV3sI0.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            A5SV6n();
            this.f8226B4ZgIw.setImageDrawable(drawable);
        } else {
            BV3sI0 bV3sI0 = this.f8226B4ZgIw;
            if (bV3sI0 != null) {
                bV3sI0.setImageDrawable(this.f8224B2KMhB);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f8223B25kr6 == null) {
                this.f8223B25kr6 = new AppCompatImageView(getContext(), null);
            }
            if (!AzWtSf(this.f8223B25kr6)) {
                A4TApA(this.f8223B25kr6, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f8223B25kr6;
            if (appCompatImageView != null && AzWtSf(appCompatImageView)) {
                removeView(this.f8223B25kr6);
                this.f8248Cd8JRx.remove(this.f8223B25kr6);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f8223B25kr6;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f8223B25kr6 == null) {
            this.f8223B25kr6 = new AppCompatImageView(getContext(), null);
        }
        AppCompatImageView appCompatImageView = this.f8223B25kr6;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ASJ6gh();
        }
        BV3sI0 bV3sI0 = this.f8222AzWtSf;
        if (bV3sI0 != null) {
            bV3sI0.setContentDescription(charSequence);
            A4TApA.DV2E8K(this.f8222AzWtSf, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ASJ6gh();
            if (!AzWtSf(this.f8222AzWtSf)) {
                A4TApA(this.f8222AzWtSf, true);
            }
        } else {
            BV3sI0 bV3sI0 = this.f8222AzWtSf;
            if (bV3sI0 != null && AzWtSf(bV3sI0)) {
                removeView(this.f8222AzWtSf);
                this.f8248Cd8JRx.remove(this.f8222AzWtSf);
            }
        }
        BV3sI0 bV3sI02 = this.f8222AzWtSf;
        if (bV3sI02 != null) {
            bV3sI02.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f8221AmA8tU;
            if (appCompatTextView != null && AzWtSf(appCompatTextView)) {
                removeView(this.f8221AmA8tU);
                this.f8248Cd8JRx.remove(this.f8221AmA8tU);
            }
        } else {
            if (this.f8221AmA8tU == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f8221AmA8tU = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f8221AmA8tU.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f8231BIYEnU;
                if (i != 0) {
                    this.f8221AmA8tU.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f8244CQhlFr;
                if (colorStateList != null) {
                    this.f8221AmA8tU.setTextColor(colorStateList);
                }
            }
            if (!AzWtSf(this.f8221AmA8tU)) {
                A4TApA(this.f8221AmA8tU, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f8221AmA8tU;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f8242CNPG0E = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f8244CQhlFr = colorStateList;
        AppCompatTextView appCompatTextView = this.f8221AmA8tU;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f8220AlLFFp;
            if (appCompatTextView != null && AzWtSf(appCompatTextView)) {
                removeView(this.f8220AlLFFp);
                this.f8248Cd8JRx.remove(this.f8220AlLFFp);
            }
        } else {
            if (this.f8220AlLFFp == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f8220AlLFFp = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f8220AlLFFp.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f8230BI9f7h;
                if (i != 0) {
                    this.f8220AlLFFp.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f8243COJEAR;
                if (colorStateList != null) {
                    this.f8220AlLFFp.setTextColor(colorStateList);
                }
            }
            if (!AzWtSf(this.f8220AlLFFp)) {
                A4TApA(this.f8220AlLFFp, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f8220AlLFFp;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.f8241CASmeH = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f8243COJEAR = colorStateList;
        AppCompatTextView appCompatTextView = this.f8220AlLFFp;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }
}
