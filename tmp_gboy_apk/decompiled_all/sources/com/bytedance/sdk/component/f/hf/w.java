package com.bytedance.sdk.component.f.hf;

import android.content.ContentValues;
import android.net.Uri;
import android.os.IInterface;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface w extends IInterface {
    int delete(Uri uri, String str, String[] strArr);

    String getType(Uri uri);

    String insert(Uri uri, ContentValues contentValues);

    Map query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
