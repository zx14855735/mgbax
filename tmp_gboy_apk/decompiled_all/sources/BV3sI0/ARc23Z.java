package BV3sI0;

import android.graphics.Path;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public char f1487A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float[] f1488A4TApA;

    public ARc23Z(char c, float[] fArr) {
        this.f1487A2egSU = c;
        this.f1488A4TApA = fArr;
    }

    public static void A2egSU(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = f;
        double d4 = f2;
        double d5 = f5;
        double d6 = ((d4 * sin) + (d3 * cos)) / d5;
        double d7 = f6;
        double d8 = ((d4 * cos) + ((-f) * sin)) / d7;
        double d9 = f4;
        double d10 = ((d9 * sin) + (f3 * cos)) / d5;
        double d11 = ((d9 * cos) + ((-f3) * sin)) / d7;
        double d12 = d6 - d10;
        double d13 = d8 - d11;
        double d14 = (d6 + d10) / 2.0d;
        double d15 = (d8 + d11) / 2.0d;
        double d16 = (d13 * d13) + (d12 * d12);
        if (d16 == 0.0d) {
            return;
        }
        double d17 = (1.0d / d16) - 0.25d;
        if (d17 < 0.0d) {
            float sqrt = (float) (Math.sqrt(d16) / 1.99999d);
            A2egSU(path, f, f2, f3, f4, f5 * sqrt, sqrt * f6, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d17);
        double d18 = d12 * sqrt2;
        double d19 = sqrt2 * d13;
        if (z == z2) {
            d = d14 - d19;
            d2 = d15 + d18;
        } else {
            d = d14 + d19;
            d2 = d15 - d18;
        }
        double atan2 = Math.atan2(d8 - d2, d6 - d);
        double atan22 = Math.atan2(d11 - d2, d10 - d) - atan2;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d20 = d * d5;
        double d21 = d2 * d7;
        double d22 = (d20 * cos) - (d21 * sin);
        double d23 = (d21 * cos) + (d20 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d24 = d4;
        double d25 = -d5;
        double d26 = d25 * cos2;
        double d27 = d7 * sin2;
        double d28 = (d26 * sin3) - (d27 * cos3);
        double d29 = d25 * sin2;
        double d30 = d7 * cos2;
        double d31 = (cos3 * d30) + (sin3 * d29);
        double d32 = atan22 / ceil;
        double d33 = atan2;
        int i = 0;
        while (i < ceil) {
            double d34 = d33 + d32;
            double sin4 = Math.sin(d34);
            double cos4 = Math.cos(d34);
            double d35 = d32;
            double d36 = (((d5 * cos2) * cos4) + d22) - (d27 * sin4);
            int i2 = ceil;
            double d37 = d29;
            double d38 = (d30 * sin4) + (d5 * sin2 * cos4) + d23;
            double d39 = (d26 * sin4) - (d27 * cos4);
            double d40 = (cos4 * d30) + (sin4 * d37);
            double d41 = d34 - d33;
            double tan = Math.tan(d41 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d41)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d28 * sqrt3) + d3), (float) ((d31 * sqrt3) + d24), (float) (d36 - (sqrt3 * d39)), (float) (d38 - (sqrt3 * d40)), (float) d36, (float) d38);
            i++;
            d3 = d36;
            d24 = d38;
            d22 = d22;
            d33 = d34;
            cos2 = cos2;
            d31 = d40;
            d28 = d39;
            d32 = d35;
            ceil = i2;
            d29 = d37;
        }
    }

    public static void A4TApA(ARc23Z[] aRc23ZArr, Path path) {
        int i;
        int i2;
        ARc23Z aRc23Z;
        int i3;
        char c;
        float f;
        float f2;
        float f3;
        float f4;
        ARc23Z aRc23Z2;
        boolean z;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path2 = path;
        float[] fArr = new float[6];
        int length = aRc23ZArr.length;
        char c2 = 'm';
        char c3 = 0;
        char c4 = 'm';
        int i4 = 0;
        while (i4 < length) {
            ARc23Z aRc23Z3 = aRc23ZArr[i4];
            char c5 = aRc23Z3.f1487A2egSU;
            float f13 = fArr[c3];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c5) {
                case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                case MediaPlayer.MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO /* 97 */:
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS /* 118 */:
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case AdEventType.AD_ZOOM_OUT /* 113 */:
                case 's':
                    i = 4;
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE /* 90 */:
                case 'z':
                    path2.close();
                    path2.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                default:
                    i = 2;
                    break;
            }
            float f19 = f14;
            float f20 = f17;
            float f21 = f18;
            float f22 = f13;
            int i5 = 0;
            while (true) {
                float[] fArr2 = aRc23Z3.f1488A4TApA;
                if (i5 < fArr2.length) {
                    if (c5 == 'A') {
                        i2 = i5;
                        aRc23Z = aRc23Z3;
                        float f23 = f22;
                        float f24 = f19;
                        i3 = i4;
                        c = c5;
                        int i6 = i2 + 5;
                        int i7 = i2 + 6;
                        A2egSU(path, f23, f24, fArr2[i6], fArr2[i7], fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f15 = fArr2[i6];
                        f = fArr2[i7];
                        f16 = f;
                        f2 = f15;
                    } else if (c5 == 'C') {
                        i2 = i5;
                        i3 = i4;
                        aRc23Z = aRc23Z3;
                        c = c5;
                        int i8 = i2 + 2;
                        int i9 = i2 + 3;
                        int i10 = i2 + 4;
                        int i11 = i2 + 5;
                        path2.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i8], fArr2[i9], fArr2[i10], fArr2[i11]);
                        float f25 = fArr2[i10];
                        float f26 = fArr2[i11];
                        f15 = fArr2[i8];
                        f16 = fArr2[i9];
                        f = f26;
                        f2 = f25;
                    } else if (c5 != 'H') {
                        if (c5 == 'Q') {
                            i2 = i5;
                            i3 = i4;
                            aRc23Z = aRc23Z3;
                            c = c5;
                            int i12 = i2 + 1;
                            int i13 = i2 + 2;
                            int i14 = i2 + 3;
                            path2.quadTo(fArr2[i2], fArr2[i12], fArr2[i13], fArr2[i14]);
                            f3 = fArr2[i2];
                            float f27 = fArr2[i12];
                            f4 = fArr2[i13];
                            f16 = f27;
                            f = fArr2[i14];
                        } else if (c5 == 'V') {
                            i2 = i5;
                            i3 = i4;
                            aRc23Z = aRc23Z3;
                            f2 = f22;
                            c = c5;
                            path2.lineTo(f2, fArr2[i2]);
                            f = fArr2[i2];
                        } else if (c5 != 'a') {
                            if (c5 == 'c') {
                                i2 = i5;
                                int i15 = i2 + 2;
                                int i16 = i2 + 3;
                                int i17 = i2 + 4;
                                int i18 = i2 + 5;
                                path2.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                                float f28 = fArr2[i15] + f22;
                                float f29 = f19 + fArr2[i16];
                                f22 += fArr2[i17];
                                f19 += fArr2[i18];
                                f15 = f28;
                                f16 = f29;
                            } else if (c5 != 'h') {
                                if (c5 != 'q') {
                                    if (c5 != 'v') {
                                        if (c5 == 'L') {
                                            i2 = i5;
                                            int i19 = i2 + 1;
                                            path2.lineTo(fArr2[i2], fArr2[i19]);
                                            f2 = fArr2[i2];
                                            f = fArr2[i19];
                                        } else if (c5 == 'M') {
                                            i2 = i5;
                                            f2 = fArr2[i2];
                                            f = fArr2[i2 + 1];
                                            if (i2 > 0) {
                                                path2.lineTo(f2, f);
                                            } else {
                                                path2.moveTo(f2, f);
                                                f20 = f2;
                                                f21 = f;
                                            }
                                        } else if (c5 == 'S') {
                                            i2 = i5;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f22 = (f22 * 2.0f) - f15;
                                                f19 = (f19 * 2.0f) - f16;
                                            }
                                            float f30 = f22;
                                            float f31 = f19;
                                            int i20 = i2 + 1;
                                            int i21 = i2 + 2;
                                            int i22 = i2 + 3;
                                            path2.cubicTo(f30, f31, fArr2[i2], fArr2[i20], fArr2[i21], fArr2[i22]);
                                            f3 = fArr2[i2];
                                            float f32 = fArr2[i20];
                                            f4 = fArr2[i21];
                                            f16 = f32;
                                            f = fArr2[i22];
                                            i3 = i4;
                                            aRc23Z = aRc23Z3;
                                            c = c5;
                                        } else if (c5 == 'T') {
                                            i2 = i5;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f22 = (f22 * 2.0f) - f15;
                                                f19 = (f19 * 2.0f) - f16;
                                            }
                                            float f33 = f19;
                                            float f34 = fArr2[i2];
                                            int i23 = i2 + 1;
                                            path2.quadTo(f22, f33, f34, fArr2[i23]);
                                            f16 = f33;
                                            f2 = fArr2[i2];
                                            f = fArr2[i23];
                                            i3 = i4;
                                            aRc23Z = aRc23Z3;
                                            f15 = f22;
                                            c = c5;
                                        } else if (c5 == 'l') {
                                            i2 = i5;
                                            int i24 = i2 + 1;
                                            path2.rLineTo(fArr2[i2], fArr2[i24]);
                                            f22 += fArr2[i2];
                                            f8 = fArr2[i24];
                                        } else if (c5 == c2) {
                                            i2 = i5;
                                            float f35 = fArr2[i2];
                                            f22 += f35;
                                            float f36 = fArr2[i2 + 1];
                                            f19 += f36;
                                            if (i2 > 0) {
                                                path2.rLineTo(f35, f36);
                                            } else {
                                                path2.rMoveTo(f35, f36);
                                                aRc23Z = aRc23Z3;
                                                f2 = f22;
                                                f20 = f2;
                                                f = f19;
                                                f21 = f;
                                                i3 = i4;
                                                c = c5;
                                            }
                                        } else if (c5 == 's') {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f9 = f19 - f16;
                                                f10 = f22 - f15;
                                            } else {
                                                f10 = 0.0f;
                                                f9 = 0.0f;
                                            }
                                            int i25 = i5 + 1;
                                            int i26 = i5 + 2;
                                            int i27 = i5 + 3;
                                            i2 = i5;
                                            path2.rCubicTo(f10, f9, fArr2[i5], fArr2[i25], fArr2[i26], fArr2[i27]);
                                            f5 = fArr2[i2] + f22;
                                            f6 = f19 + fArr2[i25];
                                            f22 += fArr2[i26];
                                            f7 = fArr2[i27];
                                        } else if (c5 != 't') {
                                            i2 = i5;
                                        } else {
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f11 = f22 - f15;
                                                f12 = f19 - f16;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i28 = i5 + 1;
                                            path2.rQuadTo(f11, f12, fArr2[i5], fArr2[i28]);
                                            float f37 = f11 + f22;
                                            float f38 = f19 + f12;
                                            float f39 = f22 + fArr2[i5];
                                            f19 += fArr2[i28];
                                            f16 = f38;
                                            i2 = i5;
                                            aRc23Z = aRc23Z3;
                                            f2 = f39;
                                            f15 = f37;
                                            f = f19;
                                            i3 = i4;
                                            c = c5;
                                        }
                                        i3 = i4;
                                        aRc23Z = aRc23Z3;
                                        c = c5;
                                    } else {
                                        i2 = i5;
                                        path2.rLineTo(0.0f, fArr2[i2]);
                                        f8 = fArr2[i2];
                                    }
                                    f19 += f8;
                                } else {
                                    i2 = i5;
                                    int i29 = i2 + 1;
                                    int i30 = i2 + 2;
                                    int i31 = i2 + 3;
                                    path2.rQuadTo(fArr2[i2], fArr2[i29], fArr2[i30], fArr2[i31]);
                                    f5 = fArr2[i2] + f22;
                                    f6 = f19 + fArr2[i29];
                                    f22 += fArr2[i30];
                                    f7 = fArr2[i31];
                                }
                                f19 += f7;
                                f15 = f5;
                                f16 = f6;
                            } else {
                                i2 = i5;
                                path2.rLineTo(fArr2[i2], 0.0f);
                                f22 += fArr2[i2];
                            }
                            aRc23Z = aRc23Z3;
                            f2 = f22;
                            f = f19;
                            i3 = i4;
                            c = c5;
                        } else {
                            i2 = i5;
                            int i32 = i2 + 5;
                            float f40 = fArr2[i32] + f22;
                            int i33 = i2 + 6;
                            float f41 = fArr2[i33] + f19;
                            float f42 = fArr2[i2];
                            float f43 = fArr2[i2 + 1];
                            float f44 = fArr2[i2 + 2];
                            if (fArr2[i2 + 3] != 0.0f) {
                                aRc23Z2 = aRc23Z3;
                                z = true;
                            } else {
                                aRc23Z2 = aRc23Z3;
                                z = false;
                            }
                            aRc23Z = aRc23Z2;
                            float f45 = f22;
                            c = c5;
                            float f46 = f19;
                            i3 = i4;
                            A2egSU(path, f45, f46, f40, f41, f42, f43, f44, z, fArr2[i2 + 4] != 0.0f);
                            f2 = f45 + fArr2[i32];
                            f = f46 + fArr2[i33];
                            f15 = f2;
                            f16 = f;
                        }
                        f15 = f3;
                        f2 = f4;
                    } else {
                        i2 = i5;
                        aRc23Z = aRc23Z3;
                        c = c5;
                        f = f19;
                        i3 = i4;
                        path2.lineTo(fArr2[i2], f);
                        f2 = fArr2[i2];
                    }
                    c5 = c;
                    aRc23Z3 = aRc23Z;
                    i4 = i3;
                    c2 = 'm';
                    f22 = f2;
                    f19 = f;
                    c4 = c5;
                    i5 = i2 + i;
                    path2 = path;
                }
            }
            fArr[0] = f22;
            fArr[1] = f19;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f20;
            fArr[5] = f21;
            c4 = aRc23Z3.f1487A2egSU;
            i4++;
            path2 = path;
            c2 = 'm';
            c3 = 0;
        }
    }

    public char getType() {
        return this.f1487A2egSU;
    }

    public ARc23Z(ARc23Z aRc23Z) {
        this.f1487A2egSU = aRc23Z.f1487A2egSU;
        float[] fArr = aRc23Z.f1488A4TApA;
        this.f1488A4TApA = com.bumptech.glide.AMqCpz.B4ZgIw(fArr, fArr.length);
    }
}
