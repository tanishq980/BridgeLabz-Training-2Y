"""
Problem 4: Island Counter
==========================
2D grid: 1 = land, 0 = water.
An island is a group of horizontally/vertically connected 1-cells.
Tasks:
  a) Model as graph
  b) Count islands using DFS
  c) Count islands using BFS
  d) Time & space complexity analysis
  e) Diagonal connections — how does it change the solution?
"""

from collections import deque
import copy


# ------------------------------------------------------------------ #
# Task a: Graph Model                                                 #
# ------------------------------------------------------------------ #
def explain_graph_model():
    print("""
Graph Model for Island Problem
--------------------------------
  Vertices : Each cell (row, col) with value 1 is a vertex.
  Edges    : Two land-cells share an undirected edge if they are
             horizontally or vertically adjacent (4-directional).
  Goal     : Count the number of connected components in this graph.

  We don't build the graph explicitly — we traverse it in-place,
  using the grid itself as the adjacency structure.
""")


DIRECTIONS_4 = [(-1, 0), (1, 0), (0, -1), (0, 1)]          # up/down/left/right
DIRECTIONS_8 = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]   # + diagonals


def in_bounds(grid, r, c):
    return 0 <= r < len(grid) and 0 <= c < len(grid[0])


# ------------------------------------------------------------------ #
# Task b: Count Islands — DFS                                         #
# ------------------------------------------------------------------ #
def count_islands_dfs(grid, allow_diagonal=False):
    """
    DFS approach:
      - Scan every cell.
      - When an unvisited land-cell (1) is found, increment counter
        and DFS to mark its entire island as visited (set to 0).

    Time Complexity : O(R × C)  — each cell visited at most once
    Space Complexity: O(R × C)  — recursion stack in worst case (all land)
    """
    if not grid:
        return 0

    grid = copy.deepcopy(grid)   # don't mutate original
    directions = DIRECTIONS_8 if allow_diagonal else DIRECTIONS_4
    rows, cols = len(grid), len(grid[0])
    island_count = 0

    def dfs(r, c):
        # Mark cell as visited by sinking it
        grid[r][c] = 0
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if in_bounds(grid, nr, nc) and grid[nr][nc] == 1:
                dfs(nr, nc)

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1:
                island_count += 1
                dfs(r, c)

    return island_count


# ------------------------------------------------------------------ #
# Task c: Count Islands — BFS                                         #
# ------------------------------------------------------------------ #
def count_islands_bfs(grid, allow_diagonal=False):
    """
    BFS approach:
      - Same scan strategy but uses a queue instead of recursion.
      - Avoids recursion-stack overflow on very large grids.

    Time Complexity : O(R × C)
    Space Complexity: O(min(R, C))  — BFS queue at most holds the
                      perimeter of the current island (diagonal of grid)
    """
    if not grid:
        return 0

    grid = copy.deepcopy(grid)
    directions = DIRECTIONS_8 if allow_diagonal else DIRECTIONS_4
    rows, cols = len(grid), len(grid[0])
    island_count = 0

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1:
                island_count += 1
                queue = deque([(r, c)])
                grid[r][c] = 0   # mark visited immediately on enqueue

                while queue:
                    cr, cc = queue.popleft()
                    for dr, dc in directions:
                        nr, nc = cr + dr, cc + dc
                        if in_bounds(grid, nr, nc) and grid[nr][nc] == 1:
                            grid[nr][nc] = 0
                            queue.append((nr, nc))

    return island_count


# ------------------------------------------------------------------ #
# Task e: Diagonal connections explanation                            #
# ------------------------------------------------------------------ #
def explain_diagonal():
    print("""
Diagonal Connections (8-directional)
--------------------------------------
If diagonals count, two land-cells that touch only at a corner are
part of the same island. This increases connectivity:

  Example:
    1 0          4-dir → 2 islands
    0 1          8-dir → 1 island  (diagonal connection merges them)

Code change: swap DIRECTIONS_4 for DIRECTIONS_8 — nothing else changes.
The allow_diagonal=True parameter in both functions demonstrates this.
Time and space complexity stay the same: O(R × C).
""")


def print_grid(grid):
    for row in grid:
        print("  " + " ".join(str(c) for c in row))


# ------------------------------------------------------------------ #
# Driver / Demo                                                        #
# ------------------------------------------------------------------ #
def main():
    grid = [
        [1, 1, 0, 0, 0],
        [1, 1, 0, 0, 1],
        [0, 0, 1, 0, 1],
        [0, 0, 0, 1, 1],
    ]

    print("=== Island Counter ===")
    print("\nGrid:")
    print_grid(grid)

    # Task a
    explain_graph_model()

    # Task b
    count_dfs = count_islands_dfs(grid)
    print(f"Task b — DFS Island Count : {count_dfs}")

    # Task c
    count_bfs = count_islands_bfs(grid)
    print(f"Task c — BFS Island Count : {count_bfs}")

    # Task d
    print("""
Task d — Complexity Analysis
------------------------------
  DFS:
    Time  : O(R × C) — every cell checked once; land cells also DFS-sunk.
    Space : O(R × C) — call stack can be as deep as the number of land cells
            (worst case: entire grid is land, single island, full recursion depth).

  BFS:
    Time  : O(R × C) — identical; each cell processed once.
    Space : O(min(R, C)) in practice (BFS queue width ≤ grid diagonal).
            Worst-case still O(R × C) if all cells are land.

  Both algorithms are equivalent in time; BFS is safer for very large
  grids because it avoids Python's recursion limit.
""")

    # Task e
    explain_diagonal()

    # Demonstrate diagonal difference
    diag_grid = [
        [1, 0],
        [0, 1],
    ]
    print("Diagonal demo grid:")
    print_grid(diag_grid)
    print(f"  4-directional → {count_islands_dfs(diag_grid, allow_diagonal=False)} island(s)")
    print(f"  8-directional → {count_islands_dfs(diag_grid, allow_diagonal=True)} island(s)")


if __name__ == "__main__":
    main()
