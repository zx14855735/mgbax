package com.fl.saas.common.util.feature;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.fl.saas.common.util.Check;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Size {
    private final int mHeight;
    private final int mWidth;

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    private static NumberFormatException invalidSize(String str) {
        throw new NumberFormatException(CtFAbx.BI9f7h("Invalid Size: \"", str, "\""));
    }

    public static Size parseSize(String str) {
        Check.checkNotNull(str, "string must not be null");
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT);
        }
        if (indexOf < 0) {
            throw invalidSize(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException unused) {
            throw invalidSize(str);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.mWidth == size.mWidth && this.mHeight == size.mHeight) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
