class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1 == "0" || num2 == "0") return "0";
        
        int m = num1.size(), n = num2.size();
        vector<int> res(m + n, 0);

        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                int mul = (num1[i] - '0') * (num2[j] - '0');
                int sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10; // keep the digit
                res[i + j] += sum / 10; // carry left
            }
        }

        string out;
        for (int d : res)
            if (!(out.empty() && d == 0))
                out += char(d + '0');
        return out;
    }
};
