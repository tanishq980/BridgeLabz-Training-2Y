"""
Problem 2: Course Prerequisite System
=======================================
Courses are vertices; a directed edge A → B means A must be taken before B.
Tasks:
  a) Represent the prerequisite system
  b) Detect circular dependency (cycle detection)
  c) Find all courses that must be completed before CS202
  d) Generate a valid course order (topological sort)
"""

from collections import defaultdict, deque


class CoursePrerequisiteSystem:
    def __init__(self):
        # Directed adjacency list: prerequisite → [courses that need it]
        self.graph = defaultdict(list)
        # Reverse graph: course → [its direct prerequisites]
        self.reverse_graph = defaultdict(list)
        self.courses = set()

    def add_course(self, course):
        self.courses.add(course)

    def add_prerequisite(self, prereq, course):
        """Edge: prereq → course (take prereq before course)."""
        self.add_course(prereq)
        self.add_course(course)
        self.graph[prereq].append(course)
        self.reverse_graph[course].append(prereq)

    # ------------------------------------------------------------------ #
    # Task b: Cycle Detection using DFS (coloring method)                 #
    # ------------------------------------------------------------------ #
    def has_cycle(self):
        """
        DFS with 3-color marking:
          WHITE (0) = unvisited
          GRAY  (1) = currently in recursion stack
          BLACK (2) = fully processed

        A back-edge (visiting a GRAY node) indicates a cycle.

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        WHITE, GRAY, BLACK = 0, 1, 2
        color = {c: WHITE for c in self.courses}
        cycle_path = []

        def dfs(node, path):
            color[node] = GRAY
            path.append(node)
            for neighbor in self.graph[node]:
                if color[neighbor] == GRAY:
                    # Found cycle — record it
                    idx = path.index(neighbor)
                    cycle_path.extend(path[idx:] + [neighbor])
                    return True
                if color[neighbor] == WHITE:
                    if dfs(neighbor, path):
                        return True
            color[node] = BLACK
            path.pop()
            return False

        for course in self.courses:
            if color[course] == WHITE:
                if dfs(course, []):
                    return True, cycle_path
        return False, []

    # ------------------------------------------------------------------ #
    # Task c: Find all prerequisites of a given course (BFS on reverse)  #
    # ------------------------------------------------------------------ #
    def get_all_prerequisites(self, target_course):
        """
        BFS/DFS on reverse_graph to collect every course that must come
        before `target_course` (direct AND transitive prerequisites).

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        if target_course not in self.courses:
            return set()

        visited = set()
        queue = deque([target_course])

        while queue:
            course = queue.popleft()
            for prereq in self.reverse_graph[course]:
                if prereq not in visited:
                    visited.add(prereq)
                    queue.append(prereq)

        return visited  # does NOT include target_course itself

    # ------------------------------------------------------------------ #
    # Task d: Topological Sort using Kahn's Algorithm (BFS)               #
    # ------------------------------------------------------------------ #
    def topological_sort(self):
        """
        Kahn's algorithm (BFS-based):
          1. Compute in-degree for every node.
          2. Enqueue nodes with in-degree 0 (no prerequisites).
          3. Process queue: reduce neighbor in-degrees; enqueue those reaching 0.

        Returns a valid course order, or raises an error if a cycle exists.

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        in_degree = {c: 0 for c in self.courses}
        for prereq in self.graph:
            for course in self.graph[prereq]:
                in_degree[course] += 1

        queue = deque([c for c in self.courses if in_degree[c] == 0])
        order = []

        while queue:
            course = queue.popleft()
            order.append(course)
            for neighbor in self.graph[course]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)

        if len(order) != len(self.courses):
            raise ValueError("Cycle detected — topological sort is not possible.")

        return order

    def display_system(self):
        print("\n=== Course Prerequisite System (Directed Adjacency List) ===")
        for course in sorted(self.courses):
            prereqs = sorted(self.reverse_graph[course])
            successors = sorted(self.graph[course])
            print(f"  {course}  |  prereqs={prereqs}  |  unlocks={successors}")


# ------------------------------------------------------------------ #
# Driver / Demo                                                        #
# ------------------------------------------------------------------ #
def main():
    system = CoursePrerequisiteSystem()

    prerequisites = [
        ("CS101", "CS102"),
        ("CS101", "CS201"),
        ("CS102", "CS202"),
        ("MATH101", "CS201"),
    ]

    for pre, course in prerequisites:
        system.add_prerequisite(pre, course)

    system.display_system()

    # Task b
    print("\n--- Task b: Cycle Detection ---")
    has_cycle, cycle = system.has_cycle()
    if has_cycle:
        print(f"  ⚠ Circular dependency detected: {' → '.join(cycle)}")
    else:
        print("  ✓ No circular dependency found.")

    # Task c
    print("\n--- Task c: Prerequisites for CS202 ---")
    prereqs = system.get_all_prerequisites("CS202")
    print(f"  All courses required before CS202: {sorted(prereqs)}")

    # Task d
    print("\n--- Task d: Valid Course Order (Topological Sort) ---")
    try:
        order = system.topological_sort()
        print(f"  Valid order: {' → '.join(order)}")
    except ValueError as e:
        print(f"  Error: {e}")

    # --- Demonstrate cycle detection with a bad curriculum ---
    print("\n--- Cycle Detection Demo (with circular dependency) ---")
    bad_system = CoursePrerequisiteSystem()
    bad_edges = [("A", "B"), ("B", "C"), ("C", "A")]   # A→B→C→A
    for pre, course in bad_edges:
        bad_system.add_prerequisite(pre, course)
    has_cycle, cycle = bad_system.has_cycle()
    print(f"  Cycle present? {has_cycle}  |  Cycle path: {' → '.join(cycle)}")


if __name__ == "__main__":
    main()
