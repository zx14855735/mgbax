package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU implements TextWatcher, SpanWatcher {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f8683AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AtomicInteger f8684AlLFFp = new AtomicInteger(0);

    public BIYEnU(Object obj) {
        this.f8683AcNBzu = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f8683AcNBzu).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.f8683AcNBzu).beforeTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (this.f8684AlLFFp.get() <= 0 || !(obj instanceof BPw6Q8)) {
            ((SpanWatcher) this.f8683AcNBzu).onSpanAdded(spannable, obj, i, i2);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.f8684AlLFFp.get() <= 0 || !(obj instanceof BPw6Q8)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (i > i2) {
                    i = 0;
                }
                if (i3 > i4) {
                    i5 = i;
                    i6 = 0;
                    ((SpanWatcher) this.f8683AcNBzu).onSpanChanged(spannable, obj, i5, i2, i6, i4);
                }
            }
            i5 = i;
            i6 = i3;
            ((SpanWatcher) this.f8683AcNBzu).onSpanChanged(spannable, obj, i5, i2, i6, i4);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (this.f8684AlLFFp.get() <= 0 || !(obj instanceof BPw6Q8)) {
            ((SpanWatcher) this.f8683AcNBzu).onSpanRemoved(spannable, obj, i, i2);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.f8683AcNBzu).onTextChanged(charSequence, i, i2, i3);
    }
}
