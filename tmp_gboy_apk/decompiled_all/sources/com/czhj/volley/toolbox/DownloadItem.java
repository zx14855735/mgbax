package com.czhj.volley.toolbox;

import com.czhj.volley.VolleyError;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownloadItem {
    public VolleyError error;
    public String filePath;
    public String md5;
    public String message;
    public long networkMs;
    public long size;
    public int status;
    public FileType type;
    public String url;
    public boolean userRange = true;

    public enum FileType {
        VIDEO(1),
        PICTURE(2),
        FILE(3),
        APK(8),
        OTHER(9),
        ZIP_FILE(10),
        MRAID_VIDEO(11);

        private int mType;

        static {
            mYLp();
        }

        FileType(int i) {
            this.mType = i;
        }

        private static /* synthetic */ void mYLp() {
            char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 20);
            }
            String str = new String(charArray);
            char[] charArray2 = "wx}z}`".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 20);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public int getType() {
            return this.mType;
        }
    }
}
