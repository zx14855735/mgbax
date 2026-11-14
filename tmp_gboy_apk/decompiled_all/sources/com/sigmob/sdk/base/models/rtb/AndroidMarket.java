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
public final class AndroidMarket extends AndroidMessage<AndroidMarket, Builder> {
    public static final ProtoAdapter<AndroidMarket> ADAPTER;
    public static final Parcelable.Creator<AndroidMarket> CREATOR;
    public static final String DEFAULT_APPSTORE_PACKAGE_NAME = "";
    public static final String DEFAULT_APP_PACKAGE_NAME = "";
    public static final String DEFAULT_MARKET_URL = "";
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String app_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appstore_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String market_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer type;

    public static final class Builder extends Message.Builder<AndroidMarket, Builder> {
        public String app_package_name;
        public String appstore_package_name;
        public String market_url;
        public Integer type;

        public Builder app_package_name(String str) {
            this.app_package_name = str;
            return this;
        }

        public Builder appstore_package_name(String str) {
            this.appstore_package_name = str;
            return this;
        }

        public Builder market_url(String str) {
            this.market_url = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public AndroidMarket build() {
            return new AndroidMarket(this.market_url, this.app_package_name, this.appstore_package_name, this.type, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_AndroidMarket extends ProtoAdapter<AndroidMarket> {
        public ProtoAdapter_AndroidMarket() {
            super(FieldEncoding.LENGTH_DELIMITED, AndroidMarket.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public AndroidMarket decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.market_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.app_package_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.appstore_package_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.type(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AndroidMarket androidMarket) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, androidMarket.market_url);
            protoAdapter.encodeWithTag(protoWriter, 2, androidMarket.app_package_name);
            protoAdapter.encodeWithTag(protoWriter, 3, androidMarket.appstore_package_name);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, androidMarket.type);
            protoWriter.writeBytes(androidMarket.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AndroidMarket androidMarket) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return androidMarket.unknownFields().size() + ProtoAdapter.UINT32.encodedSizeWithTag(4, androidMarket.type) + protoAdapter.encodedSizeWithTag(3, androidMarket.appstore_package_name) + protoAdapter.encodedSizeWithTag(2, androidMarket.app_package_name) + protoAdapter.encodedSizeWithTag(1, androidMarket.market_url);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AndroidMarket redact(AndroidMarket androidMarket) {
            Builder newBuilder = androidMarket.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AndroidMarket protoAdapter_AndroidMarket = new ProtoAdapter_AndroidMarket();
        ADAPTER = protoAdapter_AndroidMarket;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AndroidMarket);
        DEFAULT_TYPE = 0;
        OIGfzU();
    }

    public AndroidMarket(String str, String str2, String str3, Integer num) {
        this(str, str2, str3, num, ByteString.EMPTY);
    }

    private static /* synthetic */ void OIGfzU() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidMarket)) {
            return false;
        }
        AndroidMarket androidMarket = (AndroidMarket) obj;
        return unknownFields().equals(androidMarket.unknownFields()) && Internal.equals(this.market_url, androidMarket.market_url) && Internal.equals(this.app_package_name, androidMarket.app_package_name) && Internal.equals(this.appstore_package_name, androidMarket.appstore_package_name) && Internal.equals(this.type, androidMarket.type);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.market_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.app_package_name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.appstore_package_name;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode5 = hashCode4 + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.market_url != null) {
            sb.append(", market_url=");
            sb.append(this.market_url);
        }
        if (this.app_package_name != null) {
            sb.append(", app_package_name=");
            sb.append(this.app_package_name);
        }
        if (this.appstore_package_name != null) {
            sb.append(", appstore_package_name=");
            sb.append(this.appstore_package_name);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "AndroidMarket{", '}');
    }

    public AndroidMarket(String str, String str2, String str3, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.market_url = str;
        this.app_package_name = str2;
        this.appstore_package_name = str3;
        this.type = num;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.market_url = this.market_url;
        builder.app_package_name = this.app_package_name;
        builder.appstore_package_name = this.appstore_package_name;
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
