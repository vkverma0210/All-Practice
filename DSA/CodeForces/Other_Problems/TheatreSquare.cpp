#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main()
{
    ll n, m, a;
    cin >> n >> m >> a;

    ll q1 = n / a;
    ll r1 = n % a;

    if (r1 != 0)
        q1 += 1;

    ll q2 = m / a;
    ll r2 = m % a;

    if (r2 != 0)
        q2 += 1;

    cout << q1 * q2 << endl;
}