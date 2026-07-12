#include <algorithm>
#include <utility>
#include <vector>
class CraftingEngine {
private:
  unsigned int baseDurability;

  // a struct also works here
  std::vector<std::pair<unsigned int, // cost
                        unsigned int  // damage
                        >>
      materials;

public:
  CraftingEngine(unsigned int base_durability) {
    // initialized the object's starting durability
    baseDurability = base_durability;
  }
  void add(unsigned int cost, unsigned int damage) {
    // adds a new crafting material to the internal list
    materials.push_back({cost, damage});
  }
  int countReplacements(unsigned int threshold) {
    // for all weapons in the list...
    // if it's a poor material, it's cost exceeds it's damage
    int replacements(0);
    unsigned int count(0);

    for (const auto &[cost, damage] : materials) {
      if (cost > damage) {
        ++count;
        if (count == threshold) {
          ++replacements;
          count = 0;
        }
      } else {
        count = 0;
      }
    }

    return replacements;
  }
  int maximumDamage(unsigned int min_durability) {
    int capacity = baseDurability - min_durability;

    std::vector<int> dp(capacity + 1, 0);
    for (const auto &[cost, damage] : materials) {
      for (int c = capacity; c >= (int)cost; --c) {
        dp[c] = std::max(dp[c], dp[c - cost] + (int)damage);
      }
    }
    return dp[capacity];
  }
};
