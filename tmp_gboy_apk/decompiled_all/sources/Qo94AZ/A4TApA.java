package Qo94AZ;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA {
    public static final Pattern AMqCpz = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Pattern f7765ARc23Z = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final Pattern f7766ASJ6gh = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f7767A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f7768A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f7769A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f7770ADYaiT;

    static {
        Rybi();
    }

    public A4TApA(String str) {
        this.f7767A2egSU = str;
        if (str != null) {
            Matcher matcher = AMqCpz.matcher(str);
            this.f7768A4TApA = matcher.find() ? matcher.group(1) : "";
            Matcher matcher2 = f7765ARc23Z.matcher(str);
            this.f7769A5SV6n = matcher2.find() ? matcher2.group(2) : null;
        } else {
            this.f7768A4TApA = "";
            this.f7769A5SV6n = "UTF-8";
        }
        if (!"multipart/form-data".equalsIgnoreCase(this.f7768A4TApA)) {
            this.f7770ADYaiT = null;
        } else {
            Matcher matcher3 = f7766ASJ6gh.matcher(str);
            this.f7770ADYaiT = matcher3.find() ? matcher3.group(2) : null;
        }
    }

    private static /* synthetic */ void Rybi() {
        char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 169);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 169);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String A2egSU() {
        String str = this.f7769A5SV6n;
        return str == null ? CharEncoding.US_ASCII : str;
    }
}
