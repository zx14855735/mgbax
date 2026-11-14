package com.czhj.wire.okio;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class SegmentPool {

    /* renamed from: a, reason: collision with root package name */
    static final long f10709a = 65536;
    static Segment b;
    static long c;

    private SegmentPool() {
    }

    public static Segment a() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = b;
                if (segment == null) {
                    return new Segment();
                }
                b = segment.h;
                segment.h = null;
                c -= 8192;
                return segment;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Segment segment) {
        if (segment.h != null || segment.i != null) {
            throw new IllegalArgumentException();
        }
        if (segment.f) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                long j = c;
                if (j + 8192 <= f10709a) {
                    c = j + 8192;
                    segment.h = b;
                    segment.e = 0;
                    segment.d = 0;
                    b = segment;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
