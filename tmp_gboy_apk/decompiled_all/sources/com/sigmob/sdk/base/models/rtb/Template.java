package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import android.text.TextUtils;
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
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Template extends AndroidMessage<Template, Builder> {
    public static final ProtoAdapter<Template> ADAPTER;
    public static final Parcelable.Creator<Template> CREATOR;
    public static final ByteString DEFAULT_CONTEXT;
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString context;
    public String templateId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer type;

    public static final class Builder extends Message.Builder<Template, Builder> {
        public ByteString context;
        public Integer type = Template.DEFAULT_TYPE;

        public Builder context(ByteString byteString) {
            this.context = byteString;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Template build() {
            return new Template(this.type, this.context, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Template extends ProtoAdapter<Template> {
        public ProtoAdapter_Template() {
            super(FieldEncoding.LENGTH_DELIMITED, Template.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Template decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.type(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.context(ProtoAdapter.BYTES.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Template template) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, template.type);
            ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, template.context);
            protoWriter.writeBytes(template.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Template template) {
            return template.unknownFields().size() + ProtoAdapter.BYTES.encodedSizeWithTag(2, template.context) + ProtoAdapter.UINT32.encodedSizeWithTag(1, template.type);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Template redact(Template template) {
            Builder newBuilder = template.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Template protoAdapter_Template = new ProtoAdapter_Template();
        ADAPTER = protoAdapter_Template;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Template);
        DEFAULT_TYPE = 0;
        DEFAULT_CONTEXT = ByteString.EMPTY;
        xsKwQ();
    }

    public Template(Integer num, ByteString byteString) {
        this(num, byteString, ByteString.EMPTY);
    }

    private static /* synthetic */ void xsKwQ() {
        char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'r');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Template)) {
            return false;
        }
        Template template = (Template) obj;
        return unknownFields().equals(template.unknownFields()) && Internal.equals(this.type, template.type) && Internal.equals(this.context, template.context);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        ByteString byteString = this.context;
        int hashCode3 = hashCode2 + (byteString != null ? byteString.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.context != null) {
            sb.append(", context=");
            sb.append(this.context);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Template{", '}');
    }

    public Template(Integer num, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.type = num;
        this.context = byteString;
        if (num.intValue() == 2 && TextUtils.isEmpty(this.templateId)) {
            this.templateId = UUID.randomUUID().toString();
        }
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.context = this.context;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
