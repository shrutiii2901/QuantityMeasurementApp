# 📘 Quantity Measurement Application

A **Spring Boot backend application** that performs **unit-based quantity operations** such as addition, subtraction, comparison, and conversion with **secure authentication using JWT**.

---

## 🚀 Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Spring Security  
- JWT Authentication  
- Maven  

---

## 📂 Project Structure

```
com.app.quantitymeasurementapp  
│  
├── controller     → REST APIs  
├── service        → Business logic  
├── repository     → Database interaction  
├── model          → Entities (User, QuantityMeasurement)  
├── units          → Unit enums & conversions  
├── support        → Helper classes  
├── security       → JWT & Spring Security  
```


---

## 📅 Development Timeline (UC-wise)

### ✅ UC1 – Add Two Quantities
- Implemented addition of two quantities  
- Validated same units  

### ✅ UC2 – Unit Conversion
- Added support for different units  
- Converted values before operations  

### ✅ UC3 – Compare Quantities
- Compared two quantities  

### ✅ UC4 – Handle Different Units
- Conversion logic between units  

### ✅ UC5 – API Integration
- Created REST APIs:
  - `/add`
  - `/compare`
  - `/convert`

### ✅ UC6 – Exception Handling
- Handled invalid inputs  
- Added proper error responses  

### ✅ UC7 – Clean Architecture
- Separated Controller, Service, Model  

### ✅ UC8 – Database Integration
- Connected MySQL  
- Stored quantity data  

### ✅ UC9 – JPA Implementation
- Used Hibernate & JPA  
- Auto table creation  

### ✅ UC10 – DTO Usage
- Introduced DTOs for API requests  

### ✅ UC11 – More Operations
- Added subtraction API  

### ✅ UC12 – Enum for Units
- Created `LengthUnit` enum  

### ✅ UC13 – Validation Improvements
- Checked null values and invalid units  

### ✅ UC14 – Code Refactoring
- Improved readability  

### ✅ UC15 – Advanced Logic Handling
- Reusable conversion methods  

### ✅ UC16 – API Testing
- Tested using Postman  

### ✅ UC17 – Final Backend Completion
- All quantity operations working  

### 🔐 UC18 – Spring Security + JWT
- User Registration  
- User Login  
- JWT Token Generation  
- Secured APIs  

---
