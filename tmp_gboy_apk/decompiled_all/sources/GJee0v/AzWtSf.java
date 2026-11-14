package GJee0v;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3054AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f3055AlLFFp;

    public /* synthetic */ AzWtSf() {
        this.f3054AcNBzu = 0;
    }

    private final void A4TApA(MotionEvent motionEvent) {
    }

    private final void A5SV6n(MotionEvent motionEvent) {
    }

    public void A2egSU(MotionEvent motionEvent) {
        H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) this.f3055AlLFFp;
        if (azoqyo != null) {
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
            AMqCpz.append((int) motionEvent.getRawX());
            azoqyo.f3214CNPG0E = AMqCpz.toString();
            StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
            AMqCpz2.append((int) motionEvent.getRawY());
            azoqyo.f3215COJEAR = AMqCpz2.toString();
            StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
            AMqCpz3.append((int) motionEvent.getX());
            azoqyo.f3219CcAIMM = AMqCpz3.toString();
            StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
            AMqCpz4.append((int) motionEvent.getY());
            azoqyo.f3220Cd8JRx = AMqCpz4.toString();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 3:
                BottomSheetBehavior bottomSheetBehavior = ((BottomSheetDragHandleView) this.f3055AlLFFp).f11449AlLFFp;
                if (bottomSheetBehavior != null && bottomSheetBehavior.f11422CqNSpT) {
                    bottomSheetBehavior.setState(5);
                    break;
                } else {
                    break;
                }
                break;
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 0:
                H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) this.f3055AlLFFp;
                if (azoqyo == null) {
                    return false;
                }
                StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz.append((int) motionEvent.getRawX());
                azoqyo.f3212C4FrIb = AMqCpz.toString();
                StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz2.append((int) motionEvent.getRawY());
                azoqyo.f3213CASmeH = AMqCpz2.toString();
                StringBuilder AMqCpz3 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz3.append((int) motionEvent.getRawX());
                azoqyo.f3214CNPG0E = AMqCpz3.toString();
                StringBuilder AMqCpz4 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz4.append((int) motionEvent.getRawY());
                azoqyo.f3215COJEAR = AMqCpz4.toString();
                StringBuilder AMqCpz5 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz5.append((int) motionEvent.getX());
                azoqyo.f3217CSDoyG = AMqCpz5.toString();
                StringBuilder AMqCpz6 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz6.append((int) motionEvent.getY());
                azoqyo.f3218CTkVKb = AMqCpz6.toString();
                StringBuilder AMqCpz7 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz7.append((int) motionEvent.getX());
                azoqyo.f3219CcAIMM = AMqCpz7.toString();
                StringBuilder AMqCpz8 = JrXYwF.A4TApA.AMqCpz("");
                AMqCpz8.append((int) motionEvent.getY());
                azoqyo.f3220Cd8JRx = AMqCpz8.toString();
                long currentTimeMillis = System.currentTimeMillis();
                azoqyo.BpkvW3 = String.valueOf(currentTimeMillis);
                azoqyo.f3227CtxOCS = String.valueOf((int) (currentTimeMillis / 1000));
                return false;
            case 1:
                ((MOpbMP.AZOQYO) this.f3055AlLFFp).f5019AmA8tU.setHideable(true);
                return true;
            case 2:
            default:
                return super.onDown(motionEvent);
            case 3:
                return ((BottomSheetDragHandleView) this.f3055AlLFFp).isClickable();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        switch (this.f3054AcNBzu) {
            case 0:
                A2egSU(motionEvent2);
                return super.onFling(motionEvent, motionEvent2, f, f2);
            case 1:
            default:
                return super.onFling(motionEvent, motionEvent2, f, f2);
            case 2:
                ((N8W1LJ.AmA8tU) this.f3055AlLFFp).getClass();
                return false;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 0:
                A2egSU(motionEvent);
                break;
            case 1:
                break;
            case 2:
                N8W1LJ.AmA8tU amA8tU = (N8W1LJ.AmA8tU) this.f3055AlLFFp;
                View.OnLongClickListener onLongClickListener = amA8tU.f5585BV3sI0;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(amA8tU.f5575B4ZgIw);
                    break;
                }
                break;
            default:
                super.onLongPress(motionEvent);
                break;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        switch (this.f3054AcNBzu) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 0:
                break;
            default:
                super.onShowPress(motionEvent);
                break;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 3:
                int i = BottomSheetDragHandleView.f11447B9tovu;
                return ((BottomSheetDragHandleView) this.f3055AlLFFp).A2egSU();
            default:
                return super.onSingleTapConfirmed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        switch (this.f3054AcNBzu) {
            case 0:
                A2egSU(motionEvent);
                return false;
            case 1:
                ((MOpbMP.AZOQYO) this.f3055AlLFFp).f5019AmA8tU.setHideable(false);
                return true;
            default:
                return super.onSingleTapUp(motionEvent);
        }
    }

    public /* synthetic */ AzWtSf(int i, Object obj) {
        this.f3054AcNBzu = i;
        this.f3055AlLFFp = obj;
    }
}
