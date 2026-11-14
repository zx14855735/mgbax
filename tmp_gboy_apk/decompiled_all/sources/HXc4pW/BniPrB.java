package HXc4pW;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB implements Handler.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3646AcNBzu;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f3646AcNBzu) {
            case 0:
                if (message.what != 1) {
                    return false;
                }
                ((BTvldC) message.obj).A2egSU();
                return true;
            default:
                int i = message.what;
                if (i == 0) {
                    message.obj.getClass();
                    throw new ClassCastException();
                }
                if (i != 1) {
                    return false;
                }
                message.obj.getClass();
                throw new ClassCastException();
        }
    }
}
