#include "BST.h"

BST::BST()
{
    root = NULL;
    nodeCount = 0;
}

BST::~BST()
{
    //dtor
}

void BST::clear()
{
    clearhelp(root);
    root = NULL;
    nodeCount = 0;
}

void BST::insert(string k, int val)
{
        if(find(k) != -1)
        {
            //cout<<k<<" is already in the tree!\n";
            //return;
            remove(k);
        }
        root = inserthelp(root, k, val);
        nodeCount++;

}

BSTNode* BST::inserthelp(BSTNode* rt, string k, int val)
{
    if (rt == NULL) // Empty tree: create node
        return new BSTNode(k, val, NULL, NULL);
    if (k < rt->getKey())
        rt->setLeft(inserthelp(rt->getLeft(), k, val));
     else if (k > rt->getKey())
        rt->setRight(inserthelp(rt->getRight(), k, val));
    else
        rt->setElement(val);
    return rt; // Return tree with node inserted
}

/*
BSTNode* BST::inserthelp(BSTNode* rt, string k, int val)
{
    if (rt == NULL) // Empty tree: create node
        return new BSTNode(k, val, NULL, NULL);
    if (k < rt->getKey())
        rt->setLeft(inserthelp(rt->getLeft(), k, val));
    else
        rt->setRight(inserthelp(rt->getRight(), k, val));
    return rt; // Return tree with node inserted
}
*/

int BST::remove(string k)
{
    int temp = findhelp(root, k); // First find it
    if (temp != NULL)
    {
        root = removehelp(root, k);
        nodeCount--;
    }
    return temp;
}

int BST::removeAny()
{
    if (root != NULL)
    {
        int temp = root->getElement();
        root = removehelp(root, root->getKey());
        nodeCount--;
        return temp;
    }

    else
        return NULL;
}

int BST::find(string k) const
{
    if(root == NULL)
        return -1;
    return findhelp(root, k);
}

int BST::size()
{
    return nodeCount;
}

void BST::print() const
{
    if (root == NULL)
        cout<<"The BST is empty.\n";

    else
        printhelp(root, 0);
}

void BST::printhelp(BSTNode* rt, int level) const
{
    if (rt == NULL) return; // Empty tree

    printhelp(rt->getRight(), level+1); // Do left subtree
    for (int i=0; i<level; i++) // Indent to level
    cout << " ";
    cout << rt->getKey() << "\n"; // Print node value
    printhelp(rt->getLeft(), level+1); // Do right subtree
}

void BST::clearhelp(BSTNode* rt)
{
    if (rt == NULL)
        return;

    clearhelp(rt->getLeft());
    clearhelp(rt->getRight());
    delete rt;
}



BSTNode* BST::deletemin(BSTNode* rt)
{
    if (rt->getLeft() == NULL) // Found min
        return rt->getRight();
    else
    { // Continue left
        rt->setLeft(deletemin(rt->getLeft()));
        return rt;
    }
}

BSTNode* BST::getmin(BSTNode* rt)
{
    if (rt->getLeft() == NULL)
        return rt;
    else
        return getmin(rt->getLeft());
}

BSTNode* BST::removehelp(BSTNode* rt, string k)
{
    if (rt == NULL)
        return NULL; // k is not in tree

    else if (k < rt->getKey())
        rt->setLeft(removehelp(rt->getLeft(), k));

    else if (k > rt->getKey())
        rt->setRight(removehelp(rt->getRight(), k));

    else
    { // Found: remove it
        BSTNode* temp = rt;

        if (rt->getLeft() == NULL)
        { // Only a right child
            rt = rt->getRight(); // so point to right
            delete temp;
        }

        else if (rt->getRight() == NULL)
        { // Only a left child
            rt = rt->getLeft(); // so point to left
            delete temp;
        }

        else
        { // Both children are non-empty
            BSTNode* temp = getmin(rt->getRight());
            rt->setElement(temp->getElement());
            rt->setKey(temp->getKey());
            rt->setRight(deletemin(rt->getRight()));
            delete temp;
        }
    }
return rt;
}

int BST::findhelp(BSTNode* rt, string k) const
{

    if (rt == NULL)
        return -1; // Empty tree

           // cout << "help me" << " I'm inside " << rt->getKey()<< endl;

    if (k < rt->getKey())
        return findhelp(rt->getLeft(), k); // Check left
    else if (k > rt->getKey())
        return findhelp(rt->getRight(), k); // Check right
    else{
                return rt->getElement(); // Found it
    }
}

string BST::inOrderHelp(BSTNode* rt)
{
    string daTree;
    if( rt == NULL ) return "";
    daTree+=inOrderHelp( rt ->getLeft() );
    daTree += " ";
    daTree += rt->getKey();
    daTree +=" ";
    daTree +=inOrderHelp( rt->getRight() );

    return daTree;
}

string BST::inOrder(){
    if(root == NULL)
        return "Empty tree!";
    else
    return inOrderHelp(this -> root);
}

void BST::inOrderConcord()
{
    if(root == NULL)
        return;
    else
    return inOrderConcordHelp(this -> root);
}

void BST::inOrderConcordHelp(BSTNode* rt){
    if( rt == NULL ) return;
    inOrderConcordHelp( rt ->getLeft() );
    cout << rt -> getElement() << " " << rt -> getKey()<<endl;
    inOrderConcordHelp( rt -> getRight() );
}

bool BST::checkBST()
{
    string str = inOrder();
    for(int i = 0; i < str.size() - 1; i++)
        if(str.at(i) > str.at(i + 1))
           return false;
    return true;
}

void BST::printSorted()
{
    cout<<reverse() << endl;
}

string BST::reverse( ){
    string tree = inOrder();
    string rev= "";
    for(int i = tree.size()-1; i >= 0 ; i--){
        rev += tree.at(i);
    }
    return rev;
}

string* BST::treeSort(string arr[])
{
    int size = sizeof(arr);
    for(int i = 0; i <= size; i++)
    {
        insert(arr[i], i);
    }

    string s = inOrder();

    int space;
    int space2;


    for(int i = 0; i <= size; i++)
    {
        space = s.find(" ");
        space2 = s.find(" ", space + 1);
        arr[i] = s.substr(space + 1 , space2 - 1);
        s = s.substr(space2+1,s.size());
    }
    string *arrptr = &arr[0];
    return arrptr;
}

void BST::update(string k) //Meant for use in the concordance program
{
        root = updateHelp(root, k);
        nodeCount++;
}

BSTNode* BST::updateHelp(BSTNode* rt, string k)
{
    if (rt == NULL) // Empty tree: create node
        return new BSTNode(k, 1, NULL, NULL);
    if (k < rt->getKey())
        rt->setLeft(updateHelp(rt->getLeft(), k));
    else if(k > rt->getKey())
        rt->setRight(updateHelp(rt->getRight(), k));
    else{
        rt->setElement(rt -> getElement() + 1);
        }

    return rt; // Return tree with node inserted
}



