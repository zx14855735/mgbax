package LLiCI0;

import L2suez.ASJ6gh;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.view.MarqueeTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BJ7GGh extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f4737AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public MOpbMP.BpkvW3 f4738AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public FragmentActivity f4739AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f4740AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f4741B25kr6;

    public static String A2egSU(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4737AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        return this.f4741B25kr6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        BIYEnU bIYEnU = (BIYEnU) dphsd2;
        ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) this.f4737AcNBzu.get(i);
        boolean z = this.f4740AzWtSf;
        bIYEnU.getClass();
        String name = a2egSU.f4366A2egSU.getName();
        bIYEnU.f4736AmA8tU.getClass();
        String A2egSU2 = A2egSU(name);
        MarqueeTextView marqueeTextView = bIYEnU.f4735AlLFFp;
        marqueeTextView.setText(A2egSU2);
        marqueeTextView.setMarqueeEnabled(!z);
        File file = a2egSU.f4367A4TApA;
        ImageView imageView = bIYEnU.f4734AcNBzu;
        if (file != null) {
            RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(bIYEnU.itemView.getContext()).A2egSU(Drawable.class).BmvVmW(a2egSU.f4367A4TApA).AZkASS(2131230940)).AMqCpz(2131230940)).ADYaiT(HXc4pW.AlLFFp.f3556A4TApA)).B25kr6(true);
            requestBuilder.getClass();
            ((RequestBuilder) requestBuilder.B3GDIM(I3HV03.B2KMhB.f3828A5SV6n, new I3HV03.AZkASS())).BTvldC(imageView);
        } else {
            imageView.setImageResource(2131230940);
        }
        bIYEnU.itemView.setOnClickListener(new B4ZgIw(this.f4738AlLFFp, a2egSU));
        bIYEnU.itemView.setOnLongClickListener(new B7CMnp(bIYEnU, a2egSU, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BIYEnU(this, LayoutInflater.from(viewGroup.getContext()).inflate(i == 1 ? 2131492985 : 2131492984, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i, List list) {
        BIYEnU bIYEnU = (BIYEnU) dphsd2;
        if (!list.isEmpty() && (list.get(0) instanceof String) && "MARQUEE_STATE".equals(list.get(0))) {
            bIYEnU.f4735AlLFFp.setMarqueeEnabled(!this.f4740AzWtSf);
        } else {
            super.onBindViewHolder(bIYEnU, i, list);
        }
    }
}
