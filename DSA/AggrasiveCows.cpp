#include <bits/stdc++.h>

using namespace std;

bool canPlacedCows(int stall[], int n, int cow, int min_sep)
{
    int lastCow = stall[0];

    int cnt = 1;

    for (int i = 1; i < n; i++)
    {
        if (stall[i] - lastCow >= min_sep)
        {
            lastCow = stall[i];
            cnt++;

            if (cnt == cow)
            {
                return true;
            }
        }
    }

    return false;
}

int main()
{
    int stall[] = {1, 2, 4, 8, 9};

    int n = 5;

    int cow = 3;

    int s = 0;
    int e = stall[n - 1] - stall[0];
    int ans = 0;

    while (s <= e)
    {
        int mid = (s + e) / 2;
        bool cowplaced = canPlacedCows(stall, n, cow, mid);

        if (cowplaced)
        {
            ans = mid;
            s = mid + 1;
        }
        else
        {
            e = mid - 1;
        }
    }

    cout << ans << endl;

    return 0;
}