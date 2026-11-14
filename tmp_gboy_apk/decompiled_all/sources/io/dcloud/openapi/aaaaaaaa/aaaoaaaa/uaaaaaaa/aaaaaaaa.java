package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.uaaaaaaa;

import android.app.Activity;
import android.view.ViewGroup;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.AdUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends DCBaseAOLLoader implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa, aaaaaaaa.InterfaceC0548aaaaaaaa {
    private UniAdCustomBaseLoader aaaanaaa;
    private UniAdCustomAdapter aaanaaaa;
    private JSONObject aanaaaaa;

    public aaaaaaaa(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaan() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaao() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaau() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaeo() {
        loadSuccess();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public int aaaaaeaa() {
        return isSlotSupportBidding() ? 1 : 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean aaaaoaaa() {
        return true;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public int aeaaaaaa() {
        return super.aeaaaaaa();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.aaaanaaa;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.aaaanaaa;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.aaaanaaa;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        UniAdCustomBaseLoader uniAdCustomBaseLoader = this.aaaanaaa;
        return uniAdCustomBaseLoader != null && uniAdCustomBaseLoader.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        UniAdSlot uniAdSlot = new UniAdSlot();
        uniAdSlot.setSlotId(getSlotId());
        uniAdSlot.setExtra(getSlot().getExtra());
        uniAdSlot.setUserId(getSlot().getUserId());
        uniAdSlot.setWidth(getSlot().getWidth());
        uniAdSlot.setHeight(getSlot().getHeight());
        uniAdSlot.setAdCount(getSlot().getCount());
        aaaaaaaa(getActivity(), uniAdSlot);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (isValid()) {
            this.aaaanaaa.show(activity);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(ViewGroup viewGroup) {
        if (isValid()) {
            this.aaaanaaa.show(viewGroup);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.uaaaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0549aaaaaaaa implements UniAdCustomAdapter.aaaaaaaa {
        final /* synthetic */ UniAdSlot aaaaaaa0;
        final /* synthetic */ Activity aaaaaaaa;

        public C0549aaaaaaaa(Activity activity, UniAdSlot uniAdSlot) {
            this.aaaaaaaa = activity;
            this.aaaaaaa0 = uniAdSlot;
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.aaaaaaaa
        public void aaaaaaaa() {
            aaaaaaaa.this.aaaanaaa.aaaaaaaa(this.aaaaaaaa, this.aaaaaaa0, aaaaaaaa.this);
            aaaaaaaa.this.aaanaaaa.removeInitListener(this);
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.aaaaaaaa
        public void aaaaaaaa(int i, String str) {
            aaaaaaaa.this.loadFail(i, str);
            aaaaaaaa.this.aaanaaaa.removeInitListener(this);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaa0(int i, String str) {
        loadFail(i, str);
    }

    public void aaaaaaaa(UniAdCustomBaseLoader uniAdCustomBaseLoader) {
        this.aaaanaaa = uniAdCustomBaseLoader;
    }

    public void aaaaaaaa(Activity activity, UniAdSlot uniAdSlot) {
        if (this.aaaanaaa != null) {
            UniAdCustomAdapter uniAdCustomAdapter = this.aaanaaaa;
            if (uniAdCustomAdapter != null) {
                if (uniAdCustomAdapter.isInitSuccess()) {
                    this.aaaanaaa.aaaaaaaa(activity, uniAdSlot, this);
                    return;
                }
                this.aaanaaaa.addInitListener(new C0549aaaaaaaa(activity, uniAdSlot));
                try {
                    this.aaanaaaa.setPrivacyConfig(new UniAdPrivacyConfig(AdUtil.getCustomPrivacyConfig()));
                    this.aaanaaaa.init(getActivity(), this.aanaaaaa);
                    return;
                } catch (Exception unused) {
                    loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
                    return;
                }
            }
            loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
            return;
        }
        loadFail(-4001, AOLErrorUtil.getErrorMsg(-4001));
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void aaaaaaaa(IAdAdapter iAdAdapter, JSONObject jSONObject) {
        this.aaanaaaa = (UniAdCustomAdapter) iAdAdapter;
        this.aanaaaaa = jSONObject;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaaa(List list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                UniAdCustomNativeAd uniAdCustomNativeAd = (UniAdCustomNativeAd) it.next();
                aaaaaaa0 aaaaaaa0Var = new aaaaaaa0(getSlot(), getActivity());
                aaaaaaa0Var.aaaaaaaa(uniAdCustomNativeAd);
                if (isSlotSupportBidding()) {
                    aaaaaaa0Var.setBiddingECPM(uniAdCustomNativeAd.getBidPrice());
                }
                arrayList.add(aaaaaaa0Var);
            }
            loadSuccess(arrayList);
            return;
        }
        loadFail(-5004, AOLErrorUtil.getErrorMsg(200000));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa
    public void aaaaaaaa(int i, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + i + ";message:" + str);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa.InterfaceC0548aaaaaaaa
    public void aaaaaaaa() {
        if (getVideoAdCallback() instanceof io.dcloud.openapi.aaaaaaaa.aaaoaaaa.f.aaaaaaaa) {
            ((io.dcloud.openapi.aaaaaaaa.aaaoaaaa.f.aaaaaaaa) getVideoAdCallback()).onReward(new JSONObject());
        }
    }
}
