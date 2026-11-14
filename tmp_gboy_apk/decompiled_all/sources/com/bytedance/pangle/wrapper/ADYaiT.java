package com.bytedance.pangle.wrapper;

import android.telephony.CellInfo;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class ADYaiT {
    public static /* bridge */ /* synthetic */ CellInfoNr A4TApA(CellInfo cellInfo) {
        return (CellInfoNr) cellInfo;
    }

    public static /* bridge */ /* synthetic */ CellInfoTdscdma A5SV6n(CellInfo cellInfo) {
        return (CellInfoTdscdma) cellInfo;
    }

    public static /* bridge */ /* synthetic */ boolean B4ZgIw(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoNr;
    }

    public static /* bridge */ /* synthetic */ boolean BChYOn(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoTdscdma;
    }
}
