package com.game.boy.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.game.boy.MyApp;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.ads.core.v2.reward.DCRewardAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10915AcNBzu;

    public B9tovu(EmulatorActivity emulatorActivity) {
        this.f10915AcNBzu = emulatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MyApp.A2egSU("正在加载广告中...");
        EmulatorActivity emulatorActivity = this.f10915AcNBzu;
        DCRewardAd dCRewardAd = new DCRewardAd(emulatorActivity);
        dCRewardAd.setRewardAdListener(new OLy1FW.AzWtSf(16, (byte) 0));
        DCloudAdSlot.Builder builder = new DCloudAdSlot.Builder();
        builder.adpid("1595742866");
        SharedPreferences sharedPreferences = emulatorActivity.getSharedPreferences(emulatorActivity.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().apply();
        String string = sharedPreferences.getString("user_token", null);
        if (string != null) {
            builder.userId(string);
        }
        dCRewardAd.load(builder.build(), new I3HV03.A4TApA(this, dCRewardAd, 21, false));
    }
}
