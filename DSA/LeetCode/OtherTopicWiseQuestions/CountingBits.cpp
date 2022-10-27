#include <bits/stdc++.h>

using namespace std;

vector<int> countBits(int n)
{
    vector<int> ans(n + 1, 0);

    for (int i = 1; i <= n; i++)
    {
        if (i % 2 == 0)
            ans[i] = ans[i / 2];
        else
            ans[i] = ans[i / 2] + 1;
    }

    return ans;
}

int main()
{
    int n;
    cin >> n;

    vector<int> ans = countBits(n);

    for (int i = 0; i <= n; i++)
    {
        cout << ans[i] << " ";
    }

    cout << endl;

    return 0;
}