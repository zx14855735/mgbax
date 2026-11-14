package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.sigmob.sdk.base.mta.PointCategory;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String alj;
    public int errorCode;
    public String errorReason;
    public int qy;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.alj);
    }

    public final boolean xa() {
        return TextUtils.equals("start", this.alj);
    }

    public final boolean xb() {
        return TextUtils.equals(PointCategory.END, this.alj);
    }

    public final boolean xc() {
        return TextUtils.equals(PointCategory.PROGRESS, this.alj);
    }

    public final boolean xd() {
        return TextUtils.equals(com.sigmob.sdk.base.common.a.j, this.alj);
    }

    public final boolean xe() {
        return TextUtils.equals("resume", this.alj);
    }

    public final int xf() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
