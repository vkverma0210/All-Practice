#include <bits/stdc++.h>

using namespace std;

int hammingWeight(uint32_t n)
{
    int count = 0;

    while (n)
    {
        n = n & (n - 1);
        count++;
    }

    return count;
}

int main()
{
    uint32_t n;
    cin >> n;

    cout << n;
    
    int ans = hammingWeight(n);

    cout << ans << endl;

    return 0;
}