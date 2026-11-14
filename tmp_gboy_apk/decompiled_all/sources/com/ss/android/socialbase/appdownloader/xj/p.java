package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p extends xj {
    public p(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str) {
        super(context, xjVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.w);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
