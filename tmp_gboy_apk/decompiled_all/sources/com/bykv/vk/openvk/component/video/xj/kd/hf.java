package com.bykv.vk.openvk.component.video.xj.kd;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.czhj.sdk.common.Constants;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    /* renamed from: com.bykv.vk.openvk.component.video.xj.kd.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0019hf {
        void xj(Bitmap bitmap);
    }

    public static void xj(long j, String str, InterfaceC0019hf interfaceC0019hf) {
        new xj(interfaceC0019hf, j).xj((Object[]) new String[]{str});
    }

    public static class xj extends com.bytedance.sdk.component.tf.u.hf<String, Integer, Bitmap> {
        private InterfaceC0019hf hf;
        private long w;

        public xj(InterfaceC0019hf interfaceC0019hf, long j) {
            this.hf = interfaceC0019hf;
            this.w = j;
        }

        @Override // android.os.AsyncTask
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(Constants.HTTP)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.w * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.y.w.w("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0019hf interfaceC0019hf = this.hf;
            if (interfaceC0019hf != null) {
                interfaceC0019hf.xj(bitmap);
            }
        }
    }
}
