package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu extends JobServiceEngine implements B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BIYEnU f8495A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f8496A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public JobParameters f8497A5SV6n;

    public B9tovu(BIYEnU bIYEnU) {
        super(bIYEnU);
        this.f8496A4TApA = new Object();
        this.f8495A2egSU = bIYEnU;
    }

    public final B7CMnp A2egSU() {
        JobWorkItem dequeueWork;
        Intent intent;
        synchronized (this.f8496A4TApA) {
            JobParameters jobParameters = this.f8497A5SV6n;
            if (jobParameters == null) {
                return null;
            }
            dequeueWork = jobParameters.dequeueWork();
            if (dequeueWork == null) {
                return null;
            }
            intent = dequeueWork.getIntent();
            intent.setExtrasClassLoader(this.f8495A2egSU.getClassLoader());
            return new B7CMnp(this, dequeueWork);
        }
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStartJob(JobParameters jobParameters) {
        this.f8497A5SV6n = jobParameters;
        this.f8495A2egSU.ensureProcessorRunningLocked(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean doStopCurrentWork = this.f8495A2egSU.doStopCurrentWork();
        synchronized (this.f8496A4TApA) {
            this.f8497A5SV6n = null;
        }
        return doStopCurrentWork;
    }
}
