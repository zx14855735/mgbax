package io.dcloud.api.custom.base;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UniAdSlot {
    private String aaaaaaaa;
    private String aaaaaaan;
    private String aaaaaaau;
    private int aaaaaaa0 = 0;
    private int aaaaaaao = 0;
    private int aaaaaaac = 3;

    public int getAdCount() {
        return this.aaaaaaac;
    }

    public String getExtra() {
        return this.aaaaaaau;
    }

    public int getHeight() {
        return this.aaaaaaao;
    }

    public String getSlotId() {
        return this.aaaaaaaa;
    }

    public String getUserId() {
        return this.aaaaaaan;
    }

    public int getWidth() {
        return this.aaaaaaa0;
    }

    public void setAdCount(int i) {
        this.aaaaaaac = i;
    }

    public void setExtra(String str) {
        this.aaaaaaau = str;
    }

    public void setHeight(int i) {
        this.aaaaaaao = i;
    }

    public void setSlotId(String str) {
        this.aaaaaaaa = str;
    }

    public void setUserId(String str) {
        this.aaaaaaan = str;
    }

    public void setWidth(int i) {
        this.aaaaaaa0 = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UniAdSlot{slotId='");
        sb.append(this.aaaaaaaa);
        sb.append("', width=");
        sb.append(this.aaaaaaa0);
        sb.append(", height=");
        sb.append(this.aaaaaaao);
        sb.append(", adCount=");
        sb.append(this.aaaaaaac);
        sb.append(", extra='");
        sb.append(this.aaaaaaau);
        sb.append("', userId='");
        return CtFAbx.B25kr6(sb, this.aaaaaaan, "'}");
    }
}
