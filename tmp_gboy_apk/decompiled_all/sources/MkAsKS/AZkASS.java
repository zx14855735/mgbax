package MkAsKS;

import ADYaiT.CtFAbx;
import AaHO0E.CmUvjW;
import MOpbMP.BI9f7h;
import android.R;
import android.net.Uri;
import android.os.Bundle;
import android.util.Xml;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;
import com.sigmob.sdk.downloader.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZkASS extends com.game.boy.activity.A5SV6n {

    /* renamed from: B25kr6, reason: collision with root package name */
    public ArrayAdapter f5453B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final File f5454B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ListView f5455B3GDIM;

    public AZkASS(File file) {
        this.f5454B2KMhB = file;
    }

    public abstract void AYUAbz(String str);

    public abstract void AZOQYO(String str);

    public final void AZkASS(int i) {
        String str = (String) this.f5453B25kr6.getItem(i);
        if (str.equals("Default")) {
            return;
        }
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = str;
        azoqyo.f28ASJ6gh = getString(2131886264) + str + "?";
        a4TApA.AmA8tU(R.string.ok, new BI9f7h(this, str, i, 1));
        a4TApA.AaHO0E(R.string.cancel, null);
        a4TApA.AMqCpz();
    }

    public abstract void AaHO0E(String str);

    public final void AcNBzu(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[f.a.c];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    return;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "复制文件失败: " + file.getName(), 0).show();
        }
    }

    public final int AlLFFp(String str) {
        int count = this.f5453B25kr6.getCount();
        for (int i = 0; i < count; i++) {
            if (((String) this.f5453B25kr6.getItem(i)).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public abstract String AmA8tU();

    public final void AzWtSf() {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.f5454B2KMhB));
            XmlSerializer newSerializer = Xml.newSerializer();
            newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            newSerializer.setOutput(bufferedOutputStream, "UTF-8");
            newSerializer.startDocument(null, null);
            newSerializer.startTag(null, "profiles");
            int count = this.f5453B25kr6.getCount();
            for (int i = 0; i < count; i++) {
                newSerializer.startTag(null, "profile");
                newSerializer.attribute(null, "name", (String) this.f5453B25kr6.getItem(i));
                newSerializer.endTag(null, "profile");
            }
            newSerializer.endTag(null, "profiles");
            newSerializer.endDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) {
        int i = ((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        int itemId = menuItem.getItemId();
        if (itemId == 2131297593) {
            AaHO0E((String) this.f5453B25kr6.getItem(i));
            return true;
        }
        if (itemId == 2131297590) {
            AZkASS(i);
            return true;
        }
        if (itemId != 2131297588) {
            if (itemId != 2131297622) {
                return super.onContextItemSelected(menuItem);
            }
            String str = (String) this.f5453B25kr6.getItem(i);
            if ("Default".equals(str)) {
                Toast.makeText(this, "Default 配置不能重命名", 0).show();
                return true;
            }
            View inflate = LayoutInflater.from(this).inflate(2131493225, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.edit);
            editText.setText(str);
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
            ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
            azoqyo.AMqCpz = "重命名";
            azoqyo.f41B7CMnp = inflate;
            a4TApA.AmA8tU(R.string.ok, new AZOQYO(this, editText, str, 0));
            a4TApA.AaHO0E(R.string.cancel, null);
            a4TApA.AMqCpz();
            return true;
        }
        String str2 = (String) this.f5453B25kr6.getItem(i);
        String AcNBzu2 = CtFAbx.AcNBzu(str2, "-1");
        if (AlLFFp(AcNBzu2) >= 0) {
            Toast.makeText(this, "名称已存在", 0).show();
            return true;
        }
        File A2egSU2 = KpHwm4.AYUAbz.A2egSU("config/layout");
        String encode = Uri.encode(str2);
        String encode2 = Uri.encode(AcNBzu2);
        File file = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-landscape.xml"));
        File file2 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-landscape.xml"));
        if (file.exists()) {
            AcNBzu(file, file2);
        }
        File file3 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-portrait.xml"));
        File file4 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-portrait.xml"));
        if (file3.exists()) {
            AcNBzu(file3, file4);
        }
        File file5 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-landscape-kbopen.xml"));
        File file6 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-landscape-kbopen.xml"));
        if (file5.exists()) {
            AcNBzu(file5, file6);
        }
        File file7 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-portrait-kbopen.xml"));
        File file8 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-portrait-kbopen.xml"));
        if (file7.exists()) {
            AcNBzu(file7, file8);
        }
        this.f5453B25kr6.add(AcNBzu2);
        AzWtSf();
        this.f5453B25kr6.notifyDataSetChanged();
        this.f5455B3GDIM.setItemChecked(this.f5453B25kr6.getCount() - 1, true);
        AYUAbz(AcNBzu2);
        Toast.makeText(this, "已复制为 " + AcNBzu2, 0).show();
        return true;
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492917);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().AmA8tU();
        getSupportActionBar().AlLFFp(true);
        materialToolbar.setNavigationIcon(2131230963);
        materialToolbar.setNavigationOnClickListener(new ADYaiT.A5SV6n(11, this));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.f5454B2KMhB).getDocumentElement().getElementsByTagName("profile");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                arrayList.add(((Element) elementsByTagName.item(i2)).getAttribute("name"));
            }
        } catch (FileNotFoundException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            arrayList.add("Default");
        }
        this.f5453B25kr6 = new ArrayAdapter(this, R.layout.simple_list_item_single_choice, arrayList);
        ListView listView = (ListView) findViewById(R.id.list);
        this.f5455B3GDIM = listView;
        listView.setOnCreateContextMenuListener(this);
        this.f5455B3GDIM.setChoiceMode(1);
        this.f5455B3GDIM.setAdapter((ListAdapter) this.f5453B25kr6);
        this.f5455B3GDIM.setOnItemClickListener(new CmUvjW(1, this));
        int AlLFFp2 = AlLFFp(AmA8tU());
        if (AlLFFp2 < 0) {
            AYUAbz("Default");
        } else {
            i = AlLFFp2;
        }
        this.f5455B3GDIM.setItemChecked(i, true);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getMenuInflater().inflate(2131623950, contextMenu);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(2131623949, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131297615) {
            View inflate = LayoutInflater.from(this).inflate(2131493225, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.edit);
            editText.setText(2131886691);
            OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
            a4TApA.B2KMhB(2131886623);
            a4TApA.f81AcNBzu.f41B7CMnp = inflate;
            a4TApA.AmA8tU(R.string.ok, new M0ztbm.ADYaiT(this, 3, editText));
            a4TApA.AaHO0E(2131886161, null);
            a4TApA.AMqCpz();
            return true;
        }
        if (itemId == 2131297593) {
            int checkedItemPosition = this.f5455B3GDIM.getCheckedItemPosition();
            if (checkedItemPosition != -1) {
                AaHO0E((String) this.f5453B25kr6.getItem(checkedItemPosition));
                return true;
            }
        } else {
            if (itemId != 2131297590) {
                return super.onOptionsItemSelected(menuItem);
            }
            int checkedItemPosition2 = this.f5455B3GDIM.getCheckedItemPosition();
            if (checkedItemPosition2 != -1) {
                AZkASS(checkedItemPosition2);
            }
        }
        return true;
    }
}
