#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;

    int arr[n + 1];
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }

    int temp = arr[k];
    int ans = 0;

    for (int i = 1; i <= n; i++)
    {
        if (arr[i] == 0)
            continue;
        if (arr[i] >= temp)
            ans += 1;
    }

    cout << ans << endl;
    return 0;
}