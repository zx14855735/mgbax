package com.bytedance.sdk.component.w.hf;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class v {
    private static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> c;
    private final String d;
    private final List<String> f;
    final String hf;
    private final String kd;
    private final String tf;
    final int w;
    final String xj;
    private final String y;

    public static final class xj {
        List<String> c;
        String f;
        String u;
        String xj;
        final List<String> y;
        String hf = "";
        String w = "";
        int kd = -1;

        /* renamed from: com.bytedance.sdk.component.w.hf.v$xj$xj, reason: collision with other inner class name */
        public enum EnumC0122xj {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST;

            static {
                Aoaxa();
            }

            private static /* synthetic */ void Aoaxa() {
                char[] charArray = "ëçå¦ïéåí¦êçñ¦ûàíää¦ÂæáÊúáìïí".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 136);
                }
                String str = new String(charArray);
                char[] charArray2 = "ëäáæáü".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 136);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        }

        public xj() {
            ArrayList arrayList = new ArrayList();
            this.y = arrayList;
            arrayList.add("");
        }

        private boolean c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private boolean y(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public xj hf(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.hf = v.xj(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public xj kd(String str) {
            this.c = str != null ? v.hf(v.xj(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public xj query(String str) {
            this.c = str != null ? v.hf(v.xj(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.xj);
            sb.append("://");
            if (!this.hf.isEmpty() || !this.w.isEmpty()) {
                sb.append(this.hf);
                if (!this.w.isEmpty()) {
                    sb.append(':');
                    sb.append(this.w);
                }
                sb.append('@');
            }
            if (this.u.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.u);
                sb.append(']');
            } else {
                sb.append(this.u);
            }
            int xj = xj();
            if (xj != v.xj(this.xj)) {
                sb.append(':');
                sb.append(xj);
            }
            v.xj(sb, this.y);
            if (this.c != null) {
                sb.append('?');
                v.hf(sb, this.c);
            }
            if (this.f != null) {
                sb.append('#');
                sb.append(this.f);
            }
            return sb.toString();
        }

        public xj u(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String kd = kd(str, 0, str.length());
            if (kd == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.u = kd;
            return this;
        }

        public xj w(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.w = v.xj(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public xj xj(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(Constants.HTTP)) {
                this.xj = Constants.HTTP;
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.xj = "https";
            return this;
        }

        private static int y(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(v.xj(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static String kd(String str, int i, int i2) {
            return com.bytedance.sdk.component.w.hf.xj.w.xj(v.xj(str, i, i2, false));
        }

        public xj hf() {
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                this.y.set(i, v.xj(this.y.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.c;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.c.get(i2);
                    if (str != null) {
                        this.c.set(i2, v.xj(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f;
            if (str2 != null) {
                this.f = v.xj(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public v w() {
            if (this.xj != null) {
                if (this.u != null) {
                    return new v(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void u() {
            if (this.y.remove(r0.size() - 1).isEmpty() && !this.y.isEmpty()) {
                this.y.set(r0.size() - 1, "");
            } else {
                this.y.add("");
            }
        }

        public xj xj(int i) {
            if (i > 0 && i <= 65535) {
                this.kd = i;
                return this;
            }
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "unexpected port: "));
        }

        private static int w(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int u(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public int xj() {
            int i = this.kd;
            return i != -1 ? i : v.xj(this.xj);
        }

        private static int hf(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public EnumC0122xj xj(v vVar, String str) {
            int xj;
            String str2;
            int i;
            String str3;
            String str4 = str;
            int xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(str4, 0, str4.length());
            int hf = com.bytedance.sdk.component.w.hf.xj.w.hf(str4, xj2, str4.length());
            if (hf(str4, xj2, hf) != -1) {
                if (str4.regionMatches(true, xj2, "https:", 0, 6)) {
                    this.xj = "https";
                    xj2 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, xj2, "http:", 0, 5)) {
                        this.xj = Constants.HTTP;
                        xj2 += 5;
                    } else {
                        return EnumC0122xj.UNSUPPORTED_SCHEME;
                    }
                }
            } else if (vVar != null) {
                this.xj = vVar.xj;
            } else {
                return EnumC0122xj.MISSING_SCHEME;
            }
            int w = w(str4, xj2, hf);
            char c = '#';
            if (w < 2 && vVar != null && vVar.xj.equals(this.xj)) {
                this.hf = vVar.kd();
                this.w = vVar.y();
                this.u = vVar.hf;
                this.kd = vVar.w;
                this.y.clear();
                this.y.addAll(vVar.tf());
                if (xj2 == hf || str4.charAt(xj2) == '#') {
                    kd(vVar.p());
                }
                str2 = str4;
            } else {
                int i2 = xj2 + w;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    xj = com.bytedance.sdk.component.w.hf.xj.w.xj(str4, i2, hf, "@/\\?#");
                    char charAt = xj != hf ? str4.charAt(xj) : (char) 65535;
                    if (charAt == 65535 || charAt == c || charAt == '/' || charAt == '\\' || charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int xj3 = com.bytedance.sdk.component.w.hf.xj.w.xj(str4, i2, xj, ':');
                            String xj4 = v.xj(str, i2, xj3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                xj4 = A2egSU.B3GDIM(new StringBuilder(), this.hf, "%40", xj4);
                            }
                            this.hf = xj4;
                            if (xj3 != xj) {
                                i = xj;
                                this.w = v.xj(str, xj3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            } else {
                                i = xj;
                            }
                            str3 = str;
                            z2 = true;
                        } else {
                            i = xj;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.w);
                            sb.append("%40");
                            str3 = str;
                            sb.append(v.xj(str3, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.w = sb.toString();
                        }
                        i2 = i + 1;
                        str4 = str3;
                        c = '#';
                    }
                }
                str2 = str4;
                int i3 = i2;
                int u = u(str2, i3, xj);
                int i4 = u + 1;
                if (i4 < xj) {
                    this.u = kd(str2, i3, u);
                    int y = y(str2, i4, xj);
                    this.kd = y;
                    if (y == -1) {
                        return EnumC0122xj.INVALID_PORT;
                    }
                } else {
                    this.u = kd(str2, i3, u);
                    this.kd = v.xj(this.xj);
                }
                if (this.u == null) {
                    return EnumC0122xj.INVALID_HOST;
                }
                xj2 = xj;
            }
            int xj5 = com.bytedance.sdk.component.w.hf.xj.w.xj(str2, xj2, hf, "?#");
            xj(str2, xj2, xj5);
            if (xj5 < hf && str2.charAt(xj5) == '?') {
                int xj6 = com.bytedance.sdk.component.w.hf.xj.w.xj(str2, xj5, hf, '#');
                this.c = v.hf(v.xj(str2, xj5 + 1, xj6, " \"'<>#", true, false, true, true, null));
                xj5 = xj6;
            }
            if (xj5 < hf && str2.charAt(xj5) == '#') {
                this.f = v.xj(str2, xj5 + 1, hf, "", true, false, false, false, null);
            }
            return EnumC0122xj.SUCCESS;
        }

        private void xj(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.y;
                list.set(list.size() - 1, "");
            } else {
                this.y.clear();
                this.y.add("");
                i++;
            }
            int i3 = i;
            while (i3 < i2) {
                int xj = com.bytedance.sdk.component.w.hf.xj.w.xj(str, i3, i2, "/\\");
                boolean z = xj < i2;
                String str2 = str;
                xj(str2, i3, xj, z, true);
                if (z) {
                    xj++;
                }
                i3 = xj;
                str = str2;
            }
        }

        private void xj(String str, int i, int i2, boolean z, boolean z2) {
            String xj = v.xj(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (y(xj)) {
                return;
            }
            if (c(xj)) {
                u();
                return;
            }
            if (((String) A2egSU.AlLFFp(this.y, 1)).isEmpty()) {
                List<String> list = this.y;
                list.set(list.size() - 1, xj);
            } else {
                this.y.add(xj);
            }
            if (z) {
                this.y.add("");
            }
        }
    }

    public v(xj xjVar) {
        this.xj = xjVar.xj;
        this.kd = xj(xjVar.hf, false);
        this.y = xj(xjVar.w, false);
        this.hf = xjVar.u;
        this.w = xjVar.xj();
        this.c = xj(xjVar.y, false);
        List<String> list = xjVar.c;
        this.f = list != null ? xj(list, true) : null;
        String str = xjVar.f;
        this.d = str != null ? xj(str, false) : null;
        this.tf = xjVar.toString();
    }

    public xj am() {
        xj xjVar = new xj();
        xjVar.xj = this.xj;
        xjVar.hf = kd();
        xjVar.w = y();
        xjVar.u = this.hf;
        xjVar.kd = this.w != xj(this.xj) ? this.w : -1;
        xjVar.y.clear();
        xjVar.y.addAll(tf());
        xjVar.kd(p());
        xjVar.f = pl();
        return xjVar;
    }

    public String c() {
        return this.hf;
    }

    public String d() {
        int indexOf = this.tf.indexOf(47, this.xj.length() + 3);
        String str = this.tf;
        return this.tf.substring(indexOf, com.bytedance.sdk.component.w.hf.xj.w.xj(str, indexOf, str.length(), "?#"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && ((v) obj).tf.equals(this.tf);
    }

    public int f() {
        return this.w;
    }

    public String g() {
        return u("/...").hf("").w("").w().toString();
    }

    public int hashCode() {
        return this.tf.hashCode();
    }

    public URI hf() {
        String xjVar = am().hf().toString();
        try {
            return new URI(xjVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(xjVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String kd() {
        if (this.kd.isEmpty()) {
            return "";
        }
        int length = this.xj.length() + 3;
        String str = this.tf;
        return this.tf.substring(length, com.bytedance.sdk.component.w.hf.xj.w.xj(str, length, str.length(), ":@"));
    }

    public String p() {
        if (this.f == null) {
            return null;
        }
        int indexOf = this.tf.indexOf(63) + 1;
        String str = this.tf;
        return this.tf.substring(indexOf, com.bytedance.sdk.component.w.hf.xj.w.xj(str, indexOf, str.length(), '#'));
    }

    public String pl() {
        if (this.d == null) {
            return null;
        }
        return this.tf.substring(this.tf.indexOf(35) + 1);
    }

    public String query() {
        if (this.f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        hf(sb, this.f);
        return sb.toString();
    }

    public List<String> tf() {
        int indexOf = this.tf.indexOf(47, this.xj.length() + 3);
        String str = this.tf;
        int xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < xj2) {
            int i = indexOf + 1;
            int xj3 = com.bytedance.sdk.component.w.hf.xj.w.xj(this.tf, i, xj2, '/');
            arrayList.add(this.tf.substring(i, xj3));
            indexOf = xj3;
        }
        return arrayList;
    }

    public String toString() {
        return this.tf;
    }

    public boolean u() {
        return this.xj.equals("https");
    }

    public String w() {
        return this.xj;
    }

    public URL xj() {
        try {
            return new URL(this.tf);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String y() {
        if (this.y.isEmpty()) {
            return "";
        }
        return this.tf.substring(this.tf.indexOf(58, this.xj.length() + 3) + 1, this.tf.indexOf(64));
    }

    public xj u(String str) {
        xj xjVar = new xj();
        if (xjVar.xj(this, str) == xj.EnumC0122xj.SUCCESS) {
            return xjVar;
        }
        return null;
    }

    public v w(String str) {
        xj u2 = u(str);
        if (u2 != null) {
            return u2.w();
        }
        return null;
    }

    public static int xj(String str) {
        if (str.equals(Constants.HTTP)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static v kd(String str) {
        xj xjVar = new xj();
        if (xjVar.xj(null, str) == xj.EnumC0122xj.SUCCESS) {
            return xjVar.w();
        }
        return null;
    }

    public static void xj(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public static void hf(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static v xj(URL url) {
        return kd(url.toString());
    }

    public static String xj(String str, boolean z) {
        return xj(str, 0, str.length(), z);
    }

    private List<String> xj(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? xj(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> hf(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static String xj(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
                wVar.xj(str, i, i3);
                xj(wVar, str, i3, i2, z);
                return wVar.qt();
            }
        }
        return str.substring(i, i2);
    }

    public static void xj(com.bytedance.sdk.component.w.xj.w wVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(str.charAt(i + 1));
                int xj3 = com.bytedance.sdk.component.w.hf.xj.w.xj(str.charAt(i3));
                if (xj2 != -1 && xj3 != -1) {
                    wVar.d((xj2 << 4) + xj3);
                    i = i3;
                }
                wVar.xj(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    wVar.d(32);
                }
                wVar.xj(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static boolean xj(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.w.hf.xj.w.xj(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.w.hf.xj.w.xj(str.charAt(i3)) != -1;
    }

    public static String xj(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || xj(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
                wVar.xj(str, i, i3);
                xj(wVar, str, i3, i2, str2, z, z2, z3, z4, charset);
                return wVar.qt();
            }
        }
        return str.substring(i, i2);
    }

    public static void xj(com.bytedance.sdk.component.w.xj.w wVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.w.xj.w wVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    wVar.hf(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || xj(str, i, i2)))))) {
                    wVar.xj(codePointAt);
                } else {
                    if (wVar2 == null) {
                        wVar2 = new com.bytedance.sdk.component.w.xj.w();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.w.hf.xj.w.kd)) {
                        wVar2.xj(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        wVar2.xj(codePointAt);
                    }
                    while (!wVar2.kd()) {
                        byte f = wVar2.f();
                        wVar.d(37);
                        char[] cArr = u;
                        wVar.d((int) cArr[((f & 255) >> 4) & 15]);
                        wVar.d((int) cArr[f & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static String xj(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return xj(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
