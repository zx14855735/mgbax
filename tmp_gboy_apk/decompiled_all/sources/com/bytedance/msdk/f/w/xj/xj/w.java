package com.bytedance.msdk.f.w.xj.xj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements u.xj {
    private com.bytedance.msdk.f.xj.xj xj;

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.msdk.f.xj.xj xjVar = this.xj;
        if (xjVar == null) {
            return 0;
        }
        xjVar.hf(str, strArr);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
        if (com.bytedance.msdk.core.hf.getContext() != null) {
            this.xj = new com.bytedance.msdk.f.xj.xj(com.bytedance.msdk.core.hf.getContext());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.msdk.f.xj.xj xjVar = this.xj;
        if (xjVar == null) {
            return null;
        }
        xjVar.xj(contentValues);
        return uri;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.msdk.f.xj.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj(str, strArr2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
