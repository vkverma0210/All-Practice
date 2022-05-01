#include <bits/stdc++.h>
using namespace std;

bool Prime(int n)
{
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
            return false;
    }

    return true;
}

int superPrimes(int n)
{
    int cnt = 0;

    for (int i = 5; i <= n; i++)
    {
        if (Prime(i) && Prime(i - 2))
            cnt++;
    }

    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        cout << superPrimes(n) << "\n";
    }

    return 0;
}
