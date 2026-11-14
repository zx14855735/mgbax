package com.google.android.gms.common.api;

import NGepWW.EicXu4;
import NOd7IU.A2egSU;
import NOd7IU.ADYaiT;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final /* synthetic */ int f11210AlLFFp = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f11211AcNBzu = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f11211AcNBzu = 0;
            setResult(i2);
            if (booleanExtra) {
                EicXu4 A2egSU2 = EicXu4.A2egSU(this);
                if (i2 == -1) {
                    Handler handler = A2egSU2.f5844B3GDIM;
                    handler.sendMessage(handler.obtainMessage(2));
                } else if (i2 == 0) {
                    A2egSU a2egSU = new A2egSU(13, null);
                    int intExtra = getIntent().getIntExtra("failing_client_id", -1);
                    if (!A2egSU2.A4TApA(a2egSU, intExtra)) {
                        Handler handler2 = A2egSU2.f5844B3GDIM;
                        handler2.sendMessage(handler2.obtainMessage(4, intExtra, 0, a2egSU));
                    }
                }
            }
        } else if (i == 2) {
            this.f11211AcNBzu = 0;
            setResult(i2);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f11211AcNBzu = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11211AcNBzu = bundle.getInt("resolution");
        }
        if (this.f11211AcNBzu == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            finish();
            return;
        }
        if (pendingIntent == null) {
            ADYaiT.f5861A4TApA.ARc23Z(this, num.intValue(), this);
            this.f11211AcNBzu = 1;
        } else {
            try {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f11211AcNBzu = 1;
                } catch (IntentSender.SendIntentException unused) {
                    finish();
                }
            } catch (IntentSender.SendIntentException unused2) {
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f11211AcNBzu);
        super.onSaveInstanceState(bundle);
    }
}
