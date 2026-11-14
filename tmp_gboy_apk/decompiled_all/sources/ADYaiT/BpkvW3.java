package ADYaiT;

import android.os.LocaleList;
import android.view.PointerIcon;
import java.io.File;
import java.nio.charset.Charset;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class BpkvW3 {
    public static /* bridge */ /* synthetic */ LocaleList AMqCpz(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ PointerIcon ASJ6gh(Object obj) {
        return (PointerIcon) obj;
    }

    public static /* bridge */ /* synthetic */ Supplier B2KMhB(Object obj) {
        return (Supplier) obj;
    }

    public static /* synthetic */ ZipFile B3GDIM(File file, Charset charset) {
        return new ZipFile(file, charset);
    }

    public static /* bridge */ /* synthetic */ boolean BNL6CD(Object obj) {
        return obj instanceof Supplier;
    }

    public static /* bridge */ /* synthetic */ boolean BmvVmW(Object obj) {
        return obj instanceof Function;
    }
}
