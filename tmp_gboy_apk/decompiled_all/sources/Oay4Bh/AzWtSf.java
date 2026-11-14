package Oay4Bh;

import COJEAR.DG07BK;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.NavigationMenuItemView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f6537AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AZkASS.B25kr6 f6538AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6539AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ BI9f7h f6540AzWtSf;

    public AzWtSf(BI9f7h bI9f7h) {
        this.f6540AzWtSf = bI9f7h;
        A2egSU();
    }

    public final void A2egSU() {
        if (this.f6539AmA8tU) {
            return;
        }
        this.f6539AmA8tU = true;
        ArrayList arrayList = this.f6537AcNBzu;
        arrayList.clear();
        arrayList.add(new B25kr6());
        BI9f7h bI9f7h = this.f6540AzWtSf;
        int size = bI9f7h.f6548AmA8tU.AcNBzu().size();
        boolean z = false;
        int i = -1;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (i2 < size) {
            AZkASS.B25kr6 b25kr6 = (AZkASS.B25kr6) bI9f7h.f6548AmA8tU.AcNBzu().get(i2);
            if (b25kr6.isChecked()) {
                A4TApA(b25kr6);
            }
            if (b25kr6.isCheckable()) {
                b25kr6.ARc23Z(z);
            }
            if (b25kr6.hasSubMenu()) {
                AZkASS.BpkvW3 bpkvW3 = b25kr6.f534BNL6CD;
                if (bpkvW3.hasVisibleItems()) {
                    if (i2 != 0) {
                        arrayList.add(new B3GDIM(bI9f7h.f6571CQhlFr, z ? 1 : 0));
                    }
                    arrayList.add(new B4ZgIw(b25kr6));
                    int size2 = bpkvW3.f498B2KMhB.size();
                    int i4 = 0;
                    boolean z3 = false;
                    while (i4 < size2) {
                        AZkASS.B25kr6 b25kr62 = (AZkASS.B25kr6) bpkvW3.getItem(i4);
                        if (b25kr62.isVisible()) {
                            if (!z3 && b25kr62.getIcon() != null) {
                                z3 = true;
                            }
                            if (b25kr62.isCheckable()) {
                                b25kr62.ARc23Z(z);
                            }
                            if (b25kr62.isChecked()) {
                                A4TApA(b25kr62);
                            }
                            arrayList.add(new B4ZgIw(b25kr62));
                        }
                        i4++;
                        z = false;
                    }
                    if (z3) {
                        int size3 = arrayList.size();
                        for (int size4 = arrayList.size(); size4 < size3; size4++) {
                            ((B4ZgIw) arrayList.get(size4)).f6544A4TApA = true;
                        }
                    }
                }
            } else {
                int i5 = b25kr6.f521AlLFFp;
                if (i5 != i) {
                    i3 = arrayList.size();
                    z2 = b25kr6.getIcon() != null;
                    if (i2 != 0) {
                        i3++;
                        int i6 = bI9f7h.f6571CQhlFr;
                        arrayList.add(new B3GDIM(i6, i6));
                    }
                } else if (!z2 && b25kr6.getIcon() != null) {
                    int size5 = arrayList.size();
                    for (int i7 = i3; i7 < size5; i7++) {
                        ((B4ZgIw) arrayList.get(i7)).f6544A4TApA = true;
                    }
                    z2 = true;
                }
                B4ZgIw b4ZgIw = new B4ZgIw(b25kr6);
                b4ZgIw.f6544A4TApA = z2;
                arrayList.add(b4ZgIw);
                i = i5;
            }
            i2++;
            z = false;
        }
        this.f6539AmA8tU = z;
    }

    public final void A4TApA(AZkASS.B25kr6 b25kr6) {
        if (this.f6538AlLFFp == b25kr6 || !b25kr6.isCheckable()) {
            return;
        }
        AZkASS.B25kr6 b25kr62 = this.f6538AlLFFp;
        if (b25kr62 != null) {
            b25kr62.setChecked(false);
        }
        this.f6538AlLFFp = b25kr6;
        b25kr6.setChecked(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f6537AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        B2KMhB b2KMhB = (B2KMhB) this.f6537AcNBzu.get(i);
        if (b2KMhB instanceof B3GDIM) {
            return 2;
        }
        if (b2KMhB instanceof B25kr6) {
            return 3;
        }
        if (b2KMhB instanceof B4ZgIw) {
            return ((B4ZgIw) b2KMhB).f6543A2egSU.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        BChYOn bChYOn = (BChYOn) dphsd2;
        int itemViewType = getItemViewType(i);
        ArrayList arrayList = this.f6537AcNBzu;
        BI9f7h bI9f7h = this.f6540AzWtSf;
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    return;
                }
                B3GDIM b3gdim = (B3GDIM) arrayList.get(i);
                bChYOn.itemView.setPaddingRelative(bI9f7h.f6564BmvVmW, b3gdim.f6541A2egSU, bI9f7h.f6565BniPrB, b3gdim.f6542A4TApA);
                return;
            }
            TextView textView = (TextView) bChYOn.itemView;
            textView.setText(((B4ZgIw) arrayList.get(i)).f6543A2egSU.f524B25kr6);
            JrXYwF.A4TApA.DRlcZ9(textView, bI9f7h.f6552B3GDIM);
            textView.setPaddingRelative(bI9f7h.BpkvW3, textView.getPaddingTop(), bI9f7h.f6566C2rE4F, textView.getPaddingBottom());
            ColorStateList colorStateList = bI9f7h.f6553B4ZgIw;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            DG07BK.B4ZgIw(textView, new AmA8tU(this, i, true));
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) bChYOn.itemView;
        navigationMenuItemView.setIconTintList(bI9f7h.f6557BI9f7h);
        navigationMenuItemView.setTextAppearance(bI9f7h.f6554B7CMnp);
        ColorStateList colorStateList2 = bI9f7h.f6556BChYOn;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = bI9f7h.f6558BIYEnU;
        navigationMenuItemView.setBackground(drawable != null ? drawable.getConstantState().newDrawable() : null);
        RippleDrawable rippleDrawable = bI9f7h.f6559BJ7GGh;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        B4ZgIw b4ZgIw = (B4ZgIw) arrayList.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(b4ZgIw.f6544A4TApA);
        int i2 = bI9f7h.f6560BNL6CD;
        int i3 = bI9f7h.f6561BPw6Q8;
        navigationMenuItemView.setPadding(i2, i3, i2, i3);
        navigationMenuItemView.setIconPadding(bI9f7h.f6562BTvldC);
        if (bI9f7h.f6567C4FrIb) {
            navigationMenuItemView.setIconSize(bI9f7h.f6563BV3sI0);
        }
        navigationMenuItemView.setMaxLines(bI9f7h.f6569CNPG0E);
        navigationMenuItemView.f11697CNPG0E = bI9f7h.f6555B9tovu;
        navigationMenuItemView.A2egSU(b4ZgIw.f6543A2egSU);
        DG07BK.B4ZgIw(navigationMenuItemView, new AmA8tU(this, i, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        BI9f7h bI9f7h = this.f6540AzWtSf;
        if (i == 0) {
            LayoutInflater layoutInflater = bI9f7h.f6551B2KMhB;
            ADYaiT.A5SV6n a5SV6n = bI9f7h.f6573CTkVKb;
            B9tovu b9tovu = new B9tovu(layoutInflater.inflate(2131492940, viewGroup, false));
            b9tovu.itemView.setOnClickListener(a5SV6n);
            return b9tovu;
        }
        if (i == 1) {
            return new AlLFFp(bI9f7h.f6551B2KMhB.inflate(2131492943, viewGroup, false));
        }
        if (i == 2) {
            return new AlLFFp(bI9f7h.f6551B2KMhB.inflate(2131492942, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new AlLFFp(bI9f7h.f6547AlLFFp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        BChYOn bChYOn = (BChYOn) dphsd2;
        if (bChYOn instanceof B9tovu) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) bChYOn.itemView;
            FrameLayout frameLayout = navigationMenuItemView.f11699CQhlFr;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.f11698COJEAR.setCompoundDrawables(null, null, null, null);
        }
    }

    public void update() {
        ArrayList arrayList = this.f6537AcNBzu;
        int size = arrayList.size();
        A2egSU();
        notifyDataSetChanged();
        if (size == arrayList.size()) {
            notifyItemRangeChanged(0, arrayList.size());
        }
    }
}
