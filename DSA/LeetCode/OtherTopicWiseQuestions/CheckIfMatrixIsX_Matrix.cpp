#include <bits/stdc++.h>

using namespace std;

bool checkXMatrix(vector<vector<int>> &grid)
{
    int n = grid[0].size();

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if ((i == j) || ((i + j) == (n - 1)))
            {
                if (grid[i][j] == 0)
                    return false;
            }
            else
            {
                if (grid[i][j] != 0)
                    return false;
            }
        }
    }

    return true;
}

int main()
{
    int n;
    cin >> n;

    vector<vector<int>> grid;

    for (int i = 0; i < n; i++)
    {
        vector<int> v1;

        for (int j = 0; j < n; j++)
        {
            int x;
            cin >> x;
            v1.push_back(x);
        }

        grid.push_back(v1);
    }

    bool ans = checkXMatrix(grid);

    if (ans)
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }

    return 0;
}