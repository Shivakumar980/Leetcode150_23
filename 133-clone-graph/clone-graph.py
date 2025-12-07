"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        visited={}
        if node is None:
            return node
        return self.dfs(node, visited)
    def dfs(self, node, visited):
        if node in visited:
            return visited[node]
        copy=  Node(node.val)
        visited[node]=copy

        for neighbor in node.neighbors:
            copy.neighbors.append(self.dfs(neighbor,visited))
        return copy        