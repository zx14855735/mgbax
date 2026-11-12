/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Host-side check that the emulator screen and its chrome are stacked, not
 * placed in a row. Showing the menu bar or the key editor must not take space
 * away from the stage: that used to rescale and move the game right while the
 * player was placing the controls.
 */
public final class LayoutOverlayTest {
    private static final String ANDROID = "http://schemas.android.com/apk/res/android";

    public static void main(String[] args) throws Exception {
        Element root = parse().getDocumentElement();
        check("FrameLayout".equals(root.getTagName()), "the screen is a stacked container");

        Element stage = directChild(root, "screen_area");
        Element menu = directChild(root, "menu_bar");
        Element editor = directChild(root, "layout_editor");
        check(stage != null, "screen_area is a direct child of the root");
        check(menu != null, "menu_bar is a direct child of the root");
        check(editor != null, "layout_editor is a direct child of the root");

        check("match_parent".equals(attr(stage, "layout_width")), "the stage fills the width");
        check("match_parent".equals(attr(stage, "layout_height")), "the stage fills the height");
        check(!stage.hasAttributeNS(ANDROID, "layout_weight"),
                "the stage must not share height with the chrome");

        check(before(root, stage, menu), "the menu bar is drawn above the stage");
        check(before(root, stage, editor), "the key editor is drawn above the stage");
        check("top".equals(attr(editor, "layout_gravity")), "the editor floats at the top");
        // The shoulder keys sit in the top corners in landscape. The editor's
        // side margin must clear L/R (10..82dp plus 10dp of touch slop), or
        // those two keys cannot be selected while the layout is being edited.
        check("@dimen/layout_editor_side_margin".equals(attr(editor, "layout_marginStart")),
                "the editor side margin is a resource");
        check("@dimen/layout_editor_side_margin".equals(attr(editor, "layout_marginEnd")),
                "the editor side margin is a resource");
        check(dimenDp("layout_editor_side_margin", "values-land") >= 92,
                "the landscape editor clears the L/R keys");
        check(dimenDp("layout_editor_side_margin", "values") == 0,
                "the portrait editor spans the stage");
        // The activity switches the menu bar to bottom gravity in portrait.
        check("top".equals(attr(menu, "layout_gravity")), "the menu bar starts at the top");
        System.out.println("LayoutOverlayTest ok");
    }

    private static Document parse() throws Exception {
        return parse(findFile(
                "app/src/main/res/layout/activity_emulator.xml",
                "android/app/src/main/res/layout/activity_emulator.xml"));
    }

    private static Document parse(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        return factory.newDocumentBuilder().parse(file);
    }

    private static File findFile(String... candidates) {
        for (String candidate : candidates) {
            File probe = new File(candidate);
            if (probe.isFile()) {
                return probe;
            }
        }
        throw new AssertionError("resource not found: " + String.join(", ", candidates));
    }

    /** Reads a dp dimension from a values folder in the host test. */
    private static int dimenDp(String name, String folder) throws Exception {
        File file = findFile(
                "app/src/main/res/" + folder + "/dimens.xml",
                "android/app/src/main/res/" + folder + "/dimens.xml");
        NodeList entries = parse(file).getElementsByTagName("dimen");
        for (int i = 0; i < entries.getLength(); i++) {
            Element entry = (Element) entries.item(i);
            if (name.equals(entry.getAttribute("name"))) {
                String value = entry.getTextContent().trim();
                check(value.endsWith("dp"), name + " is expressed in dp");
                return Integer.parseInt(value.substring(0, value.length() - 2));
            }
        }
        throw new AssertionError("dimen not found: " + name + " in " + folder);
    }

    /** The direct child with this id, ignoring prefixes such as {@code @+id/}. */
    private static Element directChild(Element parent, String id) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element child = (Element) node;
            String value = attr(child, "id");
            if (value != null && value.endsWith("/" + id)) {
                return child;
            }
        }
        return null;
    }

    /** True when the first element comes before the second one in draw order. */
    private static boolean before(Element parent, Element first, Element second) {
        NodeList children = parent.getChildNodes();
        int firstIndex = -1;
        int secondIndex = -1;
        int element = 0;
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (children.item(i) == first) {
                firstIndex = element;
            }
            if (children.item(i) == second) {
                secondIndex = element;
            }
            element++;
        }
        return firstIndex >= 0 && secondIndex > firstIndex;
    }

    /** An android: attribute, whether or not the parser kept the prefix. */
    private static String attr(Element element, String name) {
        String value = element.getAttributeNS(ANDROID, name);
        if (value == null || value.isEmpty()) {
            value = element.getAttribute("android:" + name);
        }
        return value;
    }

    private static void check(boolean condition, String label) {
        if (!condition) {
            throw new AssertionError(label);
        }
    }
}
