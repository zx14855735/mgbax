package com.kwad.components.core.r.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a extends com.kwad.components.core.m.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> abZ = new ConcurrentHashMap();
    private static final AtomicInteger aca = new AtomicInteger(1);
    private StyleTemplate abS;
    private String abT;
    private boolean abU;
    private n abV;
    private k abW;
    private com.kwad.components.core.r.b.b abX;
    private int abY;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    static {
        cuCe();
    }

    public static void a(int i, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = abZ;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    private Object aR(String str) {
        return r(this.abY, str);
    }

    private static void br(int i) {
        Map<String, Object> map = abZ.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    private static /* synthetic */ void cuCe() {
        char[] charArray = "\u009d\u0091\u0093Ð\u0099\u009f\u0093\u009bÐ\u009c\u0091\u0087Ð\u008d\u0096\u009b\u0092\u0092Ð´\u0090\u0097¼\u008c\u0097\u009a\u0099\u009b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 254);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009d\u0092\u0097\u0090\u0097\u008a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 254);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Object r(int i, String str) {
        Map<String, Object> map = abZ.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @InvokeBy(invokerClass = c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        c.putComponentProxy(FeedDownloadActivity.class, a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.b
    /* renamed from: uj, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.a(this.mAdResultData);
        bVar.abS = this.abS;
        bVar.mRootContainer = this.mRootContainer;
        bVar.abV = this.abV;
        bVar.abW = this.abW;
        return bVar;
    }

    public static int uk() {
        return aca.incrementAndGet();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        this.abY = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) aR("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.abS = styleTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return false;
            }
        }
        if (kVar != null) {
            this.abW = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d = f.oy().d(intExtra, true);
        this.mAdResultData = d;
        return intExtra <= 0 || d != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.abU = getIntent().getBooleanExtra("show_navigationBar", true);
        this.abT = getIntent().getStringExtra("title");
        this.abV = (n) aR("native_intent");
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.abU && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0280a() { // from class: com.kwad.components.core.r.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0280a
            public final void x(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0280a
            public final void y(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.abT));
        this.mTitleBarHelper.ak(false);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.r.b.b bVar = this.abX;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        if (this.abS != null) {
            return new com.kwad.components.core.r.b.a();
        }
        if (this.abX == null) {
            this.abX = new com.kwad.components.core.r.b.b();
        }
        return this.abX;
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            br(this.abY);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
