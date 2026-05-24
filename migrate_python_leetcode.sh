#!/bin/bash
# Phase 3e: Migrate Python LeetCode files
cd /home/amari/DSA/python

declare -A FILES
FILES=(
  ["problem_9.py"]="palindrome_number|9|Palindrome Number"
  ["problem_11.py"]="container_with_most_water|11|Container With Most Water"
  ["problem_13.py"]="roman_to_integer|13|Roman to Integer"
  ["problem_15.py"]="three_sum|15|3Sum"
  ["problem_22.py"]="generate_parentheses|22|Generate Parentheses"
  ["problem_26.py"]="remove_duplicates|26|Remove Duplicates from Sorted Array"
  ["problem_27.py"]="remove_element|27|Remove Element"
  ["problem_28.py"]="find_index_first_occurrence|28|Find the Index of the First Occurrence"
  ["problem_35.py"]="search_insert_position|35|Search Insert Position"
  ["problem_36.py"]="valid_sudoku|36|Valid Sudoku"
  ["problem_58.py"]="length_of_last_word|58|Length of Last Word"
  ["problem_66.py"]="plus_one|66|Plus One"
  ["problem_67.py"]="add_binary|67|Add Binary"
  ["problem_69.py"]="sqrtx|69|Sqrt(x)"
  ["problem_74.py"]="search_2d_matrix|74|Search a 2D Matrix"
  ["problem_121.py"]="best_time_to_buy_sell_stock|121|Best Time to Buy and Sell Stock"
  ["problem_128.py"]="longest_consecutive_sequence|128|Longest Consecutive Sequence"
  ["problem_155.py"]="min_stack|155|Min Stack"
  ["problem_167.py"]="two_sum_ii|167|Two Sum II"
  ["problem_278.py"]="first_bad_version|278|First Bad Version"
  ["problem_283.py"]="move_zeroes|283|Move Zeroes"
  ["problem_463.py"]="island_perimeter|463|Island Perimeter"
  ["problem_682.py"]="baseball_game|682|Baseball Game"
  ["problem_704.py"]="binary_search|704|Binary Search"
  ["problem_724.py"]="find_pivot_index|724|Find Pivot Index"
  ["problem_875.py"]="koko_eating_bananas|875|Koko Eating Bananas"
  ["problem_997.py"]="find_the_town_judge|997|Find the Town Judge"
)

for old_path in "${!FILES[@]}"; do
  IFS='|' read -r new_name num title <<< "${FILES[$old_path]}"
  new_path="leetcode/${new_name}.py"
  
  git mv "$old_path" "$new_path"
  
  # Add problem number comment at the very top
  sed -i "1i\\# LeetCode #${num} - ${title}" "$new_path"
  
  echo "✓ ${old_path} → ${new_path}"
done

echo "✓ Python LeetCode migration complete"
