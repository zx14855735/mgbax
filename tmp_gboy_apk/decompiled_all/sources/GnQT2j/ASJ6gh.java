package GnQT2j;

import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3105AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AYUAbz f3106AlLFFp;

    public /* synthetic */ ASJ6gh(AYUAbz aYUAbz, int i) {
        this.f3105AcNBzu = i;
        this.f3106AlLFFp = aYUAbz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3105AcNBzu) {
            case 0:
                Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
                AYUAbz aYUAbz = this.f3106AlLFFp;
                aYUAbz.f3107AcNBzu.f3127ADYaiT = aYUAbz.f3110AzWtSf;
                Message message = new Message();
                message.what = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT;
                AZkASS aZkASS = aYUAbz.f3107AcNBzu;
                message.arg1 = aZkASS.f3126A5SV6n;
                message.arg2 = aZkASS.f3127ADYaiT;
                aYUAbz.f3115B7CMnp.sendMessage(message);
                break;
            default:
                Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
                AYUAbz aYUAbz2 = this.f3106AlLFFp;
                aYUAbz2.f3107AcNBzu.getClass();
                A2egSU a2egSU = aYUAbz2.f3109AmA8tU;
                SQLiteDatabase sQLiteDatabase = aYUAbz2.f3108AlLFFp;
                AZkASS aZkASS2 = aYUAbz2.f3107AcNBzu;
                a2egSU.getClass();
                A2egSU.A4TApA(sQLiteDatabase, aZkASS2);
                break;
        }
    }
}
