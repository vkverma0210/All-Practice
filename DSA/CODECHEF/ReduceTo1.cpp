#include <bits/stdc++.h>

using namespace std;

#define ll long long

void solve()
{
    ll n;
    cin >> n;

    if (n == 1)
    {
        cout << 0 << endl;
        return;
    }

    if (n % 2 != 0)
    {
        cout << 1 << endl;
        return;
    }

    if (n % 2 == 0 && ceil((double)sqrt(n)) == floor((double)sqrt(n)))
    {
        cout << 1 << endl;
        return;
    }

    ll moves = 0;

    while (!(n & 1))
    {
        moves++;
        n >>= 1;
    }

    if (moves % 2 != 0)
        cout << -1 << endl;
    else
    {
        if (n == 1)
            cout << 1 << endl;
        else
            cout << 2 << endl;
    }
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