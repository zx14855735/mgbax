package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp implements B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final JobWorkItem f8493A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ B9tovu f8494A4TApA;

    public B7CMnp(B9tovu b9tovu, JobWorkItem jobWorkItem) {
        this.f8494A4TApA = b9tovu;
        this.f8493A2egSU = jobWorkItem;
    }

    @Override // androidx.core.app.B4ZgIw
    public final void complete() {
        synchronized (this.f8494A4TApA.f8496A4TApA) {
            try {
                JobParameters jobParameters = this.f8494A4TApA.f8497A5SV6n;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.f8493A2egSU);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.core.app.B4ZgIw
    public final Intent getIntent() {
        Intent intent;
        intent = this.f8493A2egSU.getIntent();
        return intent;
    }
}
