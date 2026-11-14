package com.bytedance.sdk.openadsdk.core.qt;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static final hf xj = new hf();

    static {
        yUBb();
    }

    private static /* synthetic */ void yUBb() {
        char[] charArray = "_SQ\u0012[]QY\u0012^SE\u0012OTYPP\u0012vRU~NUX[Y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '<');
        }
        String str = new String(charArray);
        char[] charArray2 = "_PURUH".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '<');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void insert(xj xjVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(xjVar.d()));
        contentValues.put("dev2", Long.valueOf(xjVar.tf()));
        contentValues.put("dev3", Long.valueOf(xjVar.p()));
        contentValues.put("dev4", Long.valueOf(xjVar.pl()));
        contentValues.put("dev5", Integer.valueOf(xjVar.g()));
        contentValues.put("dev6", Long.valueOf(xjVar.f()));
        contentValues.put("dev7", Long.valueOf(xjVar.xj()));
        contentValues.put("dev8", Long.valueOf(xjVar.hf()));
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), "sdk_launch", contentValues);
    }

    public List<xj> xj(long j) {
        ArrayList arrayList;
        xj xjVar;
        long j2 = j - 518400000;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "sdk_launch", null, "dev1 > ?", new String[]{String.valueOf(j2)}, null, null, "dev1 DESC");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        long j3 = cursor.getLong(cursor.getColumnIndex("dev1"));
                        long j4 = cursor.getLong(cursor.getColumnIndex("dev2"));
                        long j5 = cursor.getLong(cursor.getColumnIndex("dev3"));
                        long j6 = cursor.getLong(cursor.getColumnIndex("dev4"));
                        long j7 = cursor.getLong(cursor.getColumnIndex("dev5"));
                        long j8 = cursor.getLong(cursor.getColumnIndex("dev6"));
                        long j9 = cursor.getLong(cursor.getColumnIndex("dev7"));
                        ArrayList arrayList3 = arrayList2;
                        try {
                            long j10 = cursor.getLong(cursor.getColumnIndex("dev8"));
                            xjVar = new xj();
                            xjVar.u(j3);
                            xjVar.kd(j4);
                            xjVar.y(j5);
                            xjVar.c(j6);
                            xjVar.hf((int) j7);
                            xjVar.w(j8);
                            xjVar.xj(j9);
                            xjVar.hf(j10);
                            arrayList = arrayList3;
                        } catch (Exception e) {
                            e = e;
                            arrayList = arrayList3;
                        }
                        try {
                            arrayList.add(xjVar);
                            arrayList2 = arrayList;
                        } catch (Exception e2) {
                            e = e2;
                            pl.xj(e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return arrayList;
                        }
                    }
                }
                arrayList = arrayList2;
                if (cursor != null) {
                    return arrayList;
                }
            } catch (Exception e3) {
                e = e3;
                arrayList = arrayList2;
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(w.kd().d() - 2592000000L)});
    }
}
