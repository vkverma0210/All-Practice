#include <bits/stdc++.h>

using namespace std;

#define ll long long

void solve()
{
    int x, y;
    cin >> x >> y;

    int a = x / 10;
    if (x % 10 != 0)
        a += 1;

    int b = y / 10;
    if (y % 10 != 0)
        b += 1;

    cout << abs(a - b) << endl;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        solve();
    }

    return 0;
}