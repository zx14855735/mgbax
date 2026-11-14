package com.czhj.devicehelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.devicehelper.msaoaId.a;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DeviceHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10479a = "getSimState";
    private static final String b = "getImei";
    private static final String c = "getLine1Number";
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = "";
    private static long h;
    private static long i;
    private static Handler j;
    private static Handler k;
    private static int l;
    private static boolean m;
    private static String n;
    private static String o;
    private static String p;
    private static Thread q;
    private static Thread r;
    private static boolean s;
    private static int t;

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI(Context context) {
        String deviceId;
        String meid;
        try {
            SigmobLog.d("private :getIMEI");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                deviceId = telephonyManager.getImei();
                if (TextUtils.isEmpty(deviceId)) {
                    try {
                        return telephonyManager.getDeviceId();
                    } catch (Throwable unused) {
                        meid = telephonyManager.getMeid();
                        return meid;
                    }
                }
            } else {
                deviceId = telephonyManager.getDeviceId();
            }
            if (deviceId != null) {
                return deviceId;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMSI(Context context) {
        return null;
    }

    public static String getMacAddress() {
        return "";
    }

    public static void getOAID(final Context context, final a.InterfaceC0217a interfaceC0217a) {
        if (!TextUtils.isEmpty(d)) {
            if (interfaceC0217a != null) {
                interfaceC0217a.a(e);
                return;
            }
            return;
        }
        if (t > 10) {
            if (interfaceC0217a != null) {
                interfaceC0217a.a("");
                return;
            }
            return;
        }
        h = System.currentTimeMillis();
        if (r == null) {
            Thread.activeCount();
            Thread thread = new Thread(new Runnable() { // from class: com.czhj.devicehelper.DeviceHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    SigmobLog.d("private  getOAID");
                    com.czhj.devicehelper.msaoaId.a.a(context, new a.InterfaceC0217a() { // from class: com.czhj.devicehelper.DeviceHelper.1.1
                        @Override // com.czhj.devicehelper.msaoaId.a.InterfaceC0217a
                        public void a(String str) {
                            String unused = DeviceHelper.d = str;
                            a.InterfaceC0217a interfaceC0217a2 = interfaceC0217a;
                            if (interfaceC0217a2 != null) {
                                interfaceC0217a2.a(str);
                            }
                            boolean unused2 = DeviceHelper.s = false;
                            if (DeviceHelper.j != null) {
                                DeviceHelper.j.removeCallbacksAndMessages(null);
                                Handler unused3 = DeviceHelper.j = null;
                            }
                        }
                    });
                }
            });
            r = thread;
            thread.start();
            t++;
            s = true;
            Handler handler = new Handler(Looper.getMainLooper());
            j = handler;
            handler.postDelayed(new Runnable() { // from class: com.czhj.devicehelper.DeviceHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DeviceHelper.r != null) {
                        boolean unused = DeviceHelper.s = false;
                        int unused2 = DeviceHelper.t = 11;
                        a.InterfaceC0217a interfaceC0217a2 = a.InterfaceC0217a.this;
                        if (interfaceC0217a2 != null) {
                            interfaceC0217a2.a("");
                        }
                        if (DeviceHelper.j != null) {
                            DeviceHelper.j.removeCallbacksAndMessages(null);
                            Handler unused3 = DeviceHelper.j = null;
                        }
                    }
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    public static String getVAID() {
        return f;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifiName(Context context) {
        return n;
    }

    @SuppressLint({"MissingPermission"})
    public static String getWifimac(Context context) {
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static String getIMEI(Context context, int i2) {
        String deviceId;
        String meid;
        String deviceId2;
        try {
            SigmobLog.d("private :getIMEI " + i2);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                deviceId = telephonyManager.getImei(i2);
                if (TextUtils.isEmpty(deviceId)) {
                    try {
                        deviceId2 = telephonyManager.getDeviceId(i2);
                        return deviceId2;
                    } catch (Throwable unused) {
                        meid = telephonyManager.getMeid(i2);
                        return meid;
                    }
                }
            } else {
                deviceId = telephonyManager.getDeviceId();
            }
            if (deviceId != null) {
                return deviceId;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }
}
