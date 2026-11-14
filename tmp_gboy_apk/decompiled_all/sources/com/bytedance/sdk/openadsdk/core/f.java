package com.bytedance.sdk.openadsdk.core;

import ADYaiT.CtFAbx;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.zg.w.w.u;
import com.bytedance.sdk.openadsdk.zg.w.w.w;
import com.kuaishou.weapon.p0.bi;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.status.SDKStatus;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    public static final com.bytedance.sdk.openadsdk.zg.w.w.u xj = new xj();

    /* renamed from: a, reason: collision with root package name */
    private String f10352a;
    private int ai;
    private volatile com.bytedance.sdk.openadsdk.core.a.xj am;
    private u b;
    private volatile String c;
    private volatile int d;
    private HashMap<String, Object> dk;
    private String e;
    private kd en;
    private boolean et;
    private Map<String, Object> eu;
    private volatile com.bytedance.sdk.openadsdk.core.ai.xj f;
    private volatile String ff;
    private Bitmap g;
    private volatile String hf;
    private volatile int ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10353io;
    private long j;
    private Function<SparseArray<Object>, Object> jk;
    private volatile String kd;
    private boolean l;
    private String n;
    private final Set<Integer> p;

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f10354pl;
    private volatile boolean pz;
    private int q;
    private volatile com.bytedance.sdk.openadsdk.zg.w.w.u qt;
    private String r;
    private volatile JSONObject ra;
    private volatile boolean tf;
    private com.bytedance.sdk.openadsdk.core.playable.u tj;
    private volatile boolean u;
    private volatile boolean v;
    private volatile String w;
    private String wo;
    private volatile boolean ws;
    private volatile Function<SparseArray<Object>, Object> x;
    private volatile String y;
    private volatile boolean yo;
    private int z;
    private String zg;

    public static class hf {
        private static f xj = new f();

        static {
            wDDuY();
        }

        private static /* synthetic */ void wDDuY() {
            char[] charArray = "L@B\u0001HNBJ\u0001M@V\u0001\\GJCC\u0001eAFm]FKHJ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '/');
            }
            String str = new String(charArray);
            char[] charArray2 = "LCFAF[".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '/');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class u {
        private String hf;
        private Map<String, Object> xj;

        public u(Map<String, Object> map, String str) {
            this.xj = map;
            this.hf = str;
        }

        public void xj(JSONObject jSONObject) {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.xj) == null || map.size() == 0 || TextUtils.isEmpty(this.hf)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.xj.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.hf));
        }
    }

    public static class w {
        public static final com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.a.j.xj("sp_global_info");

        static {
            RUrSV();
        }

        private static /* synthetic */ void RUrSV() {
            char[] charArray = "s\u007f}>wq}u>r\u007fi>cxu||>Z~yRbytwu".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 16);
            }
            String str = new String(charArray);
            char[] charArray2 = "s|y~yd".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 16);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static final class xj extends com.bytedance.sdk.openadsdk.zg.w.w.u {
        public xj() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean c() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public com.bytedance.sdk.openadsdk.zg.w.w.w d() {
            String[] split;
            String xj = com.bytedance.sdk.openadsdk.tools.hf.xj(8, "");
            if (TextUtils.isEmpty(xj) || (split = xj.split(",")) == null) {
                return null;
            }
            String str = split.length > 0 ? split[0] : "";
            String str2 = split.length > 1 ? split[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new w.xj().xj(Double.valueOf(str).doubleValue()).hf(Double.valueOf(str2).doubleValue()).xj();
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean f() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(24, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean g() {
            return true;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean hf() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(17, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean kd() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public String p() {
            return com.bytedance.sdk.openadsdk.tools.hf.xj(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public String pl() {
            return com.bytedance.sdk.openadsdk.tools.hf.xj(13, "");
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public String tf() {
            return com.bytedance.sdk.openadsdk.tools.hf.xj(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean u() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean w() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(9, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean xj() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.w.u
        public boolean y() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.hf.xj(22, "1"));
        }
    }

    static {
        EzqN();
    }

    private static /* synthetic */ void EzqN() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static com.bytedance.sdk.openadsdk.zg.w.w.u gj() {
        return new u.xj().hf(true).xj(true).xj((com.bytedance.sdk.openadsdk.zg.w.w.w) null).w(true).xj((String) null).u(true).hf((String) null).kd(true).w((String) null).y(true).u((String) null).c(false).xj();
    }

    public static Object ss() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(invoke);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return declaredField3.get(obj);
                }
            }
            return null;
        }
        return null;
    }

    public static f zg() {
        return hf.xj;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.r)) {
            return this.r;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                this.r = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int ai() {
        return com.bytedance.sdk.openadsdk.core.multipro.hf.w() ? w.xj.get("title_bar_theme", 0) : this.d;
    }

    public void am() {
        qt();
        Context context = pz.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.y.xj.xj(context);
        }
        this.p.add(4);
        w(context);
    }

    public Function<SparseArray<Object>, Object> aq() {
        return this.x;
    }

    public com.bytedance.sdk.openadsdk.core.playable.u b() {
        if (this.tj == null) {
            this.tj = new com.bytedance.sdk.openadsdk.core.playable.u(10, 8);
        }
        return this.tj;
    }

    public String bl() {
        try {
            if ((pz.hf().vi() & 1) == 1) {
                return com.bytedance.sdk.openadsdk.core.w.kd.xj().kd();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean c() {
        return this.ws;
    }

    public boolean d() {
        return tf() && com.bytedance.sdk.openadsdk.core.u.xj.w();
    }

    public boolean dc() {
        return this.v;
    }

    public String dk() {
        return !TextUtils.isEmpty(this.kd) ? this.kd : com.bytedance.sdk.openadsdk.core.w.u.xj().y("");
    }

    public int dq() {
        return this.z;
    }

    public com.bytedance.sdk.openadsdk.zg.w.w.u e() {
        return new io(v());
    }

    public JSONObject en() {
        if (ai.hf()) {
            zg().wo();
        }
        return this.ra;
    }

    public com.bytedance.sdk.openadsdk.core.ai.xj et() {
        return this.f;
    }

    public Bitmap eu() {
        return com.bytedance.sdk.openadsdk.core.multipro.hf.w() ? com.bytedance.sdk.component.utils.u.xj(w.xj.get("pause_icon", "")) : this.g;
    }

    public boolean f() {
        return com.bytedance.sdk.openadsdk.qt.w.xj().y();
    }

    public String ff() {
        if (!TextUtils.isEmpty(this.f10352a)) {
            return this.f10352a;
        }
        try {
            Object invoke = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (invoke instanceof String) {
                String str = (String) invoke;
                this.f10352a = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.qt.w.xj().u();
    }

    public String gh() {
        return w.xj.get("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public String gy() {
        return w.xj.get("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/basic_info.html");
    }

    public String hf() {
        if (TextUtils.isEmpty(this.ff)) {
            this.ff = com.bytedance.sdk.openadsdk.core.pl.d.xj();
        }
        return this.ff;
    }

    public boolean hl() {
        return "5001121".equals(this.hf);
    }

    public String ht() {
        return !TextUtils.isEmpty(this.w) ? this.w : com.bytedance.sdk.openadsdk.core.w.u.xj().kd();
    }

    public String io() {
        return !TextUtils.isEmpty(this.y) ? this.y : com.bytedance.sdk.openadsdk.core.w.u.xj().f("");
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.w.u.xj().hf(this.ht);
        com.bytedance.sdk.openadsdk.core.w.u.xj().xj(this.hf);
        com.bytedance.sdk.openadsdk.core.w.u.xj().hf(this.w);
        com.bytedance.sdk.openadsdk.core.w.u.xj().hf(this.u);
        com.bytedance.sdk.openadsdk.core.w.u.xj().kd(this.kd);
        com.bytedance.sdk.openadsdk.core.w.u.xj().c(this.y);
        com.bytedance.sdk.openadsdk.core.w.u.xj().d(xj(this.dk));
        com.bytedance.sdk.component.u.hf.w wVar = w.xj;
        wVar.put("title_bar_theme", this.d);
        wVar.put("allow_show_notify", this.tf);
        com.bytedance.sdk.openadsdk.core.w.u.xj().u(this.f10354pl);
        Set<Integer> set = this.p;
        if (set == null || set.isEmpty()) {
            wVar.remove("network_state");
            return;
        }
        Iterator<Integer> it = this.p.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        w.xj.put("network_state", sb.toString());
    }

    public boolean jk() {
        return w.xj.get("sdk_activate_init", true);
    }

    public boolean kd() {
        return com.bytedance.sdk.openadsdk.qt.w.xj().kd();
    }

    public String l() {
        if (!TextUtils.isEmpty(this.wo)) {
            return this.wo;
        }
        try {
            AtomicBoolean atomicBoolean = KsAdSDK.sHasInit;
            Object invoke = KsAdSDK.class.getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (invoke instanceof String) {
                String str = (String) invoke;
                this.wo = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public Object lw() {
        WeakReference<Activity> xj2 = this.am.xj();
        if (xj2 != null) {
            return xj2.get();
        }
        Object apply = this.x != null ? this.x.apply(A2egSU.ARc23Z(14, Activity.class)) : null;
        return apply == null ? ss() : apply;
    }

    public String n() {
        if (!com.bytedance.sdk.openadsdk.core.w.w.xj().hf()) {
            return TextUtils.isEmpty(this.zg) ? "" : this.zg;
        }
        String str = w.xj.get("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public u nb() {
        return this.b;
    }

    public String op() {
        return w.xj.get("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/ad_preview.html");
    }

    public boolean p() {
        return com.bytedance.sdk.openadsdk.qt.w.xj().c();
    }

    public boolean pl() {
        return com.bytedance.sdk.openadsdk.qt.w.xj().f();
    }

    public String pz() {
        return !TextUtils.isEmpty(this.hf) ? this.hf : com.bytedance.sdk.openadsdk.core.w.u.xj().u();
    }

    public boolean q() {
        return com.bytedance.sdk.openadsdk.core.multipro.hf.w() ? w.xj.get("allow_show_notify", true) : this.tf;
    }

    public long qd() {
        return this.j;
    }

    public void qt() {
        this.ws = com.bytedance.sdk.openadsdk.core.u.xj.hf();
    }

    public Function<SparseArray<Object>, Object> r() {
        Function<SparseArray<Object>, Object> function = this.jk;
        if (function != null) {
            return function;
        }
        if (com.bytedance.sdk.openadsdk.zg.w.u.hf(ai.w)) {
            this.jk = com.bytedance.sdk.openadsdk.core.pl.u.zg.xj(pz.getContext());
        } else {
            this.jk = y(3);
        }
        return this.jk;
    }

    public boolean ra() {
        return com.bytedance.sdk.openadsdk.core.w.w.xj().hf() ? com.bytedance.sdk.openadsdk.core.w.u.xj().xj(this.u) : this.u;
    }

    public String s() {
        return this.c;
    }

    public boolean tf() {
        return !p() && f();
    }

    public int tj() {
        if (!com.bytedance.sdk.openadsdk.core.w.w.xj().hf()) {
            return this.ht;
        }
        int y = com.bytedance.sdk.openadsdk.core.w.u.xj().y();
        return y == Integer.MIN_VALUE ? this.ht : y;
    }

    public boolean tu() {
        return this.l;
    }

    public com.bytedance.sdk.openadsdk.core.a.xj u() {
        if (this.am == null) {
            w(pz.getContext());
        }
        return this.am;
    }

    public com.bytedance.sdk.openadsdk.zg.w.w.u v() {
        if (this.qt == null || this.qt.g()) {
            this.qt = yy() ? xj : gj();
        }
        return this.qt;
    }

    public String vm() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        String str = xj2.get("any_door_id", (String) null);
        this.e = str;
        if (!TextUtils.isEmpty(str)) {
            return this.e;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        xj2.put("any_door_id", valueOf);
        this.e = valueOf;
        return valueOf;
    }

    public boolean w() {
        Object systemService;
        boolean isRequestPinShortcutSupported;
        if (!this.f10353io && Build.VERSION.SDK_INT >= 26) {
            this.f10353io = true;
            try {
                systemService = pz.getContext().getSystemService((Class<Object>) Cd8JRx.A2egSU.AYUAbz());
                ShortcutManager ASJ6gh2 = Cd8JRx.A2egSU.ASJ6gh(systemService);
                if (ASJ6gh2 != null) {
                    isRequestPinShortcutSupported = ASJ6gh2.isRequestPinShortcutSupported();
                    this.et = isRequestPinShortcutSupported;
                }
            } catch (Throwable unused) {
            }
        }
        return this.et;
    }

    public boolean wa() {
        com.bytedance.sdk.component.u.hf.w wVar = w.xj;
        if (wVar.get("update_advance_preview_mode", false)) {
            long j = wVar.get("update_advance_preview_mode_time", -1L);
            if (j != -1) {
                if (System.currentTimeMillis() - j <= bi.s) {
                    return true;
                }
                d(false);
            }
        }
        return false;
    }

    public int wn() {
        return com.bytedance.sdk.openadsdk.core.w.u.xj().u(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void wo() {
        /*
            r7 = this;
            java.lang.String r0 = "gdt_version"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = r7.ff()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L27
            java.lang.String r3 = r7.l()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L25
            java.lang.String r3 = r7.a()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L27
        L25:
            java.lang.String r2 = "1.0.0"
        L27:
            r1.put(r0, r2)     // Catch: org.json.JSONException -> L2b
            goto L2c
        L2b:
        L2c:
            java.lang.String r2 = "com.byted.mixed"
            int r3 = com.bytedance.sdk.openadsdk.x.p.w(r2)
            if (r3 == 0) goto L72
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
        L46:
            int r6 = r3.length()
            if (r5 >= r6) goto L63
            char r6 = r3.charAt(r5)
            r4.append(r6)
            int r6 = r3.length()
            int r6 = r6 + (-1)
            if (r5 == r6) goto L60
            java.lang.String r6 = "."
            r4.append(r6)
        L60:
            int r5 = r5 + 1
            goto L46
        L63:
            java.lang.String r3 = r4.toString()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L72
            java.lang.String r3 = r4.toString()
            goto L74
        L72:
            java.lang.String r3 = "1.0.0.0"
        L74:
            boolean r0 = r1.has(r0)
            if (r0 == 0) goto L97
            java.lang.String r0 = "app_id"
            java.lang.String r4 = r7.hf     // Catch: org.json.JSONException -> L97
            r1.put(r0, r4)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "plugin_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "sdk_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            java.lang.String r0 = "plugin_update_network"
            java.lang.String r3 = "2"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L97
            org.json.JSONObject r0 = r7.ra     // Catch: org.json.JSONException -> L97
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L97
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.wo():void");
    }

    public boolean ws() {
        return com.bytedance.sdk.openadsdk.core.w.w.xj().hf() ? com.bytedance.sdk.openadsdk.core.w.u.xj().w(false) : this.f10354pl;
    }

    public Map<String, Object> x() {
        if (!this.dk.isEmpty()) {
            return this.dk;
        }
        String tf = com.bytedance.sdk.openadsdk.core.w.u.xj().tf("");
        this.dk.putAll(TextUtils.isEmpty(tf) ? qt(tf) : new HashMap<>());
        return this.dk;
    }

    public String y() {
        return com.bytedance.sdk.openadsdk.qt.w.xj().hf();
    }

    public String yo() {
        return this.n;
    }

    public boolean yy() {
        return "5001121".equals(this.hf) && "com.union_test.toutiao".equals(wo.d());
    }

    public boolean z() {
        return this.yo;
    }

    private f() {
        this.f = new com.bytedance.sdk.openadsdk.core.ai.xj(2);
        this.d = 0;
        this.tf = true;
        this.p = Collections.synchronizedSet(new HashSet());
        this.f10354pl = false;
        this.g = null;
        this.yo = false;
        this.v = true;
        this.pz = true;
        this.ht = 0;
        this.ra = new JSONObject();
        this.dk = new HashMap<>();
        this.et = false;
        this.f10353io = false;
        this.x = null;
        this.ai = -1;
        this.q = -1;
        this.z = -1;
        this.j = -1L;
        this.n = null;
    }

    private static void e(String str) {
        com.bytedance.sdk.component.utils.zg.xj(str, "name不能为空");
    }

    private static final HashMap<String, Object> qt(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    private static void yo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.zg.xj(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    private static void zg(String str) {
        com.bytedance.sdk.component.utils.zg.xj(str, "appid不能为空");
    }

    public void c(String str) {
        y(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.openadsdk.core.w.u.xj().c(str);
            com.bytedance.sdk.openadsdk.core.w.u.xj().d(xj(this.dk));
        }
    }

    public boolean d(String str) {
        Map<String, Object> map = this.eu;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.eu.containsKey(str);
    }

    public void f(String str) {
        kd(str);
        com.bytedance.sdk.openadsdk.core.w.u.xj().kd(str);
    }

    public void g(String str) {
        w.xj.put("toolsBasicInfUrl", str);
    }

    public void kd(String str) {
        yo(str);
        this.kd = str;
    }

    public void p(String str) {
        w.xj.put("toolsQueryHost", str);
    }

    public void pl(String str) {
        w.xj.put("toolsAdPreviewUrl", str);
    }

    public boolean xj() {
        return this.am != null && this.am.hf();
    }

    public void y(final String str) {
        v(str);
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.am(str);
            }
        });
    }

    public void tf(String str) {
        this.c = str;
        com.bytedance.sdk.openadsdk.core.j.f.xj((com.bytedance.sdk.openadsdk.core.j.kd) null).xj(true);
    }

    public boolean xj(boolean z) {
        return this.am != null && this.am.xj(z);
    }

    private static void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.zg.xj(str.length() <= 20000, "data超长, 最长为20000");
    }

    public void d(boolean z) {
        com.bytedance.sdk.component.u.hf.w wVar = w.xj;
        wVar.put("update_advance_preview_mode", z);
        wVar.put("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public void f(boolean z) {
        this.l = z;
    }

    public void hf(String str) {
        this.n = str;
    }

    public void kd(boolean z) {
        w(z);
        com.bytedance.sdk.openadsdk.core.w.u.xj().hf(z);
    }

    public void u(String str) {
        e(str);
        this.w = str;
    }

    public void xj(String str) {
        this.ff = str;
    }

    public void y(boolean z) {
        ai.f = z;
        this.f10354pl = z;
    }

    public void hf(boolean z) {
        w.xj.put("sdk_activate_init", z);
    }

    public boolean xj(Activity activity) {
        return this.am != null && this.am.xj(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap hashMap = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                if (!optJSONObject.isNull("__name__")) {
                    String optString = optJSONObject.optString("__name__");
                    String optString2 = optJSONObject.optString("value");
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(optString, optString2);
                    }
                } else if ("csj_rit_list".equals(optJSONObject.optString("name"))) {
                    tf(optJSONObject.optString("value"));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(optJSONObject);
                }
            }
        }
        if (z) {
            this.y = jSONArray.toString();
        } else {
            this.y = str;
        }
        if ((jSONArray2.length() == 0 && hashMap.isEmpty()) || jSONArray2.length() != 0) {
            this.y = jSONArray2.toString();
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.dk.putAll(hashMap);
    }

    private void w(Context context) {
        this.am = new com.bytedance.sdk.openadsdk.core.a.xj();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.am);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.am);
        }
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void hf(int i) {
        this.d = i;
    }

    public void kd(int i) {
        com.bytedance.sdk.openadsdk.core.w.u.xj().w(i);
    }

    public void u(boolean z) {
        this.tf = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar) {
        this.qt = uVar;
    }

    public Function<SparseArray<Object>, Object> y(int i) {
        Object apply;
        if (this.x == null) {
            return null;
        }
        apply = this.x.apply(A2egSU.AZOQYO(10, Object.class).xj(0, Integer.valueOf(i)).hf());
        return AaHO0E.AYUAbz(apply);
    }

    public void c(int i) {
        this.z = i;
    }

    public boolean hf(Context context) {
        if (com.bytedance.sdk.openadsdk.core.q.xj.xj().kd()) {
            this.q = 2;
        } else {
            this.q = 1;
        }
        return this.q == 1;
    }

    public void u(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.ht = i;
        } catch (Throwable unused) {
        }
    }

    public void xj(int i) {
        this.f = new com.bytedance.sdk.openadsdk.core.ai.xj(i, true);
    }

    public void xj(boolean z, SparseArray<Object> sparseArray) {
        com.bytedance.sdk.component.utils.pl.u("bstsdk", "bst(true) stat-quit, run new pl");
        this.yo = z;
        com.bytedance.sdk.openadsdk.core.u.xj.xj(true);
        com.bytedance.sdk.component.utils.pl.xj("bstsdk", "setQuitWork, resultValues: " + sparseArray);
        Object obj = sparseArray == null ? null : sparseArray.get(23);
        if (obj instanceof Map) {
            this.eu = (Map) obj;
        }
        com.bytedance.sdk.openadsdk.core.u.w.xj();
    }

    public void w(String str) {
        zg(str);
        this.hf = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
            this.ra.put("com.byted.pangle", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(String str, String str2) {
        try {
            JSONObject optJSONObject = this.ra.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.pl.u("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void xj(String str, String str2, String str3, String str4) {
        try {
            JSONObject optJSONObject = this.ra.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.hf;
            }
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put(PluginConstants.KEY_APP_ID, str4);
            optJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            optJSONObject.put(PluginConstants.KEY_SDK_VERSION, str2);
            this.ra.put(str, optJSONObject);
        } catch (JSONException e) {
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("addPluginConfig for ", str, " failed: ");
            B3GDIM2.append(e.getMessage());
            com.bytedance.sdk.component.utils.pl.hf("GlobalInfo", B3GDIM2.toString());
        }
    }

    public void w(boolean z) {
        this.u = z;
    }

    public boolean w(int i) {
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            String str = w.xj.get("network_state", "");
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split.length > 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && String.valueOf(i).equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.p;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void xj(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString(PluginConstants.KEY_APP_ID, this.hf);
                    xj(str, bundle2.getString(PluginConstants.KEY_SDK_VERSION), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        }
    }

    public void xj(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.p.clear();
            for (int i : iArr) {
                this.p.add(Integer.valueOf(i));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private static final String xj(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    try {
                        jSONObject.putOpt(entry.getKey(), entry.getValue());
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
            return jSONObject.toString();
        }
        return "";
    }

    public void xj(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            String xj2 = com.bytedance.sdk.component.utils.u.xj(bitmap);
            if (!TextUtils.isEmpty(xj2)) {
                w.xj.put("pause_icon", xj2);
            }
        }
        this.g = bitmap;
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        if (this.x != null) {
            return;
        }
        this.x = function;
    }

    public boolean xj(Context context) {
        if (com.bytedance.sdk.openadsdk.core.q.xj.xj().kd()) {
            this.ai = 2;
        } else {
            this.ai = 1;
        }
        return this.ai == 1;
    }

    public void xj(long j) {
        this.j = j;
    }

    public void xj(xj.hf hfVar) {
        if (this.x != null) {
            if (this.en == null) {
                kd kdVar = new kd();
                this.en = kdVar;
                kdVar.xj(this.x);
            }
            this.en.xj(hfVar);
        }
    }

    public void xj(u uVar) {
        this.b = uVar;
    }
}
