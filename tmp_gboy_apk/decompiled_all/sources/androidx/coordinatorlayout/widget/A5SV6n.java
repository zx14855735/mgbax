package androidx.coordinatorlayout.widget;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends ViewGroup.MarginLayoutParams {

    /* renamed from: A2egSU, reason: collision with root package name */
    public CoordinatorLayout.A2egSU f8427A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f8428A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f8429A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f8430ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f8431ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f8432ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f8433AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f8434AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f8435AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public View f8436AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public View f8437AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f8438AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f8439AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f8440AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f8441B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Rect f8442B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Object f8443B3GDIM;

    public A5SV6n() {
        super(-2, -2);
        this.f8428A4TApA = false;
        this.f8429A5SV6n = 0;
        this.f8430ADYaiT = 0;
        this.AMqCpz = -1;
        this.f8431ARc23Z = -1;
        this.f8432ASJ6gh = 0;
        this.f8433AYUAbz = 0;
        this.f8442B2KMhB = new Rect();
    }

    public final boolean A2egSU(int i) {
        if (i == 0) {
            return this.f8439AmA8tU;
        }
        if (i != 1) {
            return false;
        }
        return this.f8440AzWtSf;
    }

    public final void A4TApA(CoordinatorLayout.A2egSU a2egSU) {
        CoordinatorLayout.A2egSU a2egSU2 = this.f8427A2egSU;
        if (a2egSU2 != a2egSU) {
            if (a2egSU2 != null) {
                a2egSU2.onDetachedFromLayoutParams();
            }
            this.f8427A2egSU = a2egSU;
            this.f8443B3GDIM = null;
            this.f8428A4TApA = true;
            if (a2egSU != null) {
                a2egSU.onAttachedToLayoutParams(this);
            }
        }
    }

    public A5SV6n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CoordinatorLayout.A2egSU a2egSU;
        this.f8428A4TApA = false;
        this.f8429A5SV6n = 0;
        this.f8430ADYaiT = 0;
        this.AMqCpz = -1;
        this.f8431ARc23Z = -1;
        this.f8432ASJ6gh = 0;
        this.f8433AYUAbz = 0;
        this.f8442B2KMhB = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8426A4TApA);
        this.f8429A5SV6n = obtainStyledAttributes.getInteger(0, 0);
        this.f8431ARc23Z = obtainStyledAttributes.getResourceId(1, -1);
        this.f8430ADYaiT = obtainStyledAttributes.getInteger(2, 0);
        this.AMqCpz = obtainStyledAttributes.getInteger(6, -1);
        this.f8432ASJ6gh = obtainStyledAttributes.getInt(5, 0);
        this.f8433AYUAbz = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f8428A4TApA = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.BpkvW3;
            if (TextUtils.isEmpty(string)) {
                a2egSU = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.BpkvW3;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f8445C4FrIb;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f8444C2rE4F);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    a2egSU = (CoordinatorLayout.A2egSU) constructor.newInstance(context, attributeSet);
                } catch (Exception e) {
                    throw new RuntimeException(CtFAbx.BChYOn("Could not inflate Behavior subclass ", string), e);
                }
            }
            this.f8427A2egSU = a2egSU;
        }
        obtainStyledAttributes.recycle();
        CoordinatorLayout.A2egSU a2egSU2 = this.f8427A2egSU;
        if (a2egSU2 != null) {
            a2egSU2.onAttachedToLayoutParams(this);
        }
    }

    public A5SV6n(A5SV6n a5SV6n) {
        super((ViewGroup.MarginLayoutParams) a5SV6n);
        this.f8428A4TApA = false;
        this.f8429A5SV6n = 0;
        this.f8430ADYaiT = 0;
        this.AMqCpz = -1;
        this.f8431ARc23Z = -1;
        this.f8432ASJ6gh = 0;
        this.f8433AYUAbz = 0;
        this.f8442B2KMhB = new Rect();
    }

    public A5SV6n(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f8428A4TApA = false;
        this.f8429A5SV6n = 0;
        this.f8430ADYaiT = 0;
        this.AMqCpz = -1;
        this.f8431ARc23Z = -1;
        this.f8432ASJ6gh = 0;
        this.f8433AYUAbz = 0;
        this.f8442B2KMhB = new Rect();
    }

    public A5SV6n(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f8428A4TApA = false;
        this.f8429A5SV6n = 0;
        this.f8430ADYaiT = 0;
        this.AMqCpz = -1;
        this.f8431ARc23Z = -1;
        this.f8432ASJ6gh = 0;
        this.f8433AYUAbz = 0;
        this.f8442B2KMhB = new Rect();
    }
}
