package MQlCFp;

import HXc4pW.AlLFFp;
import I3HV03.AZkASS;
import I3HV03.B2KMhB;
import LLiCI0.BV3sI0;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.AmA8tU;
import com.bumptech.glide.AzWtSf;
import com.bumptech.glide.RequestBuilder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final List f5149AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final LEPB2s.A2egSU f5150AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AzWtSf f5151AmA8tU;

    public ASJ6gh(AYUAbz aYUAbz, List list) {
        this.f5149AcNBzu = list == null ? new ArrayList() : list;
        this.f5150AlLFFp = LEPB2s.A2egSU.A4TApA();
        this.f5151AmA8tU = com.bumptech.glide.A4TApA.ARc23Z(aYUAbz.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5149AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        ARc23Z aRc23Z = (ARc23Z) dphsd2;
        aRc23Z.f5147AcNBzu.setImageDrawable(null);
        aRc23Z.f5148AlLFFp.setOnClickListener(new BV3sI0(this, 2, aRc23Z));
        RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) this.f5151AmA8tU.AaHO0E((String) this.f5149AcNBzu.get(i)).ADYaiT(AlLFFp.f3555A2egSU)).AZkASS(2131231021)).AMqCpz(2131230991)).ARc23Z(2131231001);
        I9dkCd.A2egSU a2egSU = new I9dkCd.A2egSU();
        a2egSU.f9958AcNBzu = new AZkASS.ARc23Z(20);
        RequestBuilder C2rE4F2 = requestBuilder.C2rE4F(a2egSU);
        C2rE4F2.getClass();
        ((RequestBuilder) C2rE4F2.B3GDIM(B2KMhB.f3828A5SV6n, new AZkASS())).BV3sI0(new AMqCpz()).BTvldC(aRc23Z.f5147AcNBzu);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ARc23Z(LayoutInflater.from(viewGroup.getContext()).inflate(2131492994, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        ImageView imageView = ((ARc23Z) dphsd2).f5147AcNBzu;
        AzWtSf azWtSf = this.f5151AmA8tU;
        azWtSf.getClass();
        azWtSf.A5SV6n(new AmA8tU(imageView));
    }
}
