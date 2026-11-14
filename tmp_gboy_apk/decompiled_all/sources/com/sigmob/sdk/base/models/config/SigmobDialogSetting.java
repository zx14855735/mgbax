package com.sigmob.sdk.base.models.config;

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
public final class SigmobDialogSetting extends AndroidMessage<SigmobDialogSetting, Builder> {
    public static final ProtoAdapter<SigmobDialogSetting> ADAPTER;
    public static final Parcelable.Creator<SigmobDialogSetting> CREATOR;
    public static final String DEFAULT_BODY_TEXT = "";
    public static final String DEFAULT_CANCEL_BUTTON_TEXT = "";
    public static final String DEFAULT_CLOSE_BUTTON_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String cancel_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String close_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String title;

    public static final class Builder extends Message.Builder<SigmobDialogSetting, Builder> {
        public String body_text;
        public String cancel_button_text;
        public String close_button_text;
        public String title;

        public Builder body_text(String str) {
            this.body_text = str;
            return this;
        }

        public Builder cancel_button_text(String str) {
            this.cancel_button_text = str;
            return this;
        }

        public Builder close_button_text(String str) {
            this.close_button_text = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobDialogSetting build() {
            return new SigmobDialogSetting(this.title, this.body_text, this.cancel_button_text, this.close_button_text, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobDialogSetting extends ProtoAdapter<SigmobDialogSetting> {
        public ProtoAdapter_SigmobDialogSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobDialogSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobDialogSetting decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.title(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.body_text(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.cancel_button_text(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.close_button_text(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobDialogSetting sigmobDialogSetting) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobDialogSetting.title);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobDialogSetting.body_text);
            protoAdapter.encodeWithTag(protoWriter, 3, sigmobDialogSetting.cancel_button_text);
            protoAdapter.encodeWithTag(protoWriter, 4, sigmobDialogSetting.close_button_text);
            protoWriter.writeBytes(sigmobDialogSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobDialogSetting sigmobDialogSetting) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            return sigmobDialogSetting.unknownFields().size() + protoAdapter.encodedSizeWithTag(4, sigmobDialogSetting.close_button_text) + protoAdapter.encodedSizeWithTag(3, sigmobDialogSetting.cancel_button_text) + protoAdapter.encodedSizeWithTag(2, sigmobDialogSetting.body_text) + protoAdapter.encodedSizeWithTag(1, sigmobDialogSetting.title);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobDialogSetting redact(SigmobDialogSetting sigmobDialogSetting) {
            Builder newBuilder = sigmobDialogSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobDialogSetting protoAdapter_SigmobDialogSetting = new ProtoAdapter_SigmobDialogSetting();
        ADAPTER = protoAdapter_SigmobDialogSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobDialogSetting);
        KOtfs();
    }

    public SigmobDialogSetting(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, ByteString.EMPTY);
    }

    private static /* synthetic */ void KOtfs() {
        char[] charArray = "r~|?vp|t?s~h?byt}}?[\u007fxScxuvt".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 17);
        }
        String str = new String(charArray);
        char[] charArray2 = "r}x\u007fxe".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 17);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobDialogSetting)) {
            return false;
        }
        SigmobDialogSetting sigmobDialogSetting = (SigmobDialogSetting) obj;
        return unknownFields().equals(sigmobDialogSetting.unknownFields()) && Internal.equals(this.title, sigmobDialogSetting.title) && Internal.equals(this.body_text, sigmobDialogSetting.body_text) && Internal.equals(this.cancel_button_text, sigmobDialogSetting.cancel_button_text) && Internal.equals(this.close_button_text, sigmobDialogSetting.close_button_text);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.body_text;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cancel_button_text;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.close_button_text;
        int hashCode5 = hashCode4 + (str4 != null ? str4.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.title != null) {
            sb.append(", title=");
            sb.append(this.title);
        }
        if (this.body_text != null) {
            sb.append(", body_text=");
            sb.append(this.body_text);
        }
        if (this.cancel_button_text != null) {
            sb.append(", cancel_button_text=");
            sb.append(this.cancel_button_text);
        }
        if (this.close_button_text != null) {
            sb.append(", close_button_text=");
            sb.append(this.close_button_text);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobDialogSetting{", '}');
    }

    public SigmobDialogSetting(String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.title = str;
        this.body_text = str2;
        this.cancel_button_text = str3;
        this.close_button_text = str4;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.body_text = this.body_text;
        builder.cancel_button_text = this.cancel_button_text;
        builder.close_button_text = this.close_button_text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
