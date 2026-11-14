package androidx.core.app;

import android.media.AudioAttributes;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BTvldC {
    public static AudioAttributes A2egSU(AudioAttributes.Builder builder) {
        return builder.build();
    }

    public static AudioAttributes.Builder A4TApA() {
        return new AudioAttributes.Builder();
    }

    public static AudioAttributes.Builder A5SV6n(AudioAttributes.Builder builder, int i) {
        return builder.setContentType(i);
    }

    public static AudioAttributes.Builder ADYaiT(AudioAttributes.Builder builder, int i) {
        return builder.setLegacyStreamType(i);
    }

    public static AudioAttributes.Builder AMqCpz(AudioAttributes.Builder builder, int i) {
        return builder.setUsage(i);
    }
}
