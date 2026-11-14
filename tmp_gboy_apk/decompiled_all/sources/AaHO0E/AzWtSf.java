package AaHO0E;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf extends AZkASS.A4TApA {

    /* renamed from: B9tovu, reason: collision with root package name */
    public AcNBzu f611B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Drawable f612BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f613BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f614BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f615BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f616BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f617BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f618BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f619BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final SparseBooleanArray f620BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public AYUAbz f621BniPrB;
    public AYUAbz BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public AZkASS f622C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public AZOQYO f623C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final AZkASS.ARc23Z f624CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public int f625CNPG0E;

    public AzWtSf(Context context) {
        this.f432AcNBzu = context;
        this.f435AzWtSf = LayoutInflater.from(context);
        this.f437B2KMhB = 2131492869;
        this.f438B3GDIM = 2131492868;
        this.f620BmvVmW = new SparseBooleanArray();
        this.f624CASmeH = new AZkASS.ARc23Z(1, this);
    }

    @Override // AZkASS.BNL6CD
    public final void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
        AcNBzu();
        AYUAbz aYUAbz = this.BpkvW3;
        if (aYUAbz != null && aYUAbz.A4TApA()) {
            aYUAbz.f568AZOQYO.dismiss();
        }
        AZkASS.BJ7GGh bJ7GGh = this.f436B25kr6;
        if (bJ7GGh != null) {
            bJ7GGh.A2egSU(amA8tU, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // AZkASS.BNL6CD
    public final void A4TApA(boolean z) {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.f439B4ZgIw;
        ArrayList arrayList = null;
        boolean z2 = false;
        if (viewGroup != null) {
            AZkASS.AmA8tU amA8tU = this.f434AmA8tU;
            if (amA8tU != null) {
                amA8tU.AZOQYO();
                ArrayList AcNBzu2 = this.f434AmA8tU.AcNBzu();
                int size = AcNBzu2.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    AZkASS.B25kr6 b25kr6 = (AZkASS.B25kr6) AcNBzu2.get(i2);
                    if ((b25kr6.f542CASmeH & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        AZkASS.B25kr6 itemData = childAt instanceof AZkASS.BPw6Q8 ? ((AZkASS.BPw6Q8) childAt).getItemData() : null;
                        View AMqCpz = AMqCpz(b25kr6, childAt, viewGroup);
                        if (b25kr6 != itemData) {
                            AMqCpz.setPressed(false);
                            AMqCpz.jumpDrawablesToCurrentState();
                        }
                        if (AMqCpz != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) AMqCpz.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(AMqCpz);
                            }
                            ((ViewGroup) this.f439B4ZgIw).addView(AMqCpz, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.f611B9tovu) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.f439B4ZgIw).requestLayout();
        AZkASS.AmA8tU amA8tU2 = this.f434AmA8tU;
        if (amA8tU2 != null) {
            amA8tU2.AZOQYO();
            ArrayList arrayList2 = amA8tU2.f501B7CMnp;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                COJEAR.A5SV6n a5SV6n = ((AZkASS.B25kr6) arrayList2.get(i3)).f545CQhlFr;
            }
        }
        AZkASS.AmA8tU amA8tU3 = this.f434AmA8tU;
        if (amA8tU3 != null) {
            amA8tU3.AZOQYO();
            arrayList = amA8tU3.f502B9tovu;
        }
        if (this.f614BIYEnU && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z2 = !((AZkASS.B25kr6) arrayList.get(0)).f547CTkVKb;
            } else if (size3 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f611B9tovu == null) {
                this.f611B9tovu = new AcNBzu(this, this.f432AcNBzu);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f611B9tovu.getParent();
            if (viewGroup3 != this.f439B4ZgIw) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f611B9tovu);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f439B4ZgIw;
                AcNBzu acNBzu = this.f611B9tovu;
                actionMenuView.getClass();
                B2KMhB AZkASS2 = ActionMenuView.AZkASS();
                AZkASS2.f626A2egSU = true;
                actionMenuView.addView(acNBzu, AZkASS2);
            }
        } else {
            AcNBzu acNBzu2 = this.f611B9tovu;
            if (acNBzu2 != null) {
                Object parent = acNBzu2.getParent();
                Object obj = this.f439B4ZgIw;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f611B9tovu);
                }
            }
        }
        ((ActionMenuView) this.f439B4ZgIw).setOverflowReserved(this.f614BIYEnU);
    }

    @Override // AZkASS.BNL6CD
    public final boolean A5SV6n() {
        ArrayList arrayList;
        int i;
        int i2;
        boolean z;
        AzWtSf azWtSf = this;
        AZkASS.AmA8tU amA8tU = azWtSf.f434AmA8tU;
        if (amA8tU != null) {
            arrayList = amA8tU.AcNBzu();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i3 = azWtSf.f618BTvldC;
        int i4 = azWtSf.f617BPw6Q8;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) azWtSf.f439B4ZgIw;
        int i5 = 0;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            AZkASS.B25kr6 b25kr6 = (AZkASS.B25kr6) arrayList.get(i5);
            int i8 = b25kr6.f543CNPG0E;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z2 = true;
            }
            if (azWtSf.f619BV3sI0 && b25kr6.f547CTkVKb) {
                i3 = 0;
            }
            i5++;
        }
        if (azWtSf.f614BIYEnU && (z2 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = azWtSf.f620BmvVmW;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            AZkASS.B25kr6 b25kr62 = (AZkASS.B25kr6) arrayList.get(i10);
            int i12 = b25kr62.f543CNPG0E;
            boolean z3 = (i12 & 2) == i2;
            int i13 = b25kr62.f521AlLFFp;
            if (z3) {
                View AMqCpz = azWtSf.AMqCpz(b25kr62, null, viewGroup);
                AMqCpz.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = AMqCpz.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                b25kr62.ASJ6gh(z);
            } else if ((i12 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i13);
                boolean z5 = (i9 > 0 || z4) && i4 > 0;
                if (z5) {
                    View AMqCpz2 = azWtSf.AMqCpz(b25kr62, null, viewGroup);
                    AMqCpz2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = AMqCpz2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z5 &= i4 + i11 > 0;
                }
                if (z5 && i13 != 0) {
                    sparseBooleanArray.put(i13, true);
                } else if (z4) {
                    sparseBooleanArray.put(i13, false);
                    for (int i14 = 0; i14 < i10; i14++) {
                        AZkASS.B25kr6 b25kr63 = (AZkASS.B25kr6) arrayList.get(i14);
                        if (b25kr63.f521AlLFFp == i13) {
                            if ((b25kr63.f542CASmeH & 32) == 32) {
                                i9++;
                            }
                            b25kr63.ASJ6gh(false);
                        }
                    }
                }
                if (z5) {
                    i9--;
                }
                b25kr62.ASJ6gh(z5);
            } else {
                b25kr62.ASJ6gh(false);
                i10++;
                i2 = 2;
                azWtSf = this;
                z = true;
            }
            i10++;
            i2 = 2;
            azWtSf = this;
            z = true;
        }
        return true;
    }

    @Override // AZkASS.BNL6CD
    public final void ADYaiT(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof AmA8tU) && (i = ((AmA8tU) parcelable).f610AcNBzu) > 0 && (findItem = this.f434AmA8tU.findItem(i)) != null) {
            ARc23Z((AZkASS.BpkvW3) findItem.getSubMenu());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [AZkASS.BPw6Q8] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View AMqCpz(AZkASS.B25kr6 b25kr6, View view, ViewGroup viewGroup) {
        View actionView = b25kr6.getActionView();
        if (actionView == null || b25kr6.AMqCpz()) {
            ActionMenuItemView actionMenuItemView = view instanceof AZkASS.BPw6Q8 ? (AZkASS.BPw6Q8) view : (AZkASS.BPw6Q8) this.f435AzWtSf.inflate(this.f438B3GDIM, viewGroup, false);
            actionMenuItemView.A2egSU(b25kr6);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f439B4ZgIw);
            if (this.f623C4FrIb == null) {
                this.f623C4FrIb = new AZOQYO(this);
            }
            actionMenuItemView2.setPopupCallback(this.f623C4FrIb);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(b25kr6.f547CTkVKb ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof B2KMhB)) {
            actionView.setLayoutParams(ActionMenuView.AaHO0E(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // AZkASS.BNL6CD
    public final boolean ARc23Z(AZkASS.BpkvW3 bpkvW3) {
        boolean z;
        if (bpkvW3.hasVisibleItems()) {
            AZkASS.BpkvW3 bpkvW32 = bpkvW3;
            while (true) {
                AZkASS.AmA8tU amA8tU = bpkvW32.f591CQhlFr;
                if (amA8tU == this.f434AmA8tU) {
                    break;
                }
                bpkvW32 = (AZkASS.BpkvW3) amA8tU;
            }
            ViewGroup viewGroup = (ViewGroup) this.f439B4ZgIw;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof AZkASS.BPw6Q8) && ((AZkASS.BPw6Q8) childAt).getItemData() == bpkvW32.f592CSDoyG) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                this.f625CNPG0E = bpkvW3.f592CSDoyG.f520AcNBzu;
                int size = bpkvW3.f498B2KMhB.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = bpkvW3.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                AYUAbz aYUAbz = new AYUAbz(this, this.f433AlLFFp, bpkvW3, view);
                this.BpkvW3 = aYUAbz;
                aYUAbz.f566ASJ6gh = z;
                AZkASS.BChYOn bChYOn = aYUAbz.f568AZOQYO;
                if (bChYOn != null) {
                    bChYOn.AzWtSf(z);
                }
                AYUAbz aYUAbz2 = this.BpkvW3;
                if (!aYUAbz2.A4TApA()) {
                    if (aYUAbz2.AMqCpz == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    aYUAbz2.ADYaiT(0, 0, false, false);
                }
                AZkASS.BJ7GGh bJ7GGh = this.f436B25kr6;
                if (bJ7GGh != null) {
                    bJ7GGh.AMqCpz(bpkvW3);
                }
                return true;
            }
        }
        return false;
    }

    @Override // AZkASS.BNL6CD
    public final Parcelable AYUAbz() {
        AmA8tU amA8tU = new AmA8tU();
        amA8tU.f610AcNBzu = this.f625CNPG0E;
        return amA8tU;
    }

    @Override // AZkASS.BNL6CD
    public final void AZkASS(Context context, AZkASS.AmA8tU amA8tU) {
        this.f433AlLFFp = context;
        LayoutInflater.from(context);
        this.f434AmA8tU = amA8tU;
        Resources resources = context.getResources();
        if (!this.f615BJ7GGh) {
            this.f614BIYEnU = true;
        }
        int i = 2;
        this.f616BNL6CD = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.f618BTvldC = i;
        int i4 = this.f616BNL6CD;
        if (this.f614BIYEnU) {
            if (this.f611B9tovu == null) {
                AcNBzu acNBzu = new AcNBzu(this, this.f432AcNBzu);
                this.f611B9tovu = acNBzu;
                if (this.f613BI9f7h) {
                    acNBzu.setImageDrawable(this.f612BChYOn);
                    this.f612BChYOn = null;
                    this.f613BI9f7h = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f611B9tovu.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.f611B9tovu.getMeasuredWidth();
        } else {
            this.f611B9tovu = null;
        }
        this.f617BPw6Q8 = i4;
        float f = resources.getDisplayMetrics().density;
    }

    public final boolean AcNBzu() {
        Object obj;
        AZkASS aZkASS = this.f622C2rE4F;
        if (aZkASS != null && (obj = this.f439B4ZgIw) != null) {
            ((View) obj).removeCallbacks(aZkASS);
            this.f622C2rE4F = null;
            return true;
        }
        AYUAbz aYUAbz = this.f621BniPrB;
        if (aYUAbz == null) {
            return false;
        }
        if (aYUAbz.A4TApA()) {
            aYUAbz.f568AZOQYO.dismiss();
        }
        return true;
    }

    public final boolean AlLFFp() {
        AYUAbz aYUAbz = this.f621BniPrB;
        return aYUAbz != null && aYUAbz.A4TApA();
    }

    public final boolean AmA8tU() {
        AZkASS.AmA8tU amA8tU;
        if (!this.f614BIYEnU || AlLFFp() || (amA8tU = this.f434AmA8tU) == null || this.f439B4ZgIw == null || this.f622C2rE4F != null) {
            return false;
        }
        amA8tU.AZOQYO();
        if (amA8tU.f502B9tovu.isEmpty()) {
            return false;
        }
        AZkASS aZkASS = new AZkASS(this, new AYUAbz(this, this.f433AlLFFp, this.f434AmA8tU, this.f611B9tovu));
        this.f622C2rE4F = aZkASS;
        ((View) this.f439B4ZgIw).post(aZkASS);
        return true;
    }
}
