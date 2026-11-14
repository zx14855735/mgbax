package com.fl.saas.common.saas.bean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PreAdPlace {
    private AdPlace mAdPlace;
    private int position;

    public PreAdPlace(int i, AdPlace adPlace) {
        this.position = i;
        this.mAdPlace = adPlace;
    }

    public static PreAdPlace create(int i, AdPlace adPlace) {
        return new PreAdPlace(i, adPlace);
    }

    public AdPlace getAdPlace() {
        return this.mAdPlace;
    }

    public int getPosition() {
        return this.position;
    }

    public void setAdPlace(AdPlace adPlace) {
        this.mAdPlace = adPlace;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
