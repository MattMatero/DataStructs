#ifndef BSTNODE_H
#define BSTNODE_H

#include<string>
using namespace std;

class BSTNode
{
    public:
        BSTNode();

        BSTNode(string newKey, int newValue, BSTNode* newLeft, BSTNode* newRight);
        int getElement();
        void setElement(int newElement);
        string getKey();
        void setKey(string newKey);

        BSTNode* getLeft();
        void setLeft(BSTNode* newLeft);
        BSTNode* getRight();
        void setRight(BSTNode* newRight);

        bool isLeaf();

        virtual ~BSTNode();
    protected:
    private:
        string key;
        int element;
        BSTNode* left;
        BSTNode* right;
};

#endif // BSTNODE_H
