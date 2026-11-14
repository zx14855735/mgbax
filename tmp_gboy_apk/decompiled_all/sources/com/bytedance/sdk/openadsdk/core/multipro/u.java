package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.x.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String xj = xj();
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context, TextUtils.isEmpty(xj) ? "webview" : "webview_".concat(String.valueOf(xj)), 0).getPath(), "webview_data.lock");
        pl.xj("TTMultiInitHelper", file.getAbsolutePath());
        if (file.exists()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                randomAccessFile = randomAccessFile2;
                th = th2;
            }
            try {
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    xj(file, file.delete());
                }
                com.bytedance.sdk.component.y.w.w.hf.xj(randomAccessFile);
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                xj(file, file.exists() ? file.delete() : false);
                com.bytedance.sdk.component.y.w.w.hf.xj(randomAccessFile2);
            } catch (Throwable th3) {
                th = th3;
                com.bytedance.sdk.component.y.w.w.hf.xj(randomAccessFile);
                throw th;
            }
        }
    }

    public static void xj(final Context context) {
        if (context == null) {
            return;
        }
        MultiWebview.u = new com.bytedance.sdk.component.widget.xj() { // from class: com.bytedance.sdk.openadsdk.core.multipro.u.1
            @Override // com.bytedance.sdk.component.widget.xj
            public void xj(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                am.xj().xj("webview_init_failed", jSONObject, th);
            }
        };
        com.bytedance.sdk.component.c.w.xj(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (e.xj(context)) {
                    c.xj(new d("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.u.2
                        @Override // java.lang.Runnable
                        public void run() {
                            u.w(context);
                        }
                    });
                    return;
                }
                String hf = e.hf(context);
                try {
                    if (TextUtils.isEmpty(hf)) {
                        hf = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(hf);
                } catch (IllegalStateException unused) {
                    xj(hf);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            pl.w(th.getMessage());
        }
    }

    private static void xj(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void xj(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            pl.xj(e);
        }
    }

    private static String xj() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
