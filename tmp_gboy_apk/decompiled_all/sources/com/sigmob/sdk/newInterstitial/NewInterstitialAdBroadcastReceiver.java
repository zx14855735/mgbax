package com.sigmob.sdk.newInterstitial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NewInterstitialAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static IntentFilter f13635a;
    private e b;
    private BaseAdUnit c;

    public NewInterstitialAdBroadcastReceiver(BaseAdUnit baseAdUnit, e eVar, String str) {
        super(str);
        this.c = baseAdUnit;
        this.b = eVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f13635a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f13635a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            f13635a.addAction(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            f13635a.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            f13635a.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            f13635a.addAction(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        return f13635a;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.b == null || this.c == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.getClass();
        switch (action) {
            case "action.rewardedvideo.playFail":
                this.b.c(this.c, intent.getStringExtra("error"));
                b(this);
                this.c = null;
                break;
            case "action.rewardedvideo.play":
                this.b.q(this.c);
                break;
            case "action.rewardedvideo.skip":
                this.b.p(this.c);
                break;
            case "action.rewardedvideo.Close":
                this.b.o(this.c);
                b(this);
                this.c = null;
                break;
        }
    }
}
