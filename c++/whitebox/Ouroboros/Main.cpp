#include <bits/stdc++.h>
using namespace std;

/**
 * @param n The size of the array
 * @param k The step size
 * @param a The array input
 */
void solve(int n, int k, vector<int> &a) {
  constexpr int BASE = 100001;

  for (int i = 0; i < a.size(); ++i) {
    const int next = (i + k) % n;
    a[i] += (a[next] % BASE) * BASE;
  }

  for (int i = 0; i < n; ++i) {
    const int original = a[i] % BASE;
    const int addend = a[i] / BASE;
    a[i] = original + addend;
  }
}
