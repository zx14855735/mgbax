package com.game.boy.activity;

import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.game.boy.MyApp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CNPG0E implements LCJm5h.AMqCpz, OpB85q.AzWtSf {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10944AcNBzu;

    public /* synthetic */ CNPG0E(MainActivity mainActivity) {
        this.f10944AcNBzu = mainActivity;
    }

    @Override // LCJm5h.AMqCpz
    public void A4TApA(int i, String str) {
        MyApp.A2egSU(str);
        int i2 = MainActivity.f11062B9tovu;
        MainActivity mainActivity = this.f10944AcNBzu;
        Fragment BTvldC2 = mainActivity.getSupportFragmentManager().BTvldC(mainActivity.f11063B25kr6);
        if (BTvldC2 != null) {
            if (!(BTvldC2 instanceof MOpbMP.BpkvW3)) {
                if (BTvldC2 instanceof MOpbMP.AmA8tU) {
                }
            } else {
                MOpbMP.BpkvW3 bpkvW3 = (MOpbMP.BpkvW3) BTvldC2;
                if (i == 0 || i == 4) {
                    bpkvW3.AzWtSf();
                }
            }
        }
    }

    @Override // OpB85q.AzWtSf
    public void ASJ6gh(MenuItem menuItem) {
        MainActivity mainActivity = this.f10944AcNBzu;
        int itemId = menuItem.getItemId();
        int i = MainActivity.f11062B9tovu;
        if (itemId == 2131297686) {
            mainActivity.AaHO0E("home");
        } else if (itemId == 2131297687) {
            mainActivity.AaHO0E("notifications");
        }
    }

    @Override // LCJm5h.AMqCpz
    public void onError(String str) {
        MyApp.A2egSU(str);
    }
}
