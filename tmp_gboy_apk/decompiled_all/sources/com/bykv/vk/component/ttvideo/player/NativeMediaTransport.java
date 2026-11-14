package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import com.bykv.vk.component.ttvideo.player.MediaTransport;

@JNINamespace("PLAYER")
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NativeMediaTransport extends MediaTransport {
    @CalledByNative
    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaTransport
    public void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
