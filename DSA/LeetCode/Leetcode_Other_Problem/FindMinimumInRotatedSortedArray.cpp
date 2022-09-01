#include <bits/stdc++.h>

using namespace std;

int findMin(vector<int> &nums)
{
    int start = 0;
    int end = nums.size() - 1;
    int mid = start + (end - start) / 2;

    while (start < end)
    {
        if (nums[mid] > nums[end])
            start = mid + 1;
        else if (nums[mid] < nums[end])
            end = mid;

        mid = start + (end - start) / 2;
    }

    return nums[mid];
}

int main()
{
    int n;
    cin >> n;

    vector<int> vec;

    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        vec.push_back(x);
    }

    int ans = findMin(vec);

    cout << ans << endl;

    return 0;
}