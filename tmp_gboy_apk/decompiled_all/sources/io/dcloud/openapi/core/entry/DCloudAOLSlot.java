package io.dcloud.openapi.core.entry;

import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCloudAOLSlot {
    private final String aaaaaaa0;
    private String aaaaaaaa;
    private JSONObject aaaaaaac;
    private int aaaaaaae;
    private final boolean aaaaaaan;
    private final String aaaaaaao;
    private final int aaaaaaau;
    private final String aaaaaaav;
    private String aaaaaaeo;
    private int aaaaaeaa;
    private final int aaaaeaaa;
    private final int aaaeaaaa;

    public static final class Builder {
        private String aaaaaaa0;
        private String aaaaaaaa;
        private int aaaaaaan;
        private String aaaaaaao;
        private int aaaaaaau;
        private int aaaaaaac = 3;
        private boolean aaaaaaae = false;
        private final int aaaaaaav = 1;
        private String aaaaaaeo = "";

        public Builder adpid(String str) {
            this.aaaaaaaa = str;
            return this;
        }

        public DCloudAOLSlot build() {
            return new DCloudAOLSlot(this);
        }

        public Builder count(int i) {
            this.aaaaaaac = i;
            return this;
        }

        public Builder extra(String str) {
            this.aaaaaaao = str;
            return this;
        }

        public Builder height(int i) {
            this.aaaaaaan = i;
            return this;
        }

        public Builder setEI(String str) {
            this.aaaaaaeo = str;
            return this;
        }

        public Builder setVideoSoundEnable(boolean z) {
            this.aaaaaaae = z;
            return this;
        }

        public Builder userId(String str) {
            this.aaaaaaa0 = str;
            return this;
        }

        public Builder width(int i) {
            this.aaaaaaau = i;
            return this;
        }
    }

    public String getAdpid() {
        return this.aaaaaaaa;
    }

    public JSONObject getConfig() {
        return this.aaaaaaac;
    }

    public int getCount() {
        return this.aaaaaaau;
    }

    public String getEI() {
        return this.aaaaaaav;
    }

    public String getExt() {
        return this.aaaaaaao;
    }

    public String getExtra() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.aaaaaaao);
            jSONObject.put("ruu", this.aaaaaaeo);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public int getHeight() {
        return this.aaaaeaaa;
    }

    public int getOrientation() {
        return this.aaaaaaae;
    }

    public int getType() {
        return this.aaaaaeaa;
    }

    public String getUserId() {
        return this.aaaaaaa0;
    }

    public int getWidth() {
        return this.aaaeaaaa;
    }

    public boolean isVideoSoundEnable() {
        return this.aaaaaaan;
    }

    public void setAdpid(String str) {
        this.aaaaaaaa = str;
    }

    public void setConfig(JSONObject jSONObject) {
        this.aaaaaaac = jSONObject;
    }

    public void setRID(String str) {
        this.aaaaaaeo = str;
    }

    public void setType(int i) {
        this.aaaaaeaa = i;
    }

    private DCloudAOLSlot(Builder builder) {
        this.aaaaaaae = 1;
        this.aaaaaeaa = -1;
        this.aaaaaaaa = builder.aaaaaaaa;
        this.aaaaaaa0 = builder.aaaaaaa0;
        this.aaaaaaao = builder.aaaaaaao;
        this.aaaaaaau = builder.aaaaaaac > 0 ? Math.min(builder.aaaaaaac, 3) : 3;
        this.aaaeaaaa = builder.aaaaaaau;
        this.aaaaeaaa = builder.aaaaaaan;
        this.aaaaaaae = 1;
        this.aaaaaaan = builder.aaaaaaae;
        this.aaaaaaav = builder.aaaaaaeo;
    }
}
