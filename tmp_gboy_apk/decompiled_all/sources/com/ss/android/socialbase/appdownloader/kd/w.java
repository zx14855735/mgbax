package com.ss.android.socialbase.appdownloader.kd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.network.d;
import com.ss.android.socialbase.downloader.tf.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private static volatile w hf = null;
    private static int xj = 8;
    private xj<Integer, Bitmap> w;

    public static class xj<K, T> extends LinkedHashMap<K, T> {
        final int xj;

        public xj(int i, int i2) {
            super(i2, 0.75f, true);
            this.xj = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.xj;
        }
    }

    private w() {
        this.w = null;
        int i = xj;
        this.w = new xj<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream hf(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static w xj() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public Bitmap xj(int i) {
        return this.w.get(Integer.valueOf(i));
    }

    public void xj(final int i, final String str) {
        if (TextUtils.isEmpty(str) || xj(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.g().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.kd.w.1
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        d xj2 = com.ss.android.socialbase.downloader.downloader.w.xj(true, 0, str, null);
                        if (xj2 == null) {
                            y.xj(null, null, null, null);
                            return;
                        }
                        inputStream = xj2.xj();
                        try {
                            byteArrayOutputStream = w.hf(inputStream);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e2) {
                                byteArrayInputStream2 = null;
                                e = e2;
                                byteArrayInputStream = null;
                            } catch (Throwable th2) {
                                closeable = null;
                                th = th2;
                                byteArrayInputStream = null;
                            }
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int xj3 = com.ss.android.socialbase.appdownloader.w.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), 44.0f);
                                    options.inSampleSize = w.xj(xj3, xj3, options);
                                    options.inJustDecodeBounds = false;
                                    w.this.w.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    y.xj(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                } catch (Exception e3) {
                                    e = e3;
                                    pl.xj(e);
                                    y.xj(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                }
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e = e4;
                            } catch (Throwable th3) {
                                closeable = null;
                                th = th3;
                                y.xj(inputStream, byteArrayOutputStream, byteArrayInputStream, closeable);
                                throw th;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            e = e5;
                            byteArrayOutputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream = null;
                            closeable = null;
                            th = th4;
                            byteArrayOutputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    inputStream = null;
                } catch (Throwable th6) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    closeable = null;
                    th = th6;
                    inputStream = null;
                }
            }
        });
    }

    public static int xj(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
