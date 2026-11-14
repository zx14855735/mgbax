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
public final class ResponseNativeAd extends AndroidMessage<ResponseNativeAd, Builder> {
    public static final ProtoAdapter<ResponseNativeAd> ADAPTER;
    public static final Parcelable.Creator<ResponseNativeAd> CREATOR;
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "ResponseAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<ResponseAsset> assets;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer type;

    public static final class Builder extends Message.Builder<ResponseNativeAd, Builder> {
        public Integer type = ResponseNativeAd.DEFAULT_TYPE;
        public List<ResponseAsset> assets = Internal.newMutableList();

        public Builder assets(List<ResponseAsset> list) {
            Internal.checkElementsNotNull(list);
            this.assets = list;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public ResponseNativeAd build() {
            return new ResponseNativeAd(this.assets, this.type, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseNativeAd extends ProtoAdapter<ResponseNativeAd> {
        public ProtoAdapter_ResponseNativeAd() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseNativeAd.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public ResponseNativeAd decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.assets.add(ResponseAsset.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.type(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ResponseNativeAd responseNativeAd) {
            ResponseAsset.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, responseNativeAd.assets);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, responseNativeAd.type);
            protoWriter.writeBytes(responseNativeAd.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(ResponseNativeAd responseNativeAd) {
            return responseNativeAd.unknownFields().size() + ProtoAdapter.UINT32.encodedSizeWithTag(2, responseNativeAd.type) + ResponseAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, responseNativeAd.assets);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public ResponseNativeAd redact(ResponseNativeAd responseNativeAd) {
            Builder newBuilder = responseNativeAd.newBuilder();
            Internal.redactElements(newBuilder.assets, ResponseAsset.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseNativeAd protoAdapter_ResponseNativeAd = new ProtoAdapter_ResponseNativeAd();
        ADAPTER = protoAdapter_ResponseNativeAd;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseNativeAd);
        DEFAULT_TYPE = 0;
        pGpVZ();
    }

    public ResponseNativeAd(List<ResponseAsset> list, Integer num) {
        this(list, num, ByteString.EMPTY);
    }

    private static /* synthetic */ void pGpVZ() {
        char[] charArray = "\u000f\u0003\u0001B\u000b\r\u0001\tB\u000e\u0003\u0015B\u001f\u0004\t\u0000\u0000B&\u0002\u0005.\u001e\u0005\b\u000b\t".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'l');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000f\u0000\u0005\u0002\u0005\u0018".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'l');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseNativeAd)) {
            return false;
        }
        ResponseNativeAd responseNativeAd = (ResponseNativeAd) obj;
        return unknownFields().equals(responseNativeAd.unknownFields()) && this.assets.equals(responseNativeAd.assets) && Internal.equals(this.type, responseNativeAd.type);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int A5SV6n2 = A2egSU.A5SV6n(this.assets, unknownFields().hashCode() * 37, 37);
        Integer num = this.type;
        int hashCode = A5SV6n2 + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.assets.isEmpty()) {
            sb.append(", assets=");
            sb.append(this.assets);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "ResponseNativeAd{", '}');
    }

    public ResponseNativeAd(List<ResponseAsset> list, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.assets = Internal.immutableCopyOf("assets", list);
        this.type = num;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.assets = Internal.copyOf("assets", this.assets);
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
