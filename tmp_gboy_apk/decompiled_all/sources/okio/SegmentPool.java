package okio;

import javax.annotation.Nullable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    public static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                long j = byteCount;
                if (j + 8192 > MAX_SIZE) {
                    return;
                }
                byteCount = j + 8192;
                segment.next = next;
                segment.limit = 0;
                segment.pos = 0;
                next = segment;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Segment take() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = next;
                if (segment == null) {
                    return new Segment();
                }
                next = segment.next;
                segment.next = null;
                byteCount -= 8192;
                return segment;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
