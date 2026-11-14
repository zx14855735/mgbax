package com.bytedance.sdk.openadsdk.upie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.c.u;
import com.bytedance.sdk.component.u.hf.w;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.component.y.zg;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static final String hf;
    private static volatile hf u;
    private static final String xj;
    private final w w = new u.xj().xj("lottie_tpl_info").xj(com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext()).xj(1).xj(com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl()).xj();

    public interface xj<T> {
        void xj(int i, String str);

        void xj(T t);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        xj = A2egSU.AzWtSf(sb, str, "lottie", str, MediaFormat.KEY_AUDIO);
        hf = "tt_derive" + str + "lottie" + str + "anim_img";
        oEAi();
    }

    private hf() {
    }

    private static /* synthetic */ void oEAi() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void hf(String str, final xj<Bitmap> xjVar) {
        ht kd = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd();
        if (kd != null) {
            kd.from(str).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.hf.3
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str2, Throwable th) {
                    xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.xj(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    xj xjVar2;
                    try {
                        Bitmap result = zgVar.getResult();
                        if (result == null || (xjVar2 = xjVar) == null) {
                            return;
                        }
                        xjVar2.xj(result);
                    } catch (Throwable th) {
                        pl.xj(th);
                    }
                }
            }, 4);
        } else if (xjVar != null) {
            xjVar.xj(-1, "imageCenter is null");
        }
    }

    public static hf xj() {
        if (u == null) {
            synchronized (hf.class) {
                try {
                    if (u == null) {
                        u = new hf();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public void xj(Context context, com.bytedance.sdk.openadsdk.upie.xj xjVar) {
        if (xjVar != null) {
            String w = xjVar.w();
            if (!TextUtils.isEmpty(w)) {
                hf(w, null);
            }
            String xj2 = xjVar.xj();
            if (TextUtils.isEmpty(xj2) || !TextUtils.isEmpty(xj(xj2))) {
                return;
            }
            xj(xj2, (xj<String>) null);
        }
    }

    public void xj(final String str, final xj<String> xjVar) {
        com.bytedance.sdk.component.d.hf.w kd = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().kd();
        if (kd == null) {
            return;
        }
        kd.xj(str);
        kd.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.upie.hf.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                String u2;
                boolean z = false;
                if (hfVar != null) {
                    try {
                        if (hfVar.f() && (u2 = hfVar.u()) != null) {
                            try {
                                pl.xj("TTDeriveTplManager", "lottie content is ok, version: " + new JSONObject(u2).optString(t.c));
                                hf.this.xj(str, u2);
                                xj xjVar2 = xjVar;
                                if (xjVar2 != null) {
                                    xjVar2.xj(u2);
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                pl.xj(e);
                                if (xjVar != null) {
                                    String message = e.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    xjVar.xj(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        pl.xj(th);
                        xj xjVar3 = xjVar;
                        if (xjVar3 != null) {
                            xjVar3.xj(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                xj xjVar4 = xjVar;
                if (xjVar4 != null) {
                    StringBuilder sb = new StringBuilder("lottieJsonUrl加载失败1, response is not null:");
                    sb.append(hfVar != null);
                    sb.append(", isSuccess:");
                    if (hfVar != null && hfVar.f()) {
                        z = true;
                    }
                    sb.append(z);
                    xjVar4.xj(10001, sb.toString());
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void xj(Context context, String str, final xj<Bitmap> xjVar) {
        ht kd = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd();
        if (kd != null) {
            kd.from(str).cacheDir(xj(context)).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.hf.2
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str2, Throwable th) {
                    xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.xj(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    xj xjVar2;
                    try {
                        Bitmap result = zgVar.getResult();
                        if (result == null || (xjVar2 = xjVar) == null) {
                            return;
                        }
                        xjVar2.xj(result);
                    } catch (Throwable th) {
                        pl.xj(th);
                    }
                }
            }, 4);
        } else if (xjVar != null) {
            xjVar.xj(-1, "imageCenter is null");
        }
    }

    public String xj(String str) {
        String hf2 = kd.hf(str);
        if (TextUtils.isEmpty(hf2)) {
            return null;
        }
        return this.w.get(hf2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2) {
        String hf2 = kd.hf(str);
        if (TextUtils.isEmpty(hf2)) {
            return;
        }
        this.w.put(hf2, str2);
    }

    public String xj(Context context) {
        return y.xj(context, com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().pl(), hf).getAbsolutePath();
    }
}
