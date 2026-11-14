package Mm8v1u;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BChYOn f5511AcNBzu;

    public B9tovu(BChYOn bChYOn) {
        this.f5511AcNBzu = bChYOn;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5511AcNBzu.f5516B25kr6.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        B7CMnp b7CMnp = (B7CMnp) dphsd2;
        String str = (String) this.f5511AcNBzu.f5516B25kr6.get(i);
        b7CMnp.f5509AlLFFp.setVisibility(0);
        PhotoView photoView = b7CMnp.f5508AcNBzu;
        ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(photoView.getContext()).AaHO0E(str).ADYaiT(HXc4pW.AlLFFp.f3555A2egSU)).BV3sI0(new B4ZgIw(b7CMnp)).BTvldC(photoView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new B7CMnp(this, LayoutInflater.from(viewGroup.getContext()).inflate(2131492991, viewGroup, false));
    }
}
