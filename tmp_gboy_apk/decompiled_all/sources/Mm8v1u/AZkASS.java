package Mm8v1u;

import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.viewUi.HTMLTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS extends IlwJBd.A5SV6n {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AaHO0E.A4TApA f5496AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ AaHO0E f5497B25kr6;

    public AZkASS(AaHO0E aaHO0E, AaHO0E.A4TApA a4TApA) {
        this.f5497B25kr6 = aaHO0E;
        this.f5496AzWtSf = a4TApA;
    }

    @Override // IlwJBd.AYUAbz
    public final void ADYaiT(Object obj, IsbtnO.A4TApA a4TApA) {
        Drawable drawable = (Drawable) obj;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 300;
        }
        HTMLTextView hTMLTextView = this.f5497B25kr6.f5498A2egSU;
        int width = (hTMLTextView.getWidth() - hTMLTextView.getPaddingLeft()) - hTMLTextView.getPaddingRight();
        if (width > 0 && intrinsicWidth > width) {
            intrinsicHeight = (int) (intrinsicHeight * (width / intrinsicWidth));
            intrinsicWidth = width;
        }
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        AaHO0E.A4TApA a4TApA2 = this.f5496AzWtSf;
        a4TApA2.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        a4TApA2.A5SV6n(drawable);
        hTMLTextView.post(new AZOQYO(this, 0));
    }

    @Override // IlwJBd.A5SV6n, IlwJBd.AYUAbz
    public final void AMqCpz(Drawable drawable) {
        AYUAbz aYUAbz = new AYUAbz(1);
        aYUAbz.setBounds(0, 0, 100, 100);
        this.f5496AzWtSf.A5SV6n(aYUAbz);
        this.f5497B25kr6.f5498A2egSU.post(new AZOQYO(this, 1));
    }

    @Override // IlwJBd.AYUAbz
    public final void AZOQYO(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, 100, 100);
            this.f5496AzWtSf.A5SV6n(drawable);
        }
    }
}
