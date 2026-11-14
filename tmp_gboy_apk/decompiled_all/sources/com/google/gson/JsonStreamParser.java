package com.google.gson;

import Q2dWmT.A4TApA;
import Q2dWmT.ADYaiT;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final A4TApA parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.BChYOn() != 10;
                    } catch (IOException e) {
                        throw new JsonIOException(e);
                    }
                } catch (ADYaiT e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        A4TApA a4TApA = new A4TApA(reader);
        this.parser = a4TApA;
        a4TApA.f7429AlLFFp = true;
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return com.google.gson.internal.ADYaiT.ASJ6gh(this.parser);
        } catch (JsonParseException e) {
            if (e.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e;
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        }
    }
}
