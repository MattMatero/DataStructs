#include "BSTNode.h"

BSTNode::BSTNode()
{
    key = "";
    element = 0;
    left = NULL;
    right = NULL;
}

BSTNode::BSTNode(string newKey, int newElement, BSTNode* newLeft, BSTNode* newRight)
{
    key = newKey;
    element = newElement;
    left = newLeft;
    right = newRight;
}

int BSTNode::getElement()
{
    return element;
}

void BSTNode::setElement(int newElement)
{
    element = newElement;
}

string BSTNode::getKey()
{
    return key;
}

void BSTNode::setKey(string newKey)
{
    key = newKey;
}

void BSTNode::setLeft(BSTNode* newLeft)
{
    left = newLeft;
}

BSTNode* BSTNode::getLeft()
{
    return left;
}

void BSTNode::setRight(BSTNode* newRight)
{
    right = newRight;
}

BSTNode* BSTNode::getRight()
{
    return right;
}

bool BSTNode::isLeaf()
{
    return (left == NULL) && (right == NULL);
}


BSTNode::~BSTNode()
{
    //dtor
}
