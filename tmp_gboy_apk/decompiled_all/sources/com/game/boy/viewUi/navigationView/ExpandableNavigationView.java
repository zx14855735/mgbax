package com.game.boy.viewUi.navigationView;

import AZkASS.AmA8tU;
import AZkASS.B25kr6;
import AZkASS.BpkvW3;
import BPw6Q8.A2egSU;
import Mt2q9w.ADYaiT;
import Mt2q9w.AMqCpz;
import Mt2q9w.ARc23Z;
import Mt2q9w.ASJ6gh;
import Mt2q9w.AYUAbz;
import OpB85q.B4ZgIw;
import OpB85q.B9tovu;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.AzWtSf;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ExpandableNavigationView extends B9tovu {

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final RecyclerView f11195CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public ADYaiT f11196CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public View f11197CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final FrameLayout f11198Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public ArrayList f11199CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public B4ZgIw f11200CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public int f11201CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public AmA8tU f11202CqNSpT;

    public ExpandableNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11201CmUvjW = 0;
        removeAllViews();
        FrameLayout frameLayout = new FrameLayout(getContext());
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.f11198Cd8JRx = new FrameLayout(getContext());
        frameLayout.addView(this.f11198Cd8JRx, new FrameLayout.LayoutParams(-1, -2));
        RecyclerView recyclerView = new RecyclerView(getContext(), null);
        this.f11195CSDoyG = recyclerView;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        AzWtSf azWtSf = new AzWtSf();
        azWtSf.f9428A5SV6n = 300L;
        azWtSf.f9429ADYaiT = 300L;
        azWtSf.AMqCpz = 300L;
        azWtSf.f9430ARc23Z = 300L;
        this.f11195CSDoyG.setItemAnimator(azWtSf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = 0;
        frameLayout.addView(this.f11195CSDoyG, layoutParams);
        this.f11199CikNvS = new ArrayList();
        this.f11202CqNSpT = new AmA8tU(getContext());
        ADYaiT aDYaiT = new ADYaiT(this.f11199CikNvS, new IQ76hF.AmA8tU(15, this));
        this.f11196CTkVKb = aDYaiT;
        this.f11195CSDoyG.setAdapter(aDYaiT);
        int i = this.f11201CmUvjW;
        if (i != 0) {
            AYUAbz(i);
            this.f11201CmUvjW = 0;
        }
    }

    public static MenuItem AaHO0E(ExpandableNavigationView expandableNavigationView, int i) {
        if (expandableNavigationView.f11202CqNSpT == null) {
            return null;
        }
        for (int i2 = 0; i2 < expandableNavigationView.f11202CqNSpT.f498B2KMhB.size(); i2++) {
            MenuItem item = expandableNavigationView.f11202CqNSpT.getItem(i2);
            if (item.getItemId() == i) {
                return item;
            }
            if (item.hasSubMenu()) {
                SubMenu subMenu = item.getSubMenu();
                for (int i3 = 0; i3 < subMenu.size(); i3++) {
                    if (subMenu.getItem(i3).getItemId() == i) {
                        return subMenu.getItem(i3);
                    }
                }
            }
        }
        return null;
    }

    @Override // OpB85q.B9tovu
    public final View ASJ6gh(int i) {
        AmA8tU();
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.f11198Cd8JRx, false);
        this.f11197CcAIMM = inflate;
        this.f11198Cd8JRx.addView(inflate);
        this.f11198Cd8JRx.setVisibility(0);
        this.f11197CcAIMM.getViewTreeObserver().addOnGlobalLayoutListener(new ARc23Z(this, 0));
        return this.f11197CcAIMM;
    }

    @Override // OpB85q.B9tovu
    public final void AYUAbz(int i) {
        if (this.f11195CSDoyG == null) {
            this.f11201CmUvjW = i;
            return;
        }
        this.f11202CqNSpT = new AmA8tU(getContext());
        new MenuInflater(getContext()).inflate(i, this.f11202CqNSpT);
        AmA8tU amA8tU = this.f11202CqNSpT;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < amA8tU.f498B2KMhB.size(); i2++) {
            MenuItem item = amA8tU.getItem(i2);
            if (item.hasSubMenu()) {
                SubMenu subMenu = item.getSubMenu();
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < subMenu.size(); i3++) {
                    MenuItem item2 = subMenu.getItem(i3);
                    arrayList2.add(new AYUAbz(item2.getItemId(), item2.getIcon(), item2.getTitle().toString()));
                }
                arrayList.add(new ASJ6gh(item.getItemId(), item.getIcon(), item.getTitle().toString(), arrayList2));
            } else {
                arrayList.add(new AYUAbz(item.getItemId(), item.getIcon(), item.getTitle().toString()));
            }
        }
        this.f11199CikNvS = arrayList;
        ADYaiT aDYaiT = new ADYaiT(arrayList, new AMqCpz(this));
        this.f11196CTkVKb = aDYaiT;
        this.f11195CSDoyG.setAdapter(aDYaiT);
    }

    public final void AcNBzu(int i, int i2, String str, ArrayList arrayList) {
        AlLFFp(i, i2 != 0 ? A2egSU.A4TApA(getContext(), i2) : null, str, arrayList);
    }

    public final void AlLFFp(int i, Drawable drawable, String str, ArrayList arrayList) {
        if (this.f11202CqNSpT == null) {
            this.f11202CqNSpT = new AmA8tU(getContext());
        }
        Menu addSubMenu = this.f11202CqNSpT.addSubMenu(0, i, 0, str);
        if (drawable != null) {
            ((BpkvW3) addSubMenu).f592CSDoyG.setIcon(drawable);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AYUAbz aYUAbz = (AYUAbz) it.next();
                B25kr6 A2egSU2 = ((AmA8tU) addSubMenu).A2egSU(0, aYUAbz.f5541A4TApA, 0, aYUAbz.f5543ADYaiT);
                Drawable drawable2 = aYUAbz.f5542A5SV6n;
                if (drawable2 != null) {
                    A2egSU2.setIcon(drawable2);
                }
            }
        }
        if (this.f11199CikNvS == null) {
            this.f11199CikNvS = new ArrayList();
        }
        this.f11199CikNvS.add(new ASJ6gh(i, drawable, str, arrayList));
        ADYaiT aDYaiT = this.f11196CTkVKb;
        if (aDYaiT != null) {
            aDYaiT.f5531AmA8tU = this.f11199CikNvS;
            aDYaiT.A4TApA();
            aDYaiT.notifyDataSetChanged();
        }
    }

    public final void AmA8tU() {
        View view = this.f11197CcAIMM;
        if (view != null) {
            this.f11198Cd8JRx.removeView(view);
            this.f11197CcAIMM = null;
        }
        this.f11198Cd8JRx.removeAllViews();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11195CSDoyG.getLayoutParams();
        layoutParams.topMargin = 0;
        this.f11195CSDoyG.setLayoutParams(layoutParams);
        this.f11198Cd8JRx.setVisibility(8);
    }

    public ADYaiT getAdapter() {
        return this.f11196CTkVKb;
    }

    public Set<Integer> getExpandedGroups() {
        ADYaiT aDYaiT = this.f11196CTkVKb;
        return aDYaiT != null ? new HashSet(aDYaiT.f5530AlLFFp) : new HashSet();
    }

    public View getHeaderView() {
        return this.f11197CcAIMM;
    }

    @Override // OpB85q.B9tovu
    public Menu getMenu() {
        if (this.f11202CqNSpT == null) {
            this.f11202CqNSpT = new AmA8tU(getContext());
        }
        return this.f11202CqNSpT;
    }

    public RecyclerView getRecyclerView() {
        return this.f11195CSDoyG;
    }

    public void setExpandedGroups(Set<Integer> set) {
        ADYaiT aDYaiT = this.f11196CTkVKb;
        if (aDYaiT != null) {
            HashSet hashSet = aDYaiT.f5530AlLFFp;
            hashSet.clear();
            hashSet.addAll(set);
            aDYaiT.A4TApA();
            aDYaiT.notifyDataSetChanged();
        }
    }

    @Override // OpB85q.B9tovu
    public void setNavigationItemSelectedListener(B4ZgIw b4ZgIw) {
        this.f11200CkXcdM = b4ZgIw;
    }
}
