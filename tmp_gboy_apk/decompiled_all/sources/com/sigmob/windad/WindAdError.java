package com.sigmob.windad;

import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum WindAdError {
    ERROR_LOAD_FILTER_FOR_PROVIDER_ERROR(600201, "Provider 声明错误，请检查 AndroidManifest 文件"),
    ERROR_LOAD_FILTER_FOR_PROVIDER_XML_ERROR(600200, "Provider 的 Xml 配置错误，请检查 Xml 文件内容"),
    ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR(600202, "SDK 混淆配置错误"),
    ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR(600203, "AdActivity 未声明，请检查 AndroidManifest 文件"),
    ERROR_LOAD_FILTER_FOR_INSTALL_PERMISSION_ERROR(600204, " 缺少 REQUEST_INSTALL_PACKAGES，请检查 AndroidManifest 文件"),
    ERROR_AD_LOAD_FAIL_LOADING(610012, "广告正在加载中，请稍后再加载"),
    ERROR_AD_LOAD_FAIL_INTERVAL(610013, "广告加载频繁，请稍后在试"),
    ERROR_SIGMOB_BID_TOKEN_IS_EMPTY(600300, "BidToken is empty"),
    ERROR_SIGMOB_PERSONALIZED_OFF(600400, "广告个性化开关被关闭，请开启个性化开关"),
    ERROR_SIGMOB_NETWORK(600100, "网络错误"),
    ERROR_SIGMOB_REQUEST(600101, "广告请求出错"),
    ERROR_SIGMOB_EXPIRED(600180, "广告过期"),
    ERROR_SIGMOB_NATIVE_ADCOUNT(650001, "广告请求数 ad_count 必需大于 0"),
    ERROR_SIGMOB_FILE_DOWNLOAD(600104, "文件下载错误"),
    ERROR_SIGMOB_BAD_REQUEST(600150, "内部错误，请联系运营或技术人员"),
    ERROR_SIGMOB_AD_TIME_OUT(600105, "加载广告超时"),
    ERROR_SIGMOB_PLAY_VIDEO(600106, "视频播放失败"),
    ERROR_SIGMOB_NOT_START(600900, "SDK 未启动，请先调用 start 方法启动 SDK"),
    ERROR_SIGMOB_PLACEMENTID_EMPTY(600901, "广告位为空"),
    ERROR_SIGMOB_INSTALL_FAIL(600903, "安装失败"),
    ERROR_SIGMOB_AD_DB_INSERT(600904, "插入数据库失败"),
    ERROR_SIGMOB_GDPR_DENIED(600905, "GDPR 未授权"),
    ERROR_SIGMOB_INIT_FAIL(600906, "SDK 初始化失败"),
    ERROR_SIGMOB_ADCONTAINER_IS_NULL(600907, "广告容器不能为 null"),
    ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP(600908, "广告容器只允许为 ViewGroup 类型"),
    ERROR_OTHER(600999, ""),
    ERROR_SIGMOB_AD_PLAY(610002, "激励视频播放出错"),
    ERROR_SIGMOB_SPLASH_NOT_READY(610003, "开屏广告未准备好"),
    ERROR_SIGMOB_INFORMATION_LOSE(610004, "广告缺失关键信息"),
    ERROR_SIGMOB_FILE_MD5(610005, "下载的文件校验 md5 出错"),
    ERROR_SIGMOB_VIDEO_FILE(610008, "下载的视频文件出错"),
    ERROR_SIGMOB_AD_PLAY_CHECK_FAIL(610006, "激励视频播接口检查出错（广告过期或者未 Ready）"),
    ERROR_SIGMOB_AD_PLAY_HAS_PLAYING(610007, "激励视频播接口检查出错（激励视频当前有广告正在播放中）"),
    ERROR_SIGMOB_SPLASH_TIMEOUT(620001, "开屏广告加载超时"),
    ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION(620002, "开屏广告不支持当前方向"),
    ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE(620003, "开屏广告不支持的资源类型"),
    ERROR_SPLASH_ADBLOCK(620900, "AD BLOCK"),
    ERROR_AD_ERROR(0, "AD ERROR"),
    RENDER_PROCESS_GONE_WITH_CRASH(620901, "RENDER PROCESS GONE WITH CRASH"),
    RENDER_PROCESS_GONE_UNSPECIFIED(620902, "RENDER PROCESS GONE UNSPECIFIED"),
    MRAID_LOAD_ERROR(620903, "MRAID LOAD ERROR"),
    VIDEO_CACHE_ERROR(620904, "VIDEO CACHE ERROR"),
    ERROR_NO_AD(200000, "无广告填充");


    /* renamed from: a, reason: collision with root package name */
    private int f13781a;
    private String message;

    static {
        yubY();
    }

    WindAdError(int i, String str) {
        this.f13781a = i;
        this.message = str;
    }

    public static WindAdError getWindAdError(int i) {
        for (WindAdError windAdError : values()) {
            if (windAdError.getErrorCode() == i) {
                return windAdError;
            }
        }
        return null;
    }

    private static /* synthetic */ void yubY() {
        char[] charArray = "_SQ\u0012[]QY\u0012^SE\u0012OTYPP\u0012vRU~NUX[Y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '<');
        }
        String str = new String(charArray);
        char[] charArray2 = "_PURUH".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '<');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getErrorCode() {
        return this.f13781a;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorMessage(int i, String str) {
        this.f13781a = i;
        this.message = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format(Locale.getDefault(), "{ \"error_code\":%d, \"message\": %s }", Integer.valueOf(this.f13781a), this.message);
    }
}
