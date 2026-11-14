package com.bytedance.sdk.component.f.hf.xj.xj.hf;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends hf {
    protected com.bytedance.sdk.component.f.xj.kd hf;
    private com.bytedance.sdk.component.f.hf.u.hf.xj kd;
    private final Context u;
    protected List<String> w;

    public y(Context context, com.bytedance.sdk.component.f.hf.u.hf.xj xjVar, com.bytedance.sdk.component.f.xj.kd kdVar) {
        super(context, kdVar, xjVar == null ? com.bytedance.sdk.component.f.hf.u.hf.xj.w() : xjVar);
        this.w = new ArrayList();
        this.u = context;
        this.kd = xjVar;
        this.hf = kdVar;
        if (xjVar == null) {
            this.kd = com.bytedance.sdk.component.f.hf.u.hf.xj.w();
        }
    }

    public static String kd(String str) {
        return CtFAbx.BI9f7h("ALTER TABLE ", str, " ADD COLUMN encrypt INTEGER default 0");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    public String delete(List<com.bytedance.sdk.component.f.xj.hf> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.bytedance.sdk.component.f.hf.w.xj.xj(list, this.hf, xj());
        String xj = com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "DELETE FROM " + xj() + " WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) linkedList, 1000, true), this.hf);
        xj(linkedList);
        return xj;
    }

    public byte hf() {
        return (byte) 2;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public com.bytedance.sdk.component.f.xj.kd u() {
        return this.hf;
    }

    public byte w() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return com.bytedance.sdk.component.f.hf.w.xj.w(hfVar);
    }

    private void u(List<com.bytedance.sdk.component.f.xj.hf> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.f.xj.hf> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().w());
        }
        com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "UPDATE " + xj() + " SET retry = retry+1 WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) linkedList, 1000, true), this.hf);
    }

    public String w(List<String> list) {
        xj();
        list.size();
        String xj = com.bytedance.sdk.component.f.hf.xj.xj.hf.xj(getContext(), "DELETE FROM " + xj() + " WHERE " + xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, (List<?>) list, 1000, true), this.hf);
        com.bytedance.sdk.component.f.hf.w.hf.xj(com.bytedance.sdk.component.f.hf.hf.hf.xj.qt(), list.size(), this.hf);
        xj(list);
        return xj;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public String xj() {
        com.bytedance.sdk.component.f.xj.y hf = this.hf.hf();
        if (hf != null) {
            return hf.hf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, String str, int i2, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String string;
        String string2;
        int i3;
        long xj = com.bytedance.sdk.component.f.hf.hf.xj.xj(i, getContext(), this.hf);
        com.bytedance.sdk.component.f.hf.w.w.hf(xj() + " query db max :" + xj + " limit:" + i, this.hf);
        if (xj <= 0) {
            xj = 1;
        } else if (xj > 100) {
            xj = 100;
        }
        String str2 = str + " DESC limit " + xj;
        ArrayList arrayList3 = new ArrayList();
        this.w.clear();
        ArrayList arrayList4 = arrayList3;
        Cursor query = com.bytedance.sdk.component.f.hf.xj.xj.hf.query(getContext(), xj(), new String[]{com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, "value", "encrypt", "retry"}, null, null, null, null, str2, this.hf);
        if (query != null) {
            try {
                com.bytedance.sdk.component.f.xj.u u = this.hf.u();
                while (query.moveToNext()) {
                    try {
                        string = query.getString(query.getColumnIndex(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
                        string2 = query.getString(query.getColumnIndex("value"));
                        int i4 = query.getInt(query.getColumnIndex("encrypt"));
                        i3 = query.getInt(query.getColumnIndex("retry"));
                        if (i4 == 1) {
                            string2 = u.xj(string2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        arrayList2 = arrayList4;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.w.add(string);
                    } else {
                        if (arrayList4.size() > 100) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(string2);
                        String optString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                        if (!TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject2 = new JSONObject(optString);
                            jSONObject2.put("retry_count", i3);
                            jSONObject2.put("db_rd", System.currentTimeMillis());
                            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                        }
                        com.bytedance.sdk.component.f.hf.u.xj.xj xjVar = new com.bytedance.sdk.component.f.hf.u.xj.xj(string, jSONObject);
                        xjVar.xj(w());
                        xjVar.hf(hf());
                        com.bytedance.sdk.component.f.hf.w.xj.xj(jSONObject, xjVar, this.hf, i3);
                        arrayList2 = arrayList4;
                        try {
                            arrayList2.add(xjVar);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.bytedance.sdk.component.f.hf.w.w.w(th.getMessage(), this.hf);
                                arrayList4 = arrayList2;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    query.close();
                                    if (!this.w.isEmpty()) {
                                        w(this.w);
                                        this.w.clear();
                                    }
                                    if (com.bytedance.sdk.component.f.hf.w.xj.xj(i2) && !z) {
                                        xj(arrayList2, 5, bn.d);
                                    }
                                } catch (Exception unused) {
                                }
                                throw th;
                            }
                        }
                        arrayList4 = arrayList2;
                    }
                }
                arrayList = arrayList4;
                try {
                    query.close();
                    if (!this.w.isEmpty()) {
                        w(this.w);
                        this.w.clear();
                    }
                    if (com.bytedance.sdk.component.f.hf.w.xj.xj(i2) && !z) {
                        xj(arrayList, 5, bn.d);
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th4) {
                th = th4;
                arrayList2 = arrayList4;
            }
        } else {
            arrayList = arrayList4;
        }
        com.bytedance.sdk.component.f.hf.w.w.hf(xj() + " query db actually size :" + arrayList.size(), this.hf);
        return arrayList;
    }

    public static String u(String str) {
        return CtFAbx.BI9f7h("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.w
    public List<com.bytedance.sdk.component.f.xj.hf> xj(String str, int i, boolean z) {
        com.bytedance.sdk.component.f.hf.u.hf.xj xjVar = this.kd;
        if (xjVar == null) {
            return new ArrayList();
        }
        return xj(xjVar.hf(), str, i, z);
    }

    private void xj(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context context = getContext();
        String xj = xj();
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        com.bytedance.sdk.component.f.hf.xj.xj.hf.delete(context, xj, "gen_time <? OR retry >?", new String[]{sb2, sb3.toString()}, this.hf);
    }

    public void xj(List<com.bytedance.sdk.component.f.xj.hf> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            u(list);
            xj(i, j);
        } catch (Exception unused) {
        }
    }

    private static String xj(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String xj = xj(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            A2egSU.BIYEnU(sb, str, str2, "('", xj);
            sb.append("')");
        }
        return xj(sb.toString(), CtFAbx.AlLFFp(str, str2, "('')"));
    }

    private static String xj(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
