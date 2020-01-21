# 题目描述

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

|case|输入|输出|
|:--|:--|:--|
|1|`"()"`|`true`|
|2|`"()[]{}"`|`true`|
|3|`"(]"`|`false`|


## 解法

```java
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i<s.length(); i++) {
            char temp = s.charAt(i);

            if (map.containsKey(temp)) {
                // if (stack.isEmpty()) return false;
                // char topElement = stack.pop();
                char topElement = stack.isEmpty()? '#' : stack.pop();
                if (!(topElement == map.get(temp))) return false; 
            } else {
                stack.push(temp);
            }
        }
        // if (stack.isEmpty()) return true;
        // else return false;\
        return stack.isEmpty();

    }
}
```

使用数组代替栈结构

```java
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c; 
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }
}
```
