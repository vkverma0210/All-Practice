#include <bits/stdc++.h>

using namespace std;

int firstMissingPositive1(vector<int> &nums)
{
    int maxEle = *max_element(nums.begin(), nums.end());

    int count = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] <= 0)
            count++;
    }

    if (count == nums.size())
        return 1;

    for (int i = 1; i < maxEle; i++)
    {
        if (find(nums.begin(), nums.end(), i) == nums.end())
        {
            return i;
        }
    }

    return maxEle + 1;
}

int firstMissingPositive(vector<int> &nums)
{
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] < 0)
            nums[i] = 0;
    }

    for (int i = 0; i < nums.size(); i++)
    {
        int value = abs(nums[i]);

        if (value > nums.size() or value < 1)
            continue;

        if (nums[value - 1] > 0)
            nums[value - 1] *= -1;
        else if (nums[value - 1] == 0)
            nums[value - 1] = -1 * (nums.size() + 1);
    }

    for (int i = 1; i <= nums.size(); i++)
    {
        if (nums[i - 1] >= 0)
            return i;
    }

    return nums.size() + 1;
}

int main()
{
    int n;
    cin >> n;
    vector<int> nums(n);

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    cout << firstMissingPositive(nums);

    return 0;
}