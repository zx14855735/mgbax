package com.google.gson;

import Q2dWmT.A4TApA;
import Q2dWmT.A5SV6n;
import Q2dWmT.ADYaiT;
import com.google.gson.internal.ARc23Z;
import com.google.gson.internal.AmA8tU;
import com.google.gson.internal.B25kr6;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE = new TypeToken<Object>() { // from class: com.google.gson.Gson.1
    };
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    private final ARc23Z constructorConstructor;
    private final Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private final FieldNamingStrategy fieldNamingStrategy;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final boolean lenient;
    private final boolean prettyPrinting;
    private final boolean serializeNulls;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(A4TApA a4TApA) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read2(a4TApA);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(A5SV6n a5SV6n, T t) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(a5SV6n, t);
        }
    }

    static {
        wVFOAuT();
    }

    public Gson() {
        this(Excluder.f12069B3GDIM, FieldNamingPolicy.IDENTITY, Collections.EMPTY_MAP, false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.EMPTY_LIST);
    }

    private static void assertFullConsumption(Object obj, A4TApA a4TApA) {
        if (obj != null) {
            try {
                if (a4TApA.BChYOn() == 10) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (ADYaiT e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: avoid collision after fix types in other method */
            public AtomicLong read2(A4TApA a4TApA) {
                return new AtomicLong(((Number) TypeAdapter.this.read2(a4TApA)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, AtomicLong atomicLong) {
                TypeAdapter.this.write(a5SV6n, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.6
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: avoid collision after fix types in other method */
            public AtomicLongArray read2(A4TApA a4TApA) {
                ArrayList arrayList = new ArrayList();
                a4TApA.A2egSU();
                while (a4TApA.AZOQYO()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read2(a4TApA)).longValue()));
                }
                a4TApA.AMqCpz();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, AtomicLongArray atomicLongArray) {
                a5SV6n.A4TApA();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(a5SV6n, Long.valueOf(atomicLongArray.get(i)));
                }
                a5SV6n.AMqCpz();
            }
        }.nullSafe();
    }

    public static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        return z ? com.google.gson.internal.bind.ARc23Z.f12110AlLFFp : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: merged with bridge method [inline-methods] */
            public Number read2(A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Double.valueOf(a4TApA.AlLFFp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, Number number) {
                if (number == null) {
                    a5SV6n.AZOQYO();
                } else {
                    Gson.checkValidFloatingPoint(number.doubleValue());
                    a5SV6n.AzWtSf(number);
                }
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        return z ? com.google.gson.internal.bind.ARc23Z.f12109AcNBzu : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Float.valueOf((float) a4TApA.AlLFFp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, Number number) {
                if (number == null) {
                    a5SV6n.AZOQYO();
                } else {
                    Gson.checkValidFloatingPoint(number.floatValue());
                    a5SV6n.AzWtSf(number);
                }
            }
        };
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? com.google.gson.internal.bind.ARc23Z.f12108AaHO0E : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Long.valueOf(a4TApA.AzWtSf());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(A5SV6n a5SV6n, Number number) {
                if (number == null) {
                    a5SV6n.AZOQYO();
                } else {
                    a5SV6n.B25kr6(number.toString());
                }
            }
        };
    }

    private static /* synthetic */ void wVFOAuT() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(A4TApA a4TApA, Type type) {
        boolean z = a4TApA.f7429AlLFFp;
        boolean z2 = true;
        a4TApA.f7429AlLFFp = true;
        try {
            try {
                try {
                    a4TApA.BChYOn();
                    z2 = false;
                    return getAdapter(TypeToken.get(type)).read2(a4TApA);
                } catch (IllegalStateException e) {
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e2) {
                if (!z2) {
                    throw new JsonSyntaxException(e2);
                }
                a4TApA.f7429AlLFFp = z;
                return null;
            } catch (IOException e3) {
                throw new JsonSyntaxException(e3);
            }
        } finally {
            a4TApA.f7429AlLFFp = z;
        }
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        boolean z;
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.typeTokenCache.get(typeToken == null ? NULL_KEY_SURROGATE : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.calls.get();
        if (map == null) {
            map = new HashMap<>();
            this.calls.set(map);
            z = true;
        } else {
            z = false;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            Iterator<TypeAdapterFactory> it = this.factories.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> create = it.next().create(this, typeToken);
                if (create != null) {
                    futureTypeAdapter2.setDelegate(create);
                    this.typeTokenCache.put(typeToken, create);
                    return create;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z) {
                this.calls.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public A4TApA newJsonReader(Reader reader) {
        A4TApA a4TApA = new A4TApA(reader);
        a4TApA.f7429AlLFFp = this.lenient;
        return a4TApA;
    }

    public A5SV6n newJsonWriter(Writer writer) {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        A5SV6n a5SV6n = new A5SV6n(writer);
        if (this.prettyPrinting) {
            a5SV6n.f7448AzWtSf = "  ";
            a5SV6n.f7449B25kr6 = ": ";
        }
        a5SV6n.f7453B7CMnp = this.serializeNulls;
        return a5SV6n;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) {
        try {
            toJson(jsonElement, newJsonWriter(appendable instanceof Writer ? (Writer) appendable : new B25kr6(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        com.google.gson.internal.bind.ADYaiT aDYaiT = new com.google.gson.internal.bind.ADYaiT();
        toJson(obj, type, aDYaiT);
        return aDYaiT.B4ZgIw();
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.calls = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        ARc23Z aRc23Z = new ARc23Z(map);
        this.constructorConstructor = aRc23Z;
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.serializeNulls = z;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12127BmvVmW);
        arrayList.add(ObjectTypeAdapter.f12145A4TApA);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12115B3GDIM);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12104ASJ6gh);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12102ADYaiT);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.AMqCpz);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12103ARc23Z);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A5SV6n(Long.TYPE, Long.class, longAdapter));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A5SV6n(Double.TYPE, Double.class, doubleAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A5SV6n(Float.TYPE, Float.class, floatAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12111AmA8tU);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12105AYUAbz);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12106AZOQYO);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A4TApA(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A4TApA(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12107AZkASS);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12112AzWtSf);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12116B4ZgIw);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12117B7CMnp);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A4TApA(BigDecimal.class, com.google.gson.internal.bind.ARc23Z.f12113B25kr6));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.A4TApA(BigInteger.class, com.google.gson.internal.bind.ARc23Z.f12114B2KMhB));
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12118B9tovu);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12119BChYOn);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12121BIYEnU);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12122BJ7GGh);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12125BTvldC);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12120BI9f7h);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12100A4TApA);
        arrayList.add(DateTypeAdapter.f12135A5SV6n);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12124BPw6Q8);
        arrayList.add(TimeTypeAdapter.f12154A4TApA);
        arrayList.add(SqlDateTypeAdapter.f12152A4TApA);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12123BNL6CD);
        arrayList.add(ArrayTypeAdapter.f12129A5SV6n);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12099A2egSU);
        arrayList.add(new CollectionTypeAdapterFactory(aRc23Z));
        arrayList.add(new MapTypeAdapterFactory(aRc23Z, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(aRc23Z);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(com.google.gson.internal.bind.ARc23Z.f12128BniPrB);
        arrayList.add(new ReflectiveTypeAdapterFactory(aRc23Z, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public void toJson(Object obj, Type type, Appendable appendable) {
        try {
            toJson(obj, type, newJsonWriter(appendable instanceof Writer ? (Writer) appendable : new B25kr6(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(JsonElement jsonElement, A5SV6n a5SV6n) {
        boolean z = a5SV6n.f7450B2KMhB;
        a5SV6n.f7450B2KMhB = true;
        boolean z2 = a5SV6n.f7451B3GDIM;
        a5SV6n.f7451B3GDIM = this.htmlSafe;
        boolean z3 = a5SV6n.f7453B7CMnp;
        a5SV6n.f7453B7CMnp = this.serializeNulls;
        try {
            try {
                com.google.gson.internal.bind.ARc23Z.f12126BV3sI0.write(a5SV6n, jsonElement);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            a5SV6n.f7450B2KMhB = z;
            a5SV6n.f7451B3GDIM = z2;
            a5SV6n.f7453B7CMnp = z3;
        }
    }

    public <T> T fromJson(String str, Class<T> cls) {
        Object fromJson = fromJson(str, (Type) cls);
        Map map = AmA8tU.f12060A2egSU;
        cls.getClass();
        Class<T> cls2 = (Class) AmA8tU.f12060A2egSU.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.cast(fromJson);
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public <T> T fromJson(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) {
        A4TApA newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, cls);
        assertFullConsumption(fromJson, newJsonReader);
        Map map = AmA8tU.f12060A2egSU;
        cls.getClass();
        Class<T> cls2 = (Class) AmA8tU.f12060A2egSU.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.cast(fromJson);
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public <T> T fromJson(Reader reader, Type type) {
        A4TApA newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, type);
        assertFullConsumption(t, newJsonReader);
        return t;
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) {
        Object fromJson = fromJson(jsonElement, (Type) cls);
        Map map = AmA8tU.f12060A2egSU;
        cls.getClass();
        Class<T> cls2 = (Class) AmA8tU.f12060A2egSU.get(cls);
        if (cls2 != null) {
            cls = cls2;
        }
        return cls.cast(fromJson);
    }

    public void toJson(Object obj, Appendable appendable) {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, A5SV6n a5SV6n) {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean z = a5SV6n.f7450B2KMhB;
        a5SV6n.f7450B2KMhB = true;
        boolean z2 = a5SV6n.f7451B3GDIM;
        a5SV6n.f7451B3GDIM = this.htmlSafe;
        boolean z3 = a5SV6n.f7453B7CMnp;
        a5SV6n.f7453B7CMnp = this.serializeNulls;
        try {
            try {
                adapter.write(a5SV6n, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            a5SV6n.f7450B2KMhB = z;
            a5SV6n.f7451B3GDIM = z2;
            a5SV6n.f7453B7CMnp = z3;
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new com.google.gson.internal.bind.A4TApA(jsonElement), type);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }
}
