package com.czhj.sdk.common.Database;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SQLiteBuider {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10542a = "SQLiteBuider";
    private static Map<String, String> b;

    public static class CreateTable {

        /* renamed from: a, reason: collision with root package name */
        String f10543a;
        String b;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private String f10544a = null;
            private Map<String, String> b = null;
            private Map<String, String> c = null;
            private boolean d;

            public Builder autoincrement(boolean z) {
                this.d = z;
                return this;
            }

            public CreateTable build() {
                StringBuilder sb = new StringBuilder("create table if not exists ");
                sb.append(this.f10544a);
                sb.append(" ( ");
                List b = SQLiteBuider.b(this.b);
                if (b.size() > 1) {
                    Iterator it = SQLiteBuider.b(this.c).iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append(" ,");
                    }
                    sb.append(" primary key ( ");
                    Iterator<String> it2 = this.b.keySet().iterator();
                    while (it2.hasNext()) {
                        sb.append(it2.next());
                        if (it2.hasNext()) {
                            sb.append(" ,");
                        } else {
                            sb.append(" )");
                        }
                    }
                } else {
                    sb.append(this.d ? "id integer primary key AUTOINCREMENT" : String.format("%s primary key ", b.get(0)));
                    this.c.remove(this.b.keySet().iterator().next());
                    for (String str : SQLiteBuider.b(this.c)) {
                        sb.append(" ,");
                        sb.append(str);
                        sb.append(" ");
                    }
                }
                sb.append(" ); ");
                CreateTable createTable = new CreateTable();
                createTable.b = sb.toString();
                createTable.f10543a = this.f10544a;
                return createTable;
            }

            public Builder setColumns(Map<String, String> map) {
                this.c = map;
                return this;
            }

            public Builder setPrimaryKey(String str, String str2) {
                if (this.b == null) {
                    this.b = new HashMap();
                }
                this.b.put(str, str2);
                return this;
            }

            public Builder setTableName(String str) {
                this.f10544a = str;
                return this;
            }
        }
    }

    public static class CreateTriggerBuilder {

        /* renamed from: a, reason: collision with root package name */
        private String f10545a = null;
        private String b = null;
        private String c = null;
        private String d = null;

        public String build() {
            String str = this.f10545a;
            String str2 = this.b;
            return A2egSU.AzWtSf(J3FDQU.A2egSU.BChYOn("create trigger if not exists ", str, " after ", str2, " on "), this.c, " begin ", this.d, " end;");
        }

        public CreateTriggerBuilder setExecSql(String str) {
            this.d = str;
            return this;
        }

        public CreateTriggerBuilder setOnAction(String str) {
            this.b = str;
            return this;
        }

        public CreateTriggerBuilder setOnTableName(String str) {
            this.c = str;
            return this;
        }

        public CreateTriggerBuilder setTriggerName(String str) {
            this.f10545a = str;
            return this;
        }
    }

    public static class Insert {

        /* renamed from: a, reason: collision with root package name */
        String f10546a;
        String b;
        Map<String, Object> c;
        List<Object> d;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private String f10547a = null;
            private Map<String, Object> b = null;

            public Insert build() {
                List<Object> asList = Arrays.asList(this.b.keySet().toArray());
                StringBuilder sb = new StringBuilder("insert or replace into ");
                sb.append(this.f10547a);
                StringBuilder sb2 = new StringBuilder("(");
                StringBuilder sb3 = new StringBuilder("(");
                int i = 0;
                while (i < asList.size()) {
                    sb2.append(asList.get(i));
                    sb3.append("?");
                    i++;
                    if (i < asList.size()) {
                        sb2.append(", ");
                        sb3.append(", ");
                    }
                }
                sb2.append(")");
                sb3.append(")");
                sb.append((CharSequence) sb2);
                sb.append(" values ");
                sb.append((CharSequence) sb3);
                Insert insert = new Insert();
                insert.f10546a = this.f10547a;
                insert.d = asList;
                insert.c = this.b;
                insert.b = sb.toString();
                return insert;
            }

            public void setColumnValues(Map<String, Object> map) {
                this.b = map;
            }

            public void setTableName(String str) {
                this.f10547a = str;
            }
        }

        public List<Object> getColumns() {
            return this.d;
        }

        public String getSql() {
            return this.b;
        }

        public String getTableName() {
            return this.f10546a;
        }

        public Map<String, Object> getValues() {
            return this.c;
        }
    }

    public static class Update {

        /* renamed from: a, reason: collision with root package name */
        String f10548a;
        String b;
        Map<String, Object> c;
        String d;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private String f10549a = null;
            private Map<String, Object> b = null;
            private String c = null;

            public Update build() {
                StringBuilder sb = new StringBuilder("update ");
                sb.append(this.f10549a);
                sb.append(" set ");
                Iterator<String> it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    StringBuilder A5SV6n2 = AYUAbz.A5SV6n(next, " = ");
                    A5SV6n2.append(this.b.get(next));
                    sb.append(A5SV6n2.toString());
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
                if (!TextUtils.isEmpty(this.c)) {
                    sb.append(" " + this.c);
                }
                Update update = new Update();
                update.f10548a = this.f10549a;
                update.c = this.b;
                update.d = this.c;
                update.b = sb.toString();
                return update;
            }

            public void setColumnValues(Map<String, Object> map) {
                this.b = map;
            }

            public void setTableName(String str) {
                this.f10549a = str;
            }

            public void setWhere(String str) {
                this.c = str;
            }
        }

        public String getSql() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> b(Map<String, String> map) {
        String str;
        ArrayList arrayList = new ArrayList(map.size());
        for (String str2 : map.keySet()) {
            String lowerCase = map.get(str2).toLowerCase();
            lowerCase.getClass();
            switch (lowerCase) {
                case "int":
                case "long":
                    str = "integer";
                    break;
                case "text":
                case "java.lang.string":
                    str = a.b;
                    break;
                default:
                    str = "blob";
                    break;
            }
            arrayList.add(str2 + " " + str + " ");
        }
        return arrayList;
    }
}
