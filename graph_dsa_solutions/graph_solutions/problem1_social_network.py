"""
Problem 1: Social Network Connection
=====================================
Users are vertices, friendships are undirected edges.
Tasks:
  a) Efficient graph representation
  b) Find all friends of a given user
  c) Check if two users are directly connected
  d) Find degree of separation (shortest path) between two users
"""

from collections import deque, defaultdict


class SocialNetwork:
    def __init__(self):
        # Using adjacency list — best for sparse social graphs (O(V+E) space)
        # Real-world social networks are sparse: avg person has ~150–500 friends
        # vs potentially millions of users, so O(V²) matrix would waste memory.
        self.graph = defaultdict(set)
        self.users = set()

    def add_user(self, user):
        self.users.add(user)
        if user not in self.graph:
            self.graph[user] = set()

    def add_friendship(self, user1, user2):
        """Add undirected edge between two users."""
        self.add_user(user1)
        self.add_user(user2)
        self.graph[user1].add(user2)
        self.graph[user2].add(user1)

    # ------------------------------------------------------------------ #
    # Task b: Find all friends of a given user                            #
    # ------------------------------------------------------------------ #
    def get_friends(self, user):
        """
        Return the set of direct friends of `user`.
        Time Complexity : O(degree(user))  — just return the adjacency set
        Space Complexity: O(degree(user))
        """
        if user not in self.graph:
            return set()
        return set(self.graph[user])

    # ------------------------------------------------------------------ #
    # Task c: Check if two users are directly connected                   #
    # ------------------------------------------------------------------ #
    def are_directly_connected(self, user1, user2):
        """
        Return True if user1 and user2 are direct friends.
        Time Complexity : O(1) average with hash-set adjacency list
        Space Complexity: O(1)
        """
        return user2 in self.graph.get(user1, set())

    # ------------------------------------------------------------------ #
    # Task d: Find shortest path (degree of separation) using BFS         #
    # ------------------------------------------------------------------ #
    def find_degree_of_separation(self, start, end):
        """
        BFS finds the shortest path in an unweighted graph.
        Returns (degree, path) where degree = number of hops.
        Returns (-1, []) if no path exists.

        Time Complexity : O(V + E)
        Space Complexity: O(V)
        """
        if start not in self.users or end not in self.users:
            return -1, []
        if start == end:
            return 0, [start]

        visited = {start}
        # queue holds (current_user, path_so_far)
        queue = deque([(start, [start])])

        while queue:
            current, path = queue.popleft()
            for neighbor in self.graph[current]:
                if neighbor == end:
                    full_path = path + [neighbor]
                    return len(full_path) - 1, full_path
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, path + [neighbor]))

        return -1, []   # no connection found

    def display_network(self):
        print("\n=== Social Network (Adjacency List) ===")
        for user in sorted(self.users):
            friends = sorted(self.graph[user])
            print(f"  {user}: {friends}")


# ------------------------------------------------------------------ #
# Driver / Demo                                                        #
# ------------------------------------------------------------------ #
def main():
    network = SocialNetwork()

    friendships = [
        ("Alice", "Bob"),
        ("Alice", "Charlie"),
        ("Bob", "David"),
        ("Charlie", "Eve"),
        ("David", "Eve"),
    ]

    for u, v in friendships:
        network.add_friendship(u, v)

    network.display_network()

    # Task b
    print("\n--- Task b: Friends of Alice ---")
    friends = network.get_friends("Alice")
    print(f"  Alice's friends: {sorted(friends)}")

    # Task c
    print("\n--- Task c: Direct connection check ---")
    pairs = [("Bob", "Eve"), ("Alice", "Bob"), ("Charlie", "David")]
    for a, b in pairs:
        connected = network.are_directly_connected(a, b)
        print(f"  {a} and {b} directly connected? {connected}")

    # Task d
    print("\n--- Task d: Degree of separation ---")
    queries = [("Alice", "Eve"), ("Alice", "David"), ("Bob", "Charlie")]
    for a, b in queries:
        degree, path = network.find_degree_of_separation(a, b)
        if degree == -1:
            print(f"  {a} → {b}: No connection found")
        else:
            print(f"  {a} → {b}: {degree} degree(s) of separation | Path: {' → '.join(path)}")


if __name__ == "__main__":
    main()
