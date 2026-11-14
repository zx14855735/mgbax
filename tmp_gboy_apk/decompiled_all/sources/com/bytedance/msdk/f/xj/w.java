package com.bytedance.msdk.f.xj;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile w xj;
    private Uri hf;

    private w() {
        if (com.bytedance.msdk.core.hf.getContext() != null) {
            this.hf = Uri.parse("content://" + com.bytedance.msdk.core.hf.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform");
        }
    }

    public static w xj() {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.bytedance.msdk.core.hf.getContext() == null || this.hf == null) {
            return;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.hf.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADN_NAME, str);
        contentValues.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.hf, contentValues);
    }

    public List<hf> query(String str, String str2, long j, long j2) {
        String str3;
        if (com.bytedance.msdk.core.hf.getContext() == null || this.hf == null) {
            return null;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.hf.getContext().getContentResolver();
        String[] strArr = {str, str2, String.valueOf(j), String.valueOf(j2)};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, String.valueOf(j), String.valueOf(j2)};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
        }
        Cursor query = contentResolver.query(this.hf, null, str3, strArr, null);
        if (query == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (query.moveToNext()) {
            try {
                String string = query.getString(query.getColumnIndex(MediationConstant.EXTRA_ADN_NAME));
                String string2 = query.getString(query.getColumnIndex(MediationConstant.KEY_GM_PRIME_RIT));
                String string3 = query.getString(query.getColumnIndex("adn_rit"));
                String string4 = query.getString(query.getColumnIndex("ad_action"));
                long j3 = query.getLong(query.getColumnIndex("time_stamp"));
                hf hfVar = new hf();
                hfVar.w(string);
                hfVar.xj(string2);
                hfVar.hf(string3);
                hfVar.u(string4);
                hfVar.xj(j3);
                linkedList.add(hfVar);
            } finally {
                query.close();
            }
        }
        return linkedList;
    }

    public void xj(String str, long j) {
        if (com.bytedance.msdk.core.hf.getContext() == null || this.hf == null || j <= 0) {
            return;
        }
        try {
            com.bytedance.msdk.core.hf.getContext().getContentResolver().delete(this.hf, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j)});
        } catch (IllegalStateException unused) {
        }
    }
}
