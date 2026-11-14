package AaHO0E;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F1loUV implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f811AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ FM663C f812AlLFFp;

    public /* synthetic */ F1loUV(FM663C fm663c, int i) {
        this.f811AcNBzu = i;
        this.f812AlLFFp = fm663c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f811AcNBzu) {
            case 0:
                EdQ5bb edQ5bb = this.f812AlLFFp.f823AmA8tU;
                if (edQ5bb != null) {
                    edQ5bb.setListSelectionHidden(true);
                    edQ5bb.requestLayout();
                    break;
                }
                break;
            default:
                FM663C fm663c = this.f812AlLFFp;
                EdQ5bb edQ5bb2 = fm663c.f823AmA8tU;
                if (edQ5bb2 != null && edQ5bb2.isAttachedToWindow() && fm663c.f823AmA8tU.getCount() > fm663c.f823AmA8tU.getChildCount() && fm663c.f823AmA8tU.getChildCount() <= fm663c.f833BIYEnU) {
                    fm663c.f845COJEAR.setInputMethodMode(2);
                    fm663c.show();
                    break;
                }
                break;
        }
    }
}
