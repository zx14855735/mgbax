package com.kwad.sdk.i;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class e implements com.kwad.sdk.i.b {
    public double aAi;
    public b aXA;
    public a aXB;
    public int aXz;

    public static class a implements com.kwad.sdk.i.b {
        public List<String> aXC;
        public List<String> aXD;
        public List<String> aXE;

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aXC = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            int i = 0;
            if (optJSONArray != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    i2 = A2egSU.ADYaiT(optJSONArray, i2, this.aXC, i2, 1);
                }
            }
            this.aXD = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                int i3 = 0;
                while (i3 < optJSONArray2.length()) {
                    i3 = A2egSU.ADYaiT(optJSONArray2, i3, this.aXD, i3, 1);
                }
            }
            this.aXE = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                while (i < optJSONArray3.length()) {
                    i = A2egSU.ADYaiT(optJSONArray3, i, this.aXE, i, 1);
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aXF = -1;
        public static int aXG;
        public List<String> aSY;
        public List<String> aSZ;
        public List<String> aXH;
        public int aXI = aXF;

        public final boolean OM() {
            return this.aXI == OK;
        }

        public final void bO(boolean z) {
            this.aXI = z ? OK : aXG;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aSY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            int i = 0;
            if (optJSONArray != null) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    i2 = A2egSU.ADYaiT(optJSONArray, i2, this.aSY, i2, 1);
                }
            }
            this.aSZ = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                int i3 = 0;
                while (i3 < optJSONArray2.length()) {
                    i3 = A2egSU.ADYaiT(optJSONArray2, i3, this.aSZ, i3, 1);
                }
            }
            this.aXH = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                while (i < optJSONArray3.length()) {
                    i = A2egSU.ADYaiT(optJSONArray3, i, this.aXH, i, 1);
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aAi = jSONObject.optDouble(com.sigmob.sdk.base.n.C);
        this.aXz = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aXA = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aXB = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
