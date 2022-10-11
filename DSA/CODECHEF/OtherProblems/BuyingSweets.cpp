#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int n, r;
        cin >> n >> r;

        vector<int> a, b;

        for (int i = 0; i < n; i++)
        {
            int x;
            cin >> x;
            a.push_back(x);
        }

        for (int i = 0; i < n; i++)
        {
            int x;
            cin >> x;
            b.push_back(x);
        }

        vector<pair<int, pair<int, int>>> v;
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            v.push_back(make_pair(a[i] - b[i], make_pair(a[i], b[i])));
        }

        sort(v.begin(), v.end());

        for (int i = 0; i < n; i++)
        {
            while (r >= v[i].second.first)
            {
                int g = r / v[i].second.first;

                count += g;

                r -= g * v[i].first;
            }
        }

        cout << count << endl;
    }
    return 0;
}