package com.sigmob.sdk.base.models.rtb;

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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class LinkAction extends AndroidMessage<LinkAction, Builder> {
    public static final ProtoAdapter<LinkAction> ADAPTER;
    public static final Parcelable.Creator<LinkAction> CREATOR;
    public static final String DEFAULT_HOST = "";
    public static final Integer DEFAULT_REDIRECT_COUNT;
    public static final String DEFAULT_scheme = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String host;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer redirect_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String scheme;

    public static final class Builder extends Message.Builder<LinkAction, Builder> {
        public String host;
        public Integer redirect_count = LinkAction.DEFAULT_REDIRECT_COUNT;
        public String scheme;

        public Builder host(String str) {
            this.host = str;
            return this;
        }

        public Builder redirect_count(Integer num) {
            this.redirect_count = num;
            return this;
        }

        public Builder scheme(String str) {
            this.scheme = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public LinkAction build() {
            return new LinkAction(this.scheme, this.host, this.redirect_count, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LinkAction extends ProtoAdapter<LinkAction> {
        public ProtoAdapter_LinkAction() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public LinkAction decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.scheme(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.host(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.redirect_count(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, LinkAction linkAction) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, linkAction.scheme);
            protoAdapter.encodeWithTag(protoWriter, 2, linkAction.host);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, linkAction.redirect_count);
            protoWriter.writeBytes(linkAction.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(LinkAction linkAction) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return linkAction.unknownFields().size() + ProtoAdapter.INT32.encodedSizeWithTag(3, linkAction.redirect_count) + protoAdapter.encodedSizeWithTag(2, linkAction.host) + protoAdapter.encodedSizeWithTag(1, linkAction.scheme);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public LinkAction redact(LinkAction linkAction) {
            Builder newBuilder = linkAction.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_LinkAction protoAdapter_LinkAction = new ProtoAdapter_LinkAction();
        ADAPTER = protoAdapter_LinkAction;
        CREATOR = AndroidMessage.newCreator(protoAdapter_LinkAction);
        DEFAULT_REDIRECT_COUNT = 0;
        sTeQ();
    }

    public LinkAction(String str, String str2, Integer num) {
        this(str, str2, num, ByteString.EMPTY);
    }

    private static /* synthetic */ void sTeQ() {
        char[] charArray = ")%'d-+'/d(%3d9\"/&&d\u0000$#\b8#.-/".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'J');
        }
        String str = new String(charArray);
        char[] charArray2 = ")&#$#>".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'J');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkAction)) {
            return false;
        }
        LinkAction linkAction = (LinkAction) obj;
        return unknownFields().equals(linkAction.unknownFields()) && Internal.equals(this.scheme, linkAction.scheme) && Internal.equals(this.host, linkAction.host) && Internal.equals(this.redirect_count, linkAction.redirect_count);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.scheme;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.host;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.redirect_count;
        int hashCode4 = hashCode3 + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(", scheme=");
            sb.append(this.scheme);
        }
        if (this.host != null) {
            sb.append(", host=");
            sb.append(this.host);
        }
        if (this.redirect_count != null) {
            sb.append(", redirect_count=");
            sb.append(this.redirect_count);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "LinkAction{", '}');
    }

    public LinkAction(String str, String str2, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.scheme = str;
        this.host = str2;
        this.redirect_count = num;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.host = this.host;
        builder.redirect_count = this.redirect_count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
