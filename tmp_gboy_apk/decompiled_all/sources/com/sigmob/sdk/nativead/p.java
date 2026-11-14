package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p extends View {

    /* renamed from: a, reason: collision with root package name */
    private ad f13611a;
    private boolean b;
    private boolean c;
    private a d;
    private int e;
    private long f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public p(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z = false;
        if (!a() || !e()) {
            a aVar = this.d;
            if (aVar != null && this.i) {
                aVar.e();
            }
            this.i = false;
            this.f = 0L;
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int a2 = a(viewGroup);
        int width = viewGroup.getWidth() * viewGroup.getHeight();
        boolean z2 = width > 0 && ((float) a2) >= (((float) this.e) / 100.0f) * ((float) width);
        if (a2 > 0) {
            this.i = true;
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.f();
            }
        } else {
            this.i = false;
            this.f = 0L;
            a aVar3 = this.d;
            if (aVar3 != null) {
                aVar3.e();
            }
        }
        if (a2 <= 0) {
            a aVar4 = this.d;
            if (aVar4 == null || !this.i) {
                return;
            }
            aVar4.e();
            return;
        }
        if (!z2 || !this.i) {
            a aVar5 = this.d;
            if (aVar5 != null) {
                aVar5.c();
            }
            a aVar6 = this.d;
            if (aVar6 != null) {
                aVar6.a(false);
            }
            this.f = 0L;
            return;
        }
        if (this.f == 0) {
            this.f = System.currentTimeMillis();
        }
        if (this.f > 0 && System.currentTimeMillis() - this.f >= this.g * 1000) {
            z = true;
        }
        a aVar7 = this.d;
        if (aVar7 != null) {
            aVar7.d();
        }
        a aVar8 = this.d;
        if (aVar8 != null) {
            aVar8.a(z);
        }
    }

    private void c() {
        f();
        this.f13611a = null;
    }

    private void d() {
        ad adVar = this.f13611a;
        if (adVar == null || !adVar.b()) {
            return;
        }
        SigmobLog.d("-----------startTimer----------");
        this.f13611a.removeCallbacksAndMessages(null);
        this.f13611a.a();
        this.f13611a.a(false);
    }

    private boolean e() {
        return this.b && this.h == 0 && this.c;
    }

    private void f() {
        b();
        ad adVar = this.f13611a;
        if (adVar == null || adVar.b()) {
            return;
        }
        SigmobLog.d("-----------stopTimer----------");
        this.f13611a.removeCallbacksAndMessages(null);
        this.f13611a.a(true);
    }

    public int a(View view) {
        Rect rect = new Rect();
        if (!view.isShown() || !view.getGlobalVisibleRect(rect)) {
            return 0;
        }
        return rect.width() * rect.height();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        SigmobLog.d("---------onAttachedToWindow---------");
        d();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        SigmobLog.d("---------onDetachedFromWindow----------");
        f();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        SigmobLog.d("---------onFinishTemporaryDetach-------------");
        d();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        SigmobLog.d("---------onStartTemporaryDetach-----------");
        f();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        SigmobLog.d("---------onVisibilityChanged---------" + i);
        this.j = i;
        if (i == 0) {
            d();
        } else {
            f();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        SigmobLog.d("---------onWindowFocusChanged: hasWindowFocus: " + z);
        this.c = z;
        if (this.i) {
            b();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.h = i;
        SigmobLog.d("---------onWindowVisibilityChanged: visibility: " + i);
        if (i == 0) {
            d();
        } else {
            f();
        }
    }

    public void setAdVisibilityStatusChangeListener(a aVar) {
        this.d = aVar;
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.c = true;
        this.f = 0L;
        this.g = 0;
        this.h = -1;
        this.i = false;
        this.j = -1;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public void a(int i, int i2) {
        this.c = true;
        if (this.f13611a != null) {
            c();
        }
        this.c = true;
        this.e = i;
        this.g = i2;
        this.f13611a = new ad(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.p.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (87108 != message.what || p.this.d == null) {
                    return;
                }
                p.this.b();
                a();
            }
        };
        d();
    }

    public boolean a() {
        return getVisibility() == 0 && this.j == 0 && getParent() != null;
    }
}
