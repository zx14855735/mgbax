package com.fl.saas.config.utils;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdInterstitial;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdAppBackgroundUtil {
    private long backgroundTime;
    private String foregroundName;
    private boolean hasInit;
    private final AtomicInteger mActivityCounter;
    private boolean mIsAppInBackground;
    private String placeId;
    private String showName;
    private long wakeUpTime;
    private YdInterstitial ydInterstitial;

    public class AppLifecycleTracker implements Application.ActivityLifecycleCallbacks {
        private AppLifecycleTracker() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            try {
                YdAppBackgroundUtil.this.foregroundName = activity.getComponentName().getClassName();
                if (!YdAppBackgroundUtil.this.isDialogOrTranslucentTheme(activity) && YdAppBackgroundUtil.this.mActivityCounter.incrementAndGet() == 1 && YdAppBackgroundUtil.this.mIsAppInBackground) {
                    YdAppBackgroundUtil.this.mIsAppInBackground = false;
                    YdAppBackgroundUtil.this.onAppForeground(activity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            try {
                if (YdAppBackgroundUtil.this.isDialogOrTranslucentTheme(activity) || YdAppBackgroundUtil.this.mActivityCounter.decrementAndGet() != 0) {
                    return;
                }
                YdAppBackgroundUtil.this.mIsAppInBackground = true;
                YdAppBackgroundUtil.this.onAppBackground();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final class Holder {
        private static final YdAppBackgroundUtil INSTANCE = new YdAppBackgroundUtil();

        static {
            IWTHckw();
        }

        private Holder() {
        }

        private static /* synthetic */ void IWTHckw() {
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

    private YdAppBackgroundUtil() {
        this.mActivityCounter = new AtomicInteger(0);
        this.mIsAppInBackground = false;
        this.hasInit = false;
        this.backgroundTime = 0L;
        this.wakeUpTime = 0L;
        this.placeId = "";
        this.showName = "";
        this.foregroundName = "";
    }

    private boolean checkDialogTheme(Activity activity) {
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsFloating});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    private boolean checkTranslucentTheme(Activity activity) {
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static YdAppBackgroundUtil getInstance() {
        return Holder.INSTANCE;
    }

    private boolean needWakeUpAd() {
        return (this.wakeUpTime <= 0 || TextUtils.isEmpty(this.placeId) || TextUtils.isEmpty(this.showName)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackground() {
        LogcatUtil.d("YdSDK-API", "onAppBackground");
        this.backgroundTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppForeground(Activity activity) {
        LogcatUtil.d("YdSDK-API", "onAppForeground" + activity + this.showName);
        if (needWakeUpAd() && System.currentTimeMillis() - this.backgroundTime > this.wakeUpTime && this.showName.equals(activity.getComponentName().getClassName())) {
            YdInterstitial build = new YdInterstitial.Builder(activity).setKey(this.placeId).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.config.utils.YdAppBackgroundUtil.1
                @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
                public void onAdClick(String str) {
                }

                @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
                public void onAdClosed() {
                    if (YdAppBackgroundUtil.this.ydInterstitial != null) {
                        YdAppBackgroundUtil.this.ydInterstitial.destroy();
                        YdAppBackgroundUtil.this.ydInterstitial = null;
                    }
                }

                @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
                public void onAdDisplay() {
                }

                @Override // com.fl.saas.base.interfaces.AdViewListener
                public void onAdFailed(YdError ydError) {
                    if (YdAppBackgroundUtil.this.ydInterstitial != null) {
                        YdAppBackgroundUtil.this.ydInterstitial.destroy();
                        YdAppBackgroundUtil.this.ydInterstitial = null;
                    }
                }

                @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
                public void onAdReady() {
                    if (YdAppBackgroundUtil.this.ydInterstitial != null && YdAppBackgroundUtil.this.showName.equals(YdAppBackgroundUtil.this.foregroundName)) {
                        YdAppBackgroundUtil.this.ydInterstitial.show();
                    } else if (YdAppBackgroundUtil.this.ydInterstitial != null) {
                        YdAppBackgroundUtil.this.ydInterstitial.destroy();
                        YdAppBackgroundUtil.this.ydInterstitial = null;
                    }
                }
            }).build();
            this.ydInterstitial = build;
            build.requestInterstitial();
        }
    }

    public boolean checkPlaceId(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.placeId);
    }

    public boolean isAppInBackground() {
        return this.mIsAppInBackground;
    }

    public boolean isDialogOrTranslucentTheme(Activity activity) {
        WindowManager.LayoutParams attributes;
        try {
            attributes = activity.getWindow().getAttributes();
        } catch (Exception unused) {
        }
        return (attributes.width == -2) || (attributes.height == -2) || ((attributes.flags & 2) != 0) || checkTranslucentTheme(activity) || checkDialogTheme(activity);
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        if (context != null) {
            try {
                if (this.hasInit) {
                    return;
                }
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new AppLifecycleTracker());
                this.hasInit = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setWakeUpTime(long j) {
        this.wakeUpTime = j;
    }
}
