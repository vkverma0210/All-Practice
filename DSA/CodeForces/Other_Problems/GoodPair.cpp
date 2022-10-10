#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;

    for (int i = 1; i <= t; i++)
    {
        int n;
        cin >> n;

        int arr[n];

        for (int i = 1; i <= n; i++)
        {
            cin >> arr[i];
        }

        int a = min_element(arr + 1, arr + n + 1) - arr;
        int b = max_element(arr + 1, arr + n + 1) - arr;
        cout << a << " " << b << "\n";
    }

    return 0;
}