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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Tracking extends AndroidMessage<Tracking, Builder> {
    public static final ProtoAdapter<Tracking> ADAPTER;
    public static final Parcelable.Creator<Tracking> CREATOR;
    public static final String DEFAULT_TRACKING_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String tracking_event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> tracking_url;

    public static final class Builder extends Message.Builder<Tracking, Builder> {
        public String tracking_event_type = "";
        public List<String> tracking_url = Internal.newMutableList();

        public Builder tracking_event_type(String str) {
            this.tracking_event_type = str;
            return this;
        }

        public Builder tracking_url(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.tracking_url = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Tracking build() {
            return new Tracking(this.tracking_event_type, this.tracking_url, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Tracking extends ProtoAdapter<Tracking> {
        public ProtoAdapter_Tracking() {
            super(FieldEncoding.LENGTH_DELIMITED, Tracking.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Tracking decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.tracking_event_type(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.tracking_url.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Tracking tracking) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, tracking.tracking_event_type);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, tracking.tracking_url);
            protoWriter.writeBytes(tracking.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Tracking tracking) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return tracking.unknownFields().size() + protoAdapter.asRepeated().encodedSizeWithTag(2, tracking.tracking_url) + protoAdapter.encodedSizeWithTag(1, tracking.tracking_event_type);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Tracking redact(Tracking tracking) {
            Builder newBuilder = tracking.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Tracking protoAdapter_Tracking = new ProtoAdapter_Tracking();
        ADAPTER = protoAdapter_Tracking;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Tracking);
        QejAQPu();
    }

    public Tracking(String str, List<String> list) {
        this(str, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void QejAQPu() {
        char[] charArray = "\u008a\u0086\u0084Ç\u008e\u0088\u0084\u008cÇ\u008b\u0086\u0090Ç\u009a\u0081\u008c\u0085\u0085Ç£\u0087\u0080«\u009b\u0080\u008d\u008e\u008c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 233);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008a\u0085\u0080\u0087\u0080\u009d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 233);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) obj;
        return unknownFields().equals(tracking.unknownFields()) && Internal.equals(this.tracking_event_type, tracking.tracking_event_type) && this.tracking_url.equals(tracking.tracking_url);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.tracking_event_type;
        int hashCode2 = this.tracking_url.hashCode() + ((hashCode + (str != null ? str.hashCode() : 0)) * 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tracking_event_type != null) {
            sb.append(", tracking_event_type=");
            sb.append(this.tracking_event_type);
        }
        if (!this.tracking_url.isEmpty()) {
            sb.append(", tracking_url=");
            sb.append(this.tracking_url);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Tracking{", '}');
    }

    public Tracking(String str, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.tracking_event_type = str;
        this.tracking_url = Internal.immutableCopyOf("tracking_url", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.tracking_event_type = this.tracking_event_type;
        builder.tracking_url = Internal.copyOf("tracking_url", this.tracking_url);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
