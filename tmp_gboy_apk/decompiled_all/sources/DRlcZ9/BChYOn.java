package DRlcZ9;

import ADYaiT.D8MqeW;
import COJEAR.DG07BK;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.R$styleable;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BChYOn extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final PreferenceScreen f2116AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ArrayList f2117AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ArrayList f2118AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f2119AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final D8MqeW f2121B2KMhB = new D8MqeW(10, this);

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Handler f2120B25kr6 = new Handler(Looper.getMainLooper());

    public BChYOn(PreferenceScreen preferenceScreen) {
        this.f2116AcNBzu = preferenceScreen;
        preferenceScreen.f9109CmUvjW = this;
        this.f2117AlLFFp = new ArrayList();
        this.f2118AmA8tU = new ArrayList();
        this.f2119AzWtSf = new ArrayList();
        setHasStableIds(preferenceScreen.f9122DRlcZ9);
        AMqCpz();
    }

    public final ArrayList A2egSU(PreferenceGroup preferenceGroup) {
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.f9117D8MqeW.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Preference BpkvW3 = preferenceGroup.BpkvW3(i2);
            if (BpkvW3.f9099CASmeH) {
                int i3 = preferenceGroup.f9121DG07BK;
                if (i3 == Integer.MAX_VALUE || i < i3) {
                    arrayList.add(BpkvW3);
                } else {
                    arrayList2.add(BpkvW3);
                }
                if (BpkvW3 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) BpkvW3;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.f9121DG07BK != Integer.MAX_VALUE && preferenceGroup2.f9121DG07BK != Integer.MAX_VALUE) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        Iterator it = A2egSU(preferenceGroup2).iterator();
                        while (it.hasNext()) {
                            Preference preference = (Preference) it.next();
                            int i4 = preferenceGroup.f9121DG07BK;
                            if (i4 == Integer.MAX_VALUE || i < i4) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i++;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        int i5 = preferenceGroup.f9121DG07BK;
        if (i5 != Integer.MAX_VALUE && i > i5) {
            Context context = preferenceGroup.getContext();
            long j = preferenceGroup.f9079AmA8tU;
            CharSequence charSequence = null;
            AMqCpz aMqCpz = new AMqCpz(context, null);
            aMqCpz.f9107CikNvS = 2131492955;
            Drawable CQhlFr2 = NOd7IU.AlLFFp.CQhlFr(aMqCpz.f9077AcNBzu, 2131230960);
            if (aMqCpz.f9087BChYOn != CQhlFr2) {
                aMqCpz.f9087BChYOn = CQhlFr2;
                aMqCpz.f9086B9tovu = 0;
                aMqCpz.AZOQYO();
            }
            aMqCpz.f9086B9tovu = 2131230960;
            aMqCpz.BPw6Q8(2131886299);
            if (999 != aMqCpz.f9083B3GDIM) {
                aMqCpz.f9083B3GDIM = 999;
                BChYOn bChYOn = aMqCpz.f9109CmUvjW;
                if (bChYOn != null) {
                    Handler handler = bChYOn.f2120B25kr6;
                    D8MqeW d8MqeW = bChYOn.f2121B2KMhB;
                    handler.removeCallbacks(d8MqeW);
                    handler.post(d8MqeW);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Preference preference2 = (Preference) it2.next();
                CharSequence charSequence2 = preference2.f9084B4ZgIw;
                boolean z2 = preference2 instanceof PreferenceGroup;
                if (z2 && !TextUtils.isEmpty(charSequence2)) {
                    arrayList3.add((PreferenceGroup) preference2);
                }
                if (arrayList3.contains(preference2.f9111CrfGsy)) {
                    if (z2) {
                        arrayList3.add((PreferenceGroup) preference2);
                    }
                } else if (!TextUtils.isEmpty(charSequence2)) {
                    charSequence = charSequence == null ? charSequence2 : aMqCpz.getContext().getString(2131886818, charSequence, charSequence2);
                }
            }
            aMqCpz.BNL6CD(charSequence);
            aMqCpz.f2077D6yqiO = j + C.MICROS_PER_SECOND;
            aMqCpz.f9082B2KMhB = new K1Z3yj.A2egSU(this, preferenceGroup, 14, z);
            arrayList.add(aMqCpz);
        }
        return arrayList;
    }

    public final void A4TApA(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.f9117D8MqeW);
        }
        int size = preferenceGroup.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            Preference BpkvW3 = preferenceGroup.BpkvW3(i);
            arrayList.add(BpkvW3);
            B9tovu b9tovu = new B9tovu(BpkvW3);
            if (!this.f2119AzWtSf.contains(b9tovu)) {
                this.f2119AzWtSf.add(b9tovu);
            }
            if (BpkvW3 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) BpkvW3;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    A4TApA(arrayList, preferenceGroup2);
                }
            }
            BpkvW3.f9109CmUvjW = this;
        }
    }

    public final Preference A5SV6n(int i) {
        if (i < 0 || i >= this.f2118AmA8tU.size()) {
            return null;
        }
        return (Preference) this.f2118AmA8tU.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: ADYaiT, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BV3sI0 bV3sI0, int i) {
        ColorStateList colorStateList;
        Preference A5SV6n2 = A5SV6n(i);
        Drawable background = bV3sI0.itemView.getBackground();
        Drawable drawable = bV3sI0.f2140AcNBzu;
        if (background != drawable) {
            View view = bV3sI0.itemView;
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) bV3sI0.A2egSU(R.id.title);
        if (textView != null && (colorStateList = bV3sI0.f2141AlLFFp) != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        A5SV6n2.AlLFFp(bV3sI0);
    }

    public final void AMqCpz() {
        Iterator it = this.f2117AlLFFp.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).f9109CmUvjW = null;
        }
        ArrayList arrayList = new ArrayList(this.f2117AlLFFp.size());
        this.f2117AlLFFp = arrayList;
        PreferenceScreen preferenceScreen = this.f2116AcNBzu;
        A4TApA(arrayList, preferenceScreen);
        this.f2118AmA8tU = A2egSU(preferenceScreen);
        notifyDataSetChanged();
        Iterator it2 = this.f2117AlLFFp.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).getClass();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f2118AmA8tU.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        if (hasStableIds()) {
            return A5SV6n(i).ADYaiT();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        B9tovu b9tovu = new B9tovu(A5SV6n(i));
        ArrayList arrayList = this.f2119AzWtSf;
        int indexOf = arrayList.indexOf(b9tovu);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = arrayList.size();
        arrayList.add(b9tovu);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        B9tovu b9tovu = (B9tovu) this.f2119AzWtSf.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.f9123A2egSU);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = NOd7IU.AlLFFp.CQhlFr(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(b9tovu.f2113A2egSU, viewGroup, false);
        if (inflate.getBackground() == null) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            inflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = b9tovu.f2114A4TApA;
            if (i2 != 0) {
                from.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new BV3sI0(inflate);
    }
}
