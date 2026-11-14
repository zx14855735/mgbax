package com.kwad.library.solder.lib.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a implements Comparable<a> {
    public String avL;
    public boolean tu;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
