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
public final class Widget extends AndroidMessage<Widget, Builder> {
    public static final ProtoAdapter<Widget> ADAPTER;
    public static final Parcelable.Creator<Widget> CREATOR;
    public static final Boolean DEFAULT_ENABLE_DEVELOPER_RENDER;
    public static final Long DEFAULT_WIDGET_ID;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_developer_render;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long widget_id;

    public static final class Builder extends Message.Builder<Widget, Builder> {
        public Long widget_id = Widget.DEFAULT_WIDGET_ID;
        public Boolean enable_developer_render = Widget.DEFAULT_ENABLE_DEVELOPER_RENDER;

        public Builder enable_developer_render(Boolean bool) {
            this.enable_developer_render = bool;
            return this;
        }

        public Builder widget_id(Long l) {
            this.widget_id = l;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public Widget build() {
            return new Widget(this.widget_id, this.enable_developer_render, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Widget extends ProtoAdapter<Widget> {
        public ProtoAdapter_Widget() {
            super(FieldEncoding.LENGTH_DELIMITED, Widget.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Widget decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.widget_id(ProtoAdapter.UINT64.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.enable_developer_render(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Widget widget) {
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, widget.widget_id);
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, widget.enable_developer_render);
            protoWriter.writeBytes(widget.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Widget widget) {
            return widget.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(2, widget.enable_developer_render) + ProtoAdapter.UINT64.encodedSizeWithTag(1, widget.widget_id);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Widget redact(Widget widget) {
            Builder newBuilder = widget.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Widget protoAdapter_Widget = new ProtoAdapter_Widget();
        ADAPTER = protoAdapter_Widget;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Widget);
        DEFAULT_WIDGET_ID = 0L;
        DEFAULT_ENABLE_DEVELOPER_RENDER = Boolean.FALSE;
        fkig();
    }

    public Widget(Long l, Boolean bool) {
        this(l, bool, ByteString.EMPTY);
    }

    private static /* synthetic */ void fkig() {
        char[] charArray = "XTV\u0015\\ZV^\u0015YTB\u0015HS^WW\u0015qURyIR_\\^".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ';');
        }
        String str = new String(charArray);
        char[] charArray2 = "XWRURO".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ';');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Widget)) {
            return false;
        }
        Widget widget = (Widget) obj;
        return unknownFields().equals(widget.unknownFields()) && Internal.equals(this.widget_id, widget.widget_id) && Internal.equals(this.enable_developer_render, widget.enable_developer_render);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.widget_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.enable_developer_render;
        int hashCode3 = hashCode2 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.widget_id != null) {
            sb.append(", widget_id=");
            sb.append(this.widget_id);
        }
        if (this.enable_developer_render != null) {
            sb.append(", enable_developer_render=");
            sb.append(this.enable_developer_render);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Widget{", '}');
    }

    public Widget(Long l, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.widget_id = l;
        this.enable_developer_render = bool;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.widget_id = this.widget_id;
        builder.enable_developer_render = this.enable_developer_render;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
