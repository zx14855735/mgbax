package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaaa implements AOLLoader.ContentPageVideoListener {
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa aaaaaaa0;
    private aaaaaaao aaaaaaao;

    public static class aaaaaaa0 {
        private String aaaaaaa0;
        private String aaaaaaaa;
        private String aaaaaaac;
        private String aaaaaaao;
        private String aaaaaaau;

        public String getDuration() {
            return this.aaaaaaao;
        }

        public String getErrorCode() {
            return this.aaaaaaac;
        }

        public String getErrorMsg() {
            return this.aaaaaaau;
        }

        public String getId() {
            return this.aaaaaaaa;
        }

        public String getType() {
            return this.aaaaaaa0;
        }

        public void setDuration(String str) {
            this.aaaaaaao = str;
        }

        public void setErrorCode(String str) {
            this.aaaaaaac = str;
        }

        public void setErrorMsg(String str) {
            this.aaaaaaau = str;
        }

        public void setId(String str) {
            this.aaaaaaaa = str;
        }

        public void setType(String str) {
            this.aaaaaaa0 = str;
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0532aaaaaaaa implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao {
        final /* synthetic */ io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaa0 aaaaaaaa;

        public C0532aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaa0 aaaaaaa0Var) {
            this.aaaaaaaa = aaaaaaa0Var;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onError(int i, String str, JSONArray jSONArray) {
            this.aaaaaaaa.onError(i, str, jSONArray);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao
        public void onLoaded() {
            this.aaaaaaaa.onContentPageLoad();
        }
    }

    public aaaaaaaa(Activity activity) {
        super(activity);
        this.aaaaaaa0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa(activity, 14);
    }

    public Fragment getContentPage() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar == null) {
            return null;
        }
        return aaaaaaaaVar.aaaaoaaa();
    }

    @Deprecated
    public void load(DCloudAOLSlot dCloudAOLSlot, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaa0 aaaaaaa0Var) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (aaaaaaa0Var != null) {
                aaaaaaa0Var.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(dCloudAOLSlot, new C0532aaaaaaaa(aaaaaaa0Var));
        } else if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onError(-5015, AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onComplete(aaaaaaa0 aaaaaaa0Var) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onComplete(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onError(aaaaaaa0 aaaaaaa0Var) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onPause(aaaaaaa0 aaaaaaa0Var) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onPause(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onResume(aaaaaaa0 aaaaaaa0Var) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onResume(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onStart(aaaaaaa0 aaaaaaa0Var) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaao;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onStart(aaaaaaa0Var);
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
    }

    public void setContentPageVideoListener(aaaaaaao aaaaaaaoVar) {
        this.aaaaaaao = aaaaaaaoVar;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(this);
        }
    }

    public void show(Activity activity) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.c.aaaaaaaa aaaaaaaaVar = this.aaaaaaa0;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(activity);
        }
    }
}
