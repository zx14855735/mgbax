package io.dcloud.api.custom;

import android.app.Activity;
import android.content.Context;
import io.dcloud.api.custom.base.UniAdConst;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.api.custom.type.draw.UniAdCustomDrawAdLoader;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAdLoader;
import io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader;
import io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader;
import io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader;
import io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomAdapter implements IAdAdapter {
    private boolean aaaaaaaa = false;
    private final List aaaaaaa0 = new CopyOnWriteArrayList();

    public interface aaaaaaaa {
        void aaaaaaaa();

        void aaaaaaaa(int i, String str);
    }

    public final void addInitListener(aaaaaaaa aaaaaaaaVar) {
        if (this.aaaaaaa0.contains(aaaaaaaaVar)) {
            return;
        }
        this.aaaaaaa0.add(aaaaaaaaVar);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public final DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        UniAdCustomBaseLoader adsByType = getAdsByType(dCloudAOLSlot.getType());
        if (adsByType == null) {
            return null;
        }
        int type = dCloudAOLSlot.getType();
        if (type != 1) {
            if (type != 4) {
                if (type != 7) {
                    if (type != 15) {
                        if (type != 9) {
                            if (type != 10 || !(adsByType instanceof UniAdCustomDrawAdLoader)) {
                                return null;
                            }
                        } else if (!(adsByType instanceof UniAdCustomRewardLoader)) {
                            return null;
                        }
                    } else if (!(adsByType instanceof UniAdCustomInterstitialLoader)) {
                        return null;
                    }
                } else if (!(adsByType instanceof UniAdCustomFullScreenVideoLoader)) {
                    return null;
                }
            } else if (!(adsByType instanceof UniAdCustomNativeAdLoader)) {
                return null;
            }
        } else if (!(adsByType instanceof UniAdCustomSplashLoader)) {
            return null;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.uaaaaaaa.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.uaaaaaaa.aaaaaaaa(dCloudAOLSlot, activity);
        aaaaaaaaVar.aaaaaaaa(adsByType);
        return aaaaaaaaVar;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public final String getAdapterSDKVersion() {
        return String.valueOf(getAdapterVersion());
    }

    public abstract int getAdapterVersion();

    public abstract UniAdCustomBaseLoader getAdsByType(@UniAdConst.CustomAdType int i);

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public abstract String getSDKVersion();

    public abstract void init(Context context, JSONObject jSONObject);

    public final boolean isInitSuccess() {
        return this.aaaaaaaa;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public final boolean isSupport() {
        return true;
    }

    public final void onInitFail(int i, String str) {
        this.aaaaaaaa = false;
        Iterator it = this.aaaaaaa0.iterator();
        while (it.hasNext()) {
            ((aaaaaaaa) it.next()).aaaaaaaa(i, str);
        }
    }

    public final void onInitSuccess() {
        this.aaaaaaaa = true;
        Iterator it = this.aaaaaaa0.iterator();
        while (it.hasNext()) {
            ((aaaaaaaa) it.next()).aaaaaaaa();
        }
    }

    public final void removeInitListener(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaa0.remove(aaaaaaaaVar);
    }

    public void setPrivacyConfig(UniAdPrivacyConfig uniAdPrivacyConfig) {
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public final void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        setPrivacyConfig(new UniAdPrivacyConfig(privacyConfig));
    }
}
