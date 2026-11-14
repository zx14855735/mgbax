package io.dcloud.openapi.core.module;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.fl.saas.common.crash.A2egSU;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import io.dcloud.openapi.poly.api.Platform;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class DCBaseAOLLoader extends io.dcloud.openapi.core.module.aaaaaaaa {
    private boolean aaa0aaaa;
    private final Handler aaaa0aaa;
    private final int aaaaa0aa;
    private int aaaaaa0a;
    private aaaaaaaa.InterfaceC0537aaaaaaaa anaaaaaa;

    public class aaaaaaa0 extends Handler {
        public aaaaaaa0(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            DCBaseAOLLoader.this.loadFail(AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite, "timeout");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public static class aaaaaaaa implements Runnable {
        private final int aaaaaaa0;
        private final DCBaseAOLLoader aaaaaaaa;
        private final String aaaaaaac;
        private final int aaaaaaao;
        private final List aaaaaaau;

        public aaaaaaaa(DCBaseAOLLoader dCBaseAOLLoader, List list, int i, int i2, String str) {
            this.aaaaaaaa = dCBaseAOLLoader;
            this.aaaaaaa0 = i;
            this.aaaaaaao = i2;
            this.aaaaaaac = str;
            this.aaaaaaau = list;
            if (list != null) {
                aaaaaaau.aaaaaaac("sub slot ads:" + list.size());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            aaaaaaao aaaaaaaoVar = new aaaaaaao();
            aaaaaaaoVar.aaaaaaao(this.aaaaaaaa.aaaaaaea()).aaaaaaau(this.aaaaaaaa.getSlotId()).aaaaaaaa(this.aaaaaaaa.aaaaaaau).aaaaaaac(this.aaaaaaaa.getType()).aaaaaaan(this.aaaaaaaa.getTid()).aaaaaaaa(this.aaaaaaaa.aaaaaoaa());
            if (this.aaaaaaaa.aaaaoaaa()) {
                aaaaaaaoVar.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaaa)).aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaa0(this.aaaaaaaa));
            }
            int i = this.aaaaaaa0;
            if (i == 1) {
                aaaaaaaoVar.aaaaaaa0(i);
                this.aaaaaaaa.anaaaaaa.aaaaaaaa(this.aaaaaaaa, this.aaaaaaau, aaaaaaaoVar);
            } else if (i == 0) {
                aaaaaaaoVar.aaaaaaa0(i);
                aaaaaaaoVar.aaaaaaaa(this.aaaaaaao, this.aaaaaaac);
                this.aaaaaaaa.anaaaaaa.aaaaaaaa(this.aaaaaaaa, aaaaaaaoVar);
            }
        }
    }

    public DCBaseAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.aaa0aaaa = false;
        this.aaaaa0aa = 1;
        this.aaaaaa0a = 5000;
        aaaaaaac(-1);
        this.aaaa0aaa = new aaaaaaa0(aaaaaaac.aaaaaaaa().getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaacaaa() {
        try {
            load();
        } catch (Throwable th) {
            loadFail(-4002, th.getMessage());
        }
    }

    private boolean aaacaaaa() {
        return getSlot().getType() == 10 || getSlot().getType() == 4 || getSlot().getType() == 5;
    }

    private boolean aacaaaaa() {
        if (TextUtils.isEmpty(aaaaaaea())) {
            return !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaaa(getType()) || getType().equalsIgnoreCase("dcloud") || getType().equalsIgnoreCase(Const.TYPE_WM);
        }
        if (getType().equalsIgnoreCase(Const.TYPE_SGM)) {
            return !TextUtils.isEmpty(eaaaaaaa());
        }
        return true;
    }

    public void aaaaaaaa(IAdAdapter iAdAdapter, JSONObject jSONObject) {
    }

    public aaaaaaao aaaaacaa() {
        aaaaaaao aaaaaaaoVar = new aaaaaaao();
        aaaaaaoa();
        aaaaaaaoVar.aaaaaaao(aaaaaaea()).aaaaaaaa(this.aaaaaaau).aaaaaaau(getSlotId()).aaaaaaac(getType()).aaaaaaan(getTid()).aaaaaaaa(aaaaaoaa());
        aaaaaaaoVar.aaaaaaa0(getAdStatus());
        if (aaaaoaaa()) {
            aaaaaaaoVar.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(this)).aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaa0(this));
        }
        return aaaaaaaoVar;
    }

    public abstract void init(String str, String str2);

    public abstract void load();

    public final void loadFail(int i, String str) {
        if (this.aaa0aaaa) {
            return;
        }
        aaaaaaao(i, str);
        this.aaa0aaaa = true;
        this.aaaa0aaa.removeMessages(1);
        aaaaaaac.aaaaaaaa().post(new aaaaaaaa(this, null, 0, i, str));
    }

    public final void loadSuccess() {
        if (aaacaaaa()) {
            loadFail(-5001, "回调接口调用失败，应该使用loadSuccess(List obj)");
        } else {
            loadSuccess(null);
        }
    }

    public boolean runOnMain() {
        return false;
    }

    public void setPlatform(Platform platform, String str) {
    }

    public void show(Activity activity) {
    }

    public void showIn(ViewGroup viewGroup) {
    }

    public final void aaaaaaaa(Map map) {
        aaaaaaac(-1);
        if (!aacaaaaa()) {
            loadFail(-9999, "");
            return;
        }
        if (TextUtils.isEmpty(getSlotId())) {
            loadFail(-9999, "");
            return;
        }
        startLoadTime();
        if (runOnMain()) {
            MainHandlerUtil.getMainHandler().post(new A2egSU(6, this));
        } else {
            try {
                load();
            } catch (Throwable th) {
                loadFail(-4002, th.getMessage());
            }
        }
        this.aaaa0aaa.sendEmptyMessageDelayed(1, this.aaaaaa0a);
    }

    public final void loadSuccess(List<? extends DCBaseAOL> list) {
        if (!aaacaaaa()) {
            list = null;
        }
        List<? extends DCBaseAOL> list2 = list;
        if (this.aaa0aaaa) {
            return;
        }
        if (list2 != null) {
            for (DCBaseAOL dCBaseAOL : list2) {
                dCBaseAOL.aaaaaaau = this.aaaaaaau;
                dCBaseAOL.aaaaaaa0(isSlotSupportBidding());
                dCBaseAOL.setBiddingECPM(aeaaaaaa());
                dCBaseAOL.aaaaaaac = this.aaaaaaac;
                dCBaseAOL.aaaaaaae = this.aaaaaaae;
                dCBaseAOL.aaaaaaae(getSlotId());
                dCBaseAOL.aaaaaaa0(aaaaaaea());
                dCBaseAOL.setFeedType(getFeedType());
                dCBaseAOL.aaaaaaac(aaoaaaaa());
                dCBaseAOL.aaaaoaaa = this.aaaaoaaa;
            }
        }
        acaaaaaa();
        this.aaa0aaaa = true;
        this.aaaa0aaa.removeMessages(1);
        aaaaaaac.aaaaaaaa().post(new aaaaaaaa(this, list2, 1, 0, null));
    }

    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaanaaaa.aaaaaaac aaaaaaacVar) {
        aaaaaaae(aaaaaaacVar.eaaaaaaa());
        this.aaaaoaaa = aaaaaaacVar.aaaaaeaa();
        aaaaaaa0(aaaaaaacVar.aaaaaoaa());
        if (!isSlotSupportBidding()) {
            setBiddingECPM(aaaaaaacVar.aaaaaaao());
        }
        this.aaaaaaac = aaaaaaacVar.aaaaaaea();
        this.aaaaaa0a = aaaaaaacVar.aeaaaaaa();
        this.aaaaaaau = aaaaaaacVar.aaaaaaan();
        this.aaaaaaae = aaaaaaacVar.aaaaaaa0();
        setFeedType(aaaaaaacVar.aaaaaaac());
        aaaaaaau(aaaaaaacVar.aaaaaaav());
        aaaaaaaa(aaaaaaacVar.aaoaaaaa());
        aaaaaaan(aaaaaaacVar.aaaaeaaa());
        aaaaaaao(aaaaaaacVar.aaaaaaeo());
        aaaaaaaa(aaaaaaacVar.aaaeaaaa());
        aaaaaaaa(aaaaaaacVar.aaaaaaaa());
        aaaaaaa0(aaaaaaacVar.aaaaaaau());
        setExpressAd(aaaaaaacVar.aaaoaaaa());
        aaaaaaau.aaaaaaac("load sub slot cfg:" + aaaaaaacVar.toString());
    }

    public void aaaaaaaa(String str, String str2) {
        aaaaaaa0(str);
        aaaaaaao(str2);
        init(str, str2);
    }

    public final void aaaaaaaa(String str, IAdAdapter iAdAdapter, JSONObject jSONObject) {
        aaaaaaa0(str);
        aaaaaaaa(iAdAdapter, jSONObject);
    }

    public void aaaaaaaa(aaaaaaaa.InterfaceC0537aaaaaaaa interfaceC0537aaaaaaaa) {
        this.anaaaaaa = interfaceC0537aaaaaaaa;
    }
}
