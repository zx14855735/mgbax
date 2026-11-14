package com.baidu.mobads.sdk.api;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ArticleInfo {
    public static final String USER_SEX = "sex";
    public static final String PAGE_TITLE = "page_title";
    public static final String PAGE_ID = "page_content_id";
    public static final String CONTENT_CATEGORY = "page_content_category";
    public static final String CONTENT_LABEL = "page_content_label";
    public static final String FIRST_LEVEL_CONTENTS = "page_ctnts_l1";
    public static final String FAVORITE_BOOK = "fav_book";
    public static final String PAGE_SERIAL_STATUS = "page_series_stat";
    public static final String CHAPTER_NUM = "page_chptr_num";
    public static final String PAGE_AUTHOR_ID = "page_author_id";
    public static final String SECOND_LEVEL_CONTENTS = "page_ctnts_l2";
    public static final String QUERY_WORD = "qw";
    public static final String[] PREDEFINED_KEYS = {USER_SEX, PAGE_TITLE, PAGE_ID, CONTENT_CATEGORY, CONTENT_LABEL, FIRST_LEVEL_CONTENTS, FAVORITE_BOOK, PAGE_SERIAL_STATUS, CHAPTER_NUM, PAGE_AUTHOR_ID, SECOND_LEVEL_CONTENTS, QUERY_WORD};

    public class ValidSexValue {
        int UNKNOWN = 0;
        int MALE = 1;
        int FEMALE = 2;

        public ValidSexValue() {
        }
    }

    static {
        CGAGS();
    }

    private static /* synthetic */ void CGAGS() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
