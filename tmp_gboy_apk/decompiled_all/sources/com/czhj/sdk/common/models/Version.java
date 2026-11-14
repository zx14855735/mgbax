package com.czhj.sdk.common.models;

import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Version extends AndroidMessage<Version, Builder> {
    public static final ProtoAdapter<Version> ADAPTER;
    public static final Parcelable.Creator<Version> CREATOR;
    public static final Integer DEFAULT_MAJOR;
    public static final Integer DEFAULT_MICRO;
    public static final Integer DEFAULT_MINOR;
    public static final String DEFAULT_VERSION_STR = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer major;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer micro;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer minor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String version_str;

    public static final class Builder extends Message.Builder<Version, Builder> {
        public Integer major = Version.DEFAULT_MAJOR;
        public Integer minor = Version.DEFAULT_MINOR;
        public Integer micro = Version.DEFAULT_MICRO;
        public String version_str = "";

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public Version build() {
            return new Version(this.major, this.minor, this.micro, this.version_str, buildUnknownFields());
        }

        public Builder major(Integer num) {
            this.major = num;
            return this;
        }

        public Builder micro(Integer num) {
            this.micro = num;
            return this;
        }

        public Builder minor(Integer num) {
            this.minor = num;
            return this;
        }

        public Builder version_str(String str) {
            this.version_str = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Version extends ProtoAdapter<Version> {
        public ProtoAdapter_Version() {
            super(FieldEncoding.LENGTH_DELIMITED, Version.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Version decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.major(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.minor(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.micro(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.version_str(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Version version) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, version.major);
            protoAdapter.encodeWithTag(protoWriter, 2, version.minor);
            protoAdapter.encodeWithTag(protoWriter, 3, version.micro);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, version.version_str);
            protoWriter.writeBytes(version.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Version version) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return version.unknownFields().size() + ProtoAdapter.STRING.encodedSizeWithTag(4, version.version_str) + protoAdapter.encodedSizeWithTag(3, version.micro) + protoAdapter.encodedSizeWithTag(2, version.minor) + protoAdapter.encodedSizeWithTag(1, version.major);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Version redact(Version version) {
            Builder newBuilder = version.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Version protoAdapter_Version = new ProtoAdapter_Version();
        ADAPTER = protoAdapter_Version;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Version);
        DEFAULT_MAJOR = 0;
        DEFAULT_MINOR = 0;
        DEFAULT_MICRO = 0;
        tKMk();
    }

    public Version(Integer num, Integer num2, Integer num3, String str) {
        this(num, num2, num3, str, ByteString.EMPTY);
    }

    private static /* synthetic */ void tKMk() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return unknownFields().equals(version.unknownFields()) && Internal.equals(this.major, version.major) && Internal.equals(this.minor, version.minor) && Internal.equals(this.micro, version.micro) && Internal.equals(this.version_str, version.version_str);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.major;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.minor;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.micro;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.version_str;
        int hashCode5 = hashCode4 + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.major = this.major;
        builder.minor = this.minor;
        builder.micro = this.micro;
        builder.version_str = this.version_str;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.major != null) {
            sb.append(", major=");
            sb.append(this.major);
        }
        if (this.minor != null) {
            sb.append(", minor=");
            sb.append(this.minor);
        }
        if (this.micro != null) {
            sb.append(", micro=");
            sb.append(this.micro);
        }
        if (this.version_str != null) {
            sb.append(", version_str=");
            sb.append(this.version_str);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Version{", '}');
    }

    public Version(Integer num, Integer num2, Integer num3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.major = num;
        this.minor = num2;
        this.micro = num3;
        this.version_str = str;
    }
}
