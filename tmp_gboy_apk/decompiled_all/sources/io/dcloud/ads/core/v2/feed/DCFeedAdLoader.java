package io.dcloud.ads.core.v2.feed;

import android.app.Activity;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.e.aaaaaaaa;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCFeedAdLoader extends aaaaaaau {
    public DCFeedAdLoader(Activity activity) {
        super(activity);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaau
    @Deprecated
    public void load(DCloudAOLSlot dCloudAOLSlot, aaaaaaac aaaaaaacVar) {
    }

    public void load(DCloudAdSlot dCloudAdSlot, final DCFeedAdLoadListener dCFeedAdLoadListener) {
        if (getContext() != null && dCloudAdSlot != null) {
            initLoader();
            this.aaaaaaa0.aaaaaaaa(dCloudAdSlot.getSlot(), new aaaaaaa0() { // from class: io.dcloud.ads.core.v2.feed.DCFeedAdLoader.1
                @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCFeedAdLoadListener dCFeedAdLoadListener2 = dCFeedAdLoadListener;
                    if (dCFeedAdLoadListener2 != null) {
                        dCFeedAdLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.auaaaaaa.aaaaaaa0
                public void onLoaded(List<aaaaaaaa> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<aaaaaaaa> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new DCFeedAd(it.next()));
                    }
                    DCFeedAdLoadListener dCFeedAdLoadListener2 = dCFeedAdLoadListener;
                    if (dCFeedAdLoadListener2 != null) {
                        dCFeedAdLoadListener2.onFeedAdLoad(arrayList);
                    }
                }
            });
        } else if (dCFeedAdLoadListener != null) {
            dCFeedAdLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
