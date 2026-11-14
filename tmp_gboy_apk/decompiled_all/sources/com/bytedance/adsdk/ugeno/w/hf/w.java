package com.bytedance.adsdk.ugeno.w.hf;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private float hf;
    private boolean kd;
    private Context u;
    private zg w;
    private float xj;
    private final int y;

    public w(Context context, zg zgVar) {
        this.u = context;
        this.w = zgVar;
        this.y = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean xj(yo yoVar, com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.xj) >= this.y || Math.abs(y - this.hf) >= this.y) {
                    this.kd = true;
                }
            } else if (action == 3) {
                this.kd = false;
            }
        } else {
            if (this.kd) {
                this.kd = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.xj) >= this.y || Math.abs(y2 - this.hf) >= this.y) {
                this.kd = false;
            } else if (yoVar != null) {
                yoVar.xj(this.w, wVar, wVar);
                return true;
            }
        }
        return true;
    }
}
