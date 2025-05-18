# Java Programming: Solving Problems with Software – Code Walkthrough

This repository contains my solutions and notes for the [Java Programming: Solving Problems with Software](https://www.coursera.org/learn/java-programming) course offered by Duke University on Coursera. Below is a module-wise breakdown of the code and concepts covered.

---

## 📁 Week 1: Fundamentals and Geometry – Working with Shapes

### Key Concepts:
- **Java Basics**: Introduction to Java syntax, variables, methods, conditionals, and loops.
- **Object-Oriented Programming**: Understanding classes and objects.
- **Geometry Computations**: Calculating perimeters, average side lengths, and identifying the longest side of geometric shapes.

### Code Highlights:
- **`PerimeterAssignmentRunner.java`**: Reads shape data from files and computes geometric properties.
- **`Shape.java`**: Utilizes the `edu.duke` library to represent geometric shapes.

*Example:* Calculating the perimeter of a shape by iterating over its points and summing the distances between consecutive points.

---

## 📁 Week 2: Strings and DNA – Analyzing Text Data

### Key Concepts:
- **String Manipulation**: Using Java's `String` class methods to process textual data.
- **Biological Data Analysis**: Identifying genes within DNA sequences by locating start and stop codons.
- **Control Structures**: Implementing loops and conditionals to parse and analyze strings.

### Code Highlights:
- **`Part1.java`**: Finds genes in DNA sequences by searching for specific codon patterns.
- **`Part2.java`**: Enhances gene-finding logic with additional checks and conditions.
- **`Part3.java`**: Analyzes the ratio of CG content in DNA and counts occurrences of specific codons.

*Example:* Extracting all gene sequences from a DNA string that start with "ATG" and end with "TAA", "TAG", or "TGA".

---

## 📁 Week 3: CSV Files and Basic Statistics – Data Analysis

### Key Concepts:
- **CSV Parsing**: Reading and processing data from CSV files using the `org.apache.commons.csv` library.
- **Data Analysis**: Computing statistics like maximum temperature, average temperature, and humidity levels.
- **File Handling**: Iterating over multiple files to aggregate and compare data.

### Code Highlights:
- **`CSVWeather.java`**: Processes weather data to find maximum temperatures and average humidity.
- **`CSVMax.java`**: Identifies the file with the highest temperature among multiple datasets.

*Example:* Determining the day with the highest temperature from a set of CSV files containing daily weather records.

---

## 📁 Week 4: Mini-Project – Baby Names Analysis

### Key Concepts:
- **Data Aggregation**: Summing and comparing data across multiple records.
- **Ranking and Trends**: Determining the popularity rank of baby names over the years.
- **Modular Programming**: Building reusable methods to perform specific tasks.

### Code Highlights:
- **`BabyNames.java`**: Analyzes baby name data to find name rankings, total births, and year-over-year trends.
- **`TotalBirths.java`**: Calculates the total number of births and unique names from a dataset.

*Example:* Finding out what a person's name would have been in a different year based on the popularity rank of their original name.

---

## 🛠️ Tools and Libraries

- **Java Development Kit (JDK)**: Ensure you have JDK installed to compile and run Java programs.
- **BlueJ IDE**: Recommended for this course; a user-friendly environment for beginners.
- **External Libraries**:
  - `edu.duke`: A custom library provided by Duke University for educational purposes.
  - `org.apache.commons.csv`: Used for parsing and handling CSV files.

These libraries are included in the course's custom BlueJ setup. If you're using a different environment, ensure these dependencies are properly configured.

---

## 📄 License

This repository is intended for educational purposes. Please ensure adherence to Coursera's [Honor Code](https://www.coursera.org/about/honorcode) when using or referencing these solutions.

---

*Happy Coding!*
