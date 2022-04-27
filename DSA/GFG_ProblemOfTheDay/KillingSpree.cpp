#include <bits/stdc++.h>
using namespace std;

// long long int killinSpree(long long int n)
// {
//     long long int k = n, i = 1;

//     while(k >= i * i)
//     {
//         k -= (i * i);
//         i++;
//     }

//     return i - 1;
// }

long long int helper(long long int n)
{
    long long int ans;
    ans = (n * (n + 1) * (2 * n + 1)) / 6;
    return ans;
}

long long int killinSpree(long long int n)
{
    if (n == 1)
        return 1;

    long long int low = 1, high = INT_MAX, mid, ans;

    while (low <= high)
    {
        mid = low + (high - low) / 2;

        if (helper(mid) == n)
            return mid;

        if (helper(mid) < n)
        {
            ans = mid;
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    return ans;
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        long long int n;
        cin >> n;
        long long int ans = killinSpree(n);
        cout << ans << "\n";
    }

    return 0;
}