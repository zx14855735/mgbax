package com.kwad.sdk.mobileid;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    private String aYh;
    private String errorReason;
    private boolean success;

    public d(boolean z, String str) {
        this.success = z;
        this.errorReason = str;
    }

    public final String Po() {
        return this.errorReason;
    }

    public final String Pp() {
        return this.aYh;
    }

    public final void gD(String str) {
        this.aYh = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UaidErrorReason{success=");
        sb.append(this.success);
        sb.append(", errorReason='");
        sb.append(this.errorReason);
        sb.append("', extraErrorMsg='");
        return CtFAbx.B25kr6(sb, this.aYh, "'}");
    }
}
