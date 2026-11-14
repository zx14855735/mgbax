package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa;

import android.app.Activity;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaaa implements AOLLoader.VAOLInteractionListener {
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaa0;
    private aaaaaaa0 aaaaaaao;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a0aaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0514aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao {
        final /* synthetic */ aaaaaaao aaaaaaaa;

        public C0514aaaaaaaa(aaaaaaao aaaaaaaoVar) {
            this.aaaaaaaa = aaaaaaaoVar;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onError(int i, String str, JSONArray jSONArray) {
            aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.onError(i, str, jSONArray);
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onLoaded() {
            aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.onFullScreenAOLLoad();
            }
        }
    }

    public aaaaaaaa(Activity activity) {
        super(activity);
        this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa(activity, 7);
    }

    public String getType() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        return aaaaaaaaVar == null ? "" : aaaaaaaaVar.aaaaeaaa();
    }

    public boolean isValid() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            return aaaaaaaaVar.aaaaaeaa();
        }
        return false;
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, aaaaaaao aaaaaaaoVar) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(dCloudAOLSlot, new C0514aaaaaaaa(aaaaaaaoVar));
        } else if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onClick();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onClose();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onShow();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onShowError(i, str);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onSkip();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaao;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onVideoPlayEnd();
        }
    }

    public void setFullScreenAOLListener(aaaaaaa0 aaaaaaa0Var) {
        this.aaaaaaao = aaaaaaa0Var;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
        }
    }

    public void show(Activity activity) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(activity);
        }
    }
}
