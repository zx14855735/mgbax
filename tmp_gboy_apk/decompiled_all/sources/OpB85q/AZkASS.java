package OpB85q;

import AZkASS.BTvldC;
import Oay4Bh.BpkvW3;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZkASS extends ViewGroup implements BTvldC {

    /* renamed from: DV2E8K, reason: collision with root package name */
    public static final int[] f6730DV2E8K = {R.attr.state_checked};

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public static final int[] f6731DXnQ0V = {-16842910};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final DaOi9o.A2egSU f6732AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ADYaiT.A5SV6n f6733AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CNPG0E.A5SV6n f6734AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final SparseArray f6735AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f6736B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f6737B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AZOQYO[] f6738B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f6739B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f6740B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public ColorStateList f6741B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f6742BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f6743BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ColorStateList f6744BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f6745BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f6746BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f6747BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f6748BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f6749BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public Drawable f6750BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public ColorStateList f6751BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final SparseArray f6752C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public int f6753C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f6754CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public int f6755CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f6756COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public boolean f6757CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f6758CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f6759CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f6760CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public int f6761Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f6762CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f6763CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public int f6764CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public PCV8se.B2KMhB f6765CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public boolean f6766CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public ColorStateList f6767CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public AcNBzu f6768CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public AYUAbz f6769D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public boolean f6770D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public boolean f6771D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public int f6772D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f6773D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public boolean f6774D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public MenuItem f6775DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f6776DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public boolean f6777DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final Rect f6778DUi7mC;

    static {
        AHAVH();
    }

    public AZkASS(Context context) {
        super(context);
        this.f6735AzWtSf = new SparseArray();
        this.f6739B4ZgIw = -1;
        this.f6740B7CMnp = -1;
        this.f6752C2rE4F = new SparseArray();
        this.f6753C4FrIb = -1;
        this.f6754CASmeH = -1;
        this.f6755CNPG0E = -1;
        this.f6756COJEAR = -1;
        this.f6764CmUvjW = 49;
        this.f6766CrfGsy = false;
        this.f6772D8MqeW = 1;
        this.f6773D8cQ8b = 0;
        this.f6775DAk1zC = null;
        this.f6776DG07BK = 7;
        this.f6777DRlcZ9 = false;
        this.f6778DUi7mC = new Rect();
        this.f6744BIYEnU = A4TApA();
        if (isInEditMode()) {
            this.f6732AcNBzu = null;
        } else {
            DaOi9o.A2egSU a2egSU = new DaOi9o.A2egSU();
            this.f6732AcNBzu = a2egSU;
            a2egSU.CTkVKb(0);
            a2egSU.AzWtSf();
            a2egSU.BV3sI0(com.bumptech.glide.A5SV6n.D07BeM(getContext(), 2130969623, getResources().getInteger(2131361834)));
            a2egSU.BniPrB(com.bumptech.glide.A5SV6n.D6DOie(getContext(), 2130969636, NdEzCJ.A2egSU.f6037A4TApA));
            a2egSU.COJEAR(new BpkvW3());
        }
        this.f6733AlLFFp = new ADYaiT.A5SV6n(16, this);
        setImportantForAccessibility(1);
    }

    private static /* synthetic */ void AHAVH() {
        char[] charArray = "ðüþ½ôòþö½ñüê½àûöÿÿ½ÙýúÑáú÷ôö".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 147);
        }
        String str = new String(charArray);
        char[] charArray2 = "ðÿúýúç".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 147);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean ASJ6gh(int i, int i2) {
        return i == -1 ? i2 > 3 : i == 0;
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.f6776DG07BK, this.f6769D07BeM.AMqCpz);
    }

    private ARc23Z getNewItem() {
        CNPG0E.A5SV6n a5SV6n = this.f6734AmA8tU;
        ARc23Z aRc23Z = a5SV6n != null ? (ARc23Z) a5SV6n.A2egSU() : null;
        return aRc23Z == null ? ARc23Z(getContext()) : aRc23Z;
    }

    private void setBadgeIfNeeded(ARc23Z aRc23Z) {
        NpX2pY.A2egSU a2egSU;
        int id = aRc23Z.getId();
        if (id == -1 || (a2egSU = (NpX2pY.A2egSU) this.f6752C2rE4F.get(id)) == null) {
            return;
        }
        aRc23Z.setBadge(a2egSU);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A2egSU() {
        ARc23Z aRc23Z;
        removeAllViews();
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null && this.f6734AmA8tU != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ARc23Z aRc23Z2 = (ARc23Z) azoqyo;
                    this.f6734AmA8tU.A5SV6n(aRc23Z2);
                    if (aRc23Z2.f6716DXnQ0V != null) {
                        ImageView imageView = aRc23Z2.f6687BniPrB;
                        if (imageView != null) {
                            aRc23Z2.setClipChildren(true);
                            aRc23Z2.setClipToPadding(true);
                            NpX2pY.A2egSU a2egSU = aRc23Z2.f6716DXnQ0V;
                            if (a2egSU != null) {
                                if (a2egSU.AMqCpz() != null) {
                                    a2egSU.AMqCpz().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(a2egSU);
                                }
                            }
                        }
                        aRc23Z2.f6716DXnQ0V = null;
                    }
                    aRc23Z2.f6701CqNSpT = null;
                    aRc23Z2.f6707D6yqiO = 0.0f;
                    aRc23Z2.f6668AcNBzu = false;
                }
            }
        }
        this.f6768CtxOCS.f6782AlLFFp = true;
        this.f6769D07BeM.A4TApA();
        this.f6768CtxOCS.f6782AlLFFp = false;
        int i = this.f6769D07BeM.f6728A5SV6n;
        if (i == 0) {
            this.f6739B4ZgIw = 0;
            this.f6740B7CMnp = 0;
            this.f6738B3GDIM = null;
            this.f6734AmA8tU = null;
            return;
        }
        if (this.f6734AmA8tU == null || this.f6773D8cQ8b != i) {
            this.f6773D8cQ8b = i;
            this.f6734AmA8tU = new CNPG0E.A5SV6n(i);
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.f6769D07BeM.f6727A4TApA.size(); i2++) {
            hashSet.add(Integer.valueOf(this.f6769D07BeM.A2egSU(i2).getItemId()));
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f6752C2rE4F;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                sparseArray.delete(keyAt);
            }
            i3++;
        }
        int size = this.f6769D07BeM.f6727A4TApA.size();
        this.f6738B3GDIM = new AZOQYO[size];
        boolean ASJ6gh2 = ASJ6gh(this.f6736B25kr6, getCurrentVisibleContentItemCount());
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem A2egSU2 = this.f6769D07BeM.A2egSU(i6);
            boolean z = A2egSU2 instanceof A2egSU;
            if (z) {
                Context context = getContext();
                A5SV6n a5SV6n = new A5SV6n(context);
                LayoutInflater.from(context).inflate(2131493204, (ViewGroup) a5SV6n, true);
                a5SV6n.A4TApA();
                a5SV6n.setOnlyShowWhenExpanded(true);
                a5SV6n.setDividersEnabled(this.f6777DRlcZ9);
                aRc23Z = a5SV6n;
            } else if (A2egSU2.hasSubMenu()) {
                if (i4 > 0) {
                    throw new IllegalArgumentException("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                }
                AlLFFp alLFFp = new AlLFFp(getContext());
                int i7 = this.f6748BTvldC;
                if (i7 == 0) {
                    i7 = this.f6746BNL6CD;
                }
                alLFFp.setTextAppearance(i7);
                alLFFp.setTextColor(this.f6743BI9f7h);
                alLFFp.setOnlyShowWhenExpanded(true);
                alLFFp.A2egSU((AZkASS.B25kr6) A2egSU2);
                i4 = A2egSU2.getSubMenu().size();
                aRc23Z = alLFFp;
            } else if (i4 > 0) {
                i4--;
                aRc23Z = AMqCpz(i6, (AZkASS.B25kr6) A2egSU2, ASJ6gh2, true);
            } else {
                AZkASS.B25kr6 b25kr6 = (AZkASS.B25kr6) A2egSU2;
                boolean z2 = i5 >= this.f6776DG07BK;
                i5++;
                aRc23Z = AMqCpz(i6, b25kr6, ASJ6gh2, z2);
            }
            if (!z && A2egSU2.isCheckable() && this.f6740B7CMnp == -1) {
                this.f6740B7CMnp = i6;
            }
            this.f6738B3GDIM[i6] = aRc23Z;
            addView(aRc23Z);
        }
        int min = Math.min(size - 1, this.f6740B7CMnp);
        this.f6740B7CMnp = min;
        setCheckedItem(this.f6738B3GDIM[min].getItemData());
    }

    public final ColorStateList A4TApA() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(2130968881, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = A5SV6n2.getDefaultColor();
        int[] iArr = f6731DXnQ0V;
        return new ColorStateList(new int[][]{iArr, f6730DV2E8K, ViewGroup.EMPTY_STATE_SET}, new int[]{A5SV6n2.getColorForState(iArr, defaultColor), i, defaultColor});
    }

    @Override // AZkASS.BTvldC
    public final void A5SV6n(AZkASS.AmA8tU amA8tU) {
        this.f6769D07BeM = new AYUAbz(amA8tU);
    }

    public final PCV8se.AaHO0E ADYaiT() {
        if (this.f6765CqNSpT == null || this.f6767CtFAbx == null) {
            return null;
        }
        PCV8se.AaHO0E aaHO0E = new PCV8se.AaHO0E(this.f6765CqNSpT);
        aaHO0E.B3GDIM(this.f6767CtFAbx);
        return aaHO0E;
    }

    public final ARc23Z AMqCpz(int i, AZkASS.B25kr6 b25kr6, boolean z, boolean z2) {
        this.f6768CtxOCS.f6782AlLFFp = true;
        b25kr6.setCheckable(true);
        this.f6768CtxOCS.f6782AlLFFp = false;
        ARc23Z newItem = getNewItem();
        newItem.setShifting(z);
        newItem.setLabelMaxLines(this.f6772D8MqeW);
        newItem.setIconTintList(this.f6741B9tovu);
        newItem.setIconSize(this.f6742BChYOn);
        newItem.setTextColor(this.f6744BIYEnU);
        newItem.setTextAppearanceInactive(this.f6745BJ7GGh);
        newItem.setTextAppearanceActive(this.f6746BNL6CD);
        newItem.setHorizontalTextAppearanceInactive(this.f6747BPw6Q8);
        newItem.setHorizontalTextAppearanceActive(this.f6748BTvldC);
        newItem.setTextAppearanceActiveBoldEnabled(this.f6749BV3sI0);
        newItem.setTextColor(this.f6743BI9f7h);
        int i2 = this.f6753C4FrIb;
        if (i2 != -1) {
            newItem.setItemPaddingTop(i2);
        }
        int i3 = this.f6754CASmeH;
        if (i3 != -1) {
            newItem.setItemPaddingBottom(i3);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.f6770D6DOie);
        newItem.setLabelFontScalingEnabled(this.f6771D6yqiO);
        int i4 = this.f6755CNPG0E;
        if (i4 != -1) {
            newItem.setActiveIndicatorLabelPadding(i4);
        }
        int i5 = this.f6756COJEAR;
        if (i5 != -1) {
            newItem.setIconLabelHorizontalSpacing(i5);
        }
        newItem.setActiveIndicatorWidth(this.f6758CSDoyG);
        newItem.setActiveIndicatorHeight(this.f6759CTkVKb);
        newItem.setActiveIndicatorExpandedWidth(this.f6760CcAIMM);
        newItem.setActiveIndicatorExpandedHeight(this.f6761Cd8JRx);
        newItem.setActiveIndicatorMarginHorizontal(this.f6762CikNvS);
        newItem.setItemGravity(this.f6764CmUvjW);
        newItem.setActiveIndicatorExpandedPadding(this.f6778DUi7mC);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.f6763CkXcdM);
        newItem.setActiveIndicatorDrawable(ADYaiT());
        newItem.setActiveIndicatorResizeable(this.f6766CrfGsy);
        newItem.setActiveIndicatorEnabled(this.f6757CQhlFr);
        Drawable drawable = this.f6750BmvVmW;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.BpkvW3);
        }
        newItem.setItemRippleColor(this.f6751BniPrB);
        newItem.setLabelVisibilityMode(this.f6736B25kr6);
        newItem.setItemIconGravity(this.f6737B2KMhB);
        newItem.setOnlyShowWhenExpanded(z2);
        newItem.setExpanded(this.f6774D9tr6l);
        newItem.A2egSU(b25kr6);
        newItem.setItemPosition(i);
        SparseArray sparseArray = this.f6735AzWtSf;
        int i6 = b25kr6.f520AcNBzu;
        newItem.setOnTouchListener((View.OnTouchListener) sparseArray.get(i6));
        newItem.setOnClickListener(this.f6733AlLFFp);
        int i7 = this.f6739B4ZgIw;
        if (i7 != 0 && i6 == i7) {
            this.f6740B7CMnp = i;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    public abstract ARc23Z ARc23Z(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.f6755CNPG0E;
    }

    public SparseArray<NpX2pY.A2egSU> getBadgeDrawables() {
        return this.f6752C2rE4F;
    }

    public int getCurrentVisibleContentItemCount() {
        return this.f6774D9tr6l ? this.f6769D07BeM.f6729ADYaiT : getCollapsedVisibleItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.f6748BTvldC;
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.f6747BPw6Q8;
    }

    public int getIconLabelHorizontalSpacing() {
        return this.f6756COJEAR;
    }

    public ColorStateList getIconTintList() {
        return this.f6741B9tovu;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f6767CtFAbx;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f6757CQhlFr;
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.f6761Cd8JRx;
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.f6763CkXcdM;
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.f6760CcAIMM;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f6759CTkVKb;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f6762CikNvS;
    }

    public PCV8se.B2KMhB getItemActiveIndicatorShapeAppearance() {
        return this.f6765CqNSpT;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f6758CSDoyG;
    }

    public Drawable getItemBackground() {
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null && azoqyoArr.length > 0) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    return ((ARc23Z) azoqyo).getBackground();
                }
            }
        }
        return this.f6750BmvVmW;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.BpkvW3;
    }

    public int getItemGravity() {
        return this.f6764CmUvjW;
    }

    public int getItemIconGravity() {
        return this.f6737B2KMhB;
    }

    public int getItemIconSize() {
        return this.f6742BChYOn;
    }

    public int getItemPaddingBottom() {
        return this.f6754CASmeH;
    }

    public int getItemPaddingTop() {
        return this.f6753C4FrIb;
    }

    public ColorStateList getItemRippleColor() {
        return this.f6751BniPrB;
    }

    public int getItemTextAppearanceActive() {
        return this.f6746BNL6CD;
    }

    public int getItemTextAppearanceInactive() {
        return this.f6745BJ7GGh;
    }

    public ColorStateList getItemTextColor() {
        return this.f6743BI9f7h;
    }

    public int getLabelMaxLines() {
        return this.f6772D8MqeW;
    }

    public int getLabelVisibilityMode() {
        return this.f6736B25kr6;
    }

    public AYUAbz getMenu() {
        return this.f6769D07BeM;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.f6771D6yqiO;
    }

    public int getSelectedItemId() {
        return this.f6739B4ZgIw;
    }

    public int getSelectedItemPosition() {
        return this.f6740B7CMnp;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AZkASS.ARc23Z.BJ7GGh(1, getCurrentVisibleContentItemCount(), 1, false).f451AlLFFp);
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.f6755CNPG0E = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorLabelPadding(i);
                }
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        if (this.f6775DAk1zC == menuItem || !menuItem.isCheckable()) {
            return;
        }
        MenuItem menuItem2 = this.f6775DAk1zC;
        if (menuItem2 != null && menuItem2.isChecked()) {
            this.f6775DAk1zC.setChecked(false);
        }
        menuItem.setChecked(true);
        this.f6775DAk1zC = menuItem;
    }

    public void setCollapsedMaxItemCount(int i) {
        this.f6776DG07BK = i;
    }

    public void setExpanded(boolean z) {
        this.f6774D9tr6l = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                azoqyo.setExpanded(z);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.f6748BTvldC = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setHorizontalTextAppearanceActive(i);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.f6747BPw6Q8 = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setHorizontalTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.f6756COJEAR = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setIconLabelHorizontalSpacing(i);
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f6741B9tovu = colorStateList;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f6767CtFAbx = colorStateList;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorDrawable(ADYaiT());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.f6757CQhlFr = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorEnabled(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.f6761Cd8JRx = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorExpandedHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.f6763CkXcdM = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorExpandedMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.f6760CcAIMM = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorExpandedWidth(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.f6759CTkVKb = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.f6762CikNvS = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.f6766CrfGsy = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorResizeable(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(PCV8se.B2KMhB b2KMhB) {
        this.f6765CqNSpT = b2KMhB;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorDrawable(ADYaiT());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.f6758CSDoyG = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setActiveIndicatorWidth(i);
                }
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f6750BmvVmW = drawable;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.BpkvW3 = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemBackground(i);
                }
            }
        }
    }

    public void setItemGravity(int i) {
        this.f6764CmUvjW = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemGravity(i);
                }
            }
        }
    }

    public void setItemIconGravity(int i) {
        this.f6737B2KMhB = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemIconGravity(i);
                }
            }
        }
    }

    public void setItemIconSize(int i) {
        this.f6742BChYOn = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setIconSize(i);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.f6754CASmeH = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemPaddingBottom(this.f6754CASmeH);
                }
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.f6753C4FrIb = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemPaddingTop(i);
                }
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f6751BniPrB = colorStateList;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.f6746BNL6CD = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setTextAppearanceActive(i);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.f6749BV3sI0 = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setTextAppearanceActiveBoldEnabled(z);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f6745BJ7GGh = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f6743BI9f7h = colorStateList;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.f6771D6yqiO = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setLabelFontScalingEnabled(z);
                }
            }
        }
    }

    public void setLabelMaxLines(int i) {
        this.f6772D8MqeW = i;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setLabelMaxLines(i);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.f6736B25kr6 = i;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z) {
        this.f6770D6DOie = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof ARc23Z) {
                    ((ARc23Z) azoqyo).setMeasureBottomPaddingFromLabelBaseline(z);
                }
            }
        }
    }

    public void setPresenter(AcNBzu acNBzu) {
        this.f6768CtxOCS = acNBzu;
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.f6777DRlcZ9 == z) {
            return;
        }
        this.f6777DRlcZ9 = z;
        AZOQYO[] azoqyoArr = this.f6738B3GDIM;
        if (azoqyoArr != null) {
            for (AZOQYO azoqyo : azoqyoArr) {
                if (azoqyo instanceof A5SV6n) {
                    ((A5SV6n) azoqyo).setDividersEnabled(z);
                }
            }
        }
    }
}
