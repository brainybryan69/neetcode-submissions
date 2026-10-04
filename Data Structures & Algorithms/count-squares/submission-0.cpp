class CountSquares {
    unordered_map<long long, int> cnt;
    vector<pair<int, int>> pts;

    long long key(int x, int y) { return (long long)(x) * 2001 + y; }

public:
    CountSquares() {}
    
    void add(vector<int> point) {
        int x = point[0], y = point[1];
        if (cnt[key(x, y)]++ == 0) pts.push_back({x, y}); // record distinct points once
    }
    
    int count(vector<int> point) {
        int qx = point[0], qy = point[1], res = 0;
        for (auto [x, y] : pts) {
            if (abs(x - qx) != abs(y - qy) || x == qx) continue; // not a diagonal corner
            res += cnt[key(x, y)]
                 * (cnt.count(key(qx, y)) ? cnt[key(qx, y)] : 0)
                 * (cnt.count(key(x, qy)) ? cnt[key(x, qy)] : 0);
        }
        return res;
    }
};
