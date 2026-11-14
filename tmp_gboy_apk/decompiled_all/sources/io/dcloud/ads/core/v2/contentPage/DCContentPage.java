package io.dcloud.ads.core.v2.contentPage;

import android.app.Activity;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaacaaa.aaaaaaao;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCContentPage extends aaaaaaaa {
    public DCContentPage(Activity activity) {
        super(activity);
    }

    public void load(DCloudAdSlot dCloudAdSlot, DCContentPageLoadListener dCContentPageLoadListener) {
        super.load(dCloudAdSlot.getSlot(), dCContentPageLoadListener);
    }

    public void setContentPageVideoListener(DCContentPageVideoListener dCContentPageVideoListener) {
        super.setContentPageVideoListener((aaaaaaao) dCContentPageVideoListener);
    }
}
