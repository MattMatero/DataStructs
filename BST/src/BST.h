
#ifndef BST_H
#define BST_H

#include<string>
using namespace std;
#include<iostream>
#include "BSTNode.h"


class BST
{
    public:
        BST();
        virtual ~BST();
        void clear();
        void insert(string key, int val);
        int remove(string key);
        int removeAny();
        int find(string key) const;
        int size();
        void print() const;
        void update(string key);
        string inOrder();
        void inOrderConcord();
        bool checkBST();
        void printSorted();

        string* treeSort(string arr[]);

    protected:
    private:

        BSTNode* root;
        int nodeCount;

        void clearhelp(BSTNode* rt);
        BSTNode* inserthelp(BSTNode* rt, string key, int val);
        BSTNode* deletemin(BSTNode* rt);
        BSTNode* getmin(BSTNode* rt);
        BSTNode* removehelp(BSTNode* rt, string key);
        int findhelp(BSTNode* rt, string key) const;
        void printhelp(BSTNode* rt, int level) const;
        string inOrderHelp(BSTNode* rt);
        string reverse();
        BSTNode* updateHelp(BSTNode* rt, string key);
        void inOrderConcordHelp(BSTNode* rt);
};

#endif // BST_H
