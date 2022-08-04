package com.hkllyx.solution.leetcode;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.test.Assertions;
import com.hkllyx.solution.util.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A <strong>valid IP address</strong> consists of exactly four integers separated by single dots. Each integer is between <code>0</code> and <code>255</code> (<strong>inclusive</strong>) and cannot have leading zeros.</p>
 *
 * <ul>
 *  <li>For example, <code>"0.1.2.201"</code> and <code>"192.168.1.1"</code> are <strong>valid</strong> IP addresses, but <code>"0.011.255.245"</code>, <code>"192.168.1.312"</code> and <code>"192.168@1.1"</code> are <strong>invalid</strong> IP addresses.</li>
 * </ul>
 *
 * <p>Given a string <code>s</code> containing only digits, return <em>all possible valid IP addresses that can be formed by inserting dots into </em><code>s</code>. You are <strong>not</strong> allowed to reorder or remove any digits in <code>s</code>. You may return the valid IP addresses in <strong>any</strong> order.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "25525511135"
 * <strong>Output:</strong> ["255.255.11.135","255.255.111.35"]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "0000"
 * <strong>Output:</strong> ["0.0.0.0"]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "101023"
 * <strong>Output:</strong> ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 *  <li><code>1 &lt;= s.length &lt;= 20</code></li>
 *  <li><code>s</code> consists of digits only.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 981</li><li>👎 0</li></div>
 *
 * @author xiaoyong3
 * @date 2022/08/02
 */
@Solution(no = "93", title = "Restore IP Addresses", difficulty = Difficulty.MEDIUM, url = "https://leetcode-cn.com/problems/restore-ip-addresses/")
public class RestoreIpAddresses {

    public static void main(String[] args) {
        Assertions.assertExpect("[255.255.11.135, 255.255.111.35]", "25525511135");
        Assertions.assertExpect("[0.0.0.0]", "0000");
        Assertions.assertExpect("[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]", "101023");
    }

    @Test
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        char[] ip = new char[s.length() + 4];
        dfs(s, 0, ip, 0, 0, res);
        return res;
    }

    private void dfs(String s, int i, char[] ip, int j, int part, List<String> res) {
        if (part >= 4) {
            if (i >= s.length()) {
                res.add(new String(ip, 1, ip.length - 1));
            }
            return;
        }
        ip[j++] = '.';
        // 计算i的最值，最小值假设之后部分都是3位，最大值则假设之后部分都是1位
        int min = Math.max(s.length() - 3 * (3 - part), i + 1);
        int max = Math.min(s.length() - (3 - part), i + 3);
        int num = 0;
        while (i < max) {
            char cur = s.charAt(i++);
            ip[j++] = cur;
            num = num * 10 + cur - '0';
            if (i >= min && num <= 255) {
                dfs(s, i, ip, j, part + 1, res);
            }
            // 不能连续0
            if (num == 0) {
                break;
            }
        }
    }
}
