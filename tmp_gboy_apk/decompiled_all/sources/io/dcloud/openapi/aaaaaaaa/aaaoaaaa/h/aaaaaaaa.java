package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h;

import android.app.Activity;
import com.sigmob.sdk.videoplayer.AMqCpz;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaao;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa implements AOLLoader.VAOLInteractionListener {
    private boolean aaaaaaoa;
    protected DCBaseAOL aaaaaoaa;
    protected aaaaaaao aaaaoaaa;
    protected AOLLoader.VAOLInteractionListener aaaoaaaa;
    private boolean aacaaaaa;
    private boolean acaaaaaa;

    public aaaaaaaa(Activity activity, int i) {
        super(activity);
        this.aaaaaaoa = false;
        this.acaaaaaa = false;
        this.aacaaaaa = false;
        this.aaaaaaac = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void aaaaaaa0(aaaaaaao aaaaaaaoVar) {
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(-5021, AOLErrorUtil.getErrorMsg(-5021), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaac(int i, String str) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShowError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaea() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaoaaaa() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShowError(-5006, AOLErrorUtil.getErrorMsg(-5006));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaoaaaaa() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onVideoPlayEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aeaaaaaa() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aoaaaaaa() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onSkip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void eaaaaaaa() {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.aaaoaaaa;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onClose();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa
    public void aaaaaaaa(int i, String str, JSONArray jSONArray) {
        this.aacaaaaa = false;
        this.aaaaaoaa = null;
        aaaaaaau.aaaaaaa0("uniAd-loadError", "code:" + i + ";message:" + str + ";detail:" + String.valueOf(jSONArray));
        MainHandlerUtil.getMainHandler().post(new FZu94u.A2egSU(this, i, str, jSONArray, 4));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa
    public void aaaaaaao(List list) {
        this.aacaaaaa = false;
        this.aaaaaoaa = null;
        MainHandlerUtil.getMainHandler().post(new AMqCpz(this, 3, list));
    }

    public boolean aaaaaeaa() {
        DCBaseAOL dCBaseAOL = this.aaaaaoaa;
        return dCBaseAOL != null && dCBaseAOL.isValid();
    }

    public String aaaaeaaa() {
        return this.aaaaaoaa != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaao(this.aaaaaoaa.getType()) : "";
    }

    public void destroy() {
        DCBaseAOL dCBaseAOL = this.aaaaaoaa;
        if (dCBaseAOL != null) {
            dCBaseAOL.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        aaaaaaaa(aaaaaaaa(), this.aaaaaoaa);
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 1));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        this.acaaaaaa = false;
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 3));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, String str, int i) {
        aaaaaaaa(aaaaaaaa(), this.aaaaaoaa, j, str, i);
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        this.aaaaaaoa = true;
        this.acaaaaaa = true;
        aaaaaaa0(aaaaaaaa(), this.aaaaaoaa);
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 0));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, String str) {
        this.acaaaaaa = false;
        MainHandlerUtil.getMainHandler().post(new DUi7mC.A2egSU(i, 6, this, str));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        this.acaaaaaa = false;
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 5));
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        this.acaaaaaa = false;
        MainHandlerUtil.getMainHandler().post(new A2egSU(this, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaac(List list) {
        if (list != null && list.size() > 0) {
            DCBaseAOL dCBaseAOL = (DCBaseAOL) list.get(0);
            this.aaaaaoaa = dCBaseAOL;
            dCBaseAOL.aaaaaaaa(this);
            aaaaaaao aaaaaaaoVar = this.aaaaoaaa;
            if (aaaaaaaoVar != null) {
                aaaaaaaoVar.onLoaded();
                return;
            }
            return;
        }
        aaaaaaao aaaaaaaoVar2 = this.aaaaoaaa;
        if (aaaaaaaoVar2 != null) {
            aaaaaaaoVar2.onError(-5005, AOLErrorUtil.getErrorMsg(-5005), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaao(int i, String str, JSONArray jSONArray) {
        aaaaaaao aaaaaaaoVar = this.aaaaoaaa;
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(i, str, jSONArray);
        }
    }

    public void aaaaaaaa(Activity activity) {
        if (this.aaaaaaoa) {
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, 2));
            return;
        }
        DCBaseAOL dCBaseAOL = this.aaaaaoaa;
        if (dCBaseAOL instanceof DCBaseAOLLoader) {
            ((DCBaseAOLLoader) dCBaseAOL).show(activity);
        }
    }

    public void aaaaaaaa(AOLLoader.VAOLInteractionListener vAOLInteractionListener) {
        this.aaaoaaaa = vAOLInteractionListener;
    }

    public void aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, final aaaaaaao aaaaaaaoVar) {
        if (this.acaaaaaa) {
            final int i = 0;
            MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.A4TApA
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            aaaaaaaa.aaaaaaa0(aaaaaaaoVar);
                            break;
                        default:
                            aaaaaaaa.aaaaaaaa(aaaaaaaoVar);
                            break;
                    }
                }
            });
        } else {
            if (this.aacaaaaa) {
                final int i2 = 1;
                MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.h.A4TApA
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                aaaaaaaa.aaaaaaa0(aaaaaaaoVar);
                                break;
                            default:
                                aaaaaaaa.aaaaaaaa(aaaaaaaoVar);
                                break;
                        }
                    }
                });
                return;
            }
            this.aaaaaaoa = false;
            aaaaaaaa(dCloudAOLSlot);
            this.aaaaoaaa = aaaaaaaoVar;
            this.aacaaaaa = true;
            aaaaaaac.aaaaaaaa().post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void aaaaaaaa(aaaaaaao aaaaaaaoVar) {
        if (aaaaaaaoVar != null) {
            aaaaaaaoVar.onError(-5017, AOLErrorUtil.getErrorMsg(-5017), null);
        }
    }
}
