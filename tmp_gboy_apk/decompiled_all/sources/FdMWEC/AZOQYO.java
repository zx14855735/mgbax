package FdMWEC;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements HFjH17.A5SV6n, GnQT2j.AaHO0E, Fyurov.AZkASS {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2805AcNBzu;

    public /* synthetic */ AZOQYO(AZkASS aZkASS) {
        this.f2805AcNBzu = aZkASS;
    }

    @Override // Fyurov.AZkASS
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        AZkASS aZkASS = this.f2805AcNBzu;
        AZkASS.DyaChj(aZkASS, aZkASS.f2824Fmmv0E.getPermissionUrl());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.getClass();
    }

    @Override // Fyurov.AZkASS
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        AZkASS aZkASS = this.f2805AcNBzu;
        AZkASS.DyaChj(aZkASS, aZkASS.f2824Fmmv0E.getPrivacyUrl());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.getClass();
    }

    @Override // Fyurov.AZkASS
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        AZkASS aZkASS = this.f2805AcNBzu;
        AZkASS.DyaChj(aZkASS, aZkASS.f2824Fmmv0E.getAppIntro());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        aZkASS.getClass();
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        AZkASS aZkASS = this.f2805AcNBzu;
        aZkASS.f3199B7CMnp = bitmap;
        aZkASS.f2822FdMWEC = bitmap;
        if (aZkASS.f2850HSHyT0) {
            Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
            Bitmap bitmap2 = aZkASS.f2822FdMWEC;
            try {
                Bitmap.Config config = bitmap2.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                Bitmap copy = config != config2 ? bitmap2.copy(config2, true) : bitmap2;
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
                aZkASS.f2823Ff5QvW = createBitmap;
            } catch (Exception unused) {
                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
                createBitmap2.eraseColor(Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 68, 68, 68));
                aZkASS.f2823Ff5QvW = createBitmap2;
            } catch (Throwable th) {
                throw th;
            }
        } else {
            aZkASS.f2823Ff5QvW = bitmap;
        }
        aZkASS.D9tr6l();
        aZkASS.f2831GIi2tl = System.currentTimeMillis() - aZkASS.f2831GIi2tl;
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    @Override // HFjH17.A5SV6n
    public void a(boolean z) {
        AZkASS aZkASS = this.f2805AcNBzu;
        if (z) {
            aZkASS.CqNSpT(aZkASS.f3187AYUAbz);
        } else {
            aZkASS.CSDoyG(aZkASS.f3187AYUAbz);
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        exc.getMessage();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        AZkASS aZkASS = this.f2805AcNBzu;
        aZkASS.BTvldC("1", "加载image素材失败");
        aZkASS.f2865IQ76hF = 8;
    }
}
