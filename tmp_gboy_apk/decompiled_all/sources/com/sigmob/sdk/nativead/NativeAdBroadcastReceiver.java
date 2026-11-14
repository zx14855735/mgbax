package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeAdBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static IntentFilter f13592a;
    private g b;

    public NativeAdBroadcastReceiver(g gVar, String str) {
        super(str);
        this.b = gVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (f13592a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f13592a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW);
            f13592a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            f13592a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
            f13592a.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            f13592a.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return f13592a;
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
            if (TextUtils.isEmpty(action)) {
                return;
            }
            action.getClass();
            switch (action) {
                case "action.native.temple.dismiss":
                    this.b.i();
                    break;
                case "action.native.temple.click":
                    this.b.h();
                    break;
                case "action.native.temple.show":
                    this.b.g();
                    break;
                case "action.loadpage.show":
                    this.b.a();
                    break;
                case "action.loadpage.dismiss":
                    this.b.b();
                    break;
            }
        }
    }
}
