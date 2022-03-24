#include <bits/stdc++.h>

using namespace std;

int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
{
    int n = gas.size();
    int total_surplus = 0;
    int surplus = 0;
    int start = 0;

    for (int i = 0; i < n; i++)
    {
        total_surplus += gas[i] - cost[i];
        surplus += gas[i] - cost[i];

        if (surplus < 0)
        {
            surplus = 0;
            start = i + 1;
        }
    }

    return (total_surplus < 0) ? -1 : start;
}

int main()
{
    int n;
    cin >> n;

    vector<int> gas;
    vector<int> cost;

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        gas.push_back(x);
    }

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        cost.push_back(x);
    }

    cout << canCompleteCircuit(gas, cost) << endl;
}