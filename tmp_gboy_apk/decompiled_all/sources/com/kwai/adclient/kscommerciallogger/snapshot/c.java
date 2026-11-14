package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private final String bka;
    private final LinkedList<d> bkb;
    private int bkc;
    private final int bkd;
    private long bke;

    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Vj() {
        return this.bke;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bka.equals(((c) obj).bka);
    }

    public final String getName() {
        return this.bka;
    }

    public int hashCode() {
        return Objects.hash(this.bka);
    }

    public synchronized d ig(String str) {
        d dVar;
        try {
            if (this.bkb.size() >= this.bkd) {
                this.bkb.removeFirst();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            int i = this.bkc;
            this.bkc = i + 1;
            sb.append(i);
            dVar = new d(sb.toString());
            this.bkb.addLast(dVar);
            this.bke = System.currentTimeMillis();
        } catch (Throwable th) {
            throw th;
        }
        return dVar;
    }

    public synchronized JSONObject ih(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.bkb.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Vi());
                }
                jSONObject.put("session_id", str);
                jSONObject.put("segment_name", this.bka);
                jSONObject.put("spans", jSONArray);
                this.bke = System.currentTimeMillis();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public c(String str, int i) {
        this.bka = str == null ? "" : str;
        this.bkb = new LinkedList<>();
        this.bkd = Math.min(i, 30);
        this.bke = System.currentTimeMillis();
    }
}
