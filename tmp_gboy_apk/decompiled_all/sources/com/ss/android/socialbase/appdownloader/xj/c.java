package com.ss.android.socialbase.appdownloader.xj;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends xj {
    public c(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str) {
        super(context, xjVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        Intent intent = new Intent(CtFAbx.B25kr6(new StringBuilder(), com.ss.android.socialbase.downloader.constants.kd.w, ".filemanager.intent.action.BROWSER_FILE"));
        intent.putExtra("CurrentDir", this.w);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
