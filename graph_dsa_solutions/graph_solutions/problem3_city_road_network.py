"""
Problem 3: City Road Network
==============================
Intersections are vertices; roads are weighted directed/undirected edges.
Tasks:
  a) Choose & justify graph representation
  b) Find all intersections reachable from A (DFS/BFS)
  c) BFS — path with fewest turns from A to E
  d) Explain why DFS may not give shortest distance path
"""

from collections import defaultdict, deque


class CityRoadNetwork:
    """
    Representation choice: Directed Weighted Adjacency List
    -------------------------------------------------------
    - Directed  : roads can be one-way (A→B ≠ B→A)
    - Weighted  : road lengths differ (distances in km)
    - Adj. List : city graphs are sparse — far fewer roads than V² possible
                  connections. O(V+E) space vs O(V²) for matrix.
    - Edge format: graph[u] = [(v, weight), ...]
    """

    def __init__(self):
        self.graph = defaultdict(list)
        self.intersections = set()

    def add_intersection(self, name):
        self.intersections.add(name)

    def add_road(self, u, v, distance, bidirectional=False):
        """Add a road (edge). Set bidirectional=True for two-way roads."""
        self.add_intersection(u)
        self.add_intersection(v)
        self.graph[u].append((v, distance))
        if bidirectional:
            self.graph[v].append((u, distance))

    # ------------------------------------------------------------------ #
    # Task b: Find all reachable intersections from a source (DFS)        #
    # ------------------------------------------------------------------ #
    def find_reachable(self, source):
        """
        DFS — marks every node reachable from `source` via directed edges.

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        if source not in self.intersections:
            return set()

        visited = set()
        stack = [source]

        while stack:
            node = stack.pop()
            if node not in visited:
                visited.add(node)
                for neighbor, _ in self.graph[node]:
                    if neighbor not in visited:
                        stack.append(neighbor)

        visited.discard(source)   # source itself is not "reached FROM source"
        return visited

    # ------------------------------------------------------------------ #
    # Task c: BFS — fewest-turns (fewest hops) path                       #
    # ------------------------------------------------------------------ #
    def bfs_fewest_turns(self, start, end):
        """
        BFS on an unweighted view of the directed graph (ignore distances).
        Finds the path that uses the minimum number of road segments (turns).

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        if start not in self.intersections or end not in self.intersections:
            return None, []

        visited = {start}
        queue = deque([(start, [start])])

        while queue:
            node, path = queue.popleft()
            for neighbor, _ in self.graph[node]:
                if neighbor == end:
                    return len(path), path + [neighbor]   # hops = len(path)
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, path + [neighbor]))

        return None, []   # no path

    # ------------------------------------------------------------------ #
    # Task d: Why DFS ≠ shortest distance                                 #
    # ------------------------------------------------------------------ #
    @staticmethod
    def explain_dfs_limitation():
        explanation = """
Why DFS does NOT guarantee the shortest DISTANCE path
------------------------------------------------------
DFS explores one branch as deep as possible before backtracking.

In a weighted graph it may reach the destination quickly via a long,
high-cost route (e.g. A→B→E with total 13 km) and return that as the
answer — completely ignoring a shorter route discovered later
(e.g. A→D→E with total 9 km).

Even in an unweighted graph DFS only guarantees A path exists,
not the SHORTEST one. BFS guarantees fewest hops because it
explores all nodes at distance k before any node at distance k+1.

For shortest WEIGHTED distance, use Dijkstra's algorithm (greedy +
priority queue) or Bellman-Ford (handles negative weights).
        """
        print(explanation)

    def display_network(self):
        print("\n=== City Road Network (Directed Weighted Adjacency List) ===")
        for node in sorted(self.intersections):
            edges = [(v, w) for v, w in self.graph[node]]
            print(f"  {node}: {edges}")


# ------------------------------------------------------------------ #
# Driver / Demo                                                        #
# ------------------------------------------------------------------ #
def main():
    city = CityRoadNetwork()

    roads = [
        ("A", "B", 5, False),   # one-way
        ("B", "C", 3, True),    # two-way
        ("A", "D", 7, True),    # two-way
        ("D", "E", 2, False),   # one-way
        ("C", "E", 4, False),   # one-way
    ]

    for u, v, dist, bidir in roads:
        city.add_road(u, v, dist, bidir)

    city.display_network()

    # Task b
    print("\n--- Task b: All intersections reachable from A ---")
    reachable = city.find_reachable("A")
    print(f"  Reachable from A: {sorted(reachable)}")

    # Task c
    print("\n--- Task c: BFS — fewest turns from A to E ---")
    hops, path = city.bfs_fewest_turns("A", "E")
    if path:
        print(f"  Fewest-turn path: {' → '.join(path)}  ({hops} road segment(s))")
    else:
        print("  No path found from A to E.")

    # Task d
    print("\n--- Task d: Why DFS may not find shortest distance ---")
    city.explain_dfs_limitation()


if __name__ == "__main__":
    main()
