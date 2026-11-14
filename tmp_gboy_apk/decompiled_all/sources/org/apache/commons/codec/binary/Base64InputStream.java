package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base64(false), z);
    }

    public Base64InputStream(InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream, new Base64(i, bArr), z);
    }

    public Base64InputStream(InputStream inputStream, boolean z, int i, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new Base64(i, bArr, false, codecPolicy), z);
    }
}
