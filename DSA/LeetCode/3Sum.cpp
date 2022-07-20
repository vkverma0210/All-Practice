#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> threeSum(vector<int> &nums)
{
    int n = nums.size();

    if (n < 3)
    {
        return {};
    }

    vector<vector<int>> res;

    sort(nums.begin(), nums.end());

    for (int i = 0; i < n - 2; i++)
    {
        if (i == 0 || nums[i] != nums[i - 1])
        {
            int j = i + 1, k = n - 1;

            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0)
                {
                    res.push_back({nums[i], nums[j], nums[k]});

                    while (j < k && nums[j] == nums[j + 1])
                        j++;

                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++, k--;
                }
                else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
    }

    return res;
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

    vector<vector<int>> ans = threeSum(vec);

    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i][0] << " " << ans[i][1] << " " << ans[i][2] << endl;
    }

    cout << endl;

    return 0;
}