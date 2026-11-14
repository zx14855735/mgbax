package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import com.bytedance.sdk.component.utils.pl;
import java.nio.ByteBuffer;

@Keep
@TargetApi(16)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AJMediaCodecFrame implements Cloneable {

    @Keep
    public ByteBuffer data;

    @Keep
    public int flags;

    @Keep
    public int index;

    @Keep
    public long pts = -269488145;

    @Keep
    public int size;

    @Keep
    public AJMediaCodecFrame() {
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m2clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }
}
