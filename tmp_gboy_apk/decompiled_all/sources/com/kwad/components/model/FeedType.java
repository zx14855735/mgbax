package com.kwad.components.model;

import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Method;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FEED_TYPE_UNKNOWN' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class FeedType {
    private static final /* synthetic */ FeedType[] $VALUES;
    public static final FeedType FEED_TYPE_CONTENT_11;
    public static final FeedType FEED_TYPE_CONTENT_12;
    public static final FeedType FEED_TYPE_CONTENT_13;
    public static final FeedType FEED_TYPE_TEXT_ABOVE;
    public static final FeedType FEED_TYPE_TEXT_ABOVE_GROUP;
    public static final FeedType FEED_TYPE_TEXT_BELOW;
    public static final FeedType FEED_TYPE_TEXT_IMMERSE;
    public static final FeedType FEED_TYPE_TEXT_LEFT;
    public static final FeedType FEED_TYPE_TEXT_NEW;
    public static final FeedType FEED_TYPE_TEXT_RIGHT;
    public static final FeedType FEED_TYPE_THREE_IMAGE;
    public static final FeedType FEED_TYPE_UNKNOWN;
    public static final FeedType FEED_TYPE_VERTICAL_BISERIAL;
    public static final FeedType FEED_TYPE_VERTICAL_NOVEL;
    public static final FeedType FEED_TYPE_VERTICAL_ORIGIN;
    private FeedDefaultType mFeedDefaultType;
    private int type;

    public enum FeedDefaultType {
        FEED_VERTICAL_ORIGIN(0),
        FEED_VERTICAL_NOVEL_DEFAULT(1),
        FEED_VERTICAL_BISERIAL_DEFAULT(2);

        private int defaultType;

        static {
            tFxHlh();
        }

        FeedDefaultType(int i) {
            this.defaultType = i;
        }

        private static /* synthetic */ void tFxHlh() {
            char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 216);
            }
            String str = new String(charArray);
            char[] charArray2 = "»´±¶±¬".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 216);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final int getDefaultType() {
            return this.defaultType;
        }
    }

    static {
        FeedDefaultType feedDefaultType = FeedDefaultType.FEED_VERTICAL_ORIGIN;
        FeedType feedType = new FeedType("FEED_TYPE_UNKNOWN", 0, 0, feedDefaultType);
        FEED_TYPE_UNKNOWN = feedType;
        FeedType feedType2 = new FeedType("FEED_TYPE_TEXT_IMMERSE", 1, 1, feedDefaultType);
        FEED_TYPE_TEXT_IMMERSE = feedType2;
        FeedType feedType3 = new FeedType("FEED_TYPE_TEXT_LEFT", 2, 2, feedDefaultType);
        FEED_TYPE_TEXT_LEFT = feedType3;
        FeedType feedType4 = new FeedType("FEED_TYPE_TEXT_RIGHT", 3, 3, feedDefaultType);
        FEED_TYPE_TEXT_RIGHT = feedType4;
        FeedType feedType5 = new FeedType("FEED_TYPE_TEXT_ABOVE", 4, 4, feedDefaultType);
        FEED_TYPE_TEXT_ABOVE = feedType5;
        FeedType feedType6 = new FeedType("FEED_TYPE_TEXT_BELOW", 5, 5, feedDefaultType);
        FEED_TYPE_TEXT_BELOW = feedType6;
        FeedType feedType7 = new FeedType("FEED_TYPE_TEXT_ABOVE_GROUP", 6, 6, feedDefaultType);
        FEED_TYPE_TEXT_ABOVE_GROUP = feedType7;
        FeedType feedType8 = new FeedType("FEED_TYPE_TEXT_NEW", 7, 7, feedDefaultType);
        FEED_TYPE_TEXT_NEW = feedType8;
        FeedType feedType9 = new FeedType("FEED_TYPE_CONTENT_11", 8, 11, feedDefaultType);
        FEED_TYPE_CONTENT_11 = feedType9;
        FeedType feedType10 = new FeedType("FEED_TYPE_CONTENT_12", 9, 12, feedDefaultType);
        FEED_TYPE_CONTENT_12 = feedType10;
        FeedType feedType11 = new FeedType("FEED_TYPE_CONTENT_13", 10, 13, feedDefaultType);
        FEED_TYPE_CONTENT_13 = feedType11;
        FeedType feedType12 = new FeedType("FEED_TYPE_THREE_IMAGE", 11, 20, feedDefaultType);
        FEED_TYPE_THREE_IMAGE = feedType12;
        FeedType feedType13 = new FeedType("FEED_TYPE_VERTICAL_ORIGIN", 12, 21, feedDefaultType);
        FEED_TYPE_VERTICAL_ORIGIN = feedType13;
        FeedType feedType14 = new FeedType("FEED_TYPE_VERTICAL_NOVEL", 13, 21, FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT);
        FEED_TYPE_VERTICAL_NOVEL = feedType14;
        FeedType feedType15 = new FeedType("FEED_TYPE_VERTICAL_BISERIAL", 14, 21, FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT);
        FEED_TYPE_VERTICAL_BISERIAL = feedType15;
        $VALUES = new FeedType[]{feedType, feedType2, feedType3, feedType4, feedType5, feedType6, feedType7, feedType8, feedType9, feedType10, feedType11, feedType12, feedType13, feedType14, feedType15};
        Scgll();
    }

    private FeedType(String str, int i, int i2, FeedDefaultType feedDefaultType) {
        this.type = i2;
        this.mFeedDefaultType = feedDefaultType;
    }

    private static /* synthetic */ void Scgll() {
        char[] charArray = "\u0087\u008b\u0089Ê\u0083\u0085\u0089\u0081Ê\u0086\u008b\u009dÊ\u0097\u008c\u0081\u0088\u0088Ê®\u008a\u008d¦\u0096\u008d\u0080\u0083\u0081".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 228);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0087\u0088\u008d\u008a\u008d\u0090".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 228);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean checkTypeValid(AdTemplate adTemplate) {
        int bf = a.bf(e.er(adTemplate));
        if (isH5Type(adTemplate.type)) {
            return true;
        }
        FeedType fromInt = fromInt(adTemplate.type, adTemplate.defaultType);
        if (bf != 1) {
            if (bf == 2) {
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true;
            }
            if (bf == 3) {
                return (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_VERTICAL_ORIGIN || fromInt == FEED_TYPE_VERTICAL_NOVEL || fromInt == FEED_TYPE_VERTICAL_BISERIAL) ? false : true;
            }
            if (bf != 8) {
                return false;
            }
        }
        return fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE || fromInt == FEED_TYPE_VERTICAL_ORIGIN || fromInt == FEED_TYPE_VERTICAL_NOVEL || fromInt == FEED_TYPE_VERTICAL_BISERIAL;
    }

    public static FeedType fromInt(int i, int i2) {
        if (isH5Type(i)) {
            return FEED_TYPE_TEXT_NEW;
        }
        for (FeedType feedType : values()) {
            if ((feedType.type == i && !isNewVerticalType(i)) || (feedType.type == i && isNewVerticalType(i) && feedType.mFeedDefaultType.getDefaultType() == i2)) {
                return feedType;
            }
        }
        return FEED_TYPE_UNKNOWN;
    }

    private static boolean isH5Type(int i) {
        return i == 7 || i == 8 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i >= 2000;
    }

    public static boolean isNewVerticalType(int i) {
        return i == 21;
    }

    public static FeedType valueOf(String str) {
        return (FeedType) Enum.valueOf(FeedType.class, str);
    }

    public static FeedType[] values() {
        return (FeedType[]) $VALUES.clone();
    }

    public final FeedDefaultType getFeedDefaultType() {
        return this.mFeedDefaultType;
    }

    public final int getType() {
        return this.type;
    }
}
