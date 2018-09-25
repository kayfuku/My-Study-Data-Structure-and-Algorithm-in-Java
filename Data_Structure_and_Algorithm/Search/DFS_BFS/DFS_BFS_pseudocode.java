// DFS and BFS.
// Author: Data Abstraction and Problem Solving with JAVA p.790
// Date  : February 6, 2016



+dfs(in v:Vertex)
// Traverses a graph beginning at vertex v by using a
// depth-first search: Recursive version.

   Mark v as visited
   for (each unvisited vertex u adjacent to v)
      dfs(u)

+dfs(in v:Vertex)
// Traverses a graph beginning at vertex v by using a
// depth-first search: Iterative version.

  s.createStack()

  // push v onto the stack and mark it
  s.push(v)
  Mark v as visited

  // loop invariant: there is a path from vertex v at the
  // bottom of the stack s to the vertex at the top of s
  while (!s.isEmpty()) {
    if (no unvisited vertices are adjacent to
          the vertex on the top of the stack)
      s.pop()  // backtrack
    }
    else {
      Select an unvisited vertex u adjacent to
          the vertex on the top of the stack
      s.push(u)
      Mark u as visited
    }  // end if
  }  // end while

+bfs(in v:Vertex)
// Traverses a graph beginning at vertex v by using a
// breadth-first search: Iterative version.

  q.createQueue()

  // add v to queue and mark it
  q.enqueue(v)
  Mark v as visited

  while (!q.isEmpty()) {
      w = q.dequeue()

      // loop invariant: there is a path from vertex w to
      // every vertex in the queue q
    for (each unvisited vertex u adjacent to w) {
       Mark u as visited
       q.enqueue(u)
    }  // end for
  }  // end while

