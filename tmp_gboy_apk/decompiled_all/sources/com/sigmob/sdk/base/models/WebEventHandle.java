package com.sigmob.sdk.base.models;

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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class WebEventHandle extends AndroidMessage<WebEventHandle, Builder> {
    public static final ProtoAdapter<WebEventHandle> ADAPTER;
    public static final Parcelable.Creator<WebEventHandle> CREATOR;
    public static final Integer DEFAULT_HANDLE_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "WebEvent#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<WebEvent> events;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> handle_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer handle_type;

    public static final class Builder extends Message.Builder<WebEventHandle, Builder> {
        public Integer handle_type = WebEventHandle.DEFAULT_HANDLE_TYPE;
        public List<String> handle_name = Internal.newMutableList();
        public List<WebEvent> events = Internal.newMutableList();

        public Builder events(List<WebEvent> list) {
            Internal.checkElementsNotNull(list);
            this.events = list;
            return this;
        }

        public Builder handle_name(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.handle_name = list;
            return this;
        }

        public Builder handle_type(Integer num) {
            this.handle_type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public WebEventHandle build() {
            return new WebEventHandle(this.handle_type, this.handle_name, this.events, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_WebEventHandle extends ProtoAdapter<WebEventHandle> {
        public ProtoAdapter_WebEventHandle() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEventHandle.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public WebEventHandle decode(ProtoReader protoReader) {
            List list;
            Object obj;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    if (nextTag == 2) {
                        list = builder.handle_name;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                    } else if (nextTag != 3) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        list = builder.events;
                        obj = (WebEvent) WebEvent.ADAPTER.decode(protoReader);
                    }
                    list.add(obj);
                } else {
                    builder.handle_type(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, WebEventHandle webEventHandle) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, webEventHandle.handle_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, webEventHandle.handle_name);
            WebEvent.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, webEventHandle.events);
            protoWriter.writeBytes(webEventHandle.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(WebEventHandle webEventHandle) {
            return webEventHandle.unknownFields().size() + WebEvent.ADAPTER.asRepeated().encodedSizeWithTag(3, webEventHandle.events) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, webEventHandle.handle_name) + ProtoAdapter.UINT32.encodedSizeWithTag(1, webEventHandle.handle_type);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public WebEventHandle redact(WebEventHandle webEventHandle) {
            Builder newBuilder = webEventHandle.newBuilder();
            Internal.redactElements(newBuilder.events, WebEvent.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEventHandle protoAdapter_WebEventHandle = new ProtoAdapter_WebEventHandle();
        ADAPTER = protoAdapter_WebEventHandle;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEventHandle);
        DEFAULT_HANDLE_TYPE = 0;
        vbCpDM();
    }

    public WebEventHandle(Integer num, List<String> list, List<WebEvent> list2) {
        this(num, list, list2, ByteString.EMPTY);
    }

    private static /* synthetic */ void vbCpDM() {
        char[] charArray = "\u009e\u0092\u0090Ó\u009a\u009c\u0090\u0098Ó\u009f\u0092\u0084Ó\u008e\u0095\u0098\u0091\u0091Ó·\u0093\u0094¿\u008f\u0094\u0099\u009a\u0098".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 253);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009e\u0091\u0094\u0093\u0094\u0089".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 253);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebEventHandle)) {
            return false;
        }
        WebEventHandle webEventHandle = (WebEventHandle) obj;
        return unknownFields().equals(webEventHandle.unknownFields()) && Internal.equals(this.handle_type, webEventHandle.handle_type) && this.handle_name.equals(webEventHandle.handle_name) && this.events.equals(webEventHandle.events);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.handle_type;
        int hashCode2 = this.events.hashCode() + A2egSU.A5SV6n(this.handle_name, (hashCode + (num != null ? num.hashCode() : 0)) * 37, 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.handle_type != null) {
            sb.append(", handle_type=");
            sb.append(this.handle_type);
        }
        if (!this.handle_name.isEmpty()) {
            sb.append(", handle_name=");
            sb.append(this.handle_name);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=");
            sb.append(this.events);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "WebEventHandle{", '}');
    }

    public WebEventHandle(Integer num, List<String> list, List<WebEvent> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.handle_type = num;
        this.handle_name = Internal.immutableCopyOf("handle_name", list);
        this.events = Internal.immutableCopyOf("events", list2);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.handle_type = this.handle_type;
        builder.handle_name = Internal.copyOf("handle_name", this.handle_name);
        builder.events = Internal.copyOf("events", this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
