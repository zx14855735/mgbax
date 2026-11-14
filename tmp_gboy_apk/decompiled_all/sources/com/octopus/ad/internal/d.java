package com.octopus.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashSet<String> f12429a;
    private WeakReference<Context> b;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;
    private long i;
    private long j;
    private String q;
    private boolean r;
    private String u;
    private p c = p.PREFETCH;
    private int k = 3;
    private boolean l = false;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private boolean s = false;
    private boolean t = false;

    public d(Context context, String str) {
        this.u = "";
        this.b = new WeakReference<>(context);
        this.u = str;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public Context b() {
        if (this.b.get() != null) {
            return this.b.get();
        }
        return null;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return TextUtils.isEmpty(this.f) ? this.u : this.f;
    }

    public String f() {
        return this.g;
    }

    public long g() {
        return this.i;
    }

    public long h() {
        return this.h;
    }

    public long i() {
        return this.j;
    }

    public int j() {
        return -1;
    }

    public int k() {
        return -1;
    }

    public boolean l() {
        return this.r;
    }

    public int m() {
        return this.o;
    }

    public int n() {
        return this.p;
    }

    public boolean o() {
        return this.l;
    }

    public p p() {
        return this.c;
    }

    public boolean q() {
        if (q.a().n != null && !StringUtil.isEmpty(q.a().i()) && !StringUtil.isEmpty(this.d)) {
            return true;
        }
        HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.no_identification));
        return false;
    }

    public String r() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = b().getResources().getConfiguration().orientation == 2 ? "h" : com.kuaishou.weapon.p0.t.c;
            this.q = str;
            if (!StringUtil.isEmpty(str)) {
                jSONObject.put("mOrientation", this.q);
            }
            if (this.m > 0 && this.n > 0) {
                jSONObject.put("size", this.m + "x" + this.n);
            }
            int n = n();
            int m = m();
            if (n > 0 && m > 0) {
                p pVar = this.c;
                p pVar2 = p.INTERSTITIAL;
                if (!pVar.equals(pVar2) && (this.m < 0 || this.n < 0)) {
                    jSONObject.put("max_size", m + "x" + n);
                } else if (this.c.equals(pVar2)) {
                    jSONObject.put("size", m + "x" + n);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            HaoboLog.e(HaoboLog.jsonLogTag, "Failed to encode adUnitParams, err = " + e.getMessage());
            return "";
        }
    }

    public String a() {
        return this.u;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(long j) {
        this.j = j;
    }

    public void a(long j) {
        this.i = j;
    }

    public void b(long j) {
        this.h = j;
    }

    public void c(int i) {
        this.p = i;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public void a(p pVar) {
        this.c = pVar;
    }

    public void b(int i) {
        this.o = i;
    }
}
