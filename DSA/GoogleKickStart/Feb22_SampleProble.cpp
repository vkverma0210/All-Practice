#include <bits/stdc++.h>

using namespace std;

#define res cout << "Case #" << curr << ": "

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    for (int curr = 1; curr <= t; curr++)
    {
        int n, m;
        cin >> n >> m;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            int x;
            cin >> x;
            sum += x;
        }

        cout << "Case #" << curr << ": " << sum % m << "\n";
    }

    return 0;
}