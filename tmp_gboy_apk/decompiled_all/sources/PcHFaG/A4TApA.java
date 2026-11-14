package PcHFaG;

import Oay4Bh.BmvVmW;
import Oay4Bh.BniPrB;
import P3rngT.AMqCpz;
import PCV8se.AYUAbz;
import PCV8se.AaHO0E;
import PCV8se.AmA8tU;
import PCV8se.B2KMhB;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends AaHO0E implements BmvVmW {

    /* renamed from: CmUvjW, reason: collision with root package name */
    public CharSequence f7409CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public final Context f7410CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public final Paint.FontMetrics f7411CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public final BniPrB f7412CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public final A2egSU f7413CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public final Rect f7414D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public int f7415D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public int f7416D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public int f7417D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f7418D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public boolean f7419D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public int f7420DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f7421DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public float f7422DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public float f7423DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public float f7424DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public float f7425DXnQ0V;
    public float DXuj49;

    public A4TApA(Context context, int i) {
        super(context, null, 0, i);
        this.f7411CrfGsy = new Paint.FontMetrics();
        BniPrB bniPrB = new BniPrB(this);
        this.f7412CtFAbx = bniPrB;
        this.f7413CtxOCS = new A2egSU(this);
        this.f7414D07BeM = new Rect();
        this.f7422DRlcZ9 = 1.0f;
        this.f7423DUi7mC = 1.0f;
        this.f7424DV2E8K = 0.5f;
        this.f7425DXnQ0V = 0.5f;
        this.DXuj49 = 1.0f;
        this.f7410CqNSpT = context;
        TextPaint textPaint = bniPrB.f6599A2egSU;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public final float BmvVmW() {
        int i;
        Rect rect = this.f7414D07BeM;
        if (((rect.right - getBounds().right) - this.f7421DG07BK) - this.f7418D8cQ8b < 0) {
            i = ((rect.right - getBounds().right) - this.f7421DG07BK) - this.f7418D8cQ8b;
        } else {
            if (((rect.left - getBounds().left) - this.f7421DG07BK) + this.f7418D8cQ8b <= 0) {
                return 0.0f;
            }
            i = ((rect.left - getBounds().left) - this.f7421DG07BK) + this.f7418D8cQ8b;
        }
        return i;
    }

    public final AmA8tU BniPrB() {
        float f = -BmvVmW();
        float width = (float) ((getBounds().width() - (Math.sqrt(2.0d) * this.f7420DAk1zC)) / 2.0d);
        return new AmA8tU(new AYUAbz(this.f7420DAk1zC), Math.min(Math.max(f, -width), width));
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float BmvVmW2 = BmvVmW();
        float f = (float) (-((Math.sqrt(2.0d) * this.f7420DAk1zC) - this.f7420DAk1zC));
        canvas.scale(this.f7422DRlcZ9, this.f7423DUi7mC, (getBounds().width() * this.f7424DV2E8K) + getBounds().left, (getBounds().height() * this.f7425DXnQ0V) + getBounds().top);
        canvas.translate(BmvVmW2, f);
        super.draw(canvas);
        if (this.f7409CmUvjW == null) {
            canvas2 = canvas;
        } else {
            float centerY = getBounds().centerY();
            BniPrB bniPrB = this.f7412CtFAbx;
            TextPaint textPaint = bniPrB.f6599A2egSU;
            Paint.FontMetrics fontMetrics = this.f7411CrfGsy;
            textPaint.getFontMetrics(fontMetrics);
            int i = (int) (centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            AMqCpz aMqCpz = bniPrB.f6604ASJ6gh;
            TextPaint textPaint2 = bniPrB.f6599A2egSU;
            if (aMqCpz != null) {
                textPaint2.drawableState = getState();
                bniPrB.f6604ASJ6gh.ADYaiT(this.f7410CqNSpT, textPaint2, bniPrB.f6600A4TApA);
                textPaint2.setAlpha((int) (this.DXuj49 * 255.0f));
            }
            CharSequence charSequence = this.f7409CmUvjW;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i, textPaint2);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.f7412CtFAbx.f6599A2egSU.getTextSize(), this.f7417D8MqeW);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f = this.f7415D6DOie * 2;
        CharSequence charSequence = this.f7409CmUvjW;
        return (int) Math.max(f + (charSequence == null ? 0.0f : this.f7412CtFAbx.A2egSU(charSequence.toString())), this.f7416D6yqiO);
    }

    @Override // PCV8se.AaHO0E, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f7419D9tr6l) {
            B2KMhB.A2egSU ASJ6gh2 = this.f7042AlLFFp.f7021A2egSU.ASJ6gh();
            ASJ6gh2.f7103AaHO0E = BniPrB();
            setShapeAppearanceModel(ASJ6gh2.A2egSU());
        }
    }
}
