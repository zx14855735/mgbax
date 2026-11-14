package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13161a = "v";

    private v() {
    }

    public static Intent a(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        if (com.sigmob.sdk.base.utils.q.b(bundle)) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static void b(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        String str = "Unable to open intent: " + intent;
        if (com.sigmob.sdk.base.o.a().m() != 0) {
            a(context, intent, str);
        } else {
            if (a(context, intent)) {
                a(context, intent, str);
                return;
            }
            throw new IntentNotResolvableException("Could not handle application specific action: " + intent.toString() + "\n\tYou may be running in the emulator or another device which does not have the required application.");
        }
    }

    private static void c(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            intent.addFlags(872415232);
            Activity i = com.sigmob.sdk.b.i();
            if (i == null) {
                i = com.sigmob.sdk.b.c();
            }
            if (i == null) {
                context.startActivity(intent);
            } else {
                i.startActivity(intent);
            }
        } catch (Throwable th) {
            SigmobLog.e("error ", th);
            throw new IntentNotResolvableException(th);
        }
    }

    public static boolean d(Context context, String str) {
        if (context != null && !com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            try {
                boolean b = com.sigmob.sdk.base.utils.q.b(context.getPackageManager().getApplicationInfo(str, 0));
                SigmobLogger.d(f13161a, "installedWithAInfo: enable = " + b, new Object[0]);
                return b;
            } catch (Exception e) {
                SigmobLogger.e(f13161a, CtFAbx.AZOQYO(e, new StringBuilder("installedWithAInfo: error = ")), new Object[0]);
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        if (context != null && !com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            try {
                boolean b = com.sigmob.sdk.base.utils.q.b(context.getPackageManager().getLaunchIntentForPackage(str));
                SigmobLogger.d(f13161a, "installedWithLInfo: enable = " + b, new Object[0]);
                return b;
            } catch (Exception e) {
                SigmobLogger.e(f13161a, CtFAbx.AZOQYO(e, new StringBuilder("installedWithLInfo: error = ")), new Object[0]);
            }
        }
        return false;
    }

    public static boolean f(Context context, String str) {
        if (context != null && !com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            try {
                boolean b = com.sigmob.sdk.base.utils.q.b(context.getPackageManager().getPackageInfo(str, 0));
                SigmobLogger.d(f13161a, "installedWithPInfo: enable = " + b, new Object[0]);
                return b;
            } catch (Exception e) {
                SigmobLogger.e(f13161a, CtFAbx.AZOQYO(e, new StringBuilder("installedWithPInfo: error = ")), new Object[0]);
            }
        }
        return false;
    }

    private static Uri a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        return Uri.parse(BaseConstants.MARKET_PREFIX + intent.getPackage());
    }

    public static void b(Context context, Uri uri, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(uri);
        a(context, new Intent("android.intent.action.VIEW", uri), str);
    }

    public static boolean c(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            throw new IntentNotResolvableException(CtFAbx.BI9f7h("Could not handle application specific action: ", str, "\n\tYou may be running in the emulator or another."));
        }
        c(context, launchIntentForPackage);
        return true;
    }

    public static String a(Context context, Uri uri, List<String> list) {
        if (uri == null || uri.getScheme() == null || !uri.getScheme().equalsIgnoreCase(BaseConstants.SCHEME_MARKET)) {
            return null;
        }
        for (String str : list) {
            if (AppPackageUtil.getPackageVersionCode(context, str) != -1) {
                return str;
            }
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        File externalCacheDir;
        File parentFile;
        File parentFile2;
        try {
            File file = new File("/data/data", str);
            String absolutePath = file.getAbsolutePath();
            boolean exists = file.exists();
            SigmobLogger.d(f13161a, "launchApp: cacheDir = " + absolutePath + ", exists = " + exists, new Object[0]);
            if (exists) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            externalCacheDir = context.getExternalCacheDir();
        } catch (Exception unused2) {
        }
        if (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null || (parentFile2 = parentFile.getParentFile()) == null) {
            return false;
        }
        File file2 = new File(parentFile2, str);
        String absolutePath2 = file2.getAbsolutePath();
        boolean exists2 = file2.exists();
        SigmobLogger.d(f13161a, "launchApp: packagePath = " + absolutePath2 + ", exists = " + exists2, new Object[0]);
        return exists2;
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        a(context, broadcastReceiver, intentFilter, true);
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        }
    }

    private static void a(Context context, Intent intent, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            c(context, intent);
        } catch (Throwable th) {
            throw new IntentNotResolvableException(J3FDQU.A2egSU.B4ZgIw(th, B4ZgIw.AYUAbz.A5SV6n(str, "\n")));
        }
    }

    public static void a(Context context, Uri uri) {
        a(context, uri, (String) null);
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (com.sigmob.sdk.base.utils.o.b(str)) {
            intent.setPackage(str);
        }
        b(context, intent);
    }

    public static void a(Context context, Uri uri, String str, boolean z) {
        WindowInsets rootWindowInsets;
        String str2 = f13161a;
        SigmobLogger.d(str2, "launchApp: uri = " + uri + ", packageName = " + str + ", enableSmallWindow = " + z, new Object[0]);
        boolean b = com.sigmob.sdk.base.utils.q.b(uri);
        boolean b2 = com.sigmob.sdk.base.utils.o.b(str);
        Activity i = com.sigmob.sdk.b.i();
        if (i == null) {
            i = com.sigmob.sdk.b.c();
        }
        if (i == null || com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(z))) {
            SigmobLogger.e(str2, "launchApp: error = activity is null.", new Object[0]);
            if (b && b2) {
                a(context, uri, str);
                return;
            } else if (b) {
                a(context, uri);
                return;
            } else {
                c(context, str);
                return;
            }
        }
        Bundle bundle = null;
        Intent intent = b ? new Intent("android.intent.action.VIEW", uri) : b2 ? context.getPackageManager().getLaunchIntentForPackage(str) : null;
        if (!com.sigmob.sdk.base.utils.q.b(intent) || !a(context, intent)) {
            throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
        }
        SigmobLogger.d(str2, "launchApp: intent = " + intent, new Object[0]);
        intent.setFlags(270532608);
        int i2 = Build.VERSION.SDK_INT;
        ActivityOptions makeCustomAnimation = ActivityOptions.makeCustomAnimation(context, 0, 0);
        if (makeCustomAnimation == null) {
            SigmobLogger.d(str2, "launchApp: options is unavailable.", new Object[0]);
        } else {
            if (i2 >= 33) {
                try {
                    makeCustomAnimation.getClass().getMethod("setPendingIntentBackgroundActivityLaunchAllowed", Boolean.TYPE).invoke(makeCustomAnimation, Boolean.TRUE);
                } catch (Exception e) {
                    SigmobLogger.e(f13161a, CtFAbx.AZOQYO(e, new StringBuilder("launchApp: error = ")), new Object[0]);
                }
            }
            makeCustomAnimation.getClass().getMethod("setLaunchWindowingMode", Integer.TYPE).invoke(makeCustomAnimation, 6);
            if (Build.VERSION.SDK_INT >= 24) {
                View decorView = i.getWindow().getDecorView();
                rootWindowInsets = decorView.getRootWindowInsets();
                Rect rect = new Rect(0, 0, decorView.getWidth() / 2, decorView.getHeight() / 2);
                rect.offsetTo(rootWindowInsets.getSystemWindowInsetLeft() + 50, rootWindowInsets.getSystemWindowInsetTop() + 50);
                makeCustomAnimation.setLaunchBounds(rect);
            }
        }
        if (makeCustomAnimation != null) {
            try {
                bundle = makeCustomAnimation.toBundle();
            } catch (Throwable th) {
                throw new IntentNotResolvableException(J3FDQU.A2egSU.B4ZgIw(th, B4ZgIw.AYUAbz.A5SV6n("Unable to open intent: " + intent, "\n")));
            }
        }
        i.startActivity(intent, bundle);
        if (z) {
            com.sigmob.sdk.b.j();
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4) {
        StringBuilder BChYOn2 = J3FDQU.A2egSU.BChYOn("wechat mini program error: wxAppId = ", str, ", wxAppUsername = ", str2, ", wxAppPath = ");
        BChYOn2.append(str3);
        BChYOn2.append(", wxBusinessType = ");
        BChYOn2.append(i);
        BChYOn2.append(", wxExtMsg = ");
        BChYOn2.append(str4);
        String sb = BChYOn2.toString();
        try {
            if (i != 0) {
                if (i == 1) {
                    if (com.sigmob.sdk.base.utils.o.a((CharSequence) str4)) {
                        throw new IntentNotResolvableException(sb);
                    }
                    Method method = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
                    method.setAccessible(true);
                    Object invoke = method.invoke(WXAPIFactory.class, context, str);
                    Object newInstance = WXOpenBusinessView.Req.class.newInstance();
                    Field declaredField = WXOpenBusinessView.Req.class.getDeclaredField("businessType");
                    declaredField.setAccessible(true);
                    declaredField.set(newInstance, "nativeOpenAdCanvas");
                    Field declaredField2 = WXOpenBusinessView.Req.class.getDeclaredField("extInfo");
                    declaredField2.setAccessible(true);
                    declaredField2.set(newInstance, str4);
                    Method method2 = invoke.getClass().getMethod("sendReq", newInstance.getClass().getSuperclass());
                    method2.setAccessible(true);
                    boolean booleanValue = ((Boolean) method2.invoke(invoke, newInstance)).booleanValue();
                    SigmobLog.d("openB:isSendReq " + booleanValue);
                    if (!booleanValue) {
                        throw new IntentNotResolvableException(sb);
                    }
                    return;
                }
                return;
            }
            if (com.sigmob.sdk.base.utils.o.a((CharSequence) str) || com.sigmob.sdk.base.utils.o.a((CharSequence) str2) || com.sigmob.sdk.base.utils.o.a((CharSequence) str3)) {
                throw new IntentNotResolvableException(sb);
            }
            Method method3 = WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class);
            method3.setAccessible(true);
            Object invoke2 = method3.invoke(WXAPIFactory.class, context, str);
            Object newInstance2 = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField3.setAccessible(true);
            declaredField3.set(newInstance2, str2);
            Field declaredField4 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
            declaredField4.setAccessible(true);
            declaredField4.set(newInstance2, str3);
            if (com.sigmob.sdk.base.utils.o.b(str4)) {
                Field declaredField5 = WXLaunchMiniProgram.Req.class.getDeclaredField("extData");
                declaredField5.setAccessible(true);
                declaredField5.set(newInstance2, str4);
            }
            Field declaredField6 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField6.setAccessible(true);
            declaredField6.set(newInstance2, 0);
            Method method4 = invoke2.getClass().getMethod("sendReq", newInstance2.getClass().getSuperclass());
            method4.setAccessible(true);
            boolean booleanValue2 = ((Boolean) method4.invoke(invoke2, newInstance2)).booleanValue();
            SigmobLog.d("openB:isSendReq " + booleanValue2);
            if (!booleanValue2) {
                throw new IntentNotResolvableException(sb);
            }
        } catch (Throwable th) {
            throw new IntentNotResolvableException(th.getMessage());
        }
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        return com.sigmob.sdk.base.o.a().m() == 0 ? e(context, str) : d(context, str);
    }
}
