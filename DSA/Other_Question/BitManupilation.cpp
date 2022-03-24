#include <bits/stdc++.h>

using namespace std;

bool isOdd(int n)
{
    return (n & 1);
}

int getBit(int n, int i)
{
    int mask = (1 << i);
    int bit = (n & mask) > 0 ? 1 : 0;
    return bit;
}

int setBit(int n, int i)
{
    int mask = 1 << i;
    int ans = n | mask;
    return ans;
}

void clearBit(int &n, int i)
{
    int mask = ~(1 << i);
    n = n & mask;
}

void updateBit(int &n, int i, int v)
{
    int mask = ~(1 << i);
    int cleared_n = n & mask;
    n = cleared_n | (v << i);
}

int clearLastiBits(int n, int i)
{
    int mask = (-1 << i);
    return n & mask;
}

int clearRangeItoJ(int n, int i, int j)
{
    int ones = (~0);
    int a = ones << (j + 1);
    int b = (1 << i) - 1;
    int mask = a | b;
    int ans = n & mask;
    return ans;
}
int main()
{
    int n = 5;
    int i = 2;
    // cout << isOdd(n) << endl;

    // cout << getBit(n, i) << endl;

    // cout << setBit(n, 1) << endl;

    // clearBit(n, 1);
    // cout << n << endl;

    // updateBit(n, 1, 1);

    // cout << clearLastiBits(n, i) << endl;

    cout << clearRangeItoJ(31, 1, 3) << endl;
}