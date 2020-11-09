#include <bits/stdc++.h>

using namespace std;

string findSuspiciousUserId(int n, vector<vector<int>> v) {
    map<int,vector<int>> hash;
    for(int i=0;i<n;i++)
    {
        for(int j=1;j<(int)v[i].size();j++)
        {
            hash[v[i][0]].push_back(v[i][j]);
        }
    }
    for(auto it=hash.begin();it!=hash.end();it++)
    {
        sort((it->second).begin(),(it->second).end());
    }
    set<int> s;
    for(auto x:hash)
    {
        for(auto y:x.second)
        {
            if(binary_search(hash[y].begin(),hash[y].end(),x.first))
            {
                s.insert(x.first);
                s.insert(y);
            }
        }
    }
    int t=130;
    while(t--)
    {
        for(auto x:hash)
        {
            int c=0;
            for(auto y:x.second)
            {
                if(s.count(y)==1)
                c++;
            }
            if(c>=2)
             s.insert(x.first);
        }
    }
    vector<int> res;
    for(auto x:s)
    res.push_back(x);
    for(int i=0;i<(int)res.size();i++)
    {
        if(i==(int)res.size()-1)
        {
            cout<<res[i];
        }
        else
        {
            cout<<res[i]<<",";
        }
    }
    return "";
}

vector<string> split(const string& str, char delim) {
    vector<string> strings;
    size_t start;
    size_t end = 0;
    while ((start = str.find_first_not_of(delim, end)) != string::npos) {
        end = str.find(delim, start);
        strings.push_back(str.substr(start, end - start));
    }
    return strings;
}

vector<int> splitStringToInt(const string& str, char delim) {
    vector<int> strings;
    size_t start;
    size_t end = 0;
    while ((start = str.find_first_not_of(delim, end)) != string::npos) {
        end = str.find(delim, start);
        strings.push_back(stoi(str.substr(start, end - start)));
    }
    return strings;
}

void printVector(vector<int> vec) {
    for (vector<int>::const_iterator i = vec.begin(); i != vec.end(); ++i) {
        cout << *i << ' ';
    }
    cout << endl;
}

void printVector(vector<string> vec) {
    for (vector<string>::const_iterator i = vec.begin(); i != vec.end(); ++i) {
        cout << *i << ' ';
    }
    cout << endl;
}

int main() {
    string firstLine;
    getline(cin, firstLine);

    int numOfQuestions = strtol(firstLine.c_str(), NULL, 10);;

    string questionAndAnswerStr;
    getline(cin, questionAndAnswerStr);

    vector<vector<int>> questionAndAnswerVecOfVec;
    vector<string> questionAndAnswerVecByComma = split(questionAndAnswerStr, ',');

    for (vector<string>::const_iterator i = questionAndAnswerVecByComma.begin(); i != questionAndAnswerVecByComma.end(); ++i) {
        vector<int> bankerPreferenceVecByAnd = splitStringToInt(*i, ' ');
        questionAndAnswerVecOfVec.push_back(bankerPreferenceVecByAnd);
    }

    string result = findSuspiciousUserId(numOfQuestions, questionAndAnswerVecOfVec);

    // Do not remove below line
    cout << result << "\n";
    // Do not print anything after this line

    return 0;
}