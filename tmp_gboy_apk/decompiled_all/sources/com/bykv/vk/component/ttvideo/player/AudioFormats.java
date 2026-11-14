package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {TTAdConstant.INIT_LOCAL_FAIL_CODE, AVMDLDataLoader.KeyIsLiveSetLoaderType, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length;
        int i = Build.VERSION.SDK_INT >= 23 ? length - 3 : length - 5;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = validSampleRates[i2];
        }
        return i;
    }

    @CalledByNative
    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        int length = queryEffects.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (queryEffects[i].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
            i++;
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
