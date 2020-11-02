# Data-Structures

![](https://i.pinimg.com/originals/e0/dd/3b/e0dd3bf212283a91a392972aa59caf9c.jpg)

Data structures are a variety of containers and organized data storage systems. Data structures are data organization, management, and storage formats with different usages and efficiencies. 

*A data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data.*

Different data structures are well suited for serving different functions.

## Arrays

Arrays are the most famous and widely used data type.

### Basic functions

 - Insert at a specific index
 - Get from a specific index
 - Delete from a specific index
 - Find length

### Advantages of arrays

- Arrays can store multiple data points of any type
- The ability to access information from any point in the array

### Disadvantages of arrays

- Inserting and deleting can be costly operations, as they require reindexing the other elements in the array.

## Stacks
Stacks, like arrays, are also a collection of similar data. In a stack though, data is only added or removed only from the top of the stack. A Stack is a Last In First Out (LIFO) data structure. 

![](https://cdn-media-1.freecodecamp.org/images/BP-lD2OxkMbIQI2iZD-jxgIPlANlsMTqwnLP)

### Basic functions

- Push - Enter data at the top of the stack
- Pop - Remove data from the top of the stack
- Check if the stack is empty
- Peek - Access the data at the top of the stack without removing it

### Advantages of stacks

- Stacks can store multiple data points of any type
- All stack operations take O(1) time complexity

### Disadvantages of stacks

- Can only access data from the top of the stack

### Uses of stacks

- Stacks are used for function calls
- Stacks are used for undo functions

[Stack implementation in java](https://www.geeksforgeeks.org/stack-class-in-java/)

## Queues
Queues are a similar structure to stacks, only with a First In First Out (FIFO) structure

![](https://cdn-media-1.freecodecamp.org/images/C2riLJTPBVpSI-3o5Cx9IrQ16LZi1kLrqYXo)

### Basic functions

- Enqueue — Inserts an element to the back of the queue
- Dequeue — Removes an element from the front of the queue
- Check if the queue is empty
- Peek - Access the data at the front of the queue without removing it

### Advantages of queues

- Stacks can store multiple data points of any type

### Disadvantages of queues

- Can only access data from the front of the queue

### Uses of queues

- Many types of waiting room scenarios
- A shared resource like an office printer

[Queue implementation in java](https://www.geeksforgeeks.org/queue-interface-java/)

## Linked Lists
Linked lists are a linear data structure.  The function similarly to an array, though each element in a linked list exists separately, with pointed from one to the next.  The elements in a linked list are called nodes.

Each nodes contains 2 things: the data stored in the node, and the pointer to the next node.  The head is the first node, and the last node point to null

![](https://res.cloudinary.com/dvj2hbywq/image/upload/v1590572188/Group_14_5_bvpwu0.png)

There are three types of linked list

 - Singly linked list - The linked list described above, where each node points to the next, from head to null
 - Doubly linked list - A linked list where each node has a pointer to both the next and previous node
 - Circular linked list - A linked list where the last node points back to the head

A linked list might look like this:

```
const list = {
    head: {
        value: 6
        next: {
            value: 10                                             
            next: {
                value: 12
                next: {
                    value: 3
                    next: null	
                    }
                }
            }
        }
    }
};
```

### Basic functions

- Insert - Insert a node into the list
- Delete - Delete a node from the list
- Search - Find a node in the list, either by index or value

### Advantages of linked lists

- Nodes can be added or removed from a linked list with a time complexity of O(1)

### Disadvantages of linked lists

- It uses more memory than an array due to storage of the pointer
- Searching through a linked list is slow, can only traverse through the list and not access from anywhere

### Uses of linked lists

- We can use linked list to create stacks and queues
- Dynamic memory allocation
- Performing arithmetic operations on long integers

[Linked List implementation in java](https://www.geeksforgeeks.org/linked-list-in-java/)

## Graphs
Graphs are non-linear systems of data points connected to each other. The data exists as a series of nodes, or vertices, connected to each other by edges.

![](https://www.geeksforgeeks.org/wp-content/uploads/undirectedgraph.png)

Graphs are often defined by the set of vertices and edges that they are comprised of.  In the example above, we would have a vertex list of:

`V = [0,1,2,3,4]`

and an edge list, or adjacency list, of 

`E = [[0,1], [1,2], [2,3], [3,4], [0,4], [1,4], [1,3]]`

You might also see them together, like this:

	{
	0:[1,4]
	1:[0,2,3,4],
	2:[1,3],
	3:[1,2,4],
	4:[0,1,3],
	}

### Basic functions

- Addition/Removal of a vertex
- Addition/Removal of an edge
- Access vertex

### Advantages of graphs

- Make it easy to understand complex networks
- Graphs can be used to find ideal paths between data
- Graphs can be used to understand relationships between data

### Disadvantages of graphs

- Can be time and space intensive to traverse and map graphs

### Uses of graphs

- Used to represent networks like phone systems
- Used to visualize connected on social media sites

## Trees
Trees are a data structure where data is organized and linked hierarchically. The nodes, or leaves, in a tree can be linked to more than 1 other node.  There are many types of trees, one of the most common is the binary search tree.

![](https://www.gatevidyalay.com/wp-content/uploads/2018/07/Binary-Search-Tree-Example.png)

In a binary search tree, the child node to the left of any node is less than the parent, and the node to the right is greater.

Each node in a tree has at least 3 properties:

- The value stored in the node
- The pointer to its left child node
- The pointer to its right child node

### Basic functions

- Insert - Insert a node into the tree
- Delete - Delete a node from the tree
- Search - Find a node in the tree

### Advantages of trees

- The time complexity for any of the basic operations in a balanced tree is O(log(n))

### Disadvantages of trees

- Trees can become unbalanced and lose their efficiency in searches
- In many types of trees, each node needs to be unique

### Uses of trees

- Used in many search applications where data is constantly entering and leaving.

## Hash Tables
Hash tables are data structures where key-value pairs are stored in an array. The key is converted by a hash function into the index of the array, between 0 and the size of the array.

![](https://www.tutorialspoint.com/data_structures_algorithms/images/hash_function.jpg)

Maybe we're storing data using numerical values as a key, and we decide that our hash function will be:

`index = key%20`

A key of 33 gives us an index of 13, a key of 45 gives an index of 5, and so on.
What problem will eventually arise?

### Collisions
Collisions occur when our has function produces the same index from 2 or more different keys. Collisions are unavoidable when hash tables reach larger sizes.  We have a few ways of dealing with them.

#### Linear probing
Using linear probing to deal with collisions means that in the case of a collision, we assign the next available index value to the key that caused the collision. With linear probing, we can only have hash tables of a certain size

#### Chaining
With chaining, each value in the hash table is an array.  In the case of collisions, the colliding value is added to array at the index its key produces.  This allows hash tables to grow past the number of indices in the table.

### Basic functions

- Insert - Insert a value into the table
- Delete - Delete a value from the table
- Search - Find a value in the table

### Advantages of hash tables

- Hash tables are extremely fast for accessing and storing data

### Disadvantages of hash tables

- Hash collisions will occur, requiring chaining, linear probing and/or resizing
- Can not have a null key

### Uses of hash tables

- Used to implement database indexes
- Used to implement associative arrays.

[Hash table implementation in java](https://www.geeksforgeeks.org/hashtable-in-java/)

