# Invisible Ink (Text Steganography)

## 📌 Project Overview
Invisible Ink (Text Steganography) is a Java-based project that hides secret messages within normal text using **zero-width characters** (invisible to the human eye). It also includes **encryption** for added security before encoding the message.

## 🎯 Features
- **Steganography using Zero-Width Characters** (Zero-Width Space & Zero-Width Non-Joiner)
- **Encryption (Caesar Cipher Shift-3) for Enhanced Security**
- **File Handling** (Save & Load Encoded Messages)
- **User-Friendly Encoding & Decoding Modes**

## 🛠 Technologies Used
- **Java (Core Java)**
- **File Handling (Read/Write Operations)**
- **String Manipulation & Character Encoding**
- **Basic Cryptography (Caesar Cipher)**

## 🚀 How It Works
### 1️⃣ Encoding Process:
1. The secret message is **encrypted** using a simple Caesar Cipher (Shift-3).
2. Each encrypted character is converted to **binary** (8-bit representation).
3. **Zero-Width Space (`\u200B`)** is used to represent **0**, and **Zero-Width Non-Joiner (`\u200C`)** represents **1**.
4. The modified text (with invisible characters) is **appended** to the cover text.
5. The encoded message is **optionally saved to a file**.

### 2️⃣ Decoding Process:
1. The program scans the text for **invisible zero-width characters**.
2. The extracted bits are **converted back into characters**.
3. The message is **decrypted** (Caesar Cipher Shift-3) to reveal the original secret message.
4. The decoded message is displayed.



## 📜 Usage Instructions
### 1️⃣ Running the Program
```sh
# Navigate to the project folder
cd InvisibleInkSteganography

# Compile the Java file
javac AdvancedInvisibleInk.java

# Run the program
java AdvancedInvisibleInk
```

### 2️⃣ Encoding a Message
- Choose **Option 1 (Encode a Message)**.
- Enter the **cover text** (normal text where the message will be hidden).
- Enter the **secret message** (to be hidden).
- Optionally, **save** the encoded text to a file.

### 3️⃣ Decoding a Message
- Choose **Option 2 (Decode a Message)**.
- Enter the **encoded text** manually or read from a file.
- The secret message will be extracted and displayed.

## 🔥 Example
### Input:
```
Cover Text: "Hello, how are you?"
Secret Message: "Secret123"
```

### Encoded Output:
```
Hello, how are you? [Invisible characters embedded]
```
(The secret message is hidden within invisible zero-width characters!)

### Decoded Output:
```
Extracted Secret Message: Secret123
```

## 📌 Applications
- **Secure Communication** – Send hidden messages inside harmless-looking text.
- **Data Protection** – Encrypt and conceal confidential information.
- **Digital Watermarking** – Embed invisible marks in text for copyright protection.

## 📜 License
This project is open-source and available for use under the **MIT License**.

## 🤝 Contributing
Feel free to contribute! Fork the repository, make enhancements, and submit a pull request.

## 💡 Future Enhancements
- Implement **AES Encryption** for more robust security.
- Create a **GUI version** using JavaFX.
- Support **multiple languages** for wider usability.

---
### 🔗 Connect with Me
🚀 Feel free to reach out for collaboration or improvements!

