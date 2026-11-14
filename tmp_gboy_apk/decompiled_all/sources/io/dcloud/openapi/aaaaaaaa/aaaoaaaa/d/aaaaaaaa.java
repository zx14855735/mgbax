package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.d;

import R3Hw71.A2egSU;
import android.app.Activity;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa implements AOLLoader.DrawAOLInteractionListener {
    public aaaaaaaa(DCBaseAOL dCBaseAOL, Activity activity) {
        super(dCBaseAOL, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaoa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaoaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaoaaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            feedAOLInteractionListener.onShowError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaoaaaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void acaaaaaa() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.aaaaaaac;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onStart();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 3));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 2));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 0));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 4));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 1));
    }
}
