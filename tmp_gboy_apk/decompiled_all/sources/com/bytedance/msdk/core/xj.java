package com.bytedance.msdk.core;

import ADYaiT.CtFAbx;
import IzHBwY.AYUAbz;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.am;
import com.bytedance.msdk.api.u.y;
import com.bytedance.msdk.core.d.kd;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.et;
import com.bytedance.msdk.f.l;
import com.bytedance.msdk.f.pz;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.u;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final xj eu = new xj();

    /* renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.xj.w.w f10133a;
    private boolean ai;
    private final Map<String, Integer> b;
    private boolean d;
    private boolean dk;
    private boolean en;
    private JSONObject et;
    private String f;
    private String g;
    private String[] hf;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10134io;
    private com.bytedance.msdk.api.u.xj.d.xj j;
    private PluginValueSet l;
    private am n;
    private Map<String, String> p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10135pl;
    private boolean q;
    private long r;
    private List<String> ra;
    private String tf;
    private int[] tj;
    private String u;
    private y v;
    private String w;
    private Object wo;
    private final Map<String, Float> ws;
    private String x;
    private String z;
    private int xj = 0;
    private boolean kd = true;
    private boolean y = false;
    private boolean c = false;
    private Set<String> am = new HashSet();
    private Map<String, Map<String, String>> qt = new HashMap();
    private Map<String, Map<String, String>> zg = new HashMap();
    private boolean e = false;
    private final Map<String, Object> yo = new pz();
    private long jk = -1;
    private Map<String, Object> pz = new ConcurrentHashMap();
    private Map<String, Object> ht = new ConcurrentHashMap();
    private int ff = -1;

    static {
        oEMKg();
    }

    private xj() {
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        this.ws = new ConcurrentHashMap();
        if (hf.hf().wo()) {
            hashMap.put(MediationConstant.KEY_USE_POLICY_AD_GAP, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_AD_LOAD, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_SECTION_ID, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, 1);
            hashMap.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, 1);
        }
    }

    private static /* synthetic */ void oEMKg() {
        char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 145);
        }
        String str = new String(charArray);
        char[] charArray2 = "òýøÿøå".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 145);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj p() {
        return eu;
    }

    public PluginValueSet a() {
        PluginValueSet pluginValueSet = this.l;
        return pluginValueSet != null ? pluginValueSet : AYUAbz.A4TApA().A2egSU();
    }

    public boolean ai() {
        return this.dk;
    }

    public boolean am() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return "com.bytedance.mediation_demo_csj".equals(hf.getContext().getPackageName()) && tf();
    }

    public void dk() {
        this.n = am.xj(p().hf());
    }

    public String e() {
        return this.f;
    }

    public boolean en() {
        return this.ai;
    }

    public Map<String, Object> et() {
        return this.pz;
    }

    public String f() {
        if ((!"com.union_test.toutiao".equals(hf.getContext().getPackageName()) || !"5001121".equals(this.w)) && (!"com.bytedance.mediation_demo".equals(hf.getContext().getPackageName()) || !"5001121".equals(this.w))) {
            return null;
        }
        try {
            return ai.xj("tt_mediation_ppe_info", hf.getContext()).hf("tt_ppe_content");
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, Object> ff() {
        this.yo.put(MediationConstant.KEY_GM_USB, kd.kd());
        return this.yo;
    }

    public boolean g() {
        return this.en;
    }

    public com.bytedance.msdk.xj.w.w hf() {
        if (this.f10133a == null) {
            u xj = u.xj();
            com.bytedance.msdk.y.hf.kd.xj(xj);
            this.f10133a = com.bytedance.msdk.xj.w.w.xj(xj.hf());
        }
        return this.f10133a;
    }

    public y ht() {
        return this.v;
    }

    public Map<String, Object> io() {
        return this.ht;
    }

    public String j() {
        return this.x;
    }

    public boolean jk() {
        try {
            if ("com.union_test.toutiao".equals(hf.getContext().getPackageName()) && "5001121".equals(this.w)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(hf.getContext().getPackageName()) && "5001121".equals(this.w)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(hf.getContext().getPackageName()) && "5001121".equals(this.w)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(hf.getContext().getPackageName()) && "5001121".equals(this.w)) {
                return true;
            }
            if (hf.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
                return "5001121".equals(this.w);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public long kd() {
        return this.r;
    }

    public boolean l() {
        return this.q;
    }

    public String pl() {
        return this.w;
    }

    public boolean pz() {
        String xj = l.xj();
        return "com.union_test.toutiao".equals(xj) || "com.bytedance.mediation_demo".equals(xj) || "com.msdk.qa.monkey".equals(xj);
    }

    public JSONObject q() {
        return this.et;
    }

    public String qt() {
        return this.tf;
    }

    public Object r() {
        return this.wo;
    }

    public am ra() {
        if (this.n == null) {
            this.n = am.xj(p().hf());
        }
        return this.n;
    }

    public boolean tf() {
        String path = com.bytedance.sdk.openadsdk.api.plugin.hf.w(hf.getContext()).getPath();
        if (this.ff < 0) {
            if (new File(CtFAbx.AcNBzu(path, "/e2e.text")).exists()) {
                this.ff = 1;
            } else {
                this.ff = 0;
            }
        }
        return this.ff > 0;
    }

    public Map<String, Integer> u() {
        return this.b;
    }

    public String v() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String xj = ai.xj((String) null, hf.getContext()).xj();
        this.g = xj;
        if (!TextUtils.isEmpty(xj)) {
            return this.g;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        ai.xj((String) null, hf.getContext()).xj(valueOf);
        this.g = valueOf;
        return valueOf;
    }

    public long w() {
        long j = this.jk;
        if (j != -1) {
            return j;
        }
        long hf = com.bytedance.msdk.c.hf.xj.xj().hf();
        this.jk = hf;
        return hf;
    }

    public com.bytedance.msdk.api.u.xj.d.xj wo() {
        return this.j;
    }

    public List<String> x() {
        return this.ra;
    }

    public void xj(boolean z) {
        this.e = z;
    }

    public String y() {
        return this.z;
    }

    public String yo() {
        return this.u;
    }

    public boolean z() {
        return this.f10134io;
    }

    public Map<String, String> zg() {
        return this.p;
    }

    private static void d(String str) {
        et.xj(str, "appid不能为空");
    }

    public void c(String str) {
        this.f10135pl = str;
    }

    public void kd(String str) {
        this.tf = str;
    }

    public void u(boolean z) {
        this.c = z;
    }

    public boolean xj() {
        return this.e;
    }

    public void y(boolean z) {
        this.y = z;
    }

    public void c(boolean z) {
        this.dk = z;
    }

    public void d(boolean z) {
        this.ai = z;
    }

    public void kd(boolean z) {
        this.kd = z;
    }

    public void u(String str) {
        this.f = str;
    }

    public void w(String str) {
        d(str);
        this.w = str;
    }

    public void xj(String str, float f) {
        this.ws.put(str, Float.valueOf(f));
    }

    public void y(String str) {
        if (TextUtils.isEmpty(str)) {
            str = xj(hf.getContext());
        }
        this.u = str;
    }

    public void f(boolean z) {
        this.f10134io = z;
    }

    public float xj(String str) {
        return this.ws.get(str).floatValue();
    }

    public void f(String str) {
        this.x = str;
    }

    public void w(boolean z) {
        this.en = z;
    }

    public void xj(long j) {
        com.bytedance.msdk.c.hf.xj.xj().xj(j);
    }

    public void hf(long j) {
        this.r = j;
    }

    public void w(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.ht.putAll(map);
    }

    public void xj(Map<String, String> map) {
        this.p = map;
    }

    public void hf(String str) {
        this.z = str;
    }

    public void xj(int... iArr) {
        this.tj = iArr;
    }

    public static String xj(Context context) {
        CharSequence charSequence;
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            if (applicationInfo == null) {
                charSequence = "";
            } else {
                charSequence = packageManager.getApplicationLabel(applicationInfo);
            }
            return (String) charSequence;
        } catch (Throwable th) {
            pl.xj(th);
            return "";
        }
    }

    public void hf(boolean z) {
        this.d = z;
    }

    public void hf(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.pz.putAll(map);
    }

    public void xj(int i) {
        this.xj = i;
    }

    public void xj(String[] strArr) {
        this.hf = strArr;
    }

    public void tf(boolean z) {
        this.q = z;
    }

    public void xj(y yVar, boolean z) {
        boolean equals;
        if (!z) {
            y yVar2 = this.v;
            if (yVar2 == null && yVar == null) {
                equals = true;
            } else {
                equals = (yVar2 == null || yVar == null) ? false : yVar2.equals(yVar);
            }
            this.v = yVar;
            if (equals) {
                return;
            }
            com.bytedance.msdk.core.am.hf.xj(hf.hf()).xj().xj(3);
            return;
        }
        this.v = yVar;
    }

    public void xj(List<String> list) {
        this.ra = list;
    }

    public void xj(JSONObject jSONObject) {
        this.et = jSONObject;
    }

    public void xj(PluginValueSet pluginValueSet) {
        this.l = pluginValueSet;
    }

    public void xj(com.bytedance.msdk.api.u.xj.d.xj xjVar) {
        this.j = xjVar;
    }

    public void xj(Object obj) {
        this.wo = obj;
    }
}
