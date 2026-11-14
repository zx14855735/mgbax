package com.czhj.wire.okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class HashingSource extends ForwardingSource {

    /* renamed from: a, reason: collision with root package name */
    private final MessageDigest f10693a;
    private final Mac b;

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            Mac mac = Mac.getInstance(str);
            this.b = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.f10693a = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, MessageDigestAlgorithms.SHA_1);
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, MessageDigestAlgorithms.SHA_256);
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.f10693a;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.b.doFinal());
    }

    @Override // com.czhj.wire.okio.ForwardingSource, com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.c;
            long j3 = j2 - read;
            Segment segment = buffer.b;
            while (j2 > j3) {
                segment = segment.i;
                j2 -= segment.e - segment.d;
            }
            while (j2 < buffer.c) {
                int i = (int) ((segment.d + j3) - j2);
                MessageDigest messageDigest = this.f10693a;
                if (messageDigest != null) {
                    messageDigest.update(segment.c, i, segment.e - i);
                } else {
                    this.b.update(segment.c, i, segment.e - i);
                }
                j3 = (segment.e - segment.d) + j2;
                segment = segment.h;
                j2 = j3;
            }
        }
        return read;
    }

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.f10693a = MessageDigest.getInstance(str);
            this.b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
