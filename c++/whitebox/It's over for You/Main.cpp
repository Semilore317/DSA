class box {
public:
  virtual int foo() {
    // virtual makes it actual overriding else it's just hiding
    return 0;
  }
  virtual int foo(int x) { return x; }
};

class whitebox : public box {
public:
  int foo() override { return 1; }
  int foo(int x) override { return x + 1; }
};
