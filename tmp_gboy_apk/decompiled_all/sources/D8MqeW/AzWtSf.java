package D8MqeW;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ArrayList f2030A2egSU;

    public static AzWtSf A2egSU(Handler handler) {
        AzWtSf azWtSf = new AzWtSf();
        ArrayList arrayList = new ArrayList(3);
        azWtSf.f2030A2egSU = arrayList;
        KDRMvK.A2egSU a2egSU = new KDRMvK.A2egSU();
        a2egSU.f4242AcNBzu = handler;
        arrayList.add(a2egSU);
        return azWtSf;
    }

    public void A4TApA() {
        ArrayList arrayList = this.f2030A2egSU;
        arrayList.size();
        JrXYwF.A5SV6n.f4152ADYaiT.getClass();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KDRMvK.A2egSU a2egSU = (KDRMvK.A2egSU) it.next();
            try {
                a2egSU.f4242AcNBzu.post(a2egSU);
            } catch (Throwable unused) {
            }
        }
    }
}
