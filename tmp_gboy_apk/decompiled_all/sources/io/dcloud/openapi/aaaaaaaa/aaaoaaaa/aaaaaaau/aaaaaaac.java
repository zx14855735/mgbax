package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaac {
    private static final ThreadLocal aaaaaaaa = new aaaaaaaa();
    private static final String[] aaaaaaa0 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] aaaaaaao = new DateFormat[15];

    public class aaaaaaaa extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aoaaaaaa);
            return simpleDateFormat;
        }
    }

    static {
        EzBSjFC();
    }

    private static /* synthetic */ void EzBSjFC() {
        char[] charArray = "\u0005\t\u000bH\u0001\u0007\u000b\u0003H\u0004\t\u001fH\u0015\u000e\u0003\n\nH,\b\u000f$\u0014\u000f\u0002\u0001\u0003".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'f');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0005\n\u000f\b\u000f\u0012".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Date aaaaaaaa(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) aaaaaaaa.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = aaaaaaa0;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = aaaaaaao;
                    DateFormat dateFormat = dateFormatArr[i];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(aaaaaaa0[i], Locale.US);
                        dateFormat.setTimeZone(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aoaaaaaa);
                        dateFormatArr[i] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String aaaaaaaa(Date date) {
        return ((DateFormat) aaaaaaaa.get()).format(date);
    }
}
