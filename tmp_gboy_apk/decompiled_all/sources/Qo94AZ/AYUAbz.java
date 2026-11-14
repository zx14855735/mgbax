package Qo94AZ;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final File f7779A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f7780A4TApA;

    public AYUAbz() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        this.f7779A2egSU = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f7780A4TApA = new ArrayList();
    }

    public final void A2egSU() {
        ArrayList arrayList = this.f7780A4TApA;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((ASJ6gh) ((AzWtSf) it.next())).delete();
            } catch (Exception e) {
                B25kr6.f7818AZkASS.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
        }
        arrayList.clear();
    }
}
