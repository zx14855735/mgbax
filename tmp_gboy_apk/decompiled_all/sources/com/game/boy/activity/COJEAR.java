package com.game.boy.activity;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.game.boy.MyApp;
import com.google.gson.GsonBuilder;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class COJEAR implements LlW7FF.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ PackageActivity f10945AcNBzu;

    public COJEAR(PackageActivity packageActivity) {
        this.f10945AcNBzu = packageActivity;
    }

    @Override // LlW7FF.AMqCpz
    public final void ARc23Z(String str) {
    }

    @Override // LlW7FF.AMqCpz
    public final void onSuccess(Object obj) {
        MTKlkd.A5SV6n a5SV6n = (MTKlkd.A5SV6n) obj;
        if (!a5SV6n.A5SV6n()) {
            MyApp.A2egSU(a5SV6n.A4TApA());
            return;
        }
        new GsonBuilder().setPrettyPrinting().create().toJson(a5SV6n.A2egSU().A2egSU());
        List A2egSU2 = a5SV6n.A2egSU().A2egSU();
        PackageActivity packageActivity = this.f10945AcNBzu;
        packageActivity.f11071B3GDIM.setVisibility(8);
        packageActivity.f11072B4ZgIw.setVisibility(8);
        packageActivity.f11069B25kr6.setVisibility(0);
        Collections.sort(A2egSU2, new B4ZgIw.ARc23Z(16));
        LLiCI0.BpkvW3 bpkvW3 = packageActivity.f11073B7CMnp;
        if (bpkvW3 == null) {
            LLiCI0.BpkvW3 bpkvW32 = new LLiCI0.BpkvW3();
            bpkvW32.f4762AcNBzu = A2egSU2;
            bpkvW32.f4763AlLFFp = packageActivity;
            packageActivity.f11073B7CMnp = bpkvW32;
            packageActivity.f11069B25kr6.setAdapter(bpkvW32);
        } else {
            bpkvW3.f4762AcNBzu = A2egSU2;
            bpkvW3.notifyDataSetChanged();
        }
        packageActivity.f11069B25kr6.setLayoutManager(new StaggeredGridLayoutManager(a5SV6n.A2egSU().A2egSU().size() > 1 ? 2 : 1, 1));
    }
}
