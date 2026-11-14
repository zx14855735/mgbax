package okhttp3;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.A5SV6n;
import okhttp3.internal.http.ADYaiT;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class Builder {

        @Nullable
        String domain;
        boolean hostOnly;
        boolean httpOnly;

        @Nullable
        String name;
        boolean persistent;
        boolean secure;

        @Nullable
        String value;
        long expiresAt = ADYaiT.MAX_DATE;
        String path = "/";

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > ADYaiT.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public Builder path(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        private Builder domain(String str, boolean z) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String ADYaiT2 = A5SV6n.ADYaiT(str);
            if (ADYaiT2 == null) {
                throw new IllegalArgumentException("unexpected domain: ".concat(str));
            }
            this.domain = ADYaiT2;
            this.hostOnly = z;
            return this;
        }
    }

    static {
        NhKENO();
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    private static /* synthetic */ void NhKENO() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !A5SV6n.BI9f7h(str);
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String ADYaiT2 = A5SV6n.ADYaiT(str);
        if (ADYaiT2 != null) {
            return ADYaiT2;
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i, int i2) {
        int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (dateCharacterOffset < i2) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(A5SV6n.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, i6 - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i7);
        gregorianCalendar.set(13, i8);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith("/") || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int A2egSU2 = A2egSU.A2egSU(A2egSU.A2egSU(A2egSU.A2egSU(A2egSU.A2egSU(527, 31, this.name), 31, this.value), 31, this.domain), 31, this.path);
        long j = this.expiresAt;
        return ((((((((A2egSU2 + ((int) (j ^ (j >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        if ((this.hostOnly ? httpUrl.host().equals(this.domain) : domainMatch(httpUrl.host(), this.domain)) && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    @Nullable
    public static Cookie parse(long j, HttpUrl httpUrl, String str) {
        long j2;
        String str2;
        String str3;
        int length = str.length();
        char c = ';';
        int AaHO0E2 = A5SV6n.AaHO0E(str, 0, length, ';');
        int AaHO0E3 = A5SV6n.AaHO0E(str, 0, AaHO0E2, '=');
        if (AaHO0E3 != AaHO0E2) {
            int B7CMnp2 = A5SV6n.B7CMnp(0, AaHO0E3, str);
            String substring = str.substring(B7CMnp2, A5SV6n.B9tovu(B7CMnp2, AaHO0E3, str));
            if (!substring.isEmpty()) {
                int length2 = substring.length();
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        i = -1;
                        break;
                    }
                    char charAt = substring.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        break;
                    }
                    i++;
                }
                if (i == -1) {
                    int B7CMnp3 = A5SV6n.B7CMnp(AaHO0E3 + 1, AaHO0E2, str);
                    String substring2 = str.substring(B7CMnp3, A5SV6n.B9tovu(B7CMnp3, AaHO0E2, str));
                    int length3 = substring2.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 < length3) {
                            char charAt2 = substring2.charAt(i2);
                            if (charAt2 <= 31 || charAt2 >= 127) {
                                break;
                            }
                            i2++;
                        } else {
                            i2 = -1;
                            break;
                        }
                    }
                    if (i2 == -1) {
                        int i3 = AaHO0E2 + 1;
                        long j3 = 253402300799999L;
                        String str4 = null;
                        String str5 = null;
                        long j4 = -1;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = true;
                        boolean z4 = false;
                        while (i3 < length) {
                            int AaHO0E4 = A5SV6n.AaHO0E(str, i3, length, c);
                            int AaHO0E5 = A5SV6n.AaHO0E(str, i3, AaHO0E4, '=');
                            int B7CMnp4 = A5SV6n.B7CMnp(i3, AaHO0E5, str);
                            String substring3 = str.substring(B7CMnp4, A5SV6n.B9tovu(B7CMnp4, AaHO0E5, str));
                            if (AaHO0E5 < AaHO0E4) {
                                int B7CMnp5 = A5SV6n.B7CMnp(AaHO0E5 + 1, AaHO0E4, str);
                                str3 = str.substring(B7CMnp5, A5SV6n.B9tovu(B7CMnp5, AaHO0E4, str));
                            } else {
                                str3 = "";
                            }
                            if (substring3.equalsIgnoreCase("expires")) {
                                try {
                                    j3 = parseExpires(str3, 0, str3.length());
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (substring3.equalsIgnoreCase("max-age")) {
                                j4 = parseMaxAge(str3);
                            } else {
                                if (substring3.equalsIgnoreCase("domain")) {
                                    str4 = parseDomain(str3);
                                    z3 = false;
                                } else if (substring3.equalsIgnoreCase("path")) {
                                    str5 = str3;
                                } else if (substring3.equalsIgnoreCase("secure")) {
                                    z = true;
                                } else if (substring3.equalsIgnoreCase("httponly")) {
                                    z2 = true;
                                }
                                i3 = AaHO0E4 + 1;
                                c = ';';
                            }
                            z4 = true;
                            i3 = AaHO0E4 + 1;
                            c = ';';
                        }
                        if (j4 == Long.MIN_VALUE) {
                            j2 = Long.MIN_VALUE;
                        } else if (j4 != -1) {
                            long j5 = j + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                            j2 = (j5 < j || j5 > ADYaiT.MAX_DATE) ? 253402300799999L : j5;
                        } else {
                            j2 = j3;
                        }
                        String host = httpUrl.host();
                        if (str4 == null) {
                            str2 = host;
                        } else {
                            if (!domainMatch(host, str4)) {
                                return null;
                            }
                            str2 = str4;
                        }
                        if (host.length() != str2.length() && PublicSuffixDatabase.A4TApA().A5SV6n(str2) == null) {
                            return null;
                        }
                        if (str5 == null || !str5.startsWith("/")) {
                            String encodedPath = httpUrl.encodedPath();
                            int lastIndexOf = encodedPath.lastIndexOf(47);
                            str5 = lastIndexOf != 0 ? encodedPath.substring(0, lastIndexOf) : "/";
                        }
                        return new Cookie(substring, substring2, j2, str2, str5, z, z2, z3, z4);
                    }
                }
            }
        }
        return null;
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(ADYaiT.A2egSU(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
