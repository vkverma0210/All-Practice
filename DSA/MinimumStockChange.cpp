#include <bits/stdc++.h>

using namespace std;

int findEarliestMonth(vector<int> stockPrice)
{
    vector<int> arr1{};
    vector<int> arr2{};

    int i = 0;
    int j = stockPrice.size() - 1;
    int temp = 0;

    while (i < stockPrice.size())
    {
        temp += stockPrice[i];
        arr1.push_back(temp);
        i++;
    }

    temp = 0;

    while (j >= 0)
    {
        temp += stockPrice[j];
        arr2.push_back(temp);
        j--;
    }

    reverse(arr2.begin(), arr2.end());

    vector<int> ans(stockPrice.size() - 1, 0);

    for (int x{}; x < ans.size(); x++)
    {
        ans[x] = abs(floor((arr1[x] * 1.0) / (x + 1)) - floor((arr2[x + 1] * 1.0) / (stockPrice.size() - x - 1)));
    }

    temp = INT_MAX;

    int res = 0;
    for (int i = 0; i < ans.size(); i++)
    {
        if (ans[i] < temp)
        {
            temp = ans[i];
            res = i + 1;
        }
    }

    return res;
}

int main()
{
    int n;
    cin >> n;

    vector<int> stockPrice;

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        stockPrice.push_back(x);
    }

    cout << findEarliestMonth(stockPrice) << endl;
}