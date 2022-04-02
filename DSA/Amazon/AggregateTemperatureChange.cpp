#include <bits/stdc++.h>

using namespace std;

long getMaxAggregateTemperatureChange(int n, int arr[])
{
    vector<long> arr1{};
    vector<long> arr2{};
    long i = 0;
    long j = n - 1;

    long temp = 0;
    while (i < n)
    {
        temp += arr[i];
        arr1.push_back(temp);
        i++;
    }

    temp = 0;
    while (j >= 0)
    {
        temp += arr[i];
        arr2.push_back(temp);
        j--;
    }

    reverse(arr2.begin(), arr2.end());

    vector<long> ans(n, 0);

    for (long x{}; x < n; x++)
    {
        ans[x] = max(arr1[x], arr2[x]);
    }

    return *max_element(ans.begin(), ans.end());
}

int main()
{
    int n;
    cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    cout << getMaxAggregateTemperatureChange(n, arr) << endl;

    return 0;
}