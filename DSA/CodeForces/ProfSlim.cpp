#include <bits/stdc++.h>

using namespace std;

bool solve(int n, vector<int> &vec)
{
    int start = 0;
    int end = n - 1;

    while (start <= end)
    {
        if (vec[start] <= vec[end])
            start++;
        else if (vec[start] > vec[end] && vec[end] < 0)
        {
            vec[start] = -1 * vec[start];
            vec[end] = -1 * vec[end];
            start++;
            end--;
        }
        else if (vec[start] > vec[end] && vec[end] > 0)
        {
            return false;
        }
    }

    return true;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        vector<int> vec(n);
        for (int i = 0; i < n; i++)
        {
            cin >> vec[i];
        }

        bool ans = solve(n, vec);

        if (ans)
            cout << "YES \n";
        else
            cout << "NO \n";
    }

    return 0;
}