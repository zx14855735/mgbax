package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaae;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaeaaa;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import io.dcloud.openapi.poly.api.Platform;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends DCBaseAOLLoader implements aaaaaaaa.aaaaaaao {
    private Handler aaaaaana;
    private int aaaaaaua;
    private aaaaaaaa.aaaaaaau aaaaanaa;
    private String aaaanaaa;
    private Platform aaanaaaa;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa aanaaaaa;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public class C0542aaaaaaa0 implements aaaaaaae {
        public C0542aaaaaaa0() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaae
        public void aaaaaaaa() {
            if (aaaaaaa0.this.getVideoAdCallback() != null) {
                aaaaaaa0.this.getVideoAdCallback().onClose();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaae
        public void onClicked() {
            if (aaaaaaa0.this.getVideoAdCallback() != null) {
                aaaaaaa0.this.getVideoAdCallback().onClick();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaae
        public void onShow() {
            if (aaaaaaa0.this.getVideoAdCallback() != null) {
                aaaaaaa0.this.getVideoAdCallback().onShow();
            }
        }
    }

    public class aaaaaaaa extends Handler {
        public aaaaaaaa(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            aaaaaaa0.this.loadFail(-9999, "");
        }
    }

    public class aaaaaaao implements aaaaaaaa.aaaaaaae {
        public aaaaaaao() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaae
        public void aaaaaaa0() {
            if (aaaaaaa0.this.getAdStatus() != -1) {
                return;
            }
            aaaaaaaa.aaaaaaau aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(aaaaaaa0.this.getActivity(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
            if (!aaaaaaa0.aaaaaaaa()) {
                aaaaaaa0.this.loadFail(-9999, "");
                return;
            }
            aaaaaaa0.this.aaaaanaa = aaaaaaa0;
            aaaaaaa0.this.aaaaanaa.aaaaaaaa(aaaaaaa0.this.getDCloudId());
            aaaaaaa0.this.loadSuccess();
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaae
        public void aaaaaaaa() {
            if (aaaaaaa0.this.getAdStatus() != -1) {
                return;
            }
            aaaaaaaa.aaaaaaau aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(aaaaaaa0.this.getActivity(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
            if (!aaaaaaa0.aaaaaaaa()) {
                aaaaaaa0.this.loadFail(-9999, "");
                return;
            }
            aaaaaaa0.this.aaaaanaa = aaaaaaa0;
            aaaaaaa0.this.aaaaanaa.aaaaaaaa(aaaaaaa0.this.getDCloudId());
            aaaaaaa0.this.loadSuccess();
        }
    }

    public aaaaaaa0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.aaaanaaa = "";
        this.aaaaaana = new aaaaaaaa(Looper.getMainLooper());
        this.aaaaaaua = 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaa0(ViewGroup viewGroup) {
        this.aanaaaaa.aaaaaaaa(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aaaaaaao, reason: merged with bridge method [inline-methods] */
    public void aaaaaaaa(ViewGroup viewGroup) {
        new aaaaeaaa(getActivity(), this.aaaaanaa, viewGroup, new C0542aaaaaaa0()).aaaaaaa0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaca() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaoaaa.aaaaaaaa aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.eaaaaaaa.aaaaaaa0.aaaaaaaa(this, getActivity(), this.aaanaaaa.getSplash(), getSlotId(), this.aaanaaaa.getEr(), this.aaanaaaa.getEc());
        this.aanaaaaa = aaaaaaaa2;
        aaaaaaaa2.aaaaaaao();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void aaaaaaae() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String aaaaaaea() {
        Platform platform = this.aaanaaaa;
        return platform == null ? "" : platform.getAppid();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void aaaaeaaa() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getTid() {
        Platform platform = this.aaanaaaa;
        if (platform != null) {
            return platform.getTid();
        }
        aaaaaaaa.aaaaaaau aaaaaaauVar = this.aaaaanaa;
        return aaaaaaauVar != null ? aaaaaaauVar.aaaaaeaa : "";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        Platform platform = this.aaanaaaa;
        return platform == null ? this.aaaanaaa : platform.getType();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        if (TextUtils.isEmpty(this.aaaanaaa)) {
            loadFail(-9999, "");
            return;
        }
        if (this.aaaanaaa.equals("dcloud")) {
            aaaaaaau.aaaaaaaa("uniAd", "load base");
            this.aaaaaana.sendEmptyMessageDelayed(this.aaaaaaua, PushUIConfig.dismissTime);
        } else if (this.aaanaaaa == null) {
            loadFail(-9999, "");
        } else {
            MainHandlerUtil.getMainHandler().post(new com.fl.saas.common.crash.A2egSU(4, this));
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void onSplashAdLoad() {
        loadSuccess();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public boolean runOnMain() {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void setPlatform(Platform platform, String str) {
        this.aaanaaaa = platform;
        this.aaaanaaa = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(final ViewGroup viewGroup) {
        if ((this.aanaaaaa == null && this.aaaaanaa == null) || TextUtils.isEmpty(this.aaaanaaa)) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
                return;
            }
            return;
        }
        if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else {
            if (this.aaaanaaa.equals("dcloud")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    aaaaaaaa(viewGroup);
                    return;
                } else {
                    final int i = 0;
                    MainHandlerUtil.getMainHandler().post(new Runnable(this) { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.A2egSU

                        /* renamed from: AlLFFp, reason: collision with root package name */
                        public final /* synthetic */ aaaaaaa0 f13900AlLFFp;

                        {
                            this.f13900AlLFFp = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    this.f13900AlLFFp.aaaaaaaa(viewGroup);
                                    break;
                                default:
                                    this.f13900AlLFFp.aaaaaaa0(viewGroup);
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.aanaaaaa.aaaaaaaa(viewGroup);
            } else {
                final int i2 = 1;
                MainHandlerUtil.getMainHandler().post(new Runnable(this) { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa.A2egSU

                    /* renamed from: AlLFFp, reason: collision with root package name */
                    public final /* synthetic */ aaaaaaa0 f13900AlLFFp;

                    {
                        this.f13900AlLFFp = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f13900AlLFFp.aaaaaaaa(viewGroup);
                                break;
                            default:
                                this.f13900AlLFFp.aaaaaaa0(viewGroup);
                                break;
                        }
                    }
                });
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aeaaaaaa.aaaaaaaa.aaaaaaao
    public void aaaaaaaa(int i, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, PluginConstants.KEY_ERROR_CODE + i + ";message:" + str);
        }
    }

    public void aaaaaaaa(JSONArray jSONArray, boolean z) {
        aaaaaaau.aaaaaaaa("uniAd-finish", String.valueOf(jSONArray) + "::::::" + z);
        if (this.aaaaaana.hasMessages(this.aaaaaaua)) {
            this.aaaaaana.removeMessages(this.aaaaaaua);
            if (z) {
                if (jSONArray != null && jSONArray.length() != 0) {
                    aaaaaaao aaaaaaaoVar = new aaaaaaao();
                    boolean z2 = true;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa(getActivity(), optJSONObject, System.currentTimeMillis(), aaaaaaaoVar);
                            z2 = false;
                        }
                    }
                    if (z2) {
                        loadFail(-9999, "");
                        return;
                    }
                    return;
                }
                aaaaaaaa.aaaaaaau aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaa0(getActivity(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
                if (aaaaaaa0.aaaaaaaa()) {
                    this.aaaaanaa = aaaaaaa0;
                    aaaaaaa0.aaaaaaaa(getDCloudId());
                    loadSuccess();
                    return;
                }
                loadFail(-9999, "");
                return;
            }
            loadFail(-9999, "");
        }
    }
}
