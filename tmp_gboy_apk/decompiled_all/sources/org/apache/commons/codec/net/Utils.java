package org.apache.commons.codec.net;

import ADYaiT.CtFAbx;
import org.apache.commons.codec.DecoderException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class Utils {
    private static final int RADIX = 16;

    public static int digit16(byte b) {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException(CtFAbx.ARc23Z(b, "Invalid URL encoding: not a valid digit (radix 16): "));
    }

    public static char hexDigit(int i) {
        return Character.toUpperCase(Character.forDigit(i & 15, 16));
    }
}
