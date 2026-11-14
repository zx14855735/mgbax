package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {
    private int hf;
    private xj xj;

    public interface xj {
        void xj();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.hf - y) > 100) {
                xj();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.hf = y;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xj(xj xjVar) {
        this.xj = xjVar;
    }

    private void xj() {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj();
        }
    }
}
