package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn extends BI9f7h {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final JobInfo f8498ADYaiT;
    public final JobScheduler AMqCpz;

    public BChYOn(Context context, ComponentName componentName, int i) {
        super(componentName);
        A4TApA(i);
        this.f8498ADYaiT = new JobInfo.Builder(i, componentName).setOverrideDeadline(0L).build();
        this.AMqCpz = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // androidx.core.app.BI9f7h
    public final void A2egSU(Intent intent) {
        this.AMqCpz.enqueue(this.f8498ADYaiT, P8ccfD.A2egSU.A5SV6n(intent));
    }
}
