package AZkASS;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements BniPrB.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f520AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f521AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f522AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f523AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CharSequence f524B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public CharSequence f525B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Intent f526B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public char f527B4ZgIw;

    /* renamed from: B9tovu, reason: collision with root package name */
    public char f529B9tovu;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Drawable f531BI9f7h;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final AmA8tU f533BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public BpkvW3 f534BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f535BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f536BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public CharSequence f537BV3sI0;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public int f543CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public View f544COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public COJEAR.A5SV6n f545CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f546CSDoyG;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f528B7CMnp = f.a.c;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f530BChYOn = f.a.c;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f532BIYEnU = 0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public ColorStateList f538BmvVmW = null;

    /* renamed from: BniPrB, reason: collision with root package name */
    public PorterDuff.Mode f539BniPrB = null;
    public boolean BpkvW3 = false;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f540C2rE4F = false;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f541C4FrIb = false;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f542CASmeH = 16;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public boolean f547CTkVKb = false;

    public B25kr6(AmA8tU amA8tU, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f533BJ7GGh = amA8tU;
        this.f520AcNBzu = i2;
        this.f521AlLFFp = i;
        this.f522AmA8tU = i3;
        this.f523AzWtSf = i4;
        this.f524B25kr6 = charSequence;
        this.f543CNPG0E = i5;
    }

    public static void A5SV6n(int i, int i2, String str, StringBuilder sb) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    @Override // BniPrB.A2egSU
    public final BniPrB.A2egSU A2egSU(COJEAR.A5SV6n a5SV6n) {
        this.f544COJEAR = null;
        this.f545CQhlFr = a5SV6n;
        this.f533BJ7GGh.B25kr6(true);
        COJEAR.A5SV6n a5SV6n2 = this.f545CQhlFr;
        if (a5SV6n2 != null) {
            B2KMhB b2KMhB = (B2KMhB) a5SV6n2;
            b2KMhB.f548A4TApA = new KCxDWD.A5SV6n(3, this);
            b2KMhB.f549A5SV6n.setVisibilityListener(b2KMhB);
        }
        return this;
    }

    @Override // BniPrB.A2egSU
    public final COJEAR.A5SV6n A4TApA() {
        return this.f545CQhlFr;
    }

    public final Drawable ADYaiT(Drawable drawable) {
        if (drawable != null && this.f541C4FrIb && (this.BpkvW3 || this.f540C2rE4F)) {
            drawable = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
            if (this.BpkvW3) {
                BmvVmW.A2egSU.AYUAbz(drawable, this.f538BmvVmW);
            }
            if (this.f540C2rE4F) {
                BmvVmW.A2egSU.AZOQYO(drawable, this.f539BniPrB);
            }
            this.f541C4FrIb = false;
        }
        return drawable;
    }

    public final boolean AMqCpz() {
        COJEAR.A5SV6n a5SV6n;
        if ((this.f543CNPG0E & 8) != 0) {
            if (this.f544COJEAR == null && (a5SV6n = this.f545CQhlFr) != null) {
                this.f544COJEAR = ((B2KMhB) a5SV6n).f549A5SV6n.onCreateActionView(this);
            }
            if (this.f544COJEAR != null) {
                return true;
            }
        }
        return false;
    }

    public final void ARc23Z(boolean z) {
        this.f542CASmeH = (z ? 4 : 0) | (this.f542CASmeH & (-5));
    }

    public final void ASJ6gh(boolean z) {
        if (z) {
            this.f542CASmeH |= 32;
        } else {
            this.f542CASmeH &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f543CNPG0E & 8) == 0) {
            return false;
        }
        if (this.f544COJEAR == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f546CSDoyG;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f533BJ7GGh.ADYaiT(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!AMqCpz()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f546CSDoyG;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f533BJ7GGh.ARc23Z(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f544COJEAR;
        if (view != null) {
            return view;
        }
        COJEAR.A5SV6n a5SV6n = this.f545CQhlFr;
        if (a5SV6n == null) {
            return null;
        }
        View onCreateActionView = ((B2KMhB) a5SV6n).f549A5SV6n.onCreateActionView(this);
        this.f544COJEAR = onCreateActionView;
        return onCreateActionView;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f530BChYOn;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f529B9tovu;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f536BTvldC;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f521AlLFFp;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f531BI9f7h;
        if (drawable != null) {
            return ADYaiT(drawable);
        }
        if (this.f532BIYEnU == 0) {
            return null;
        }
        Drawable CQhlFr2 = NOd7IU.AlLFFp.CQhlFr(this.f533BJ7GGh.getContext(), this.f532BIYEnU);
        this.f532BIYEnU = 0;
        this.f531BI9f7h = CQhlFr2;
        return ADYaiT(CQhlFr2);
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f538BmvVmW;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f539BniPrB;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f526B3GDIM;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f520AcNBzu;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f528B7CMnp;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f527B4ZgIw;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f522AmA8tU;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f534BNL6CD;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f524B25kr6;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f525B2KMhB;
        return charSequence != null ? charSequence : this.f524B25kr6;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f537BV3sI0;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f534BNL6CD != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f547CTkVKb;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f542CASmeH & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f542CASmeH & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f542CASmeH & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        COJEAR.A5SV6n a5SV6n = this.f545CQhlFr;
        return (a5SV6n == null || !((B2KMhB) a5SV6n).f549A5SV6n.overridesItemVisibility()) ? (this.f542CASmeH & 8) == 0 : (this.f542CASmeH & 8) == 0 && ((B2KMhB) this.f545CQhlFr).f549A5SV6n.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f544COJEAR = view;
        this.f545CQhlFr = null;
        if (view != null && view.getId() == -1 && (i = this.f520AcNBzu) > 0) {
            view.setId(i);
        }
        AmA8tU amA8tU = this.f533BJ7GGh;
        amA8tU.f503BChYOn = true;
        amA8tU.B25kr6(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.f529B9tovu == c) {
            return this;
        }
        this.f529B9tovu = Character.toLowerCase(c);
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i = this.f542CASmeH;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.f542CASmeH = i2;
        if (i != i2) {
            this.f533BJ7GGh.B25kr6(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i = this.f542CASmeH;
        if ((i & 4) == 0) {
            int i2 = (i & (-3)) | (z ? 2 : 0);
            this.f542CASmeH = i2;
            if (i != i2) {
                this.f533BJ7GGh.B25kr6(false);
            }
            return this;
        }
        AmA8tU amA8tU = this.f533BJ7GGh;
        amA8tU.getClass();
        ArrayList arrayList = amA8tU.f498B2KMhB;
        int size = arrayList.size();
        amA8tU.BJ7GGh();
        for (int i3 = 0; i3 < size; i3++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i3);
            if (b25kr6.f521AlLFFp == this.f521AlLFFp && (b25kr6.f542CASmeH & 4) != 0 && b25kr6.isCheckable()) {
                boolean z2 = b25kr6 == this;
                int i4 = b25kr6.f542CASmeH;
                int i5 = (z2 ? 2 : 0) | (i4 & (-3));
                b25kr6.f542CASmeH = i5;
                if (i4 != i5) {
                    b25kr6.f533BJ7GGh.B25kr6(false);
                }
            }
        }
        amA8tU.BIYEnU();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f542CASmeH |= 16;
        } else {
            this.f542CASmeH &= -17;
        }
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f532BIYEnU = 0;
        this.f531BI9f7h = drawable;
        this.f541C4FrIb = true;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f538BmvVmW = colorStateList;
        this.BpkvW3 = true;
        this.f541C4FrIb = true;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f539BniPrB = mode;
        this.f540C2rE4F = true;
        this.f541C4FrIb = true;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f526B3GDIM = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.f527B4ZgIw == c) {
            return this;
        }
        this.f527B4ZgIw = c;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f546CSDoyG = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f535BPw6Q8 = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.f527B4ZgIw = c;
        this.f529B9tovu = Character.toLowerCase(c2);
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f543CNPG0E = i;
        AmA8tU amA8tU = this.f533BJ7GGh;
        amA8tU.f503BChYOn = true;
        amA8tU.B25kr6(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f524B25kr6 = charSequence;
        this.f533BJ7GGh.B25kr6(false);
        BpkvW3 bpkvW3 = this.f534BNL6CD;
        if (bpkvW3 != null) {
            bpkvW3.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f525B2KMhB = charSequence;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i = this.f542CASmeH;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.f542CASmeH = i2;
        if (i != i2) {
            AmA8tU amA8tU = this.f533BJ7GGh;
            amA8tU.f500B4ZgIw = true;
            amA8tU.B25kr6(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f524B25kr6;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final BniPrB.A2egSU setContentDescription(CharSequence charSequence) {
        this.f536BTvldC = charSequence;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final BniPrB.A2egSU setTooltipText(CharSequence charSequence) {
        this.f537BV3sI0 = charSequence;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f529B9tovu == c && this.f530BChYOn == i) {
            return this;
        }
        this.f529B9tovu = Character.toLowerCase(c);
        this.f530BChYOn = KeyEvent.normalizeMetaState(i);
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.f527B4ZgIw == c && this.f528B7CMnp == i) {
            return this;
        }
        this.f527B4ZgIw = c;
        this.f528B7CMnp = KeyEvent.normalizeMetaState(i);
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f527B4ZgIw = c;
        this.f528B7CMnp = KeyEvent.normalizeMetaState(i);
        this.f529B9tovu = Character.toLowerCase(c2);
        this.f530BChYOn = KeyEvent.normalizeMetaState(i2);
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f531BI9f7h = null;
        this.f532BIYEnU = i;
        this.f541C4FrIb = true;
        this.f533BJ7GGh.B25kr6(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f533BJ7GGh.getContext().getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i2;
        Context context = this.f533BJ7GGh.getContext();
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f544COJEAR = inflate;
        this.f545CQhlFr = null;
        if (inflate != null && inflate.getId() == -1 && (i2 = this.f520AcNBzu) > 0) {
            inflate.setId(i2);
        }
        AmA8tU amA8tU = this.f533BJ7GGh;
        amA8tU.f503BChYOn = true;
        amA8tU.B25kr6(true);
        return this;
    }
}
