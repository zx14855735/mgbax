package BPw6Q8;

import ADYaiT.CtFAbx;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f1433A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f1434A4TApA = new HashMap();

    public AZkASS(String str) {
        this.f1433A2egSU = str;
    }

    public static boolean A2egSU(String str, String str2) {
        String access$000 = FileProvider.access$000(str);
        String access$0002 = FileProvider.access$000(str2);
        if (access$000.equals(access$0002)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(access$0002);
        sb.append('/');
        return access$000.startsWith(sb.toString());
    }

    public final File A4TApA(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        File file = (File) this.f1434A4TApA.get(decode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, decode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (A2egSU(canonicalFile.getPath(), file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            throw new IllegalArgumentException(CtFAbx.AYUAbz(file2, "Failed to resolve canonical path for "));
        }
    }
}
