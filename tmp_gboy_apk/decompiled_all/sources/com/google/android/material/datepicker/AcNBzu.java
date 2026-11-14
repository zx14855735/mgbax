package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ B9tovu f11596A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f11597A4TApA;

    public AcNBzu(AlLFFp alLFFp, B9tovu b9tovu) {
        this.f11597A4TApA = alLFFp;
        this.f11596A2egSU = b9tovu;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        AlLFFp alLFFp = this.f11597A4TApA;
        int findFirstVisibleItemPosition = i < 0 ? ((LinearLayoutManager) alLFFp.f11605B7CMnp.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) alLFFp.f11605B7CMnp.getLayoutManager()).findLastVisibleItemPosition();
        A4TApA a4TApA = this.f11596A2egSU.f11653AcNBzu;
        Calendar A2egSU2 = BTvldC.A2egSU(a4TApA.f11575AcNBzu.f11638AcNBzu);
        A2egSU2.add(2, findFirstVisibleItemPosition);
        B2KMhB b2KMhB = new B2KMhB(A2egSU2);
        alLFFp.f11601B25kr6 = b2KMhB;
        MaterialButton materialButton = alLFFp.f11610BJ7GGh;
        Calendar A2egSU3 = BTvldC.A2egSU(a4TApA.f11575AcNBzu.f11638AcNBzu);
        A2egSU3.add(2, findFirstVisibleItemPosition);
        A2egSU3.set(5, 1);
        Calendar A2egSU4 = BTvldC.A2egSU(A2egSU3);
        A2egSU4.get(2);
        A2egSU4.get(1);
        A2egSU4.getMaximum(7);
        A2egSU4.getActualMaximum(5);
        A2egSU4.getTimeInMillis();
        long timeInMillis = A2egSU4.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = BTvldC.f11658A2egSU;
            instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            timeZone = TimeZone.getTimeZone("UTC");
            instanceForSkeleton.setTimeZone(timeZone);
            unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            formatDateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            formatDateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        materialButton.setText(formatDateTime);
        alLFFp.AlLFFp(a4TApA.f11575AcNBzu.ADYaiT(b2KMhB));
    }
}
