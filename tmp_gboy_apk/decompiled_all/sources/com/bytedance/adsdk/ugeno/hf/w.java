package com.bytedance.adsdk.ugeno.hf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.c;
import com.bytedance.adsdk.ugeno.w.d;
import com.bytedance.adsdk.ugeno.w.e;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.hf.kd;
import com.bytedance.adsdk.ugeno.w.hf.u;
import com.bytedance.adsdk.ugeno.w.hf.y;
import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.tf;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.adsdk.ugeno.y.xj;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.language.Soundex;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class w<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.w, yo.hf, yo.xj {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f10068a;
    private boolean ah;
    protected float ai;
    protected float am;
    protected boolean aq;
    protected ImageView.ScaleType b;
    private com.bytedance.adsdk.ugeno.kd.xj.xj bh;
    protected String bl;
    protected xj<ViewGroup> c;

    @Deprecated
    private kd ci;
    private boolean cu;
    protected float cy;
    protected am d;
    protected yo da;
    private boolean db;
    protected float dc;
    protected boolean dk;
    protected float dq;
    protected float e;
    protected boolean en;
    protected boolean et;
    protected boolean eu;
    private boolean ew;

    @Deprecated
    private y ey;
    protected d.xj f;
    protected boolean ff;
    protected float ft;
    protected float g;
    protected boolean gh;
    protected float gj;
    protected com.bytedance.adsdk.ugeno.xj.xj gy;
    protected float h;
    private String he;
    protected Context hf;
    protected float hl;
    private boolean ho;
    protected boolean ht;
    protected boolean i;

    @Deprecated
    private com.bytedance.adsdk.ugeno.w.hf.w ic;

    /* renamed from: io, reason: collision with root package name */
    protected float f10069io;
    private boolean ir;
    protected boolean j;
    protected float jk;
    private boolean jw;
    protected tf k;
    private boolean kc;
    protected T kd;
    private JSONObject kr;
    protected boolean l;
    protected c le;
    private boolean lm;
    protected int lw;
    private boolean lx;
    private ht m;
    private boolean mg;
    private boolean my;
    protected float n;
    protected com.bytedance.adsdk.ugeno.xj.y nb;
    protected float ne;
    private boolean no;

    @Deprecated
    private com.bytedance.adsdk.ugeno.w.hf.hf nt;
    protected Map<Integer, zg> oa;
    private String ol;
    protected ViewGroup.LayoutParams op;
    protected String p;

    /* renamed from: pl, reason: collision with root package name */
    protected String f10070pl;
    protected float pz;
    protected float q;
    protected int qd;
    private boolean qf;
    private boolean qi;
    protected float qt;
    protected String r;
    protected boolean ra;
    protected float rg;
    protected boolean s;
    protected float se;
    protected com.bytedance.adsdk.ugeno.kd.d si;
    protected float ss;
    private boolean sv;
    protected float t;
    protected boolean tf;
    protected boolean tj;
    protected boolean tu;
    protected JSONObject u;
    protected xj.C0035xj ua;
    private g uf;
    private boolean uj;
    private GradientDrawable ut;
    protected float v;
    private long vh;
    private boolean vi;
    protected float vl;
    protected float vm;

    @Deprecated
    private u.xj vw;
    protected JSONObject w;
    protected float wa;
    protected boolean wn;
    protected int wo;
    protected float ws;
    private float wx;
    protected float x;
    private boolean xj;
    protected float xv;
    protected xj<ViewGroup> y;
    protected float yo;
    protected float yy;
    protected float z;
    protected jk zb;
    private boolean zd;
    protected float zg;
    private com.bytedance.adsdk.ugeno.w.xj zm;

    public w(Context context) {
        this(context, null);
    }

    private void c() {
        if (this.xj) {
            this.kd.setTranslationX(this.gj);
        }
        if (this.my) {
            this.kd.setTranslationY(this.cy);
        }
        if (this.lm) {
            this.kd.setScaleX(this.vl);
        }
        if (this.vi) {
            this.kd.setScaleY(this.h);
        }
        if (this.cu) {
            this.kd.setRotation(this.ne);
        }
        if (this.no) {
            this.kd.setRotationX(this.se);
        }
        if (this.qi) {
            this.kd.setRotationY(-this.ft);
        }
        if (this.kc) {
            this.kd.setAlpha(this.t);
        }
        float f = this.rg;
        if (f != 0.0f) {
            this.kd.setRotation(f);
        }
        if (this.cu || this.no || this.qi) {
            this.kd.setCameraDistance(10000.0f);
        }
    }

    private void dq() {
        if (TextUtils.equals("dashed", this.bl)) {
            GradientDrawable gradientDrawable = this.ut;
            float f = this.dq;
            gradientDrawable.setStroke((int) f, this.qd, 3.0f * f, f);
        } else {
            if (!TextUtils.equals("dotted", this.bl)) {
                this.ut.setStroke((int) this.dq, this.qd);
                return;
            }
            GradientDrawable gradientDrawable2 = this.ut;
            float f2 = this.dq;
            gradientDrawable2.setStroke((int) f2, this.qd, f2 / 2.0f, f2);
        }
    }

    @Deprecated
    private void f() {
        u u;
        this.kd.setVisibility(this.lw);
        float f = this.rg;
        if (f != 0.0f) {
            this.kd.setRotation(f);
        }
        d.xj xjVar = this.f;
        if (xjVar != null && TextUtils.isEmpty(xjVar.hf())) {
            this.kd.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.hf.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w wVar = w.this;
                    if (wVar.k == null || !wVar.qf) {
                        return;
                    }
                    w wVar2 = w.this;
                    wVar2.k.xj(wVar2);
                }
            });
        } else if (xj(1) && !this.jw) {
            this.kd.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.hf.w.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w wVar = w.this;
                    if (wVar.da == null || !wVar.qf) {
                        return;
                    }
                    w wVar2 = w.this;
                    yo yoVar = wVar2.da;
                    zg zgVar = wVar2.oa.get(1);
                    w wVar3 = w.this;
                    yoVar.xj(zgVar, wVar3, wVar3);
                }
            });
        }
        if (this.da != null && xj(4)) {
            if (xj(1)) {
                this.db = true;
                this.ci = new kd(this.hf, this.oa.get(4), this.oa.get(1), this.db, aq());
            } else {
                this.ci = new kd(this.hf, this.oa.get(4), this.db, aq());
            }
        }
        if (this.da != null && xj(1) && this.jw) {
            this.ic = new com.bytedance.adsdk.ugeno.w.hf.w(this.hf, this.oa.get(1));
        }
        tu();
        if (this.da != null && xj(3) && (u = com.bytedance.adsdk.ugeno.u.xj().u()) != null) {
            u.xj xjVar2 = this.vw;
            if (xjVar2 != null) {
                xjVar2.hf();
            }
            u.xj xj = u.xj(this.hf, this);
            this.vw = xj;
            xj.xj(this.wx);
            this.vw.xj();
            this.vw.xj(new u.hf() { // from class: com.bytedance.adsdk.ugeno.hf.w.3
                @Override // com.bytedance.adsdk.ugeno.w.hf.u.hf
                public void xj(int i) {
                    w wVar;
                    yo yoVar;
                    w.this.vw.hf();
                    if (w.this.kd.isShown() && (yoVar = (wVar = w.this).da) != null && i == 1) {
                        zg zgVar = wVar.oa.get(3);
                        w wVar2 = w.this;
                        yoVar.xj(zgVar, wVar2, wVar2);
                    }
                }
            });
        }
        if (this.da != null && xj(9)) {
            y yVar = new y(this.hf, this.oa.get(9), this);
            this.ey = yVar;
            yVar.xj(this.da);
        }
        if (xj(10)) {
            com.bytedance.adsdk.ugeno.w.hf.hf hfVar = new com.bytedance.adsdk.ugeno.w.hf.hf(this.hf, this.oa.get(10), this);
            this.nt = hfVar;
            hfVar.xj(this.da);
        }
    }

    private void qd() {
        float f = this.wn ? this.yy : this.n;
        float f2 = this.aq ? this.vm : this.n;
        float f3 = this.tu ? this.hl : this.n;
        float f4 = this.s ? this.dc : this.n;
        this.ut.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    private void s() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.p);
        this.kd.setContentDescription(sb);
    }

    private void tu() {
        zg zgVar;
        if (this.da == null || !xj(18) || (zgVar = this.oa.get(18)) == null) {
            return;
        }
        JSONObject w = zgVar.w();
        if (w != null) {
            try {
                w.put("rotateZ", com.bytedance.adsdk.ugeno.u.hf.xj(w.optString("rotateZ"), this.u));
            } catch (JSONException unused) {
            }
        }
        this.da.xj(zgVar, this, this);
    }

    public am a() {
        return this.d;
    }

    public d.xj ai() {
        return this.f;
    }

    public float am() {
        return this.cy;
    }

    public boolean aq() {
        return this.ho;
    }

    public com.bytedance.adsdk.ugeno.kd.xj.xj b() {
        return this.bh;
    }

    public T d() {
        return this.kd;
    }

    public float dc() {
        T t = this.kd;
        if (t instanceof com.bytedance.adsdk.ugeno.xj.c) {
            return ((com.bytedance.adsdk.ugeno.xj.c) t).getRubIn();
        }
        return 0.0f;
    }

    public JSONObject dk() {
        return this.w;
    }

    public float e() {
        return this.se;
    }

    public String en() {
        return this.f10070pl;
    }

    public void et() {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        if (TextUtils.isEmpty(this.r)) {
            if (this.i) {
                xj(this.ua);
                return;
            } else {
                this.ut.setColor(this.wo);
                w(this.wo);
                return;
            }
        }
        if (!this.r.startsWith("local://")) {
            io();
            return;
        }
        String replace = this.r.replace("local://", "");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = this.eu ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            Bitmap decodeStream = BitmapFactory.decodeStream(this.hf.getResources().openRawResource(com.bytedance.adsdk.ugeno.y.u.hf(this.hf, replace)), null, options);
            if (this.eu) {
                Bitmap xj = f.xj(this.hf, decodeStream, (int) this.ws);
                if (xj != null) {
                    bitmapDrawable2 = new BitmapDrawable(this.hf.getResources(), xj);
                    xj(bitmapDrawable2);
                }
                bitmapDrawable = new BitmapDrawable(this.hf.getResources(), decodeStream);
            } else {
                bitmapDrawable = new BitmapDrawable(this.hf.getResources(), decodeStream);
            }
            bitmapDrawable2 = bitmapDrawable;
            xj(bitmapDrawable2);
        } catch (Throwable unused) {
        }
    }

    public void eu() {
    }

    public int ff() {
        return (int) this.am;
    }

    public float g() {
        return this.gj;
    }

    public void hf(JSONObject jSONObject) {
        this.u = jSONObject;
        p();
    }

    public float hl() {
        T t = this.kd;
        if (t instanceof com.bytedance.adsdk.ugeno.xj.c) {
            return ((com.bytedance.adsdk.ugeno.xj.c) t).getShine();
        }
        return 0.0f;
    }

    public yo ht() {
        return this.da;
    }

    public void io() {
        c cVar = this.le;
        if (cVar != null) {
            cVar.xj();
        }
        com.bytedance.adsdk.ugeno.u.xj().hf().xj(this.d, this.r, new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.hf.w.4
            @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
            public void xj(final Bitmap bitmap) {
                if (bitmap == null) {
                    w wVar = w.this;
                    c cVar2 = wVar.le;
                    if (cVar2 != null) {
                        cVar2.hf(wVar, wVar.r);
                        return;
                    }
                    return;
                }
                w wVar2 = w.this;
                c cVar3 = wVar2.le;
                if (cVar3 != null) {
                    cVar3.xj(wVar2, wVar2.r);
                }
                w wVar3 = w.this;
                if (!wVar3.eu) {
                    f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.hf.w.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            w.this.xj(new BitmapDrawable(bitmap));
                        }
                    });
                    return;
                }
                final Bitmap xj = f.xj(wVar3.hf, bitmap, (int) wVar3.ws);
                if (xj != null) {
                    f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.hf.w.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.this.xj(new BitmapDrawable(xj));
                        }
                    });
                }
            }
        });
    }

    public String j() {
        return this.p;
    }

    public float jk() {
        return this.t;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void kd() {
        com.bytedance.adsdk.ugeno.w.xj xjVar = this.zm;
        if (xjVar != null) {
            g gVar = new g(this.kd, xjVar);
            this.uf = gVar;
            gVar.xj();
        }
        com.bytedance.adsdk.ugeno.xj.xj xjVar2 = this.gy;
        if (xjVar2 != null) {
            xjVar2.xj();
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            yVar.hf();
        }
        ht htVar = this.m;
        if (htVar != null) {
            htVar.u();
        }
        com.bytedance.adsdk.ugeno.kd.d dVar = this.si;
        if (dVar != null) {
            dVar.kd();
        }
        if (this.nt != null && xj(10)) {
            this.nt.xj();
        }
        if (this.ey != null && xj(9)) {
            this.ey.xj();
        }
        kd kdVar = this.ci;
        if (kdVar != null) {
            kdVar.xj();
        }
        this.vh = System.currentTimeMillis();
    }

    public int l() {
        return (int) this.g;
    }

    public boolean n() {
        return this.wa > 0.0f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        kd kdVar;
        yo yoVar;
        com.bytedance.adsdk.ugeno.w.hf.w wVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            ws();
        } else if (action == 1 || action == 3) {
            eu();
        }
        jk jkVar = this.zb;
        if (jkVar != null) {
            jkVar.xj(this, motionEvent);
        }
        if (xj(17) && motionEvent.getAction() == 0) {
            this.da.xj(this.oa.get(17), this, this);
        }
        if (xj(1) && this.jw && (yoVar = this.da) != null && (wVar = this.ic) != null) {
            return wVar.xj(yoVar, this, motionEvent);
        }
        yo yoVar2 = this.da;
        if (yoVar2 != null && (kdVar = this.ci) != null) {
            return kdVar.xj(yoVar2, this, motionEvent, aq());
        }
        com.bytedance.adsdk.ugeno.kd.d dVar = this.si;
        if (dVar != null) {
            return dVar.xj(motionEvent);
        }
        return false;
    }

    public void p() {
        this.ho = this.u.optBoolean("gesture_through_enable", false);
    }

    public void pl() {
        this.kd.setPadding((int) (this.en ? this.x : this.f10069io), (int) (this.ff ? this.q : this.f10069io), (int) (this.l ? this.ai : this.f10069io), (int) (this.f10068a ? this.z : this.f10069io));
    }

    public float pz() {
        return this.n;
    }

    public boolean q() {
        return this.tf;
    }

    public float qt() {
        return this.vl;
    }

    public int r() {
        return this.wo;
    }

    public long ra() {
        return this.vh;
    }

    public JSONObject tf() {
        return this.u;
    }

    public void tj() {
        kd kdVar = this.ci;
        if (kdVar != null) {
            kdVar.hf();
        }
    }

    public float v() {
        return this.rg;
    }

    public float vm() {
        T t = this.kd;
        if (t instanceof com.bytedance.adsdk.ugeno.xj.c) {
            return ((com.bytedance.adsdk.ugeno.xj.c) t).getStretch();
        }
        return 0.0f;
    }

    public boolean wn() {
        return this.mg;
    }

    public boolean wo() {
        return this.gh;
    }

    public void ws() {
    }

    public ViewGroup.LayoutParams x() {
        return this.op;
    }

    public T xj() {
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void y() {
        g gVar = this.uf;
        if (gVar != null) {
            gVar.hf();
        }
        com.bytedance.adsdk.ugeno.xj.xj xjVar = this.gy;
        if (xjVar != null) {
            xjVar.w();
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            yVar.w();
        }
        ht htVar = this.m;
        if (htVar != null) {
            htVar.kd();
        }
        u.xj xjVar2 = this.vw;
        if (xjVar2 != null) {
            xjVar2.hf();
        }
    }

    public float yo() {
        return this.ft;
    }

    public float yy() {
        T t = this.kd;
        if (t instanceof com.bytedance.adsdk.ugeno.xj.c) {
            return ((com.bytedance.adsdk.ugeno.xj.c) t).getRipple();
        }
        return 0.0f;
    }

    public xj z() {
        return this.y;
    }

    public float zg() {
        return this.h;
    }

    public w(Context context, xj<ViewGroup> xjVar) {
        this.g = -2.0f;
        this.am = -2.0f;
        this.bl = "solid";
        this.lw = 0;
        this.gh = true;
        this.ss = 0.0f;
        this.gj = 0.0f;
        this.cy = 0.0f;
        this.xv = 1.0f;
        this.vl = 1.0f;
        this.h = 1.0f;
        this.ne = 0.0f;
        this.se = 0.0f;
        this.ft = 0.0f;
        this.rg = 0.0f;
        this.t = 1.0f;
        this.zd = true;
        this.qf = true;
        this.sv = false;
        this.uj = false;
        this.ho = false;
        this.wx = 12.0f;
        this.hf = context;
        this.y = xjVar;
        this.oa = new HashMap();
        this.ut = new GradientDrawable();
        this.kd = xj();
    }

    private ImageView.ScaleType p(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.b = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.b = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.b = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.b = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.b;
    }

    public List<com.bytedance.adsdk.ugeno.kd.w.hf> d(String str) {
        com.bytedance.adsdk.ugeno.kd.d dVar;
        if (TextUtils.isEmpty(str) || (dVar = this.si) == null) {
            return null;
        }
        return dVar.xj(str);
    }

    public com.bytedance.adsdk.ugeno.xj.xj tf(String str) {
        com.bytedance.adsdk.ugeno.xj.xj xjVar = this.gy;
        if (xjVar != null && TextUtils.equals(str, xjVar.kd())) {
            return this.gy;
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            return yVar.xj(str);
        }
        return null;
    }

    public w<T> u(String str) {
        return xj(str);
    }

    public void w(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public void xj(JSONObject jSONObject) {
        this.u = jSONObject;
        p();
        JSONObject jSONObject2 = this.w;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        xj<ViewGroup> xjVar = this.y;
        xj.C0026xj f = xjVar != null ? xjVar.f() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String xj = com.bytedance.adsdk.ugeno.u.hf.xj(this.w.optString(next), jSONObject);
            xj(next, xj);
            if (f != null) {
                f.xj(this.hf, next, xj);
            }
        }
        if (f != null) {
            xj(f.xj());
        }
        if (this.kr == null || this.u == null) {
            return;
        }
        try {
            if (!q()) {
                this.u.put("i18n", this.kr);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("i18n", this.kr);
            this.u.put("xNode", jSONObject3);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void hf() {
        et();
        pl();
        hf(this.lw);
        c();
        f();
        com.bytedance.adsdk.ugeno.kd.d dVar = this.si;
        if (dVar != null) {
            dVar.xj();
            this.si.hf();
            this.si.w();
        }
        this.kd.setOnTouchListener(this);
        s();
        ViewGroup viewGroup = (ViewGroup) this.kd.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.zd);
        }
        com.bytedance.adsdk.ugeno.xj.xj xjVar = this.gy;
        if (xjVar != null) {
            xjVar.u();
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            yVar.xj();
        }
        com.bytedance.adsdk.ugeno.kd.d dVar2 = this.si;
        if (dVar2 != null) {
            dVar2.u();
        }
        if (this.da == null || !xj(22)) {
            return;
        }
        this.da.xj(this.oa.get(22), this, this);
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void u() {
        if (this.m == null || this.ah) {
            return;
        }
        this.ah = true;
    }

    public void w(int i) {
        this.ut.setShape(0);
        this.ut.setColor(i);
        qd();
        dq();
        this.kd.setBackground(this.ut);
    }

    private boolean pl(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void u(int i) {
        if (q()) {
            T t = this.kd;
            if (t instanceof hf) {
                ((hf) t).xj(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hf) {
                ((hf) viewParent).xj(this.kd, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.kd.getLayoutParams();
        layoutParams.width = i;
        this.kd.setLayoutParams(layoutParams);
    }

    public w<T> w(String str) {
        if (tf(str) != null) {
            return this;
        }
        return null;
    }

    public void w(boolean z) {
        this.tf = z;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void w() {
        if (this.m == null || this.ir) {
            return;
        }
        this.ir = true;
    }

    public w<T> y(String str) {
        return w(str);
    }

    public w<T> kd(String str) {
        return hf(str);
    }

    public void kd(int i) {
        if (q()) {
            T t = this.kd;
            if (t instanceof hf) {
                ((hf) t).hf(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof hf) {
                ((hf) viewParent).hf(this.kd, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.kd.getLayoutParams();
        layoutParams.height = i;
        this.kd.setLayoutParams(layoutParams);
    }

    public void c(String str) {
        this.p = str;
    }

    public void xj(ht htVar) {
        this.m = htVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void xj(boolean z) {
        ht htVar = this.m;
        if (htVar != null) {
            htVar.xj(z);
        }
    }

    public boolean xj(int i) {
        Map<Integer, zg> map = this.oa;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void hf(boolean z) {
        this.jw = z;
    }

    public void xj(jk jkVar) {
        this.zb = jkVar;
    }

    public void hf(int i) {
        ViewParent viewParent = (ViewGroup) this.kd.getParent();
        if (viewParent instanceof hf) {
            ((hf) viewParent).w(this.kd, i);
        } else {
            this.kd.setVisibility(i);
        }
    }

    public void xj(yo yoVar) {
        this.da = yoVar;
    }

    public void xj(xj.C0035xj c0035xj) {
        if (c0035xj == null) {
            return;
        }
        this.ut.setShape(0);
        this.ut.setOrientation(c0035xj.xj);
        if (Build.VERSION.SDK_INT >= 29) {
            this.ut.setColors(c0035xj.hf, c0035xj.w);
        } else {
            this.ut.setColors(c0035xj.hf);
        }
        qd();
        dq();
        this.kd.setBackground(this.ut);
    }

    public w<T> hf(String str) {
        if (TextUtils.isEmpty(this.f10070pl) || !TextUtils.equals(this.f10070pl, str)) {
            return null;
        }
        return this;
    }

    public void f(String str) {
        this.f10070pl = str;
    }

    public void hf(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.oa == null) {
            return;
        }
        try {
            int type = e.xj(str).getType();
            zg zgVar = new zg();
            zgVar.xj(type);
            zgVar.xj(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.wx = Float.parseFloat(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("shakeAmplitude"), this.u));
                } catch (NumberFormatException unused) {
                    this.wx = 12.0f;
                }
            }
            yo yoVar = this.da;
            if (!(yoVar instanceof com.bytedance.adsdk.ugeno.w.xj.hf)) {
                xj(type, jSONObject, zgVar);
            } else if (!((com.bytedance.adsdk.ugeno.w.xj.hf) yoVar).xj()) {
                xj(type, jSONObject, zgVar);
            } else {
                zgVar.xj(jSONObject);
                this.oa.put(Integer.valueOf(type), zgVar);
            }
        } catch (JSONException unused2) {
        }
    }

    public void xj(Drawable drawable) {
        this.kd.setBackground(drawable);
    }

    public void xj(ViewGroup.LayoutParams layoutParams) {
        T t = this.kd;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.op = layoutParams;
    }

    public void xj(boolean z, boolean z2) {
        if (this.kd != null) {
            xj(this.op);
            if (z) {
                u((int) this.g);
            }
            if (z2) {
                kd((int) this.am);
            }
        }
    }

    public void xj(d.xj xjVar) {
        this.f = xjVar;
    }

    public w<T> xj(String str) {
        if (TextUtils.isEmpty(this.p) || !TextUtils.equals(this.p, str)) {
            return null;
        }
        return this;
    }

    public void xj(xj xjVar) {
        this.y = xjVar;
    }

    public void xj(am amVar) {
        this.d = amVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void hf(int i, int i2, int i3, int i4) {
        g gVar = this.uf;
        if (gVar != null) {
            gVar.xj(i, i2);
        }
        com.bytedance.adsdk.ugeno.xj.xj xjVar = this.gy;
        if (xjVar != null) {
            xjVar.xj(i, i2);
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            yVar.xj(i, i2);
        }
    }

    public void xj(tf tfVar) {
        this.k = tfVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    c = 0;
                    break;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    c = 1;
                    break;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    c = 2;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c = 3;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 4;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c = 5;
                    break;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    c = 6;
                    break;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    c = 7;
                    break;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    c = '\b';
                    break;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    c = '\t';
                    break;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    c = '\n';
                    break;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    c = 11;
                    break;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    c = '\f';
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c = '\r';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    c = 14;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals(MediaFormat.KEY_HEIGHT)) {
                    c = 15;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c = 16;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 17;
                    break;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    c = 18;
                    break;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    c = 19;
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c = 20;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 21;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 22;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c = 23;
                    break;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    c = 24;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 25;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c = 26;
                    break;
                }
                break;
            case 3355:
                if (str.equals(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)) {
                    c = 27;
                    break;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    c = 28;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 29;
                    break;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    c = 30;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = 31;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c = ' ';
                    break;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    c = '!';
                    break;
                }
                break;
            case 108285963:
                if (str.equals(n.C)) {
                    c = '\"';
                    break;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    c = '#';
                    break;
                }
                break;
            case 113126854:
                if (str.equals(MediaFormat.KEY_WIDTH)) {
                    c = '$';
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '%';
                    break;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    c = '&';
                    break;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    c = '\'';
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    c = '(';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c = ')';
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    c = '*';
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    c = '+';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = ',';
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = Soundex.SILENT_MARKER;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c = '.';
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c = '/';
                    break;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    c = '0';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = '1';
                    break;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    c = '2';
                    break;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    c = '3';
                    break;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    c = '4';
                    break;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    c = '5';
                    break;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    c = '6';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = '7';
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c = '8';
                    break;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    c = '9';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = ':';
                    break;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    c = ';';
                    break;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    c = '<';
                    break;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    c = '=';
                    break;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    c = '>';
                    break;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    c = '?';
                    break;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    c = '@';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 'A';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 'B';
                    break;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    c = 'C';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.qf = com.bytedance.adsdk.ugeno.y.w.xj(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 18:
            case '!':
            case '\'':
            case '0':
            case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
            case '6':
            case '>':
            case '@':
                hf(str, str2);
                break;
            case 2:
                this.xj = true;
                this.gj = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case 3:
                this.my = true;
                this.cy = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case 4:
                this.x = f.xj(this.hf, str2);
                this.en = true;
                break;
            case 5:
                this.jk = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case 11:
            case '7':
                if (com.bytedance.adsdk.ugeno.y.xj.w(str2)) {
                    this.i = true;
                    this.ua = com.bytedance.adsdk.ugeno.y.xj.hf(str2);
                    break;
                } else {
                    this.wo = com.bytedance.adsdk.ugeno.y.xj.xj(str2, 0);
                    this.i = false;
                    break;
                }
            case '\f':
                this.si = com.bytedance.adsdk.ugeno.kd.d.xj(this, str2);
                break;
            case '\r':
                this.kc = true;
                this.t = com.bytedance.adsdk.ugeno.y.w.xj(str2, 1.0f);
                break;
            case 14:
                this.yy = f.xj(this.hf, str2);
                this.wn = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.am = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.am = -2.0f;
                } else {
                    this.am = f.xj(this.hf, str2);
                }
                this.uj = true;
                break;
            case 16:
                this.qt = f.xj(this.hf, str2);
                break;
            case 17:
                this.yo = f.xj(this.hf, str2);
                this.dk = true;
                break;
            case 19:
            case '8':
                this.r = str2;
                break;
            case 20:
                this.cu = true;
                this.ne = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case 21:
                this.lm = true;
                this.vl = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case 22:
                this.vi = true;
                this.h = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case 23:
                this.f10069io = f.xj(this.hf, str2);
                this.j = true;
                break;
            case 24:
                this.ol = str2;
                break;
            case 25:
                this.v = f.xj(this.hf, str2);
                this.et = true;
                break;
            case 26:
                this.pz = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case 27:
                this.p = str2;
                break;
            case 28:
                this.kr = com.bytedance.adsdk.ugeno.y.hf.xj(str2, (JSONObject) null);
                break;
            case 29:
                this.f10070pl = str2;
                break;
            case 30:
                float xj = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                this.ws = xj;
                if (xj > 0.0f) {
                    this.eu = true;
                    break;
                }
                break;
            case 31:
                this.q = f.xj(this.hf, str2);
                this.ff = true;
                break;
            case ' ':
                this.he = str2;
                break;
            case '\"':
                this.wa = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case '#':
                this.lm = true;
                this.vi = true;
                float[] w = com.bytedance.adsdk.ugeno.xj.u.w(str2);
                this.vl = w[0];
                this.h = w[1];
                break;
            case '$':
                if (TextUtils.equals(str2, "match_parent")) {
                    this.g = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.g = -2.0f;
                } else {
                    this.g = f.xj(this.hf, str2);
                }
                this.sv = true;
                break;
            case '%':
                this.z = f.xj(this.hf, str2);
                this.f10068a = true;
                break;
            case '&':
                List<com.bytedance.adsdk.ugeno.xj.w> xj2 = com.bytedance.adsdk.ugeno.xj.u.xj(str2, this.u);
                if (xj2 != null && !xj2.isEmpty()) {
                    this.nb = new com.bytedance.adsdk.ugeno.xj.y(this.hf, this, xj2);
                    break;
                }
                break;
            case '(':
                this.vm = f.xj(this.hf, str2);
                this.aq = true;
                break;
            case ')':
                this.zd = pl(str2);
                break;
            case '*':
                this.hl = f.xj(this.hf, str2);
                this.tu = true;
                break;
            case '+':
                this.dc = f.xj(this.hf, str2);
                this.s = true;
                break;
            case ',':
                this.ai = f.xj(this.hf, str2);
                this.l = true;
                break;
            case '-':
                this.qd = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case '.':
                this.bl = str2;
                break;
            case '/':
                this.dq = f.xj(this.hf, str2);
                break;
            case '1':
                this.e = f.xj(this.hf, str2);
                this.ra = true;
                break;
            case '2':
                this.xj = true;
                this.my = true;
                float[] w2 = com.bytedance.adsdk.ugeno.xj.u.w(str2);
                this.gj = f.xj(this.hf, w2[0]);
                this.cy = f.xj(this.hf, w2[1]);
                break;
            case '4':
                try {
                    this.gy = new com.bytedance.adsdk.ugeno.xj.xj(this.hf, this, com.bytedance.adsdk.ugeno.xj.u.xj(new JSONObject(str2), this.u));
                    break;
                } catch (JSONException e) {
                    pl.xj(e);
                    return;
                }
            case '5':
                this.zm = com.bytedance.adsdk.ugeno.w.xj.xj(str2, this);
                break;
            case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                this.tj = true;
                this.b = p(str2);
                break;
            case ':':
                this.n = f.xj(this.hf, str2);
                break;
            case ';':
                this.no = true;
                this.se = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case '<':
                this.qi = true;
                this.ft = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case '=':
                this.rg = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case '?':
                this.mg = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                break;
            case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                if (TextUtils.equals("visible", str2)) {
                    this.lw = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.lw = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.lw = 8;
                }
                this.kd.setVisibility(this.lw);
                break;
            case 'B':
                this.zg = f.xj(this.hf, str2);
                this.ht = true;
                break;
            case 'C':
                this.gh = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    public w hf(w wVar) {
        return (wVar.z() == null && (wVar instanceof xj)) ? wVar : hf(wVar.z());
    }

    @Deprecated
    public void xj(int i, JSONObject jSONObject, zg zgVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject(cb.o);
        if (optJSONObject != null) {
            zg zgVar2 = new zg();
            zgVar2.xj(optJSONObject);
            zgVar2.xj(this);
            zgVar.xj(zgVar2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("fail");
        if (optJSONObject2 != null) {
            zg zgVar3 = new zg();
            zgVar3.xj(optJSONObject2);
            zgVar3.xj(this);
            zgVar.hf(zgVar3);
        }
        zgVar.xj(jSONObject);
        this.oa.put(Integer.valueOf(i), zgVar);
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public int[] xj(int i, int i2) {
        if (this.wa > 0.0f) {
            if (this.sv) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.wa;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.uj) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.wa;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.m != null && !this.lx) {
            this.lx = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void xj(int i, int i2, int i3, int i4) {
        if (this.m == null || this.ew) {
            return;
        }
        this.ew = true;
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void xj(Canvas canvas, com.bytedance.adsdk.ugeno.w.kd kdVar) {
        g gVar = this.uf;
        if (gVar != null) {
            gVar.xj(canvas, kdVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w
    public void xj(Canvas canvas) {
        com.bytedance.adsdk.ugeno.xj.xj xjVar = this.gy;
        if (xjVar != null) {
            xjVar.xj(canvas);
        }
        com.bytedance.adsdk.ugeno.xj.y yVar = this.nb;
        if (yVar != null) {
            yVar.xj(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo.hf
    public void xj(zg zgVar) {
        xj<ViewGroup> xjVar;
        w<T> u;
        if (zgVar == null || zgVar.w() == null) {
            return;
        }
        u.xj xjVar2 = this.vw;
        if (xjVar2 != null) {
            xjVar2.hf();
        }
        if (TextUtils.equals(zgVar.w().optString(PointParamKey.TYPE), "onDismiss")) {
            String optString = zgVar.w().optString("nodeId");
            hf(8);
            this.c = (xj) hf(this);
            if (TextUtils.isEmpty(optString) || (xjVar = this.c) == null || (u = xjVar.u(optString)) == null) {
                return;
            }
            u.hf(8);
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.kd.xj.xj xjVar) {
        this.bh = xjVar;
    }

    public void xj(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> d = d(str);
        if (d == null || d.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : d) {
            hfVar.xj(this.si);
            hfVar.xj(objArr);
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.w.y yVar) {
        com.bytedance.adsdk.ugeno.kd.d dVar = this.si;
        if (dVar != null) {
            dVar.xj(yVar);
        }
    }

    public void xj(c cVar) {
        this.le = cVar;
    }
}
