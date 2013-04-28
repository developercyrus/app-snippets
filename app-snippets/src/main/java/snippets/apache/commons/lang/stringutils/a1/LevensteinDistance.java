package snippets.apache.commons.lang.stringutils.a1;

import org.apache.commons.lang.StringUtils;

public class LevensteinDistance {
    public static int getDistanceValue(String arg0, String arg1) {
        return StringUtils.getLevenshteinDistance(arg0, arg1);
    }
        
    public static void main(String[] args) {
        System.out.println(getDistanceValue("insurance", "insured"));
        System.out.println(getDistanceValue("insurance", "coffee"));
    }
}
