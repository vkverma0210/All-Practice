#include <bits/stdc++.h>
using namespace std;

#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define trav(a, x) for(auto& a : x)
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()
#define subnb true
#define Lnb true
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;

void solve(int tcase) {
    string str;
    cin >> str;
    int rem = 0;
    for (char c : str) {
        rem = (rem + (c - '0')) % 9;
    }
    int d = (9 - rem) % 9;
    int pos = (d == 0 ? 1 : 0);
    while(pos < sz(str) && str[pos] - '0' <= d) {
        pos++;
    }
    str.insert(str.begin() + pos, (char)(d + '0'));
    cout << "Case #" << tcase << ": " << str << '\n';

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    rep(t, 1, T + 1) {
        solve(t);
    }
}
