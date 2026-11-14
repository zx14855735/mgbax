package L2suez;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B7CMnp {
    public static String A2egSU(String str) {
        int i;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != '\\' || (i = i2 + 1) >= str.length()) {
                sb.append(charAt);
                i2++;
            } else {
                char charAt2 = str.charAt(i);
                if (charAt2 == '\"') {
                    sb.append('\"');
                } else if (charAt2 == '\\') {
                    sb.append('\\');
                } else if (charAt2 == 'b') {
                    sb.append('\b');
                } else if (charAt2 == 'f') {
                    sb.append('\f');
                } else if (charAt2 == 'n') {
                    sb.append('\n');
                } else if (charAt2 == 'r') {
                    sb.append('\r');
                } else if (charAt2 != 't') {
                    if (charAt2 != 'u') {
                        sb.append(charAt);
                    } else if (i2 + 5 < str.length()) {
                        int i3 = i2 + 2;
                        int i4 = i2 + 6;
                        try {
                            sb.append((char) Integer.parseInt(str.substring(i3, i4), 16));
                            i = i4;
                        } catch (NumberFormatException unused) {
                            sb.append(charAt);
                        }
                    } else {
                        sb.append(charAt);
                    }
                    i2 = i;
                } else {
                    sb.append('\t');
                }
                i = i2 + 2;
                i2 = i;
            }
        }
        return sb.toString();
    }
}
