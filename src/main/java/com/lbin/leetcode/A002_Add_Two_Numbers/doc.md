### 题目

#### [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，并且它们的每个节点只能存储 **一位** 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

### 思路

1.递归数学

还原数字，数值相加

2.递归补位0

链表递归，相同数位相加，满10进1，同时建立新链表。判断链表是否为null，单null链表补位0，同时null结束递归

### 解答

#### 1.递归数学

```java
    private ListNode set(int i) {
        if (i == 0) {
            return null;
        }
        int j = i % 10;
        return new ListNode(j, set(i / 10));
    }

    private int get(ListNode i) {
        if (i == null) {
            return 0;
        }
        return i.val + get(i.next) * 10;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return set(get(l1) + get(l2));
    }
```

#### 2.递归补位0

```java
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else {
            if (l1 == null) {
                l1 = new ListNode(0);
            } else if (l2 == null) {
                l2 = new ListNode(0);
            }
        }
        int num = l1.val + l2.val;
        if (num > 10) {
            num = num % 10;
            l1.next.val += 1;
        }
        return new ListNode(num, addTwoNumbers2(l1.next, l2.next));
    }
```

#### 3.非递归链表(官方)

```java
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
```

#### 4.非递归链表(参考)

```java
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry > 0){
            cur.next = new ListNode();
            cur = cur.next;
            if (l1 != null ){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null ){
                carry += l2.val;
                l2 = l2.next;
            }
            cur.val = carry %10;
            carry = carry/10;
        }
        return dummy.next;
    }
```