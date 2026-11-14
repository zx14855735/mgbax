package com.fl.saas.base.widget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdInfo {
    private int mAdv_id = 0;
    private String mTagid = "";

    public static AdInfo create(int i, String str) {
        AdInfo createEmpty = createEmpty();
        createEmpty.setAdv_id(i);
        createEmpty.setTagid(str);
        return createEmpty;
    }

    public static AdInfo createEmpty() {
        return new AdInfo();
    }

    public int getAdv_id() {
        return this.mAdv_id;
    }

    public String getTagid() {
        return this.mTagid;
    }

    public void setAdv_id(int i) {
        this.mAdv_id = i;
    }

    public void setTagid(String str) {
        this.mTagid = str;
    }
}
