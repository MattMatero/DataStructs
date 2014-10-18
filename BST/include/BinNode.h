#ifndef BINNODE_H
#define BINNODE_H
#include <string>
using namespace std;

class BinNode
{
    public:

        BinNode leftChild(); //gets left child
        BinNode rightChild(); //gets right child
        void updateVal() {++val;};

        //set and get the key + value of a node
        string getKey(){ return this -> keyword;};
        int getElement() { return val;};
        void setKey(const string key){keyword = key;};
        void setElement(int num) { val = num;};


        BinNode(){right = left = NULL;};
        BinNode(string word,int value, BinNode *l=NULL, BinNode *r= NULL)
        {keyword = word, val = value, left = l, right = r;};
        virtual ~BinNode();
    private:
        string keyword;  //the nodes key
        int val; //the nodes value
        BinNode *left; //ptr to left
        BinNode *right; //ptr to right
};

#endif // BINNODE_H
