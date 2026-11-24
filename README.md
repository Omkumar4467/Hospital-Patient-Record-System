# 🏥 Hospital Patient Record System

## 📌 Project Overview
The **Hospital Patient Record System** is a console-based Java application designed to manage hospital patient information efficiently. It allows users to register new patients, display all patient records, search patients by name, and sort patients according to their age.

The application uses Java OOP concepts, ArrayList, searching, sorting, methods, and file handling to maintain patient records.

## 🎯 Objectives
- Register new patients with unique patient IDs.
- Display all registered patient records.
- Search patients by name.
- Sort patients by age (low to high).
- Validate patient information.
- Store patient records permanently using file handling.

## 🛠️ Technologies Used
- **Programming Language:** Java
- **IDE:** VS Code / IntelliJ IDEA / Eclipse
- **Data Structure:** ArrayList
- **File Handling:** FileReader, FileWriter, BufferedReader, PrintWriter
- **Algorithms:** Linear Search and Bubble Sort

## ✨ Features

1. **Register Patient:** Add a new patient with name, age, and disease.
2. **Display All Patients:** Display all available patient records.
3. **Search by Name:** Find patients using their full or partial name.
4. **Sort by Age:** Arrange patients from youngest to oldest.
5. **File Handling:** Save and load patient records using `patients.txt`.
6. **Input Validation:** Age must be between 0 and 120. Name and disease cannot be empty.

## 🆔 Patient ID Generation
- First patient ID: `PT101`
- Second patient ID: `PT102`
- Third patient ID: `PT103`

Patient IDs are automatically generated and continue from previously saved records.

## 📂 Project Structure

```text
Hospital-Patient-Record-System/
│
├── HospitalPatientRecordSystem.java
├── patients.txt
└── README.md
```

## 💻 How to Run the Project

**Step 1:** Install Java JDK.

**Step 2:** Open the project folder in VS Code or any Java IDE.

**Step 3:** Open the terminal and compile the program.

```bash
javac HospitalPatientRecordSystem.java
```

**Step 4:** Run the application.

```bash
java HospitalPatientRecordSystem
```

## 📋 Application Menu

```text
===== HOSPITAL PATIENT RECORD SYSTEM =====

1. Register Patient
2. Display All Patients
3. Search by Name
4. Sort by Age (Low to High)
5. Exit

Enter your choice:
```

## 🧪 Sample Test Cases

| Test Case | Input | Expected Result |
|---|---|---|
| Normal Input | Sunita Devi, 45, Diabetes | Patient registered as PT101 |
| Minimum Age | Baby Arya, 0, Fever | Registration successful |
| Invalid Age | Ramesh Yadav, 200 | Invalid age message |
| Sorting | Rohan (30), Sunita (45) | Rohan displayed first |
| Searching | Search for Sunita | Sunita Devi found |

## 🧠 Concepts Implemented

- Classes and Objects
- ArrayList
- Constructors
- Methods
- Linear Searching
- Bubble Sorting
- File Handling
- Exception Handling
- Loops and Conditional Statements

## ⏱️ Algorithm Complexity

| Operation | Algorithm | Time Complexity |
|---|---|---|
| Register Patient | ArrayList insertion | O(1) amortized |
| Display Patients | Traversal | O(n) |
| Search Patient | Linear Search | O(n) |
| Sort Patients | Bubble Sort | O(n²) |

## 💾 Data Storage

All patient records are stored in a text file named `patients.txt`.
<img width="1919" height="1029" alt="Screenshot 2026-11-24 224646" src="https://github.com/user-attachments/assets/25a1393e-6b4b-4ff0-86d4-c55838650cfa" />



Example:

```text
PT103 | OM KUMAR | 19 | FEVER
```

The application loads existing records when it starts and saves records when the user exits.

## 🚀 Future Enhancements
- Update patient details.
- Delete patient records.
- Add doctor and appointment management.
- Introduce a graphical user interface (GUI).
- Integrate a database such as MySQL.
- Add administrator login and authentication.

## 🎓 Conclusion

The Hospital Patient Record System demonstrates the practical implementation of Java programming concepts in a real-world healthcare management scenario. It provides basic patient record management through registration, searching, displaying, sorting, and file handling.

This project improves understanding of object-oriented programming, data structures, algorithms, and file operations in Java.

---

**Project Title:** Hospital Patient Record System  
**Programming Language:** Java  
**Project Type:** Console-Based Application  
**Storage File:** patients.txt
