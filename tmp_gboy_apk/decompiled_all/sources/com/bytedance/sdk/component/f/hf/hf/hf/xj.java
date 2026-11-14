package com.bytedance.sdk.component.f.hf.hf.hf;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.hf.xj.xj.u;
import com.bytedance.sdk.component.f.hf.xj.xj.w;
import com.bytedance.sdk.component.f.xj.c;
import com.bytedance.sdk.component.f.xj.d;
import com.bytedance.sdk.component.f.xj.kd;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private Context hf;
    private d u;
    private kd w;
    private String xj;

    public xj(String str) {
        this.xj = str;
        c w = com.bytedance.sdk.component.f.hf.xj.w(str);
        this.w = w.w();
        this.u = w.u();
    }

    private kd hf() {
        if (this.w == null) {
            this.w = com.bytedance.sdk.component.f.hf.xj.w(this.xj).w();
        }
        return this.w;
    }

    private d w() {
        if (this.u == null) {
            this.u = com.bytedance.sdk.component.f.hf.xj.w(this.xj).u();
        }
        return this.u;
    }

    public static void xj(kd kdVar) {
        if (kdVar == null) {
            return;
        }
        try {
            ContentResolver hf = hf(kdVar);
            if (hf != null) {
                hf.getType(Uri.parse(w(kdVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x004e, code lost:
    
        if (r5.equals("adLogStop") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getType(android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.hf.hf.xj.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static ContentResolver hf(kd kdVar) {
        try {
            if (kdVar.getContext() != null) {
                return kdVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String w(kd kdVar) {
        return CtFAbx.B25kr6(AYUAbz.A5SV6n(u.xj(kdVar), "/"), "csj_mediation".equals(kdVar.kd()) ? "gromore_ad_log_event" : "ad_log_event", "/");
    }

    public static void xj(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (hfVar == null) {
            return;
        }
        try {
            ContentResolver hf = hf(kdVar);
            if (hf != null) {
                hf.getType(Uri.parse(w(kdVar) + "adLogDispatch?event=" + w.xj(hfVar.y())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w("dispatch event Throwable:" + th.toString(), kdVar);
        }
    }

    public static void xj(String str, List<String> list, boolean z, kd kdVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(w.xj(it.next()));
                sb.append(",");
            }
            String xj = w.xj(sb.toString());
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(xj) + "&replace=" + String.valueOf(z) + "&extraMate=" + w.xj(jSONObject.toString());
            ContentResolver hf = hf(kdVar);
            if (hf != null) {
                hf.getType(Uri.parse(w(kdVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void xj(String str, kd kdVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver hf = hf(kdVar);
            if (hf != null) {
                hf.getType(Uri.parse(w(kdVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(Context context) {
        this.hf = context;
    }

    public String xj() {
        return "csj_mediation".equals(this.xj) ? "gromore_ad_log_event" : "ad_log_event";
    }
}
