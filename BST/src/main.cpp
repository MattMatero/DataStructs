#include <iostream>
#include "BST.h"
using namespace std;
#include<stdio.h>

string* treeSort(string arr[]);
void concordance(string paragraph);

/*
Author: Matt Matero & David Brosnan
*/
int main()
{

    cout<<"BEGINNING OF BST***************************************************************************\n\n\n";

    BST tree = BST();

    cout<<"Empty tree:\n\n";
    tree.print();
    cout<<"\n\n\n";

    tree.insert("g",10);
    tree.insert("b", 12);
    tree.insert("y", 13);
    tree.insert("a", 14);
    tree.insert("c", 15);
    tree.insert("x", 16);
    tree.insert("z",12);
    tree.insert("d",100);

    cout<<"Expecting a tree with nodes, a,b,c,g,x,y,z\n\n";
    tree.print();


    cout<<"\n\nprint sorted from highest to lowest\n"<<endl;
    tree.printSorted();
    cout<<"Expected: z x y g c b a "<<endl;

    cout<<"\n\n\nsize method"<<endl;
    cout<<tree.size()<<endl;
    cout<<"Expected: 8"<<endl;

    cout<<"\n\n";

    cout<<"find method on g"<<endl;
    cout<<tree.find("g")<<endl;
    cout<<"Expected: 10"<<endl;

    cout<<"\n\n";

    cout<<"Removing a leaf! Expecting a to be missing from the tree"<<endl;
    tree.remove("a");//removing a leaf
    tree.print();

    cout<<"Removing a root with remove! Expecting x to be the new root!"<<endl;
    tree.remove("g");//removing g root
    tree.print();

    cout<<"Removing the root with removeAny! Expecting y to be the new root!"<<endl;
    tree.removeAny();//remove the new root
    tree.print();

    cout<<"Removing a key which doesnt exist with remove! Expecting no changes!"<<endl;
    tree.remove("jdks");//removing g root
    tree.print();

    cout<<"Inserting a node with a key already on the tree\n"<<endl;
    cout<<"d before inserting " <<tree.find("d")<<endl;
    tree.insert("d",543);
    cout<<"d after inserting: "<<tree.find("d")<<endl;
    cout<<"Expected: 543\n"<<endl;

    cout<<"Clearing out the tree with clear!\n"<<endl;
    tree.clear();
    tree.print();
    cout<<"Expected: BST is empty!\n\n";


    cout<<"END OF BST************************************************************************************************";

    cout<<"\n\n\n\nBEGINNING OF TREE SORT******************************************************************************\n\n\n";

    BST tree2 = BST();

   string arr2[5] = {"Beatrice", "Carrie", "Alice", "Snark", "Siggy"};

    cout<<"Before Tree sort: \n"<<endl;

    for(int i = 0; i < sizeof(arr2)/sizeof(arr2[0]); i++)
    {
        cout<<arr2[i]<<" ";
    }

    string* strptr;
    strptr = treeSort(arr2);

    cout<<endl;
    cout<<endl;

    cout<<"After Tree sort: \n"<<endl;

    for(int i = 0; i < sizeof(arr2)/sizeof(arr2[0]); i++){
        cout<<arr2[i]<< " ";
    }
    cout << endl;
    cout << endl;

    cout<<"END OF TREE SORT**********************************************\n\n\n\n";

    string h = "Dr. Siegfried\'s traditional project for this course: a \"concordance\" program that takes in a bunch of text, breaks it into words, and produces an alphabetized list of words, with the number of times each word appears in the text. A \"word\" is defined, for purposes of this problem, as a sequence of one or more letters: you can throw away spaces, punctuation, numbers, newlines, etc.";
    concordance(h);


    return 0;
}

string* treeSort(string arr[])
{
    BST tree = BST();

    int size = sizeof(arr);
    for(int i = 0; i <= size; i++)
    {
        tree.insert(arr[i], i);
    }

    string s = tree.inOrder();

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

void concordance(string paragraph)
{
    cout<<"BEGINNING OF CONCORDANCE TEST**************************************************************\n"<<endl;

    BST tree = BST();

    int start = 0;
    int last = 0;
    //a (97) - z (122)
    //A (65) - Z (90)


   while(last != paragraph.size() - 1)
   {


    while(!((paragraph.at(start) >= 97 && paragraph.at(start) <= 122) || (paragraph.at(start) >= 65 && paragraph.at(start) <= 90)))
        start++;

        last = start;

    while((paragraph.at(last) >= 97 && paragraph.at(last) <= 122) || (paragraph.at(last) >= 65 && paragraph.at(last) <= 90)  && last != paragraph.size() - 1)
    {
        last++;
    }


    tree.update(paragraph.substr(start, last - start));

    start = last;

}

    tree.inOrderConcord();

cout<<"END OF CONCORDANCE TEST**************************************************************";


}


