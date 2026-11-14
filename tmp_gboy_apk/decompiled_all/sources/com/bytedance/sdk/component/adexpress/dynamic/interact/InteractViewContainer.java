package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.sigmob.sdk.base.mta.PointType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class InteractViewContainer extends FrameLayout implements f {
    private RippleView c;
    private int d;
    private View.OnTouchListener f;
    private DynamicBaseWidget hf;
    private c kd;
    private com.bytedance.sdk.component.adexpress.dynamic.w.tf p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.hf.g f10179pl;
    private boolean tf;
    private View u;
    private com.bytedance.sdk.component.adexpress.dynamic.w.c w;
    private Context xj;
    private String y;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        super(context);
        this.xj = context;
        this.hf = dynamicBaseWidget;
        this.w = cVar;
        c();
    }

    private void c() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.y = this.w.eu();
        this.d = this.w.yy();
        this.tf = this.w.dq();
        c xj = d.xj(this.xj, this.hf, this.w, this.p, this.f10179pl);
        this.kd = xj;
        if (xj != null) {
            this.u = xj.w();
            if (this.w.tj()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.y, "6")) {
                if (!this.w.qd() || TextUtils.isEmpty(this.w.bl())) {
                    this.c = new RippleView(this.xj, Color.parseColor("#99000000"));
                } else {
                    this.c = new RippleView(this.xj, com.bytedance.sdk.component.adexpress.dynamic.w.c.xj(this.w.bl()));
                }
                FrameLayout frameLayout = new FrameLayout(this.xj);
                frameLayout.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.c.hf();
                    }
                });
            }
            if (xj(this.y) && com.bytedance.sdk.component.adexpress.u.xj()) {
                int parseColor = Color.parseColor("#99000000");
                if (this.w.qd() && !TextUtils.isEmpty(this.w.bl())) {
                    try {
                        parseColor = com.bytedance.sdk.component.adexpress.dynamic.w.c.xj(this.w.bl());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.xj);
                view.setBackgroundColor(parseColor);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.kd.w());
            xj(this.kd.w());
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f != null) {
            setOnClickListener((View.OnClickListener) this.hf.getDynamicClickListener());
            performClick();
            if (this.w.h()) {
                return;
            }
            setVisibility(8);
        }
    }

    private boolean f() {
        return (this.w.dq() || TextUtils.equals("9", this.y) || TextUtils.equals("16", this.y) || TextUtils.equals(PointType.LOAD_READY, this.y) || TextUtils.equals("18", this.y) || TextUtils.equals("20", this.y) || TextUtils.equals("29", this.y) || TextUtils.equals(PointType.SIGMOB_APP, this.y)) ? false : true;
    }

    public void kd() {
        if (this.u != null && TextUtils.equals(this.y, "2")) {
            View view = this.u;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).w();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            c cVar = this.kd;
            if (cVar != null) {
                cVar.hf();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w(e.getMessage());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.xj.w) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void u() {
        c cVar = this.kd;
        if (cVar != null) {
            cVar.hf();
        }
    }

    public void w() {
        c cVar = this.kd;
        if (cVar != null) {
            cVar.xj();
        }
    }

    public void y() {
        if (this.u != null && TextUtils.equals(this.y, "2")) {
            View view = this.u;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).u();
            }
        }
    }

    private boolean xj(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void hf() {
        if (f()) {
            setOnClickListener((View.OnClickListener) this.hf.getDynamicClickListener());
            performClick();
            if (this.w.h()) {
                return;
            }
            setVisibility(8);
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar, com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar, com.bytedance.sdk.component.adexpress.hf.g gVar) {
        super(context);
        this.xj = context;
        this.hf = dynamicBaseWidget;
        this.w = cVar;
        this.p = tfVar;
        this.f10179pl = gVar;
        c();
    }

    private void xj(ViewGroup viewGroup) {
        if (this.u == null) {
            return;
        }
        String str = this.y;
        str.getClass();
        switch (str) {
            case "0":
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.kd(this, this.d);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case "1":
            case "6":
                if (!this.w.qd() || TextUtils.isEmpty(this.w.bl())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.y(this);
                break;
            case "2":
            case "7":
                setBackgroundColor(Color.parseColor("#80000000"));
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.hf(this, this);
                break;
            case "5":
                if (this.w.qd() && !TextUtils.isEmpty(this.w.bl())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.w.c.xj(this.w.bl()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.w(this);
                this.u.setTag(2);
                break;
            case "8":
            case "11":
                this.hf.setClipChildren(false);
                this.hf.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.hf.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.y(this);
                break;
            case "9":
            case "17":
                this.u.setTag(2);
                break;
            case "10":
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.u(this, this.d, this.tf);
                break;
            case "12":
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.w(this);
                this.u.setTag(2);
                break;
            case "13":
            case "24":
                if (this.y.equals("24") && com.bytedance.sdk.component.adexpress.u.xj()) {
                    this.hf.setClipChildren(false);
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.y(this);
                    break;
                } else {
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.kd(this, this.d);
                    break;
                }
            case "14":
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.hf(this, this);
                break;
            case "16":
                View view = this.u;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.u).getShakeLayout().setTag(2);
                }
                this.u.setTag(2);
                break;
            case "18":
                View view2 = this.u;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.u).getWriggleLayout().setTag(2);
                }
                this.u.setTag(2);
                break;
            case "20":
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.xj(this, this.d, viewGroup);
                break;
            case "22":
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.f(this, this.tf);
                    break;
                } else {
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.c(this, this.d, viewGroup);
                    break;
                }
            case "23":
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.y(this);
                    break;
                }
                break;
            case "25":
                if (com.bytedance.sdk.component.adexpress.u.xj()) {
                    this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.f(this, this.tf);
                    break;
                }
                break;
            case "29":
                View view3 = this.u;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.u).getShakeView().setTag(2);
                }
                this.f = new com.bytedance.sdk.component.adexpress.dynamic.interact.xj.kd(this, this.d);
                break;
        }
        View.OnTouchListener onTouchListener = this.f;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (f()) {
            this.u.setTag(2);
            setOnClickListener((View.OnClickListener) this.hf.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.f
    public void xj() {
        if (TextUtils.equals(this.y, "6")) {
            RippleView rippleView = this.c;
            if (rippleView != null) {
                rippleView.w();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.d();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.y, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.d();
                }
            }, 400L);
        } else {
            d();
        }
    }
}
