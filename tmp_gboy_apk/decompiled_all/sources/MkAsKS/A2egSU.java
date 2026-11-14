package MkAsKS;

import LLiCI0.BChYOn;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.activity.LayoutEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f5418AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Paint f5419AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Bitmap f5420AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BChYOn f5421AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public ADYaiT f5422B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public A5SV6n f5423B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f5424B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ASJ6gh f5425B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public ARc23Z f5426B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Paint f5427B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f5428BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public float f5429BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public float f5430BIYEnU;

    public A2egSU(LayoutEditor layoutEditor) {
        super(layoutEditor);
        this.f5428BChYOn = true;
        this.f5418AcNBzu = new ArrayList();
        Paint paint = new Paint();
        this.f5419AlLFFp = paint;
        this.f5424B3GDIM = 4;
        paint.setFilterBitmap(true);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-16711936);
        int i = (int) (layoutEditor.getResources().getDisplayMetrics().density * 56.0f);
        Drawable A4TApA2 = BPw6Q8.A2egSU.A4TApA(layoutEditor, 2131231508);
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        A4TApA2.setBounds(0, 0, i, i);
        A4TApA2.draw(canvas);
        this.f5420AmA8tU = createBitmap;
        Paint paint2 = new Paint();
        this.f5427B9tovu = paint2;
        paint2.setColor(Color.argb(100, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS));
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(style);
    }

    public static int A2egSU(A2egSU a2egSU, int i, int i2) {
        a2egSU.getClass();
        if (i < 0) {
            i = 0;
        }
        if (i > i2) {
            i = i2;
        }
        int i3 = a2egSU.f5424B3GDIM;
        if (i3 <= 0) {
            i3 = 1;
        }
        int i4 = i % i3;
        return Math.max(0, Math.min(i4 > i3 / 2 ? (i3 - i4) + i : i - i4, i2));
    }

    public final void A4TApA(ADYaiT aDYaiT) {
        invalidate(aDYaiT.f5434A5SV6n);
        if (aDYaiT == this.f5422B25kr6) {
            invalidate((Rect) this.f5421AzWtSf.AMqCpz);
        }
    }

    public List<ADYaiT> getAllItems() {
        return this.f5418AcNBzu;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        A4TApA a4TApA = new A4TApA();
        a4TApA.f5431A2egSU = this.f5422B25kr6;
        return a4TApA;
    }

    public ADYaiT getCurrentItem() {
        return this.f5422B25kr6;
    }

    public int getGridSize() {
        return this.f5424B3GDIM;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        if (this.f5428BChYOn) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    paint2 = this.f5427B9tovu;
                    if (i2 > height) {
                        break;
                    }
                    float f = i2;
                    canvas.drawLine(0.0f, f, width, f, paint2);
                    i2 += this.f5424B3GDIM;
                }
                while (i <= width) {
                    float f2 = i;
                    canvas.drawLine(f2, 0.0f, f2, height, paint2);
                    i += this.f5424B3GDIM;
                }
            }
        }
        Iterator it = this.f5418AcNBzu.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            paint = this.f5419AlLFFp;
            if (!hasNext) {
                break;
            }
            ADYaiT aDYaiT = (ADYaiT) it.next();
            canvas.drawBitmap(aDYaiT.f5433A4TApA, (Rect) null, aDYaiT.f5434A5SV6n, paint);
        }
        ADYaiT aDYaiT2 = this.f5422B25kr6;
        if (aDYaiT2 != null) {
            Rect rect = aDYaiT2.f5434A5SV6n;
            canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
            BChYOn bChYOn = this.f5421AzWtSf;
            if (bChYOn != null) {
                Rect rect2 = (Rect) bChYOn.AMqCpz;
                canvas.drawBitmap((Bitmap) bChYOn.f4728ADYaiT, rect2.left, rect2.top, (Paint) null);
                canvas.drawRect(rect2.left + 1, rect2.top + 1, rect2.right - 1, rect2.bottom - 1, ((A2egSU) bChYOn.f4727A5SV6n).f5419AlLFFp);
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        ASJ6gh aSJ6gh = this.f5425B4ZgIw;
        if (aSJ6gh != null) {
            LayoutEditor layoutEditor = (LayoutEditor) aSJ6gh;
            if (i3 != 0 && i4 != 0) {
                layoutEditor.B25kr6(i3, i4);
            }
            if (LayoutEditor.f11052BChYOn == null) {
                return;
            }
            int width = layoutEditor.f11057B3GDIM.getWidth();
            int height = layoutEditor.f11057B3GDIM.getHeight();
            layoutEditor.AZOQYO(layoutEditor.f11056B2KMhB.AZkASS(width, height, width > height));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r0 != 3) goto L41;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            float r1 = r9.getX()
            float r2 = r9.getY()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L4f
            if (r0 == r4) goto L42
            r5 = 2
            if (r0 == r5) goto L1c
            r1 = 3
            if (r0 == r1) goto L45
            goto La2
        L1c:
            MkAsKS.A5SV6n r0 = r8.f5423B2KMhB
            if (r0 == 0) goto La2
            float r0 = r8.f5429BI9f7h
            float r0 = r1 - r0
            int r0 = (int) r0
            float r3 = r8.f5430BIYEnU
            float r3 = r2 - r3
            int r3 = (int) r3
            int r0 = java.lang.Math.abs(r0)
            if (r0 > r4) goto L36
            int r0 = java.lang.Math.abs(r3)
            if (r0 <= r4) goto La2
        L36:
            MkAsKS.A5SV6n r0 = r8.f5423B2KMhB
            int r3 = (int) r1
            int r4 = (int) r2
            r0.b(r3, r4)
            r8.f5429BI9f7h = r1
            r8.f5430BIYEnU = r2
            goto La2
        L42:
            r8.performClick()
        L45:
            MkAsKS.A5SV6n r0 = r8.f5423B2KMhB
            if (r0 == 0) goto La2
            r0.a()
            r8.f5423B2KMhB = r3
            goto La2
        L4f:
            int r0 = (int) r1
            int r5 = (int) r2
            r8.f5429BI9f7h = r1
            r8.f5430BIYEnU = r2
            LLiCI0.BChYOn r1 = r8.f5421AzWtSf
            if (r1 == 0) goto L6d
            java.lang.Object r1 = r1.AMqCpz
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            boolean r1 = r1.contains(r0, r5)
            if (r1 == 0) goto L6d
            MkAsKS.AYUAbz r1 = new MkAsKS.AYUAbz
            LLiCI0.BChYOn r2 = r8.f5421AzWtSf
            r1.<init>(r8, r2)
            r8.f5423B2KMhB = r1
            goto L94
        L6d:
            java.util.ArrayList r1 = r8.f5418AcNBzu
            int r2 = r1.size()
        L73:
            int r2 = r2 + (-1)
            if (r2 < 0) goto L86
            java.lang.Object r6 = r1.get(r2)
            MkAsKS.ADYaiT r6 = (MkAsKS.ADYaiT) r6
            android.graphics.Rect r7 = r6.f5434A5SV6n
            boolean r7 = r7.contains(r0, r5)
            if (r7 == 0) goto L73
            r3 = r6
        L86:
            r8.setCurrentItem(r3)
            MkAsKS.ADYaiT r1 = r8.f5422B25kr6
            if (r1 == 0) goto L94
            MkAsKS.AMqCpz r2 = new MkAsKS.AMqCpz
            r2.<init>(r8, r1)
            r8.f5423B2KMhB = r2
        L94:
            MkAsKS.A5SV6n r1 = r8.f5423B2KMhB
            if (r1 == 0) goto L9b
            r1.a(r0, r5)
        L9b:
            MkAsKS.A5SV6n r0 = r8.f5423B2KMhB
            boolean r0 = r0 instanceof MkAsKS.AMqCpz
            if (r0 != 0) goto La2
            return r4
        La2:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: MkAsKS.A2egSU.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCurrentItem(ADYaiT aDYaiT) {
        ADYaiT aDYaiT2 = this.f5422B25kr6;
        if (aDYaiT2 != aDYaiT) {
            if (aDYaiT2 != null) {
                A4TApA(aDYaiT2);
            }
            this.f5422B25kr6 = aDYaiT;
            this.f5421AzWtSf = null;
            if (aDYaiT != null) {
                this.f5421AzWtSf = new BChYOn(this, this.f5420AmA8tU, aDYaiT);
                A4TApA(aDYaiT);
            }
        }
    }

    public void setGridSize(int i) {
        if (i > 0) {
            this.f5424B3GDIM = i;
            invalidate();
        }
    }

    public void setOnItemChangeListener(ARc23Z aRc23Z) {
        this.f5426B7CMnp = aRc23Z;
    }

    public void setOnSizeChangeListener(ASJ6gh aSJ6gh) {
        this.f5425B4ZgIw = aSJ6gh;
    }

    public void setShowGrid(boolean z) {
        if (this.f5428BChYOn != z) {
            this.f5428BChYOn = z;
            invalidate();
        }
    }
}
