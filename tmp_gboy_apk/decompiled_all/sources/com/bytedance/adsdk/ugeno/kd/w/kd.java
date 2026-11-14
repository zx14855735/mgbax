package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kd.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends hf {
    private boolean g;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10074pl;

    public kd(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        return xj(this.hf, (MotionEvent) objArr[0]);
    }

    public boolean xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (Math.abs(rawX - this.p) >= 15.0f || Math.abs(rawY - this.f10074pl) >= 15.0f) {
                        this.g = true;
                    }
                } else if (action == 3) {
                    this.g = false;
                }
            }
            if (this.g) {
                this.g = false;
                this.p = 0.0f;
                this.f10074pl = 0.0f;
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.p) < 15.0f && Math.abs(rawY2 - this.f10074pl) < 15.0f) {
                p pVar = this.xj;
                if (pVar != null) {
                    pVar.xj(wVar, this.y, this.w.hf());
                    this.p = 0.0f;
                    this.f10074pl = 0.0f;
                    return true;
                }
            } else {
                this.g = false;
                return false;
            }
        } else {
            this.p = motionEvent.getRawX();
            this.f10074pl = motionEvent.getRawY();
        }
        return true;
    }
}
