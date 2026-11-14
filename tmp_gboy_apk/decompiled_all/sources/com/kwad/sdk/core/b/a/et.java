package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class et {
    @InvokeBy(invokerClass = gu.class, methodId = "registerHolder")
    public static void Je() {
        gu.Jf().put(JavaBackTraceElement.class, new gs());
        gu.Jf().put(com.kwad.sdk.crash.online.monitor.a.b.class, new ei());
        gu.Jf().put(Backtrace.class, new bw());
        gu.Jf().put(AnrReason.class, new bi());
        gu.Jf().put(com.kwad.sdk.crash.model.b.class, new ee());
        gu.Jf().put(com.kwad.sdk.crash.online.monitor.a.c.class, new hp());
        gu.Jf().put(NativeBackTraceElement.class, new hw());
        gu.Jf().put(com.kwad.sdk.crash.online.monitor.a.a.class, new ca());
        gu.Jf().put(com.kwad.sdk.crash.online.monitor.block.d.class, new cc());
        gu.Jf().put(BlockEvent.class, new cb());
        gu.Jf().put(com.kwad.sdk.crash.a.class, new dg());
        gu.Jf().put(BlockEvent.a.class, new lv());
        gu.Jf().put(BackTraceElement.class, new bv());
    }
}
