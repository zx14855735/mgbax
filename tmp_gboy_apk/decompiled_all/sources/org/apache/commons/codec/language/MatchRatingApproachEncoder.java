package org.apache.commons.codec.language;

import ADYaiT.CtFAbx;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.lang.reflect.Method;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", GlobalSetting.TT_SDK_WRAPPER, "VV", "WW", "XX", "YY", "ZZ"};
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    static {
        HXfi();
    }

    private static /* synthetic */ void HXfi() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i = 0; i < 5; i++) {
            upperCase = upperCase.replaceAll(strArr[i], "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    @Override // org.apache.commons.codec.Encoder
    public final Object encode(Object obj) {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public String getFirst3Last3(String str) {
        int length = str.length();
        return length > 6 ? CtFAbx.AcNBzu(str.substring(0, 3), str.substring(length - 3, length)) : str;
    }

    public int getMinRating(int i) {
        if (i <= 4) {
            return 5;
        }
        if (i <= 7) {
            return 4;
        }
        if (i <= 11) {
            return 3;
        }
        return i == 12 ? 2 : 1;
    }

    public boolean isEncodeEquals(String str, String str2) {
        if (str != null && !"".equalsIgnoreCase(str) && !SPACE.equalsIgnoreCase(str) && str2 != null && !"".equalsIgnoreCase(str2) && !SPACE.equalsIgnoreCase(str2) && str.length() != 1 && str2.length() != 1) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
            String cleanName = cleanName(str);
            String cleanName2 = cleanName(str2);
            String removeVowels = removeVowels(cleanName);
            String removeVowels2 = removeVowels(cleanName2);
            String removeDoubleConsonants = removeDoubleConsonants(removeVowels);
            String removeDoubleConsonants2 = removeDoubleConsonants(removeVowels2);
            String first3Last3 = getFirst3Last3(removeDoubleConsonants);
            String first3Last32 = getFirst3Last3(removeDoubleConsonants2);
            if (Math.abs(first3Last3.length() - first3Last32.length()) >= 3) {
                return false;
            }
            if (leftToRightThenRightToLeftProcessing(first3Last3, first3Last32) >= getMinRating(Math.abs(first3Last32.length() + first3Last3.length()))) {
                return true;
            }
        }
        return false;
    }

    public boolean isVowel(String str) {
        return str.equalsIgnoreCase("E") || str.equalsIgnoreCase("A") || str.equalsIgnoreCase("O") || str.equalsIgnoreCase("I") || str.equalsIgnoreCase("U");
    }

    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < charArray.length && i <= length2) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            int i3 = length - i;
            String substring2 = str.substring(i3, i3 + 1);
            String substring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String substring4 = str2.substring(i4, i4 + 1);
            if (substring.equals(substring3)) {
                charArray[i] = ' ';
                charArray2[i] = ' ';
            }
            if (substring2.equals(substring4)) {
                charArray[i3] = ' ';
                charArray2[i4] = ' ';
            }
            i = i2;
        }
        String replaceAll = new String(charArray).replaceAll("\\s+", "");
        String replaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        return replaceAll.length() > replaceAll2.length() ? Math.abs(6 - replaceAll.length()) : Math.abs(6 - replaceAll2.length());
    }

    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int indexOf = UNICODE.indexOf(charAt);
            if (indexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(indexOf));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (String str2 : DOUBLE_CONSONANT) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    public String removeVowels(String str) {
        String substring = str.substring(0, 1);
        String replaceAll = str.replaceAll("A", "").replaceAll("E", "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", SPACE);
        return isVowel(substring) ? CtFAbx.AcNBzu(substring, replaceAll) : replaceAll;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public final String encode(String str) {
        if (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str.length() == 1) {
            return "";
        }
        return getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }
}
