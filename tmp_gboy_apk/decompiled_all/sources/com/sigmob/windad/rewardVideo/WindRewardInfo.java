package com.sigmob.windad.rewardVideo;

import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindRewardInfo {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f13796a;
    private HashMap<String, String> b;

    public WindRewardInfo(boolean z) {
        this.f13796a = z;
    }

    public HashMap<String, String> getOptions() {
        return this.b;
    }

    public boolean isReward() {
        return this.f13796a;
    }

    public void setOptions(HashMap<String, String> hashMap) {
        this.b = hashMap;
    }

    public String toString() {
        return "WindRewardInfo{isReward=" + this.f13796a + ", options=" + this.b + '}';
    }

    public WindRewardInfo(boolean z, HashMap<String, String> hashMap) {
        this.f13796a = z;
        this.b = hashMap;
    }
}
