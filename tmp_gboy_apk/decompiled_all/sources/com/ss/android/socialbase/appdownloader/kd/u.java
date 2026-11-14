package com.ss.android.socialbase.appdownloader.kd;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.KeyEvent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.appdownloader.w.qt;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static List<qt> hf = new ArrayList();
    private static AlertDialog u = null;
    private static com.ss.android.socialbase.appdownloader.view.xj w = null;
    private static final String xj = "u";

    static {
        NqBH();
    }

    private static /* synthetic */ void NqBH() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean hf() {
        Method method;
        Integer num;
        boolean areNotificationsEnabled;
        Context tj = com.ss.android.socialbase.downloader.downloader.w.tj();
        NotificationManager notificationManager = (NotificationManager) tj.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) tj.getSystemService("appops");
        ApplicationInfo applicationInfo = tj.getApplicationInfo();
        String packageName = tj.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.getClass();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
        }
        return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i), packageName)).intValue() == 0;
    }

    public static boolean xj() {
        try {
            return hf();
        } catch (Throwable th) {
            pl.xj(th);
            return true;
        }
    }

    public static synchronized void xj(boolean z) {
        synchronized (u.class) {
            try {
                AlertDialog alertDialog = u;
                if (alertDialog != null) {
                    alertDialog.cancel();
                    u = null;
                }
                for (qt qtVar : hf) {
                    if (qtVar != null) {
                        if (z) {
                            qtVar.xj();
                        } else {
                            qtVar.hf();
                        }
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public static void hf(Activity activity, qt qtVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = xj;
                    com.ss.android.socialbase.appdownloader.view.xj xjVar = (com.ss.android.socialbase.appdownloader.view.xj) fragmentManager.findFragmentByTag(str);
                    w = xjVar;
                    if (xjVar == null) {
                        w = new com.ss.android.socialbase.appdownloader.view.xj();
                        fragmentManager.beginTransaction().add(w, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            pl.xj(th);
                        }
                    }
                    w.xj();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    pl.xj(th2);
                    qtVar.xj();
                    return;
                } catch (Throwable th3) {
                    pl.xj(th3);
                    return;
                }
            }
        }
        qtVar.xj();
    }

    public static synchronized void xj(final Activity activity, final qt qtVar) {
        synchronized (u.class) {
            if (qtVar == null) {
                return;
            }
            if (activity != null) {
                try {
                    if (!activity.isFinishing()) {
                        int xj2 = d.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), "tt_appdownloader_notification_request_title");
                        int xj3 = d.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), "tt_appdownloader_notification_request_message");
                        int xj4 = d.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), "tt_appdownloader_notification_request_btn_yes");
                        int xj5 = d.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), "tt_appdownloader_notification_request_btn_no");
                        hf.add(qtVar);
                        AlertDialog alertDialog = u;
                        if (alertDialog != null) {
                            if (!alertDialog.isShowing()) {
                            }
                            return;
                        }
                        u = new AlertDialog.Builder(activity).setTitle(xj2).setMessage(xj3).setPositiveButton(xj4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.kd.u.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                u.hf(activity, qtVar);
                                dialogInterface.cancel();
                                AlertDialog unused = u.u = null;
                            }
                        }).setNegativeButton(xj5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.kd.u.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                u.xj(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.kd.u.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    u.xj(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                        return;
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                    xj(false);
                    return;
                }
            }
            qtVar.hf();
        }
    }

    public static void xj(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.ss.android.socialbase.downloader.f.xj.xj(i).hf("enable_target_34") <= 0 || xj()) {
            return;
        }
        Context tj = com.ss.android.socialbase.downloader.downloader.w.tj();
        try {
            Intent intent = new Intent(tj, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            tj.startActivity(intent);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.w.xj.kd(xj, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
