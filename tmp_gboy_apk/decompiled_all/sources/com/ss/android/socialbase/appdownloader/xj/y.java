package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y extends xj {
    public y(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
