package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import com.kwad.sdk.core.report.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends c {
    private static String aMB = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(Context context, int i) {
        super(context, "ksadBlock.db", i, aMB);
    }
}
