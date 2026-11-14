package RmWSka;

import ADYaiT.CtFAbx;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A2egSU implements A4TApA {
    public final void A2egSU(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException(CtFAbx.AYUAbz(file, "not a readable directory: "));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                A2egSU(file2);
            }
            if (!file2.delete()) {
                throw new IOException(CtFAbx.AYUAbz(file2, "failed to delete "));
            }
        }
    }

    public final void A4TApA(File file, File file2) {
        delete(file2);
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("failed to rename " + file + " to " + file2);
    }

    @Override // RmWSka.A4TApA
    public void delete(File file) {
        if (!file.delete() && file.exists()) {
            throw new IOException(CtFAbx.AYUAbz(file, "failed to delete "));
        }
    }
}
