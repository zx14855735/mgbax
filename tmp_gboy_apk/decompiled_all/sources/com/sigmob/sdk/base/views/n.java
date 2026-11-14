package com.sigmob.sdk.base.views;

import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f13310a = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/gif");
    private static final List<String> b = Arrays.asList("application/x-javascript");
    private static final long serialVersionUID = 0;
    private final String c;
    private final b d;
    private final a e;
    private final int f;
    private final int g;

    /* renamed from: com.sigmob.sdk.base.views.n$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13311a;

        static {
            int[] iArr = new int[b.values().length];
            f13311a = iArr;
            try {
                iArr[b.IFRAME_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13311a[b.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13311a[b.STATIC_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13311a[b.NATIVE_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13311a[b.URL_RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum a {
        NONE,
        IMAGE,
        JAVASCRIPT;

        static {
            ZHRJk();
        }

        private static /* synthetic */ void ZHRJk() {
            char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 153);
            }
            String str = new String(charArray);
            char[] charArray2 = "úõð÷ðí".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 153);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum b {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE,
        NATIVE_RESOURCE,
        URL_RESOURCE;

        static {
            mRMC();
        }

        private static /* synthetic */ void mRMC() {
            char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'i');
            }
            String str = new String(charArray);
            char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'i');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        FUWJN();
    }

    public n(String str, b bVar, a aVar, int i, int i2) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(bVar);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.c = str;
        this.d = bVar;
        this.e = aVar;
        this.f = i;
        this.g = i2;
    }

    private static /* synthetic */ void FUWJN() {
        char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 1);
        }
        String str = new String(charArray);
        char[] charArray2 = "bmhohu".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 1);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String a() {
        return this.c;
    }

    public b b() {
        return this.d;
    }

    public a c() {
        return this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0 != 5) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int[] r0 = com.sigmob.sdk.base.views.n.AnonymousClass1.f13311a
            com.sigmob.sdk.base.views.n$b r1 = r5.d
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            java.lang.String r2 = "CreativeType.JAVASCRIPT"
            java.lang.String r3 = "CreativeType.IMAGE"
            r4 = 0
            if (r0 == r1) goto L38
            r1 = 2
            if (r0 == r1) goto L38
            r1 = 3
            if (r0 == r1) goto L1f
            r1 = 4
            if (r0 == r1) goto L38
            r1 = 5
            if (r0 == r1) goto L38
            goto L51
        L1f:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L2f
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L47
            return r7
        L2f:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            if (r6 != r1) goto L37
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L37:
            return r4
        L38:
            com.sigmob.sdk.base.views.n$a r0 = com.sigmob.sdk.base.views.n.a.IMAGE
            com.sigmob.sdk.base.views.n$a r1 = r5.e
            if (r0 != r1) goto L49
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L48
        L47:
            return r6
        L48:
            return r4
        L49:
            com.sigmob.sdk.base.views.n$a r6 = com.sigmob.sdk.base.views.n.a.JAVASCRIPT
            if (r6 != r1) goto L51
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.n.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public void a(o oVar) {
        Preconditions.NoThrow.checkNotNull(oVar);
        int i = AnonymousClass1.f13311a[this.d.ordinal()];
        if (i == 1) {
            oVar.a("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.f + "\" height=\"" + this.g + "\" src=\"" + this.c + "\"></iframe>");
            return;
        }
        if (i == 2) {
            oVar.a(this.c);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                oVar.loadUrl(this.c);
                return;
            } else {
                if (this.c.toLowerCase().startsWith("file://")) {
                    oVar.loadUrl(this.c);
                    return;
                }
                oVar.loadUrl("file://" + this.c);
                return;
            }
        }
        a aVar = this.e;
        if (aVar == a.IMAGE) {
            oVar.a("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.c + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>");
            return;
        }
        if (aVar == a.JAVASCRIPT) {
            oVar.a("<script src=\"" + this.c + "\"></script>");
        }
    }
}
