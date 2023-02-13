class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class CBTInserter:

    def __init__(self, root: TreeNode):
        self.root = root
        self.list = []
        self.list.append(root)
        while len(self.list)>0 and self.list[0].left is not None and self.list[0].right is not None:
            tmpNode = self.list[0]
            self.list.remove(tmpNode)
            self.list.append(tmpNode.left)
            self.list.append(tmpNode.right)

    def insert(self, v: int) -> int:
        tmpNode = self.list[0]
        if tmpNode.left is None:
            tmpNode.left = TreeNode(v)
        else:
            tmpNode.right = TreeNode(v)
            self.list.remove(tmpNode)
            self.list.append(tmpNode.left)
            self.list.append(tmpNode.right)
        return tmpNode.val

    def get_root(self) -> TreeNode:
        return self.root


if __name__ == '__main__':
    a = [2,3,4,]
    print(a)
    a.pop()
    print(a)