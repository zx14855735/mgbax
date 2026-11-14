package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw implements AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f11649AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B9tovu f11650AlLFFp;

    public B4ZgIw(B9tovu b9tovu, MaterialCalendarGridView materialCalendarGridView) {
        this.f11650AlLFFp = b9tovu;
        this.f11649AcNBzu = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MaterialCalendarGridView materialCalendarGridView = this.f11649AcNBzu;
        B3GDIM A2egSU2 = materialCalendarGridView.A2egSU();
        if (i < A2egSU2.A2egSU() || i > A2egSU2.A5SV6n()) {
            return;
        }
        if (materialCalendarGridView.A2egSU().getItem(i).longValue() >= this.f11650AlLFFp.f11655AmA8tU.f11594A2egSU.f11599AmA8tU.f11577AmA8tU.f11584AcNBzu) {
            throw null;
        }
    }
}
