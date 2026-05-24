#!/bin/bash
# Phase 3b: Migrate Java HackerRank files
cd /home/amari/DSA/java

# From hacker_rank_challenge/ — most just need move + package removal
# Files that need class rename: Arrays_DS, CountingSort_2, TwoD_Array_DS, intro
for f in hacker_rank_challenge/*.java; do
  base=$(basename "$f")
  git mv "$f" "hackerrank/$base"
done

# From week_1_challenge/
for f in week_1_challenge/*.java; do
  base=$(basename "$f")
  git mv "$f" "hackerrank/$base"
done

# Remove all package lines
sed -i '/^package hacker_rank_challenge;/d' hackerrank/*.java
sed -i '/^package week_1_challenge;/d' hackerrank/*.java
# Also handle the commented-out package line in Arrays_DS
sed -i '/^\/\/package hacker_rank_challenge;/d' hackerrank/*.java

# Rename files that need it
git mv hackerrank/Arrays_DS.java hackerrank/ArraysDS.java
git mv hackerrank/CountingSort_2.java hackerrank/CountingSort.java
git mv hackerrank/TwoD_Array_DS.java hackerrank/TwoDArrayDS.java
git mv hackerrank/intro.java hackerrank/Intro.java

# Rename classes to match new filenames
sed -i 's/class Arrays_DS/class ArraysDS/g' hackerrank/ArraysDS.java
sed -i 's/class CountingSort_2/class CountingSort/g' hackerrank/CountingSort.java
sed -i 's/class TwoD_Array_DS/class TwoDArrayDS/g' hackerrank/TwoDArrayDS.java
sed -i 's/class intro/class Intro/g' hackerrank/Intro.java
# Also fix commented-out class in ArraysDS
sed -i 's|//public class Arrays_DS|//public class ArraysDS|g' hackerrank/ArraysDS.java

# Add HackerRank header to each file
for f in hackerrank/*.java; do
  base=$(basename "$f" .java)
  # Skip if already has a header
  if ! head -1 "$f" | grep -q "^// HackerRank"; then
    sed -i "1i\\// HackerRank - ${base}" "$f"
  fi
done

echo "✓ HackerRank migration complete"
ls hackerrank/
