package com.kwad.sdk.pngencrypt;

import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum FilterType {
    FILTER_NONE(0),
    FILTER_SUB(1),
    FILTER_UP(2),
    FILTER_AVERAGE(3),
    FILTER_PAETH(4),
    FILTER_DEFAULT(-1),
    FILTER_AGGRESSIVE(-2),
    FILTER_VERYAGGRESSIVE(-4),
    FILTER_ADAPTIVE_FULL(-4),
    FILTER_ADAPTIVE_MEDIUM(-3),
    FILTER_ADAPTIVE_FAST(-2),
    FILTER_SUPER_ADAPTIVE(-10),
    FILTER_PRESERVE(-40),
    FILTER_CYCLIC(-50),
    FILTER_UNKNOWN(-100);

    private static HashMap<Integer, FilterType> byVal = new HashMap<>();
    public final int val;

    static {
        for (FilterType filterType : values()) {
            byVal.put(Integer.valueOf(filterType.val), filterType);
        }
        BQugH();
    }

    FilterType(int i) {
        this.val = i;
    }

    private static /* synthetic */ void BQugH() {
        char[] charArray = "EIK\bAGKC\bDI_\bUNCJJ\blHOdTOBAC".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '&');
        }
        String str = new String(charArray);
        char[] charArray2 = "EJOHOR".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '&');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static FilterType[] getAllStandard() {
        return new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardExceptNone() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardForFirstRow() {
        return new FilterType[]{FILTER_SUB, FILTER_NONE};
    }

    public static FilterType[] getAllStandardNoneLast() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_NONE};
    }

    public static FilterType getByVal(int i) {
        return byVal.get(Integer.valueOf(i));
    }

    public static boolean isAdaptive(FilterType filterType) {
        int i = filterType.val;
        return i <= -2 && i >= -4;
    }

    public static boolean isValidStandard(int i) {
        return i >= 0 && i <= 4;
    }

    public static boolean isValidStandard(FilterType filterType) {
        return filterType != null && isValidStandard(filterType.val);
    }
}
