package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SensorEntity;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.aw;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class x extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13619a = 100;
    public static final int b = 70;
    public static final int c = 30;
    public static final int d = 12;
    private static com.sigmob.sdk.base.views.v n;
    private static am.a o;
    private BaseAdUnit e;
    private final int f;
    private com.sigmob.sdk.base.views.v g;
    private TextView h;
    private am.a i;
    private boolean j;
    private ClickCommon k;
    private d l;
    private boolean m;
    private final int p;
    private final int q;
    private final int r;
    private boolean s;
    private Boolean t;
    private String title;
    private final int u;
    private final int v;

    /* renamed from: com.sigmob.sdk.nativead.x$1, reason: invalid class name */
    public class AnonymousClass1 implements am.b {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            x.this.k.sld = "5";
            x.this.i();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || x.this.j) {
                return;
            }
            x.this.j = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                x.this.k.turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                x.this.k.turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                x.this.k.turn_z = String.valueOf(number3.intValue());
            }
            x.this.k.turn_time = String.valueOf(number4);
            x.this.g.postDelayed(new ARc23Z(1, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.x$2, reason: invalid class name */
    public class AnonymousClass2 implements am.b {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (x.this.j) {
                return;
            }
            x.this.k.sld = "2";
            x.this.i();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null && x.this.k != null) {
                x.this.k.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && x.this.k != null) {
                x.this.k.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && x.this.k != null) {
                x.this.k.z_max_acc = String.valueOf(number3.intValue());
            }
            x.this.g.postDelayed(new ARc23Z(2, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.x$3, reason: invalid class name */
    public class AnonymousClass3 implements am.b {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            x.this.k.sld = "5";
            x.this.i();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (x.this.g instanceof com.sigmob.sdk.base.views.am) {
                ((com.sigmob.sdk.base.views.am) x.this.g).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || x.this.j) {
                return;
            }
            x.this.j = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                x.this.k.turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                x.this.k.turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                x.this.k.turn_z = String.valueOf(number3.intValue());
            }
            x.this.k.turn_time = String.valueOf(number4);
            x.this.g.postDelayed(new ARc23Z(3, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.nativead.x$4, reason: invalid class name */
    public class AnonymousClass4 implements am.b {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            x.this.k.sld = "2";
            x.this.i();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (x.this.g instanceof ap) {
                ((ap) x.this.g).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || x.this.j) {
                return;
            }
            x.this.j = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null && x.this.k != null) {
                x.this.k.x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null && x.this.k != null) {
                x.this.k.y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null && x.this.k != null) {
                x.this.k.z_max_acc = String.valueOf(number3.intValue());
            }
            x.this.g.postDelayed(new ARc23Z(4, this), 400L);
        }
    }

    public x(Context context, BaseAdUnit baseAdUnit, int i, int i2) {
        super(context);
        this.j = false;
        this.t = null;
        this.p = Dips.dipsToIntPixels(100.0f, context);
        this.q = Dips.dipsToIntPixels(70.0f, context);
        this.r = Dips.dipsToIntPixels(30.0f, context);
        this.f = Dips.dipsToIntPixels(0.5f, getContext());
        this.u = i;
        this.v = i2;
        this.e = baseAdUnit;
        this.k = baseAdUnit.getClickCommon();
        a((int) baseAdUnit.getWidgetId(0));
    }

    private void d() {
        this.s = true;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void e() {
        this.g = new aw(getContext());
        this.title = "扭动或点击前往";
        am.a aVar = new am.a(getContext(), new AnonymousClass1(), am.c.WRING);
        this.i = aVar;
        aVar.a(SensorEntity.format(this.e));
    }

    private void f() {
        this.g = new com.sigmob.sdk.base.views.ac(getContext());
        this.title = "摇一摇或点击前往";
        am.a aVar = new am.a(getContext(), new AnonymousClass2(), am.c.SHAKE);
        this.i = aVar;
        aVar.a(SensorEntity.format(this.e));
    }

    private void g() {
        this.g = new com.sigmob.sdk.base.views.am(getContext());
        this.title = "前倾或点击前往";
        am.a aVar = new am.a(getContext(), new AnonymousClass3(), am.c.SLOPE);
        this.i = aVar;
        aVar.a(SensorEntity.format(this.e));
    }

    private void h() {
        this.g = new ap(getContext());
        this.title = "晃动或点击前往";
        am.a aVar = new am.a(getContext(), new AnonymousClass4(), am.c.SWING);
        this.i = aVar;
        aVar.a(SensorEntity.format(this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        d dVar = this.l;
        if (dVar == null) {
            return;
        }
        dVar.onAction();
    }

    public void a() {
        if (this.m && this.g.getVisibility() == 0) {
            com.sigmob.sdk.base.views.v vVar = n;
            if (vVar != null && vVar != this.g) {
                vVar.b();
                n = null;
            }
            am.a aVar = o;
            if (aVar != null && aVar != this.i) {
                aVar.b();
                o = null;
            }
            this.j = false;
            if (this.i != null && this.m && com.sigmob.sdk.base.utils.r.b(this)) {
                am.a aVar2 = o;
                am.a aVar3 = this.i;
                if (aVar2 != aVar3) {
                    o = aVar3;
                    aVar3.a();
                }
                com.sigmob.sdk.base.views.v vVar2 = this.g;
                if (vVar2 == null || vVar2 == n || vVar2.getVisibility() != 0) {
                    return;
                }
                com.sigmob.sdk.base.views.v vVar3 = this.g;
                n = vVar3;
                vVar3.a();
            }
        }
    }

    public boolean getCreateWidgetViewResult() {
        return com.sigmob.sdk.base.utils.q.b(this.g);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = false;
        this.s = false;
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        b();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.s) {
            this.s = false;
            int min = Math.min(this.u, this.v);
            com.sigmob.sdk.base.utils.r.a(this.h);
            if (min < this.r) {
                com.sigmob.sdk.base.views.v vVar = this.g;
                if (vVar != null) {
                    vVar.b();
                    this.g.setVisibility(4);
                }
                am.a aVar = this.i;
                if (aVar != null) {
                    aVar.b();
                }
                this.t = Boolean.FALSE;
                return;
            }
            com.sigmob.sdk.base.views.v vVar2 = this.g;
            if (vVar2 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = vVar2.getLayoutParams();
            if (layoutParams != null && layoutParams.width != min) {
                layoutParams.width = min;
                layoutParams.height = min;
                this.g.setLayoutParams(layoutParams);
            }
            Boolean bool = this.t;
            if (bool != null && !bool.booleanValue()) {
                this.g.a();
                this.g.setVisibility(0);
                am.a aVar2 = this.i;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
            if (min < this.p) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) getParent();
            Context context = getContext();
            if (context == null || viewGroup == null || this.h == null) {
                return;
            }
            int measuredHeight = this.g.getMeasuredHeight() + getTop();
            com.sigmob.sdk.base.utils.r.a(this.h);
            int drawableId = ResourceUtil.getDrawableId(context, "sig_layout_background_radius");
            if (drawableId > 0) {
                this.h.setBackgroundResource(drawableId);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.setMargins(0, measuredHeight + this.f, 0, 0);
            viewGroup.addView(this.h, layoutParams2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.s = true;
    }

    public void setMotionActionListener(d dVar) {
        this.l = dVar;
    }

    public void a(int i) {
        switch (i) {
            case 138731:
                h();
                break;
            case 138733:
                g();
                break;
            case 138757:
                f();
                break;
            case 138758:
                e();
                break;
        }
        if (this.g == null) {
            return;
        }
        this.k.widget_id = i;
        RelativeLayout.LayoutParams ASJ6gh2 = J3FDQU.A2egSU.ASJ6gh(-1, -1, 13);
        this.g.setId(ClientMetadata.generateViewId());
        addView(this.g, ASJ6gh2);
        TextView textView = new TextView(getContext());
        this.h = textView;
        textView.setText(this.title);
        this.h.setTextSize(2, 12.0f);
        this.h.setTextColor(-1);
        this.h.setTypeface(Typeface.DEFAULT_BOLD);
        this.h.setId(ClientMetadata.generateViewId());
    }

    public void b() {
        com.sigmob.sdk.base.views.v vVar = this.g;
        if (vVar != null) {
            vVar.b();
        }
        am.a aVar = this.i;
        if (aVar != null) {
            aVar.b();
        }
        com.sigmob.sdk.base.views.v vVar2 = n;
        if (vVar2 != null && vVar2 == this.g) {
            n = null;
        }
        am.a aVar2 = o;
        if (aVar2 == null || aVar2 != this.i) {
            return;
        }
        o = null;
    }

    public void c() {
        com.sigmob.sdk.base.views.v vVar = n;
        if (vVar != null && vVar == this.g) {
            n = null;
        }
        am.a aVar = o;
        if (aVar != null && aVar == this.i) {
            o = null;
        }
        com.sigmob.sdk.base.views.v vVar2 = this.g;
        if (vVar2 != null) {
            vVar2.b();
            com.sigmob.sdk.base.utils.r.a(this.g);
            this.g = null;
        }
        TextView textView = this.h;
        if (textView != null) {
            com.sigmob.sdk.base.utils.r.a(textView);
            this.h = null;
        }
        am.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.c();
            this.i = null;
        }
    }
}
