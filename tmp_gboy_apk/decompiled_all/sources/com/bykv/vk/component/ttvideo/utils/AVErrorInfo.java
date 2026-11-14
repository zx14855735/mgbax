package com.bykv.vk.component.ttvideo.utils;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.content.Context;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVErrorInfo {
    public static final String CRASH = "crash";
    public static final String ERROR = "error";
    private static StringBuilder PHONE_INFO;

    public static void setupErrorInfo(Context context, StringBuilder sb, String str, String str2, String str3) {
        if (PHONE_INFO == null) {
            StringBuilder sb2 = new StringBuilder();
            PHONE_INFO = sb2;
            setupPhoneInfo(context, sb2);
        }
        sb.append((CharSequence) PHONE_INFO);
        sb.append("\r\n");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
    }

    public static final void setupPhoneInfo(Context context, StringBuilder sb) {
        String[] version = VersionInfo.getVersion();
        if (version != null) {
            String str = version[0];
            String str2 = version[1];
            String str3 = version[2];
            StringBuilder BChYOn2 = A2egSU.BChYOn("version:", str, ",", str2, ",");
            BChYOn2.append(str3);
            BChYOn2.append("\r\n");
            sb.append(BChYOn2.toString());
            sb.append("\r\n");
        }
        long[] romMemroy = MemoryInfo.getRomMemroy();
        if (romMemroy != null) {
            Locale locale = Locale.US;
            long j = romMemroy[0];
            long j2 = romMemroy[1];
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("rom memory totle:", j, ",availe:");
            B2KMhB2.append(j2);
            B2KMhB2.append("\r\n");
            sb.append(B2KMhB2.toString());
            sb.append("\r\n");
        }
        long availMemory = MemoryInfo.getAvailMemory(context);
        long tolalMemory = MemoryInfo.getTolalMemory();
        Locale locale2 = Locale.US;
        StringBuilder B2KMhB3 = CtFAbx.B2KMhB("ram memory totle:", tolalMemory, ",availe:");
        B2KMhB3.append(availMemory);
        B2KMhB3.append("\r\n");
        sb.append(B2KMhB3.toString());
        sb.append("\r\n");
        long[] sDCardSize = HardWareInfo.getSDCardSize(context);
        if (sDCardSize != null) {
            long j3 = sDCardSize[0];
            long j4 = sDCardSize[1];
            StringBuilder B2KMhB4 = CtFAbx.B2KMhB("sdcard totle:", j3, ",availe:");
            B2KMhB4.append(j4);
            B2KMhB4.append("\r\n");
            sb.append(B2KMhB4.toString());
            sb.append("\r\n");
        }
    }
}
