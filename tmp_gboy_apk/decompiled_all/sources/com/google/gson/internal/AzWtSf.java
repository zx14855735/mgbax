package com.google.gson.internal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf implements CharSequence {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public char[] f12061AcNBzu;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f12061AcNBzu[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f12061AcNBzu.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new String(this.f12061AcNBzu, i, i2 - i);
    }
}
