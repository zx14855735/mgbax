package GnQT2j;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.internal.an;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends Thread {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ String f3093AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f3094AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f3095AmA8tU;

    public ADYaiT(String str, Context context, AMqCpz aMqCpz) {
        this.f3093AcNBzu = str;
        this.f3094AlLFFp = context;
        this.f3095AmA8tU = aMqCpz;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AMqCpz aMqCpz = this.f3095AmA8tU;
        super.run();
        try {
            Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
            String str = this.f3093AcNBzu;
            ((HttpURLConnection) new URL(str).openConnection()).setRequestMethod(an.c);
            Context context = this.f3094AlLFFp;
            ((Activity) context).runOnUiThread(new Dphsd2.AlLFFp(this, str, context, aMqCpz));
        } catch (Exception e) {
            aMqCpz.a(e);
            e.getMessage();
        }
    }
}
