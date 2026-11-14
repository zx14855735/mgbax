package com.sigmob.sdk.base.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ap;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.windad.WindAds;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static final b f13116a = new b() { // from class: com.sigmob.sdk.base.common.ao.1
        @Override // com.sigmob.sdk.base.common.ao.b
        public void a(String str, an anVar) {
        }

        @Override // com.sigmob.sdk.base.common.ao.b
        public void b(String str, an anVar) {
        }
    };
    private static final c b = new c() { // from class: com.sigmob.sdk.base.common.ao.2
        @Override // com.sigmob.sdk.base.common.ao.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ao.c
        public void b() {
        }

        @Override // com.sigmob.sdk.base.common.ao.c
        public void c() {
        }
    };
    private final EnumSet<an> c;
    private final b d;
    private final b e;
    private final c f;
    private final BaseAdUnit g;
    private final boolean h;
    private boolean i;
    private boolean j;
    private boolean k;

    /* renamed from: com.sigmob.sdk.base.common.ao$3, reason: invalid class name */
    public class AnonymousClass3 implements ap.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ an f13117a;
        final /* synthetic */ Context b;
        final /* synthetic */ ao c;
        final /* synthetic */ Uri d;
        final /* synthetic */ String e;

        public AnonymousClass3(an anVar, Context context, ao aoVar, Uri uri, String str) {
            this.f13117a = anVar;
            this.b = context;
            this.c = aoVar;
            this.d = uri;
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, an anVar) {
            try {
                ao.this.d.a(str, anVar);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, an anVar) {
            try {
                ao.this.d.b(str, anVar);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, an anVar) {
            try {
                ao.this.d.a(str, anVar);
            } catch (Throwable unused) {
            }
        }

        @Override // com.sigmob.sdk.base.common.ap.a
        public void a(String str) {
            an anVar = this.f13117a;
            if (!str.toLowerCase().startsWith(Constants.HTTP)) {
                anVar = an.FOLLOW_DEEP_LINK;
            }
            try {
                anVar.a(this.b, Uri.parse(str), this.c, ao.this.g);
                WindAds.sharedAds().getHandler().post(new ASJ6gh(this, str, anVar, 2));
            } catch (Exception unused) {
                WindAds.sharedAds().getHandler().post(new ASJ6gh(this, str, anVar, 3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, an anVar) {
            try {
                ao.this.d.b(str, anVar);
            } catch (Throwable unused) {
            }
        }

        @Override // com.sigmob.sdk.base.common.ap.a
        public void a(String str, Throwable th) {
            try {
                this.f13117a.a(this.b, this.d, this.c, ao.this.g);
                WindAds.sharedAds().getHandler().post(new ASJ6gh(this, this.e, this.f13117a, 0));
            } catch (Exception unused) {
                WindAds.sharedAds().getHandler().post(new ASJ6gh(this, this.e, this.f13117a, 1));
            }
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private EnumSet<an> f13119a = EnumSet.of(an.NOOP);
        private b b = ao.f13116a;
        private b c = ao.f13116a;
        private c d = ao.b;
        private boolean e = false;
        private boolean f = false;
        private BaseAdUnit g;

        public a a(an anVar, an... anVarArr) {
            this.f13119a = EnumSet.of(anVar, anVarArr);
            return this;
        }

        public a b(b bVar) {
            this.c = bVar;
            return this;
        }

        public a a(b bVar) {
            this.b = bVar;
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(BaseAdUnit baseAdUnit) {
            this.g = baseAdUnit;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public ao a() {
            return new ao(this.f13119a, this.b, this.c, this.d, this.e, this.g, this.f);
        }
    }

    public interface b {
        void a(String str, an anVar);

        void b(String str, an anVar);
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    static {
        aIlfLej();
    }

    private ao(EnumSet<an> enumSet, b bVar, b bVar2, c cVar, boolean z, BaseAdUnit baseAdUnit, boolean z2) {
        this.c = EnumSet.copyOf((EnumSet) enumSet);
        this.d = bVar;
        this.e = bVar2;
        this.f = cVar;
        this.h = z;
        this.g = baseAdUnit;
        this.i = false;
        this.j = false;
        this.k = z2;
    }

    private static /* synthetic */ void aIlfLej() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public c a() {
        return this.f;
    }

    public boolean b() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.sigmob.sdk.base.common.ao] */
    private boolean b(Context context, String str) {
        Context context2;
        ao aoVar;
        Uri parse;
        AndroidMarket androidMarket;
        an anVar = an.NOOP;
        Iterator it = this.c.iterator();
        String str2 = null;
        while (it.hasNext()) {
            final an anVar2 = (an) it.next();
            String a2 = anVar2.a(this.g);
            ?? r6 = r6;
            if (!TextUtils.isEmpty(str)) {
                r6 = 7;
                r6 = 7;
                if (this.g.getInteractionType() != 7) {
                    a2 = str;
                }
            }
            if (TextUtils.isEmpty(a2)) {
                r6 = this;
                context2 = context;
            } else {
                final String macroProcess = this.g.getMacroCommon().macroProcess(a2);
                try {
                    parse = Uri.parse(macroProcess);
                    androidMarket = this.g.getAndroidMarket();
                } catch (Throwable unused) {
                    r6 = this;
                    context2 = context;
                }
                if (anVar2 == an.FOLLOW_DEEP_LINK && parse.getScheme().equalsIgnoreCase(BaseConstants.SCHEME_MARKET) && androidMarket != null && !TextUtils.isEmpty(androidMarket.market_url)) {
                    str2 = macroProcess;
                } else if (anVar2.a(parse, this.g.getInteractionType())) {
                    try {
                        if (this.k || an.OPEN_WITH_BROWSER != anVar2) {
                            ao aoVar2 = this;
                            context2 = context;
                            anVar2.a(context2, parse, this, aoVar2.g);
                            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.ao.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    ao.this.d.a(macroProcess, anVar2);
                                }
                            });
                            r6 = aoVar2;
                        } else {
                            ao aoVar3 = this;
                            context2 = context;
                            ap.a(macroProcess, aoVar3.new AnonymousClass3(anVar2, context2, this, parse, macroProcess));
                            r6 = aoVar3;
                        }
                        return true;
                    } catch (Throwable unused2) {
                        r6.d.b(macroProcess, anVar2);
                        aoVar = r6;
                        str2 = macroProcess;
                        r6 = aoVar;
                        context = context2;
                    }
                } else {
                    aoVar = this;
                    context2 = context;
                    str2 = macroProcess;
                    r6 = aoVar;
                }
            }
            context = context2;
        }
        try {
            a(str2, anVar, "Link ignored. Unable to handle url: ", null);
            return false;
        } catch (Throwable th) {
            SigmobLog.e("handleResolvedUrl eroor", th);
            return false;
        }
    }

    public void a(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        b(context, str);
    }

    private void a(String str, an anVar, String str2, Throwable th) {
        Preconditions.NoThrow.checkNotNull(str2);
        if (anVar == null) {
            anVar = an.NOOP;
        }
        SigmobLog.d(str2, th);
        this.d.b(str, anVar);
    }
}
