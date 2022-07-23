#include <bits/stdc++.h>

using namespace std;

uint32_t reverseBits(uint32_t n)
{
    uint32_t ans = 0;

    for (int i = 0; i < 32; i++)
    {
        auto k = n & 1;
        ans = ans << 1;
        ans = ans | k;
        n = n >> 1;
    }

    cout << ans << endl;

    return ans;
}

int main()
{
    uint32_t n;
    cin >> n;

    cout << reverseBits(n) << endl;

    return 0;
}