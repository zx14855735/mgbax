package com.bytedance.sdk.openadsdk.core.a;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    public static String am() {
        return pz().getIP();
    }

    public static String c() {
        return pz().getTotalSpace();
    }

    public static String d() {
        return pz().getWifiMac(null);
    }

    public static String e() {
        return pz().getAppLogDid();
    }

    public static String f() {
        return pz().getImei(null);
    }

    public static String g() {
        return pz().getWebViewUA();
    }

    public static String hf() {
        return pz().getDeviceModel();
    }

    public static String jk() {
        return pz().getRom();
    }

    public static String kd() {
        return pz().getMnc();
    }

    public static String p() {
        return pz().getBuildSerial();
    }

    public static String pl() {
        return pz().getMacAddress(null);
    }

    public static com.bytedance.sdk.component.u.xj.xj pz() {
        return (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
    }

    public static String qt() {
        return pz().getIpv6();
    }

    public static String tf() {
        return pz().getCompilingTime();
    }

    public static String u() {
        return pz().getMcc();
    }

    public static int v() {
        return pz().getTimeZoneInt();
    }

    public static String w() {
        return pz().getLocalLanguage();
    }

    public static String xj() {
        return pz().getAndroidId();
    }

    public static String y() {
        return pz().getTotalMem();
    }

    public static String yo() {
        return pz().getUUId();
    }

    public static com.bytedance.sdk.component.u.xj.w zg() {
        return pz().getLocation();
    }

    public static String[] hf(boolean z) {
        return pz().getNewIpAddrs(z);
    }

    public static String kd(com.bytedance.sdk.openadsdk.core.io.xj xjVar) {
        return pz().getImsi(Boolean.valueOf(xjVar.xj()));
    }

    public static String u(com.bytedance.sdk.openadsdk.core.io.xj xjVar) {
        return pz().getSSID(Boolean.valueOf((xjVar.hf() && xjVar.w()) ? false : true));
    }

    public static String w(com.bytedance.sdk.openadsdk.core.io.xj xjVar) {
        return pz().getMacAddress(Boolean.valueOf(xjVar.hf()));
    }

    public static int xj(boolean z) {
        return pz().getDeviceType(z);
    }

    public static String hf(com.bytedance.sdk.openadsdk.core.io.xj xjVar) {
        return pz().getImei(Boolean.valueOf(xjVar.xj()));
    }

    public static String w(boolean z) {
        return pz().getOAID(z);
    }

    public static String xj(com.bytedance.sdk.openadsdk.core.io.xj xjVar) {
        return pz().getWifiMac(Boolean.valueOf((xjVar.hf() && xjVar.w()) ? false : true));
    }

    public static List<ResolveInfo> xj(Intent intent, int i) {
        return com.bytedance.sdk.openadsdk.core.pz.getContext().getPackageManager().queryIntentActivities(intent, i);
    }
}
