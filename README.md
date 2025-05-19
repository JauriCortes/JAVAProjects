# Programming Exercise: Finding Many Genes

You can find a PDF of this programming exercise in the **Resources** tab.

For files related to this assignment, visit the DukeLearnToProgram Project Resources page for this course:  
[http://www.dukelearntoprogram.com/course2/files.php](http://www.dukelearntoprogram.com/course2/files.php)  
(also linked in the Resources tab).

You can also find the frequently asked questions page for this course’s assignments on DukeLearnToProgram:  
[http://www.dukelearntoprogram.com/course2/faq.php](http://www.dukelearntoprogram.com/course2/faq.php)  
(also linked in the Resources tab).

---

## Part 1: Finding Many Genes

This assignment is to write the code from the lesson to make the following improvements to your algorithm:

**A.** Find a gene in a strand of DNA where the stop codon could be any of the three stop codons “TAA”, “TAG”, or “TGA”.

**B.** Find all the genes (where the stop codon could be any of the three stop codons) in a strand of DNA.

This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named `StringsSecondAssignments`. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named `Part1`. The following methods go in this class.

3. Write the method `findStopCodon` that has three parameters:
   - a `String` parameter named `dna`,
   - an `int` parameter named `startIndex` that represents where the first occurrence of `ATG` occurs in `dna`,
   - a `String` parameter named `stopCodon`.

   This method returns the index of the first occurrence of `stopCodon` that appears past `startIndex` and is a multiple of 3 away from `startIndex`. If there is no such `stopCodon`, this method returns the length of the `dna` strand.

4. Write the void method `testFindStopCodon` that calls the method `findStopCodon` with several examples and prints out the results to check if `findStopCodon` is working correctly. Think about what types of examples you should check (e.g., DNA strings with and without genes).

5. Write the method `findGene` that has one `String` parameter `dna`. In this method you should:

   - Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
   - Find the index of the stop codon “TAA”, “TAG”, or “TGA” that is a multiple of 3 away using `findStopCodon`.
   - Return the gene formed from the “ATG” to the closest valid stop codon.
   - If no valid stop codon is found, return the empty string.

6. Write the void method `testFindGene` with no parameters. Create five DNA strings that include cases such as:
   - DNA with no “ATG”
   - DNA with “ATG” and one valid stop codon
   - DNA with “ATG” and multiple valid stop codons
   - DNA with “ATG” and no valid stop codons

   For each DNA string:
   - Print the DNA string
   - Calculate the gene using `findGene` and print it (or an empty string if no gene)

7. Write the void method `printAllGenes` with one `String` parameter `dna`. In this method, repeatedly find and print genes until there are no more.  
   *Hint: Use a `while(true)` loop and `break`.*

---

## Part 2: HowMany - Finding Multiple Occurrences

This assignment will write a method to determine how many occurrences of a string appear in another string.

1. Create a new Java Class named `Part2` in the `StringsSecondAssignments` project.

2. Write the method `howMany` with two `String` parameters: `stringa` and `stringb`. This method returns an `int` indicating how many times `stringa` appears in `stringb`, without overlapping occurrences.

   Examples:
   - `howMany("GAA", "ATGAACGAATTGAATC")` returns 3
   - `howMany("AA", "ATAAAA")` returns 2

3. Write the void method `testHowMany` with no parameters. Add calls to `howMany` with various test cases and print the results.

---

## Part 3: How Many Genes?

Write a program to count how many genes are in a strand of DNA.

1. Create a new Java Class named `Part3` in the `StringsSecondAssignments` project.

2. Copy your methods from `Part1` to find one gene and print all genes.

3. Write the method `countGenes` with a `String` parameter `dna`. This method returns the number of genes found in `dna`.

   Example:
   - `countGenes("ATGTAAGATGCCCTAGT")` returns 2 (genes: `ATGTAA`, `ATGCCCTAG`)

4. Write the void method `testCountGenes` with no parameters. This method should:
   - Call `countGenes` with several example DNA strings
   - Print the number of genes found for each example
