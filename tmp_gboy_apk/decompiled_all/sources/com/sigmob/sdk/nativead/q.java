package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final int f13613a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final int j;
    private final int k;
    private final boolean l;
    private final int m;
    private final int n;
    private final float o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final boolean t;
    private boolean u;
    private final float[] v;
    private e w;
    private final a x;
    private final int y;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (q.this.l) {
                b bVar = (b) view;
                b selectedItem = q.this.getSelectedItem();
                int i2 = 0;
                if (q.this.t) {
                    bVar.a(!bVar.b);
                    int childCount = q.this.getChildCount();
                    while (true) {
                        if (i2 >= childCount) {
                            i = -1;
                            break;
                        } else {
                            if (q.this.b(i2) == bVar) {
                                i = i2;
                                break;
                            }
                            i2++;
                        }
                    }
                } else {
                    if (selectedItem != null) {
                        selectedItem.a(false);
                    }
                    bVar.a(true);
                    i = q.this.getSelectedIndex();
                }
                if (q.this.w != null) {
                    q.this.w.onItemClick(i, bVar.getText().toString());
                }
            }
        }
    }

    public class b extends TextView {
        private boolean b;
        private final Paint c;
        private final Rect d;

        public b(Context context, CharSequence charSequence) {
            super(context);
            this.b = false;
            Paint paint = new Paint(1);
            this.c = paint;
            this.d = new Rect();
            paint.setStyle(Paint.Style.FILL);
            setPadding(q.this.r, q.this.s, q.this.r, q.this.s);
            setLayoutParams(new c(q.this.y, -2));
            setGravity(17);
            setTextSize(0, q.this.o);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            setMaxEms(4);
            setText(charSequence);
            setClickable(true);
            a();
        }

        private void a() {
            int i;
            q.this.u = false;
            if (this.b) {
                this.c.setColor(q.this.n);
                i = q.this.m;
            } else {
                this.c.setColor(q.this.k);
                i = q.this.j;
            }
            setTextColor(i);
        }

        private void b() {
            int i = this.b ? q.this.n : q.this.k;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(q.this.v);
            gradientDrawable.setColor(i);
            setBackground(gradientDrawable);
        }

        @Override // android.widget.TextView
        public boolean getDefaultEditable() {
            return false;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            if (!q.this.u) {
                b();
            }
            super.onDraw(canvas);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        
            if (r3.d.contains((int) r4.getX(), (int) r4.getY()) != false) goto L13;
         */
        @Override // android.widget.TextView, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r4) {
            /*
                r3 = this;
                int r0 = r4.getAction()
                if (r0 == 0) goto L26
                r1 = 1
                if (r0 == r1) goto L1f
                r1 = 2
                if (r0 == r1) goto Ld
                goto L2c
            Ld:
                android.graphics.Rect r0 = r3.d
                float r1 = r4.getX()
                int r1 = (int) r1
                float r2 = r4.getY()
                int r2 = (int) r2
                boolean r0 = r0.contains(r1, r2)
                if (r0 != 0) goto L2c
            L1f:
                r3.a()
                r3.invalidate()
                goto L2c
            L26:
                android.graphics.Rect r0 = r3.d
                r3.getDrawingRect(r0)
                goto L1f
            L2c:
                boolean r4 = super.onTouchEvent(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.q.b.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void a(boolean z) {
            this.b = z;
            a();
        }
    }

    public static class c extends ViewGroup.LayoutParams {
        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.sigmob.sdk.nativead.q.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f13616a;
        String[] b;
        int c;

        static {
            gvlWZD();
        }

        public d(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f13616a = readInt;
            String[] strArr = new String[readInt];
            this.b = strArr;
            parcel.readStringArray(strArr);
            this.c = parcel.readInt();
        }

        private static /* synthetic */ void gvlWZD() {
            char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '.');
            }
            String str = new String(charArray);
            char[] charArray2 = "MBG@GZ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '.');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int length = this.b.length;
            this.f13616a = length;
            parcel.writeInt(length);
            parcel.writeStringArray(this.b);
            parcel.writeInt(this.c);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface e {
        void onItemClick(int i, String str);
    }

    public q(Context context) {
        this(context, null);
    }

    private float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int b(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public ArrayList<Integer> getAllItemSelectedIndex() {
        int childCount = getChildCount();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            if (b(i).b) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAllItemSelectedTextWithListArray() {
        int childCount = getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            b b2 = b(i);
            if (b2.b) {
                arrayList.add(b2.getText().toString());
            }
        }
        return arrayList;
    }

    public String[] getAllItemSelectedTextWithStringArray() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            b b2 = b(i);
            if (b2.b) {
                arrayList.add(b2.getText().toString());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] getAllItemText() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(b(i).getText().toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public int getSelectedIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (b(i).b) {
                return i;
            }
        }
        return -1;
    }

    public b getSelectedItem() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex == -1) {
            return null;
        }
        return b(selectedIndex);
    }

    public String getSelectedItemText() {
        b selectedItem = getSelectedItem();
        if (selectedItem == null) {
            return null;
        }
        return selectedItem.getText().toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i5 = paddingLeft;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                if (i5 + measuredWidth > paddingRight) {
                    paddingTop += i6 + this.q;
                    i5 = paddingLeft;
                    i6 = measuredHeight;
                } else {
                    i6 = Math.max(i6, measuredHeight);
                }
                childAt.layout(i5, paddingTop, i5 + measuredWidth, measuredHeight + paddingTop);
                i5 += measuredWidth + this.p;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                int i8 = i6 + measuredWidth;
                if (i8 > size) {
                    i3 += i4 + this.q;
                    i5++;
                } else {
                    measuredHeight = Math.max(i4, measuredHeight);
                    measuredWidth = i8;
                }
                i6 = measuredWidth + this.p;
                i4 = measuredHeight;
            }
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3 + i4;
        int paddingRight = i5 == 0 ? getPaddingRight() + getPaddingLeft() + i6 : size;
        if (mode != 1073741824) {
            size = paddingRight;
        }
        if (mode2 != 1073741824) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setList(dVar.b);
        b b2 = b(dVar.c);
        if (b2 == null) {
            return;
        }
        b2.a(true);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.b = getAllItemText();
        dVar.c = getSelectedIndex();
        return dVar;
    }

    public void setIndexListItemSelected(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > getChildCount()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            b(i).a(true);
        }
    }

    public void setList(List<String> list) {
        setList((String[]) list.toArray(new String[0]));
    }

    public void setOnItemClickListener(e eVar) {
        this.w = eVar;
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int a(int i) {
        return a(i, true);
    }

    public b b(int i) {
        if (getChildAt(i) == null) {
            return null;
        }
        return (b) getChildAt(i);
    }

    public void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b b2 = b(i);
            if (b2 != null) {
                if (b2.b) {
                    b2.a(false);
                }
                b2.setClickable(false);
            }
        }
    }

    public boolean d(int i) {
        b b2 = b(i);
        return b2 != null && b2.b;
    }

    public void setList(String... strArr) {
        removeAllViews();
        for (String str : strArr) {
            a((CharSequence) str);
        }
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13613a = com.sigmob.sdk.base.blurkit.d.f13043a;
        int parseColor = Color.parseColor("#EEEEEE");
        this.b = parseColor;
        this.c = -1;
        int parseColor2 = Color.parseColor("#FE7E03");
        this.d = parseColor2;
        this.u = false;
        this.v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.x = new a();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        int a2 = (int) a(100.0f);
        if (i3 > i2) {
            this.y = (i2 - a2) / 3;
        } else {
            this.y = (i3 - a2) / 3;
        }
        float b2 = b(11.0f);
        this.e = b2;
        float a3 = a(8.0f);
        this.f = a3;
        float a4 = a(8.0f);
        this.g = a4;
        float a5 = a(8.0f);
        this.h = a5;
        float a6 = a(5.0f);
        this.i = a6;
        this.j = com.sigmob.sdk.base.blurkit.d.f13043a;
        this.k = parseColor;
        this.m = -1;
        this.n = parseColor2;
        this.o = b2;
        this.p = (int) a3;
        this.q = (int) a4;
        this.r = (int) a5;
        this.s = (int) a6;
        this.t = false;
        this.l = true;
    }

    public int a(int i, boolean z) {
        if (i >= getChildCount()) {
            return -1;
        }
        b(i).a(z);
        return i;
    }

    public void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b b2 = b(i);
            if (b2 != null && b2.b) {
                b2.a(false);
            }
        }
    }

    public void c(int i) {
        b b2 = b(i);
        if (b2 == null || !b2.b) {
            return;
        }
        b2.a(false);
    }

    public int a(String str) {
        ArrayList<String> allItemSelectedTextWithListArray = getAllItemSelectedTextWithListArray();
        if (allItemSelectedTextWithListArray == null || !allItemSelectedTextWithListArray.contains(str)) {
            return -1;
        }
        return allItemSelectedTextWithListArray.indexOf(str);
    }

    public void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b(i).a(true);
        }
    }

    public void a(int i, String str) {
        if (i >= getChildCount()) {
            return;
        }
        b(i).setText(str);
    }

    private void a(CharSequence charSequence) {
        b bVar = new b(getContext(), charSequence);
        bVar.setOnClickListener(this.x);
        addView(bVar);
    }
}
