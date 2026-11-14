package com.baidu.mobads.sdk.internal;

import java.lang.reflect.Method;
import java.util.Observer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface v {

    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");

        private int i;
        private String j;

        static {
            xfDENji();
        }

        a(int i, String str) {
            this.i = i;
            this.j = str;
        }

        private static /* synthetic */ void xfDENji() {
            char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 158);
            }
            String str = new String(charArray);
            char[] charArray2 = "ýò÷ð÷ê".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 158);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public int b() {
            return this.i;
        }

        public String c() {
            return this.j;
        }
    }

    void a();

    void a(boolean z);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
