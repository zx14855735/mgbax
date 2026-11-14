package com.octopus.ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import com.octopus.ad.internal.utilities.DeviceInfo;
import com.octopus.ad.internal.utilities.HaoboLog;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12322a;
    static Class<AdActivity> b = AdActivity.class;
    private a c;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    static {
        YdPBGv();
    }

    private static /* synthetic */ void YdPBGv() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Class<AdActivity> a() {
        return b;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private static void b(Activity activity, int i) {
        String str = DeviceInfo.getInstance().model;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        boolean z = DeviceInfo.getInstance().brand.toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"));
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (i == 1) {
            int rotation = defaultDisplay.getRotation();
            if (rotation == 1 || rotation == 2) {
                activity.setRequestedOrientation(9);
                return;
            } else {
                activity.setRequestedOrientation(1);
                return;
            }
        }
        if (i == 2) {
            int rotation2 = defaultDisplay.getRotation();
            if (z) {
                if (rotation2 == 0 || rotation2 == 1) {
                    activity.setRequestedOrientation(8);
                    return;
                } else {
                    activity.setRequestedOrientation(0);
                    return;
                }
            }
            if (rotation2 == 0 || rotation2 == 1) {
                activity.setRequestedOrientation(0);
            } else {
                activity.setRequestedOrientation(8);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("ACTIVITY_TYPE");
        if (TextUtils.isEmpty(stringExtra)) {
            HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adactivity_no_type));
            finish();
        } else if ("INTERSTITIAL".equals(stringExtra)) {
            com.octopus.ad.internal.activity.a aVar = new com.octopus.ad.internal.activity.a(this);
            this.c = aVar;
            aVar.a();
        }
        CookieSyncManager.createInstance(this);
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d();
            this.c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }

    public static void a(Activity activity, int i) {
        b(activity, i);
    }
}
