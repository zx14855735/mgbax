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
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AdCache extends AndroidMessage<AdCache, Builder> {
    public static final ProtoAdapter<AdCache> ADAPTER;
    public static final Parcelable.Creator<AdCache> CREATOR;
    public static final Integer DEFAULT_AD_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> crids;

    public static final class Builder extends Message.Builder<AdCache, Builder> {
        public Integer ad_type;
        public List<String> crids = Internal.newMutableList();

        public Builder ad_type(Integer num) {
            this.ad_type = num;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public AdCache build() {
            return new AdCache(this.ad_type, this.crids, buildUnknownFields());
        }

        public Builder crids(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.crids = list;
            return this;
        }
    }

    public static final class ProtoAdapter_AdCache extends ProtoAdapter<AdCache> {
        public ProtoAdapter_AdCache() {
            super(FieldEncoding.LENGTH_DELIMITED, AdCache.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public AdCache decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.ad_type(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.crids.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AdCache adCache) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, adCache.ad_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, adCache.crids);
            protoWriter.writeBytes(adCache.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AdCache adCache) {
            return adCache.unknownFields().size() + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, adCache.crids) + ProtoAdapter.INT32.encodedSizeWithTag(1, adCache.ad_type);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdCache redact(AdCache adCache) {
            Builder newBuilder = adCache.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdCache protoAdapter_AdCache = new ProtoAdapter_AdCache();
        ADAPTER = protoAdapter_AdCache;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdCache);
        DEFAULT_AD_TYPE = 0;
        MVeLtyc();
    }

    public AdCache(Integer num, List<String> list) {
        this(num, list, ByteString.EMPTY);
    }

    private static /* synthetic */ void MVeLtyc() {
        char[] charArray = "q}\u007f<us\u007fw<p}k<azw~~<X|{P`{vuw".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 18);
        }
        String str = new String(charArray);
        char[] charArray2 = "q~{|{f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 18);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdCache)) {
            return false;
        }
        AdCache adCache = (AdCache) obj;
        return unknownFields().equals(adCache.unknownFields()) && Internal.equals(this.ad_type, adCache.ad_type) && this.crids.equals(adCache.crids);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.ad_type;
        int hashCode2 = this.crids.hashCode() + ((hashCode + (num != null ? num.hashCode() : 0)) * 37);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ad_type = this.ad_type;
        builder.crids = Internal.copyOf("crids", this.crids);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.ad_type != null) {
            sb.append(", ad_type=");
            sb.append(this.ad_type);
        }
        if (!this.crids.isEmpty()) {
            sb.append(", crids=");
            sb.append(this.crids);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "AdCache{", '}');
    }

    public AdCache(Integer num, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_type = num;
        this.crids = Internal.immutableCopyOf("crids", list);
    }
}
