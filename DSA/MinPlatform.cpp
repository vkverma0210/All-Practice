#include <bits/stdc++.h>

using namespace std;

int findPlatform1(int arr[], int dep[], int n)
{
    int plat_needed = 1, res = 1;

    for (int i = 0; i < n; i++)
    {
        plat_needed = 1;

        for (int j = i + 1; j < n; j++)
        {
            if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i]))
                plat_needed++;
        }

        res = max(res, plat_needed);
    }

    return res;
}

int findPlatform2(int arr[], int dep[], int n)
{
    sort(arr, arr + n);
    sort(dep, dep + n);

    int plat_needed = 1, res = 1;
    int i = 1, j = 0;

    while (i < n && j < n)
    {
        if (arr[i] <= dep[j])
        {
            plat_needed++;
            i++;
        }
        else if (arr[i] > dep[j])
        {
            plat_needed--;
            j++;
        }

        if (plat_needed > res)
            res = plat_needed;
    }

    return res;
}

int findPlatform3(int arr[], int dep[], int n)
{
    multiset<pair<int, char>> order;

    for (int i = 0; i < n; i++)
    {
        order.insert(make_pair(arr[i], 'a'));
        order.insert(make_pair(dep[i], 'd'));
    }

    int plat_needed = 0;
    int res = 0;

    for (auto it : order)
    {
        if (it.second == 'a')
        {
            plat_needed++;
        }
        else
        {
            plat_needed--;
        }

        if (plat_needed > res)
            res = plat_needed;
    }

    return res;
}

int findPlatform4(int arr[], int dep[], int n)
{
    int platform[2361] = {};
    int plat_needed = 0;

    for (int i = 0; i < n; i++)
    {
        platform[arr[i]]++;
        platform[dep[i] + 1]--;
    }

    for (int i = 1; i < 2361; i++)
    {
        platform[i] = platform[i] + platform[i - 1];
        plat_needed = max(plat_needed, platform[i]);
    }

    return plat_needed;
}

int main()
{
    int n;
    cin >> n;

    int arr[n];
    int dep[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    for (int i = 0; i < n; i++)
    {
        cin >> dep[i];
    }

    cout << findPlatform4(arr, dep, n) << endl;

    return 0;
}