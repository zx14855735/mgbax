package com.game.boy.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;

@TargetApi(5)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BluetoothDeviceListActivity extends A5SV6n {
    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("saveMode", false);
        String stringExtra = intent.getStringExtra("romName");
        MOpbMP.AZkASS aZkASS = new MOpbMP.AZkASS();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("saveMode", booleanExtra);
        bundle2.putString("romName", stringExtra);
        aZkASS.setArguments(bundle2);
        aZkASS.show(getSupportFragmentManager(), "SaveSlotsFragment");
    }
}
