package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements u.xj {
    private com.bytedance.sdk.component.c.w.xj.u xj = new com.bytedance.sdk.component.c.w.xj.u();

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        return this.xj.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return this.xj.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        return this.xj.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.xj.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.xj.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.xj.update(uri, contentValues, str, strArr);
    }
}
