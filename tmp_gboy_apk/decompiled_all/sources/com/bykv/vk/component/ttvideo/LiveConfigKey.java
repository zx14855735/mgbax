package com.bykv.vk.component.ttvideo;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface LiveConfigKey {
    public static final String ABR_BB_4LIVE = "abr_bb_4live";
    public static final String AUTO = "auto";
    public static final String AVPH = "avph";
    public static final String BACKUP = "backup";
    public static final String CMAF = "cmaf";
    public static final String DEFAULT_KCP_PORT = "8848";
    public static final String DEFAULT_QUIC_PORT = "80";
    public static final String DEFAULT_TCP_PORT = "80";
    public static final String DEFAULT_TLS_PORT = "443";
    public static final String FLV = "flv";
    public static final String HLS = "hls";
    public static final String KCP = "kcp";
    public static final String MAIN = "main";
    public static final String MEDIUM = "md";
    public static final String NONE = "none";
    public static final String ONLYAUDIO = "only_audio=1";
    public static final String ONLYVIDEO = "only_video=1";
    public static final String QUIC = "quic";
    public static final String QUICU = "quicu";
    public static final String RAD = "rad";
    public static final String RTMP = "rtmp";
    public static final String TCP = "tcp";
    public static final String TLS = "tls";
    public static final String TSL = "tsl";
    public static final String UNRELIABLE = "unreliable=1";
    public static final String ORIGIN = "origin";
    public static final String UHD = "uhd";
    public static final String HIGH = "hd";
    public static final String STANDARD = "sd";
    public static final String LOW = "ld";
    public static final String AUDIO = "ao";
    public static final String[] resolution = {ORIGIN, UHD, HIGH, STANDARD, LOW, AUDIO};

    static {
        nXrqA();
    }

    private static /* synthetic */ void nXrqA() {
        char[] charArray = "/#!b+-!)b.#5b?$)  b\u0006\"%\u000e>%(+)".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'L');
        }
        String str = new String(charArray);
        char[] charArray2 = "/ %\"%8".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'L');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
