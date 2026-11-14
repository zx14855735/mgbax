package io.dcloud.api.custom.type.draw;

import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomDrawAd extends UniAdCustomNativeAd {
    public void onVideoPlayEnd() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var instanceof aaaaaaa0.aaaaaaaa) {
            ((aaaaaaa0.aaaaaaaa) aaaaaaa0Var).onVideoPlayEnd();
        }
    }

    public void onVideoPlayError() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var instanceof aaaaaaa0.aaaaaaaa) {
            ((aaaaaaa0.aaaaaaaa) aaaaaaa0Var).aaaaaaa0();
        }
    }

    public void onVideoPlayPause() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var instanceof aaaaaaa0.aaaaaaaa) {
            ((aaaaaaa0.aaaaaaaa) aaaaaaa0Var).aaaaaaav();
        }
    }

    public void onVideoPlayResume() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var instanceof aaaaaaa0.aaaaaaaa) {
            ((aaaaaaa0.aaaaaaaa) aaaaaaa0Var).aaaaaaac();
        }
    }

    public void onVideoPlayStart() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var instanceof aaaaaaa0.aaaaaaaa) {
            ((aaaaaaa0.aaaaaaaa) aaaaaaa0Var).aaaeaaaa();
        }
    }
}
