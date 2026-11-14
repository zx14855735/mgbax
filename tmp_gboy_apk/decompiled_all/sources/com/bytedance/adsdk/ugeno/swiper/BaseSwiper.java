package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.swiper.indicator.BaseIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.swiper.indicator.RectangleIndicator;
import com.bytedance.adsdk.ugeno.swiper.xj.w;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.u {

    /* renamed from: io, reason: collision with root package name */
    private static final Interpolator f10077io = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private final Runnable ai;
    private boolean am;
    private int c;
    private int d;
    private xj dk;
    private boolean e;
    private com.bytedance.adsdk.ugeno.swiper.xj et;
    private int f;
    private boolean g;
    protected ViewPager hf;
    private FrameLayout ht;
    private int jk;
    private int kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10078pl;
    private int pz;
    private boolean qt;
    private BaseIndicator ra;
    private String tf;
    private int u;
    private int v;
    protected Context w;
    private final Runnable x;
    protected List<T> xj;
    private int y;
    private int yo;
    private boolean zg;

    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        private MotionEvent xj(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.qt) {
                return false;
            }
            try {
                if (BaseSwiper.this.pz != 1) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                boolean onInterceptTouchEvent = super.onInterceptTouchEvent(xj(motionEvent));
                xj(motionEvent);
                return onInterceptTouchEvent;
            } catch (IllegalArgumentException e) {
                pl.xj(e);
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.qt) {
                return false;
            }
            try {
                return BaseSwiper.this.pz == 1 ? super.onTouchEvent(xj(motionEvent)) : super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                pl.xj(e);
                return false;
            }
        }
    }

    public class xj extends com.bytedance.adsdk.ugeno.viewpager.hf {
        public xj() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public int xj(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public boolean xj(View view, Object obj) {
            return view == obj;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public int xj() {
            if (BaseSwiper.this.am) {
                return 1024;
            }
            return BaseSwiper.this.xj.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public Object xj(ViewGroup viewGroup, int i) {
            View xj = BaseSwiper.this.xj(i, hf.xj(BaseSwiper.this.am, i, BaseSwiper.this.xj.size()));
            viewGroup.addView(xj);
            return xj;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public void xj(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.hf
        public float xj(int i) {
            if (BaseSwiper.this.p <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.p;
        }
    }

    static {
        NlaSpE();
    }

    public BaseSwiper(Context context) {
        super(context);
        this.xj = new CopyOnWriteArrayList();
        this.u = 2000;
        this.kd = 500;
        this.y = 500;
        this.c = 0;
        this.f = -1;
        this.d = -1;
        this.tf = PrerollVideoResponse.NORMAL;
        this.p = 1.0f;
        this.f10078pl = true;
        this.g = true;
        this.am = true;
        this.qt = true;
        this.yo = 0;
        this.v = 0;
        this.jk = 0;
        this.pz = 0;
        this.x = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.hf.getCurrentItem() + 1;
                if (BaseSwiper.this.am) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.hf.xj(512, false);
                        return;
                    } else {
                        BaseSwiper.this.hf.xj(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.viewpager.hf adapter = BaseSwiper.this.hf.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.xj()) {
                        BaseSwiper.this.hf.xj(0, false);
                    } else {
                        BaseSwiper.this.hf.xj(currentItem, true);
                    }
                }
            }
        };
        this.ai = new Runnable() { // from class: com.bytedance.adsdk.ugeno.swiper.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.g) {
                    int currentItem = BaseSwiper.this.hf.getCurrentItem() + 1;
                    if (BaseSwiper.this.am) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.hf.xj(512, false);
                        } else {
                            BaseSwiper.this.hf.xj(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.ai, BaseSwiper.this.u);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.viewpager.hf adapter = BaseSwiper.this.hf.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.xj()) {
                            BaseSwiper.this.hf.xj(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.ai, BaseSwiper.this.u);
                        } else {
                            BaseSwiper.this.hf.xj(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.ai, BaseSwiper.this.u);
                        }
                    }
                }
            }
        };
        this.w = context;
        this.ht = new FrameLayout(context);
        this.hf = xj();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ht.addView(this.hf, layoutParams);
        addView(this.ht);
    }

    private static /* synthetic */ void NlaSpE() {
        char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 2);
        }
        String str = new String(charArray);
        char[] charArray2 = "anklkv".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 2);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract View c(int i);

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.u
    public void d(int i) {
        if (i == 1 && this.zg) {
            u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.g) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.zg) {
                    w();
                }
            } else if (action == 0) {
                u();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.u
    public void f(int i) {
        int i2;
        if (this.et != null) {
            int xj2 = hf.xj(this.am, i, this.xj.size());
            i2 = i;
            this.et.xj(this.am, xj2, i2, xj2 == 0, xj2 == this.xj.size() - 1);
        } else {
            i2 = i;
        }
        if (this.f10078pl) {
            this.ra.xj(i2);
        }
    }

    public com.bytedance.adsdk.ugeno.viewpager.hf getAdapter() {
        return this.hf.getAdapter();
    }

    public int getCurrentItem() {
        return this.hf.getCurrentItem();
    }

    public ViewPager getViewPager() {
        return this.hf;
    }

    public void p(int i) {
        removeCallbacks(this.x);
        postDelayed(this.x, i);
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.swiper.xj xjVar) {
        this.et = xjVar;
    }

    public void setTwoItems(boolean z) {
        this.e = z;
    }

    public void tf(int i) {
        xj(this.tf, this.c, this.f, this.d, true);
        if (this.dk == null) {
            this.dk = new xj();
            this.hf.xj((ViewPager.u) this);
            this.hf.setAdapter(this.dk);
        }
        if (this.am) {
            if (i >= 1024) {
                this.hf.xj(512, false);
                return;
            } else {
                this.hf.xj(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.xj.size()) {
            return;
        }
        this.hf.xj(i, true);
    }

    private boolean c() {
        return this.xj.size() <= 2 && this.am;
    }

    public BaseSwiper hf(boolean z) {
        this.qt = z;
        return this;
    }

    public BaseSwiper<T> kd(int i) {
        this.f = i;
        xj(this.tf, this.c, i, this.d, true);
        return this;
    }

    public BaseSwiper u(boolean z) {
        this.ra.setLoop(z);
        if (this.am != z) {
            int xj2 = hf.xj(z, this.hf.getCurrentItem(), this.xj.size());
            this.am = z;
            xj xjVar = this.dk;
            if (xjVar != null) {
                xjVar.w();
                this.hf.setCurrentItem(xj2);
            }
        }
        return this;
    }

    public BaseSwiper w(boolean z) {
        this.f10078pl = z;
        return this;
    }

    public ViewPager xj() {
        return new SwiperViewPager(getContext());
    }

    public BaseSwiper y(int i) {
        this.d = i;
        xj(this.tf, this.c, this.f, i, true);
        return this;
    }

    public BaseSwiper hf(int i) {
        this.ra.setSelectedColor(i);
        return this;
    }

    public BaseSwiper w(int i) {
        this.ra.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper xj(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.ra = new RectangleIndicator(this.w);
        } else {
            this.ra = new DotIndicator(this.w);
        }
        addView(this.ra, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper hf(String str) {
        this.tf = str;
        xj(str, this.c, this.f, this.d, true);
        return this;
    }

    public void kd() {
        int i;
        xj(this.tf, this.c, this.f, this.d, true);
        if (this.dk == null) {
            this.dk = new xj();
            this.hf.xj((ViewPager.u) this);
            this.hf.setAdapter(this.dk);
        }
        int i2 = this.yo;
        if (i2 < 0 || i2 >= this.xj.size()) {
            this.yo = 0;
        }
        if (this.am) {
            i = this.yo + 512;
        } else {
            i = this.yo;
        }
        this.hf.xj(i, true);
    }

    public void w() {
        removeCallbacks(this.ai);
        postDelayed(this.ai, this.u);
    }

    public void y() {
        removeCallbacks(this.x);
    }

    public void hf() {
        int i;
        xj(this.tf, this.c, this.f, this.d, true);
        if (this.dk == null) {
            this.dk = new xj();
            this.hf.xj((ViewPager.u) this);
            this.hf.setAdapter(this.dk);
        }
        int i2 = this.yo;
        if (i2 < 0 || i2 >= this.xj.size()) {
            this.yo = 0;
        }
        if (this.am) {
            i = this.yo + 512;
        } else {
            i = this.yo;
        }
        this.hf.xj(i, true);
        if (!this.am) {
            f(i);
        }
        if (this.g) {
            w();
        }
    }

    public BaseSwiper xj(boolean z) {
        this.g = z;
        w();
        return this;
    }

    public BaseSwiper u(int i) {
        this.c = i;
        xj(this.tf, i, this.f, this.d, true);
        return this;
    }

    public BaseSwiper xj(int i) {
        this.u = i;
        w();
        return this;
    }

    public void u() {
        removeCallbacks(this.ai);
    }

    public BaseSwiper xj(float f) {
        this.p = f;
        return this;
    }

    public void xj(String str, int i, int i2, int i3, boolean z) {
        xj xjVar = this.dk;
        if (xjVar != null) {
            xjVar.w();
        }
        this.hf.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.pz == 1) {
                this.hf.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.hf.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.ht.setClipChildren(false);
            this.hf.setClipChildren(false);
            this.hf.setClipToPadding(false);
        }
        if (this.pz == 1) {
            w wVar = new w();
            wVar.xj(str);
            this.hf.xj(true, (ViewPager.kd) wVar);
            this.hf.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.hf.xj(false, (ViewPager.kd) new com.bytedance.adsdk.ugeno.swiper.xj.hf());
        } else if (TextUtils.equals(str, "cube")) {
            this.hf.xj(false, (ViewPager.kd) new com.bytedance.adsdk.ugeno.swiper.xj.xj());
        } else {
            this.hf.xj(false, (ViewPager.kd) null);
        }
        this.hf.setOffscreenPageLimit((int) this.p);
    }

    public View xj(int i, int i2) {
        if (this.xj.size() == 0) {
            return new View(getContext());
        }
        View c = c(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (c instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (c()) {
            c.setTag("two_items_tag");
        }
        if (c.getParent() instanceof ViewGroup) {
            ((ViewGroup) c.getParent()).removeView(c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(c, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (c()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> xj(T t) {
        if (t != null) {
            this.xj.add(t);
            if (this.f10078pl) {
                this.ra.xj();
            }
        }
        xj xjVar = this.dk;
        if (xjVar != null) {
            xjVar.w();
            this.ra.xj(this.yo, this.hf.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.u
    public void xj(int i, float f, int i2) {
        if (this.et != null) {
            hf.xj(this.am, i, this.xj.size());
        }
        if (c()) {
            xj(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                xj(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    private void xj(int i, View view) {
        View findViewWithTag;
        if ((view instanceof ViewGroup) && (findViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.xj.get(hf.xj(true, i, this.xj.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.bytedance.adsdk.ugeno.hf.w) {
                findViewWithTag = ((com.bytedance.adsdk.ugeno.hf.w) t).d();
            } else if (t instanceof View) {
                findViewWithTag = (View) t;
            }
            if (findViewWithTag == null) {
                return;
            }
            if (findViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) findViewWithTag.getParent()).removeView(findViewWithTag);
            }
            ((ViewGroup) view).addView(findViewWithTag);
        }
    }
}
