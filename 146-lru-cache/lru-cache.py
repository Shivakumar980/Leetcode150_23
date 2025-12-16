class Node:
    def __init__(self,key=None, val=None):
        self.key=key
        self.val=val
        self.prev=None
        self.next=None
class LRUCache:

    def __init__(self, capacity: int):
        self.cap= capacity
        self.cache={}

        self.dummyhead= Node()
        self.dummytail= Node()
        self.dummyhead.next= self.dummytail
        self.dummytail.prev= self.dummyhead
        

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node= self.cache[key]
        self.deleteNode(node)
        self.insertAfterHead(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node=self.cache[key]
            node.val=value
            self.deleteNode(node)
            self.insertAfterHead(node)
        else:
            if len(self.cache)==self.cap:
                node= self.dummytail.prev
                self.deleteNode(node)
                del self.cache[node.key]
            node= Node(key,value)
            self.cache[key]= node
            self.insertAfterHead(node)

    def deleteNode(self,node):
        prevNode= node.prev
        nextNode= node.next

        prevNode.next= nextNode
        nextNode.prev= prevNode

    def insertAfterHead(self, node):

        prevNode= self.dummyhead
        nextNode= self.dummyhead.next

        prevNode.next= node
        node.next= nextNode
        nextNode.prev=node
        node.prev= prevNode

            
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)