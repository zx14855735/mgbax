package K7mCWO;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str != null && str.endsWith(".npth");
    }
}
