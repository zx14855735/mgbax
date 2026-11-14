package com.bytedance.sdk.openadsdk.api.plugin.hf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class hf {
    private char[] c;
    private final int hf;
    private int kd;
    private int u;
    private int w;
    private final String xj;
    private int y;

    public hf(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.xj = name;
        this.hf = name.length();
    }

    private String hf() {
        int i = this.w + 1;
        this.w = i;
        this.u = i;
        this.kd = i;
        while (true) {
            int i2 = this.w;
            if (i2 == this.hf) {
                throw new IllegalStateException("Unexpected end of DN: " + this.xj);
            }
            char[] cArr = this.c;
            char c = cArr[i2];
            if (c == '\"') {
                this.w = i2 + 1;
                while (true) {
                    int i3 = this.w;
                    if (i3 >= this.hf || this.c[i3] != ' ') {
                        break;
                    }
                    this.w = i3 + 1;
                }
                char[] cArr2 = this.c;
                int i4 = this.u;
                return new String(cArr2, i4, this.kd - i4);
            }
            if (c == '\\') {
                cArr[this.kd] = kd();
            } else {
                cArr[this.kd] = c;
            }
            this.w++;
            this.kd++;
        }
    }

    private char kd() {
        int i = this.w + 1;
        this.w = i;
        if (i == this.hf) {
            throw new IllegalStateException("Unexpected end of DN: " + this.xj);
        }
        char c = this.c[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return y();
                }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.y - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String u() {
        /*
            r8 = this;
            int r0 = r8.w
            r8.u = r0
            r8.kd = r0
        L6:
            int r0 = r8.w
            int r1 = r8.hf
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.c
            int r2 = r8.u
            int r3 = r8.kd
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.c
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.kd
            int r4 = r3 + 1
            r8.kd = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.w = r0
            goto L6
        L3e:
            int r0 = r8.kd
            int r2 = r0 + 1
            r8.kd = r2
            char r2 = r8.kd()
            r1[r0] = r2
            int r0 = r8.w
            int r0 = r0 + 1
            r8.w = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.u
            int r3 = r8.kd
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.kd
            r8.y = r2
            int r0 = r0 + 1
            r8.w = r0
            int r0 = r2 + 1
            r8.kd = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.w
            int r1 = r8.hf
            if (r0 >= r1) goto L83
            char[] r2 = r8.c
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.kd
            int r7 = r1 + 1
            r8.kd = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.w = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.c
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.c
            int r2 = r8.u
            int r3 = r8.y
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.hf.hf.u():java.lang.String");
    }

    private String w() {
        int i;
        char[] cArr;
        char c;
        int i2 = this.w;
        if (i2 + 4 >= this.hf) {
            throw new IllegalStateException("Unexpected end of DN: " + this.xj);
        }
        this.u = i2;
        this.w = i2 + 1;
        while (true) {
            i = this.w;
            if (i == this.hf || (c = (cArr = this.c)[i]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.kd = i;
                this.w = i + 1;
                while (true) {
                    int i3 = this.w;
                    if (i3 >= this.hf || this.c[i3] != ' ') {
                        break;
                    }
                    this.w = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i] = (char) (c + ' ');
                }
                this.w = i + 1;
            }
        }
        this.kd = i;
        int i4 = this.kd;
        int i5 = this.u;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.xj);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) xj(i8);
            i8 += 2;
        }
        return new String(this.c, this.u, i6);
    }

    private String xj() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.w;
            i2 = this.hf;
            if (i >= i2 || this.c[i] != ' ') {
                break;
            }
            this.w = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.u = i;
        this.w = i + 1;
        while (true) {
            i3 = this.w;
            i4 = this.hf;
            if (i3 >= i4 || (c3 = this.c[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.w = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.xj);
        }
        this.kd = i3;
        if (this.c[i3] == ' ') {
            while (true) {
                i6 = this.w;
                i7 = this.hf;
                if (i6 >= i7 || (c2 = this.c[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.w = i6 + 1;
            }
            if (this.c[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.xj);
            }
        }
        do {
            i5 = this.w + 1;
            this.w = i5;
            if (i5 >= this.hf) {
                break;
            }
        } while (this.c[i5] == ' ');
        int i8 = this.kd;
        int i9 = this.u;
        if (i8 - i9 > 4) {
            char[] cArr = this.c;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.u = i9 + 4;
            }
        }
        char[] cArr2 = this.c;
        int i10 = this.u;
        return new String(cArr2, i10, i8 - i10);
    }

    private char y() {
        int i;
        int i2;
        int xj = xj(this.w);
        this.w++;
        if (xj < 128) {
            return (char) xj;
        }
        if (xj < 192 || xj > 247) {
            return '?';
        }
        if (xj <= 223) {
            i = xj & 31;
            i2 = 1;
        } else if (xj <= 239) {
            i = xj & 15;
            i2 = 2;
        } else {
            i = xj & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.w;
            int i5 = i4 + 1;
            this.w = i5;
            if (i5 == this.hf || this.c[i5] != '\\') {
                return '?';
            }
            int i6 = i4 + 2;
            this.w = i6;
            int xj2 = xj(i6);
            this.w++;
            if ((xj2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) != 128) {
                return '?';
            }
            i = (i << 6) + (xj2 & 63);
        }
        return (char) i;
    }

    private int xj(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.hf) {
            char[] cArr = this.c;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else {
                if (c < 'A' || c > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.xj);
                }
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.xj);
                }
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.xj);
    }

    public String xj(String str) {
        String hf;
        this.w = 0;
        this.u = 0;
        this.kd = 0;
        this.y = 0;
        this.c = this.xj.toCharArray();
        String xj = xj();
        if (xj == null) {
            return null;
        }
        do {
            int i = this.w;
            if (i == this.hf) {
                return null;
            }
            char c = this.c[i];
            if (c == '\"') {
                hf = hf();
            } else if (c == '#') {
                hf = w();
            } else if (c != '+' && c != ',' && c != ';') {
                hf = u();
            } else {
                hf = "";
            }
            if (str.equalsIgnoreCase(xj)) {
                return hf;
            }
            int i2 = this.w;
            if (i2 >= this.hf) {
                return null;
            }
            char c2 = this.c[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.xj);
            }
            this.w = i2 + 1;
            xj = xj();
        } while (xj != null);
        throw new IllegalStateException("Malformed DN: " + this.xj);
    }
}
