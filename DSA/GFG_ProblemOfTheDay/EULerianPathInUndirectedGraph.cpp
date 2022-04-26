#include <bits/stdc++.h>
using namespace std;

int eulerPath(int N, vector<vector<int>> graph)
{
    vector<int> numofadj(N, 0);

    for (int i = 0; i < N; i++)
    {
        int count = 0;

        for (int j = 0; j < N; j++)
        {
            if (graph[i][j] == 1)
                count++;
        }
        numofadj[i] = count;
    }

    int oddVertex = 0;

    for (int i = 0; i < N; i++)
    {
        if (numofadj[i] % 2)
            oddVertex++;
    }

    return oddVertex == 2 ? 1 : 0;
}

void findPath(vector<vector<int>> graph, int n)
{
    vector<int> numofadj;

    for (int i = 0; i < n; i++)
    {
        numofadj.push_back(accumulate(graph[i].begin(), graph[i].end(), 0));
    }

    int startpoint = 0, numofodd = 0;

    for (int i = n - 1; i >= 0; i--)
    {
        if (numofadj[i] % 2 == 1)
        {
            numofodd++;
            startpoint = i;
        }
    }

    if (numofodd > 2)
    {
        cout << "No Solution" << endl;
        return;
    }

    stack<int> stac;
    vector<int> path;

    int curr = startpoint;

    while (!stac.empty() or accumulate(graph[curr].begin(), graph[curr].end(), 0) != 0)
    {
        if (accumulate(graph[curr].begin(), graph[curr].end(), 0) == 0)
        {
            path.push_back(curr);
            curr = stac.top();
            stac.pop();
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                if (graph[curr][i] == 1)
                {
                    stac.push(curr);
                    graph[curr][i] = 0;
                    graph[i][curr] = 0;
                    curr = i;
                    break;
                }
            }
        }
    }

    for (auto ele : path)
        cout << ele + 1 << " -> ";
    cout << curr + 1 << endl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        vector<vector<int>> graph(N, vector<int>(N, -1));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                cin >> graph[i][j];

        cout << eulerPath(N, graph) << "\n";
        findPath(graph, N);
    }

    return 0;
}