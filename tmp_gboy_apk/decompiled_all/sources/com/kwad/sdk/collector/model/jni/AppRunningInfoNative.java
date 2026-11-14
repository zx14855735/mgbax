package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.aa;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    private static SimpleDateFormat aiH = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    static {
        LQBrMn();
    }

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Fz, reason: merged with bridge method [inline-methods] */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    private static /* synthetic */ void LQBrMn() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative);
        if (appRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return appRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    private static String aq(long j) {
        return aiH.format(new Date(j));
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / appRunningInfoGetGranularity;
        return ((AppStatusNative.appRunningInfoGetPackageName(this).hashCode() + (AppStatusNative.appRunningInfoGetName(this).hashCode() * 31)) * 31) + ((int) (appRunningInfoGetLastRunningTime ^ (appRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        aa.putValue(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        aa.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + aq(c.c(this)) + '}';
    }

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }
}
