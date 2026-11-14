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
public final class WXProgramReq extends AndroidMessage<WXProgramReq, Builder> {
    public static final ProtoAdapter<WXProgramReq> ADAPTER;
    public static final Parcelable.Creator<WXProgramReq> CREATOR;
    public static final String DEFAULT_OPENSDK_VER = "";
    public static final Integer DEFAULT_WX_API_VER;
    public static final Boolean DEFAULT_WX_INSTALLED;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String opensdk_ver;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer wx_api_ver;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean wx_installed;

    public static final class Builder extends Message.Builder<WXProgramReq, Builder> {
        public Integer wx_api_ver = WXProgramReq.DEFAULT_WX_API_VER;
        public String opensdk_ver = "";
        public Boolean wx_installed = WXProgramReq.DEFAULT_WX_INSTALLED;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public WXProgramReq build() {
            return new WXProgramReq(this.wx_api_ver, this.opensdk_ver, this.wx_installed, buildUnknownFields());
        }

        public Builder opensdk_ver(String str) {
            this.opensdk_ver = str;
            return this;
        }

        public Builder wx_api_ver(Integer num) {
            this.wx_api_ver = num;
            return this;
        }

        public Builder wx_installed(Boolean bool) {
            this.wx_installed = bool;
            return this;
        }
    }

    public static final class ProtoAdapter_WXProgramReq extends ProtoAdapter<WXProgramReq> {
        public ProtoAdapter_WXProgramReq() {
            super(FieldEncoding.LENGTH_DELIMITED, WXProgramReq.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public WXProgramReq decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.wx_api_ver(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.opensdk_ver(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.wx_installed(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, WXProgramReq wXProgramReq) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, wXProgramReq.wx_api_ver);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, wXProgramReq.opensdk_ver);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, wXProgramReq.wx_installed);
            protoWriter.writeBytes(wXProgramReq.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(WXProgramReq wXProgramReq) {
            return wXProgramReq.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(3, wXProgramReq.wx_installed) + ProtoAdapter.STRING.encodedSizeWithTag(2, wXProgramReq.opensdk_ver) + ProtoAdapter.INT32.encodedSizeWithTag(1, wXProgramReq.wx_api_ver);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public WXProgramReq redact(WXProgramReq wXProgramReq) {
            Builder newBuilder = wXProgramReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WXProgramReq protoAdapter_WXProgramReq = new ProtoAdapter_WXProgramReq();
        ADAPTER = protoAdapter_WXProgramReq;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WXProgramReq);
        DEFAULT_WX_API_VER = 0;
        DEFAULT_WX_INSTALLED = Boolean.FALSE;
        zpoPmF();
    }

    public WXProgramReq(Integer num, String str, Boolean bool) {
        this(num, str, bool, ByteString.EMPTY);
    }

    private static /* synthetic */ void zpoPmF() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WXProgramReq)) {
            return false;
        }
        WXProgramReq wXProgramReq = (WXProgramReq) obj;
        return unknownFields().equals(wXProgramReq.unknownFields()) && Internal.equals(this.wx_api_ver, wXProgramReq.wx_api_ver) && Internal.equals(this.opensdk_ver, wXProgramReq.opensdk_ver) && Internal.equals(this.wx_installed, wXProgramReq.wx_installed);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.wx_api_ver;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.opensdk_ver;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.wx_installed;
        int hashCode4 = hashCode3 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.wx_api_ver = this.wx_api_ver;
        builder.opensdk_ver = this.opensdk_ver;
        builder.wx_installed = this.wx_installed;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.wx_api_ver != null) {
            sb.append(", wx_api_ver=");
            sb.append(this.wx_api_ver);
        }
        if (this.opensdk_ver != null) {
            sb.append(", opensdk_ver=");
            sb.append(this.opensdk_ver);
        }
        if (this.wx_installed != null) {
            sb.append(", wx_installed=");
            sb.append(this.wx_installed);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "WXProgramReq{", '}');
    }

    public WXProgramReq(Integer num, String str, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.wx_api_ver = num;
        this.opensdk_ver = str;
        this.wx_installed = bool;
    }
}
