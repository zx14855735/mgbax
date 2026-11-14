package org.apache.commons.codec.net;

import ADYaiT.CtFAbx;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class RFC1522Codec {
    protected static final String POSTFIX = "?=";
    protected static final String PREFIX = "=?";
    protected static final char SEP = '?';

    public String decodeText(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf == length) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String substring = str.substring(2, indexOf);
        if (substring.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(63, i);
        if (indexOf2 == length) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String substring2 = str.substring(i, indexOf2);
        if (!getEncoding().equalsIgnoreCase(substring2)) {
            throw new DecoderException(CtFAbx.BI9f7h("This codec cannot decode ", substring2, " encoded content"));
        }
        int i2 = indexOf2 + 1;
        return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), substring);
    }

    public abstract byte[] doDecoding(byte[] bArr);

    public abstract byte[] doEncoding(byte[] bArr);

    public String encodeText(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return PREFIX + charset + SEP + getEncoding() + SEP + StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))) + POSTFIX;
    }

    public abstract String getEncoding();

    public String encodeText(String str, String str2) {
        if (str == null) {
            return null;
        }
        return encodeText(str, Charset.forName(str2));
    }
}
