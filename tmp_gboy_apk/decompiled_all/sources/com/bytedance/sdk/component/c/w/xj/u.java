package com.bytedance.sdk.component.c.w.xj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public int delete(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            w.xj(uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (w.xj(uri.getQueryParameter("sp_file_name"), str2)) {
            w.hf(uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public String getType(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            StringBuilder sb = new StringBuilder();
            sb.append(w.xj(uri.getQueryParameter("sp_file_name"), str2));
            return sb.toString();
        }
        return w.xj(uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            w.xj(uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> hf;
        if (!uri.getPath().split("/")[2].equals("get_all") || (hf = w.hf(uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : hf.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = hf.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            } else if (obj instanceof Long) {
                objArr[1] = "long";
            } else if (obj instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        insert(uri, contentValues);
        return 0;
    }

    public String xj() {
        return "t_sp";
    }
}
