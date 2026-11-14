package com.sigmob.sdk.nativead;

import ADYaiT.CtFAbx;
import Dphsd2.AlLFFp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.d;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.natives.WindNativeAdData;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, v {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13602a = "DisLikeDialog";
    private final SoftReference<Context> b;
    private final Context c;
    private final BaseAdUnit d;
    private WindNativeAdData.DislikeInteractionCallback e;
    private final List<String> f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private EditText k;
    private q l;

    /* renamed from: com.sigmob.sdk.nativead.b$1, reason: invalid class name */
    public class AnonymousClass1 implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f13603a;

        public AnonymousClass1(Context context) {
            this.f13603a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Context context) {
            ak.a(context, "反馈上报成功", 0).show();
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            WindAds.sharedAds().getHandler().post(new ASJ6gh(volleyError, 0, this.f13603a));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(VolleyError volleyError, Context context) {
            NetworkResponse networkResponse;
            ak.a(context, "反馈上报失败，错误码: " + ((volleyError == null || (networkResponse = volleyError.networkResponse) == null) ? 0 : networkResponse.statusCode), 1).show();
        }

        @Override // com.sigmob.sdk.base.network.d.a
        public void a(JSONObject jSONObject) {
            WindAds.sharedAds().getHandler().post(new ARc23Z(0, this.f13603a));
        }
    }

    public b(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.k.e());
        this.f = new ArrayList();
        this.b = new SoftReference<>(context);
        this.c = context.getApplicationContext();
        this.d = baseAdUnit;
        c();
    }

    private void c() {
        this.f.clear();
        this.f.add("违法违规");
        this.f.add("疑似抄袭");
        this.f.add("虚假欺诈");
        this.f.add("低俗色情");
        this.f.add("诱导点击");
    }

    private void d() {
        Context e = com.sigmob.sdk.b.e();
        BaseAdUnit baseAdUnit = this.d;
        if (baseAdUnit == null) {
            ak.a(e, "感谢反馈", 0).show();
            return;
        }
        baseAdUnit.dislikeReport();
        if (!com.sigmob.sdk.base.o.a().g()) {
            ak.a(e, "感谢反馈", 0).show();
            return;
        }
        BidResponse a2 = com.sigmob.sdk.base.common.h.a(this.d.getRequestId());
        if (a2 == null) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new AlLFFp(8, this, a2, e));
    }

    private void e() {
        int i;
        Window window = getWindow();
        Context context = getContext();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        int dipsToIntPixels = Dips.dipsToIntPixels(0.0f, context);
        int i4 = -1;
        if (i3 > i2) {
            i4 = i2 - dipsToIntPixels;
            i = -1;
        } else {
            i = i3 - dipsToIntPixels;
        }
        attributes.width = i4;
        attributes.height = i;
        window.setAttributes(attributes);
        int g = com.sigmob.sdk.base.k.g();
        if (g <= 0) {
            return;
        }
        window.setWindowAnimations(g);
    }

    public void b() {
        TextView textView = this.g;
        if (textView != null) {
            textView.setOnClickListener(null);
            this.g = null;
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setOnClickListener(null);
            this.h = null;
        }
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setOnClickListener(null);
            this.i = null;
        }
        TextView textView4 = this.j;
        if (textView4 != null) {
            textView4.setOnClickListener(null);
            this.j = null;
        }
        if (this.e != null) {
            this.e = null;
        }
        setOnShowListener(null);
        setOnDismissListener(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        String obj;
        String str = "";
        if (view.equals(this.h)) {
            String str2 = (String) this.h.getText();
            a(PointCategory.DISLIKE, PointCategory.ADNORMAL_SHOW, "", "");
            str = str2;
            i = 1;
        } else {
            if (view.equals(this.i)) {
                obj = (String) this.i.getText();
                a(PointCategory.DISLIKE, PointCategory.CANNOT_CLOSE, "", "");
                i = 2;
            } else if (view.equals(this.g)) {
                obj = (String) this.g.getText();
                a(PointCategory.DISLIKE, PointCategory.NOINTEREST_CLICK, "", "");
                i = 3;
            } else {
                i = 0;
                if (view.equals(this.j) && com.sigmob.sdk.base.utils.q.b(this.k)) {
                    obj = this.k.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        ak.a(com.sigmob.sdk.b.e(), "请输入反馈文字", 0).show();
                        return;
                    } else {
                        a(PointCategory.DISLIKE, PointCategory.ADVICE, "", Base64.encodeToString(obj.getBytes(), 0));
                        i = 5;
                    }
                }
            }
            str = obj;
        }
        d();
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.e;
        if (dislikeInteractionCallback == null || i == 0) {
            return;
        }
        dislikeInteractionCallback.onSelected(i, str, true);
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtil.getLayoutId(this.c, "sig_dislike_layout"));
        View findViewById = findViewById(ResourceUtil.getId(this.c, "sig_dislike_sv"));
        ViewGroup viewGroup = (ViewGroup) findViewById(ResourceUtil.getId(this.c, "sig_dislike_ll"));
        viewGroup.setLongClickable(true);
        viewGroup.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sigmob.sdk.nativead.A5SV6n
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean b;
                b = b.this.b(view);
                return b;
            }
        });
        this.h = (TextView) findViewById(ResourceUtil.getId(this.c, "sig_not_show_tv"));
        this.i = (TextView) findViewById(ResourceUtil.getId(this.c, "sig_not_close_tv"));
        this.g = (TextView) findViewById(ResourceUtil.getId(this.c, "sig_dislike_tv"));
        this.j = (TextView) findViewById(ResourceUtil.getId(this.c, "sig_commit_sl"));
        this.k = (EditText) findViewById(ResourceUtil.getId(this.c, "sig_suggest_et"));
        findViewById.setOnClickListener(new ADYaiT(0, this));
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.addTextChangedListener(new TextWatcher() { // from class: com.sigmob.sdk.nativead.b.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable.toString()) && com.sigmob.sdk.base.utils.q.b(b.this.j)) {
                    b.this.j.setTextColor(Color.parseColor("#C2C2C2"));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (b.this.j == null) {
                    return;
                }
                b.this.j.setTextColor(Color.parseColor("#FE7E03"));
            }
        });
        q qVar = new q(this.c);
        this.l = qVar;
        qVar.setList(this.f);
        this.l.setOnItemClickListener(new AMqCpz(this));
        ((ViewGroup) findViewById(ResourceUtil.getId(this.c, "sig_flow_sl"))).addView(this.l, new ViewGroup.LayoutParams(-1, -2));
        setOnShowListener(this);
        setOnDismissListener(this);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        e();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog#onDismiss");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.e;
        if (dislikeInteractionCallback == null) {
            return;
        }
        dislikeInteractionCallback.onCancel();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog#onShow");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.e;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
        q qVar = this.l;
        if (qVar != null) {
            qVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(View view) {
        Context context;
        BaseAdUnit baseAdUnit = this.d;
        if (baseAdUnit == null) {
            return false;
        }
        String BChYOn2 = CtFAbx.BChYOn("广告请求 ID\n", baseAdUnit.getRequestId());
        SoftReference<Context> softReference = this.b;
        if (softReference != null && (context = softReference.get()) != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                new c(activity, BChYOn2).show();
                return true;
            }
        }
        return false;
    }

    @Override // com.sigmob.sdk.nativead.v
    public void a() {
        BaseAdUnit baseAdUnit = this.d;
        if (baseAdUnit == null || (baseAdUnit.isDislikeReported() && this.d.getAd_type() != 5)) {
            ak.a(getContext(), "已提交反馈", 0).show();
        } else {
            show();
            a(PointCategory.DISLIKE, "click", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str) {
        d();
        a(PointCategory.DISLIKE, PointCategory.REPORT, String.valueOf(i), "");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.e;
        if (dislikeInteractionCallback == null) {
            return;
        }
        dislikeInteractionCallback.onSelected(4, str, true);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BidResponse bidResponse, Context context) {
        com.sigmob.sdk.base.network.d dVar = new com.sigmob.sdk.base.network.d(com.sigmob.sdk.base.o.a().s(), bidResponse, new AnonymousClass1(context));
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            return;
        }
        sigRequestQueue.add(dVar);
    }

    @Override // com.sigmob.sdk.nativead.v
    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.e = dislikeInteractionCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setAdtype(String.valueOf(this.d.getAd_type()));
            pointEntitySigmob.setLoad_id(this.d.getLoad_id());
            pointEntitySigmob.setRequest_id(this.d.getRequestId());
            pointEntitySigmob.setReason(str);
            pointEntitySigmob.setContent(str2);
            pointEntitySigmob.setVid(this.d.getVid());
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        com.sigmob.sdk.base.common.ae.a(str, str2, this.d, new GnQT2j.A4TApA(this, str3, str4));
    }
}
