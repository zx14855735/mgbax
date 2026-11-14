package com.bytedance.msdk.f.w.xj.xj;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private u.xj hf;
    private final com.bytedance.sdk.openadsdk.core.multipro.xj xj = new com.bytedance.sdk.openadsdk.core.multipro.xj(new com.bytedance.sdk.component.f.hf.hf.hf.xj("csj_mediation"));

    private u.xj xj(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "uri is error3");
            return null;
        }
        if (this.hf == null) {
            w wVar = new w();
            this.hf = wVar;
            wVar.init();
        }
        if (str.equals(this.hf.getTableName())) {
            return this.hf;
        }
        if (str.equals(this.xj.getTableName())) {
            return this.xj;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "uri is error4");
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        u.xj xj = xj(uri);
        if (xj != null) {
            return xj.delete(uri, str, strArr);
        }
        return 0;
    }

    public String getType(Uri uri) {
        u.xj xj = xj(uri);
        if (xj != null) {
            return xj.getType(uri);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        u.xj xj = xj(uri);
        if (xj != null) {
            return xj.insert(uri, contentValues);
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        u.xj xj = xj(uri);
        if (xj != null) {
            return xj.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        u.xj xj = xj(uri);
        if (xj != null) {
            return xj.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
