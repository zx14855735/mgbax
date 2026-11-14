package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa;

import android.app.Activity;
import android.view.ViewGroup;
import io.dcloud.openapi.core.entry.SplashAOLConfig;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaaa implements AOLLoader.VAOLInteractionListener {
    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0 aaaaaaa0;
    private aaaaaaao aaaaaaao;

    public class aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao {
        final /* synthetic */ aaaaaaac aaaaaaaa;

        public aaaaaaaa(aaaaaaac aaaaaaacVar) {
            this.aaaaaaaa = aaaaaaacVar;
        }

        public void getConfig(JSONObject jSONObject) {
            try {
                this.aaaaaaaa.getClass().getDeclaredMethod("getConfig", JSONObject.class).invoke(this.aaaaaaaa, jSONObject);
            } catch (Exception unused) {
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onError(int i, String str, JSONArray jSONArray) {
            this.aaaaaaaa.onError(i, str, jSONArray);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onLoaded() {
            this.aaaaaaaa.onSplashAOLLoad();
        }
    }

    public aaaaaaa0(Activity activity) {
        super(activity);
        this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0(activity, 1);
    }

    public boolean isSplashOpen() {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaac(getContext());
    }

    public boolean isValid() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
        return aaaaaaa0Var != null && aaaaaaa0Var.aaaaaeaa();
    }

    public void load(SplashAOLConfig splashAOLConfig, aaaaaaac aaaaaaacVar) {
        if (getContext() == null || splashAOLConfig == null) {
            if (aaaaaaacVar != null) {
                aaaaaaacVar.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.aaaaaaaa(splashAOLConfig, new aaaaaaaa(aaaaaaacVar));
        } else if (aaaaaaacVar != null) {
            aaaaaaacVar.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onClick();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onClose();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onShow();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onShowError(i, str);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onSkip();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onVideoPlayEnd();
        }
    }

    public void setSplashAOLListener(aaaaaaao aaaaaaaoVar) {
        this.aaaaaaao = aaaaaaaoVar;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.aaaaaaaa(this);
        }
    }

    public void show(Activity activity) {
    }

    @Deprecated
    public void showIn(ViewGroup viewGroup) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.g.aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.aaaaaaaa(viewGroup);
        }
    }

    public void show(ViewGroup viewGroup) {
        showIn(viewGroup);
    }
}
