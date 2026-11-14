package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements com.bytedance.sdk.component.u.xj.xj, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return getAndroidId();
            case 2:
            case 6:
            case 19:
            case 22:
            case 23:
            case 24:
            case 27:
            case 28:
            default:
                return null;
            case 3:
                return Integer.valueOf(getConnType());
            case 4:
                return getDeviceModel();
            case 5:
                return getDeviceName();
            case 7:
                return getLanguage();
            case 8:
                return getLocalLanguage();
            case 9:
                return getMcc();
            case 10:
                return getMnc();
            case 11:
                return Integer.valueOf(getOs());
            case 12:
                return getOsVersion();
            case 13:
                return getTimeZone();
            case 14:
                return getTotalMem();
            case 15:
                return getTotalSpace();
            case 16:
                return getVendor();
            case 17:
                return getBoot();
            case 18:
                return getCarrierName();
            case 20:
                return getIP();
            case 21:
                return getUUId();
            case 25:
                return getCompilingTime();
            case 26:
                return getBuildSerial();
            case 29:
                return getUserAgent();
            case 30:
                return getRom();
            case 31:
                return Integer.valueOf(getTimeZoneInt());
            case 32:
                return getDisplayDensity();
            case 33:
                return Integer.valueOf(getDeviceType(((Boolean) sparseArray.get(1)).booleanValue()));
            case 34:
                return getWebViewUA();
            case 35:
                return getNewIpAddrs(((Boolean) sparseArray.get(1)).booleanValue());
            case 36:
                return getWifiMac((Boolean) sparseArray.get(1));
            case 37:
                com.bytedance.sdk.component.u.xj.w location = getLocation();
                return location != null ? new com.bytedance.sdk.component.u.xj.u(location) : location;
            case 38:
                return getImei((Boolean) sparseArray.get(1));
            case 39:
                return getMacAddress((Boolean) sparseArray.get(1));
            case 40:
                return getSSID((Boolean) sparseArray.get(1));
            case 41:
                return getImsi((Boolean) sparseArray.get(1));
            case 42:
                return getOAID(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return getAppLogDid();
            case 44:
                return getIpv6();
        }
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getAndroidId() {
        return com.bytedance.sdk.openadsdk.core.yo.y();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getAppLogDid() {
        return com.bytedance.sdk.openadsdk.core.y.xj().w();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getBoot() {
        String str;
        double currentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            str = new Formatter().format("%.6f", Double.valueOf(currentTimeMillis)).toString();
        } catch (Exception unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new DecimalFormat("#0.000000").format(currentTimeMillis);
        } catch (Exception unused2) {
            return str;
        }
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getBuildSerial() {
        return com.bytedance.sdk.openadsdk.core.yo.f();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getCarrierName() {
        return com.bytedance.sdk.openadsdk.core.yo.e();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getCompilingTime() {
        return com.bytedance.sdk.openadsdk.core.yo.u();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getConnType() {
        return com.bytedance.sdk.component.utils.am.w(com.bytedance.sdk.openadsdk.core.pz.getContext());
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDeviceModel() {
        return com.bytedance.sdk.openadsdk.core.yo.yo();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDeviceName() {
        Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        return context == null ? "" : Settings.Global.getString(context.getContentResolver(), "device_name");
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getDeviceType(boolean z) {
        return p.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), z);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getDisplayDensity() {
        return com.bytedance.sdk.openadsdk.core.ht.xj.xj(r.f(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getIP() {
        return p.y();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getImei(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.yo.xj(bool);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getImsi(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.yo.hf(bool);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getIpv6() {
        return p.c();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getLocalLanguage() {
        return p.p();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public com.bytedance.sdk.component.u.xj.w getLocation() {
        return u.xj(com.bytedance.sdk.openadsdk.core.pz.getContext());
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMacAddress(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.yo.kd(bool);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMcc() {
        return com.bytedance.sdk.openadsdk.core.yo.g();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getMnc() {
        return com.bytedance.sdk.openadsdk.core.yo.qt();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String[] getNewIpAddrs(boolean z) {
        return p.xj(z);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getOAID(boolean z) {
        return ra.xj(z);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getOs() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getRom() {
        return com.bytedance.sdk.openadsdk.core.ht.xj.p();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getSSID(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.yo.w(bool);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public int getTimeZoneInt() {
        return com.bytedance.sdk.openadsdk.core.ht.xj.pl();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTotalMem() {
        return String.valueOf(Long.parseLong(wo.pl()) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getTotalSpace() {
        return String.valueOf(wo.e());
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getUUId() {
        return com.bytedance.sdk.openadsdk.core.w.xj.w();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getUserAgent() {
        return wo.y();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getVendor() {
        return Build.MANUFACTURER;
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getWebViewUA() {
        return wo.c();
    }

    @Override // com.bytedance.sdk.component.u.xj.xj
    public String getWifiMac(Boolean bool) {
        return com.bytedance.sdk.openadsdk.core.yo.u(bool);
    }
}
