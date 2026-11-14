package com.google.gson;

import Q2dWmT.A4TApA;
import Q2dWmT.A5SV6n;
import com.google.gson.internal.bind.ADYaiT;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) {
        return read2(new A4TApA(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read2(new com.google.gson.internal.bind.A4TApA(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return (T) TypeAdapter.this.read2(a4TApA);
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, T t) {
                if (t == null) {
                    a5SV6n.AZOQYO();
                } else {
                    TypeAdapter.this.write(a5SV6n, t);
                }
            }
        };
    }

    /* renamed from: read */
    public abstract T read2(A4TApA a4TApA);

    public final void toJson(Writer writer, T t) {
        write(new A5SV6n(writer), t);
    }

    public final JsonElement toJsonTree(T t) {
        try {
            ADYaiT aDYaiT = new ADYaiT();
            write(aDYaiT, t);
            return aDYaiT.B4ZgIw();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public abstract void write(A5SV6n a5SV6n, T t);

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
