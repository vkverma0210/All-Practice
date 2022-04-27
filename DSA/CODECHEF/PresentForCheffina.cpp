#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        long n;
        cin >> n;

        long quo = n / 5;
        long rem = n % 5;

        long ans = 4 * quo + rem;

        cout << ans << "\n";
    }

    return 0;
}