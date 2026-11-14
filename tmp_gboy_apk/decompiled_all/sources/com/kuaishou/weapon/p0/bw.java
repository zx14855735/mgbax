package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class bw {
    private static final byte[] d = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private Context f12225a;
    private boolean b;
    private int c;

    static {
        rnnzbBU();
    }

    public bw(Context context, int i, boolean z) {
        this.f12225a = context;
        this.b = z;
        this.c = i;
    }

    private static /* synthetic */ void rnnzbBU() {
        char[] charArray = "ÔØÚ\u0099ÐÖÚÒ\u0099ÕØÎ\u0099ÄßÒÛÛ\u0099ýÙÞõÅÞÓÐÒ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 183);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÔÛÞÙÞÃ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 183);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x054d: RETURN (r16 I:org.json.JSONObject) A[SYNTHETIC], block:B:161:? */
    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            h a2 = h.a(this.f12225a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            jSONObject3.put("11006", e ? 1 : 0);
            jSONObject3.put("11029", e2 ? 1 : 0);
            if (a2.b(df.au, 1) == 1 && (e || e2)) {
                String a3 = bh.a(this.f12225a);
                if (!TextUtils.isEmpty(a3) && !a3.startsWith("RISK")) {
                    jSONObject3.put("01001", f.a(a3));
                }
                String c = bh.c(this.f12225a);
                if (!TextUtils.isEmpty(c) && !c.startsWith("RISK")) {
                    jSONObject3.put("01003", c);
                }
                String b = bh.b(this.f12225a, 0);
                if (!TextUtils.isEmpty(b) && !b.startsWith("RISK")) {
                    jSONObject3.put("01019", b);
                }
                String b2 = bh.b(this.f12225a, 1);
                if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                    jSONObject3.put("01004", f.a(b2));
                }
            }
            int b3 = a2.b(df.at, 1);
            if (b3 == 1 && (e || e2)) {
                String f = bh.f(this.f12225a);
                if (!TextUtils.isEmpty(f) && !f.startsWith("RISK")) {
                    jSONObject3.put("01013", f);
                }
            }
            if (a2.b(df.av, 1) == 1 && (e || e2)) {
                String d2 = bh.d(this.f12225a);
                if (!TextUtils.isEmpty(d2) && !d2.startsWith("RISK")) {
                    jSONObject3.put("01007", d2);
                }
            }
            if (a2.b(df.aw, 1) == 1 && (e || e2)) {
                jSONObject3.put("01011", bh.e(this.f12225a));
            }
            if (e || e2) {
                String h = bh.h();
                if (!TextUtils.isEmpty(h) && !h.startsWith("RISK")) {
                    jSONObject3.put("07005", h);
                } else if (h == null) {
                    jSONObject3.put("07005", "");
                } else {
                    jSONObject3.put("07005", h);
                }
                jSONObject3.put("07006", bh.g());
            }
            if (a2.b(df.ay, 1) == 1 && (e || e2)) {
                String p = bh.p(this.f12225a);
                if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                    jSONObject3.put("01016", p);
                }
            }
            if (e || e2) {
                try {
                    double b4 = bh.b();
                    if (b4 > 0.0d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b4);
                        jSONObject3.put("09002", sb.toString());
                    }
                    double c2 = bh.c();
                    if (c2 > 0.0d) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(c2);
                        jSONObject3.put("09003", sb2.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject3.put("11013", Integer.parseInt(bx.a(this.f12225a.getApplicationContext()), 2));
            jSONObject3.put("11012", bx.b(this.f12225a));
            try {
                jSONObject3.put("11202", bh.b(com.kwad.sdk.e.b.Oe().NU()));
                jSONObject3.put("11204", bh.b(com.kwad.sdk.e.b.Oe().Oa()));
                jSONObject3.put("11205", bh.b(com.kwad.sdk.e.b.Oe().getDeviceId()));
                jSONObject3.put("11206", bh.b(com.kwad.sdk.e.b.Oe().getIccId()));
                jSONObject3.put("11207", bh.b(com.kwad.sdk.e.b.Oe().getIMEI()));
                jSONObject3.put("11208", bh.b(com.kwad.sdk.e.b.Oe().NV()));
                jSONObject3.put("11209", bh.b(com.kwad.sdk.e.b.Oe().NW()));
                jSONObject3.put("11210", bh.b(com.kwad.sdk.e.b.Oe().NX()));
                jSONObject3.put("11211", bh.b(com.kwad.sdk.e.b.Oe().getIp()));
                jSONObject3.put("11212", bh.b(com.kwad.sdk.e.b.Oe().getLocation()));
                jSONObject3.put("11213", bh.b(com.kwad.sdk.e.b.Oe().getOaid()));
                jSONObject3.put("11214", bh.b(com.kwad.sdk.e.b.Oe().getMac()));
                jSONObject3.put("11215", bh.b(com.kwad.sdk.e.b.Oe().NZ()));
                jSONObject3.put("11216", bh.b(com.kwad.sdk.e.b.Oe().NY()));
                jSONObject3.put("11301", bh.c(com.kwad.sdk.e.b.Oe().Od()));
                jSONObject3.put("11302", bh.c(com.kwad.sdk.e.b.Oe().getSdkVersion()));
                jSONObject3.put("11303", bh.c(com.kwad.sdk.e.b.Oe().getAppId()));
                jSONObject3.put("11104", com.kwad.sdk.e.b.Oe().Oa());
                jSONObject3.put("11105", com.kwad.sdk.e.b.Oe().getDeviceId());
                jSONObject3.put("11106", com.kwad.sdk.e.b.Oe().getIccId());
                jSONObject3.put("11107", com.kwad.sdk.e.b.Oe().getIMEI());
                jSONObject3.put("11108", com.kwad.sdk.e.b.Oe().NV());
                jSONObject3.put("11109", com.kwad.sdk.e.b.Oe().NW());
                jSONObject3.put("11110", com.kwad.sdk.e.b.Oe().NX());
                jSONObject3.put("11111", com.kwad.sdk.e.b.Oe().getIp());
                jSONObject3.put("11112", com.kwad.sdk.e.b.Oe().getLocation());
                jSONObject3.put("11113", com.kwad.sdk.e.b.Oe().getOaid());
                jSONObject3.put("11114", com.kwad.sdk.e.b.Oe().getMac());
                jSONObject3.put("11115", com.kwad.sdk.e.b.Oe().NZ());
                jSONObject3.put("11116", com.kwad.sdk.e.b.Oe().NY());
            } catch (Throwable unused2) {
            }
            String w = bh.w(this.f12225a);
            if (!TextUtils.isEmpty(w)) {
                jSONObject3.put("01026", w);
            }
            if (b3 == 1) {
                try {
                    Object a4 = ai.a(this.f12225a);
                    if (a4 != null) {
                        jSONObject3.put("11015", a4);
                    }
                    try {
                        if (Engine.loadSuccess) {
                            jSONObject2 = null;
                            ce ceVar = new ce(this.f12225a);
                            jSONObject3.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                            jSONObject3.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                            jSONObject3.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                            jSONObject3.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                            jSONObject3.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                            jSONObject3.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                            jSONObject3.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                            jSONObject3.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                            jSONObject3.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                            jSONObject3.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                        } else {
                            jSONObject2 = null;
                            jSONObject3.put("02001", bl.a());
                            jSONObject3.put("02002", bl.b());
                            jSONObject3.put("02003", bl.c());
                            jSONObject3.put("02004", bl.d());
                            jSONObject3.put("02005", bl.e());
                            jSONObject3.put("02006", bl.f());
                            jSONObject3.put("02007", bl.g());
                            jSONObject3.put("02018", bl.s());
                            jSONObject3.put("02013", bl.m());
                            jSONObject3.put("02016", bl.q());
                        }
                        jSONObject3.put("02021", bl.d(this.f12225a));
                        jSONObject3.put("02022", bl.c(this.f12225a));
                        jSONObject3.put("02044", bl.t());
                        jSONObject3.put("11009", bs.a(this.f12225a.getApplicationContext()));
                        if (Engine.loadSuccess) {
                            bz bzVar = new bz(this.f12225a);
                            jSONObject3.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : "");
                            jSONObject3.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : "");
                            jSONObject3.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : "");
                            jSONObject3.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : "");
                        } else {
                            try {
                                bj b5 = bk.b();
                                jSONObject3.put("04001", bk.a());
                                jSONObject3.put("04002", b5.b());
                                jSONObject3.put("04003", b5.c());
                                jSONObject3.put("04004", b5.a());
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        return jSONObject;
                    }
                } catch (Throwable unused5) {
                    return null;
                }
            } else {
                jSONObject2 = null;
            }
            try {
                if (this.b) {
                    jSONObject3.put("20004", 1);
                }
                jSONObject3.put("11017", jSONObject3.toString().length());
                jSONObject3.put("20000", this.c);
                jSONObject3.put("11028", WeaponHI.sKSSdkver);
                return jSONObject3;
            } catch (Throwable unused6) {
                return jSONObject2;
            }
        } catch (Throwable unused7) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (d) {
                try {
                    JSONObject a2 = new cm(str, ck.l).a(this.f12225a);
                    if (a2 == null) {
                        return null;
                    }
                    JSONObject a3 = a();
                    if (a3 == null) {
                        return null;
                    }
                    a2.put("module_section", a3);
                    return a2.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
