package DcUJf1;

import ADYaiT.CtFAbx;
import android.R;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f2304A2egSU = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f2305A4TApA = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final int[] f2306A5SV6n = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f2307ADYaiT = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] AMqCpz = {R.attr.drawable};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final int[] f2308ARc23Z = {R.attr.name, R.attr.animation};

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final int[] f2309ASJ6gh = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final int[] f2310AYUAbz = {R.attr.ordering};

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final int[] f2311AZOQYO = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final int[] f2312AZkASS = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final int[] f2313AaHO0E = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};

    /* JADX WARN: Code restructure failed: missing block: B:10:0x03b3, code lost:
    
        r2 = new android.animation.Animator[r22.size()];
        r3 = r22.iterator();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x03c2, code lost:
    
        if (r3.hasNext() == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x03c4, code lost:
    
        r2[r11] = (android.animation.Animator) r3.next();
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x03d0, code lost:
    
        if (r33 != 0) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x03d2, code lost:
    
        r32.playTogether(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x03d5, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x03d6, code lost:
    
        r32.playSequentially(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x03d9, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        r22 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x03af, code lost:
    
        if (r32 == null) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x03b1, code lost:
    
        if (r22 == null) goto L220;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0381 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator A2egSU(android.content.Context r27, android.content.res.Resources r28, android.content.res.Resources.Theme r29, android.content.res.XmlResourceParser r30, android.util.AttributeSet r31, android.animation.AnimatorSet r32, int r33) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DcUJf1.A2egSU.A2egSU(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.content.res.XmlResourceParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static PropertyValuesHolder A4TApA(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder ofFloat;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && A5SV6n(i4)) || (z2 && A5SV6n(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            BV3sI0.ARc23Z[] B9tovu2 = com.bumptech.glide.AMqCpz.B9tovu(string);
            BV3sI0.ARc23Z[] B9tovu3 = com.bumptech.glide.AMqCpz.B9tovu(string2);
            if (B9tovu2 != null || B9tovu3 != null) {
                if (B9tovu2 != null) {
                    ASJ6gh aSJ6gh = new ASJ6gh();
                    if (B9tovu3 == null) {
                        return PropertyValuesHolder.ofObject(str, aSJ6gh, B9tovu2);
                    }
                    if (com.bumptech.glide.AMqCpz.B25kr6(B9tovu2, B9tovu3)) {
                        return PropertyValuesHolder.ofObject(str, aSJ6gh, B9tovu2, B9tovu3);
                    }
                    throw new InflateException(CtFAbx.AmA8tU(" Can't morph from ", string, " to ", string2));
                }
                if (B9tovu3 != null) {
                    return PropertyValuesHolder.ofObject(str, new ASJ6gh(), B9tovu3);
                }
            }
            return null;
        }
        AYUAbz aYUAbz = i == 3 ? AYUAbz.f2330A2egSU : null;
        if (z3) {
            if (z) {
                float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                ofFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : A5SV6n(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (z2) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : A5SV6n(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
            }
        } else if (z2) {
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : A5SV6n(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
        }
        if (propertyValuesHolder != null && aYUAbz != null) {
            propertyValuesHolder.setEvaluator(aYUAbz);
        }
        return propertyValuesHolder;
    }

    public static boolean A5SV6n(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator ADYaiT(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        int i = 0;
        TypedArray ASJ6gh2 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, f2309ASJ6gh);
        TypedArray ASJ6gh3 = BTvldC.A4TApA.ASJ6gh(resources, theme, attributeSet, f2313AaHO0E);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j = BTvldC.A4TApA.ADYaiT(xmlResourceParser, MediationConstant.EXTRA_DURATION) ? ASJ6gh2.getInt(1, 300) : 300;
        long j2 = !(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null) ? 0 : ASJ6gh2.getInt(2, 0);
        int i2 = !(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null) ? 4 : ASJ6gh2.getInt(7, 4);
        if (xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") != null && xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") != null) {
            if (i2 == 4) {
                TypedValue peekValue = ASJ6gh2.peekValue(5);
                boolean z = peekValue != null;
                int i3 = z ? peekValue.type : 0;
                TypedValue peekValue2 = ASJ6gh2.peekValue(6);
                boolean z2 = peekValue2 != null;
                i2 = ((z && A5SV6n(i3)) || (z2 && A5SV6n(z2 ? peekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder A4TApA2 = A4TApA(ASJ6gh2, i2, 5, 6, "");
            if (A4TApA2 != null) {
                valueAnimator3.setValues(A4TApA2);
            }
        }
        valueAnimator3.setDuration(j);
        valueAnimator3.setStartDelay(j2);
        valueAnimator3.setRepeatCount(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null ? ASJ6gh2.getInt(3, 0) : 0);
        valueAnimator3.setRepeatMode(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null ? ASJ6gh2.getInt(4, 1) : 1);
        if (ASJ6gh3 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String A5SV6n2 = BTvldC.A4TApA.A5SV6n(ASJ6gh3, xmlResourceParser, "pathData", 1);
            if (A5SV6n2 != null) {
                String A5SV6n3 = BTvldC.A4TApA.A5SV6n(ASJ6gh3, xmlResourceParser, "propertyXName", 2);
                String A5SV6n4 = BTvldC.A4TApA.A5SV6n(ASJ6gh3, xmlResourceParser, "propertyYName", 3);
                if (i2 != 2) {
                }
                if (A5SV6n3 == null && A5SV6n4 == null) {
                    throw new InflateException(ASJ6gh3.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path BChYOn2 = com.bumptech.glide.AMqCpz.BChYOn(A5SV6n2);
                PathMeasure pathMeasure = new PathMeasure(BChYOn2, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f = 0.0f;
                do {
                    f += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(BChYOn2, false);
                int min = Math.min(100, ((int) (f / 0.5f)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f2 = f / (min - 1);
                valueAnimator = valueAnimator3;
                float f3 = 0.0f;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= min) {
                        break;
                    }
                    int i6 = i4;
                    pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
                    fArr[i6] = fArr3[0];
                    fArr2[i6] = fArr3[1];
                    int i7 = i5 + 1;
                    f3 += f2;
                    if (i7 < arrayList.size() && f3 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i5 = i7;
                    }
                    i4 = i6 + 1;
                }
                PropertyValuesHolder ofFloat = A5SV6n3 != null ? PropertyValuesHolder.ofFloat(A5SV6n3, fArr) : null;
                PropertyValuesHolder ofFloat2 = A5SV6n4 != null ? PropertyValuesHolder.ofFloat(A5SV6n4, fArr2) : null;
                if (ofFloat == null) {
                    objectAnimator2.setValues(ofFloat2);
                } else if (ofFloat2 == null) {
                    objectAnimator2.setValues(ofFloat);
                } else {
                    objectAnimator2.setValues(ofFloat, ofFloat2);
                }
                i = 0;
            } else {
                valueAnimator = valueAnimator3;
                i = 0;
                objectAnimator2.setPropertyName(BTvldC.A4TApA.A5SV6n(ASJ6gh3, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
        }
        if (xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null) {
            i = ASJ6gh2.getResourceId(i, i);
        }
        if (i > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, i));
        } else {
            valueAnimator2 = valueAnimator;
        }
        ASJ6gh2.recycle();
        if (ASJ6gh3 != null) {
            ASJ6gh3.recycle();
        }
        return valueAnimator2;
    }
}
