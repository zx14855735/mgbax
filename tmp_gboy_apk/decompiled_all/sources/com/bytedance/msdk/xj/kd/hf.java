package com.bytedance.msdk.xj.kd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.utils.pl;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends com.bytedance.sdk.component.tf.u.hf<String, Void, Bitmap> {
    private SoftReference<ImageView> hf;

    public hf(ImageView imageView) {
        this.hf = new SoftReference<>(imageView);
    }

    @Override // android.os.AsyncTask
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(an.c);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.hf.get() != null) {
                this.hf.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        w.xj("download Image", "Error download Image fail...");
    }
}
