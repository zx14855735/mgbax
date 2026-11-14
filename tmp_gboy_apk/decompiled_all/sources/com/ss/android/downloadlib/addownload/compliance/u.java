package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.w;
import com.ss.android.socialbase.downloader.network.d;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u extends com.ss.android.socialbase.downloader.tf.f<Long, Bitmap> {
    private final Map<Long, SoftReference<xj>> xj;

    public static class hf {
        private static u xj = new u();

        static {
            JXLP();
        }

        private static /* synthetic */ void JXLP() {
            char[] charArray = "nb`#jl`h#obt#~ehaa#GcdO\u007fdijh".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\r');
            }
            String str = new String(charArray);
            char[] charArray2 = "nadcdy".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\r');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface xj {
        void xj(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hf(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    private u() {
        super(8, 8);
        this.xj = new HashMap();
    }

    public static u xj() {
        return hf.xj;
    }

    public void xj(long j, xj xjVar) {
        if (get(Long.valueOf(j)) != null) {
            xjVar.xj(get(Long.valueOf(j)));
        } else {
            this.xj.put(Long.valueOf(j), new SoftReference<>(xjVar));
        }
    }

    public void xj(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<xj> remove = this.xj.remove(Long.valueOf(j));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().xj(get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            c.xj(12, j2);
        } else {
            com.ss.android.downloadlib.c.w.xj((w.xj<Object, R>) new w.xj<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.u.2
                @Override // com.ss.android.downloadlib.c.w.xj
                public Object xj(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    d xj2;
                    try {
                        xj2 = com.ss.android.socialbase.downloader.downloader.w.xj(true, 0, str, null);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.tf.y.xj(bufferedInputStream);
                        throw th;
                    }
                    if (xj2 == null) {
                        com.ss.android.socialbase.downloader.tf.y.xj(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(xj2.xj());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i = options.outWidth;
                            int i2 = options.outHeight;
                            int xj3 = g.xj(pl.getContext(), 60.0f);
                            options.inSampleSize = u.hf(xj3, xj3, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e2) {
                                com.bytedance.sdk.component.utils.pl.xj(e2);
                            }
                            com.ss.android.downloadlib.u.xj.xj().xj("ttd_pref_monitor", jSONObject, j2);
                            u.this.put(Long.valueOf(j), decodeStream);
                            com.ss.android.socialbase.downloader.tf.y.xj(bufferedInputStream);
                        } catch (Exception e3) {
                            e = e3;
                            com.ss.android.downloadlib.kd.w.xj().xj(e, "BitmapCache loadBitmap");
                            com.ss.android.socialbase.downloader.tf.y.xj(bufferedInputStream);
                            return null;
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.ss.android.socialbase.downloader.tf.y.xj(bufferedInputStream);
                        throw th;
                    }
                }
            }, (Object) null).xj(new w.xj<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.u.1
                @Override // com.ss.android.downloadlib.c.w.xj
                public Object xj(Object obj) {
                    SoftReference softReference = (SoftReference) u.this.xj.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((xj) softReference.get()).xj(u.this.get(Long.valueOf(j)));
                    return null;
                }
            }).xj();
        }
    }
}
