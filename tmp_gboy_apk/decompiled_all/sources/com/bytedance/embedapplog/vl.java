package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.ContentValues;
import android.database.Cursor;
import com.fl.saas.base.cache.DatabaseHelper;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class vl implements Cloneable {

    /* renamed from: pl, reason: collision with root package name */
    private static final SimpleDateFormat f10110pl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String c;
    public int d;
    public String f;
    public long hf;
    public long kd;
    String p;
    public int tf;
    public String u;
    public long w;
    long xj;
    public String y;

    static {
        nLUi();
    }

    public vl() {
        xj(0L);
    }

    public static String hf(long j) {
        return f10110pl.format(new Date(j));
    }

    private static /* synthetic */ void nLUi() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public vl clone() {
        try {
            return (vl) super.clone();
        } catch (CloneNotSupportedException e) {
            cu.hf(e);
            return null;
        }
    }

    public String d() {
        return null;
    }

    public String f() {
        return "sid:" + this.u;
    }

    public abstract JSONObject hf();

    public final JSONObject kd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", u());
            xj(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            cu.hf(e);
            return jSONObject;
        }
    }

    public String toString() {
        String u = u();
        if (!getClass().getSimpleName().equalsIgnoreCase(u)) {
            StringBuilder A5SV6n2 = AYUAbz.A5SV6n(u, ", ");
            A5SV6n2.append(getClass().getSimpleName());
            u = A5SV6n2.toString();
        }
        String str = this.u;
        String str2 = "-";
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            str2 = str;
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("{", u, ", ");
        B3GDIM2.append(f());
        B3GDIM2.append(", ");
        B3GDIM2.append(str2);
        B3GDIM2.append(", ");
        B3GDIM2.append(this.hf);
        B3GDIM2.append("}");
        return B3GDIM2.toString();
    }

    public abstract String u();

    public final String w() {
        List<String> xj = xj();
        if (xj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("create table if not exists ");
        sb.append(u());
        sb.append("(");
        for (int i = 0; i < xj.size(); i += 2) {
            sb.append(xj.get(i));
            sb.append(" ");
            sb.append(xj.get(i + 1));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public void xj(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.hf = j;
    }

    public final JSONObject y() {
        try {
            this.p = hf(this.hf);
            return hf();
        } catch (JSONException e) {
            cu.hf(e);
            return null;
        }
    }

    public vl hf(JSONObject jSONObject) {
        this.hf = jSONObject.optLong("local_time_ms", 0L);
        this.xj = 0L;
        this.w = 0L;
        this.d = 0;
        this.kd = 0L;
        this.u = null;
        this.y = null;
        this.c = null;
        this.f = null;
        return this;
    }

    public List<String> xj() {
        return Arrays.asList(DatabaseHelper.COLUMN_ID, "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    public int xj(Cursor cursor) {
        this.xj = cursor.getLong(0);
        this.hf = cursor.getLong(1);
        this.w = cursor.getLong(2);
        this.d = cursor.getInt(3);
        this.kd = cursor.getLong(4);
        this.u = cursor.getString(5);
        this.y = cursor.getString(6);
        this.c = cursor.getString(7);
        this.f = cursor.getString(8);
        this.tf = cursor.getInt(9);
        return 10;
    }

    public final ContentValues hf(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        xj(contentValues);
        return contentValues;
    }

    public void xj(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hf));
        contentValues.put("tea_event_index", Long.valueOf(this.w));
        contentValues.put("nt", Integer.valueOf(this.d));
        contentValues.put("user_id", Long.valueOf(this.kd));
        contentValues.put("session_id", this.u);
        contentValues.put("user_unique_id", this.y);
        contentValues.put("ssid", this.c);
        contentValues.put("ab_sdk_version", this.f);
        contentValues.put("event_type", Integer.valueOf(this.tf));
    }

    public void xj(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.hf);
    }

    public static vl xj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return h.hf.get(jSONObject.optString("k_cls", "")).clone().hf(jSONObject);
        } catch (Throwable th) {
            cu.hf(th);
            return null;
        }
    }
}
