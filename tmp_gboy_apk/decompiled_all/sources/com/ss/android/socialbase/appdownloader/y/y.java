package com.ss.android.socialbase.appdownloader.y;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.pl;
import com.czhj.sdk.common.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private static Boolean xj;

    public static boolean hf() {
        if (u() == 0) {
            return true;
        }
        return kd();
    }

    private static boolean kd() {
        String[] strArr = {xj("2f7362696e2f7375"), xj("2f73797374656d2f62696e2f7375"), xj("2f73797374656d2f7862696e2f7375"), xj("2f646174612f6c6f63616c2f7862696e2f7375"), xj("2f646174612f6c6f63616c2f62696e2f7375"), xj("2f73797374656d2f73642f7862696e2f7375"), xj("2f73797374656d2f62696e2f6661696c736166652f7375"), xj("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (A2egSU.BPw6Q8(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    private static int u() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, xj("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !Constants.FAIL.equals(str)) ? 1 : 0;
    }

    public static boolean w(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static boolean xj() {
        Boolean bool = xj;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static boolean y() {
        try {
            HashSet hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.contains(xj("636f6d2e73617572696b2e737562737472617465")) || str.contains(xj("58706f7365644272696467652e6a6172")) || str.contains(xj("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized void xj(Context context) {
        synchronized (y.class) {
            try {
                if (xj == null) {
                    xj = Boolean.valueOf((hf() || hf(context) || w(context) || !u(context) || w() || kd(context)) ? false : true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean hf(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean w() {
        try {
            InetAddress.getByName(xj("3132372e302e302e31"));
            new Socket(xj("3132372e302e302e31"), Integer.parseInt(xj("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean u(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    private static String xj(String str) {
        return com.ss.android.socialbase.downloader.tf.y.xj(str);
    }

    private static boolean y(Context context) {
        List asList = Arrays.asList(xj("64652e726f62762e616e64726f69642e78706f736564"), xj("636f6d2e746f706a6f686e77752e6d616769736b"), xj("696f2e76612e6578706f736564"), xj("636f6d2e77696e642e636f74746572"), xj("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), xj("6d652e7765697368752e657870"), xj("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                pl.xj(e);
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean kd(Context context) {
        return y() || y(context);
    }
}
