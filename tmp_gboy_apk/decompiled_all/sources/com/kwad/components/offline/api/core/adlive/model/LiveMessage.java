package com.kwad.components.offline.api.core.adlive.model;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.LiveStringUtil;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LiveMessage extends BaseOfflineCompoJsonParse<LiveMessage> implements Serializable {
    private static final long serialVersionUID = 2264410572624564928L;
    public String content;
    public long mSortRank;
    public String userName;

    public boolean isInValid() {
        return LiveStringUtil.isNullString(this.userName) || LiveStringUtil.isNullString(this.content);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveMessage.userName = jSONObject.optString("userName");
        Object opt = jSONObject.opt("userName");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            liveMessage.userName = "";
        }
        liveMessage.content = jSONObject.optString(IAdInterListener.AdProdType.PRODUCT_CONTENT);
        if (jSONObject.opt(IAdInterListener.AdProdType.PRODUCT_CONTENT) == obj) {
            liveMessage.content = "";
        }
        liveMessage.mSortRank = jSONObject.optInt("sortRank");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = liveMessage.userName;
        if (str != null && !str.equals("")) {
            aa.putValue(jSONObject, "userName", liveMessage.userName);
        }
        String str2 = liveMessage.content;
        if (str2 != null && !str2.equals("")) {
            aa.putValue(jSONObject, IAdInterListener.AdProdType.PRODUCT_CONTENT, liveMessage.content);
        }
        long j = liveMessage.mSortRank;
        if (j != 0) {
            aa.putValue(jSONObject, "sortRank", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage) {
        return toJson(liveMessage, (JSONObject) null);
    }
}
