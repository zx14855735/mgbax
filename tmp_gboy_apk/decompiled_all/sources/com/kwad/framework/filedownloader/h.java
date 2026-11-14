package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h {
    private final ArrayList<a.InterfaceC0332a> aqb;

    public static final class a {
        private static final h aqc = new h(0);

        static {
            KxmVnti();
        }

        private static /* synthetic */ void KxmVnti() {
            char[] charArray = "FJH\u000bBDH@\u000bGJ\\\u000bVM@II\u000boKLgWLAB@".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '%');
            }
            String str = new String(charArray);
            char[] charArray2 = "FILKLQ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '%');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h yT() {
        return a.aqc;
    }

    public final boolean a(a.InterfaceC0332a interfaceC0332a) {
        return this.aqb.isEmpty() || !this.aqb.contains(interfaceC0332a);
    }

    public final void b(a.InterfaceC0332a interfaceC0332a) {
        if (!interfaceC0332a.yv().yg()) {
            interfaceC0332a.yy();
        }
        if (interfaceC0332a.yw().yL().yY()) {
            c(interfaceC0332a);
        }
    }

    public final int bK(int i) {
        int i2;
        synchronized (this.aqb) {
            try {
                Iterator<a.InterfaceC0332a> it = this.aqb.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (it.next().bJ(i)) {
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public final List<a.InterfaceC0332a> bL(int i) {
        byte yn;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aqb) {
            try {
                Iterator<a.InterfaceC0332a> it = this.aqb.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0332a next = it.next();
                    if (next.bJ(i) && !next.isOver() && (yn = next.yv().yn()) != 0 && yn != 10) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final List<a.InterfaceC0332a> bM(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aqb) {
            try {
                Iterator<a.InterfaceC0332a> it = this.aqb.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0332a next = it.next();
                    if (next.bJ(i) && !next.isOver()) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0332a interfaceC0332a) {
        if (interfaceC0332a.yz()) {
            return;
        }
        synchronized (this.aqb) {
            try {
                if (this.aqb.contains(interfaceC0332a)) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0332a);
                } else {
                    interfaceC0332a.yA();
                    this.aqb.add(interfaceC0332a);
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0332a, Byte.valueOf(interfaceC0332a.yv().yn()), Integer.valueOf(this.aqb.size()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(List<a.InterfaceC0332a> list) {
        synchronized (this.aqb) {
            try {
                Iterator<a.InterfaceC0332a> it = this.aqb.iterator();
                while (it.hasNext()) {
                    a.InterfaceC0332a next = it.next();
                    if (!list.contains(next)) {
                        list.add(next);
                    }
                }
                this.aqb.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int size() {
        return this.aqb.size();
    }

    private h() {
        this.aqb = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0332a interfaceC0332a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte yn = messageSnapshot.yn();
        synchronized (this.aqb) {
            remove = this.aqb.remove(interfaceC0332a);
        }
        if (com.kwad.framework.filedownloader.f.d.atL && this.aqb.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0332a, Byte.valueOf(yn), Integer.valueOf(this.aqb.size()));
        }
        if (!remove) {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0332a, Byte.valueOf(yn));
            return remove;
        }
        t yL = interfaceC0332a.yw().yL();
        if (yn == -4) {
            yL.l(messageSnapshot);
            return remove;
        }
        if (yn == -3) {
            yL.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            return remove;
        }
        if (yn == -2) {
            yL.n(messageSnapshot);
            return remove;
        }
        if (yn != -1) {
            return remove;
        }
        yL.m(messageSnapshot);
        return remove;
    }
}
