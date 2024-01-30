<div align="center">
  <img src="https://img.shields.io/badge/language-Java-red.svg">
  <img src="https://custom-icon-badges.demolab.com/github/license/denvercoder1/custom-icon-badges?logo=law">
</div>

# Project Name

## Overview
This Java program implements a Red-Black Tree, a self-balancing binary search tree known for efficient search, insert, and delete operations.

## Table of Contents
- [Wikipedia Reference](#wikipedia-reference)
- [Project Properties](#project-properties)
- [Program Structure](#program-structure)
   - [Constructors](#constructors)
   - [Public Methods](#public-methods)
   - [Private Methods](#private-methods)
   - [Utility Methods](#utility-methods)
- [Test Class (Main)](#main-class-main)
   - [Main Method](#main-method)
- [License](#license)


### Wikipedia Reference
- [Red-Black Tree](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)

### Project Properties
- Language: Java
- Dependencies: None

## Program Structure
### Constructors
- `RedBlackTree()`: Initializes an empty Red-Black Tree.

### Public Methods
- `insert(int key)`: Inserts a key.
- `search(int key)`: Searches for a key.
- `delete(int key)`: Deletes a key.

### Private Methods
- `leftRotate(Node x)`: Left rotation around a node.
- `rightRotate(Node y)`: Right rotation around a node.
- `insertFixup(Node z)`: Fixes tree properties after insertion.
- `deleteFixup(Node x)`: Fixes tree properties after deletion.
- `transplant(Node u, Node v)`: Replaces subtree rooted at u with subtree rooted at v.
- `minimum(Node x)`: Finds node with minimum key in subtree rooted at x.

### Utility Methods
- `isValidRedBlackTree(RedBlackTree tree)`: Checks if the Red-Black Tree is valid.
- `inOrderTraversal(RedBlackTree tree, Node root)`: In-order traversal.
- `calculateHeight(RedBlackTree tree, Node root)`: Calculates tree height.

## Main Class (Main)
### Main Method
- `main(String[] args)`: Provides a command-line interface for tree interaction.


## License
This program is released under the [MIT License]( https://github.com/yehonatanke/Red_Black_Tree/blob/main/LICENSE).

## Author

yehonataKe
