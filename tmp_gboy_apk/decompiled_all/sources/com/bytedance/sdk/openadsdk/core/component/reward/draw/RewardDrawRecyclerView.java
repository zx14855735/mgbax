package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardDrawRecyclerView extends RecyclerView {
    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        pl.u("lfz", motionEvent.toString());
        return false;
    }
}
