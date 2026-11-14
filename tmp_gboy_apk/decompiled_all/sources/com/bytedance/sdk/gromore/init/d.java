package com.bytedance.sdk.gromore.init;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements u.xj {
    private u.xj hf = com.bytedance.msdk.f.w.xj.xj.hf.xj();
    private u.xj xj;

    public d(u.xj xjVar) {
        this.xj = xjVar;
    }

    private boolean xj(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            return false;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        return xj(uri) ? this.hf.delete(uri, str, strArr) : this.xj.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        return (xj(uri) ? this.hf : this.xj).getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
        u.xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.injectContext(context);
        }
        u.xj xjVar2 = this.hf;
        if (xjVar2 != null) {
            xjVar2.injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        return xj(uri) ? this.hf.insert(uri, contentValues) : this.xj.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return xj(uri) ? this.hf.query(uri, strArr, str, strArr2, str2) : this.xj.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return xj(uri) ? this.hf.update(uri, contentValues, str, strArr) : this.xj.update(uri, contentValues, str, strArr);
    }
}
