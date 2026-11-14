package com.czhj.wire.okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class HashingSink extends ForwardingSink {

    /* renamed from: a, reason: collision with root package name */
    private final MessageDigest f10692a;
    private final Mac b;

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        try {
            Mac mac = Mac.getInstance(str);
            this.b = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.f10692a = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, "MD5");
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, MessageDigestAlgorithms.SHA_1);
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, MessageDigestAlgorithms.SHA_256);
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, MessageDigestAlgorithms.SHA_512);
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.f10692a;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.b.doFinal());
    }

    @Override // com.czhj.wire.okio.ForwardingSink, com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        Segment segment = buffer.b;
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, segment.e - segment.d);
            MessageDigest messageDigest = this.f10692a;
            if (messageDigest != null) {
                messageDigest.update(segment.c, segment.d, min);
            } else {
                this.b.update(segment.c, segment.d, min);
            }
            j2 += min;
            segment = segment.h;
        }
        super.write(buffer, j);
    }

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.f10692a = MessageDigest.getInstance(str);
            this.b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
