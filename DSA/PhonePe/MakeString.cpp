
#include <bits/stdc++.h>

using namespace std;

string makeNewString(string str)
{
    int n = str.length();
    int count_W = 0;
    int count_D = 0;
    int count_L = 0;

    for (int i{}; i < n; i++)
    {
        if (str[i] == 'W')
            count_W++;

        if (str[i] == 'D')
            count_D++;

        if (str[i] == 'L')
            count_L++;
    }

    int j = 0;
    int k = 0;
    string result{};

    while (k < n)
    {
        if (j == 0 && count_W > 0)
        {
            count_W--;
            result += 'W';
            k++;
        }

        if (j == 1 && count_D > 0)
        {
            count_D--;
            result += 'D';
            k++;
        }

        if (j == 2 && count_L > 0)
        {
            count_L--;
            result += 'L';
            k++;
        }

        if (j == 2)
            j = 0;
        else
            j++;
    }

    return result;
}

int main()
{
    string str;
    cin >> str;

    cout << makeNewString(str) << endl;

    return 0;
}