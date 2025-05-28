# Gehtsoft Technical Assessment Console App

This is a simple Java console application created as part of a technical assessment. It provides the following main features:

- **Caesar Cipher** for encrypting and decrypting text (supports English and Russian alphabets)
- **Arithmetic Expression Evaluator** using the exp4j library
- **File input/output support** for Caesar operations
- **Unit tests** for cipher and expression logic

---

## 🧠 Features

### 1. Caesar Cipher

- Supports both English and Russian characters
- Preserves case (uppercase/lowercase)
- Leaves digits, spaces, and punctuation untouched
- Works with positive and negative shift values
- Optional file input/output

### 2. Expression Evaluator

- Supports common math operations: `+`, `-`, `*`, `/`, parentheses, decimals
- Handles both positive and negative numbers
- Uses the [`exp4j`](https://www.objecthunter.net/exp4j/) library

---

## 🚀 How to Run

1. Compile and run the app using your IDE or with Maven:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.raxrot.Main"
```

2. Follow the menu prompts:

```
Welcome to Gehtsoft Technical Assessment

Please choose an option:
1. Caesar Cipher Encryption
2. Caesar Cipher Decryption
3. Arithmetic Expression Evaluation
Your choice:
```

---

## 📝 Example

### Caesar Cipher (Manual)

```
Your choice: 1
Choose text source:
1. Enter manually
2. Load from file
Your choice: 1
Enter text: Привет Мир
Enter shift value: 5
Result:
Фхнжйч Снх
```

### Expression Evaluation

```
Your choice: 3
Enter expression: (3 + 2) * 4 - 6
Result: 14.0
```

---

## 🧪 Unit Tests

Tests are included using JUnit:

- `CaesarCipherTest` ensures encrypt/decrypt accuracy for both English and Russian
- `ExpressionEvaluatorTest` verifies mathematical expression results including decimals and negatives

To run tests:

```bash
mvn test
```

---

## 📁 Project Structure

```
src/
├── com.raxrot/
│   ├── Main.java
│   ├── ceaser/
│   │   ├── CaesarCipher.java
│   │   └── CaesarFileHandler.java
│   └── math/
│       └── ExpressionEvaluator.java
test/
├── CaesarCipherTest.java
└── ExpressionEvaluatorTest.java
```

---

## ⚙️ Dependencies

Main dependency for expression parsing:

```xml
<dependency>
  <groupId>net.objecthunter</groupId>
  <artifactId>exp4j</artifactId>
  <version>0.4.8</version>
</dependency>
```

JUnit dependency for testing:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.10.0</version>
  <scope>test</scope>
</dependency>
```

---

## ✅ Done

- [x] Caesar Cipher with file I/O support
- [x] Expression evaluation using exp4j
- [x] Clean, simple console interface
- [x] Unit tests included
- [x] Supports Russian and English alphabets

---

## 📌 Author Notes

This project is intentionally written to look human-made, including:
- Slightly redundant logic
- Simplified method names
- Straightforward conditionals and flow

Everything was implemented manually to simulate realistic coding practices.

---

## 🧹 TODO (Optional)

- Add support for custom alphabets
- Include command-line args support
- Add GUI interface

---

## 📬 License

Free to use and modify. No license required.