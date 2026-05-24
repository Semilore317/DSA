#!/bin/bash
# Phase 3a: Migrate Java LeetCode files
# For each file: git mv, remove package line, rename class, add problem number comment

cd /home/amari/DSA/java

declare -A FILES
FILES=(
  ["leetcode_problems/problem_7.java"]="ReverseInteger|7|Reverse Integer|problem_7"
  ["leetcode_problems/problem_11.java"]="ContainerWithMostWater|11|Container With Most Water|problem_11"
  ["leetcode_problems/problem_15.java"]="ThreeSum|15|3Sum|problem_15"
  ["leetcode_problems/problem_20.java"]="ValidParentheses|20|Valid Parentheses|problem_20"
  ["leetcode_problems/problem_22.java"]="GenerateParentheses|22|Generate Parentheses|problem_22"
  ["leetcode_problems/problem_55.java"]="JumpGame|55|Jump Game|problem_55"
  ["leetcode_problems/problem_66.java"]="PlusOne|66|Plus One|problem_66"
  ["leetcode_problems/problem_74.java"]="Search2DMatrix|74|Search a 2D Matrix|problem_74"
  ["leetcode_problems/problem_102.java"]="BinaryTreeLevelOrder|102|Binary Tree Level Order Traversal|problem_102"
  ["leetcode_problems/problem_121.java"]="BestTimeToBuySellStock|121|Best Time to Buy and Sell Stock|problem_121"
  ["leetcode_problems/problem_143.java"]="ReorderList|143|Reorder List|problem_143"
  ["leetcode_problems/problem_155.java"]="MinStack|155|Min Stack|problem_155"
  ["leetcode_problems/problem_164.java"]="MaximumGap|164|Maximum Gap|problem_164"
  ["leetcode_problems/problem_200.java"]="NumberOfIslands|200|Number of Islands|problem_200"
  ["leetcode_problems/problem_202.java"]="HappyNumber|202|Happy Number|problem_202"
  ["leetcode_problems/problem_206.java"]="ReverseLinkedList|206|Reverse Linked List|problem_206"
  ["leetcode_problems/problem_217.java"]="ContainsDuplicate|217|Contains Duplicate|problem_217"
  ["leetcode_problems/problem_518.java"]="CoinChangeII|518|Coin Change II|problem_518"
  ["leetcode_problems/problem_532.java"]="KDiffPairs|532|K-diff Pairs in an Array|problem_532"
  ["leetcode_problems/problem_739.java"]="DailyTemperatures|739|Daily Temperatures|problem_739"
  ["leetcode_problems/problem_853.java"]="CarFleet|853|Car Fleet|problem_853"
  ["leetcode_problems/problem_875.java"]="KokoEatingBananas|875|Koko Eating Bananas|problem_875"
)

for old_path in "${!FILES[@]}"; do
  IFS='|' read -r new_class num title old_class <<< "${FILES[$old_path]}"
  new_path="leetcode/${new_class}.java"
  
  # git mv
  git mv "$old_path" "$new_path"
  
  # Remove package line
  sed -i '/^package leetcode_problems;$/d' "$new_path"
  
  # Remove any existing problem number comment at very top (like "// Jump Game" or "// Valid Parentheses")
  sed -i '1{/^\/\/ /d}' "$new_path"
  
  # Rename class
  sed -i "s/class ${old_class}/class ${new_class}/g" "$new_path"
  
  # Remove leading blank lines then add problem number comment at top
  sed -i '/./,$!d' "$new_path"
  sed -i "1i\\// LeetCode #${num} - ${title}" "$new_path"
  
  echo "✓ ${old_path} → ${new_path} (class: ${new_class})"
done
