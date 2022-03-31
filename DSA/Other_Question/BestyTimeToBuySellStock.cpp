#include <bits/stdc++.h>

using namespace std;

int maxProfit(vector<int> &prices)
{
    int buy = INT_MAX;
    int total_profit = 0;
    int curr_profit = 0;

    for (int i = 0; i < prices.size(); i++)
    {
        if (prices[i] < buy)
            buy = prices[i];

        curr_profit = prices[i] - buy;

        if (total_profit < curr_profit)
        {
            total_profit = curr_profit;
        }
    }

    return total_profit;
}

int main()
{
    int n;
    cin >> n;

    vector<int> prices(n);

    for (int i = 0; i < n; i++)
    {
        cin >> prices[i];
    }

    cout << maxProfit(prices) << endl;

    return 0;
}