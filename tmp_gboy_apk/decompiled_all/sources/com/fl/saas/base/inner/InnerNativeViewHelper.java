package com.fl.saas.base.inner;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.h5.YdH5Activity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InnerNativeViewHelper {
    public static TextView createAppInfoView(final Context context, NativeMaterial nativeMaterial) {
        final NativeAdAppInfo adAppInfo;
        if (!nativeMaterial.isNativeAppAd() || (adAppInfo = nativeMaterial.getAdAppInfo()) == null) {
            return null;
        }
        int parseColor = Color.parseColor("#c9c9c9");
        final int i = 0;
        ClickSpannable textClick = new ClickSpannable().setSeparator(" | ").setGenericColor(parseColor).setText("应用名称：", adAppInfo.getAppName()).setText("应用版本：", adAppInfo.getAppVersion()).setText("开发者：", adAppInfo.getPublisher()).nextCondition(new Supplier() { // from class: com.fl.saas.base.inner.A4TApA
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                Boolean lambda$createAppInfoView$0;
                Boolean lambda$createAppInfoView$2;
                Boolean lambda$createAppInfoView$4;
                switch (i) {
                    case 0:
                        lambda$createAppInfoView$0 = InnerNativeViewHelper.lambda$createAppInfoView$0(adAppInfo);
                        return lambda$createAppInfoView$0;
                    case 1:
                        lambda$createAppInfoView$2 = InnerNativeViewHelper.lambda$createAppInfoView$2(adAppInfo);
                        return lambda$createAppInfoView$2;
                    default:
                        lambda$createAppInfoView$4 = InnerNativeViewHelper.lambda$createAppInfoView$4(adAppInfo);
                        return lambda$createAppInfoView$4;
                }
            }
        }).setTextClick("权限详情 >", new Runnable() { // from class: com.fl.saas.base.inner.A5SV6n
            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        InnerNativeViewHelper.lambda$createAppInfoView$1(adAppInfo, context);
                        break;
                    case 1:
                        InnerNativeViewHelper.lambda$createAppInfoView$3(adAppInfo, context);
                        break;
                    default:
                        InnerNativeViewHelper.lambda$createAppInfoView$5(adAppInfo, context);
                        break;
                }
            }
        });
        final int i2 = 1;
        ClickSpannable textClick2 = textClick.nextCondition(new Supplier() { // from class: com.fl.saas.base.inner.A4TApA
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                Boolean lambda$createAppInfoView$0;
                Boolean lambda$createAppInfoView$2;
                Boolean lambda$createAppInfoView$4;
                switch (i2) {
                    case 0:
                        lambda$createAppInfoView$0 = InnerNativeViewHelper.lambda$createAppInfoView$0(adAppInfo);
                        return lambda$createAppInfoView$0;
                    case 1:
                        lambda$createAppInfoView$2 = InnerNativeViewHelper.lambda$createAppInfoView$2(adAppInfo);
                        return lambda$createAppInfoView$2;
                    default:
                        lambda$createAppInfoView$4 = InnerNativeViewHelper.lambda$createAppInfoView$4(adAppInfo);
                        return lambda$createAppInfoView$4;
                }
            }
        }).setTextClick("隐私协议 >", new Runnable() { // from class: com.fl.saas.base.inner.A5SV6n
            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        InnerNativeViewHelper.lambda$createAppInfoView$1(adAppInfo, context);
                        break;
                    case 1:
                        InnerNativeViewHelper.lambda$createAppInfoView$3(adAppInfo, context);
                        break;
                    default:
                        InnerNativeViewHelper.lambda$createAppInfoView$5(adAppInfo, context);
                        break;
                }
            }
        });
        final int i3 = 2;
        SpannableStringBuilder build = textClick2.nextCondition(new Supplier() { // from class: com.fl.saas.base.inner.A4TApA
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                Boolean lambda$createAppInfoView$0;
                Boolean lambda$createAppInfoView$2;
                Boolean lambda$createAppInfoView$4;
                switch (i3) {
                    case 0:
                        lambda$createAppInfoView$0 = InnerNativeViewHelper.lambda$createAppInfoView$0(adAppInfo);
                        return lambda$createAppInfoView$0;
                    case 1:
                        lambda$createAppInfoView$2 = InnerNativeViewHelper.lambda$createAppInfoView$2(adAppInfo);
                        return lambda$createAppInfoView$2;
                    default:
                        lambda$createAppInfoView$4 = InnerNativeViewHelper.lambda$createAppInfoView$4(adAppInfo);
                        return lambda$createAppInfoView$4;
                }
            }
        }).setTextClick("功能介绍 > ", new Runnable() { // from class: com.fl.saas.base.inner.A5SV6n
            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        InnerNativeViewHelper.lambda$createAppInfoView$1(adAppInfo, context);
                        break;
                    case 1:
                        InnerNativeViewHelper.lambda$createAppInfoView$3(adAppInfo, context);
                        break;
                    default:
                        InnerNativeViewHelper.lambda$createAppInfoView$5(adAppInfo, context);
                        break;
                }
            }
        }).build();
        if (build.length() == 0) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(build);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(parseColor);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$0(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getAppPermissionUrl()) && nativeAdAppInfo.getPermissonClick() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$1(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getPermissonClick() != null) {
            nativeAdAppInfo.getPermissonClick().onClick();
        } else {
            YdH5Activity.launch(context, nativeAdAppInfo.getAppPermissionUrl(), "权限详情");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$2(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getAppPrivacyUrl()) && nativeAdAppInfo.getAppPrivacyUrl() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$3(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getPrivacyClick() != null) {
            nativeAdAppInfo.getPrivacyClick().onClick();
        } else {
            YdH5Activity.launch(context, nativeAdAppInfo.getAppPrivacyUrl(), "隐私协议");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$createAppInfoView$4(NativeAdAppInfo nativeAdAppInfo) {
        return Boolean.valueOf((TextUtils.isEmpty(nativeAdAppInfo.getFunctionUrl()) && nativeAdAppInfo.getFunctionClick() == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAppInfoView$5(NativeAdAppInfo nativeAdAppInfo, Context context) {
        if (nativeAdAppInfo.getFunctionClick() != null) {
            nativeAdAppInfo.getFunctionClick().onClick();
        } else {
            YdH5Activity.launch(context, nativeAdAppInfo.getFunctionUrl(), "功能介绍");
        }
    }
}
