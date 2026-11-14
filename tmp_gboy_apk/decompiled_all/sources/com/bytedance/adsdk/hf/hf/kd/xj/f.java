package com.bytedance.adsdk.hf.hf.kd.xj;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static Object xj(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(number.intValue() + i);
        }
        if (number instanceof Long) {
            return Long.valueOf(number.longValue() + i);
        }
        if (number instanceof Float) {
            return Float.valueOf(number.floatValue() + i);
        }
        if (!(number instanceof Double)) {
            throw new UnsupportedOperationException(A2egSU.B25kr6("This type of addition operation is not supported", number));
        }
        return Double.valueOf(number.doubleValue() + i);
    }

    private static Object xj(long j, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(number.longValue() + j);
            }
            if (number instanceof Float) {
                return Float.valueOf(number.floatValue() + j);
            }
            if (number instanceof Double) {
                return Double.valueOf(number.doubleValue() + j);
            }
            throw new UnsupportedOperationException(A2egSU.B25kr6("This type of addition operation is not supported", number));
        }
        return Long.valueOf(j + number.intValue());
    }

    private static Object xj(float f, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f + number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(number.floatValue() + f);
            }
            if (number instanceof Double) {
                return Double.valueOf(number.doubleValue() + f);
            }
            throw new UnsupportedOperationException(A2egSU.B25kr6("This type of addition operation is not supported", number));
        }
        return Float.valueOf(f + number.intValue());
    }

    private static Object xj(double d, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Double.valueOf(d + number.longValue());
            }
            if (number instanceof Float) {
                return Double.valueOf(d + number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(number.doubleValue() + d);
            }
            throw new UnsupportedOperationException(A2egSU.B25kr6("This type of addition operation is not supported", number));
        }
        return Double.valueOf(d + number.intValue());
    }

    public static Object xj(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return xj(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return xj(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return xj(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(A2egSU.B25kr6("This type of addition operation is not supported", number));
        }
        return xj(number.intValue(), number2);
    }
}
