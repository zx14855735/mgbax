package com.czhj.sdk.common.mta;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class PointEntitySuper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10565a = UUID.randomUUID().toString();
    private static long b = 1;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Map<String, String> j;
    private String k;
    private String l;
    private String m;
    protected Object mPointEntityClass;
    private String n;
    private int o;
    private String p;
    private int q;

    static {
        fLlLRj();
    }

    private static synchronized long a() {
        long j;
        synchronized (PointEntitySuper.class) {
            j = b;
            b = 1 + j;
        }
        return j;
    }

    public static String captureName(String str) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        if (c <= '`' || c >= '{') {
            return str;
        }
        charArray[0] = (char) (c - ' ');
        return String.valueOf(charArray);
    }

    private static /* synthetic */ void fLlLRj() {
        char[] charArray = "\u0081\u008d\u008fÌ\u0085\u0083\u008f\u0087Ì\u0080\u008d\u009bÌ\u0091\u008a\u0087\u008e\u008eÌ¨\u008c\u008b \u0090\u008b\u0086\u0085\u0087".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 226);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0081\u008e\u008b\u008c\u008b\u0096".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 226);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String getSessionId() {
        return f10565a;
    }

    public static String lowFirstChar(String str) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        if (c <= '@' || c >= '[') {
            return str;
        }
        charArray[0] = (char) (c + ' ');
        return String.valueOf(charArray);
    }

    public static String toURLEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            SigmobLog.e(e.getMessage());
            return "";
        }
    }

    public abstract String appId();

    public void commit() {
        this.mPointEntityClass = this;
        if (TextUtils.isEmpty(this.k)) {
            setTimestamp(String.valueOf(System.currentTimeMillis()));
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.1
            @Override // java.lang.Runnable
            public void run() {
                PointEntitySuper.this.insertToDB(null);
            }
        });
    }

    public String getAc_type() {
        return this.c;
    }

    public String getAndroid_id() {
        return getDeviceContext() != null ? getDeviceContext().getAndroidId() : ClientMetadata.getInstance().getAndroidId();
    }

    public String getAppinfo_switch() {
        return this.e;
    }

    public String getCarrier() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getNetworkOperatorForUrl() : deviceContext.getCarrier();
    }

    public String getCategory() {
        return this.g;
    }

    public String getClientversion() {
        return ClientMetadata.getDeviceOsVersion();
    }

    public int getCompatible() {
        return this.q;
    }

    public abstract DeviceContext getDeviceContext();

    public String getExt() {
        return this.i;
    }

    public String getGameversion() {
        return ClientMetadata.getInstance().getAppVersion();
    }

    public String getGoogle_aid() {
        return ClientMetadata.getInstance().getAdvertisingId();
    }

    public String getImei() {
        return getDeviceContext() != null ? getDeviceContext().getImei() : ClientMetadata.getInstance().getDeviceId();
    }

    public String getImei1() {
        return getDeviceContext() != null ? getDeviceContext().getImei1() : ClientMetadata.getInstance().getDeviceId(0);
    }

    public String getImei2() {
        return getDeviceContext() != null ? getDeviceContext().getImei2() : ClientMetadata.getInstance().getDeviceId(1);
    }

    public int getIntegration() {
        return this.o;
    }

    public String getIs_mediation() {
        return this.d;
    }

    public String getLocation_switch() {
        return this.f;
    }

    public String getMd5() {
        return this.m;
    }

    public String getName() {
        return this.n;
    }

    public String getNetworktype() {
        return String.valueOf(ClientMetadata.getInstance().getActiveNetworkType());
    }

    public String getOaid() {
        return getDeviceContext() != null ? getDeviceContext().getOaid() : ClientMetadata.getInstance().getOAID();
    }

    public String getOaid_api() {
        return ClientMetadata.getInstance().getOAID_API();
    }

    public Map<String, String> getOptions() {
        if (this.j == null) {
            this.j = new HashMap();
        }
        return this.j;
    }

    public String getOs() {
        return "2";
    }

    public abstract String getSdkversion();

    public String getSeconds_from_GMT() {
        return String.valueOf(((TimeZone.getDefault().getRawOffset() / 1000) / 60) / 60);
    }

    public String getSeq_id() {
        return String.valueOf(a());
    }

    public String getSha1() {
        return this.l;
    }

    public String getSub_category() {
        return this.h;
    }

    public String getTime_zone() {
        return TimeZone.getDefault().getID();
    }

    public String getTimestamp() {
        return TextUtils.isEmpty(this.k) ? String.valueOf(System.currentTimeMillis()) : this.k;
    }

    public String getUdid() {
        return ClientMetadata.getInstance().getUDID();
    }

    public String getUid() {
        return ClientMetadata.getUid();
    }

    public String getUser_id() {
        return ClientMetadata.getUserId();
    }

    public String getVersion() {
        return this.p;
    }

    public String getWmsession_id() {
        return f10565a;
    }

    public void insertToDB(final SQLiteMTAHelper.ExecCallBack execCallBack) {
        try {
            if (!isAcTypeBlock() && !TextUtils.isEmpty(appId())) {
                Map<String, Object> map = toMap();
                Map<String, String> options = getOptions();
                if (options != null) {
                    map.remove("options");
                    map.putAll(options);
                }
                map.put("_uniq_key", "sigandroid_" + appId());
                String jsonString = toJsonString(map);
                if (TextUtils.isEmpty(jsonString)) {
                    return;
                }
                SigmobLog.d("dcdebug:" + jsonString);
                SQLiteMTAHelper sQLiteMTAHelper = SQLiteMTAHelper.getInstance();
                if (sQLiteMTAHelper == null) {
                    return;
                }
                SQLiteDatabase writableDatabase = sQLiteMTAHelper.getWritableDatabase();
                SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
                builder.setTableName(SQLiteMTAHelper.TABLE_POINT);
                HashMap hashMap = new HashMap();
                hashMap.put("item", AESUtil.EncryptString(jsonString, Constants.AESKEY));
                hashMap.put("encryption", 1);
                builder.setColumnValues(hashMap);
                SQLiteMTAHelper.insert(writableDatabase, builder.build(), new SQLiteMTAHelper.ExecCallBack() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.2
                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onFailed(Throwable th) {
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onFailed(th);
                        }
                        SigmobLog.e(th.getMessage());
                    }

                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onSuccess() {
                        SigmobLog.d("insert success!");
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onSuccess();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public abstract boolean isAcTypeBlock();

    public void sendServe() {
        sendServe(null);
    }

    public void setAc_type(String str) {
        this.c = str;
    }

    public void setAppinfo_switch(String str) {
        this.e = str;
    }

    public void setCategory(String str) {
        this.g = str;
    }

    public void setCompatible(int i) {
        this.q = i;
    }

    public void setExt(String str) {
        this.i = str;
    }

    public void setIntegration(int i) {
        this.o = i;
    }

    public void setIs_mediation(String str) {
        this.d = str;
    }

    public void setLocation_switch(String str) {
        this.f = str;
    }

    public void setMd5(String str) {
        this.m = str;
    }

    public void setName(String str) {
        this.n = str;
    }

    public void setOptions(Map<String, String> map) {
        Map<String, String> options = getOptions();
        this.j = options;
        options.putAll(map);
    }

    public void setSha1(String str) {
        this.l = str;
    }

    public void setSub_category(String str) {
        this.h = str;
    }

    public void setTimestamp(String str) {
        this.k = str;
    }

    public void setVersion(String str) {
        this.p = str;
    }

    public String testJsonString() {
        Map<String, Object> map = toMap();
        if (getOptions() != null) {
            map.remove("options");
            map.putAll(getOptions());
        }
        return toJsonString(map);
    }

    public String toJsonString(Map<String, Object> map) {
        String obj;
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        boolean z = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (z) {
                    sb.append(",");
                }
                sb.append("\"" + key + "\":");
                if (value instanceof String) {
                    obj = (String) value;
                    if (!a(key)) {
                        obj = toURLEncoded(obj);
                    }
                } else {
                    obj = value.toString();
                }
                if (obj.startsWith("{") || obj.startsWith("[")) {
                    sb.append(obj);
                } else {
                    sb.append("\"" + obj + "\"");
                }
                z = true;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Map<String, Object> toMap() {
        List<Method> methodWithTraversal = ReflectionUtil.getMethodWithTraversal(this.mPointEntityClass.getClass());
        if (methodWithTraversal == null || methodWithTraversal.isEmpty()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(methodWithTraversal.size());
        for (Method method : methodWithTraversal) {
            String name = method.getName();
            if (name.startsWith("get") && !name.equals("getLogs") && !name.equals("getDeviceContext")) {
                try {
                    Object invoke = method.invoke(this.mPointEntityClass, new Object[0]);
                    String lowFirstChar = lowFirstChar(name.substring(3));
                    if (invoke != null && (!(invoke instanceof String) || !TextUtils.isEmpty((String) invoke))) {
                        if (lowFirstChar.equalsIgnoreCase(f.k)) {
                            lowFirstChar = "content-length";
                        } else if (lowFirstChar.equalsIgnoreCase("content_type")) {
                            lowFirstChar = "content-type";
                        } else if (lowFirstChar.equalsIgnoreCase("ac_type")) {
                            lowFirstChar = PointParamKey._AC_TYPE;
                        } else if (lowFirstChar.equalsIgnoreCase("user_id")) {
                            lowFirstChar = "_user_id";
                        } else if (!lowFirstChar.equalsIgnoreCase("class")) {
                        }
                        hashMap.put(lowFirstChar, invoke);
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder("name ");
                    sb.append(name);
                    A2egSU.BJ7GGh(th, sb);
                }
            }
        }
        return hashMap;
    }

    private boolean a(String str) {
        return Arrays.asList("motion_before", "motion_after", PointParamKey.FREQUENCY_CONTROL_LIST).contains(str);
    }

    public void sendServe(BuriedPointRequest.RequestListener requestListener) {
        this.mPointEntityClass = this;
        String jsonString = toJsonString(toMap());
        if (TextUtils.isEmpty(jsonString)) {
            return;
        }
        try {
            String str = "sigandroid_" + appId();
            BuriedPointRequest.BuriedPointSend(toURLEncoded(BuriedPointManager.deflateAndBase64("_uniq_key=" + str + "&_batch_value=" + ("[" + jsonString + "]"))), requestListener);
        } catch (Exception e) {
            SigmobLog.e(e.getMessage());
        }
    }
}
