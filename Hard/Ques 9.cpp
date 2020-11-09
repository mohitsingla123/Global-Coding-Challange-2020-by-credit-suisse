#include <bits/stdc++.h>

using namespace std;

string organizingContainers(vector< vector<int> > n) {
    int flg=0;
    for(int i=0;i<n.size();i++)
    {
        int sum1=0;
            int sum2=0;
        for(int j=0;j<n[i].size();j++)
        {
            if(i==j)
                continue;
            else
                sum1=sum1+n[i][j];    
        }
        for(int j=0;j<n.size();j++)
        {
            if(i==j)
                continue;
            else
                sum2=sum2+n[j][i];
        }
        if(sum1!=sum2)
            flg=1;
    }
    if(flg==1)
    return "Impossible";
    else
    return "Possible";


}
int main(){
    int q;
    cin >> q;
    string answer ="";
    for(int a0 = 0; a0 < q; a0++){
        int n;
        cin >> n;
        vector< vector<int> > M(n,vector<int>(n));
        for(int M_i = 0;M_i < n;M_i++){
           for(int M_j = 0;M_j < n;M_j++){
              cin >> M[M_i][M_j];
           }
        }
		string result=organizingContainers(M);
        if (answer =="")
            answer = result;
        else
            answer = answer + "," + result;
    }
    // Do not remove below line
    cout << answer << endl;
    // Do not print anything after this line
    return 0;
}
