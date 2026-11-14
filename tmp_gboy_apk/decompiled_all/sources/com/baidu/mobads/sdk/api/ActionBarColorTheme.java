package com.baidu.mobads.sdk.api;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum ActionBarColorTheme {
    ACTION_BAR_WHITE_THEME(-5987164, -6842473, -11113262, -328966),
    ACTION_BAR_RED_THEME(-1, -1, -12510, -1294276),
    ACTION_BAR_GREEN_THEME(-1, -1, -11113262, -14303071),
    ACTION_BAR_NAVYBLUE_THEME(-1, -1, 16764706, -14210226),
    ACTION_BAR_BLUE_THEME(-1, -1, -12510, -13870424),
    ACTION_BAR_COFFEE_THEME(-1, -1, -12510, -11255230),
    ACTION_BAR_BLACK_THEME(-1, -1, -12510, -13749450);

    public int mBackgroundColor;
    public int mCloseColor;
    public int mProgressColor;
    public int mTitleColor;

    static {
        hMGJjFy();
    }

    ActionBarColorTheme(int i, int i2, int i3, int i4) {
        this.mCloseColor = i;
        this.mTitleColor = i2;
        this.mProgressColor = i3;
        this.mBackgroundColor = i4;
    }

    private static /* synthetic */ void hMGJjFy() {
        char[] charArray = ")%'d-+'/d(%3d9\"/&&d\u0000$#\b8#.-/".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'J');
        }
        String str = new String(charArray);
        char[] charArray2 = ")&#$#>".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'J');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
