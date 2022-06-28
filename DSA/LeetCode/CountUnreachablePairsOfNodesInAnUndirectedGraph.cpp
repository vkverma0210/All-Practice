#include <bits/stdc++.h>

using namespace std;

long long dfs(vector<vector<int>> &adj, int si, vector<bool> &visit)
{
    if (visit[si])
        return 0;

    visit[si] = true;

    long long count = 1;

    for (int i = 0; i < adj[si].size(); i++)
    {
        if (visit[adj[si][i]])
            continue;

        count += dfs(adj, adj[si][i], visit);
    }

    return count;
}

long long countPairs(int n, vector<vector<int>> &edges)
{
    vector<vector<int>> adj(n);

    for (int i = 0; i < edges.size(); i++)
    {
        int a = edges[i][0];
        int b = edges[i][1];

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    vector<bool> visit(n, false);

    long long count = 0;
    long long ans = 0;

    for (int i = 0; i < n; i++)
    {
        if (visit[i])
            continue;

        long long x = dfs(adj, i, visit);

        ans += count * x;
        count += x;
    }

    return ans;
}

int main()
{
    int n;
    cin >> n;

    int m;
    cin >> m;

    vector<vector<int>> edges;

    for (int i = 0; i < m; i++)
    {
        vector<int> v1;

        for (int j = 0; j < 2; j++)
        {
            int x;
            cin >> x;
            v1.push_back(x);
        }

        edges.push_back(v1);
    }

    long long ans = countPairs(n, edges);

    cout << ans << endl;

    return 0;
}