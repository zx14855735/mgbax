package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.connection.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13388a = "ConnectTrial";
    private static final Pattern i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
    private final com.sigmob.sdk.downloader.f b;
    private final com.sigmob.sdk.downloader.core.breakpoint.c c;
    private boolean d;
    private long e;
    private String f;
    private String g;
    private int h;

    static {
        kwARHL();
    }

    public c(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.b = fVar;
        this.c = cVar;
    }

    private static String a(String str) {
        String group;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = i.matcher(str);
            if (matcher.find()) {
                group = matcher.group(1);
            } else {
                Matcher matcher2 = j.matcher(str);
                group = matcher2.find() ? matcher2.group(1) : null;
            }
            if (group != null && group.contains("../")) {
                throw new com.sigmob.sdk.downloader.core.exception.a("The filename [" + group + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return group;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static long c(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.sigmob.sdk.downloader.core.c.a(f13388a, "parse instance length failed with ".concat(str));
            }
        }
        return -1L;
    }

    private static long d(a.InterfaceC0451a interfaceC0451a) {
        long c = c(interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.f));
        if (c != -1) {
            return c;
        }
        if (!b(interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.h))) {
            com.sigmob.sdk.downloader.core.c.a(f13388a, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    private static /* synthetic */ void kwARHL() {
        char[] charArray = "IEG\u0004MKGO\u0004HES\u0004YBOFF\u0004`DChXCNMO".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ '*');
        }
        String str = new String(charArray);
        char[] charArray2 = "IFCDC^".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ '*');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public long b() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return (this.c.k() == null || this.c.k().equals(this.f)) ? false : true;
    }

    public void i() {
        com.sigmob.sdk.downloader.core.connection.a a2 = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        com.sigmob.sdk.downloader.c a3 = com.sigmob.sdk.downloader.g.j().b().a();
        try {
            a2.a(com.sigmob.sdk.downloader.core.c.f13360a);
            Map<String, List<String>> b = this.b.b();
            if (b != null) {
                com.sigmob.sdk.downloader.core.c.a(b, a2);
            }
            a3.a(this.b, a2.c());
            a.InterfaceC0451a a4 = a2.a();
            a3.a(this.b, a4.d(), a4.f());
            this.e = com.sigmob.sdk.downloader.core.c.b(a4.c(com.sigmob.sdk.downloader.core.c.e));
            a2.b();
        } catch (Throwable th) {
            a2.b();
            throw th;
        }
    }

    private static String b(a.InterfaceC0451a interfaceC0451a) {
        return a(interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.j));
    }

    private static String c(a.InterfaceC0451a interfaceC0451a) {
        return interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.g);
    }

    public void a() {
        com.sigmob.sdk.downloader.g.j().g().b(this.b);
        com.sigmob.sdk.downloader.g.j().g().b();
        com.sigmob.sdk.downloader.core.connection.a a2 = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        try {
            if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) this.c.k())) {
                a2.a(com.sigmob.sdk.downloader.core.c.c, this.c.k());
            }
            a2.a(com.sigmob.sdk.downloader.core.c.b, "bytes=0-0");
            Map<String, List<String>> b = this.b.b();
            if (b != null) {
                com.sigmob.sdk.downloader.core.c.a(b, a2);
            }
            com.sigmob.sdk.downloader.c a3 = com.sigmob.sdk.downloader.g.j().b().a();
            a3.a(this.b, a2.c());
            a.InterfaceC0451a a4 = a2.a();
            this.b.a(a4.g());
            com.sigmob.sdk.downloader.core.c.b(f13388a, "task[" + this.b.c() + "] redirect location: " + this.b.j());
            this.h = a4.d();
            this.d = a(a4);
            this.e = d(a4);
            this.f = c(a4);
            this.g = b(a4);
            Map<String, List<String>> f = a4.f();
            if (f == null) {
                f = new HashMap<>();
            }
            a3.a(this.b, this.h, f);
            boolean a5 = a(this.e, a4);
            a2.b();
            if (a5) {
                i();
            }
        } catch (Throwable th) {
            a2.b();
            throw th;
        }
    }

    public boolean d() {
        return this.e == -1;
    }

    private static boolean b(String str) {
        return str != null && str.equals("chunked");
    }

    public boolean a(long j2, a.InterfaceC0451a interfaceC0451a) {
        String c;
        if (j2 != -1) {
            return false;
        }
        String c2 = interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.f);
        return (c2 == null || c2.length() <= 0) && !b(interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.h)) && (c = interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.e)) != null && c.length() > 0;
    }

    public boolean c() {
        return this.d;
    }

    private static boolean a(a.InterfaceC0451a interfaceC0451a) {
        if (interfaceC0451a.d() == 206) {
            return true;
        }
        return "bytes".equals(interfaceC0451a.c(com.sigmob.sdk.downloader.core.c.i));
    }
}
