package com.bytedance.sdk.component.d.hf;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.c;
import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.xj;
import com.bytedance.sdk.component.hf.xj.y;
import com.bytedance.sdk.component.hf.xj.zg;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends u {
    private boolean d;
    private com.bytedance.sdk.component.hf.xj.xj f;
    private Map<String, String> tf;
    public static final com.bytedance.sdk.component.hf.xj.xj xj = new xj.C0115xj().xj().hf();
    public static final com.bytedance.sdk.component.hf.xj.xj hf = new xj.C0115xj().hf();

    static {
        MqCBJ();
    }

    public w(pl plVar) {
        super(plVar);
        this.f = xj;
        this.d = false;
        this.tf = new HashMap();
    }

    private static /* synthetic */ void MqCBJ() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void xj(String str, String str2) {
        if (str == null) {
            com.bytedance.sdk.component.d.u.kd.xj("GetExecutor", "name cannot be null !!!");
        } else {
            this.tf.put(str, str2);
        }
    }

    public void xj(final com.bytedance.sdk.component.d.xj.xj xjVar) {
        try {
            am.xj xjVar2 = new am.xj();
            if (this.d) {
                xjVar2.xj(this.y);
            } else {
                c.xj xjVar3 = new c.xj();
                Uri parse = Uri.parse(this.y);
                xjVar3.xj(parse.getScheme());
                xjVar3.hf(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    xjVar3.w(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tf.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tf.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        xjVar3.xj(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                xjVar2.xj(xjVar3.hf());
            }
            xj(xjVar2);
            xjVar2.xj(this.f);
            xjVar2.xj((Object) hf());
            this.w.xj(xjVar2.xj().hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bytedance.sdk.component.d.hf.w.1
                @Override // com.bytedance.sdk.component.hf.xj.w
                public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
                    com.bytedance.sdk.component.d.xj.xj xjVar4 = xjVar;
                    if (xjVar4 != null) {
                        xjVar4.xj(w.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.hf.xj.w
                public void onResponse(com.bytedance.sdk.component.hf.xj.hf hfVar, zg zgVar) {
                    if (xjVar != null) {
                        HashMap hashMap = new HashMap();
                        if (zgVar != null) {
                            y c = zgVar.c();
                            if (c != null) {
                                for (int i = 0; i < c.xj(); i++) {
                                    hashMap.put(c.xj(i), c.hf(i));
                                }
                            }
                            e y = zgVar.y();
                            xjVar.xj(w.this, new com.bytedance.sdk.component.d.hf(zgVar.u(), zgVar.w(), zgVar.kd(), hashMap, y == null ? "" : y.hf(), zgVar.hf(), zgVar.xj()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.d.u.kd.xj()) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
            if (xjVar != null) {
                xjVar.xj(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.hf.u
    public com.bytedance.sdk.component.d.hf xj() {
        try {
            am.xj xjVar = new am.xj();
            if (this.d) {
                xjVar.xj(this.y);
            } else {
                c.xj xjVar2 = new c.xj();
                Uri parse = Uri.parse(this.y);
                xjVar2.xj(parse.getScheme());
                xjVar2.hf(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    xjVar2.w(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tf.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tf.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        xjVar2.xj(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                xjVar.xj(xjVar2.hf());
            }
            xj(xjVar);
            xjVar.xj(this.f);
            xjVar.xj((Object) hf());
            zg hf2 = this.w.xj(xjVar.xj().hf()).hf();
            if (hf2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            y c = hf2.c();
            if (c != null) {
                for (int i = 0; i < c.xj(); i++) {
                    hashMap.put(c.xj(i), c.hf(i));
                }
            }
            e y = hf2.y();
            return new com.bytedance.sdk.component.d.hf(hf2.u(), hf2.w(), hf2.kd(), hashMap, y != null ? y.hf() : "", hf2.hf(), hf2.xj());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }
}
