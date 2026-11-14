package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class pl extends xj {
    public pl(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str) {
        super(context, xjVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        String w = this.hf.w("s");
        String xj = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("ag"), w);
        String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("ah"), w);
        String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("ai"), w);
        String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("aj"), w);
        Intent intent = new Intent();
        intent.putExtra(xj, this.w);
        intent.putExtra(xj2, "*/*");
        intent.putExtra(xj3, true);
        intent.setAction(xj4);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        return intent;
    }
}
