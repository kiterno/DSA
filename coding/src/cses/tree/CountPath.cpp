// Online C++ compiler to run C++ program online
#include<bits/stdc++.h>
using namespace std;

const int MX = 2e5 + 5;
const int MS = 18;

vector<int> adj[MX];
int up[MS][MX];
int depth[MX];

void constructBinaryLifting(int n) {
    queue<pair<int, pair<int, int>>> q;
    q.push({1, {1, 0}});
    vector<bool> vis(n + 1, false);

    while (!q.empty()) {
        int cur = q.front().first;
        int curDepth = q.front().second.first;
        int parent = q.front().second.second;
        q.pop();

        vis[cur] = true;
        depth[cur] = curDepth;
        up[0][cur] = parent;

        for (int i:adj[cur]) {
            if (!vis[i]) {
                q.push({i, {curDepth + 1, cur}});
            }
        }
    }

    for (int i = 1; i < MS; i++) {
        for (int j = 1; j <= n; j++) {
            up[i][j] = up[i - 1][up[i - 1][j]];
        }
    }
}

int jump(int x, int d) {
    for (int i = 0; i < MS; i++) {
        if (((d >> i) & 1) == 1) x = up[i][x];
    }

    return (x == 0) ? -1 : x;
}

int LCA(int x, int d) {
    if (depth[x] < depth[d]) {
        int t = x;
        x = d;
        d = t;
    }

    x = jump(x, depth[x] - depth[d]);
    if (x == d) return x;

    for (int i = 17; i >= 0; i--) {
        int xT = up[i][x], dT = up[i][d];

        if (xT != dT) {
            x = xT;
            d = dT;
        }
    }

    return up[0][x];
}

int dfs(vector<int>& val, vector<bool>& vis, int i) {
    vis[i] = true;

    for (int j : adj[i]) {
        if (!vis[j])
            val[i] += dfs(val, vis, j);
    }

    return val[i];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, queries;
    cin >> n >> queries;

    for (int i = 0; i <= n; i++) {
        adj[i].clear();
    }

    for (int i = 2; i <= n; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    constructBinaryLifting(n);

    vector<int> val(n + 1, 0);

    for (int i = 0; i < queries; i++) {
        int u, v;
        cin >> u >> v;

        val[u] += 1;
        val[v] += 1;

        int p = LCA(u, v);
        if (p != 0) {
            val[p]--;
            if (up[0][p] != 0) {
                val[up[0][p]]--;
            }
        }
    }

    vector<bool> vis(n + 1, false);
    dfs(val, vis, 1);

    for (int i = 1; i <= n; i++) {
        cout << val[i] << " ";
    }
    cout << endl;

    return 0;
}
