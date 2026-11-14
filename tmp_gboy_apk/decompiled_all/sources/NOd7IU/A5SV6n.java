package NOd7IU;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.C;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f5859A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f5860A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5SV6n(ADYaiT aDYaiT, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f5859A2egSU = aDYaiT;
        this.f5860A4TApA = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        ADYaiT aDYaiT = this.f5859A2egSU;
        Context context = this.f5860A4TApA;
        int A2egSU2 = aDYaiT.A2egSU(context);
        if (aDYaiT.A4TApA(A2egSU2)) {
            Intent ADYaiT2 = aDYaiT.ADYaiT(context, A2egSU2, "n");
            aDYaiT.AMqCpz(context, A2egSU2, ADYaiT2 == null ? null : PendingIntent.getActivity(context, 0, ADYaiT2, C.ENCODING_PCM_MU_LAW));
        }
    }
}
