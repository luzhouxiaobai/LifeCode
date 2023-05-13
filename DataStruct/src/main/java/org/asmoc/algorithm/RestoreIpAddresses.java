package org.asmoc.algorithm;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new LinkedList<>();
        String sb = "";
        helper(s, 0, sb, res, 0);
        return res;

    }

    public void helper(String s, int start, String sb, List<String> res, int len) {
        if (start>=s.length() && len==4) {
            res.add(String.valueOf(sb.substring(0, sb.length()-1)));
            return;
        }
        if (start<s.length() && len < 4) {
            for (int i=start; i<Math.min(s.length(), start+3); i++) {
                if (Integer.parseInt(s.substring(start, i+1))<256 && (s.substring(start, i + 1).equals("0") || s.charAt(start)!='0')) {
                    helper(s, i+1, sb+s.substring(start, i+1) + ",", res, len+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s  = "5525511135";
        RestoreIpAddresses r = new RestoreIpAddresses();
        r.restoreIpAddresses(s);
    }
}
