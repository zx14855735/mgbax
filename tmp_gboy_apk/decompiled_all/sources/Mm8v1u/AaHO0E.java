package Mm8v1u;

import android.graphics.drawable.Drawable;
import android.text.Html;
import com.bumptech.glide.RequestBuilder;
import com.game.boy.viewUi.HTMLTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements Html.ImageGetter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ HTMLTextView f5498A2egSU;

    public AaHO0E(HTMLTextView hTMLTextView) {
        this.f5498A2egSU = hTMLTextView;
    }

    @Override // android.text.Html.ImageGetter
    public final Drawable getDrawable(String str) {
        AaHO0E.A4TApA a4TApA = new AaHO0E.A4TApA();
        AYUAbz aYUAbz = new AYUAbz(0);
        aYUAbz.setBounds(0, 0, 100, 100);
        a4TApA.A5SV6n(aYUAbz);
        RequestBuilder AaHO0E2 = com.bumptech.glide.A4TApA.ARc23Z(this.f5498A2egSU.getContext()).AaHO0E(str);
        AaHO0E2.BPw6Q8(new AZkASS(this, a4TApA), null, AaHO0E2, ItGa5w.ARc23Z.f4079A2egSU);
        return a4TApA;
    }
}
