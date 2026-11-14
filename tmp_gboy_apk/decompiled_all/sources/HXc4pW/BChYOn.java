package HXc4pW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn implements Appendable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Appendable f3611AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f3612AlLFFp = true;

    public BChYOn(Appendable appendable) {
        this.f3611AcNBzu = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        boolean z = this.f3612AlLFFp;
        Appendable appendable = this.f3611AcNBzu;
        if (z) {
            this.f3612AlLFFp = false;
            appendable.append("  ");
        }
        this.f3612AlLFFp = c == '\n';
        appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z = this.f3612AlLFFp;
        Appendable appendable = this.f3611AcNBzu;
        boolean z2 = false;
        if (z) {
            this.f3612AlLFFp = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
            z2 = true;
        }
        this.f3612AlLFFp = z2;
        appendable.append(charSequence, i, i2);
        return this;
    }
}
