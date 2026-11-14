package com.game.boy.activity;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SaveSlotsActivity extends A5SV6n {
    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("saveMode", false);
        String stringExtra = intent.getStringExtra("romName");
        if (stringExtra.equals("login")) {
            new MOpbMP.ARc23Z().show(getSupportFragmentManager(), "AuthBottomSheetDialogFragment");
            return;
        }
        MOpbMP.CTkVKb cTkVKb = new MOpbMP.CTkVKb();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("saveMode", booleanExtra);
        bundle2.putString("romName", stringExtra);
        cTkVKb.setArguments(bundle2);
        cTkVKb.show(getSupportFragmentManager(), "SaveSlotsFragment");
    }
}
