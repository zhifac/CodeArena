package org.codearena.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ML on 2016/5/12.
 */
public class RegTest {
    @Test
    public void test() {
        String teststr = "        000-000-0000      // covered by [1]\n" +
            "        000 000 0000      //dup in XiYuan's patterns\n" +
            "        000.000.0000      //dup\n" +
            "        (000)000-0000     //dup\n" +
            "        (000)000 0000     // covered by [2]\n" +
            "        (000)000.0000     // covered by [3]\n" +
            "        (000) 000-0000    //dup\n" +
            "        (000)-000 0000    // new [3]\n" +
            "        (000) 000 0000    // [2]\n" +
            "        (000) 000.0000    // [2]\n" +
            "        000-0000          //dup\n" +
            "        000 0000          // [1]\n" +
            "        000.0000          // [1]\n" +
            "        0000000           //dup\n" +
            "        0000000000        //dup\n" +
            "        00000000000       // Chinese mobile phone number\n" +
            "        (000)0000000      // [2]\n" +

            "       (000) 000-0000                   // [2]\n" +
            "       0000000000                       // [1]\n" +
            "       000-000-0000                     // [3]\n" +
            "       00-00-00000000                   // [5]\n" +
            "       000 000-0000                     // [1]\n" +
            "       000 000 0000                     // [1]\n" +
            "       (000)000-0000                    // [2]\n" +
            "       (000) 000-0000* Ext 0000         // [6]\n" +
            "       000.000.0000                     // [1]\n" +
            "       (000)000 - 0000                  // [2]\n" +
            "       (****) 000-000-0000              // [1]\n" +
            "       000/000-0000                     // [1]\n" +
            "       000000000000                     // [5]\n" +
            "       00*0000000                       // [7]\n" +
            "       000-000-0000 ex 000              // [6]\n" +
            "       0000000000000                    // [8]\n" +
            "       000  000 0000                    // [1]\n" +
            "       (000)000-0000 x00                // [6]\n" +
            "       000-0000                         // [1]\n" +
            "       000 000 00 00                    // [9]\n" +
            "       +0000-0000000                    // [10]\n" +
            "       (00000)000000                    // [14]\n" +
            "       0000000000                       //dup\n" +
            "       000-000-0000-0000                // [9]\n" +
            "       000-000-00000                    // [1]\n" +
            "       +0000000000000                   // [8]\n" +
            "       00000 000000                     // [10]\n" +
            "       000.000.0000 x. 0000             // [6]\n" +
            "       0-000-000-0000                   // [9]\n" +
            "       000 00000000                     // [1]\n" +
            "       000-000-0000 000                 // [9]\n" +
            "       0000-0000000                     // [10]\n" +
            "       (000) 000-0000 (***)             // [11]\n" +
            "       0000000                          // [1]\n" +
            "       00000000                         // [1]\n" +
            "       +00 0000000000                   // [12]\n" +
            "       +00-00-0000-0000                 // [12]\n" +
            "       000 000 0000 x 000               // [6]\n" +
            "       000-000 0000 (****)              // [11]\n" +
            "       000-000-0000 x000                // [6]\n" +
            "       (000)000-0000x0000               // [6]\n" +
            "       000-0000000                      // [1]\n" +
            "       ** 00000 000 0000                // [13]\n" +
            "       +00000000000                     // [8]\n" +
            "       000-000000                       // [1]\n" +
            "       000-000-000-0000                 // [13]\n" +
            "       +000000000000                    // [8]\n" +
            "       0000-000-0000                    // [1]\n" +
            "       (000)-00-00-000000               // [16]\n" +
            "       00 00 0 00 00 00 00              // [15]\n" +
            "       000-000000                       // [1]\n" +
            "       0000000000000                    // [8]\n" +
            "       00-0000-000000                   // [1]\n" +
            "       000-000-0000 ext.000             // [6]\n" +
            "       000 00 000000                    // [1]\n" +
            "       000-0000                         // [1]\n" +
            "       000-0000000                      // [1]\n" +
            "       000/000/0000                     // [1]\n" +
            "       00000/000000                     // [14]\n" +
            "       0 (000) 000-0000 (*)             // [11]\n" +
            "       00 0 00 00 00 00                 // [15]\n" +
            "       *000-000 00 00                   // [9]\n" +
            "       (000)000-0000x000                // [6]\n" +
            "       0000-0000000000                  // [17]\n" +
            "       +00-0000-000000 (000000)         // [22]\n" +
            "       000/0/0000000                    // [20]\n" +
            "       000(000)0000ext 0000             // [6]\n" +
            "       000.000.0000 x. 000              // [6]\n" +
            "       00000-00-00000                   // [21]\n" +
            "       000-000-0000 ext 000             // [6]\n" +
            "       000-00-0000                      // [1]\n" +
            "       000-0000000                      // [1]\n" +
            "       0000 000 0000000                 // [17]\n" +
            "       000-000-0000x000                 // [6]\n" +
            "       000--000--0000                   // [1]\n" +
            "       0 (000) 000-0000                 //  [2]\n" +
            "       +00 (000) 0000000                // [18]\n" +
            "       +00-0000-000000                  // [18]\n" +
            "       +000 (000) 000000                // [18]\n" +
            "       (00000)0000000                   // [14]\n" +
            "       0000 000 0000 ext. 0000          // [6]\n" +
            "       0000 (000) 0000000               // [17]\n" +
            "       00-00-000-0000                   // [12]\n" +
            "       +00-00-0000000                   // [19]\n" +
            "       0000-00-00000000                 // [17]\n" +
            "       00/0000000                       // [1]\n" +
            "       000 000 0000 ext. 000            // [6]\n" +
            "       +00 00 0000000                   // [19]\n" +
            "       000-000-0000x00                  // [6]\n" +
            "       0-000-000-0000 ext 00000         // [6]\n" +
            "       00-00-0000-0000                  // [12]\n" +
            "       +00(0)0000000000                 // [8]\n" +
            "       0000000                          // [1]\n" +
            "       000 000 0000 E: 000              // [6]";
        String[] regs = new String[]{"(\\(\\*+\\)\\s)?(\\d{2,4}[-\\.\\s/]*)?\\d{2,4}[-\\.\\s/]*\\d{4,6}",
            "(\\d[-\\s]*)?\\(\\d{3}\\)\\s*\\d{3}[-\\.\\s]*\\d{4}",
            "\\(\\d{3}\\)-\\d{3}[-\\.\\s]??\\d{4}",
            "(^|(?<!\\d))\\d{3}[-\\.\\s]??\\d{4}",
            "\\d{2}[-]?\\d{2}[-]?\\d{8}",
            "(\\d[-]?)?\\(?\\d{3}\\)?[-\\.\\s\\(]*\\d{3}[-\\.\\s\\)]*\\d{4}\\*?\\s*([eE]xt|[eE][Xx]?|[eE]?[Xx])[.:\\s]*\\d{2,5}",
            "\\d{2}\\*\\d{7}",
            "\\+?(\\d{11,13}|(\\d{2}\\(\\d\\)\\d{10}))",
            "(\\*|\\+)?\\d{1,3}[-\\.\\s/]*\\d{3}[-\\.\\s/]*\\d{2,4}[-\\.\\s/]*\\d{2,4}",
            "\\+?\\d{4,5}[-\\.\\s/]*\\d{6,7}",
            "\\d[-\\.\\s/]+\\(?\\d{3}\\)?[-\\.\\s/]*\\d{3}[-\\.\\s/]*\\d{4}\\s+\\(\\*+\\)",
            "\\+?\\d{2}[-\\.\\s/]+((\\d{2}[-\\.\\s/]+\\d{3,4}[-\\.\\s/]+\\d{4})|\\d{10})",
            "\\*+[-\\.\\s/]+\\d{5}[-\\.\\s/]+\\d{3}[-\\.\\s/]+\\d{4}",
            "\\(?\\d{5}\\)?[-\\.\\s/]+\\d{6,7}",
            "\\d{2}[-\\.\\s/]+(\\d{2}[-\\.\\s/]+)?\\d([-\\.\\s/]+\\d{2}){4}",
            "\\(\\d{3}\\)-\\d{2}-\\d{2}-\\d{6}",
            "\\d{4}[-\\.\\s/]+(\\d{2,3}|\\(\\d{3}\\))[-\\.\\s/]*\\d{7,8}",
            "\\+\\d{2,3}[-\\.\\s/]+(\\d{4}|\\(\\d{3}\\))[-\\.\\s/]+\\d{6,7}",
            "\\+\\d{2}[-\\.\\s/]+\\d{2}[-\\.\\s/]+\\d{7}",
            "\\d{3}[-\\.\\s/]+\\d[-\\.\\s/]+\\d{7}",
            "\\d{5}-\\d{2}-\\d{5}",
            "\\+\\d{2}-\\d{4}-\\d{6}\\s+\\(\\d{6}\\)"};


        ArrayList<String> srcStr = new ArrayList<String>();
        for (String line: teststr.split("\n")) {
            String tl = line.replaceAll("(\\s+//.*$|^\\s+)", "");
            srcStr.add(tl);
            //System.out.println(tl);
        }
        Collections.sort(srcStr, new StringComp());
        List<String> regstr = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        for (String s: srcStr) {
            String rex = RegTest.genRegex(s);
            regstr.add(rex);
        }
      /*  for (int i = 0; i < regstr.size(); i++) {
            if (!set.contains(regstr.get(i))) {
                System.out.println("'" + regstr.get(i) + "',");
                set.add(regstr.get(i));
            }
        }*/
        for (int i = 0; i < regstr.size(); i++) {
            if (!set.contains(srcStr.get(i))) {
                System.out.println(srcStr.get(i) + " <-- " + regstr.get(i));
                set.add(srcStr.get(i));
            }
        }
        int c = 0;
/*        for (String line: teststr.split("\n")) {
            c++;
            for (String r: regstr) {
                String r2 = ".*(?<phone>" + r + ").*";
                Pattern p = Pattern.compile(r2);
                Matcher m = p.matcher(line);
                if (m.matches()) {
                    System.out.println("line " + c + " match :" + m.group("phone"));
                    break;
                }
            }
        }*/

    }

    public static String genRegex(String src) {
        char[] sensitive = new char[]{'(', ')', '.', '*', '+', ' '};
        String regex = "";
        int digitNo = 0;
        String nonDigit = "";
        char nonDigitc = ' ';
        int nonDigitCnt = 0;
        int i = 0;
        for (char c: src.toCharArray()) {

            if (nonDigitCnt > 0 && nonDigitc != c) {
                if (nonDigitCnt > 1) {
                    regex += nonDigit + "{" + nonDigitCnt + "}";
                } else {
                    regex += nonDigit;
                }
                nonDigitCnt = 0;
            }
            if (c == '0') {
                digitNo++;
            } else {
                nonDigitc = c;
                if (digitNo > 0) {
                    if (digitNo > 1) {
                        regex += "\\d{" + digitNo + "}";
                    } else {
                        regex += "\\d";
                    }
                    digitNo = 0;
                }
                boolean found = false;
                for (char x: sensitive) {
                    if (c == x) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    if (c == ' ') {
                        nonDigit = "\\s";
                    } else {
                        nonDigit = "\\" + c;
                    }
                } else {
                    nonDigit = c + "";
                }
                nonDigitCnt ++;
            }
            if (i == src.length() - 1) {
                if (nonDigitCnt > 0) {
                    if (nonDigitCnt > 1) {
                        regex += nonDigit + "{" + nonDigitCnt + "}";
                    } else {
                        regex += nonDigit;
                    }
                }
                if (digitNo > 0) {
                    if (digitNo > 1) {
                        regex += "\\d{" + digitNo + "}";
                    } else {
                        regex += "\\d";
                    }
                }
            }
            i++;
        }
        return regex;
    }
    private class StringComp implements Comparator<String> {
        @Override
        public int compare(String src, String target ){
            return target.length()- src.length();
        }
    }
}
