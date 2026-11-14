package com.bytedance.msdk.api;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public String hf;
    public String u;
    public int w;
    public int xj;

    public xj() {
        this(-99999, "no error message");
    }

    public static String xj(int i) {
        switch (i) {
            case -2:
                break;
            case -1:
                break;
            case 1:
                break;
            case AVMDLDataLoader.KeyIsStoRingBufferSizeKB /* 10003 */:
                break;
            case 10012:
                break;
            case 10013:
                break;
            case 10014:
                break;
            case 10015:
                break;
            case 20005:
                break;
            case 40044:
                break;
            case 40045:
            case 840040:
                break;
            case 40047:
                break;
            case 40048:
                break;
            case 40052:
                break;
            case 40061:
                break;
            case 40062:
                break;
            case 40063:
                break;
            case 40064:
                break;
            case 41005:
                break;
            case 41007:
                break;
            case 41008:
                break;
            case 41041:
                break;
            case 41042:
                break;
            case 41043:
                break;
            case 41044:
                break;
            case 44404:
                break;
            case 44405:
                break;
            case 49000:
                break;
            case 49001:
                break;
            case 49002:
                break;
            case 49003:
                break;
            case 49004:
                break;
            case 49005:
                break;
            case 49006:
                break;
            case 49007:
                break;
            case 49008:
                break;
            case 49009:
                break;
            case 49010:
                break;
            case 49012:
                break;
            case 49015:
                break;
            case 49016:
                break;
            case 50100:
                break;
            case 81001:
                break;
            case 81002:
                break;
            case 81003:
                break;
            case 81004:
                break;
            case 81008:
                break;
            case 81009:
                break;
            case 81010:
                break;
            case 81011:
                break;
            case 81012:
                break;
            case 810085:
                break;
            case 840026:
                break;
            case 840027:
                break;
            case 840028:
                break;
            case 840029:
                break;
            case 840030:
                break;
            case 840031:
                break;
            case 840032:
                break;
            case 840033:
                break;
            case 840034:
                break;
            case 840035:
                break;
            case 840036:
                break;
            case 840037:
                break;
            case 840038:
                break;
            case 840039:
                break;
            case 840041:
                break;
            case 840042:
                break;
            case 840043:
                break;
        }
        return "信息流广告暂无广告返回，请稍后重试";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdError{code=");
        sb.append(this.xj);
        sb.append(", message='");
        sb.append(this.hf);
        sb.append("', thirdSdkErrorCode=");
        sb.append(this.w);
        sb.append(", thirdSdkErrorMessage='");
        return CtFAbx.B25kr6(sb, this.u, "'}");
    }

    public xj(String str) {
        this(-99999, str);
    }

    public xj(int i, String str) {
        this(i, str, i, str);
    }

    public xj(int i, String str, int i2, String str2) {
        this.xj = i;
        this.hf = str;
        this.w = i2;
        this.u = str2;
    }
}
