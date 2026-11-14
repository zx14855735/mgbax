package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements u.xj {
    private com.bytedance.sdk.component.f.hf.hf.hf.xj xj;

    public xj(com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.f.hf.hf.hf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
