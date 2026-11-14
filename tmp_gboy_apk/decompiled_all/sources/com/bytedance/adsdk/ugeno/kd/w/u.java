package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends hf {
    private int am;
    private String e;
    private int g;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10075pl;
    private int qt;
    private AtomicBoolean zg;

    public u(Context context) {
        super(context);
        this.g = 0;
        this.am = Integer.MAX_VALUE;
        this.qt = Integer.MAX_VALUE;
        this.zg = new AtomicBoolean(true);
        this.e = "up";
    }

    private boolean hf(com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (this.am <= 0 || !this.zg.get()) {
            return false;
        }
        this.xj.xj(wVar, this.y, this.w.hf());
        int i = this.am;
        if (i != Integer.MAX_VALUE) {
            this.am = i - 1;
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.kd;
        if (map != null) {
            this.e = TextUtils.isEmpty(map.get("direction")) ? "all" : this.kd.get("direction");
            this.g = com.bytedance.adsdk.ugeno.y.w.xj(this.kd.get("distance"), 0);
            if (this.am == Integer.MAX_VALUE) {
                this.am = com.bytedance.adsdk.ugeno.y.w.xj(this.kd.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.qt == Integer.MAX_VALUE) {
                this.qt = com.bytedance.adsdk.ugeno.y.w.xj(this.kd.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.zg.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        xj();
        return xj(this.hf, motionEvent);
    }

    private void xj() {
        if (this.qt == Integer.MAX_VALUE || this.hf == null || System.currentTimeMillis() - this.hf.ra() < this.qt) {
            return;
        }
        this.zg.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        char c;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = motionEvent.getX();
            this.f10075pl = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.g == 0 && this.xj != null) {
                return hf(wVar);
            }
            int hf = com.bytedance.adsdk.ugeno.y.f.hf(this.tf, x - this.p);
            int hf2 = com.bytedance.adsdk.ugeno.y.f.hf(this.tf, y - this.f10075pl);
            String str = this.e;
            switch (str.hashCode()) {
                case 3739:
                    if (str.equals("up")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 96673:
                    if (str.equals("all")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                hf = -hf2;
            } else if (c == 1) {
                hf = hf2;
            } else if (c == 2) {
                hf = -hf;
            } else if (c != 3) {
                hf = (int) Math.abs(Math.sqrt(Math.pow(hf2, 2.0d) + Math.pow(hf, 2.0d)));
            }
            if (hf < this.g) {
                return false;
            }
            if (this.xj != null) {
                this.p = 0.0f;
                this.f10075pl = 0.0f;
                return hf(wVar);
            }
        }
        return true;
    }
}
