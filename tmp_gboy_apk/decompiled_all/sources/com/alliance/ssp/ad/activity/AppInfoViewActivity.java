package com.alliance.ssp.ad.activity;

import ADYaiT.BChYOn;
import Dphsd2.A2egSU;
import Dphsd2.A5SV6n;
import Dphsd2.AMqCpz;
import Dphsd2.ARc23Z;
import Dphsd2.ASJ6gh;
import Fyurov.ADYaiT;
import GJee0v.AZkASS;
import H0qugq.AZOQYO;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.sigmob.sdk.base.blurkit.d;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AppInfoViewActivity extends Activity {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static AZOQYO f9605B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static NMRewardVideoActivity f9606B3GDIM;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public SAAllianceAdData f9607AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f9608AlLFFp = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f9609AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f9610AzWtSf = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public FrameLayout f9611B25kr6;

    public static Bitmap A4TApA(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        float f = i;
        float f2 = i2;
        float height = (1.0f * f2) / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale((f * 1.0f) / bitmap.getWidth(), height);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f3 = i3;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f2), f3, f3, paint);
        return createBitmap;
    }

    public static /* synthetic */ void a(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(View view) {
        if (view.getVisibility() == 8) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final int A2egSU(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final WebView A5SV6n(String str) {
        WebView webView = new WebView(this);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setWebViewClient(new WebViewClient());
        GYpKKt.AZOQYO.A2egSU(webView, this.f9609AmA8tU, this.f9610AzWtSf);
        runOnUiThread(new AMqCpz(this, this.f9607AcNBzu.getTagCode(), webView, str));
        return webView;
    }

    public final FrameLayout ADYaiT() {
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.setMargins(0, A2egSU(4.0f), 0, A2egSU(4.0f));
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#edeeeeee"));
        frameLayout.setBackground(gradientDrawable);
        return frameLayout;
    }

    public final LinearLayout AMqCpz(float f, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i, f);
        linearLayout.setOrientation(i2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void ARc23Z(LinearLayout linearLayout) {
        ImageView imageView = new ImageView(this);
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
        BChYOn bChYOn = new BChYOn(this, 3, imageView);
        SAAllianceAdData sAAllianceAdData = this.f9607AcNBzu;
        if (sAAllianceAdData == null || sAAllianceAdData.getMaterial() == null || this.f9607AcNBzu.getMaterial().getIconurl() == null || this.f9607AcNBzu.getMaterial().getIconurl().isEmpty()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131231421);
            if (decodeResource != null) {
                imageView.setImageBitmap(A4TApA(decodeResource, A2egSU(56.0f), A2egSU(56.0f), A2egSU(16.0f)));
            }
        } else {
            AZkASS.f3040ADYaiT.f3041A2egSU.execute(bChYOn);
        }
        linearLayout.addView(imageView);
    }

    public final void ASJ6gh(LinearLayout linearLayout, float f, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{A2egSU(f), A2egSU(f), A2egSU(f2), A2egSU(f2), A2egSU(0.0f), A2egSU(0.0f), A2egSU(0.0f), A2egSU(0.0f)});
        linearLayout.setBackground(gradientDrawable);
    }

    public final ArrayList AYUAbz() {
        SAAllianceAdData sAAllianceAdData = this.f9607AcNBzu;
        if (sAAllianceAdData == null || sAAllianceAdData.getMaterial() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ARc23Z("应用名称", this.f9607AcNBzu.getMaterial().getApkname(), null, false));
        arrayList.add(new ARc23Z("版本", this.f9607AcNBzu.getMaterial().getVersionName(), null, false));
        arrayList.add(new ARc23Z("开发者名称", this.f9607AcNBzu.getMaterial().getAppPublisher(), null, false));
        arrayList.add(new ARc23Z("权限列表", null, this.f9607AcNBzu.getMaterial().getPermissionUrl(), true));
        arrayList.add(new ARc23Z("隐私协议", null, this.f9607AcNBzu.getMaterial().getPrivacyUrl(), true));
        arrayList.add(new ARc23Z("产品介绍", null, this.f9607AcNBzu.getMaterial().getAppIntro(), true));
        return arrayList;
    }

    public final void AZOQYO(LinearLayout linearLayout) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 86.0f);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        textView.setText("应用详情");
        textView.setTextColor(Color.parseColor("#1e1e1e"));
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r10v21, types: [android.view.View, android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r20v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r22v0, types: [android.app.Activity, android.content.Context, com.alliance.ssp.ad.activity.AppInfoViewActivity] */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r3v17, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v21, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View, android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r7v13, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r9v13, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        ADYaiT aDYaiT;
        FrameLayout frameLayout;
        ADYaiT aDYaiT2;
        final View view;
        FrameLayout frameLayout2;
        ADYaiT aDYaiT3;
        final View view2;
        super.onCreate(bundle);
        if (getIntent() == null) {
            return;
        }
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) getIntent().getParcelableExtra("app_info_ad_data_copy");
        this.f9607AcNBzu = sAAllianceAdData;
        if (sAAllianceAdData == null) {
            return;
        }
        this.f9608AlLFFp = sAAllianceAdData.getWebViewReplaceTagCode();
        this.f9609AmA8tU = this.f9607AcNBzu.getWebViewCloseAccess();
        this.f9610AzWtSf = this.f9607AcNBzu.getWebViewCloseCache();
        int i = 1;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#75000000")));
        String str = "#7c7c7c";
        int i2 = -1;
        if (getResources().getConfiguration().orientation == 2) {
            getWindow().setFlags(1024, 1024);
            ?? AMqCpz = AMqCpz(1.0f, 0, 1);
            AMqCpz.setBackgroundColor(d.f13043a);
            ?? AMqCpz2 = AMqCpz(65.0f, 0, 1);
            AMqCpz.addView(AMqCpz2);
            ?? AMqCpz3 = AMqCpz(30.0f, 0, 1);
            ASJ6gh(AMqCpz3, 14.0f, 14.0f);
            AMqCpz2.addView(AMqCpz3);
            ?? AMqCpz4 = AMqCpz(36.0f, 0, 1);
            ?? AMqCpz5 = AMqCpz(1.0f, -1, 0);
            View view3 = new View(this);
            view3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 5.0f));
            AMqCpz5.addView(view3);
            AZOQYO(AMqCpz5);
            int A2egSU2 = A2egSU(24.0f);
            Button button = new Button(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A2egSU2, A2egSU2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            button.setLayoutParams(layoutParams);
            ASJ6gh aSJ6gh = new ASJ6gh(this, button, 1);
            aSJ6gh.setShape(1);
            aSJ6gh.setColor(-1);
            aSJ6gh.setStroke(12, -1);
            button.setBackground(aSJ6gh);
            FrameLayout frameLayout3 = new FrameLayout(this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 5.0f);
            layoutParams2.gravity = 8388629;
            frameLayout3.setLayoutParams(layoutParams2);
            frameLayout3.addView(button);
            final int i3 = 1;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: Dphsd2.ADYaiT

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ AppInfoViewActivity f2434AlLFFp;

                {
                    this.f2434AlLFFp = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AppInfoViewActivity appInfoViewActivity = this.f2434AlLFFp;
                    switch (i3) {
                        case 0:
                            H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                            appInfoViewActivity.finish();
                            break;
                        default:
                            H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                            appInfoViewActivity.finish();
                            break;
                    }
                }
            });
            AMqCpz5.addView(frameLayout3);
            AMqCpz4.addView(AMqCpz5);
            AMqCpz3.addView(AMqCpz4);
            LinearLayout AMqCpz6 = AMqCpz(34.0f, 0, 1);
            ARc23Z(AMqCpz6);
            AMqCpz3.addView(AMqCpz6);
            ?? AMqCpz7 = AMqCpz(70.0f, 0, 1);
            ASJ6gh(AMqCpz7, 0.0f, 0.0f);
            ?? frameLayout4 = new FrameLayout(this);
            frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ?? frameLayout5 = new FrameLayout(this);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.bottomMargin = A2egSU(0.0f);
            frameLayout5.setLayoutParams(layoutParams3);
            ?? scrollView = new ScrollView(this);
            scrollView.setFillViewport(true);
            ?? linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            ArrayList AYUAbz2 = AYUAbz();
            if (AYUAbz2 != null && !AYUAbz2.isEmpty()) {
                Iterator it = AYUAbz2.iterator();
                AMqCpz2 = AMqCpz2;
                AMqCpz = AMqCpz;
                while (it.hasNext()) {
                    ARc23Z aRc23Z = (ARc23Z) it.next();
                    String str2 = aRc23Z.f2440A2egSU;
                    new FrameLayout(this);
                    ?? linearLayout2 = new LinearLayout(this);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setBackgroundColor(-1);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    Object obj = AMqCpz;
                    Iterator it2 = it;
                    Object obj2 = AMqCpz2;
                    layoutParams4.setMargins(A2egSU(16.0f), A2egSU(4.0f), A2egSU(16.0f), A2egSU(4.0f));
                    linearLayout2.setLayoutParams(layoutParams4);
                    ?? AMqCpz8 = AMqCpz(1.0f, -1, 0);
                    TextView textView = new TextView(this);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
                    textView.setTextSize(14.0f);
                    textView.setTextColor(d.f13043a);
                    textView.setText(str2);
                    AMqCpz8.addView(textView);
                    String str3 = aRc23Z.f2441A4TApA;
                    if (str3 != null) {
                        TextView textView2 = new TextView(this);
                        textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
                        textView2.setGravity(8388613);
                        textView2.setTextSize(14.0f);
                        textView2.setTextColor(Color.parseColor("#7c7c7c"));
                        textView2.setText(str3);
                        AMqCpz8.addView(textView2);
                    }
                    linearLayout2.addView(AMqCpz8);
                    if (aRc23Z.f2443ADYaiT) {
                        String str4 = aRc23Z.f2442A5SV6n;
                        if (str4 != null) {
                            View A5SV6n2 = A5SV6n(str4);
                            linearLayout2.addView(A5SV6n2);
                            A5SV6n2.setVisibility(8);
                            view = A5SV6n2;
                        } else {
                            TextView textView3 = new TextView(this);
                            textView3.setText("素材采集中...");
                            textView3.setTextSize(12.0f);
                            textView3.setTextColor(Color.parseColor("#7c7c7c"));
                            textView3.setVisibility(8);
                            linearLayout2.addView(textView3);
                            view = textView3;
                        }
                        final int i4 = 0;
                        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: Dphsd2.A4TApA
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                View view5 = view;
                                switch (i4) {
                                    case 0:
                                        H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                                        if (view5.getVisibility() != 8) {
                                            view5.setVisibility(8);
                                            break;
                                        } else {
                                            view5.setVisibility(0);
                                            break;
                                        }
                                    default:
                                        H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                                        if (view5.getVisibility() != 8) {
                                            view5.setVisibility(8);
                                            break;
                                        } else {
                                            view5.setVisibility(0);
                                            break;
                                        }
                                }
                            }
                        });
                        A5SV6n a5SV6n = new A5SV6n(view, 0);
                        int A2egSU3 = A2egSU(16.0f);
                        Button button2 = new Button(this);
                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(A2egSU3, A2egSU3);
                        layoutParams5.addRule(10);
                        layoutParams5.addRule(11);
                        button2.setLayoutParams(layoutParams5);
                        ASJ6gh aSJ6gh2 = new ASJ6gh(this, button2, 0);
                        aSJ6gh2.setShape(1);
                        aSJ6gh2.setColor(-1);
                        aSJ6gh2.setStroke(12, -1);
                        button2.setBackground(aSJ6gh2);
                        FrameLayout frameLayout6 = new FrameLayout(this);
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 2.0f);
                        layoutParams6.gravity = 8388629;
                        frameLayout6.setLayoutParams(layoutParams6);
                        frameLayout6.addView(button2);
                        AMqCpz8.addView(frameLayout6);
                        button2.setOnClickListener(new A2egSU(1, a5SV6n));
                    }
                    linearLayout2.addView(ADYaiT());
                    linearLayout.addView(linearLayout2);
                    it = it2;
                    AMqCpz = obj;
                    AMqCpz2 = obj2;
                }
            }
            ?? r18 = AMqCpz2;
            View view4 = AMqCpz;
            scrollView.addView(linearLayout);
            frameLayout5.addView(scrollView);
            frameLayout4.addView(frameLayout5);
            AMqCpz7.addView(frameLayout4);
            scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new DjONCG.A2egSU(scrollView, linearLayout, 1));
            this.f9611B25kr6 = new FrameLayout(this);
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, A2egSU(32.0f));
            layoutParams7.gravity = 80;
            layoutParams7.setMargins(A2egSU(200.0f), 0, A2egSU(200.0f), A2egSU(16.0f));
            this.f9611B25kr6.setLayoutParams(layoutParams7);
            AZOQYO azoqyo = f9605B2KMhB;
            if (azoqyo == null || (aDYaiT2 = azoqyo.f3208BV3sI0) == null) {
                NMRewardVideoActivity nMRewardVideoActivity = f9606B3GDIM;
                if (nMRewardVideoActivity != null && (aDYaiT = nMRewardVideoActivity.f9658DG07BK) != null && (frameLayout = aDYaiT.f2904B3GDIM) != null) {
                    if (frameLayout.getParent() == null) {
                        this.f9611B25kr6.addView(frameLayout);
                    }
                }
                frameLayout4.addView(this.f9611B25kr6);
            } else {
                FrameLayout frameLayout7 = aDYaiT2.f2904B3GDIM;
                if (frameLayout7 != null) {
                    if (frameLayout7.getParent() == null) {
                        this.f9611B25kr6.addView(frameLayout7);
                    }
                }
                frameLayout4.addView(this.f9611B25kr6);
            }
            r18.addView(AMqCpz7);
            setContentView(view4);
            return;
        }
        ?? AMqCpz9 = AMqCpz(1.0f, 0, 1);
        AMqCpz9.addView(AMqCpz(35.0f, 0, 1));
        ?? AMqCpz10 = AMqCpz(65.0f, 0, 1);
        AMqCpz9.addView(AMqCpz10);
        ?? AMqCpz11 = AMqCpz(30.0f, 0, 1);
        ASJ6gh(AMqCpz11, 14.0f, 14.0f);
        AMqCpz10.addView(AMqCpz11);
        ?? AMqCpz12 = AMqCpz(36.0f, 0, 1);
        ?? AMqCpz13 = AMqCpz(1.0f, -1, 0);
        View view5 = new View(this);
        view5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 12.0f));
        AMqCpz13.addView(view5);
        AZOQYO(AMqCpz13);
        int A2egSU4 = A2egSU(24.0f);
        Button button3 = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(A2egSU4, A2egSU4);
        layoutParams8.addRule(10);
        layoutParams8.addRule(11);
        button3.setLayoutParams(layoutParams8);
        ASJ6gh aSJ6gh3 = new ASJ6gh(this, button3, 1);
        aSJ6gh3.setShape(1);
        aSJ6gh3.setColor(-1);
        aSJ6gh3.setStroke(12, -1);
        button3.setBackground(aSJ6gh3);
        FrameLayout frameLayout8 = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2, 12.0f);
        layoutParams9.gravity = 8388629;
        frameLayout8.setLayoutParams(layoutParams9);
        frameLayout8.addView(button3);
        final int i5 = 0;
        button3.setOnClickListener(new View.OnClickListener(this) { // from class: Dphsd2.ADYaiT

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ AppInfoViewActivity f2434AlLFFp;

            {
                this.f2434AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view42) {
                AppInfoViewActivity appInfoViewActivity = this.f2434AlLFFp;
                switch (i5) {
                    case 0:
                        H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                        appInfoViewActivity.finish();
                        break;
                    default:
                        H0qugq.AZOQYO azoqyo22 = AppInfoViewActivity.f9605B2KMhB;
                        appInfoViewActivity.finish();
                        break;
                }
            }
        });
        AMqCpz13.addView(frameLayout8);
        AMqCpz12.addView(AMqCpz13);
        AMqCpz11.addView(AMqCpz12);
        LinearLayout AMqCpz14 = AMqCpz(34.0f, 0, 1);
        ARc23Z(AMqCpz14);
        AMqCpz11.addView(AMqCpz14);
        ?? AMqCpz15 = AMqCpz(70.0f, 0, 1);
        ASJ6gh(AMqCpz15, 0.0f, 0.0f);
        ?? frameLayout9 = new FrameLayout(this);
        frameLayout9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ?? frameLayout10 = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams10.bottomMargin = A2egSU(64.0f);
        frameLayout10.setLayoutParams(layoutParams10);
        ?? scrollView2 = new ScrollView(this);
        scrollView2.setFillViewport(true);
        ?? linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        ArrayList AYUAbz3 = AYUAbz();
        if (AYUAbz3 != null && !AYUAbz3.isEmpty()) {
            Iterator it3 = AYUAbz3.iterator();
            AMqCpz9 = AMqCpz9;
            AMqCpz10 = AMqCpz10;
            while (it3.hasNext()) {
                ARc23Z aRc23Z2 = (ARc23Z) it3.next();
                String str5 = aRc23Z2.f2440A2egSU;
                new FrameLayout(this);
                ?? linearLayout4 = new LinearLayout(this);
                linearLayout4.setOrientation(i);
                linearLayout4.setBackgroundColor(i2);
                String str6 = str;
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(i2, -2);
                Object obj3 = AMqCpz9;
                Iterator it4 = it3;
                Object obj4 = AMqCpz10;
                layoutParams11.setMargins(A2egSU(16.0f), A2egSU(4.0f), A2egSU(16.0f), A2egSU(4.0f));
                linearLayout4.setLayoutParams(layoutParams11);
                ?? AMqCpz16 = AMqCpz(1.0f, -1, 0);
                TextView textView4 = new TextView(this);
                textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
                textView4.setTextSize(14.0f);
                textView4.setTextColor(d.f13043a);
                textView4.setText(str5);
                AMqCpz16.addView(textView4);
                String str7 = aRc23Z2.f2441A4TApA;
                if (str7 != null) {
                    TextView textView5 = new TextView(this);
                    textView5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 50.0f));
                    textView5.setGravity(8388613);
                    textView5.setTextSize(14.0f);
                    textView5.setTextColor(Color.parseColor(str6));
                    textView5.setText(str7);
                    AMqCpz16.addView(textView5);
                }
                linearLayout4.addView(AMqCpz16);
                if (aRc23Z2.f2443ADYaiT) {
                    String str8 = aRc23Z2.f2442A5SV6n;
                    if (str8 != null) {
                        View A5SV6n3 = A5SV6n(str8);
                        linearLayout4.addView(A5SV6n3);
                        A5SV6n3.setVisibility(8);
                        view2 = A5SV6n3;
                    } else {
                        TextView textView6 = new TextView(this);
                        textView6.setText("素材采集中...");
                        textView6.setTextSize(12.0f);
                        textView6.setTextColor(Color.parseColor(str6));
                        textView6.setVisibility(8);
                        linearLayout4.addView(textView6);
                        view2 = textView6;
                    }
                    final int i6 = 1;
                    linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: Dphsd2.A4TApA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view42) {
                            View view52 = view2;
                            switch (i6) {
                                case 0:
                                    H0qugq.AZOQYO azoqyo2 = AppInfoViewActivity.f9605B2KMhB;
                                    if (view52.getVisibility() != 8) {
                                        view52.setVisibility(8);
                                        break;
                                    } else {
                                        view52.setVisibility(0);
                                        break;
                                    }
                                default:
                                    H0qugq.AZOQYO azoqyo22 = AppInfoViewActivity.f9605B2KMhB;
                                    if (view52.getVisibility() != 8) {
                                        view52.setVisibility(8);
                                        break;
                                    } else {
                                        view52.setVisibility(0);
                                        break;
                                    }
                            }
                        }
                    });
                    A5SV6n a5SV6n2 = new A5SV6n(view2, i6);
                    int A2egSU5 = A2egSU(16.0f);
                    Button button4 = new Button(this);
                    RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(A2egSU5, A2egSU5);
                    layoutParams12.addRule(10);
                    layoutParams12.addRule(11);
                    button4.setLayoutParams(layoutParams12);
                    ASJ6gh aSJ6gh4 = new ASJ6gh(this, button4, 0);
                    aSJ6gh4.setShape(1);
                    aSJ6gh4.setColor(-1);
                    aSJ6gh4.setStroke(12, -1);
                    button4.setBackground(aSJ6gh4);
                    FrameLayout frameLayout11 = new FrameLayout(this);
                    LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -2, 5.0f);
                    layoutParams13.gravity = 8388629;
                    frameLayout11.setLayoutParams(layoutParams13);
                    frameLayout11.addView(button4);
                    AMqCpz16.addView(frameLayout11);
                    button4.setOnClickListener(new A2egSU(0, a5SV6n2));
                }
                linearLayout4.addView(ADYaiT());
                linearLayout3.addView(linearLayout4);
                it3 = it4;
                AMqCpz9 = obj3;
                AMqCpz10 = obj4;
                str = str6;
                i = 1;
                i2 = -1;
            }
        }
        View view6 = AMqCpz9;
        ?? r20 = AMqCpz10;
        scrollView2.addView(linearLayout3);
        frameLayout10.addView(scrollView2);
        frameLayout9.addView(frameLayout10);
        AMqCpz15.addView(frameLayout9);
        scrollView2.getViewTreeObserver().addOnGlobalLayoutListener(new DjONCG.A2egSU(scrollView2, linearLayout3, 0));
        this.f9611B25kr6 = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-1, A2egSU(60.0f));
        layoutParams14.gravity = 80;
        layoutParams14.setMargins(A2egSU(40.0f), 0, A2egSU(40.0f), A2egSU(16.0f));
        this.f9611B25kr6.setLayoutParams(layoutParams14);
        AZOQYO azoqyo2 = f9605B2KMhB;
        if (azoqyo2 == null || (aDYaiT3 = azoqyo2.f3208BV3sI0) == null) {
            NMRewardVideoActivity nMRewardVideoActivity2 = f9606B3GDIM;
            if (nMRewardVideoActivity2 != null && (frameLayout2 = nMRewardVideoActivity2.f9658DG07BK.f2904B3GDIM) != null) {
                if (frameLayout2.getParent() == null) {
                    this.f9611B25kr6.addView(frameLayout2);
                }
            }
            frameLayout9.addView(this.f9611B25kr6);
        } else {
            FrameLayout frameLayout12 = aDYaiT3.f2904B3GDIM;
            if (frameLayout12 != null) {
                if (frameLayout12.getParent() == null) {
                    this.f9611B25kr6.addView(frameLayout12);
                }
            }
            frameLayout9.addView(this.f9611B25kr6);
        }
        r20.addView(AMqCpz15);
        setContentView(view6);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f9611B25kr6.removeAllViews();
        f9605B2KMhB = null;
        f9606B3GDIM = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        finish();
    }
}
