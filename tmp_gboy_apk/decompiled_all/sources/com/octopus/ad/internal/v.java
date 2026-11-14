package com.octopus.ad.internal;

import com.octopus.ad.RewardItem;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class v implements RewardItem {

    /* renamed from: a, reason: collision with root package name */
    private String f12526a;
    private int b;

    public v(String str, int i) {
        this.f12526a = str;
        this.b = i;
    }

    @Override // com.octopus.ad.RewardItem
    public int getAmount() {
        return this.b;
    }

    @Override // com.octopus.ad.RewardItem
    public String getType() {
        return this.f12526a;
    }
}
