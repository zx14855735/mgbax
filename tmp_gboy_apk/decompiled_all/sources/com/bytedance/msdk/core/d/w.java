package com.bytedance.msdk.core.d;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static void hf(double d, double d2, double d3, com.bytedance.msdk.core.tf.hf hfVar, List<tf> list) {
        if (d2 < d3 || d2 <= 0.0d || d < hfVar.et()) {
            return;
        }
        if (d > hfVar.dk() && d3 <= 0.0d) {
            list.addAll(hfVar.yy());
            return;
        }
        BigDecimal valueOf = BigDecimal.valueOf(d * d2);
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        double doubleValue = valueOf.setScale(2, roundingMode).doubleValue();
        double doubleValue2 = BigDecimal.valueOf(d * d3).setScale(2, roundingMode).doubleValue();
        List<tf> yy = hfVar.yy();
        double d4 = -1.0d;
        double d5 = -1.0d;
        for (int i = 0; i < yy.size(); i++) {
            tf tfVar = yy.get(i);
            if (tfVar.v() == 0) {
                double doubleValue3 = BigDecimal.valueOf(tfVar.ra()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (doubleValue3 <= doubleValue && doubleValue3 >= doubleValue2) {
                    if (d4 == -1.0d || d4 < tfVar.ra()) {
                        d4 = tfVar.ra();
                    }
                    if (d5 == -1.0d || d5 > tfVar.ra()) {
                        d5 = tfVar.ra();
                    }
                    list.add(tfVar);
                }
            } else {
                list.add(tfVar);
            }
        }
        hfVar.y().put("max_ecpm", Double.valueOf(d4));
        hfVar.y().put("min_ecpm", Double.valueOf(d5));
        hfVar.y().put("upper_cpm_x", Double.valueOf(doubleValue));
    }

    public static List<tf> xj(com.bytedance.msdk.core.tf.hf hfVar, String str) {
        return xj(hfVar, str, 0.0d, 0.0d);
    }

    public static List<tf> xj(com.bytedance.msdk.core.tf.hf hfVar, String str, double d, double d2) {
        int i;
        double d3;
        if (hfVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.bytedance.msdk.core.tf.u kd = com.bytedance.msdk.core.hf.hf().kd(str);
        if (kd != null) {
            double xj = kd.xj();
            double hf = kd.hf();
            int w = kd.w();
            if (hfVar.c() == 3 || hfVar.c() == 4) {
                i = 1;
                double[] xj2 = hf.u().xj(hfVar.c(), d, d2, hfVar.en(), str);
                d3 = xj2[0];
                hfVar.y().put("price_from", Integer.valueOf((int) xj2[1]));
            } else {
                d3 = hfVar.c() == 2 ? hf.u().xj(3, str, w) : 0.0d;
                i = 1;
            }
            if (!kd.kd() && d3 > 0.0d) {
                if (kd.getType() == i) {
                    hf(d3, xj, hf, hfVar, copyOnWriteArrayList);
                } else if (kd.getType() == 2) {
                    xj(d3, xj, hf, hfVar, copyOnWriteArrayList);
                }
                List<com.bytedance.msdk.core.tf.w> y = com.bytedance.msdk.core.hf.hf().y(String.valueOf(hfVar.a()));
                if (y != null) {
                    Iterator<com.bytedance.msdk.core.tf.w> it = y.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bytedance.msdk.core.tf.w next = it.next();
                        if (d3 > next.y() && d3 <= next.kd()) {
                            hfVar.y().put("user_label_value", next);
                            break;
                        }
                    }
                }
            }
            hfVar.y().put("rule_id", kd.u());
            hfVar.y().put("ecpm", Double.valueOf(d3));
            hfVar.y().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : 1));
            hfVar.y().put("group_type", Integer.valueOf(hfVar.c()));
        }
        if (com.bytedance.msdk.xj.kd.w.hf()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.bytedance.msdk.xj.kd.w.xj("DynamicRuleCalculate", "rit：" + ((tf) copyOnWriteArrayList.get(i2)).yo() + ",level：" + ((tf) copyOnWriteArrayList.get(i2)).dk());
                }
            } else {
                com.bytedance.msdk.xj.kd.w.xj("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : hfVar.yy();
    }

    private static void xj(double d, double d2, double d3, com.bytedance.msdk.core.tf.hf hfVar, List<tf> list) {
        if (hfVar == null || d2 == 0.0d || d < hfVar.et()) {
            return;
        }
        if (d > hfVar.dk() && d3 <= 0.0d) {
            list.addAll(hfVar.yy());
        } else {
            xj(hfVar, d, d2, d3, list);
        }
    }

    public static void xj(com.bytedance.msdk.core.tf.hf hfVar, double d, double d2, double d3, List<tf> list) {
        double d4;
        Map<Integer, List<tf>> n = hfVar.n();
        if (n != null) {
            ArrayList arrayList = new ArrayList(n.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i2));
                } else {
                    List<tf> list2 = n.get(arrayList.get(i2));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.bytedance.msdk.core.c.hf.xj(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int i3 = -1;
            int i4 = size;
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                double d5 = i5;
                List<tf> list3 = n.get(arrayList2.get(i5));
                if (list3 != null) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= list3.size()) {
                            break;
                        }
                        tf tfVar = list3.get(i6);
                        if (tfVar != null && tfVar.v() == 0) {
                            double doubleValue = BigDecimal.valueOf(tfVar.ra()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d == doubleValue) {
                                if (i3 < 0) {
                                    i3 = Math.max((int) (d5 - d2), 0);
                                }
                                if (i4 == size || d == doubleValue) {
                                    if (d3 > 0.0d) {
                                        i4 = Math.min((int) (d5 + d3), size - 1);
                                    }
                                }
                            } else if (d > doubleValue) {
                                if (i3 < 0) {
                                    d4 = 2.0d;
                                    i3 = Math.max((int) Math.ceil((((d5 - 1.0d) + d5) / 2.0d) - d2), 0);
                                } else {
                                    d4 = 2.0d;
                                }
                                if (i4 == size) {
                                    if (d3 > 0.0d) {
                                        i4 = Math.min((int) Math.floor((((d5 - 1.0d) + d5) / d4) + d3), size - 1);
                                    }
                                }
                            }
                        }
                        i6++;
                    }
                    i4 = size - 1;
                }
            }
            if (i3 < 0) {
                i3 = 0;
            }
            if (i4 >= size) {
                i4 = size - 1;
            }
            int i7 = i3;
            double d6 = -1.0d;
            double d7 = -1.0d;
            double d8 = -1.0d;
            while (i7 <= i4) {
                List<tf> list4 = n.get(arrayList2.get(i7));
                if (list4 != null && list4.size() != 0) {
                    while (i < list4.size()) {
                        tf tfVar2 = list4.get(i);
                        if (tfVar2 != null) {
                            if (d7 < tfVar2.ra() || d7 == -1.0d) {
                                d7 = tfVar2.ra();
                            }
                            if (d8 > tfVar2.ra() || d8 == -1.0d) {
                                d8 = tfVar2.ra();
                            }
                            list.add(tfVar2);
                            if (i7 == i3) {
                                d6 = d7;
                            }
                        }
                        i++;
                    }
                }
                i7++;
                i = 0;
            }
            hfVar.y().put("upper_cpm_x", Double.valueOf(d6));
            hfVar.y().put("max_ecpm", Double.valueOf(d7));
            hfVar.y().put("min_ecpm", Double.valueOf(d8));
        }
    }
}
