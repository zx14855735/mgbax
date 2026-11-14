package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.method.MetaKeyKeyListener;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZkASS f8669A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AZOQYO.ARc23Z f8670A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ARc23Z f8671A5SV6n;

    public B4ZgIw(AZOQYO.ARc23Z aRc23Z, AZkASS aZkASS, ARc23Z aRc23Z2, Set set) {
        this.f8669A2egSU = aZkASS;
        this.f8670A4TApA = aRc23Z;
        this.f8671A5SV6n = aRc23Z2;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            A5SV6n(str, 0, str.length(), 1, true, new IQ76hF.AmA8tU(28, str));
        }
    }

    public static boolean A2egSU(Editable editable, int i, KeyEvent keyEvent) {
        if (!(i != 67 ? i != 112 ? false : delete(editable, keyEvent, true) : delete(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        BPw6Q8[] bPw6Q8Arr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (bPw6Q8Arr = (BPw6Q8[]) editable.getSpans(selectionStart, selectionEnd, BPw6Q8.class)) != null && bPw6Q8Arr.length > 0) {
                for (BPw6Q8 bPw6Q8 : bPw6Q8Arr) {
                    int spanStart = editable.getSpanStart(bPw6Q8);
                    int spanEnd = editable.getSpanEnd(bPw6Q8);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        if (r6 >= r7) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A4TApA(java.lang.CharSequence r10, int r11, int r12, androidx.emoji2.text.BNL6CD r13) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.B4ZgIw.A4TApA(java.lang.CharSequence, int, int, androidx.emoji2.text.BNL6CD):boolean");
    }

    public final Object A5SV6n(CharSequence charSequence, int i, int i2, int i3, boolean z, B3GDIM b3gdim) {
        char c;
        BI9f7h bI9f7h = (BI9f7h) this.f8670A4TApA.f365AmA8tU;
        QgOIY0.B25kr6 b25kr6 = new QgOIY0.B25kr6();
        b25kr6.f7545A2egSU = 1;
        b25kr6.f7548ADYaiT = bI9f7h;
        b25kr6.AMqCpz = bI9f7h;
        int i4 = i;
        int codePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean z2 = true;
        int i6 = i4;
        while (i6 < i2 && i5 < i3 && z2) {
            SparseArray sparseArray = ((BI9f7h) b25kr6.AMqCpz).f8681A2egSU;
            BI9f7h bI9f7h2 = sparseArray == null ? null : (BI9f7h) sparseArray.get(codePointAt);
            if (b25kr6.f7545A2egSU == 2) {
                if (bI9f7h2 != null) {
                    b25kr6.AMqCpz = bI9f7h2;
                    b25kr6.f7547A5SV6n++;
                } else {
                    if (codePointAt == 65038) {
                        b25kr6.A2egSU();
                    } else if (codePointAt != 65039) {
                        BI9f7h bI9f7h3 = (BI9f7h) b25kr6.AMqCpz;
                        if (bI9f7h3.f8682A4TApA != null) {
                            if (b25kr6.f7547A5SV6n != 1) {
                                b25kr6.f7549ARc23Z = bI9f7h3;
                                b25kr6.A2egSU();
                            } else if (b25kr6.A4TApA()) {
                                b25kr6.f7549ARc23Z = (BI9f7h) b25kr6.AMqCpz;
                                b25kr6.A2egSU();
                            } else {
                                b25kr6.A2egSU();
                            }
                            c = 3;
                        } else {
                            b25kr6.A2egSU();
                        }
                    }
                    c = 1;
                }
                c = 2;
            } else if (bI9f7h2 == null) {
                b25kr6.A2egSU();
                c = 1;
            } else {
                b25kr6.f7545A2egSU = 2;
                b25kr6.AMqCpz = bI9f7h2;
                b25kr6.f7547A5SV6n = 1;
                c = 2;
            }
            b25kr6.f7546A4TApA = codePointAt;
            if (c == 1) {
                i6 = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                if (i6 < i2) {
                    codePointAt = Character.codePointAt(charSequence, i6);
                }
            } else if (c == 2) {
                int charCount = Character.charCount(codePointAt) + i6;
                if (charCount < i2) {
                    codePointAt = Character.codePointAt(charSequence, charCount);
                }
                i6 = charCount;
            } else if (c == 3) {
                if (z || !A4TApA(charSequence, i4, i6, ((BI9f7h) b25kr6.f7549ARc23Z).f8682A4TApA)) {
                    z2 = b3gdim.AYUAbz(charSequence, i4, i6, ((BI9f7h) b25kr6.f7549ARc23Z).f8682A4TApA);
                    i5++;
                }
            }
            i4 = i6;
        }
        if (b25kr6.f7545A2egSU == 2 && ((BI9f7h) b25kr6.AMqCpz).f8682A4TApA != null && ((b25kr6.f7547A5SV6n > 1 || b25kr6.A4TApA()) && i5 < i3 && z2 && (z || !A4TApA(charSequence, i4, i6, ((BI9f7h) b25kr6.AMqCpz).f8682A4TApA)))) {
            b3gdim.AYUAbz(charSequence, i4, i6, ((BI9f7h) b25kr6.AMqCpz).f8682A4TApA);
        }
        return b3gdim.getResult();
    }
}
