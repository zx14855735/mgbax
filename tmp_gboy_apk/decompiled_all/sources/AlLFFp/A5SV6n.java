package AlLFFp;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Map.Entry {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f944AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f945AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A5SV6n f946AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public A5SV6n f947AzWtSf;

    public A5SV6n(Object obj, Object obj2) {
        this.f944AcNBzu = obj;
        this.f945AlLFFp = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof A5SV6n)) {
            return false;
        }
        A5SV6n a5SV6n = (A5SV6n) obj;
        return this.f944AcNBzu.equals(a5SV6n.f944AcNBzu) && this.f945AlLFFp.equals(a5SV6n.f945AlLFFp);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f944AcNBzu;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f945AlLFFp;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f944AcNBzu.hashCode() ^ this.f945AlLFFp.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f944AcNBzu + "=" + this.f945AlLFFp;
    }
}
