package com.czhj.sdk.common.utils;

import CtFAbx.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.mobads.sdk.internal.an;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ImageManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ImageManager f10595a;
    private Context b;
    private final ExecutorService c = ThreadPoolFactory.getFixIOExecutor();
    private final LruCache<String, Bitmap> d = new LruCache<>(4194304);
    private final Handler e = new Handler(Looper.getMainLooper());
    private File f;

    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    public class RequestCreatorRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        String f10599a;
        int b;
        int c;
        ImageView d;

        public RequestCreatorRunnable(String str) {
            this.f10599a = StringUtil.getUrl(str);
        }

        private Bitmap a() {
            String str = this.f10599a;
            File file = new File(ImageManager.this.a(), Md5Util.md5(str.substring(str.lastIndexOf("/") + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        private void b() {
            ImageManager.this.e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.RequestCreatorRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    RequestCreatorRunnable requestCreatorRunnable = RequestCreatorRunnable.this;
                    int i = requestCreatorRunnable.c;
                    if (i == 0 || (imageView = requestCreatorRunnable.d) == null) {
                        return;
                    }
                    imageView.setImageResource(i);
                }
            });
        }

        public RequestCreatorRunnable error(int i) {
            this.c = i;
            return this;
        }

        public void into(ImageView imageView) {
            this.d = imageView;
            int i = this.b;
            if (i != 0 && imageView != null) {
                imageView.setImageResource(i);
            }
            if (TextUtils.isEmpty(this.f10599a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) ImageManager.this.d.get(this.f10599a);
            if (bitmap != null && imageView != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap a2 = a();
            if (a2 == null || imageView == null) {
                ImageManager.this.c.submit(this);
            } else {
                imageView.setImageBitmap(a2);
                ImageManager.this.d.put(this.f10599a, a2);
            }
        }

        public RequestCreatorRunnable placeholder(int i) {
            this.b = i;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 3) {
                    return;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f10599a).openConnection();
                    httpURLConnection.setRequestMethod(an.c);
                    httpURLConnection.setConnectTimeout(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                    b();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    ImageManager.this.e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.RequestCreatorRunnable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView = RequestCreatorRunnable.this.d;
                            if (imageView == null) {
                                return;
                            }
                            imageView.setImageBitmap(decodeStream);
                            RequestCreatorRunnable.this.d = null;
                        }
                    });
                    ImageManager.this.d.put(this.f10599a, decodeStream);
                    String str = this.f10599a;
                    decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(ImageManager.this.a(), Md5Util.md5(str.substring(str.lastIndexOf("/") + 1)))));
                    return;
                }
                b();
                i = i2;
            }
        }
    }

    public ImageManager(Context context) {
        this.b = context.getApplicationContext();
    }

    private static ImageManager a(Context context) {
        if (f10595a == null) {
            synchronized (ImageManager.class) {
                try {
                    if (f10595a == null) {
                        f10595a = new ImageManager(context);
                    }
                } finally {
                }
            }
        }
        return f10595a;
    }

    public static ImageManager with(Context context) {
        return a(context);
    }

    public void clearCache() {
        ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(ImageManager.this.a().getAbsolutePath()), 100);
                    if (clearCacheFileByCount == null) {
                        str = "native ad file list is null";
                    } else {
                        str = "native ad file remain num: " + clearCacheFileByCount.length;
                    }
                    SigmobLog.i(str);
                } catch (Throwable th) {
                    SigmobLog.e("clean native ad file error", th);
                }
            }
        });
    }

    public ImageManager customCachePath(File file) {
        this.f = file;
        return this;
    }

    public void getBitmap(String str, final BitmapLoadedListener bitmapLoadedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String url = StringUtil.getUrl(str);
        Bitmap bitmap = this.d.get(url);
        if (bitmap != null) {
            bitmapLoadedListener.onBitmapLoaded(bitmap);
            return;
        }
        File file = new File(a(), Md5Util.md5(url.substring(url.lastIndexOf("/") + 1)));
        Bitmap decodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile == null) {
            this.c.submit(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                        httpURLConnection.setRequestMethod(an.c);
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            final Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            ImageManager.this.e.post(new Runnable() { // from class: com.czhj.sdk.common.utils.ImageManager.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bitmapLoadedListener.onBitmapLoaded(decodeStream);
                                }
                            });
                            ImageManager.this.d.put(url, decodeStream);
                            String str2 = url;
                            decodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(ImageManager.this.a(), Md5Util.md5(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        Handler handler = ImageManager.this.e;
                        BitmapLoadedListener bitmapLoadedListener2 = bitmapLoadedListener;
                        Objects.requireNonNull(bitmapLoadedListener2);
                        handler.post(new A2egSU(23, bitmapLoadedListener2));
                    }
                }
            });
        } else {
            this.d.put(url, decodeFile);
            bitmapLoadedListener.onBitmapLoaded(decodeFile);
        }
    }

    public RequestCreatorRunnable load(String str) {
        return new RequestCreatorRunnable(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a() {
        File file = this.f;
        if (file != null && file.isDirectory() && this.f.exists()) {
            return this.f;
        }
        File file2 = Environment.getExternalStorageState().equals("mounted") ? new File(this.b.getExternalCacheDir(), "SigImageCache") : new File(this.b.getCacheDir(), "SigImageCache");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        this.f = file2;
        return file2;
    }
}
