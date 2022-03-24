#include <bits/stdc++.h>

using namespace std;

long aggregrateTemp(vector<long> vec)
{
    vector<long> arr1{};
    vector<long> arr2{};

    long i = 0;
    long j = vec.size() - 1;

    long temp = 0;

    while (i < vec.size())
    {
        temp += vec[i];
        arr1.push_back(temp);
        i++;
    }

    temp = 0;
    while (j >= 0)
    {
        temp += vec[j];
        arr2.push_back(temp);
        j--;
    }

    reverse(arr2.begin(), arr2.end());

    vector<long> ans(vec.size(), 0);

    for (long x{}; x < vec.size(); x++)
    {
        ans[x] = max(arr1[x], arr2[x]);
    }

    return *max_element(ans.begin(), ans.end());
}

int main()
{

    long n;
    cin >> n;

    vector<long> vec;

    for (long i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
    }

    cout << aggregrateTemp(vec) << endl;
}