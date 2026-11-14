package com.kwad.components.core.innerEc.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f {
    private final AtomicBoolean OO;
    private final String TAG;
    private final AtomicBoolean qZ;

    public static class a {
        private static final f RV = new f(0);

        static {
            LMKghj();
        }

        private static /* synthetic */ void LMKghj() {
            char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 212);
            }
            String str = new String(charArray);
            char[] charArray2 = "·¸½º½ ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 212);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    public static f qV() {
        return a.RV;
    }

    public final void eM() {
        h.qX().qZ();
        this.qZ.set(false);
    }

    public final void fb() {
        h.qX().qY();
        this.qZ.set(true);
    }

    private f() {
        this.TAG = "AuthHintManager";
        this.qZ = new AtomicBoolean();
        this.OO = new AtomicBoolean();
    }

    public final synchronized void a(final AdTemplate adTemplate, final j jVar) {
        if (!this.OO.get() && !this.qZ.get()) {
            com.kwad.sdk.core.d.c.d("AuthHintManager", "startLoadAuthHintCard");
            this.OO.set(true);
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.innerEc.a.f.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.a(adTemplate, new d() { // from class: com.kwad.components.core.innerEc.a.f.1.1
                        @Override // com.kwad.components.core.innerEc.a.d
                        public final void fZ() {
                            com.kwad.sdk.core.d.c.d("AuthHintManager", "onViewClose");
                            f.this.eM();
                        }

                        @Override // com.kwad.components.core.innerEc.a.d
                        public final void oB() {
                            j jVar2 = jVar;
                            if (jVar2 != null) {
                                jVar2.oB();
                            }
                        }

                        @Override // com.kwad.components.core.innerEc.a.d
                        public final void oX() {
                            com.kwad.sdk.core.d.c.d("AuthHintManager", "onViewShow");
                            f.this.fb();
                        }

                        @Override // com.kwad.components.core.innerEc.a.d
                        public final void qT() {
                            j jVar2 = jVar;
                            if (jVar2 != null) {
                                jVar2.qO();
                            }
                            f.this.qZ.set(false);
                        }
                    });
                    f.this.OO.set(false);
                }
            });
            return;
        }
        com.kwad.sdk.core.d.c.d("AuthHintManager", "mLoadDisable: " + this.qZ.get() + ", mLoadDisable: " + this.OO.get());
    }
}
