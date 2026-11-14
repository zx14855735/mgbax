package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.Callback;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IBaseHorizontalLiveListView {
    void refresh();

    View self();

    void setEmptyListener(Callback<Boolean> callback);

    void setErrorListener(Callback<Boolean> callback);

    void setRoomCountListener(Callback<Integer> callback);
}
