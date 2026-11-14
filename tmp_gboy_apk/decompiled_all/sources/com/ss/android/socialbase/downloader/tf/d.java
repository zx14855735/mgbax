package com.ss.android.socialbase.downloader.tf;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    public static StringBuilder hf(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            xj(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder xj(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder xj(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder xj(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String hf(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + '\"');
        sb.append(" (");
        xj(sb, strArr);
        sb.append(") VALUES (");
        xj(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder xj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder xj(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            xj(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String xj(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append("\" (");
        xj(sb, strArr);
        sb.append(") VALUES (");
        xj(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String xj(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            xj(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String xj(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("UPDATE ", str2, " SET ");
        hf(B3GDIM2, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            B3GDIM2.append(" WHERE ");
            xj(B3GDIM2, str2, strArr2);
        }
        return B3GDIM2.toString();
    }
}
