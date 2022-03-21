#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "

bool notPalindrome(string a)
{
    string b = a;
    reverse(b.begin(), b.end());
    return b != a;
}

int helper(string prev, int index, string &s, map<pair<int, string>, int> &dp)
{
    if (index == s.size())
    {
        return 1;
    }

    if (dp.find({index, prev}) != dp.end())
    {
        return dp[{index, prev}];
    }

    string x1 = prev.substr(1, 4);
    string x2 = prev.substr(1, 4);

    x1 += '0';
    x2 += '1';

    int ans = 0;

    if (s[index] == '?')
    {
        if (notPalindrome(x1) && notPalindrome(prev + "0"))
            ans += helper(x1, index + 1, s, dp);

        if (notPalindrome(x2) && notPalindrome(prev + "1"))
            ans += helper(x2, index + 1, s, dp);
    }
    else if (s[index] == '1')
    {
        if (notPalindrome(x2) && notPalindrome(prev + "1"))
            ans += helper(x2, index + 1, s, dp);
    }
    else
    {
        if (notPalindrome(x1) && notPalindrome(prev + "0"))
            ans += helper(x1, index + 1, s, dp);
    }

    dp[{index, prev}] = ans;
    return ans;
}

int main()
{
    int t;
    cin >> t;

    for (int curr = 1; curr <= t; curr++)
    {
        int n;
        cin >> n;
        string s;
        cin >> s;

        map<pair<int, string>, int> dp;
        res;
        cout << (helper("?????", 0, s, dp) ? "POSSIBLE" : "IMPOSSIBLE") << "\n";
    }

    return 0;
}