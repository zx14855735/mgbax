package okhttp3.internal.http2;

import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.adevent.AdEventType;
import java.io.ByteArrayOutputStream;
import okio.Buffer;
import okio.ByteString;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class B9tovu {
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 2042, 1018, 1019, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 2043, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, AdEventType.AD_RENDER_SUCCESS, 110, 111, AdEventType.AD_TICK, AdEventType.AD_ZOOM_OUT, AdEventType.AD_ZOOM_OUT_PLAY_FINISH, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 115, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, 44, 8, 9, 45, 119, AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_LENGTHS = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
    private static final B9tovu INSTANCE = new B9tovu();
    private final A2egSU root = new A2egSU();

    private B9tovu() {
        int i = 0;
        while (true) {
            byte[] bArr = CODE_LENGTHS;
            if (i >= bArr.length) {
                return;
            }
            int i2 = CODES[i];
            byte b = bArr[i];
            A2egSU a2egSU = new A2egSU(i, b);
            A2egSU a2egSU2 = this.root;
            while (b > 8) {
                b = (byte) (b - 8);
                int i3 = (i2 >>> b) & 255;
                A2egSU[] a2egSUArr = a2egSU2.children;
                if (a2egSUArr == null) {
                    throw new IllegalStateException("invalid dictionary: prefix not unique");
                }
                if (a2egSUArr[i3] == null) {
                    a2egSUArr[i3] = new A2egSU();
                }
                a2egSU2 = a2egSU2.children[i3];
            }
            int i4 = 8 - b;
            int i5 = (i2 << i4) & 255;
            int i6 = 1 << i4;
            for (int i7 = i5; i7 < i5 + i6; i7++) {
                a2egSU2.children[i7] = a2egSU;
            }
            i++;
        }
    }

    public static void A4TApA(ByteString byteString, Buffer buffer) {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < byteString.size(); i2++) {
            int i3 = byteString.getByte(i2) & 255;
            int i4 = CODES[i3];
            byte b = CODE_LENGTHS[i3];
            j = (j << b) | i4;
            i += b;
            while (i >= 8) {
                i -= 8;
                buffer.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            buffer.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public static int A5SV6n(ByteString byteString) {
        long j = 0;
        for (int i = 0; i < byteString.size(); i++) {
            j += CODE_LENGTHS[byteString.getByte(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public static B9tovu ADYaiT() {
        return INSTANCE;
    }

    public final byte[] A2egSU(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        A2egSU a2egSU = this.root;
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & 255);
            i2 += 8;
            while (i2 >= 8) {
                a2egSU = a2egSU.children[(i >>> (i2 - 8)) & 255];
                if (a2egSU.children == null) {
                    byteArrayOutputStream.write(a2egSU.symbol);
                    i2 -= a2egSU.terminalBits;
                    a2egSU = this.root;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            A2egSU a2egSU2 = a2egSU.children[(i << (8 - i2)) & 255];
            if (a2egSU2.children != null || a2egSU2.terminalBits > i2) {
                break;
            }
            byteArrayOutputStream.write(a2egSU2.symbol);
            i2 -= a2egSU2.terminalBits;
            a2egSU = this.root;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final class A2egSU {
        final A2egSU[] children;
        final int symbol;
        final int terminalBits;

        public A2egSU() {
            this.children = new A2egSU[256];
            this.symbol = 0;
            this.terminalBits = 0;
        }

        public A2egSU(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBits = i3 == 0 ? 8 : i3;
        }
    }
}
