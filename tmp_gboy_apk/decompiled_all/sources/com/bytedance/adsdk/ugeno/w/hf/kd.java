package com.bytedance.adsdk.ugeno.w.hf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.y.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private zg c;
    private String d;
    private zg f;
    private xj g;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10084pl;
    private Context tf;
    private float xj = Float.MIN_VALUE;
    private float hf = Float.MIN_VALUE;
    private int w = 0;
    private int u = Integer.MAX_VALUE;
    private int kd = Integer.MAX_VALUE;
    private AtomicBoolean y = new AtomicBoolean(true);

    public kd(Context context, zg zgVar, boolean z, boolean z2) {
        this.tf = context;
        this.c = zgVar;
        this.p = z;
        this.f10084pl = z2;
        w();
    }

    private void w() {
        if (this.f10084pl) {
            this.g = new xj();
        }
        zg zgVar = this.c;
        if (zgVar == null) {
            return;
        }
        this.w = zgVar.w().optInt("slideThreshold");
        this.d = this.c.w().optString("slideDirection");
        this.u = this.c.w().optInt("frequency", Integer.MAX_VALUE);
        this.kd = this.c.w().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.y.get();
    }

    public void hf() {
        this.xj = Float.MIN_VALUE;
        this.hf = Float.MIN_VALUE;
    }

    public void xj() {
        if (this.kd == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.w.hf.kd.1
            @Override // java.lang.Runnable
            public void run() {
                kd.this.y.set(false);
            }
        }, this.kd);
    }

    public boolean xj(yo yoVar, com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent, boolean z) {
        xj xjVar = this.g;
        if (xjVar != null) {
            if (xjVar.xj(motionEvent)) {
                return false;
            }
            this.g.xj(wVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    if (this.xj == Float.MIN_VALUE || this.hf == Float.MIN_VALUE) {
                        return false;
                    }
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.p && Math.abs(x - this.xj) <= 10.0f && Math.abs(y - this.hf) <= 10.0f && yoVar != null) {
                hf();
                yoVar.xj(this.f, wVar, wVar);
                return true;
            }
            if (this.w == 0 && yoVar != null) {
                hf();
                xj(yoVar, this.c, wVar);
                return true;
            }
            int hf = f.hf(this.tf, x - this.xj);
            int hf2 = f.hf(this.tf, y - this.hf);
            if (TextUtils.equals(this.d, "up")) {
                hf = -hf2;
            } else if (TextUtils.equals(this.d, "down")) {
                hf = hf2;
            } else if (TextUtils.equals(this.d, "left")) {
                hf = -hf;
            } else if (!TextUtils.equals(this.d, "right")) {
                hf = (int) Math.abs(Math.sqrt(Math.pow(hf2, 2.0d) + Math.pow(hf, 2.0d)));
            }
            if (hf < this.w) {
                hf();
                xj(wVar);
                return false;
            }
            if (yoVar != null) {
                hf();
                xj(yoVar, this.c, wVar);
                return true;
            }
            hf();
        } else {
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
        }
        return true;
    }

    public kd(Context context, zg zgVar, zg zgVar2, boolean z, boolean z2) {
        this.tf = context;
        this.c = zgVar;
        this.f = zgVar2;
        this.p = z;
        this.f10084pl = z2;
        w();
    }

    private void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        xj xjVar = this.g;
        if (xjVar != null) {
            xjVar.xj(wVar);
        }
    }

    private void xj(yo yoVar, zg zgVar, com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (this.u <= 0) {
            xj(wVar);
            return;
        }
        if (!this.y.get()) {
            xj(wVar);
            return;
        }
        yoVar.xj(zgVar, wVar, wVar);
        int i = this.u;
        if (i != Integer.MAX_VALUE) {
            this.u = i - 1;
        }
    }
}
