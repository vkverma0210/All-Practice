#include <bits/stdc++.h>

using namespace std;

int missingNumber(vector<int> &nums)
{
    int n = nums.size();

    int ans = 0;

    for (int i = 1; i <= n; i++)
    {
        ans ^= i;
    }

    for (int i = 0; i < n; i++)
    {
        ans ^= nums[i];
    }

    return ans;
}

int main()
{
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    int ans = missingNumber(nums);

    cout << ans << endl;

    return 0;
}