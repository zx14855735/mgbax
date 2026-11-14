package com.game.boy.viewUi;

import ADYaiT.A5SV6n;
import AZkASS.AMqCpz;
import AaHO0E.CmUvjW;
import Mm8v1u.BIYEnU;
import Mm8v1u.BJ7GGh;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import com.game.boy.R$styleable;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Material3AutoCompleteTextView extends MaterialAutoCompleteTextView {

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final LinkedHashMap f11184BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final LinkedHashMap f11185BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public String f11186BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public String f11187BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public String f11188BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f11189BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public ArrayAdapter f11190BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public BJ7GGh f11191BniPrB;

    public Material3AutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11184BIYEnU = new LinkedHashMap();
        this.f11185BJ7GGh = new LinkedHashMap();
        this.f11186BNL6CD = "";
        this.f11187BPw6Q8 = "";
        this.f11188BTvldC = "";
        this.f11189BV3sI0 = false;
        try {
            setKeyListener(null);
        } catch (Throwable unused) {
        }
        try {
            setThreshold(0);
        } catch (Throwable unused2) {
        }
        try {
            setOnClickListener(new A5SV6n(12, this));
        } catch (Throwable unused3) {
        }
        try {
            setOnItemClickListener(new CmUvjW(2, this));
        } catch (Throwable unused4) {
        }
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f10883A5SV6n);
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
            CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(3);
            String string = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
            try {
                post(new AMqCpz(this, string, textArray, textArray2, 2));
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
        }
    }

    public final void ADYaiT(String str, String str2) {
        LinkedHashMap linkedHashMap = this.f11184BIYEnU;
        linkedHashMap.put(str, str2);
        this.f11185BJ7GGh.put(str2, str);
        if (this.f11190BmvVmW == null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.simple_dropdown_item_1line, new ArrayList());
            this.f11190BmvVmW = arrayAdapter;
            setAdapter(arrayAdapter);
        }
        this.f11190BmvVmW.clear();
        this.f11190BmvVmW.addAll(linkedHashMap.keySet());
        this.f11190BmvVmW.notifyDataSetChanged();
        if (this.f11189BV3sI0 && this.f11187BPw6Q8.isEmpty()) {
            setSelectedValue(this.f11188BTvldC);
        }
    }

    public final void AMqCpz(String str, boolean z) {
        BJ7GGh bJ7GGh;
        String str2 = (String) this.f11185BJ7GGh.get(str);
        if (str2 == null) {
            return;
        }
        this.f11187BPw6Q8 = str;
        this.f11186BNL6CD = str2;
        setText((CharSequence) str2, false);
        if (!z || (bJ7GGh = this.f11191BniPrB) == null) {
            return;
        }
        bJ7GGh.A2egSU(str);
    }

    public String getDefaultValue() {
        return this.f11188BTvldC;
    }

    public int getOptionCount() {
        return this.f11184BIYEnU.size();
    }

    public String getSelectedDisplayText() {
        return this.f11186BNL6CD;
    }

    public String getSelectedValue() {
        return this.f11187BPw6Q8;
    }

    @Override // com.google.android.material.textfield.MaterialAutoCompleteTextView, android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new LLYwnm.AMqCpz(17, this));
    }

    public void setDefaultDisplayText(String str) {
        String str2 = (String) this.f11184BIYEnU.get(str);
        if (str2 != null) {
            setDefaultValue(str2);
        }
    }

    public void setDefaultValue(String str) {
        this.f11188BTvldC = str;
        this.f11189BV3sI0 = true;
        if (this.f11184BIYEnU.isEmpty()) {
            return;
        }
        setSelectedValue(str);
    }

    @Deprecated
    public void setOnSyncModeChangeListener(BIYEnU bIYEnU) {
    }

    public void setOnValueSelectedListener(BJ7GGh bJ7GGh) {
        this.f11191BniPrB = bJ7GGh;
    }

    public void setSelectedValue(String str) {
        AMqCpz(str, false);
    }

    public void setSelectedValueByDisplay(String str) {
        String str2 = (String) this.f11184BIYEnU.get(str);
        if (str2 != null) {
            AMqCpz(str2, true);
        }
    }

    @Override // com.google.android.material.textfield.MaterialAutoCompleteTextView, android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (getWindowToken() == null) {
            return;
        }
        Context context = getContext();
        int i = 0;
        while (context instanceof ContextWrapper) {
            int i2 = i + 1;
            if (i < 10) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.isFinishing() || activity.isDestroyed()) {
                        return;
                    }
                } else {
                    Context baseContext = ((ContextWrapper) context).getBaseContext();
                    if (baseContext != null && baseContext != context) {
                        context = baseContext;
                        i = i2;
                    }
                }
            }
        }
        try {
            super.showDropDown();
        } catch (Throwable unused) {
        }
    }
}
