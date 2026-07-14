#include <cmath>
#include <utility>
#include <vector>
class RollingCorr {
private:
  std::vector<std::pair<double, double>> vec;
  double _x_{}; // mean for x
  double _y_{}; // mean for y

public:
  RollingCorr() {}
  void updateMean(double x, double y) {
    int n = (int)vec.size();
    _x_ += (x - _x_) / n;
    _y_ += (y - _y_) / n;
  }
  double update(double x, double y) {
    // each method call appends (x,y) to the stream as a *pair*
    // return the pearson correlation cooefficient
    // of all the pairs in the vector

    double quotient(0.0);

    vec.push_back({x, y});
    updateMean(x, y);

    if (vec.size() < 2)
      return 0.0;

    double numerator{};
    // denomiator helper variables
    double sumXX{};
    double sumYY{};
    // numerator computation
    for (const auto &[x_i, y_i] : vec) {
      numerator += (x_i - _x_) * (y_i - _y_);
      sumXX += (x_i - _x_) * (x_i - _x_);
      sumYY += (y_i - _y_) * (y_i - _y_);
    }

    double denominator = sqrt(sumXX * sumYY);
    // denominator computation
    if (denominator != 0.0) {
      quotient = numerator / denominator;
    }
    return quotient;
  }
};
