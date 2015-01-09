package snippets.html.parser.htmlcleaner.a2;

import java.io.Reader;
import java.io.StringReader;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class Main {
    public static void main(String[] args) throws Exception {  
        Reader sr = new StringReader("<div class=\"entry cald3\" id=\"id_58816\"><div class=\"posblock \"><div class=\"posblock_b \"><div class=\"gwblock \"><div class=\"gwblock_h\"> <h1 class=\"header\"> <span class=\"hw \"><span class=\"BASE \">perfect</span><span class=\"SEP \"> </span></span> <span class=\"pos \" title=\"A word that refers to a person, place, idea, event or thing.\">noun</span> </h1> <div class=\"additional_header\"> <span class=\"SEP \"> </span><span class=\"posabb \" title=\"noun\">n</span><span class=\"SEP \"> </span><span class=\"grams \"><span class=\"SEP \">[</span><span class=\"gram \" title=\"Singular noun: a noun only used in singular form and which has no plural form.\">S</span><span class=\"SEP \">]</span></span><span class=\"SEP \"> </span><span class=\"lab \"><span class=\"usage \" title=\"Used in connection with a particular area of work or study.\">specialized</span> </span> </div> </div> <div class=\"gwblock_b \"> <div class=\"sense \"></div> <div class=\"phraserec \"> <div class=\"phraserec_h \"> <div class=\"phrase \"> <h4 class=\"BASE \">the perfect (tense)</h4> <span class=\"SEP \"> </span> </div> </div> <div class=\"phraserec_b \"><div class=\"sense \"> <div class=\"sense_b \"> <span class=\"SEP \"> </span><span class=\"def parentof__def__is__sense_b\">the tense of a verb that shows action that has happened in the past or before another time or event</span> </div> <div class=\"sense_t \"><div class=\"examp \"><span class=\"eg parentof__eg__is__examp eg parentof__eg__is__examp__firstchild\">In English, the perfect is formed with 'have' and the past participle of the verb.</span></div></div> </div></div> </div> </div> <div class=\"gwblock_t \"></div> </div></div></div></div> <br/><span class='small' id='definition_line'>(Definition of <span class='headword'><span class='hwd'>perfect</span> <span class='pos'>noun</span></span> from the Cambridge Advanced Learner's Dictionary)</span>");
        HtmlCleaner cleaner = new HtmlCleaner();  
        TagNode node = cleaner.clean(sr);  
        Object[] ns;  
        
        ns = node.getElementsHavingAttribute("class", true);
        for(Object on : ns) {  
            TagNode n = (TagNode) on;  
            System.out.println(n.getName() + " class=" + n.getAttributeByName("class"));  
        }  
    }
}
