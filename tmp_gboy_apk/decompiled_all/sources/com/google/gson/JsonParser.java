package com.google.gson;

import Q2dWmT.A4TApA;
import Q2dWmT.ADYaiT;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class JsonParser {
    public JsonElement parse(String str) {
        return parse(new StringReader(str));
    }

    public JsonElement parse(Reader reader) {
        try {
            A4TApA a4TApA = new A4TApA(reader);
            JsonElement parse = parse(a4TApA);
            if (!parse.isJsonNull() && a4TApA.BChYOn() != 10) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return parse;
        } catch (ADYaiT e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    public JsonElement parse(A4TApA a4TApA) {
        boolean z = a4TApA.f7429AlLFFp;
        a4TApA.f7429AlLFFp = true;
        try {
            try {
                try {
                    return com.google.gson.internal.ADYaiT.ASJ6gh(a4TApA);
                } catch (StackOverflowError e) {
                    throw new JsonParseException("Failed parsing JSON source: " + a4TApA + " to Json", e);
                }
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + a4TApA + " to Json", e2);
            }
        } finally {
            a4TApA.f7429AlLFFp = z;
        }
    }
}
