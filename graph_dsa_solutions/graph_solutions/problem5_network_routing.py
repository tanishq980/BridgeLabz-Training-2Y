"""
Problem 5: Network Packet Routing
===================================
Routers are vertices; connections are undirected unweighted edges.
Tasks:
  a) Represent using both adjacency matrix AND adjacency list
  b) Calculate space complexity for both
  c) Check if network is fully connected
  d) Find alternative paths if R4-R5 fails
  e) BFS — minimum hops from R1 to R6
"""

from collections import deque, defaultdict


# ================================================================== #
# Task a & b: Both representations                                    #
# ================================================================== #

class AdjacencyMatrixGraph:
    """
    Undirected graph stored as a 2D boolean matrix.
    Space Complexity: O(V²)  — allocates V×V regardless of edges.
    """

    def __init__(self, vertices):
        self.vertices = vertices
        self.index = {v: i for i, v in enumerate(vertices)}
        n = len(vertices)
        self.matrix = [[0] * n for _ in range(n)]

    def add_edge(self, u, v):
        i, j = self.index[u], self.index[v]
        self.matrix[i][j] = 1
        self.matrix[j][i] = 1   # undirected

    def remove_edge(self, u, v):
        i, j = self.index[u], self.index[v]
        self.matrix[i][j] = 0
        self.matrix[j][i] = 0

    def has_edge(self, u, v):
        i, j = self.index[u], self.index[v]
        return self.matrix[i][j] == 1

    def neighbors(self, u):
        i = self.index[u]
        return [self.vertices[j] for j in range(len(self.vertices)) if self.matrix[i][j] == 1]

    def display(self):
        print("\n=== Adjacency Matrix ===")
        header = "     " + "  ".join(f"{v:>3}" for v in self.vertices)
        print(header)
        for v in self.vertices:
            row = self.matrix[self.index[v]]
            print(f"  {v:>3}  " + "  ".join(f"{x:>3}" for x in row))
        v = len(self.vertices)
        print(f"\n  Space Complexity: O(V²) = O({v}²) = {v*v} cells")


class AdjacencyListGraph:
    """
    Undirected graph stored as a dictionary of sets.
    Space Complexity: O(V + E)
    """

    def __init__(self):
        self.graph = defaultdict(set)
        self.vertices = set()

    def add_vertex(self, v):
        self.vertices.add(v)

    def add_edge(self, u, v):
        self.vertices.update([u, v])
        self.graph[u].add(v)
        self.graph[v].add(u)

    def remove_edge(self, u, v):
        self.graph[u].discard(v)
        self.graph[v].discard(u)

    def has_edge(self, u, v):
        return v in self.graph[u]

    def neighbors(self, u):
        return list(self.graph[u])

    def display(self):
        print("\n=== Adjacency List ===")
        for v in sorted(self.vertices):
            print(f"  {v}: {sorted(self.graph[v])}")
        v = len(self.vertices)
        e = sum(len(nb) for nb in self.graph.values()) // 2
        print(f"\n  Space Complexity: O(V + E) = O({v} + {e}) = O({v+e}) entries")


# ================================================================== #
# Shared algorithms (work on AdjacencyListGraph)                     #
# ================================================================== #

# ------------------------------------------------------------------ #
# Task c: Is the network fully connected? (BFS from any node)        #
# ------------------------------------------------------------------ #
def is_fully_connected(graph: AdjacencyListGraph):
    """
    BFS from an arbitrary vertex. If all vertices are reached →
    the graph is connected.

    Time Complexity : O(V + E)
    Space Complexity: O(V)
    """
    if not graph.vertices:
        return True

    start = next(iter(graph.vertices))
    visited = {start}
    queue = deque([start])

    while queue:
        node = queue.popleft()
        for nb in graph.graph[node]:
            if nb not in visited:
                visited.add(nb)
                queue.append(nb)

    return visited == graph.vertices


# ------------------------------------------------------------------ #
# Task d: Alternative paths after edge failure                        #
# ------------------------------------------------------------------ #
def find_all_paths(graph: AdjacencyListGraph, start, end,
                   failed_edge=None, max_paths=10):
    """
    DFS-based enumeration of all simple (no repeated vertex) paths
    from start to end, ignoring a specific failed edge if provided.

    failed_edge: tuple (u, v) — edge to exclude.

    Time Complexity : O(V! ) worst case (all permutations), but in
                      practice limited by graph structure.
    Returns: list of paths (each path is a list of vertices)
    """
    all_paths = []

    def dfs(current, path, visited):
        if len(all_paths) >= max_paths:
            return
        if current == end:
            all_paths.append(list(path))
            return
        for nb in sorted(graph.graph[current]):
            if nb in visited:
                continue
            # Skip the failed edge
            if failed_edge and (
                (current == failed_edge[0] and nb == failed_edge[1]) or
                (current == failed_edge[1] and nb == failed_edge[0])
            ):
                continue
            visited.add(nb)
            path.append(nb)
            dfs(nb, path, visited)
            path.pop()
            visited.remove(nb)

    dfs(start, [start], {start})
    return all_paths


# ------------------------------------------------------------------ #
# Task e: Minimum hops using BFS                                      #
# ------------------------------------------------------------------ #
def bfs_min_hops(graph: AdjacencyListGraph, start, end,
                 failed_edge=None):
    """
    BFS finds the shortest path in hop count (unweighted graph).
    Optionally excludes a failed edge.

    Time Complexity : O(V + E)
    Space Complexity: O(V)
    """
    if start not in graph.vertices or end not in graph.vertices:
        return -1, []

    visited = {start}
    queue = deque([(start, [start])])

    while queue:
        node, path = queue.popleft()
        for nb in graph.graph[node]:
            # Skip failed edge
            if failed_edge and (
                (node == failed_edge[0] and nb == failed_edge[1]) or
                (node == failed_edge[1] and nb == failed_edge[0])
            ):
                continue
            if nb == end:
                return len(path), path + [nb]
            if nb not in visited:
                visited.add(nb)
                queue.append((nb, path + [nb]))

    return -1, []


# ================================================================== #
# Driver / Demo                                                        #
# ================================================================== #
def main():
    routers = ["R1", "R2", "R3", "R4", "R5", "R6"]
    connections = [
        ("R1", "R2"), ("R1", "R3"),
        ("R2", "R4"), ("R3", "R4"),
        ("R4", "R5"), ("R5", "R6"),
    ]

    # --- Build adjacency matrix ---
    mat_graph = AdjacencyMatrixGraph(routers)
    for u, v in connections:
        mat_graph.add_edge(u, v)
    mat_graph.display()

    # --- Build adjacency list ---
    list_graph = AdjacencyListGraph()
    for u, v in connections:
        list_graph.add_edge(u, v)
    list_graph.display()

    # Task c
    print("\n--- Task c: Is network fully connected? ---")
    connected = is_fully_connected(list_graph)
    print(f"  All routers can reach each other: {connected}")

    # Task d — simulate R4-R5 link failure
    print("\n--- Task d: Alternative paths from R1 to R6 (R4-R5 failed) ---")
    failed = ("R4", "R5")
    alt_paths = find_all_paths(list_graph, "R1", "R6", failed_edge=failed)
    if alt_paths:
        for i, p in enumerate(alt_paths, 1):
            print(f"  Path {i}: {' → '.join(p)}")
    else:
        print("  No alternative path exists! Network is partitioned.")

    # Task e
    print("\n--- Task e: Minimum hops from R1 to R6 (normal network) ---")
    hops, path = bfs_min_hops(list_graph, "R1", "R6")
    if hops >= 0:
        print(f"  Minimum hops: {hops}  |  Path: {' → '.join(path)}")
    else:
        print("  R6 is unreachable from R1.")

    print("\n--- Task e (extra): Min hops with R4-R5 failed ---")
    hops2, path2 = bfs_min_hops(list_graph, "R1", "R6", failed_edge=failed)
    if hops2 >= 0:
        print(f"  Minimum hops: {hops2}  |  Path: {' → '.join(path2)}")
    else:
        print("  R6 is unreachable from R1 with the failed link.")


if __name__ == "__main__":
    main()
