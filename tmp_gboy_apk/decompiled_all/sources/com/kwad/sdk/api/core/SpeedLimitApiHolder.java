package com.kwad.sdk.api.core;

import com.kwad.sdk.api.loader.Loader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SpeedLimitApiHolder {
    private static volatile SpeedLimitApi instance;

    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                try {
                    if (instance == null) {
                        instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                    }
                } finally {
                }
            }
        }
        return instance;
    }
}
