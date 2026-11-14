package com.game.boy.viewUi;

import LLYwnm.AMqCpz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.game.boy.R$styleable;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AutoSaveTextInputEditText extends TextInputEditText {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f11142BI9f7h = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final SharedPreferences f11143B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public String f11144B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public AMqCpz f11145BChYOn;

    public AutoSaveTextInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        String str;
        try {
            this.f11143B7CMnp = context.getSharedPreferences("AppPrefs", 0);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10881A2egSU);
                try {
                    String string = obtainStyledAttributes.getString(0);
                    if (string != null && !string.isEmpty()) {
                        this.f11144B9tovu = string;
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
            String str2 = this.f11144B9tovu;
            if (str2 == null || str2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getClass().getSimpleName());
                if (getId() != -1) {
                    try {
                        str = getResources().getResourceEntryName(getId());
                    } catch (Exception unused) {
                        str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                    }
                    sb.append("_");
                    sb.append(str);
                }
                this.f11144B9tovu = sb.toString();
            }
            String string2 = this.f11143B7CMnp.getString(this.f11144B9tovu, "");
            if (!string2.isEmpty()) {
                setText(string2);
            }
            addTextChangedListener(new Mi9UWv.AMqCpz(1, this));
        } catch (Exception unused2) {
        }
    }

    public final void A4TApA() {
        if (this.f11143B7CMnp == null || this.f11144B9tovu == null) {
            return;
        }
        try {
            String obj = getText() != null ? getText().toString() : "";
            SharedPreferences.Editor edit = this.f11143B7CMnp.edit();
            edit.putString(this.f11144B9tovu, obj);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public String getSaveKey() {
        return this.f11144B9tovu;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A4TApA();
        AMqCpz aMqCpz = this.f11145BChYOn;
        if (aMqCpz != null) {
            removeCallbacks(aMqCpz);
            this.f11145BChYOn = null;
        }
    }

    public void setSaveKey(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f11144B9tovu = str;
    }
}
