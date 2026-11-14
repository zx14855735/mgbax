package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface g {

    public static class a implements g {
        private long aat;

        public a(long j) {
            this.aat = j;
        }

        public final boolean K(long j) {
            return this.aat > 0 && System.currentTimeMillis() - j >= this.aat;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.aat + '}';
        }
    }

    public static class b implements g {
        private AlLFFp aam;

        public b(AlLFFp alLFFp) {
            this.aam = alLFFp;
        }

        public final boolean b(AlLFFp alLFFp) {
            return this.aam.equals(alLFFp);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.aam + '}';
        }
    }
}
