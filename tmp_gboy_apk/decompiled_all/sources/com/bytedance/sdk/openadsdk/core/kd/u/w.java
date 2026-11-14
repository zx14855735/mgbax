package com.bytedance.sdk.openadsdk.core.kd.u;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.kd.u.y;
import com.bytedance.sdk.openadsdk.core.pz;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements hf {

    /* renamed from: com.bytedance.sdk.openadsdk.core.kd.u.w$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[y.xj.hf.values().length];
            xj = iArr;
            try {
                iArr[y.xj.hf.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[y.xj.hf.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void hf(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, y.hf hfVar, boolean z, long j, y.xj xjVar, xj xjVar2) {
        if (xjVar.w() <= 0) {
            return;
        }
        Cursor query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (query != null) {
            if (xjVar.w() > 0 && query.getCount() >= xjVar.w()) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("uuid"));
                if (xjVar2 != null) {
                    xjVar2.xj(new y.hf(query.getString(query.getColumnIndex("meta_data")), query.getLong(query.getColumnIndex("create_time")), query.getLong(query.getColumnIndex("expire_time")), query.getString(query.getColumnIndex("uuid"))));
                }
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "rit=? AND uuid=?", new String[]{str, string});
            }
            query.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("uuid", hfVar.kd);
        contentValues.put("create_time", Long.valueOf(hfVar.xj));
        contentValues.put("meta_data", hfVar.w);
        contentValues.put("save_version", Integer.valueOf(hfVar.u));
        contentValues.put("expire_time", Long.valueOf(hfVar.hf));
        contentValues.put("slot_type", xjVar.xj());
        contentValues.put("is_using", Integer.valueOf(z ? 1 : 0));
        contentValues.put("priority", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), "meta_cache", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public y.hf xj(String str, y.xj xjVar, long j) {
        String string;
        long j2;
        long j3;
        Cursor xj = xj(xjVar, str);
        if (xj == null) {
            return null;
        }
        do {
            try {
                if (!xj.moveToNext()) {
                    return null;
                }
                string = xj.getString(xj.getColumnIndex("meta_data"));
                j2 = xj.getLong(xj.getColumnIndex("create_time"));
                j3 = xj.getLong(xj.getColumnIndex("expire_time"));
                if (j <= 0) {
                    break;
                }
            } finally {
                xj.close();
            }
        } while (j2 < j);
        y.hf hfVar = new y.hf(string, j2, j3, xj.getString(xj.getColumnIndex("uuid")));
        xj.close();
        return hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public y.hf xj(String str, y.xj xjVar, long j, List<String> list) {
        Cursor xj = xj(xjVar, str);
        if (xj == null) {
            return null;
        }
        while (xj.moveToNext()) {
            try {
                String string = xj.getString(xj.getColumnIndex("uuid"));
                if (string != null && list != null && list.contains(string)) {
                }
                String string2 = xj.getString(xj.getColumnIndex("meta_data"));
                long j2 = xj.getLong(xj.getColumnIndex("create_time"));
                long j3 = xj.getLong(xj.getColumnIndex("expire_time"));
                if (j <= 0 || j2 >= j) {
                    y.hf hfVar = new y.hf(string2, j2, j3, string);
                    xj.close();
                    return hfVar;
                }
            } catch (Throwable th) {
                xj.close();
                throw th;
            }
        }
        xj.close();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(y.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "slot_type =?", new String[]{xjVar.xj()});
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, y.xj xjVar, xj xjVar2) {
        Cursor query;
        long currentTimeMillis = System.currentTimeMillis();
        if (xjVar2 != null && (query = com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(currentTimeMillis), str}, null, null, null)) != null) {
            while (query.moveToNext()) {
                xjVar2.xj(new y.hf(query.getString(query.getColumnIndex("meta_data")), query.getLong(query.getColumnIndex("create_time")), query.getLong(query.getColumnIndex("expire_time")), query.getString(query.getColumnIndex("uuid"))));
            }
            query.close();
        }
        if (xjVar.hf()) {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7132", String.valueOf(currentTimeMillis)});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(currentTimeMillis)});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), "meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.u.hf
    public void xj(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), "meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    private Cursor xj(y.xj xjVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = AnonymousClass1.xj[xjVar.u().ordinal()];
        if (i == 1) {
            if (xjVar.hf()) {
                return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7132"}, null, null, "create_time DESC");
            }
            return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (i != 2) {
            if (xjVar.hf()) {
                return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7132"}, null, null, null);
            }
            return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, null);
        }
        if (xjVar.hf()) {
            return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str, "7132"}, null, null, "priority DESC");
        }
        return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(currentTimeMillis), str}, null, null, "priority DESC");
    }
}
