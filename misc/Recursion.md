生活中的例子:

1. 查词典
2. 假设你在一个电影院，你想知道自己坐在哪一排，但是前面人很多，你懒得去数了，于是你问前一排的人「你坐在哪一排？」，这样前面的人 (代号 A) 回答你以后，你就知道自己在哪一排了——只要把 A 的答案加一，就是自己所在的排了。不料 A 比你还懒，他也不想数，于是他也问他前面的人 B「你坐在哪一排？」，这样 A 可以用和你一模一样的步骤知道自己所在的排。然后 B 也如法炮制。直到他们这一串人问到了最前面的一排，第一排的人告诉问问题的人「我在第一排」。最后大家就都知道自己在哪一排了。
3. 古之欲明明德于天下者，先治其国；欲治其国者，先齐其家；欲齐其家者，先修其身；欲修其身者，先正其心；欲正其心者，先诚其意；欲诚其意者，先致其知，致知在格物。物格而后知至，知至而后意诚，意诚而后心正，心正而后身修，身修而后家齐，家齐而后国治，国治而后天下平。
4. 一个小朋友坐在第10排，他的作业本被小组长扔到了第1排，小朋友要拿回他的作业本，可以怎么办？他可以拍拍第9排小朋友，说：“帮我拿第1排的本子”，而第9排的小朋友可以拍拍第8排小朋友，说：“帮我拿第1排的本子”...如此下去，消息终于传到了第1排小朋友那里，于是他把本子递给第2排，第2排又递给第3排...终于，本子到手啦！这就是递归，拍拍小朋友的背可以类比函数调用，而小朋友们都记得要传消息、送本子，是因为他们有记忆力，这可以类比栈。
5. 数学归纳法

递归和循环的关系: 循环可以用递归实现, 反之则不一定

要使用递归首先要知道两件事：

- 递归出口(终止递归的条件)
- 递归表达式(规律)


```java
// 递归和循环的关系1
int sum = 0;
for (int i = 1; i <= 100; i++) {

    sum = sum + i;

}
System.out.println("公众号：Java3y：" + sum);
    
 
public static void main(String[] args) {
    System.out.println("公众号：Java3y：" + sum(100));
}

/**
 *
 * @param n 要加到的数字，比如题目的100
 * @return
 */
public static int sum(int n) {

    if (n == 1) {
        return 1;
    } else {
        return sum(n - 1) + n;
    }
}

public static void main(String[] args) {
    System.out.println("公众号：Java3y：" + sum(100));
}

/**
 *
 * @param n 要加到的数字，比如题目的100
 * @return
 */
public static int sum(int n) {

    //如果递归出口为4，(1+2+3+4)
    if (n == 4) {
        return 10;
    } else {
        return sum(n - 1) + n;
    }
}

// 递归和循环的关系2 
int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 2};

//将数组的第一个假设是最大值
int max = arrays[0];

for (int i = 1; i < arrays.length; i++) {

    if (arrays[i] > max) {
        max = arrays[i];
    }
}

System.out.println("公众号：Java3y：" + max);


public static void main(String[] args) {

    int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};

    System.out.println("公众号：Java3y：" + findMax(arrays, 0, arrays.length - 1));

}

/**
 * 递归，找出数组最大的值
 * @param arrays 数组
 * @param L      左边界，第一个数
 * @param R      右边界，数组的长度
 * @return
 */

public static int findMax(int[] arrays, int L, int R) {

    //如果该数组只有一个数，那么最大的就是该数组第一个值了
    if (L == R) {
        return arrays[L];
    } else {

        int a = arrays[L];
        int b = findMax(arrays, L + 1, R);//找出整体的最大值

        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}
```

Fibbonacci

```java
public static void main(String[] args) {

    int[] arrays = {1, 1, 2, 3, 5, 8, 13, 21};
    //bubbleSort(arrays, 0, arrays.length - 1);

    int fibonacci = fibonacci(10);
    System.out.println("公众号：Java3y：" + fibonacci);

}

public static int fibonacci(int n) {
    if (n == 1) {
        return 1;
    } else if (n == 2) {
        return 1;
    } else {
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

}
```

Hanoi

```java
public static void main(String[] args) {

    int[] arrays = {1, 1, 2, 3, 5, 8, 13, 21};
    //bubbleSort(arrays, 0, arrays.length - 1);

    //int fibonacci = fibonacci(10);

    hanoi(3, 'A', 'B', 'C');

    System.out.println("公众号：Java3y" );

}

/**
 * 汉诺塔
 * @param n n个盘子
 * @param start 起始柱子
 * @param transfer 中转柱子
 * @param target 目标柱子
 */
public static void hanoi(int n, char start, char transfer, char target) {

    //只有一个盘子，直接搬到目标柱子
    if (n == 1) {
        System.out.println(start + "---->" + target);
    } else {

        //起始柱子借助目标柱子将盘子都移动到中转柱子中(除了最大的盘子)
        hanoi(n - 1, start, target, transfer);
        System.out.println(start + "---->" + target);

        //中转柱子借助起始柱子将盘子都移动到目标柱子中
        hanoi(n - 1, transfer, start, target);

    }
}
```

leetcode回溯算法

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个没有用掉
     * @param right  右边的括号还有几个没有用掉
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 因为每一次尝试，都使用新的字符串变量，所以没有显式的回溯过程
        // 在递归终止的时候，直接把它添加到结果集即可，与「力扣」第 46 题、第 39 题区分

        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfs(curStr + "(", left - 1, right, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left < right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(2);
        System.out.println(res);
    }
}

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

- https://www.zhihu.com/question/20507130
- https://www.jianshu.com/p/92f1b9020e64
- https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
