#!/bin/bash
# Phase 3c: Migrate Java competition files
cd /home/amari/DSA/java

# IEEExtreme 17 — flatten from IEEEXTREME_17/<Problem>/Main.java to competitions/ieeextreme-17/<Problem>.java
declare -A IEEE
IEEE=(
  ["IEEEXTREME_17/BeetleBag/Main.java"]="BeetleBag"
  ["IEEEXTREME_17/Blackgate_Penitentiary/Main.java"]="BlackgatePenitentiary"
  ["IEEEXTREME_17/Crafting_Wooden_Tables/Main.java"]="CraftingWoodenTables"
  ["IEEEXTREME_17/DogWalking/Main.java"]="DogWalking"
  ["IEEEXTREME_17/Fibonacci/Main.java"]="Fibonacci"
  ["IEEEXTREME_17/Rumour/Main.java"]="Rumour"
  ["IEEEXTREME_17/Running_Up_Stairs/Main.java"]="RunningUpStairs"
)

for old_path in "${!IEEE[@]}"; do
  new_name="${IEEE[$old_path]}"
  new_path="competitions/ieeextreme-17/${new_name}.java"
  git mv "$old_path" "$new_path"
  
  # Remove package line
  sed -i '/^package IEEEXTREME_17/d' "$new_path"
  
  # Rename class Main -> new_name
  sed -i "s/class Main/class ${new_name}/g" "$new_path"
  
  # Add header
  sed -i '/./,$!d' "$new_path"
  sed -i "1i\\// IEEExtreme 17 - ${new_name}" "$new_path"
  
  echo "✓ ${old_path} → ${new_path}"
done

# Pre-extreme — loose files in java/ root
for f in GridMove.java Lemonade.java MysteriousArchipelago.java ShiftCipher.java ZigZagSequence.java; do
  git mv "$f" "competitions/pre-extreme/$f"
  sed -i '/^package pre_extreme_problems;/d' "competitions/pre-extreme/$f"
  
  name=$(basename "$f" .java)
  sed -i '/./,$!d' "competitions/pre-extreme/$f"
  sed -i "1i\\// Pre-Extreme - ${name}" "competitions/pre-extreme/$f"
  
  echo "✓ ${f} → competitions/pre-extreme/${f}"
done

echo "✓ Competition migration complete"
