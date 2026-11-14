package androidx.preference;

import DRlcZ9.BV3sI0;
import DRlcZ9.BmvVmW;
import DRlcZ9.BniPrB;
import DRlcZ9.BpkvW3;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public int f9135D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public int f9136D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f9137D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public int f9138D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f9139DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public SeekBar f9140DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public TextView f9141DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final boolean f9142DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final boolean f9143DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public final boolean f9144DXnQ0V;
    public final BmvVmW DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public final BniPrB f9145DaOi9o;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969825);
        this.DXuj49 = new BmvVmW(this);
        this.f9145DaOi9o = new BniPrB(0, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9132AaHO0E, 2130969825, 0);
        this.f9136D8MqeW = obtainStyledAttributes.getInt(3, 0);
        int i = obtainStyledAttributes.getInt(1, 100);
        int i2 = this.f9136D8MqeW;
        i = i < i2 ? i2 : i;
        if (i != this.f9137D8cQ8b) {
            this.f9137D8cQ8b = i;
            AZOQYO();
        }
        int i3 = obtainStyledAttributes.getInt(4, 0);
        if (i3 != this.f9138D9tr6l) {
            this.f9138D9tr6l = Math.min(this.f9137D8cQ8b - this.f9136D8MqeW, Math.abs(i3));
            AZOQYO();
        }
        this.f9142DUi7mC = obtainStyledAttributes.getBoolean(2, true);
        this.f9143DV2E8K = obtainStyledAttributes.getBoolean(5, false);
        this.f9144DXnQ0V = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void AlLFFp(BV3sI0 bV3sI0) {
        super.AlLFFp(bV3sI0);
        bV3sI0.itemView.setOnKeyListener(this.f9145DaOi9o);
        this.f9140DG07BK = (SeekBar) bV3sI0.A2egSU(2131297903);
        TextView textView = (TextView) bV3sI0.A2egSU(2131297904);
        this.f9141DRlcZ9 = textView;
        if (this.f9143DV2E8K) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f9141DRlcZ9 = null;
        }
        SeekBar seekBar = this.f9140DG07BK;
        if (seekBar == null) {
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.DXuj49);
        this.f9140DG07BK.setMax(this.f9137D8cQ8b - this.f9136D8MqeW);
        int i = this.f9138D9tr6l;
        if (i != 0) {
            this.f9140DG07BK.setKeyProgressIncrement(i);
        } else {
            this.f9138D9tr6l = this.f9140DG07BK.getKeyProgressIncrement();
        }
        this.f9140DG07BK.setProgress(this.f9135D6yqiO - this.f9136D8MqeW);
        int i2 = this.f9135D6yqiO;
        TextView textView2 = this.f9141DRlcZ9;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.f9140DG07BK.setEnabled(AYUAbz());
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(BpkvW3.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        BpkvW3 bpkvW3 = (BpkvW3) parcelable;
        super.B2KMhB(bpkvW3.getSuperState());
        this.f9135D6yqiO = bpkvW3.f2148AcNBzu;
        this.f9136D8MqeW = bpkvW3.f2149AlLFFp;
        this.f9137D8cQ8b = bpkvW3.f2150AmA8tU;
        AZOQYO();
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f9095BmvVmW) {
            return absSavedState;
        }
        BpkvW3 bpkvW3 = new BpkvW3();
        bpkvW3.f2148AcNBzu = this.f9135D6yqiO;
        bpkvW3.f2149AlLFFp = this.f9136D8MqeW;
        bpkvW3.f2150AmA8tU = this.f9137D8cQ8b;
        return bpkvW3;
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        BmvVmW(AMqCpz(((Integer) obj).intValue()), true);
    }

    public final void BmvVmW(int i, boolean z) {
        int i2 = this.f9136D8MqeW;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.f9137D8cQ8b;
        if (i > i3) {
            i = i3;
        }
        if (i != this.f9135D6yqiO) {
            this.f9135D6yqiO = i;
            TextView textView = this.f9141DRlcZ9;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            BChYOn(i);
            if (z) {
                AZOQYO();
            }
        }
    }

    public final void BniPrB(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.f9136D8MqeW;
        if (progress != this.f9135D6yqiO) {
            if (A2egSU(Integer.valueOf(progress))) {
                BmvVmW(progress, false);
                return;
            }
            seekBar.setProgress(this.f9135D6yqiO - this.f9136D8MqeW);
            int i = this.f9135D6yqiO;
            TextView textView = this.f9141DRlcZ9;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
        }
    }
}
