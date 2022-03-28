#include <bits/stdc++.h>

using namespace std;

int main()
{
    string s;
    cin >> s;

    int arr[4] = {0};

    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] != '+')
            arr[s[i] - '0']++;
    }

    string ans = "";
    while (arr[1] != 0)
    {
        ans += '1';
        ans += '+';
        arr[1]--;
    }

    while (arr[2] != 0)
    {
        ans += '2';
        ans += '+';
        arr[2]--;
    }

    while (arr[3] != 0)
    {
        ans += '3';
        ans += '+';
        arr[3]--;
    }

    ans.erase(ans.length() - 1);

    cout << ans << endl;

    return 0;
}