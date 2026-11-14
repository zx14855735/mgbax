package HMGPfW;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends ByteArrayOutputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f3407AcNBzu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ARc23Z(ASJ6gh aSJ6gh, int i) {
        super(i);
        this.f3407AcNBzu = aSJ6gh;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
            i--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i, this.f3407AcNBzu.f3409AlLFFp.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
