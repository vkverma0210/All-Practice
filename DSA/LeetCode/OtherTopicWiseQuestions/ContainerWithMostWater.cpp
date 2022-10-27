#include <bits/stdc++.h>

using namespace std;

int maxArea(vector<int> &height)
{
    int left = 0;
    int right = height.size() - 1;

    int ans = 0;

    while (left < right)
    {
        int area = min(height[left], height[right]) * (right - left);

        if (height[left] <= height[right])
            left++;
        else
            right--;

        ans = max(ans, area);
    }

    return ans;
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

    int ans = maxArea(vec);

    cout << ans << endl;

    return 0;
}