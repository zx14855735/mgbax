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
public final class Color extends AndroidMessage<Color, Builder> {
    public static final ProtoAdapter<Color> ADAPTER;
    public static final Parcelable.Creator<Color> CREATOR;
    public static final Float DEFAULT_ALPHA;
    public static final Integer DEFAULT_BLUE;
    public static final Integer DEFAULT_GREEN;
    public static final Integer DEFAULT_RED;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float alpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer blue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer green;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer red;

    public static final class Builder extends Message.Builder<Color, Builder> {
        public Integer red = Color.DEFAULT_RED;
        public Integer green = Color.DEFAULT_GREEN;
        public Integer blue = Color.DEFAULT_BLUE;
        public Float alpha = Color.DEFAULT_ALPHA;

        public Builder alpha(Float f) {
            this.alpha = f;
            return this;
        }

        public Builder blue(Integer num) {
            this.blue = num;
            return this;
        }

        public Builder green(Integer num) {
            this.green = num;
            return this;
        }

        public Builder red(Integer num) {
            this.red = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Color build() {
            return new Color(this.red, this.green, this.blue, this.alpha, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Color extends ProtoAdapter<Color> {
        public ProtoAdapter_Color() {
            super(FieldEncoding.LENGTH_DELIMITED, Color.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Color decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.red(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.green(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.blue(ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.alpha(ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Color color) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, color.red);
            protoAdapter.encodeWithTag(protoWriter, 2, color.green);
            protoAdapter.encodeWithTag(protoWriter, 3, color.blue);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, color.alpha);
            protoWriter.writeBytes(color.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Color color) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return color.unknownFields().size() + ProtoAdapter.FLOAT.encodedSizeWithTag(4, color.alpha) + protoAdapter.encodedSizeWithTag(3, color.blue) + protoAdapter.encodedSizeWithTag(2, color.green) + protoAdapter.encodedSizeWithTag(1, color.red);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Color redact(Color color) {
            Builder newBuilder = color.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Color protoAdapter_Color = new ProtoAdapter_Color();
        ADAPTER = protoAdapter_Color;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Color);
        DEFAULT_RED = 0;
        DEFAULT_GREEN = 0;
        DEFAULT_BLUE = 0;
        DEFAULT_ALPHA = Float.valueOf(0.0f);
        fGDjS();
    }

    public Color(Integer num, Integer num2, Integer num3, Float f) {
        this(num, num2, num3, f, ByteString.EMPTY);
    }

    private static /* synthetic */ void fGDjS() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Color)) {
            return false;
        }
        Color color = (Color) obj;
        return unknownFields().equals(color.unknownFields()) && Internal.equals(this.red, color.red) && Internal.equals(this.green, color.green) && Internal.equals(this.blue, color.blue) && Internal.equals(this.alpha, color.alpha);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.red;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.green;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.blue;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Float f = this.alpha;
        int hashCode5 = hashCode4 + (f != null ? f.hashCode() : 0);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.red != null) {
            sb.append(", red=");
            sb.append(this.red);
        }
        if (this.green != null) {
            sb.append(", green=");
            sb.append(this.green);
        }
        if (this.blue != null) {
            sb.append(", blue=");
            sb.append(this.blue);
        }
        if (this.alpha != null) {
            sb.append(", alpha=");
            sb.append(this.alpha);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Color{", '}');
    }

    public Color(Integer num, Integer num2, Integer num3, Float f, ByteString byteString) {
        super(ADAPTER, byteString);
        this.red = num;
        this.green = num2;
        this.blue = num3;
        this.alpha = f;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.red = this.red;
        builder.green = this.green;
        builder.blue = this.blue;
        builder.alpha = this.alpha;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
