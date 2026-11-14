package com.bytedance.sdk.component.w.hf.xj.kd;

import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.adevent.AdEventType;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class p {
    private final xj u = new xj();
    private static final int[] xj = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 2042, 1018, 1019, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 2043, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, AdEventType.AD_RENDER_SUCCESS, 110, 111, AdEventType.AD_TICK, AdEventType.AD_ZOOM_OUT, AdEventType.AD_ZOOM_OUT_PLAY_FINISH, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, 44, 8, 9, 45, 119, AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] hf = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
    private static final p w = new p();

    private p() {
        hf();
    }

    private void hf() {
        int i = 0;
        while (true) {
            byte[] bArr = hf;
            if (i >= bArr.length) {
                return;
            }
            xj(i, xj[i], bArr[i]);
            i++;
        }
    }

    public static p xj() {
        return w;
    }

    public void xj(com.bytedance.sdk.component.w.xj.y yVar, com.bytedance.sdk.component.w.xj.u uVar) {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < yVar.c(); i2++) {
            int xj2 = yVar.xj(i2) & 255;
            int i3 = xj[xj2];
            byte b = hf[xj2];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i -= 8;
                uVar.d((int) (j >> i));
            }
        }
        if (i > 0) {
            uVar.d((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public static final class xj {
        final int hf;
        final int w;
        final xj[] xj;

        public xj() {
            this.xj = new xj[256];
            this.hf = 0;
            this.w = 0;
        }

        public xj(int i, int i2) {
            this.xj = null;
            this.hf = i;
            int i3 = i2 & 7;
            this.w = i3 == 0 ? 8 : i3;
        }
    }

    public int xj(com.bytedance.sdk.component.w.xj.y yVar) {
        long j = 0;
        for (int i = 0; i < yVar.c(); i++) {
            j += hf[yVar.xj(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public byte[] xj(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xj xjVar = this.u;
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & 255);
            i2 += 8;
            while (i2 >= 8) {
                xjVar = xjVar.xj[(i >>> (i2 - 8)) & 255];
                if (xjVar.xj == null) {
                    byteArrayOutputStream.write(xjVar.hf);
                    i2 -= xjVar.w;
                    xjVar = this.u;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            xj xjVar2 = xjVar.xj[(i << (8 - i2)) & 255];
            if (xjVar2.xj != null || xjVar2.w > i2) {
                break;
            }
            byteArrayOutputStream.write(xjVar2.hf);
            i2 -= xjVar2.w;
            xjVar = this.u;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void xj(int i, int i2, byte b) {
        xj xjVar = new xj(i, b);
        xj xjVar2 = this.u;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            xj[] xjVarArr = xjVar2.xj;
            if (xjVarArr != null) {
                if (xjVarArr[i3] == null) {
                    xjVarArr[i3] = new xj();
                }
                xjVar2 = xjVar2.xj[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            xjVar2.xj[i7] = xjVar;
        }
    }
}
