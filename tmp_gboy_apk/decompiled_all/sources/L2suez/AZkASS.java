package L2suez;

import com.fl.saas.common.crash.CrashHandler;
import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.getName().toLowerCase(Locale.ROOT).endsWith(CrashHandler.FILE_NAME_SUFFIX);
    }
}
