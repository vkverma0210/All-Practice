#include <bits/stdc++.h>

using namespace std;

#define N 8

int Matrix[N][N] = {{0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 0}};

int knows(int a, int b)
{
    return Matrix[a][b];
}

int findCelebrity1(int n) // Time = O(N^ 2) Space = O(N)
{
    int indegree[n]{};
    int outdegree[n]{};

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int x = knows(i, j);
            if (x == 1)
            {
                outdegree[i]++;
                indegree[j]++;
            }
        }
    }

    for (int i = 0; i < n; i++)
        if (indegree[i] == n - 1 && outdegree[i] == 0)
            return i;

    return -1;
}

int findCelebrity2(int n) // Time = O(N) Space = O(N)
{
    stack<int> s;

    int C;

    for (int i = 0; i < n; i++)
        s.push(i);

    while (s.size() > 1)
    {
        int A = s.top();
        s.pop();

        int B = s.top();
        s.pop();

        if (knows(A, B) == 1)
            s.push(B);
        else
            s.push(A);
    }

    if (s.empty())
        return -1;

    C = s.top();
    s.pop();

    for (int i = 0; i < n; i++)
    {
        if ((i != C) && ((knows(C, i) == 1) || (knows(i, C) == 0)))
            return -1;
    }

    return C;
}

int findCelebrity3(int n) // Time = O(N) Space = O(1)
{
    int i = 0, j = n - 1;

    while (i < j)
    {
        if (knows(j, i) == 1)
            j--;
        else
            i++;
    }

    int C = i;

    for (int i = 0; i < n; i++)
    {
        if ((i != C) && ((knows(C, i) == 1) || (knows(i, C) == 0)))
            return -1;
    }

    return C;
}

int main()
{
    int n = 4;
    int id = findCelebrity3(n);

    id == -1 ? cout << "No Celebrity" : cout << "Celebrity Id = " << id << endl;

    return 0;
}