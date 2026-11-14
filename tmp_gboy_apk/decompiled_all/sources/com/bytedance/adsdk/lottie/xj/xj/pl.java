package com.bytedance.adsdk.lottie.xj.xj;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.hf.d;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl implements g, tf {
    private final String u;
    private final com.bytedance.adsdk.lottie.model.hf.d y;
    private final Path xj = new Path();
    private final Path hf = new Path();
    private final Path w = new Path();
    private final List<g> kd = new ArrayList();

    /* renamed from: com.bytedance.adsdk.lottie.xj.xj.pl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[d.xj.values().length];
            xj = iArr;
            try {
                iArr[d.xj.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[d.xj.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[d.xj.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[d.xj.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[d.xj.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public pl(com.bytedance.adsdk.lottie.model.hf.d dVar) {
        this.u = dVar.xj();
        this.y = dVar;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        this.w.reset();
        if (this.y.w()) {
            return this.w;
        }
        int i = AnonymousClass1.xj[this.y.hf().ordinal()];
        if (i == 1) {
            xj();
        } else if (i == 2) {
            xj(Path.Op.UNION);
        } else if (i == 3) {
            xj(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            xj(Path.Op.INTERSECT);
        } else if (i == 5) {
            xj(Path.Op.XOR);
        }
        return this.w;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.tf
    public void xj(ListIterator<w> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            w previous = listIterator.previous();
            if (previous instanceof g) {
                this.kd.add((g) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        for (int i = 0; i < this.kd.size(); i++) {
            this.kd.get(i).xj(list, list2);
        }
    }

    private void xj() {
        for (int i = 0; i < this.kd.size(); i++) {
            this.w.addPath(this.kd.get(i).u());
        }
    }

    @TargetApi(19)
    private void xj(Path.Op op) {
        this.hf.reset();
        this.xj.reset();
        for (int size = this.kd.size() - 1; size > 0; size--) {
            g gVar = this.kd.get(size);
            if (gVar instanceof u) {
                u uVar = (u) gVar;
                List<g> hf = uVar.hf();
                for (int size2 = hf.size() - 1; size2 >= 0; size2--) {
                    Path u = hf.get(size2).u();
                    u.transform(uVar.w());
                    this.hf.addPath(u);
                }
            } else {
                this.hf.addPath(gVar.u());
            }
        }
        g gVar2 = this.kd.get(0);
        if (gVar2 instanceof u) {
            u uVar2 = (u) gVar2;
            List<g> hf2 = uVar2.hf();
            for (int i = 0; i < hf2.size(); i++) {
                Path u2 = hf2.get(i).u();
                u2.transform(uVar2.w());
                this.xj.addPath(u2);
            }
        } else {
            this.xj.set(gVar2.u());
        }
        this.w.op(this.xj, this.hf, op);
    }
}
