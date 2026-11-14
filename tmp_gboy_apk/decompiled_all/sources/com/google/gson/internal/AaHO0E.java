package com.google.gson.internal;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements Map.Entry {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AaHO0E f12044AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AaHO0E f12045AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AaHO0E f12046AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AaHO0E f12047AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AaHO0E f12048B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Object f12049B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public Object f12050B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f12051B4ZgIw;

    public AaHO0E() {
        this.f12049B2KMhB = null;
        this.f12048B25kr6 = this;
        this.f12047AzWtSf = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f12049B2KMhB;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f12050B3GDIM;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f12049B2KMhB;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f12050B3GDIM;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f12049B2KMhB;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f12050B3GDIM;
        return (obj2 != null ? obj2.hashCode() : 0) ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f12050B3GDIM;
        this.f12050B3GDIM = obj;
        return obj2;
    }

    public final String toString() {
        return this.f12049B2KMhB + "=" + this.f12050B3GDIM;
    }

    public AaHO0E(AaHO0E aaHO0E, Object obj, AaHO0E aaHO0E2, AaHO0E aaHO0E3) {
        this.f12044AcNBzu = aaHO0E;
        this.f12049B2KMhB = obj;
        this.f12051B4ZgIw = 1;
        this.f12047AzWtSf = aaHO0E2;
        this.f12048B25kr6 = aaHO0E3;
        aaHO0E3.f12047AzWtSf = this;
        aaHO0E2.f12048B25kr6 = this;
    }
}
