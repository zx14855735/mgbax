package DRlcZ9;

import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.activity.MainActivity;
import com.game.boy.viewUi.QuoteTextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB implements View.OnKeyListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2146AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2147AlLFFp;

    public /* synthetic */ BniPrB(int i, Object obj) {
        this.f2146AcNBzu = i;
        this.f2147AlLFFp = obj;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        SeekBar seekBar;
        switch (this.f2146AcNBzu) {
            case 0:
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = (SeekBarPreference) this.f2147AlLFFp;
                if ((!seekBarPreference.f9142DUi7mC && (i == 21 || i == 22)) || i == 23 || i == 66 || (seekBar = seekBarPreference.f9140DG07BK) == null) {
                    return false;
                }
                return seekBar.onKeyDown(i, keyEvent);
            case 1:
                if (i != 66 || keyEvent.getAction() != 0 || (keyEvent.getMetaState() & 1) != 0) {
                    return false;
                }
                Mm8v1u.BPw6Q8 bPw6Q8 = ((QuoteTextInputLayout) this.f2147AlLFFp).f11192F508T2;
                if (bPw6Q8 == null) {
                    return true;
                }
                LHpdLt.AZOQYO.A5SV6n((LHpdLt.AZOQYO) ((IQ76hF.AmA8tU) bPw6Q8).f3956AlLFFp);
                return true;
            default:
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                MainActivity mainActivity = (MainActivity) this.f2147AlLFFp;
                if (i == 19) {
                    mainActivity.f11065B3GDIM.requestFocus(33);
                } else {
                    if (i != 20) {
                        return false;
                    }
                    mainActivity.f11065B3GDIM.requestFocus(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                }
                return true;
        }
    }
}
