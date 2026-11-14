package LLiCI0;

import MTKlkd.AZOQYO;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f4706AcNBzu;

    public AzWtSf(ArrayList arrayList) {
        this.f4706AcNBzu = arrayList;
        setHasStableIds(true);
    }

    public static void A2egSU(int i, ImageView imageView, String str) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) com.bumptech.glide.A4TApA.ARc23Z(imageView.getContext()).AaHO0E(str).AZkASS(2131231021)).AMqCpz(2131230991);
        requestBuilder.getClass();
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) requestBuilder.B3GDIM(I3HV03.B2KMhB.f3828A5SV6n, new I3HV03.AZkASS())).ADYaiT(HXc4pW.AlLFFp.f3555A2egSU)).B25kr6(false)).BV3sI0(new AlLFFp(i, imageView, str)).BTvldC(imageView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        ArrayList arrayList = this.f4706AcNBzu;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        if (arrayList.size() == 1) {
            return 1;
        }
        return arrayList.size() * 10000;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        ArrayList arrayList = this.f4706AcNBzu;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1L;
        }
        return i % arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        AZOQYO.A2egSU a2egSU;
        AmA8tU amA8tU = (AmA8tU) dphsd2;
        ArrayList arrayList = this.f4706AcNBzu;
        if (arrayList == null || arrayList.isEmpty() || (a2egSU = (AZOQYO.A2egSU) arrayList.get(i % arrayList.size())) == null) {
            return;
        }
        String A5SV6n2 = a2egSU.A5SV6n();
        if (TextUtils.isEmpty(A5SV6n2)) {
            A5SV6n2 = a2egSU.A2egSU();
        }
        if (TextUtils.isEmpty(A5SV6n2)) {
            amA8tU.f4701AcNBzu.setImageResource(2131230991);
        } else {
            A2egSU(0, amA8tU.f4701AcNBzu, A5SV6n2);
        }
        amA8tU.f4702AlLFFp.setText(a2egSU.AMqCpz());
        amA8tU.f4703AmA8tU.setText(a2egSU.A4TApA());
        String A2egSU2 = a2egSU.A2egSU();
        if (TextUtils.isEmpty(A2egSU2)) {
            A2egSU2 = a2egSU.A5SV6n();
        }
        boolean isEmpty = TextUtils.isEmpty(A2egSU2);
        ImageView imageView = amA8tU.f4704AzWtSf;
        if (isEmpty) {
            imageView.setImageResource(2131230991);
        } else {
            A2egSU(0, imageView, A2egSU2);
        }
        amA8tU.f4705B25kr6.setOnClickListener(new AZkASS(this, a2egSU));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492986, viewGroup, false);
        AmA8tU amA8tU = new AmA8tU(inflate);
        amA8tU.f4701AcNBzu = (ImageView) inflate.findViewById(2131296757);
        amA8tU.f4702AlLFFp = (TextView) inflate.findViewById(2131298188);
        amA8tU.f4703AmA8tU = (TextView) inflate.findViewById(2131298187);
        amA8tU.f4704AzWtSf = (ImageView) inflate.findViewById(2131296752);
        amA8tU.f4705B25kr6 = (MaterialButton) inflate.findViewById(2131296438);
        return amA8tU;
    }
}
