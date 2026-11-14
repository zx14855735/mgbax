package RjNab0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AZkASS extends AZOQYO {
    public static String A2egSU(String str) {
        RXb0Sz.ARc23Z.AMqCpz(str, "<this>");
        RXb0Sz.ARc23Z.AMqCpz(str, "missingDelimiterValue");
        int lastIndexOf = str.lastIndexOf(46, str.length() - 1);
        if (lastIndexOf == -1) {
            return str;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        RXb0Sz.ARc23Z.ADYaiT(substring, "substring(...)");
        return substring;
    }
}
