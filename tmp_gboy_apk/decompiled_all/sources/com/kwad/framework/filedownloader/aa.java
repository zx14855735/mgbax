package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0332a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.yn() == -3) {
            Iterator<a.InterfaceC0332a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().yw().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0332a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().yw().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.yn()) {
            Iterator<a.InterfaceC0332a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().yw().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).yw().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            try {
                List<a.InterfaceC0332a> bL = h.yT().bL(messageSnapshot.getId());
                if (bL.size() > 0) {
                    a yv = bL.get(0).yv();
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(yv.yn()), Byte.valueOf(messageSnapshot.yn()), Integer.valueOf(bL.size()));
                    }
                    if (!a(bL, messageSnapshot)) {
                        StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.yn()) + " task-count:" + bL.size());
                        for (a.InterfaceC0332a interfaceC0332a : bL) {
                            sb.append(" | ");
                            sb.append((int) interfaceC0332a.yv().yn());
                        }
                        com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                    }
                } else {
                    com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.yn()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
