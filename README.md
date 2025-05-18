# StringsThirdAssignments

This Java project analyzes DNA sequences to find genes, calculate CG ratios, and count specific codons using the [Duke University `edu.duke` library](https://www.dukelearntoprogram.com/downloads/duke.jar).

## Features

- **Find Stop Codons:** Locates stop codons in DNA sequences.
- **Find Genes:** Extracts genes based on start and stop codons.
- **Get All Genes:** Collects all genes from a DNA string.
- **CG Ratio:** Calculates the ratio of 'C' and 'G' in a DNA string.
- **Count CTG:** Counts the number of times the codon "CTG" appears.
- **Process Genes:** Analyzes genes for length and CG ratio.

## Requirements

- Java 8 or higher
- [`duke.jar`](https://www.dukelearntoprogram.com/downloads/duke.jar) (place in your project directory or `lib` folder)

## Usage

1. **Compile:**
    ```bash
    javac -cp .;duke.jar StringsThirdAssignments/StringThirdAssignment.java
    ```
    *(On Mac/Linux, use `:` instead of `;` in the classpath)*

2. **Run:**
    ```bash
    java -cp .;duke.jar StringsThirdAssignments.StringThirdAssignment
    ```

3. **Input File:**
    - Place your DNA file (e.g., `GRch38dnapart.fa`) in the project directory.

## File Structure

- `StringThirdAssignment.java` — Main source file with all logic.
- `GRch38dnapart.fa` — Example DNA input file.
- `duke.jar` — Required library for file handling and `StorageResource`.

## Example Output

```
The size of GRch38dnapart is: 45
12 Strings larger than 60
8 Strings with a cgRatio larger than 0.35
120 Is the longest gene found
CGT appear 23 times
```

## Credits

- Based on assignments from Duke University's Java Programming: Solving Problems with Software.

---