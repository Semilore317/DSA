#!/bin/bash
# Phase 3d: Consolidate Java fundamentals
cd /home/amari/DSA/java

# Delete the weaker duplicates
# linear_search.java is more complete than LinearSearch.java — keep linear_search, delete LinearSearch
git rm fundamentals/LinearSearch.java
# arrays.java is a trivial demo, Array.java is the real implementation — delete arrays.java
git rm fundamentals/arrays.java

# Move and rename fundamentals files
git mv fundamentals/Array.java fundamentals_new/Array.java 2>/dev/null || true
# We need a temp dir since 'fundamentals' already exists
mkdir -p fundamentals_new

# Move all remaining fundamentals files
for f in fundamentals/ArrayListJava.java fundamentals/binary_search.java fundamentals/bubble_sort.java \
         fundamentals/EuclideanAlgorithm.java fundamentals/Fibonacci.java fundamentals/KruskalsAlgorithm.java \
         fundamentals/linear_search.java fundamentals/Array.java; do
  if [ -f "$f" ]; then
    git mv "$f" fundamentals_new/
  fi
done

# Move linked_lists files
for f in fundamentals/linked_lists/*.java; do
  if [ -f "$f" ]; then
    git mv "$f" fundamentals_new/
  fi
done

# Move GraphTraversal files
for f in GraphTraversal/*.java; do
  if [ -f "$f" ]; then
    git mv "$f" fundamentals_new/
  fi
done

# Now swap directories — remove old fundamentals (oop will be handled in Phase 4)
# For now, just rename fundamentals_new to a temp name
# Actually let's just keep both for now, we'll clean up

# Rename files with bad casing
git mv fundamentals_new/ArrayListJava.java fundamentals_new/ArrayList.java
git mv fundamentals_new/binary_search.java fundamentals_new/BinarySearch.java
git mv fundamentals_new/bubble_sort.java fundamentals_new/BubbleSort.java
git mv fundamentals_new/linear_search.java fundamentals_new/LinearSearch.java
git mv fundamentals_new/Djikstra.java fundamentals_new/Dijkstra.java
git mv fundamentals_new/buildingALinkedList.java fundamentals_new/BuildLinkedList.java
git mv fundamentals_new/linkedLists.java fundamentals_new/LinkedList.java

# Remove package lines from all files
sed -i '/^package fundamentals;/d' fundamentals_new/*.java
sed -i '/^package GraphTraversal;/d' fundamentals_new/*.java

# Rename classes to match new filenames
sed -i 's/class ArrayListJava/class ArrayList/g' fundamentals_new/ArrayList.java
sed -i 's/class binary_search/class BinarySearch/g' fundamentals_new/BinarySearch.java
sed -i 's/class bubble_sort/class BubbleSort/g' fundamentals_new/BubbleSort.java
sed -i 's/class linear_search/class LinearSearch/g' fundamentals_new/LinearSearch.java
sed -i 's/class Djikstra/class Dijkstra/g' fundamentals_new/Dijkstra.java 2>/dev/null
sed -i 's/class buildingALinkedList/class BuildLinkedList/g' fundamentals_new/BuildLinkedList.java
sed -i 's/class linkedLists/class LinkedList/g' fundamentals_new/LinkedList.java

# Add headers
for f in fundamentals_new/*.java; do
  name=$(basename "$f" .java)
  if ! head -1 "$f" | grep -q "^// "; then
    sed -i "1i\\// Fundamentals - ${name}" "$f"
  fi
done

echo "✓ Fundamentals consolidation complete"
ls fundamentals_new/
