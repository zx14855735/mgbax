package com.bytedance.sdk.component.widget.recycler;

import J3FDQU.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends p {
    private static TimeInterpolator d;
    private ArrayList<RecyclerView.ra> tf = new ArrayList<>();
    private ArrayList<RecyclerView.ra> p = new ArrayList<>();

    /* renamed from: pl, reason: collision with root package name */
    private ArrayList<hf> f10253pl = new ArrayList<>();
    private ArrayList<xj> g = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ra>> xj = new ArrayList<>();
    ArrayList<ArrayList<hf>> hf = new ArrayList<>();
    ArrayList<ArrayList<xj>> w = new ArrayList<>();
    ArrayList<RecyclerView.ra> u = new ArrayList<>();
    ArrayList<RecyclerView.ra> kd = new ArrayList<>();
    ArrayList<RecyclerView.ra> y = new ArrayList<>();
    ArrayList<RecyclerView.ra> c = new ArrayList<>();

    public static class hf {
        public int hf;
        public int kd;
        public int u;
        public int w;
        public RecyclerView.ra xj;

        public hf(RecyclerView.ra raVar, int i, int i2, int i3, int i4) {
            this.xj = raVar;
            this.hf = i;
            this.w = i2;
            this.u = i3;
            this.kd = i4;
        }
    }

    private void p(final RecyclerView.ra raVar) {
        final View view = raVar.xj;
        final ViewPropertyAnimator animate = view.animate();
        this.y.add(raVar);
        animate.setDuration(c()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.w.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                w.this.f(raVar);
                w.this.y.remove(raVar);
                w.this.w();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void pl(RecyclerView.ra raVar) {
        if (d == null) {
            d = new ValueAnimator().getInterpolator();
        }
        raVar.xj.animate().setInterpolator(d);
        u(raVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p
    public boolean hf(RecyclerView.ra raVar) {
        pl(raVar);
        raVar.xj.setAlpha(0.0f);
        this.p.add(raVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public void u(RecyclerView.ra raVar) {
        View view = raVar.xj;
        view.animate().cancel();
        int size = this.f10253pl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f10253pl.get(size).xj == raVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                d(raVar);
                this.f10253pl.remove(size);
            }
        }
        xj(this.g, raVar);
        if (this.tf.remove(raVar)) {
            view.setAlpha(1.0f);
            f(raVar);
        }
        if (this.p.remove(raVar)) {
            view.setAlpha(1.0f);
            tf(raVar);
        }
        for (int size2 = this.w.size() - 1; size2 >= 0; size2--) {
            ArrayList<xj> arrayList = this.w.get(size2);
            xj(arrayList, raVar);
            if (arrayList.isEmpty()) {
                this.w.remove(size2);
            }
        }
        for (int size3 = this.hf.size() - 1; size3 >= 0; size3--) {
            ArrayList<hf> arrayList2 = this.hf.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).xj == raVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    d(raVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.hf.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.xj.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ra> arrayList3 = this.xj.get(size5);
            if (arrayList3.remove(raVar)) {
                view.setAlpha(1.0f);
                tf(raVar);
                if (arrayList3.isEmpty()) {
                    this.xj.remove(size5);
                }
            }
        }
        this.y.remove(raVar);
        this.u.remove(raVar);
        this.c.remove(raVar);
        this.kd.remove(raVar);
        w();
    }

    public void w(final RecyclerView.ra raVar) {
        final View view = raVar.xj;
        final ViewPropertyAnimator animate = view.animate();
        this.u.add(raVar);
        animate.alpha(1.0f).setDuration(y()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.w.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                w.this.tf(raVar);
                w.this.u.remove(raVar);
                w.this.w();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public void xj() {
        boolean isEmpty = this.tf.isEmpty();
        boolean isEmpty2 = this.f10253pl.isEmpty();
        boolean isEmpty3 = this.g.isEmpty();
        boolean isEmpty4 = this.p.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator<RecyclerView.ra> it = this.tf.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        this.tf.clear();
        if (!isEmpty2) {
            final ArrayList<hf> arrayList = new ArrayList<>();
            arrayList.addAll(this.f10253pl);
            this.hf.add(arrayList);
            this.f10253pl.clear();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.w.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        hf hfVar = (hf) it2.next();
                        w.this.hf(hfVar.xj, hfVar.hf, hfVar.w, hfVar.u, hfVar.kd);
                    }
                    arrayList.clear();
                    w.this.hf.remove(arrayList);
                }
            };
            if (isEmpty) {
                runnable.run();
            } else {
                com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(arrayList.get(0).xj.xj, runnable, c());
            }
        }
        if (!isEmpty3) {
            final ArrayList<xj> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.g);
            this.w.add(arrayList2);
            this.g.clear();
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.w.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        w.this.xj((xj) it2.next());
                    }
                    arrayList2.clear();
                    w.this.w.remove(arrayList2);
                }
            };
            if (isEmpty) {
                runnable2.run();
            } else {
                com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(arrayList2.get(0).xj.xj, runnable2, c());
            }
        }
        if (isEmpty4) {
            return;
        }
        final ArrayList<RecyclerView.ra> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.p);
        this.xj.add(arrayList3);
        this.p.clear();
        Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.w.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    w.this.w((RecyclerView.ra) it2.next());
                }
                arrayList3.clear();
                w.this.xj.remove(arrayList3);
            }
        };
        if (isEmpty && isEmpty2 && isEmpty3) {
            runnable3.run();
        } else {
            com.bytedance.sdk.component.widget.recycler.xj.w.c.xj(arrayList3.get(0).xj, runnable3, Math.max(!isEmpty2 ? kd() : 0L, isEmpty3 ? 0L : f()) + (!isEmpty ? c() : 0L));
        }
    }

    public static class xj {
        public RecyclerView.ra hf;
        public int kd;
        public int u;
        public int w;
        public RecyclerView.ra xj;
        public int y;

        private xj(RecyclerView.ra raVar, RecyclerView.ra raVar2) {
            this.xj = raVar;
            this.hf = raVar2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ChangeInfo{oldHolder=");
            sb.append(this.xj);
            sb.append(", newHolder=");
            sb.append(this.hf);
            sb.append(", fromX=");
            sb.append(this.w);
            sb.append(", fromY=");
            sb.append(this.u);
            sb.append(", toX=");
            sb.append(this.kd);
            sb.append(", toY=");
            return A2egSU.B2KMhB(sb, this.y, '}');
        }

        public xj(RecyclerView.ra raVar, RecyclerView.ra raVar2, int i, int i2, int i3, int i4) {
            this(raVar, raVar2);
            this.w = i;
            this.u = i2;
            this.kd = i3;
            this.y = i4;
        }
    }

    public void hf(final RecyclerView.ra raVar, int i, int i2, int i3, int i4) {
        final View view = raVar.xj;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.kd.add(raVar);
        animate.setDuration(kd()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.w.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                w.this.d(raVar);
                w.this.kd.remove(raVar);
                w.this.w();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    public void w() {
        if (hf()) {
            return;
        }
        d();
    }

    private void hf(xj xjVar) {
        RecyclerView.ra raVar = xjVar.xj;
        if (raVar != null) {
            xj(xjVar, raVar);
        }
        RecyclerView.ra raVar2 = xjVar.hf;
        if (raVar2 != null) {
            xj(xjVar, raVar2);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean hf() {
        return (this.p.isEmpty() && this.g.isEmpty() && this.f10253pl.isEmpty() && this.tf.isEmpty() && this.kd.isEmpty() && this.y.isEmpty() && this.u.isEmpty() && this.c.isEmpty() && this.hf.isEmpty() && this.xj.isEmpty() && this.w.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p
    public boolean xj(RecyclerView.ra raVar) {
        pl(raVar);
        this.tf.add(raVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p
    public boolean xj(RecyclerView.ra raVar, int i, int i2, int i3, int i4) {
        View view = raVar.xj;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) raVar.xj.getTranslationY());
        pl(raVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            d(raVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f10253pl.add(new hf(raVar, translationX, translationY, i3, i4));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public void u() {
        int size = this.f10253pl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            hf hfVar = this.f10253pl.get(size);
            View view = hfVar.xj.xj;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            d(hfVar.xj);
            this.f10253pl.remove(size);
        }
        for (int size2 = this.tf.size() - 1; size2 >= 0; size2--) {
            f(this.tf.get(size2));
            this.tf.remove(size2);
        }
        int size3 = this.p.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ra raVar = this.p.get(size3);
            raVar.xj.setAlpha(1.0f);
            tf(raVar);
            this.p.remove(size3);
        }
        for (int size4 = this.g.size() - 1; size4 >= 0; size4--) {
            hf(this.g.get(size4));
        }
        this.g.clear();
        if (hf()) {
            for (int size5 = this.hf.size() - 1; size5 >= 0; size5--) {
                ArrayList<hf> arrayList = this.hf.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    hf hfVar2 = arrayList.get(size6);
                    View view2 = hfVar2.xj.xj;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    d(hfVar2.xj);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.hf.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.xj.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ra> arrayList2 = this.xj.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ra raVar2 = arrayList2.get(size8);
                    raVar2.xj.setAlpha(1.0f);
                    tf(raVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.xj.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.w.size() - 1; size9 >= 0; size9--) {
                ArrayList<xj> arrayList3 = this.w.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    hf(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.w.remove(arrayList3);
                    }
                }
            }
            xj(this.y);
            xj(this.kd);
            xj(this.u);
            xj(this.c);
            d();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p
    public boolean xj(RecyclerView.ra raVar, RecyclerView.ra raVar2, int i, int i2, int i3, int i4) {
        if (raVar == raVar2) {
            return xj(raVar, i, i2, i3, i4);
        }
        float translationX = raVar.xj.getTranslationX();
        float translationY = raVar.xj.getTranslationY();
        float alpha = raVar.xj.getAlpha();
        pl(raVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        raVar.xj.setTranslationX(translationX);
        raVar.xj.setTranslationY(translationY);
        raVar.xj.setAlpha(alpha);
        if (raVar2 != null) {
            pl(raVar2);
            raVar2.xj.setTranslationX(-i5);
            raVar2.xj.setTranslationY(-i6);
            raVar2.xj.setAlpha(0.0f);
        }
        this.g.add(new xj(raVar, raVar2, i, i2, i3, i4));
        return true;
    }

    public void xj(final xj xjVar) {
        RecyclerView.ra raVar = xjVar.xj;
        final View view = raVar == null ? null : raVar.xj;
        RecyclerView.ra raVar2 = xjVar.hf;
        final View view2 = raVar2 != null ? raVar2.xj : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(f());
            this.c.add(xjVar.xj);
            duration.translationX(xjVar.kd - xjVar.w);
            duration.translationY(xjVar.y - xjVar.u);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.w.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    w.this.xj(xjVar.xj, true);
                    w.this.c.remove(xjVar.xj);
                    w.this.w();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.c.add(xjVar.hf);
            animate.translationX(0.0f).translationY(0.0f).setDuration(f()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.w.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    w.this.xj(xjVar.hf, false);
                    w.this.c.remove(xjVar.hf);
                    w.this.w();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    private void xj(List<xj> list, RecyclerView.ra raVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            xj xjVar = list.get(size);
            if (xj(xjVar, raVar) && xjVar.xj == null && xjVar.hf == null) {
                list.remove(xjVar);
            }
        }
    }

    private boolean xj(xj xjVar, RecyclerView.ra raVar) {
        boolean z = false;
        if (xjVar.hf == raVar) {
            xjVar.hf = null;
        } else {
            if (xjVar.xj != raVar) {
                return false;
            }
            xjVar.xj = null;
            z = true;
        }
        raVar.xj.setAlpha(1.0f);
        raVar.xj.setTranslationX(0.0f);
        raVar.xj.setTranslationY(0.0f);
        xj(raVar, z);
        return true;
    }

    public void xj(List<RecyclerView.ra> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).xj.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean xj(RecyclerView.ra raVar, List<Object> list) {
        return !list.isEmpty() || super.xj(raVar, list);
    }
}
