package com.google.gson.internal;

import java.math.BigDecimal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz extends Number {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f12036AcNBzu;

    public AYUAbz(String str) {
        this.f12036AcNBzu = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f12036AcNBzu);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AYUAbz)) {
            return false;
        }
        Object obj2 = ((AYUAbz) obj).f12036AcNBzu;
        String str = this.f12036AcNBzu;
        return str == obj2 || str.equals(obj2);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f12036AcNBzu);
    }

    public final int hashCode() {
        return this.f12036AcNBzu.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f12036AcNBzu;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f12036AcNBzu;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f12036AcNBzu;
    }
}
