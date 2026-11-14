package LLiCI0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.view.MarqueeTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f4716AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final com.game.boy.activity.A2egSU f4717AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f4718AmA8tU = false;

    public B3GDIM(ArrayList arrayList, com.game.boy.activity.A2egSU a2egSU) {
        this.f4716AcNBzu = new ArrayList(arrayList);
        this.f4717AlLFFp = a2egSU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: A2egSU, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(B2KMhB b2KMhB, int i) {
        L5dZB6.A4TApA a4TApA = (L5dZB6.A4TApA) this.f4716AcNBzu.get(i);
        b2KMhB.f4714B2KMhB = a4TApA;
        String str = a4TApA.f4395AzWtSf;
        MarqueeTextView marqueeTextView = b2KMhB.f4710AlLFFp;
        marqueeTextView.setText(str);
        marqueeTextView.setMarqueeEnabled(!b2KMhB.f4715B3GDIM.f4718AmA8tU);
        String str2 = a4TApA.f4394AmA8tU;
        ImageView imageView = b2KMhB.f4709AcNBzu;
        if (str2 == null || str2.isEmpty()) {
            imageView.setImageResource(2131231009);
        } else {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(b2KMhB.itemView.getContext()).AaHO0E(a4TApA.f4394AmA8tU).AZkASS(2131231009)).AMqCpz(2131231009)).ADYaiT(HXc4pW.AlLFFp.f3555A2egSU)).B25kr6(false)).BTvldC(imageView);
        }
        b2KMhB.A5SV6n(a4TApA);
        b2KMhB.ADYaiT(a4TApA);
        b2KMhB.f4713B25kr6.setOnClickListener(new ADYaiT.A5SV6n(8, b2KMhB));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4716AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new B2KMhB(this, LayoutInflater.from(viewGroup.getContext()).inflate(2131492977, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i, List list) {
        B2KMhB b2KMhB = (B2KMhB) dphsd2;
        if (!list.isEmpty() && (list.get(0) instanceof String) && "MARQUEE_STATE".equals(list.get(0))) {
            b2KMhB.f4710AlLFFp.setMarqueeEnabled(!this.f4718AmA8tU);
            return;
        }
        if (list.isEmpty()) {
            onBindViewHolder(b2KMhB, i);
            return;
        }
        L5dZB6.A4TApA a4TApA = (L5dZB6.A4TApA) this.f4716AcNBzu.get(i);
        b2KMhB.f4714B2KMhB = a4TApA;
        for (Object obj : list) {
            if (obj instanceof List) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    b2KMhB.A4TApA(it.next(), a4TApA);
                }
            } else {
                b2KMhB.A4TApA(obj, a4TApA);
            }
        }
    }
}
