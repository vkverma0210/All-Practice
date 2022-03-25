#include <bits/stdc++.h>

using namespace std;

int *greaterElement(int arr[], int n)
{
    set<int> s;

    for (int i = 0; i < n; i++)
    {
        s.insert(arr[i]);
    }

    for (int i = 0; i < n; i++)
    {
        auto itr = s.find(arr[i]);
        auto temp = ++itr;

        if (temp == s.end())
        {
            arr[i] = -10000000;
        }
        else
            arr[i] = *temp;
    }

    return arr;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        int arr[n];

        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        int *b;
        b = greaterElement(arr, n);

        for (int i = 0; i < n; i++)
        {
            if (b[i] == -10000000)
                cout << "_ ";
            else
                cout << b[i] << " ";
        }

        cout << endl;
    }

    return 0;
}