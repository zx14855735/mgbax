package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.component.utils.pl;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pbln {
    public static void A2egSU(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                pl.xj(e);
            }
        }
    }
}
