package okhttp3;

import ADYaiT.CtFAbx;
import java.nio.charset.Charset;
import okhttp3.internal.A5SV6n;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, A5SV6n.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        return CtFAbx.BChYOn("Basic ", ByteString.encodeString(str + ":" + str2, charset).base64());
    }
}
