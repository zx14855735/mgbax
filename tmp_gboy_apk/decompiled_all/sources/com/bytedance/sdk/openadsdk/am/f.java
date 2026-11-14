package com.bytedance.sdk.openadsdk.am;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.pl;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private long f10268a;
    private String ah;
    private long ai;
    private Runnable am;
    private int aq;
    private long b;
    private int bl;
    private final String c;
    private int ci;
    private float cu;
    private xj cy;
    private Runnable d;
    private String da;
    private boolean db;
    private int dc;
    private boolean dk;
    private String dq;
    private boolean e;
    private long en;
    private boolean et;
    private String eu;
    private String ew;
    private int ey;
    private final Handler f;
    private long ff;
    private w ft;
    private Runnable g;
    private int gh;
    private int gj;
    private long gy;
    private WeakReference<View> h;
    private int he;
    public final String hf;
    private int hl;
    private boolean ht;
    private JSONObject i;
    private int ic;

    /* renamed from: io, reason: collision with root package name */
    private String f10269io;
    private boolean ir;
    private long j;
    private String jk;
    private boolean jw;
    private JSONObject k;
    private int kc;
    public final String kd;
    private boolean kr;
    private long l;
    private String le;
    private String lm;
    private int lw;
    private String lx;
    private boolean m;
    private int mg;
    private String my;
    private String n;
    private JSONObject nb;
    private y ne;
    private float no;
    private int nt;
    private Map<String, String> oa;
    private boolean ol;
    private long op;
    private Runnable p;

    /* renamed from: pl, reason: collision with root package name */
    private final Handler f10270pl;
    private String pz;
    private int q;
    private boolean qd;
    private String qf;
    private float qi;
    private hf qt;
    private long r;
    private boolean ra;
    private int rg;
    private int s;
    private com.bytedance.sdk.openadsdk.am.xj se;
    private String si;
    private int ss;
    private List<JSONObject> sv;
    private int t;
    private Runnable tf;
    private String tj;
    private int tu;
    public final String u;
    private String ua;
    private boolean uf;
    private ViewTreeObserver.OnGlobalLayoutListener uj;
    private int ut;
    private Set<String> v;
    private JSONObject vi;
    private com.bytedance.sdk.component.g.w vl;
    private boolean vm;
    private String vw;
    public final String w;
    private int wa;
    private int wn;
    private long wo;
    private String ws;
    private long x;
    public final String xj;
    private Context xv;
    private final String y;
    private boolean yo;
    private int yy;
    private long z;
    private String zb;
    private int zd;
    private boolean zg;
    private int zm;

    public enum xj {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME;

        static {
            fRDY();
        }

        private static /* synthetic */ void fRDY() {
            char[] charArray = "59;x17;3x49/x%>3::x\u001c8?\u0014$?213".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'V');
            }
            String str = new String(charArray);
            char[] charArray2 = "5:?8?\"".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'V');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private f(Context context, com.bytedance.sdk.component.g.w wVar, w wVar2, com.bytedance.sdk.openadsdk.am.xj xjVar, xj xjVar2, boolean z) {
        this.y = "playable_stuck_check_ping";
        this.c = "playable_apply_media_permission_callback";
        this.f = new Handler(Looper.getMainLooper());
        this.f10270pl = new Handler(Looper.getMainLooper());
        this.zg = true;
        this.e = true;
        this.yo = true;
        this.xj = "PL_sdk_playable_global_viewable";
        this.hf = "PL_sdk_page_screen_blank";
        this.w = "PL_sdk_playable_destroy_analyze_summary";
        this.u = "PL_sdk_playable_hardware_dialog_cancel";
        this.kd = "PL_sdk_playable_hardware_dialog_setting";
        this.v = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.jk = null;
        this.pz = "embeded_ad";
        this.ht = true;
        this.ra = true;
        this.dk = true;
        this.et = false;
        this.f10269io = "";
        this.x = 10L;
        this.ai = 10L;
        this.q = 700;
        this.z = 0L;
        this.j = 0L;
        this.en = -1L;
        this.l = -1L;
        this.ff = -1L;
        this.f10268a = -1L;
        this.wo = -1L;
        this.r = -1L;
        this.b = -1L;
        this.ws = "";
        this.eu = "";
        this.tj = "";
        this.n = "";
        this.yy = 0;
        this.hl = 0;
        this.vm = false;
        this.dc = 0;
        this.wn = -1;
        this.aq = 0;
        this.tu = 0;
        this.s = 0;
        this.dq = null;
        this.qd = false;
        this.bl = 0;
        this.lw = 0;
        this.wa = 0;
        this.gh = 0;
        this.op = 0L;
        this.gy = 0L;
        this.ss = -2;
        this.gj = 0;
        this.rg = 0;
        this.t = 0;
        this.k = new JSONObject();
        this.oa = new HashMap();
        this.i = new JSONObject();
        this.lm = "";
        this.cu = 0.0f;
        this.no = 0.0f;
        this.jw = false;
        this.ir = false;
        this.kr = false;
        this.sv = new ArrayList();
        this.uj = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.am.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) f.this.h.get();
                    if (view == null) {
                        return;
                    }
                    f.this.hf(view);
                } catch (Throwable th) {
                    c.xj("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.ss = 0;
        this.cy = xjVar2;
        this.vl = wVar;
        d.xj(wVar);
        if (!z) {
            xj(wVar.getView());
        }
        xj(context, wVar2, xjVar);
    }

    private void a() {
        this.qt = new hf(this, this.q);
        this.d = new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.ra) {
                    f.this.ra = false;
                    f.this.f.removeCallbacks(f.this.tf);
                    f.this.xj(2, "容器加载超时");
                }
            }
        };
        this.tf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.ra) {
                    f.this.ra = false;
                    f.this.f.removeCallbacks(f.this.d);
                    f.this.xj(3, "JSSDK加载超时");
                }
            }
        };
        this.g = new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (f.this.vl != null) {
                    f.this.vl.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.am.f.5.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (f.this.qt != null) {
                                f.this.qt.xj(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (f.this.f10270pl != null) {
                    f.this.f10270pl.postDelayed(this, 500L);
                }
            }
        };
        this.am = new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                f.this.xj("playable_stuck_check_ping", new JSONObject());
                if (f.this.f10270pl != null) {
                    f.this.f10270pl.postDelayed(this, 500L);
                }
            }
        };
        this.p = new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.7
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gy <= 0) {
                    f.this.hf(1, "点击热区卡死");
                } else {
                    if (f.this.gy - f.this.op > f.this.q) {
                        f.this.hf(1, "点击热区卡死");
                        return;
                    }
                    f.this.z();
                    f.this.op = 0L;
                    f.this.gy = 0L;
                }
            }
        };
    }

    public static /* synthetic */ int g(f fVar) {
        int i = fVar.hl;
        fVar.hl = i + 1;
        return i;
    }

    public static /* synthetic */ int pl(f fVar) {
        int i = fVar.yy;
        fVar.yy = i + 1;
        return i;
    }

    private void r() {
        Runnable runnable;
        Runnable runnable2;
        this.qt.xj(System.currentTimeMillis());
        Handler handler = this.f10270pl;
        if (handler != null) {
            int i = this.ss;
            if (i == 0 && (runnable2 = this.g) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.am) != null) {
                handler.post(runnable);
            }
            this.qt.xj(500);
        }
    }

    private void wo() {
        String str;
        if (this.i == null || (str = this.ua) == null || str.contains("/cid_")) {
            return;
        }
        String optString = this.i.optString("cid");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String host = Uri.parse(this.ua).getHost();
        if (TextUtils.isEmpty(host)) {
            this.ua = A2egSU.B3GDIM(new StringBuilder(), this.ua, "/cid_", optString);
        } else {
            this.ua = this.ua.replace(host, CtFAbx.AlLFFp(host, "/cid_", optString));
        }
    }

    public void ai() {
        hf hfVar;
        this.gy = System.currentTimeMillis();
        int i = this.ss;
        if ((i == 1 || i == 2) && (hfVar = this.qt) != null) {
            hfVar.xj(System.currentTimeMillis());
        }
    }

    public JSONObject am() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.cy.ordinal());
            jSONObject.put("safe_area_top_height", this.cu);
            jSONObject.put("safe_area_bottom_height", this.no);
            jSONObject.put("playable_enter_from", this.tu);
            jSONObject.put("playable_retry_count", this.aq);
            jSONObject.put("playable_card_session", this.ws);
            jSONObject.put("playable_video_session", this.eu);
            jSONObject.put("playable_network_type", zg());
            jSONObject.put("aweme_id", this.n);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public void dk() {
        this.qd = true;
    }

    public com.bytedance.sdk.openadsdk.am.xj e() {
        return this.se;
    }

    public void en() {
        this.rg = 0;
        this.t = 0;
        this.qi = 0.0f;
        this.kc = 0;
        this.zd = 0;
        this.mg = 0;
        this.ut = 0;
        this.he = 0;
        this.zm = 0;
        this.ey = 0;
        this.nt = 0;
        this.ic = 0;
        this.ci = 0;
    }

    public void et() {
        if (this.se != null) {
            xj xjVar = xj.LAND_PAGE;
        }
    }

    public String ff() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public Context getContext() {
        return this.xv;
    }

    public void ht() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.wo > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.wo);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.ff > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.ff;
                this.b = currentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", currentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            w("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void io() {
        if (this.se != null) {
            xj xjVar = xj.LAND_PAGE;
        }
    }

    public void j() {
        try {
            hf hfVar = this.qt;
            if (hfVar != null) {
                hfVar.xj();
            }
            Handler handler = this.f10270pl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public JSONObject jk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.qi);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MediaFormat.KEY_WIDTH, this.kc);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, this.zd);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.ut);
            jSONObject3.put("y", this.mg);
            jSONObject3.put(MediaFormat.KEY_WIDTH, this.he);
            jSONObject3.put(MediaFormat.KEY_HEIGHT, this.zm);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.nt);
            jSONObject4.put("y", this.ey);
            jSONObject4.put(MediaFormat.KEY_WIDTH, this.ic);
            jSONObject4.put(MediaFormat.KEY_HEIGHT, this.ci);
            jSONObject.put("visible", jSONObject4);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "getViewport error", th);
            return jSONObject;
        }
    }

    public void l() {
        if (this.kr) {
            return;
        }
        this.kr = true;
        this.j = 0L;
        this.e = true;
        en();
        try {
            View view = this.h.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.uj);
            }
        } catch (Throwable unused) {
        }
        try {
            this.ne.hf();
        } catch (Throwable unused2) {
        }
        try {
            hf hfVar = this.qt;
            if (hfVar != null) {
                hfVar.xj();
                this.qt = null;
            }
            Handler handler = this.f10270pl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.ua)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.yy);
                jSONObject.put("playable_hit_times", this.hl);
                int i = this.yy;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", this.hl / (i * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                w("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.ua)) {
                if (this.en != -1) {
                    this.z += System.currentTimeMillis() - this.en;
                    this.en = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.z);
                w("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.f.removeCallbacks(this.d);
        this.f.removeCallbacks(this.tf);
        this.f.removeCallbacksAndMessages(null);
    }

    public void pz() {
        com.bytedance.sdk.openadsdk.am.xj xjVar = this.se;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    public void q() {
        this.f.removeCallbacks(this.d);
        this.f.removeCallbacks(this.tf);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ff > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.ff);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            w("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public Intent qt() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File xj2 = kd.xj();
        if (xj2 == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.xv, this.xv.getPackageName() + ".playable.fileProvider", xj2));
        return intent;
    }

    public void ra() {
        this.wn = 2;
    }

    public JSONObject v() {
        return this.i;
    }

    public void x() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.wo > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.wo);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.ff > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.ff);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            w("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject yo() {
        if (this.k.isNull(MediaFormat.KEY_WIDTH)) {
            View view = this.h.get();
            if (view == null) {
                return this.k;
            }
            hf(view);
        }
        return this.k;
    }

    public void z() {
        if (this.dk) {
            this.r = System.currentTimeMillis();
            if (this.cy == xj.FEED_AWEME) {
                if (this.ol && this.gj == 3) {
                    hf hfVar = this.qt;
                    if (hfVar != null && hfVar.hf()) {
                        r();
                        return;
                    } else {
                        if (this.qt == null) {
                            this.qt = new hf(this, this.q);
                            r();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.ol && this.gj == 2) {
                hf hfVar2 = this.qt;
                if (hfVar2 != null && hfVar2.hf()) {
                    r();
                } else if (this.qt == null) {
                    this.qt = new hf(this, this.q);
                    r();
                }
            }
        }
    }

    public String zg() {
        com.bytedance.sdk.openadsdk.am.xj xjVar;
        if (TextUtils.isEmpty(this.tj) && (xjVar = this.se) != null) {
            this.tj = xjVar.u().toString();
        }
        return this.tj;
    }

    private boolean tf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public boolean c() {
        return this.uf;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.db);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public boolean f() {
        return this.ol;
    }

    public JSONObject g() {
        boolean xj2;
        boolean xj3;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                xj2 = kd.xj(this.xv, "android.permission.READ_MEDIA_IMAGES");
                xj3 = true;
            } else {
                xj2 = kd.xj(this.xv, g.i);
                xj3 = kd.xj(this.xv, g.j);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", xj2);
            jSONObject.put("isHasWrite", xj3);
            if (!xj2 || !xj3) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public String kd() {
        return this.le;
    }

    public JSONObject p() {
        try {
            boolean xj2 = kd.xj(this.xv, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", xj2);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject pl() {
        try {
            boolean xj2 = kd.xj(this.xv, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", xj2);
            return jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public String u() {
        return this.da;
    }

    public String w() {
        return this.zb;
    }

    public String y() {
        return this.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.rg == view.getWidth() && this.t == view.getHeight()) {
                return;
            }
            this.rg = view.getWidth();
            this.t = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, this.rg);
            jSONObject.put(MediaFormat.KEY_HEIGHT, this.t);
            xj("resize", jSONObject);
            this.k = jSONObject;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void c(JSONObject jSONObject) {
        this.nb = jSONObject;
        this.s++;
        j();
        this.f.removeCallbacks(this.p);
        if (this.dk) {
            this.r = System.currentTimeMillis();
            this.op = System.currentTimeMillis();
            this.gy = 0L;
            int i = this.ss;
            if (i == 0) {
                com.bytedance.sdk.component.g.w wVar = this.vl;
                if (wVar != null) {
                    wVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.am.f.8
                        @Override // android.webkit.ValueCallback
                        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            f.this.gy = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                xj("playable_stuck_check_ping", new JSONObject());
            }
            this.f.postDelayed(this.p, this.q);
        }
    }

    public void f(JSONObject jSONObject) {
        hf(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public f kd(JSONObject jSONObject) {
        this.i = jSONObject;
        return this;
    }

    public Set<String> tf() {
        Set<String> xj2 = this.ne.xj();
        Set<String> set = this.v;
        if (set == null || set.size() <= 0) {
            return xj2;
        }
        HashSet hashSet = new HashSet();
        for (String str : xj2) {
            if (!this.v.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public f u(String str) {
        this.vw = str;
        return this;
    }

    public f w(String str) {
        this.le = str;
        return this;
    }

    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dq = jSONObject.optString("section");
        }
    }

    public f kd(String str) {
        Uri parse;
        String scheme;
        int indexOf;
        String decode;
        this.lm = str;
        try {
            parse = Uri.parse(str);
            scheme = parse.getScheme();
        } catch (Throwable unused) {
        }
        if (!Constants.HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            String host = parse.getHost();
            if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.ss == -1) {
                        hf(2);
                    } else {
                        hf(1);
                    }
                }
                this.ua = str;
                return this;
            }
            hf(0);
            String queryParameter = parse.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter) && (decode = Uri.decode(queryParameter)) != null) {
                int indexOf2 = decode.indexOf("?");
                str = indexOf2 != -1 ? decode.substring(0, indexOf2) : decode;
            }
            this.ua = str;
            return this;
        }
        hf(0);
        if (str != null && (indexOf = str.indexOf("?")) != -1) {
            str = str.substring(0, indexOf);
        }
        this.ua = str;
        return this;
    }

    public void u(JSONObject jSONObject) {
        if (this.se != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public f w(boolean z) {
        this.db = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.db);
            xj("change_playable_click", jSONObject);
            return this;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "setPlayableClick error", th);
            return this;
        }
    }

    public void y(String str) {
        int i;
        int i2;
        this.gj = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.ff = currentTimeMillis;
            long j = this.l;
            jSONObject.put("playable_page_show_duration", j != -1 ? currentTimeMillis - j : 0L);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        w("PL_sdk_html_load_start", jSONObject);
        if (this.ht && ((i = this.ss) == 0 || i == 1 || i == 2)) {
            this.f.postDelayed(this.d, this.x * 1000);
            if (tf(this.ua) || (i2 = this.ss) == 1 || i2 == 2) {
                this.f.postDelayed(this.tf, this.ai * 1000);
            }
            this.ht = false;
        }
        if (this.e) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (kd.xj(this.xv, kd.f10271pl)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (kd.hf(this.xv, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append(Constants.FAIL);
                    }
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                if (kd.xj(this.xv, kd.p)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                if (kd.xj(this.xv, kd.tf)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                if (kd.xj(this.xv, kd.d)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                if (kd.xj(this.xv, kd.f)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (kd.hf(this.xv, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append(Constants.FAIL);
                    }
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                if (kd.xj(this.xv, kd.c)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (kd.xj(this.xv)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append(Constants.FAIL);
                    }
                } else {
                    stringBuffer2.append(Constants.FAIL);
                    stringBuffer3.append(Constants.FAIL);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                w("PL_sdk_hardware_detect", jSONObject2);
                this.e = false;
            } catch (Throwable th2) {
                c.xj("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    private void xj(Context context, w wVar, com.bytedance.sdk.openadsdk.am.xj xjVar) {
        this.jk = UUID.randomUUID().toString();
        this.xv = context;
        this.se = xjVar;
        this.ft = wVar;
        tf.xj(xjVar);
        this.ne = new y(this);
        a();
    }

    public JSONObject d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt(PointParamKey.TYPE, 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt == 1) {
            return p();
        }
        if (optInt != 2) {
            return optInt != 3 ? jSONObject2 : g();
        }
        return pl();
    }

    public void f(String str) {
        this.f.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.10
            @Override // java.lang.Runnable
            public void run() {
                f.pl(f.this);
            }
        });
    }

    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean(cb.o, true);
            if (optBoolean) {
                this.gj = 3;
                z();
            } else {
                this.gj = -2;
            }
            if (optBoolean || !this.ra) {
                return;
            }
            this.ra = false;
            this.f.removeCallbacks(this.d);
            this.f.removeCallbacks(this.tf);
            xj(4, "素材渲染失败");
        }
    }

    public f u(boolean z) {
        this.dk = z;
        return this;
    }

    private String u(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.my) && !TextUtils.isEmpty(this.lm)) {
            Uri parse = Uri.parse(this.lm);
            String host = parse.getHost();
            if (!"lynxview".equalsIgnoreCase(host) && (host == null || !host.contains("lynxview"))) {
                queryParameter = "";
                queryParameter2 = "";
            } else {
                queryParameter = parse.getQueryParameter("surl");
                queryParameter2 = parse.getQueryParameter("playable_hash");
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(parse.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                appendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.my = appendQueryParameter.toString();
        }
        return this.my;
    }

    public JSONObject tf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt(PointParamKey.TYPE, 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (optInt != 1) {
                if (optInt == 2) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", kd.hf(this.xv, "android.permission.CAMERA"));
                        return jSONObject2;
                    }
                    jSONObject2.put("result", false);
                    return jSONObject2;
                }
                if (optInt == 3) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", kd.xj(this.xv));
                        return jSONObject2;
                    }
                    jSONObject2.put("result", false);
                    return jSONObject2;
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject2.put("result", kd.hf(this.xv, "android.permission.RECORD_AUDIO"));
                    return jSONObject2;
                }
                jSONObject2.put("result", false);
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void w(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.am.xj xjVar = this.se;
        if (xjVar == null || xjVar.xj(jSONObject) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = jSONObject.optInt("resource_type", -1);
        String optString2 = jSONObject.optString("resource_name", "playable_media");
        if (optInt == 1) {
            hf(optString2, optString);
        } else if (optInt == 2) {
            w(optString2, optString);
        }
    }

    public void d(String str) {
        this.f.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.am.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.g(f.this);
            }
        });
    }

    public f hf(String str) {
        this.zb = str;
        return this;
    }

    public void xj(View view) {
        if (view == null) {
            return;
        }
        try {
            this.h = new WeakReference<>(view);
            hf(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.uj);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public JSONObject hf() {
        return this.vi;
    }

    public f hf(long j) {
        if (j <= 0) {
            this.ai = 10L;
            return this;
        }
        this.ai = j;
        return this;
    }

    public void c(String str) {
        com.bytedance.sdk.component.g.w wVar;
        this.gj = 2;
        this.si = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f10268a = currentTimeMillis;
            long j = this.ff;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? currentTimeMillis - j : 0L);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        w("PL_sdk_html_load_finish", jSONObject);
        this.f.removeCallbacks(this.d);
        try {
            if (this.ss == 0) {
                if (this.zg && (wVar = this.vl) != null) {
                    this.zg = false;
                    wVar.evaluateJavascript(ff(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.am.f.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                z();
            }
        } catch (Throwable th2) {
            c.xj("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public f hf(boolean z) {
        if (this.ol != z) {
            this.ol = z;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.ol) {
                    jSONObject.put("playable_background_show_type", this.lw);
                }
            } catch (JSONException e) {
                pl.xj(e);
            }
            w(this.ol ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
            if (this.l == -1 && this.ol) {
                this.l = System.currentTimeMillis();
                w("PL_sdk_page_show", (JSONObject) null);
            }
            if (this.l != -1 && !this.ol && !this.jw) {
                this.jw = true;
            }
            if (this.ol) {
                this.en = System.currentTimeMillis();
            } else if (this.en != -1) {
                this.z += System.currentTimeMillis() - this.en;
                this.en = -1L;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewStatus", this.ol);
                xj("viewableChange", jSONObject2);
            } catch (Throwable th) {
                c.xj("PlayablePlugin", "setViewable error", th);
            }
            if (this.ol) {
                z();
            } else {
                j();
            }
        }
        return this;
    }

    public f xj(String str, String str2) {
        this.oa.put(str, str2);
        return this;
    }

    public void w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.xv, "视频保存失败", 0).show();
            return;
        }
        File xj2 = kd.xj(str, str2);
        if (xj2 != null && xj2.exists()) {
            Uri fromFile = Uri.fromFile(xj2);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile);
            this.xv.sendBroadcast(intent);
            Toast.makeText(this.xv, "视频已保存到相册", 0).show();
            return;
        }
        Toast.makeText(this.xv, "视频保存失败", 0).show();
    }

    public Map<String, String> xj() {
        return this.oa;
    }

    public f xj(String str) {
        this.da = str;
        return this;
    }

    public f xj(boolean z) {
        this.uf = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.uf);
            xj("volumeChange", jSONObject);
            return this;
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "setIsMute error", th);
            return this;
        }
    }

    public JSONObject u(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject xj2 = this.ne.xj(str, jSONObject);
        if (c.xj()) {
            System.currentTimeMillis();
        }
        return xj2;
    }

    private String kd(String str, String str2) {
        String format = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.ua = format;
        return format;
    }

    public f xj(long j) {
        if (j <= 0) {
            this.x = 10L;
            return this;
        }
        this.x = j;
        return this;
    }

    private void kd(String str, JSONObject jSONObject) {
        try {
            int i = this.ss;
            if (i == 0) {
                if (this.cy != xj.LAND_PAGE && !tf(this.ua)) {
                    wo();
                }
                jSONObject.put("playable_url", this.ua);
            } else {
                if (i != 3 && i != 4) {
                    if (i == 1 || i == 2) {
                        jSONObject.put("playable_url", u(this.lx, this.ah));
                    }
                }
                jSONObject.put("playable_url", kd(this.ew, this.qf));
            }
            jSONObject.put("playable_render_type", this.ss);
            if (this.se != null && this.ss == 0 && this.cy == xj.LAND_PAGE) {
                tf(this.ua);
            }
        } catch (JSONException unused) {
        }
    }

    public void xj(JSONObject jSONObject) {
        if (this.se != null) {
            qt();
        }
    }

    private void w(int i, String str) {
        com.bytedance.sdk.openadsdk.am.xj xjVar = this.se;
        if (xjVar != null) {
            xjVar.xj(i, str);
        }
    }

    public Intent xj(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
            return intent;
        }
        if (i == 1) {
            intent.setType("image/*");
            return intent;
        }
        if (i == 2) {
            intent.setType("video/mp4");
            return intent;
        }
        intent.setType("*/*");
        return intent;
    }

    public void w(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.vm && this.hl > 0) {
                this.vm = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.ol);
            jSONObject.put("playable_session_id", this.jk);
            int i = this.ss;
            if (i == 0) {
                if (this.cy != xj.LAND_PAGE && !tf(this.ua)) {
                    wo();
                }
                jSONObject.put("playable_url", this.ua);
            } else {
                if (i != 3 && i != 4) {
                    if (i == 1 || i == 2) {
                        jSONObject.put("playable_url", u(this.lx, this.ah));
                    }
                }
                jSONObject.put("playable_url", kd(this.ew, this.qf));
            }
            jSONObject.put("playable_full_url", this.lm);
            jSONObject.put("playable_replay_count", this.dc);
            jSONObject.put("playable_is_prerender", this.m);
            jSONObject.put("playable_is_preload", this.vm);
            jSONObject.put("playable_render_type", this.ss);
            jSONObject.put("playable_scenes_type", this.cy.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.lx) ? "" : this.lx);
            if (!TextUtils.isEmpty(this.ah)) {
                str2 = this.ah;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.ew);
            jSONObject.put("playable_minigamelite_schema", this.qf);
            jSONObject.put("playable_is_debug", this.ir);
            jSONObject.put("playable_retry_count", this.aq);
            jSONObject.put("playable_enter_from", this.tu);
            jSONObject.put("playable_sequence", this.s);
            jSONObject.put("playable_current_section", this.dq);
            jSONObject.put("is_playable_finish", this.qd);
            jSONObject.put("playable_card_session", this.ws);
            jSONObject.put("playable_video_session", this.eu);
            jSONObject.put("playable_network_type", zg());
            jSONObject.put("playable_lynx_version", this.f10269io);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.pz);
            jSONObject2.put("nt", 4);
            jSONObject2.put(PointParamKey.CATEGORY, BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.i.opt("cid"));
            jSONObject2.put("log_extra", this.i.opt("log_extra"));
            int i2 = this.ss;
            if (i2 != -1 && i2 != -2) {
                if (this.se != null) {
                    List<JSONObject> list = this.sv;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.sv.iterator();
                        while (it.hasNext()) {
                            JSONObject optJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (optJSONObject != null) {
                                optJSONObject.put("playable_render_type", this.ss);
                                optJSONObject.put("playable_url", this.ua);
                            }
                        }
                        this.sv.clear();
                    }
                    if (this.ss == 0 && this.cy == xj.LAND_PAGE) {
                        tf(this.ua);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.sv == null) {
                this.sv = new ArrayList();
            }
            this.sv.add(jSONObject2);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void xj(String str, JSONObject jSONObject) {
        w wVar = this.ft;
        if (wVar != null) {
            wVar.xj(str, jSONObject);
        }
    }

    public void xj(int i, String str) {
        j();
        w(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "reportRenderFatal error", th);
        }
        w("PL_sdk_global_faild", jSONObject);
    }

    public void hf(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            i = jSONObject.optInt("resource_type", 0);
            kd.w = jSONObject.optInt("video_min_duration", 1);
            kd.u = jSONObject.optInt("video_max_duration", 20);
            kd.kd = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.se != null) {
            xj(i);
        }
    }

    public void xj(int i, String str, String str2) {
        this.gj = -1;
        this.si = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            c.xj("PlayablePlugin", "onWebReceivedError error", th);
        }
        w("PL_sdk_html_load_error", jSONObject);
        if (this.ra) {
            this.ra = false;
            this.f.removeCallbacks(this.d);
            this.f.removeCallbacks(this.tf);
            xj(1, "容器加载失败");
        }
    }

    public void hf(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.xv, "照片保存失败", 0).show();
            return;
        }
        Bitmap hf = kd.hf(str2);
        if (hf != null) {
            MediaStore.Images.Media.insertImage(this.xv.getContentResolver(), hf, str, "");
            Toast.makeText(this.xv, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.xv, "照片保存失败", 0).show();
        }
    }

    public f hf(int i) {
        this.ss = i;
        return this;
    }

    public void hf(int i, String str) {
        this.wn = i;
        if (this.nb == null) {
            this.nb = new JSONObject();
        }
        try {
            this.nb.put("playable_stuck_type", i);
            this.nb.put("playable_stuck_reason", str);
            if (this.r > 0) {
                this.nb.put("playable_stuck_duration", System.currentTimeMillis() - this.r);
            } else {
                this.nb.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        w("PL_sdk_page_stuck", this.nb);
        j();
        if (this.se == null || i != 2) {
            return;
        }
        this.nb = new JSONObject();
    }

    public void xj(boolean z, String str, int i) {
        if (z) {
            this.gj = -1;
            this.si = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                c.xj("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            w("PL_sdk_html_load_error", jSONObject);
            if (this.ra) {
                this.ra = false;
                this.f.removeCallbacks(this.d);
                this.f.removeCallbacks(this.tf);
                xj(1, "容器加载失败");
            }
        }
    }

    public void hf(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        kd(str, jSONObject);
    }

    public static f xj(Context context, com.bytedance.sdk.component.g.w wVar, w wVar2, com.bytedance.sdk.openadsdk.am.xj xjVar, Set<String> set, xj xjVar2, boolean z) {
        if (wVar == null || wVar2 == null || xjVar == null) {
            return null;
        }
        return new f(context, wVar, wVar2, xjVar, set, xjVar2, z);
    }

    private f(Context context, com.bytedance.sdk.component.g.w wVar, w wVar2, com.bytedance.sdk.openadsdk.am.xj xjVar, Set<String> set, xj xjVar2, boolean z) {
        this(context, wVar, wVar2, xjVar, xjVar2, z);
        this.v = set;
    }
}
