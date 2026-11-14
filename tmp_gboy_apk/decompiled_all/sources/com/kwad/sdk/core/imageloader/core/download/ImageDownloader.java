package com.kwad.sdk.core.imageloader.core.download;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.n;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface ImageDownloader {

    public enum Scheme {
        HTTP(Constants.HTTP),
        HTTPS("https"),
        FILE(n.z),
        CONTENT(IAdInterListener.AdProdType.PRODUCT_CONTENT),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        static {
            rggK();
        }

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = CtFAbx.AcNBzu(str, "://");
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        private static /* synthetic */ void rggK() {
            char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 218);
            }
            String str = new String(charArray);
            char[] charArray2 = "¹¶³´³®".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 218);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public final String wrap(String str) {
            return CtFAbx.B25kr6(new StringBuilder(), this.uriPrefix, str);
        }
    }

    InputStream getStream(String str, Object obj);
}
