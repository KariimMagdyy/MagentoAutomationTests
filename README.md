# Magento Automation Tests

Automated testing suite for validating critical functionalities of an e-commerce website (Magento). This project ensures a stable and user-friendly experience by automatically verifying core user flows such as product searching, adding items to the cart, and completing a purchase.

---

## 📌 Project Overview
**Title:** Magento Automation Tests  
**Description:** Focused automated testing on critical functionalities of an e-commerce website to ensure reliability and user satisfaction. Key areas include product search, adding products to the cart, and completing purchases.

---

## ✅ Test Scenarios Covered
- Product Search
- Add Product to Cart
- Complete Purchase Flow

---

## ⚙️ Technologies Used
- **Test Framework:** TestNG (with Page Object Model)
- **Automation Tools:**
    - Selenium WebDriver
    - Maven
    - Log4j (for logging)

---

## 💻 System Prerequisites
- Java Development Kit (JDK) 21
- Maven (Recommended version 3.8 or higher)
- Chrome Browser (latest version)

---

## 🔧 Setup Instructions
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/KariimMagdyy/MagentoAutomationTests.git
   cd MagentoAutomationTests
   ```

2. **Open the Project in IntelliJ**

3. **Install Dependencies:**
   Maven will automatically download the required dependencies based on the `pom.xml` file.

4. **Project Structure:**
    - `tests/` — Contains the test classes
    - `Pages/` — Page Object Model classes
    - `utils/` — Utility/helper classes
    - `testng.xml` — Optional TestNG suite for structured execution

---

## 🚀 Execution Instructions

### Option 1: Using Maven CLI
```bash
mvn clean test
```

### Option 2: Using TestNG XML
Run the `testng.xml` file from your IDE or via Maven.

---

## 📊 Test Reports
After execution, reports can be found at:
```
/target/surefire-reports/index.html
```
Or you can inspect individual test result files in the `target/surefire-reports/` directory.

---

## 👤 Author
**Karim Magdy**  
GitHub: [KariimMagdyy](https://github.com/KariimMagdyy)

---

## 📝 License
This project is currently not licensed. You may use and modify it as needed.

---

Feel free to contribute or suggest improvements!
