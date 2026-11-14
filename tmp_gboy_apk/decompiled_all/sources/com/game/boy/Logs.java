package com.game.boy;

import ADYaiT.CtFAbx;
import KpHwm4.ADYaiT;
import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.fl.saas.common.crash.CrashHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Logs {
    public static final Thread.UncaughtExceptionHandler DEFAULT_UNCAUGHT_EXCEPTION_HANDLER = Thread.getDefaultUncaughtExceptionHandler();
    private static volatile boolean initialized = false;

    public static final class CrashActivity extends Activity implements MenuItem.OnMenuItemClickListener {
        private static final String EXTRA_CRASH_INFO = "crashInfo";
        private String mLog;

        private int dp2px(float f) {
            return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
        }

        private void quitApp() {
            System.exit(0);
        }

        @Override // android.app.Activity
        public void onBackPressed() {
            quitApp();
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setTheme(R.style.Theme.DeviceDefault);
            if (bundle != null) {
                this.mLog = bundle.getString(EXTRA_CRASH_INFO);
            } else {
                this.mLog = getIntent().getStringExtra(EXTRA_CRASH_INFO);
            }
            if (this.mLog == null) {
                this.mLog = "No crash log available.";
            }
            ScrollView scrollView = new ScrollView(this);
            scrollView.setFillViewport(true);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
            TextView textView = new TextView(this);
            int dp2px = dp2px(16.0f);
            textView.setPadding(dp2px, dp2px, dp2px, dp2px);
            textView.setText(this.mLog);
            textView.setTextIsSelectable(true);
            horizontalScrollView.addView(textView);
            scrollView.addView(horizontalScrollView, -1, -1);
            setContentView(scrollView);
        }

        @Override // android.app.Activity
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuItem add = menu.add(0, R.id.copy, 0, R.string.copy);
            add.setOnMenuItemClickListener(this);
            add.setShowAsAction(1);
            return true;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908321) {
                return false;
            }
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            if (clipboardManager == null) {
                return true;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(getPackageName(), this.mLog));
            return true;
        }

        @Override // android.app.Activity
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putString(EXTRA_CRASH_INFO, this.mLog);
        }
    }

    static {
        vcrFvX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleCrash(Application application, String str, Throwable th) {
        File file;
        File file2;
        long j;
        String format = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss", Locale.US).format(new Date());
        File externalFilesDir = application.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            if (TextUtils.isEmpty(str)) {
                file2 = new File(externalFilesDir, "crash");
            } else {
                file = new File(str);
                file2 = file;
            }
        } else if (TextUtils.isEmpty(str)) {
            file2 = new File(application.getCacheDir(), "crash");
        } else {
            file = new File(str);
            file2 = file;
        }
        if (!file2.exists() && !file2.mkdirs()) {
            file2 = application.getCacheDir();
        }
        File file3 = new File(file2, CtFAbx.BI9f7h("crash_", format, CrashHandler.FILE_NAME_SUFFIX));
        String str2 = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            str2 = packageInfo.versionName;
            j = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            j = 0;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        String str3 = "************* 崩溃头信息 ****************\n崩溃时间          : " + format + "\n设备制造商        : " + Build.MANUFACTURER + "\n设备型号          : " + Build.MODEL + "\nAndroid 版本      : " + Build.VERSION.RELEASE + "\nAndroid SDK       : " + Build.VERSION.SDK_INT + "\n应用版本名称      : " + str2 + "\n应用版本号        : " + j + "\n************* 崩溃头信息 ****************\n\n" + stringWriter2;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(str3.getBytes());
            fileOutputStream.flush();
        } catch (IOException unused2) {
        }
        Intent intent = new Intent(application, (Class<?>) CrashActivity.class);
        intent.addFlags(335577088);
        intent.putExtra("crashInfo", str3);
        try {
            application.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            if (DEFAULT_UNCAUGHT_EXCEPTION_HANDLER != null) {
                DEFAULT_UNCAUGHT_EXCEPTION_HANDLER.uncaughtException(Thread.currentThread(), th);
            }
        }
    }

    public static void init(Application application) {
        init(application, null);
    }

    private static /* synthetic */ void vcrFvX() {
        char[] charArray = "íáã éïãë ìá÷ ýæëââ ÄàçÌüçêéë".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 142);
        }
        String str = new String(charArray);
        char[] charArray2 = "íâçàçú".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 142);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized void init(Application application, String str) {
        synchronized (Logs.class) {
            if (initialized) {
                return;
            }
            initialized = true;
            Thread.setDefaultUncaughtExceptionHandler(new ADYaiT(application, str));
        }
    }
}
