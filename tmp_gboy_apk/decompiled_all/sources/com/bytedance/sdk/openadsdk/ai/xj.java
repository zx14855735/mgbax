package com.bytedance.sdk.openadsdk.ai;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ITTProvider;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements ITTProvider {
    private Function<SparseArray<Object>, Object> xj;

    public xj(Object obj) {
        if (BpkvW3.BmvVmW(obj)) {
            this.xj = AaHO0E.AYUAbz(obj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999906, sparseArray, -99999987, -99999985, Integer.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999901, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999903, sparseArray, -99999987, -99999985, String.class);
        sparseArray.put(-7999921, uri);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
        if (this.xj != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(-7999902, sparseArray, -99999987, -99999985, Void.class);
            this.xj.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        if (this.xj != null) {
            SparseArray sparseArray = new SparseArray();
            A2egSU.B2KMhB(-7999900, sparseArray, -99999987, -99999985, Void.class);
            sparseArray.put(-7999920, context);
            this.xj.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999905, sparseArray, -99999987, -99999985, Uri.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, contentValues);
        apply = this.xj.apply(sparseArray);
        return (Uri) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object apply;
        if (this.xj == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999904, sparseArray, -99999987, -99999985, Cursor.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, strArr);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr2);
        sparseArray.put(-7999925, str2);
        apply = this.xj.apply(sparseArray);
        return (Cursor) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Object apply;
        if (this.xj == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-7999907, sparseArray, -99999987, -99999985, Integer.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, contentValues);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr);
        apply = this.xj.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
