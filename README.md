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

Every judge problem is an independent, package-less Java program. This keeps the
source ready to paste into the judge and allows different problems to use the
same `Solution` or `Main` class name.

From Neovim or a terminal, run a source file directly with JDK 21 or newer:

```sh
java java/whitebox/add-to-13/Main.java
```

For IntelliJ IDEA, open the repository root as a Gradle project. The Gradle
settings discover every problem folder as an independent module, preventing
package-path and duplicate-class conflicts. Re-sync Gradle after adding a new
problem folder.

Validate the complete Java layout and compile every module with:

```sh
./gradlew check
./gradlew build
```

## Languages

- C++
- Java
- Python
