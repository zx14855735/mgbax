package com.bykv.vk.component.ttvideo.player;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface FrameMetadataListener {
    void frameDTSNotify(int i, long j, long j2);

    void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map);

    void updateFrameTerminatedDTS(int i, long j, long j2);
}
