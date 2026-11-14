package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa implements AOLLoader.ContentPageVideoListener {
    public aaaaaaaa(Activity activity, int i) {
        super(activity, i);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa
    public void aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, aaaaaaao aaaaaaaoVar) {
        try {
            Class.forName("com.kwad.sdk.api.KsContentPage");
            super.aaaaaaaa(dCloudAOLSlot, aaaaaaaoVar);
        } catch (ClassNotFoundException unused) {
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.onError(-5050, "当前环境没有快手内容联盟SDK", null);
            }
        }
    }

    public Fragment aaaaoaaa() {
        DCBaseAOL dCBaseAOL = this.aaaaaoaa;
        if (dCBaseAOL != null) {
            try {
                return (Fragment) dCBaseAOL.getClass().getDeclaredMethod("getContentPage", null).invoke(this.aaaaaoaa, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onComplete(aaaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onComplete(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onError(aaaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onError(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onPause(aaaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onPause(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onResume(aaaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onResume(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onStart(aaaaaaaa.aaaaaaa0 aaaaaaa0Var) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onStart(aaaaaaa0Var);
        }
    }
}
