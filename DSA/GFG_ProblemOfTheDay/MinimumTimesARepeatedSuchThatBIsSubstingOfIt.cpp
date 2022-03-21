#include <bits/stdc++.h>

using namespace std;

bool match_char(string A, string B)
{
    set<char> arr;

    for (int i = 0; i < A.size(); i++)
    {
        arr.insert(A[i]);
    }

    for (int i = 0; i < B.size(); i++)
    {
        char c = B[i];

        if (arr.find(c) == arr.end())
        {
            return false;
        }
    }

    return true;
}

bool subString(string s1, string s2)
{
    int i = 0;
    int l1 = s1.size();

    int j = 0;
    int l2 = s2.size();

    while (i < l1 && j < l2)
    {
        if (s1[i] != s2[j])
        {
            i++;
            j = 0;
        }
        else
        {
            i++;
            j++;
        }
    }
    return j == l2;
}

int minRepeats(string A, string B)
{
    if (match_char(A, B) == false)
        return -1;

    string temp = A;
    int count = 1;

    while (temp.length() < B.length())
    {
        temp = temp + A;
        count++;
    }
    if (subString(temp, B))
    {
        return count;
    }

    if (subString(temp + A, B))
    {
        return count + 1;
    }

    return -1;
}

int main()
{
    int t;
    scanf("%d ", &t);

    while (t--)
    {
        string A, B;
        getline(cin, A);
        getline(cin, B);

        cout << minRepeats(A, B) << endl;
    }
}