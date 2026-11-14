package DRlcZ9;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BmvVmW implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f2145AcNBzu;

    public BmvVmW(SeekBarPreference seekBarPreference) {
        this.f2145AcNBzu = seekBarPreference;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        SeekBarPreference seekBarPreference = this.f2145AcNBzu;
        if (z && (seekBarPreference.f9144DXnQ0V || !seekBarPreference.f9139DAk1zC)) {
            seekBarPreference.BniPrB(seekBar);
            return;
        }
        int i2 = i + seekBarPreference.f9136D8MqeW;
        TextView textView = seekBarPreference.f9141DRlcZ9;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.f2145AcNBzu.f9139DAk1zC = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarPreference seekBarPreference = this.f2145AcNBzu;
        seekBarPreference.f9139DAk1zC = false;
        if (seekBar.getProgress() + seekBarPreference.f9136D8MqeW != seekBarPreference.f9135D6yqiO) {
            seekBarPreference.BniPrB(seekBar);
        }
    }
}
