## 题目描述

## 解法

```java
// n为4的时候通过不了
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if  (n==1) {
            result = Arrays.asList("()");
            return result;
        }
        List<String> temp = generateParenthesis(n-1);
        for (int i = 0; i < temp.size(); i++) {
            result.add("(" + temp.get(i) + ")");
            result.add("()" + temp.get(i));
            if (!("()"+temp.get(i)).equals(temp.get(i)+"()")) result.add(temp.get(i)+"()");
        }
        /* list的遍历方式
        for (String str : temp) {
            result.add("(" + str + ")");
            result.add("()" + str);
            if (!("()"+str).equals(str+"()")) result.add(str+"()");
        }*/
        return result;
    }
}
输出
["(((())))","()((()))","((()))()","(()(()))","()()(())","()(())()","((())())","()(())()","(())()()","((()()))","()(()())","(()())()","(()()())","()()()()"]
预期结果
["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
```

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
```