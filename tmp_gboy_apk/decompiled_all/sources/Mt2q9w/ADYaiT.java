package Mt2q9w;

import LHpdLt.B9tovu;
import LLiCI0.BV3sI0;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f5529AcNBzu;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public List f5531AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final A5SV6n f5532AzWtSf;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final HashSet f5530AlLFFp = new HashSet();

    /* renamed from: B25kr6, reason: collision with root package name */
    public final HashMap f5533B25kr6 = new HashMap();

    public ADYaiT(ArrayList arrayList, A5SV6n a5SV6n) {
        this.f5531AmA8tU = arrayList;
        this.f5532AzWtSf = a5SV6n;
        A4TApA();
    }

    public final ASJ6gh A2egSU(int i) {
        for (AZOQYO azoqyo : this.f5531AmA8tU) {
            if (azoqyo instanceof ASJ6gh) {
                ASJ6gh aSJ6gh = (ASJ6gh) azoqyo;
                if (aSJ6gh.f5537A4TApA == i) {
                    return aSJ6gh;
                }
            }
        }
        return null;
    }

    public final void A4TApA() {
        this.f5529AcNBzu = new ArrayList();
        HashMap hashMap = this.f5533B25kr6;
        hashMap.clear();
        for (AZOQYO azoqyo : this.f5531AmA8tU) {
            this.f5529AcNBzu.add(azoqyo);
            if (azoqyo instanceof ASJ6gh) {
                ASJ6gh aSJ6gh = (ASJ6gh) azoqyo;
                hashMap.put(Integer.valueOf(aSJ6gh.f5537A4TApA), Integer.valueOf(this.f5529AcNBzu.size() - 1));
                if (this.f5530AlLFFp.contains(Integer.valueOf(aSJ6gh.f5537A4TApA))) {
                    this.f5529AcNBzu.addAll(aSJ6gh.AMqCpz);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5529AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        return this.f5529AcNBzu.get(i) instanceof ASJ6gh ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        Object obj = this.f5529AcNBzu.get(i);
        if (dphsd2 instanceof A2egSU) {
            ASJ6gh aSJ6gh = (ASJ6gh) obj;
            boolean contains = this.f5530AlLFFp.contains(Integer.valueOf(aSJ6gh.f5537A4TApA));
            A2egSU a2egSU = (A2egSU) dphsd2;
            B9tovu b9tovu = new B9tovu(2, this, aSJ6gh, a2egSU);
            a2egSU.getClass();
            Drawable drawable = aSJ6gh.f5538A5SV6n;
            AppCompatImageView appCompatImageView = a2egSU.f5521AcNBzu;
            if (drawable != null) {
                appCompatImageView.setImageDrawable(drawable);
                appCompatImageView.setVisibility(0);
            } else {
                appCompatImageView.setVisibility(4);
            }
            a2egSU.f5522AlLFFp.setText(aSJ6gh.f5539ADYaiT);
            AppCompatTextView appCompatTextView = a2egSU.f5523AmA8tU;
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            AppCompatImageView appCompatImageView2 = a2egSU.f5524AzWtSf;
            if (appCompatImageView2 != null) {
                if (aSJ6gh.f5540ARc23Z) {
                    appCompatImageView2.setImageResource(2131230979);
                    appCompatImageView2.setRotation(contains ? 90.0f : 0.0f);
                    appCompatImageView2.setVisibility(0);
                } else {
                    appCompatImageView2.setVisibility(8);
                }
            }
            a2egSU.itemView.setOnClickListener(b9tovu);
            View view = a2egSU.itemView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams != null) {
                Context context = view.getContext();
                marginLayoutParams.leftMargin = (context == null || context.getResources() == null) ? (int) 48.0f : (int) (16.0f * context.getResources().getDisplayMetrics().density);
                view.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        if (dphsd2 instanceof A4TApA) {
            AYUAbz aYUAbz = (AYUAbz) obj;
            A4TApA a4TApA = (A4TApA) dphsd2;
            BV3sI0 bV3sI0 = new BV3sI0(this, 5, aYUAbz);
            a4TApA.getClass();
            Drawable drawable2 = aYUAbz.f5542A5SV6n;
            AppCompatImageView appCompatImageView3 = a4TApA.f5525AcNBzu;
            if (drawable2 != null) {
                appCompatImageView3.setImageDrawable(drawable2);
                appCompatImageView3.setVisibility(0);
            } else {
                appCompatImageView3.setVisibility(4);
            }
            a4TApA.f5526AlLFFp.setText(aYUAbz.f5543ADYaiT);
            AppCompatTextView appCompatTextView2 = a4TApA.f5527AmA8tU;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            AppCompatTextView appCompatTextView3 = a4TApA.f5528AzWtSf;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setVisibility(8);
            }
            a4TApA.itemView.setOnClickListener(bV3sI0);
            View view2 = a4TApA.itemView;
            if (aYUAbz.f5544A2egSU > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.leftMargin = A4TApA.A2egSU(view2.getContext(), 24.0f) + A4TApA.A2egSU(view2.getContext(), 16.0f);
                    view2.setLayoutParams(marginLayoutParams2);
                    return;
                }
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams3 != null) {
                marginLayoutParams3.leftMargin = A4TApA.A2egSU(view2.getContext(), 16.0f);
                view2.setLayoutParams(marginLayoutParams3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 1) {
            View inflate = from.inflate(2131493216, viewGroup, false);
            A2egSU a2egSU = new A2egSU(inflate);
            a2egSU.f5521AcNBzu = (AppCompatImageView) inflate.findViewById(2131297566);
            a2egSU.f5522AlLFFp = (AppCompatTextView) inflate.findViewById(2131297567);
            a2egSU.f5523AmA8tU = (AppCompatTextView) inflate.findViewById(2131297565);
            a2egSU.f5524AzWtSf = (AppCompatImageView) inflate.findViewById(2131297562);
            return a2egSU;
        }
        View inflate2 = from.inflate(2131493217, viewGroup, false);
        A4TApA a4TApA = new A4TApA(inflate2);
        a4TApA.f5525AcNBzu = (AppCompatImageView) inflate2.findViewById(2131297566);
        a4TApA.f5526AlLFFp = (AppCompatTextView) inflate2.findViewById(2131297567);
        a4TApA.f5527AmA8tU = (AppCompatTextView) inflate2.findViewById(2131297565);
        a4TApA.f5528AzWtSf = (AppCompatTextView) inflate2.findViewById(2131297563);
        return a4TApA;
    }
}
