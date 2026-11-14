package com.bytedance.sdk.openadsdk.core.multipro.xj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.tf.w;
import com.bytedance.sdk.openadsdk.core.wo.xj.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements u.xj {
    private Context xj;

    private Context getContext() {
        Context context = this.xj;
        return context == null ? pz.getContext() : context;
    }

    private boolean xj(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int delete(Uri uri, String str, String[] strArr) {
        String[] split;
        if (!xj(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            com.bytedance.sdk.openadsdk.core.tf.u xj = xj(str2);
            if (xj != null) {
                xj.delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public String getType(Uri uri) {
        String[] split;
        if (!xj(uri) && (split = uri.getPath().split("/")) != null && split.length >= 5) {
            String str = split[2];
            String str2 = split[4];
            com.bytedance.sdk.openadsdk.core.tf.u xj = xj(str);
            if (xj != null) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        xj.xj(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    xj.w();
                } else if ("transactionSetSuccess".equals(str2)) {
                    xj.u();
                } else if ("transactionEnd".equals(str2)) {
                    xj.kd();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public void injectContext(Context context) {
        this.xj = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Uri insert(Uri uri, ContentValues contentValues) {
        String[] split;
        if (!xj(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str = split[2];
            String str2 = split[3];
            com.bytedance.sdk.openadsdk.core.tf.u xj = xj(str);
            if (xj != null) {
                xj.insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] split;
        if (!xj(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str3 = split[2];
            String str4 = split[3];
            com.bytedance.sdk.openadsdk.core.tf.u xj = xj(str3);
            if (xj != null) {
                return xj.query(str4, strArr, str, strArr2, null, null, str2);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String[] split;
        if (!xj(uri) && (split = uri.getPath().split("/")) != null && split.length >= 4) {
            String str2 = split[2];
            String str3 = split[3];
            com.bytedance.sdk.openadsdk.core.tf.u xj = xj(str2);
            if (xj != null) {
                xj.update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }

    private com.bytedance.sdk.openadsdk.core.tf.u xj(String str) {
        if ("ttopensdk.db".equals(str)) {
            return w.xj(getContext()).xj();
        }
        if ("ttopensdk2.db".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.tf.xj.xj(getContext()).xj();
        }
        return null;
    }
}
