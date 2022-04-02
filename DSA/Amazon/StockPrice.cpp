#include <bits/stdc++.h>

using namespace std;

long findEarliestMonth(int n, int arr[])
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

    vector<long> ans(n - 1, 0);

    for (long x{}; x < ans.size(); x++)
    {
        ans[x] = abs(floor((arr1[x] * 1.0) / (x + 1)) - floor((arr2[x + 1] * 1.0) / (n - x - 1)));
    }

    temp = INT_MAX;
    long result = 0;

    for (int i{}; i < ans.size(); i++)
    {
        if (ans[i] < temp)
        {
            temp = ans[i];
            result = i + 1;
        }
    }

    return result;
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

    cout << findEarliestMonth(n, arr) << endl;

    return 0;
}