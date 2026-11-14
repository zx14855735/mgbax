package okio;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i, int i2) {
        long j;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "beginIndex < 0: "));
        }
        if (i2 < i) {
            throw new IllegalArgumentException(A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
        }
        if (i2 > str.length()) {
            StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
            B9tovu2.append(str.length());
            throw new IllegalArgumentException(B9tovu2.toString());
        }
        long j2 = 0;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                j2++;
            } else {
                if (charAt < 2048) {
                    j = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    j = 3;
                } else {
                    int i3 = i + 1;
                    char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j2++;
                        i = i3;
                    } else {
                        j2 += 4;
                        i += 2;
                    }
                }
                j2 += j;
            }
            i++;
        }
        return j2;
    }
}
