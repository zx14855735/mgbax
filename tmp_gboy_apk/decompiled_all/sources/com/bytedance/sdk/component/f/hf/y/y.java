package com.bytedance.sdk.component.f.hf.y;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements kd {
    private Context hf;
    private com.bytedance.sdk.component.f.xj.kd xj;

    public y(com.bytedance.sdk.component.f.xj.kd kdVar) {
        this.hf = kdVar.getContext();
        this.xj = kdVar;
    }

    public static String hf() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)";
    }

    public static String u() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String w() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    @Override // com.bytedance.sdk.component.f.hf.y.kd
    public void delete(u uVar) {
        com.bytedance.sdk.component.f.hf.xj.xj.hf.delete(this.hf, "trackurl", "id=?", new String[]{uVar.hf()}, this.xj);
    }

    @Override // com.bytedance.sdk.component.f.hf.y.kd
    public void insert(u uVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f13353a, uVar.hf());
        contentValues.put("url", uVar.w());
        contentValues.put("replaceholder", Integer.valueOf(uVar.u() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(uVar.kd()));
        contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.xj.hf(uVar.xj().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.f.hf.xj.xj.hf.insert(this.hf, "trackurl", contentValues, this.xj);
    }

    @Override // com.bytedance.sdk.component.f.hf.y.kd
    public void update(u uVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f13353a, uVar.hf());
        contentValues.put("url", uVar.w());
        contentValues.put("replaceholder", Integer.valueOf(uVar.u() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(uVar.kd()));
        contentValues.put(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.xj.hf(uVar.xj().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.f.hf.xj.xj.hf.update(this.hf, "trackurl", contentValues, "id=?", new String[]{uVar.hf()}, this.xj);
    }

    @Override // com.bytedance.sdk.component.f.hf.y.kd
    public List<u> xj() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor query = com.bytedance.sdk.component.f.hf.xj.xj.hf.query(this.hf, "trackurl", null, null, null, null, null, null, this.xj);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    try {
                        String string = query.getString(query.getColumnIndex(f.f13353a));
                        String string2 = query.getString(query.getColumnIndex("url"));
                        boolean z = query.getInt(query.getColumnIndex("replaceholder")) > 0;
                        int i = query.getInt(query.getColumnIndex("retry"));
                        String string3 = query.getString(query.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA));
                        int i2 = query.getInt(query.getColumnIndex("encrypt"));
                        if (i2 > 0) {
                            string3 = com.bytedance.sdk.component.utils.xj.w(string3);
                        }
                        try {
                            jSONObject = new JSONObject(string3);
                        } catch (Exception unused) {
                            jSONObject = null;
                        }
                        linkedList.add(new u(string, string2, z, i, jSONObject, i2));
                    } finally {
                        query.close();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return linkedList;
    }
}
