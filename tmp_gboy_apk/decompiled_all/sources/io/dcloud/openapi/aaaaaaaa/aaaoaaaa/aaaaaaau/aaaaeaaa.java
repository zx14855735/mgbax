package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aacaaaaa;
import java.net.ProtocolException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaeaaa {
    public final int aaaaaaa0;
    public final aacaaaaa aaaaaaaa;
    public final String aaaaaaao;

    public aaaaeaaa(aacaaaaa aacaaaaaVar, int i, String str) {
        this.aaaaaaaa = aacaaaaaVar;
        this.aaaaaaa0 = i;
        this.aaaaaaao = str;
    }

    public static aaaaeaaa aaaaaaaa(String str) {
        aacaaaaa aacaaaaaVar;
        int i;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                aacaaaaaVar = aacaaaaa.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                aacaaaaaVar = aacaaaaa.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            aacaaaaaVar = aacaaaaa.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                str2 = str.substring(i + 4);
            }
            return new aaaaeaaa(aacaaaaaVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.aaaaaaaa == aacaaaaa.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.aaaaaaa0);
        if (this.aaaaaaao != null) {
            sb.append(' ');
            sb.append(this.aaaaaaao);
        }
        return sb.toString();
    }
}
