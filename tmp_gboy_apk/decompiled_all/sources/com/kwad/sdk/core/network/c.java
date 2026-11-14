package com.kwad.sdk.core.network;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    public int aIU = -1;
    public Exception aIV;
    public String aIW;
    public int code;

    public final boolean Jr() {
        return this.code == 200;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseResponse{code=");
        sb.append(this.code);
        sb.append(", rawCode=");
        sb.append(this.aIU);
        sb.append(", rawException=");
        sb.append(this.aIV);
        sb.append(", body='");
        return CtFAbx.B25kr6(sb, this.aIW, "'}");
    }
}
