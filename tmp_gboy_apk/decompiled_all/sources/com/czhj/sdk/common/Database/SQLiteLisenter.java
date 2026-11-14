package com.czhj.sdk.common.Database;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface SQLiteLisenter {
    void onFailed(Error error);

    void onSuccess(List<?> list);
}
