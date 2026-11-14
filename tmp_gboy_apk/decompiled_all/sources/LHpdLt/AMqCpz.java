package LHpdLt;

import ADYaiT.D8MqeW;
import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends OrientationEventListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4464A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f4465A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AMqCpz(Object obj, Context context, int i) {
        super(context);
        this.f4464A2egSU = i;
        this.f4465A4TApA = obj;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        ADYaiT.AmA8tU amA8tU;
        switch (this.f4464A2egSU) {
            case 0:
                AZOQYO azoqyo = (AZOQYO) this.f4465A4TApA;
                azoqyo.B25kr6();
                View view = azoqyo.AMqCpz;
                if (view != null) {
                    view.post(new D8MqeW(29, this));
                    break;
                }
                break;
            default:
                if (i != -1) {
                    int i2 = (i >= 315 || i < 45) ? 0 : (i < 45 || i >= 135) ? (i < 135 || i >= 225) ? MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME : 180 : 90;
                    Mi9UWv.ASJ6gh aSJ6gh = (Mi9UWv.ASJ6gh) this.f4465A4TApA;
                    int i3 = aSJ6gh.f5417BV3sI0;
                    if (i3 != -1) {
                        if (i2 != i3) {
                            aSJ6gh.f5417BV3sI0 = i2;
                            ADYaiT.AmA8tU amA8tU2 = aSJ6gh.f5408B7CMnp;
                            if (amA8tU2 != null && amA8tU2.isShowing() && (amA8tU = aSJ6gh.f5408B7CMnp) != null && amA8tU.isShowing()) {
                                aSJ6gh.f5408B7CMnp.dismiss();
                                break;
                            }
                        }
                    } else {
                        aSJ6gh.f5417BV3sI0 = i2;
                        break;
                    }
                }
                break;
        }
    }
}
