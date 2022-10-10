#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main()
{
    ll k, n, w;
    cin >> k >> n >> w;

    ll cost = 0;
    for (ll i = 1; i <= w; i++)
    {
        cost += k * i;
    }

    if (cost <= n)
        cout << 0 << "\n";
    else
        cout << cost - n << "\n";

    return 0;
}