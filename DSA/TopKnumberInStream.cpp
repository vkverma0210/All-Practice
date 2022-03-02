#include <bits/stdc++.h>

using namespace std;

void kTop(int arr[], int n, int k)
{
    vector<int> top(k + 1);
    unordered_map<int, int> freq;

    for (int i = 0; i < n; i++)
    {
        freq[arr[i]]++;
        top[k] = arr[i];

        auto it = find(top.begin(), top.end() - 1, arr[i]);

        for (int j = distance(top.begin(), it) - 1; j >= 0; j--)
        {
            if (freq[top[j]] < freq[top[j + 1]])
                swap(top[j], top[j + 1]);

            else if ((freq[top[j]] == freq[top[j + 1]]) && (top[j] > top[j + 1]))
                swap(top[j], top[j + 1]);
            else
                break;
        }

        for (int j = 0; j < k && top[j] != 0; j++)
            cout << top[j] << " ";
    }

    cout << endl;
}

int main()
{
    int k = 4;

    int arr[] = {5, 2, 1, 3, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    kTop(arr, n, k);

    return 0;
}