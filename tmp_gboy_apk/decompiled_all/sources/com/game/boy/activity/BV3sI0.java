package com.game.boy.activity;

import com.game.boy.MyApp;
import java.io.File;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BV3sI0 implements androidx.swiperefreshlayout.widget.AZOQYO, LlW7FF.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ FavoriteActivity f10925AcNBzu;

    public /* synthetic */ BV3sI0(FavoriteActivity favoriteActivity) {
        this.f10925AcNBzu = favoriteActivity;
    }

    @Override // LlW7FF.AMqCpz
    public void ARc23Z(String str) {
        this.f10925AcNBzu.f11035B2KMhB.setRefreshing(false);
    }

    @Override // androidx.swiperefreshlayout.widget.AZOQYO
    public void onRefresh() {
        int i = FavoriteActivity.f11033BChYOn;
        this.f10925AcNBzu.AYUAbz();
    }

    @Override // LlW7FF.AMqCpz
    public void onSuccess(Object obj) {
        boolean z;
        MTKlkd.ASJ6gh aSJ6gh = (MTKlkd.ASJ6gh) obj;
        MyApp.A2egSU(aSJ6gh.A4TApA());
        boolean ADYaiT2 = aSJ6gh.ADYaiT();
        FavoriteActivity favoriteActivity = this.f10925AcNBzu;
        if (ADYaiT2) {
            List<MTKlkd.ARc23Z> A2egSU2 = aSJ6gh.A2egSU();
            if (!A2egSU2.isEmpty()) {
                for (MTKlkd.ARc23Z aRc23Z : A2egSU2) {
                    if (aRc23Z.AZOQYO() != null) {
                        try {
                            z = L2suez.A2egSU.A5SV6n(new File(L2suez.B9tovu.A2egSU("GBoy/rom"), aRc23Z.ARc23Z() + aRc23Z.getType()).getAbsolutePath(), aRc23Z.AZOQYO());
                        } catch (Exception unused) {
                            z = false;
                        }
                        if (z) {
                            aRc23Z.B3GDIM(3);
                        } else {
                            aRc23Z.B3GDIM(4);
                        }
                    } else {
                        if (L2suez.A2egSU.A4TApA(new File(L2suez.B9tovu.A2egSU("GBoy/rom"), aRc23Z.ARc23Z() + aRc23Z.getType()).getAbsolutePath())) {
                            aRc23Z.B3GDIM(3);
                        }
                    }
                    aRc23Z.AlLFFp(true);
                    favoriteActivity.f11037B4ZgIw.add(aRc23Z);
                }
            }
        }
        favoriteActivity.f11035B2KMhB.setRefreshing(false);
        favoriteActivity.f11039B9tovu.notifyDataSetChanged();
    }
}
