#include <bits/stdc++.h>

using namespace std;

maximumXOR(vector<int> &nums)
{
    vector<int> count(32, 0);

    for (int num : nums)
    {
        for (int i = 0; i < 32; i++)
        {
            count[i] += num >> i & 1;
        }
    }

    int ans = 0;

    for (int i = 0; i < 32; i++)
    {
        if (count[i] > 0)
            ans |= 1 << i;
    }

    return ans;
}

int main()
{
    int n;
    cin >> n;

    vector<int> nums;

    for (int j = 0; j < n; j++)
    {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    int ans = maximumXOR(nums);

    cout << ans << endl;

    return 0;
}