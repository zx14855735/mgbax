package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM extends BaseAdapter {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int f11645ADYaiT = BTvldC.A5SV6n(null).getMaximum(4);
    public static final int AMqCpz = (BTvldC.A5SV6n(null).getMaximum(7) + BTvldC.A5SV6n(null).getMaximum(5)) - 1;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B2KMhB f11646A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ADYaiT f11647A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final A4TApA f11648A5SV6n;

    static {
        fVKc();
    }

    public B3GDIM(B2KMhB b2KMhB, A4TApA a4TApA, ARc23Z aRc23Z) {
        this.f11646A2egSU = b2KMhB;
        this.f11648A5SV6n = a4TApA;
        throw null;
    }

    private static /* synthetic */ void fVKc() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU() {
        int i = this.f11648A5SV6n.f11579B25kr6;
        B2KMhB b2KMhB = this.f11646A2egSU;
        Calendar calendar = b2KMhB.f11638AcNBzu;
        int i2 = calendar.get(7);
        if (i <= 0) {
            i = calendar.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        return i3 < 0 ? i3 + b2KMhB.f11641AzWtSf : i3;
    }

    @Override // android.widget.Adapter
    /* renamed from: A4TApA, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < A2egSU() || i > A5SV6n()) {
            return null;
        }
        int A2egSU2 = (i - A2egSU()) + 1;
        Calendar A2egSU3 = BTvldC.A2egSU(this.f11646A2egSU.f11638AcNBzu);
        A2egSU3.set(5, A2egSU2);
        return Long.valueOf(A2egSU3.getTimeInMillis());
    }

    public final int A5SV6n() {
        return (A2egSU() + this.f11646A2egSU.f11642B25kr6) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return AMqCpz;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.f11646A2egSU.f11641AzWtSf;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.f11647A4TApA == null) {
            this.f11647A4TApA = new ADYaiT(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131493236, viewGroup, false);
        }
        int A2egSU2 = i - A2egSU();
        if (A2egSU2 >= 0) {
            B2KMhB b2KMhB = this.f11646A2egSU;
            if (A2egSU2 < b2KMhB.f11642B25kr6) {
                textView.setTag(b2KMhB);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(A2egSU2 + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                BTvldC.A4TApA().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i) == null) {
            textView.getContext();
            BTvldC.A4TApA().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
