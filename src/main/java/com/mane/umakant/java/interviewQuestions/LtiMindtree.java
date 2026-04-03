package com.mane.umakant.java.interviewQuestions;

public class LtiMindtree {
    LtiMindtree object2 = new LtiMindtree();

    public int show() {
        return (true ? null : 0);
    }

    public static void main(String args[]) {
        LtiMindtree object1 = new LtiMindtree();
        object1.show();
    }
}
/*
Let’s analyze this carefully step-by-step 👇
public class LtiMindtree {
    LtiMindtree object2 = new LtiMindtree();

    public int show() {
        return (true ? null : 0);
    }

    public static void main(String args[]) {
        LtiMindtree object1 = new LtiMindtree();
        object1.show();
    }
}
# 🔴 Step 1: What Happens When `main()` Runs?
```java
LtiMindtree object1 = new LtiMindtree();
When `new LtiMindtree()` is executed:
### Object Creation Steps:
1. Memory allocated.
2. Instance variables initialized.
3. Constructor executes (default constructor here).
---

# 🔴 Step 2: Instance Variable Initialization
```java
LtiMindtree object2 = new LtiMindtree();
This is the key problem.
When you create `object1`:
* It tries to initialize `object2`
* That requires `new LtiMindtree()`
* That new object again tries to initialize its own `object2`
* Which again creates another `LtiMindtree`
* And again…
* And again…

This becomes **infinite recursive object creation**.
---

# 💥 Result
The program **compiles successfully** ✔

But at runtime it throws:
```
Exception in thread "main" java.lang.StackOverflowError
---

# 🔴 Important Point

The method:

```java
public int show() {
    return (true ? null : 0);
}
```
⚠️ **Never gets executed**

Because program crashes during object creation itself.
---

# 🔥 Interview-Ready Answer
> The code compiles successfully.
> At runtime, when creating the first object, the instance variable initializes another object of the same class, causing infinite recursive object creation.
> This results in a StackOverflowError before the show() method is executed.
---

# 🎯 Bonus (If Interviewer Asks Further)
If the recursive instance variable is removed, then:
```java
return (true ? null : 0);```

would cause:
```
NullPointerException
``
due to auto-unboxing of `null` to `int`.
---
If you want, I can now give you a similar tricky question that combines constructor + static block + ternary 😄
🔴 2️⃣ Second Important Thing – Ternary Operator
public int show(){
    return (true ? null : 0);
}
Now check carefully.
The method return type is:
public int show()
It must return primitive int.
But:
(true ? null : 0)
Ternary operator rules:
null is treated as Integer
0 is int
Java tries to determine a common type
It becomes Integer
So expression type becomes Integer.
Then Java tries to unbox it to int.
But since condition is true, value is null.
So at runtime it would cause:
NullPointerException
🚨 But Wait — Does show() Even Execute?
No ❌
Because program crashes earlier due to:
StackOverflowError
during object creation.
So show() is never reached.
✅ FINAL ANSWER
✔ Program Compiles
❌ Runtime Output:
Exception in thread "main" java.lang.StackOverflowError

Because of infinite object creation:
B b = new B();
💡 If interviewer asks further:
Q: What if instance variable is removed?
public class B{
    public int show(){
        return (true ? null : 0);
    }
}
Then runtime error would be:
NullPointerException
Due to auto-unboxing of null.
 */