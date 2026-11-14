package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.u;
import com.bytedance.adsdk.ugeno.y.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.xj {
    private SparseIntArray am;
    private Drawable c;
    private int d;
    private com.bytedance.adsdk.ugeno.w e;
    private Drawable f;
    private int[] g;
    private int hf;
    private int kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10065pl;
    private u qt;
    private int tf;
    private int u;
    private int w;
    private int xj;
    private int y;
    private u.xj yo;
    private List<w> zg;

    public static class xj extends ViewGroup.MarginLayoutParams implements hf {
        public static final Parcelable.Creator<xj> CREATOR = new Parcelable.Creator<xj>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.xj.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public xj createFromParcel(Parcel parcel) {
                return new xj(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public xj[] newArray(int i) {
                return new xj[i];
            }
        };
        private int c;
        private int d;
        private int f;
        private float hf;
        private float kd;
        private boolean tf;
        private int u;
        private float w;
        private int xj;
        private int y;

        static {
            NFuSnCE();
        }

        public xj(xj xjVar) {
            super((ViewGroup.MarginLayoutParams) xjVar);
            this.xj = 1;
            this.hf = 0.0f;
            this.w = 0.0f;
            this.u = -1;
            this.kd = -1.0f;
            this.y = -1;
            this.c = -1;
            this.f = 16777215;
            this.d = 16777215;
            this.xj = xjVar.xj;
            this.hf = xjVar.hf;
            this.w = xjVar.w;
            this.u = xjVar.u;
            this.kd = xjVar.kd;
            this.y = xjVar.y;
            this.c = xjVar.c;
            this.f = xjVar.f;
            this.d = xjVar.d;
            this.tf = xjVar.tf;
        }

        private static /* synthetic */ void NFuSnCE() {
            char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'o');
            }
            String str = new String(charArray);
            char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'o');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int am() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int c() {
            return this.y;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int d() {
            return this.f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int f() {
            return this.c;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int g() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int hf() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public float kd() {
            return this.w;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public boolean p() {
            return this.tf;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public float pl() {
            return this.kd;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int qt() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int tf() {
            return this.d;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public float u() {
            return this.hf;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int w() {
            return this.xj;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.xj);
            parcel.writeFloat(this.hf);
            parcel.writeFloat(this.w);
            parcel.writeInt(this.u);
            parcel.writeFloat(this.kd);
            parcel.writeInt(this.y);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f);
            parcel.writeInt(this.d);
            parcel.writeByte(this.tf ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int xj() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int y() {
            return this.u;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public int zg() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        public void hf(float f) {
            this.w = f;
        }

        public void u(int i) {
            this.u = i;
        }

        public void w(int i) {
            this.xj = i;
        }

        public void xj(float f) {
            this.hf = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public void hf(int i) {
            this.c = i;
        }

        public void w(float f) {
            this.kd = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.hf
        public void xj(int i) {
            this.y = i;
        }

        public xj(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.xj = 1;
            this.hf = 0.0f;
            this.w = 0.0f;
            this.u = -1;
            this.kd = -1.0f;
            this.y = -1;
            this.c = -1;
            this.f = 16777215;
            this.d = 16777215;
        }

        public xj(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.xj = 1;
            this.hf = 0.0f;
            this.w = 0.0f;
            this.u = -1;
            this.kd = -1.0f;
            this.y = -1;
            this.c = -1;
            this.f = 16777215;
            this.d = 16777215;
        }

        public xj(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.xj = 1;
            this.hf = 0.0f;
            this.w = 0.0f;
            this.u = -1;
            this.kd = -1.0f;
            this.y = -1;
            this.c = -1;
            this.f = 16777215;
            this.d = 16777215;
        }

        public xj(Parcel parcel) {
            super(0, 0);
            this.xj = 1;
            this.hf = 0.0f;
            this.w = 0.0f;
            this.u = -1;
            this.kd = -1.0f;
            this.y = -1;
            this.c = -1;
            this.f = 16777215;
            this.d = 16777215;
            this.xj = parcel.readInt();
            this.hf = parcel.readFloat();
            this.w = parcel.readFloat();
            this.u = parcel.readInt();
            this.kd = parcel.readFloat();
            this.y = parcel.readInt();
            this.c = parcel.readInt();
            this.f = parcel.readInt();
            this.d = parcel.readInt();
            this.tf = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.y = -1;
        this.qt = new u(this);
        this.zg = new ArrayList();
        this.yo = new u.xj();
    }

    private boolean kd(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View w = w(i - i3);
            if (w != null && w.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean u(int i, int i2) {
        return kd(i, i2) ? xj() ? (this.tf & 1) != 0 : (this.d & 1) != 0 : xj() ? (this.tf & 2) != 0 : (this.d & 2) != 0;
    }

    private boolean y(int i) {
        if (i >= 0 && i < this.zg.size()) {
            for (int i2 = i + 1; i2 < this.zg.size(); i2++) {
                if (this.zg.get(i2).hf() > 0) {
                    return false;
                }
            }
            if (xj()) {
                return (this.d & 4) != 0;
            }
            if ((this.tf & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.am == null) {
            this.am = new SparseIntArray(getChildCount());
        }
        this.g = this.qt.xj(view, i, layoutParams, this.am);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof xj;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof xj ? new xj((xj) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new xj((ViewGroup.MarginLayoutParams) layoutParams) : new xj(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getAlignContent() {
        return this.kd;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getAlignItems() {
        return this.u;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.c;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getFlexDirection() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<w> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.zg.size());
        for (w wVar : this.zg) {
            if (wVar.hf() != 0) {
                arrayList.add(wVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public List<w> getFlexLinesInternal() {
        return this.zg;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getFlexWrap() {
        return this.hf;
    }

    public int getJustifyContent() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getLargestMainSize() {
        Iterator<w> it = this.zg.iterator();
        int i = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i = Math.max(i, it.next().kd);
        }
        return i;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getMaxLine() {
        return this.y;
    }

    public int getShowDividerHorizontal() {
        return this.d;
    }

    public int getShowDividerVertical() {
        return this.tf;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int getSumOfCrossSize() {
        int size = this.zg.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = this.zg.get(i2);
            if (u(i2)) {
                i += xj() ? this.p : this.f10065pl;
            }
            if (y(i2)) {
                i += xj() ? this.p : this.f10065pl;
            }
            i += wVar.c;
        }
        return i;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public View hf(int i) {
        return w(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f == null && this.c == null) {
            return;
        }
        if (this.d == 0 && this.tf == 0) {
            return;
        }
        int xj2 = c.xj(this);
        int i = this.xj;
        if (i == 0) {
            xj(canvas, xj2 == 1, this.hf == 2);
            return;
        }
        if (i == 1) {
            xj(canvas, xj2 != 1, this.hf == 2);
            return;
        }
        if (i == 2) {
            boolean z = xj2 == 1;
            if (this.hf == 2) {
                z = !z;
            }
            hf(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = xj2 == 1;
        if (this.hf == 2) {
            z2 = !z2;
        }
        hf(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            wVar.u();
        }
        int xj2 = c.xj(this);
        int i5 = this.xj;
        if (i5 == 0) {
            xj(xj2 == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            xj(xj2 != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = xj2 == 1;
            if (this.hf == 2) {
                z2 = !z2;
            }
            xj(z2, false, i, i2, i3, i4);
        } else {
            if (i5 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.xj);
            }
            z2 = xj2 == 1;
            if (this.hf == 2) {
                z2 = !z2;
            }
            xj(z2, true, i, i2, i3, i4);
        }
        com.bytedance.adsdk.ugeno.w wVar2 = this.e;
        if (wVar2 != null) {
            wVar2.xj(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            int[] xj2 = wVar.xj(i, i2);
            xj(xj2[0], xj2[1]);
        } else {
            xj(i, i2);
        }
        com.bytedance.adsdk.ugeno.w wVar2 = this.e;
        if (wVar2 != null) {
            wVar2.w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.w wVar = this.e;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void setAlignContent(int i) {
        if (this.kd != i) {
            this.kd = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.c) {
            return;
        }
        this.c = drawable;
        if (drawable != null) {
            this.p = drawable.getIntrinsicHeight();
        } else {
            this.p = 0;
        }
        hf();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f) {
            return;
        }
        this.f = drawable;
        if (drawable != null) {
            this.f10065pl = drawable.getIntrinsicWidth();
        } else {
            this.f10065pl = 0;
        }
        hf();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.xj != i) {
            this.xj = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public void setFlexLines(List<w> list) {
        this.zg = list;
    }

    public void setFlexWrap(int i) {
        if (this.hf != i) {
            this.hf = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.w != i) {
            this.w = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.y != i) {
            this.y = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.d) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.tf) {
            this.tf = i;
            requestLayout();
        }
    }

    public View w(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.g;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int xj(View view) {
        return 0;
    }

    private void hf(int i, int i2) {
        this.zg.clear();
        this.yo.xj();
        this.qt.xj(this.yo, i, i2);
        this.zg = this.yo.xj;
        this.qt.xj(i, i2);
        if (this.u == 3) {
            for (w wVar : this.zg) {
                int i3 = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < wVar.f; i4++) {
                    View w = w(wVar.qt + i4);
                    if (w != null && w.getVisibility() != 8) {
                        xj xjVar = (xj) w.getLayoutParams();
                        i3 = this.hf != 2 ? Math.max(i3, w.getMeasuredHeight() + Math.max(wVar.f10067pl - w.getBaseline(), ((ViewGroup.MarginLayoutParams) xjVar).topMargin) + ((ViewGroup.MarginLayoutParams) xjVar).bottomMargin) : Math.max(i3, w.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) xjVar).topMargin + Math.max(w.getBaseline() + (wVar.f10067pl - w.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) xjVar).bottomMargin));
                    }
                }
                wVar.c = i3;
            }
        }
        this.qt.hf(i, i2, getPaddingBottom() + getPaddingTop());
        this.qt.xj();
        xj(this.xj, i, i2, this.yo.hf);
    }

    private void xj(int i, int i2) {
        if (this.am == null) {
            this.am = new SparseIntArray(getChildCount());
        }
        if (this.qt.hf(this.am)) {
            this.g = this.qt.xj(this.am);
        }
        int i3 = this.xj;
        if (i3 == 0 || i3 == 1) {
            hf(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            w(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.xj);
        }
    }

    private boolean kd(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zg.get(i2).hf() > 0) {
                return false;
            }
        }
        return true;
    }

    private void w(int i, int i2) {
        this.zg.clear();
        this.yo.xj();
        this.qt.hf(this.yo, i, i2);
        this.zg = this.yo.xj;
        this.qt.xj(i, i2);
        this.qt.hf(i, i2, getPaddingRight() + getPaddingLeft());
        this.qt.xj();
        xj(this.xj, i, i2, this.yo.hf);
    }

    private boolean u(int i) {
        if (i >= 0 && i < this.zg.size()) {
            if (kd(i)) {
                return xj() ? (this.d & 1) != 0 : (this.tf & 1) != 0;
            }
            if (xj()) {
                return (this.d & 2) != 0;
            }
            if ((this.tf & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public View xj(int i) {
        return getChildAt(i);
    }

    private void xj(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = paddingBottom;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void hf(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.zg.size();
        for (int i3 = 0; i3 < size; i3++) {
            w wVar = this.zg.get(i3);
            for (int i4 = 0; i4 < wVar.f; i4++) {
                int i5 = wVar.qt + i4;
                View w = w(i5);
                if (w != null && w.getVisibility() != 8) {
                    xj xjVar = (xj) w.getLayoutParams();
                    if (u(i5, i4)) {
                        if (z2) {
                            top = w.getBottom() + ((ViewGroup.MarginLayoutParams) xjVar).bottomMargin;
                        } else {
                            top = (w.getTop() - ((ViewGroup.MarginLayoutParams) xjVar).topMargin) - this.p;
                        }
                        hf(canvas, wVar.xj, top, wVar.c);
                    }
                    if (i4 == wVar.f - 1 && (this.d & 4) > 0) {
                        if (z2) {
                            bottom = (w.getTop() - ((ViewGroup.MarginLayoutParams) xjVar).topMargin) - this.p;
                        } else {
                            bottom = w.getBottom() + ((ViewGroup.MarginLayoutParams) xjVar).bottomMargin;
                        }
                        hf(canvas, wVar.xj, bottom, wVar.c);
                    }
                }
            }
            if (u(i3)) {
                if (z) {
                    i2 = wVar.w;
                } else {
                    i2 = wVar.xj - this.f10065pl;
                }
                xj(canvas, i2, paddingTop, max);
            }
            if (y(i3) && (this.tf & 4) > 0) {
                if (z) {
                    i = wVar.xj - this.f10065pl;
                } else {
                    i = wVar.w;
                }
                xj(canvas, i, paddingTop, max);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public boolean xj() {
        int i = this.xj;
        return i == 0 || i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.xj(boolean, int, int, int, int):void");
    }

    private void hf(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.c;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.p + i2);
        this.c.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int hf(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    private void hf() {
        if (this.c == null && this.f == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(boolean r25, boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.xj(boolean, boolean, int, int, int, int):void");
    }

    private void xj(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.zg.size();
        for (int i3 = 0; i3 < size; i3++) {
            w wVar = this.zg.get(i3);
            for (int i4 = 0; i4 < wVar.f; i4++) {
                int i5 = wVar.qt + i4;
                View w = w(i5);
                if (w != null && w.getVisibility() != 8) {
                    xj xjVar = (xj) w.getLayoutParams();
                    if (u(i5, i4)) {
                        if (z) {
                            left = w.getRight() + ((ViewGroup.MarginLayoutParams) xjVar).rightMargin;
                        } else {
                            left = (w.getLeft() - ((ViewGroup.MarginLayoutParams) xjVar).leftMargin) - this.f10065pl;
                        }
                        xj(canvas, left, wVar.hf, wVar.c);
                    }
                    if (i4 == wVar.f - 1 && (this.tf & 4) > 0) {
                        if (z) {
                            right = (w.getLeft() - ((ViewGroup.MarginLayoutParams) xjVar).leftMargin) - this.f10065pl;
                        } else {
                            right = w.getRight() + ((ViewGroup.MarginLayoutParams) xjVar).rightMargin;
                        }
                        xj(canvas, right, wVar.hf, wVar.c);
                    }
                }
            }
            if (u(i3)) {
                if (z2) {
                    i2 = wVar.u;
                } else {
                    i2 = wVar.hf - this.p;
                }
                hf(canvas, paddingLeft, i2, max);
            }
            if (y(i3) && (this.d & 4) > 0) {
                if (z2) {
                    i = wVar.hf - this.p;
                } else {
                    i = wVar.u;
                }
                hf(canvas, paddingLeft, i, max);
            }
        }
    }

    private void xj(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.f;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.f10065pl + i, i3 + i2);
        this.f.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int xj(View view, int i, int i2) {
        int i3;
        int i4;
        if (xj()) {
            i3 = u(i, i2) ? this.f10065pl : 0;
            if ((this.tf & 4) <= 0) {
                return i3;
            }
            i4 = this.f10065pl;
        } else {
            i3 = u(i, i2) ? this.p : 0;
            if ((this.d & 4) <= 0) {
                return i3;
            }
            i4 = this.p;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public void xj(w wVar) {
        if (xj()) {
            if ((this.tf & 4) > 0) {
                int i = wVar.kd;
                int i2 = this.f10065pl;
                wVar.kd = i + i2;
                wVar.y += i2;
                return;
            }
            return;
        }
        if ((this.d & 4) > 0) {
            int i3 = wVar.kd;
            int i4 = this.p;
            wVar.kd = i3 + i4;
            wVar.y += i4;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public int xj(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.xj
    public void xj(View view, int i, int i2, w wVar) {
        if (u(i, i2)) {
            if (xj()) {
                int i3 = wVar.kd;
                int i4 = this.f10065pl;
                wVar.kd = i3 + i4;
                wVar.y += i4;
                return;
            }
            int i5 = wVar.kd;
            int i6 = this.p;
            wVar.kd = i5 + i6;
            wVar.y += i6;
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.e = wVar;
    }
}
