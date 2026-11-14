package com.octopus.ad.internal.utilities;

import BPw6Q8.A2egSU;
import BPw6Q8.ASJ6gh;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.octopus.ad.R;
import com.octopus.ad.internal.activity.BrowserAdActivity;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.q;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ViewUtil {
    public static FrameLayout createAdImageView(Context context, ServerResponse.AdLogoInfo adLogoInfo, int i, int i2, float f) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        float f2 = 10.0f * f;
        int i3 = (int) f2;
        if (adLogoInfo != null) {
            q a2 = q.a();
            if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int applyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, a2.q());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension * 2, applyDimension, i2 | 80);
                layoutParams.setMargins(0, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                if (TextUtils.isEmpty(adLogoInfo.getAdurl()) || !adLogoInfo.getAdurl().endsWith("remdad.png")) {
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                } else {
                    imageView.setImageResource(R.drawable.oct_logo_text);
                }
                frameLayout.addView(imageView);
                return frameLayout;
            }
            if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
                appCompatTextView.setTextSize(2, f2);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(adLogoInfo.getAdurl());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, i2 | 80);
                layoutParams2.setMargins(0, 0, i * i3, 0);
                frameLayout.addView(appCompatTextView, layoutParams2);
            }
        }
        return frameLayout;
    }

    public static AppCompatTextView createComplianceView(Context context, final ComplianceInfo complianceInfo, float f, boolean z) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
        if (complianceInfo == null) {
            return appCompatTextView;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        appCompatTextView.setTextSize(8.0f * f);
        int i = (int) (f * 10.0f);
        if (z) {
            appCompatTextView.setPadding(i, i, i, i);
        } else {
            appCompatTextView.setPadding(i * 3, i, i * 16, i * 4);
        }
        String format = String.format("应用名称：%1$s | 开发者：%2$s | 应用版本：%3$s | 权限详情 | 隐私协议 | 功能介绍", complianceInfo.getAppName(), complianceInfo.getDeveloperName(), complianceInfo.getAppVersion());
        SpannableString spannableString = new SpannableString(format);
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.octopus.ad.internal.utilities.ViewUtil.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(ComplianceInfo.this.getPermissionsUrl(), 0);
            }
        };
        int indexOf = format.indexOf("权限详情");
        spannableString.setSpan(clickableSpan, indexOf, indexOf + 4, 17);
        ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.octopus.ad.internal.utilities.ViewUtil.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(ComplianceInfo.this.getPrivacyUrl(), 0);
            }
        };
        int indexOf2 = format.indexOf("隐私协议");
        spannableString.setSpan(clickableSpan2, indexOf2, indexOf2 + 4, 17);
        ClickableSpan clickableSpan3 = new ClickableSpan() { // from class: com.octopus.ad.internal.utilities.ViewUtil.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ViewUtil.openLocalBrowser(ComplianceInfo.this.getFunctionDescUrl(), 0);
            }
        };
        int indexOf3 = format.indexOf("功能介绍");
        spannableString.setSpan(clickableSpan3, indexOf3, indexOf3 + 4, 17);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        appCompatTextView.setText(spannableString);
        return appCompatTextView;
    }

    public static AppCompatTextView createCountDown(Context context, int i, int i2, int i3, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
        Locale locale = Locale.US;
        appCompatTextView.setText("跳过 " + i);
        appCompatTextView.setTextColor(-1);
        float f2 = 12.0f * f;
        appCompatTextView.setTextSize(2, f2);
        appCompatTextView.setGravity(17);
        q a2 = q.a();
        int applyDimension = (int) TypedValue.applyDimension(1, f2, a2.q());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 4.0f * f, a2.q());
        appCompatTextView.setPadding(applyDimension, applyDimension2, applyDimension, applyDimension2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i2 + 15) * f, a2.q()), (int) TypedValue.applyDimension(1, (i3 + 15) * f, a2.q()), 0);
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.utilities.ViewUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        try {
            appCompatTextView.setBackgroundDrawable(A2egSU.A4TApA(context, R.drawable.oct_count_down_background));
            return appCompatTextView;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return appCompatTextView;
        }
    }

    public static AppCompatTextView createFeedBackButton(Context context, String str, int i, int i2, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
        appCompatTextView.setTextColor(-1);
        float f2 = 12.0f * f;
        appCompatTextView.setTextSize(2, f2);
        appCompatTextView.setText(R.string.octopus_feedback);
        appCompatTextView.setGravity(17);
        q a2 = q.a();
        int applyDimension = (int) TypedValue.applyDimension(1, f2, a2.q());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 4.0f * f, a2.q());
        appCompatTextView.setPadding(applyDimension, applyDimension2, applyDimension, applyDimension2);
        int applyDimension3 = (int) TypedValue.applyDimension(1, (i + 15) * f, a2.q());
        int applyDimension4 = (int) TypedValue.applyDimension(1, (i2 + 15) * f, a2.q());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388659);
        layoutParams.setMargins(applyDimension3, applyDimension4, 0, 0);
        appCompatTextView.setLayoutParams(layoutParams);
        try {
            appCompatTextView.setBackgroundDrawable(A2egSU.A4TApA(context, R.drawable.oct_count_down_background));
            return appCompatTextView;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return appCompatTextView;
        }
    }

    public static ImageView createImageCloseButton(Context context, int i, float f) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.oct_close);
        imageView.setBackgroundResource(R.drawable.oct_close_background);
        q a2 = q.a();
        int applyDimension = (int) TypedValue.applyDimension(1, 5.0f * f, a2.q());
        imageView.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 24.0f * f, a2.q());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension2, applyDimension2, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i + 15) * f, a2.q()), (int) TypedValue.applyDimension(1, f * 15.0f, a2.q()), 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public static AppCompatTextView createInterstitialCountDown(Context context, int i, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(ASJ6gh.A5SV6n(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 13.0f * f);
        q a2 = q.a();
        int applyDimension = (int) TypedValue.applyDimension(1, 24.0f * f, a2.q());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388661);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, (i + 15) * f, a2.q()), (int) TypedValue.applyDimension(1, f * 15.0f, a2.q()), 0);
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.utilities.ViewUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        try {
            appCompatTextView.setBackgroundDrawable(A2egSU.A4TApA(context, R.drawable.oct_count_down_interstitial_background));
            return appCompatTextView;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return appCompatTextView;
        }
    }

    public static ProgressBar createLoadingView(Context context, float f) {
        ProgressBar progressBar = new ProgressBar(context);
        if (progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(-3355444, PorterDuff.Mode.SRC_IN);
        }
        int applyDimension = (int) TypedValue.applyDimension(1, f * 40.0f, q.a().q());
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(applyDimension, applyDimension, 17));
        return progressBar;
    }

    public static FrameLayout createLogoImageView(Context context, ServerResponse.AdLogoInfo adLogoInfo, int i, float f) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        float f2 = 10.0f * f;
        int i2 = (int) f2;
        if (adLogoInfo != null) {
            q a2 = q.a();
            if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_PIC) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int applyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, a2.q());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388693);
                layoutParams.setMargins(0, 0, i * i2, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                if (TextUtils.isEmpty(adLogoInfo.getAdurl()) || !adLogoInfo.getAdurl().endsWith("octlogo.png")) {
                    ImageManager.with(context).load(adLogoInfo.getAdurl()).into(imageView);
                } else {
                    imageView.setImageResource(R.drawable.oct_logo);
                }
                frameLayout.addView(imageView);
                return frameLayout;
            }
            if (adLogoInfo.getType() == ServerResponse.AdLogoInfo.TYPE_TEXT) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
                appCompatTextView.setTextSize(2, f2);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(adLogoInfo.getAdurl());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388693);
                layoutParams2.setMargins(0, 0, 0, 0);
                frameLayout.addView(appCompatTextView, layoutParams2);
            }
        }
        return frameLayout;
    }

    public static AppCompatImageView createMuteButton(Context context, boolean z, int i, float f) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context, null);
        appCompatImageView.setImageResource(z ? R.drawable.oct_voice_off : R.drawable.oct_voice_on);
        q a2 = q.a();
        int applyDimension = (int) TypedValue.applyDimension(1, 24.0f * f, a2.q());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388659);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 15.0f * f, a2.q()), (int) TypedValue.applyDimension(1, (i + 15) * f, a2.q()), 0, 0);
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenHeightDp(Context context) {
        return px2dip(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    private static int getSystemUiVisibility() {
        return 5894;
    }

    public static void hideSystemTitleBarUI(Activity activity) {
        try {
            int systemUiVisibility = getSystemUiVisibility();
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void openLocalBrowser(WebView webView, int i) {
        try {
            Context j = q.a().j();
            if (j != null && webView != null) {
                Intent intent = new Intent(j, (Class<?>) BrowserAdActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                intent.putExtra("REPEAT_NUM", i);
                BrowserAdActivity.f12404a.add(webView);
                j.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            BrowserAdActivity.f12404a.remove();
        } catch (Exception e) {
            HaoboLog.e(HaoboLog.baseLogTag, "Exception initializing the redirect webview: " + e.getMessage());
        }
    }

    public static void openSystemBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removeChildFromParent(final View view) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.utilities.ViewUtil.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    View view2 = view;
                    if (view2 == null || view2.getParent() == null) {
                        return;
                    }
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void openLocalBrowser(String str, int i) {
        try {
            Context j = q.a().j();
            if (j != null && !TextUtils.isEmpty(str)) {
                WebView webView = new WebView(new MutableContextWrapper(j));
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(str);
                Intent intent = new Intent(j, (Class<?>) BrowserAdActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                intent.putExtra("REPEAT_NUM", i);
                BrowserAdActivity.f12404a.add(webView);
                j.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            BrowserAdActivity.f12404a.remove();
        } catch (Exception e) {
            HaoboLog.e(HaoboLog.baseLogTag, "Exception initializing the redirect webview: " + e.getMessage());
        }
    }
}
