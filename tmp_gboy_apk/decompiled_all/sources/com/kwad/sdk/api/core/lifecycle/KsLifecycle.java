package com.kwad.sdk.api.core.lifecycle;

import A5SV6n.A2egSU;
import androidx.lifecycle.AlLFFp;
import androidx.lifecycle.AmA8tU;
import androidx.lifecycle.AzWtSf;
import androidx.lifecycle.B4ZgIw;
import androidx.lifecycle.B9tovu;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsLifecycle {
    private AzWtSf mBase;

    @A2egSU
    public enum KsLifeEvent {
        ON_CREATE(AlLFFp.ON_CREATE),
        ON_START(AlLFFp.ON_START),
        ON_RESUME(AlLFFp.ON_RESUME),
        ON_PAUSE(AlLFFp.ON_PAUSE),
        ON_STOP(AlLFFp.ON_STOP),
        ON_DESTROY(AlLFFp.ON_DESTROY),
        ON_ANY(AlLFFp.ON_ANY);

        AlLFFp mRealValue;

        static {
            ycEXjxQ();
        }

        KsLifeEvent(AlLFFp alLFFp) {
            this.mRealValue = alLFFp;
        }

        public static KsLifeEvent createfrom(AlLFFp alLFFp) {
            for (KsLifeEvent ksLifeEvent : values()) {
                if (ksLifeEvent.getReal() == alLFFp) {
                    return ksLifeEvent;
                }
            }
            return null;
        }

        private static /* synthetic */ void ycEXjxQ() {
            char[] charArray = "ÓßÝ\u009e×ÑÝÕ\u009eÒßÉ\u009eÃØÕÜÜ\u009eúÞÙòÂÙÔ×Õ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 176);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÓÜÙÞÙÄ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 176);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @A2egSU
        public final AlLFFp getReal() {
            return this.mRealValue;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DESTROYED' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class KsLifeState {
        private static final /* synthetic */ KsLifeState[] $VALUES;
        public static final KsLifeState CREATED;
        public static final KsLifeState DESTROYED;
        public static final KsLifeState INITIALIZED;
        public static final KsLifeState RESUMED;
        public static final KsLifeState STARTED;
        AmA8tU mReal;

        static {
            AmA8tU amA8tU = AmA8tU.f8977AcNBzu;
            KsLifeState ksLifeState = new KsLifeState("DESTROYED", 0, amA8tU);
            DESTROYED = ksLifeState;
            KsLifeState ksLifeState2 = new KsLifeState("INITIALIZED", 1, amA8tU);
            INITIALIZED = ksLifeState2;
            KsLifeState ksLifeState3 = new KsLifeState("CREATED", 2, amA8tU);
            CREATED = ksLifeState3;
            KsLifeState ksLifeState4 = new KsLifeState("STARTED", 3, amA8tU);
            STARTED = ksLifeState4;
            KsLifeState ksLifeState5 = new KsLifeState("RESUMED", 4, amA8tU);
            RESUMED = ksLifeState5;
            $VALUES = new KsLifeState[]{ksLifeState, ksLifeState2, ksLifeState3, ksLifeState4, ksLifeState5};
            qwJc();
        }

        private KsLifeState(String str, int i, AmA8tU amA8tU) {
            this.mReal = amA8tU;
        }

        public static KsLifeState createFrom(AmA8tU amA8tU) {
            for (KsLifeState ksLifeState : values()) {
                if (ksLifeState.mReal == amA8tU) {
                    return ksLifeState;
                }
            }
            return null;
        }

        private static /* synthetic */ void qwJc() {
            char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 220);
            }
            String str = new String(charArray);
            char[] charArray2 = "¿°µ²µ¨".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 220);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static KsLifeState valueOf(String str) {
            return (KsLifeState) Enum.valueOf(KsLifeState.class, str);
        }

        public static KsLifeState[] values() {
            return (KsLifeState[]) $VALUES.clone();
        }

        public final boolean isAtLeast(KsLifeState ksLifeState) {
            return compareTo(ksLifeState) >= 0;
        }
    }

    public KsLifecycle(AzWtSf azWtSf) {
        this.mBase = azWtSf;
    }

    public void addObserver(final KsLifecycleObserver ksLifecycleObserver) {
        if (ksLifecycleObserver instanceof KsGenericLifecycleObserver) {
            B4ZgIw b4ZgIw = new B4ZgIw() { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                @Override // androidx.lifecycle.B4ZgIw
                public void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
                    ((KsGenericLifecycleObserver) ksLifecycleObserver).onStateChanged(KsLifeEvent.createfrom(alLFFp));
                }
            };
            ksLifecycleObserver.setBase(b4ZgIw);
            this.mBase.A2egSU(b4ZgIw);
        }
    }

    public KsLifeState getCurrentState() {
        return KsLifeState.createFrom(this.mBase.A4TApA());
    }

    public void removeObserver(KsLifecycleObserver ksLifecycleObserver) {
        this.mBase.A5SV6n(ksLifecycleObserver.getBase());
    }
}
