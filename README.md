# DSA

Solved problems and implementations in **C++**, **Java**, and **Python**.

## Structure

```
├── c++
│   └── whitebox
├── java
│   ├── competitions
│   │   └── <event>/<problem>/Main.java
│   ├── fundamentals/src/main/java/dsa/fundamentals
│   ├── hackerrank/<problem>/Solution.java
│   ├── leetcode/<number>-<problem>/Solution.java
│   └── whitebox/<problem>/Main.java
├── python
│   ├── fundamentals/
│   └── leetcode/
```

## Java workflow

Judge solutions are stored as package-less source files. This keeps them ready
to paste into a judge and allows different problems to reuse the `Solution` or
`Main` class name.

From Neovim or a terminal, run a source file directly with JDK 21 or newer:

```sh
java java/whitebox/add-to-13/Main.java
```

Archived judge solutions are intentionally excluded from Gradle. Some depend on
types supplied by their judge, such as `ListNode` or `TreeNode`, so the archive
is not expected to compile as one Java project.

The conventional `java/fundamentals` project remains available through Gradle:

```sh
./gradlew :java-fundamentals:build
```

## Languages

- C++
- Java
- Python
