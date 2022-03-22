#include <bits/stdc++.h>

using namespace std;

vector<int> Smallestonleft(int arr[], int n)
{
    vector<int> ans(n);

    set<int> s;

    for (int i = 0; i < n; i++)
    {
        s.insert(arr[i]);

        auto pos = s.lower_bound(arr[i]);

        if (pos == s.begin())
        {
            ans[i] = -1;
        }
        else
        {
            pos--;
            ans[i] = *pos;
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
        int n;
        cin >> n;
        int arr[n + 1];

        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        vector<int> b;
        b = Smallestonleft(arr, n);
        for (int i = 0; i < n; i++)
            cout << b[i] << " ";
        cout << endl;
    }

    return 0;
}