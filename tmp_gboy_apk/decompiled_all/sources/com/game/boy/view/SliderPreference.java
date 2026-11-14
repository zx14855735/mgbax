package com.game.boy.view;

import ADYaiT.DUi7mC;
import DRlcZ9.BV3sI0;
import MlRYy2.A4TApA;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.google.android.material.slider.Slider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SliderPreference extends SeekBarPreference {

    /* renamed from: DcUJf1, reason: collision with root package name */
    public DUi7mC f11134DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f11135DdagTj;
    public long Ddcejp;

    public SliderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11135DdagTj = false;
        this.Ddcejp = 0L;
        this.f9107CikNvS = 2131493297;
        int i = this.f9138D9tr6l;
        if (i > 0) {
            int i2 = this.f9136D8MqeW;
            int i3 = this.f9137D8cQ8b;
            if (i > 0) {
                int i4 = i3 - i2;
                if (i4 % i != 0) {
                    throw new IllegalArgumentException(A2egSU.AaHO0E(i4, i, "StepSize must be a factor of (max - min). Current range: ", ", stepSize: "));
                }
            }
        }
    }

    @Override // androidx.preference.SeekBarPreference, androidx.preference.Preference
    public final void AlLFFp(BV3sI0 bV3sI0) {
        DUi7mC dUi7mC;
        Slider slider;
        float f;
        super.AlLFFp(bV3sI0);
        if (this.f11134DcUJf1 == null) {
            DUi7mC dUi7mC2 = new DUi7mC(20);
            this.f11134DcUJf1 = dUi7mC2;
            dUi7mC2.f241AzWtSf = bV3sI0.A2egSU(2131297903);
            this.f11134DcUJf1.f239AlLFFp = (Slider) bV3sI0.A2egSU(2131297994);
            this.f11134DcUJf1.f240AmA8tU = (TextView) bV3sI0.A2egSU(2131297904);
            View view = (View) this.f11134DcUJf1.f241AzWtSf;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        if (!this.f11135DdagTj && (dUi7mC = this.f11134DcUJf1) != null && (slider = (Slider) dUi7mC.f239AlLFFp) != null) {
            int i = this.f9136D8MqeW;
            int i2 = this.f9137D8cQ8b;
            int i3 = this.f9135D6yqiO;
            slider.setValueFrom(i);
            ((Slider) this.f11134DcUJf1.f239AlLFFp).setValueTo(i2);
            ((Slider) this.f11134DcUJf1.f239AlLFFp).setValue(i3);
            int i4 = this.f9138D9tr6l;
            if (i4 <= 0) {
                f = 0.0f;
            } else {
                int i5 = i2 - i;
                if (i5 % i4 == 0) {
                    f = i4;
                } else {
                    while (i4 != 0) {
                        int i6 = i5 % i4;
                        i5 = i4;
                        i4 = i6;
                    }
                    f = i5;
                }
            }
            ((Slider) this.f11134DcUJf1.f239AlLFFp).setStepSize(f);
            ((Slider) this.f11134DcUJf1.f239AlLFFp).f7193BIYEnU.add(new A4TApA(this));
            this.f11135DdagTj = true;
        }
        BpkvW3(this.f9135D6yqiO);
    }

    @Override // androidx.preference.Preference
    public final void AzWtSf() {
        DUi7mC dUi7mC = this.f11134DcUJf1;
        if (dUi7mC != null) {
            Slider slider = (Slider) dUi7mC.f239AlLFFp;
            if (slider != null) {
                slider.f7193BIYEnU.clear();
            }
            this.f11134DcUJf1 = null;
        }
        this.f11135DdagTj = false;
        super.AzWtSf();
    }

    public final void BpkvW3(int i) {
        if (SystemClock.uptimeMillis() - this.Ddcejp < 100) {
            return;
        }
        this.Ddcejp = SystemClock.uptimeMillis();
        DUi7mC dUi7mC = this.f11134DcUJf1;
        if (dUi7mC == null || ((TextView) dUi7mC.f240AmA8tU) == null) {
            return;
        }
        String valueOf = String.valueOf(i);
        if (valueOf.equals(((TextView) this.f11134DcUJf1.f240AmA8tU).getText().toString())) {
            return;
        }
        ((TextView) this.f11134DcUJf1.f240AmA8tU).setText(valueOf);
    }
}
