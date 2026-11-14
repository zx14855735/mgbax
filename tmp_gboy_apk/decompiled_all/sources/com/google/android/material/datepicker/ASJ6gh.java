package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ASJ6gh extends BaseAdapter {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int f11585ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Calendar f11586A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f11587A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f11588A5SV6n;

    static {
        f11585ADYaiT = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
        NlxcL();
    }

    public ASJ6gh() {
        Calendar A5SV6n2 = BTvldC.A5SV6n(null);
        this.f11586A2egSU = A5SV6n2;
        this.f11587A4TApA = A5SV6n2.getMaximum(7);
        this.f11588A5SV6n = A5SV6n2.getFirstDayOfWeek();
    }

    private static /* synthetic */ void NlxcL() {
        char[] charArray = "µ¹»ø±·»³ø´¹¯ø¥¾³ººø\u009c¸¿\u0094¤¿²±³".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 214);
        }
        String str = new String(charArray);
        char[] charArray2 = "µº¿¸¿¢".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 214);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11587A4TApA;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i2 = this.f11587A4TApA;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.f11588A5SV6n;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131493237, viewGroup, false);
        }
        int i2 = i + this.f11588A5SV6n;
        int i3 = this.f11587A4TApA;
        if (i2 > i3) {
            i2 -= i3;
        }
        Calendar calendar = this.f11586A2egSU;
        calendar.set(7, i2);
        textView.setText(calendar.getDisplayName(7, f11585ADYaiT, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(2131886576), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public ASJ6gh(int i) {
        Calendar A5SV6n2 = BTvldC.A5SV6n(null);
        this.f11586A2egSU = A5SV6n2;
        this.f11587A4TApA = A5SV6n2.getMaximum(7);
        this.f11588A5SV6n = i;
    }
}
