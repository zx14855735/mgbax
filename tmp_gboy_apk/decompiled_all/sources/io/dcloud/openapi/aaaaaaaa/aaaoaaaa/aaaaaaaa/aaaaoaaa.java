package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaoaaa {
    private static final char[] aaaeaaaa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String aaaaaaa0;
    final String aaaaaaaa;
    final String aaaaaaac;
    private final List aaaaaaae;
    private final List aaaaaaan;
    private final String aaaaaaao;
    final int aaaaaaau;
    private final String aaaaaaav;
    private final String aaaaaaeo;

    public static final class aaaaaaaa {
        String aaaaaaaa;
        String aaaaaaac;
        List aaaaaaae;
        final List aaaaaaan;
        String aaaaaaav;
        String aaaaaaa0 = "";
        String aaaaaaao = "";
        int aaaaaaau = -1;

        public aaaaaaaa() {
            ArrayList arrayList = new ArrayList();
            this.aaaaaaan = arrayList;
            arrayList.add("");
        }

        private boolean aaaaaaao(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public aaaaaaaa aaaaaaa0(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String aaaaaaaa = aaaaaaaa(str, 0, str.length());
            if (aaaaaaaa == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(str));
            }
            this.aaaaaaac = aaaaaaaa;
            return this;
        }

        public aaaaaaaa aaaaaaaa(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "unexpected port: "));
            }
            this.aaaaaaau = i;
            return this;
        }

        public aaaaaaaa aaaaaaac() {
            int size = this.aaaaaaan.size();
            for (int i = 0; i < size; i++) {
                this.aaaaaaan.set(i, aaaaoaaa.aaaaaaaa((String) this.aaaaaaan.get(i), "[]", true, true, false, true));
            }
            List list = this.aaaaaaae;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.aaaaaaae.get(i2);
                    if (str != null) {
                        this.aaaaaaae.set(i2, aaaaoaaa.aaaaaaaa(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.aaaaaaav;
            if (str2 != null) {
                this.aaaaaaav = aaaaoaaa.aaaaaaaa(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public aaaaaaaa aaaaaaae(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.aaaaaaa0 = aaaaoaaa.aaaaaaaa(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public aaaaaaaa aaaaaaan(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(Constants.HTTP)) {
                this.aaaaaaaa = Constants.HTTP;
                return this;
            }
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            this.aaaaaaaa = "https";
            return this;
        }

        public aaaaaaaa aaaaaaau(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.aaaaaaao = aaaaoaaa.aaaaaaaa(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.aaaaaaaa;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.aaaaaaa0.isEmpty() || !this.aaaaaaao.isEmpty()) {
                sb.append(this.aaaaaaa0);
                if (!this.aaaaaaao.isEmpty()) {
                    sb.append(':');
                    sb.append(this.aaaaaaao);
                }
                sb.append('@');
            }
            String str2 = this.aaaaaaac;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.aaaaaaac);
                    sb.append(']');
                } else {
                    sb.append(this.aaaaaaac);
                }
            }
            if (this.aaaaaaau != -1 || this.aaaaaaaa != null) {
                int aaaaaaa0 = aaaaaaa0();
                String str3 = this.aaaaaaaa;
                if (str3 == null || aaaaaaa0 != aaaaoaaa.aaaaaaaa(str3)) {
                    sb.append(':');
                    sb.append(aaaaaaa0);
                }
            }
            aaaaoaaa.aaaaaaa0(sb, this.aaaaaaan);
            if (this.aaaaaaae != null) {
                sb.append('?');
                aaaaoaaa.aaaaaaaa(sb, this.aaaaaaae);
            }
            if (this.aaaaaaav != null) {
                sb.append('#');
                sb.append(this.aaaaaaav);
            }
            return sb.toString();
        }

        private void aaaaaaao() {
            if (!((String) this.aaaaaaan.remove(r0.size() - 1)).isEmpty() || this.aaaaaaan.isEmpty()) {
                this.aaaaaaan.add("");
            } else {
                this.aaaaaaan.set(r0.size() - 1, "");
            }
        }

        private static int aaaaaaau(String str, int i, int i2) {
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

        public int aaaaaaa0() {
            int i = this.aaaaaaau;
            return i != -1 ? i : aaaaoaaa.aaaaaaaa(this.aaaaaaaa);
        }

        private static int aaaaaaa0(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(aaaaoaaa.aaaaaaaa(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static int aaaaaaao(String str, int i, int i2) {
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

        private static int aaaaaaan(String str, int i, int i2) {
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

        public aaaaaaaa aaaaaaaa(String str) {
            this.aaaaaaae = str != null ? aaaaoaaa.aaaaaaac(aaaaoaaa.aaaaaaaa(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public aaaaoaaa aaaaaaaa() {
            if (this.aaaaaaaa != null) {
                if (this.aaaaaaac != null) {
                    return new aaaaoaaa(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void aaaaaaac(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt != '/' && charAt != '\\') {
                List list = this.aaaaaaan;
                list.set(list.size() - 1, "");
            } else {
                this.aaaaaaan.clear();
                this.aaaaaaan.add("");
                i++;
            }
            int i3 = i;
            while (i3 < i2) {
                int aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, i3, i2, "/\\");
                boolean z = aaaaaaaa < i2;
                String str2 = str;
                aaaaaaaa(str2, i3, aaaaaaaa, z, true);
                if (z) {
                    i3 = aaaaaaaa + 1;
                    str = str2;
                } else {
                    str = str2;
                    i3 = aaaaaaaa;
                }
            }
        }

        public aaaaaaaa aaaaaaaa(aaaaoaaa aaaaoaaaVar, String str) {
            int aaaaaaaa;
            String str2;
            int i;
            String str3;
            String str4 = str;
            int aaaaaaa0 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(str4, 0, str4.length());
            int aaaaaaao = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaao(str4, aaaaaaa0, str4.length());
            int aaaaaaau = aaaaaaau(str4, aaaaaaa0, aaaaaaao);
            if (aaaaaaau != -1) {
                if (str4.regionMatches(true, aaaaaaa0, "https:", 0, 6)) {
                    this.aaaaaaaa = "https";
                    aaaaaaa0 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (str4.regionMatches(true, aaaaaaa0, "http:", 0, 5)) {
                        this.aaaaaaaa = Constants.HTTP;
                        aaaaaaa0 += 5;
                    } else {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, aaaaaaau) + "'");
                    }
                }
            } else if (aaaaoaaaVar != null) {
                this.aaaaaaaa = aaaaoaaaVar.aaaaaaaa;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int aaaaaaan = aaaaaaan(str4, aaaaaaa0, aaaaaaao);
            char c = '#';
            if (aaaaaaan < 2 && aaaaoaaaVar != null && aaaaoaaaVar.aaaaaaaa.equals(this.aaaaaaaa)) {
                this.aaaaaaa0 = aaaaoaaaVar.aaaaaaan();
                this.aaaaaaao = aaaaoaaaVar.aaaaaaa0();
                this.aaaaaaac = aaaaoaaaVar.aaaaaaac;
                this.aaaaaaau = aaaaoaaaVar.aaaaaaau;
                this.aaaaaaan.clear();
                this.aaaaaaan.addAll(aaaaoaaaVar.aaaaaaac());
                if (aaaaaaa0 == aaaaaaao || str4.charAt(aaaaaaa0) == '#') {
                    aaaaaaaa(aaaaoaaaVar.aaaaaaau());
                }
                str2 = str4;
            } else {
                int i2 = aaaaaaa0 + aaaaaaan;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str4, i2, aaaaaaao, "@/\\?#");
                    char charAt = aaaaaaaa != aaaaaaao ? str4.charAt(aaaaaaaa) : (char) 65535;
                    if (charAt == 65535 || charAt == c || charAt == '/' || charAt == '\\' || charAt == '?') {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str4, i2, aaaaaaaa, ':');
                            String aaaaaaaa3 = aaaaoaaa.aaaaaaaa(str, i2, aaaaaaaa2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                aaaaaaaa3 = A2egSU.B3GDIM(new StringBuilder(), this.aaaaaaa0, "%40", aaaaaaaa3);
                            }
                            this.aaaaaaa0 = aaaaaaaa3;
                            if (aaaaaaaa2 != aaaaaaaa) {
                                i = aaaaaaaa;
                                this.aaaaaaao = aaaaoaaa.aaaaaaaa(str, aaaaaaaa2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            } else {
                                i = aaaaaaaa;
                            }
                            str3 = str;
                            z2 = true;
                        } else {
                            i = aaaaaaaa;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.aaaaaaao);
                            sb.append("%40");
                            str3 = str;
                            sb.append(aaaaoaaa.aaaaaaaa(str3, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.aaaaaaao = sb.toString();
                        }
                        i2 = i + 1;
                        str4 = str3;
                        c = '#';
                    }
                }
                str2 = str4;
                int i3 = i2;
                int aaaaaaao2 = aaaaaaao(str2, i3, aaaaaaaa);
                int i4 = aaaaaaao2 + 1;
                if (i4 < aaaaaaaa) {
                    this.aaaaaaac = aaaaaaaa(str2, i3, aaaaaaao2);
                    int aaaaaaa02 = aaaaaaa0(str2, i4, aaaaaaaa);
                    this.aaaaaaau = aaaaaaa02;
                    if (aaaaaaa02 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i4, aaaaaaaa) + '\"');
                    }
                } else {
                    this.aaaaaaac = aaaaaaaa(str2, i3, aaaaaaao2);
                    this.aaaaaaau = aaaaoaaa.aaaaaaaa(this.aaaaaaaa);
                }
                if (this.aaaaaaac == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, aaaaaaao2) + '\"');
                }
                aaaaaaa0 = aaaaaaaa;
            }
            int aaaaaaaa4 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str2, aaaaaaa0, aaaaaaao, "?#");
            aaaaaaac(str2, aaaaaaa0, aaaaaaaa4);
            if (aaaaaaaa4 < aaaaaaao && str2.charAt(aaaaaaaa4) == '?') {
                int aaaaaaaa5 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str2, aaaaaaaa4, aaaaaaao, '#');
                this.aaaaaaae = aaaaoaaa.aaaaaaac(aaaaoaaa.aaaaaaaa(str2, aaaaaaaa4 + 1, aaaaaaaa5, " \"'<>#", true, false, true, true, null));
                aaaaaaaa4 = aaaaaaaa5;
            }
            if (aaaaaaaa4 < aaaaaaao && str2.charAt(aaaaaaaa4) == '#') {
                this.aaaaaaav = aaaaoaaa.aaaaaaaa(str2, aaaaaaaa4 + 1, aaaaaaao, "", true, false, false, false, null);
            }
            return this;
        }

        private boolean aaaaaaac(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void aaaaaaaa(String str, int i, int i2, boolean z, boolean z2) {
            String aaaaaaaa = aaaaoaaa.aaaaaaaa(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (aaaaaaao(aaaaaaaa)) {
                return;
            }
            if (aaaaaaac(aaaaaaaa)) {
                aaaaaaao();
                return;
            }
            if (((String) A2egSU.AlLFFp(this.aaaaaaan, 1)).isEmpty()) {
                List list = this.aaaaaaan;
                list.set(list.size() - 1, aaaaaaaa);
            } else {
                this.aaaaaaan.add(aaaaaaaa);
            }
            if (z) {
                this.aaaaaaan.add("");
            }
        }

        private static String aaaaaaaa(String str, int i, int i2) {
            return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaoaaa.aaaaaaaa(str, i, i2, false));
        }
    }

    public aaaaoaaa(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaa0 = aaaaaaaa(aaaaaaaaVar.aaaaaaa0, false);
        this.aaaaaaao = aaaaaaaa(aaaaaaaaVar.aaaaaaao, false);
        this.aaaaaaac = aaaaaaaaVar.aaaaaaac;
        this.aaaaaaau = aaaaaaaaVar.aaaaaaa0();
        this.aaaaaaan = aaaaaaaa(aaaaaaaaVar.aaaaaaan, false);
        List list = aaaaaaaaVar.aaaaaaae;
        this.aaaaaaae = list != null ? aaaaaaaa(list, true) : null;
        String str = aaaaaaaaVar.aaaaaaav;
        this.aaaaaaav = str != null ? aaaaaaaa(str, false) : null;
        this.aaaaaaeo = aaaaaaaaVar.toString();
    }

    public static int aaaaaaaa(String str) {
        if (str.equals(Constants.HTTP)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String aaaaaaa0() {
        if (this.aaaaaaao.isEmpty()) {
            return "";
        }
        return this.aaaaaaeo.substring(this.aaaaaaeo.indexOf(58, this.aaaaaaaa.length() + 3) + 1, this.aaaaaaeo.indexOf(64));
    }

    public List aaaaaaac() {
        int indexOf = this.aaaaaaeo.indexOf(47, this.aaaaaaaa.length() + 3);
        String str = this.aaaaaaeo;
        int aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < aaaaaaaa2) {
            int i = indexOf + 1;
            int aaaaaaaa3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaeo, i, aaaaaaaa2, '/');
            arrayList.add(this.aaaaaaeo.substring(i, aaaaaaaa3));
            indexOf = aaaaaaaa3;
        }
        return arrayList;
    }

    public String aaaaaaae() {
        return this.aaaaaaac;
    }

    public String aaaaaaan() {
        if (this.aaaaaaa0.isEmpty()) {
            return "";
        }
        int length = this.aaaaaaaa.length() + 3;
        String str = this.aaaaaaeo;
        return this.aaaaaaeo.substring(length, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, length, str.length(), ":@"));
    }

    public String aaaaaaao() {
        int indexOf = this.aaaaaaeo.indexOf(47, this.aaaaaaaa.length() + 3);
        String str = this.aaaaaaeo;
        return this.aaaaaaeo.substring(indexOf, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, indexOf, str.length(), "?#"));
    }

    public String aaaaaaau() {
        if (this.aaaaaaae == null) {
            return null;
        }
        int indexOf = this.aaaaaaeo.indexOf(63) + 1;
        String str = this.aaaaaaeo;
        return this.aaaaaaeo.substring(indexOf, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str, indexOf, str.length(), '#'));
    }

    public boolean aaaaaaav() {
        return this.aaaaaaaa.equals("https");
    }

    public String aaaaaaea() {
        return this.aaaaaaaa;
    }

    public aaaaaaaa aaaaaaeo() {
        aaaaaaaa aaaaaaaaVar = new aaaaaaaa();
        aaaaaaaaVar.aaaaaaaa = this.aaaaaaaa;
        aaaaaaaaVar.aaaaaaa0 = aaaaaaan();
        aaaaaaaaVar.aaaaaaao = aaaaaaa0();
        aaaaaaaaVar.aaaaaaac = this.aaaaaaac;
        aaaaaaaaVar.aaaaaaau = this.aaaaaaau != aaaaaaaa(this.aaaaaaaa) ? this.aaaaaaau : -1;
        aaaaaaaaVar.aaaaaaan.clear();
        aaaaaaaaVar.aaaaaaan.addAll(aaaaaaac());
        aaaaaaaaVar.aaaaaaaa(aaaaaaau());
        aaaaaaaaVar.aaaaaaav = aaaaaaaa();
        return aaaaaaaaVar;
    }

    public String aaaaaeaa() {
        return aaaaaaao("/...").aaaaaaae("").aaaaaaau("").aaaaaaaa().toString();
    }

    public String aaaaeaaa() {
        if (this.aaaaaaae == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        aaaaaaaa(sb, this.aaaaaaae);
        return sb.toString();
    }

    public int aaaeaaaa() {
        return this.aaaaaaau;
    }

    public URI eaaaaaaa() {
        String aaaaaaaaVar = aaaaaaeo().aaaaaaac().toString();
        try {
            return new URI(aaaaaaaaVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aaaaaaaaVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof aaaaoaaa) && ((aaaaoaaa) obj).aaaaaaeo.equals(this.aaaaaaeo);
    }

    public int hashCode() {
        return this.aaaaaaeo.hashCode();
    }

    public String toString() {
        return this.aaaaaaeo;
    }

    public static void aaaaaaaa(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
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

    public aaaaaaaa aaaaaaao(String str) {
        try {
            return new aaaaaaaa().aaaaaaaa(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void aaaaaaa0(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) list.get(i));
        }
    }

    public aaaaoaaa aaaaaaau(String str) {
        aaaaaaaa aaaaaaao = aaaaaaao(str);
        if (aaaaaaao != null) {
            return aaaaaaao.aaaaaaaa();
        }
        return null;
    }

    public static List aaaaaaac(String str) {
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

    public static aaaaoaaa aaaaaaa0(String str) {
        return new aaaaaaaa().aaaaaaaa(null, str).aaaaaaaa();
    }

    public String aaaaaaaa() {
        if (this.aaaaaaav == null) {
            return null;
        }
        return this.aaaaaaeo.substring(this.aaaaaaeo.indexOf(35) + 1);
    }

    public static String aaaaaaaa(String str, boolean z) {
        return aaaaaaaa(str, 0, str.length(), z);
    }

    private List aaaaaaaa(List list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? aaaaaaaa(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String aaaaaaaa(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
                aaaaaaaoVar.aaaaaaaa(str, i, i3);
                aaaaaaaa(aaaaaaaoVar, str, i3, i2, z);
                return aaaaaaaoVar.aaaaaeaa();
            }
        }
        return str.substring(i, i2);
    }

    public static void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str.charAt(i + 1));
                int aaaaaaaa3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str.charAt(i3));
                if (aaaaaaaa2 != -1 && aaaaaaaa3 != -1) {
                    aaaaaaaoVar.writeByte((aaaaaaaa2 << 4) + aaaaaaaa3);
                    i = i3;
                }
                aaaaaaaoVar.aaaaaaan(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    aaaaaaaoVar.writeByte(32);
                }
                aaaaaaaoVar.aaaaaaan(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static boolean aaaaaaaa(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str.charAt(i + 1)) != -1 && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(str.charAt(i3)) != -1;
    }

    public static String aaaaaaaa(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || aaaaaaaa(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
                aaaaaaaoVar.aaaaaaaa(str, i, i3);
                aaaaaaaa(aaaaaaaoVar, str, i3, i2, str2, z, z2, z3, z4, charset);
                return aaaaaaaoVar.aaaaaeaa();
            }
        }
        return str.substring(i, i2);
    }

    public static void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    aaaaaaaoVar.aaaaaaaa(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || aaaaaaaa(str, i, i2)))))) {
                    aaaaaaaoVar.aaaaaaan(codePointAt);
                } else {
                    if (aaaaaaaoVar2 == null) {
                        aaaaaaaoVar2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
                    }
                    if (charset != null && !charset.equals(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaeaaaa)) {
                        aaaaaaaoVar2.aaaaaaaa(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        aaaaaaaoVar2.aaaaaaan(codePointAt);
                    }
                    while (!aaaaaaaoVar2.aaaaaaan()) {
                        byte readByte = aaaaaaaoVar2.readByte();
                        aaaaaaaoVar.writeByte(37);
                        char[] cArr = aaaeaaaa;
                        aaaaaaaoVar.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        aaaaaaaoVar.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static String aaaaaaaa(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return aaaaaaaa(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
