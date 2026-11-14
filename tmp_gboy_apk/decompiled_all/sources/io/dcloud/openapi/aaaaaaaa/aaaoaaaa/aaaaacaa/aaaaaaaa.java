package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaacaa;

import android.app.Activity;
import android.view.View;
import io.dcloud.openapi.core.interfaces.AOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0 implements AOLLoader.DrawAOLInteractionListener {
    public aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa aaaaaaaaVar) {
        super(aaaaaaaaVar);
    }

    public View getDrawAOLView(Activity activity) {
        return getFeedAOLView(activity);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaa0, io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        return true;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar instanceof aaaaaaa0) {
            ((aaaaaaa0) aaaaaaaoVar).onEnd();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar instanceof aaaaaaa0) {
            aaaaaaaoVar.onShowError();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar instanceof aaaaaaa0) {
            ((aaaaaaa0) aaaaaaaoVar).onPause();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar instanceof aaaaaaa0) {
            ((aaaaaaa0) aaaaaaaoVar).onResume();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar instanceof aaaaaaa0) {
            ((aaaaaaa0) aaaaaaaoVar).onStart();
        }
    }

    public void setDrawAOLListener(aaaaaaa0 aaaaaaa0Var) {
        this.aaaaaaa0 = aaaaaaa0Var;
    }
}
