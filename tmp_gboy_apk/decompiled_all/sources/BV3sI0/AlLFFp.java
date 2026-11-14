package BV3sI0;

import C4FrIb.AzWtSf;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AlLFFp extends JrXYwF.A4TApA {
    public static Font EY4UKY(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int EdQ5bb = EdQ5bb(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int EdQ5bb2 = EdQ5bb(fontStyle, font2.getStyle());
            if (EdQ5bb2 < EdQ5bb) {
                font = font2;
                EdQ5bb = EdQ5bb2;
            }
        }
        return font;
    }

    public static int EdQ5bb(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BI9f7h(Context context, BTvldC.ASJ6gh aSJ6gh, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (BTvldC.AYUAbz aYUAbz : aSJ6gh.f1450A2egSU) {
                try {
                    Font build = new Font.Builder(resources, aYUAbz.f1455ARc23Z).setWeight(aYUAbz.f1452A4TApA).setSlant(aYUAbz.f1453A5SV6n ? 1 : 0).setTtcIndex(aYUAbz.AMqCpz).setFontVariationSettings(aYUAbz.f1454ADYaiT).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(EY4UKY(build2, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BIYEnU(Context context, AzWtSf[] azWtSfArr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = azWtSfArr.length;
            FontFamily.Builder builder = null;
            while (i2 < length) {
                AzWtSf azWtSf = azWtSfArr[i2];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(azWtSf.f1576A2egSU, t.k, null);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i2 = openFileDescriptor == null ? i2 + 1 : 0;
                } else {
                    try {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(azWtSf.f1578A5SV6n).setSlant(azWtSf.f1579ADYaiT ? 1 : 0).setTtcIndex(azWtSf.f1577A4TApA).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                openFileDescriptor.close();
            }
            if (builder != null) {
                FontFamily build2 = builder.build();
                return new Typeface.CustomFallbackBuilder(build2).setStyle(EY4UKY(build2, i).getStyle()).build();
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BJ7GGh(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // JrXYwF.A4TApA
    public final Typeface BNL6CD(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // JrXYwF.A4TApA
    public final AzWtSf BmvVmW(int i, AzWtSf[] azWtSfArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
