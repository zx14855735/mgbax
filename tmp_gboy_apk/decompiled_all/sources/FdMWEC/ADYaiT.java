package FdMWEC;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2796AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2797AlLFFp;

    public /* synthetic */ ADYaiT(AZkASS aZkASS, int i) {
        this.f2796AcNBzu = i;
        this.f2797AlLFFp = aZkASS;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AZkASS aZkASS = this.f2797AlLFFp;
        switch (this.f2796AcNBzu) {
            case 0:
                TextView textView = aZkASS.f2819FOAO9d;
                if (textView != null) {
                    textView.setText("跳过");
                    return;
                }
                return;
            case 1:
                aZkASS.getClass();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                GnQT2j.AcNBzu.A2egSU().A4TApA(aZkASS.f2824Fmmv0E.getAdm(), new AZOQYO(aZkASS));
                return;
            default:
                Bitmap A2egSU2 = aZkASS.f2841H0qugq.A2egSU(0L);
                if (!aZkASS.f2850HSHyT0) {
                    aZkASS.f2854Hdahpu = A2egSU2;
                    return;
                }
                Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
                try {
                    Bitmap.Config config = A2egSU2.getConfig();
                    Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                    Bitmap copy = config != config2 ? A2egSU2.copy(config2, true) : A2egSU2;
                    Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), config2);
                    RenderScript create = RenderScript.create(A4TApA2);
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, copy);
                    Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(25);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    create.destroy();
                    createFromBitmap.destroy();
                    createFromBitmap2.destroy();
                    create2.destroy();
                    aZkASS.f2854Hdahpu = createBitmap;
                    return;
                } catch (Exception unused) {
                    Bitmap createBitmap2 = Bitmap.createBitmap(A2egSU2.getWidth(), A2egSU2.getHeight(), Bitmap.Config.ARGB_8888);
                    createBitmap2.eraseColor(Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 68, 68, 68));
                    aZkASS.f2854Hdahpu = createBitmap2;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
        }
    }
}
