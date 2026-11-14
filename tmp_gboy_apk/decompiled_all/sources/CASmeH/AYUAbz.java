package CASmeH;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextPaint f1601A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TextDirectionHeuristic f1602A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f1603A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f1604ADYaiT;

    public AYUAbz(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = ASJ6gh.ASJ6gh(textPaint).setBreakStrategy(i);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i2);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f1601A2egSU = textPaint;
        this.f1602A4TApA = textDirectionHeuristic;
        this.f1603A5SV6n = i;
        this.f1604ADYaiT = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r7.f1604ADYaiT != r8.f1604ADYaiT) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r1 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
    
        if (r3.getTypeface() != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a6, code lost:
    
        if (r5.getTypeface() == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b9, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
    
        if (r3.getTypeface().equals(r5.getTypeface()) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        if (r3.getTextLocale().equals(r5.getTextLocale()) == false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L5
            goto Lc3
        L5:
            boolean r1 = r8 instanceof CASmeH.AYUAbz
            r2 = 0
            if (r1 != 0) goto Lc
            goto Lc4
        Lc:
            CASmeH.AYUAbz r8 = (CASmeH.AYUAbz) r8
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L24
            int r3 = r8.f1603A5SV6n
            int r4 = r7.f1603A5SV6n
            if (r4 == r3) goto L1c
            goto Lb7
        L1c:
            int r3 = r7.f1604ADYaiT
            int r4 = r8.f1604ADYaiT
            if (r3 == r4) goto L24
            goto Lb7
        L24:
            android.text.TextPaint r3 = r7.f1601A2egSU
            float r4 = r3.getTextSize()
            android.text.TextPaint r5 = r8.f1601A2egSU
            float r5 = r5.getTextSize()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L36
            goto Lb7
        L36:
            float r4 = r3.getTextScaleX()
            android.text.TextPaint r5 = r8.f1601A2egSU
            float r6 = r5.getTextScaleX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L46
            goto Lb7
        L46:
            float r4 = r3.getTextSkewX()
            float r6 = r5.getTextSkewX()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L53
            goto Lb7
        L53:
            float r4 = r3.getLetterSpacing()
            float r6 = r5.getLetterSpacing()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L60
            goto Lb7
        L60:
            java.lang.String r4 = r3.getFontFeatureSettings()
            java.lang.String r6 = r5.getFontFeatureSettings()
            boolean r4 = android.text.TextUtils.equals(r4, r6)
            if (r4 != 0) goto L6f
            goto Lb7
        L6f:
            int r4 = r3.getFlags()
            int r6 = r5.getFlags()
            if (r4 == r6) goto L7a
            goto Lb7
        L7a:
            r4 = 24
            if (r1 < r4) goto L8d
            android.os.LocaleList r1 = ADYaiT.BpkvW3.ADYaiT(r3)
            android.os.LocaleList r4 = ADYaiT.BpkvW3.ADYaiT(r5)
            boolean r1 = ADYaiT.BpkvW3.BPw6Q8(r4, r1)
            if (r1 != 0) goto L9c
            goto Lb7
        L8d:
            java.util.Locale r1 = r3.getTextLocale()
            java.util.Locale r4 = r5.getTextLocale()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L9c
            goto Lb7
        L9c:
            android.graphics.Typeface r1 = r3.getTypeface()
            if (r1 != 0) goto La9
            android.graphics.Typeface r1 = r5.getTypeface()
            if (r1 == 0) goto Lb9
            goto Lb7
        La9:
            android.graphics.Typeface r1 = r3.getTypeface()
            android.graphics.Typeface r3 = r5.getTypeface()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto Lb9
        Lb7:
            r1 = 0
            goto Lba
        Lb9:
            r1 = 1
        Lba:
            if (r1 != 0) goto Lbd
            goto Lc4
        Lbd:
            android.text.TextDirectionHeuristic r1 = r7.f1602A4TApA
            android.text.TextDirectionHeuristic r8 = r8.f1602A4TApA
            if (r1 != r8) goto Lc4
        Lc3:
            return r0
        Lc4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: CASmeH.AYUAbz.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        LocaleList textLocales;
        TextDirectionHeuristic textDirectionHeuristic = this.f1602A4TApA;
        int i = Build.VERSION.SDK_INT;
        int i2 = this.f1604ADYaiT;
        int i3 = this.f1603A5SV6n;
        TextPaint textPaint = this.f1601A2egSU;
        if (i < 24) {
            return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2));
        }
        Float valueOf = Float.valueOf(textPaint.getTextSize());
        Float valueOf2 = Float.valueOf(textPaint.getTextScaleX());
        Float valueOf3 = Float.valueOf(textPaint.getTextSkewX());
        Float valueOf4 = Float.valueOf(textPaint.getLetterSpacing());
        Integer valueOf5 = Integer.valueOf(textPaint.getFlags());
        textLocales = textPaint.getTextLocales();
        return Objects.hash(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public final String toString() {
        String fontVariationSettings;
        LocaleList textLocales;
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f1601A2egSU;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        if (i >= 24) {
            StringBuilder sb3 = new StringBuilder(", textLocale=");
            textLocales = textPaint.getTextLocales();
            sb3.append(textLocales);
            sb.append(sb3.toString());
        } else {
            sb.append(", textLocale=" + textPaint.getTextLocale());
        }
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i >= 26) {
            StringBuilder sb4 = new StringBuilder(", variationSettings=");
            fontVariationSettings = textPaint.getFontVariationSettings();
            sb4.append(fontVariationSettings);
            sb.append(sb4.toString());
        }
        sb.append(", textDir=" + this.f1602A4TApA);
        sb.append(", breakStrategy=" + this.f1603A5SV6n);
        sb.append(", hyphenationFrequency=" + this.f1604ADYaiT);
        sb.append("}");
        return sb.toString();
    }

    public AYUAbz(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f1601A2egSU = textPaint;
        textDirection = params.getTextDirection();
        this.f1602A4TApA = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f1603A5SV6n = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f1604ADYaiT = hyphenationFrequency;
    }
}
