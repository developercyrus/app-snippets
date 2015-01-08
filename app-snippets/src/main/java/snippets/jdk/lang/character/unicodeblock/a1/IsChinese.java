package snippets.jdk.lang.character.unicodeblock.a1;

import java.lang.Character.UnicodeBlock;
import java.util.HashSet;
import java.util.Set;

public class IsChinese {
    public static void main(String[] args) {
        Set<UnicodeBlock> chineseUnicodeBlocks = new HashSet<UnicodeBlock>();
        
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_COMPATIBILITY);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        chineseUnicodeBlocks.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        chineseUnicodeBlocks.add(UnicodeBlock.KANGXI_RADICALS);
        chineseUnicodeBlocks.add(UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS);

        String mixedChinese = "查詢促進民間參與公共建設法（210ＢＯＴ法）";

        for (char c : mixedChinese.toCharArray()) {
            if (chineseUnicodeBlocks.contains(UnicodeBlock.of(c))) {
                System.out.println(c + " is chinese");
            } else {
                System.out.println(c + " is not chinese");
            }
        }
    }
}

