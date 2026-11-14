package com.sigmob.sdk.splash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.utils.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SplashAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static IntentFilter f13668a;
    private e b;

    public SplashAdBroadcastReceiver(e eVar, String str) {
        super(str);
        this.b = eVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f13668a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f13668a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_SPLAH_STOP_TIME);
            f13668a.addAction(IntentActions.ACTION_SPLAH_PLAYFAIL);
            f13668a.addAction(IntentActions.ACTION_SPLAH_SKIP);
            f13668a.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            f13668a.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return f13668a;
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
        if (this.b != null && a(intent)) {
            String action = intent.getAction();
            if (o.a((CharSequence) action)) {
                return;
            }
            action.getClass();
            switch (action) {
                case "action.splash.playFail":
                    this.b.a_();
                    break;
                case "action.splash.play":
                    this.b.k();
                    break;
                case "action.splash.skip":
                    this.b.b_();
                    break;
                case "action.loadpage.show":
                    this.b.a();
                    break;
                case "action.splash.stoptime":
                    this.b.l();
                    break;
                case "action.loadpage.dismiss":
                    this.b.b();
                    break;
            }
        }
    }
}
