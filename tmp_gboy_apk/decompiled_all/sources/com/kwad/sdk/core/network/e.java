package com.kwad.sdk.core.network;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    public static e aIX = new e(-1, "请求超时事件");
    public static e aIY = new e(-2, "请求异常");
    public static e aIZ = new e(-1000, "该业务组件未加载");
    public static e aJa = new e(40001, "网络错误");
    public static e aJb = new e(40002, "数据解析错误");
    public static e aJc = new e(40003, "数据为空");
    public static e aJd = new e(40004, "视频资源缓存失败");
    public static e aJe = new e(40005, "网络超时");
    public static e aJf = new e(40007, "图片下载失败");
    public static e aJg = new e(40008, "广告场景不匹配");
    public static e aJh = new e(40009, "广告加载异常");
    public static e aJi = new e(40010, "activity场景不匹配");
    public static e aJj = new e(40011, "sdk初始化失败");
    public static e aJk = new e(40012, "权限未开启");
    public static e aJl = new e(40013, "SDK未调用start方法");
    public static e aJm = new e(100006, "更多视频请前往快手App查看");
    public static e aJn = new e(100007, "复制链接失败，请稍后重试");
    public static e aJo = new e(100008, "内容有点敏感，不可以发送哦");
    public static e aJp = new e(130001, "数据不存在");
    public static e aJq = new e(0, "网络超时");
    public final int errorCode;
    public final String msg;

    static {
        ruDeQb();
    }

    private e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }

    private static /* synthetic */ void ruDeQb() {
        char[] charArray = "=13p9?3;p<1'p-6;22p\u001407\u001c,7:9;".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '^');
        }
        String str = new String(charArray);
        char[] charArray2 = "=2707*".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '^');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
