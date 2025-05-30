# Java Guard 🔒

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://java.com)
[![Rust](https://img.shields.io/badge/Rust-1.41+-red)](https://rust-lang.org)

> Java bytecode protection solution providing JAR encryption and runtime dynamic decryption capabilities, effectively preventing decompilation and code theft.
> 
> The core workflow and functionality are fully implemented. Future improvements include: documentation enhancement, JRE environment signature verification, and class execution support.

## ✨ Core Features
- **Bytecode Encryption**: AES-GCM-256 encryption for class constants and method bytecode
- **Resource Protection**: Block-level encryption for any resource files within JARs
- **Secure Launcher**: Native Rust launcher preventing decryption logic exposure
- **Signature Verification**: ED25519 signature validation ensuring code integrity
- **Zero-Intrusion**: No business code modification required

## 🚀 Quick Start
### Requirements
- JDK 1.8+
- Maven 3.0+
- Rust 1.41+

```shell
# 1. Clone repository
git clone https://github.com/java-guard/java-guard.git
cd java-guard
git submodule update --init

# 2. Build project
mvn clean package

# 3. Generate keys
ssh-keygen -t ed25519 -f config/id_ed25519

# 4. Encrypt JAR (Example)
java -jar target/java-guard-*.jar \
  -c config.yml \
  -o out \
  your-application.jar

# 5. Launch application
./out/jg-launcher -jar out/your-application.jar
# if your os is windows:
# .\out\jg-launcher.exe -jar out\your-application.jar
```

## ⚙️ Configuration Example
```yaml
# config.yml
matches: 
  - "com/yourcompany/**"     # Encryption path pattern
  - "META-INF/resources/*"

key: your_encryption_key     # AES key (optional)
privateKey: config/id_ed25519 # ED25519 private key path
publicKey: config/id_ed25519.pub # ED25519 public key path
```

## 🛡️ Workflow
```mermaid
graph TD
A[Original JAR] --> B{Java Guard}
B --> C[Encrypted Bytecode]
B --> D[Encrypted Resources]
C --> E[Secure Launcher]
D --> E
E --> F[JVM ClassFileLoadHook]
E --> G[URL Class Extension]
F --> H[Runtime Decryption]
G --> H
```

## 📦 Key Features
| Feature               | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| Constant & Method Encryption | Encrypts critical data while preserving class structure integrity       |
| JAR Signature Verification | Adds private key signature during encryption, verifies with public key at startup |
| Native Launcher       | Rust implementation increases reverse-engineering difficulty            |
| Transparent URL Extension | Dynamically extends bytecode to resolve encrypted resource access           |

## 🤝 Contributing
We welcome contributions through:
1. Submitting issues for bugs/feature requests
2. Forking repository and creating PRs
3. Improving documentation or adding test cases

[//]: # (Contribution guidelines pending)
[//]: # (See [CONTRIBUTING.md](CONTRIBUTING.md) for details)

## 📜 License
Distributed under [MIT License](LICENSE)

## ❓ Get Help
- [Issue Tracker](https://github.com/java-guard/java-guard/issues)
- Email: feng.kyle@outlook.com