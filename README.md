# Crypto Calculator

**Author:** RaxRot  
**Project for:** Demonstration to Gehtsoft  
**Tech:** Java 17+  
**Features:** Caesar Cipher with Russian + English support, Math Expression Evaluator, File I/O, Console App

---

## 📌 About

This is a small Java console app combining two core features:

1. **Caesar Cipher** (encrypt/decrypt) — supports **English** and **Russian** alphabets  
2. **Expression Calculator** — evaluates arithmetic expressions like `5 * (2 + 3)`

The app was built for demo purposes by **RaxRot** for the company **Gehtsoft**.

---

## 📖 Menu Options

When you launch the app, you’ll see:

```
Welcome in program Crypto calculator
Main Menu:
1. Encrypt
2. Decrypt
3. Calculate expression
4. Exit
```

---

## 🔐 Caesar Cipher

You can encrypt or decrypt using a shift (positive or negative).

### ✅ Supports:
- English (A–Z, a–z)
- Russian (А–Я, а–я)
- Mixed language texts
- File or manual input

### 🔄 Example:

```
Text: Hello
Shift: 1
Encrypted: Ifmmp
```

```
Text: Привет
Shift: 1
Encrypted: Рсйгёу
```

---

## 📂 File Mode

You can read input from a file and optionally save output.

### Example Flow:

```
Choose input method:
1.type
2.read
> 2

Enter file path:
> input.txt

Shift:
> 5

Save result to file? ([y]/[n])
> y

Enter output file path:
> encrypted.txt
```

---

## 🧮 Expression Evaluator

Supports arithmetic operations:

- `+`, `-`, `*`, `/`
- Parentheses: `( )`
- Negative numbers: `-24 + 3`

### Example:

```
Input: 5 * (3 + 2)
Output: 25.0
```

---

## ✅ Unit Tests

Basic tests for both features:

- ✅ Caesar cipher encrypt/decrypt
- ✅ Expression evaluation

---

## 📦 Dependencies

### Maven

```xml
<dependency>
    <groupId>net.objecthunter</groupId>
    <artifactId>exp4j</artifactId>
    <version>0.4.8</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

---

## 📁 Project Structure

```
├── CaesarCipher.java            # Cipher logic
├── CaesarFileHandler.java       # Read/write files
├── ExpressionEvaluator.java     # Math expression calculator
├── Main.java                    # Console menu and program loop
├── CaesarCipherTest.java        # JUnit tests (cipher)
├── ExpressionEvaluatorTest.java # JUnit tests (calculator)
```

---

## 👨‍💻 Author

Built by **RaxRot**  
For demonstration to **Gehtsoft**