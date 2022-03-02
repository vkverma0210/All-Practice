#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;
    int z = 1;

    while (t--)
    {
        int n, m;
        cin >> n >> m;
        int arr[n];

        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
            sum += arr[i];
        }

        cout << "Case #" << z << ": " << sum % m << endl;
        z++;
    }

    return 0;
}