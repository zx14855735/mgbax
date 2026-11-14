package com.game.boy.activity;

import com.game.boy.MyApp;
import io.dcloud.ads.core.v2.reward.DCRewardAdListener;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM implements DCRewardAdListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10910AcNBzu;

    public void A2egSU(M0ztbm.A4TApA a4TApA, boolean z) {
        LLYwnm.AYUAbz aYUAbz = this.f10910AcNBzu.f10998B9tovu;
        if (aYUAbz == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
            MyApp.A2egSU("未连接服务器");
            return;
        }
        if (!z) {
            LLYwnm.AYUAbz aYUAbz2 = this.f10910AcNBzu.f10998B9tovu;
            String str = a4TApA.f4960A5SV6n;
            LHpdLt.AcNBzu acNBzu = new LHpdLt.AcNBzu(1);
            aYUAbz2.getClass();
            HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("action", "reject_invite");
            if (str != null && !str.isEmpty()) {
                BI9f7h2.put("invite_id", str);
            }
            aYUAbz2.ARc23Z(BI9f7h2, "reject_invite", acNBzu);
            return;
        }
        if (a4TApA.f4967AaHO0E == 1) {
            MyApp.A2egSU("此房间《游戏已开始》请更换！");
            return;
        }
        if (a4TApA.f4964AYUAbz != 1) {
            MyApp.A2egSU("此房间《游戏与您不相同》请更换！");
            return;
        }
        Mi9UWv.ASJ6gh.f5401BmvVmW = a4TApA.f4962ARc23Z;
        LLYwnm.AYUAbz aYUAbz3 = this.f10910AcNBzu.f10998B9tovu;
        String str2 = a4TApA.f4960A5SV6n;
        aYUAbz3.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("action", "accept_invite");
        if (str2 != null && !str2.isEmpty()) {
            hashMap.put("invite_id", str2);
        }
        aYUAbz3.ARc23Z(hashMap, "accept_invite", null);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClick() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClose() {
        EmulatorActivity.B3GDIM(this.f10910AcNBzu);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onReward(JSONObject jSONObject) {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShow() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShowError(int i, String str) {
        EmulatorActivity.B3GDIM(this.f10910AcNBzu);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onSkip() {
        EmulatorActivity.B3GDIM(this.f10910AcNBzu);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onVideoPlayEnd() {
        EmulatorActivity.B3GDIM(this.f10910AcNBzu);
    }
}
