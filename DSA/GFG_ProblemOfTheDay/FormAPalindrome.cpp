#include <bits/stdc++.h>

using namespace std;

int findMinInsertion(string s)
{
    int n = s.length();

    string s1 = s;
    reverse(s1.begin(), s1.end());

    int dp[n + 1][n + 1];

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (s[i - 1] == s1[j - 1])
                dp[i][j] = 1 + dp[i - 1][j - 1];
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return n - dp[n][n];
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        string s;
        cin >> s;

        cout << findMinInsertion(s) << endl;
    }

    return 0;
}