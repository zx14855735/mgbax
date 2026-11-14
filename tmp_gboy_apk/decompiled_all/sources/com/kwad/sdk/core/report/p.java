package com.kwad.sdk.core.report;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class p extends c {
    public static int NT = 1;
    private static String aMB = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(Context context, int i) {
        super(context, "ksadrep.db", i, aMB);
    }
}
