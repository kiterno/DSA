#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Trie {
public:
    static const int mod = 1000000009;
    unordered_map<char, Trie*> children;
    bool endOfWord;

    Trie() : endOfWord(false) {}

    void insert(const string& word) {
        Trie* temp = this;
        for (char ch : word) {
            if (!temp->children.count(ch)) {
                temp->children[ch] = new Trie();
            }
            temp = temp->children[ch];
        }
        temp->endOfWord = true;
    }

    long long search(const string& word, int start, const vector<long>& dp) {
        Trie* temp = this;
        long long ans = 0;

        for (int i = start; i < word.length(); i++) {
            char ch = word[i];

            if (!temp->children.count(ch)) {
                return ans;
            }

            temp = temp->children[ch];

            if (temp->endOfWord) {
                ans = (ans + dp[i + 1]) % mod;
            }
        }

        return ans;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int n;
    cin >> n;

    Trie trie;

    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        trie.insert(word);
    }

    vector<long> dp(s.length() + 1, 0);
    dp[s.length()] = 1;

    for (int i = s.length() - 1; i >= 0; i--) {
        dp[i] = trie.search(s, i, dp);
    }

    cout << dp[0] << '\n';

    return 0;
}
