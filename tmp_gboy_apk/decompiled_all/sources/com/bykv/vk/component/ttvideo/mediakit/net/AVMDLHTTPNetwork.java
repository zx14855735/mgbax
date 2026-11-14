package com.bykv.vk.component.ttvideo.mediakit.net;

import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.hf;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.hf.xj.w;
import com.bytedance.sdk.component.hf.xj.zg;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final tf JSON = tf.xj(an.d);
    private static pl mClient;
    private hf mCall;

    static {
        DbVrnh();
    }

    private static /* synthetic */ void DbVrnh() {
        char[] charArray = "oca\"kmai\"ncu\"\u007fdi``\"FbeN~ehki".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\f');
        }
        String str = new String(charArray);
        char[] charArray2 = "o`ebex".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        hf hfVar = this.mCall;
        if (hfVar == null || hfVar.u()) {
            return;
        }
        this.mCall.w();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            try {
                if (mClient == null) {
                    pl.xj hf = new pl().hf();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    mClient = hf.xj(10L, timeUnit).w(10L, timeUnit).hf(10L, timeUnit).xj();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        am.xj xj = new am.xj().xj(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                xj.xj(str2, map.get(str2));
            }
        }
        hf xj2 = mClient.xj(xj.hf());
        this.mCall = xj2;
        xj2.xj(new w() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onFailure(hf hfVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onResponse(hf hfVar, zg zgVar) {
                e eVar;
                Throwable th2;
                JSONObject jSONObject;
                try {
                    eVar = zgVar.y();
                    try {
                        try {
                            jSONObject = new JSONObject(eVar.hf());
                            e = null;
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (eVar != null) {
                                try {
                                    eVar.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.bytedance.sdk.component.utils.pl.xj(e);
                        jSONObject = null;
                    }
                    if (e == null && !zgVar.u()) {
                        e = new Exception("http fail");
                        zgVar.w();
                    }
                    if (eVar != null) {
                        try {
                            eVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th4) {
                    eVar = null;
                    th2 = th4;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            try {
                if (mClient == null) {
                    pl.xj hf = new pl().hf();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    mClient = hf.xj(10L, timeUnit).w(10L, timeUnit).hf(10L, timeUnit).xj();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        am.xj xj = new am.xj().xj(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                xj.hf(str2, map.get(str2));
            }
        }
        if (i == 1) {
            xj.xj(qt.xj(JSON, String.valueOf(jSONObject)));
        }
        hf xj2 = mClient.xj(xj.hf());
        this.mCall = xj2;
        xj2.xj(new w() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onFailure(hf hfVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onResponse(hf hfVar, zg zgVar) {
                e eVar;
                Throwable th2;
                String obj;
                JSONObject jSONObject2;
                try {
                    eVar = zgVar.y();
                    try {
                        try {
                            jSONObject2 = new JSONObject(eVar.hf());
                            obj = null;
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (eVar != null) {
                                try {
                                    eVar.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Exception e) {
                        obj = e.toString();
                        com.bytedance.sdk.component.utils.pl.xj(e);
                        jSONObject2 = null;
                    }
                    if (!zgVar.u()) {
                        obj = zgVar.kd();
                        zgVar.w();
                    }
                    if (eVar != null) {
                        try {
                            eVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (obj == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, obj.toString()));
                    }
                } catch (Throwable th4) {
                    eVar = null;
                    th2 = th4;
                }
            }
        });
    }
}
